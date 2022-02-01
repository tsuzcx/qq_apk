package com.google.protobuf.nano;

public final class SourceCodeInfo$Location
  extends ExtendableMessageNano<Location>
{
  private static volatile Location[] f;
  public int[] a;
  public int[] b;
  public String c;
  public String d;
  public String[] e;
  
  public SourceCodeInfo$Location()
  {
    b();
  }
  
  public static Location[] a()
  {
    if (f == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (f == null) {
          f = new Location[0];
        }
      }
    }
    return f;
  }
  
  public Location a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      int j;
      Object localObject;
      if (i != 8)
      {
        int k;
        if (i != 10)
        {
          if (i != 16)
          {
            if (i != 18)
            {
              if (i != 26)
              {
                if (i != 34)
                {
                  if (i != 50)
                  {
                    if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                      return this;
                    }
                  }
                  else
                  {
                    j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 50);
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
                else {
                  this.d = paramCodedInputByteBufferNano.readString();
                }
              }
              else {
                this.c = paramCodedInputByteBufferNano.readString();
              }
            }
            else
            {
              k = paramCodedInputByteBufferNano.pushLimit(paramCodedInputByteBufferNano.readRawVarint32());
              i = paramCodedInputByteBufferNano.getPosition();
              j = 0;
              while (paramCodedInputByteBufferNano.getBytesUntilLimit() > 0)
              {
                paramCodedInputByteBufferNano.readInt32();
                j += 1;
              }
              paramCodedInputByteBufferNano.rewindToPosition(i);
              localObject = this.b;
              if (localObject == null) {
                i = 0;
              } else {
                i = localObject.length;
              }
              localObject = new int[j + i];
              j = i;
              if (i != 0)
              {
                System.arraycopy(this.b, 0, localObject, 0, i);
                j = i;
              }
              while (j < localObject.length)
              {
                localObject[j] = paramCodedInputByteBufferNano.readInt32();
                j += 1;
              }
              this.b = ((int[])localObject);
              paramCodedInputByteBufferNano.popLimit(k);
            }
          }
          else
          {
            j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 16);
            localObject = this.b;
            if (localObject == null) {
              i = 0;
            } else {
              i = localObject.length;
            }
            localObject = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.b, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = paramCodedInputByteBufferNano.readInt32();
              paramCodedInputByteBufferNano.readTag();
              j += 1;
            }
            localObject[j] = paramCodedInputByteBufferNano.readInt32();
            this.b = ((int[])localObject);
          }
        }
        else
        {
          k = paramCodedInputByteBufferNano.pushLimit(paramCodedInputByteBufferNano.readRawVarint32());
          i = paramCodedInputByteBufferNano.getPosition();
          j = 0;
          while (paramCodedInputByteBufferNano.getBytesUntilLimit() > 0)
          {
            paramCodedInputByteBufferNano.readInt32();
            j += 1;
          }
          paramCodedInputByteBufferNano.rewindToPosition(i);
          localObject = this.a;
          if (localObject == null) {
            i = 0;
          } else {
            i = localObject.length;
          }
          localObject = new int[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.a, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length)
          {
            localObject[j] = paramCodedInputByteBufferNano.readInt32();
            j += 1;
          }
          this.a = ((int[])localObject);
          paramCodedInputByteBufferNano.popLimit(k);
        }
      }
      else
      {
        j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 8);
        localObject = this.a;
        if (localObject == null) {
          i = 0;
        } else {
          i = localObject.length;
        }
        localObject = new int[j + i];
        j = i;
        if (i != 0)
        {
          System.arraycopy(this.a, 0, localObject, 0, i);
          j = i;
        }
        while (j < localObject.length - 1)
        {
          localObject[j] = paramCodedInputByteBufferNano.readInt32();
          paramCodedInputByteBufferNano.readTag();
          j += 1;
        }
        localObject[j] = paramCodedInputByteBufferNano.readInt32();
        this.a = ((int[])localObject);
      }
    }
    return this;
  }
  
  public Location b()
  {
    this.a = WireFormatNano.EMPTY_INT_ARRAY;
    this.b = WireFormatNano.EMPTY_INT_ARRAY;
    this.c = "";
    this.d = "";
    this.e = WireFormatNano.EMPTY_STRING_ARRAY;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int k = super.computeSerializedSize();
    Object localObject = this.a;
    int n = 0;
    int i = k;
    if (localObject != null)
    {
      i = k;
      if (localObject.length > 0)
      {
        i = 0;
        j = 0;
        for (;;)
        {
          localObject = this.a;
          if (i >= localObject.length) {
            break;
          }
          j += CodedOutputByteBufferNano.computeInt32SizeNoTag(localObject[i]);
          i += 1;
        }
        i = k + j + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(j);
      }
    }
    localObject = this.b;
    int j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        j = 0;
        k = 0;
        for (;;)
        {
          localObject = this.b;
          if (j >= localObject.length) {
            break;
          }
          k += CodedOutputByteBufferNano.computeInt32SizeNoTag(localObject[j]);
          j += 1;
        }
        j = i + k + 1 + CodedOutputByteBufferNano.computeRawVarint32Size(k);
      }
    }
    k = j;
    if (!this.c.equals("")) {
      k = j + CodedOutputByteBufferNano.computeStringSize(3, this.c);
    }
    i = k;
    if (!this.d.equals("")) {
      i = k + CodedOutputByteBufferNano.computeStringSize(4, this.d);
    }
    localObject = this.e;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        k = 0;
        int m = 0;
        j = n;
        for (;;)
        {
          localObject = this.e;
          if (j >= localObject.length) {
            break;
          }
          localObject = localObject[j];
          int i1 = k;
          n = m;
          if (localObject != null)
          {
            n = m + 1;
            i1 = k + CodedOutputByteBufferNano.computeStringSizeNoTag((String)localObject);
          }
          j += 1;
          k = i1;
          m = n;
        }
        j = i + k + m * 1;
      }
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    Object localObject = this.a;
    int k = 0;
    int i;
    int j;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      j = 0;
      for (;;)
      {
        localObject = this.a;
        if (i >= localObject.length) {
          break;
        }
        j += CodedOutputByteBufferNano.computeInt32SizeNoTag(localObject[i]);
        i += 1;
      }
      paramCodedOutputByteBufferNano.writeRawVarint32(10);
      paramCodedOutputByteBufferNano.writeRawVarint32(j);
      i = 0;
      for (;;)
      {
        localObject = this.a;
        if (i >= localObject.length) {
          break;
        }
        paramCodedOutputByteBufferNano.writeInt32NoTag(localObject[i]);
        i += 1;
      }
    }
    localObject = this.b;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      j = 0;
      for (;;)
      {
        localObject = this.b;
        if (i >= localObject.length) {
          break;
        }
        j += CodedOutputByteBufferNano.computeInt32SizeNoTag(localObject[i]);
        i += 1;
      }
      paramCodedOutputByteBufferNano.writeRawVarint32(18);
      paramCodedOutputByteBufferNano.writeRawVarint32(j);
      i = 0;
      for (;;)
      {
        localObject = this.b;
        if (i >= localObject.length) {
          break;
        }
        paramCodedOutputByteBufferNano.writeInt32NoTag(localObject[i]);
        i += 1;
      }
    }
    if (!this.c.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.c);
    }
    if (!this.d.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.d);
    }
    localObject = this.e;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = k;
      for (;;)
      {
        localObject = this.e;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeString(6, (String)localObject);
        }
        i += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.protobuf.nano.SourceCodeInfo.Location
 * JD-Core Version:    0.7.0.1
 */