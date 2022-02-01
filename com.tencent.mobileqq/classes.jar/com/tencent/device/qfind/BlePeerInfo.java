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
    try
    {
      paramBlePeerInfo.jdField_a_of_type_JavaUtilList = new ArrayList();
      paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.LITTLE_ENDIAN);
      int j;
      int i;
      if (paramArrayOfByte.remaining() > 2)
      {
        j = paramArrayOfByte.get();
        if (j == 0) {
          return;
        }
        i = j;
        switch (paramArrayOfByte.get())
        {
        }
      }
      for (;;)
      {
        for (;;)
        {
          paramArrayOfByte.position(j + paramArrayOfByte.position() - 1);
          break;
          while (i >= 2)
          {
            paramBlePeerInfo.jdField_a_of_type_JavaUtilList.add(String.format("%08x-0000-1000-8000-00805f9b34fb", new Object[] { Short.valueOf(paramArrayOfByte.getShort()) }));
            i = (byte)(i - 2);
          }
          if (j > 10)
          {
            if (j > 11) {
              paramArrayOfByte.get(new byte[j - 1 - 10]);
            }
            paramBlePeerInfo.jdField_a_of_type_Int = paramArrayOfByte.getInt();
            paramBlePeerInfo.jdField_a_of_type_ArrayOfByte = new byte[6];
            paramArrayOfByte.get(paramBlePeerInfo.jdField_a_of_type_ArrayOfByte);
            break;
          }
          paramArrayOfByte.position(j + paramArrayOfByte.position() - 1);
          break;
          if (j <= 2) {
            break label254;
          }
          try
          {
            if (paramArrayOfByte.getShort() != 513) {
              break;
            }
            paramBlePeerInfo.f = paramArrayOfByte.getShort();
            paramBlePeerInfo.e = paramArrayOfByte.getShort();
          }
          catch (Exception localException) {}
        }
        break;
        label254:
        paramArrayOfByte.position(j + paramArrayOfByte.position() - 1);
        break;
        return;
      }
      return;
    }
    catch (Throwable paramArrayOfByte) {}
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString.replaceAll(":", "") + "0000";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.device.qfind.BlePeerInfo
 * JD-Core Version:    0.7.0.1
 */