import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import cooperation.liveroom.LiveRoomGiftCallback;

class bbzz
  implements MediaPlayer.OnCompletionListener
{
  bbzz(bbzy parambbzy) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (bbzy.a(this.a)) {
      this.a.a.start();
    }
    for (;;)
    {
      if (bbzy.a(this.a) != null) {
        bbzy.a(this.a).onCall(7, "");
      }
      return;
      bbzy.a(this.a, false);
      if (bbzy.a(this.a) != null) {
        bbzy.a(this.a).onCompletion(this.a.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbzz
 * JD-Core Version:    0.7.0.1
 */