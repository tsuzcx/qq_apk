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
    FieldArray localFieldArray = this.unknownFieldData;
    int j = 0;
    if (localFieldArray != null)
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
    Object localObject = this.unknownFieldData;
    if (localObject == null) {
      return null;
    }
    localObject = ((FieldArray)localObject).get(WireFormatNano.getTagFieldNumber(paramExtension.tag));
    if (localObject == null) {
      return null;
    }
    return ((FieldData)localObject).getValue(paramExtension);
  }
  
  public final boolean hasExtension(Extension<M, ?> paramExtension)
  {
    FieldArray localFieldArray = this.unknownFieldData;
    boolean bool = false;
    if (localFieldArray == null) {
      return false;
    }
    if (localFieldArray.get(WireFormatNano.getTagFieldNumber(paramExtension.tag)) != null) {
      bool = true;
    }
    return bool;
  }
  
  public final <T> M setExtension(Extension<M, T> paramExtension, T paramT)
  {
    int i = WireFormatNano.getTagFieldNumber(paramExtension.tag);
    FieldData localFieldData = null;
    if (paramT == null)
    {
      paramExtension = this.unknownFieldData;
      if (paramExtension != null)
      {
        paramExtension.remove(i);
        if (this.unknownFieldData.isEmpty())
        {
          this.unknownFieldData = null;
          return this;
        }
      }
    }
    else
    {
      FieldArray localFieldArray = this.unknownFieldData;
      if (localFieldArray == null) {
        this.unknownFieldData = new FieldArray();
      } else {
        localFieldData = localFieldArray.get(i);
      }
      if (localFieldData == null)
      {
        this.unknownFieldData.put(i, new FieldData(paramExtension, paramT));
        return this;
      }
      localFieldData.setValue(paramExtension, paramT);
    }
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
    Object localObject = this.unknownFieldData;
    if (localObject == null) {
      this.unknownFieldData = new FieldArray();
    } else {
      paramCodedInputByteBufferNano = ((FieldArray)localObject).get(j);
    }
    localObject = paramCodedInputByteBufferNano;
    if (paramCodedInputByteBufferNano == null)
    {
      localObject = new FieldData();
      this.unknownFieldData.put(j, (FieldData)localObject);
    }
    ((FieldData)localObject).addUnknownField(localUnknownFieldData);
    return true;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    if (this.unknownFieldData == null) {
      return;
    }
    int i = 0;
    while (i < this.unknownFieldData.size())
    {
      this.unknownFieldData.dataAt(i).writeTo(paramCodedOutputByteBufferNano);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.protobuf.nano.ExtendableMessageNano
 * JD-Core Version:    0.7.0.1
 */