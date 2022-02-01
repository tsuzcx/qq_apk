package com.google.protobuf;

import java.io.ByteArrayOutputStream;

class CodedInputStream$StreamDecoder$SkippedDataSink
  implements CodedInputStream.StreamDecoder.RefillCallback
{
  private int b;
  private ByteArrayOutputStream c;
  
  public void a()
  {
    if (this.c == null) {
      this.c = new ByteArrayOutputStream();
    }
    this.c.write(CodedInputStream.StreamDecoder.b(this.a), this.b, CodedInputStream.StreamDecoder.a(this.a) - this.b);
    this.b = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.CodedInputStream.StreamDecoder.SkippedDataSink
 * JD-Core Version:    0.7.0.1
 */