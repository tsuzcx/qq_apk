package com.getkeepsafe.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Dynamic32Structure
  extends Elf.DynamicStructure
{
  public Dynamic32Structure(ElfParser paramElfParser, Elf.Header paramHeader, long paramLong, int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    if (paramHeader.a) {
      paramHeader = ByteOrder.BIG_ENDIAN;
    } else {
      paramHeader = ByteOrder.LITTLE_ENDIAN;
    }
    localByteBuffer.order(paramHeader);
    paramLong += paramInt * 8;
    this.a = paramElfParser.b(localByteBuffer, paramLong);
    this.b = paramElfParser.b(localByteBuffer, paramLong + 4L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.getkeepsafe.relinker.elf.Dynamic32Structure
 * JD-Core Version:    0.7.0.1
 */