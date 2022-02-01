package com.tencent.av.business.handler;

import android.annotation.SuppressLint;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;

public class AudioTrans
{
  private static AudioTrans a = new AudioTrans();
  
  public static AudioTrans.PBBytes a(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    int j = paramArrayOfByte[0];
    j = paramArrayOfByte[(i - 1)];
    Object localObject = new byte[4];
    byte[] arrayOfByte = new byte[4];
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("rspBodyBytes = ");
    localStringBuilder.append(b(paramArrayOfByte));
    QLog.d("AudioTrans runhw", 2, localStringBuilder.toString());
    System.arraycopy(paramArrayOfByte, 1, localObject, 0, 4);
    System.arraycopy(paramArrayOfByte, 5, arrayOfByte, 0, 4);
    j = c((byte[])localObject);
    int k = c(arrayOfByte);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("rspBytesLen = ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(", lengthOfHead = ");
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append(", lengthOfBody = ");
    ((StringBuilder)localObject).append(k);
    QLog.d("AudioTrans runhw", 2, ((StringBuilder)localObject).toString());
    localObject = new AudioTrans.PBBytes(j, k);
    System.arraycopy(paramArrayOfByte, 9, ((AudioTrans.PBBytes)localObject).a, 0, j);
    System.arraycopy(paramArrayOfByte, j + 9, ((AudioTrans.PBBytes)localObject).b, 0, k);
    return localObject;
  }
  
  public static AudioTrans a()
  {
    return a;
  }
  
  @SuppressLint({"DefaultLocale"})
  public static String a(int paramInt)
  {
    return String.format("%d.%d.%d.%d", new Object[] { Integer.valueOf(paramInt >> 24 & 0xFF), Integer.valueOf(paramInt >> 16 & 0xFF), Integer.valueOf(paramInt >> 8 & 0xFF), Integer.valueOf(paramInt & 0xFF) });
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = paramArrayOfByte1.length;
    int j = paramArrayOfByte2.length;
    byte[] arrayOfByte1 = ByteBuffer.allocate(4).putInt(i).array();
    byte[] arrayOfByte2 = ByteBuffer.allocate(4).putInt(j).array();
    int k = i + 9;
    byte[] arrayOfByte3 = new byte[k + j + 1];
    arrayOfByte3[0] = 40;
    System.arraycopy(arrayOfByte1, 0, arrayOfByte3, 1, 4);
    System.arraycopy(arrayOfByte2, 0, arrayOfByte3, 5, 4);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte3, 9, i);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte3, k, j);
    arrayOfByte3[(arrayOfByte3.length - 1)] = 41;
    return arrayOfByte3;
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    char[] arrayOfChar1 = "0123456789ABCDEF".toCharArray();
    char[] arrayOfChar2 = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      int k = i * 2;
      arrayOfChar2[k] = arrayOfChar1[(j >>> 4)];
      arrayOfChar2[(k + 1)] = arrayOfChar1[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar2);
  }
  
  private static int c(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte[3];
    int j = paramArrayOfByte[2];
    int k = paramArrayOfByte[1];
    return (paramArrayOfByte[0] & 0xFF) << 24 | i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.handler.AudioTrans
 * JD-Core Version:    0.7.0.1
 */