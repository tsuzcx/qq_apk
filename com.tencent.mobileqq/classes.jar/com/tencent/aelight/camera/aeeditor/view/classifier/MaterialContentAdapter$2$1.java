package com.tencent.aelight.camera.aeeditor.view.classifier;

import androidx.annotation.NonNull;
import com.tencent.aelight.camera.aeeditor.module.MetaMaterialKt;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class MaterialContentAdapter$2$1
  implements ApplyMaterialTask.MaterialStatusCallback
{
  MaterialContentAdapter$2$1(MaterialContentAdapter.2 param2) {}
  
  public void a(@NonNull ApplyMaterialTask.Status paramStatus, int paramInt)
  {
    ApplyMaterialTaskHelper.a("onDownloadMaterial", this.a.a, String.format("callback: %s-%s", new Object[] { paramStatus, Integer.valueOf(paramInt) }));
    int i = MaterialContentAdapter.5.a[paramStatus.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        MaterialContentAdapter.b(this.a.c, this.a.b, this.a.a);
        MaterialContentAdapter.a(this.a.c, ApplyMaterialTask.Status.FAILED, this.a.b, this.a.a);
        MaterialContentAdapter.a(this.a.c, this.a.a, "-90000000");
        return;
      }
      MetaMaterialKt.a(this.a.a, 100);
      MaterialContentAdapter.a(this.a.c, ApplyMaterialTask.Status.SUCCEEDED, this.a.b, this.a.a);
      MaterialContentAdapter.a(this.a.c, this.a.a, "0");
      return;
    }
    MetaMaterialKt.a(this.a.a, paramInt);
    ThreadManager.getUIHandler().post(new MaterialContentAdapter.2.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.classifier.MaterialContentAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */