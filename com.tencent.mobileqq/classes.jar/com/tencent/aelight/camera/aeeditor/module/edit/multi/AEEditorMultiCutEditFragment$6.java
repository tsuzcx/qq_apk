package com.tencent.aelight.camera.aeeditor.module.edit.multi;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.aeeditor.view.timebar.scale.ScaleAdapter;
import com.tencent.aelight.camera.aeeditor.view.videotrack.VideoTrackContainerView;
import com.tencent.qcircle.tavcut.session.TAVCutVideoSession;
import com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.VideoThumbProviderManager;
import com.tencent.qcircle.weseevideo.camera.mvauto.redo.CutModelKt;
import com.tencent.qcircle.weseevideo.camera.mvauto.redo.ResourceModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaResourceModel;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jetbrains.annotations.Nullable;

class AEEditorMultiCutEditFragment$6
  implements Observer<ResourceModel>
{
  AEEditorMultiCutEditFragment$6(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  @RequiresApi(api=17)
  public void a(@Nullable ResourceModel paramResourceModel)
  {
    if (paramResourceModel == null) {
      return;
    }
    AEEditorMultiCutEditFragment.b(this.a, false);
    AEEditorMultiCutEditFragment.c(this.a, false);
    if (AEEditorMultiCutEditFragment.j(this.a))
    {
      int i = AEEditorMultiCutEditFragment.a(this.a, paramResourceModel.getData());
      AEEditorMultiCutEditFragment.k(this.a).c(i);
    }
    AEEditorMultiCutEditFragment.a(this.a, paramResourceModel);
    AEEditorMultiCutEditFragment.b(this.a, paramResourceModel);
    AEEditorMultiCutEditFragment.b(this.a, paramResourceModel.getData());
    if ((this.a.g()) && (AEEditorMultiCutEditFragment.f(this.a).size() >= 2)) {
      AEEditorMultiCutEditFragment.l(this.a);
    }
    if (AEEditorMultiCutEditFragment.j(this.a)) {
      AEEditorMultiCutEditFragment.d(this.a, false);
    } else {
      AEEditorMultiCutEditFragment.g(this.a).updateTemplateComposition(true);
    }
    AEEditorMultiCutEditFragment.a(this.a, true);
    paramResourceModel = new LinkedList();
    Object localObject = AEEditorMultiCutEditFragment.f(this.a).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramResourceModel.add(((CutModelKt)((Iterator)localObject).next()).convert());
    }
    localObject = new MediaResourceModel();
    ((MediaResourceModel)localObject).setVideos(paramResourceModel);
    VideoThumbProviderManager.getInstance().reset((MediaResourceModel)localObject, String.valueOf(this.a.getActivity().hashCode()));
    this.a.h.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.6
 * JD-Core Version:    0.7.0.1
 */