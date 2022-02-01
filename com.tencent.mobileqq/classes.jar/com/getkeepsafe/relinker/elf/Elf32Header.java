package com.getkeepsafe.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Elf32Header
  extends Elf.Header
{
  private final ElfParser j;
  
  public Elf32Header(boolean paramBoolean, ElfParser paramElfParser)
  {
    this.a = paramBoolean;
    this.j = paramElfParser;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    ByteOrder localByteOrder;
    if (paramBoolean) {
      localByteOrder = ByteOrder.BIG_ENDIAN;
    } else {
      localByteOrder = ByteOrder.LITTLE_ENDIAN;
    }
    localByteBuffer.order(localByteOrder);
    this.b = paramElfParser.d(localByteBuffer, 16L);
    this.c = paramElfParser.c(localByteBuffer, 28L);
    this.d = paramElfParser.c(localByteBuffer, 32L);
    this.e = paramElfParser.d(localByteBuffer, 42L);
    this.f = paramElfParser.d(localByteBuffer, 44L);
    this.g = paramElfParser.d(localByteBuffer, 46L);
    this.h = paramElfParser.d(localByteBuffer, 48L);
    this.i = paramElfParser.d(localByteBuffer, 50L);
  }
  
  public Elf.DynamicStructure a(long paramLong, int paramInt)
  {
    return new Dynamic32Structure(this.j, this, paramLong, paramInt);
  }
  
  public Elf.ProgramHeader a(long paramLong)
  {
    return new Program32Header(this.j, this, paramLong);
  }
  
  public Elf.SectionHeader a(int paramInt)
  {
    return new Section32Header(this.j, this, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.getkeepsafe.relinker.elf.Elf32Header
 * JD-Core Version:    0.7.0.1
 */