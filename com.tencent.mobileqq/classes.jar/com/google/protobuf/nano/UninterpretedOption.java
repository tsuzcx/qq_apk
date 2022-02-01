package com.google.protobuf.nano;

import java.util.Arrays;

public final class UninterpretedOption
  extends ExtendableMessageNano<UninterpretedOption>
{
  private static volatile UninterpretedOption[] h;
  public UninterpretedOption.NamePart[] a;
  public String b;
  public long c;
  public long d;
  public double e;
  public byte[] f;
  public String g;
  
  public UninterpretedOption()
  {
    b();
  }
  
  public static UninterpretedOption[] a()
  {
    if (h == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (h == null) {
          h = new UninterpretedOption[0];
        }
      }
    }
    return h;
  }
  
  public UninterpretedOption a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 18)
      {
        if (i != 26)
        {
          if (i != 32)
          {
            if (i != 40)
            {
              if (i != 49)
              {
                if (i != 58)
                {
                  if (i != 66)
                  {
                    if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                      return this;
                    }
                  }
                  else {
                    this.g = paramCodedInputByteBufferNano.readString();
                  }
                }
                else {
                  this.f = paramCodedInputByteBufferNano.readBytes();
                }
              }
              else {
                this.e = paramCodedInputByteBufferNano.readDouble();
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readInt64();
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readUInt64();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readString();
        }
      }
      else
      {
        int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 18);
        UninterpretedOption.NamePart[] arrayOfNamePart = this.a;
        if (arrayOfNamePart == null) {
          i = 0;
        } else {
          i = arrayOfNamePart.length;
        }
        arrayOfNamePart = new UninterpretedOption.NamePart[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.a, 0, arrayOfNamePart, 0, i);
          j = i;
        }
        while (j < arrayOfNamePart.length - 1)
        {
          arrayOfNamePart[j] = new UninterpretedOption.NamePart();
          paramCodedInputByteBufferNano.readMessage(arrayOfNamePart[j]);
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
        arrayOfNamePart[j] = new UninterpretedOption.NamePart();
        paramCodedInputByteBufferNano.readMessage(arrayOfNamePart[j]);
        this.a = arrayOfNamePart;
      }
    }
    return this;
  }
  
  public UninterpretedOption b()
  {
    this.a = UninterpretedOption.NamePart.a();
    this.b = "";
    this.c = 0L;
    this.d = 0L;
    this.e = 0.0D;
    this.f = WireFormatNano.EMPTY_BYTES;
    this.g = "";
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    Object localObject = this.a;
    int j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        int k = 0;
        for (;;)
        {
          localObject = this.a;
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
    i = j;
    if (!this.b.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(3, this.b);
    }
    long l = this.c;
    j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(4, l);
    }
    l = this.d;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeInt64Size(5, l);
    }
    j = i;
    if (Double.doubleToLongBits(this.e) != Double.doubleToLongBits(0.0D)) {
      j = i + CodedOutputByteBufferNano.computeDoubleSize(6, this.e);
    }
    i = j;
    if (!Arrays.equals(this.f, WireFormatNano.EMPTY_BYTES)) {
      i = j + CodedOutputByteBufferNano.computeBytesSize(7, this.f);
    }
    j = i;
    if (!this.g.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(8, this.g);
    }
    return j;
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
          paramCodedOutputByteBufferNano.writeMessage(2, (MessageNano)localObject);
        }
        i += 1;
      }
    }
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.b);
    }
    long l = this.c;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(4, l);
    }
    l = this.d;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(5, l);
    }
    if (Double.doubleToLongBits(this.e) != Double.doubleToLongBits(0.0D)) {
      paramCodedOutputByteBufferNano.writeDouble(6, this.e);
    }
    if (!Arrays.equals(this.f, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(7, this.f);
    }
    if (!this.g.equals("")) {
      paramCodedOutputByteBufferNano.writeString(8, this.g);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.protobuf.nano.UninterpretedOption
 * JD-Core Version:    0.7.0.1
 */