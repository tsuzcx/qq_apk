package com.tencent.ilivesdk.loginservice.proto.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class CgiLoginRequest
  extends MessageNano
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public CgiLoginRequest()
  {
    a();
  }
  
  public CgiLoginRequest a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.c = "";
    this.d = "";
    this.e = "";
    this.cachedSize = -1;
    return this;
  }
  
  public CgiLoginRequest a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        this.jdField_a_of_type_Int = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 16: 
        this.jdField_b_of_type_Int = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 26: 
        this.jdField_a_of_type_JavaLangString = paramCodedInputByteBufferNano.readString();
        break;
      case 34: 
        this.jdField_b_of_type_JavaLangString = paramCodedInputByteBufferNano.readString();
        break;
      case 42: 
        this.c = paramCodedInputByteBufferNano.readString();
        break;
      case 50: 
        this.d = paramCodedInputByteBufferNano.readString();
        break;
      }
      this.e = paramCodedInputByteBufferNano.readString();
    }
  }
  
  public int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (this.jdField_a_of_type_Int != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(1, this.jdField_a_of_type_Int);
    }
    j = i;
    if (this.jdField_b_of_type_Int != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(2, this.jdField_b_of_type_Int);
    }
    i = j;
    if (!this.jdField_a_of_type_JavaLangString.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(3, this.jdField_a_of_type_JavaLangString);
    }
    j = i;
    if (!this.jdField_b_of_type_JavaLangString.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(4, this.jdField_b_of_type_JavaLangString);
    }
    i = j;
    if (!this.c.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(5, this.c);
    }
    j = i;
    if (!this.d.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(6, this.d);
    }
    i = j;
    if (!this.e.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(7, this.e);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.jdField_a_of_type_Int != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, this.jdField_a_of_type_Int);
    }
    if (this.jdField_b_of_type_Int != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(2, this.jdField_b_of_type_Int);
    }
    if (!this.jdField_a_of_type_JavaLangString.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.jdField_a_of_type_JavaLangString);
    }
    if (!this.jdField_b_of_type_JavaLangString.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.jdField_b_of_type_JavaLangString);
    }
    if (!this.c.equals("")) {
      paramCodedOutputByteBufferNano.writeString(5, this.c);
    }
    if (!this.d.equals("")) {
      paramCodedOutputByteBufferNano.writeString(6, this.d);
    }
    if (!this.e.equals("")) {
      paramCodedOutputByteBufferNano.writeString(7, this.e);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.loginservice.proto.nano.CgiLoginRequest
 * JD-Core Version:    0.7.0.1
 */