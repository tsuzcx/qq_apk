package com.tencent.gift.gift_info_svr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class GetGiftListReq
  extends ExtendableMessageNano<GetGiftListReq>
{
  public long a;
  public int b;
  public int c;
  public GiftListInfo d;
  
  public GetGiftListReq()
  {
    a();
  }
  
  public GetGiftListReq a()
  {
    this.a = 0L;
    this.b = 0;
    this.c = 0;
    this.d = null;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GetGiftListReq a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
            if (i != 34)
            {
              if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                return this;
              }
            }
            else
            {
              if (this.d == null) {
                this.d = new GiftListInfo();
              }
              paramCodedInputByteBufferNano.readMessage(this.d);
            }
          }
          else {
            this.c = paramCodedInputByteBufferNano.readUInt32();
          }
        }
        else {
          this.b = paramCodedInputByteBufferNano.readUInt32();
        }
      }
      else {
        this.a = paramCodedInputByteBufferNano.readUInt64();
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int i = super.computeSerializedSize();
    long l = this.a;
    int j = i;
    if (l != 0L) {
      j = i + CodedOutputByteBufferNano.computeUInt64Size(1, l);
    }
    int k = this.b;
    i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(2, k);
    }
    k = this.c;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(3, k);
    }
    GiftListInfo localGiftListInfo = this.d;
    i = j;
    if (localGiftListInfo != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(4, localGiftListInfo);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    long l = this.a;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(1, l);
    }
    int i = this.b;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(2, i);
    }
    i = this.c;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(3, i);
    }
    GiftListInfo localGiftListInfo = this.d;
    if (localGiftListInfo != null) {
      paramCodedOutputByteBufferNano.writeMessage(4, localGiftListInfo);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gift.gift_info_svr.nano.GetGiftListReq
 * JD-Core Version:    0.7.0.1
 */