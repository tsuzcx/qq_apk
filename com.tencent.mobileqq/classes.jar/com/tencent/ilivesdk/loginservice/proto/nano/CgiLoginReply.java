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
      if (i == 0) {
        break;
      }
      if (i != 8)
      {
        if (i != 18)
        {
          if (i != 26)
          {
            if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
              return this;
            }
          }
          else
          {
            if (this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoCgiResult == null) {
              this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoCgiResult = new CgiResult();
            }
            paramCodedInputByteBufferNano.readMessage(this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoCgiResult);
          }
        }
        else {
          this.jdField_a_of_type_JavaLangString = paramCodedInputByteBufferNano.readString();
        }
      }
      else {
        this.jdField_a_of_type_Int = paramCodedInputByteBufferNano.readInt32();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int k = this.jdField_a_of_type_Int;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(1, k);
    }
    j = i;
    if (!this.jdField_a_of_type_JavaLangString.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.jdField_a_of_type_JavaLangString);
    }
    CgiResult localCgiResult = this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoCgiResult;
    i = j;
    if (localCgiResult != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(3, localCgiResult);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.jdField_a_of_type_Int;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1, i);
    }
    if (!this.jdField_a_of_type_JavaLangString.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.jdField_a_of_type_JavaLangString);
    }
    CgiResult localCgiResult = this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoCgiResult;
    if (localCgiResult != null) {
      paramCodedOutputByteBufferNano.writeMessage(3, localCgiResult);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.loginservice.proto.nano.CgiLoginReply
 * JD-Core Version:    0.7.0.1
 */