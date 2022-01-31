package com.tencent.av.avgesture;

class SHA1Utils
{
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  /* Error */
  public static String getFileSHA1(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 36	java/io/FileInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 39	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   11: astore_2
    //   12: aload_2
    //   13: astore_0
    //   14: ldc 41
    //   16: invokestatic 47	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   19: astore_3
    //   20: aload_2
    //   21: astore_0
    //   22: ldc 48
    //   24: newarray byte
    //   26: astore 5
    //   28: aload_2
    //   29: astore_0
    //   30: aload_2
    //   31: aload 5
    //   33: invokevirtual 52	java/io/FileInputStream:read	([B)I
    //   36: istore_1
    //   37: iload_1
    //   38: ifle +39 -> 77
    //   41: aload_2
    //   42: astore_0
    //   43: aload_3
    //   44: aload 5
    //   46: iconst_0
    //   47: iload_1
    //   48: invokevirtual 56	java/security/MessageDigest:update	([BII)V
    //   51: goto -23 -> 28
    //   54: astore_3
    //   55: aload_2
    //   56: astore_0
    //   57: aload_3
    //   58: invokevirtual 59	java/lang/Exception:printStackTrace	()V
    //   61: aload 4
    //   63: astore_0
    //   64: aload_2
    //   65: ifnull +10 -> 75
    //   68: aload_2
    //   69: invokevirtual 62	java/io/FileInputStream:close	()V
    //   72: aload 4
    //   74: astore_0
    //   75: aload_0
    //   76: areturn
    //   77: aload_2
    //   78: astore_0
    //   79: aload_3
    //   80: invokevirtual 66	java/security/MessageDigest:digest	()[B
    //   83: invokestatic 70	com/tencent/av/avgesture/SHA1Utils:toHexString	([B)Ljava/lang/String;
    //   86: astore_3
    //   87: aload_3
    //   88: astore_0
    //   89: aload_2
    //   90: ifnull -15 -> 75
    //   93: aload_2
    //   94: invokevirtual 62	java/io/FileInputStream:close	()V
    //   97: aload_3
    //   98: areturn
    //   99: astore_0
    //   100: aload_0
    //   101: invokevirtual 59	java/lang/Exception:printStackTrace	()V
    //   104: aload_3
    //   105: areturn
    //   106: astore_0
    //   107: aload_0
    //   108: invokevirtual 59	java/lang/Exception:printStackTrace	()V
    //   111: aconst_null
    //   112: areturn
    //   113: astore_2
    //   114: aconst_null
    //   115: astore_0
    //   116: aload_0
    //   117: ifnull +7 -> 124
    //   120: aload_0
    //   121: invokevirtual 62	java/io/FileInputStream:close	()V
    //   124: aload_2
    //   125: athrow
    //   126: astore_0
    //   127: aload_0
    //   128: invokevirtual 59	java/lang/Exception:printStackTrace	()V
    //   131: goto -7 -> 124
    //   134: astore_2
    //   135: goto -19 -> 116
    //   138: astore_3
    //   139: aconst_null
    //   140: astore_2
    //   141: goto -86 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	paramString	String
    //   36	12	1	i	int
    //   11	83	2	localFileInputStream	java.io.FileInputStream
    //   113	12	2	localObject1	Object
    //   134	1	2	localObject2	Object
    //   140	1	2	localObject3	Object
    //   19	25	3	localMessageDigest	java.security.MessageDigest
    //   54	26	3	localException1	java.lang.Exception
    //   86	19	3	str	String
    //   138	1	3	localException2	java.lang.Exception
    //   1	72	4	localObject4	Object
    //   26	19	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   14	20	54	java/lang/Exception
    //   22	28	54	java/lang/Exception
    //   30	37	54	java/lang/Exception
    //   43	51	54	java/lang/Exception
    //   79	87	54	java/lang/Exception
    //   93	97	99	java/lang/Exception
    //   68	72	106	java/lang/Exception
    //   3	12	113	finally
    //   120	124	126	java/lang/Exception
    //   14	20	134	finally
    //   22	28	134	finally
    //   30	37	134	finally
    //   43	51	134	finally
    //   57	61	134	finally
    //   79	87	134	finally
    //   3	12	138	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.avgesture.SHA1Utils
 * JD-Core Version:    0.7.0.1
 */