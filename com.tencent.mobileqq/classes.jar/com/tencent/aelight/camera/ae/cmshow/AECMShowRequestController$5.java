package com.tencent.aelight.camera.ae.cmshow;

import android.text.TextUtils;
import com.tencent.aelight.camera.cmsshow.api.CmShowDataWrapper;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.apollo.utils.api.IApolloIPCHelper.ApolloRoleInfoListener;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

class AECMShowRequestController$5
  implements IApolloIPCHelper.ApolloRoleInfoListener
{
  AECMShowRequestController$5(AECMShowRequestController paramAECMShowRequestController, HashMap paramHashMap, Map paramMap, String paramString) {}
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[requestCmJoyRoleInfo], roleDir=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", errMsg=");
    localStringBuilder.append(paramString2);
    AEQLog.a("AECMShowRequestController", localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString1))
    {
      if (AECMShowRequestController.c(this.d) != null) {
        ThreadManager.getUIHandler().removeCallbacks(AECMShowRequestController.c(this.d));
      }
      if (AECMShowRequestController.b(this.d) != null)
      {
        AECMShowRequestController.a(this.d, 100);
        AECMShowRequestController.b(this.d).d(AECMShowRequestController.a(this.d));
        paramString2 = new CmShowDataWrapper();
        paramString2.sceneMode = AECMShowRequestController.d(this.d);
        paramString2.namePathMap = this.a;
        paramString2.rolePath = paramString1;
        paramString2.dressidMaps = this.b;
        paramString2.cmJsonString = this.c;
        AECMShowRequestController.b(this.d).a(1, paramString2);
      }
    }
    else
    {
      if (AECMShowRequestController.c(this.d) != null) {
        ThreadManager.getUIHandler().removeCallbacks(AECMShowRequestController.c(this.d));
      }
      if (AECMShowRequestController.b(this.d) != null) {
        AECMShowRequestController.b(this.d).a(2, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.cmshow.AECMShowRequestController.5
 * JD-Core Version:    0.7.0.1
 */