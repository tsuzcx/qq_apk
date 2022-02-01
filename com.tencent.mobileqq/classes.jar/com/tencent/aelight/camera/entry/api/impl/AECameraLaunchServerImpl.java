package com.tencent.aelight.camera.entry.api.impl;

import com.tencent.aelight.camera.ae.entry.AECameraLaunchServer;
import com.tencent.aelight.camera.entry.api.IAECameraLaunchServer;
import com.tencent.mobileqq.qipc.QIPCModule;

public class AECameraLaunchServerImpl
  implements IAECameraLaunchServer
{
  public QIPCModule getAECameraLaunchServerQIPCModule()
  {
    return AECameraLaunchServer.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.entry.api.impl.AECameraLaunchServerImpl
 * JD-Core Version:    0.7.0.1
 */