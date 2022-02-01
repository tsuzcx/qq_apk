package com.tencent.aelight.camera.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

@Service(needUin=false, process={"all"})
public abstract interface IPeakJceService
  extends IRuntimeService
{
  public abstract void handleRequest(ToServiceMsg paramToServiceMsg);
  
  public abstract void handleResponse(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg);
  
  public abstract void onCreate(AppRuntime paramAppRuntime);
  
  public abstract void onDestroy();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.api.IPeakJceService
 * JD-Core Version:    0.7.0.1
 */