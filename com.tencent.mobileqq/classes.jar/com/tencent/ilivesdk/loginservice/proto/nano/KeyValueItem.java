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
    if (jdField_a_of_type_ArrayOfComTencentIlivesdkLoginserviceProtoNanoKeyValueItem == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (jdField_a_of_type_ArrayOfComTencentIlivesdkLoginserviceProtoNanoKeyValueItem == null) {
          jdField_a_of_type_ArrayOfComTencentIlivesdkLoginserviceProtoNanoKeyValueItem = new KeyValueItem[0];
        }
      }
    }
    return jdField_a_of_type_ArrayOfComTencentIlivesdkLoginserviceProtoNanoKeyValueItem;
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
      if (i == 0) {
        break;
      }
      if (i != 10)
      {
        if (i != 18)
        {
          if (i != 24)
          {
            if (i != 34)
            {
              if (i != 42)
              {
                if (i != 48)
                {
                  if (i != 58)
                  {
                    if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, i)) {
                      return this;
                    }
                  }
                  else {
                    this.e = paramCodedInputByteBufferNano.readString();
                  }
                }
                else {
                  this.jdField_a_of_type_Long = paramCodedInputByteBufferNano.readInt64();
                }
              }
              else {
                this.d = paramCodedInputByteBufferNano.readString();
              }
            }
            else {
              this.c = paramCodedInputByteBufferNano.readString();
            }
          }
          else {
            this.jdField_a_of_type_Int = paramCodedInputByteBufferNano.readUInt32();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readString();
        }
      }
      else {
        this.jdField_a_of_type_JavaLangString = paramCodedInputByteBufferNano.readString();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    int j = i;
    if (!this.jdField_a_of_type_JavaLangString.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(1, this.jdField_a_of_type_JavaLangString);
    }
    i = j;
    if (!this.b.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    int k = this.jdField_a_of_type_Int;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(3, k);
    }
    i = j;
    if (!this.c.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(4, this.c);
    }
    j = i;
    if (!this.d.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(5, this.d);
    }
    long l = this.jdField_a_of_type_Long;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeInt64Size(6, l);
    }
    j = i;
    if (!this.e.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(7, this.e);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.jdField_a_of_type_JavaLangString);
    }
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.b);
    }
    int i = this.jdField_a_of_type_Int;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(3, i);
    }
    if (!this.c.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.c);
    }
    if (!this.d.equals("")) {
      paramCodedOutputByteBufferNano.writeString(5, this.d);
    }
    long l = this.jdField_a_of_type_Long;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(6, l);
    }
    if (!this.e.equals("")) {
      paramCodedOutputByteBufferNano.writeString(7, this.e);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.loginservice.proto.nano.KeyValueItem
 * JD-Core Version:    0.7.0.1
 */