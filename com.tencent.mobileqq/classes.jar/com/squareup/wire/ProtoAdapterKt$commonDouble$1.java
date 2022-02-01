package com.squareup.wire;

import kotlin.Metadata;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/squareup/wire/ProtoAdapterKt$commonDouble$1", "Lcom/squareup/wire/ProtoAdapter;", "", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "(Lcom/squareup/wire/ProtoReader;)Ljava/lang/Double;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "(D)Ljava/lang/Double;", "wire-runtime"}, k=1, mv={1, 1, 16})
public final class ProtoAdapterKt$commonDouble$1
  extends ProtoAdapter<Double>
{
  ProtoAdapterKt$commonDouble$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public Double decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    DoubleCompanionObject localDoubleCompanionObject = DoubleCompanionObject.INSTANCE;
    return Double.valueOf(Double.longBitsToDouble(paramProtoReader.readFixed64()));
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, double paramDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    paramProtoWriter.writeFixed64(Double.doubleToLongBits(paramDouble));
  }
  
  public int encodedSize(double paramDouble)
  {
    return 8;
  }
  
  @NotNull
  public Double redact(double paramDouble)
  {
    throw ((Throwable)new UnsupportedOperationException());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.ProtoAdapterKt.commonDouble.1
 * JD-Core Version:    0.7.0.1
 */