package com.tencent.aelight.camera.ae.camera.ui.bottom;

import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import java.util.List;

class AEBottomListPart$15
  implements Runnable
{
  AEBottomListPart$15(AEBottomListPart paramAEBottomListPart) {}
  
  public void run()
  {
    Object localObject = this.this$0.e.d(this.this$0.k());
    this.this$0.c.a((List)localObject);
    localObject = AEMaterialManager.n();
    if ((localObject != null) && (!((AEMaterialMetaData)localObject).equals(AEMaterialMetaData.l)))
    {
      AEBottomListPart.a(this.this$0, (AEMaterialMetaData)localObject);
      return;
    }
    this.this$0.c(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart.15
 * JD-Core Version:    0.7.0.1
 */