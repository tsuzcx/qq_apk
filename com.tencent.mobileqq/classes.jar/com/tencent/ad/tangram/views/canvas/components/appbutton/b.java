package com.tencent.ad.tangram.views.canvas.components.appbutton;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class b
{
  private static final String APP_DATA_INFO_DOMAIN = "https://h5.gdt.qq.com/player/openapp/";
  private static final String APP_DATA_INFO_DOMAIN_ROOT = "https://h5.gdt.qq.com";
  
  private static String converStreamToString(InputStream paramInputStream)
  {
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuffer localStringBuffer = new StringBuffer();
    for (;;)
    {
      String str = paramInputStream.readLine();
      if (str == null) {
        break;
      }
      localStringBuffer.append(str);
    }
    return localStringBuffer.toString();
  }
  
  /* Error */
  public static AdAppBtnData loadGdtAppBtnData(String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 52	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore_3
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore 6
    //   11: aconst_null
    //   12: astore 7
    //   14: iload_3
    //   15: ifeq +5 -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: new 54	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   27: astore 4
    //   29: aload 4
    //   31: ldc 57
    //   33: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 4
    //   39: aload_0
    //   40: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload 4
    //   46: ldc 62
    //   48: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload 4
    //   54: aload_1
    //   55: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload 4
    //   61: ldc 64
    //   63: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload 4
    //   69: iload_2
    //   70: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: ldc 69
    //   76: aload 4
    //   78: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 76	com/tencent/ad/tangram/log/AdLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: new 54	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   91: astore 4
    //   93: aload 4
    //   95: ldc 8
    //   97: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload 4
    //   103: aload_0
    //   104: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 4
    //   110: ldc 78
    //   112: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 4
    //   118: aload_1
    //   119: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload 4
    //   125: ldc 80
    //   127: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload 4
    //   133: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: astore_0
    //   137: new 54	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   144: astore_1
    //   145: aload_1
    //   146: ldc 82
    //   148: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload_1
    //   153: aload_0
    //   154: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: ldc 69
    //   160: aload_1
    //   161: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 76	com/tencent/ad/tangram/log/AdLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   167: new 84	java/net/URL
    //   170: dup
    //   171: aload_0
    //   172: invokespecial 87	java/net/URL:<init>	(Ljava/lang/String;)V
    //   175: invokevirtual 91	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   178: checkcast 93	java/net/HttpURLConnection
    //   181: astore 4
    //   183: aload 4
    //   185: astore_1
    //   186: aload 4
    //   188: ldc 95
    //   190: invokevirtual 98	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   193: aload 4
    //   195: astore_1
    //   196: aload 4
    //   198: ldc 100
    //   200: ldc 102
    //   202: invokevirtual 105	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   205: aload 4
    //   207: astore_1
    //   208: aload 4
    //   210: ldc 107
    //   212: ldc 109
    //   214: invokevirtual 105	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   217: aload 4
    //   219: astore_1
    //   220: aload 4
    //   222: ldc 111
    //   224: ldc 11
    //   226: invokevirtual 105	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: aload 4
    //   231: astore_1
    //   232: aload 4
    //   234: sipush 3000
    //   237: invokevirtual 115	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   240: aload 4
    //   242: astore_1
    //   243: aload 4
    //   245: sipush 3000
    //   248: invokevirtual 118	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   251: aload 4
    //   253: astore_1
    //   254: aload 4
    //   256: invokevirtual 122	java/net/HttpURLConnection:getResponseCode	()I
    //   259: sipush 200
    //   262: if_icmpne +59 -> 321
    //   265: aload 4
    //   267: astore_1
    //   268: aload 4
    //   270: invokevirtual 126	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   273: invokestatic 128	com/tencent/ad/tangram/views/canvas/components/appbutton/b:converStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   276: astore_0
    //   277: aload 4
    //   279: astore_1
    //   280: aload_0
    //   281: invokestatic 52	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   284: ifne +21 -> 305
    //   287: aload 4
    //   289: astore_1
    //   290: new 130	org/json/JSONObject
    //   293: dup
    //   294: aload_0
    //   295: invokespecial 131	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   298: invokestatic 137	com/tencent/ad/tangram/views/canvas/components/appbutton/AdAppBtnData:parseJson	(Lorg/json/JSONObject;)Lcom/tencent/ad/tangram/views/canvas/components/appbutton/AdAppBtnData;
    //   301: astore_0
    //   302: goto +32 -> 334
    //   305: aload 4
    //   307: astore_1
    //   308: ldc 69
    //   310: ldc 139
    //   312: invokestatic 142	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   315: aload 7
    //   317: astore_0
    //   318: goto +16 -> 334
    //   321: aload 4
    //   323: astore_1
    //   324: ldc 69
    //   326: ldc 144
    //   328: invokestatic 142	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   331: aload 7
    //   333: astore_0
    //   334: aload_0
    //   335: astore_1
    //   336: aload 4
    //   338: ifnull +59 -> 397
    //   341: aload_0
    //   342: astore_1
    //   343: aload 4
    //   345: invokevirtual 147	java/net/HttpURLConnection:disconnect	()V
    //   348: aload_1
    //   349: areturn
    //   350: astore_1
    //   351: aload 4
    //   353: astore_0
    //   354: aload_1
    //   355: astore 4
    //   357: goto +13 -> 370
    //   360: astore_0
    //   361: aconst_null
    //   362: astore_1
    //   363: goto +37 -> 400
    //   366: astore 4
    //   368: aconst_null
    //   369: astore_0
    //   370: aload_0
    //   371: astore_1
    //   372: ldc 69
    //   374: ldc 149
    //   376: aload 4
    //   378: invokestatic 152	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   381: aload 6
    //   383: astore_1
    //   384: aload_0
    //   385: ifnull +12 -> 397
    //   388: aload 5
    //   390: astore_1
    //   391: aload_0
    //   392: astore 4
    //   394: goto -51 -> 343
    //   397: aload_1
    //   398: areturn
    //   399: astore_0
    //   400: aload_1
    //   401: ifnull +7 -> 408
    //   404: aload_1
    //   405: invokevirtual 147	java/net/HttpURLConnection:disconnect	()V
    //   408: goto +5 -> 413
    //   411: aload_0
    //   412: athrow
    //   413: goto -2 -> 411
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	416	0	paramString1	String
    //   0	416	1	paramString2	String
    //   0	416	2	paramInt	int
    //   4	11	3	bool	boolean
    //   27	329	4	localObject1	Object
    //   366	11	4	localException	java.lang.Exception
    //   392	1	4	str	String
    //   6	383	5	localObject2	Object
    //   9	373	6	localObject3	Object
    //   12	320	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   186	193	350	java/lang/Exception
    //   196	205	350	java/lang/Exception
    //   208	217	350	java/lang/Exception
    //   220	229	350	java/lang/Exception
    //   232	240	350	java/lang/Exception
    //   243	251	350	java/lang/Exception
    //   254	265	350	java/lang/Exception
    //   268	277	350	java/lang/Exception
    //   280	287	350	java/lang/Exception
    //   290	302	350	java/lang/Exception
    //   308	315	350	java/lang/Exception
    //   324	331	350	java/lang/Exception
    //   167	183	360	finally
    //   167	183	366	java/lang/Exception
    //   186	193	399	finally
    //   196	205	399	finally
    //   208	217	399	finally
    //   220	229	399	finally
    //   232	240	399	finally
    //   243	251	399	finally
    //   254	265	399	finally
    //   268	277	399	finally
    //   280	287	399	finally
    //   290	302	399	finally
    //   308	315	399	finally
    //   324	331	399	finally
    //   372	381	399	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.components.appbutton.b
 * JD-Core Version:    0.7.0.1
 */