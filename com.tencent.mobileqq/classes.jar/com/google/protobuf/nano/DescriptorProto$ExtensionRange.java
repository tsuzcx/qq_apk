package com.google.protobuf.nano;

public final class DescriptorProto$ExtensionRange
  extends ExtendableMessageNano<ExtensionRange>
{
  private static volatile ExtensionRange[] d;
  public int a;
  public int b;
  public ExtensionRangeOptions c;
  
  public DescriptorProto$ExtensionRange()
  {
    b();
  }
  
  public static ExtensionRange[] a()
  {
    if (d == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (d == null) {
          d = new ExtensionRange[0];
        }
      }
    }
    return d;
  }
  
  public ExtensionRange a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 8)
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
              this.c = new ExtensionRangeOptions();
            }
            paramCodedInputByteBufferNano.readMessage(this.c);
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readInt32();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readInt32();
      }
    }
    return this;
  }
  
  public ExtensionRange b()
  {
    this.a = 0;
    this.b = 0;
    this.c = null;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int k = this.a;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(1, k);
    }
    k = this.b;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(2, k);
    }
    ExtensionRangeOptions localExtensionRangeOptions = this.c;
    i = j;
    if (localExtensionRangeOptions != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(3, localExtensionRangeOptions);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.a;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1, i);
    }
    i = this.b;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(2, i);
    }
    ExtensionRangeOptions localExtensionRangeOptions = this.c;
    if (localExtensionRangeOptions != null) {
      paramCodedOutputByteBufferNano.writeMessage(3, localExtensionRangeOptions);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.protobuf.nano.DescriptorProto.ExtensionRange
 * JD-Core Version:    0.7.0.1
 */