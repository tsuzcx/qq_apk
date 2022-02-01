import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer.OnErrorListener;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener;

class bkzi
  implements IMediaPlayer.OnErrorListener
{
  bkzi(bkzb parambkzb, ReliableVideoPlayer.OnErrorListener paramOnErrorListener) {}
  
  public boolean onError(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreWidgetReliableVideoPlayer$OnErrorListener != null) {
      return this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreWidgetReliableVideoPlayer$OnErrorListener.onError(this.jdField_a_of_type_Bkzb, paramInt1, paramInt2);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkzi
 * JD-Core Version:    0.7.0.1
 */