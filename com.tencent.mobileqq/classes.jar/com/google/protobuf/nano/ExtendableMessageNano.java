package com.google.protobuf.nano;

public abstract class ExtendableMessageNano<M extends ExtendableMessageNano<M>>
  extends MessageNano
{
  protected FieldArray unknownFieldData;
  
  public M clone()
  {
    ExtendableMessageNano localExtendableMessageNano = (ExtendableMessageNano)super.clone();
    InternalNano.cloneUnknownFieldData(this, localExtendableMessageNano);
    return localExtendableMessageNano;
  }
  
  protected int computeSerializedSize()
  {
    int j = 0;
    if (this.unknownFieldData != null)
    {
      int i = 0;
      for (;;)
      {
        k = i;
        if (j >= this.unknownFieldData.size()) {
          break;
        }
        i += this.unknownFieldData.dataAt(j).computeSerializedSize();
        j += 1;
      }
    }
    int k = 0;
    return k;
  }
  
  public final <T> T getExtension(Extension<M, T> paramExtension)
  {
    if (this.unknownFieldData == null) {}
    FieldData localFieldData;
    do
    {
      return null;
      localFieldData = this.unknownFieldData.get(WireFormatNano.getTagFieldNumber(paramExtension.tag));
    } while (localFieldData == null);
    return localFieldData.getValue(paramExtension);
  }
  
  public final boolean hasExtension(Extension<M, ?> paramExtension)
  {
    if (this.unknownFieldData == null) {}
    while (this.unknownFieldData.get(WireFormatNano.getTagFieldNumber(paramExtension.tag)) == null) {
      return false;
    }
    return true;
  }
  
  public final <T> M setExtension(Extension<M, T> paramExtension, T paramT)
  {
    FieldData localFieldData = null;
    int i = WireFormatNano.getTagFieldNumber(paramExtension.tag);
    if (paramT == null)
    {
      if (this.unknownFieldData != null)
      {
        this.unknownFieldData.remove(i);
        if (this.unknownFieldData.isEmpty()) {
          this.unknownFieldData = null;
        }
      }
      return this;
    }
    if (this.unknownFieldData == null) {
      this.unknownFieldData = new FieldArray();
    }
    while (localFieldData == null)
    {
      this.unknownFieldData.put(i, new FieldData(paramExtension, paramT));
      return this;
      localFieldData = this.unknownFieldData.get(i);
    }
    localFieldData.setValue(paramExtension, paramT);
    return this;
  }
  
  protected final boolean storeUnknownField(CodedInputByteBufferNano paramCodedInputByteBufferNano, int paramInt)
  {
    int i = paramCodedInputByteBufferNano.getPosition();
    if (!paramCodedInputByteBufferNano.skipField(paramInt)) {
      return false;
    }
    int j = WireFormatNano.getTagFieldNumber(paramInt);
    UnknownFieldData localUnknownFieldData = new UnknownFieldData(paramInt, paramCodedInputByteBufferNano.getData(i, paramCodedInputByteBufferNano.getPosition() - i));
    paramCodedInputByteBufferNano = null;
    if (this.unknownFieldData == null) {
      this.unknownFieldData = new FieldArray();
    }
    for (;;)
    {
      Object localObject = paramCodedInputByteBufferNano;
      if (paramCodedInputByteBufferNano == null)
      {
        localObject = new FieldData();
        this.unknownFieldData.put(j, (FieldData)localObject);
      }
      ((FieldData)localObject).addUnknownField(localUnknownFieldData);
      return true;
      paramCodedInputByteBufferNano = this.unknownFieldData.get(j);
    }
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.unknownFieldData == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.unknownFieldData.size())
      {
        this.unknownFieldData.dataAt(i).writeTo(paramCodedOutputByteBufferNano);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.protobuf.nano.ExtendableMessageNano
 * JD-Core Version:    0.7.0.1
 */