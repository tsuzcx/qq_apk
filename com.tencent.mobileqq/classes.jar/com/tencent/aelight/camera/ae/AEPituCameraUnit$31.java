package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.ttpic.openapi.model.VideoMaterial;

class AEPituCameraUnit$31
  implements Runnable
{
  AEPituCameraUnit$31(AEPituCameraUnit paramAEPituCameraUnit, VideoMaterial paramVideoMaterial) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.a.a(131072) != null)) {
      this.this$0.a.a(131072).a(114, this.a);
    }
    if ((this.this$0.a != null) && (this.this$0.a.a(786432) != null)) {
      this.this$0.a.a(786432).a(114, this.a);
    }
    Object localObject2 = AEMaterialManager.b();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = AEMaterialManager.a();
    }
    if (AEPituCameraUnit.a(this.this$0, (AEMaterialMetaData)localObject1))
    {
      ((AEMaterialMetaData)localObject1).c = false;
      this.this$0.a.a(589825, new Object[0]);
      localObject2 = AEBaseDataReporter.a();
      if (((AEMaterialMetaData)localObject1).k == null) {
        localObject1 = "none";
      } else {
        localObject1 = ((AEMaterialMetaData)localObject1).k;
      }
      ((AEBaseDataReporter)localObject2).o((String)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.31
 * JD-Core Version:    0.7.0.1
 */