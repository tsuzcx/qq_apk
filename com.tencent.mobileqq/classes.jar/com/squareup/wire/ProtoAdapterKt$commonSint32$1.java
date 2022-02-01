package com.squareup.wire;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/squareup/wire/ProtoAdapterKt$commonSint32$1", "Lcom/squareup/wire/ProtoAdapter;", "", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "(Lcom/squareup/wire/ProtoReader;)Ljava/lang/Integer;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "redact", "(I)Ljava/lang/Integer;", "wire-runtime"}, k=1, mv={1, 1, 16})
public final class ProtoAdapterKt$commonSint32$1
  extends ProtoAdapter<Integer>
{
  ProtoAdapterKt$commonSint32$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public Integer decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    return Integer.valueOf(ProtoWriter.Companion.decodeZigZag32$wire_runtime(paramProtoReader.readVarint32()));
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    paramProtoWriter.writeVarint32(ProtoWriter.Companion.encodeZigZag32$wire_runtime(paramInt));
  }
  
  public int encodedSize(int paramInt)
  {
    return ProtoWriter.Companion.varint32Size$wire_runtime(ProtoWriter.Companion.encodeZigZag32$wire_runtime(paramInt));
  }
  
  @NotNull
  public Integer redact(int paramInt)
  {
    throw ((Throwable)new UnsupportedOperationException());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.ProtoAdapterKt.commonSint32.1
 * JD-Core Version:    0.7.0.1
 */