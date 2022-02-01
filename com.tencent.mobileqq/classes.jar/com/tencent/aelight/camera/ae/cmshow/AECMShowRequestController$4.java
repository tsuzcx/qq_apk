package com.tencent.aelight.camera.ae.cmshow;

import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.apollo.utils.api.IApolloIPCHelper.ApolloDressInfoListener;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

class AECMShowRequestController$4
  implements IApolloIPCHelper.ApolloDressInfoListener
{
  AECMShowRequestController$4(AECMShowRequestController paramAECMShowRequestController, HashMap paramHashMap, List paramList, int paramInt, String paramString) {}
  
  public void a(HashMap<Integer, String> paramHashMap, String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[requestCmJoyDressInfo], apolloDressInfo=");
    localStringBuilder.append(paramHashMap);
    localStringBuilder.append(", errMsg=");
    localStringBuilder.append(paramString);
    AEQLog.a("AECMShowRequestController", localStringBuilder.toString());
    if (paramHashMap != null)
    {
      paramHashMap = AECMShowRequestController.a(this.e, this.a, paramHashMap);
      paramString = AECMShowRequestController.a(this.e, this.b);
      AECMShowRequestController.a(this.e, this.c, paramHashMap, this.d, paramString);
      return;
    }
    if (AECMShowRequestController.c(this.e) != null) {
      ThreadManager.getUIHandler().removeCallbacks(AECMShowRequestController.c(this.e));
    }
    if (AECMShowRequestController.b(this.e) != null) {
      AECMShowRequestController.b(this.e).a(2, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.cmshow.AECMShowRequestController.4
 * JD-Core Version:    0.7.0.1
 */