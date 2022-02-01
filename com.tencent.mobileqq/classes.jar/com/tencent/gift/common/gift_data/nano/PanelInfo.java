package com.tencent.gift.common.gift_data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;

public final class PanelInfo
  extends ExtendableMessageNano<PanelInfo>
{
  public int a;
  public int b;
  public String c;
  public String d;
  public String e;
  
  public PanelInfo()
  {
    a();
  }
  
  public PanelInfo a()
  {
    this.a = 0;
    this.b = 0;
    this.c = "";
    this.d = "";
    this.e = "";
    this.unknownFieldData = null;
    this.cachedSize = -1;
    return this;
  }
  
  public PanelInfo a(CodedInputByteBufferNano paramCodedInputByteBufferNano)
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
          if (i != 26)
          {
            if (i != 34)
            {
              if (i != 42)
              {
                if (!storeUnknownField(paramCodedInputByteBufferNano, i)) {
                  return this;
                }
              }
              else {
                this.e = paramCodedInputByteBufferNano.readString();
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
          i = paramCodedInputByteBufferNano.readInt32();
          if ((i == 0) || (i == 1) || (i == 2)) {
            this.b = i;
          }
        }
      }
      else
      {
        i = paramCodedInputByteBufferNano.readInt32();
        if ((i == 0) || (i == 1) || (i == 2)) {
          this.a = i;
        }
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
      i = j + CodedOutputByteBufferNano.computeInt32Size(1, k);
    }
    k = this.b;
    j = i;
    if (k != 0) {
      j = i + CodedOutputByteBufferNano.computeInt32Size(2, k);
    }
    i = j;
    if (!this.c.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(3, this.c);
    }
    j = i;
    if (!this.d.equals("")) {
      j = i + CodedOutputByteBufferNano.computeStringSize(4, this.d);
    }
    i = j;
    if (!this.e.equals("")) {
      i = j + CodedOutputByteBufferNano.computeStringSize(5, this.e);
    }
    return i;
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano)
  {
    int i = this.a;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(1, i);
    }
    i = this.b;
    if (i != 0) {
      paramCodedOutputByteBufferNano.writeInt32(2, i);
    }
    if (!this.c.equals("")) {
      paramCodedOutputByteBufferNano.writeString(3, this.c);
    }
    if (!this.d.equals("")) {
      paramCodedOutputByteBufferNano.writeString(4, this.d);
    }
    if (!this.e.equals("")) {
      paramCodedOutputByteBufferNano.writeString(5, this.e);
    }
    super.writeTo(paramCodedOutputByteBufferNano);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gift.common.gift_data.nano.PanelInfo
 * JD-Core Version:    0.7.0.1
 */