package com.tencent.av.avgesture;

class SHA1Utils
{
  private static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  /* Error */
  public static String getFileSHA1(String paramString)
  {
    // Byte code:
    //   0: new 36	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 39	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aload_2
    //   10: astore_0
    //   11: ldc 41
    //   13: invokestatic 47	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   16: astore_3
    //   17: aload_2
    //   18: astore_0
    //   19: ldc 48
    //   21: newarray byte
    //   23: astore 4
    //   25: aload_2
    //   26: astore_0
    //   27: aload_2
    //   28: aload 4
    //   30: invokevirtual 52	java/io/FileInputStream:read	([B)I
    //   33: istore_1
    //   34: iload_1
    //   35: ifle +16 -> 51
    //   38: aload_2
    //   39: astore_0
    //   40: aload_3
    //   41: aload 4
    //   43: iconst_0
    //   44: iload_1
    //   45: invokevirtual 56	java/security/MessageDigest:update	([BII)V
    //   48: goto -23 -> 25
    //   51: aload_2
    //   52: astore_0
    //   53: aload_3
    //   54: invokevirtual 60	java/security/MessageDigest:digest	()[B
    //   57: invokestatic 64	com/tencent/av/avgesture/SHA1Utils:toHexString	([B)Ljava/lang/String;
    //   60: astore_3
    //   61: aload_2
    //   62: invokevirtual 67	java/io/FileInputStream:close	()V
    //   65: aload_3
    //   66: areturn
    //   67: astore_0
    //   68: aload_0
    //   69: invokevirtual 70	java/lang/Exception:printStackTrace	()V
    //   72: aload_3
    //   73: areturn
    //   74: astore_3
    //   75: goto +12 -> 87
    //   78: astore_2
    //   79: aconst_null
    //   80: astore_0
    //   81: goto +30 -> 111
    //   84: astore_3
    //   85: aconst_null
    //   86: astore_2
    //   87: aload_2
    //   88: astore_0
    //   89: aload_3
    //   90: invokevirtual 70	java/lang/Exception:printStackTrace	()V
    //   93: aload_2
    //   94: ifnull +14 -> 108
    //   97: aload_2
    //   98: invokevirtual 67	java/io/FileInputStream:close	()V
    //   101: aconst_null
    //   102: areturn
    //   103: astore_0
    //   104: aload_0
    //   105: invokevirtual 70	java/lang/Exception:printStackTrace	()V
    //   108: aconst_null
    //   109: areturn
    //   110: astore_2
    //   111: aload_0
    //   112: ifnull +15 -> 127
    //   115: aload_0
    //   116: invokevirtual 67	java/io/FileInputStream:close	()V
    //   119: goto +8 -> 127
    //   122: astore_0
    //   123: aload_0
    //   124: invokevirtual 70	java/lang/Exception:printStackTrace	()V
    //   127: goto +5 -> 132
    //   130: aload_2
    //   131: athrow
    //   132: goto -2 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	paramString	String
    //   33	12	1	i	int
    //   8	54	2	localFileInputStream	java.io.FileInputStream
    //   78	1	2	localObject1	Object
    //   86	12	2	localObject2	Object
    //   110	21	2	localObject3	Object
    //   16	57	3	localObject4	Object
    //   74	1	3	localException1	java.lang.Exception
    //   84	6	3	localException2	java.lang.Exception
    //   23	19	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   61	65	67	java/lang/Exception
    //   11	17	74	java/lang/Exception
    //   19	25	74	java/lang/Exception
    //   27	34	74	java/lang/Exception
    //   40	48	74	java/lang/Exception
    //   53	61	74	java/lang/Exception
    //   0	9	78	finally
    //   0	9	84	java/lang/Exception
    //   97	101	103	java/lang/Exception
    //   11	17	110	finally
    //   19	25	110	finally
    //   27	34	110	finally
    //   40	48	110	finally
    //   53	61	110	finally
    //   89	93	110	finally
    //   115	119	122	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.avgesture.SHA1Utils
 * JD-Core Version:    0.7.0.1
 */