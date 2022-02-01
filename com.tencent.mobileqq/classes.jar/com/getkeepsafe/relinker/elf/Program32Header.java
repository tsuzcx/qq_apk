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
    if (paramHeader.a) {
      localByteOrder = ByteOrder.BIG_ENDIAN;
    } else {
      localByteOrder = ByteOrder.LITTLE_ENDIAN;
    }
    localByteBuffer.order(localByteOrder);
    paramLong = paramHeader.c + paramLong * paramHeader.e;
    this.a = paramElfParser.c(localByteBuffer, paramLong);
    this.b = paramElfParser.c(localByteBuffer, 4L + paramLong);
    this.c = paramElfParser.c(localByteBuffer, 8L + paramLong);
    this.d = paramElfParser.c(localByteBuffer, paramLong + 20L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.getkeepsafe.relinker.elf.Program32Header
 * JD-Core Version:    0.7.0.1
 */