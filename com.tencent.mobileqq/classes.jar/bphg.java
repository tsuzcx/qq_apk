import android.widget.TextView;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.player.IPlayer.PlayerListener;
import com.tencent.tav.player.IPlayer.PlayerStatus;
import com.tencent.tavcut.player.MoviePlayer;
import com.tencent.tavcut.session.TAVCutVideoSession;
import dov.com.qq.im.aeeditor.module.controlpanel.VideoControlPanel;
import dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment;

public class bphg
  implements IPlayer.PlayerListener
{
  public bphg(AEEditorVideoEditFragment paramAEEditorVideoEditFragment) {}
  
  public void onPositionChanged(CMTime paramCMTime)
  {
    if (AEEditorVideoEditFragment.a(this.a) == 0L)
    {
      CMTime localCMTime = AEEditorVideoEditFragment.a(this.a).getDuration();
      AEEditorVideoEditFragment.a(this.a, ((float)(localCMTime.value * 1000L) / localCMTime.timeScale));
    }
    float f = (float)(paramCMTime.value * 1000L) / paramCMTime.timeScale;
    paramCMTime = bpkx.a(f) + "/" + bpkx.a(AEEditorVideoEditFragment.a(this.a));
    AEEditorVideoEditFragment.a(this.a).setText(paramCMTime);
    long l = bpkx.a(f);
    if (AEEditorVideoEditFragment.a(this.a) != null) {
      bpio.a().a(l, AEEditorVideoEditFragment.a(this.a));
    }
    AEEditorVideoEditFragment.a(this.a).b((int)l, (int)AEEditorVideoEditFragment.a(this.a));
    if ((AEEditorVideoEditFragment.a(this.a) != null) && (AEEditorVideoEditFragment.a(this.a) != null)) {
      AEEditorVideoEditFragment.a(this.a).updateVideoProgress(f);
    }
  }
  
  public void onStatusChanged(IPlayer.PlayerStatus paramPlayerStatus)
  {
    if ((paramPlayerStatus == IPlayer.PlayerStatus.PLAYING) || (paramPlayerStatus == IPlayer.PlayerStatus.REPLAY))
    {
      AEEditorVideoEditFragment.a(this.a, true);
      return;
    }
    AEEditorVideoEditFragment.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bphg
 * JD-Core Version:    0.7.0.1
 */