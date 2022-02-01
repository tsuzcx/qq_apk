package com.tencent.mm.modelappbrand.image;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qz.o;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class AppBrandSimpleImageLoader$p
{
  private final String a;
  private final String b;
  
  private AppBrandSimpleImageLoader$p(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.a = paramString;
      this.b = AppBrandSimpleImageLoader.a(paramString);
      return;
    }
    throw new IllegalArgumentException();
  }
  
  /* Error */
  private java.io.InputStream a(@Nullable Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 20	com/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$p:a	Ljava/lang/String;
    //   4: ldc 49
    //   6: invokevirtual 55	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   9: ifne +193 -> 202
    //   12: aload_0
    //   13: getfield 20	com/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$p:a	Ljava/lang/String;
    //   16: ldc 57
    //   18: invokevirtual 55	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   21: ifeq +6 -> 27
    //   24: goto +178 -> 202
    //   27: new 59	java/net/URL
    //   30: dup
    //   31: aload_0
    //   32: getfield 20	com/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$p:a	Ljava/lang/String;
    //   35: invokespecial 60	java/net/URL:<init>	(Ljava/lang/String;)V
    //   38: invokevirtual 64	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   41: checkcast 66	java/net/HttpURLConnection
    //   44: astore_3
    //   45: aload_0
    //   46: aload_3
    //   47: aload_1
    //   48: invokespecial 69	com/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$p:a	(Ljava/net/HttpURLConnection;Ljava/util/Map;)V
    //   51: aload_3
    //   52: invokevirtual 73	java/net/HttpURLConnection:getResponseCode	()I
    //   55: sipush 301
    //   58: if_icmpeq +15 -> 73
    //   61: aload_3
    //   62: astore_2
    //   63: aload_3
    //   64: invokevirtual 73	java/net/HttpURLConnection:getResponseCode	()I
    //   67: sipush 302
    //   70: if_icmpne +61 -> 131
    //   73: aload_3
    //   74: ldc 75
    //   76: invokevirtual 78	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   79: astore_2
    //   80: aload_3
    //   81: invokevirtual 82	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   84: invokevirtual 87	java/io/InputStream:close	()V
    //   87: aload_3
    //   88: invokevirtual 90	java/net/HttpURLConnection:disconnect	()V
    //   91: aload_2
    //   92: invokestatic 95	android/webkit/URLUtil:isAboutUrl	(Ljava/lang/String;)Z
    //   95: ifne +59 -> 154
    //   98: aload_2
    //   99: invokestatic 98	android/webkit/URLUtil:isNetworkUrl	(Ljava/lang/String;)Z
    //   102: ifeq +52 -> 154
    //   105: new 59	java/net/URL
    //   108: dup
    //   109: aload_2
    //   110: invokespecial 60	java/net/URL:<init>	(Ljava/lang/String;)V
    //   113: invokevirtual 64	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   116: checkcast 66	java/net/HttpURLConnection
    //   119: astore_2
    //   120: aload_2
    //   121: iconst_0
    //   122: invokevirtual 102	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   125: aload_0
    //   126: aload_2
    //   127: aload_1
    //   128: invokespecial 69	com/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$p:a	(Ljava/net/HttpURLConnection;Ljava/util/Map;)V
    //   131: new 104	com/tencent/luggage/wxa/pc/i
    //   134: dup
    //   135: aload_2
    //   136: invokespecial 107	com/tencent/luggage/wxa/pc/i:<init>	(Ljava/lang/Object;)V
    //   139: astore_1
    //   140: new 109	com/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$p$1
    //   143: dup
    //   144: aload_0
    //   145: aload_2
    //   146: invokevirtual 82	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   149: aload_1
    //   150: invokespecial 112	com/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$p$1:<init>	(Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$p;Ljava/io/InputStream;Lcom/tencent/luggage/wxa/pc/i;)V
    //   153: areturn
    //   154: new 114	java/net/MalformedURLException
    //   157: dup
    //   158: ldc 116
    //   160: iconst_2
    //   161: anewarray 4	java/lang/Object
    //   164: dup
    //   165: iconst_0
    //   166: aload_0
    //   167: getfield 20	com/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$p:a	Ljava/lang/String;
    //   170: aastore
    //   171: dup
    //   172: iconst_1
    //   173: aload_2
    //   174: aastore
    //   175: invokestatic 120	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   178: invokespecial 121	java/net/MalformedURLException:<init>	(Ljava/lang/String;)V
    //   181: athrow
    //   182: astore_1
    //   183: new 123	java/io/IOException
    //   186: dup
    //   187: aload_1
    //   188: invokespecial 126	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   191: athrow
    //   192: astore_1
    //   193: new 123	java/io/IOException
    //   196: dup
    //   197: aload_1
    //   198: invokespecial 126	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   201: athrow
    //   202: aload_0
    //   203: getfield 20	com/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$p:a	Ljava/lang/String;
    //   206: invokestatic 131	com/tencent/luggage/wxa/rt/k:a	(Ljava/lang/String;)Ljava/io/InputStream;
    //   209: astore_1
    //   210: aload_1
    //   211: areturn
    //   212: astore_1
    //   213: ldc 133
    //   215: aload_1
    //   216: ldc 135
    //   218: iconst_1
    //   219: anewarray 4	java/lang/Object
    //   222: dup
    //   223: iconst_0
    //   224: aload_0
    //   225: getfield 20	com/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$p:a	Ljava/lang/String;
    //   228: aastore
    //   229: invokestatic 140	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   232: aload_1
    //   233: athrow
    //   234: astore_3
    //   235: goto -144 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	this	p
    //   0	238	1	paramMap	Map<String, String>
    //   62	112	2	localObject	Object
    //   44	44	3	localHttpURLConnection	HttpURLConnection
    //   234	1	3	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   51	61	182	java/lang/Exception
    //   63	73	182	java/lang/Exception
    //   73	80	182	java/lang/Exception
    //   80	91	182	java/lang/Exception
    //   91	131	182	java/lang/Exception
    //   131	154	182	java/lang/Exception
    //   154	182	182	java/lang/Exception
    //   51	61	192	java/lang/ArrayIndexOutOfBoundsException
    //   63	73	192	java/lang/ArrayIndexOutOfBoundsException
    //   73	80	192	java/lang/ArrayIndexOutOfBoundsException
    //   80	91	192	java/lang/ArrayIndexOutOfBoundsException
    //   91	131	192	java/lang/ArrayIndexOutOfBoundsException
    //   131	154	192	java/lang/ArrayIndexOutOfBoundsException
    //   154	182	192	java/lang/ArrayIndexOutOfBoundsException
    //   202	210	212	java/io/FileNotFoundException
    //   80	91	234	java/lang/Throwable
  }
  
  private String a()
  {
    return this.b;
  }
  
  private void a(HttpURLConnection paramHttpURLConnection, @Nullable Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        o.d("Luggage.AppBrandSimpleImageLoader", "setHeaders, header: %s: %s", new Object[] { localEntry.getKey(), localEntry.getValue() });
        paramHttpURLConnection.setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
  }
  
  @NonNull
  public String toString()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.p
 * JD-Core Version:    0.7.0.1
 */