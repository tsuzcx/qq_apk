package com.tencent.aelight.camera.aeeditor.module.edit.multi;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.AEEditorModuleManager;
import com.tencent.aelight.camera.aeeditor.module.edit.multi.data.SpeedFloatUtil;
import com.tencent.aelight.camera.aeeditor.view.videotrack.VideoTrackContainerView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qcircle.tavcut.session.TAVCutVideoSession;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.tav.coremedia.CMTime;
import java.util.ArrayList;
import java.util.List;

class AEEditorMultiCutEditFragment$10
  implements View.OnClickListener
{
  AEEditorMultiCutEditFragment$10(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  public void onClick(View paramView)
  {
    long l = this.a.h.getAllDuration();
    AEBaseDataReporter.a().a(l / 1000L, AEEditorMultiCutEditFragment.f(this.a).size(), SpeedFloatUtil.a(AEEditorMultiCutEditFragment.f(this.a)));
    int i = 0;
    if (l < 2000L)
    {
      QQToast.makeText(this.a.getActivity(), 2064187474, 0).show();
      return;
    }
    this.a.getArguments().putString("editor_filter_id", "");
    this.a.getArguments().putLong("video_edit_clip_start_time", 0L);
    this.a.getArguments().putLong("video_edit_clip_end_time", Math.min(60000000L, AEEditorMultiCutEditFragment.g(this.a).getDuration().getTimeUs()));
    if ((AEEditorMultiCutEditFragment.g(this.a) != null) && (AEEditorMultiCutEditFragment.g(this.a).getMediaModel() != null)) {
      this.a.getArguments().putSerializable("resource_model", AEEditorMultiCutEditFragment.g(this.a).getMediaModel().getMediaResourceModel());
    }
    if (AEEditorMultiCutEditFragment.r(this.a) != null)
    {
      this.a.getArguments().putSerializable("resource_aealbummediabasemodel", AEEditorMultiCutEditFragment.r(this.a));
      i = AEEditorMultiCutEditFragment.r(this.a).size();
    }
    paramView = new Bundle(this.a.getArguments());
    this.a.b().b(this.a.a(), paramView);
    AEReportUtils.a(i, paramView.getLong("video_edit_clip_end_time") - paramView.getLong("video_edit_clip_start_time"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.10
 * JD-Core Version:    0.7.0.1
 */