import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer.OnBufferingUpdateListener;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener;

class bkzf
  implements IMediaPlayer.OnBufferingUpdateListener
{
  bkzf(bkzb parambkzb, ReliableVideoPlayer.OnBufferingUpdateListener paramOnBufferingUpdateListener) {}
  
  public void onBufferingUpdate(IMediaPlayer paramIMediaPlayer, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreWidgetReliableVideoPlayer$OnBufferingUpdateListener != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreWidgetReliableVideoPlayer$OnBufferingUpdateListener.onBufferingUpdate(this.jdField_a_of_type_Bkzb, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkzf
 * JD-Core Version:    0.7.0.1
 */