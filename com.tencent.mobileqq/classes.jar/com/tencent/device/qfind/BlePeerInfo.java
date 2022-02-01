package com.tencent.device.qfind;

import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public class BlePeerInfo
{
  private static int q = 1000000000;
  public String a;
  public String b;
  public List<String> c;
  public byte[] d;
  public int e;
  public int f;
  public long g;
  public long h;
  public int i;
  public SosoLbsInfo j;
  public byte[] k;
  public int l;
  public boolean m = false;
  public boolean n = false;
  public int o = 0;
  public int p = 0;
  
  public BlePeerInfo()
  {
    q += 1;
    this.i = q;
  }
  
  public static void a(byte[] paramArrayOfByte, BlePeerInfo paramBlePeerInfo)
  {
    for (;;)
    {
      try
      {
        paramBlePeerInfo.c = new ArrayList();
        paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.LITTLE_ENDIAN);
        if (paramArrayOfByte.remaining() > 2)
        {
          i2 = paramArrayOfByte.get();
          if (i2 == 0) {
            return;
          }
          int i3 = paramArrayOfByte.get();
          if (i3 != -1)
          {
            if (i3 != 22)
            {
              int i1 = i2;
              if (i3 != 2)
              {
                i1 = i2;
                if (i3 != 3)
                {
                  paramArrayOfByte.position(paramArrayOfByte.position() + i2 - 1);
                  continue;
                }
              }
              if (i1 >= 2)
              {
                paramBlePeerInfo.c.add(String.format("%08x-0000-1000-8000-00805f9b34fb", new Object[] { Short.valueOf(paramArrayOfByte.getShort()) }));
                i1 = (byte)(i1 - 2);
                continue;
              }
              continue;
            }
            if (i2 <= 2) {}
          }
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        int i2;
        return;
      }
      try
      {
        if (paramArrayOfByte.getShort() != 513) {
          continue;
        }
        paramBlePeerInfo.p = paramArrayOfByte.getShort();
        paramBlePeerInfo.o = paramArrayOfByte.getShort();
      }
      catch (Exception localException) {}
      paramArrayOfByte.position(paramArrayOfByte.position() + i2 - 1);
      continue;
      if (i2 > 10)
      {
        if (i2 > 11) {
          paramArrayOfByte.get(new byte[i2 - 1 - 10]);
        }
        paramBlePeerInfo.e = paramArrayOfByte.getInt();
        paramBlePeerInfo.d = new byte[6];
        paramArrayOfByte.get(paramBlePeerInfo.d);
      }
      else
      {
        paramArrayOfByte.position(paramArrayOfByte.position() + i2 - 1);
        continue;
        return;
      }
    }
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b.replaceAll(":", ""));
    localStringBuilder.append("0000");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.qfind.BlePeerInfo
 * JD-Core Version:    0.7.0.1
 */