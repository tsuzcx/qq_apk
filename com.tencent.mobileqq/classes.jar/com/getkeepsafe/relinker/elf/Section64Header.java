package com.getkeepsafe.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Section64Header
  extends Elf.SectionHeader
{
  public Section64Header(ElfParser paramElfParser, Elf.Header paramHeader, int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    ByteOrder localByteOrder;
    if (paramHeader.a) {
      localByteOrder = ByteOrder.BIG_ENDIAN;
    } else {
      localByteOrder = ByteOrder.LITTLE_ENDIAN;
    }
    localByteBuffer.order(localByteOrder);
    this.a = paramElfParser.b(localByteBuffer, paramHeader.b + paramInt * paramHeader.d + 44L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.getkeepsafe.relinker.elf.Section64Header
 * JD-Core Version:    0.7.0.1
 */