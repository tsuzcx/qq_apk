package com.google.protobuf.nano;

import java.util.Arrays;

final class UnknownFieldData
{
  final byte[] bytes;
  final int tag;
  
  UnknownFieldData(int paramInt, byte[] paramArrayOfByte)
  {
    this.tag = paramInt;
    this.bytes = paramArrayOfByte;
  }
  
  int computeSerializedSize()
  {
    return CodedOutputByteBufferNano.computeRawVarint32Size(this.tag) + 0 + this.bytes.length;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof UnknownFieldData)) {
      return false;
    }
    paramObject = (UnknownFieldData)paramObject;
    return (this.tag == paramObject.tag) && (Arrays.equals(this.bytes, paramObject.bytes));
  }
  
  public int hashCode()
  {
    return (527 + this.tag) * 31 + Arrays.hashCode(this.bytes);
  }
  
  void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeRawVarint32(this.tag);
    paramCodedOutputByteBufferNano.writeRawBytes(this.bytes);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.protobuf.nano.UnknownFieldData
 * JD-Core Version:    0.7.0.1
 */