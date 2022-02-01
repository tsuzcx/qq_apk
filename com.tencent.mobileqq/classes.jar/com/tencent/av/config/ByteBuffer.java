package com.tencent.av.config;

public class ByteBuffer
{
  private int jdField_a_of_type_Int = 0;
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  private int b = 0;
  
  public ByteBuffer()
  {
    int i = 0;
    while (i < 512)
    {
      this.jdField_a_of_type_ArrayOfByte[i] = 0;
      i += 1;
    }
    this.jdField_a_of_type_Int = 0;
    this.b = 0;
  }
  
  public void a(byte paramByte)
  {
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    int i = this.jdField_a_of_type_Int;
    arrayOfByte[i] = paramByte;
    this.jdField_a_of_type_Int = (i + 1);
    this.b += 1;
  }
  
  public void a(int paramInt)
  {
    int i = (byte)(paramInt & 0xFF);
    int j = (byte)(paramInt >> 8 & 0xFF);
    int k = (byte)(paramInt >> 16 & 0xFF);
    int m = (byte)(paramInt >> 24 & 0xFF);
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    paramInt = this.jdField_a_of_type_Int;
    System.arraycopy(new byte[] { m, k, j, i }, 0, arrayOfByte, paramInt, 4);
    this.jdField_a_of_type_Int += 4;
    this.b += 4;
  }
  
  public byte[] a()
  {
    int i = this.b;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.jdField_a_of_type_ArrayOfByte, 0, arrayOfByte, 0, i);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.config.ByteBuffer
 * JD-Core Version:    0.7.0.1
 */