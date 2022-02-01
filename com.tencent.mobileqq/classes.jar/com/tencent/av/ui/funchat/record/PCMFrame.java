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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PCMFrame:");
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    int i;
    if (arrayOfByte == null) {
      i = -1;
    } else {
      i = arrayOfByte.length;
    }
    localStringBuilder.append(i);
    localStringBuilder.append(", idx=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", pts=");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.record.PCMFrame
 * JD-Core Version:    0.7.0.1
 */