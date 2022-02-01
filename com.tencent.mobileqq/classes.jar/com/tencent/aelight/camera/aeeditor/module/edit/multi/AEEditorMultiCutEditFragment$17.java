package com.tencent.aelight.camera.aeeditor.module.edit.multi;

import android.widget.ImageView;
import com.tencent.aelight.camera.aeeditor.module.edit.multi.viewmodel.MvVideoViewModel;
import com.tencent.aelight.camera.aeeditor.view.timebar.ScaleView.OnBarMoveListener;
import com.tencent.aelight.camera.aeeditor.view.timebar.scale.ScaleAdapter;
import com.tencent.aelight.camera.aeeditor.view.videotrack.VideoTrackContainerView;
import com.tencent.qcircle.tavcut.player.MoviePlayer;
import com.tencent.tav.coremedia.CMTime;

class AEEditorMultiCutEditFragment$17
  implements ScaleView.OnBarMoveListener
{
  AEEditorMultiCutEditFragment$17(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  public void a()
  {
    if ((AEEditorMultiCutEditFragment.e(this.a) != null) && (AEEditorMultiCutEditFragment.e(this.a).a())) {
      AEEditorMultiCutEditFragment.e(this.a).c();
    }
    this.a.h.h();
  }
  
  public void a(int paramInt)
  {
    long l = AEEditorMultiCutEditFragment.k(this.a).b(paramInt);
    if (AEEditorMultiCutEditFragment.e(this.a).a()) {
      AEEditorMultiCutEditFragment.e(this.a).c();
    }
    this.a.h.a(paramInt, 0);
    AEEditorMultiCutEditFragment.c(this.a, l);
  }
  
  public void b(int paramInt)
  {
    this.a.h.a(paramInt, 0);
    this.a.h.setScrollByPassive(false);
    paramInt = (int)(this.a.h.getLengthPerMs() * (float)(AEEditorMultiCutEditFragment.m(this.a).getPosition().getTimeUs() / 1000L));
    if (this.a.h.getWidth() / 2 - paramInt >= AEEditorMultiCutEditFragment.s(this.a))
    {
      AEEditorMultiCutEditFragment.t(this.a).setVisibility(0);
      return;
    }
    AEEditorMultiCutEditFragment.t(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.17
 * JD-Core Version:    0.7.0.1
 */