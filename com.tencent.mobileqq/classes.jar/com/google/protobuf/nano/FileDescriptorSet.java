package com.google.protobuf.nano;

public final class FileDescriptorSet
  extends ExtendableMessageNano<FileDescriptorSet>
{
  public FileDescriptorProto[] a;
  
  public FileDescriptorSet()
  {
    a();
  }
  
  public FileDescriptorSet a()
  {
    this.a = FileDescriptorProto.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public FileDescriptorSet a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 10)
      {
        if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
          return this;
        }
      }
      else
      {
        int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 10);
        FileDescriptorProto[] arrayOfFileDescriptorProto = this.a;
        if (arrayOfFileDescriptorProto == null) {
          i = 0;
        } else {
          i = arrayOfFileDescriptorProto.length;
        }
        arrayOfFileDescriptorProto = new FileDescriptorProto[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.a, 0, arrayOfFileDescriptorProto, 0, i);
          j = i;
        }
        while (j < arrayOfFileDescriptorProto.length - 1)
        {
          arrayOfFileDescriptorProto[j] = new FileDescriptorProto();
          paramCodedInputByteBufferNano.readMessage(arrayOfFileDescriptorProto[j]);
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
        arrayOfFileDescriptorProto[j] = new FileDescriptorProto();
        paramCodedInputByteBufferNano.readMessage(arrayOfFileDescriptorProto[j]);
        this.a = arrayOfFileDescriptorProto;
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    Object localObject = this.a;
    int k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        int j = 0;
        for (;;)
        {
          localObject = this.a;
          k = i;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(1, (MessageNano)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.a;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i = 0;
      for (;;)
      {
        localObject = this.a;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(1, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.protobuf.nano.FileDescriptorSet
 * JD-Core Version:    0.7.0.1
 */