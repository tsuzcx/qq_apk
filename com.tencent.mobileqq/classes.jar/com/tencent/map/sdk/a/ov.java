package com.tencent.map.sdk.a;

import android.graphics.Rect;
import java.nio.ByteBuffer;

public final class ov
{
  public final Rect a = new Rect();
  public int[] b;
  public int[] c;
  public int[] d;
  
  public static void a(int paramInt)
  {
    if ((paramInt != 0) && ((paramInt & 0x1) == 0)) {
      return;
    }
    throw new RuntimeException("invalid nine-patch: ".concat(String.valueOf(paramInt)));
  }
  
  public static void a(int[] paramArrayOfInt, ByteBuffer paramByteBuffer)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      paramArrayOfInt[i] = paramByteBuffer.getInt();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.ov
 * JD-Core Version:    0.7.0.1
 */