package com.tencent.aelight.camera.aeeditor.module.edit.multi;

import android.animation.Animator;
import android.content.res.Resources;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.MutableLiveData;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.module.edit.multi.action.ActionFactory;
import com.tencent.aelight.camera.aeeditor.module.edit.multi.viewmodel.MvVideoViewModel;
import com.tencent.aelight.camera.aeeditor.view.reorder.ReorderContainerView;
import com.tencent.aelight.camera.aeeditor.view.reorder.ReorderListener;
import com.tencent.aelight.camera.aeeditor.view.reorder.ReorderTransition;
import com.tencent.aelight.camera.aeeditor.view.timeline.ScaleScrollLayout;
import com.tencent.aelight.camera.aeeditor.view.videotrack.VideoTrackContainerView;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.qcircle.tavcut.session.TAVCutVideoSession;
import com.tencent.qcircle.weishi.module.edit.cut.CutExtKt;
import java.util.LinkedList;

class AEEditorMultiCutEditFragment$1
  implements ReorderListener
{
  AEEditorMultiCutEditFragment$1(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  @RequiresApi(api=16)
  public void a(@NonNull String paramString, int paramInt)
  {
    if (AEEditorMultiCutEditFragment.c(this.a) != null) {
      AEEditorMultiCutEditFragment.c(this.a).setVisibility(4);
    }
    if (AEEditorMultiCutEditFragment.d(this.a) != null)
    {
      AEEditorMultiCutEditFragment.d(this.a).setVisibility(0);
      AEEditorMultiCutEditFragment.d(this.a).setHandleView(null);
    }
    if (AEEditorMultiCutEditFragment.a(this.a) != null) {
      AEEditorMultiCutEditFragment.a(this.a).setVisibility(0);
    }
    if (AEEditorMultiCutEditFragment.b(this.a) != null) {
      AEEditorMultiCutEditFragment.b(this.a).setVisibility(0);
    }
    AEEditorMultiCutEditFragment.a(this.a, true);
    if ((AEEditorMultiCutEditFragment.e(this.a) != null) && (!paramString.isEmpty()) && (paramInt != -1))
    {
      long l = CutExtKt.calculateReorderSeek(AEEditorMultiCutEditFragment.f(this.a), new LinkedList(), paramString, paramInt);
      if (l >= 0L) {
        AEEditorMultiCutEditFragment.a(this.a, l);
      }
      AEEditorMultiCutEditFragment.e(this.a).a.postValue(ActionFactory.a(paramString, paramInt, AEEditorMultiCutEditFragment.f(this.a), AEEditorMultiCutEditFragment.g(this.a).getMediaModel()));
      AEBaseDataReporter.a().I();
      AEReportUtils.q();
    }
  }
  
  @RequiresApi(api=19)
  public void a(@NonNull String paramString, @NonNull Point paramPoint)
  {
    AEEditorMultiCutEditFragment.a(this.a).setVisibility(8);
    AEEditorMultiCutEditFragment.b(this.a).setVisibility(8);
    AEEditorMultiCutEditFragment.a(this.a, false);
    int i;
    if (AEEditorMultiCutEditFragment.c(this.a) != null) {
      i = AEEditorMultiCutEditFragment.c(this.a).a(paramString, paramPoint);
    } else {
      i = -1;
    }
    paramString = new StringBuilder();
    paramString.append("dragIndex: ");
    paramString.append(i);
    AEQLog.b("AEEditorMultiCutEditFragment", paramString.toString());
    if (i != -1)
    {
      int j = this.a.getResources().getDimensionPixelSize(2063859753);
      int k = paramPoint.x;
      int m = this.a.getResources().getDimensionPixelSize(2063859777);
      paramString = ReorderTransition.a(this.a.h.getContentView(), i, k - m, j);
      paramString.setDuration(200L);
      AEEditorMultiCutEditFragment.d(this.a).a();
      paramString.addListener(new AEEditorMultiCutEditFragment.1.1(this, i));
      paramString.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.1
 * JD-Core Version:    0.7.0.1
 */