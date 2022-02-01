package com.squareup.wire;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/squareup/wire/ProtoWriter;", "", "sink", "Lokio/BufferedSink;", "(Lokio/BufferedSink;)V", "writeBytes", "", "value", "Lokio/ByteString;", "writeFixed32", "", "writeFixed64", "", "writeSignedVarint32", "writeSignedVarint32$wire_runtime", "writeString", "", "writeTag", "fieldNumber", "fieldEncoding", "Lcom/squareup/wire/FieldEncoding;", "writeVarint32", "writeVarint64", "Companion", "wire-runtime"}, k=1, mv={1, 1, 16})
public final class ProtoWriter
{
  public static final ProtoWriter.Companion Companion = new ProtoWriter.Companion(null);
  private final BufferedSink sink;
  
  public ProtoWriter(@NotNull BufferedSink paramBufferedSink)
  {
    this.sink = paramBufferedSink;
  }
  
  public final void writeBytes(@NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "value");
    this.sink.write(paramByteString);
  }
  
  public final void writeFixed32(int paramInt)
  {
    this.sink.writeIntLe(paramInt);
  }
  
  public final void writeFixed64(long paramLong)
  {
    this.sink.writeLongLe(paramLong);
  }
  
  public final void writeSignedVarint32$wire_runtime(int paramInt)
  {
    if (paramInt >= 0)
    {
      writeVarint32(paramInt);
      return;
    }
    writeVarint64(paramInt);
  }
  
  public final void writeString(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    this.sink.writeUtf8(paramString);
  }
  
  public final void writeTag(int paramInt, @NotNull FieldEncoding paramFieldEncoding)
  {
    Intrinsics.checkParameterIsNotNull(paramFieldEncoding, "fieldEncoding");
    writeVarint32(ProtoWriter.Companion.access$makeTag(Companion, paramInt, paramFieldEncoding));
  }
  
  public final void writeVarint32(int paramInt)
  {
    while ((paramInt & 0xFFFFFF80) != 0)
    {
      this.sink.writeByte(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
    this.sink.writeByte(paramInt);
  }
  
  public final void writeVarint64(long paramLong)
  {
    while ((0xFFFFFF80 & paramLong) != 0L)
    {
      this.sink.writeByte((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
    this.sink.writeByte((int)paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.ProtoWriter
 * JD-Core Version:    0.7.0.1
 */