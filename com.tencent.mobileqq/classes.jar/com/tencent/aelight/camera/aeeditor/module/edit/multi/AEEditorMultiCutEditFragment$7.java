package com.tencent.aelight.camera.aeeditor.module.edit.multi;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.aeeditor.util.TimeUtils;
import com.tencent.qcircle.tavcut.player.MoviePlayer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.player.IPlayer.PlayerListener;
import com.tencent.tav.player.IPlayer.PlayerStatus;

class AEEditorMultiCutEditFragment$7
  implements IPlayer.PlayerListener
{
  AEEditorMultiCutEditFragment$7(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  public void onPositionChanged(CMTime paramCMTime)
  {
    Object localObject = AEEditorMultiCutEditFragment.m(this.a).getDuration();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(TimeUtils.a(paramCMTime.getTimeUs() / 1000L));
    localStringBuilder.append("/");
    localStringBuilder.append(TimeUtils.a(((CMTime)localObject).getTimeUs() / 1000L));
    localObject = localStringBuilder.toString();
    AEEditorMultiCutEditFragment.n(this.a).setText((CharSequence)localObject);
    AEEditorMultiCutEditFragment.b(this.a, paramCMTime.getTimeUs());
  }
  
  public void onStatusChanged(IPlayer.PlayerStatus paramPlayerStatus)
  {
    if ((paramPlayerStatus != IPlayer.PlayerStatus.PLAYING) && (paramPlayerStatus != IPlayer.PlayerStatus.REPLAY))
    {
      AEEditorMultiCutEditFragment.o(this.a).setSelected(false);
      return;
    }
    AEEditorMultiCutEditFragment.o(this.a).setSelected(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.7
 * JD-Core Version:    0.7.0.1
 */