package com.google.protobuf.nano;

public final class EnumValueDescriptorProto
  extends ExtendableMessageNano<EnumValueDescriptorProto>
{
  private static volatile EnumValueDescriptorProto[] d;
  public String a;
  public int b;
  public EnumValueOptions c;
  
  public EnumValueDescriptorProto()
  {
    b();
  }
  
  public static EnumValueDescriptorProto[] a()
  {
    if (d == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (d == null) {
          d = new EnumValueDescriptorProto[0];
        }
      }
    }
    return d;
  }
  
  public EnumValueDescriptorProto a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 10)
      {
        if (i != 16)
        {
          if (i != 26)
          {
            if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
              return this;
            }
          }
          else
          {
            if (this.c == null) {
              this.c = new EnumValueOptions();
            }
            paramCodedInputByteBufferNano.readMessage(this.c);
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readInt32();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readString();
      }
    }
    return this;
  }
  
  public EnumValueDescriptorProto b()
  {
    this.a = "";
    this.b = 0;
    this.c = null;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int i = j;
    if (!this.a.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(1, this.a);
    }
    int k = this.b;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(2, k);
    }
    EnumValueOptions localEnumValueOptions = this.c;
    i = j;
    if (localEnumValueOptions != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(3, localEnumValueOptions);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!this.a.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.a);
    }
    int i = this.b;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(2, i);
    }
    EnumValueOptions localEnumValueOptions = this.c;
    if (localEnumValueOptions != null) {
      paramCodedOutputByteBufferNano.writeMessage(3, localEnumValueOptions);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.protobuf.nano.EnumValueDescriptorProto
 * JD-Core Version:    0.7.0.1
 */