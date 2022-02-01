package com.tencent.mobileqq.activity.home;

import java.util.ArrayList;
import java.util.List;

public class FrameAddPushNotifier
{
  private static volatile FrameAddPushNotifier a;
  private final List<OnTabFrameAddCallback> b = new ArrayList();
  
  public static FrameAddPushNotifier a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new FrameAddPushNotifier();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(OnTabFrameAddCallback paramOnTabFrameAddCallback)
  {
    if (paramOnTabFrameAddCallback == null) {
      return;
    }
    if (this.b.contains(paramOnTabFrameAddCallback)) {
      return;
    }
    this.b.add(paramOnTabFrameAddCallback);
  }
  
  public List<OnTabFrameAddCallback> b()
  {
    return this.b;
  }
  
  public void b(OnTabFrameAddCallback paramOnTabFrameAddCallback)
  {
    if (paramOnTabFrameAddCallback == null) {
      return;
    }
    if (!this.b.contains(paramOnTabFrameAddCallback)) {
      return;
    }
    this.b.remove(paramOnTabFrameAddCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.FrameAddPushNotifier
 * JD-Core Version:    0.7.0.1
 */