package com.getkeepsafe.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Section32Header
  extends Elf.SectionHeader
{
  public Section32Header(ElfParser paramElfParser, Elf.Header paramHeader, int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    ByteOrder localByteOrder;
    if (paramHeader.a) {
      localByteOrder = ByteOrder.BIG_ENDIAN;
    } else {
      localByteOrder = ByteOrder.LITTLE_ENDIAN;
    }
    localByteBuffer.order(localByteOrder);
    this.a = paramElfParser.c(localByteBuffer, paramHeader.d + paramInt * paramHeader.g + 28L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.getkeepsafe.relinker.elf.Section32Header
 * JD-Core Version:    0.7.0.1
 */