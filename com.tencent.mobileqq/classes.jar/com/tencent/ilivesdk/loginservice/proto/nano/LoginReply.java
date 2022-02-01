package com.tencent.ilivesdk.loginservice.proto.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class LoginReply
  extends MessageNano
{
  public AccountBaseInfo a;
  public ConfigKeyValue a;
  public TicketInfo a;
  
  public LoginReply()
  {
    a();
  }
  
  public static LoginReply a(byte[] paramArrayOfByte)
  {
    return (LoginReply)MessageNano.mergeFrom(new LoginReply(), paramArrayOfByte);
  }
  
  public LoginReply a()
  {
    this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoAccountBaseInfo = null;
    this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoTicketInfo = null;
    this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoConfigKeyValue = null;
    this.cachedSize = -1;
    return this;
  }
  
  public LoginReply a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 10)
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
            if (this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoConfigKeyValue == null) {
              this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoConfigKeyValue = new ConfigKeyValue();
            }
            paramCodedInputByteBufferNano.readMessage(this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoConfigKeyValue);
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoTicketInfo == null) {
            this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoTicketInfo = new TicketInfo();
          }
          paramCodedInputByteBufferNano.readMessage(this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoTicketInfo);
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoAccountBaseInfo == null) {
          this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoAccountBaseInfo = new AccountBaseInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoAccountBaseInfo);
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    Object localObject = this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoAccountBaseInfo;
    int i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(1, (MessageNano)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoTicketInfo;
    j = i;
    if (localObject != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(2, (MessageNano)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoConfigKeyValue;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(3, (MessageNano)localObject);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoAccountBaseInfo;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(1, (MessageNano)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoTicketInfo;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(2, (MessageNano)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoConfigKeyValue;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(3, (MessageNano)localObject);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.loginservice.proto.nano.LoginReply
 * JD-Core Version:    0.7.0.1
 */