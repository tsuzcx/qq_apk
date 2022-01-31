package com.tencent.biz.pubaccount.readinjoy.struct;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.Base64Util;

public class MagicEvent
  extends Entity
{
  public String val;
  
  public MagicEvent() {}
  
  public MagicEvent(boolean paramBoolean, @NonNull String paramString, long paramLong)
  {
    this.val = obfuscate(paramBoolean, paramString, paramLong);
  }
  
  public static long bytesToLong(byte[] paramArrayOfByte)
  {
    long l = 0L;
    int i = 0;
    while (i < 8)
    {
      l = l << 8 | paramArrayOfByte[i] & 0xFF;
      i += 1;
    }
    return l;
  }
  
  private String obfuscate(boolean paramBoolean, String paramString, long paramLong)
  {
    int j = 0;
    paramString = paramString.getBytes();
    int m = paramString.length;
    int k = m + 1 + 8;
    byte[] arrayOfByte = new byte[k];
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      arrayOfByte[0] = ((byte)i);
      i = 0;
      while (i < 8)
      {
        arrayOfByte[(k - 1 - i)] = ((byte)(int)(0xFF & paramLong));
        paramLong >>= 8;
        i += 1;
      }
    }
    System.arraycopy(paramString, 0, arrayOfByte, 1, m);
    i = j;
    while (i < k)
    {
      arrayOfByte[i] = ((byte)(arrayOfByte[i] ^ 0xB6));
      i += 1;
    }
    return Base64Util.encodeToString(arrayOfByte, 2);
  }
  
  public String getVal()
  {
    return this.val;
  }
  
  public String toString()
  {
    return this.val;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.MagicEvent
 * JD-Core Version:    0.7.0.1
 */