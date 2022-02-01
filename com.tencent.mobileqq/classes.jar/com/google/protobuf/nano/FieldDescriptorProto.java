package com.google.protobuf.nano;

public final class FieldDescriptorProto
  extends ExtendableMessageNano<FieldDescriptorProto>
{
  private static volatile FieldDescriptorProto[] k;
  public String a;
  public int b;
  public int c;
  public int d;
  public String e;
  public String f;
  public String g;
  public int h;
  public String i;
  public FieldOptions j;
  
  public FieldDescriptorProto()
  {
    b();
  }
  
  public static FieldDescriptorProto[] a()
  {
    if (k == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (k == null) {
          k = new FieldDescriptorProto[0];
        }
      }
    }
    return k;
  }
  
  public FieldDescriptorProto a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int m = paramCodedInputByteBufferNano.readTag();
      switch (m)
      {
      default: 
        if (!storeUnknownField(paramCodedInputByteBufferNano, m)) {
          return this;
        }
        break;
      case 82: 
        this.i = paramCodedInputByteBufferNano.readString();
        break;
      case 72: 
        this.h = paramCodedInputByteBufferNano.readInt32();
        break;
      case 66: 
        if (this.j == null) {
          this.j = new FieldOptions();
        }
        paramCodedInputByteBufferNano.readMessage(this.j);
        break;
      case 58: 
        this.g = paramCodedInputByteBufferNano.readString();
        break;
      case 50: 
        this.e = paramCodedInputByteBufferNano.readString();
        break;
      case 40: 
        m = paramCodedInputByteBufferNano.readInt32();
        switch (m)
        {
        default: 
          break;
        }
        this.d = m;
        break;
      case 32: 
        m = paramCodedInputByteBufferNano.readInt32();
        if ((m == 1) || (m == 2) || (m == 3)) {
          this.c = m;
        }
        break;
      case 24: 
        this.b = paramCodedInputByteBufferNano.readInt32();
        break;
      case 18: 
        this.f = paramCodedInputByteBufferNano.readString();
        break;
      case 10: 
        this.a = paramCodedInputByteBufferNano.readString();
      }
    }
    return this;
  }
  
  public FieldDescriptorProto b()
  {
    this.a = "";
    this.b = 0;
    this.c = 1;
    this.d = 1;
    this.e = "";
    this.f = "";
    this.g = "";
    this.h = 0;
    this.i = "";
    this.j = null;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int n = super.computeSerializedSize();
    int m = n;
    if (!this.a.equals("")) {
      m = n + CodedOutputByteBufferNano.computeStringSize(1, this.a);
    }
    n = m;
    if (!this.f.equals("")) {
      n = m + CodedOutputByteBufferNano.computeStringSize(2, this.f);
    }
    int i1 = this.b;
    m = n;
    if (i1 != 0) {
      m = n + CodedOutputByteBufferNano.computeInt32Size(3, i1);
    }
    i1 = this.c;
    n = m;
    if (i1 != 1) {
      n = m + CodedOutputByteBufferNano.computeInt32Size(4, i1);
    }
    i1 = this.d;
    m = n;
    if (i1 != 1) {
      m = n + CodedOutputByteBufferNano.computeInt32Size(5, i1);
    }
    n = m;
    if (!this.e.equals("")) {
      n = m + CodedOutputByteBufferNano.computeStringSize(6, this.e);
    }
    i1 = n;
    if (!this.g.equals("")) {
      i1 = n + CodedOutputByteBufferNano.computeStringSize(7, this.g);
    }
    FieldOptions localFieldOptions = this.j;
    m = i1;
    if (localFieldOptions != null) {
      m = i1 + CodedOutputByteBufferNano.computeMessageSize(8, localFieldOptions);
    }
    i1 = this.h;
    n = m;
    if (i1 != 0) {
      n = m + CodedOutputByteBufferNano.computeInt32Size(9, i1);
    }
    m = n;
    if (!this.i.equals("")) {
      m = n + CodedOutputByteBufferNano.computeStringSize(10, this.i);
    }
    return m;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!this.a.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.a);
    }
    if (!this.f.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.f);
    }
    int m = this.b;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeInt32(3, m);
    }
    m = this.c;
    if (m != 1) {
      paramCodedOutputByteBufferNano.writeInt32(4, m);
    }
    m = this.d;
    if (m != 1) {
      paramCodedOutputByteBufferNano.writeInt32(5, m);
    }
    if (!this.e.equals("")) {
      paramCodedOutputByteBufferNano.writeString(6, this.e);
    }
    if (!this.g.equals("")) {
      paramCodedOutputByteBufferNano.writeString(7, this.g);
    }
    FieldOptions localFieldOptions = this.j;
    if (localFieldOptions != null) {
      paramCodedOutputByteBufferNano.writeMessage(8, localFieldOptions);
    }
    m = this.h;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeInt32(9, m);
    }
    if (!this.i.equals("")) {
      paramCodedOutputByteBufferNano.writeString(10, this.i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.protobuf.nano.FieldDescriptorProto
 * JD-Core Version:    0.7.0.1
 */