package com.squareup.wire;

import java.io.Closeable;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/squareup/wire/MessageSource;", "T", "", "Ljava/io/Closeable;", "read", "()Ljava/lang/Object;", "wire-runtime"}, k=1, mv={1, 1, 16})
public abstract interface MessageSource<T>
  extends Closeable
{
  @Nullable
  public abstract T read();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.MessageSource
 * JD-Core Version:    0.7.0.1
 */