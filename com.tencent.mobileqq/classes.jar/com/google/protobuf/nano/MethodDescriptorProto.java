package com.google.protobuf.nano;

public final class MethodDescriptorProto
  extends ExtendableMessageNano<MethodDescriptorProto>
{
  private static volatile MethodDescriptorProto[] g;
  public String a;
  public String b;
  public String c;
  public MethodOptions d;
  public boolean e;
  public boolean f;
  
  public MethodDescriptorProto()
  {
    b();
  }
  
  public static MethodDescriptorProto[] a()
  {
    if (g == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (g == null) {
          g = new MethodDescriptorProto[0];
        }
      }
    }
    return g;
  }
  
  public MethodDescriptorProto a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (i != 26)
          {
            if (i != 34)
            {
              if (i != 40)
              {
                if (i != 48)
                {
                  if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                    return this;
                  }
                }
                else {
                  this.f = paramCodedInputByteBufferNano.readBool();
                }
              }
              else {
                this.e = paramCodedInputByteBufferNano.readBool();
              }
            }
            else
            {
              if (this.d == null) {
                this.d = new MethodOptions();
              }
              paramCodedInputByteBufferNano.readMessage(this.d);
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readString();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readString();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readString();
      }
    }
    return this;
  }
  
  public MethodDescriptorProto b()
  {
    this.a = "";
    this.b = "";
    this.c = "";
    this.d = null;
    this.e = false;
    this.f = false;
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
    j = i;
    if (!this.b.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    i = j;
    if (!this.c.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(3, this.c);
    }
    MethodOptions localMethodOptions = this.d;
    j = i;
    if (localMethodOptions != null) {
      j = i + CodedOutputByteBufferNano.computeMessageSize(4, localMethodOptions);
    }
    boolean bool = this.e;
    i = j;
    if (bool) {
      i = j + CodedOutputByteBufferNano.computeBoolSize(5, bool);
    }
    bool = this.f;
    j = i;
    if (bool) {
      j = i + CodedOutputByteBufferNano.computeBoolSize(6, bool);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!this.a.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.a);
    }
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.b);
    }
    if (!this.c.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.c);
    }
    MethodOptions localMethodOptions = this.d;
    if (localMethodOptions != null) {
      paramCodedOutputByteBufferNano.writeMessage(4, localMethodOptions);
    }
    boolean bool = this.e;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(5, bool);
    }
    bool = this.f;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(6, bool);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.protobuf.nano.MethodDescriptorProto
 * JD-Core Version:    0.7.0.1
 */