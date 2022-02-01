package com.squareup.wire;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/squareup/wire/ProtoAdapterKt$commonString$1", "Lcom/squareup/wire/ProtoAdapter;", "", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "wire-runtime"}, k=1, mv={1, 1, 16})
public final class ProtoAdapterKt$commonString$1
  extends ProtoAdapter<String>
{
  ProtoAdapterKt$commonString$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public String decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    return paramProtoReader.readString();
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    paramProtoWriter.writeString(paramString);
  }
  
  public int encodedSize(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    return (int)Utf8.size$default(paramString, 0, 0, 3, null);
  }
  
  @NotNull
  public String redact(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    throw ((Throwable)new UnsupportedOperationException());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.ProtoAdapterKt.commonString.1
 * JD-Core Version:    0.7.0.1
 */