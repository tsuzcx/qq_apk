package com.squareup.wire.internal;

import com.squareup.wire.ProtoAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={"com/squareup/wire/internal/Internal__InternalJvmKt", "com/squareup/wire/internal/Internal__InternalKt"}, k=4, mv={1, 1, 16})
public final class Internal
{
  @JvmName(name="-redactElements")
  @NotNull
  public static final <T> List<T> -redactElements(@NotNull List<? extends T> paramList, @NotNull ProtoAdapter<T> paramProtoAdapter)
  {
    return Internal__InternalKt.-redactElements(paramList, paramProtoAdapter);
  }
  
  @JvmName(name="-redactElements")
  @NotNull
  public static final <K, V> Map<K, V> -redactElements(@NotNull Map<K, ? extends V> paramMap, @NotNull ProtoAdapter<V> paramProtoAdapter)
  {
    return Internal__InternalKt.-redactElements(paramMap, paramProtoAdapter);
  }
  
  public static final void checkElementsNotNull(@NotNull List<?> paramList)
  {
    Internal__InternalKt.checkElementsNotNull(paramList);
  }
  
  public static final void checkElementsNotNull(@NotNull Map<?, ?> paramMap)
  {
    Internal__InternalKt.checkElementsNotNull(paramMap);
  }
  
  @Deprecated(message="Please regenerate code using wire-compiler version 3.0.0 or higher.", replaceWith=@ReplaceWith(expression="com.squareup.internal.Internal.copyOf(list)", imports={}))
  @NotNull
  public static final <T> List<T> copyOf(@NotNull String paramString, @Nullable List<? extends T> paramList)
  {
    return Internal__InternalKt.copyOf(paramString, paramList);
  }
  
  @NotNull
  public static final <T> List<T> copyOf(@NotNull List<? extends T> paramList)
  {
    return Internal__InternalKt.copyOf(paramList);
  }
  
  @Deprecated(message="Please regenerate code using wire-compiler version 3.0.0 or higher.", replaceWith=@ReplaceWith(expression="com.squareup.internal.Internal.copyOf(map)", imports={}))
  @NotNull
  public static final <K, V> Map<K, V> copyOf(@NotNull String paramString, @Nullable Map<K, ? extends V> paramMap)
  {
    return Internal__InternalKt.copyOf(paramString, paramMap);
  }
  
  @NotNull
  public static final <K, V> Map<K, V> copyOf(@NotNull Map<K, ? extends V> paramMap)
  {
    return Internal__InternalKt.copyOf(paramMap);
  }
  
  public static final int countNonNull(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    return Internal__InternalKt.countNonNull(paramObject1, paramObject2);
  }
  
  public static final int countNonNull(@Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3)
  {
    return Internal__InternalKt.countNonNull(paramObject1, paramObject2, paramObject3);
  }
  
  public static final int countNonNull(@Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3, @Nullable Object paramObject4, @NotNull Object... paramVarArgs)
  {
    return Internal__InternalKt.countNonNull(paramObject1, paramObject2, paramObject3, paramObject4, paramVarArgs);
  }
  
  public static final boolean equals(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    return Internal__InternalKt.equals(paramObject1, paramObject2);
  }
  
  @NotNull
  public static final <T> List<T> immutableCopyOf(@NotNull String paramString, @NotNull List<? extends T> paramList)
  {
    return Internal__InternalKt.immutableCopyOf(paramString, paramList);
  }
  
  @NotNull
  public static final <K, V> Map<K, V> immutableCopyOf(@NotNull String paramString, @NotNull Map<K, ? extends V> paramMap)
  {
    return Internal__InternalKt.immutableCopyOf(paramString, paramMap);
  }
  
  @NotNull
  public static final IllegalStateException missingRequiredFields(@NotNull Object... paramVarArgs)
  {
    return Internal__InternalKt.missingRequiredFields(paramVarArgs);
  }
  
  @NotNull
  public static final <T> List<T> newMutableList()
  {
    return Internal__InternalKt.newMutableList();
  }
  
  @NotNull
  public static final <K, V> Map<K, V> newMutableMap()
  {
    return Internal__InternalKt.newMutableMap();
  }
  
  public static final <T> void redactElements(@NotNull List<T> paramList, @NotNull ProtoAdapter<T> paramProtoAdapter)
  {
    Internal__InternalJvmKt.redactElements(paramList, paramProtoAdapter);
  }
  
  public static final <T> void redactElements(@NotNull Map<?, T> paramMap, @NotNull ProtoAdapter<T> paramProtoAdapter)
  {
    Internal__InternalJvmKt.redactElements(paramMap, paramProtoAdapter);
  }
  
  @NotNull
  public static final String sanitize(@NotNull String paramString)
  {
    return Internal__InternalKt.sanitize(paramString);
  }
  
  @NotNull
  public static final String sanitize(@NotNull List<String> paramList)
  {
    return Internal__InternalKt.sanitize(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.internal.Internal
 * JD-Core Version:    0.7.0.1
 */