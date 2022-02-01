package com.tencent.ilivesdk.loginservice.proto.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

public final class CgiResult
  extends MessageNano
{
  public long a;
  public String b;
  public long c;
  public String d;
  public String e;
  public int f;
  public String g;
  public ConfigKeyValue h;
  public int i;
  public int j;
  
  public CgiResult()
  {
    a();
  }
  
  public CgiResult a()
  {
    this.a = 0L;
    this.b = "";
    this.c = 0L;
    this.d = "";
    this.e = "";
    this.f = 0;
    this.g = "";
    this.h = null;
    this.i = 0;
    this.j = 0;
    this.cachedSize = -1;
    return this;
  }
  
  public CgiResult a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int k = paramCodedInputByteBufferNano.readTag();
      switch (k)
      {
      default: 
        if (!WireFormatNano.parseUnknownField(paramCodedInputByteBufferNano, k)) {
          return this;
        }
        break;
      case 80: 
        this.j = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 72: 
        this.i = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 66: 
        if (this.h == null) {
          this.h = new ConfigKeyValue();
        }
        paramCodedInputByteBufferNano.readMessage(this.h);
        break;
      case 58: 
        this.g = paramCodedInputByteBufferNano.readString();
        break;
      case 48: 
        this.f = paramCodedInputByteBufferNano.readUInt32();
        break;
      case 42: 
        this.e = paramCodedInputByteBufferNano.readString();
        break;
      case 34: 
        this.d = paramCodedInputByteBufferNano.readString();
        break;
      case 24: 
        this.c = paramCodedInputByteBufferNano.readUInt64();
        break;
      case 18: 
        this.b = paramCodedInputByteBufferNano.readString();
        break;
      case 8: 
        this.a = paramCodedInputByteBufferNano.readUInt64();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int m = super.computeSerializedSize();
    long l = this.a;
    int k = m;
    if (l != 0L) {
      k = m + CodedOutputByteBufferNano.computeUInt64Size(1, l);
    }
    m = k;
    if (!this.b.equals("")) {
      m = k + CodedOutputByteBufferNano.computeStringSize(2, this.b);
    }
    l = this.c;
    k = m;
    if (l != 0L) {
      k = m + CodedOutputByteBufferNano.computeUInt64Size(3, l);
    }
    m = k;
    if (!this.d.equals("")) {
      m = k + CodedOutputByteBufferNano.computeStringSize(4, this.d);
    }
    k = m;
    if (!this.e.equals("")) {
      k = m + CodedOutputByteBufferNano.computeStringSize(5, this.e);
    }
    int n = this.f;
    m = k;
    if (n != 0) {
      m = k + CodedOutputByteBufferNano.computeUInt32Size(6, n);
    }
    k = m;
    if (!this.g.equals("")) {
      k = m + CodedOutputByteBufferNano.computeStringSize(7, this.g);
    }
    ConfigKeyValue localConfigKeyValue = this.h;
    m = k;
    if (localConfigKeyValue != null) {
      m = k + CodedOutputByteBufferNano.computeMessageSize(8, localConfigKeyValue);
    }
    n = this.i;
    k = m;
    if (n != 0) {
      k = m + CodedOutputByteBufferNano.computeUInt32Size(9, n);
    }
    n = this.j;
    m = k;
    if (n != 0) {
      m = k + CodedOutputByteBufferNano.computeUInt32Size(10, n);
    }
    return m;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.a;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l);
    }
    if (!this.b.equals("")) {
      paramCodedOutputByteBufferNano.writeString(2, this.b);
    }
    l = this.c;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(3, l);
    }
    if (!this.d.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.d);
    }
    if (!this.e.equals("")) {
      paramCodedOutputByteBufferNano.writeString(5, this.e);
    }
    int k = this.f;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(6, k);
    }
    if (!this.g.equals("")) {
      paramCodedOutputByteBufferNano.writeString(7, this.g);
    }
    ConfigKeyValue localConfigKeyValue = this.h;
    if (localConfigKeyValue != null) {
      paramCodedOutputByteBufferNano.writeMessage(8, localConfigKeyValue);
    }
    k = this.i;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(9, k);
    }
    k = this.j;
    if (k != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(10, k);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.loginservice.proto.nano.CgiResult
 * JD-Core Version:    0.7.0.1
 */