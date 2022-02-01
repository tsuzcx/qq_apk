package com.tencent.ilivesdk.loginservice.proto.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class CtkLoginReply
  extends MessageNano
{
  public AccountBaseInfo a;
  public ConfigKeyValue a;
  public TicketInfo a;
  
  public CtkLoginReply()
  {
    a();
  }
  
  public CtkLoginReply a()
  {
    this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoAccountBaseInfo = null;
    this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoTicketInfo = null;
    this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoConfigKeyValue = null;
    this.cachedSize = -1;
    return this;
  }
  
  public CtkLoginReply a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        if (this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoAccountBaseInfo == null) {
          this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoAccountBaseInfo = new AccountBaseInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoAccountBaseInfo);
        break;
      case 18: 
        if (this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoTicketInfo == null) {
          this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoTicketInfo = new TicketInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoTicketInfo);
        break;
      }
      if (this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoConfigKeyValue == null) {
        this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoConfigKeyValue = new ConfigKeyValue();
      }
      paramCodedInputByteBufferNano.readMessage(this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoConfigKeyValue);
    }
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoAccountBaseInfo != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(1, this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoAccountBaseInfo);
    }
    j = i;
    if (this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoTicketInfo != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(2, this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoTicketInfo);
    }
    i = j;
    if (this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoConfigKeyValue != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(3, this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoConfigKeyValue);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoAccountBaseInfo != null) {
      paramCodedOutputByteBufferNano.writeMessage(1, this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoAccountBaseInfo);
    }
    if (this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoTicketInfo != null) {
      paramCodedOutputByteBufferNano.writeMessage(2, this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoTicketInfo);
    }
    if (this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoConfigKeyValue != null) {
      paramCodedOutputByteBufferNano.writeMessage(3, this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoConfigKeyValue);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.loginservice.proto.nano.CtkLoginReply
 * JD-Core Version:    0.7.0.1
 */