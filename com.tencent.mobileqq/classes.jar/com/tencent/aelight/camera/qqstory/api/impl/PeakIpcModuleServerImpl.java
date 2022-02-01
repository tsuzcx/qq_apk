package com.tencent.aelight.camera.qqstory.api.impl;

import com.tencent.aelight.camera.aioeditor.editipc.PeakIpcModuleServer;
import com.tencent.aelight.camera.qqstory.api.IPeakIpcModuleServer;
import com.tencent.mobileqq.qipc.QIPCModule;

public class PeakIpcModuleServerImpl
  implements IPeakIpcModuleServer
{
  public String ACTION_QCIRCLE_PICKER_COST_REPORT()
  {
    return "action_qcircle_picker_cost_report";
  }
  
  public String ACTION_QCIRCLE_PICKER_EXIT_CANCEL()
  {
    return "action_qcircle_picker_exit_cancel";
  }
  
  public String ACTION_QCIRCLE_PICKER_EXIT_NORMAL()
  {
    return "action_qcircle_picker_exit_normal";
  }
  
  public String ACTION_QCIRCLE_PICKER_READY()
  {
    return "action_qcircle_picker_ready";
  }
  
  public QIPCModule getPeakIpcModuleServerModule()
  {
    return PeakIpcModuleServer.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.impl.PeakIpcModuleServerImpl
 * JD-Core Version:    0.7.0.1
 */