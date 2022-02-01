package com.squareup.wire;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/squareup/wire/ProtoAdapterKt$commonUint64$1", "Lcom/squareup/wire/ProtoAdapter;", "", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "(Lcom/squareup/wire/ProtoReader;)Ljava/lang/Long;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "(J)Ljava/lang/Long;", "wire-runtime"}, k=1, mv={1, 1, 16})
public final class ProtoAdapterKt$commonUint64$1
  extends ProtoAdapter<Long>
{
  ProtoAdapterKt$commonUint64$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public Long decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    return Long.valueOf(paramProtoReader.readVarint64());
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    paramProtoWriter.writeVarint64(paramLong);
  }
  
  public int encodedSize(long paramLong)
  {
    return ProtoWriter.Companion.varint64Size$wire_runtime(paramLong);
  }
  
  @NotNull
  public Long redact(long paramLong)
  {
    throw ((Throwable)new UnsupportedOperationException());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.ProtoAdapterKt.commonUint64.1
 * JD-Core Version:    0.7.0.1
 */