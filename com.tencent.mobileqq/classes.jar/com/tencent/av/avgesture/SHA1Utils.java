package com.tencent.av.avgesture;

class SHA1Utils
{
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  /* Error */
  public static String getFileSHA1(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: new 36	java/io/FileInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 39	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   13: astore_0
    //   14: ldc 41
    //   16: invokestatic 47	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   19: astore_2
    //   20: ldc 48
    //   22: newarray byte
    //   24: astore_3
    //   25: aload_0
    //   26: aload_3
    //   27: invokevirtual 52	java/io/FileInputStream:read	([B)I
    //   30: istore_1
    //   31: iload_1
    //   32: ifle +30 -> 62
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: iload_1
    //   39: invokevirtual 56	java/security/MessageDigest:update	([BII)V
    //   42: goto -17 -> 25
    //   45: astore_3
    //   46: aload_0
    //   47: astore_2
    //   48: aload_3
    //   49: invokevirtual 59	java/lang/Exception:printStackTrace	()V
    //   52: aload_0
    //   53: ifnull +7 -> 60
    //   56: aload_0
    //   57: invokevirtual 62	java/io/FileInputStream:close	()V
    //   60: aconst_null
    //   61: areturn
    //   62: aload_2
    //   63: invokevirtual 66	java/security/MessageDigest:digest	()[B
    //   66: invokestatic 70	com/tencent/av/avgesture/SHA1Utils:toHexString	([B)Ljava/lang/String;
    //   69: astore_2
    //   70: aload_0
    //   71: ifnull +7 -> 78
    //   74: aload_0
    //   75: invokevirtual 62	java/io/FileInputStream:close	()V
    //   78: aload_2
    //   79: areturn
    //   80: astore_0
    //   81: aload_0
    //   82: invokevirtual 59	java/lang/Exception:printStackTrace	()V
    //   85: goto -7 -> 78
    //   88: astore_0
    //   89: aload_0
    //   90: invokevirtual 59	java/lang/Exception:printStackTrace	()V
    //   93: goto -33 -> 60
    //   96: astore_0
    //   97: aload_2
    //   98: ifnull +7 -> 105
    //   101: aload_2
    //   102: invokevirtual 62	java/io/FileInputStream:close	()V
    //   105: aload_0
    //   106: athrow
    //   107: astore_2
    //   108: aload_2
    //   109: invokevirtual 59	java/lang/Exception:printStackTrace	()V
    //   112: goto -7 -> 105
    //   115: astore_3
    //   116: aload_0
    //   117: astore_2
    //   118: aload_3
    //   119: astore_0
    //   120: goto -23 -> 97
    //   123: astore_3
    //   124: aload 4
    //   126: astore_0
    //   127: goto -81 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	paramString	String
    //   30	9	1	i	int
    //   1	101	2	localObject1	Object
    //   107	2	2	localException1	java.lang.Exception
    //   117	1	2	str	String
    //   24	13	3	arrayOfByte	byte[]
    //   45	4	3	localException2	java.lang.Exception
    //   115	4	3	localObject2	Object
    //   123	1	3	localException3	java.lang.Exception
    //   3	122	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   14	25	45	java/lang/Exception
    //   25	31	45	java/lang/Exception
    //   35	42	45	java/lang/Exception
    //   62	70	45	java/lang/Exception
    //   74	78	80	java/lang/Exception
    //   56	60	88	java/lang/Exception
    //   5	14	96	finally
    //   48	52	96	finally
    //   101	105	107	java/lang/Exception
    //   14	25	115	finally
    //   25	31	115	finally
    //   35	42	115	finally
    //   62	70	115	finally
    //   5	14	123	java/lang/Exception
  }
  
  public static String toHexString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(HEX_DIGITS[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(HEX_DIGITS[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.avgesture.SHA1Utils
 * JD-Core Version:    0.7.0.1
 */