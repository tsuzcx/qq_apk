package com.squareup.wire;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/squareup/wire/ProtoAdapterKt$commonBytes$1", "Lcom/squareup/wire/ProtoAdapter;", "Lokio/ByteString;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "wire-runtime"}, k=1, mv={1, 1, 16})
public final class ProtoAdapterKt$commonBytes$1
  extends ProtoAdapter<ByteString>
{
  ProtoAdapterKt$commonBytes$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public ByteString decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    return paramProtoReader.readBytes();
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramByteString, "value");
    paramProtoWriter.writeBytes(paramByteString);
  }
  
  public int encodedSize(@NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "value");
    return paramByteString.size();
  }
  
  @NotNull
  public ByteString redact(@NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "value");
    throw ((Throwable)new UnsupportedOperationException());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.ProtoAdapterKt.commonBytes.1
 * JD-Core Version:    0.7.0.1
 */