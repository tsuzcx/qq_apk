package com.tencent.aelight.camera.aeeditor.module.edit.multi;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.ae.entry.AECameraLauncher;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.util.AEFastClickThrottle;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.module.edit.multi.viewmodel.MvVideoViewModel;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.entry.api.AELaunchParamsBuilder;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class AEEditorMultiCutEditFragment$13
  implements View.OnClickListener
{
  AEEditorMultiCutEditFragment$13(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  public void onClick(View paramView)
  {
    if (AEFastClickThrottle.a(paramView)) {
      return;
    }
    AEBaseDataReporter.a().F();
    AEReportUtils.n();
    int j = AEEditorMultiCutEditFragment.f(this.a).size();
    int i = 0;
    if (j >= 30)
    {
      QQToast.makeText(this.a.getActivity(), this.a.getResources().getString(2064187470, new Object[] { Integer.valueOf(30) }), 0).show();
      return;
    }
    if (AEEditorMultiCutEditFragment.e(this.a).a()) {
      AEEditorMultiCutEditFragment.e(this.a).c();
    }
    paramView = new AELaunchParamsBuilder().from(AECameraEntry.E).canSwitchSelectionMode(false).canMixPickPhotoAndVideo(true);
    if (AEEditorMultiCutEditFragment.f(this.a) != null) {
      i = AEEditorMultiCutEditFragment.f(this.a).size();
    }
    paramView = paramView.initialPickedNum(i).build();
    AECameraLauncher.a(this.a.getActivity(), paramView, 1024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.13
 * JD-Core Version:    0.7.0.1
 */