package com.squareup.wire;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/squareup/wire/AnyMessage$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/squareup/wire/AnyMessage;", "pack", "message", "Lcom/squareup/wire/Message;", "wire-runtime"}, k=1, mv={1, 1, 16})
public final class AnyMessage$Companion
{
  @NotNull
  public final AnyMessage pack(@NotNull Message<?, ?> paramMessage)
  {
    Intrinsics.checkParameterIsNotNull(paramMessage, "message");
    Object localObject = paramMessage.adapter().getTypeUrl();
    if (localObject != null) {
      return new AnyMessage((String)localObject, paramMessage.encodeByteString());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("recompile ");
    ((StringBuilder)localObject).append(Reflection.getOrCreateKotlinClass(paramMessage.getClass()));
    ((StringBuilder)localObject).append(" to use it with AnyMessage");
    throw ((Throwable)new IllegalStateException(((StringBuilder)localObject).toString().toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.AnyMessage.Companion
 * JD-Core Version:    0.7.0.1
 */