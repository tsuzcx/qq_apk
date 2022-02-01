package com.tencent.ilivesdk.loginservice.proto.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class CgiLoginReply
  extends MessageNano
{
  public int a;
  public CgiResult a;
  public String a;
  
  public CgiLoginReply()
  {
    a();
  }
  
  public CgiLoginReply a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoCgiResult = null;
    this.cachedSize = -1;
    return this;
  }
  
  public CgiLoginReply a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 8: 
        this.jdField_a_of_type_Int = paramCodedInputByteBufferNano.readInt32();
        break;
      case 18: 
        this.jdField_a_of_type_JavaLangString = paramCodedInputByteBufferNano.readString();
        break;
      }
      if (this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoCgiResult == null) {
        this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoCgiResult = new CgiResult();
      }
      paramCodedInputByteBufferNano.readMessage(this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoCgiResult);
    }
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.jdField_a_of_type_Int != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(1, this.jdField_a_of_type_Int);
    }
    j = i;
    if (!this.jdField_a_of_type_JavaLangString.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.jdField_a_of_type_JavaLangString);
    }
    i = j;
    if (this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoCgiResult != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(3, this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoCgiResult);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.jdField_a_of_type_Int != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1, this.jdField_a_of_type_Int);
    }
    if (!this.jdField_a_of_type_JavaLangString.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoCgiResult != null) {
      paramCodedOutputByteBufferNano.writeMessage(3, this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoCgiResult);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.loginservice.proto.nano.CgiLoginReply
 * JD-Core Version:    0.7.0.1
 */