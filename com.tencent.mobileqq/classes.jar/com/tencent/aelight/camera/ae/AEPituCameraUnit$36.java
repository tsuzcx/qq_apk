package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.ttpic.openapi.model.VideoMaterial;

class AEPituCameraUnit$36
  implements Runnable
{
  AEPituCameraUnit$36(AEPituCameraUnit paramAEPituCameraUnit, VideoMaterial paramVideoMaterial) {}
  
  public void run()
  {
    if ((this.this$0.S != null) && (this.this$0.S.b(131072) != null)) {
      this.this$0.S.b(131072).a(114, this.a);
    }
    if ((this.this$0.S != null) && (this.this$0.S.b(786432) != null)) {
      this.this$0.S.b(786432).a(114, this.a);
    }
    Object localObject2 = AEMaterialManager.o();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = AEMaterialManager.n();
    }
    if (AEPituCameraUnit.a(this.this$0, (AEMaterialMetaData)localObject1))
    {
      ((AEMaterialMetaData)localObject1).w = false;
      this.this$0.S.b(589825, new Object[0]);
      localObject2 = AEBaseDataReporter.a();
      if (((AEMaterialMetaData)localObject1).m == null) {
        localObject1 = "none";
      } else {
        localObject1 = ((AEMaterialMetaData)localObject1).m;
      }
      ((AEBaseDataReporter)localObject2).q((String)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.36
 * JD-Core Version:    0.7.0.1
 */