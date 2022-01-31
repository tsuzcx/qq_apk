package com.tencent.biz.flatbuffers;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

public class FlatBufferBuilder
{
  static final Charset jdField_a_of_type_JavaNioCharsetCharset;
  int jdField_a_of_type_Int;
  ByteBuffer jdField_a_of_type_JavaNioByteBuffer;
  CharsetEncoder jdField_a_of_type_JavaNioCharsetCharsetEncoder = jdField_a_of_type_JavaNioCharsetCharset.newEncoder();
  boolean jdField_a_of_type_Boolean = false;
  int[] jdField_a_of_type_ArrayOfInt = null;
  int jdField_b_of_type_Int = 1;
  boolean jdField_b_of_type_Boolean = false;
  int[] jdField_b_of_type_ArrayOfInt = new int[16];
  int jdField_c_of_type_Int = 0;
  boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int = 0;
  int e = 0;
  
  static
  {
    if (!FlatBufferBuilder.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_d_of_type_Boolean = bool;
      jdField_a_of_type_JavaNioCharsetCharset = Charset.forName("UTF-8");
      return;
    }
  }
  
  public FlatBufferBuilder()
  {
    this(1024);
  }
  
  public FlatBufferBuilder(int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = 1;
    }
    this.jdField_a_of_type_Int = i;
    this.jdField_a_of_type_JavaNioByteBuffer = a(i);
  }
  
  static ByteBuffer a(int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramInt);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    return localByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.flatbuffers.FlatBufferBuilder
 * JD-Core Version:    0.7.0.1
 */