package com.tencent.falco.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils
{
  private byte[] buffer = new byte[64];
  private byte[] digest = new byte[16];
  public String digestHexStr;
  
  public static long b2iu(byte paramByte)
  {
    return paramByte;
  }
  
  public static String byteHEX(byte paramByte)
  {
    char[] arrayOfChar = new char[16];
    char[] tmp6_5 = arrayOfChar;
    tmp6_5[0] = 48;
    char[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 49;
    char[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 50;
    char[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 51;
    char[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 52;
    char[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 53;
    char[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 54;
    char[] tmp42_36 = tmp36_31;
    tmp42_36[7] = 55;
    char[] tmp48_42 = tmp42_36;
    tmp48_42[8] = 56;
    char[] tmp54_48 = tmp48_42;
    tmp54_48[9] = 57;
    char[] tmp60_54 = tmp54_48;
    tmp60_54[10] = 65;
    char[] tmp66_60 = tmp60_54;
    tmp66_60[11] = 66;
    char[] tmp72_66 = tmp66_60;
    tmp72_66[12] = 67;
    char[] tmp78_72 = tmp72_66;
    tmp78_72[13] = 68;
    char[] tmp84_78 = tmp78_72;
    tmp84_78[14] = 69;
    char[] tmp90_84 = tmp84_78;
    tmp90_84[15] = 70;
    tmp90_84;
    return new String(new char[] { arrayOfChar[(paramByte >>> 4 & 0xF)], arrayOfChar[(paramByte & 0xF)] });
  }
  
  public static byte[] getFileMd5(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return null;
      }
      try
      {
        File localFile = new File(paramString);
        if (localFile.exists())
        {
          paramString = getPartfileMd5(paramString, localFile.length());
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public static String getFileMd5String(String paramString)
  {
    paramString = getFileMd5(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString != null)
    {
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(byteHEX(paramString[i]));
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static byte[] getPartfileMd5(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aload_0
    //   4: ifnull +191 -> 195
    //   7: aload_0
    //   8: invokevirtual 51	java/lang/String:length	()I
    //   11: ifeq +184 -> 195
    //   14: lload_1
    //   15: lconst_0
    //   16: lcmp
    //   17: ifge +5 -> 22
    //   20: aconst_null
    //   21: areturn
    //   22: new 91	java/io/FileInputStream
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 92	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   30: astore 8
    //   32: aload 8
    //   34: astore 7
    //   36: new 53	java/io/File
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: astore_0
    //   45: aload 8
    //   47: astore 7
    //   49: aload_0
    //   50: invokevirtual 60	java/io/File:exists	()Z
    //   53: ifeq +60 -> 113
    //   56: aload 8
    //   58: astore 7
    //   60: aload_0
    //   61: invokevirtual 63	java/io/File:length	()J
    //   64: lstore 5
    //   66: lload_1
    //   67: lconst_0
    //   68: lcmp
    //   69: ifeq +128 -> 197
    //   72: lload_1
    //   73: lstore_3
    //   74: lload 5
    //   76: lload_1
    //   77: lcmp
    //   78: ifge +6 -> 84
    //   81: goto +116 -> 197
    //   84: aload 8
    //   86: astore 7
    //   88: aload 8
    //   90: lload_3
    //   91: invokestatic 96	com/tencent/falco/utils/MD5Utils:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   94: astore_0
    //   95: aload_0
    //   96: astore 7
    //   98: aload 8
    //   100: invokevirtual 99	java/io/FileInputStream:close	()V
    //   103: aload_0
    //   104: areturn
    //   105: astore_0
    //   106: aload_0
    //   107: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   110: aload 7
    //   112: areturn
    //   113: aload 8
    //   115: invokevirtual 99	java/io/FileInputStream:close	()V
    //   118: aconst_null
    //   119: areturn
    //   120: astore_0
    //   121: aload_0
    //   122: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   125: aconst_null
    //   126: areturn
    //   127: astore 7
    //   129: aload 8
    //   131: astore_0
    //   132: aload 7
    //   134: astore 8
    //   136: goto +14 -> 150
    //   139: astore_0
    //   140: aconst_null
    //   141: astore 7
    //   143: goto +30 -> 173
    //   146: astore 8
    //   148: aconst_null
    //   149: astore_0
    //   150: aload_0
    //   151: astore 7
    //   153: aload 8
    //   155: invokevirtual 70	java/lang/Exception:printStackTrace	()V
    //   158: aload_0
    //   159: ifnull +11 -> 170
    //   162: aload 9
    //   164: astore 7
    //   166: aload_0
    //   167: invokevirtual 99	java/io/FileInputStream:close	()V
    //   170: aconst_null
    //   171: areturn
    //   172: astore_0
    //   173: aload 7
    //   175: ifnull +18 -> 193
    //   178: aload 7
    //   180: invokevirtual 99	java/io/FileInputStream:close	()V
    //   183: goto +10 -> 193
    //   186: astore 7
    //   188: aload 7
    //   190: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   193: aload_0
    //   194: athrow
    //   195: aconst_null
    //   196: areturn
    //   197: lload 5
    //   199: lstore_3
    //   200: goto -116 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	paramString	String
    //   0	203	1	paramLong	long
    //   73	127	3	l1	long
    //   64	134	5	l2	long
    //   34	77	7	localObject1	Object
    //   127	6	7	localException1	Exception
    //   141	38	7	localObject2	Object
    //   186	3	7	localIOException	IOException
    //   30	105	8	localObject3	Object
    //   146	8	8	localException2	Exception
    //   1	162	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   98	103	105	java/io/IOException
    //   166	170	105	java/io/IOException
    //   113	118	120	java/io/IOException
    //   36	45	127	java/lang/Exception
    //   49	56	127	java/lang/Exception
    //   60	66	127	java/lang/Exception
    //   88	95	127	java/lang/Exception
    //   22	32	139	finally
    //   22	32	146	java/lang/Exception
    //   36	45	172	finally
    //   49	56	172	finally
    //   60	66	172	finally
    //   88	95	172	finally
    //   153	158	172	finally
    //   178	183	186	java/io/IOException
  }
  
  public static byte[] sysGetBufferMd5(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte != null)
    {
      if (paramInt2 == 0) {
        return null;
      }
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        localMessageDigest.update(paramArrayOfByte, paramInt1, paramInt2);
        paramArrayOfByte = localMessageDigest.digest();
        return paramArrayOfByte;
      }
      catch (NoSuchAlgorithmException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
    return null;
  }
  
  /* Error */
  public static byte[] sysGetStremMd5(InputStream paramInputStream, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +150 -> 151
    //   4: lconst_0
    //   5: lstore 4
    //   7: lload_1
    //   8: lconst_0
    //   9: lcmp
    //   10: ifne +5 -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: ldc 106
    //   17: invokestatic 112	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   20: astore 6
    //   22: ldc 122
    //   24: newarray byte
    //   26: astore 7
    //   28: aload 7
    //   30: arraylength
    //   31: istore_3
    //   32: lload 4
    //   34: lload_1
    //   35: lcmp
    //   36: ifge +59 -> 95
    //   39: aload 7
    //   41: arraylength
    //   42: i2l
    //   43: lload 4
    //   45: ladd
    //   46: lload_1
    //   47: lcmp
    //   48: ifle +9 -> 57
    //   51: lload_1
    //   52: lload 4
    //   54: lsub
    //   55: l2i
    //   56: istore_3
    //   57: aload_0
    //   58: aload 7
    //   60: iconst_0
    //   61: iload_3
    //   62: invokevirtual 128	java/io/InputStream:read	([BII)I
    //   65: istore_3
    //   66: iload_3
    //   67: ifge +9 -> 76
    //   70: aload_0
    //   71: invokestatic 134	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   74: aconst_null
    //   75: areturn
    //   76: aload 6
    //   78: aload 7
    //   80: iconst_0
    //   81: iload_3
    //   82: invokevirtual 116	java/security/MessageDigest:update	([BII)V
    //   85: lload 4
    //   87: iload_3
    //   88: i2l
    //   89: ladd
    //   90: lstore 4
    //   92: goto -60 -> 32
    //   95: aload_0
    //   96: invokevirtual 135	java/io/InputStream:close	()V
    //   99: aload 6
    //   101: invokevirtual 119	java/security/MessageDigest:digest	()[B
    //   104: astore 6
    //   106: aload_0
    //   107: invokestatic 134	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   110: aload 6
    //   112: areturn
    //   113: astore 6
    //   115: goto +29 -> 144
    //   118: astore 6
    //   120: aload 6
    //   122: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   125: aload_0
    //   126: invokestatic 134	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   129: aconst_null
    //   130: areturn
    //   131: astore 6
    //   133: aload 6
    //   135: invokevirtual 120	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   138: aload_0
    //   139: invokestatic 134	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   142: aconst_null
    //   143: areturn
    //   144: aload_0
    //   145: invokestatic 134	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   148: aload 6
    //   150: athrow
    //   151: aconst_null
    //   152: areturn
    //   153: astore 7
    //   155: goto -56 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	paramInputStream	InputStream
    //   0	158	1	paramLong	long
    //   31	57	3	i	int
    //   5	86	4	l	long
    //   20	91	6	localObject1	Object
    //   113	1	6	localObject2	Object
    //   118	3	6	localIOException	IOException
    //   131	18	6	localNoSuchAlgorithmException	NoSuchAlgorithmException
    //   26	53	7	arrayOfByte	byte[]
    //   153	1	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   15	32	113	finally
    //   39	51	113	finally
    //   57	66	113	finally
    //   76	85	113	finally
    //   95	99	113	finally
    //   99	106	113	finally
    //   120	125	113	finally
    //   133	138	113	finally
    //   15	32	118	java/io/IOException
    //   39	51	118	java/io/IOException
    //   57	66	118	java/io/IOException
    //   76	85	118	java/io/IOException
    //   95	99	118	java/io/IOException
    //   99	106	118	java/io/IOException
    //   15	32	131	java/security/NoSuchAlgorithmException
    //   39	51	131	java/security/NoSuchAlgorithmException
    //   57	66	131	java/security/NoSuchAlgorithmException
    //   76	85	131	java/security/NoSuchAlgorithmException
    //   95	99	131	java/security/NoSuchAlgorithmException
    //   99	106	131	java/security/NoSuchAlgorithmException
    //   95	99	153	java/lang/Exception
  }
  
  public static String toMD5(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      localObject = paramString.getBytes("ISO8859_1");
      paramString = (String)localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      Object localObject;
      label18:
      int j;
      int i;
      break label18;
    }
    paramString = paramString.getBytes();
    localObject = new MD5Utils();
    j = paramString.length;
    i = 0;
    localObject = ((MD5Utils)localObject).getMD5(paramString, 0, j);
    paramString = "";
    if (localObject == null) {
      return "";
    }
    while (i < 16)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(byteHEX(localObject[i]));
      paramString = localStringBuilder.toString();
      i += 1;
    }
    return paramString;
  }
  
  public static String toMD5(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      Object localObject = new MD5Utils();
      int j = paramArrayOfByte.length;
      int i = 0;
      localObject = ((MD5Utils)localObject).getMD5(paramArrayOfByte, 0, j);
      paramArrayOfByte = "";
      while (i < 16)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramArrayOfByte);
        localStringBuilder.append(byteHEX(localObject[i]));
        paramArrayOfByte = localStringBuilder.toString();
        i += 1;
      }
      return paramArrayOfByte;
    }
    return null;
  }
  
  public static byte[] toMD5Byte(InputStream paramInputStream, long paramLong)
  {
    return new MD5Utils().getMD5(paramInputStream, paramLong);
  }
  
  public static byte[] toMD5Byte(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      byte[] arrayOfByte = paramString.getBytes("ISO8859_1");
      paramString = arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      label18:
      break label18;
    }
    paramString = paramString.getBytes();
    return new MD5Utils().getMD5(paramString, 0, paramString.length);
  }
  
  public static byte[] toMD5Byte(byte[] paramArrayOfByte)
  {
    return toMD5Byte(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static byte[] toMD5Byte(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new MD5Utils().getMD5(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public byte[] getMD5(InputStream paramInputStream, long paramLong)
  {
    if (paramInputStream != null)
    {
      if (paramLong < 0L) {
        return null;
      }
      try
      {
        long l2 = paramInputStream.available();
        long l1;
        if (paramLong != 0L)
        {
          l1 = paramLong;
          if (l2 != 0L)
          {
            l1 = paramLong;
            if (paramInputStream.available() >= paramLong) {}
          }
        }
        else
        {
          int i = paramInputStream.available();
          l1 = i;
        }
        if (l1 == 0L) {
          return null;
        }
        paramInputStream = sysGetStremMd5(paramInputStream, l1);
        if (paramInputStream != null)
        {
          this.digest = paramInputStream;
          return this.digest;
        }
        return this.digest;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (paramInputStream != null) {
          try
          {
            paramInputStream.close();
            return null;
          }
          catch (IOException paramInputStream)
          {
            paramInputStream.printStackTrace();
          }
        }
      }
    }
    return null;
  }
  
  public byte[] getMD5(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte != null) && (paramInt2 != 0) && (paramInt1 >= 0))
    {
      paramArrayOfByte = sysGetBufferMd5(paramArrayOfByte, paramInt1, paramInt2);
      if (paramArrayOfByte != null)
      {
        this.digest = paramArrayOfByte;
        return this.digest;
      }
      return this.digest;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.utils.MD5Utils
 * JD-Core Version:    0.7.0.1
 */