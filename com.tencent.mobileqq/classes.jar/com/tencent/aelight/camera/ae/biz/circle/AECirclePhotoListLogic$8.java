package com.tencent.aelight.camera.ae.biz.circle;

import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.qcircle.tavcut.TAVCut.Callback;
import java.util.List;

class AECirclePhotoListLogic$8
  implements TAVCut.Callback
{
  AECirclePhotoListLogic$8(AECirclePhotoListLogic paramAECirclePhotoListLogic) {}
  
  public void onDone(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TAVCut init ret code = ");
    localStringBuilder.append(paramInt);
    AEQLog.b("AECirclePhotoListLogic", localStringBuilder.toString());
    if (paramInt != 0) {
      AECirclePhotoListLogic.a(this.a).add(new AECirclePhotoListLogic.InitResult(this.a, -9));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic.8
 * JD-Core Version:    0.7.0.1
 */