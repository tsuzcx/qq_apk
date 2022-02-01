package com.google.protobuf.nano;

public final class SourceCodeInfo
  extends ExtendableMessageNano<SourceCodeInfo>
{
  public SourceCodeInfo.Location[] a;
  
  public SourceCodeInfo()
  {
    a();
  }
  
  public SourceCodeInfo a()
  {
    this.a = SourceCodeInfo.Location.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public SourceCodeInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
        SourceCodeInfo.Location[] arrayOfLocation = this.a;
        if (arrayOfLocation == null) {
          i = 0;
        } else {
          i = arrayOfLocation.length;
        }
        arrayOfLocation = new SourceCodeInfo.Location[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.a, 0, arrayOfLocation, 0, i);
          j = i;
        }
        while (j < arrayOfLocation.length - 1)
        {
          arrayOfLocation[j] = new SourceCodeInfo.Location();
          paramCodedInputByteBufferNano.readMessage(arrayOfLocation[j]);
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
        arrayOfLocation[j] = new SourceCodeInfo.Location();
        paramCodedInputByteBufferNano.readMessage(arrayOfLocation[j]);
        this.a = arrayOfLocation;
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
 * Qualified Name:     com.google.protobuf.nano.SourceCodeInfo
 * JD-Core Version:    0.7.0.1
 */