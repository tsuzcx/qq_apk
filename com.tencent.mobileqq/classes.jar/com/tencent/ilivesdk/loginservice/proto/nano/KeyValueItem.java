package com.tencent.ilivesdk.loginservice.proto.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class KeyValueItem
  extends MessageNano
{
  private static volatile KeyValueItem[] a;
  public int a;
  public long a;
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public KeyValueItem()
  {
    a();
  }
  
  public static KeyValueItem[] a()
  {
    if (jdField_a_of_type_ArrayOfComTencentIlivesdkLoginserviceProtoNanoKeyValueItem == null) {}
    synchronized (InternalNano.LAZY_INIT_LOCK)
    {
      if (jdField_a_of_type_ArrayOfComTencentIlivesdkLoginserviceProtoNanoKeyValueItem == null) {
        jdField_a_of_type_ArrayOfComTencentIlivesdkLoginserviceProtoNanoKeyValueItem = new KeyValueItem[0];
      }
      return jdField_a_of_type_ArrayOfComTencentIlivesdkLoginserviceProtoNanoKeyValueItem;
    }
  }
  
  public KeyValueItem a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.b = "";
    this.jdField_a_of_type_Int = 0;
    this.c = "";
    this.d = "";
    this.jdField_a_of_type_Long = 0L;
    this.e = "";
    this.cachedSize = -1;
    return this;
  }
  
  public KeyValueItem a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 18: 
        this.b = paramCodedInputByteBufferNano.readString();
        break;
      case 24: 
        this.jdField_a_of_type_Int = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 34: 
        this.c = paramCodedInputByteBufferNano.readString();
        break;
      case 42: 
        this.d = paramCodedInputByteBufferNano.readString();
        break;
      case 48: 
        this.jdField_a_of_type_Long = paramCodedInputByteBufferNano.readInt64();
        break;
      }
      this.e = paramCodedInputByteBufferNano.readString();
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
    if (!this.b.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    i = j;
    if (this.jdField_a_of_type_Int != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(3, this.jdField_a_of_type_Int);
    }
    j = i;
    if (!this.c.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(4, this.c);
    }
    i = j;
    if (!this.d.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(5, this.d);
    }
    j = i;
    if (this.jdField_a_of_type_Long != 0L) {
      j = i + CodedOutputByteBufferNano.computeInt64Size(6, this.jdField_a_of_type_Long);
    }
    i = j;
    if (!this.e.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(7, this.e);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.jdField_a_of_type_JavaLangString);
    }
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.b);
    }
    if (this.jdField_a_of_type_Int != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(3, this.jdField_a_of_type_Int);
    }
    if (!this.c.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.c);
    }
    if (!this.d.equals("")) {
      paramCodedOutputByteBufferNano.writeString(5, this.d);
    }
    if (this.jdField_a_of_type_Long != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(6, this.jdField_a_of_type_Long);
    }
    if (!this.e.equals("")) {
      paramCodedOutputByteBufferNano.writeString(7, this.e);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.loginservice.proto.nano.KeyValueItem
 * JD-Core Version:    0.7.0.1
 */