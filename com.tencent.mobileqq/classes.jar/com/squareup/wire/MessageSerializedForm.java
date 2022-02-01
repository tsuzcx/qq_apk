package com.squareup.wire;

import java.io.IOException;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/squareup/wire/MessageSerializedForm;", "M", "Lcom/squareup/wire/Message;", "B", "Lcom/squareup/wire/Message$Builder;", "Ljava/io/Serializable;", "bytes", "", "messageClass", "Ljava/lang/Class;", "([BLjava/lang/Class;)V", "readResolve", "", "Companion", "wire-runtime"}, k=1, mv={1, 1, 16})
public final class MessageSerializedForm<M extends Message<M, B>, B extends Message.Builder<M, B>>
  implements Serializable
{
  public static final MessageSerializedForm.Companion Companion = new MessageSerializedForm.Companion(null);
  private static final long serialVersionUID = 0L;
  private final byte[] bytes;
  private final Class<M> messageClass;
  
  public MessageSerializedForm(@NotNull byte[] paramArrayOfByte, @NotNull Class<M> paramClass)
  {
    this.bytes = paramArrayOfByte;
    this.messageClass = paramClass;
  }
  
  @NotNull
  public final Object readResolve()
  {
    Object localObject = ProtoAdapter.Companion.get(this.messageClass);
    try
    {
      localObject = ((ProtoAdapter)localObject).decode(this.bytes);
      return localObject;
    }
    catch (IOException localIOException)
    {
      throw ((Throwable)new StreamCorruptedException(localIOException.getMessage()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.MessageSerializedForm
 * JD-Core Version:    0.7.0.1
 */