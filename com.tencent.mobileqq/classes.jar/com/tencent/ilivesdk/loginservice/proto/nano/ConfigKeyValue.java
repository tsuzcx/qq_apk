package com.tencent.ilivesdk.loginservice.proto.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class ConfigKeyValue
  extends MessageNano
{
  public String a;
  public KeyValueItem[] a;
  
  public ConfigKeyValue()
  {
    a();
  }
  
  public ConfigKeyValue a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ArrayOfComTencentIlivesdkLoginserviceProtoNanoKeyValueItem = KeyValueItem.a();
    this.cachedSize = -1;
    return this;
  }
  
  public ConfigKeyValue a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 18);
      if (this.jdField_a_of_type_ArrayOfComTencentIlivesdkLoginserviceProtoNanoKeyValueItem == null) {}
      KeyValueItem[] arrayOfKeyValueItem;
      for (i = 0;; i = this.jdField_a_of_type_ArrayOfComTencentIlivesdkLoginserviceProtoNanoKeyValueItem.length)
      {
        arrayOfKeyValueItem = new KeyValueItem[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.jdField_a_of_type_ArrayOfComTencentIlivesdkLoginserviceProtoNanoKeyValueItem, 0, arrayOfKeyValueItem, 0, i);
          j = i;
        }
        while (j < arrayOfKeyValueItem.length - 1)
        {
          arrayOfKeyValueItem[j] = new KeyValueItem();
          paramCodedInputByteBufferNano.readMessage(arrayOfKeyValueItem[j]);
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
      }
      arrayOfKeyValueItem[j] = new KeyValueItem();
      paramCodedInputByteBufferNano.readMessage(arrayOfKeyValueItem[j]);
      this.jdField_a_of_type_ArrayOfComTencentIlivesdkLoginserviceProtoNanoKeyValueItem = arrayOfKeyValueItem;
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
    if (this.jdField_a_of_type_ArrayOfComTencentIlivesdkLoginserviceProtoNanoKeyValueItem != null)
    {
      j = i;
      if (this.jdField_a_of_type_ArrayOfComTencentIlivesdkLoginserviceProtoNanoKeyValueItem.length > 0)
      {
        j = 0;
        while (j < this.jdField_a_of_type_ArrayOfComTencentIlivesdkLoginserviceProtoNanoKeyValueItem.length)
        {
          KeyValueItem localKeyValueItem = this.jdField_a_of_type_ArrayOfComTencentIlivesdkLoginserviceProtoNanoKeyValueItem[j];
          int k = i;
          if (localKeyValueItem != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(2, localKeyValueItem);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.jdField_a_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_ArrayOfComTencentIlivesdkLoginserviceProtoNanoKeyValueItem != null) && (this.jdField_a_of_type_ArrayOfComTencentIlivesdkLoginserviceProtoNanoKeyValueItem.length > 0))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfComTencentIlivesdkLoginserviceProtoNanoKeyValueItem.length)
      {
        KeyValueItem localKeyValueItem = this.jdField_a_of_type_ArrayOfComTencentIlivesdkLoginserviceProtoNanoKeyValueItem[i];
        if (localKeyValueItem != null) {
          paramCodedOutputByteBufferNano.writeMessage(2, localKeyValueItem);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.loginservice.proto.nano.ConfigKeyValue
 * JD-Core Version:    0.7.0.1
 */