package com.tencent.aelight.camera.api.impl;

import com.tencent.aelight.camera.ae.perf.AELaunchRecorder;
import com.tencent.aelight.camera.api.IAELaunchRecorder;

public class AELaunchRecorderImpl
  implements IAELaunchRecorder
{
  public void beginSession()
  {
    AELaunchRecorder.d().e();
  }
  
  public void endSession()
  {
    AELaunchRecorder.d().f();
  }
  
  public void milestone(String paramString)
  {
    AELaunchRecorder.d().a(paramString);
  }
  
  public void oldAioDrawFirstFrameDone()
  {
    AELaunchRecorder.d().a();
  }
  
  public void print(boolean paramBoolean)
  {
    AELaunchRecorder.d().a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.api.impl.AELaunchRecorderImpl
 * JD-Core Version:    0.7.0.1
 */