package com.tencent.aelight.camera.api.impl;

import com.tencent.aelight.camera.ae.perf.AELaunchRecorder;
import com.tencent.aelight.camera.api.IAELaunchRecorder;

public class AELaunchRecorderImpl
  implements IAELaunchRecorder
{
  public void beginSession()
  {
    AELaunchRecorder.a().d();
  }
  
  public void endSession()
  {
    AELaunchRecorder.a().e();
  }
  
  public void milestone(String paramString)
  {
    AELaunchRecorder.a().a(paramString);
  }
  
  public void oldAioDrawFirstFrameDone()
  {
    AELaunchRecorder.a().a();
  }
  
  public void print(boolean paramBoolean)
  {
    AELaunchRecorder.a().a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.api.impl.AELaunchRecorderImpl
 * JD-Core Version:    0.7.0.1
 */