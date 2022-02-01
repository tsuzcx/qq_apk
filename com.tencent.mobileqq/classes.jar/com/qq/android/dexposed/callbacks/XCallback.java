package com.qq.android.dexposed.callbacks;

public abstract class XCallback
  implements Comparable<XCallback>
{
  public final int b;
  
  public XCallback()
  {
    this.b = 50;
  }
  
  public XCallback(int paramInt)
  {
    this.b = paramInt;
  }
  
  public int a(XCallback paramXCallback)
  {
    if (this == paramXCallback) {
      return 0;
    }
    int i = paramXCallback.b;
    int j = this.b;
    if (i != j) {
      return i - j;
    }
    if (System.identityHashCode(this) < System.identityHashCode(paramXCallback)) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.android.dexposed.callbacks.XCallback
 * JD-Core Version:    0.7.0.1
 */