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
      break label20;
    }
    catch (RuntimeException localRuntimeException)
    {
      break label15;
    }
    catch (Exception localException)
    {
      label10:
      label15:
      label20:
      break label10;
    }
    mIsSoLoaded = false;
    return;
    mIsSoLoaded = false;
    return;
    mIsSoLoaded = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.video.effect.utils.NativeLoader
 * JD-Core Version:    0.7.0.1
 */