package com.squareup.wire;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/squareup/wire/Message$Builder;", "M", "Lcom/squareup/wire/Message;", "B", "", "()V", "unknownFieldsBuffer", "Lokio/Buffer;", "getUnknownFieldsBuffer$wire_runtime", "()Lokio/Buffer;", "setUnknownFieldsBuffer$wire_runtime", "(Lokio/Buffer;)V", "unknownFieldsByteString", "Lokio/ByteString;", "getUnknownFieldsByteString$wire_runtime", "()Lokio/ByteString;", "setUnknownFieldsByteString$wire_runtime", "(Lokio/ByteString;)V", "unknownFieldsWriter", "Lcom/squareup/wire/ProtoWriter;", "getUnknownFieldsWriter$wire_runtime", "()Lcom/squareup/wire/ProtoWriter;", "setUnknownFieldsWriter$wire_runtime", "(Lcom/squareup/wire/ProtoWriter;)V", "addUnknownField", "tag", "", "fieldEncoding", "Lcom/squareup/wire/FieldEncoding;", "value", "addUnknownFields", "unknownFields", "build", "()Lcom/squareup/wire/Message;", "buildUnknownFields", "clearUnknownFields", "prepareForNewUnknownFields", "", "wire-runtime"}, k=1, mv={1, 1, 16})
public abstract class Message$Builder<M extends Message<M, B>, B extends Builder<M, B>>
{
  @Nullable
  private transient Buffer unknownFieldsBuffer;
  @NotNull
  private transient ByteString unknownFieldsByteString = ByteString.EMPTY;
  @Nullable
  private transient ProtoWriter unknownFieldsWriter;
  
  private final void prepareForNewUnknownFields()
  {
    if (this.unknownFieldsBuffer == null)
    {
      this.unknownFieldsBuffer = new Buffer();
      Object localObject = this.unknownFieldsBuffer;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      this.unknownFieldsWriter = new ProtoWriter((BufferedSink)localObject);
      localObject = this.unknownFieldsWriter;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      ((ProtoWriter)localObject).writeBytes(this.unknownFieldsByteString);
      this.unknownFieldsByteString = ByteString.EMPTY;
    }
  }
  
  @NotNull
  public final Builder<M, B> addUnknownField(int paramInt, @NotNull FieldEncoding paramFieldEncoding, @Nullable Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramFieldEncoding, "fieldEncoding");
    Builder localBuilder = (Builder)this;
    localBuilder.prepareForNewUnknownFields();
    paramFieldEncoding = paramFieldEncoding.rawProtoAdapter();
    if (paramFieldEncoding != null)
    {
      ProtoWriter localProtoWriter = localBuilder.unknownFieldsWriter;
      if (localProtoWriter == null) {
        Intrinsics.throwNpe();
      }
      paramFieldEncoding.encodeWithTag(localProtoWriter, paramInt, paramObject);
      return localBuilder;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
  }
  
  @NotNull
  public final Builder<M, B> addUnknownFields(@NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    Builder localBuilder = (Builder)this;
    if (paramByteString.size() > 0)
    {
      localBuilder.prepareForNewUnknownFields();
      ProtoWriter localProtoWriter = localBuilder.unknownFieldsWriter;
      if (localProtoWriter == null) {
        Intrinsics.throwNpe();
      }
      localProtoWriter.writeBytes(paramByteString);
    }
    return localBuilder;
  }
  
  @NotNull
  public abstract M build();
  
  @NotNull
  public final ByteString buildUnknownFields()
  {
    Buffer localBuffer = this.unknownFieldsBuffer;
    if (localBuffer != null)
    {
      if (localBuffer == null) {
        Intrinsics.throwNpe();
      }
      this.unknownFieldsByteString = localBuffer.readByteString();
      this.unknownFieldsBuffer = ((Buffer)null);
      this.unknownFieldsWriter = ((ProtoWriter)null);
    }
    return this.unknownFieldsByteString;
  }
  
  @NotNull
  public final Builder<M, B> clearUnknownFields()
  {
    Builder localBuilder = (Builder)this;
    localBuilder.unknownFieldsByteString = ByteString.EMPTY;
    Buffer localBuffer = localBuilder.unknownFieldsBuffer;
    if (localBuffer != null)
    {
      if (localBuffer == null) {
        Intrinsics.throwNpe();
      }
      localBuffer.clear();
      localBuilder.unknownFieldsBuffer = ((Buffer)null);
    }
    localBuilder.unknownFieldsWriter = ((ProtoWriter)null);
    return localBuilder;
  }
  
  @Nullable
  public final Buffer getUnknownFieldsBuffer$wire_runtime()
  {
    return this.unknownFieldsBuffer;
  }
  
  @NotNull
  public final ByteString getUnknownFieldsByteString$wire_runtime()
  {
    return this.unknownFieldsByteString;
  }
  
  @Nullable
  public final ProtoWriter getUnknownFieldsWriter$wire_runtime()
  {
    return this.unknownFieldsWriter;
  }
  
  public final void setUnknownFieldsBuffer$wire_runtime(@Nullable Buffer paramBuffer)
  {
    this.unknownFieldsBuffer = paramBuffer;
  }
  
  public final void setUnknownFieldsByteString$wire_runtime(@NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "<set-?>");
    this.unknownFieldsByteString = paramByteString;
  }
  
  public final void setUnknownFieldsWriter$wire_runtime(@Nullable ProtoWriter paramProtoWriter)
  {
    this.unknownFieldsWriter = paramProtoWriter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.Message.Builder
 * JD-Core Version:    0.7.0.1
 */