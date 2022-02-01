package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleContentImmersiveEvent
  extends SimpleBaseEvent
{
  public static final int ENTER = 3;
  public static final int EXIT = 2;
  public static final int TOGGLE = 1;
  private static boolean a;
  private int mState;
  
  public QCircleContentImmersiveEvent(int paramInt)
  {
    this.mState = paramInt;
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      if (!a) {}
      for (;;)
      {
        a = bool;
        return;
        bool = false;
      }
    case 3: 
      a = true;
      return;
    }
    a = false;
  }
  
  public static boolean isImmersive()
  {
    return a;
  }
  
  public static void resetImmersive()
  {
    a = false;
  }
  
  public int getState()
  {
    return this.mState;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleContentImmersiveEvent
 * JD-Core Version:    0.7.0.1
 */