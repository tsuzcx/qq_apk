package com.google.protobuf.nano;

import java.io.IOException;
import java.util.Arrays;

public abstract class MessageNano
{
  protected volatile int cachedSize = -1;
  
  public static final <T extends MessageNano> T mergeFrom(T paramT, byte[] paramArrayOfByte)
  {
    return mergeFrom(paramT, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static final <T extends MessageNano> T mergeFrom(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte = CodedInputByteBufferNano.newInstance(paramArrayOfByte, paramInt1, paramInt2);
      paramT.mergeFrom(paramArrayOfByte);
      paramArrayOfByte.checkLastTagWas(0);
      return paramT;
    }
    catch (InvalidProtocolBufferNanoException paramT)
    {
      throw paramT;
    }
    catch (IOException paramT)
    {
      label20:
      break label20;
    }
    throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
  }
  
  public static final boolean messageNanoEquals(MessageNano paramMessageNano1, MessageNano paramMessageNano2)
  {
    if (paramMessageNano1 == paramMessageNano2) {
      return true;
    }
    if (paramMessageNano1 != null)
    {
      if (paramMessageNano2 == null) {
        return false;
      }
      if (paramMessageNano1.getClass() != paramMessageNano2.getClass()) {
        return false;
      }
      int i = paramMessageNano1.getSerializedSize();
      if (paramMessageNano2.getSerializedSize() != i) {
        return false;
      }
      byte[] arrayOfByte1 = new byte[i];
      byte[] arrayOfByte2 = new byte[i];
      toByteArray(paramMessageNano1, arrayOfByte1, 0, i);
      toByteArray(paramMessageNano2, arrayOfByte2, 0, i);
      return Arrays.equals(arrayOfByte1, arrayOfByte2);
    }
    return false;
  }
  
  public static final void toByteArray(MessageNano paramMessageNano, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte = CodedOutputByteBufferNano.newInstance(paramArrayOfByte, paramInt1, paramInt2);
      paramMessageNano.writeTo(paramArrayOfByte);
      paramArrayOfByte.checkNoSpaceLeft();
      return;
    }
    catch (IOException paramMessageNano)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", paramMessageNano);
    }
  }
  
  public static final byte[] toByteArray(MessageNano paramMessageNano)
  {
    byte[] arrayOfByte = new byte[paramMessageNano.getSerializedSize()];
    toByteArray(paramMessageNano, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public MessageNano clone()
  {
    return (MessageNano)super.clone();
  }
  
  protected int computeSerializedSize()
  {
    return 0;
  }
  
  public int getCachedSize()
  {
    if (this.cachedSize < 0) {
      getSerializedSize();
    }
    return this.cachedSize;
  }
  
  public int getSerializedSize()
  {
    int i = computeSerializedSize();
    this.cachedSize = i;
    return i;
  }
  
  public abstract MessageNano mergeFrom(CodedInputByteBufferNano paramCodedInputByteBufferNano);
  
  public String toString()
  {
    return MessageNanoPrinter.print(this);
  }
  
  public void writeTo(CodedOutputByteBufferNano paramCodedOutputByteBufferNano) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.protobuf.nano.MessageNano
 * JD-Core Version:    0.7.0.1
 */