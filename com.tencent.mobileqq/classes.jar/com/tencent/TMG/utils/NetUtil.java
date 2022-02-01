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
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: new 49	java/net/URL
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 52	java/net/URL:<init>	(Ljava/lang/String;)V
    //   17: invokevirtual 56	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   20: checkcast 58	java/net/HttpURLConnection
    //   23: astore_3
    //   24: aload_3
    //   25: astore_2
    //   26: aload_3
    //   27: ldc 60
    //   29: invokevirtual 63	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   32: aload_3
    //   33: astore_2
    //   34: aload_3
    //   35: sipush 5000
    //   38: invokevirtual 67	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   41: aload_3
    //   42: astore_2
    //   43: aload_3
    //   44: sipush 10000
    //   47: invokevirtual 70	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   50: aload_3
    //   51: astore_2
    //   52: aload_3
    //   53: iconst_1
    //   54: invokevirtual 74	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   57: aload_3
    //   58: astore_2
    //   59: aload_3
    //   60: invokevirtual 78	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   63: astore_0
    //   64: aload_3
    //   65: astore_2
    //   66: aload_0
    //   67: aload_1
    //   68: invokevirtual 84	java/lang/String:getBytes	()[B
    //   71: invokevirtual 89	java/io/OutputStream:write	([B)V
    //   74: aload_3
    //   75: astore_2
    //   76: aload_0
    //   77: invokevirtual 92	java/io/OutputStream:flush	()V
    //   80: aload_3
    //   81: astore_2
    //   82: aload_0
    //   83: invokevirtual 93	java/io/OutputStream:close	()V
    //   86: aload 6
    //   88: astore_0
    //   89: aload_3
    //   90: astore_2
    //   91: aload_3
    //   92: invokevirtual 97	java/net/HttpURLConnection:getResponseCode	()I
    //   95: sipush 200
    //   98: if_icmpne +13 -> 111
    //   101: aload_3
    //   102: astore_2
    //   103: aload_3
    //   104: invokevirtual 101	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   107: invokestatic 103	com/tencent/TMG/utils/NetUtil:getStringFromInputStream	(Ljava/io/InputStream;)Ljava/lang/String;
    //   110: astore_0
    //   111: aload_0
    //   112: astore_1
    //   113: aload_3
    //   114: ifnull +47 -> 161
    //   117: aload_0
    //   118: astore_1
    //   119: aload_3
    //   120: invokevirtual 106	java/net/HttpURLConnection:disconnect	()V
    //   123: aload_1
    //   124: areturn
    //   125: astore_1
    //   126: aload_3
    //   127: astore_0
    //   128: goto +12 -> 140
    //   131: astore_0
    //   132: aconst_null
    //   133: astore_2
    //   134: goto +30 -> 164
    //   137: astore_1
    //   138: aconst_null
    //   139: astore_0
    //   140: aload_0
    //   141: astore_2
    //   142: aload_1
    //   143: invokevirtual 109	java/lang/Exception:printStackTrace	()V
    //   146: aload 5
    //   148: astore_1
    //   149: aload_0
    //   150: ifnull +11 -> 161
    //   153: aload 4
    //   155: astore_1
    //   156: aload_0
    //   157: astore_3
    //   158: goto -39 -> 119
    //   161: aload_1
    //   162: areturn
    //   163: astore_0
    //   164: aload_2
    //   165: ifnull +7 -> 172
    //   168: aload_2
    //   169: invokevirtual 106	java/net/HttpURLConnection:disconnect	()V
    //   172: goto +5 -> 177
    //   175: aload_0
    //   176: athrow
    //   177: goto -2 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	paramString1	String
    //   0	180	1	paramString2	String
    //   25	144	2	localObject1	Object
    //   23	135	3	localObject2	Object
    //   1	153	4	localObject3	Object
    //   4	143	5	localObject4	Object
    //   7	80	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   26	32	125	java/lang/Exception
    //   34	41	125	java/lang/Exception
    //   43	50	125	java/lang/Exception
    //   52	57	125	java/lang/Exception
    //   59	64	125	java/lang/Exception
    //   66	74	125	java/lang/Exception
    //   76	80	125	java/lang/Exception
    //   82	86	125	java/lang/Exception
    //   91	101	125	java/lang/Exception
    //   103	111	125	java/lang/Exception
    //   9	24	131	finally
    //   9	24	137	java/lang/Exception
    //   26	32	163	finally
    //   34	41	163	finally
    //   43	50	163	finally
    //   52	57	163	finally
    //   59	64	163	finally
    //   66	74	163	finally
    //   76	80	163	finally
    //   82	86	163	finally
    //   91	101	163	finally
    //   103	111	163	finally
    //   142	146	163	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.utils.NetUtil
 * JD-Core Version:    0.7.0.1
 */