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

class bbsd
  implements VideoPlayerCallback
{
  bbsd(bbrz parambbrz, VideoPlayParam paramVideoPlayParam) {}
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AIOVideoView", 0, "onCapFrame, id:" + paramLong + ", isSuccess:" + paramBoolean + ", w:" + paramInt1 + ", h:" + paramInt2);
    }
    bbrz.a(this.jdField_a_of_type_Bbrz, paramBitmap);
  }
  
  public void onDownloadComplete(long paramLong)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onDownloadComplete");
    aklw localaklw = this.jdField_a_of_type_Bbrz.jdField_a_of_type_Bbqi.a(this.jdField_a_of_type_Bbrz.a());
    if (localaklw != null) {
      localaklw.a = false;
    }
    this.jdField_a_of_type_Bbrz.jdField_a_of_type_Bbqi.a(2003, 0L);
  }
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onFirstFrameRendered(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoView", 0, "onFirstFrameRendered, id:" + paramLong);
    }
    bbrz.a(this.jdField_a_of_type_Bbrz, paramLong, this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam);
  }
  
  public void onLoopBack(long paramLong1, long paramLong2) {}
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    BrowserLogHelper.getInstance().getGalleryLog().e("AIOVideoView", 1, "onPlayError, id = " + paramLong + " ,module = " + paramInt1 + " , errorType = " + paramInt2 + ", errCode = " + paramInt3 + " , exInfo = " + paramString);
    bbrz.a(this.jdField_a_of_type_Bbrz, paramInt1, paramInt3, this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam);
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2)
  {
    bbrz.a(this.jdField_a_of_type_Bbrz, paramLong2);
    int i = (int)(paramLong2 / this.jdField_a_of_type_Bbrz.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getVideoDurationMs() * 10000.0D);
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onPlayProgress, id = " + paramLong1 + " , position = " + paramLong2 + " , progress = " + i);
    this.jdField_a_of_type_Bbrz.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.stringForTime(paramLong2));
    this.jdField_a_of_type_Bbrz.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i);
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
          bbrz.a(this.jdField_a_of_type_Bbrz, 5);
          this.jdField_a_of_type_Bbrz.updateUI();
          if (!this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam.mIsMute) {
            bbrz.a(this.jdField_a_of_type_Bbrz);
          }
          localObject = this.jdField_a_of_type_Bbrz.a();
          if (localObject != null)
          {
            this.jdField_a_of_type_Bbrz.jdField_a_of_type_Bbqi.a(((AIOVideoData)localObject).a);
            this.jdField_a_of_type_Bbrz.jdField_a_of_type_Bbqi.a(((AIOVideoData)localObject).a, false);
          }
        } while (!this.jdField_a_of_type_Bbrz.jdField_a_of_type_Bbqi.a(this.jdField_a_of_type_Bbrz.jdField_a_of_type_Bbqi.getCurrentPosition()));
        this.jdField_a_of_type_Bbrz.jdField_a_of_type_Bbqi.a();
        localObject = this.jdField_a_of_type_Bbrz.jdField_a_of_type_Bbqi.getSelectedItem();
      } while ((localObject == null) || (!(((RichMediaBrowserInfo)localObject).baseData instanceof AIOBrowserBaseData)) || (this.jdField_a_of_type_Bbrz.jdField_a_of_type_Bbqi.a() == null) || (this.jdField_a_of_type_Bbrz.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null));
      this.jdField_a_of_type_Bbrz.jdField_a_of_type_Bbqi.a().a(bbpf.a(((AIOBrowserBaseData)((RichMediaBrowserInfo)localObject).baseData).d, this.jdField_a_of_type_Bbrz.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getCurPlayingPos(), this.jdField_a_of_type_Bbrz.jdField_a_of_type_Bbqi.a(), this.jdField_a_of_type_Bbrz.jdField_a_of_type_Bbqi.a));
      return;
    case 8: 
      this.jdField_a_of_type_Bbrz.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.stringForTime(this.jdField_a_of_type_Bbrz.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getVideoDurationMs()));
      this.jdField_a_of_type_Bbrz.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(100);
      bbrz.a(this.jdField_a_of_type_Bbrz, 0);
      this.jdField_a_of_type_Bbrz.updateUI();
      return;
    case 9: 
      bbrz.b(this.jdField_a_of_type_Bbrz);
      return;
    case 6: 
      bbrz.a(this.jdField_a_of_type_Bbrz, 6);
      this.jdField_a_of_type_Bbrz.updateUI();
      return;
    }
    bbrz.a(this.jdField_a_of_type_Bbrz, 3);
    this.jdField_a_of_type_Bbrz.updateUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbsd
 * JD-Core Version:    0.7.0.1
 */