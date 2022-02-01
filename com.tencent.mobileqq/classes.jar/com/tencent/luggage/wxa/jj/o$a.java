package com.tencent.luggage.wxa.jj;

import android.text.TextUtils;
import android.util.SparseIntArray;

final class o$a
{
  private final SparseIntArray a = new SparseIntArray();
  
  public int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    synchronized (this.a)
    {
      int i = this.a.get(paramString.hashCode(), -1);
      return i;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    synchronized (this.a)
    {
      this.a.put(paramString.hashCode(), paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jj.o.a
 * JD-Core Version:    0.7.0.1
 */