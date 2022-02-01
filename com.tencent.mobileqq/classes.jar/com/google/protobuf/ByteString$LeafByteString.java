package com.google.protobuf;

abstract class ByteString$LeafByteString
  extends ByteString
{
  abstract boolean equalsRange(ByteString paramByteString, int paramInt1, int paramInt2);
  
  protected final int getTreeDepth()
  {
    return 0;
  }
  
  protected final boolean isBalanced()
  {
    return true;
  }
  
  void writeToReverse(ByteOutput paramByteOutput)
  {
    writeTo(paramByteOutput);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.ByteString.LeafByteString
 * JD-Core Version:    0.7.0.1
 */