package com.squareup.wire;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/squareup/wire/ProtoWriter$Companion;", "", "()V", "decodeZigZag32", "", "n", "decodeZigZag32$wire_runtime", "decodeZigZag64", "", "decodeZigZag64$wire_runtime", "encodeZigZag32", "encodeZigZag32$wire_runtime", "encodeZigZag64", "encodeZigZag64$wire_runtime", "int32Size", "value", "int32Size$wire_runtime", "makeTag", "fieldNumber", "fieldEncoding", "Lcom/squareup/wire/FieldEncoding;", "tagSize", "tag", "tagSize$wire_runtime", "varint32Size", "varint32Size$wire_runtime", "varint64Size", "varint64Size$wire_runtime", "wire-runtime"}, k=1, mv={1, 1, 16})
public final class ProtoWriter$Companion
{
  private final int makeTag(int paramInt, FieldEncoding paramFieldEncoding)
  {
    return paramInt << 3 | paramFieldEncoding.getValue$wire_runtime();
  }
  
  public final int decodeZigZag32$wire_runtime(int paramInt)
  {
    return -(paramInt & 0x1) ^ paramInt >>> 1;
  }
  
  public final long decodeZigZag64$wire_runtime(long paramLong)
  {
    return -(paramLong & 1L) ^ paramLong >>> 1;
  }
  
  public final int encodeZigZag32$wire_runtime(int paramInt)
  {
    return paramInt >> 31 ^ paramInt << 1;
  }
  
  public final long encodeZigZag64$wire_runtime(long paramLong)
  {
    return paramLong >> 63 ^ paramLong << 1;
  }
  
  public final int int32Size$wire_runtime(int paramInt)
  {
    if (paramInt >= 0) {
      return ((Companion)this).varint32Size$wire_runtime(paramInt);
    }
    return 10;
  }
  
  public final int tagSize$wire_runtime(int paramInt)
  {
    Companion localCompanion = (Companion)this;
    return localCompanion.varint32Size$wire_runtime(localCompanion.makeTag(paramInt, FieldEncoding.VARINT));
  }
  
  public final int varint32Size$wire_runtime(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0) {
      return 1;
    }
    if ((paramInt & 0xFFFFC000) == 0) {
      return 2;
    }
    if ((0xFFE00000 & paramInt) == 0) {
      return 3;
    }
    if ((paramInt & 0xF0000000) == 0) {
      return 4;
    }
    return 5;
  }
  
  public final int varint64Size$wire_runtime(long paramLong)
  {
    if ((0xFFFFFF80 & paramLong) == 0L) {
      return 1;
    }
    if ((0xFFFFC000 & paramLong) == 0L) {
      return 2;
    }
    if ((0xFFE00000 & paramLong) == 0L) {
      return 3;
    }
    if ((0xF0000000 & paramLong) == 0L) {
      return 4;
    }
    if ((0x0 & paramLong) == 0L) {
      return 5;
    }
    if ((0x0 & paramLong) == 0L) {
      return 6;
    }
    if ((0x0 & paramLong) == 0L) {
      return 7;
    }
    if ((0x0 & paramLong) == 0L) {
      return 8;
    }
    if ((paramLong & 0x0) == 0L) {
      return 9;
    }
    return 10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.squareup.wire.ProtoWriter.Companion
 * JD-Core Version:    0.7.0.1
 */