package com.squareup.wire;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"commonEncode", "", "E", "Lcom/squareup/wire/WireEnum;", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "(Lcom/squareup/wire/ProtoWriter;Lcom/squareup/wire/WireEnum;)V", "commonEncodedSize", "", "(Lcom/squareup/wire/WireEnum;)I", "commonRedact", "(Lcom/squareup/wire/WireEnum;)Lcom/squareup/wire/WireEnum;", "commonDecode", "Lcom/squareup/wire/EnumAdapter;", "reader", "Lcom/squareup/wire/ProtoReader;", "fromValue", "Lkotlin/Function1;", "(Lcom/squareup/wire/EnumAdapter;Lcom/squareup/wire/ProtoReader;Lkotlin/jvm/functions/Function1;)Lcom/squareup/wire/WireEnum;", "wire-runtime"}, k=2, mv={1, 1, 16})
public final class EnumAdapterKt
{
  @NotNull
  public static final <E extends WireEnum> E commonDecode(@NotNull EnumAdapter<E> paramEnumAdapter, @NotNull ProtoReader paramProtoReader, @NotNull Function1<? super Integer, ? extends E> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramEnumAdapter, "$this$commonDecode");
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "fromValue");
    int i = paramProtoReader.readVarint32();
    paramProtoReader = (WireEnum)paramFunction1.invoke(Integer.valueOf(i));
    if (paramProtoReader != null) {
      return paramProtoReader;
    }
    throw ((Throwable)new ProtoAdapter.EnumConstantNotFoundException(i, paramEnumAdapter.getType()));
  }
  
  public static final <E extends WireEnum> void commonEncode(@NotNull ProtoWriter paramProtoWriter, @NotNull E paramE)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramE, "value");
    paramProtoWriter.writeVarint32(paramE.getValue());
  }
  
  public static final <E extends WireEnum> int commonEncodedSize(@NotNull E paramE)
  {
    Intrinsics.checkParameterIsNotNull(paramE, "value");
    return ProtoWriter.Companion.varint32Size$wire_runtime(paramE.getValue());
  }
  
  @NotNull
  public static final <E extends WireEnum> E commonRedact(@NotNull E paramE)
  {
    Intrinsics.checkParameterIsNotNull(paramE, "value");
    throw ((Throwable)new UnsupportedOperationException());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.EnumAdapterKt
 * JD-Core Version:    0.7.0.1
 */