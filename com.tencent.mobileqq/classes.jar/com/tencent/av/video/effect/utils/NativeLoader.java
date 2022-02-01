package com.tencent.av.video.effect.utils;

public class NativeLoader
{
  public static boolean mIsSoLoaded;
  
  public static void loadSo()
  {
    try
    {
      System.loadLibrary("qav_video_effect");
      mIsSoLoaded = true;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      mIsSoLoaded = false;
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      mIsSoLoaded = false;
      return;
    }
    catch (Exception localException)
    {
      mIsSoLoaded = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.video.effect.utils.NativeLoader
 * JD-Core Version:    0.7.0.1
 */