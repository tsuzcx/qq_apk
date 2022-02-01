package com.huawei.hms.framework.network.grs.b;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.local.model.c;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class g
  extends b
  implements Callable<d>
{
  private static final String b = g.class.getSimpleName();
  
  public g(String paramString1, int paramInt, a parama, Context paramContext, String paramString2)
  {
    super(paramString1, paramInt, parama, paramContext, paramString2);
  }
  
  private String h()
  {
    Object localObject1 = new HashSet();
    com.huawei.hms.framework.network.grs.local.model.a locala = com.huawei.hms.framework.network.grs.local.b.a(d().getPackageName()).a();
    if (locala == null)
    {
      Logger.w(b, "get local assets appGrs is null.");
      return "";
    }
    Object localObject2 = locala.b();
    if ((localObject2 == null) || (((Map)localObject2).isEmpty())) {
      return "";
    }
    localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Set)localObject1).add(((c)((Map.Entry)((Iterator)localObject2).next()).getValue()).a());
    }
    if (((Set)localObject1).isEmpty()) {
      return "";
    }
    localObject2 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    localObject1 = ((Set)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      localJSONArray.put((String)((Iterator)localObject1).next());
    }
    try
    {
      ((JSONObject)localObject2).put("services", localJSONArray);
      Logger.v(b, "post service list is:%s,and appName is:%s", new Object[] { ((JSONObject)localObject2).toString(), locala.a() });
      return ((JSONObject)localObject2).toString();
    }
    catch (JSONException localJSONException) {}
    return "";
  }
  
  /* Error */
  public d g()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 4
    //   3: getstatic 19	com/huawei/hms/framework/network/grs/b/g:b	Ljava/lang/String;
    //   6: ldc 141
    //   8: invokestatic 144	com/huawei/hms/framework/common/Logger:i	(Ljava/lang/String;Ljava/lang/Object;)V
    //   11: invokestatic 150	android/os/SystemClock:elapsedRealtime	()J
    //   14: lstore 6
    //   16: lload 4
    //   18: lstore_2
    //   19: invokestatic 155	java/lang/System:currentTimeMillis	()J
    //   22: lstore 4
    //   24: lload 4
    //   26: lstore_2
    //   27: aload_0
    //   28: invokevirtual 156	com/huawei/hms/framework/network/grs/b/g:a	()Ljava/lang/String;
    //   31: aload_0
    //   32: invokevirtual 35	com/huawei/hms/framework/network/grs/b/g:d	()Landroid/content/Context;
    //   35: aload_0
    //   36: invokevirtual 159	com/huawei/hms/framework/network/grs/b/g:e	()Ljava/lang/String;
    //   39: invokestatic 164	com/huawei/hms/framework/network/grs/c/a/a:a	(Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;)Ljavax/net/ssl/HttpsURLConnection;
    //   42: astore 14
    //   44: aload 14
    //   46: ifnonnull +16 -> 62
    //   49: lload 4
    //   51: lstore_2
    //   52: getstatic 19	com/huawei/hms/framework/network/grs/b/g:b	Ljava/lang/String;
    //   55: ldc 166
    //   57: invokestatic 57	com/huawei/hms/framework/common/Logger:w	(Ljava/lang/String;Ljava/lang/Object;)V
    //   60: aconst_null
    //   61: areturn
    //   62: lload 4
    //   64: lstore_2
    //   65: aload 14
    //   67: ldc 168
    //   69: ldc 170
    //   71: invokevirtual 176	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: lload 4
    //   76: lstore_2
    //   77: aload 14
    //   79: ldc 178
    //   81: invokevirtual 182	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   84: lload 4
    //   86: lstore_2
    //   87: aload 14
    //   89: iconst_1
    //   90: invokevirtual 186	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   93: lload 4
    //   95: lstore_2
    //   96: aload 14
    //   98: iconst_1
    //   99: invokevirtual 189	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   102: lload 4
    //   104: lstore_2
    //   105: aload 14
    //   107: invokevirtual 192	javax/net/ssl/HttpsURLConnection:connect	()V
    //   110: lload 4
    //   112: lstore_2
    //   113: aload 14
    //   115: invokevirtual 196	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   118: astore 12
    //   120: lload 4
    //   122: lstore_2
    //   123: aload 12
    //   125: aload_0
    //   126: invokespecial 198	com/huawei/hms/framework/network/grs/b/g:h	()Ljava/lang/String;
    //   129: invokevirtual 202	java/lang/String:getBytes	()[B
    //   132: invokevirtual 208	java/io/OutputStream:write	([B)V
    //   135: lload 4
    //   137: lstore_2
    //   138: aload 12
    //   140: invokevirtual 211	java/io/OutputStream:close	()V
    //   143: lload 4
    //   145: lstore_2
    //   146: aload 14
    //   148: invokevirtual 215	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   151: istore_1
    //   152: iload_1
    //   153: sipush 200
    //   156: if_icmpne +244 -> 400
    //   159: aload 14
    //   161: invokevirtual 219	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   164: astore 13
    //   166: aload 13
    //   168: invokestatic 225	com/huawei/hms/framework/common/IoUtils:toByteArray	(Ljava/io/InputStream;)[B
    //   171: astore 12
    //   173: lload 4
    //   175: lstore_2
    //   176: aload 13
    //   178: invokestatic 229	com/huawei/hms/framework/common/IoUtils:closeSecure	(Ljava/io/InputStream;)V
    //   181: lload 4
    //   183: lstore_2
    //   184: aload 14
    //   186: invokevirtual 232	javax/net/ssl/HttpsURLConnection:getHeaderFields	()Ljava/util/Map;
    //   189: astore 13
    //   191: lload 4
    //   193: lstore_2
    //   194: aload 14
    //   196: invokevirtual 235	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   199: lload 4
    //   201: lstore_2
    //   202: invokestatic 150	android/os/SystemClock:elapsedRealtime	()J
    //   205: lstore 10
    //   207: lload 4
    //   209: lstore_2
    //   210: invokestatic 155	java/lang/System:currentTimeMillis	()J
    //   213: lstore 8
    //   215: lload 4
    //   217: lstore_2
    //   218: aload_0
    //   219: new 237	com/huawei/hms/framework/network/grs/b/d
    //   222: dup
    //   223: iload_1
    //   224: aload 13
    //   226: aload 12
    //   228: lload 10
    //   230: lload 6
    //   232: lsub
    //   233: invokespecial 240	com/huawei/hms/framework/network/grs/b/d:<init>	(ILjava/util/Map;[BJ)V
    //   236: putfield 243	com/huawei/hms/framework/network/grs/b/g:a	Lcom/huawei/hms/framework/network/grs/b/d;
    //   239: lload 8
    //   241: lstore_2
    //   242: lload 4
    //   244: lstore 6
    //   246: lload_2
    //   247: lstore 4
    //   249: aload_0
    //   250: getfield 243	com/huawei/hms/framework/network/grs/b/g:a	Lcom/huawei/hms/framework/network/grs/b/d;
    //   253: aload_0
    //   254: invokevirtual 156	com/huawei/hms/framework/network/grs/b/g:a	()Ljava/lang/String;
    //   257: invokevirtual 245	com/huawei/hms/framework/network/grs/b/d:a	(Ljava/lang/String;)V
    //   260: aload_0
    //   261: getfield 243	com/huawei/hms/framework/network/grs/b/g:a	Lcom/huawei/hms/framework/network/grs/b/d;
    //   264: aload_0
    //   265: invokevirtual 248	com/huawei/hms/framework/network/grs/b/g:c	()I
    //   268: invokevirtual 251	com/huawei/hms/framework/network/grs/b/d:a	(I)V
    //   271: aload_0
    //   272: getfield 243	com/huawei/hms/framework/network/grs/b/g:a	Lcom/huawei/hms/framework/network/grs/b/d;
    //   275: lload 6
    //   277: invokevirtual 254	com/huawei/hms/framework/network/grs/b/d:a	(J)V
    //   280: aload_0
    //   281: getfield 243	com/huawei/hms/framework/network/grs/b/g:a	Lcom/huawei/hms/framework/network/grs/b/d;
    //   284: lload 4
    //   286: invokevirtual 256	com/huawei/hms/framework/network/grs/b/d:b	(J)V
    //   289: aload_0
    //   290: invokevirtual 259	com/huawei/hms/framework/network/grs/b/g:b	()Lcom/huawei/hms/framework/network/grs/b/a;
    //   293: ifnull +16 -> 309
    //   296: aload_0
    //   297: invokevirtual 259	com/huawei/hms/framework/network/grs/b/g:b	()Lcom/huawei/hms/framework/network/grs/b/a;
    //   300: aload_0
    //   301: getfield 243	com/huawei/hms/framework/network/grs/b/g:a	Lcom/huawei/hms/framework/network/grs/b/d;
    //   304: invokeinterface 264 2 0
    //   309: aload_0
    //   310: getfield 243	com/huawei/hms/framework/network/grs/b/g:a	Lcom/huawei/hms/framework/network/grs/b/d;
    //   313: areturn
    //   314: astore 12
    //   316: aconst_null
    //   317: astore 13
    //   319: lload 4
    //   321: lstore_2
    //   322: aload 13
    //   324: invokestatic 229	com/huawei/hms/framework/common/IoUtils:closeSecure	(Ljava/io/InputStream;)V
    //   327: lload 4
    //   329: lstore_2
    //   330: aload 12
    //   332: athrow
    //   333: astore 12
    //   335: lload 6
    //   337: lstore 4
    //   339: invokestatic 150	android/os/SystemClock:elapsedRealtime	()J
    //   342: lstore 8
    //   344: invokestatic 155	java/lang/System:currentTimeMillis	()J
    //   347: lstore 6
    //   349: getstatic 19	com/huawei/hms/framework/network/grs/b/g:b	Ljava/lang/String;
    //   352: ldc_w 266
    //   355: aload 12
    //   357: invokestatic 269	com/huawei/hms/framework/common/Logger:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   360: aload_0
    //   361: new 237	com/huawei/hms/framework/network/grs/b/d
    //   364: dup
    //   365: aload 12
    //   367: lload 8
    //   369: lload 4
    //   371: lsub
    //   372: invokespecial 272	com/huawei/hms/framework/network/grs/b/d:<init>	(Ljava/lang/Exception;J)V
    //   375: putfield 243	com/huawei/hms/framework/network/grs/b/g:a	Lcom/huawei/hms/framework/network/grs/b/d;
    //   378: lload 6
    //   380: lstore 4
    //   382: lload_2
    //   383: lstore 6
    //   385: goto -136 -> 249
    //   388: astore 12
    //   390: lconst_0
    //   391: lstore_2
    //   392: goto -53 -> 339
    //   395: astore 12
    //   397: goto -78 -> 319
    //   400: aconst_null
    //   401: astore 12
    //   403: goto -222 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	406	0	this	g
    //   151	73	1	i	int
    //   18	374	2	l1	long
    //   1	380	4	l2	long
    //   14	370	6	l3	long
    //   213	155	8	l4	long
    //   205	24	10	l5	long
    //   118	109	12	localObject1	Object
    //   314	17	12	localObject2	Object
    //   333	33	12	localIOException1	java.io.IOException
    //   388	1	12	localIOException2	java.io.IOException
    //   395	1	12	localObject3	Object
    //   401	1	12	localObject4	Object
    //   164	159	13	localObject5	Object
    //   42	153	14	localHttpsURLConnection	javax.net.ssl.HttpsURLConnection
    // Exception table:
    //   from	to	target	type
    //   159	166	314	finally
    //   19	24	333	java/io/IOException
    //   27	44	333	java/io/IOException
    //   52	60	333	java/io/IOException
    //   65	74	333	java/io/IOException
    //   77	84	333	java/io/IOException
    //   87	93	333	java/io/IOException
    //   96	102	333	java/io/IOException
    //   105	110	333	java/io/IOException
    //   113	120	333	java/io/IOException
    //   123	135	333	java/io/IOException
    //   138	143	333	java/io/IOException
    //   146	152	333	java/io/IOException
    //   176	181	333	java/io/IOException
    //   184	191	333	java/io/IOException
    //   194	199	333	java/io/IOException
    //   202	207	333	java/io/IOException
    //   210	215	333	java/io/IOException
    //   218	239	333	java/io/IOException
    //   322	327	333	java/io/IOException
    //   330	333	333	java/io/IOException
    //   11	16	388	java/io/IOException
    //   166	173	395	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.b.g
 * JD-Core Version:    0.7.0.1
 */