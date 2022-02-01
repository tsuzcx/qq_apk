import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

final class bikk
  implements MediaPlayer.OnPreparedListener
{
  bikk(biko parambiko) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.start();
    paramMediaPlayer.setLooping(true);
    if (this.a != null) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bikk
 * JD-Core Version:    0.7.0.1
 */