import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import cooperation.liveroom.LiveRoomGiftCallback;

class baxf
  implements MediaPlayer.OnCompletionListener
{
  baxf(baxe parambaxe) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (baxe.a(this.a)) {
      this.a.a.start();
    }
    for (;;)
    {
      if (baxe.a(this.a) != null) {
        baxe.a(this.a).onCall(7, "");
      }
      return;
      baxe.a(this.a, false);
      if (baxe.a(this.a) != null) {
        baxe.a(this.a).onCompletion(this.a.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     baxf
 * JD-Core Version:    0.7.0.1
 */