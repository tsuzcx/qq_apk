package com.tencent.luggage.wxa.cv;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/jsapi/webview/model/WxaGetA8KeyCgiFactory;", "", "()V", "cgiInstanceMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/luggage/jsapi/webview/model/IlinkGetA8KeyUrlType;", "Lcom/tencent/luggage/jsapi/webview/model/CgiWxaGetA8Key;", "create", "reqUrl", "", "reason", "", "getA8KeyType", "notHttpUrl", "", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class k
{
  private final ConcurrentHashMap<d, a> a = new ConcurrentHashMap();
  
  private final boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!StringsKt.startsWith$default(paramString, "http://", false, 2, null))
    {
      bool1 = bool2;
      if (!StringsKt.startsWith$default(paramString, "https://", false, 2, null)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private final d b(String paramString, int paramInt)
  {
    if (paramInt == 5) {
      return d.d;
    }
    if ((StringsKt.isBlank((CharSequence)paramString) ^ true))
    {
      Object localObject4 = Uri.parse(paramString);
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "uri");
      Object localObject1 = ((Uri)localObject4).getHost();
      Object localObject2 = "";
      if (localObject1 == null) {
        localObject1 = "";
      }
      Object localObject3 = Locale.getDefault();
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "Locale.getDefault()");
      if (localObject1 != null)
      {
        localObject3 = ((String)localObject1).toLowerCase((Locale)localObject3);
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "(this as java.lang.String).toLowerCase(locale)");
        localObject1 = ((Uri)localObject4).getFragment();
        localObject4 = (CharSequence)localObject1;
        if ((localObject4 != null) && (((CharSequence)localObject4).length() != 0)) {
          paramInt = 0;
        } else {
          paramInt = 1;
        }
        if (paramInt != 0)
        {
          localObject1 = localObject2;
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append('#');
          ((StringBuilder)localObject2).append((String)localObject1);
          localObject1 = ((StringBuilder)localObject2).toString();
        }
        if (CollectionsKt.arrayListOf(new String[] { "open.weixin.qq.com", "mp.weixin.qq.com", "mp.weixinbridge.com" }).contains(localObject3)) {
          return d.b;
        }
        if (StringsKt.contains$default((CharSequence)localObject1, (CharSequence)"wechat_pay", false, 2, null)) {
          return d.c;
        }
        localObject1 = (CharSequence)localObject3;
        if ((!StringsKt.contains$default((CharSequence)localObject1, (CharSequence)".qq.com", false, 2, null)) && (!Intrinsics.areEqual(localObject3, "qq.com")) && (!StringsKt.contains$default((CharSequence)localObject1, (CharSequence)".wechat.com", false, 2, null)) && (!Intrinsics.areEqual(localObject3, "wechat.com")) && (!StringsKt.contains$default((CharSequence)localObject1, (CharSequence)".tenpay.com", false, 2, null)) && (!Intrinsics.areEqual(localObject3, "tenpay.com")) && (!StringsKt.contains$default((CharSequence)localObject1, (CharSequence)".url.cn", false, 2, null)) && (!Intrinsics.areEqual(localObject3, "url.com")) && (!a(paramString))) {
          return d.e;
        }
        return d.a;
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
    return d.a;
  }
  
  @NotNull
  public final a a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "reqUrl");
    paramString = b(paramString, paramInt);
    if (!this.a.contains(paramString))
    {
      Map localMap = (Map)this.a;
      Object localObject = paramString.c().newInstance();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "type.cgiInstanceClazz.newInstance()");
      localMap.put(paramString, localObject);
    }
    paramString = this.a.get(paramString);
    if (paramString == null) {
      Intrinsics.throwNpe();
    }
    return (a)paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cv.k
 * JD-Core Version:    0.7.0.1
 */