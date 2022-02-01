package com.tencent.beacon.base.net.adapter;

import android.support.annotation.Nullable;
import com.tencent.beacon.base.net.BodyType;
import com.tencent.beacon.base.net.a.b;
import com.tencent.beacon.base.net.a.f;
import com.tencent.beacon.base.net.a.k;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;

public class OkHttpAdapter
  extends a
{
  private OkHttpClient client;
  private int failCount;
  
  private OkHttpAdapter()
  {
    this.client = new OkHttpClient.Builder().connectTimeout(30000L, TimeUnit.MILLISECONDS).readTimeout(10000L, TimeUnit.MILLISECONDS).build();
  }
  
  private OkHttpAdapter(OkHttpClient paramOkHttpClient)
  {
    this.client = paramOkHttpClient;
  }
  
  private RequestBody buildBody(f paramf)
  {
    BodyType localBodyType = paramf.a();
    int i = f.a[localBodyType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return null;
        }
        return RequestBody.create(MediaType.parse("multipart/form-data"), paramf.c());
      }
      return RequestBody.create(MediaType.parse(localBodyType.httpType), paramf.f());
    }
    return RequestBody.create(MediaType.parse(localBodyType.httpType), com.tencent.beacon.base.net.c.d.b(paramf.d()));
  }
  
  public static a create(@Nullable OkHttpClient paramOkHttpClient)
  {
    if (paramOkHttpClient != null) {
      return new OkHttpAdapter(paramOkHttpClient);
    }
    return new OkHttpAdapter();
  }
  
  private Headers mapToHeaders(Map<String, String> paramMap)
  {
    Headers.Builder localBuilder = new Headers.Builder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (localEntry.getValue() != null) {
        localBuilder.add((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    return localBuilder.build();
  }
  
  public void request(f paramf, b<com.tencent.beacon.base.net.a> paramb)
  {
    String str = paramf.h();
    Object localObject = buildBody(paramf);
    localObject = new Request.Builder().url(paramf.i()).method(paramf.g().name(), (RequestBody)localObject).headers(mapToHeaders(paramf.e()));
    if (str == null) {
      paramf = "beacon";
    } else {
      paramf = str;
    }
    paramf = ((Request.Builder)localObject).tag(paramf).build();
    this.client.newCall(paramf).enqueue(new e(this, paramb, str));
  }
  
  public void request(k paramk, b<byte[]> paramb)
  {
    RequestBody localRequestBody = RequestBody.create(MediaType.parse("jce"), paramk.b());
    Headers localHeaders = mapToHeaders(paramk.d());
    String str = paramk.g().name();
    paramk = paramk.h();
    paramk = new Request.Builder().url(paramk).tag(str).post(localRequestBody).headers(localHeaders).build();
    this.client.newCall(paramk).enqueue(new d(this, paramb, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.base.net.adapter.OkHttpAdapter
 * JD-Core Version:    0.7.0.1
 */