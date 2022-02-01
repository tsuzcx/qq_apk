import android.net.Uri;
import com.tencent.mobileqq.highway.utils.BdhUtils;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;

public class bhvd
{
  private static Uri a;
  public static String a;
  public static String b = "ctwap";
  public static String c = "cmnet";
  public static String d = "cmwap";
  public static String e = "uninet";
  public static String f = "uniwap";
  public static String g = "3gnet";
  public static String h = "3gwap";
  
  static
  {
    jdField_a_of_type_AndroidNetUri = Uri.parse("content://telephony/carriers/preferapn");
    jdField_a_of_type_JavaLangString = "ctnet";
  }
  
  public static int a(byte paramByte)
  {
    return paramByte & 0xFF;
  }
  
  public static long a(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return 0L;
    }
    return ((paramArrayOfByte[paramInt] & 0xFF) << 24) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16) + ((paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8) + ((paramArrayOfByte[(paramInt + 3)] & 0xFF) << 0);
  }
  
  public static String a(long paramLong)
  {
    StringBuffer localStringBuffer = new StringBuffer(16);
    int i = 3;
    while (i >= 0)
    {
      localStringBuffer.append(0xFF & paramLong % 256L);
      paramLong /= 256L;
      if (i != 0) {
        localStringBuffer.append('.');
      }
      i -= 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramString == null) {
      return "";
    }
    paramString = paramString.toCharArray();
    int j = paramString.length;
    if (j == 0) {
      return "";
    }
    int i = 0;
    while (i < j)
    {
      if (paramString[i] == '%')
      {
        String str = String.valueOf(paramString, i + 1, 2);
        try
        {
          int k = Integer.parseInt(str, 16);
          c1 = (char)k;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            char c1 = ' ';
          }
        }
        localStringBuffer.append(c1);
        i += 3;
        continue;
      }
      localStringBuffer.append(paramString[i]);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    int i = paramString1.indexOf(paramString2, paramInt);
    if (i == -1) {
      return paramString1.substring(paramInt);
    }
    int j = paramString2.length();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramString1.substring(paramInt, i)).append(paramString3).append(a(paramString1, i + j, paramString2, paramString3));
    return localStringBuffer.toString();
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString1.length() == 0) || (paramString2.length() == 0)) {
      return "";
    }
    int i = paramString1.length();
    int j = paramString2.indexOf(paramString1 + "=");
    int k = paramString2.indexOf("&" + paramString1 + "=");
    boolean bool = paramString2.startsWith(paramString1 + "=");
    if (j != -1) {
      i = i + j + 1;
    }
    for (;;)
    {
      j = paramString2.indexOf('&', i);
      if (j != -1) {
        break label172;
      }
      return paramString2.substring(i);
      if (k != -1)
      {
        i = i + (k + 1) + 1;
      }
      else
      {
        if (!bool) {
          break;
        }
        i += 1;
      }
    }
    return "";
    label172:
    return paramString2.substring(i, j);
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length * 2);
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      int k = paramArrayOfByte[i];
      int j = (k & 0xF0) >>> 4;
      k &= 0xF;
      char c1;
      if (j > 9)
      {
        c1 = (char)(j - 10 + 65);
        label66:
        if (k <= 9) {
          break label111;
        }
      }
      label111:
      for (char c2 = (char)(k - 10 + 65);; c2 = (char)(k + 48))
      {
        localStringBuffer.append(c1).append(c2);
        i += 1;
        break;
        c1 = (char)(j + 48);
        break label66;
      }
    }
    return localStringBuffer.toString();
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return b(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static HttpURLConnection a(String paramString1, String paramString2, int paramInt)
  {
    paramString2 = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(paramString2, paramInt));
    return (HttpURLConnection)new URL(paramString1).openConnection(paramString2);
  }
  
  public static short a(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return 0;
    }
    return (short)(((paramArrayOfByte[paramInt] & 0xFF) << 8) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 0));
  }
  
  public static void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, String paramString)
  {
    a(paramInt1, paramArrayOfByte, paramInt2, paramInt3, paramString);
  }
  
  public static void a(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    int i = 0;
    try
    {
      byte[] arrayOfByte1 = new byte[paramInt2];
      byte[] arrayOfByte2 = (paramLong + "").getBytes(paramString);
      while (i < arrayOfByte1.length)
      {
        arrayOfByte1[i] = " ".getBytes(paramString)[0];
        i += 1;
      }
      a(arrayOfByte1, paramInt2 - arrayOfByte2.length, arrayOfByte2, arrayOfByte2.length);
      a(paramArrayOfByte, paramInt1, arrayOfByte1, arrayOfByte1.length);
      return;
    }
    catch (Exception paramArrayOfByte) {}
  }
  
  public static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[paramInt1] = ((byte)(paramInt2 >> 8));
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)paramInt2);
  }
  
  public static void a(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    paramArrayOfByte[paramInt] = ((byte)(int)(paramLong >> 24));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(paramLong >> 16));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(int)(paramLong >> 8));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(int)paramLong);
  }
  
  public static void a(byte[] paramArrayOfByte, int paramInt, short paramShort)
  {
    paramArrayOfByte[paramInt] = ((byte)(paramShort >> 8));
    paramArrayOfByte[(paramInt + 1)] = ((byte)paramShort);
  }
  
  public static void a(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    a(paramArrayOfByte1, paramInt1, paramArrayOfByte2, 0, paramInt2);
  }
  
  public static void a(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    System.arraycopy(paramArrayOfByte2, paramInt2, paramArrayOfByte1, paramInt1, paramInt3);
  }
  
  public static byte[] a(int paramInt)
  {
    int i = (byte)(paramInt >> 24 & 0xFF);
    int j = (byte)(paramInt >> 16 & 0xFF);
    int k = (byte)(paramInt >> 8 & 0xFF);
    return new byte[] { (byte)(paramInt & 0xFF), k, j, i };
  }
  
  public static byte[] a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = paramString.length();
    paramString = paramString.toUpperCase();
    if ((i % 2 != 0) || (i == 0)) {
      return null;
    }
    int k = i / 2;
    byte[] arrayOfByte = new byte[k];
    i = 0;
    if (i < k)
    {
      int j = paramString.charAt(i * 2);
      int m = paramString.charAt(i * 2 + 1);
      if ((j >= 48) && (j <= 57))
      {
        j = (j - 48 << 4) + 0;
        label84:
        if ((m < 48) || (m > 57)) {
          break label148;
        }
        j += m - 48;
      }
      for (;;)
      {
        arrayOfByte[i] = ((byte)j);
        i += 1;
        break;
        if ((j >= 65) && (j <= 70))
        {
          j = (j - 65 + 10 << 4) + 0;
          break label84;
        }
        return null;
        label148:
        if ((m < 65) || (m > 70)) {
          break label176;
        }
        j += m - 65 + 10;
      }
      label176:
      return null;
    }
    return arrayOfByte;
  }
  
  public static byte[] a(short paramShort)
  {
    int i = (byte)(paramShort & 0xFF);
    return new byte[] { (byte)(paramShort >> 8 & 0xFF), i };
  }
  
  public static long b(byte[] paramArrayOfByte, int paramInt)
  {
    return ((paramArrayOfByte[(paramInt + 4)] & 0xFF) << 56) + ((paramArrayOfByte[(paramInt + 5)] & 0xFF) << 48) + ((paramArrayOfByte[(paramInt + 6)] & 0xFF) << 40) + ((paramArrayOfByte[(paramInt + 7)] & 0xFF) << 32) + ((paramArrayOfByte[paramInt] & 0xFF) << 24) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16) + ((paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8) + (paramArrayOfByte[(paramInt + 3)] & 0xFF);
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return "nomatch";
      try
      {
        if (paramString.startsWith(jdField_a_of_type_JavaLangString)) {
          return jdField_a_of_type_JavaLangString;
        }
        if (paramString.startsWith(b)) {
          return b;
        }
        if (paramString.startsWith(c)) {
          return c;
        }
        if (paramString.startsWith(d)) {
          return d;
        }
        if (paramString.startsWith(e)) {
          return e;
        }
        if (paramString.startsWith(f)) {
          return f;
        }
        if (paramString.startsWith(g)) {
          return g;
        }
        if (paramString.startsWith(h))
        {
          paramString = h;
          return paramString;
        }
      }
      catch (Exception paramString) {}
    }
    return "nomatch";
  }
  
  /* Error */
  public static String b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_3
    //   8: ldc 90
    //   10: astore 4
    //   12: iload_2
    //   13: iconst_2
    //   14: iadd
    //   15: newarray byte
    //   17: astore 7
    //   19: aload 7
    //   21: iconst_0
    //   22: iload_2
    //   23: bipush 8
    //   25: ishr
    //   26: i2b
    //   27: bastore
    //   28: aload 7
    //   30: iconst_1
    //   31: iload_2
    //   32: i2b
    //   33: bastore
    //   34: aload_0
    //   35: iload_1
    //   36: aload 7
    //   38: iconst_2
    //   39: iload_2
    //   40: invokestatic 209	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   43: new 224	java/io/ByteArrayInputStream
    //   46: dup
    //   47: aload 7
    //   49: invokespecial 227	java/io/ByteArrayInputStream:<init>	([B)V
    //   52: astore_0
    //   53: new 229	java/io/DataInputStream
    //   56: dup
    //   57: aload_0
    //   58: invokespecial 232	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   61: astore_3
    //   62: aload_3
    //   63: invokevirtual 235	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   66: astore 5
    //   68: aload 5
    //   70: astore 4
    //   72: aload_3
    //   73: ifnull +7 -> 80
    //   76: aload_3
    //   77: invokevirtual 238	java/io/DataInputStream:close	()V
    //   80: aload 4
    //   82: astore_3
    //   83: aload_0
    //   84: ifnull +10 -> 94
    //   87: aload_0
    //   88: invokevirtual 239	java/io/ByteArrayInputStream:close	()V
    //   91: aload 4
    //   93: astore_3
    //   94: aload_3
    //   95: areturn
    //   96: astore_0
    //   97: aconst_null
    //   98: astore 5
    //   100: aload_3
    //   101: astore_0
    //   102: aload 5
    //   104: astore_3
    //   105: aload_3
    //   106: ifnull +7 -> 113
    //   109: aload_3
    //   110: invokevirtual 238	java/io/DataInputStream:close	()V
    //   113: aload 4
    //   115: astore_3
    //   116: aload_0
    //   117: ifnull -23 -> 94
    //   120: aload_0
    //   121: invokevirtual 239	java/io/ByteArrayInputStream:close	()V
    //   124: ldc 90
    //   126: areturn
    //   127: astore_0
    //   128: ldc 90
    //   130: areturn
    //   131: astore_0
    //   132: aconst_null
    //   133: astore_0
    //   134: aload 6
    //   136: astore_3
    //   137: aload_3
    //   138: ifnull +7 -> 145
    //   141: aload_3
    //   142: invokevirtual 238	java/io/DataInputStream:close	()V
    //   145: aload 4
    //   147: astore_3
    //   148: aload_0
    //   149: ifnull -55 -> 94
    //   152: aload_0
    //   153: invokevirtual 239	java/io/ByteArrayInputStream:close	()V
    //   156: ldc 90
    //   158: areturn
    //   159: astore_0
    //   160: ldc 90
    //   162: areturn
    //   163: astore_3
    //   164: aconst_null
    //   165: astore_0
    //   166: aload 5
    //   168: astore 4
    //   170: aload 4
    //   172: ifnull +8 -> 180
    //   175: aload 4
    //   177: invokevirtual 238	java/io/DataInputStream:close	()V
    //   180: aload_0
    //   181: ifnull +7 -> 188
    //   184: aload_0
    //   185: invokevirtual 239	java/io/ByteArrayInputStream:close	()V
    //   188: aload_3
    //   189: athrow
    //   190: astore_3
    //   191: goto -111 -> 80
    //   194: astore_0
    //   195: aload 4
    //   197: areturn
    //   198: astore_3
    //   199: goto -86 -> 113
    //   202: astore_3
    //   203: goto -58 -> 145
    //   206: astore 4
    //   208: goto -28 -> 180
    //   211: astore_0
    //   212: goto -24 -> 188
    //   215: astore_3
    //   216: aload 5
    //   218: astore 4
    //   220: goto -50 -> 170
    //   223: astore 5
    //   225: aload_3
    //   226: astore 4
    //   228: aload 5
    //   230: astore_3
    //   231: goto -61 -> 170
    //   234: astore_3
    //   235: aload 6
    //   237: astore_3
    //   238: goto -101 -> 137
    //   241: astore 5
    //   243: goto -106 -> 137
    //   246: astore_3
    //   247: aconst_null
    //   248: astore_3
    //   249: goto -144 -> 105
    //   252: astore 5
    //   254: goto -149 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	paramArrayOfByte	byte[]
    //   0	257	1	paramInt1	int
    //   0	257	2	paramInt2	int
    //   7	141	3	localObject1	Object
    //   163	26	3	localObject2	Object
    //   190	1	3	localIOException1	java.io.IOException
    //   198	1	3	localIOException2	java.io.IOException
    //   202	1	3	localIOException3	java.io.IOException
    //   215	11	3	localObject3	Object
    //   230	1	3	localObject4	Object
    //   234	1	3	localException1	Exception
    //   237	1	3	localObject5	Object
    //   246	1	3	localIOException4	java.io.IOException
    //   248	1	3	localObject6	Object
    //   10	186	4	str1	String
    //   206	1	4	localIOException5	java.io.IOException
    //   218	9	4	localObject7	Object
    //   4	213	5	str2	String
    //   223	6	5	localObject8	Object
    //   241	1	5	localException2	Exception
    //   252	1	5	localIOException6	java.io.IOException
    //   1	235	6	localObject9	Object
    //   17	31	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   12	19	96	java/io/IOException
    //   34	53	96	java/io/IOException
    //   120	124	127	java/io/IOException
    //   12	19	131	java/lang/Exception
    //   34	53	131	java/lang/Exception
    //   152	156	159	java/io/IOException
    //   12	19	163	finally
    //   34	53	163	finally
    //   76	80	190	java/io/IOException
    //   87	91	194	java/io/IOException
    //   109	113	198	java/io/IOException
    //   141	145	202	java/io/IOException
    //   175	180	206	java/io/IOException
    //   184	188	211	java/io/IOException
    //   53	62	215	finally
    //   62	68	223	finally
    //   53	62	234	java/lang/Exception
    //   62	68	241	java/lang/Exception
    //   53	62	246	java/io/IOException
    //   62	68	252	java/io/IOException
  }
  
  public static HttpURLConnection b(String paramString1, String paramString2, int paramInt)
  {
    return BdhUtils.getConnectionWithXOnlineHost(paramString1, paramString2, paramInt);
  }
  
  public static short b(byte[] paramArrayOfByte, int paramInt)
  {
    return (short)(((paramArrayOfByte[paramInt] & 0xFF) << 0) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8));
  }
  
  public static void b(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    a(paramArrayOfByte2, 0, paramArrayOfByte1, paramInt1, paramInt2);
  }
  
  public static byte[] b(int paramInt)
  {
    return new byte[] { (byte)(paramInt >> 24 & 0xFF), (byte)(paramInt >> 16 & 0xFF), (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt & 0xFF) };
  }
  
  public static byte[] c(int paramInt)
  {
    int i = (byte)(paramInt & 0xFF);
    int j = (byte)(paramInt >> 8 & 0xFF);
    int k = (byte)(paramInt >> 16 & 0xFF);
    return new byte[] { (byte)(paramInt >> 24 & 0xFF), k, j, i };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhvd
 * JD-Core Version:    0.7.0.1
 */