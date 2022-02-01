package com.tencent.ilivesdk.loginservice.proto.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class AccountBaseInfo
  extends MessageNano
{
  public int a;
  public long a;
  public String a;
  public int b;
  public long b;
  public String b;
  public int c;
  public long c;
  public String c;
  public String d;
  
  public AccountBaseInfo()
  {
    a();
  }
  
  public AccountBaseInfo a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = 0;
    this.d = "";
    this.jdField_c_of_type_Int = 0;
    this.cachedSize = -1;
    return this;
  }
  
  public AccountBaseInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      switch (i)
      {
      default: 
        if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
          return this;
        }
        break;
      case 80: 
        this.jdField_c_of_type_Int = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 74: 
        this.d = paramCodedInputByteBufferNano.readString();
        break;
      case 64: 
        this.jdField_b_of_type_Int = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 58: 
        this.jdField_c_of_type_JavaLangString = paramCodedInputByteBufferNano.readString();
        break;
      case 48: 
        this.jdField_a_of_type_Int = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 42: 
        this.jdField_b_of_type_JavaLangString = paramCodedInputByteBufferNano.readString();
        break;
      case 32: 
        this.jdField_c_of_type_Long = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 24: 
        this.jdField_b_of_type_Long = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 16: 
        this.jdField_a_of_type_Long = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 10: 
        this.jdField_a_of_type_JavaLangString = paramCodedInputByteBufferNano.readString();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (!this.jdField_a_of_type_JavaLangString.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(1, this.jdField_a_of_type_JavaLangString);
    }
    long l = this.jdField_a_of_type_Long;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(2, l);
    }
    l = this.jdField_b_of_type_Long;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(3, l);
    }
    l = this.jdField_c_of_type_Long;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(4, l);
    }
    i = j;
    if (!this.jdField_b_of_type_JavaLangString.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(5, this.jdField_b_of_type_JavaLangString);
    }
    int k = this.jdField_a_of_type_Int;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(6, k);
    }
    i = j;
    if (!this.jdField_c_of_type_JavaLangString.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(7, this.jdField_c_of_type_JavaLangString);
    }
    k = this.jdField_b_of_type_Int;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(8, k);
    }
    i = j;
    if (!this.d.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(9, this.d);
    }
    k = this.jdField_c_of_type_Int;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(10, k);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.jdField_a_of_type_JavaLangString);
    }
    long l = this.jdField_a_of_type_Long;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, l);
    }
    l = this.jdField_b_of_type_Long;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(3, l);
    }
    l = this.jdField_c_of_type_Long;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(4, l);
    }
    if (!this.jdField_b_of_type_JavaLangString.equals("")) {
      paramCodedOutputByteBufferNano.writeString(5, this.jdField_b_of_type_JavaLangString);
    }
    int i = this.jdField_a_of_type_Int;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(6, i);
    }
    if (!this.jdField_c_of_type_JavaLangString.equals("")) {
      paramCodedOutputByteBufferNano.writeString(7, this.jdField_c_of_type_JavaLangString);
    }
    i = this.jdField_b_of_type_Int;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, i);
    }
    if (!this.d.equals("")) {
      paramCodedOutputByteBufferNano.writeString(9, this.d);
    }
    i = this.jdField_c_of_type_Int;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(10, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.loginservice.proto.nano.AccountBaseInfo
 * JD-Core Version:    0.7.0.1
 */