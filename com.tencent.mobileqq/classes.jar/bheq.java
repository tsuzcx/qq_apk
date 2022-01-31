import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Handler;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.audiorecorder.LameMp3EncodeThread;

public class bheq
  implements MediaPlayer.OnCompletionListener
{
  public bheq(LameMp3EncodeThread paramLameMp3EncodeThread) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    QMLog.i(LameMp3EncodeThread.a, "onCompletion");
    LameMp3EncodeThread.a(this.a).sendEmptyMessage(106);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bheq
 * JD-Core Version:    0.7.0.1
 */