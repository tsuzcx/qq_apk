package com.tencent.aelight.camera.aeeditor.view.classifier;

import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.module.MetaMaterialKt;

class MaterialContentAdapter$2
  implements ApplyMaterialTask.MaterialStatusCallback
{
  MaterialContentAdapter$2(MaterialContentAdapter paramMaterialContentAdapter, MetaMaterial paramMetaMaterial, int paramInt) {}
  
  public void a(@NonNull ApplyMaterialTask.Status paramStatus, int paramInt)
  {
    ApplyMaterialTaskHelper.a("onPreExecute", this.a, String.format("callback: %s-%s", new Object[] { paramStatus, Integer.valueOf(paramInt) }));
    if (paramStatus == ApplyMaterialTask.Status.SUCCEEDED)
    {
      boolean bool = MaterialContentAdapter.b(this.c).b(this.b, this.a);
      ApplyMaterialTaskHelper.a("isApplyMaterialLocal", this.a, String.valueOf(bool));
      if (bool)
      {
        bool = MaterialContentAdapter.b(this.c).c(this.b, this.a);
        ApplyMaterialTaskHelper.a("isMaterialReady", this.a, String.valueOf(bool));
        if ((!bool) && (MetaMaterialKt.k(this.a) != 100))
        {
          if (MetaMaterialKt.k(this.a) < 0)
          {
            MaterialContentAdapter.b(this.c).d(this.b, this.a);
            ApplyMaterialTaskHelper.a("onDownloadMaterial", this.a, "start");
            ApplyMaterialTaskHelper.a(this.a, new MaterialContentAdapter.2.1(this));
            return;
          }
          ApplyMaterialTaskHelper.a("executeApplyMaterialTask", this.a, String.format("run into wrong branch: isMaterialReady=%s, downloadProgress=%s", new Object[] { Boolean.valueOf(MaterialContentAdapter.b(this.c).c(this.b, this.a)), Integer.valueOf(MetaMaterialKt.k(this.a)) }));
          return;
        }
        MaterialContentAdapter.a(this.c, ApplyMaterialTask.Status.SUCCEEDED, this.b, this.a);
        return;
      }
      ApplyMaterialTaskHelper.a("onApplyMaterialOnline", this.a, "start");
      MaterialContentAdapter.b(this.c).a(this.b, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.classifier.MaterialContentAdapter.2
 * JD-Core Version:    0.7.0.1
 */