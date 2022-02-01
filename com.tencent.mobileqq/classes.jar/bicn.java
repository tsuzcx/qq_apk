import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import cooperation.liveroom.LiveRoomGiftCallback;

class bicn
  implements MediaPlayer.OnCompletionListener
{
  bicn(bicm parambicm) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (bicm.a(this.a)) {
      this.a.a.start();
    }
    for (;;)
    {
      if (bicm.a(this.a) != null) {
        bicm.a(this.a).onCall(7, "");
      }
      return;
      bicm.a(this.a, false);
      if (bicm.a(this.a) != null) {
        bicm.a(this.a).onCompletion(this.a.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bicn
 * JD-Core Version:    0.7.0.1
 */