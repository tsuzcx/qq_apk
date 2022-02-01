package com.tencent.biz.flatbuffers;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

public class FlatBufferBuilder
{
  static final Charset c = Charset.forName("UTF-8");
  ByteBuffer a;
  int b;
  int d = 1;
  int[] e = null;
  int f = 0;
  boolean g = false;
  boolean h = false;
  int[] i = new int[16];
  int j = 0;
  int k = 0;
  boolean l = false;
  CharsetEncoder m = c.newEncoder();
  
  public FlatBufferBuilder()
  {
    this(1024);
  }
  
  public FlatBufferBuilder(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt <= 0) {
      i1 = 1;
    }
    this.b = i1;
    this.a = a(i1);
  }
  
  static ByteBuffer a(int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramInt);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    return localByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.flatbuffers.FlatBufferBuilder
 * JD-Core Version:    0.7.0.1
 */