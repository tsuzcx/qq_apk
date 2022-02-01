package com.tencent.gift.gift_info_svr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.tencent.gift.common.gift_data.nano.GiftData;

public final class GetGiftListRsp
  extends ExtendableMessageNano<GetGiftListRsp>
{
  public int a;
  public GiftData[] b;
  public long c;
  public int d;
  
  public GetGiftListRsp()
  {
    a();
  }
  
  public static GetGiftListRsp a(byte[] paramArrayOfByte)
  {
    return (GetGiftListRsp)MessageNano.mergeFrom(new GetGiftListRsp(), paramArrayOfByte);
  }
  
  public GetGiftListRsp a()
  {
    this.a = 0;
    this.b = GiftData.a();
    this.c = 0L;
    this.d = 0;
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public GetGiftListRsp a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
  {
    for (;;)
    {
      int i = paramCodedInputByteBufferNano.readTag();
      if (i == 0) {
        break;
      }
      if (i != 8)
      {
        if (i != 18)
        {
          if (i != 24)
          {
            if (i != 32)
            {
              if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                return this;
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
        else
        {
          int j = WireFormatNano.getRepeatedFieldArrayLength(paramCodedInputByteBufferNano, 18);
          GiftData[] arrayOfGiftData = this.b;
          if (arrayOfGiftData == null) {
            i = 0;
          } else {
            i = arrayOfGiftData.length;
          }
          arrayOfGiftData = new GiftData[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.b, 0, arrayOfGiftData, 0, i);
            j = i;
          }
          while (j < arrayOfGiftData.length - 1)
          {
            arrayOfGiftData[j] = new GiftData();
            paramCodedInputByteBufferNano.readMessage(arrayOfGiftData[j]);
            paramCodedInputByteBufferNano.readTag();
            j += 1;
          }
          arrayOfGiftData[j] = new GiftData();
          paramCodedInputByteBufferNano.readMessage(arrayOfGiftData[j]);
          this.b = arrayOfGiftData;
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
    int j = super.computeSerializedSize();
    int k = this.a;
    int i = j;
    if (k != 0) {
      i = j + CodedOutputByteBufferNano.computeUInt32Size(1, k);
    }
    Object localObject = this.b;
    j = i;
    if (localObject != null)
    {
      j = i;
      if (localObject.length > 0)
      {
        k = 0;
        for (;;)
        {
          localObject = this.b;
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
    long l = this.c;
    i = j;
    if (l != 0L) {
      i = j + CodedOutputByteBufferNano.computeUInt64Size(3, l);
    }
    k = this.d;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeUInt32Size(4, k);
    }
    return j;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.a;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(1, i);
    }
    Object localObject = this.b;
    if ((localObject != null) && (localObject.length > 0))
    {
      i = 0;
      for (;;)
      {
        localObject = this.b;
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
    long l = this.c;
    if (l != 0L) {
      paramCodedOutputByteBufferNano.writeUInt64(3, l);
    }
    i = this.d;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeUInt32(4, i);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gift.gift_info_svr.nano.GetGiftListRsp
 * JD-Core Version:    0.7.0.1
 */