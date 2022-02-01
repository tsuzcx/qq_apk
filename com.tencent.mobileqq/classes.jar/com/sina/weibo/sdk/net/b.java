package com.sina.weibo.sdk.net;

import android.os.Bundle;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Set;

public final class b
  implements a
{
  private static void a(OutputStream paramOutputStream, d paramd)
  {
    Bundle localBundle = paramd.h();
    paramd = new StringBuilder();
    Iterator localIterator = localBundle.keySet().iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (i != 0) {
        i = 0;
      } else {
        paramd.append("&");
      }
      String str2 = String.valueOf(localBundle.get(str1));
      try
      {
        paramd.append(URLEncoder.encode(str1, "UTF-8"));
        paramd.append("=");
        paramd.append(URLEncoder.encode(str2, "UTF-8"));
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    try
    {
      paramOutputStream = new DataOutputStream(paramOutputStream);
      paramOutputStream.write(paramd.toString().getBytes("UTF-8"));
      paramOutputStream.close();
      return;
    }
    catch (IOException paramOutputStream)
    {
      paramOutputStream.printStackTrace();
    }
  }
  
  private static void a(HttpURLConnection paramHttpURLConnection, Bundle paramBundle)
  {
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramHttpURLConnection.addRequestProperty(str, String.valueOf(paramBundle.get(str)));
    }
  }
  
  /* Error */
  public final f a(d paramd)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 111 1 0
    //   6: astore 5
    //   8: aload_1
    //   9: invokeinterface 114 1 0
    //   14: astore 6
    //   16: aload 5
    //   18: astore 4
    //   20: aload 6
    //   22: ifnull +135 -> 157
    //   25: aload 5
    //   27: astore 4
    //   29: aload 6
    //   31: invokevirtual 118	android/os/Bundle:size	()I
    //   34: ifeq +123 -> 157
    //   37: aload 5
    //   39: astore 4
    //   41: aload 5
    //   43: invokestatic 124	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   46: ifne +111 -> 157
    //   49: aload 5
    //   51: invokestatic 130	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   54: astore 4
    //   56: aload 4
    //   58: astore_3
    //   59: aload 6
    //   61: ifnull +82 -> 143
    //   64: aload 6
    //   66: invokevirtual 132	android/os/Bundle:isEmpty	()Z
    //   69: ifeq +9 -> 78
    //   72: aload 4
    //   74: astore_3
    //   75: goto +68 -> 143
    //   78: aload 4
    //   80: invokevirtual 136	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   83: astore_3
    //   84: aload 6
    //   86: invokevirtual 32	android/os/Bundle:keySet	()Ljava/util/Set;
    //   89: invokeinterface 38 1 0
    //   94: astore 4
    //   96: aload 4
    //   98: invokeinterface 44 1 0
    //   103: ifeq +35 -> 138
    //   106: aload 4
    //   108: invokeinterface 48 1 0
    //   113: checkcast 50	java/lang/String
    //   116: astore 7
    //   118: aload_3
    //   119: aload 7
    //   121: aload 6
    //   123: aload 7
    //   125: invokevirtual 60	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   128: invokestatic 64	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   131: invokevirtual 142	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   134: pop
    //   135: goto -39 -> 96
    //   138: aload_3
    //   139: invokevirtual 146	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   142: astore_3
    //   143: aload 5
    //   145: astore 4
    //   147: aload_3
    //   148: ifnull +9 -> 157
    //   151: aload_3
    //   152: invokevirtual 147	android/net/Uri:toString	()Ljava/lang/String;
    //   155: astore 4
    //   157: new 149	java/net/URL
    //   160: dup
    //   161: aload 4
    //   163: invokespecial 152	java/net/URL:<init>	(Ljava/lang/String;)V
    //   166: invokevirtual 156	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   169: checkcast 101	java/net/HttpURLConnection
    //   172: astore_3
    //   173: aload_3
    //   174: ldc 158
    //   176: invokevirtual 161	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   179: aload_3
    //   180: ldc 163
    //   182: ldc 165
    //   184: invokevirtual 168	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: aload_3
    //   188: ldc 170
    //   190: ldc 66
    //   192: invokevirtual 168	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   195: new 28	android/os/Bundle
    //   198: dup
    //   199: invokespecial 171	android/os/Bundle:<init>	()V
    //   202: astore 4
    //   204: aload 4
    //   206: ldc 173
    //   208: ldc 175
    //   210: invokevirtual 178	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: aload_3
    //   214: aload 4
    //   216: invokestatic 180	com/sina/weibo/sdk/net/b:a	(Ljava/net/HttpURLConnection;Landroid/os/Bundle;)V
    //   219: aload_3
    //   220: iconst_1
    //   221: invokevirtual 184	java/net/HttpURLConnection:setDoInput	(Z)V
    //   224: aload_3
    //   225: iconst_1
    //   226: invokevirtual 187	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   229: aload_3
    //   230: iconst_0
    //   231: invokevirtual 190	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   234: aload_3
    //   235: aload_1
    //   236: invokeinterface 193 1 0
    //   241: invokevirtual 197	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   244: aload_3
    //   245: aload_1
    //   246: invokeinterface 200 1 0
    //   251: invokevirtual 203	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   254: aload_3
    //   255: invokevirtual 206	java/net/HttpURLConnection:connect	()V
    //   258: aload_3
    //   259: invokevirtual 210	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   262: aload_1
    //   263: invokestatic 212	com/sina/weibo/sdk/net/b:a	(Ljava/io/OutputStream;Lcom/sina/weibo/sdk/net/d;)V
    //   266: aload_3
    //   267: invokevirtual 215	java/net/HttpURLConnection:getResponseCode	()I
    //   270: istore_2
    //   271: iload_2
    //   272: sipush 200
    //   275: if_icmpne +11 -> 286
    //   278: aload_3
    //   279: invokevirtual 219	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   282: astore_1
    //   283: goto +8 -> 291
    //   286: aload_3
    //   287: invokevirtual 222	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   290: astore_1
    //   291: new 224	com/sina/weibo/sdk/net/g
    //   294: dup
    //   295: iload_2
    //   296: aload_1
    //   297: invokespecial 227	com/sina/weibo/sdk/net/g:<init>	(ILjava/io/InputStream;)V
    //   300: astore_1
    //   301: aload_3
    //   302: ifnull +7 -> 309
    //   305: aload_3
    //   306: invokevirtual 230	java/net/HttpURLConnection:disconnect	()V
    //   309: aload_1
    //   310: areturn
    //   311: astore_1
    //   312: goto +16 -> 328
    //   315: astore_1
    //   316: new 232	java/lang/Throwable
    //   319: dup
    //   320: aload_1
    //   321: invokevirtual 235	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   324: invokespecial 236	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   327: athrow
    //   328: aload_3
    //   329: ifnull +7 -> 336
    //   332: aload_3
    //   333: invokevirtual 230	java/net/HttpURLConnection:disconnect	()V
    //   336: goto +5 -> 341
    //   339: aload_1
    //   340: athrow
    //   341: goto -2 -> 339
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	this	b
    //   0	344	1	paramd	d
    //   270	26	2	i	int
    //   58	275	3	localObject1	Object
    //   18	197	4	localObject2	Object
    //   6	138	5	str1	String
    //   14	108	6	localBundle	Bundle
    //   116	8	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   173	271	311	finally
    //   278	283	311	finally
    //   286	291	311	finally
    //   291	301	311	finally
    //   316	328	311	finally
    //   173	271	315	java/lang/Exception
    //   278	283	315	java/lang/Exception
    //   286	291	315	java/lang/Exception
    //   291	301	315	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.net.b
 * JD-Core Version:    0.7.0.1
 */