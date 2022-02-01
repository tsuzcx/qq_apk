package com.tencent.gift.gift_trans_svr.gift_trans_svr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;

public final class SendGiftRsp
  extends ExtendableMessageNano<SendGiftRsp>
{
  public SendGiftRsp()
  {
    a();
  }
  
  public static SendGiftRsp a(byte[] paramArrayOfByte)
  {
    return (SendGiftRsp)MessageNano.mergeFrom(new SendGiftRsp(), paramArrayOfByte);
  }
  
  public SendGiftRsp a()
  {
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public SendGiftRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    int i;
    do
    {
      i = paramCodedInputByteBufferNano.readTag();
    } while ((i != 0) && (storeUnknownField(paramCodedInputByteBufferNano, i)));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gift.gift_trans_svr.gift_trans_svr.nano.SendGiftRsp
 * JD-Core Version:    0.7.0.1
 */