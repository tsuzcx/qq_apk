package com.tencent.aelight.camera.aioeditor.capture.control;

public class CaptureAsyncControl
{
  public static boolean a = true;
  public static boolean b = true;
  public static boolean c = true;
  public static String d = "{1001,1004,1003,1005,1006,1007,1010}";
  public static boolean e;
  public static boolean f;
  public static String g;
  public CaptureAsyncAutomator h = new CaptureAsyncAutomator(null);
  
  public static boolean a(boolean paramBoolean)
  {
    paramBoolean = c;
    return false;
  }
  
  public void a()
  {
    this.h.onDestroy();
  }
  
  public void a(int paramInt)
  {
    CaptureAsyncAutomator localCaptureAsyncAutomator = this.h;
    localCaptureAsyncAutomator.a(CaptureAsyncStepFactory.a(localCaptureAsyncAutomator, String.valueOf(paramInt)));
  }
  
  public void a(String paramString)
  {
    CaptureAsyncAutomator localCaptureAsyncAutomator = this.h;
    localCaptureAsyncAutomator.a(CaptureAsyncStepFactory.a(localCaptureAsyncAutomator, paramString));
  }
  
  public void a(String paramString, Object[] paramArrayOfObject)
  {
    paramString = CaptureAsyncStepFactory.a(this.h, paramString);
    paramString.mParams = paramArrayOfObject;
    this.h.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.control.CaptureAsyncControl
 * JD-Core Version:    0.7.0.1
 */