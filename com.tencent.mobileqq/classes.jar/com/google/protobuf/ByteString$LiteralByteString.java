package com.google.protobuf;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

class ByteString$LiteralByteString
  extends ByteString.LeafByteString
{
  private static final long serialVersionUID = 1L;
  protected final byte[] bytes;
  
  ByteString$LiteralByteString(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      this.bytes = paramArrayOfByte;
      return;
    }
    throw new NullPointerException();
  }
  
  public final ByteBuffer asReadOnlyByteBuffer()
  {
    return ByteBuffer.wrap(this.bytes, getOffsetIntoBytes(), size()).asReadOnlyBuffer();
  }
  
  public final List<ByteBuffer> asReadOnlyByteBufferList()
  {
    return Collections.singletonList(asReadOnlyByteBuffer());
  }
  
  public byte byteAt(int paramInt)
  {
    return this.bytes[paramInt];
  }
  
  public final void copyTo(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.put(this.bytes, getOffsetIntoBytes(), size());
  }
  
  protected void copyToInternal(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    System.arraycopy(this.bytes, paramInt1, paramArrayOfByte, paramInt2, paramInt3);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof ByteString)) {
      return false;
    }
    if (size() != ((ByteString)paramObject).size()) {
      return false;
    }
    if (size() == 0) {
      return true;
    }
    if ((paramObject instanceof LiteralByteString))
    {
      paramObject = (LiteralByteString)paramObject;
      int i = peekCachedHashCode();
      int j = paramObject.peekCachedHashCode();
      if ((i != 0) && (j != 0) && (i != j)) {
        return false;
      }
      return equalsRange(paramObject, 0, size());
    }
    return paramObject.equals(this);
  }
  
  final boolean equalsRange(ByteString paramByteString, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= paramByteString.size())
    {
      int i = paramInt1 + paramInt2;
      if (i <= paramByteString.size())
      {
        if ((paramByteString instanceof LiteralByteString))
        {
          paramByteString = (LiteralByteString)paramByteString;
          localObject = this.bytes;
          byte[] arrayOfByte = paramByteString.bytes;
          int j = getOffsetIntoBytes();
          i = getOffsetIntoBytes();
          paramInt1 = paramByteString.getOffsetIntoBytes() + paramInt1;
          while (i < j + paramInt2)
          {
            if (localObject[i] != arrayOfByte[paramInt1]) {
              return false;
            }
            i += 1;
            paramInt1 += 1;
          }
          return true;
        }
        return paramByteString.substring(paramInt1, i).equals(substring(0, paramInt2));
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Ran off end of other: ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramByteString.size());
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    paramByteString = new StringBuilder();
    paramByteString.append("Length too large: ");
    paramByteString.append(paramInt2);
    paramByteString.append(size());
    paramByteString = new IllegalArgumentException(paramByteString.toString());
    for (;;)
    {
      throw paramByteString;
    }
  }
  
  protected int getOffsetIntoBytes()
  {
    return 0;
  }
  
  byte internalByteAt(int paramInt)
  {
    return this.bytes[paramInt];
  }
  
  public final boolean isValidUtf8()
  {
    int i = getOffsetIntoBytes();
    return Utf8.a(this.bytes, i, size() + i);
  }
  
  public final CodedInputStream newCodedInput()
  {
    return CodedInputStream.a(this.bytes, getOffsetIntoBytes(), size(), true);
  }
  
  public final InputStream newInput()
  {
    return new ByteArrayInputStream(this.bytes, getOffsetIntoBytes(), size());
  }
  
  protected final int partialHash(int paramInt1, int paramInt2, int paramInt3)
  {
    return Internal.a(paramInt1, this.bytes, getOffsetIntoBytes() + paramInt2, paramInt3);
  }
  
  protected final int partialIsValidUtf8(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = getOffsetIntoBytes() + paramInt2;
    return Utf8.a(paramInt1, this.bytes, paramInt2, paramInt3 + paramInt2);
  }
  
  public int size()
  {
    return this.bytes.length;
  }
  
  public final ByteString substring(int paramInt1, int paramInt2)
  {
    paramInt2 = checkRange(paramInt1, paramInt2, size());
    if (paramInt2 == 0) {
      return ByteString.EMPTY;
    }
    return new ByteString.BoundedByteString(this.bytes, getOffsetIntoBytes() + paramInt1, paramInt2);
  }
  
  protected final String toStringInternal(Charset paramCharset)
  {
    return new String(this.bytes, getOffsetIntoBytes(), size(), paramCharset);
  }
  
  final void writeTo(ByteOutput paramByteOutput)
  {
    paramByteOutput.b(this.bytes, getOffsetIntoBytes(), size());
  }
  
  public final void writeTo(OutputStream paramOutputStream)
  {
    paramOutputStream.write(toByteArray());
  }
  
  final void writeToInternal(OutputStream paramOutputStream, int paramInt1, int paramInt2)
  {
    paramOutputStream.write(this.bytes, getOffsetIntoBytes() + paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.ByteString.LiteralByteString
 * JD-Core Version:    0.7.0.1
 */