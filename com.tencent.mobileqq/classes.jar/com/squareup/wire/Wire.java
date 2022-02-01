package com.squareup.wire;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"get", "T", "value", "defaultValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "wire-runtime"}, k=2, mv={1, 1, 16})
@JvmName(name="Wire")
public final class Wire
{
  public static final <T> T get(@Nullable T paramT1, T paramT2)
  {
    if (paramT1 != null) {
      return paramT1;
    }
    return paramT2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.Wire
 * JD-Core Version:    0.7.0.1
 */