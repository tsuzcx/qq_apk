import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.player.IPlayer.PlayerListener;
import com.tencent.tav.player.IPlayer.PlayerStatus;
import dov.com.qq.im.aeeditor.module.clip.video.AEEditorMvClipMenu;
import dov.com.qq.im.aeeditor.module.clip.video.AEEditorVideoClipFragment;

public class blmf
  implements IPlayer.PlayerListener
{
  public blmf(AEEditorVideoClipFragment paramAEEditorVideoClipFragment) {}
  
  public void onPositionChanged(CMTime paramCMTime) {}
  
  public void onStatusChanged(IPlayer.PlayerStatus paramPlayerStatus)
  {
    bljn.b(AEEditorVideoClipFragment.c(), "play status changed, current status = " + paramPlayerStatus);
    if (AEEditorVideoClipFragment.a(this.a) != null) {
      AEEditorVideoClipFragment.a(this.a).setPlayStatus(paramPlayerStatus);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blmf
 * JD-Core Version:    0.7.0.1
 */