package com.tencent.gift.gift_trans_svr.gift_trans_svr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.tencent.gift.common.gift_data.nano.ExtData;

public final class SendGiftOverReq
  extends ExtendableMessageNano<SendGiftOverReq>
{
  public int a;
  public long b;
  public long c;
  public int d;
  public int e;
  public long f;
  public int g;
  public int h;
  public ExtData[] i;
  
  public SendGiftOverReq()
  {
    a();
  }
  
  public SendGiftOverReq a()
  {
    this.a = 0;
    this.b = 0L;
    this.c = 0L;
    this.d = 0;
    this.e = 0;
    this.f = 0L;
    this.g = 0;
    this.h = 0;
    this.i = ExtData.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public SendGiftOverReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int j = paramCodedInputByteBufferNano.readTag();
      if (j == 0) {
        break;
      }
      if (j != 8)
      {
        if (j != 16)
        {
          if (j != 24)
          {
            if (j != 32)
            {
              if (j != 40)
              {
                if (j != 48)
                {
                  if (j != 56)
                  {
                    if (j != 64)
                    {
                      if (j != 74)
                      {
                        if (!storeUnknownField(paramCodedInputByteBufferNano, j)) {
                          return this;
                        }
                      }
                      else
                      {
                        int k = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 74);
                        ExtData[] arrayOfExtData = this.i;
                        if (arrayOfExtData == null) {
                          j = 0;
                        } else {
                          j = arrayOfExtData.length;
                        }
                        arrayOfExtData = new ExtData[k + j];
                        k = j;
                        if (j != 0)
                        {
                          System.arraycopy(this.i, 0, arrayOfExtData, 0, j);
                          k = j;
                        }
                        while (k < arrayOfExtData.length - 1)
                        {
                          arrayOfExtData[k] = new ExtData();
                          paramCodedInputByteBufferNano.readMessage(arrayOfExtData[k]);
                          paramCodedInputByteBufferNano.readTag();
                          k += 1;
                        }
                        arrayOfExtData[k] = new ExtData();
                        paramCodedInputByteBufferNano.readMessage(arrayOfExtData[k]);
                        this.i = arrayOfExtData;
                      }
                    }
                    else {
                      this.h = paramCodedInputByteBufferNano.readUInt32();
                    }
                  }
                  else {
                    this.g = paramCodedInputByteBufferNano.readUInt32();
                  }
                }
                else {
                  this.f = paramCodedInputByteBufferNano.readUInt64();
                }
              }
              else {
                this.e = paramCodedInputByteBufferNano.readUInt32();
              }
            }
            else {
              this.d = paramCodedInputByteBufferNano.readUInt32();
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readUInt64();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readUInt64();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int k = super.computeSerializedSize();
    int m = this.a;
    int j = k;
    if (m != 0) {
      j = k + CodedOutputByteBufferNano.computeUInt32Size(1, m);
    }
    long l = this.b;
    m = j;
    if (l != 0L) {
      m = j + CodedOutputByteBufferNano.computeUInt64Size(2, l);
    }
    l = this.c;
    k = m;
    if (l != 0L) {
      k = m + CodedOutputByteBufferNano.computeUInt64Size(3, l);
    }
    m = this.d;
    j = k;
    if (m != 0) {
      j = k + CodedOutputByteBufferNano.computeUInt32Size(4, m);
    }
    m = this.e;
    k = j;
    if (m != 0) {
      k = j + CodedOutputByteBufferNano.computeUInt32Size(5, m);
    }
    l = this.f;
    j = k;
    if (l != 0L) {
      j = k + CodedOutputByteBufferNano.computeUInt64Size(6, l);
    }
    m = this.g;
    k = j;
    if (m != 0) {
      k = j + CodedOutputByteBufferNano.computeUInt32Size(7, m);
    }
    m = this.h;
    j = k;
    if (m != 0) {
      j = k + CodedOutputByteBufferNano.computeUInt32Size(8, m);
    }
    Object localObject = this.i;
    m = j;
    if (localObject != null)
    {
      m = j;
      if (localObject.length > 0)
      {
        k = 0;
        for (;;)
        {
          localObject = this.i;
          m = j;
          if (k >= localObject.length) {
            break;
          }
          localObject = localObject[k];
          m = j;
          if (localObject != null) {
            m = j + CodedOutputByteBufferNano.computeMessageSize(9, (MessageNano)localObject);
          }
          k += 1;
          j = m;
        }
      }
    }
    return m;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int j = this.a;
    if (j != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, j);
    }
    long l = this.b;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, l);
    }
    l = this.c;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(3, l);
    }
    j = this.d;
    if (j != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, j);
    }
    j = this.e;
    if (j != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, j);
    }
    l = this.f;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(6, l);
    }
    j = this.g;
    if (j != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, j);
    }
    j = this.h;
    if (j != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, j);
    }
    Object localObject = this.i;
    if ((localObject != null) && (localObject.length > 0))
    {
      j = 0;
      for (;;)
      {
        localObject = this.i;
        if (j >= localObject.length) {
          break;
        }
        localObject = localObject[j];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(9, (MessageNano)localObject);
        }
        j += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gift.gift_trans_svr.gift_trans_svr.nano.SendGiftOverReq
 * JD-Core Version:    0.7.0.1
 */