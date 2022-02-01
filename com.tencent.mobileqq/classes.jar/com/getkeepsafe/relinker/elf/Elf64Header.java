package com.getkeepsafe.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Elf64Header
  extends Elf.Header
{
  private final ElfParser j;
  
  public Elf64Header(boolean paramBoolean, ElfParser paramElfParser)
  {
    this.a = paramBoolean;
    this.j = paramElfParser;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    ByteOrder localByteOrder;
    if (paramBoolean) {
      localByteOrder = ByteOrder.BIG_ENDIAN;
    } else {
      localByteOrder = ByteOrder.LITTLE_ENDIAN;
    }
    localByteBuffer.order(localByteOrder);
    this.b = paramElfParser.d(localByteBuffer, 16L);
    this.c = paramElfParser.b(localByteBuffer, 32L);
    this.d = paramElfParser.b(localByteBuffer, 40L);
    this.e = paramElfParser.d(localByteBuffer, 54L);
    this.f = paramElfParser.d(localByteBuffer, 56L);
    this.g = paramElfParser.d(localByteBuffer, 58L);
    this.h = paramElfParser.d(localByteBuffer, 60L);
    this.i = paramElfParser.d(localByteBuffer, 62L);
  }
  
  public Elf.DynamicStructure a(long paramLong, int paramInt)
  {
    return new Dynamic64Structure(this.j, this, paramLong, paramInt);
  }
  
  public Elf.ProgramHeader a(long paramLong)
  {
    return new Program64Header(this.j, this, paramLong);
  }
  
  public Elf.SectionHeader a(int paramInt)
  {
    return new Section64Header(this.j, this, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.getkeepsafe.relinker.elf.Elf64Header
 * JD-Core Version:    0.7.0.1
 */