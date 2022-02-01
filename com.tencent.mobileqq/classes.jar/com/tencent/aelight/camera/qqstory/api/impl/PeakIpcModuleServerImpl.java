package com.tencent.aelight.camera.qqstory.api.impl;

import com.tencent.aelight.camera.aioeditor.editipc.PeakIpcModuleServer;
import com.tencent.aelight.camera.qqstory.api.IPeakIpcModuleServer;
import com.tencent.mobileqq.qipc.QIPCModule;

public class PeakIpcModuleServerImpl
  implements IPeakIpcModuleServer
{
  public QIPCModule getPeakIpcModuleServerModule()
  {
    return PeakIpcModuleServer.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.impl.PeakIpcModuleServerImpl
 * JD-Core Version:    0.7.0.1
 */