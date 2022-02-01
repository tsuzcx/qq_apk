package com.tencent.imcore.message.core.codec;

import android.util.SparseIntArray;

public class UinTypeRoutingTypeMapImpl
  implements UinTypeRoutingTypeMap
{
  private final SparseIntArray a = new SparseIntArray();
  
  public int a(int paramInt)
  {
    try
    {
      paramInt = this.a.get(paramInt, 1);
      return paramInt;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    try
    {
      this.a.put(paramInt1, paramInt2);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.core.codec.UinTypeRoutingTypeMapImpl
 * JD-Core Version:    0.7.0.1
 */