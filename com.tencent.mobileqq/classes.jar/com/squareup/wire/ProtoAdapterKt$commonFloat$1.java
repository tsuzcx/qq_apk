package com.squareup.wire;

import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/squareup/wire/ProtoAdapterKt$commonFloat$1", "Lcom/squareup/wire/ProtoAdapter;", "", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "(Lcom/squareup/wire/ProtoReader;)Ljava/lang/Float;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "(F)Ljava/lang/Float;", "wire-runtime"}, k=1, mv={1, 1, 16})
public final class ProtoAdapterKt$commonFloat$1
  extends ProtoAdapter<Float>
{
  ProtoAdapterKt$commonFloat$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public Float decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    FloatCompanionObject localFloatCompanionObject = FloatCompanionObject.INSTANCE;
    return Float.valueOf(Float.intBitsToFloat(paramProtoReader.readFixed32()));
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    paramProtoWriter.writeFixed32(Float.floatToIntBits(paramFloat));
  }
  
  public int encodedSize(float paramFloat)
  {
    return 4;
  }
  
  @NotNull
  public Float redact(float paramFloat)
  {
    throw ((Throwable)new UnsupportedOperationException());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.ProtoAdapterKt.commonFloat.1
 * JD-Core Version:    0.7.0.1
 */