package com.tencent.aelight.camera.ae.album.logic;

import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.qcircle.tavcut.TAVCut.Callback;
import java.util.List;

class AEPhotoListLogicDefault$1
  implements TAVCut.Callback
{
  AEPhotoListLogicDefault$1(AEPhotoListLogicDefault paramAEPhotoListLogicDefault) {}
  
  public void onDone(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TAVCut init ret code = ");
    localStringBuilder.append(paramInt);
    AEQLog.b("AEPhotoListLogicDefault", localStringBuilder.toString());
    if (paramInt != 0) {
      AEPhotoListLogicDefault.a(this.a).add(new AEPhotoListLogicDefault.InitResult(this.a, -9));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.logic.AEPhotoListLogicDefault.1
 * JD-Core Version:    0.7.0.1
 */