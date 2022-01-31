import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import cooperation.liveroom.LiveRoomGiftCallback;

class bdzo
  implements MediaPlayer.OnCompletionListener
{
  bdzo(bdzn parambdzn) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (bdzn.a(this.a)) {
      this.a.a.start();
    }
    for (;;)
    {
      if (bdzn.a(this.a) != null) {
        bdzn.a(this.a).onCall(7, "");
      }
      return;
      bdzn.a(this.a, false);
      if (bdzn.a(this.a) != null) {
        bdzn.a(this.a).onCompletion(this.a.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdzo
 * JD-Core Version:    0.7.0.1
 */