package com.tencent.luggage.wxa.bj;

import android.os.Build.VERSION;
import com.tencent.luggage.wxa.gl.c;
import com.tencent.luggage.wxa.qz.o;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/crash/CgiAEStackReport;", "", "()V", "HOST", "", "MMAEWEBCMD_AESTACKREPORT_URI", "TAG", "deviceType", "sRawOkHttpClient", "Lokhttp3/OkHttpClient;", "getSRawOkHttpClient", "()Lokhttp3/OkHttpClient;", "sRawOkHttpClient$delegate", "Lkotlin/Lazy;", "doAEStackReport", "", "productId", "", "uin", "clientVersion", "content", "", "params", "", "doPost", "url", "postContent", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class a
{
  public static final a a = new a();
  private static final String b;
  private static final Lazy c = LazyKt.lazy((Function0)a.a.a);
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("android-");
    localStringBuilder.append(Build.VERSION.SDK_INT);
    b = localStringBuilder.toString();
  }
  
  private final OkHttpClient a()
  {
    return (OkHttpClient)c.getValue();
  }
  
  private final void a(String paramString, byte[] paramArrayOfByte)
  {
    paramString = new Request.Builder().url(paramString).post(RequestBody.create(MediaType.parse("binary/octet-stream"), paramArrayOfByte)).build();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "Request.Builder()\n      …nt))\n            .build()");
    paramString = a().newCall(paramString).execute();
    int i = paramString.code();
    if (i != 200)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("rsp error, code = ");
      paramArrayOfByte.append(i);
      o.c("Luggage.CgiAEStackReport", paramArrayOfByte.toString());
    }
    paramString = paramString.body();
    if (paramString == null) {
      Intrinsics.throwNpe();
    }
    paramString = paramString.string();
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("http post with HttpClient, rsp code = ");
    paramArrayOfByte.append(i);
    paramArrayOfByte.append(", content = ");
    paramArrayOfByte.append(paramString);
    o.d("Luggage.CgiAEStackReport", paramArrayOfByte.toString());
  }
  
  @JvmOverloads
  public final void a(int paramInt1, @NotNull String paramString, int paramInt2, @NotNull byte[] paramArrayOfByte, @NotNull Map<String, String> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "content");
    Intrinsics.checkParameterIsNotNull(paramMap, "params");
    int i = paramArrayOfByte.length;
    Object localObject1 = StringCompanionObject.INSTANCE;
    localObject1 = new Object[2];
    localObject1[0] = Integer.valueOf(paramInt2);
    localObject1[1] = Integer.valueOf(i);
    localObject1 = String.format("appengine#$()%d%d", Arrays.copyOf((Object[])localObject1, localObject1.length));
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "java.lang.String.format(format, *args)");
    Object localObject2 = Charsets.UTF_8;
    if (localObject1 != null)
    {
      localObject1 = ((String)localObject1).getBytes((Charset)localObject2);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "(this as java.lang.String).getBytes(charset)");
      localObject1 = c.a((byte[])localObject1);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "MD5.getMessageDigest(beforeMd5.toByteArray())");
      if (localObject1 != null)
      {
        localObject2 = ((String)localObject1).toLowerCase();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "(this as java.lang.String).toLowerCase()");
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("http://");
        ((StringBuilder)localObject1).append("aesupport.weixin.qq.com");
        ((StringBuilder)localObject1).append("/cgi-bin/mmsupport-bin/aestackreport");
        ((StringBuilder)localObject1).append("?version=");
        ((StringBuilder)localObject1).append(Integer.toHexString(paramInt2));
        ((StringBuilder)localObject1).append("&devicetype=");
        ((StringBuilder)localObject1).append(b);
        ((StringBuilder)localObject1).append("&filelength=");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append("&sum=");
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("&uin=");
        ((StringBuilder)localObject1).append(paramString);
        if (paramInt1 >= 0)
        {
          ((StringBuilder)localObject1).append("&productid=");
          ((StringBuilder)localObject1).append(paramInt1);
        }
        paramString = paramMap.entrySet().iterator();
        Object localObject3;
        while (paramString.hasNext())
        {
          localObject3 = (Map.Entry)paramString.next();
          paramMap = (String)((Map.Entry)localObject3).getKey();
          localObject3 = (String)((Map.Entry)localObject3).getValue();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append('&');
          localStringBuilder.append(paramMap);
          localStringBuilder.append('=');
          localStringBuilder.append((String)localObject3);
          ((StringBuilder)localObject1).append(localStringBuilder.toString());
        }
        try
        {
          paramString = b.a.a(paramArrayOfByte);
          paramArrayOfByte = new com.tencent.luggage.wxa.qt.b();
          paramMap = b.a;
          localObject3 = Charsets.UTF_8;
          if (localObject2 != null)
          {
            localObject2 = ((String)localObject2).getBytes((Charset)localObject3);
            Intrinsics.checkExpressionValueIsNotNull(localObject2, "(this as java.lang.String).getBytes(charset)");
            paramMap.a(paramArrayOfByte, paramString, (byte[])localObject2);
            paramString = paramArrayOfByte.a;
            if (paramString != null)
            {
              paramArrayOfByte = new StringBuilder();
              paramArrayOfByte.append("http post, content length = ");
              paramArrayOfByte.append(paramString.length);
              o.d("Luggage.CgiAEStackReport", paramArrayOfByte.toString());
              paramArrayOfByte = ((StringBuilder)localObject1).toString();
              Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "sb.toString()");
              a(paramArrayOfByte, paramString);
            }
          }
          else
          {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
          }
        }
        catch (Exception paramString)
        {
          o.c("Luggage.CgiAEStackReport", "post http reqeust fail", new Object[] { paramString });
        }
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
    paramString = new TypeCastException("null cannot be cast to non-null type java.lang.String");
    for (;;)
    {
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bj.a
 * JD-Core Version:    0.7.0.1
 */