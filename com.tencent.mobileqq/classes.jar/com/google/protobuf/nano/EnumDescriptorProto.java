package com.google.protobuf.nano;

public final class EnumDescriptorProto
  extends ExtendableMessageNano<EnumDescriptorProto>
{
  private static volatile EnumDescriptorProto[] f;
  public String a;
  public EnumValueDescriptorProto[] b;
  public EnumOptions c;
  public EnumDescriptorProto.EnumReservedRange[] d;
  public String[] e;
  
  public EnumDescriptorProto()
  {
    b();
  }
  
  public static EnumDescriptorProto[] a()
  {
    if (f == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (f == null) {
          f = new EnumDescriptorProto[0];
        }
      }
    }
    return f;
  }
  
  public EnumDescriptorProto a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 10)
      {
        int j;
        Object localObject;
        if (i != 18)
        {
          if (i != 26)
          {
            if (i != 34)
            {
              if (i != 42)
              {
                if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                  return this;
                }
              }
              else
              {
                j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 42);
                localObject = this.e;
                if (localObject == null) {
                  i = 0;
                } else {
                  i = localObject.length;
                }
                localObject = new String[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(this.e, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length - 1)
                {
                  localObject[j] = paramCodedInputByteBufferNano.readString();
                  paramCodedInputByteBufferNano.readTag();
                  j += 1;
                }
                localObject[j] = paramCodedInputByteBufferNano.readString();
                this.e = ((String[])localObject);
              }
            }
            else
            {
              j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 34);
              localObject = this.d;
              if (localObject == null) {
                i = 0;
              } else {
                i = localObject.length;
              }
              localObject = new EnumDescriptorProto.EnumReservedRange[j + i];
              j = i;
              if (i != 0)
              {
                System.arraycopy(this.d, 0, localObject, 0, i);
                j = i;
              }
              while (j < localObject.length - 1)
              {
                localObject[j] = new EnumDescriptorProto.EnumReservedRange();
                paramCodedInputByteBufferNano.readMessage(localObject[j]);
                paramCodedInputByteBufferNano.readTag();
                j += 1;
              }
              localObject[j] = new EnumDescriptorProto.EnumReservedRange();
              paramCodedInputByteBufferNano.readMessage(localObject[j]);
              this.d = ((EnumDescriptorProto.EnumReservedRange[])localObject);
            }
          }
          else
          {
            if (this.c == null) {
              this.c = new EnumOptions();
            }
            paramCodedInputByteBufferNano.readMessage(this.c);
          }
        }
        else
        {
          j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 18);
          localObject = this.b;
          if (localObject == null) {
            i = 0;
          } else {
            i = localObject.length;
          }
          localObject = new EnumValueDescriptorProto[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.b, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new EnumValueDescriptorProto();
            paramCodedInputByteBufferNano.readMessage(localObject[j]);
            paramCodedInputByteBufferNano.readTag();
            j += 1;
          }
          localObject[j] = new EnumValueDescriptorProto();
          paramCodedInputByteBufferNano.readMessage(localObject[j]);
          this.b = ((EnumValueDescriptorProto[])localObject);
        }
      }
      else
      {
        this.a = paramCodedInputByteBufferNano.readString();
      }
    }
    return this;
  }
  
  public EnumDescriptorProto b()
  {
    this.a = "";
    this.b = EnumValueDescriptorProto.a();
    this.c = null;
    this.d = EnumDescriptorProto.EnumReservedRange.a();
    this.e = WireFormatNano.EMPTY_STRING_ARRAY;
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
    int n = 0;
    j = i;
    int k;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.b;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(2, (MessageNano)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    localObject = this.c;
    i = j;
    if (localObject != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(3, (MessageNano)localObject);
    }
    localObject = this.d;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.d;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(4, (MessageNano)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    localObject = this.e;
    i = j;
    if (localObject != null)
    {
      i = j;
      if (localObject.length > 0)
      {
        k = 0;
        int m = 0;
        i = n;
        for (;;)
        {
          localObject = this.e;
          if (i >= localObject.length) {
            break;
          }
          localObject = localObject[i];
          int i1 = k;
          n = m;
          if (localObject != null)
          {
            n = m + 1;
            i1 = k + CodedOutputByteBufferNano.computeStringSizeNoTag((String)localObject);
          }
          i += 1;
          k = i1;
          m = n;
        }
        i = j + k + m * 1;
      }
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (!this.a.equals("")) {
      paramCodedOutputByteBufferNano.writeString(1, this.a);
    }
    Object localObject = this.b;
    int j = 0;
    int i;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
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
    localObject = this.d;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.d;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(4, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    localObject = this.e;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = j;
      for (;;)
      {
        localObject = this.e;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeString(5, (String)localObject);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.protobuf.nano.EnumDescriptorProto
 * JD-Core Version:    0.7.0.1
 */