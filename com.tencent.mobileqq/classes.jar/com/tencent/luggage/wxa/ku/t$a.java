package com.tencent.luggage.wxa.ku;

import android.webkit.ValueCallback;
import com.tencent.luggage.wxa.dq.d.a;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.pd.l;
import com.tencent.luggage.wxa.pd.l.a;
import com.tencent.luggage.wxa.pd.m;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appcache.h;
import com.tencent.mm.plugin.appbrand.appcache.h.a;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.u;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.apache.commons.io.IOUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "loadJsFiles", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "paths", "Lorg/json/JSONArray;", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "scriptProvider", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "reportKey", "reporter", "Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$Reporter;", "toJavascriptInfo", "Lcom/tencent/luggage/sdk/jsapi/component/IAppBrandComponentWxaSharedLU$JavascriptInfo;", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader$FileEntry;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class t$a
{
  private final d.a a(@NotNull h.a parama)
  {
    d.a locala = new d.a();
    locala.a(parama);
    locala.c = parama.k;
    return locala;
  }
  
  @JvmStatic
  @JvmOverloads
  public final void a(@NotNull d paramd, @Nullable JSONArray paramJSONArray, @Nullable i parami, @Nullable h paramh, @Nullable String paramString, @Nullable t.b paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "runtime");
    long l1;
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0))
    {
      if ((parami != null) && (paramh != null))
      {
        String str = paramd.aa();
        l1 = af.d();
        d.a[] arrayOfa1 = new d.a[paramJSONArray.length()];
        int j = paramJSONArray.length();
        boolean[] arrayOfBoolean = new boolean[j];
        int i = 0;
        while (i < j)
        {
          arrayOfBoolean[i] = false;
          i += 1;
        }
        Object[] arrayOfObject1 = new Object[paramJSONArray.length()];
        j = paramJSONArray.length();
        i = 0;
        while (i < j)
        {
          Object localObject2 = paramJSONArray.optString(i, null);
          if (localObject2 != null)
          {
            Object localObject1;
            if (i == paramJSONArray.length() - 1) {
              localObject1 = (ValueCallback)new t.a.c(paramb, paramString, arrayOfa1, arrayOfBoolean, arrayOfObject1, l1);
            } else {
              localObject1 = null;
            }
            d.a[] arrayOfa2 = arrayOfa1;
            Object[] arrayOfObject2 = arrayOfObject1;
            int k = i;
            h.a locala = paramh.c((String)localObject2);
            Object localObject3;
            if (locala == null)
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("loadJsFiles appId[");
              ((StringBuilder)localObject3).append(str);
              ((StringBuilder)localObject3).append("] path[");
              ((StringBuilder)localObject3).append((String)localObject2);
              ((StringBuilder)localObject3).append("] EMPTY");
              o.b("Luggage.WXA.JsApiLoadJsFiles", ((StringBuilder)localObject3).toString());
              if (localObject1 != null) {
                ((ValueCallback)localObject1).onReceiveValue("404");
              }
              arrayOfa2[k] = ((d.a)null);
              arrayOfBoolean[k] = false;
              arrayOfObject2[k] = null;
            }
            for (;;)
            {
              break;
              localObject3 = ((a)this).a(locala);
              ((d.a)localObject3).a = ((String)localObject2);
              arrayOfa2[k] = localObject3;
              if ((u)parami.a(u.class) == null)
              {
                localObject2 = paramh.b((String)localObject2);
                if (localObject2 == null) {
                  Intrinsics.throwNpe();
                }
                localObject2 = IOUtils.toString((InputStream)localObject2, Charsets.UTF_8);
                if (localObject2 == null) {
                  localObject2 = "";
                }
                ((d.a)localObject3).b = ((String)localObject2);
                ((d.a)localObject3).c = ((String)localObject2).length();
                l.a(parami, (String)localObject2, (l.a)new t.a.a(arrayOfBoolean, k, (ValueCallback)localObject1));
              }
              else
              {
                localObject1 = (l.a)new t.a.b((ValueCallback)localObject1, arrayOfBoolean, k, (d.a)localObject3, arrayOfObject2);
                m.a(paramd, parami, (String)localObject2, locala, (l.a)localObject1);
              }
            }
          }
          i += 1;
        }
      }
      return;
    }
    if (paramb != null)
    {
      l1 = af.d();
      long l2 = af.d();
      paramb.a(paramString, new d.a[0], new boolean[0], new Object[0], l1, l2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.t.a
 * JD-Core Version:    0.7.0.1
 */