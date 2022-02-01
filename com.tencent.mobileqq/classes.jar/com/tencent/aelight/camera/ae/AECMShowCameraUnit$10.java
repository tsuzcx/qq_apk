package com.tencent.aelight.camera.ae;

import com.tencent.aekit.api.standard.filter.AEFilterManager;

class AECMShowCameraUnit$10
  implements Runnable
{
  AECMShowCameraUnit$10(AECMShowCameraUnit paramAECMShowCameraUnit, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.this$0.I != null)
    {
      AEFilterManager localAEFilterManager = this.this$0.I;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("event.script.");
      localStringBuilder.append(this.a);
      localAEFilterManager.setLightNodePresetData(localStringBuilder.toString(), this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AECMShowCameraUnit.10
 * JD-Core Version:    0.7.0.1
 */