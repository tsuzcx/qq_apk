package androidx.core.view;

import android.view.MotionEvent;

public final class MotionEventCompat
{
  @Deprecated
  public static final int ACTION_HOVER_ENTER = 9;
  @Deprecated
  public static final int ACTION_HOVER_EXIT = 10;
  @Deprecated
  public static final int ACTION_HOVER_MOVE = 7;
  @Deprecated
  public static final int ACTION_MASK = 255;
  @Deprecated
  public static final int ACTION_POINTER_DOWN = 5;
  @Deprecated
  public static final int ACTION_POINTER_INDEX_MASK = 65280;
  @Deprecated
  public static final int ACTION_POINTER_INDEX_SHIFT = 8;
  @Deprecated
  public static final int ACTION_POINTER_UP = 6;
  @Deprecated
  public static final int ACTION_SCROLL = 8;
  @Deprecated
  public static final int AXIS_BRAKE = 23;
  @Deprecated
  public static final int AXIS_DISTANCE = 24;
  @Deprecated
  public static final int AXIS_GAS = 22;
  @Deprecated
  public static final int AXIS_GENERIC_1 = 32;
  @Deprecated
  public static final int AXIS_GENERIC_10 = 41;
  @Deprecated
  public static final int AXIS_GENERIC_11 = 42;
  @Deprecated
  public static final int AXIS_GENERIC_12 = 43;
  @Deprecated
  public static final int AXIS_GENERIC_13 = 44;
  @Deprecated
  public static final int AXIS_GENERIC_14 = 45;
  @Deprecated
  public static final int AXIS_GENERIC_15 = 46;
  @Deprecated
  public static final int AXIS_GENERIC_16 = 47;
  @Deprecated
  public static final int AXIS_GENERIC_2 = 33;
  @Deprecated
  public static final int AXIS_GENERIC_3 = 34;
  @Deprecated
  public static final int AXIS_GENERIC_4 = 35;
  @Deprecated
  public static final int AXIS_GENERIC_5 = 36;
  @Deprecated
  public static final int AXIS_GENERIC_6 = 37;
  @Deprecated
  public static final int AXIS_GENERIC_7 = 38;
  @Deprecated
  public static final int AXIS_GENERIC_8 = 39;
  @Deprecated
  public static final int AXIS_GENERIC_9 = 40;
  @Deprecated
  public static final int AXIS_HAT_X = 15;
  @Deprecated
  public static final int AXIS_HAT_Y = 16;
  @Deprecated
  public static final int AXIS_HSCROLL = 10;
  @Deprecated
  public static final int AXIS_LTRIGGER = 17;
  @Deprecated
  public static final int AXIS_ORIENTATION = 8;
  @Deprecated
  public static final int AXIS_PRESSURE = 2;
  public static final int AXIS_RELATIVE_X = 27;
  public static final int AXIS_RELATIVE_Y = 28;
  @Deprecated
  public static final int AXIS_RTRIGGER = 18;
  @Deprecated
  public static final int AXIS_RUDDER = 20;
  @Deprecated
  public static final int AXIS_RX = 12;
  @Deprecated
  public static final int AXIS_RY = 13;
  @Deprecated
  public static final int AXIS_RZ = 14;
  public static final int AXIS_SCROLL = 26;
  @Deprecated
  public static final int AXIS_SIZE = 3;
  @Deprecated
  public static final int AXIS_THROTTLE = 19;
  @Deprecated
  public static final int AXIS_TILT = 25;
  @Deprecated
  public static final int AXIS_TOOL_MAJOR = 6;
  @Deprecated
  public static final int AXIS_TOOL_MINOR = 7;
  @Deprecated
  public static final int AXIS_TOUCH_MAJOR = 4;
  @Deprecated
  public static final int AXIS_TOUCH_MINOR = 5;
  @Deprecated
  public static final int AXIS_VSCROLL = 9;
  @Deprecated
  public static final int AXIS_WHEEL = 21;
  @Deprecated
  public static final int AXIS_X = 0;
  @Deprecated
  public static final int AXIS_Y = 1;
  @Deprecated
  public static final int AXIS_Z = 11;
  @Deprecated
  public static final int BUTTON_PRIMARY = 1;
  
  @Deprecated
  public static int findPointerIndex(MotionEvent paramMotionEvent, int paramInt)
  {
    return paramMotionEvent.findPointerIndex(paramInt);
  }
  
  @Deprecated
  public static int getActionIndex(MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getActionIndex();
  }
  
  @Deprecated
  public static int getActionMasked(MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getActionMasked();
  }
  
  @Deprecated
  public static float getAxisValue(MotionEvent paramMotionEvent, int paramInt)
  {
    return paramMotionEvent.getAxisValue(paramInt);
  }
  
  @Deprecated
  public static float getAxisValue(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    return paramMotionEvent.getAxisValue(paramInt1, paramInt2);
  }
  
  @Deprecated
  public static int getButtonState(MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getButtonState();
  }
  
  @Deprecated
  public static int getPointerCount(MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getPointerCount();
  }
  
  @Deprecated
  public static int getPointerId(MotionEvent paramMotionEvent, int paramInt)
  {
    return paramMotionEvent.getPointerId(paramInt);
  }
  
  @Deprecated
  public static int getSource(MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getSource();
  }
  
  @Deprecated
  public static float getX(MotionEvent paramMotionEvent, int paramInt)
  {
    return paramMotionEvent.getX(paramInt);
  }
  
  @Deprecated
  public static float getY(MotionEvent paramMotionEvent, int paramInt)
  {
    return paramMotionEvent.getY(paramInt);
  }
  
  public static boolean isFromSource(MotionEvent paramMotionEvent, int paramInt)
  {
    return (paramMotionEvent.getSource() & paramInt) == paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.view.MotionEventCompat
 * JD-Core Version:    0.7.0.1
 */