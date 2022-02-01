package com.google.protobuf.nano;

public final class FileDescriptorProto
  extends ExtendableMessageNano<FileDescriptorProto>
{
  private static volatile FileDescriptorProto[] m;
  public String a;
  public String b;
  public String[] c;
  public int[] d;
  public int[] e;
  public DescriptorProto[] f;
  public EnumDescriptorProto[] g;
  public ServiceDescriptorProto[] h;
  public FieldDescriptorProto[] i;
  public FileOptions j;
  public SourceCodeInfo k;
  public String l;
  
  public FileDescriptorProto()
  {
    b();
  }
  
  public static FileDescriptorProto[] a()
  {
    if (m == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (m == null) {
          m = new FileDescriptorProto[0];
        }
      }
    }
    return m;
  }
  
  public FileDescriptorProto a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int n = paramCodedInputByteBufferNano.readTag();
      int i2;
      int i1;
      Object localObject;
      switch (n)
      {
      default: 
        if (!storeUnknownField(paramCodedInputByteBufferNano, n)) {
          return this;
        }
        break;
      case 98: 
        this.l = paramCodedInputByteBufferNano.readString();
        break;
      case 90: 
        i2 = paramCodedInputByteBufferNano.pushLimit(paramCodedInputByteBufferNano.readRawVarint32());
        n = paramCodedInputByteBufferNano.getPosition();
        i1 = 0;
        while (paramCodedInputByteBufferNano.getBytesUntilLimit() > 0)
        {
          paramCodedInputByteBufferNano.readInt32();
          i1 += 1;
        }
        paramCodedInputByteBufferNano.rewindToPosition(n);
        localObject = this.e;
        if (localObject == null) {
          n = 0;
        } else {
          n = localObject.length;
        }
        localObject = new int[i1 + n];
        i1 = n;
        if (n != 0)
        {
          System.arraycopy(this.e, 0, localObject, 0, n);
          i1 = n;
        }
        while (i1 < localObject.length)
        {
          localObject[i1] = paramCodedInputByteBufferNano.readInt32();
          i1 += 1;
        }
        this.e = ((int[])localObject);
        paramCodedInputByteBufferNano.popLimit(i2);
        break;
      case 88: 
        i1 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 88);
        localObject = this.e;
        if (localObject == null) {
          n = 0;
        } else {
          n = localObject.length;
        }
        localObject = new int[i1 + n];
        i1 = n;
        if (n != 0)
        {
          System.arraycopy(this.e, 0, localObject, 0, n);
          i1 = n;
        }
        while (i1 < localObject.length - 1)
        {
          localObject[i1] = paramCodedInputByteBufferNano.readInt32();
          paramCodedInputByteBufferNano.readTag();
          i1 += 1;
        }
        localObject[i1] = paramCodedInputByteBufferNano.readInt32();
        this.e = ((int[])localObject);
        break;
      case 82: 
        i2 = paramCodedInputByteBufferNano.pushLimit(paramCodedInputByteBufferNano.readRawVarint32());
        n = paramCodedInputByteBufferNano.getPosition();
        i1 = 0;
        while (paramCodedInputByteBufferNano.getBytesUntilLimit() > 0)
        {
          paramCodedInputByteBufferNano.readInt32();
          i1 += 1;
        }
        paramCodedInputByteBufferNano.rewindToPosition(n);
        localObject = this.d;
        if (localObject == null) {
          n = 0;
        } else {
          n = localObject.length;
        }
        localObject = new int[i1 + n];
        i1 = n;
        if (n != 0)
        {
          System.arraycopy(this.d, 0, localObject, 0, n);
          i1 = n;
        }
        while (i1 < localObject.length)
        {
          localObject[i1] = paramCodedInputByteBufferNano.readInt32();
          i1 += 1;
        }
        this.d = ((int[])localObject);
        paramCodedInputByteBufferNano.popLimit(i2);
        break;
      case 80: 
        i1 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 80);
        localObject = this.d;
        if (localObject == null) {
          n = 0;
        } else {
          n = localObject.length;
        }
        localObject = new int[i1 + n];
        i1 = n;
        if (n != 0)
        {
          System.arraycopy(this.d, 0, localObject, 0, n);
          i1 = n;
        }
        while (i1 < localObject.length - 1)
        {
          localObject[i1] = paramCodedInputByteBufferNano.readInt32();
          paramCodedInputByteBufferNano.readTag();
          i1 += 1;
        }
        localObject[i1] = paramCodedInputByteBufferNano.readInt32();
        this.d = ((int[])localObject);
        break;
      case 74: 
        if (this.k == null) {
          this.k = new SourceCodeInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.k);
        break;
      case 66: 
        if (this.j == null) {
          this.j = new FileOptions();
        }
        paramCodedInputByteBufferNano.readMessage(this.j);
        break;
      case 58: 
        i1 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 58);
        localObject = this.i;
        if (localObject == null) {
          n = 0;
        } else {
          n = localObject.length;
        }
        localObject = new FieldDescriptorProto[i1 + n];
        i1 = n;
        if (n != 0)
        {
          System.arraycopy(this.i, 0, localObject, 0, n);
          i1 = n;
        }
        while (i1 < localObject.length - 1)
        {
          localObject[i1] = new FieldDescriptorProto();
          paramCodedInputByteBufferNano.readMessage(localObject[i1]);
          paramCodedInputByteBufferNano.readTag();
          i1 += 1;
        }
        localObject[i1] = new FieldDescriptorProto();
        paramCodedInputByteBufferNano.readMessage(localObject[i1]);
        this.i = ((FieldDescriptorProto[])localObject);
        break;
      case 50: 
        i1 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 50);
        localObject = this.h;
        if (localObject == null) {
          n = 0;
        } else {
          n = localObject.length;
        }
        localObject = new ServiceDescriptorProto[i1 + n];
        i1 = n;
        if (n != 0)
        {
          System.arraycopy(this.h, 0, localObject, 0, n);
          i1 = n;
        }
        while (i1 < localObject.length - 1)
        {
          localObject[i1] = new ServiceDescriptorProto();
          paramCodedInputByteBufferNano.readMessage(localObject[i1]);
          paramCodedInputByteBufferNano.readTag();
          i1 += 1;
        }
        localObject[i1] = new ServiceDescriptorProto();
        paramCodedInputByteBufferNano.readMessage(localObject[i1]);
        this.h = ((ServiceDescriptorProto[])localObject);
        break;
      case 42: 
        i1 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 42);
        localObject = this.g;
        if (localObject == null) {
          n = 0;
        } else {
          n = localObject.length;
        }
        localObject = new EnumDescriptorProto[i1 + n];
        i1 = n;
        if (n != 0)
        {
          System.arraycopy(this.g, 0, localObject, 0, n);
          i1 = n;
        }
        while (i1 < localObject.length - 1)
        {
          localObject[i1] = new EnumDescriptorProto();
          paramCodedInputByteBufferNano.readMessage(localObject[i1]);
          paramCodedInputByteBufferNano.readTag();
          i1 += 1;
        }
        localObject[i1] = new EnumDescriptorProto();
        paramCodedInputByteBufferNano.readMessage(localObject[i1]);
        this.g = ((EnumDescriptorProto[])localObject);
        break;
      case 34: 
        i1 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 34);
        localObject = this.f;
        if (localObject == null) {
          n = 0;
        } else {
          n = localObject.length;
        }
        localObject = new DescriptorProto[i1 + n];
        i1 = n;
        if (n != 0)
        {
          System.arraycopy(this.f, 0, localObject, 0, n);
          i1 = n;
        }
        while (i1 < localObject.length - 1)
        {
          localObject[i1] = new DescriptorProto();
          paramCodedInputByteBufferNano.readMessage(localObject[i1]);
          paramCodedInputByteBufferNano.readTag();
          i1 += 1;
        }
        localObject[i1] = new DescriptorProto();
        paramCodedInputByteBufferNano.readMessage(localObject[i1]);
        this.f = ((DescriptorProto[])localObject);
        break;
      case 26: 
        i1 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 26);
        localObject = this.c;
        if (localObject == null) {
          n = 0;
        } else {
          n = localObject.length;
        }
        localObject = new String[i1 + n];
        i1 = n;
        if (n != 0)
        {
          System.arraycopy(this.c, 0, localObject, 0, n);
          i1 = n;
        }
        while (i1 < localObject.length - 1)
        {
          localObject[i1] = paramCodedInputByteBufferNano.readString();
          paramCodedInputByteBufferNano.readTag();
          i1 += 1;
        }
        localObject[i1] = paramCodedInputByteBufferNano.readString();
        this.c = ((String[])localObject);
        break;
      case 18: 
        this.b = paramCodedInputByteBufferNano.readString();
        break;
      case 10: 
        this.a = paramCodedInputByteBufferNano.readString();
      }
    }
    return this;
  }
  
  public FileDescriptorProto b()
  {
    this.a = "";
    this.b = "";
    this.c = WireFormatNano.EMPTY_STRING_ARRAY;
    this.d = WireFormatNano.EMPTY_INT_ARRAY;
    this.e = WireFormatNano.EMPTY_INT_ARRAY;
    this.f = DescriptorProto.a();
    this.g = EnumDescriptorProto.a();
    this.h = ServiceDescriptorProto.a();
    this.i = FieldDescriptorProto.a();
    this.j = null;
    this.k = null;
    this.l = "";
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i1 = super.computeSerializedSize();
    int n = i1;
    if (!this.a.equals("")) {
      n = i1 + CodedOutputByteBufferNano.computeStringSize(1, this.a);
    }
    i1 = n;
    if (!this.b.equals("")) {
      i1 = n + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    Object localObject = this.c;
    int i6 = 0;
    n = i1;
    int i2;
    if (localObject != null)
    {
      n = i1;
      if (localObject.length > 0)
      {
        n = 0;
        i2 = 0;
        int i4;
        for (int i3 = 0;; i3 = i4)
        {
          localObject = this.c;
          if (n >= localObject.length) {
            break;
          }
          localObject = localObject[n];
          int i5 = i2;
          i4 = i3;
          if (localObject != null)
          {
            i4 = i3 + 1;
            i5 = i2 + CodedOutputByteBufferNano.computeStringSizeNoTag((String)localObject);
          }
          n += 1;
          i2 = i5;
        }
        n = i1 + i2 + i3 * 1;
      }
    }
    localObject = this.f;
    i1 = n;
    if (localObject != null)
    {
      i1 = n;
      if (localObject.length > 0)
      {
        i1 = 0;
        for (;;)
        {
          localObject = this.f;
          if (i1 >= localObject.length) {
            break;
          }
          localObject = localObject[i1];
          i2 = n;
          if (localObject != null) {
            i2 = n + CodedOutputByteBufferNano.computeMessageSize(4, (MessageNano)localObject);
          }
          i1 += 1;
          n = i2;
        }
        i1 = n;
      }
    }
    localObject = this.g;
    n = i1;
    if (localObject != null)
    {
      n = i1;
      if (localObject.length > 0)
      {
        n = i1;
        i1 = 0;
        for (;;)
        {
          localObject = this.g;
          if (i1 >= localObject.length) {
            break;
          }
          localObject = localObject[i1];
          i2 = n;
          if (localObject != null) {
            i2 = n + CodedOutputByteBufferNano.computeMessageSize(5, (MessageNano)localObject);
          }
          i1 += 1;
          n = i2;
        }
      }
    }
    localObject = this.h;
    i1 = n;
    if (localObject != null)
    {
      i1 = n;
      if (localObject.length > 0)
      {
        i1 = 0;
        for (;;)
        {
          localObject = this.h;
          if (i1 >= localObject.length) {
            break;
          }
          localObject = localObject[i1];
          i2 = n;
          if (localObject != null) {
            i2 = n + CodedOutputByteBufferNano.computeMessageSize(6, (MessageNano)localObject);
          }
          i1 += 1;
          n = i2;
        }
        i1 = n;
      }
    }
    localObject = this.i;
    n = i1;
    if (localObject != null)
    {
      n = i1;
      if (localObject.length > 0)
      {
        n = i1;
        i1 = 0;
        for (;;)
        {
          localObject = this.i;
          if (i1 >= localObject.length) {
            break;
          }
          localObject = localObject[i1];
          i2 = n;
          if (localObject != null) {
            i2 = n + CodedOutputByteBufferNano.computeMessageSize(7, (MessageNano)localObject);
          }
          i1 += 1;
          n = i2;
        }
      }
    }
    localObject = this.j;
    i1 = n;
    if (localObject != null) {
      i1 = n + CodedOutputByteBufferNano.computeMessageSize(8, (MessageNano)localObject);
    }
    localObject = this.k;
    n = i1;
    if (localObject != null) {
      n = i1 + CodedOutputByteBufferNano.computeMessageSize(9, (MessageNano)localObject);
    }
    localObject = this.d;
    i1 = n;
    if (localObject != null)
    {
      i1 = n;
      if (localObject.length > 0)
      {
        i1 = 0;
        i2 = 0;
        for (;;)
        {
          localObject = this.d;
          if (i1 >= localObject.length) {
            break;
          }
          i2 += CodedOutputByteBufferNano.computeInt32SizeNoTag(localObject[i1]);
          i1 += 1;
        }
        i1 = n + i2 + localObject.length * 1;
      }
    }
    localObject = this.e;
    n = i1;
    if (localObject != null)
    {
      n = i1;
      if (localObject.length > 0)
      {
        i2 = 0;
        n = i6;
        for (;;)
        {
          localObject = this.e;
          if (n >= localObject.length) {
            break;
          }
          i2 += CodedOutputByteBufferNano.computeInt32SizeNoTag(localObject[n]);
          n += 1;
        }
        n = i1 + i2 + localObject.length * 1;
      }
    }
    i1 = n;
    if (!this.l.equals("")) {
      i1 = n + CodedOutputByteBufferNano.computeStringSize(12, this.l);
    }
    return i1;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!this.a.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.a);
    }
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.b);
    }
    Object localObject = this.c;
    int i1 = 0;
    int n;
    if ((localObject != null) && (localObject.length > 0))
    {
      n = 0;
      for (;;)
      {
        localObject = this.c;
        if (n >= localObject.length) {
          break;
        }
        localObject = localObject[n];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeString(3, (String)localObject);
        }
        n += 1;
      }
    }
    localObject = this.f;
    if ((localObject != null) && (localObject.length > 0))
    {
      n = 0;
      for (;;)
      {
        localObject = this.f;
        if (n >= localObject.length) {
          break;
        }
        localObject = localObject[n];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(4, (MessageNano)localObject);
        }
        n += 1;
      }
    }
    localObject = this.g;
    if ((localObject != null) && (localObject.length > 0))
    {
      n = 0;
      for (;;)
      {
        localObject = this.g;
        if (n >= localObject.length) {
          break;
        }
        localObject = localObject[n];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(5, (MessageNano)localObject);
        }
        n += 1;
      }
    }
    localObject = this.h;
    if ((localObject != null) && (localObject.length > 0))
    {
      n = 0;
      for (;;)
      {
        localObject = this.h;
        if (n >= localObject.length) {
          break;
        }
        localObject = localObject[n];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(6, (MessageNano)localObject);
        }
        n += 1;
      }
    }
    localObject = this.i;
    if ((localObject != null) && (localObject.length > 0))
    {
      n = 0;
      for (;;)
      {
        localObject = this.i;
        if (n >= localObject.length) {
          break;
        }
        localObject = localObject[n];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(7, (MessageNano)localObject);
        }
        n += 1;
      }
    }
    localObject = this.j;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(8, (MessageNano)localObject);
    }
    localObject = this.k;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(9, (MessageNano)localObject);
    }
    localObject = this.d;
    if ((localObject != null) && (localObject.length > 0))
    {
      n = 0;
      for (;;)
      {
        localObject = this.d;
        if (n >= localObject.length) {
          break;
        }
        paramCodedOutputByteBufferNano.writeInt32(10, localObject[n]);
        n += 1;
      }
    }
    localObject = this.e;
    if ((localObject != null) && (localObject.length > 0))
    {
      n = i1;
      for (;;)
      {
        localObject = this.e;
        if (n >= localObject.length) {
          break;
        }
        paramCodedOutputByteBufferNano.writeInt32(11, localObject[n]);
        n += 1;
      }
    }
    if (!this.l.equals("")) {
      paramCodedOutputByteBufferNano.writeString(12, this.l);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.protobuf.nano.FileDescriptorProto
 * JD-Core Version:    0.7.0.1
 */