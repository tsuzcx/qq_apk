package com.google.protobuf.nano;

public final class DescriptorProto
  extends ExtendableMessageNano<DescriptorProto>
{
  private static volatile DescriptorProto[] k;
  public String a;
  public FieldDescriptorProto[] b;
  public FieldDescriptorProto[] c;
  public DescriptorProto[] d;
  public EnumDescriptorProto[] e;
  public DescriptorProto.ExtensionRange[] f;
  public OneofDescriptorProto[] g;
  public MessageOptions h;
  public DescriptorProto.ReservedRange[] i;
  public String[] j;
  
  public DescriptorProto()
  {
    b();
  }
  
  public static DescriptorProto[] a()
  {
    if (k == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (k == null) {
          k = new DescriptorProto[0];
        }
      }
    }
    return k;
  }
  
  public DescriptorProto a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int m = paramCodedInputByteBufferNano.readTag();
      int n;
      Object localObject;
      switch (m)
      {
      default: 
        if (!storeUnknownField(paramCodedInputByteBufferNano, m)) {
          return this;
        }
        break;
      case 82: 
        n = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 82);
        localObject = this.j;
        if (localObject == null) {
          m = 0;
        } else {
          m = localObject.length;
        }
        localObject = new String[n + m];
        n = m;
        if (m != 0)
        {
          System.arraycopy(this.j, 0, localObject, 0, m);
          n = m;
        }
        while (n < localObject.length - 1)
        {
          localObject[n] = paramCodedInputByteBufferNano.readString();
          paramCodedInputByteBufferNano.readTag();
          n += 1;
        }
        localObject[n] = paramCodedInputByteBufferNano.readString();
        this.j = ((String[])localObject);
        break;
      case 74: 
        n = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 74);
        localObject = this.i;
        if (localObject == null) {
          m = 0;
        } else {
          m = localObject.length;
        }
        localObject = new DescriptorProto.ReservedRange[n + m];
        n = m;
        if (m != 0)
        {
          System.arraycopy(this.i, 0, localObject, 0, m);
          n = m;
        }
        while (n < localObject.length - 1)
        {
          localObject[n] = new DescriptorProto.ReservedRange();
          paramCodedInputByteBufferNano.readMessage(localObject[n]);
          paramCodedInputByteBufferNano.readTag();
          n += 1;
        }
        localObject[n] = new DescriptorProto.ReservedRange();
        paramCodedInputByteBufferNano.readMessage(localObject[n]);
        this.i = ((DescriptorProto.ReservedRange[])localObject);
        break;
      case 66: 
        n = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 66);
        localObject = this.g;
        if (localObject == null) {
          m = 0;
        } else {
          m = localObject.length;
        }
        localObject = new OneofDescriptorProto[n + m];
        n = m;
        if (m != 0)
        {
          System.arraycopy(this.g, 0, localObject, 0, m);
          n = m;
        }
        while (n < localObject.length - 1)
        {
          localObject[n] = new OneofDescriptorProto();
          paramCodedInputByteBufferNano.readMessage(localObject[n]);
          paramCodedInputByteBufferNano.readTag();
          n += 1;
        }
        localObject[n] = new OneofDescriptorProto();
        paramCodedInputByteBufferNano.readMessage(localObject[n]);
        this.g = ((OneofDescriptorProto[])localObject);
        break;
      case 58: 
        if (this.h == null) {
          this.h = new MessageOptions();
        }
        paramCodedInputByteBufferNano.readMessage(this.h);
        break;
      case 50: 
        n = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 50);
        localObject = this.c;
        if (localObject == null) {
          m = 0;
        } else {
          m = localObject.length;
        }
        localObject = new FieldDescriptorProto[n + m];
        n = m;
        if (m != 0)
        {
          System.arraycopy(this.c, 0, localObject, 0, m);
          n = m;
        }
        while (n < localObject.length - 1)
        {
          localObject[n] = new FieldDescriptorProto();
          paramCodedInputByteBufferNano.readMessage(localObject[n]);
          paramCodedInputByteBufferNano.readTag();
          n += 1;
        }
        localObject[n] = new FieldDescriptorProto();
        paramCodedInputByteBufferNano.readMessage(localObject[n]);
        this.c = ((FieldDescriptorProto[])localObject);
        break;
      case 42: 
        n = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 42);
        localObject = this.f;
        if (localObject == null) {
          m = 0;
        } else {
          m = localObject.length;
        }
        localObject = new DescriptorProto.ExtensionRange[n + m];
        n = m;
        if (m != 0)
        {
          System.arraycopy(this.f, 0, localObject, 0, m);
          n = m;
        }
        while (n < localObject.length - 1)
        {
          localObject[n] = new DescriptorProto.ExtensionRange();
          paramCodedInputByteBufferNano.readMessage(localObject[n]);
          paramCodedInputByteBufferNano.readTag();
          n += 1;
        }
        localObject[n] = new DescriptorProto.ExtensionRange();
        paramCodedInputByteBufferNano.readMessage(localObject[n]);
        this.f = ((DescriptorProto.ExtensionRange[])localObject);
        break;
      case 34: 
        n = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 34);
        localObject = this.e;
        if (localObject == null) {
          m = 0;
        } else {
          m = localObject.length;
        }
        localObject = new EnumDescriptorProto[n + m];
        n = m;
        if (m != 0)
        {
          System.arraycopy(this.e, 0, localObject, 0, m);
          n = m;
        }
        while (n < localObject.length - 1)
        {
          localObject[n] = new EnumDescriptorProto();
          paramCodedInputByteBufferNano.readMessage(localObject[n]);
          paramCodedInputByteBufferNano.readTag();
          n += 1;
        }
        localObject[n] = new EnumDescriptorProto();
        paramCodedInputByteBufferNano.readMessage(localObject[n]);
        this.e = ((EnumDescriptorProto[])localObject);
        break;
      case 26: 
        n = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 26);
        localObject = this.d;
        if (localObject == null) {
          m = 0;
        } else {
          m = localObject.length;
        }
        localObject = new DescriptorProto[n + m];
        n = m;
        if (m != 0)
        {
          System.arraycopy(this.d, 0, localObject, 0, m);
          n = m;
        }
        while (n < localObject.length - 1)
        {
          localObject[n] = new DescriptorProto();
          paramCodedInputByteBufferNano.readMessage(localObject[n]);
          paramCodedInputByteBufferNano.readTag();
          n += 1;
        }
        localObject[n] = new DescriptorProto();
        paramCodedInputByteBufferNano.readMessage(localObject[n]);
        this.d = ((DescriptorProto[])localObject);
        break;
      case 18: 
        n = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 18);
        localObject = this.b;
        if (localObject == null) {
          m = 0;
        } else {
          m = localObject.length;
        }
        localObject = new FieldDescriptorProto[n + m];
        n = m;
        if (m != 0)
        {
          System.arraycopy(this.b, 0, localObject, 0, m);
          n = m;
        }
        while (n < localObject.length - 1)
        {
          localObject[n] = new FieldDescriptorProto();
          paramCodedInputByteBufferNano.readMessage(localObject[n]);
          paramCodedInputByteBufferNano.readTag();
          n += 1;
        }
        localObject[n] = new FieldDescriptorProto();
        paramCodedInputByteBufferNano.readMessage(localObject[n]);
        this.b = ((FieldDescriptorProto[])localObject);
        break;
      case 10: 
        this.a = paramCodedInputByteBufferNano.readString();
      }
    }
    return this;
  }
  
  public DescriptorProto b()
  {
    this.a = "";
    this.b = FieldDescriptorProto.a();
    this.c = FieldDescriptorProto.a();
    this.d = a();
    this.e = EnumDescriptorProto.a();
    this.f = DescriptorProto.ExtensionRange.a();
    this.g = OneofDescriptorProto.a();
    this.h = null;
    this.i = DescriptorProto.ReservedRange.a();
    this.j = WireFormatNano.EMPTY_STRING_ARRAY;
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
    Object localObject = this.b;
    int i3 = 0;
    n = m;
    int i1;
    if (localObject != null)
    {
      n = m;
      if (localObject.length > 0)
      {
        n = 0;
        for (;;)
        {
          localObject = this.b;
          if (n >= localObject.length) {
            break;
          }
          localObject = localObject[n];
          i1 = m;
          if (localObject != null) {
            i1 = m + CodedOutputByteBufferNano.computeMessageSize(2, (MessageNano)localObject);
          }
          n += 1;
          m = i1;
        }
        n = m;
      }
    }
    localObject = this.d;
    m = n;
    if (localObject != null)
    {
      m = n;
      if (localObject.length > 0)
      {
        m = n;
        n = 0;
        for (;;)
        {
          localObject = this.d;
          if (n >= localObject.length) {
            break;
          }
          localObject = localObject[n];
          i1 = m;
          if (localObject != null) {
            i1 = m + CodedOutputByteBufferNano.computeMessageSize(3, (MessageNano)localObject);
          }
          n += 1;
          m = i1;
        }
      }
    }
    localObject = this.e;
    n = m;
    if (localObject != null)
    {
      n = m;
      if (localObject.length > 0)
      {
        n = 0;
        for (;;)
        {
          localObject = this.e;
          if (n >= localObject.length) {
            break;
          }
          localObject = localObject[n];
          i1 = m;
          if (localObject != null) {
            i1 = m + CodedOutputByteBufferNano.computeMessageSize(4, (MessageNano)localObject);
          }
          n += 1;
          m = i1;
        }
        n = m;
      }
    }
    localObject = this.f;
    m = n;
    if (localObject != null)
    {
      m = n;
      if (localObject.length > 0)
      {
        m = n;
        n = 0;
        for (;;)
        {
          localObject = this.f;
          if (n >= localObject.length) {
            break;
          }
          localObject = localObject[n];
          i1 = m;
          if (localObject != null) {
            i1 = m + CodedOutputByteBufferNano.computeMessageSize(5, (MessageNano)localObject);
          }
          n += 1;
          m = i1;
        }
      }
    }
    localObject = this.c;
    n = m;
    if (localObject != null)
    {
      n = m;
      if (localObject.length > 0)
      {
        n = 0;
        for (;;)
        {
          localObject = this.c;
          if (n >= localObject.length) {
            break;
          }
          localObject = localObject[n];
          i1 = m;
          if (localObject != null) {
            i1 = m + CodedOutputByteBufferNano.computeMessageSize(6, (MessageNano)localObject);
          }
          n += 1;
          m = i1;
        }
        n = m;
      }
    }
    localObject = this.h;
    m = n;
    if (localObject != null) {
      m = n + CodedOutputByteBufferNano.computeMessageSize(7, (MessageNano)localObject);
    }
    localObject = this.g;
    n = m;
    if (localObject != null)
    {
      n = m;
      if (localObject.length > 0)
      {
        n = 0;
        for (;;)
        {
          localObject = this.g;
          if (n >= localObject.length) {
            break;
          }
          localObject = localObject[n];
          i1 = m;
          if (localObject != null) {
            i1 = m + CodedOutputByteBufferNano.computeMessageSize(8, (MessageNano)localObject);
          }
          n += 1;
          m = i1;
        }
        n = m;
      }
    }
    localObject = this.i;
    m = n;
    if (localObject != null)
    {
      m = n;
      if (localObject.length > 0)
      {
        m = n;
        n = 0;
        for (;;)
        {
          localObject = this.i;
          if (n >= localObject.length) {
            break;
          }
          localObject = localObject[n];
          i1 = m;
          if (localObject != null) {
            i1 = m + CodedOutputByteBufferNano.computeMessageSize(9, (MessageNano)localObject);
          }
          n += 1;
          m = i1;
        }
      }
    }
    localObject = this.j;
    n = m;
    if (localObject != null)
    {
      n = m;
      if (localObject.length > 0)
      {
        i1 = 0;
        int i2 = 0;
        n = i3;
        for (;;)
        {
          localObject = this.j;
          if (n >= localObject.length) {
            break;
          }
          localObject = localObject[n];
          int i4 = i1;
          i3 = i2;
          if (localObject != null)
          {
            i3 = i2 + 1;
            i4 = i1 + CodedOutputByteBufferNano.computeStringSizeNoTag((String)localObject);
          }
          n += 1;
          i1 = i4;
          i2 = i3;
        }
        n = m + i1 + i2 * 1;
      }
    }
    return n;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!this.a.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.a);
    }
    Object localObject = this.b;
    int n = 0;
    int m;
    if ((localObject != null) && (localObject.length > 0))
    {
      m = 0;
      for (;;)
      {
        localObject = this.b;
        if (m >= localObject.length) {
          break;
        }
        localObject = localObject[m];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(2, (MessageNano)localObject);
        }
        m += 1;
      }
    }
    localObject = this.d;
    if ((localObject != null) && (localObject.length > 0))
    {
      m = 0;
      for (;;)
      {
        localObject = this.d;
        if (m >= localObject.length) {
          break;
        }
        localObject = localObject[m];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(3, (MessageNano)localObject);
        }
        m += 1;
      }
    }
    localObject = this.e;
    if ((localObject != null) && (localObject.length > 0))
    {
      m = 0;
      for (;;)
      {
        localObject = this.e;
        if (m >= localObject.length) {
          break;
        }
        localObject = localObject[m];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(4, (MessageNano)localObject);
        }
        m += 1;
      }
    }
    localObject = this.f;
    if ((localObject != null) && (localObject.length > 0))
    {
      m = 0;
      for (;;)
      {
        localObject = this.f;
        if (m >= localObject.length) {
          break;
        }
        localObject = localObject[m];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(5, (MessageNano)localObject);
        }
        m += 1;
      }
    }
    localObject = this.c;
    if ((localObject != null) && (localObject.length > 0))
    {
      m = 0;
      for (;;)
      {
        localObject = this.c;
        if (m >= localObject.length) {
          break;
        }
        localObject = localObject[m];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(6, (MessageNano)localObject);
        }
        m += 1;
      }
    }
    localObject = this.h;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(7, (MessageNano)localObject);
    }
    localObject = this.g;
    if ((localObject != null) && (localObject.length > 0))
    {
      m = 0;
      for (;;)
      {
        localObject = this.g;
        if (m >= localObject.length) {
          break;
        }
        localObject = localObject[m];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(8, (MessageNano)localObject);
        }
        m += 1;
      }
    }
    localObject = this.i;
    if ((localObject != null) && (localObject.length > 0))
    {
      m = 0;
      for (;;)
      {
        localObject = this.i;
        if (m >= localObject.length) {
          break;
        }
        localObject = localObject[m];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(9, (MessageNano)localObject);
        }
        m += 1;
      }
    }
    localObject = this.j;
    if ((localObject != null) && (localObject.length > 0))
    {
      m = n;
      for (;;)
      {
        localObject = this.j;
        if (m >= localObject.length) {
          break;
        }
        localObject = localObject[m];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeString(10, (String)localObject);
        }
        m += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.protobuf.nano.DescriptorProto
 * JD-Core Version:    0.7.0.1
 */