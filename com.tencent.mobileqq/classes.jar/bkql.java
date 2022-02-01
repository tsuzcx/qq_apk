import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer.OnSeekCompleteListener;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener;

class bkql
  implements IMediaPlayer.OnSeekCompleteListener
{
  bkql(bkqg parambkqg, ReliableVideoPlayer.OnSeekCompleteListener paramOnSeekCompleteListener) {}
  
  public void onSeekComplete(IMediaPlayer paramIMediaPlayer)
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreWidgetReliableVideoPlayer$OnSeekCompleteListener != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreWidgetReliableVideoPlayer$OnSeekCompleteListener.onSeekComplete(this.jdField_a_of_type_Bkqg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkql
 * JD-Core Version:    0.7.0.1
 */