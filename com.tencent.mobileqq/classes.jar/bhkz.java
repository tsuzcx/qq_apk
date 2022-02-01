import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import cooperation.liveroom.LiveRoomGiftCallback;

class bhkz
  implements MediaPlayer.OnCompletionListener
{
  bhkz(bhky parambhky) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (bhky.a(this.a)) {
      this.a.a.start();
    }
    for (;;)
    {
      if (bhky.a(this.a) != null) {
        bhky.a(this.a).onCall(7, "");
      }
      return;
      bhky.a(this.a, false);
      if (bhky.a(this.a) != null) {
        bhky.a(this.a).onCompletion(this.a.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhkz
 * JD-Core Version:    0.7.0.1
 */