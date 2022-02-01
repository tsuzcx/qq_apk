package com.tencent.luggage.wxa.dd;

import android.os.Looper;
import com.tencent.luggage.wxa.qy.a;
import com.tencent.luggage.wxa.qz.w;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/account/SessionInfoShare;", "Lcom/tencent/luggage/login/account/SessionInfo;", "()V", "AES_KEY", "", "TAG", "value", "", "expiresIn", "getExpiresIn", "()I", "setExpiresIn", "(I)V", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "oauthCode", "getOauthCode", "()Ljava/lang/String;", "setOauthCode", "(Ljava/lang/String;)V", "openId", "getOpenId", "setOpenId", "runtimeAppId", "getRuntimeAppId", "setRuntimeAppId", "sessionKey", "getSessionKey", "setSessionKey", "uin", "getUin", "setUin", "updateTimeStamp", "getUpdateTimeStamp", "setUpdateTimeStamp", "clear", "", "toString", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class h
  extends g
{
  public static final h b = new h();
  private static final Lazy c = LazyKt.lazy((Function0)h.a.a);
  
  private final w k()
  {
    return (w)c.getValue();
  }
  
  @NotNull
  public String a()
  {
    Object localObject = k();
    if (localObject != null)
    {
      localObject = ((w)localObject).getString("sessionKey", "");
      if (localObject != null) {
        return localObject;
      }
    }
    return "";
  }
  
  public void a(int paramInt)
  {
    w localw = k();
    if (localw != null) {
      localw.putInt("updateTimeStamp", paramInt);
    }
    localw = k();
    if (localw != null) {
      localw.commit();
    }
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    w localw = k();
    if (localw != null) {
      localw.putString("sessionKey", paramString);
    }
    a(h());
    paramString = k();
    if (paramString != null) {
      paramString.commit();
    }
  }
  
  public int b()
  {
    w localw = k();
    if (localw != null) {
      return localw.getInt("updateTimeStamp", -1);
    }
    return 0;
  }
  
  public void b(int paramInt)
  {
    a.a.a((com.tencent.luggage.wxa.qy.b)new com.tencent.luggage.wxa.dh.b(paramInt), Looper.getMainLooper());
    w localw = k();
    if (localw != null) {
      localw.putInt("uin", paramInt);
    }
    localw = k();
    if (localw != null) {
      localw.commit();
    }
  }
  
  public void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    w localw = k();
    if (localw != null) {
      localw.putString("oauthCode", paramString);
    }
    paramString = k();
    if (paramString != null) {
      paramString.commit();
    }
  }
  
  public int c()
  {
    w localw = k();
    int i = -1;
    if (localw != null) {
      i = localw.getInt("uin", -1);
    }
    return i;
  }
  
  public void c(int paramInt)
  {
    w localw = k();
    if (localw != null) {
      localw.putInt("expiresIn", paramInt);
    }
    localw = k();
    if (localw != null) {
      localw.commit();
    }
  }
  
  public void c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    w localw = k();
    if (localw != null) {
      localw.putString("runtimeAppId", paramString);
    }
    paramString = k();
    if (paramString != null) {
      paramString.commit();
    }
  }
  
  @NotNull
  public String d()
  {
    Object localObject = k();
    if (localObject != null)
    {
      localObject = ((w)localObject).getString("oauthCode", "");
      if (localObject != null) {
        return localObject;
      }
    }
    return "";
  }
  
  public void d(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    w localw = k();
    if (localw != null) {
      localw.putString("openId", paramString);
    }
    paramString = k();
    if (paramString != null) {
      paramString.commit();
    }
  }
  
  @NotNull
  public String e()
  {
    Object localObject = k();
    if (localObject != null)
    {
      localObject = ((w)localObject).getString("runtimeAppId", "");
      if (localObject != null) {
        return localObject;
      }
    }
    return "";
  }
  
  public int f()
  {
    w localw = k();
    int i = -1;
    if (localw != null) {
      i = localw.getInt("expiresIn", -1);
    }
    return i;
  }
  
  @NotNull
  public String g()
  {
    Object localObject = k();
    if (localObject != null)
    {
      localObject = ((w)localObject).getString("openId", "");
      if (localObject != null) {
        return localObject;
      }
    }
    return "";
  }
  
  public final void j()
  {
    b(0);
    a("");
    a(0);
    b("");
    c("");
    c((int)604800L);
  }
  
  @NotNull
  public String toString()
  {
    Object localObject = StringCompanionObject.INSTANCE;
    localObject = Locale.US;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Locale.US");
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = Integer.valueOf(c());
    arrayOfObject[1] = a();
    arrayOfObject[2] = d();
    arrayOfObject[3] = e();
    arrayOfObject[4] = Integer.valueOf(f());
    localObject = String.format((Locale)localObject, "session(uin: %s, sessionKey: %s, oauthCode: %s, runtimeAppId: %s，expiresIn: %d)", Arrays.copyOf(arrayOfObject, arrayOfObject.length));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(locale, format, *args)");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dd.h
 * JD-Core Version:    0.7.0.1
 */