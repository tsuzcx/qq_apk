package com.tencent.crossengine.net;

import android.util.Pair;
import androidx.annotation.NonNull;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.MultipartBody.Builder;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Timeout;

class OkHttpNetworkManager
  extends NetworkManager
{
  private final OkHttpClient a;
  
  public OkHttpNetworkManager()
  {
    this(new OkHttpClient.Builder().connectionPool(new ConnectionPool(32, 1L, TimeUnit.MINUTES)).followRedirects(true).build());
  }
  
  public OkHttpNetworkManager(@NonNull OkHttpClient paramOkHttpClient)
  {
    this.a = paramOkHttpClient;
  }
  
  private List<Pair<String, String>> a(Response paramResponse)
  {
    ArrayList localArrayList = new ArrayList(paramResponse.headers().size());
    int i = 0;
    while (i < localArrayList.size())
    {
      localArrayList.add(new Pair(paramResponse.headers().name(i), paramResponse.headers().value(i)));
      i += 1;
    }
    return localArrayList;
  }
  
  private MediaType a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return MediaType.parse(paramString);
  }
  
  private RequestBody a(NetworkManager.Callback paramCallback, long[] paramArrayOfLong, RequestBody paramRequestBody)
  {
    return new OkHttpNetworkManager.3(this, paramRequestBody, paramArrayOfLong, paramCallback);
  }
  
  public NetworkManager.HttpRequest performHttpRequest(@NonNull NetworkManager.HttpRequestData paramHttpRequestData)
  {
    Request.Builder localBuilder = new Request.Builder();
    localBuilder.url(paramHttpRequestData.url);
    if (paramHttpRequestData.userAgent != null) {
      localBuilder.addHeader("User-Agent", paramHttpRequestData.userAgent);
    }
    Object localObject1 = paramHttpRequestData.header.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Pair)((Iterator)localObject1).next();
      localBuilder.addHeader((String)((Pair)localObject2).first, (String)((Pair)localObject2).second);
    }
    Object localObject2 = paramHttpRequestData.callback;
    long[] arrayOfLong = new long[4];
    if (paramHttpRequestData.method == 0)
    {
      localBuilder.get();
    }
    else
    {
      if (paramHttpRequestData.postBody != null)
      {
        localObject1 = RequestBody.create(null, paramHttpRequestData.postBody);
      }
      else
      {
        localObject1 = new MultipartBody.Builder();
        Iterator localIterator = paramHttpRequestData.multiParts.iterator();
        while (localIterator.hasNext())
        {
          Object localObject3 = localIterator.next();
          if ((localObject3 instanceof NetworkManager.MultiPartString))
          {
            localObject3 = (NetworkManager.MultiPartString)localObject3;
            ((MultipartBody.Builder)localObject1).addFormDataPart(((NetworkManager.MultiPartString)localObject3).a, null, RequestBody.create(a(((NetworkManager.MultiPartString)localObject3).b), ((NetworkManager.MultiPartString)localObject3).c));
          }
          else if ((localObject3 instanceof NetworkManager.MultiPartData))
          {
            localObject3 = (NetworkManager.MultiPartData)localObject3;
            ((MultipartBody.Builder)localObject1).addFormDataPart(((NetworkManager.MultiPartData)localObject3).a, null, RequestBody.create(a(((NetworkManager.MultiPartData)localObject3).b), ((NetworkManager.MultiPartData)localObject3).c));
          }
          else if ((localObject3 instanceof NetworkManager.MultiPartFile))
          {
            localObject3 = (NetworkManager.MultiPartFile)localObject3;
            ((MultipartBody.Builder)localObject1).addFormDataPart(((NetworkManager.MultiPartFile)localObject3).a, ((NetworkManager.MultiPartFile)localObject3).d, RequestBody.create(a(((NetworkManager.MultiPartFile)localObject3).b), new File(((NetworkManager.MultiPartFile)localObject3).c)));
          }
        }
        ((MultipartBody.Builder)localObject1).setType(MultipartBody.FORM);
        localObject1 = ((MultipartBody.Builder)localObject1).build();
      }
      localBuilder.post(a((NetworkManager.Callback)localObject2, arrayOfLong, (RequestBody)localObject1));
    }
    localObject1 = this.a.newCall(localBuilder.build());
    if (paramHttpRequestData.timeout != 0L) {
      ((Call)localObject1).timeout().timeout(paramHttpRequestData.timeout, TimeUnit.MILLISECONDS);
    }
    ((Call)localObject1).enqueue(new OkHttpNetworkManager.1(this, (NetworkManager.Callback)localObject2, arrayOfLong));
    return new OkHttpNetworkManager.2(this, (Call)localObject1, (NetworkManager.Callback)localObject2);
  }
  
  public NetworkManager.WebSocket performWebSocketRequest(@NonNull NetworkManager.WebSocketRequestData paramWebSocketRequestData)
  {
    Request.Builder localBuilder = new Request.Builder();
    localBuilder.url(paramWebSocketRequestData.url);
    if (paramWebSocketRequestData.userAgent != null) {
      localBuilder.addHeader("User-Agent", paramWebSocketRequestData.userAgent);
    }
    Iterator localIterator = paramWebSocketRequestData.header.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      localBuilder.addHeader((String)localPair.first, (String)localPair.second);
    }
    if (!paramWebSocketRequestData.protocols.isEmpty())
    {
      localIterator = paramWebSocketRequestData.protocols.iterator();
      while (localIterator.hasNext()) {
        localBuilder.addHeader("Sec-WebSocket-Protocol", (String)localIterator.next());
      }
    }
    paramWebSocketRequestData = paramWebSocketRequestData.delegate;
    return new OkHttpNetworkManager.5(this, this.a.newWebSocket(localBuilder.build(), new OkHttpNetworkManager.4(this, paramWebSocketRequestData)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.crossengine.net.OkHttpNetworkManager
 * JD-Core Version:    0.7.0.1
 */