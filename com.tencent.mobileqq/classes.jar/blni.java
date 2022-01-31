import android.widget.TextView;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.player.IPlayer.PlayerListener;
import com.tencent.tav.player.IPlayer.PlayerStatus;
import com.tencent.tavcut.player.MoviePlayer;
import dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment;

public class blni
  implements IPlayer.PlayerListener
{
  public blni(AEEditorVideoEditFragment paramAEEditorVideoEditFragment) {}
  
  public void onPositionChanged(CMTime paramCMTime)
  {
    if (AEEditorVideoEditFragment.a(this.a) == 0L)
    {
      CMTime localCMTime = AEEditorVideoEditFragment.a(this.a).getDuration();
      AEEditorVideoEditFragment.a(this.a, ((float)(localCMTime.value * 1000L) / localCMTime.timeScale));
    }
    float f = (float)(paramCMTime.value * 1000L) / paramCMTime.timeScale;
    paramCMTime = blpz.a(f) + "/" + blpz.a(AEEditorVideoEditFragment.a(this.a));
    AEEditorVideoEditFragment.a(this.a).setText(paramCMTime);
  }
  
  public void onStatusChanged(IPlayer.PlayerStatus paramPlayerStatus)
  {
    bljn.b(AEEditorVideoEditFragment.e(), "play status changed, current status = " + paramPlayerStatus);
    if (paramPlayerStatus == IPlayer.PlayerStatus.PLAYING)
    {
      AEEditorVideoEditFragment.a(this.a, true);
      return;
    }
    AEEditorVideoEditFragment.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blni
 * JD-Core Version:    0.7.0.1
 */