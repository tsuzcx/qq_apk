package com.tencent.gift.common.gift_data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;

public final class GiftData
  extends ExtendableMessageNano<GiftData>
{
  private static volatile GiftData[] k;
  public int a;
  public String b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public CornerIcon i;
  public FreeInfo j;
  
  public GiftData()
  {
    b();
  }
  
  public static GiftData[] a()
  {
    if (k == null) {
      synchronized (InternalNano.LAZY_INIT_LOCK)
      {
        if (k == null) {
          k = new GiftData[0];
        }
      }
    }
    return k;
  }
  
  public GiftData a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
      case 82: 
        if (this.j == null) {
          this.j = new FreeInfo();
        }
        paramCodedInputByteBufferNano.readMessage(this.j);
        break;
      case 74: 
        if (this.i == null) {
          this.i = new CornerIcon();
        }
        paramCodedInputByteBufferNano.readMessage(this.i);
        break;
      case 64: 
        this.h = paramCodedInputByteBufferNano.readInt32();
        break;
      case 56: 
        this.g = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 48: 
        this.f = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 40: 
        this.e = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 32: 
        this.d = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 24: 
        this.c = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 18: 
        this.b = paramCodedInputByteBufferNano.readString();
        break;
      case 8: 
        this.a = paramCodedInputByteBufferNano.readUInt32();
      }
    }
    return this;
  }
  
  public GiftData b()
  {
    this.a = 0;
    this.b = "";
    this.c = 0;
    this.d = 0;
    this.e = 0;
    this.f = 0;
    this.g = 0;
    this.h = 0;
    this.i = null;
    this.j = null;
    this.unknownFieldData = null;
    this.cachedSize = -1;
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
    n = m;
    if (!this.b.equals("")) {
      n = m + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    i1 = this.c;
    m = n;
    if (i1 != 0) {
      m = n + CodedOutputByteBufferNano.computeUInt32Size(3, i1);
    }
    i1 = this.d;
    n = m;
    if (i1 != 0) {
      n = m + CodedOutputByteBufferNano.computeUInt32Size(4, i1);
    }
    i1 = this.e;
    m = n;
    if (i1 != 0) {
      m = n + CodedOutputByteBufferNano.computeUInt32Size(5, i1);
    }
    i1 = this.f;
    n = m;
    if (i1 != 0) {
      n = m + CodedOutputByteBufferNano.computeUInt32Size(6, i1);
    }
    i1 = this.g;
    m = n;
    if (i1 != 0) {
      m = n + CodedOutputByteBufferNano.computeUInt32Size(7, i1);
    }
    i1 = this.h;
    n = m;
    if (i1 != 0) {
      n = m + CodedOutputByteBufferNano.computeInt32Size(8, i1);
    }
    Object localObject = this.i;
    m = n;
    if (localObject != null) {
      m = n + CodedOutputByteBufferNano.computeMessageSize(9, (MessageNano)localObject);
    }
    localObject = this.j;
    n = m;
    if (localObject != null) {
      n = m + CodedOutputByteBufferNano.computeMessageSize(10, (MessageNano)localObject);
    }
    return n;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int m = this.a;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, m);
    }
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.b);
    }
    m = this.c;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(3, m);
    }
    m = this.d;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, m);
    }
    m = this.e;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(5, m);
    }
    m = this.f;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(6, m);
    }
    m = this.g;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, m);
    }
    m = this.h;
    if (m != 0) {
      paramCodedOutputByteBufferNano.writeInt32(8, m);
    }
    Object localObject = this.i;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(9, (MessageNano)localObject);
    }
    localObject = this.j;
    if (localObject != null) {
      paramCodedOutputByteBufferNano.writeMessage(10, (MessageNano)localObject);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gift.common.gift_data.nano.GiftData
 * JD-Core Version:    0.7.0.1
 */