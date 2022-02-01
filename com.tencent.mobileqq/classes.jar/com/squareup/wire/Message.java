package com.squareup.wire;

import java.io.OutputStream;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/squareup/wire/Message;", "M", "B", "Lcom/squareup/wire/Message$Builder;", "Ljava/io/Serializable;", "adapter", "Lcom/squareup/wire/ProtoAdapter;", "unknownFields", "Lokio/ByteString;", "(Lcom/squareup/wire/ProtoAdapter;Lokio/ByteString;)V", "()Lcom/squareup/wire/ProtoAdapter;", "cachedSerializedSize", "", "getCachedSerializedSize$wire_runtime", "()I", "setCachedSerializedSize$wire_runtime", "(I)V", "hashCode", "()Lokio/ByteString;", "encode", "", "", "stream", "Ljava/io/OutputStream;", "sink", "Lokio/BufferedSink;", "encodeByteString", "newBuilder", "()Lcom/squareup/wire/Message$Builder;", "toString", "", "withoutUnknownFields", "()Lcom/squareup/wire/Message;", "writeReplace", "", "Builder", "Companion", "wire-runtime"}, k=1, mv={1, 1, 16})
public abstract class Message<M extends Message<M, B>, B extends Message.Builder<M, B>>
  implements Serializable
{
  public static final Message.Companion Companion = new Message.Companion(null);
  private static final long serialVersionUID = 0L;
  @NotNull
  private final transient ProtoAdapter<M> adapter;
  private transient int cachedSerializedSize;
  @JvmField
  protected transient int hashCode;
  @NotNull
  private final transient ByteString unknownFields;
  
  protected Message(@NotNull ProtoAdapter<M> paramProtoAdapter, @NotNull ByteString paramByteString)
  {
    this.adapter = paramProtoAdapter;
    this.unknownFields = paramByteString;
  }
  
  @JvmName(name="adapter")
  @NotNull
  public final ProtoAdapter<M> adapter()
  {
    return this.adapter;
  }
  
  public final void encode(@NotNull OutputStream paramOutputStream)
  {
    Intrinsics.checkParameterIsNotNull(paramOutputStream, "stream");
    this.adapter.encode(paramOutputStream, (Message)this);
  }
  
  public final void encode(@NotNull BufferedSink paramBufferedSink)
  {
    Intrinsics.checkParameterIsNotNull(paramBufferedSink, "sink");
    this.adapter.encode(paramBufferedSink, (Message)this);
  }
  
  @NotNull
  public final byte[] encode()
  {
    return this.adapter.encode((Message)this);
  }
  
  @NotNull
  public final ByteString encodeByteString()
  {
    return this.adapter.encodeByteString((Message)this);
  }
  
  public final int getCachedSerializedSize$wire_runtime()
  {
    return this.cachedSerializedSize;
  }
  
  @NotNull
  public abstract B newBuilder();
  
  public final void setCachedSerializedSize$wire_runtime(int paramInt)
  {
    this.cachedSerializedSize = paramInt;
  }
  
  @NotNull
  public String toString()
  {
    return this.adapter.toString((Message)this);
  }
  
  @JvmName(name="unknownFields")
  @NotNull
  public final ByteString unknownFields()
  {
    ByteString localByteString2 = this.unknownFields;
    ByteString localByteString1 = localByteString2;
    if (localByteString2 == null) {
      localByteString1 = ByteString.EMPTY;
    }
    return localByteString1;
  }
  
  @NotNull
  public final M withoutUnknownFields()
  {
    return newBuilder().clearUnknownFields().build();
  }
  
  @NotNull
  protected final Object writeReplace()
  {
    byte[] arrayOfByte = encode();
    Class localClass = getClass();
    if (localClass != null) {
      return new MessageSerializedForm(arrayOfByte, localClass);
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<M>");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.Message
 * JD-Core Version:    0.7.0.1
 */