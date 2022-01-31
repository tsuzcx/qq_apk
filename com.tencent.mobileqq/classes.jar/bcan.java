import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import cooperation.liveroom.LiveRoomGiftCallback;

class bcan
  implements MediaPlayer.OnCompletionListener
{
  bcan(bcam parambcam) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (bcam.a(this.a)) {
      this.a.a.start();
    }
    for (;;)
    {
      if (bcam.a(this.a) != null) {
        bcam.a(this.a).onCall(7, "");
      }
      return;
      bcam.a(this.a, false);
      if (bcam.a(this.a) != null) {
        bcam.a(this.a).onCompletion(this.a.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bcan
 * JD-Core Version:    0.7.0.1
 */