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
    //   1: astore_2
    //   2: new 17	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 20	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   10: astore_0
    //   11: aload_0
    //   12: invokestatic 24	com/tencent/hippy/qq/update/sign/MD5:streamToMD5	(Ljava/io/InputStream;)Ljava/lang/String;
    //   15: astore_1
    //   16: aload_1
    //   17: astore_2
    //   18: aload_0
    //   19: ifnull +9 -> 28
    //   22: aload_0
    //   23: invokevirtual 29	java/io/InputStream:close	()V
    //   26: aload_1
    //   27: astore_2
    //   28: aload_2
    //   29: areturn
    //   30: astore_0
    //   31: aload_0
    //   32: invokevirtual 32	java/io/IOException:printStackTrace	()V
    //   35: aload_1
    //   36: areturn
    //   37: astore_0
    //   38: aconst_null
    //   39: astore_0
    //   40: aload_0
    //   41: ifnull -13 -> 28
    //   44: aload_0
    //   45: invokevirtual 29	java/io/InputStream:close	()V
    //   48: aconst_null
    //   49: areturn
    //   50: astore_0
    //   51: aload_0
    //   52: invokevirtual 32	java/io/IOException:printStackTrace	()V
    //   55: aconst_null
    //   56: areturn
    //   57: astore_1
    //   58: aconst_null
    //   59: astore_0
    //   60: aload_0
    //   61: ifnull +7 -> 68
    //   64: aload_0
    //   65: invokevirtual 29	java/io/InputStream:close	()V
    //   68: aload_1
    //   69: athrow
    //   70: astore_0
    //   71: aload_0
    //   72: invokevirtual 32	java/io/IOException:printStackTrace	()V
    //   75: goto -7 -> 68
    //   78: astore_1
    //   79: goto -19 -> 60
    //   82: astore_1
    //   83: goto -43 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	paramString	String
    //   15	21	1	str	String
    //   57	12	1	localObject1	Object
    //   78	1	1	localObject2	Object
    //   82	1	1	localException	Exception
    //   1	28	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   22	26	30	java/io/IOException
    //   2	11	37	java/lang/Exception
    //   44	48	50	java/io/IOException
    //   2	11	57	finally
    //   64	68	70	java/io/IOException
    //   11	16	78	finally
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
    catch (Exception paramInputStream) {}
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
    catch (Exception paramString) {}
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
      arrayOfChar2[(i * 2)] = arrayOfChar1[(k >>> 4 & 0xF)];
      arrayOfChar2[(i * 2 + 1)] = arrayOfChar1[(k & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.update.sign.MD5
 * JD-Core Version:    0.7.0.1
 */