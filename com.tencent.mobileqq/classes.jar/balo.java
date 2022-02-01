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

class balo
  implements VideoPlayerCallback
{
  balo(balk parambalk, VideoPlayParam paramVideoPlayParam) {}
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AIOVideoView", 0, "onCapFrame, id:" + paramLong + ", isSuccess:" + paramBoolean + ", w:" + paramInt1 + ", h:" + paramInt2);
    }
    balk.a(this.jdField_a_of_type_Balk, paramBitmap);
  }
  
  public void onDownloadComplete(long paramLong)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onDownloadComplete");
    ajqi localajqi = this.jdField_a_of_type_Balk.jdField_a_of_type_Bajt.a(this.jdField_a_of_type_Balk.a());
    if (localajqi != null) {
      localajqi.a = false;
    }
    this.jdField_a_of_type_Balk.jdField_a_of_type_Bajt.a(2003, 0L);
  }
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onFirstFrameRendered(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoView", 0, "onFirstFrameRendered, id:" + paramLong);
    }
    balk.a(this.jdField_a_of_type_Balk, paramLong, this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam);
  }
  
  public void onLoopBack(long paramLong1, long paramLong2) {}
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    BrowserLogHelper.getInstance().getGalleryLog().e("AIOVideoView", 1, "onPlayError, id = " + paramLong + " ,module = " + paramInt1 + " , errorType = " + paramInt2 + ", errCode = " + paramInt3 + " , exInfo = " + paramString);
    balk.a(this.jdField_a_of_type_Balk, paramInt1, paramInt3, this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam);
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2)
  {
    balk.a(this.jdField_a_of_type_Balk, paramLong2);
    int i = (int)(paramLong2 / this.jdField_a_of_type_Balk.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getVideoDurationMs() * 10000.0D);
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onPlayProgress, id = " + paramLong1 + " , position = " + paramLong2 + " , progress = " + i);
    this.jdField_a_of_type_Balk.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.stringForTime(paramLong2));
    this.jdField_a_of_type_Balk.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i);
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
          balk.a(this.jdField_a_of_type_Balk, 5);
          this.jdField_a_of_type_Balk.updateUI();
          if (!this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam.mIsMute) {
            balk.a(this.jdField_a_of_type_Balk);
          }
          localObject = this.jdField_a_of_type_Balk.a();
          if (localObject != null)
          {
            this.jdField_a_of_type_Balk.jdField_a_of_type_Bajt.a(((AIOVideoData)localObject).a);
            this.jdField_a_of_type_Balk.jdField_a_of_type_Bajt.a(((AIOVideoData)localObject).a, false);
          }
        } while (!this.jdField_a_of_type_Balk.jdField_a_of_type_Bajt.a(this.jdField_a_of_type_Balk.jdField_a_of_type_Bajt.getCurrentPosition()));
        this.jdField_a_of_type_Balk.jdField_a_of_type_Bajt.a();
        localObject = this.jdField_a_of_type_Balk.jdField_a_of_type_Bajt.getSelectedItem();
      } while ((localObject == null) || (!(((RichMediaBrowserInfo)localObject).baseData instanceof AIOBrowserBaseData)) || (this.jdField_a_of_type_Balk.jdField_a_of_type_Bajt.a() == null) || (this.jdField_a_of_type_Balk.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null));
      this.jdField_a_of_type_Balk.jdField_a_of_type_Bajt.a().a(baiq.a(((AIOBrowserBaseData)((RichMediaBrowserInfo)localObject).baseData).d, this.jdField_a_of_type_Balk.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getCurPlayingPos(), this.jdField_a_of_type_Balk.jdField_a_of_type_Bajt.a(), this.jdField_a_of_type_Balk.jdField_a_of_type_Bajt.a));
      return;
    case 8: 
      this.jdField_a_of_type_Balk.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.stringForTime(this.jdField_a_of_type_Balk.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getVideoDurationMs()));
      this.jdField_a_of_type_Balk.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(100);
      balk.a(this.jdField_a_of_type_Balk, 0);
      this.jdField_a_of_type_Balk.updateUI();
      return;
    case 9: 
      balk.b(this.jdField_a_of_type_Balk);
      return;
    case 6: 
      balk.a(this.jdField_a_of_type_Balk, 6);
      this.jdField_a_of_type_Balk.updateUI();
      return;
    }
    balk.a(this.jdField_a_of_type_Balk, 3);
    this.jdField_a_of_type_Balk.updateUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     balo
 * JD-Core Version:    0.7.0.1
 */