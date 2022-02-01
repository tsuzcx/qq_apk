package com.tencent.mobileqq.app.automator.step;

import com.tencent.aelight.camera.control.api.IAECameraCategoryMaterialService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.ttpic.baseutils.log.LogUtils;

public class CameraCategoryMaterialStep
  extends AsyncStep
{
  protected int doStep()
  {
    IAECameraCategoryMaterialService localIAECameraCategoryMaterialService = (IAECameraCategoryMaterialService)this.mAutomator.a.getRuntimeService(IAECameraCategoryMaterialService.class, "");
    if (localIAECameraCategoryMaterialService != null) {
      localIAECameraCategoryMaterialService.doStep();
    } else {
      LogUtils.e("QQInitHandler", "[CameraCategoryMaterialStep] service is null....");
    }
    return super.doStep();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CameraCategoryMaterialStep
 * JD-Core Version:    0.7.0.1
 */