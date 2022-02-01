package com.tencent.gift.qlive_proxy_svr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

public final class ProxyReq
  extends ExtendableMessageNano<ProxyReq>
{
  public long a;
  public long b;
  public String c;
  public int d;
  public String e;
  public byte[] f;
  public int g;
  public int h;
  public String i;
  public String j;
  public int k;
  public int l;
  public String m;
  public int n;
  public AuthInfo[] o;
  public byte[] p;
  public int q;
  public String r;
  public TransInfo[] s;
  public String t;
  public String u;
  public String v;
  public String w;
  public int x;
  public int y;
  public long z;
  
  public ProxyReq()
  {
    a();
  }
  
  public ProxyReq a()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = "";
    this.d = 0;
    this.e = "";
    this.f = WireFormatNano.EMPTY_BYTES;
    this.g = 0;
    this.h = 0;
    this.i = "";
    this.j = "";
    this.k = 0;
    this.l = 0;
    this.m = "";
    this.n = 0;
    this.o = AuthInfo.a();
    this.p = WireFormatNano.EMPTY_BYTES;
    this.q = 0;
    this.r = "";
    this.s = TransInfo.a();
    this.t = "";
    this.u = "";
    this.v = "";
    this.w = "";
    this.x = 0;
    this.y = 0;
    this.z = 0L;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public ProxyReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i1 = paramCodedInputByteBufferNano.readTag();
      int i2;
      Object localObject;
      switch (i1)
      {
      default: 
        if (!storeUnknownField(paramCodedInputByteBufferNano, i1)) {
          return this;
        }
        break;
      case 208: 
        this.z = paramCodedInputByteBufferNano.readInt64();
        break;
      case 200: 
        this.y = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 192: 
        this.x = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 186: 
        this.w = paramCodedInputByteBufferNano.readString();
        break;
      case 178: 
        this.v = paramCodedInputByteBufferNano.readString();
        break;
      case 170: 
        this.u = paramCodedInputByteBufferNano.readString();
        break;
      case 162: 
        this.t = paramCodedInputByteBufferNano.readString();
        break;
      case 154: 
        i2 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 154);
        localObject = this.s;
        if (localObject == null) {
          i1 = 0;
        } else {
          i1 = localObject.length;
        }
        localObject = new TransInfo[i2 + i1];
        i2 = i1;
        if (i1 != 0)
        {
          System.arraycopy(this.s, 0, localObject, 0, i1);
          i2 = i1;
        }
        while (i2 < localObject.length - 1)
        {
          localObject[i2] = new TransInfo();
          paramCodedInputByteBufferNano.readMessage(localObject[i2]);
          paramCodedInputByteBufferNano.readTag();
          i2 += 1;
        }
        localObject[i2] = new TransInfo();
        paramCodedInputByteBufferNano.readMessage(localObject[i2]);
        this.s = ((TransInfo[])localObject);
        break;
      case 146: 
        this.r = paramCodedInputByteBufferNano.readString();
        break;
      case 136: 
        this.q = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 130: 
        this.p = paramCodedInputByteBufferNano.readBytes();
        break;
      case 122: 
        i2 = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 122);
        localObject = this.o;
        if (localObject == null) {
          i1 = 0;
        } else {
          i1 = localObject.length;
        }
        localObject = new AuthInfo[i2 + i1];
        i2 = i1;
        if (i1 != 0)
        {
          System.arraycopy(this.o, 0, localObject, 0, i1);
          i2 = i1;
        }
        while (i2 < localObject.length - 1)
        {
          localObject[i2] = new AuthInfo();
          paramCodedInputByteBufferNano.readMessage(localObject[i2]);
          paramCodedInputByteBufferNano.readTag();
          i2 += 1;
        }
        localObject[i2] = new AuthInfo();
        paramCodedInputByteBufferNano.readMessage(localObject[i2]);
        this.o = ((AuthInfo[])localObject);
        break;
      case 112: 
        this.n = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 106: 
        this.m = paramCodedInputByteBufferNano.readString();
        break;
      case 96: 
        this.l = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 88: 
        this.k = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 82: 
        this.j = paramCodedInputByteBufferNano.readString();
        break;
      case 74: 
        this.i = paramCodedInputByteBufferNano.readString();
        break;
      case 64: 
        this.h = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 56: 
        this.g = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 50: 
        this.f = paramCodedInputByteBufferNano.readBytes();
        break;
      case 42: 
        this.e = paramCodedInputByteBufferNano.readString();
        break;
      case 32: 
        this.d = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 26: 
        this.c = paramCodedInputByteBufferNano.readString();
        break;
      case 16: 
        this.b = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 8: 
        this.a = paramCodedInputByteBufferNano.readUInt64();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i2 = super.computeSerializedSize();
    long l1 = this.a;
    int i1 = i2;
    if (l1 != 0L) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt64Size(1, l1);
    }
    l1 = this.b;
    i2 = i1;
    if (l1 != 0L) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt64Size(2, l1);
    }
    i1 = i2;
    if (!this.c.equals("")) {
      i1 = i2 + CodedOutputByteBufferNano.computeStringSize(3, this.c);
    }
    int i3 = this.d;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(4, i3);
    }
    i1 = i2;
    if (!this.e.equals("")) {
      i1 = i2 + CodedOutputByteBufferNano.computeStringSize(5, this.e);
    }
    i2 = i1;
    if (!Arrays.equals(this.f, WireFormatNano.EMPTY_BYTES)) {
      i2 = i1 + CodedOutputByteBufferNano.computeBytesSize(6, this.f);
    }
    i3 = this.g;
    i1 = i2;
    if (i3 != 0) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt32Size(7, i3);
    }
    i3 = this.h;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(8, i3);
    }
    i1 = i2;
    if (!this.i.equals("")) {
      i1 = i2 + CodedOutputByteBufferNano.computeStringSize(9, this.i);
    }
    i2 = i1;
    if (!this.j.equals("")) {
      i2 = i1 + CodedOutputByteBufferNano.computeStringSize(10, this.j);
    }
    i3 = this.k;
    i1 = i2;
    if (i3 != 0) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt32Size(11, i3);
    }
    i3 = this.l;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(12, i3);
    }
    i3 = i2;
    if (!this.m.equals("")) {
      i3 = i2 + CodedOutputByteBufferNano.computeStringSize(13, this.m);
    }
    i2 = this.n;
    i1 = i3;
    if (i2 != 0) {
      i1 = i3 + CodedOutputByteBufferNano.computeUInt32Size(14, i2);
    }
    Object localObject = this.o;
    int i4 = 0;
    i2 = i1;
    if (localObject != null)
    {
      i2 = i1;
      if (localObject.length > 0)
      {
        i2 = 0;
        for (;;)
        {
          localObject = this.o;
          if (i2 >= localObject.length) {
            break;
          }
          localObject = localObject[i2];
          i3 = i1;
          if (localObject != null) {
            i3 = i1 + CodedOutputByteBufferNano.computeMessageSize(15, (MessageNano)localObject);
          }
          i2 += 1;
          i1 = i3;
        }
        i2 = i1;
      }
    }
    i1 = i2;
    if (!Arrays.equals(this.p, WireFormatNano.EMPTY_BYTES)) {
      i1 = i2 + CodedOutputByteBufferNano.computeBytesSize(16, this.p);
    }
    i3 = this.q;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(17, i3);
    }
    i1 = i2;
    if (!this.r.equals("")) {
      i1 = i2 + CodedOutputByteBufferNano.computeStringSize(18, this.r);
    }
    localObject = this.s;
    i2 = i1;
    if (localObject != null)
    {
      i2 = i1;
      if (localObject.length > 0)
      {
        i3 = i4;
        for (;;)
        {
          localObject = this.s;
          i2 = i1;
          if (i3 >= localObject.length) {
            break;
          }
          localObject = localObject[i3];
          i2 = i1;
          if (localObject != null) {
            i2 = i1 + CodedOutputByteBufferNano.computeMessageSize(19, (MessageNano)localObject);
          }
          i3 += 1;
          i1 = i2;
        }
      }
    }
    i1 = i2;
    if (!this.t.equals("")) {
      i1 = i2 + CodedOutputByteBufferNano.computeStringSize(20, this.t);
    }
    i2 = i1;
    if (!this.u.equals("")) {
      i2 = i1 + CodedOutputByteBufferNano.computeStringSize(21, this.u);
    }
    i1 = i2;
    if (!this.v.equals("")) {
      i1 = i2 + CodedOutputByteBufferNano.computeStringSize(22, this.v);
    }
    i2 = i1;
    if (!this.w.equals("")) {
      i2 = i1 + CodedOutputByteBufferNano.computeStringSize(23, this.w);
    }
    i3 = this.x;
    i1 = i2;
    if (i3 != 0) {
      i1 = i2 + CodedOutputByteBufferNano.computeUInt32Size(24, i3);
    }
    i3 = this.y;
    i2 = i1;
    if (i3 != 0) {
      i2 = i1 + CodedOutputByteBufferNano.computeUInt32Size(25, i3);
    }
    l1 = this.z;
    i1 = i2;
    if (l1 != 0L) {
      i1 = i2 + CodedOutputByteBufferNano.computeInt64Size(26, l1);
    }
    return i1;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l1 = this.a;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l1);
    }
    l1 = this.b;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(2, l1);
    }
    if (!this.c.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.c);
    }
    int i1 = this.d;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, i1);
    }
    if (!this.e.equals("")) {
      paramCodedOutputByteBufferNano.writeString(5, this.e);
    }
    if (!Arrays.equals(this.f, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(6, this.f);
    }
    i1 = this.g;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(7, i1);
    }
    i1 = this.h;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(8, i1);
    }
    if (!this.i.equals("")) {
      paramCodedOutputByteBufferNano.writeString(9, this.i);
    }
    if (!this.j.equals("")) {
      paramCodedOutputByteBufferNano.writeString(10, this.j);
    }
    i1 = this.k;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(11, i1);
    }
    i1 = this.l;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(12, i1);
    }
    if (!this.m.equals("")) {
      paramCodedOutputByteBufferNano.writeString(13, this.m);
    }
    i1 = this.n;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(14, i1);
    }
    Object localObject = this.o;
    int i2 = 0;
    if ((localObject != null) && (localObject.length > 0))
    {
      i1 = 0;
      for (;;)
      {
        localObject = this.o;
        if (i1 >= localObject.length) {
          break;
        }
        localObject = localObject[i1];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(15, (MessageNano)localObject);
        }
        i1 += 1;
      }
    }
    if (!Arrays.equals(this.p, WireFormatNano.EMPTY_BYTES)) {
      paramCodedOutputByteBufferNano.writeBytes(16, this.p);
    }
    i1 = this.q;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(17, i1);
    }
    if (!this.r.equals("")) {
      paramCodedOutputByteBufferNano.writeString(18, this.r);
    }
    localObject = this.s;
    if ((localObject != null) && (localObject.length > 0))
    {
      i1 = i2;
      for (;;)
      {
        localObject = this.s;
        if (i1 >= localObject.length) {
          break;
        }
        localObject = localObject[i1];
        if (localObject != null) {
          paramCodedOutputByteBufferNano.writeMessage(19, (MessageNano)localObject);
        }
        i1 += 1;
      }
    }
    if (!this.t.equals("")) {
      paramCodedOutputByteBufferNano.writeString(20, this.t);
    }
    if (!this.u.equals("")) {
      paramCodedOutputByteBufferNano.writeString(21, this.u);
    }
    if (!this.v.equals("")) {
      paramCodedOutputByteBufferNano.writeString(22, this.v);
    }
    if (!this.w.equals("")) {
      paramCodedOutputByteBufferNano.writeString(23, this.w);
    }
    i1 = this.x;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(24, i1);
    }
    i1 = this.y;
    if (i1 != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(25, i1);
    }
    l1 = this.z;
    if (l1 != 0L) {
      paramCodedOutputByteBufferNano.writeInt64(26, l1);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gift.qlive_proxy_svr.nano.ProxyReq
 * JD-Core Version:    0.7.0.1
 */