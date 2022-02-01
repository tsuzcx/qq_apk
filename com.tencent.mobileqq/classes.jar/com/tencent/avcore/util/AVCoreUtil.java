package com.tencent.avcore.util;

public class AVCoreUtil
{
  static final long MAX_VALUE = -1L;
  static final String MIN_VALUE = "-9223372036854775808";
  static final String TAG = "AVCoreUtil";
  static int nVersion = -1;
  
  public static String asUnsignedDecimalString(long paramLong)
  {
    long l = 0xFFFFFFFF & paramLong;
    if (paramLong == l) {
      return String.valueOf(l);
    }
    char[] arrayOfChar = "-9223372036854775808".toCharArray();
    arrayOfChar[0] = '0';
    int j = arrayOfChar.length - 1;
    paramLong = l;
    while ((j != 0) && (paramLong != 0L))
    {
      int i = (char)(int)(arrayOfChar[j] + paramLong % 10L);
      arrayOfChar[j] = i;
      if (i > 57)
      {
        arrayOfChar[j] = ((char)(arrayOfChar[j] - '\n'));
        int k = j - 1;
        arrayOfChar[k] = ((char)(arrayOfChar[k] + '\001'));
      }
      paramLong /= 10L;
      j -= 1;
    }
    j = '1' - arrayOfChar[0];
    return new String(arrayOfChar, j, arrayOfChar.length - j);
  }
  
  public static int getQQVersion()
  {
    if (nVersion == -1)
    {
      nVersion = strVersionToInt(AVCoreLog.getVersion());
      if (nVersion == 0) {
        nVersion = 660;
      }
    }
    return nVersion;
  }
  
  public static void printHexStringEx(String paramString, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      StringBuilder localStringBuilder1 = new StringBuilder((paramArrayOfByte.length + 15) / 16 * 73 + 85);
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("buf size: ");
      localStringBuilder2.append(paramArrayOfByte.length);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder1.append("\r\n");
      localStringBuilder1.append("______00_01_02_03_04_05_06_07_08_09_0A_0B_0C_0D_0E_0F\r\n");
      localStringBuilder2 = new StringBuilder(32);
      localStringBuilder2.append(" ");
      int j = 0;
      int i = 0;
      int k = 0;
      for (;;)
      {
        if (j < paramArrayOfByte.length)
        {
          if (i == 0) {
            localStringBuilder1.append(String.format("%04x: ", new Object[] { Integer.valueOf(j) }));
          }
          localStringBuilder1.append(String.format("%02x ", new Object[] { Byte.valueOf(paramArrayOfByte[j]) }));
          if ((paramArrayOfByte[j] >= 32) && (paramArrayOfByte[j] <= 127)) {
            localStringBuilder2.append(String.format("%c", new Object[] { Byte.valueOf(paramArrayOfByte[j]) }));
          } else {
            localStringBuilder2.append(".");
          }
        }
        else
        {
          if (i == 0) {
            break label294;
          }
          localStringBuilder1.append("   ");
          localStringBuilder2.append(" ");
          k = 1;
        }
        int m = i + 1;
        i = m;
        if (m >= 16)
        {
          localStringBuilder1.append(localStringBuilder2.toString());
          localStringBuilder1.append("\r\n");
          localStringBuilder2.setLength(1);
          if (k != 0)
          {
            label294:
            AVCoreLog.i(paramString, localStringBuilder1.toString());
            return;
          }
          i = 0;
        }
        j += 1;
      }
    }
    AVCoreLog.i(paramString, "bytes = null or bytes.length = 0");
  }
  
  public static int strVersionToInt(String paramString)
  {
    for (;;)
    {
      try
      {
        String[] arrayOfString = paramString.split("\\.");
        if (arrayOfString.length > 0)
        {
          j = Integer.valueOf(arrayOfString[0]).intValue() * 10000 + 0;
          int i = j;
          if (arrayOfString.length > 1) {
            i = j + Integer.valueOf(arrayOfString[1]).intValue() * 100;
          }
          j = i;
          if (arrayOfString.length > 2)
          {
            j = Integer.valueOf(arrayOfString[2]).intValue();
            j = i + j;
          }
          return j;
        }
      }
      catch (Exception localException)
      {
        if (AVCoreLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("strVersionToInt, Exception, version[");
          localStringBuilder.append(paramString);
          localStringBuilder.append("]");
          AVCoreLog.e("AVCoreUtil", localStringBuilder.toString(), localException);
        }
        return 0;
      }
      int j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.util.AVCoreUtil
 * JD-Core Version:    0.7.0.1
 */