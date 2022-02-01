package com.google.protobuf.nano;

public final class GeneratedCodeInfo$Annotation
  extends ExtendableMessageNano<Annotation>
{
  private static volatile Annotation[] e;
  public int[] a;
  public String b;
  public int c;
  public int d;
  
  public GeneratedCodeInfo$Annotation()
  {
    b();
  }
  
  public static Annotation[] a()
  {
    if (e == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (e == null) {
          e = new Annotation[0];
        }
      }
    }
    return e;
  }
  
  public Annotation a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      int j;
      int[] arrayOfInt;
      if (i != 8)
      {
        if (i != 10)
        {
          if (i != 18)
          {
            if (i != 24)
            {
              if (i != 32)
              {
                if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                  return this;
                }
              }
              else {
                this.d = paramCodedInputByteBufferNano.readInt32();
              }
            }
            else {
              this.c = paramCodedInputByteBufferNano.readInt32();
            }
          }
          else {
            this.b = paramCodedInputByteBufferNano.readString();
          }
        }
        else
        {
          int k = paramCodedInputByteBufferNano.pushLimit(paramCodedInputByteBufferNano.readRawVarint32());
          i = paramCodedInputByteBufferNano.getPosition();
          j = 0;
          while (paramCodedInputByteBufferNano.getBytesUntilLimit() > 0)
          {
            paramCodedInputByteBufferNano.readInt32();
            j += 1;
          }
          paramCodedInputByteBufferNano.rewindToPosition(i);
          arrayOfInt = this.a;
          if (arrayOfInt == null) {
            i = 0;
          } else {
            i = arrayOfInt.length;
          }
          arrayOfInt = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.a, 0, arrayOfInt, 0, i);
            j = i;
          }
          while (j < arrayOfInt.length)
          {
            arrayOfInt[j] = paramCodedInputByteBufferNano.readInt32();
            j += 1;
          }
          this.a = arrayOfInt;
          paramCodedInputByteBufferNano.popLimit(k);
        }
      }
      else
      {
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 8);
        arrayOfInt = this.a;
        if (arrayOfInt == null) {
          i = 0;
        } else {
          i = arrayOfInt.length;
        }
        arrayOfInt = new int[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.a, 0, arrayOfInt, 0, i);
          j = i;
        }
        while (j < arrayOfInt.length - 1)
        {
          arrayOfInt[j] = paramCodedInputByteBufferNano.readInt32();
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
        arrayOfInt[j] = paramCodedInputByteBufferNano.readInt32();
        this.a = arrayOfInt;
      }
    }
    return this;
  }
  
  public Annotation b()
  {
    this.a = WireFormatNano.EMPTY_INT_ARRAY;
    this.b = "";
    this.c = 0;
    this.d = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int k = super.computeSerializedSize();
    int[] arrayOfInt = this.a;
    int i = k;
    if (arrayOfInt != null)
    {
      i = k;
      if (arrayOfInt.length > 0)
      {
        i = 0;
        j = 0;
        for (;;)
        {
          arrayOfInt = this.a;
          if (i >= arrayOfInt.length) {
            break;
          }
          j += CodedOutputByteBufferNano.computeInt32SizeNoTag(arrayOfInt[i]);
          i += 1;
        }
        i = k + j + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(j);
      }
    }
    int j = i;
    if (!this.b.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    k = this.c;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeInt32Size(3, k);
    }
    k = this.d;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(4, k);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int[] arrayOfInt = this.a;
    if ((arrayOfInt != null) && (arrayOfInt.length > 0))
    {
      int k = 0;
      i = 0;
      int j = 0;
      for (;;)
      {
        arrayOfInt = this.a;
        if (i >= arrayOfInt.length) {
          break;
        }
        j += CodedOutputByteBufferNano.computeInt32SizeNoTag(arrayOfInt[i]);
        i += 1;
      }
      paramCodedOutputByteBufferNano.writeRawVarint32(10);
      paramCodedOutputByteBufferNano.writeRawVarint32(j);
      i = k;
      for (;;)
      {
        arrayOfInt = this.a;
        if (i >= arrayOfInt.length) {
          break;
        }
        paramCodedOutputByteBufferNano.writeInt32NoTag(arrayOfInt[i]);
        i += 1;
      }
    }
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.b);
    }
    int i = this.c;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(3, i);
    }
    i = this.d;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(4, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.protobuf.nano.GeneratedCodeInfo.Annotation
 * JD-Core Version:    0.7.0.1
 */