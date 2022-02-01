package com.tencent.luggage.wxa.cu;

import com.tencent.luggage.wxa.jx.m;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/jsapi/webview/jsapi/HTMLWebViewJsApiPool$collectApis$map$1", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "containsKey", "", "key", "get", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class h$a
  extends HashMap<String, m>
{
  public m a(String paramString, m paramm)
  {
    return (m)super.getOrDefault(paramString, paramm);
  }
  
  public Set a()
  {
    return super.entrySet();
  }
  
  public boolean a(m paramm)
  {
    return super.containsValue(paramm);
  }
  
  public boolean a(@Nullable String paramString)
  {
    Object localObject = (CharSequence)paramString;
    int i;
    if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return false;
    }
    localObject = Locale.ENGLISH;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Locale.ENGLISH");
    if (paramString != null)
    {
      paramString = paramString.toLowerCase((Locale)localObject);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).toLowerCase(locale)");
      return super.containsKey(paramString);
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  @Nullable
  public m b(@Nullable String paramString)
  {
    Object localObject = (CharSequence)paramString;
    int i;
    if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return null;
    }
    localObject = Locale.ENGLISH;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Locale.ENGLISH");
    if (paramString != null)
    {
      paramString = paramString.toLowerCase((Locale)localObject);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).toLowerCase(locale)");
      return (m)super.get(paramString);
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  public Set b()
  {
    return super.keySet();
  }
  
  public boolean b(String paramString, m paramm)
  {
    return super.remove(paramString, paramm);
  }
  
  public m c(String paramString)
  {
    return (m)super.remove(paramString);
  }
  
  public Collection c()
  {
    return super.values();
  }
  
  public final boolean containsKey(Object paramObject)
  {
    boolean bool;
    if (paramObject != null) {
      bool = paramObject instanceof String;
    } else {
      bool = true;
    }
    if (bool) {
      return a((String)paramObject);
    }
    return false;
  }
  
  public final boolean containsValue(Object paramObject)
  {
    if ((paramObject instanceof m)) {
      return a((m)paramObject);
    }
    return false;
  }
  
  public int d()
  {
    return super.size();
  }
  
  public final Set<Map.Entry<String, m>> entrySet()
  {
    return a();
  }
  
  public final Object get(Object paramObject)
  {
    boolean bool;
    if (paramObject != null) {
      bool = paramObject instanceof String;
    } else {
      bool = true;
    }
    if (bool) {
      return b((String)paramObject);
    }
    return null;
  }
  
  public final Object getOrDefault(Object paramObject1, Object paramObject2)
  {
    boolean bool;
    if (paramObject1 != null) {
      bool = paramObject1 instanceof String;
    } else {
      bool = true;
    }
    if (bool) {
      return a((String)paramObject1, (m)paramObject2);
    }
    return paramObject2;
  }
  
  public final Set<String> keySet()
  {
    return b();
  }
  
  public final Object remove(Object paramObject)
  {
    boolean bool;
    if (paramObject != null) {
      bool = paramObject instanceof String;
    } else {
      bool = true;
    }
    if (bool) {
      return c((String)paramObject);
    }
    return null;
  }
  
  public final boolean remove(Object paramObject1, Object paramObject2)
  {
    boolean bool;
    if (paramObject1 != null) {
      bool = paramObject1 instanceof String;
    } else {
      bool = true;
    }
    if ((bool) && ((paramObject2 instanceof m))) {
      return b((String)paramObject1, (m)paramObject2);
    }
    return false;
  }
  
  public final int size()
  {
    return d();
  }
  
  public final Collection<m> values()
  {
    return c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cu.h.a
 * JD-Core Version:    0.7.0.1
 */