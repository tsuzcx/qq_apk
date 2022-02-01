package com.google.protobuf.nano;

public final class ServiceDescriptorProto
  extends ExtendableMessageNano<ServiceDescriptorProto>
{
  private static volatile ServiceDescriptorProto[] d;
  public String a;
  public MethodDescriptorProto[] b;
  public ServiceOptions c;
  
  public ServiceDescriptorProto()
  {
    b();
  }
  
  public static ServiceDescriptorProto[] a()
  {
    if (d == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (d == null) {
          d = new ServiceDescriptorProto[0];
        }
      }
    }
    return d;
  }
  
  public ServiceDescriptorProto a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
            if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
              return this;
            }
          }
          else
          {
            if (this.c == null) {
              this.c = new ServiceOptions();
            }
            paramCodedInputByteBufferNano.readMessage(this.c);
          }
        }
        else
        {
          int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 18);
          MethodDescriptorProto[] arrayOfMethodDescriptorProto = this.b;
          if (arrayOfMethodDescriptorProto == null) {
            i = 0;
          } else {
            i = arrayOfMethodDescriptorProto.length;
          }
          arrayOfMethodDescriptorProto = new MethodDescriptorProto[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.b, 0, arrayOfMethodDescriptorProto, 0, i);
            j = i;
          }
          while (j < arrayOfMethodDescriptorProto.length - 1)
          {
            arrayOfMethodDescriptorProto[j] = new MethodDescriptorProto();
            paramCodedInputByteBufferNano.readMessage(arrayOfMethodDescriptorProto[j]);
            paramCodedInputByteBufferNano.readTag();
            j += 1;
          }
          arrayOfMethodDescriptorProto[j] = new MethodDescriptorProto();
          paramCodedInputByteBufferNano.readMessage(arrayOfMethodDescriptorProto[j]);
          this.b = arrayOfMethodDescriptorProto;
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readString();
      }
    }
    return this;
  }
  
  public ServiceDescriptorProto b()
  {
    this.a = "";
    this.b = MethodDescriptorProto.a();
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
    Object localObject = this.b;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        int k = 0;
        for (;;)
        {
          localObject = this.b;
          j = i;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          j = i;
          if (localObject != null) {
            j = i + CodedOutputByteBufferNano.computeMessageSize(2, (MessageNano)localObject);
          }
          k += 1;
          i = j;
        }
      }
    }
    localObject = this.c;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(3, (MessageNano)localObject);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!this.a.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.a);
    }
    Object localObject = this.b;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i = 0;
      for (;;)
      {
        localObject = this.b;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(2, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    localObject = this.c;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(3, (MessageNano)localObject);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.protobuf.nano.ServiceDescriptorProto
 * JD-Core Version:    0.7.0.1
 */