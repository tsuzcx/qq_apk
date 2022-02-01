import android.graphics.Bitmap;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCaptureImageListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCaptureImageListener;

class bkvu
  implements TVK_IMediaPlayer.OnCaptureImageListener
{
  bkvu(bkvm parambkvm, AbsVideoPlayer.OnCaptureImageListener paramOnCaptureImageListener) {}
  
  public void onCaptureImageFailed(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAbsVideoPlayer$OnCaptureImageListener.onCaptureImageFailed(this.jdField_a_of_type_Bkvm);
  }
  
  public void onCaptureImageSucceed(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAbsVideoPlayer$OnCaptureImageListener.onCaptureImageSucceed(this.jdField_a_of_type_Bkvm, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkvu
 * JD-Core Version:    0.7.0.1
 */