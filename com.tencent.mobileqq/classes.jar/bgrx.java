import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import cooperation.liveroom.LiveRoomGiftCallback;

class bgrx
  implements MediaPlayer.OnCompletionListener
{
  bgrx(bgrw parambgrw) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (bgrw.a(this.a)) {
      this.a.a.start();
    }
    for (;;)
    {
      if (bgrw.a(this.a) != null) {
        bgrw.a(this.a).onCall(7, "");
      }
      return;
      bgrw.a(this.a, false);
      if (bgrw.a(this.a) != null) {
        bgrw.a(this.a).onCompletion(this.a.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgrx
 * JD-Core Version:    0.7.0.1
 */