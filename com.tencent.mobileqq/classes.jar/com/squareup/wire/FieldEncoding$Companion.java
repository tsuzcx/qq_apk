package com.squareup.wire;

import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/squareup/wire/FieldEncoding$Companion;", "", "()V", "get", "Lcom/squareup/wire/FieldEncoding;", "value", "", "get$wire_runtime", "wire-runtime"}, k=1, mv={1, 1, 16})
public final class FieldEncoding$Companion
{
  @JvmStatic
  @NotNull
  public final FieldEncoding get$wire_runtime(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt == 5) {
            return FieldEncoding.FIXED32;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unexpected FieldEncoding: ");
          localStringBuilder.append(paramInt);
          throw ((Throwable)new ProtocolException(localStringBuilder.toString()));
        }
        return FieldEncoding.LENGTH_DELIMITED;
      }
      return FieldEncoding.FIXED64;
    }
    return FieldEncoding.VARINT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.FieldEncoding.Companion
 * JD-Core Version:    0.7.0.1
 */