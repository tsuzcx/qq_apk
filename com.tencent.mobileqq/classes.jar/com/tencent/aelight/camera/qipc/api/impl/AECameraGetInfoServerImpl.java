package com.tencent.aelight.camera.qipc.api.impl;

import com.tencent.aelight.camera.ae.qipc.AECameraGetInfoServer;
import com.tencent.aelight.camera.qipc.api.IAECameraGetInfoServer;
import com.tencent.mobileqq.qipc.QIPCModule;

public class AECameraGetInfoServerImpl
  implements IAECameraGetInfoServer
{
  public QIPCModule getAECameraGetInfoServerQIPCModule()
  {
    return AECameraGetInfoServer.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.qipc.api.impl.AECameraGetInfoServerImpl
 * JD-Core Version:    0.7.0.1
 */