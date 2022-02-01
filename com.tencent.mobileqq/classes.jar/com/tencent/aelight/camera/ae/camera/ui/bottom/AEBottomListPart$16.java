package com.tencent.aelight.camera.ae.camera.ui.bottom;

import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.data.AEWatermarkMaterialManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

class AEBottomListPart$16
  implements Runnable
{
  AEBottomListPart$16(AEBottomListPart paramAEBottomListPart, String paramString) {}
  
  public void run()
  {
    Object localObject = AEWatermarkMaterialManager.a().b();
    localObject = AEBottomListPart.a(this.this$0, this.a, (List)localObject);
    if (localObject != null)
    {
      if (((AEMaterialMetaData)localObject).A)
      {
        ThreadManager.getUIHandler().post(new AEBottomListPart.16.1(this, (AEMaterialMetaData)localObject));
        return;
      }
      this.this$0.e.a(this.this$0.e.getApp(), (AEMaterialMetaData)localObject, new AEBottomListPart.16.2(this, (AEMaterialMetaData)localObject));
      return;
    }
    AEQLog.d("AEBottomListPart", "meta data is null =======");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart.16
 * JD-Core Version:    0.7.0.1
 */