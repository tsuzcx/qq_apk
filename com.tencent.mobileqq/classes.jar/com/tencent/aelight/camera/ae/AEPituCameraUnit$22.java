package com.tencent.aelight.camera.ae;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.log.AEQLog;

class AEPituCameraUnit$22
  implements Observer<Boolean>
{
  AEPituCameraUnit$22(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    String str = this.a.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCapturingLiveData--isCapturing=");
    localStringBuilder.append(paramBoolean);
    AEQLog.b(str, localStringBuilder.toString());
    com.tencent.aelight.camera.ae.data.AEMaterialManager.a = paramBoolean.booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.22
 * JD-Core Version:    0.7.0.1
 */