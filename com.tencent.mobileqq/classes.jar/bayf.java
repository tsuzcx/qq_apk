import android.graphics.Bitmap;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;

class bayf
  implements VideoPlayerCallback
{
  bayf(bayd parambayd, VideoPlayParam paramVideoPlayParam) {}
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AIOFileVideoView<FileAssistant>XOXO", 2, "onCapFrame, id:" + paramLong + ", isSuccess:" + paramBoolean + ", w:" + paramInt1 + ", h:" + paramInt2);
    }
    bayd.a(this.jdField_a_of_type_Bayd, paramBitmap);
  }
  
  public void onDownloadComplete(long paramLong)
  {
    QLog.i("AIOFileVideoView<FileAssistant>XOXO", 1, "@@@@@@@@@@@ videoView Download Success:" + paramLong);
    AIOFileVideoData localAIOFileVideoData = this.jdField_a_of_type_Bayd.a();
    if (!localAIOFileVideoData.f) {
      this.jdField_a_of_type_Bayd.jdField_a_of_type_Baxa.d(localAIOFileVideoData);
    }
  }
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onFirstFrameRendered(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOFileVideoView<FileAssistant>XOXO", 2, "onFirstFrameRendered, id:" + paramLong);
    }
  }
  
  public void onLoopBack(long paramLong1, long paramLong2) {}
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    BrowserLogHelper.getInstance().getGalleryLog().e("AIOFileVideoView<FileAssistant>XOXO", 1, "onPlayError, id = " + paramLong + " ,module = " + paramInt1 + " , errorType = " + paramInt2 + ", errCode = " + paramInt3 + " , exInfo = " + paramString);
    bayd.a(this.jdField_a_of_type_Bayd, paramInt1, paramInt3, this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam);
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2)
  {
    bayd.a(this.jdField_a_of_type_Bayd, paramLong2);
    int i = (int)(paramLong2 / this.jdField_a_of_type_Bayd.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getVideoDurationMs() * 10000.0D);
    this.jdField_a_of_type_Bayd.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(paramLong2));
    this.jdField_a_of_type_Bayd.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i);
  }
  
  public void onStateChange(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOFileVideoView<FileAssistant>XOXO", 2, "onStateChange , state = " + bayd.a(this.jdField_a_of_type_Bayd, paramInt) + ", msgUniseq=" + paramLong);
    }
    switch (paramInt)
    {
    case 7: 
    default: 
      return;
    case 4: 
      Object localObject = this.jdField_a_of_type_Bayd.a();
      if (((AIOFileVideoData)localObject).f) {
        bayd.a(this.jdField_a_of_type_Bayd, 5);
      }
      for (;;)
      {
        this.jdField_a_of_type_Bayd.updateUI();
        if (localObject != null)
        {
          this.jdField_a_of_type_Bayd.jdField_a_of_type_Baxa.b(((AIOFileVideoData)localObject).a);
          this.jdField_a_of_type_Bayd.jdField_a_of_type_Baxa.a(((AIOFileVideoData)localObject).a);
        }
        if (!this.jdField_a_of_type_Bayd.jdField_a_of_type_Baxa.a(this.jdField_a_of_type_Bayd.jdField_a_of_type_Baxa.getCurrentPosition())) {
          break;
        }
        this.jdField_a_of_type_Bayd.jdField_a_of_type_Baxa.a();
        localObject = this.jdField_a_of_type_Bayd.jdField_a_of_type_Baxa.getSelectedItem();
        if ((localObject == null) || (!(((RichMediaBrowserInfo)localObject).baseData instanceof AIOBrowserBaseData)) || (this.jdField_a_of_type_Bayd.jdField_a_of_type_Baxa.a() == null) || (this.jdField_a_of_type_Bayd.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null)) {
          break;
        }
        this.jdField_a_of_type_Bayd.jdField_a_of_type_Baxa.a().a(bawc.a(((AIOBrowserBaseData)((RichMediaBrowserInfo)localObject).baseData).d, this.jdField_a_of_type_Bayd.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getCurPlayingPos(), this.jdField_a_of_type_Bayd.jdField_a_of_type_Baxa.a(), this.jdField_a_of_type_Bayd.jdField_a_of_type_Baxa.a));
        return;
        bayd.a(this.jdField_a_of_type_Bayd, 1);
      }
    case 8: 
      this.jdField_a_of_type_Bayd.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(this.jdField_a_of_type_Bayd.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getVideoDurationMs()));
      this.jdField_a_of_type_Bayd.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(100);
      bayd.a(this.jdField_a_of_type_Bayd, 0);
      this.jdField_a_of_type_Bayd.updateUI();
      return;
    case 9: 
      bayd.a(this.jdField_a_of_type_Bayd);
      return;
    case 6: 
      bayd.a(this.jdField_a_of_type_Bayd, 6);
      this.jdField_a_of_type_Bayd.updateUI();
      return;
    }
    bayd.a(this.jdField_a_of_type_Bayd, 3);
    this.jdField_a_of_type_Bayd.updateUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bayf
 * JD-Core Version:    0.7.0.1
 */