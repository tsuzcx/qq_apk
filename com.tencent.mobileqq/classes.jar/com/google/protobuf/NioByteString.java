package com.google.protobuf;

import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

final class NioByteString
  extends ByteString.LeafByteString
{
  private final ByteBuffer buffer;
  
  NioByteString(ByteBuffer paramByteBuffer)
  {
    Internal.a(paramByteBuffer, "buffer");
    this.buffer = paramByteBuffer.slice().order(ByteOrder.nativeOrder());
  }
  
  private ByteBuffer a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= this.buffer.position()) && (paramInt2 <= this.buffer.limit()) && (paramInt1 <= paramInt2))
    {
      ByteBuffer localByteBuffer = this.buffer.slice();
      localByteBuffer.position(paramInt1 - this.buffer.position());
      localByteBuffer.limit(paramInt2 - this.buffer.position());
      return localByteBuffer;
    }
    throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    throw new InvalidObjectException("NioByteString instances are not to be serialized directly");
  }
  
  private Object writeReplace()
  {
    return ByteString.copyFrom(this.buffer.slice());
  }
  
  public ByteBuffer asReadOnlyByteBuffer()
  {
    return this.buffer.asReadOnlyBuffer();
  }
  
  public List<ByteBuffer> asReadOnlyByteBufferList()
  {
    return Collections.singletonList(asReadOnlyByteBuffer());
  }
  
  public byte byteAt(int paramInt)
  {
    try
    {
      byte b = this.buffer.get(paramInt);
      return b;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      throw new ArrayIndexOutOfBoundsException(localIndexOutOfBoundsException.getMessage());
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      throw localArrayIndexOutOfBoundsException;
    }
  }
  
  public void copyTo(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.put(this.buffer.slice());
  }
  
  protected void copyToInternal(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    ByteBuffer localByteBuffer = this.buffer.slice();
    localByteBuffer.position(paramInt1);
    localByteBuffer.get(paramArrayOfByte, paramInt2, paramInt3);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof ByteString)) {
      return false;
    }
    ByteString localByteString = (ByteString)paramObject;
    if (size() != localByteString.size()) {
      return false;
    }
    if (size() == 0) {
      return true;
    }
    if ((paramObject instanceof NioByteString)) {
      return this.buffer.equals(((NioByteString)paramObject).buffer);
    }
    if ((paramObject instanceof RopeByteString)) {
      return paramObject.equals(this);
    }
    return this.buffer.equals(localByteString.asReadOnlyByteBuffer());
  }
  
  boolean equalsRange(ByteString paramByteString, int paramInt1, int paramInt2)
  {
    return substring(0, paramInt2).equals(paramByteString.substring(paramInt1, paramInt2 + paramInt1));
  }
  
  public byte internalByteAt(int paramInt)
  {
    return byteAt(paramInt);
  }
  
  public boolean isValidUtf8()
  {
    return Utf8.a(this.buffer);
  }
  
  public CodedInputStream newCodedInput()
  {
    return CodedInputStream.a(this.buffer, true);
  }
  
  public InputStream newInput()
  {
    return new NioByteString.1(this);
  }
  
  protected int partialHash(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    paramInt1 = paramInt2;
    while (paramInt1 < paramInt2 + paramInt3)
    {
      i = i * 31 + this.buffer.get(paramInt1);
      paramInt1 += 1;
    }
    return i;
  }
  
  protected int partialIsValidUtf8(int paramInt1, int paramInt2, int paramInt3)
  {
    return Utf8.a(paramInt1, this.buffer, paramInt2, paramInt3 + paramInt2);
  }
  
  public int size()
  {
    return this.buffer.remaining();
  }
  
  public ByteString substring(int paramInt1, int paramInt2)
  {
    try
    {
      NioByteString localNioByteString = new NioByteString(a(paramInt1, paramInt2));
      return localNioByteString;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      throw new ArrayIndexOutOfBoundsException(localIndexOutOfBoundsException.getMessage());
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      throw localArrayIndexOutOfBoundsException;
    }
  }
  
  protected String toStringInternal(Charset paramCharset)
  {
    byte[] arrayOfByte;
    int i;
    int j;
    if (this.buffer.hasArray())
    {
      arrayOfByte = this.buffer.array();
      i = this.buffer.arrayOffset() + this.buffer.position();
      j = this.buffer.remaining();
    }
    else
    {
      arrayOfByte = toByteArray();
      i = 0;
      j = arrayOfByte.length;
    }
    return new String(arrayOfByte, i, j, paramCharset);
  }
  
  void writeTo(ByteOutput paramByteOutput)
  {
    paramByteOutput.a(this.buffer.slice());
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    paramOutputStream.write(toByteArray());
  }
  
  void writeToInternal(OutputStream paramOutputStream, int paramInt1, int paramInt2)
  {
    if (this.buffer.hasArray())
    {
      int i = this.buffer.arrayOffset();
      int j = this.buffer.position();
      paramOutputStream.write(this.buffer.array(), i + j + paramInt1, paramInt2);
      return;
    }
    ByteBufferWriter.a(a(paramInt1, paramInt2 + paramInt1), paramOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.NioByteString
 * JD-Core Version:    0.7.0.1
 */