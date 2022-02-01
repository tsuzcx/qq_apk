package com.tencent.mm.plugin.appbrand.page;

import android.util.Base64;
import com.tencent.luggage.wxa.pd.k;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/MPPageScriptProviderDefaultImpl;", "Lcom/tencent/mm/plugin/appbrand/page/IMPPageScriptProvider;", "renderer", "Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;", "(Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;)V", "runtime", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "getRuntime", "()Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "provideScript", "", "resourceName", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public class at
  implements ap
{
  @Deprecated
  public static final at.a c = new at.a(null);
  private final a<?> a;
  
  public at(@NotNull a<?> parama)
  {
    this.a = parama;
  }
  
  private final com.tencent.luggage.wxa.ed.d a()
  {
    return this.a.n();
  }
  
  @Nullable
  public String a(@Nullable String paramString)
  {
    Object localObject1 = (CharSequence)paramString;
    int j = 0;
    int i;
    if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    Object localObject2 = null;
    if (i != 0) {
      return null;
    }
    localObject1 = com.tencent.luggage.wxa.dq.d.b;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "IAppBrandComponentWxaSha…U.SCRIPTS_LIB_FOR_WEBVIEW");
    Object localObject4;
    if (ArraysKt.contains((Object[])localObject1, paramString))
    {
      localObject1 = this.a.a(n.class);
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = ((n)localObject1).a(paramString);
    }
    else if (Intrinsics.areEqual(paramString, "app-wxss.js"))
    {
      localObject1 = a();
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = ad.a((com.tencent.luggage.wxa.iu.d)localObject1, "app-wxss.js");
    }
    else if (Intrinsics.areEqual(paramString, "page-frame.html"))
    {
      localObject1 = a();
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = v.c(ad.a((com.tencent.luggage.wxa.iu.d)localObject1, "page-frame.html"));
    }
    else if (Intrinsics.areEqual(paramString, this.a.u()))
    {
      localObject1 = a();
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject3 = ad.a((com.tencent.luggage.wxa.iu.d)localObject1, paramString);
      localObject1 = v.b((String)localObject3);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "extractStyle(pageHtml)");
      localObject4 = Charsets.UTF_8;
      if (localObject1 != null)
      {
        localObject1 = ((String)localObject1).getBytes((Charset)localObject4);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "(this as java.lang.String).getBytes(charset)");
        localObject1 = Base64.encodeToString((byte[])localObject1, 2);
        localObject4 = v.a((String)localObject3);
        Intrinsics.checkExpressionValueIsNotNull(localObject4, "extractPage(pageHtml)");
        Object localObject5 = Charsets.UTF_8;
        if (localObject4 != null)
        {
          localObject4 = ((String)localObject4).getBytes((Charset)localObject5);
          Intrinsics.checkExpressionValueIsNotNull(localObject4, "(this as java.lang.String).getBytes(charset)");
          localObject4 = Base64.encodeToString((byte[])localObject4, 2);
          localObject3 = v.c((String)localObject3);
          localObject5 = StringCompanionObject.INSTANCE;
          localObject5 = Locale.ENGLISH;
          Intrinsics.checkExpressionValueIsNotNull(localObject5, "Locale.ENGLISH");
          Object[] arrayOfObject = new Object[3];
          arrayOfObject[0] = localObject1;
          arrayOfObject[1] = localObject4;
          arrayOfObject[2] = localObject3;
          localObject1 = String.format((Locale)localObject5, "var style = document.createElement('style');style.innerHTML = atob(\"%s\");document.head.appendChild(style);var page = document.createElement('page');page.innerHTML = atob(\"%s\");document.body.appendChild(page);%s;", Arrays.copyOf(arrayOfObject, arrayOfObject.length));
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "java.lang.String.format(locale, format, *args)");
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
    }
    else
    {
      localObject1 = ad.a((com.tencent.luggage.wxa.iu.d)a(), paramString);
    }
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("provideScript name[");
    ((StringBuilder)localObject3).append(paramString);
    ((StringBuilder)localObject3).append("] source.length[");
    if (localObject1 != null) {
      i = ((String)localObject1).length();
    } else {
      i = -1;
    }
    ((StringBuilder)localObject3).append(i);
    ((StringBuilder)localObject3).append(']');
    o.d("Luggage.WXA.MPPageScriptProviderDefaultImpl", ((StringBuilder)localObject3).toString());
    localObject3 = (CharSequence)localObject1;
    if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      localObject2 = (at)this;
      localObject3 = com.tencent.luggage.wxa.dq.d.b;
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "SCRIPTS_LIB_FOR_WEBVIEW");
      if (!ArraysKt.contains((Object[])localObject3, paramString))
      {
        localObject3 = ((at)localObject2).a();
        if (localObject3 != null)
        {
          localObject3 = ((com.tencent.luggage.wxa.ed.d)localObject3).i();
          if ((localObject3 != null) && (((com.tencent.luggage.wxa.do.d)localObject3).b == true)) {}
        }
        else
        {
          paramString = "";
          break label722;
        }
      }
      localObject3 = new StringBuilder("https://servicewechat.com/");
      if (((at)localObject2).a() == null)
      {
        ((StringBuilder)localObject3).append("preload/");
      }
      else
      {
        localObject4 = ((at)localObject2).a();
        if (localObject4 == null) {
          Intrinsics.throwNpe();
        }
        ((StringBuilder)localObject3).append(((com.tencent.luggage.wxa.ed.d)localObject4).aa());
        ((StringBuilder)localObject3).append("/");
        localObject2 = ((at)localObject2).a();
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        ((StringBuilder)localObject3).append(((com.tencent.luggage.wxa.ed.d)localObject2).i().S.pkgVersion());
        ((StringBuilder)localObject3).append("/");
      }
      ((StringBuilder)localObject3).append(paramString);
      paramString = ((StringBuilder)localObject3).toString();
      Intrinsics.checkExpressionValueIsNotNull(paramString, "builder.append(resourceName).toString()");
      label722:
      Intrinsics.checkExpressionValueIsNotNull(paramString, "run makeSourceURL@{\n    …      }\n                }");
      i = j;
      if (((CharSequence)paramString).length() == 0) {
        i = 1;
      }
      if (i != 0) {
        return localObject1;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("\n//# sourceURL=");
      ((StringBuilder)localObject2).append(k.a(paramString));
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.at
 * JD-Core Version:    0.7.0.1
 */