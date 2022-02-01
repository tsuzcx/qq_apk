import android.widget.TextView;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.player.IPlayer.PlayerListener;
import com.tencent.tav.player.IPlayer.PlayerStatus;
import com.tencent.tavcut.player.MoviePlayer;
import com.tencent.tavcut.session.TAVCutVideoSession;
import dov.com.qq.im.aeeditor.module.controlpanel.VideoControlPanel;
import dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment;

public class bnyq
  implements IPlayer.PlayerListener
{
  public bnyq(AEEditorVideoEditFragment paramAEEditorVideoEditFragment) {}
  
  public void onPositionChanged(CMTime paramCMTime)
  {
    if (this.a.jdField_a_of_type_Long == 0L)
    {
      CMTime localCMTime = this.a.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.getDuration();
      this.a.jdField_a_of_type_Long = (((float)(localCMTime.value * 1000L) / localCMTime.timeScale));
    }
    float f = (float)(paramCMTime.value * 1000L) / paramCMTime.timeScale;
    paramCMTime = bodl.a(f) + "/" + bodl.a(this.a.jdField_a_of_type_Long);
    AEEditorVideoEditFragment.a(this.a).setText(paramCMTime);
    long l = bodl.a(f);
    if (AEEditorVideoEditFragment.a(this.a) != null) {
      bobc.a().a(l, this.a.jdField_a_of_type_Long);
    }
    AEEditorVideoEditFragment.a(this.a).b((int)l, (int)this.a.jdField_a_of_type_Long);
    if ((this.a.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession != null) && (AEEditorVideoEditFragment.a(this.a) != null)) {
      this.a.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession.updateVideoProgress(f);
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
 * Qualified Name:     bnyq
 * JD-Core Version:    0.7.0.1
 */