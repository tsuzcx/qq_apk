package com.tencent.aelight.camera.aioeditor.capture.control;

public class CaptureAsyncControl
{
  public static String a = "{1001,1004,1003,1005,1006,1007,1010}";
  public static boolean a = true;
  public static String b;
  public static boolean b = true;
  public static boolean c = true;
  public static boolean d;
  public static boolean e;
  public CaptureAsyncAutomator a = new CaptureAsyncAutomator(null);
  
  public static boolean a(boolean paramBoolean)
  {
    paramBoolean = c;
    return false;
  }
  
  public void a()
  {
    this.a.onDestroy();
  }
  
  public void a(int paramInt)
  {
    CaptureAsyncAutomator localCaptureAsyncAutomator = this.a;
    localCaptureAsyncAutomator.a(CaptureAsyncStepFactory.a(localCaptureAsyncAutomator, String.valueOf(paramInt)));
  }
  
  public void a(String paramString)
  {
    CaptureAsyncAutomator localCaptureAsyncAutomator = this.a;
    localCaptureAsyncAutomator.a(CaptureAsyncStepFactory.a(localCaptureAsyncAutomator, paramString));
  }
  
  public void a(String paramString, Object[] paramArrayOfObject)
  {
    paramString = CaptureAsyncStepFactory.a(this.a, paramString);
    paramString.mParams = paramArrayOfObject;
    this.a.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.control.CaptureAsyncControl
 * JD-Core Version:    0.7.0.1
 */