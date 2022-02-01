package com.tencent.map.sdk.a;

import android.support.annotation.NonNull;

public class ow$i$a<T>
  implements ow.f<T>
{
  private final Object[] a;
  private int b;
  
  public ow$i$a(int paramInt)
  {
    if (paramInt > 0)
    {
      this.a = new Object[paramInt];
      return;
    }
    throw new IllegalArgumentException("The max pool size must be > 0");
  }
  
  public T a()
  {
    int i = this.b;
    if (i > 0)
    {
      int j = i - 1;
      Object[] arrayOfObject = this.a;
      Object localObject = arrayOfObject[j];
      arrayOfObject[j] = null;
      this.b = (i - 1);
      return localObject;
    }
    return null;
  }
  
  public boolean a(@NonNull T paramT)
  {
    int i = 0;
    while (i < this.b)
    {
      if (this.a[i] == paramT)
      {
        i = 1;
        break label34;
      }
      i += 1;
    }
    i = 0;
    label34:
    if (i == 0)
    {
      i = this.b;
      Object[] arrayOfObject = this.a;
      if (i < arrayOfObject.length)
      {
        arrayOfObject[i] = paramT;
        this.b = (i + 1);
        return true;
      }
      return false;
    }
    paramT = new IllegalStateException("Already in the pool!");
    for (;;)
    {
      throw paramT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.ow.i.a
 * JD-Core Version:    0.7.0.1
 */