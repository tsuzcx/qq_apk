package com.tencent.hippy.qq.update.sign;

import java.io.InputStream;
import java.security.MessageDigest;

public class MD5
{
  /* Error */
  public static String getFileMd5(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 17	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 20	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   10: astore_0
    //   11: aload_0
    //   12: invokestatic 24	com/tencent/hippy/qq/update/sign/MD5:streamToMD5	(Ljava/io/InputStream;)Ljava/lang/String;
    //   15: astore_1
    //   16: aload_0
    //   17: invokevirtual 29	java/io/InputStream:close	()V
    //   20: aload_1
    //   21: areturn
    //   22: astore_0
    //   23: aload_0
    //   24: invokevirtual 32	java/io/IOException:printStackTrace	()V
    //   27: aload_1
    //   28: areturn
    //   29: astore_2
    //   30: aload_0
    //   31: astore_1
    //   32: aload_2
    //   33: astore_0
    //   34: goto +7 -> 41
    //   37: goto +24 -> 61
    //   40: astore_0
    //   41: aload_1
    //   42: ifnull +15 -> 57
    //   45: aload_1
    //   46: invokevirtual 29	java/io/InputStream:close	()V
    //   49: goto +8 -> 57
    //   52: astore_1
    //   53: aload_1
    //   54: invokevirtual 32	java/io/IOException:printStackTrace	()V
    //   57: aload_0
    //   58: athrow
    //   59: aconst_null
    //   60: astore_0
    //   61: aload_0
    //   62: ifnull +14 -> 76
    //   65: aload_0
    //   66: invokevirtual 29	java/io/InputStream:close	()V
    //   69: aconst_null
    //   70: areturn
    //   71: astore_0
    //   72: aload_0
    //   73: invokevirtual 32	java/io/IOException:printStackTrace	()V
    //   76: aconst_null
    //   77: areturn
    //   78: astore_0
    //   79: goto -20 -> 59
    //   82: astore_1
    //   83: goto -46 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	paramString	String
    //   1	45	1	str	String
    //   52	2	1	localIOException	java.io.IOException
    //   82	1	1	localException	Exception
    //   29	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	20	22	java/io/IOException
    //   11	16	29	finally
    //   2	11	40	finally
    //   45	49	52	java/io/IOException
    //   65	69	71	java/io/IOException
    //   2	11	78	java/lang/Exception
    //   11	16	82	java/lang/Exception
  }
  
  public static String streamToMD5(InputStream paramInputStream)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        localMessageDigest.update(arrayOfByte, 0, i);
      }
      paramInputStream = toHexString(localMessageDigest.digest());
      return paramInputStream;
    }
    catch (Exception paramInputStream)
    {
      label42:
      break label42;
    }
    return null;
  }
  
  public static String stringToMD5(String paramString)
  {
    try
    {
      paramString = paramString.getBytes();
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString);
      paramString = toHexString(localMessageDigest.digest());
      return paramString;
    }
    catch (Exception paramString)
    {
      label26:
      break label26;
    }
    return null;
  }
  
  private static String toHexString(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar1 = new char[16];
    char[] tmp8_6 = arrayOfChar1;
    tmp8_6[0] = 48;
    char[] tmp13_8 = tmp8_6;
    tmp13_8[1] = 49;
    char[] tmp18_13 = tmp13_8;
    tmp18_13[2] = 50;
    char[] tmp23_18 = tmp18_13;
    tmp23_18[3] = 51;
    char[] tmp28_23 = tmp23_18;
    tmp28_23[4] = 52;
    char[] tmp33_28 = tmp28_23;
    tmp33_28[5] = 53;
    char[] tmp38_33 = tmp33_28;
    tmp38_33[6] = 54;
    char[] tmp44_38 = tmp38_33;
    tmp44_38[7] = 55;
    char[] tmp50_44 = tmp44_38;
    tmp50_44[8] = 56;
    char[] tmp56_50 = tmp50_44;
    tmp56_50[9] = 57;
    char[] tmp62_56 = tmp56_50;
    tmp62_56[10] = 97;
    char[] tmp68_62 = tmp62_56;
    tmp68_62[11] = 98;
    char[] tmp74_68 = tmp68_62;
    tmp74_68[12] = 99;
    char[] tmp80_74 = tmp74_68;
    tmp80_74[13] = 100;
    char[] tmp86_80 = tmp80_74;
    tmp86_80[14] = 101;
    char[] tmp92_86 = tmp86_80;
    tmp92_86[15] = 102;
    tmp92_86;
    int j = paramArrayOfByte.length;
    char[] arrayOfChar2 = new char[j * 2];
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i];
      int m = i * 2;
      arrayOfChar2[m] = arrayOfChar1[(k >>> 4 & 0xF)];
      arrayOfChar2[(m + 1)] = arrayOfChar1[(k & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.update.sign.MD5
 * JD-Core Version:    0.7.0.1
 */