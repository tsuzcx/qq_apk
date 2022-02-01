package com.tencent.TMG.utils;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class NetUtil
{
  private static final boolean DEBUG = true;
  
  public static void debugInfo(String paramString1, String paramString2)
  {
    Log.d(paramString1, paramString2);
  }
  
  private static String getStringFromInputStream(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    paramInputStream.close();
    paramInputStream = localByteArrayOutputStream.toString();
    localByteArrayOutputStream.close();
    return paramInputStream;
  }
  
  /* Error */
  public static String post(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 49	java/net/URL
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 52	java/net/URL:<init>	(Ljava/lang/String;)V
    //   12: invokevirtual 56	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   15: checkcast 58	java/net/HttpURLConnection
    //   18: astore_0
    //   19: aload_0
    //   20: ldc 60
    //   22: invokevirtual 63	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   25: aload_0
    //   26: sipush 5000
    //   29: invokevirtual 67	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   32: aload_0
    //   33: sipush 10000
    //   36: invokevirtual 70	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   39: aload_0
    //   40: iconst_1
    //   41: invokevirtual 74	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   44: aload_0
    //   45: invokevirtual 78	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   48: astore_3
    //   49: aload_3
    //   50: aload_1
    //   51: invokevirtual 84	java/lang/String:getBytes	()[B
    //   54: invokevirtual 89	java/io/OutputStream:write	([B)V
    //   57: aload_3
    //   58: invokevirtual 92	java/io/OutputStream:flush	()V
    //   61: aload_3
    //   62: invokevirtual 93	java/io/OutputStream:close	()V
    //   65: aload_2
    //   66: astore_1
    //   67: aload_0
    //   68: invokevirtual 97	java/net/HttpURLConnection:getResponseCode	()I
    //   71: sipush 200
    //   74: if_icmpne +11 -> 85
    //   77: aload_0
    //   78: invokevirtual 101	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   81: invokestatic 103	com/tencent/TMG/utils/NetUtil:getStringFromInputStream	(Ljava/io/InputStream;)Ljava/lang/String;
    //   84: astore_1
    //   85: aload_0
    //   86: ifnull +61 -> 147
    //   89: aload_0
    //   90: invokevirtual 106	java/net/HttpURLConnection:disconnect	()V
    //   93: aload_1
    //   94: areturn
    //   95: astore_1
    //   96: aconst_null
    //   97: astore_0
    //   98: aload_1
    //   99: invokevirtual 109	java/lang/Exception:printStackTrace	()V
    //   102: aload_0
    //   103: ifnull +42 -> 145
    //   106: aload_0
    //   107: invokevirtual 106	java/net/HttpURLConnection:disconnect	()V
    //   110: aconst_null
    //   111: areturn
    //   112: astore_0
    //   113: aload_3
    //   114: astore_1
    //   115: aload_1
    //   116: ifnull +7 -> 123
    //   119: aload_1
    //   120: invokevirtual 106	java/net/HttpURLConnection:disconnect	()V
    //   123: aload_0
    //   124: athrow
    //   125: astore_2
    //   126: aload_0
    //   127: astore_1
    //   128: aload_2
    //   129: astore_0
    //   130: goto -15 -> 115
    //   133: astore_2
    //   134: aload_0
    //   135: astore_1
    //   136: aload_2
    //   137: astore_0
    //   138: goto -23 -> 115
    //   141: astore_1
    //   142: goto -44 -> 98
    //   145: aconst_null
    //   146: areturn
    //   147: aload_1
    //   148: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	paramString1	String
    //   0	149	1	paramString2	String
    //   3	63	2	localObject1	Object
    //   125	4	2	localObject2	Object
    //   133	4	2	localObject3	Object
    //   1	113	3	localOutputStream	java.io.OutputStream
    // Exception table:
    //   from	to	target	type
    //   4	19	95	java/lang/Exception
    //   4	19	112	finally
    //   19	65	125	finally
    //   67	85	125	finally
    //   98	102	133	finally
    //   19	65	141	java/lang/Exception
    //   67	85	141	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.utils.NetUtil
 * JD-Core Version:    0.7.0.1
 */