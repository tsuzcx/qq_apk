package com.tencent.luggage.wxa.dg;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.w;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/device/WxaDeviceInfo;", "", "()V", "deviceId", "", "getDeviceId", "()Ljava/lang/String;", "expireTime", "", "getExpireTime", "()J", "extraData", "getExtraData", "hostAppId", "getHostAppId", "productId", "", "getProductId", "()I", "syncTime", "getSyncTime", "token", "getToken", "username", "getUsername", "isActivate", "", "isValid", "reset", "", "update", "Companion", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class c
{
  public static final c.a a = new c.a(null);
  private static final w b;
  
  static
  {
    w localw = w.a("Luggage.WxaDeviceInfo", 2);
    if (localw == null) {
      Intrinsics.throwNpe();
    }
    b = localw;
  }
  
  @NotNull
  public final String a()
  {
    String str = b.getString("deviceId", "");
    if (str == null) {
      str = "";
    }
    Intrinsics.checkExpressionValueIsNotNull(str, "INNER_MMKV.getString(KEY_DEVICE_ID, \"\") ?: \"\"");
    return str;
  }
  
  public final void a(int paramInt, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, long paramLong1, long paramLong2, @NotNull String paramString4, @NotNull String paramString5)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "deviceId");
    Intrinsics.checkParameterIsNotNull(paramString2, "token");
    Intrinsics.checkParameterIsNotNull(paramString3, "username");
    Intrinsics.checkParameterIsNotNull(paramString4, "hostAppId");
    Intrinsics.checkParameterIsNotNull(paramString5, "extraData");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("update productId:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" deviceId:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" hostAppId:");
    localStringBuilder.append(paramString4);
    o.e("Luggage.WxaDeviceInfo", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("update token:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" syncTime:");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(" expireTime:");
    localStringBuilder.append(paramLong2);
    o.e("Luggage.WxaDeviceInfo", localStringBuilder.toString());
    b.putInt("productId", paramInt);
    b.putString("deviceId", paramString1);
    b.putString("username", paramString3);
    b.putString("token", paramString2);
    b.putLong("syncTime", paramLong1);
    b.putLong("expireTime", paramLong2);
    b.putString("hostAppId", paramString4);
    b.putString("extraData", paramString5);
    b.commit();
  }
  
  @NotNull
  public final String b()
  {
    String str = b.getString("username", "");
    if (str == null) {
      str = "";
    }
    Intrinsics.checkExpressionValueIsNotNull(str, "INNER_MMKV.getString(KEY_USERNAME, \"\") ?: \"\"");
    return str;
  }
  
  @NotNull
  public final String c()
  {
    String str = b.getString("token", "");
    if (str == null) {
      str = "";
    }
    Intrinsics.checkExpressionValueIsNotNull(str, "INNER_MMKV.getString(KEY_TOKEN, \"\") ?: \"\"");
    return str;
  }
  
  @NotNull
  public final String d()
  {
    String str = b.getString("hostAppId", "");
    if (str == null) {
      str = "";
    }
    Intrinsics.checkExpressionValueIsNotNull(str, "INNER_MMKV.getString(KEY_HOSTAPPID, \"\") ?: \"\"");
    return str;
  }
  
  public final long e()
  {
    return b.getLong("syncTime", 0L);
  }
  
  public final long f()
  {
    return b.getLong("expireTime", 0L);
  }
  
  public final boolean g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isActivate:");
    boolean bool;
    if (((CharSequence)c()).length() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    o.e("Luggage.WxaDeviceInfo", localStringBuilder.toString());
    return ((CharSequence)c()).length() > 0;
  }
  
  public final boolean h()
  {
    long l = e() + f() * 1000 - 10000;
    if (l < System.currentTimeMillis())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isValid false expireTimestamp:");
      localStringBuilder.append(l);
      localStringBuilder.append(' ');
      localStringBuilder.append(System.currentTimeMillis());
      o.e("Luggage.WxaDeviceInfo", localStringBuilder.toString());
      return false;
    }
    o.e("Luggage.WxaDeviceInfo", "isValid true");
    return true;
  }
  
  public final void i()
  {
    o.e("Luggage.WxaDeviceInfo", "reset");
    b.putInt("productId", -1);
    b.putString("deviceId", "");
    b.putString("username", "");
    b.putString("token", "");
    b.putLong("syncTime", 0L);
    b.putLong("expireTime", 0L);
    b.putString("hostAppId", "");
    b.putString("extraData", "");
    b.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dg.c
 * JD-Core Version:    0.7.0.1
 */