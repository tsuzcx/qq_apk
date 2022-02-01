package com.google.protobuf;

final class ByteString$CodedBuilder
{
  private final CodedOutputStream a;
  private final byte[] b;
  
  private ByteString$CodedBuilder(int paramInt)
  {
    this.b = new byte[paramInt];
    this.a = CodedOutputStream.a(this.b);
  }
  
  public ByteString a()
  {
    this.a.d();
    return new ByteString.LiteralByteString(this.b);
  }
  
  public CodedOutputStream b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.ByteString.CodedBuilder
 * JD-Core Version:    0.7.0.1
 */