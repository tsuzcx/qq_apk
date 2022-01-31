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

public class axwg
  implements VideoPlayerCallback
{
  axwg(axwf paramaxwf) {}
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AIOVideoView", 0, "onCapFrame, id:" + paramLong + ", isSuccess:" + paramBoolean + ", w:" + paramInt1 + ", h:" + paramInt2);
    }
    axwf.a(this.a, paramBitmap);
  }
  
  public void onDownloadComplete(long paramLong)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onDownloadComplete");
    ailz localailz = this.a.jdField_a_of_type_Axup.a(this.a.a());
    if (localailz != null) {
      localailz.jdField_a_of_type_Boolean = false;
    }
    this.a.jdField_a_of_type_Axup.a(2003, 0L);
  }
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onLoopBack(long paramLong1, long paramLong2) {}
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    paramString = null;
    if (paramInt1 == 3)
    {
      ailz localailz = this.a.jdField_a_of_type_Axup.a(this.a.a());
      if ((localailz != null) && (localailz.jdField_a_of_type_ArrayOfJavaLangString != null) && (!bdje.a(localailz.c)))
      {
        String[] arrayOfString = localailz.jdField_a_of_type_ArrayOfJavaLangString;
        int i = arrayOfString.length;
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          String str = arrayOfString[paramInt2];
          if (!bdje.a(str)) {
            bavf.a().a(localailz.c, bavf.a(str), 1005);
          }
          paramInt2 += 1;
        }
        axuz.a().a();
      }
    }
    if (paramInt1 == 1) {
      paramString = this.a.mContext.getString(2131720114);
    }
    if (paramInt3 == 14011001)
    {
      paramString = this.a.mContext.getString(2131719264);
      this.a.jdField_a_of_type_Axup.a(5002, 0L);
    }
    ThreadManager.getUIHandler().post(new AIOVideoView.1.1(this, paramString));
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2)
  {
    axwf.a(this.a, paramLong2);
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
          this.a.jdField_a_of_type_Axup.onLoadFinish(this.a.jdField_a_of_type_Axup.getSelectedIndex(), true);
          this.a.f(true);
          this.a.e(false);
          this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          axwf.a(this.a).setVisibility(8);
          axwf.a(this.a).setVisibility(8);
          axwf.a(this.a, true);
          this.a.jdField_a_of_type_Axup.b(paramLong);
        } while (!this.a.jdField_a_of_type_Axup.a(this.a.jdField_a_of_type_Axup.getCurrentPosition()));
        this.a.jdField_a_of_type_Axup.a();
        localRichMediaBrowserInfo = this.a.jdField_a_of_type_Axup.getSelectedItem();
      } while ((localRichMediaBrowserInfo == null) || (!(localRichMediaBrowserInfo.baseData instanceof AIOBrowserBaseData)) || (this.a.jdField_a_of_type_Axup.a() == null) || (this.a.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null));
      this.a.jdField_a_of_type_Axup.a().a(axts.a(((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData).d, this.a.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getCurPlayingPos(), this.a.jdField_a_of_type_Axup.a(), this.a.jdField_a_of_type_Axup.a));
      return;
    case 8: 
      this.a.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(this.a.jdField_a_of_type_AndroidWidgetSeekBar.getMax());
      return;
    case 9: 
      this.a.jdField_a_of_type_Axup.onLoadFinish(this.a.jdField_a_of_type_Axup.getSelectedIndex(), true);
      this.a.f(true);
      this.a.e(false);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getVideoDurationMs()));
      this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      axwf.a(this.a).setVisibility(8);
      axwf.a(this.a).setVisibility(0);
      this.a.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845634);
      axwf.a(this.a, true);
      axwf.a(this.a);
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
      this.a.jdField_a_of_type_Axup.onLoadFinish(this.a.jdField_a_of_type_Axup.getSelectedIndex(), true);
      this.a.f(true);
      this.a.e(false);
      axwf.a(this.a).setVisibility(8);
      axwf.a(this.a, true);
      return;
      label640:
      this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axwg
 * JD-Core Version:    0.7.0.1
 */