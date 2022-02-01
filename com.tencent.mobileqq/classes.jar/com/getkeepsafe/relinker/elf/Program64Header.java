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
    if (paramHeader.a) {
      localByteOrder = ByteOrder.BIG_ENDIAN;
    } else {
      localByteOrder = ByteOrder.LITTLE_ENDIAN;
    }
    localByteBuffer.order(localByteOrder);
    paramLong = paramHeader.c + paramLong * paramHeader.e;
    this.a = paramElfParser.c(localByteBuffer, paramLong);
    this.b = paramElfParser.b(localByteBuffer, 8L + paramLong);
    this.c = paramElfParser.b(localByteBuffer, 16L + paramLong);
    this.d = paramElfParser.b(localByteBuffer, paramLong + 40L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.getkeepsafe.relinker.elf.Program64Header
 * JD-Core Version:    0.7.0.1
 */