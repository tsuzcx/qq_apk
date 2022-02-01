package com.android.dx.cf.iface;

import com.android.dx.util.FixedSizeList;

public final class StdMethodList
  extends FixedSizeList
  implements MethodList
{
  public StdMethodList(int paramInt)
  {
    super(paramInt);
  }
  
  public Method get(int paramInt)
  {
    return (Method)get0(paramInt);
  }
  
  public void set(int paramInt, Method paramMethod)
  {
    set0(paramInt, paramMethod);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.iface.StdMethodList
 * JD-Core Version:    0.7.0.1
 */