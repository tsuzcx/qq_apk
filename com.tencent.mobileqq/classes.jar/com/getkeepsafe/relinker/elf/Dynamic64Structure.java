package com.getkeepsafe.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Dynamic64Structure
  extends Elf.DynamicStructure
{
  public Dynamic64Structure(ElfParser paramElfParser, Elf.Header paramHeader, long paramLong, int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    if (paramHeader.a) {
      paramHeader = ByteOrder.BIG_ENDIAN;
    } else {
      paramHeader = ByteOrder.LITTLE_ENDIAN;
    }
    localByteBuffer.order(paramHeader);
    paramLong += paramInt * 16;
    this.a = paramElfParser.a(localByteBuffer, paramLong);
    this.b = paramElfParser.a(localByteBuffer, paramLong + 8L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.getkeepsafe.relinker.elf.Dynamic64Structure
 * JD-Core Version:    0.7.0.1
 */