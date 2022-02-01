package com.tencent.aelight.camera.ae;

import android.support.annotation.NonNull;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.log.AEQLog;
import com.tribe.async.reactive.SimpleObserver;

class AEPituCameraUnit$18
  extends SimpleObserver<GenerateContext>
{
  AEPituCameraUnit$18(AEPituCameraUnit paramAEPituCameraUnit, String paramString1, String paramString2) {}
  
  public void a(GenerateContext paramGenerateContext)
  {
    AEQLog.b(this.c.a, "generate observer --- onNext");
    AEPituCameraUnit localAEPituCameraUnit = this.c;
    AEPituCameraUnit.a(localAEPituCameraUnit, localAEPituCameraUnit.s(), this.a, this.b, paramGenerateContext.m);
  }
  
  public void onCancel()
  {
    AEQLog.b(this.c.a, "generate observer --- onCancel");
  }
  
  public void onComplete()
  {
    AEQLog.b(this.c.a, "generate observer --- onComplete");
  }
  
  public void onError(@NonNull Error paramError)
  {
    AEQLog.a(this.c.a, "generate observer --- onError", paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.18
 * JD-Core Version:    0.7.0.1
 */