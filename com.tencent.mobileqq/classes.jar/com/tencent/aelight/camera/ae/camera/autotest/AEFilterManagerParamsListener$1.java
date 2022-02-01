package com.tencent.aelight.camera.ae.camera.autotest;

import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.HashMap;

class AEFilterManagerParamsListener$1
  implements Runnable
{
  AEFilterManagerParamsListener$1(AEFilterManagerParamsListener paramAEFilterManagerParamsListener, String paramString) {}
  
  public void run()
  {
    AEFilterManagerParamsListener.a(this.this$0).clear();
    Object localObject = AEFilterManagerParamsListener.a(this.this$0);
    String str = this.a;
    ((HashMap)localObject).put(str, VideoMaterial.loadLightAsset(str));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Loaded material:");
    ((StringBuilder)localObject).append(this.a);
    QLog.d("AEFilterManagerParamsListener", 4, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.autotest.AEFilterManagerParamsListener.1
 * JD-Core Version:    0.7.0.1
 */