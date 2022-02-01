package c.t.m.sapp.c;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class p
{
  public static int a = 20000;
  
  public static byte[] a(String paramString)
  {
    try
    {
      Object localObject = new URL(paramString).openConnection();
      ((URLConnection)localObject).connect();
      paramString = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        int i = ((URLConnection)localObject).getInputStream().read(arrayOfByte);
        if (i == -1) {
          break;
        }
        paramString.write(arrayOfByte, 0, i);
      }
      localObject = paramString.toByteArray();
      paramString.close();
      return localObject;
    }
    catch (Exception paramString)
    {
      label65:
      break label65;
    }
    return null;
  }
  
  /* Error */
  public static byte[] a(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 12	java/net/URL
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 16	java/net/URL:<init>	(Ljava/lang/String;)V
    //   11: invokevirtual 20	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   14: checkcast 57	java/net/HttpURLConnection
    //   17: astore_3
    //   18: aload_3
    //   19: astore_0
    //   20: aload_3
    //   21: getstatic 59	c/t/m/sapp/c/p:a	I
    //   24: invokevirtual 63	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   27: aload_3
    //   28: astore_0
    //   29: aload_3
    //   30: getstatic 59	c/t/m/sapp/c/p:a	I
    //   33: invokevirtual 66	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   36: aload_3
    //   37: astore_0
    //   38: aload_3
    //   39: iconst_1
    //   40: invokevirtual 70	java/net/HttpURLConnection:setDoInput	(Z)V
    //   43: aload_3
    //   44: astore_0
    //   45: aload_3
    //   46: iconst_1
    //   47: invokevirtual 73	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   50: aload_3
    //   51: astore_0
    //   52: aload_3
    //   53: ldc 75
    //   55: invokevirtual 78	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   58: aload_3
    //   59: astore_0
    //   60: aload_3
    //   61: iconst_0
    //   62: invokevirtual 81	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   65: aload_3
    //   66: astore_0
    //   67: aload_3
    //   68: ldc 83
    //   70: ldc 85
    //   72: invokevirtual 89	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: aload_3
    //   76: astore_0
    //   77: aload_3
    //   78: ldc 91
    //   80: aload_1
    //   81: arraylength
    //   82: invokestatic 97	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   85: invokevirtual 89	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload_3
    //   89: astore_0
    //   90: aload_3
    //   91: invokevirtual 101	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   94: aload_1
    //   95: invokevirtual 106	java/io/OutputStream:write	([B)V
    //   98: aload_3
    //   99: astore_0
    //   100: aload_3
    //   101: invokevirtual 110	java/net/HttpURLConnection:getResponseCode	()I
    //   104: sipush 200
    //   107: if_icmpne +76 -> 183
    //   110: aload_3
    //   111: astore_0
    //   112: aload_3
    //   113: invokevirtual 111	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   116: astore_1
    //   117: aload_3
    //   118: astore_0
    //   119: new 28	java/io/ByteArrayOutputStream
    //   122: dup
    //   123: invokespecial 30	java/io/ByteArrayOutputStream:<init>	()V
    //   126: astore 4
    //   128: aload_3
    //   129: astore_0
    //   130: sipush 128
    //   133: newarray byte
    //   135: astore 5
    //   137: aload_3
    //   138: astore_0
    //   139: aload_1
    //   140: aload 5
    //   142: invokevirtual 40	java/io/InputStream:read	([B)I
    //   145: istore_2
    //   146: iload_2
    //   147: iconst_m1
    //   148: if_icmpeq +17 -> 165
    //   151: aload_3
    //   152: astore_0
    //   153: aload 4
    //   155: aload 5
    //   157: iconst_0
    //   158: iload_2
    //   159: invokevirtual 44	java/io/ByteArrayOutputStream:write	([BII)V
    //   162: goto -25 -> 137
    //   165: aload_3
    //   166: astore_0
    //   167: aload 4
    //   169: invokevirtual 48	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   172: astore_1
    //   173: aload_3
    //   174: ifnull +7 -> 181
    //   177: aload_3
    //   178: invokevirtual 114	java/net/HttpURLConnection:disconnect	()V
    //   181: aload_1
    //   182: areturn
    //   183: aload_3
    //   184: ifnull +7 -> 191
    //   187: aload_3
    //   188: invokevirtual 114	java/net/HttpURLConnection:disconnect	()V
    //   191: sipush 20000
    //   194: putstatic 59	c/t/m/sapp/c/p:a	I
    //   197: aconst_null
    //   198: areturn
    //   199: astore_1
    //   200: aload 4
    //   202: astore_0
    //   203: goto +24 -> 227
    //   206: aconst_null
    //   207: astore_1
    //   208: aload_1
    //   209: astore_0
    //   210: sipush 20000
    //   213: putstatic 59	c/t/m/sapp/c/p:a	I
    //   216: aload_1
    //   217: ifnull +7 -> 224
    //   220: aload_1
    //   221: invokevirtual 114	java/net/HttpURLConnection:disconnect	()V
    //   224: aconst_null
    //   225: areturn
    //   226: astore_1
    //   227: aload_0
    //   228: ifnull +7 -> 235
    //   231: aload_0
    //   232: invokevirtual 114	java/net/HttpURLConnection:disconnect	()V
    //   235: goto +5 -> 240
    //   238: aload_1
    //   239: athrow
    //   240: goto -2 -> 238
    //   243: astore_0
    //   244: goto -38 -> 206
    //   247: astore_0
    //   248: aload_3
    //   249: astore_1
    //   250: goto -42 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	paramString	String
    //   0	253	1	paramArrayOfByte	byte[]
    //   145	14	2	i	int
    //   17	232	3	localHttpURLConnection	java.net.HttpURLConnection
    //   1	200	4	localByteArrayOutputStream	ByteArrayOutputStream
    //   135	21	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   3	18	199	finally
    //   20	27	226	finally
    //   29	36	226	finally
    //   38	43	226	finally
    //   45	50	226	finally
    //   52	58	226	finally
    //   60	65	226	finally
    //   67	75	226	finally
    //   77	88	226	finally
    //   90	98	226	finally
    //   100	110	226	finally
    //   112	117	226	finally
    //   119	128	226	finally
    //   130	137	226	finally
    //   139	146	226	finally
    //   153	162	226	finally
    //   167	173	226	finally
    //   210	216	226	finally
    //   3	18	243	java/io/IOException
    //   20	27	247	java/io/IOException
    //   29	36	247	java/io/IOException
    //   38	43	247	java/io/IOException
    //   45	50	247	java/io/IOException
    //   52	58	247	java/io/IOException
    //   60	65	247	java/io/IOException
    //   67	75	247	java/io/IOException
    //   77	88	247	java/io/IOException
    //   90	98	247	java/io/IOException
    //   100	110	247	java/io/IOException
    //   112	117	247	java/io/IOException
    //   119	128	247	java/io/IOException
    //   130	137	247	java/io/IOException
    //   139	146	247	java/io/IOException
    //   153	162	247	java/io/IOException
    //   167	173	247	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.sapp.c.p
 * JD-Core Version:    0.7.0.1
 */