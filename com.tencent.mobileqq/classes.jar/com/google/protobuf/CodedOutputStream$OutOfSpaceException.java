package com.google.protobuf;

import java.io.IOException;

public class CodedOutputStream$OutOfSpaceException
  extends IOException
{
  private static final long serialVersionUID = -6947486886997889499L;
  
  CodedOutputStream$OutOfSpaceException()
  {
    super("CodedOutputStream was writing to a flat byte array and ran out of space.");
  }
  
  CodedOutputStream$OutOfSpaceException(String paramString)
  {
    super(localStringBuilder.toString());
  }
  
  CodedOutputStream$OutOfSpaceException(String paramString, Throwable paramThrowable)
  {
    super(localStringBuilder.toString(), paramThrowable);
  }
  
  CodedOutputStream$OutOfSpaceException(Throwable paramThrowable)
  {
    super("CodedOutputStream was writing to a flat byte array and ran out of space.", paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.CodedOutputStream.OutOfSpaceException
 * JD-Core Version:    0.7.0.1
 */