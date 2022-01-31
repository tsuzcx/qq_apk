package com.tencent.mobileqq.activity.richmedia;

import java.lang.ref.WeakReference;

public class ShortVideoCaptureController
{
  private static WeakReference a;
  private static WeakReference b;
  
  public static void a()
  {
    if (b != null) {}
    for (ShortVideoCaptureController.CaptureProcessObserver localCaptureProcessObserver = (ShortVideoCaptureController.CaptureProcessObserver)b.get();; localCaptureProcessObserver = null)
    {
      if (localCaptureProcessObserver != null) {
        localCaptureProcessObserver.g();
      }
      return;
    }
  }
  
  public static void a(int paramInt)
  {
    if (b != null) {}
    for (ShortVideoCaptureController.CaptureProcessObserver localCaptureProcessObserver = (ShortVideoCaptureController.CaptureProcessObserver)b.get();; localCaptureProcessObserver = null)
    {
      if (localCaptureProcessObserver != null) {
        localCaptureProcessObserver.b(paramInt);
      }
      return;
    }
  }
  
  public static void a(ShortVideoCaptureController.CaptureProcessObserver paramCaptureProcessObserver)
  {
    b = new WeakReference(paramCaptureProcessObserver);
  }
  
  public static void a(ShortVideoCaptureController.CaptureTriggerObserver paramCaptureTriggerObserver)
  {
    a = new WeakReference(paramCaptureTriggerObserver);
  }
  
  public static void a(String paramString)
  {
    if (b != null) {}
    for (ShortVideoCaptureController.CaptureProcessObserver localCaptureProcessObserver = (ShortVideoCaptureController.CaptureProcessObserver)b.get();; localCaptureProcessObserver = null)
    {
      if (localCaptureProcessObserver != null) {
        localCaptureProcessObserver.c(paramString);
      }
      return;
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (a != null) {}
    for (ShortVideoCaptureController.CaptureTriggerObserver localCaptureTriggerObserver = (ShortVideoCaptureController.CaptureTriggerObserver)a.get();; localCaptureTriggerObserver = null)
    {
      if (localCaptureTriggerObserver != null) {
        localCaptureTriggerObserver.a(paramString, paramInt);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.ShortVideoCaptureController
 * JD-Core Version:    0.7.0.1
 */