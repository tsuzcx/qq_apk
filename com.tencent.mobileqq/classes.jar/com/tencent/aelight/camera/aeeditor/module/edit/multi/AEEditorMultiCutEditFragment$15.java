package com.tencent.aelight.camera.aeeditor.module.edit.multi;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.ae.util.AEFastClickThrottle;
import com.tencent.aelight.camera.aeeditor.module.clip.video.VideoSetSpeedDialog;
import com.tencent.aelight.camera.aeeditor.view.videotrack.VideoTrackContainerView;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.qcircle.weseevideo.camera.mvauto.redo.CutModelKt;
import com.tencent.qcircle.weseevideo.camera.mvauto.redo.VideoResourceModelKt;

class AEEditorMultiCutEditFragment$15
  implements View.OnClickListener
{
  AEEditorMultiCutEditFragment$15(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  public void onClick(View paramView)
  {
    if (AEFastClickThrottle.a(paramView)) {
      return;
    }
    if ((AEEditorMultiCutEditFragment.h(this.a) != null) && (AEEditorMultiCutEditFragment.h(this.a).isShowing())) {
      return;
    }
    if (this.a.h == null) {
      return;
    }
    paramView = this.a.h.getSelectedVideoClip();
    if ((paramView != null) && (paramView.getResource() != null) && (paramView.getResource().getType() != 2))
    {
      AEEditorMultiCutEditFragment.i(this.a);
      return;
    }
    AEQLog.a("AEEditorMultiCutEditFragment", "[mIvSpeedBtn.onClick] type==IMAGE_TYPE");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.15
 * JD-Core Version:    0.7.0.1
 */