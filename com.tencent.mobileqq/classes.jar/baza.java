import android.graphics.Bitmap;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;

class baza
  implements VideoPlayerCallback
{
  baza(bayw parambayw, VideoPlayParam paramVideoPlayParam) {}
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AIOVideoView", 0, "onCapFrame, id:" + paramLong + ", isSuccess:" + paramBoolean + ", w:" + paramInt1 + ", h:" + paramInt2);
    }
    bayw.a(this.jdField_a_of_type_Bayw, paramBitmap);
  }
  
  public void onDownloadComplete(long paramLong)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onDownloadComplete");
    akhh localakhh = this.jdField_a_of_type_Bayw.jdField_a_of_type_Baxf.a(this.jdField_a_of_type_Bayw.a());
    if (localakhh != null) {
      localakhh.a = false;
    }
    this.jdField_a_of_type_Bayw.jdField_a_of_type_Baxf.a(2003, 0L);
  }
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onFirstFrameRendered(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoView", 0, "onFirstFrameRendered, id:" + paramLong);
    }
    bayw.a(this.jdField_a_of_type_Bayw, paramLong, this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam);
  }
  
  public void onLoopBack(long paramLong1, long paramLong2) {}
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    BrowserLogHelper.getInstance().getGalleryLog().e("AIOVideoView", 1, "onPlayError, id = " + paramLong + " ,module = " + paramInt1 + " , errorType = " + paramInt2 + ", errCode = " + paramInt3 + " , exInfo = " + paramString);
    bayw.a(this.jdField_a_of_type_Bayw, paramInt1, paramInt3, this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam);
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2)
  {
    bayw.a(this.jdField_a_of_type_Bayw, paramLong2);
    int i = (int)(paramLong2 / this.jdField_a_of_type_Bayw.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getVideoDurationMs() * 10000.0D);
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onPlayProgress, id = " + paramLong1 + " , position = " + paramLong2 + " , progress = " + i);
    this.jdField_a_of_type_Bayw.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(paramLong2));
    this.jdField_a_of_type_Bayw.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i);
  }
  
  public void onStateChange(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoView", 0, "onStateChange , state = " + paramInt + ", msgUniseq=" + paramLong);
    }
    switch (paramInt)
    {
    case 7: 
    default: 
    case 4: 
      Object localObject;
      do
      {
        do
        {
          return;
          bayw.a(this.jdField_a_of_type_Bayw, 5);
          this.jdField_a_of_type_Bayw.updateUI();
          if (!this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam.mIsMute) {
            bayw.a(this.jdField_a_of_type_Bayw);
          }
          localObject = this.jdField_a_of_type_Bayw.a();
          if (localObject != null)
          {
            this.jdField_a_of_type_Bayw.jdField_a_of_type_Baxf.a(((AIOVideoData)localObject).a);
            this.jdField_a_of_type_Bayw.jdField_a_of_type_Baxf.a(((AIOVideoData)localObject).a, false);
          }
        } while (!this.jdField_a_of_type_Bayw.jdField_a_of_type_Baxf.a(this.jdField_a_of_type_Bayw.jdField_a_of_type_Baxf.getCurrentPosition()));
        this.jdField_a_of_type_Bayw.jdField_a_of_type_Baxf.a();
        localObject = this.jdField_a_of_type_Bayw.jdField_a_of_type_Baxf.getSelectedItem();
      } while ((localObject == null) || (!(((RichMediaBrowserInfo)localObject).baseData instanceof AIOBrowserBaseData)) || (this.jdField_a_of_type_Bayw.jdField_a_of_type_Baxf.a() == null) || (this.jdField_a_of_type_Bayw.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null));
      this.jdField_a_of_type_Bayw.jdField_a_of_type_Baxf.a().a(bawc.a(((AIOBrowserBaseData)((RichMediaBrowserInfo)localObject).baseData).d, this.jdField_a_of_type_Bayw.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getCurPlayingPos(), this.jdField_a_of_type_Bayw.jdField_a_of_type_Baxf.a(), this.jdField_a_of_type_Bayw.jdField_a_of_type_Baxf.a));
      return;
    case 8: 
      this.jdField_a_of_type_Bayw.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(this.jdField_a_of_type_Bayw.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getVideoDurationMs()));
      this.jdField_a_of_type_Bayw.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(100);
      bayw.a(this.jdField_a_of_type_Bayw, 0);
      this.jdField_a_of_type_Bayw.updateUI();
      return;
    case 9: 
      bayw.b(this.jdField_a_of_type_Bayw);
      return;
    case 6: 
      bayw.a(this.jdField_a_of_type_Bayw, 6);
      this.jdField_a_of_type_Bayw.updateUI();
      return;
    }
    bayw.a(this.jdField_a_of_type_Bayw, 3);
    this.jdField_a_of_type_Bayw.updateUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baza
 * JD-Core Version:    0.7.0.1
 */