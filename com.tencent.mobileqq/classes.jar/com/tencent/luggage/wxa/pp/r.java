package com.tencent.luggage.wxa.pp;

import android.content.Context;

abstract class r
  extends z
{
  public r(Context paramContext)
  {
    super(paramContext);
    super.setHorizontallyScrolling(true);
  }
  
  private boolean f()
  {
    return (getBottom() > getTop()) && (getRight() > getLeft());
  }
  
  public boolean b()
  {
    return false;
  }
  
  public final boolean c()
  {
    return false;
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    return false;
  }
  
  public final boolean isLaidOut()
  {
    boolean bool2 = super.isLaidOut();
    boolean bool1 = bool2;
    if (bool2)
    {
      bool1 = bool2;
      if (isFocusable())
      {
        bool1 = bool2;
        if (f()) {}
      }
    }
    try
    {
      StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
      bool1 = bool2;
      if (arrayOfStackTraceElement != null)
      {
        bool1 = bool2;
        if (arrayOfStackTraceElement.length >= 3)
        {
          boolean bool3 = arrayOfStackTraceElement[2].getMethodName().equals("canTakeFocus");
          bool1 = bool2;
          if (bool3) {
            bool1 = false;
          }
        }
      }
      return bool1;
    }
    catch (Throwable localThrowable) {}
    return bool2;
  }
  
  public void setGravity(int paramInt)
  {
    super.setGravity(paramInt & 0xFFFFFFAF & 0xFFFFFFCF | 0x10);
  }
  
  public final void setInputType(int paramInt)
  {
    super.setInputType(paramInt & 0xFFFDFFFF);
  }
  
  public final void setSingleLine(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.r
 * JD-Core Version:    0.7.0.1
 */