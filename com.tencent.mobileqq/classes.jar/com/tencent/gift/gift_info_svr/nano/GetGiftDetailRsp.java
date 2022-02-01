package com.tencent.gift.gift_info_svr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.tencent.gift.common.gift_data.nano.GiftData;

public final class GetGiftDetailRsp
  extends ExtendableMessageNano<GetGiftDetailRsp>
{
  public GiftData a;
  
  public GetGiftDetailRsp()
  {
    a();
  }
  
  public static GetGiftDetailRsp a(byte[] paramArrayOfByte)
  {
    return (GetGiftDetailRsp)MessageNano.mergeFrom(new GetGiftDetailRsp(), paramArrayOfByte);
  }
  
  public GetGiftDetailRsp a()
  {
    this.a = null;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GetGiftDetailRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 10)
      {
        if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
          return this;
        }
      }
      else
      {
        if (this.a == null) {
          this.a = new GiftData();
        }
        paramCodedInputByteBufferNano.readMessage(this.a);
      }
    }
    return this;
  }
  
  protected int computeSerializedSize()
  {
    int j = super.computeSerializedSize();
    GiftData localGiftData = this.a;
    int i = j;
    if (localGiftData != null) {
      i = j + CodedOutputByteBufferNano.computeMessageSize(1, localGiftData);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    GiftData localGiftData = this.a;
    if (localGiftData != null) {
      paramCodedOutputByteBufferNano.writeMessage(1, localGiftData);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gift.gift_info_svr.nano.GetGiftDetailRsp
 * JD-Core Version:    0.7.0.1
 */