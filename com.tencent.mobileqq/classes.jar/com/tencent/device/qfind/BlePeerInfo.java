package com.tencent.device.qfind;

import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public class BlePeerInfo
{
  private static int g = 1000000000;
  public int a;
  public long a;
  public SosoLbsInfo a;
  public String a;
  public List<String> a;
  public boolean a;
  public byte[] a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public byte[] b;
  public int c;
  public int d;
  public int e = 0;
  public int f = 0;
  
  public BlePeerInfo()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    g += 1;
    this.c = g;
  }
  
  public static void a(byte[] paramArrayOfByte, BlePeerInfo paramBlePeerInfo)
  {
    for (;;)
    {
      try
      {
        paramBlePeerInfo.jdField_a_of_type_JavaUtilList = new ArrayList();
        paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.LITTLE_ENDIAN);
        if (paramArrayOfByte.remaining() > 2)
        {
          j = paramArrayOfByte.get();
          if (j == 0) {
            return;
          }
          int k = paramArrayOfByte.get();
          if (k != -1)
          {
            if (k != 22)
            {
              int i = j;
              if (k != 2)
              {
                i = j;
                if (k != 3)
                {
                  paramArrayOfByte.position(paramArrayOfByte.position() + j - 1);
                  continue;
                }
              }
              if (i >= 2)
              {
                paramBlePeerInfo.jdField_a_of_type_JavaUtilList.add(String.format("%08x-0000-1000-8000-00805f9b34fb", new Object[] { Short.valueOf(paramArrayOfByte.getShort()) }));
                i = (byte)(i - 2);
                continue;
              }
              continue;
            }
            if (j <= 2) {}
          }
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        int j;
        return;
      }
      try
      {
        if (paramArrayOfByte.getShort() != 513) {
          continue;
        }
        paramBlePeerInfo.f = paramArrayOfByte.getShort();
        paramBlePeerInfo.e = paramArrayOfByte.getShort();
      }
      catch (Exception localException) {}
      paramArrayOfByte.position(paramArrayOfByte.position() + j - 1);
      continue;
      if (j > 10)
      {
        if (j > 11) {
          paramArrayOfByte.get(new byte[j - 1 - 10]);
        }
        paramBlePeerInfo.jdField_a_of_type_Int = paramArrayOfByte.getInt();
        paramBlePeerInfo.jdField_a_of_type_ArrayOfByte = new byte[6];
        paramArrayOfByte.get(paramBlePeerInfo.jdField_a_of_type_ArrayOfByte);
      }
      else
      {
        paramArrayOfByte.position(paramArrayOfByte.position() + j - 1);
        continue;
        return;
      }
    }
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString.replaceAll(":", ""));
    localStringBuilder.append("0000");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.qfind.BlePeerInfo
 * JD-Core Version:    0.7.0.1
 */