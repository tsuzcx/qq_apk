package com.getkeepsafe.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Program64Header
  extends Elf.ProgramHeader
{
  public Program64Header(ElfParser paramElfParser, Elf.Header paramHeader, long paramLong)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    ByteOrder localByteOrder;
    if (paramHeader.jdField_a_of_type_Boolean) {
      localByteOrder = ByteOrder.BIG_ENDIAN;
    } else {
      localByteOrder = ByteOrder.LITTLE_ENDIAN;
    }
    localByteBuffer.order(localByteOrder);
    paramLong = paramHeader.jdField_a_of_type_Long + paramLong * paramHeader.b;
    this.jdField_a_of_type_Long = paramElfParser.b(localByteBuffer, paramLong);
    this.b = paramElfParser.a(localByteBuffer, 8L + paramLong);
    this.c = paramElfParser.a(localByteBuffer, 16L + paramLong);
    this.d = paramElfParser.a(localByteBuffer, paramLong + 40L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.getkeepsafe.relinker.elf.Program64Header
 * JD-Core Version:    0.7.0.1
 */