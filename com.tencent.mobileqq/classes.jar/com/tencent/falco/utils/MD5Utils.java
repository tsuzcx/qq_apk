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
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return null;
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
    //   1: astore 10
    //   3: aload 10
    //   5: astore 7
    //   7: aload_0
    //   8: ifnull +24 -> 32
    //   11: aload 10
    //   13: astore 7
    //   15: aload_0
    //   16: invokevirtual 51	java/lang/String:length	()I
    //   19: ifeq +13 -> 32
    //   22: lload_1
    //   23: lconst_0
    //   24: lcmp
    //   25: ifge +10 -> 35
    //   28: aload 10
    //   30: astore 7
    //   32: aload 7
    //   34: areturn
    //   35: new 91	java/io/FileInputStream
    //   38: dup
    //   39: aload_0
    //   40: invokespecial 92	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   43: astore 8
    //   45: aload 8
    //   47: astore 7
    //   49: new 53	java/io/File
    //   52: dup
    //   53: aload_0
    //   54: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
    //   57: astore_0
    //   58: aload 8
    //   60: astore 7
    //   62: aload_0
    //   63: invokevirtual 60	java/io/File:exists	()Z
    //   66: ifeq +66 -> 132
    //   69: aload 8
    //   71: astore 7
    //   73: aload_0
    //   74: invokevirtual 63	java/io/File:length	()J
    //   77: lstore 5
    //   79: lload_1
    //   80: lconst_0
    //   81: lcmp
    //   82: ifeq +144 -> 226
    //   85: lload_1
    //   86: lstore_3
    //   87: lload 5
    //   89: lload_1
    //   90: lcmp
    //   91: ifge +6 -> 97
    //   94: goto +132 -> 226
    //   97: aload 8
    //   99: astore 7
    //   101: aload 8
    //   103: lload_3
    //   104: invokestatic 96	com/tencent/falco/utils/MD5Utils:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   107: astore_0
    //   108: aload_0
    //   109: astore 7
    //   111: aload 8
    //   113: ifnull -81 -> 32
    //   116: aload 8
    //   118: invokevirtual 99	java/io/FileInputStream:close	()V
    //   121: aload_0
    //   122: areturn
    //   123: astore 7
    //   125: aload 7
    //   127: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   130: aload_0
    //   131: areturn
    //   132: aload 10
    //   134: astore 7
    //   136: aload 8
    //   138: ifnull -106 -> 32
    //   141: aload 8
    //   143: invokevirtual 99	java/io/FileInputStream:close	()V
    //   146: aconst_null
    //   147: areturn
    //   148: astore_0
    //   149: aload_0
    //   150: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   153: aconst_null
    //   154: areturn
    //   155: astore 9
    //   157: aconst_null
    //   158: astore_0
    //   159: aload_0
    //   160: astore 7
    //   162: aload 9
    //   164: invokevirtual 70	java/lang/Exception:printStackTrace	()V
    //   167: aload 10
    //   169: astore 7
    //   171: aload_0
    //   172: ifnull -140 -> 32
    //   175: aload_0
    //   176: invokevirtual 99	java/io/FileInputStream:close	()V
    //   179: aconst_null
    //   180: areturn
    //   181: astore_0
    //   182: aload_0
    //   183: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   186: aconst_null
    //   187: areturn
    //   188: astore_0
    //   189: aconst_null
    //   190: astore 7
    //   192: aload 7
    //   194: ifnull +8 -> 202
    //   197: aload 7
    //   199: invokevirtual 99	java/io/FileInputStream:close	()V
    //   202: aload_0
    //   203: athrow
    //   204: astore 7
    //   206: aload 7
    //   208: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   211: goto -9 -> 202
    //   214: astore_0
    //   215: goto -23 -> 192
    //   218: astore 9
    //   220: aload 8
    //   222: astore_0
    //   223: goto -64 -> 159
    //   226: lload 5
    //   228: lstore_3
    //   229: goto -132 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	paramString	String
    //   0	232	1	paramLong	long
    //   86	143	3	l1	long
    //   77	150	5	l2	long
    //   5	105	7	localObject1	Object
    //   123	3	7	localIOException1	IOException
    //   134	64	7	localObject2	Object
    //   204	3	7	localIOException2	IOException
    //   43	178	8	localFileInputStream	java.io.FileInputStream
    //   155	8	9	localException1	Exception
    //   218	1	9	localException2	Exception
    //   1	167	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   116	121	123	java/io/IOException
    //   141	146	148	java/io/IOException
    //   35	45	155	java/lang/Exception
    //   175	179	181	java/io/IOException
    //   35	45	188	finally
    //   197	202	204	java/io/IOException
    //   49	58	214	finally
    //   62	69	214	finally
    //   73	79	214	finally
    //   101	108	214	finally
    //   162	167	214	finally
    //   49	58	218	java/lang/Exception
    //   62	69	218	java/lang/Exception
    //   73	79	218	java/lang/Exception
    //   101	108	218	java/lang/Exception
  }
  
  public static byte[] sysGetBufferMd5(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte == null) || (paramInt2 == 0)) {
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
    return null;
  }
  
  /* Error */
  public static byte[] sysGetStremMd5(InputStream paramInputStream, long paramLong)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 4
    //   3: aload_0
    //   4: ifnull +9 -> 13
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
    //   115: aload 6
    //   117: invokevirtual 120	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   120: aload_0
    //   121: invokestatic 134	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   124: aconst_null
    //   125: areturn
    //   126: astore 6
    //   128: aload 6
    //   130: invokevirtual 100	java/io/IOException:printStackTrace	()V
    //   133: aload_0
    //   134: invokestatic 134	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   137: aconst_null
    //   138: areturn
    //   139: astore 6
    //   141: aload_0
    //   142: invokestatic 134	com/tencent/falco/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   145: aload 6
    //   147: athrow
    //   148: astore 7
    //   150: goto -51 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramInputStream	InputStream
    //   0	153	1	paramLong	long
    //   31	57	3	i	int
    //   1	90	4	l	long
    //   20	91	6	localObject1	Object
    //   113	3	6	localNoSuchAlgorithmException	NoSuchAlgorithmException
    //   126	3	6	localIOException	IOException
    //   139	7	6	localObject2	Object
    //   26	53	7	arrayOfByte	byte[]
    //   148	1	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   15	32	113	java/security/NoSuchAlgorithmException
    //   39	51	113	java/security/NoSuchAlgorithmException
    //   57	66	113	java/security/NoSuchAlgorithmException
    //   76	85	113	java/security/NoSuchAlgorithmException
    //   95	99	113	java/security/NoSuchAlgorithmException
    //   99	106	113	java/security/NoSuchAlgorithmException
    //   15	32	126	java/io/IOException
    //   39	51	126	java/io/IOException
    //   57	66	126	java/io/IOException
    //   76	85	126	java/io/IOException
    //   95	99	126	java/io/IOException
    //   99	106	126	java/io/IOException
    //   15	32	139	finally
    //   39	51	139	finally
    //   57	66	139	finally
    //   76	85	139	finally
    //   95	99	139	finally
    //   99	106	139	finally
    //   115	120	139	finally
    //   128	133	139	finally
    //   95	99	148	java/lang/Exception
  }
  
  public static String toMD5(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      paramString = null;
    }
    do
    {
      return paramString;
      try
      {
        localObject = paramString.getBytes("ISO8859_1");
        paramString = (String)localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          Object localObject;
          byte[] arrayOfByte;
          paramString = paramString.getBytes();
        }
      }
      arrayOfByte = new MD5Utils().getMD5(paramString, 0, paramString.length);
      localObject = "";
      paramString = (String)localObject;
    } while (arrayOfByte == null);
    for (;;)
    {
      paramString = (String)localObject;
      if (i >= 16) {
        break;
      }
      localObject = (String)localObject + byteHEX(arrayOfByte[i]);
      i += 1;
    }
  }
  
  public static String toMD5(byte[] paramArrayOfByte)
  {
    Object localObject;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      localObject = null;
      return localObject;
    }
    byte[] arrayOfByte = new MD5Utils().getMD5(paramArrayOfByte, 0, paramArrayOfByte.length);
    paramArrayOfByte = "";
    int i = 0;
    for (;;)
    {
      localObject = paramArrayOfByte;
      if (i >= 16) {
        break;
      }
      paramArrayOfByte = paramArrayOfByte + byteHEX(arrayOfByte[i]);
      i += 1;
    }
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
      for (;;)
      {
        paramString = paramString.getBytes();
      }
    }
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
    if ((paramInputStream == null) || (paramLong < 0L)) {}
    do
    {
      for (;;)
      {
        return null;
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
          if (l1 != 0L)
          {
            paramInputStream = sysGetStremMd5(paramInputStream, l1);
            if (paramInputStream == null) {
              break label111;
            }
            this.digest = paramInputStream;
            return this.digest;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    } while (paramInputStream == null);
    try
    {
      paramInputStream.close();
      return null;
    }
    catch (IOException paramInputStream)
    {
      paramInputStream.printStackTrace();
      return null;
    }
    label111:
    return this.digest;
  }
  
  public byte[] getMD5(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte == null) || (paramInt2 == 0) || (paramInt1 < 0)) {
      return null;
    }
    paramArrayOfByte = sysGetBufferMd5(paramArrayOfByte, paramInt1, paramInt2);
    if (paramArrayOfByte != null)
    {
      this.digest = paramArrayOfByte;
      return this.digest;
    }
    return this.digest;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.utils.MD5Utils
 * JD-Core Version:    0.7.0.1
 */