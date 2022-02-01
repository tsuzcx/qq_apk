package com.google.protobuf.nano;

public final class FieldOptions
  extends ExtendableMessageNano<FieldOptions>
{
  public int a;
  public boolean b;
  public int c;
  public boolean d;
  public boolean e;
  public boolean f;
  public UninterpretedOption[] g;
  
  public FieldOptions()
  {
    a();
  }
  
  public FieldOptions a()
  {
    this.a = 0;
    this.b = false;
    this.c = 0;
    this.d = false;
    this.e = false;
    this.f = false;
    this.g = UninterpretedOption.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public FieldOptions a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 8)
      {
        if (i != 16)
        {
          if (i != 24)
          {
            if (i != 40)
            {
              if (i != 48)
              {
                if (i != 80)
                {
                  if (i != 7994)
                  {
                    if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                      return this;
                    }
                  }
                  else
                  {
                    int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 7994);
                    UninterpretedOption[] arrayOfUninterpretedOption = this.g;
                    if (arrayOfUninterpretedOption == null) {
                      i = 0;
                    } else {
                      i = arrayOfUninterpretedOption.length;
                    }
                    arrayOfUninterpretedOption = new UninterpretedOption[j + i];
                    j = i;
                    if (i != 0)
                    {
                      System.arraycopy(this.g, 0, arrayOfUninterpretedOption, 0, i);
                      j = i;
                    }
                    while (j < arrayOfUninterpretedOption.length - 1)
                    {
                      arrayOfUninterpretedOption[j] = new UninterpretedOption();
                      paramCodedInputByteBufferNano.readMessage(arrayOfUninterpretedOption[j]);
                      paramCodedInputByteBufferNano.readTag();
                      j += 1;
                    }
                    arrayOfUninterpretedOption[j] = new UninterpretedOption();
                    paramCodedInputByteBufferNano.readMessage(arrayOfUninterpretedOption[j]);
                    this.g = arrayOfUninterpretedOption;
                  }
                }
                else {
                  this.f = paramCodedInputByteBufferNano.readBool();
                }
              }
              else
              {
                i = paramCodedInputByteBufferNano.readInt32();
                if ((i == 0) || (i == 1) || (i == 2)) {
                  this.c = i;
                }
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readBool();
            }
          }
          else {
            this.e = paramCodedInputByteBufferNano.readBool();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readBool();
        }
      }
      else
      {
        i = paramCodedInputByteBufferNano.readInt32();
        if ((i == 0) || (i == 1) || (i == 2)) {
          this.a = i;
        }
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    int k = this.a;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(1, k);
    }
    boolean bool = this.b;
    j = i;
    if (bool) {
      j = i + CodedOutputByteBufferNano.computeBoolSize(2, bool);
    }
    bool = this.e;
    k = j;
    if (bool) {
      k = j + CodedOutputByteBufferNano.computeBoolSize(3, bool);
    }
    bool = this.d;
    i = k;
    if (bool) {
      i = k + CodedOutputByteBufferNano.computeBoolSize(5, bool);
    }
    k = this.c;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(6, k);
    }
    bool = this.f;
    i = j;
    if (bool) {
      i = j + CodedOutputByteBufferNano.computeBoolSize(10, bool);
    }
    Object localObject = this.g;
    k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.g;
          k = i;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          k = i;
          if (localObject != null) {
            k = i + CodedOutputByteBufferNano.computeMessageSize(999, (MessageNano)localObject);
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
    int i = this.a;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1, i);
    }
    boolean bool = this.b;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(2, bool);
    }
    bool = this.e;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(3, bool);
    }
    bool = this.d;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(5, bool);
    }
    i = this.c;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(6, i);
    }
    bool = this.f;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(10, bool);
    }
    Object localObject = this.g;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.g;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(999, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.protobuf.nano.FieldOptions
 * JD-Core Version:    0.7.0.1
 */