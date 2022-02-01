package com.tencent.map.sdk.a;

import android.support.annotation.NonNull;

public final class ow$i$b<T>
  extends ow.i.a<T>
{
  private final Object a = new Object();
  
  public ow$i$b(int paramInt)
  {
    super(paramInt);
  }
  
  public final T a()
  {
    synchronized (this.a)
    {
      Object localObject2 = super.a();
      return localObject2;
    }
  }
  
  public final boolean a(@NonNull T paramT)
  {
    synchronized (this.a)
    {
      boolean bool = super.a(paramT);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ow.i.b
 * JD-Core Version:    0.7.0.1
 */