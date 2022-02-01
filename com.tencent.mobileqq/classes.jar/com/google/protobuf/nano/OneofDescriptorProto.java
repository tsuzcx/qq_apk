package com.google.protobuf.nano;

public final class OneofDescriptorProto
  extends ExtendableMessageNano<OneofDescriptorProto>
{
  private static volatile OneofDescriptorProto[] c;
  public String a;
  public OneofOptions b;
  
  public OneofDescriptorProto()
  {
    b();
  }
  
  public static OneofDescriptorProto[] a()
  {
    if (c == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (c == null) {
          c = new OneofDescriptorProto[0];
        }
      }
    }
    return c;
  }
  
  public OneofDescriptorProto a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
            return this;
          }
        }
        else
        {
          if (this.b == null) {
            this.b = new OneofOptions();
          }
          paramCodedInputByteBufferNano.readMessage(this.b);
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readString();
      }
    }
    return this;
  }
  
  public OneofDescriptorProto b()
  {
    this.a = "";
    this.b = null;
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
    OneofOptions localOneofOptions = this.b;
    j = i;
    if (localOneofOptions != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(2, localOneofOptions);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!this.a.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.a);
    }
    OneofOptions localOneofOptions = this.b;
    if (localOneofOptions != null) {
      paramCodedOutputByteBufferNano.writeMessage(2, localOneofOptions);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.protobuf.nano.OneofDescriptorProto
 * JD-Core Version:    0.7.0.1
 */