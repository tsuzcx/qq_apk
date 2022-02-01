package com.tencent.gdtad.aditem;

import com.tencent.open.base.MD5Utils;

public class GdtAdUtil
{
  public static String a(long paramLong1, long paramLong2, int paramInt)
  {
    return MD5Utils.toMD5(String.format("%s_%d_%d_%d", new Object[] { "!@#$%qboi!@#^&*m13=4aa22", Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) })).toLowerCase();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtAdUtil
 * JD-Core Version:    0.7.0.1
 */