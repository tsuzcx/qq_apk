package com.tencent.aelight.camera.aeeditor.module.edit.multi;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.util.AEFastClickThrottle;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.view.videotrack.VideoTrackContainerView;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class AEEditorMultiCutEditFragment$14
  implements View.OnClickListener
{
  AEEditorMultiCutEditFragment$14(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  @RequiresApi(api=16)
  public void onClick(View paramView)
  {
    if (AEFastClickThrottle.a(paramView)) {
      return;
    }
    AEBaseDataReporter.a().G();
    AEReportUtils.o();
    QQCustomDialog localQQCustomDialog;
    if (this.a.h != null)
    {
      paramView = this.a.h.getSelectedVideoClip();
      if (paramView == null) {
        return;
      }
      if (AEEditorMultiCutEditFragment.f(this.a).size() == 1)
      {
        QQToast.makeText(this.a.getActivity(), 2064187467, 0).show();
        return;
      }
      FragmentActivity localFragmentActivity = this.a.getActivity();
      localQQCustomDialog = DialogUtil.a(localFragmentActivity, 230);
      localQQCustomDialog.setTitle(localFragmentActivity.getString(2064187466));
      localQQCustomDialog.setMessage(localFragmentActivity.getString(2064187465));
      localQQCustomDialog.setPositiveButton(localFragmentActivity.getString(2064187510), new AEEditorMultiCutEditFragment.14.1(this, paramView));
      localQQCustomDialog.setNegativeButton(localFragmentActivity.getString(2064187459), new AEEditorMultiCutEditFragment.14.2(this));
      if (localQQCustomDialog == null) {}
    }
    try
    {
      if (!localQQCustomDialog.isShowing()) {
        localQQCustomDialog.show();
      }
      return;
    }
    catch (Throwable paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.14
 * JD-Core Version:    0.7.0.1
 */