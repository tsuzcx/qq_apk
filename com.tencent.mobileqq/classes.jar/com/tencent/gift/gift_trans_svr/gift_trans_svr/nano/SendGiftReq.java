package com.tencent.gift.gift_trans_svr.gift_trans_svr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.tencent.gift.common.gift_data.nano.ExtData;

public final class SendGiftReq
  extends ExtendableMessageNano<SendGiftReq>
{
  public int a;
  public long b;
  public long c;
  public int d;
  public int e;
  public String f;
  public String g;
  public long h;
  public int i;
  public int j;
  public ExtData[] k;
  
  public SendGiftReq()
  {
    a();
  }
  
  public SendGiftReq a()
  {
    this.a = 0;
    this.b = 0L;
    this.c = 0L;
    this.d = 0;
    this.e = 0;
    this.f = "";
    this.g = "";
    this.h = 0L;
    this.i = 0;
    this.j = 0;
    this.k = ExtData.a();
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public SendGiftReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int m = paramCodedInputByteBufferNano.readTag();
      switch (m)
      {
      default: 
        if (!storeUnknownField(paramCodedInputByteBufferNano, m)) {
          return this;
        }
        break;
      case 90: 
        int n = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 90);
        ExtData[] arrayOfExtData = this.k;
        if (arrayOfExtData == null) {
          m = 0;
        } else {
          m = arrayOfExtData.length;
        }
        arrayOfExtData = new ExtData[n + m];
        n = m;
        if (m != 0)
        {
          System.arraycopy(this.k, 0, arrayOfExtData, 0, m);
          n = m;
        }
        while (n < arrayOfExtData.length - 1)
        {
          arrayOfExtData[n] = new ExtData();
          paramCodedInputByteBufferNano.readMessage(arrayOfExtData[n]);
          paramCodedInputByteBufferNano.readTag();
          n += 1;
        }
        arrayOfExtData[n] = new ExtData();
        paramCodedInputByteBufferNano.readMessage(arrayOfExtData[n]);
        this.k = arrayOfExtData;
        break;
      case 80: 
        this.j = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 72: 
        this.i = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 64: 
        this.h = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 58: 
        this.g = paramCodedInputByteBufferNano.readString();
        break;
      case 50: 
        this.f = paramCodedInputByteBufferNano.readString();
        break;
      case 40: 
        this.e = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 32: 
        this.d = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 24: 
        this.c = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 16: 
        this.b = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 8: 
        this.a = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int n = super.computeSerializedSize();
    int i1 = this.a;
    int m = n;
    if (i1 != 0) {
      m = n + CodedOutputByteBufferNano.computeUInt32Size(1, i1);
    }
    long l = this.b;
    i1 = m;
    if (l != 0L) {
      i1 = m + CodedOutputByteBufferNano.computeUInt64Size(2, l);
    }
    l = this.c;
    n = i1;
    if (l != 0L) {
      n = i1 + CodedOutputByteBufferNano.computeUInt64Size(3, l);
    }
    i1 = this.d;
    m = n;
    if (i1 != 0) {
      m = n + CodedOutputByteBufferNano.computeUInt32Size(4, i1);
    }
    i1 = this.e;
    n = m;
    if (i1 != 0) {
      n = m + CodedOutputByteBufferNano.computeUInt32Size(5, i1);
    }
    m = n;
    if (!this.f.equals("")) {
      m = n + CodedOutputByteBufferNano.computeStringSize(6, this.f);
    }
    n = m;
    if (!this.g.equals("")) {
      n = m + CodedOutputByteBufferNano.computeStringSize(7, this.g);
    }
    l = this.h;
    m = n;
    if (l != 0L) {
      m = n + CodedOutputByteBufferNano.computeUInt64Size(8, l);
    }
    i1 = this.i;
    n = m;
    if (i1 != 0) {
      n = m + CodedOutputByteBufferNano.computeUInt32Size(9, i1);
    }
    i1 = this.j;
    m = n;
    if (i1 != 0) {
      m = n + CodedOutputByteBufferNano.computeUInt32Size(10, i1);
    }
    Object localObject = this.k;
    i1 = m;
    if (localObject != null)
    {
      i1 = m;
      if (localObject.length > 0)
      {
        n = 0;
        for (;;)
        {
          localObject = this.k;
          i1 = m;
          if (n >= localObject.length) {
            break;
          }
          localObject = localObject[n];
          i1 = m;
          if (localObject != null) {
            i1 = m + CodedOutputByteBufferNano.computeMessageSize(11, (MessageNano)localObject);
          }
          n += 1;
          m = i1;
        }
      }
    }
    return i1;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int m = this.a;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, m);
    }
    long l = this.b;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, l);
    }
    l = this.c;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(3, l);
    }
    m = this.d;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, m);
    }
    m = this.e;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, m);
    }
    if (!this.f.equals("")) {
      paramCodedOutputByteBufferNano.writeString(6, this.f);
    }
    if (!this.g.equals("")) {
      paramCodedOutputByteBufferNano.writeString(7, this.g);
    }
    l = this.h;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(8, l);
    }
    m = this.i;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(9, m);
    }
    m = this.j;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(10, m);
    }
    Object localObject = this.k;
    if ((localObject != null) && (localObject.length > 0))
    {
      m = 0;
      for (;;)
      {
        localObject = this.k;
        if (m >= localObject.length) {
          break;
        }
        localObject = localObject[m];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(11, (MessageNano)localObject);
        }
        m += 1;
      }
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gift.gift_trans_svr.gift_trans_svr.nano.SendGiftReq
 * JD-Core Version:    0.7.0.1
 */