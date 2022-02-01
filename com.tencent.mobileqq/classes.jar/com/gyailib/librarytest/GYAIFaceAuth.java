package com.gyailib.librarytest;

public class GYAIFaceAuth
{
  private long nativePtr;
  
  static
  {
    try
    {
      System.loadLibrary("YTCommon");
      System.loadLibrary("gy_test_all");
      return;
    }
    catch (Error localError)
    {
      localError.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public long getNativePtr()
  {
    return this.nativePtr;
  }
  
  public native int processAllJni(CrossTesterConfig paramCrossTesterConfig);
  
  public native int registerFaceLicenseTest(String paramString);
  
  public void setNativePtr(long paramLong)
  {
    this.nativePtr = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.gyailib.librarytest.GYAIFaceAuth
 * JD-Core Version:    0.7.0.1
 */