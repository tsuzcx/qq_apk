package com.tencent.aelight.camera.qqstory.api;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IPeakIpcModuleServer
  extends QRouteApi
{
  public static final String NAME = "PeakIpcModuleServer";
  
  public abstract String ACTION_QCIRCLE_PICKER_COST_REPORT();
  
  public abstract String ACTION_QCIRCLE_PICKER_EXIT_CANCEL();
  
  public abstract String ACTION_QCIRCLE_PICKER_EXIT_NORMAL();
  
  public abstract String ACTION_QCIRCLE_PICKER_READY();
  
  public abstract QIPCModule getPeakIpcModuleServerModule();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.IPeakIpcModuleServer
 * JD-Core Version:    0.7.0.1
 */