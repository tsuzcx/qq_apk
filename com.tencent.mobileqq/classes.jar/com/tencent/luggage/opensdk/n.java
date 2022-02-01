package com.tencent.luggage.opensdk;

import android.text.TextUtils;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rm.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/opensdk/QRCodeTransferLongPullingConnect;", "", "()V", "extractKeyValue", "", "", "respStr", "replaceLast", "str", "oldValue", "newValue", "startConnect", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "env", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "uuid", "callback", "Lcom/tencent/luggage/opensdk/QRCodeTransferLongPullingConnect$LongPullingCallback;", "Connector", "LongPullingCallback", "PullingConstants", "PullingErrCode", "PullingState", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class n
{
  public static final n a = new n();
  
  @JvmStatic
  @NotNull
  public static final a a(@NotNull h paramh, @NotNull String paramString, @NotNull n.b paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramh, "env");
    Intrinsics.checkParameterIsNotNull(paramString, "uuid");
    Intrinsics.checkParameterIsNotNull(paramb, "callback");
    paramh = new n.a(paramh, paramString, paramb);
    paramh.e();
    return (a)paramh;
  }
  
  private final String a(String paramString1, String paramString2, String paramString3)
  {
    CharSequence localCharSequence = (CharSequence)paramString1;
    int i = StringsKt.lastIndexOf$default(localCharSequence, paramString2, 0, false, 6, null);
    if (i < 0) {
      return paramString1;
    }
    int j = paramString2.length();
    if (paramString1 != null) {
      return StringsKt.replaceRange(localCharSequence, i, j + i, (CharSequence)paramString3).toString();
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
  }
  
  private final Map<String, String> a(String paramString)
  {
    paramString = (CharSequence)paramString;
    if (TextUtils.isEmpty(paramString)) {
      return MapsKt.emptyMap();
    }
    HashMap localHashMap = new HashMap();
    paramString = new Regex(";").split(paramString, 0);
    ListIterator localListIterator;
    int i;
    if (!paramString.isEmpty())
    {
      localListIterator = paramString.listIterator(paramString.size());
      while (localListIterator.hasPrevious())
      {
        if (((CharSequence)localListIterator.previous()).length() == 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 0)
        {
          paramString = CollectionsKt.take((Iterable)paramString, localListIterator.nextIndex() + 1);
          break label129;
        }
      }
    }
    paramString = CollectionsKt.emptyList();
    label129:
    paramString = ((Collection)paramString).toArray(new String[0]);
    if (paramString != null)
    {
      paramString = (String[])paramString;
      int j = paramString.length;
      i = 0;
      while (i < j)
      {
        localListIterator = paramString[i];
        Object localObject = (CharSequence)localListIterator;
        int k;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          k = StringsKt.indexOf$default((CharSequence)localObject, '=', 0, false, 6, null);
          if (localListIterator == null) {}
        }
        try
        {
          localObject = localListIterator.substring(0, k);
          Intrinsics.checkExpressionValueIsNotNull(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          if (localListIterator != null)
          {
            str = localListIterator.substring(k + 1);
            Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.String).substring(startIndex)");
            ((Map)localHashMap).put(localObject, str);
            break label333;
          }
          throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        catch (Exception localException)
        {
          String str;
          break label282;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        label282:
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("extractKeyValue kv-pair=");
        ((StringBuilder)localObject).append(localListIterator);
        ((StringBuilder)localObject).append(", e=");
        ((StringBuilder)localObject).append(str);
        o.b("Luggage.QRCodeTransferLongPullingConnect", ((StringBuilder)localObject).toString());
        label333:
        i += 1;
      }
      return (Map)localHashMap;
    }
    else
    {
      paramString = new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
      for (;;)
      {
        throw paramString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.n
 * JD-Core Version:    0.7.0.1
 */