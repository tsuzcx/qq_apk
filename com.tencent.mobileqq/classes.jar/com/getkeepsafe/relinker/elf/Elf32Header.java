package com.getkeepsafe.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Elf32Header
  extends Elf.Header
{
  private final ElfParser a;
  
  public Elf32Header(boolean paramBoolean, ElfParser paramElfParser)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComGetkeepsafeRelinkerElfElfParser = paramElfParser;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    ByteOrder localByteOrder;
    if (paramBoolean) {
      localByteOrder = ByteOrder.BIG_ENDIAN;
    } else {
      localByteOrder = ByteOrder.LITTLE_ENDIAN;
    }
    localByteBuffer.order(localByteOrder);
    this.jdField_a_of_type_Int = paramElfParser.a(localByteBuffer, 16L);
    this.jdField_a_of_type_Long = paramElfParser.b(localByteBuffer, 28L);
    this.jdField_b_of_type_Long = paramElfParser.b(localByteBuffer, 32L);
    this.jdField_b_of_type_Int = paramElfParser.a(localByteBuffer, 42L);
    this.c = paramElfParser.a(localByteBuffer, 44L);
    this.d = paramElfParser.a(localByteBuffer, 46L);
    this.e = paramElfParser.a(localByteBuffer, 48L);
    this.f = paramElfParser.a(localByteBuffer, 50L);
  }
  
  public Elf.DynamicStructure a(long paramLong, int paramInt)
  {
    return new Dynamic32Structure(this.jdField_a_of_type_ComGetkeepsafeRelinkerElfElfParser, this, paramLong, paramInt);
  }
  
  public Elf.ProgramHeader a(long paramLong)
  {
    return new Program32Header(this.jdField_a_of_type_ComGetkeepsafeRelinkerElfElfParser, this, paramLong);
  }
  
  public Elf.SectionHeader a(int paramInt)
  {
    return new Section32Header(this.jdField_a_of_type_ComGetkeepsafeRelinkerElfElfParser, this, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.getkeepsafe.relinker.elf.Elf32Header
 * JD-Core Version:    0.7.0.1
 */