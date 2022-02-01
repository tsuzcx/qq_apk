package com.tencent.aelight.camera.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IAELaunchRecorder
  extends QRouteApi
{
  public static final String MILESTONE_CLICK = "userClick";
  public static final String MILESTONE_LAUNCHER_BEGIN = "AECameraLauncher---launchAECameraUnit-begin";
  public static final String MILESTONE_LAUNCHER_END = "AECameraLauncher---launchAECameraUnit-end";
  public static final String MILESTONE_START_ACTIVITY = "startActivityForResult";
  
  public abstract void beginSession();
  
  public abstract void endSession();
  
  public abstract void milestone(String paramString);
  
  public abstract void oldAioDrawFirstFrameDone();
  
  public abstract void print(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.api.IAELaunchRecorder
 * JD-Core Version:    0.7.0.1
 */