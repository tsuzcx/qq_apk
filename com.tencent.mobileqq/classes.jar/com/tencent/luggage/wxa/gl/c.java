package com.tencent.luggage.wxa.gl;

import com.tencent.luggage.wxa.rt.i;
import java.io.InputStream;
import java.security.MessageDigest;

public final class c
{
  /* Error */
  public static String a(i parami, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +100 -> 101
    //   4: iload_1
    //   5: ifle +96 -> 101
    //   8: aload_0
    //   9: invokevirtual 16	com/tencent/luggage/wxa/rt/i:j	()Z
    //   12: ifne +5 -> 17
    //   15: aconst_null
    //   16: areturn
    //   17: aload_0
    //   18: invokestatic 21	com/tencent/luggage/wxa/rt/k:a	(Lcom/tencent/luggage/wxa/rt/i;)Ljava/io/InputStream;
    //   21: astore 4
    //   23: iload_1
    //   24: i2l
    //   25: lstore_2
    //   26: lload_2
    //   27: aload_0
    //   28: invokevirtual 25	com/tencent/luggage/wxa/rt/i:q	()J
    //   31: lcmp
    //   32: ifgt +6 -> 38
    //   35: goto +8 -> 43
    //   38: aload_0
    //   39: invokevirtual 25	com/tencent/luggage/wxa/rt/i:q	()J
    //   42: lstore_2
    //   43: aload 4
    //   45: lload_2
    //   46: l2i
    //   47: invokestatic 28	com/tencent/luggage/wxa/gl/c:a	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   50: astore_0
    //   51: aload 4
    //   53: invokevirtual 34	java/io/InputStream:close	()V
    //   56: aload 4
    //   58: ifnull +8 -> 66
    //   61: aload 4
    //   63: invokevirtual 34	java/io/InputStream:close	()V
    //   66: aload_0
    //   67: areturn
    //   68: astore_0
    //   69: goto +7 -> 76
    //   72: astore_0
    //   73: aconst_null
    //   74: astore 4
    //   76: aload 4
    //   78: ifnull +8 -> 86
    //   81: aload 4
    //   83: invokevirtual 34	java/io/InputStream:close	()V
    //   86: aload_0
    //   87: athrow
    //   88: aconst_null
    //   89: astore 4
    //   91: aload 4
    //   93: ifnull +8 -> 101
    //   96: aload 4
    //   98: invokevirtual 34	java/io/InputStream:close	()V
    //   101: aconst_null
    //   102: areturn
    //   103: astore_0
    //   104: goto -16 -> 88
    //   107: astore_0
    //   108: goto -17 -> 91
    //   111: astore 4
    //   113: aload_0
    //   114: areturn
    //   115: astore 4
    //   117: goto -31 -> 86
    //   120: astore_0
    //   121: aconst_null
    //   122: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	parami	i
    //   0	123	1	paramInt	int
    //   25	21	2	l	long
    //   21	76	4	localInputStream	InputStream
    //   111	1	4	localIOException1	java.io.IOException
    //   115	1	4	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   26	35	68	finally
    //   38	43	68	finally
    //   43	56	68	finally
    //   17	23	72	finally
    //   17	23	103	java/lang/Exception
    //   26	35	107	java/lang/Exception
    //   38	43	107	java/lang/Exception
    //   43	56	107	java/lang/Exception
    //   61	66	111	java/io/IOException
    //   81	86	115	java/io/IOException
    //   96	101	120	java/io/IOException
  }
  
  public static final String a(InputStream paramInputStream, int paramInt)
  {
    if (paramInputStream != null) {
      if (paramInt <= 0) {
        return null;
      }
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      StringBuilder localStringBuilder = new StringBuilder(32);
      byte[] arrayOfByte = new byte[paramInt];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        paramInt = 0;
        if (i == -1) {
          break;
        }
        localMessageDigest.update(arrayOfByte, 0, i);
      }
      paramInputStream = localMessageDigest.digest();
      while (paramInt < paramInputStream.length)
      {
        localStringBuilder.append(Integer.toString((paramInputStream[paramInt] & 0xFF) + 256, 16).substring(1));
        paramInt += 1;
      }
      paramInputStream = localStringBuilder.toString();
      return paramInputStream;
    }
    catch (Exception paramInputStream) {}
    return null;
    return null;
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = new i(paramString);
    if (paramString.j()) {
      return a(paramString, 102400);
    }
    return null;
  }
  
  public static final String a(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[16];
    char[] tmp8_6 = arrayOfChar;
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
    for (;;)
    {
      Object localObject;
      int k;
      int i;
      int j;
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramArrayOfByte);
        paramArrayOfByte = ((MessageDigest)localObject).digest();
        k = paramArrayOfByte.length;
        localObject = new char[k * 2];
        i = 0;
        j = 0;
      }
      catch (Exception paramArrayOfByte)
      {
        continue;
      }
      paramArrayOfByte = new String((char[])localObject);
      return paramArrayOfByte;
      return null;
      while (i < k)
      {
        int m = paramArrayOfByte[i];
        int n = j + 1;
        localObject[j] = arrayOfChar[(m >>> 4 & 0xF)];
        j = n + 1;
        localObject[n] = arrayOfChar[(m & 0xF)];
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gl.c
 * JD-Core Version:    0.7.0.1
 */