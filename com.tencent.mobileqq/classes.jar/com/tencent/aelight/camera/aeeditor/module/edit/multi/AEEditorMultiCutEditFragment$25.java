package com.tencent.aelight.camera.aeeditor.module.edit.multi;

import android.content.res.Resources;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.MutableLiveData;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.module.clip.video.VideoSetSpeedDialog;
import com.tencent.aelight.camera.aeeditor.module.clip.video.VideoSetSpeedDialog.OnSpeedChangeListener;
import com.tencent.aelight.camera.aeeditor.module.edit.multi.action.ActionFactory;
import com.tencent.aelight.camera.aeeditor.module.edit.multi.data.SpeedFloatUtil;
import com.tencent.aelight.camera.aeeditor.module.edit.multi.viewmodel.MvVideoViewModel;
import com.tencent.aelight.camera.aeeditor.view.videotrack.VideoTrackContainerView;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.weishi.module.edit.cut.CutExtKt;
import com.tencent.weseevideo.camera.mvauto.redo.CutModelKt;
import com.tencent.weseevideo.camera.mvauto.redo.VideoResourceModelKt;
import java.util.LinkedList;

class AEEditorMultiCutEditFragment$25
  implements VideoSetSpeedDialog.OnSpeedChangeListener
{
  AEEditorMultiCutEditFragment$25(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  @RequiresApi(api=16)
  public void a(float paramFloat)
  {
    AEBaseDataReporter.a().a(paramFloat, "combine");
    AEReportUtils.m(String.valueOf(paramFloat));
    CutModelKt localCutModelKt = this.a.a.a();
    if (localCutModelKt != null)
    {
      if (localCutModelKt.getResource() == null) {
        return;
      }
      float f = localCutModelKt.getResource().getScaleSpeed();
      if (SpeedFloatUtil.a(f, paramFloat))
      {
        AEQLog.a("AEEditorMultiCutEditFragment", "[onChangeSpeed] currentSpeed==newSpeed");
        return;
      }
      if ((float)localCutModelKt.getResource().getSelectTimeDuration() / paramFloat < 1000.0F)
      {
        AEEditorMultiCutEditFragment.a(this.a).a(f);
        QQToast.a(this.a.getActivity(), this.a.getResources().getString(2064515122, new Object[] { Integer.valueOf(1) }), 0).a();
        AEQLog.a("AEEditorMultiCutEditFragment", "[onChangeSpeed] new duration < Config.MIN_VIDEO_CLIP_DURATION_IN_MS");
        return;
      }
      AEEditorMultiCutEditFragment.a(this.a).a(paramFloat);
      long l = CutExtKt.calculateSpeedSeek(AEEditorMultiCutEditFragment.a(this.a), new LinkedList(), localCutModelKt.getUuid());
      if (l >= 0L) {
        AEEditorMultiCutEditFragment.a(this.a, l);
      }
      AEEditorMultiCutEditFragment.a(this.a).a.postValue(ActionFactory.a(localCutModelKt.getUuid(), paramFloat, AEEditorMultiCutEditFragment.a(this.a), AEEditorMultiCutEditFragment.a(this.a).getMediaModel()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.25
 * JD-Core Version:    0.7.0.1
 */