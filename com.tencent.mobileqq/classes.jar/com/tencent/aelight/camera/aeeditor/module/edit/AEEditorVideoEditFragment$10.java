package com.tencent.aelight.camera.aeeditor.module.edit;

import android.widget.TextView;
import com.tencent.aelight.camera.aeeditor.module.controlpanel.AEEditorMusicControlPanel;
import com.tencent.aelight.camera.aeeditor.module.music.AEEditorLyricProgressCalculator;
import com.tencent.aelight.camera.aeeditor.util.TimeUtils;
import com.tencent.qcircle.tavcut.player.MoviePlayer;
import com.tencent.qcircle.tavcut.session.TAVCutVideoSession;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.player.IPlayer.PlayerListener;
import com.tencent.tav.player.IPlayer.PlayerStatus;

class AEEditorVideoEditFragment$10
  implements IPlayer.PlayerListener
{
  AEEditorVideoEditFragment$10(AEEditorVideoEditFragment paramAEEditorVideoEditFragment) {}
  
  public void onPositionChanged(CMTime paramCMTime)
  {
    CMTime localCMTime = this.a.D.getDuration();
    this.a.E = (((float)(localCMTime.value * 1000L) / localCMTime.timeScale));
    float f = (float)(paramCMTime.value * 1000L) / paramCMTime.timeScale;
    paramCMTime = new StringBuilder();
    long l1 = f;
    paramCMTime.append(TimeUtils.a(l1));
    paramCMTime.append("/");
    paramCMTime.append(TimeUtils.a(this.a.E));
    paramCMTime = paramCMTime.toString();
    AEEditorVideoEditFragment.l(this.a).setText(paramCMTime);
    long l2 = TimeUtils.b(l1);
    if (this.a.L != null) {
      AEEditorLyricProgressCalculator.a().a(l2, this.a.E);
    }
    AEEditorVideoEditFragment.m(this.a).b((int)l2, (int)this.a.E);
    if ((this.a.B != null) && (this.a.L != null)) {
      this.a.B.updateVideoProgress(l1);
    }
  }
  
  public void onStatusChanged(IPlayer.PlayerStatus paramPlayerStatus)
  {
    if ((paramPlayerStatus != IPlayer.PlayerStatus.PLAYING) && (paramPlayerStatus != IPlayer.PlayerStatus.REPLAY))
    {
      AEEditorVideoEditFragment.a(this.a, false);
      return;
    }
    AEEditorVideoEditFragment.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorVideoEditFragment.10
 * JD-Core Version:    0.7.0.1
 */