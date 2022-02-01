package com.tencent.aelight.camera.api.impl;

import com.tencent.aelight.camera.aebase.PeakJceService;
import com.tencent.aelight.camera.api.IPeakJceService;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.AppRuntime;

public class PeakJceServiceImpl
  implements IPeakJceService
{
  private static final String TAG = "PeakJceImpl";
  PeakJceService mPeakJceService;
  
  public void handleRequest(ToServiceMsg paramToServiceMsg)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("impl handleRequest");
    ((StringBuilder)localObject).append(this.mPeakJceService);
    AEQLog.a("PeakJceImpl", ((StringBuilder)localObject).toString());
    localObject = this.mPeakJceService;
    if (localObject == null) {
      return;
    }
    ((PeakJceService)localObject).a(paramToServiceMsg);
  }
  
  public void handleResponse(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("impl handleResponse");
    ((StringBuilder)localObject).append(this.mPeakJceService);
    AEQLog.a("PeakJceImpl", ((StringBuilder)localObject).toString());
    localObject = this.mPeakJceService;
    if (localObject == null) {
      return;
    }
    ((PeakJceService)localObject).a(paramBoolean, paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    AEQLog.a("PeakJceImpl", "impl onCreate");
    try
    {
      if ((paramAppRuntime instanceof PeakAppInterface))
      {
        paramAppRuntime = (PeakAppInterface)paramAppRuntime;
        this.mPeakJceService = new PeakJceService(paramAppRuntime);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onCreate] init error, not in QQAppInterface! appRuntime = ");
      localStringBuilder.append(paramAppRuntime);
      AEQLog.d("PeakJceImpl", localStringBuilder.toString());
      return;
    }
    catch (Throwable paramAppRuntime)
    {
      AEQLog.a("PeakJceImpl", "[onCreate] init error!", paramAppRuntime);
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.api.impl.PeakJceServiceImpl
 * JD-Core Version:    0.7.0.1
 */