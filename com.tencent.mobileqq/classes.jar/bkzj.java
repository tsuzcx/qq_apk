import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer.OnInfoListener;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener;

class bkzj
  implements IMediaPlayer.OnInfoListener
{
  bkzj(bkzb parambkzb, ReliableVideoPlayer.OnInfoListener paramOnInfoListener) {}
  
  public boolean onInfo(IMediaPlayer paramIMediaPlayer, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreWidgetReliableVideoPlayer$OnInfoListener != null) {
      return this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreWidgetReliableVideoPlayer$OnInfoListener.onInfo(this.jdField_a_of_type_Bkzb, paramInt1, paramInt2);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkzj
 * JD-Core Version:    0.7.0.1
 */