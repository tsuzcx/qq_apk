package com.tencent.av.ui.funchat.record;

public class PCMFrame
{
  public long a;
  public byte[] a;
  public long b;
  
  public PCMFrame(byte[] paramArrayOfByte, long paramLong)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("PCMFrame:");
    if (this.jdField_a_of_type_ArrayOfByte == null) {}
    for (int i = -1;; i = this.jdField_a_of_type_ArrayOfByte.length) {
      return i + ", idx=" + this.jdField_a_of_type_Long + ", pts=" + this.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.funchat.record.PCMFrame
 * JD-Core Version:    0.7.0.1
 */