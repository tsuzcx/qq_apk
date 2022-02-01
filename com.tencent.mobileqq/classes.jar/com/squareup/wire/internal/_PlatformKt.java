package com.squareup.wire.internal;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"camelCase", "", "string", "toUnmodifiableList", "", "T", "", "toUnmodifiableMap", "", "K", "V", "", "ObjectStreamException", "Ljava/io/ObjectStreamException;", "ProtocolException", "Ljava/net/ProtocolException;", "Serializable", "Ljava/io/Serializable;", "Throws", "Lkotlin/jvm/Throws;", "wire-runtime"}, k=2, mv={1, 1, 16})
public final class _PlatformKt
{
  @NotNull
  public static final String camelCase(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "string");
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    int k;
    for (int i = 0;; i = k)
    {
      int j = 0;
      k = i;
      for (;;)
      {
        if (k >= paramString.length()) {
          break label141;
        }
        m = paramString.codePointAt(k);
        i = m;
        if (k == 0) {
          if (65 > m)
          {
            i = m;
          }
          else
          {
            i = m;
            if (90 >= m) {
              i = m + 32;
            }
          }
        }
        k += Character.charCount(i);
        if (i != 95) {
          break;
        }
        j = 1;
      }
      int m = i;
      if (j != 0) {
        if (97 > i)
        {
          m = i;
        }
        else
        {
          m = i;
          if (122 >= i) {
            m = i - 32;
          }
        }
      }
      localStringBuilder.appendCodePoint(m);
    }
    label141:
    paramString = localStringBuilder.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "StringBuilder(capacity).…builderAction).toString()");
    return paramString;
  }
  
  @NotNull
  public static final <T> List<T> toUnmodifiableList(@NotNull List<T> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "$this$toUnmodifiableList");
    paramList = Collections.unmodifiableList(paramList);
    Intrinsics.checkExpressionValueIsNotNull(paramList, "Collections.unmodifiableList(this)");
    return paramList;
  }
  
  @NotNull
  public static final <K, V> Map<K, V> toUnmodifiableMap(@NotNull Map<K, V> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$toUnmodifiableMap");
    paramMap = Collections.unmodifiableMap(paramMap);
    Intrinsics.checkExpressionValueIsNotNull(paramMap, "Collections.unmodifiableMap(this)");
    return paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.internal._PlatformKt
 * JD-Core Version:    0.7.0.1
 */