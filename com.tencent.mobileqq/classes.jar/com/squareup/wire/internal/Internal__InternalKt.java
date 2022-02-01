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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"ESCAPED_CHARS", "", "checkElementsNotNull", "", "list", "", "map", "", "copyOf", "", "T", "name", "", "K", "V", "countNonNull", "", "a", "", "b", "c", "d", "rest", "", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)I", "equals", "", "immutableCopyOf", "missingRequiredFields", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "args", "([Ljava/lang/Object;)Ljava/lang/IllegalStateException;", "newMutableList", "newMutableMap", "sanitize", "value", "values", "redactElements", "adapter", "Lcom/squareup/wire/ProtoAdapter;", "-redactElements", "wire-runtime"}, k=5, mv={1, 1, 16}, xs="com/squareup/wire/internal/Internal")
final class Internal__InternalKt
{
  private static final String ESCAPED_CHARS = ",[]{}\\";
  
  @JvmName(name="-redactElements")
  @NotNull
  public static final <T> List<T> -redactElements(@NotNull List<? extends T> arg0, @NotNull ProtoAdapter<T> arg1) {}
  
  @JvmName(name="-redactElements")
  @NotNull
  public static final <K, V> Map<K, V> -redactElements(@NotNull Map<K, ? extends V> arg0, @NotNull ProtoAdapter<V> arg1) {}
  
  public static final void checkElementsNotNull(@NotNull List<?> arg0) {}
  
  public static final void checkElementsNotNull(@NotNull Map<?, ?> arg0) {}
  
  @Deprecated(message="Please regenerate code using wire-compiler version 3.0.0 or higher.", replaceWith=@ReplaceWith(expression="com.squareup.internal.Internal.copyOf(list)", imports={}))
  @NotNull
  public static final <T> List<T> copyOf(@NotNull String arg0, @Nullable List<? extends T> arg1) {}
  
  @NotNull
  public static final <T> List<T> copyOf(@NotNull List<? extends T> arg0) {}
  
  @Deprecated(message="Please regenerate code using wire-compiler version 3.0.0 or higher.", replaceWith=@ReplaceWith(expression="com.squareup.internal.Internal.copyOf(map)", imports={}))
  @NotNull
  public static final <K, V> Map<K, V> copyOf(@NotNull String arg0, @Nullable Map<K, ? extends V> arg1) {}
  
  @NotNull
  public static final <K, V> Map<K, V> copyOf(@NotNull Map<K, ? extends V> arg0) {}
  
  public static final int countNonNull(@Nullable Object arg0, @Nullable Object arg1) {}
  
  public static final int countNonNull(@Nullable Object arg0, @Nullable Object arg1, @Nullable Object arg2) {}
  
  public static final int countNonNull(@Nullable Object arg0, @Nullable Object arg1, @Nullable Object arg2, @Nullable Object arg3, @NotNull Object... arg4) {}
  
  public static final boolean equals(@Nullable Object arg0, @Nullable Object arg1) {}
  
  @NotNull
  public static final <T> List<T> immutableCopyOf(@NotNull String arg0, @NotNull List<? extends T> arg1) {}
  
  @NotNull
  public static final <K, V> Map<K, V> immutableCopyOf(@NotNull String arg0, @NotNull Map<K, ? extends V> arg1) {}
  
  @NotNull
  public static final IllegalStateException missingRequiredFields(@NotNull Object... arg0) {}
  
  @NotNull
  public static final <T> List<T> newMutableList() {}
  
  @NotNull
  public static final <K, V> Map<K, V> newMutableMap() {}
  
  @NotNull
  public static final String sanitize(@NotNull String arg0) {}
  
  @NotNull
  public static final String sanitize(@NotNull List<String> arg0) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.internal.Internal__InternalKt
 * JD-Core Version:    0.7.0.1
 */