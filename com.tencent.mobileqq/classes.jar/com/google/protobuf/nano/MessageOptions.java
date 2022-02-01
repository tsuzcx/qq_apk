package com.google.protobuf.nano;

public final class MessageOptions
  extends ExtendableMessageNano<MessageOptions>
{
  public boolean a;
  public boolean b;
  public boolean c;
  public boolean d;
  public UninterpretedOption[] e;
  
  public MessageOptions()
  {
    a();
  }
  
  public MessageOptions a()
  {
    this.a = false;
    this.b = false;
    this.c = false;
    this.d = false;
    this.e = UninterpretedOption.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public MessageOptions a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
            if (i != 56)
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
                UninterpretedOption[] arrayOfUninterpretedOption = this.e;
                if (arrayOfUninterpretedOption == null) {
                  i = 0;
                } else {
                  i = arrayOfUninterpretedOption.length;
                }
                arrayOfUninterpretedOption = new UninterpretedOption[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(this.e, 0, arrayOfUninterpretedOption, 0, i);
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
                this.e = arrayOfUninterpretedOption;
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readBool();
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readBool();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readBool();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readBool();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    boolean bool = this.a;
    int i = j;
    if (bool) {
      i = j + CodedOutputByteBufferNano.computeBoolSize(1, bool);
    }
    bool = this.b;
    j = i;
    if (bool) {
      j = i + CodedOutputByteBufferNano.computeBoolSize(2, bool);
    }
    bool = this.c;
    int k = j;
    if (bool) {
      k = j + CodedOutputByteBufferNano.computeBoolSize(3, bool);
    }
    bool = this.d;
    i = k;
    if (bool) {
      i = k + CodedOutputByteBufferNano.computeBoolSize(7, bool);
    }
    Object localObject = this.e;
    k = i;
    if (localObject != null)
    {
      k = i;
      if (localObject.length > 0)
      {
        j = 0;
        for (;;)
        {
          localObject = this.e;
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
    boolean bool = this.a;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(1, bool);
    }
    bool = this.b;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(2, bool);
    }
    bool = this.c;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(3, bool);
    }
    bool = this.d;
    if (bool) {
      paramCodedOutputByteBufferNano.writeBool(7, bool);
    }
    Object localObject = this.e;
    if ((localObject != null) && (localObject.length > 0))
    {
      int i = 0;
      for (;;)
      {
        localObject = this.e;
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
 * Qualified Name:     com.google.protobuf.nano.MessageOptions
 * JD-Core Version:    0.7.0.1
 */