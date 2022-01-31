import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import cooperation.liveroom.LiveRoomGiftCallback;

class bedx
  implements MediaPlayer.OnCompletionListener
{
  bedx(bedw parambedw) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (bedw.a(this.a)) {
      this.a.a.start();
    }
    for (;;)
    {
      if (bedw.a(this.a) != null) {
        bedw.a(this.a).onCall(7, "");
      }
      return;
      bedw.a(this.a, false);
      if (bedw.a(this.a) != null) {
        bedw.a(this.a).onCompletion(this.a.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bedx
 * JD-Core Version:    0.7.0.1
 */