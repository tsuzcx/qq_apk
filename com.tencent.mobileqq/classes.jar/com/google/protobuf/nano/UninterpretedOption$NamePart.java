package com.google.protobuf.nano;

public final class UninterpretedOption$NamePart
  extends ExtendableMessageNano<NamePart>
{
  private static volatile NamePart[] c;
  public String a;
  public boolean b;
  
  public UninterpretedOption$NamePart()
  {
    b();
  }
  
  public static NamePart[] a()
  {
    if (c == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (c == null) {
          c = new NamePart[0];
        }
      }
    }
    return c;
  }
  
  public NamePart a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
            return this;
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readBool();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readString();
      }
    }
    return this;
  }
  
  public NamePart b()
  {
    this.a = "";
    this.b = false;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    return super.computeSerializedSize() + CodedOutputByteBufferNano.computeStringSize(1, this.a) + CodedOutputByteBufferNano.computeBoolSize(2, this.b);
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    paramCodedOutputByteBufferNano.writeString(1, this.a);
    paramCodedOutputByteBufferNano.writeBool(2, this.b);
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.protobuf.nano.UninterpretedOption.NamePart
 * JD-Core Version:    0.7.0.1
 */