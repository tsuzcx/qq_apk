package com.tencent.ilivesdk.loginservice.proto.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class TicketInfo
  extends MessageNano
{
  public int a;
  public String a;
  
  public TicketInfo()
  {
    a();
  }
  
  public TicketInfo a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.cachedSize = -1;
    return this;
  }
  
  public TicketInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      switch (i)
      {
      default: 
        if (WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
          continue;
        }
      case 0: 
        return this;
      case 10: 
        this.jdField_a_of_type_JavaLangString = paramCodedInputByteBufferNano.readString();
        break;
      }
      this.jdField_a_of_type_Int = paramCodedInputByteBufferNano.readUInt32();
    }
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (!this.jdField_a_of_type_JavaLangString.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(1, this.jdField_a_of_type_JavaLangString);
    }
    j = i;
    if (this.jdField_a_of_type_Int != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(2, this.jdField_a_of_type_Int);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Int != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(2, this.jdField_a_of_type_Int);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.loginservice.proto.nano.TicketInfo
 * JD-Core Version:    0.7.0.1
 */