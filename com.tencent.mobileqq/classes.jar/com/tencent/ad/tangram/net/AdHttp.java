package com.tencent.ad.tangram.net;

import android.support.annotation.Keep;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.thread.AdThreadManager;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;

@Keep
public final class AdHttp
{
  private static final String TAG = "AdHttp";
  
  private static byte[] read(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      return null;
    }
    localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      for (;;)
      {
        byte[] arrayOfByte = new byte[1024];
        int i = paramInputStream.read(arrayOfByte);
        if (i < 0) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      return localByteArrayOutputStream.toByteArray();
    }
    catch (Throwable paramInputStream)
    {
      AdLog.e("AdHttp", "read", paramInputStream);
      try
      {
        localByteArrayOutputStream.close();
      }
      catch (Throwable paramInputStream)
      {
        AdLog.e("AdHttp", "read", paramInputStream);
      }
    }
  }
  
  /* Error */
  public static void send(AdHttp.Params paramParams)
  {
    // Byte code:
    //   0: invokestatic 52	java/lang/System:currentTimeMillis	()J
    //   3: lstore_1
    //   4: aload_0
    //   5: ifnull +398 -> 403
    //   8: aload_0
    //   9: invokevirtual 58	com/tencent/ad/tangram/net/AdHttp$Params:canSend	()Z
    //   12: ifne +4 -> 16
    //   15: return
    //   16: aload_0
    //   17: invokestatic 62	com/tencent/ad/tangram/net/AdHttp$Params:access$000	(Lcom/tencent/ad/tangram/net/AdHttp$Params;)Ljava/net/URL;
    //   20: invokevirtual 68	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   23: checkcast 70	java/net/HttpURLConnection
    //   26: astore_3
    //   27: aload_3
    //   28: astore 4
    //   30: aload_3
    //   31: aload_0
    //   32: getfield 74	com/tencent/ad/tangram/net/AdHttp$Params:connectTimeoutMillis	I
    //   35: invokevirtual 78	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   38: aload_3
    //   39: astore 4
    //   41: aload_3
    //   42: aload_0
    //   43: getfield 81	com/tencent/ad/tangram/net/AdHttp$Params:readTimeoutMillis	I
    //   46: invokevirtual 84	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   49: aload_3
    //   50: astore 4
    //   52: aload_3
    //   53: iconst_1
    //   54: invokevirtual 88	java/net/HttpURLConnection:setDoInput	(Z)V
    //   57: aload_3
    //   58: astore 4
    //   60: aload_0
    //   61: getfield 91	com/tencent/ad/tangram/net/AdHttp$Params:method	Ljava/lang/String;
    //   64: ldc 93
    //   66: invokestatic 99	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   69: ifeq +14 -> 83
    //   72: aload_3
    //   73: astore 4
    //   75: aload_3
    //   76: iconst_0
    //   77: invokevirtual 102	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   80: goto +26 -> 106
    //   83: aload_3
    //   84: astore 4
    //   86: aload_0
    //   87: getfield 91	com/tencent/ad/tangram/net/AdHttp$Params:method	Ljava/lang/String;
    //   90: ldc 104
    //   92: invokestatic 99	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   95: ifeq +11 -> 106
    //   98: aload_3
    //   99: astore 4
    //   101: aload_3
    //   102: iconst_1
    //   103: invokevirtual 102	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   106: aload_3
    //   107: astore 4
    //   109: aload_3
    //   110: aload_0
    //   111: getfield 91	com/tencent/ad/tangram/net/AdHttp$Params:method	Ljava/lang/String;
    //   114: invokevirtual 108	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   117: aload_3
    //   118: astore 4
    //   120: aload_3
    //   121: iconst_0
    //   122: invokevirtual 111	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   125: aload_3
    //   126: astore 4
    //   128: aload_3
    //   129: aload_0
    //   130: getfield 115	com/tencent/ad/tangram/net/AdHttp$Params:isInstanceFollowRedirects	Z
    //   133: invokevirtual 118	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   136: aload_3
    //   137: astore 4
    //   139: aload_0
    //   140: getfield 121	com/tencent/ad/tangram/net/AdHttp$Params:contentType	Ljava/lang/String;
    //   143: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   146: ifne +16 -> 162
    //   149: aload_3
    //   150: astore 4
    //   152: aload_3
    //   153: ldc 127
    //   155: aload_0
    //   156: getfield 121	com/tencent/ad/tangram/net/AdHttp$Params:contentType	Ljava/lang/String;
    //   159: invokevirtual 131	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: aload_3
    //   163: astore 4
    //   165: aload_0
    //   166: getfield 134	com/tencent/ad/tangram/net/AdHttp$Params:referer	Ljava/lang/String;
    //   169: invokestatic 125	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   172: ifne +16 -> 188
    //   175: aload_3
    //   176: astore 4
    //   178: aload_3
    //   179: ldc 136
    //   181: aload_0
    //   182: getfield 134	com/tencent/ad/tangram/net/AdHttp$Params:referer	Ljava/lang/String;
    //   185: invokevirtual 131	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: aload_3
    //   189: astore 4
    //   191: aload_3
    //   192: invokevirtual 139	java/net/HttpURLConnection:getDoOutput	()Z
    //   195: ifeq +63 -> 258
    //   198: aload_3
    //   199: astore 4
    //   201: aload_0
    //   202: getfield 143	com/tencent/ad/tangram/net/AdHttp$Params:requestData	[B
    //   205: ifnull +53 -> 258
    //   208: aload_3
    //   209: astore 4
    //   211: new 145	java/io/DataOutputStream
    //   214: dup
    //   215: aload_3
    //   216: invokevirtual 149	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   219: invokespecial 152	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   222: astore 5
    //   224: aload_3
    //   225: astore 4
    //   227: aload 5
    //   229: aload_0
    //   230: getfield 143	com/tencent/ad/tangram/net/AdHttp$Params:requestData	[B
    //   233: iconst_0
    //   234: aload_0
    //   235: getfield 143	com/tencent/ad/tangram/net/AdHttp$Params:requestData	[B
    //   238: arraylength
    //   239: invokevirtual 153	java/io/DataOutputStream:write	([BII)V
    //   242: aload_3
    //   243: astore 4
    //   245: aload 5
    //   247: invokevirtual 156	java/io/DataOutputStream:flush	()V
    //   250: aload_3
    //   251: astore 4
    //   253: aload 5
    //   255: invokevirtual 157	java/io/DataOutputStream:close	()V
    //   258: aload_3
    //   259: astore 4
    //   261: aload_3
    //   262: invokevirtual 160	java/net/HttpURLConnection:connect	()V
    //   265: aload_3
    //   266: astore 4
    //   268: aload_0
    //   269: aload_3
    //   270: invokevirtual 164	java/net/HttpURLConnection:getResponseCode	()I
    //   273: putfield 167	com/tencent/ad/tangram/net/AdHttp$Params:responseCode	I
    //   276: aload_3
    //   277: astore 4
    //   279: aload_0
    //   280: getfield 167	com/tencent/ad/tangram/net/AdHttp$Params:responseCode	I
    //   283: sipush 200
    //   286: if_icmpne +42 -> 328
    //   289: aload_3
    //   290: astore 4
    //   292: aload_3
    //   293: invokevirtual 170	java/net/HttpURLConnection:getDoInput	()Z
    //   296: ifeq +32 -> 328
    //   299: aload_3
    //   300: astore 4
    //   302: aload_3
    //   303: invokevirtual 174	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   306: astore 5
    //   308: aload_3
    //   309: astore 4
    //   311: aload_0
    //   312: aload 5
    //   314: invokestatic 176	com/tencent/ad/tangram/net/AdHttp:read	(Ljava/io/InputStream;)[B
    //   317: putfield 179	com/tencent/ad/tangram/net/AdHttp$Params:responseData	[B
    //   320: aload_3
    //   321: astore 4
    //   323: aload 5
    //   325: invokevirtual 180	java/io/InputStream:close	()V
    //   328: aload_3
    //   329: ifnull +42 -> 371
    //   332: goto +35 -> 367
    //   335: astore 5
    //   337: goto +14 -> 351
    //   340: astore_3
    //   341: aconst_null
    //   342: astore 4
    //   344: goto +38 -> 382
    //   347: astore 5
    //   349: aconst_null
    //   350: astore_3
    //   351: aload_3
    //   352: astore 4
    //   354: ldc 9
    //   356: ldc 181
    //   358: aload 5
    //   360: invokestatic 37	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   363: aload_3
    //   364: ifnull +7 -> 371
    //   367: aload_3
    //   368: invokevirtual 184	java/net/HttpURLConnection:disconnect	()V
    //   371: aload_0
    //   372: invokestatic 52	java/lang/System:currentTimeMillis	()J
    //   375: lload_1
    //   376: lsub
    //   377: putfield 188	com/tencent/ad/tangram/net/AdHttp$Params:durationMillis	J
    //   380: return
    //   381: astore_3
    //   382: aload 4
    //   384: ifnull +8 -> 392
    //   387: aload 4
    //   389: invokevirtual 184	java/net/HttpURLConnection:disconnect	()V
    //   392: aload_0
    //   393: invokestatic 52	java/lang/System:currentTimeMillis	()J
    //   396: lload_1
    //   397: lsub
    //   398: putfield 188	com/tencent/ad/tangram/net/AdHttp$Params:durationMillis	J
    //   401: aload_3
    //   402: athrow
    //   403: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	404	0	paramParams	AdHttp.Params
    //   3	394	1	l	long
    //   26	303	3	localHttpURLConnection	java.net.HttpURLConnection
    //   340	1	3	localObject1	Object
    //   350	18	3	localObject2	Object
    //   381	21	3	localObject3	Object
    //   28	360	4	localObject4	Object
    //   222	102	5	localObject5	Object
    //   335	1	5	localThrowable1	Throwable
    //   347	12	5	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   30	38	335	java/lang/Throwable
    //   41	49	335	java/lang/Throwable
    //   52	57	335	java/lang/Throwable
    //   60	72	335	java/lang/Throwable
    //   75	80	335	java/lang/Throwable
    //   86	98	335	java/lang/Throwable
    //   101	106	335	java/lang/Throwable
    //   109	117	335	java/lang/Throwable
    //   120	125	335	java/lang/Throwable
    //   128	136	335	java/lang/Throwable
    //   139	149	335	java/lang/Throwable
    //   152	162	335	java/lang/Throwable
    //   165	175	335	java/lang/Throwable
    //   178	188	335	java/lang/Throwable
    //   191	198	335	java/lang/Throwable
    //   201	208	335	java/lang/Throwable
    //   211	224	335	java/lang/Throwable
    //   227	242	335	java/lang/Throwable
    //   245	250	335	java/lang/Throwable
    //   253	258	335	java/lang/Throwable
    //   261	265	335	java/lang/Throwable
    //   268	276	335	java/lang/Throwable
    //   279	289	335	java/lang/Throwable
    //   292	299	335	java/lang/Throwable
    //   302	308	335	java/lang/Throwable
    //   311	320	335	java/lang/Throwable
    //   323	328	335	java/lang/Throwable
    //   16	27	340	finally
    //   16	27	347	java/lang/Throwable
    //   30	38	381	finally
    //   41	49	381	finally
    //   52	57	381	finally
    //   60	72	381	finally
    //   75	80	381	finally
    //   86	98	381	finally
    //   101	106	381	finally
    //   109	117	381	finally
    //   120	125	381	finally
    //   128	136	381	finally
    //   139	149	381	finally
    //   152	162	381	finally
    //   165	175	381	finally
    //   178	188	381	finally
    //   191	198	381	finally
    //   201	208	381	finally
    //   211	224	381	finally
    //   227	242	381	finally
    //   245	250	381	finally
    //   253	258	381	finally
    //   261	265	381	finally
    //   268	276	381	finally
    //   279	289	381	finally
    //   292	299	381	finally
    //   302	308	381	finally
    //   311	320	381	finally
    //   323	328	381	finally
    //   354	363	381	finally
  }
  
  public static boolean sendAsync(AdHttp.Params paramParams, WeakReference<AdHttp.a> paramWeakReference)
  {
    if ((paramParams != null) && (paramParams.canSend()))
    {
      AdThreadManager.INSTANCE.post(new AdHttp.1(paramParams, paramWeakReference), 4);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.net.AdHttp
 * JD-Core Version:    0.7.0.1
 */