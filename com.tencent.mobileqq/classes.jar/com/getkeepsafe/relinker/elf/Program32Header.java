package com.getkeepsafe.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Program32Header
  extends Elf.ProgramHeader
{
  public Program32Header(ElfParser paramElfParser, Elf.Header paramHeader, long paramLong)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    ByteOrder localByteOrder;
    if (paramHeader.jdField_a_of_type_Boolean) {
      localByteOrder = ByteOrder.BIG_ENDIAN;
    } else {
      localByteOrder = ByteOrder.LITTLE_ENDIAN;
    }
    localByteBuffer.order(localByteOrder);
    paramLong = paramHeader.jdField_a_of_type_Long + paramLong * paramHeader.b;
    this.jdField_a_of_type_Long = paramElfParser.b(localByteBuffer, paramLong);
    this.b = paramElfParser.b(localByteBuffer, 4L + paramLong);
    this.c = paramElfParser.b(localByteBuffer, 8L + paramLong);
    this.d = paramElfParser.b(localByteBuffer, paramLong + 20L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.getkeepsafe.relinker.elf.Program32Header
 * JD-Core Version:    0.7.0.1
 */