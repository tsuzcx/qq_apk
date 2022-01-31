package com.tencent.map.sdk.a;

import android.support.annotation.NonNull;

public class ow$i$a<T>
  implements ow.f<T>
{
  private final Object[] a;
  private int b;
  
  public ow$i$a(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("The max pool size must be > 0");
    }
    this.a = new Object[paramInt];
  }
  
  public T a()
  {
    if (this.b > 0)
    {
      int i = this.b - 1;
      Object localObject = this.a[i];
      this.a[i] = null;
      this.b -= 1;
      return localObject;
    }
    return null;
  }
  
  public boolean a(@NonNull T paramT)
  {
    boolean bool = false;
    int i = 0;
    if (i < this.b) {
      if (this.a[i] != paramT) {}
    }
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label50;
      }
      throw new IllegalStateException("Already in the pool!");
      i += 1;
      break;
    }
    label50:
    if (this.b < this.a.length)
    {
      this.a[this.b] = paramT;
      this.b += 1;
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.ow.i.a
 * JD-Core Version:    0.7.0.1
 */