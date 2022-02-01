package com.qq.android.dexposed.callbacks;

import com.qq.android.dexposed.DexposedBridge;

public abstract class XCallback
  implements Comparable<XCallback>
{
  public static final int PRIORITY_DEFAULT = 50;
  public static final int PRIORITY_HIGHEST = 10000;
  public static final int PRIORITY_LOWEST = -10000;
  public final int priority;
  
  public XCallback()
  {
    this.priority = 50;
  }
  
  public XCallback(int paramInt)
  {
    this.priority = paramInt;
  }
  
  public static final void callAll(XCallback.Param paramParam)
  {
    if (paramParam.callbacks == null) {
      throw new IllegalStateException("This object was not created for use with callAll");
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramParam.callbacks.length) {
        return;
      }
      try
      {
        ((XCallback)paramParam.callbacks[i]).call(paramParam);
        i += 1;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          DexposedBridge.log(localThrowable);
        }
      }
    }
  }
  
  protected void call(XCallback.Param paramParam) {}
  
  public int compareTo(XCallback paramXCallback)
  {
    if (this == paramXCallback) {
      return 0;
    }
    if (paramXCallback.priority != this.priority) {
      return paramXCallback.priority - this.priority;
    }
    if (System.identityHashCode(this) < System.identityHashCode(paramXCallback)) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qq.android.dexposed.callbacks.XCallback
 * JD-Core Version:    0.7.0.1
 */