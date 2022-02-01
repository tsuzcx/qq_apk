package com.tencent.luggage.wxa.nf;

import java.util.Collection;
import java.util.Formatter;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$Companion;", "", "()V", "TAG", "", "getFormatTime", "timeMs", "", "getMsTime", "", "formatTime", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class b$c
{
  public final long a(@Nullable String paramString)
  {
    Object localObject1 = String.valueOf(paramString);
    Object localObject2 = (CharSequence)localObject1;
    paramString = (String)localObject1;
    int i;
    if (StringsKt.lastIndexOf$default((CharSequence)localObject2, ".", 0, false, 6, null) != -1)
    {
      i = StringsKt.lastIndexOf$default((CharSequence)localObject2, ".", 0, false, 6, null);
      if (localObject1 != null)
      {
        paramString = ((String)localObject1).substring(0, i);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
    }
    localObject1 = (CharSequence)paramString;
    localObject1 = new Regex(":").split((CharSequence)localObject1, 0);
    if (!((List)localObject1).isEmpty())
    {
      localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
      while (((ListIterator)localObject2).hasPrevious())
      {
        if (((CharSequence)((ListIterator)localObject2).previous()).length() == 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 0)
        {
          localObject1 = CollectionsKt.take((Iterable)localObject1, ((ListIterator)localObject2).nextIndex() + 1);
          break label181;
        }
      }
    }
    localObject1 = CollectionsKt.emptyList();
    label181:
    localObject1 = ((Collection)localObject1).toArray(new String[0]);
    if (localObject1 != null)
    {
      localObject1 = (String[])localObject1;
      if (localObject1.length == 3) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return (Long.parseLong(localObject1[0]) * 3600 + Long.parseLong(localObject1[1]) * 60 + Long.parseLong(localObject1[2])) * 1000;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Can't parse time string: ");
      ((StringBuilder)localObject1).append(paramString);
      throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject1).toString().toString()));
    }
    paramString = new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    for (;;)
    {
      throw paramString;
    }
  }
  
  @NotNull
  public final String a(int paramInt)
  {
    Object localObject = new StringBuilder();
    Formatter localFormatter = new Formatter((Appendable)localObject, Locale.getDefault());
    paramInt /= 1000;
    int i = paramInt / 60;
    int j = paramInt / 3600;
    ((StringBuilder)localObject).setLength(0);
    localObject = localFormatter.format("%02d:%02d:%02d", new Object[] { Integer.valueOf(j), Integer.valueOf(i % 60), Integer.valueOf(paramInt % 60) }).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "formatter.format(\"%02d:%…utes, seconds).toString()");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nf.b.c
 * JD-Core Version:    0.7.0.1
 */