package com.getkeepsafe.relinker.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Elf64Header
  extends Elf.Header
{
  private final ElfParser a;
  
  public Elf64Header(boolean paramBoolean, ElfParser paramElfParser)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComGetkeepsafeRelinkerElfElfParser = paramElfParser;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    ByteOrder localByteOrder;
    if (paramBoolean) {
      localByteOrder = ByteOrder.BIG_ENDIAN;
    } else {
      localByteOrder = ByteOrder.LITTLE_ENDIAN;
    }
    localByteBuffer.order(localByteOrder);
    this.jdField_a_of_type_Int = paramElfParser.a(localByteBuffer, 16L);
    this.jdField_a_of_type_Long = paramElfParser.a(localByteBuffer, 32L);
    this.jdField_b_of_type_Long = paramElfParser.a(localByteBuffer, 40L);
    this.jdField_b_of_type_Int = paramElfParser.a(localByteBuffer, 54L);
    this.c = paramElfParser.a(localByteBuffer, 56L);
    this.d = paramElfParser.a(localByteBuffer, 58L);
    this.e = paramElfParser.a(localByteBuffer, 60L);
    this.f = paramElfParser.a(localByteBuffer, 62L);
  }
  
  public Elf.DynamicStructure a(long paramLong, int paramInt)
  {
    return new Dynamic64Structure(this.jdField_a_of_type_ComGetkeepsafeRelinkerElfElfParser, this, paramLong, paramInt);
  }
  
  public Elf.ProgramHeader a(long paramLong)
  {
    return new Program64Header(this.jdField_a_of_type_ComGetkeepsafeRelinkerElfElfParser, this, paramLong);
  }
  
  public Elf.SectionHeader a(int paramInt)
  {
    return new Section64Header(this.jdField_a_of_type_ComGetkeepsafeRelinkerElfElfParser, this, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.getkeepsafe.relinker.elf.Elf64Header
 * JD-Core Version:    0.7.0.1
 */