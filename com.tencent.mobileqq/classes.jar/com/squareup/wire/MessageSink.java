package com.squareup.wire;

import java.io.Closeable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/squareup/wire/MessageSink;", "T", "", "Ljava/io/Closeable;", "cancel", "", "write", "message", "(Ljava/lang/Object;)V", "wire-runtime"}, k=1, mv={1, 1, 16})
public abstract interface MessageSink<T>
  extends Closeable
{
  public abstract void cancel();
  
  public abstract void write(@NotNull T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.MessageSink
 * JD-Core Version:    0.7.0.1
 */