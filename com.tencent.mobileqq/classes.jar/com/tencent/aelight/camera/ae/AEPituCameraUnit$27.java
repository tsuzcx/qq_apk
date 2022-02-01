package com.tencent.aelight.camera.ae;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.log.AEQLog;

class AEPituCameraUnit$27
  implements Observer<Boolean>
{
  AEPituCameraUnit$27(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    String str = this.a.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getTplPanelVisibleLiveData--isShow=");
    localStringBuilder.append(paramBoolean);
    AEQLog.b(str, localStringBuilder.toString());
    AEPituCameraUnit.c(this.a, Boolean.TRUE.equals(paramBoolean));
    AEPituCameraUnit.n(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.27
 * JD-Core Version:    0.7.0.1
 */