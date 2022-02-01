import android.widget.SeekBar;
import com.tencent.tavcut.player.MoviePlayer.onVideoProgressListener;
import dov.com.qq.im.ae.play.AEVideoPreviewFragment;

public class boxq
  implements MoviePlayer.onVideoProgressListener
{
  public boxq(AEVideoPreviewFragment paramAEVideoPreviewFragment) {}
  
  public void updateVideoProgress(long paramLong)
  {
    if (this.a.a != null) {
      AEVideoPreviewFragment.a(this.a).setProgress((int)paramLong * 1000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boxq
 * JD-Core Version:    0.7.0.1
 */