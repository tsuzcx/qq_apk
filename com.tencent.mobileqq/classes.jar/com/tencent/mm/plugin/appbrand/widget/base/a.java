package com.tencent.mm.plugin.appbrand.widget.base;

import android.view.MotionEvent;
import com.tencent.luggage.wxa.qz.o;

public final class a
{
  public static String a(int paramInt)
  {
    int i;
    int j;
    switch (paramInt)
    {
    case 5: 
    case 6: 
    default: 
      i = (0xFF00 & paramInt) >> 8;
      j = paramInt & 0xFF;
      break;
    case 12: 
      return "ACTION_BUTTON_RELEASE";
    case 11: 
      return "ACTION_BUTTON_PRESS";
    case 10: 
      return "ACTION_HOVER_EXIT";
    case 9: 
      return "ACTION_HOVER_ENTER";
    case 8: 
      return "ACTION_SCROLL";
    case 7: 
      return "ACTION_HOVER_MOVE";
    case 4: 
      return "ACTION_OUTSIDE";
    case 3: 
      return "ACTION_CANCEL";
    case 2: 
      return "ACTION_MOVE";
    case 1: 
      return "ACTION_UP";
    case 0: 
      return "ACTION_DOWN";
    }
    if (j != 5)
    {
      if (j != 6) {
        return Integer.toString(paramInt);
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ACTION_POINTER_UP(");
      localStringBuilder.append(i);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ACTION_POINTER_DOWN(");
    localStringBuilder.append(i);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static String a(MotionEvent paramMotionEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MotionEvent { action=");
    localStringBuilder.append(a(paramMotionEvent.getAction()));
    int j = paramMotionEvent.getPointerCount();
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(", x[");
      localStringBuilder.append(i);
      localStringBuilder.append("]=");
      localStringBuilder.append(paramMotionEvent.getX(i));
      localStringBuilder.append(", y[");
      localStringBuilder.append(i);
      localStringBuilder.append("]=");
      localStringBuilder.append(paramMotionEvent.getY(i));
      i += 1;
    }
    localStringBuilder.append(", downTime=");
    localStringBuilder.append(paramMotionEvent.getDownTime());
    localStringBuilder.append(" }");
    return localStringBuilder.toString();
  }
  
  public static void a(String paramString1, String paramString2, MotionEvent paramMotionEvent)
  {
    if (o.c() >= 1) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(' ');
    localStringBuilder.append("[apptouch] MotionEvent { action=");
    localStringBuilder.append(a(paramMotionEvent.getAction()));
    int j = paramMotionEvent.getPointerCount();
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(", x[");
      localStringBuilder.append(i);
      localStringBuilder.append("]=");
      localStringBuilder.append(paramMotionEvent.getX(i));
      localStringBuilder.append(", y[");
      localStringBuilder.append(i);
      localStringBuilder.append("]=");
      localStringBuilder.append(paramMotionEvent.getY(i));
      i += 1;
    }
    localStringBuilder.append(", downTime=");
    localStringBuilder.append(paramMotionEvent.getDownTime());
    localStringBuilder.append(" }");
    o.f(paramString1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.base.a
 * JD-Core Version:    0.7.0.1
 */