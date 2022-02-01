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
    if (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (i != 0) {
        i = 0;
      }
      for (;;)
      {
        for (;;)
        {
          String str2 = String.valueOf(localBundle.get(str1));
          try
          {
            paramd.append(URLEncoder.encode(str1, "UTF-8")).append("=").append(URLEncoder.encode(str2, "UTF-8"));
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            localUnsupportedEncodingException.printStackTrace();
          }
        }
        break;
        paramd.append("&");
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
    //   6: astore_3
    //   7: aload_1
    //   8: invokeinterface 114 1 0
    //   13: astore 6
    //   15: aload_3
    //   16: astore 4
    //   18: aload 6
    //   20: ifnull +62 -> 82
    //   23: aload_3
    //   24: astore 4
    //   26: aload 6
    //   28: invokevirtual 118	android/os/Bundle:size	()I
    //   31: ifeq +51 -> 82
    //   34: aload_3
    //   35: invokestatic 124	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   38: ifne +262 -> 300
    //   41: aload_3
    //   42: invokestatic 130	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   45: astore 5
    //   47: aload 5
    //   49: astore 4
    //   51: aload 6
    //   53: ifnull +15 -> 68
    //   56: aload 6
    //   58: invokevirtual 132	android/os/Bundle:isEmpty	()Z
    //   61: ifeq +167 -> 228
    //   64: aload 5
    //   66: astore 4
    //   68: aload 4
    //   70: ifnull +230 -> 300
    //   73: aload 4
    //   75: invokevirtual 133	android/net/Uri:toString	()Ljava/lang/String;
    //   78: astore_3
    //   79: aload_3
    //   80: astore 4
    //   82: new 135	java/net/URL
    //   85: dup
    //   86: aload 4
    //   88: invokespecial 138	java/net/URL:<init>	(Ljava/lang/String;)V
    //   91: invokevirtual 142	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   94: checkcast 101	java/net/HttpURLConnection
    //   97: astore_3
    //   98: aload_3
    //   99: ldc 144
    //   101: invokevirtual 147	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   104: aload_3
    //   105: ldc 149
    //   107: ldc 151
    //   109: invokevirtual 154	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: aload_3
    //   113: ldc 156
    //   115: ldc 60
    //   117: invokevirtual 154	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: new 28	android/os/Bundle
    //   123: dup
    //   124: invokespecial 157	android/os/Bundle:<init>	()V
    //   127: astore 4
    //   129: aload 4
    //   131: ldc 159
    //   133: ldc 161
    //   135: invokevirtual 164	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: aload_3
    //   139: aload 4
    //   141: invokestatic 166	com/sina/weibo/sdk/net/b:a	(Ljava/net/HttpURLConnection;Landroid/os/Bundle;)V
    //   144: aload_3
    //   145: iconst_1
    //   146: invokevirtual 170	java/net/HttpURLConnection:setDoInput	(Z)V
    //   149: aload_3
    //   150: iconst_1
    //   151: invokevirtual 173	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   154: aload_3
    //   155: iconst_0
    //   156: invokevirtual 176	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   159: aload_3
    //   160: aload_1
    //   161: invokeinterface 179 1 0
    //   166: invokevirtual 183	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   169: aload_3
    //   170: aload_1
    //   171: invokeinterface 186 1 0
    //   176: invokevirtual 189	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   179: aload_3
    //   180: invokevirtual 192	java/net/HttpURLConnection:connect	()V
    //   183: aload_3
    //   184: invokevirtual 196	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   187: aload_1
    //   188: invokestatic 198	com/sina/weibo/sdk/net/b:a	(Ljava/io/OutputStream;Lcom/sina/weibo/sdk/net/d;)V
    //   191: aload_3
    //   192: invokevirtual 201	java/net/HttpURLConnection:getResponseCode	()I
    //   195: istore_2
    //   196: iload_2
    //   197: sipush 200
    //   200: if_icmpne +103 -> 303
    //   203: aload_3
    //   204: invokevirtual 205	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   207: astore_1
    //   208: new 207	com/sina/weibo/sdk/net/g
    //   211: dup
    //   212: iload_2
    //   213: aload_1
    //   214: invokespecial 210	com/sina/weibo/sdk/net/g:<init>	(ILjava/io/InputStream;)V
    //   217: astore_1
    //   218: aload_3
    //   219: ifnull +7 -> 226
    //   222: aload_3
    //   223: invokevirtual 213	java/net/HttpURLConnection:disconnect	()V
    //   226: aload_1
    //   227: areturn
    //   228: aload 5
    //   230: invokevirtual 217	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   233: astore 4
    //   235: aload 6
    //   237: invokevirtual 32	android/os/Bundle:keySet	()Ljava/util/Set;
    //   240: invokeinterface 38 1 0
    //   245: astore 5
    //   247: aload 5
    //   249: invokeinterface 44 1 0
    //   254: ifeq +36 -> 290
    //   257: aload 5
    //   259: invokeinterface 48 1 0
    //   264: checkcast 50	java/lang/String
    //   267: astore 7
    //   269: aload 4
    //   271: aload 7
    //   273: aload 6
    //   275: aload 7
    //   277: invokevirtual 54	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   280: invokestatic 58	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   283: invokevirtual 223	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   286: pop
    //   287: goto -40 -> 247
    //   290: aload 4
    //   292: invokevirtual 227	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   295: astore 4
    //   297: goto -229 -> 68
    //   300: goto -221 -> 79
    //   303: aload_3
    //   304: invokevirtual 230	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   307: astore_1
    //   308: goto -100 -> 208
    //   311: astore_1
    //   312: new 232	java/lang/Throwable
    //   315: dup
    //   316: aload_1
    //   317: invokevirtual 235	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   320: invokespecial 236	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   323: athrow
    //   324: astore_1
    //   325: aload_3
    //   326: ifnull +7 -> 333
    //   329: aload_3
    //   330: invokevirtual 213	java/net/HttpURLConnection:disconnect	()V
    //   333: aload_1
    //   334: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	335	0	this	b
    //   0	335	1	paramd	d
    //   195	18	2	i	int
    //   6	324	3	localObject1	Object
    //   16	280	4	localObject2	Object
    //   45	213	5	localObject3	Object
    //   13	261	6	localBundle	Bundle
    //   267	9	7	str	String
    // Exception table:
    //   from	to	target	type
    //   98	196	311	java/lang/Exception
    //   203	208	311	java/lang/Exception
    //   208	218	311	java/lang/Exception
    //   303	308	311	java/lang/Exception
    //   98	196	324	finally
    //   203	208	324	finally
    //   208	218	324	finally
    //   303	308	324	finally
    //   312	324	324	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.sina.weibo.sdk.net.b
 * JD-Core Version:    0.7.0.1
 */