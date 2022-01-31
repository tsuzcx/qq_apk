package com.tencent.av.opengl;

public class Tlv
{
  private short jdField_a_of_type_Short;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private short b;
  
  public Tlv(short paramShort1, short paramShort2, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_Short = paramShort1;
    this.b = paramShort2;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public int a()
  {
    return b() + 4;
  }
  
  public short a()
  {
    return this.jdField_a_of_type_Short;
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public short b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.opengl.Tlv
 * JD-Core Version:    0.7.0.1
 */