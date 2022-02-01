package com.tencent.aelight.camera.entry.api;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IAECameraLaunchServer
  extends QRouteApi
{
  public static final String ACTION_MINI_LAUNCH_CAMERA_FOR_MINIAPP = "ACTION_MINI_LAUNCH_CAMERA_FOR_MINIAPP";
  public static final String ACTION_MINI_LAUNCH_CAMERA_FOR_PLAY = "ACTION_MINI_LAUNCH_CAMERA_FOR_PLAY";
  public static final String ACTION_MINI_LAUNCH_CAMERA_FOR_SIGN_IN = "ACTION_MINI_LAUNCH_CAMERA_FOR_SIGN_IN";
  public static final String NAME = "AECameraLaunchServer";
  
  public abstract QIPCModule getAECameraLaunchServerQIPCModule();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.entry.api.IAECameraLaunchServer
 * JD-Core Version:    0.7.0.1
 */