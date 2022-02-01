package com.tencent.ilivesdk.loginservice.proto.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class CgiResult
  extends MessageNano
{
  public int a;
  public long a;
  public ConfigKeyValue a;
  public String a;
  public int b;
  public long b;
  public String b;
  public int c;
  public String c;
  public String d;
  
  public CgiResult()
  {
    a();
  }
  
  public CgiResult a()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.d = "";
    this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoConfigKeyValue = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.cachedSize = -1;
    return this;
  }
  
  public CgiResult a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        this.jdField_a_of_type_Long = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 18: 
        this.jdField_a_of_type_JavaLangString = paramCodedInputByteBufferNano.readString();
        break;
      case 24: 
        this.jdField_b_of_type_Long = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 34: 
        this.jdField_b_of_type_JavaLangString = paramCodedInputByteBufferNano.readString();
        break;
      case 42: 
        this.jdField_c_of_type_JavaLangString = paramCodedInputByteBufferNano.readString();
        break;
      case 48: 
        this.jdField_a_of_type_Int = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 58: 
        this.d = paramCodedInputByteBufferNano.readString();
        break;
      case 66: 
        if (this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoConfigKeyValue == null) {
          this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoConfigKeyValue = new ConfigKeyValue();
        }
        paramCodedInputByteBufferNano.readMessage(this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoConfigKeyValue);
        break;
      case 72: 
        this.jdField_b_of_type_Int = paramCodedInputByteBufferNano.readUInt32();
        break;
      }
      this.jdField_c_of_type_Int = paramCodedInputByteBufferNano.readUInt32();
    }
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.jdField_a_of_type_Long != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(1, this.jdField_a_of_type_Long);
    }
    j = i;
    if (!this.jdField_a_of_type_JavaLangString.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.jdField_a_of_type_JavaLangString);
    }
    i = j;
    if (this.jdField_b_of_type_Long != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(3, this.jdField_b_of_type_Long);
    }
    j = i;
    if (!this.jdField_b_of_type_JavaLangString.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(4, this.jdField_b_of_type_JavaLangString);
    }
    i = j;
    if (!this.jdField_c_of_type_JavaLangString.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(5, this.jdField_c_of_type_JavaLangString);
    }
    j = i;
    if (this.jdField_a_of_type_Int != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(6, this.jdField_a_of_type_Int);
    }
    i = j;
    if (!this.d.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(7, this.d);
    }
    j = i;
    if (this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoConfigKeyValue != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(8, this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoConfigKeyValue);
    }
    i = j;
    if (this.jdField_b_of_type_Int != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(9, this.jdField_b_of_type_Int);
    }
    j = i;
    if (this.jdField_c_of_type_Int != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(10, this.jdField_c_of_type_Int);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.jdField_a_of_type_Long != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, this.jdField_a_of_type_Long);
    }
    if (!this.jdField_a_of_type_JavaLangString.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_b_of_type_Long != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(3, this.jdField_b_of_type_Long);
    }
    if (!this.jdField_b_of_type_JavaLangString.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.jdField_b_of_type_JavaLangString);
    }
    if (!this.jdField_c_of_type_JavaLangString.equals("")) {
      paramCodedOutputByteBufferNano.writeString(5, this.jdField_c_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Int != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(6, this.jdField_a_of_type_Int);
    }
    if (!this.d.equals("")) {
      paramCodedOutputByteBufferNano.writeString(7, this.d);
    }
    if (this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoConfigKeyValue != null) {
      paramCodedOutputByteBufferNano.writeMessage(8, this.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoConfigKeyValue);
    }
    if (this.jdField_b_of_type_Int != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(9, this.jdField_b_of_type_Int);
    }
    if (this.jdField_c_of_type_Int != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(10, this.jdField_c_of_type_Int);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.loginservice.proto.nano.CgiResult
 * JD-Core Version:    0.7.0.1
 */