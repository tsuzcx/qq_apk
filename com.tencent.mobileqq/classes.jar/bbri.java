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

class bbri
  implements VideoPlayerCallback
{
  bbri(bbrg parambbrg, VideoPlayParam paramVideoPlayParam) {}
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AIOFileVideoView<FileAssistant>XOXO", 2, "onCapFrame, id:" + paramLong + ", isSuccess:" + paramBoolean + ", w:" + paramInt1 + ", h:" + paramInt2);
    }
    bbrg.a(this.jdField_a_of_type_Bbrg, paramBitmap);
  }
  
  public void onDownloadComplete(long paramLong)
  {
    QLog.i("AIOFileVideoView<FileAssistant>XOXO", 1, "@@@@@@@@@@@ videoView Download Success:" + paramLong);
    AIOFileVideoData localAIOFileVideoData = this.jdField_a_of_type_Bbrg.a();
    if (!localAIOFileVideoData.f) {
      this.jdField_a_of_type_Bbrg.jdField_a_of_type_Bbqd.d(localAIOFileVideoData);
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
    bbrg.a(this.jdField_a_of_type_Bbrg, paramInt1, paramInt3, this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam);
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2)
  {
    bbrg.a(this.jdField_a_of_type_Bbrg, paramLong2);
    int i = (int)(paramLong2 / this.jdField_a_of_type_Bbrg.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getVideoDurationMs() * 10000.0D);
    this.jdField_a_of_type_Bbrg.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.stringForTime(paramLong2));
    this.jdField_a_of_type_Bbrg.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i);
  }
  
  public void onStateChange(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOFileVideoView<FileAssistant>XOXO", 2, "onStateChange , state = " + bbrg.a(this.jdField_a_of_type_Bbrg, paramInt) + ", msgUniseq=" + paramLong);
    }
    switch (paramInt)
    {
    case 7: 
    default: 
      return;
    case 4: 
      Object localObject = this.jdField_a_of_type_Bbrg.a();
      if (localObject == null)
      {
        QLog.w("AIOFileVideoView<FileAssistant>XOXO", 1, "onStateChange , state = " + bbrg.a(this.jdField_a_of_type_Bbrg, paramInt) + ", msgUniseq=" + paramLong + " get videoData is null!");
        return;
      }
      if (((AIOFileVideoData)localObject).f) {
        bbrg.a(this.jdField_a_of_type_Bbrg, 5);
      }
      for (;;)
      {
        this.jdField_a_of_type_Bbrg.updateUI();
        this.jdField_a_of_type_Bbrg.jdField_a_of_type_Bbqd.b(((AIOFileVideoData)localObject).a);
        this.jdField_a_of_type_Bbrg.jdField_a_of_type_Bbqd.a(((AIOFileVideoData)localObject).a);
        if (!this.jdField_a_of_type_Bbrg.jdField_a_of_type_Bbqd.a(this.jdField_a_of_type_Bbrg.jdField_a_of_type_Bbqd.getCurrentPosition())) {
          break;
        }
        this.jdField_a_of_type_Bbrg.jdField_a_of_type_Bbqd.a();
        localObject = this.jdField_a_of_type_Bbrg.jdField_a_of_type_Bbqd.getSelectedItem();
        if ((localObject == null) || (!(((RichMediaBrowserInfo)localObject).baseData instanceof AIOBrowserBaseData)) || (this.jdField_a_of_type_Bbrg.jdField_a_of_type_Bbqd.a() == null) || (this.jdField_a_of_type_Bbrg.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null)) {
          break;
        }
        this.jdField_a_of_type_Bbrg.jdField_a_of_type_Bbqd.a().a(bbpf.a(((AIOBrowserBaseData)((RichMediaBrowserInfo)localObject).baseData).d, this.jdField_a_of_type_Bbrg.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getCurPlayingPos(), this.jdField_a_of_type_Bbrg.jdField_a_of_type_Bbqd.a(), this.jdField_a_of_type_Bbrg.jdField_a_of_type_Bbqd.a));
        return;
        bbrg.a(this.jdField_a_of_type_Bbrg, 1);
      }
    case 8: 
      this.jdField_a_of_type_Bbrg.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.stringForTime(this.jdField_a_of_type_Bbrg.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getVideoDurationMs()));
      this.jdField_a_of_type_Bbrg.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(100);
      bbrg.a(this.jdField_a_of_type_Bbrg, 0);
      this.jdField_a_of_type_Bbrg.updateUI();
      return;
    case 9: 
      bbrg.a(this.jdField_a_of_type_Bbrg);
      return;
    case 6: 
      bbrg.a(this.jdField_a_of_type_Bbrg, 6);
      this.jdField_a_of_type_Bbrg.updateUI();
      return;
    }
    bbrg.a(this.jdField_a_of_type_Bbrg, 3);
    this.jdField_a_of_type_Bbrg.updateUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbri
 * JD-Core Version:    0.7.0.1
 */