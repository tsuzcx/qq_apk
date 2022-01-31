import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

class biup
  implements MediaPlayer.OnPreparedListener
{
  biup(biuk parambiuk) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biup
 * JD-Core Version:    0.7.0.1
 */