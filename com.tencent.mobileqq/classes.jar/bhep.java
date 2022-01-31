import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import com.tencent.qqmini.sdk.runtime.audiorecorder.LameMp3EncodeThread;

public class bhep
  implements MediaPlayer.OnPreparedListener
{
  public bhep(LameMp3EncodeThread paramLameMp3EncodeThread) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    LameMp3EncodeThread.a(this.a).sendEmptyMessage(101);
    LameMp3EncodeThread.a(this.a).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhep
 * JD-Core Version:    0.7.0.1
 */