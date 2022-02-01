package com.squareup.wire;

import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/squareup/wire/EnumAdapter;", "E", "Lcom/squareup/wire/WireEnum;", "Lcom/squareup/wire/ProtoAdapter;", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)V", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "(Lcom/squareup/wire/ProtoReader;)Lcom/squareup/wire/WireEnum;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "(Lcom/squareup/wire/ProtoWriter;Lcom/squareup/wire/WireEnum;)V", "encodedSize", "", "(Lcom/squareup/wire/WireEnum;)I", "fromValue", "(I)Lcom/squareup/wire/WireEnum;", "redact", "(Lcom/squareup/wire/WireEnum;)Lcom/squareup/wire/WireEnum;", "wire-runtime"}, k=1, mv={1, 1, 16})
public abstract class EnumAdapter<E extends WireEnum>
  extends ProtoAdapter<E>
{
  public EnumAdapter(@NotNull Class<E> paramClass)
  {
    this(JvmClassMappingKt.getKotlinClass(paramClass));
  }
  
  protected EnumAdapter(@NotNull KClass<E> paramKClass)
  {
    super(FieldEncoding.VARINT, paramKClass, null);
  }
  
  @NotNull
  public E decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    int i = paramProtoReader.readVarint32();
    paramProtoReader = ((EnumAdapter)this).fromValue(i);
    if (paramProtoReader != null) {
      return paramProtoReader;
    }
    throw ((Throwable)new ProtoAdapter.EnumConstantNotFoundException(i, getType()));
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull E paramE)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramE, "value");
    paramProtoWriter.writeVarint32(paramE.getValue());
  }
  
  public int encodedSize(@NotNull E paramE)
  {
    Intrinsics.checkParameterIsNotNull(paramE, "value");
    return ProtoWriter.Companion.varint32Size$wire_runtime(paramE.getValue());
  }
  
  @Nullable
  protected abstract E fromValue(int paramInt);
  
  @NotNull
  public E redact(@NotNull E paramE)
  {
    Intrinsics.checkParameterIsNotNull(paramE, "value");
    throw ((Throwable)new UnsupportedOperationException());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.EnumAdapter
 * JD-Core Version:    0.7.0.1
 */