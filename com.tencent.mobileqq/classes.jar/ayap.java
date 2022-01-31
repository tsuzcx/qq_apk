import android.app.Activity;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.view.AIOVideoView.1.1;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import mqq.os.MqqHandler;

public class ayap
  implements VideoPlayerCallback
{
  ayap(ayao paramayao) {}
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AIOVideoView", 0, "onCapFrame, id:" + paramLong + ", isSuccess:" + paramBoolean + ", w:" + paramInt1 + ", h:" + paramInt2);
    }
    ayao.a(this.a, paramBitmap);
  }
  
  public void onDownloadComplete(long paramLong)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onDownloadComplete");
    aiqo localaiqo = this.a.jdField_a_of_type_Axyy.a(this.a.a());
    if (localaiqo != null) {
      localaiqo.jdField_a_of_type_Boolean = false;
    }
    this.a.jdField_a_of_type_Axyy.a(2003, 0L);
  }
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onLoopBack(long paramLong1, long paramLong2) {}
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    paramString = null;
    if (paramInt1 == 3)
    {
      aiqo localaiqo = this.a.jdField_a_of_type_Axyy.a(this.a.a());
      if ((localaiqo != null) && (localaiqo.jdField_a_of_type_ArrayOfJavaLangString != null) && (!bdnn.a(localaiqo.c)))
      {
        String[] arrayOfString = localaiqo.jdField_a_of_type_ArrayOfJavaLangString;
        int i = arrayOfString.length;
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          String str = arrayOfString[paramInt2];
          if (!bdnn.a(str)) {
            bazo.a().a(localaiqo.c, bazo.a(str), 1005);
          }
          paramInt2 += 1;
        }
        axzi.a().a();
      }
    }
    if (paramInt1 == 1) {
      paramString = this.a.mContext.getString(2131720126);
    }
    if (paramInt3 == 14011001)
    {
      paramString = this.a.mContext.getString(2131719276);
      this.a.jdField_a_of_type_Axyy.a(5002, 0L);
    }
    ThreadManager.getUIHandler().post(new AIOVideoView.1.1(this, paramString));
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2)
  {
    ayao.a(this.a, paramLong2);
    int i = (int)(paramLong2 / this.a.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getVideoDurationMs() * 10000.0D);
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onPlayProgress, id = " + paramLong1 + " , position = " + paramLong2 + " , progress = " + i);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(paramLong2));
    this.a.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i);
  }
  
  public void onStateChange(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoView", 0, "onStateChange , state = " + paramInt + ", msgUniseq=" + paramLong);
    }
    switch (paramInt)
    {
    case 6: 
    case 7: 
    default: 
    case 4: 
      RichMediaBrowserInfo localRichMediaBrowserInfo;
      do
      {
        do
        {
          return;
          if (this.a.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null)
          {
            long l = this.a.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getVideoDurationMs();
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "videoDuration = " + l);
            this.a.jdField_b_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(l));
            this.a.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(0L));
          }
          this.a.jdField_a_of_type_Axyy.onLoadFinish(this.a.jdField_a_of_type_Axyy.getSelectedIndex(), true);
          this.a.f(true);
          this.a.e(false);
          this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          ayao.a(this.a).setVisibility(8);
          ayao.a(this.a).setVisibility(8);
          ayao.a(this.a, true);
          this.a.jdField_a_of_type_Axyy.b(paramLong);
        } while (!this.a.jdField_a_of_type_Axyy.a(this.a.jdField_a_of_type_Axyy.getCurrentPosition()));
        this.a.jdField_a_of_type_Axyy.a();
        localRichMediaBrowserInfo = this.a.jdField_a_of_type_Axyy.getSelectedItem();
      } while ((localRichMediaBrowserInfo == null) || (!(localRichMediaBrowserInfo.baseData instanceof AIOBrowserBaseData)) || (this.a.jdField_a_of_type_Axyy.a() == null) || (this.a.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null));
      this.a.jdField_a_of_type_Axyy.a().a(axyb.a(((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData).d, this.a.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getCurPlayingPos(), this.a.jdField_a_of_type_Axyy.a(), this.a.jdField_a_of_type_Axyy.a));
      return;
    case 8: 
      this.a.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(this.a.jdField_a_of_type_AndroidWidgetSeekBar.getMax());
      return;
    case 9: 
      this.a.jdField_a_of_type_Axyy.onLoadFinish(this.a.jdField_a_of_type_Axyy.getSelectedIndex(), true);
      this.a.f(true);
      this.a.e(false);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getVideoDurationMs()));
      this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      ayao.a(this.a).setVisibility(8);
      ayao.a(this.a).setVisibility(0);
      this.a.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845706);
      ayao.a(this.a, true);
      ayao.a(this.a);
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null)
    {
      if (!this.a.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.isPlaying()) {
        break label640;
      }
      this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Axyy.onLoadFinish(this.a.jdField_a_of_type_Axyy.getSelectedIndex(), true);
      this.a.f(true);
      this.a.e(false);
      ayao.a(this.a).setVisibility(8);
      ayao.a(this.a, true);
      return;
      label640:
      this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayap
 * JD-Core Version:    0.7.0.1
 */