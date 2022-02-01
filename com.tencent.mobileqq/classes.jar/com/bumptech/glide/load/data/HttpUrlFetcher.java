package com.bumptech.glide.load.data;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HttpUrlFetcher
  implements DataFetcher<InputStream>
{
  @VisibleForTesting
  static final HttpUrlFetcher.HttpUrlConnectionFactory a = new HttpUrlFetcher.DefaultHttpUrlConnectionFactory();
  private final GlideUrl b;
  private final int c;
  private final HttpUrlFetcher.HttpUrlConnectionFactory d;
  private HttpURLConnection e;
  private InputStream f;
  private volatile boolean g;
  
  public HttpUrlFetcher(GlideUrl paramGlideUrl, int paramInt)
  {
    this(paramGlideUrl, paramInt, a);
  }
  
  @VisibleForTesting
  HttpUrlFetcher(GlideUrl paramGlideUrl, int paramInt, HttpUrlFetcher.HttpUrlConnectionFactory paramHttpUrlConnectionFactory)
  {
    this.b = paramGlideUrl;
    this.c = paramInt;
    this.d = paramHttpUrlConnectionFactory;
  }
  
  private InputStream a(HttpURLConnection paramHttpURLConnection)
  {
    if (TextUtils.isEmpty(paramHttpURLConnection.getContentEncoding()))
    {
      int i = paramHttpURLConnection.getContentLength();
      this.f = ContentLengthInputStream.a(paramHttpURLConnection.getInputStream(), i);
    }
    else
    {
      if (Log.isLoggable("HttpUrlFetcher", 3))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Got non empty content encoding: ");
        localStringBuilder.append(paramHttpURLConnection.getContentEncoding());
        Log.d("HttpUrlFetcher", localStringBuilder.toString());
      }
      this.f = paramHttpURLConnection.getInputStream();
    }
    return this.f;
  }
  
  private InputStream a(URL paramURL1, int paramInt, URL paramURL2, Map<String, String> paramMap)
  {
    if ((paramInt >= 5) || (paramURL2 != null)) {}
    try
    {
      if (paramURL1.toURI().equals(paramURL2.toURI())) {
        throw new HttpException("In re-direct loop");
      }
    }
    catch (URISyntaxException paramURL2)
    {
      label36:
      int i;
      break label36;
    }
    this.e = this.d.a(paramURL1);
    paramURL2 = paramMap.entrySet().iterator();
    while (paramURL2.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramURL2.next();
      this.e.addRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    this.e.setConnectTimeout(this.c);
    this.e.setReadTimeout(this.c);
    this.e.setUseCaches(false);
    this.e.setDoInput(true);
    this.e.setInstanceFollowRedirects(false);
    this.e.connect();
    this.f = this.e.getInputStream();
    if (this.g) {
      return null;
    }
    i = this.e.getResponseCode();
    if (a(i)) {
      return a(this.e);
    }
    if (b(i))
    {
      paramURL2 = this.e.getHeaderField("Location");
      if (!TextUtils.isEmpty(paramURL2))
      {
        paramURL2 = new URL(paramURL1, paramURL2);
        b();
        return a(paramURL2, paramInt + 1, paramURL1, paramMap);
      }
      throw new HttpException("Received empty or null redirect url");
    }
    if (i == -1) {
      throw new HttpException(i);
    }
    throw new HttpException(this.e.getResponseMessage(), i);
    paramURL1 = new HttpException("Too many (> 5) redirects!");
    for (;;)
    {
      throw paramURL1;
    }
  }
  
  private static boolean a(int paramInt)
  {
    return paramInt / 100 == 2;
  }
  
  private static boolean b(int paramInt)
  {
    return paramInt / 100 == 3;
  }
  
  @NonNull
  public Class<InputStream> a()
  {
    return InputStream.class;
  }
  
  /* Error */
  public void a(@NonNull com.bumptech.glide.Priority paramPriority, @NonNull DataFetcher.DataCallback<? super InputStream> paramDataCallback)
  {
    // Byte code:
    //   0: invokestatic 231	com/bumptech/glide/util/LogTime:a	()J
    //   3: lstore_3
    //   4: aload_2
    //   5: aload_0
    //   6: aload_0
    //   7: getfield 38	com/bumptech/glide/load/data/HttpUrlFetcher:b	Lcom/bumptech/glide/load/model/GlideUrl;
    //   10: invokevirtual 236	com/bumptech/glide/load/model/GlideUrl:a	()Ljava/net/URL;
    //   13: iconst_0
    //   14: aconst_null
    //   15: aload_0
    //   16: getfield 38	com/bumptech/glide/load/data/HttpUrlFetcher:b	Lcom/bumptech/glide/load/model/GlideUrl;
    //   19: invokevirtual 239	com/bumptech/glide/load/model/GlideUrl:b	()Ljava/util/Map;
    //   22: invokespecial 204	com/bumptech/glide/load/data/HttpUrlFetcher:a	(Ljava/net/URL;ILjava/net/URL;Ljava/util/Map;)Ljava/io/InputStream;
    //   25: invokeinterface 244 2 0
    //   30: ldc 73
    //   32: iconst_2
    //   33: invokestatic 79	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   36: ifeq +87 -> 123
    //   39: new 81	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   46: astore_1
    //   47: goto +50 -> 97
    //   50: astore_1
    //   51: goto +73 -> 124
    //   54: astore_1
    //   55: ldc 73
    //   57: iconst_3
    //   58: invokestatic 79	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   61: ifeq +12 -> 73
    //   64: ldc 73
    //   66: ldc 246
    //   68: aload_1
    //   69: invokestatic 249	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   72: pop
    //   73: aload_2
    //   74: aload_1
    //   75: invokeinterface 252 2 0
    //   80: ldc 73
    //   82: iconst_2
    //   83: invokestatic 79	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   86: ifeq +37 -> 123
    //   89: new 81	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   96: astore_1
    //   97: aload_1
    //   98: ldc 254
    //   100: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload_1
    //   105: lload_3
    //   106: invokestatic 257	com/bumptech/glide/util/LogTime:a	(J)D
    //   109: invokevirtual 260	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: ldc 73
    //   115: aload_1
    //   116: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 263	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   122: pop
    //   123: return
    //   124: ldc 73
    //   126: iconst_2
    //   127: invokestatic 79	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   130: ifeq +37 -> 167
    //   133: new 81	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   140: astore_2
    //   141: aload_2
    //   142: ldc 254
    //   144: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload_2
    //   149: lload_3
    //   150: invokestatic 257	com/bumptech/glide/util/LogTime:a	(J)D
    //   153: invokevirtual 260	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: ldc 73
    //   159: aload_2
    //   160: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 263	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   166: pop
    //   167: aload_1
    //   168: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	HttpUrlFetcher
    //   0	169	1	paramPriority	com.bumptech.glide.Priority
    //   0	169	2	paramDataCallback	DataFetcher.DataCallback<? super InputStream>
    //   3	147	3	l	long
    // Exception table:
    //   from	to	target	type
    //   4	30	50	finally
    //   55	73	50	finally
    //   73	80	50	finally
    //   4	30	54	java/io/IOException
  }
  
  public void b()
  {
    Object localObject = this.f;
    if (localObject != null) {}
    try
    {
      ((InputStream)localObject).close();
    }
    catch (IOException localIOException)
    {
      label16:
      break label16;
    }
    localObject = this.e;
    if (localObject != null) {
      ((HttpURLConnection)localObject).disconnect();
    }
    this.e = null;
  }
  
  public void c()
  {
    this.g = true;
  }
  
  @NonNull
  public DataSource d()
  {
    return DataSource.REMOTE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.data.HttpUrlFetcher
 * JD-Core Version:    0.7.0.1
 */