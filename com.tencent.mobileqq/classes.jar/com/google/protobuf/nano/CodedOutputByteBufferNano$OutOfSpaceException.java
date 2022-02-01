package com.google.protobuf.nano;

import java.io.IOException;

public class CodedOutputByteBufferNano$OutOfSpaceException
  extends IOException
{
  private static final long serialVersionUID = -6947486886997889499L;
  
  CodedOutputByteBufferNano$OutOfSpaceException(int paramInt1, int paramInt2)
  {
    super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + paramInt1 + " limit " + paramInt2 + ").");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.protobuf.nano.CodedOutputByteBufferNano.OutOfSpaceException
 * JD-Core Version:    0.7.0.1
 */