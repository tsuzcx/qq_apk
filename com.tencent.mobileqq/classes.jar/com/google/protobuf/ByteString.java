package com.google.protobuf;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public abstract class ByteString
  implements Serializable, Iterable<Byte>
{
  static final int CONCATENATE_BY_COPY_SIZE = 128;
  public static final ByteString EMPTY = new ByteString.LiteralByteString(Internal.c);
  static final int MAX_READ_FROM_CHUNK_SIZE = 8192;
  static final int MIN_READ_FROM_CHUNK_SIZE = 256;
  private static final ByteString.ByteArrayCopier a;
  private static final Comparator<ByteString> b = new ByteString.2();
  private int hash = 0;
  
  static
  {
    Object localObject;
    if (Android.a()) {
      localObject = new ByteString.SystemByteArrayCopier(null);
    } else {
      localObject = new ByteString.ArraysByteArrayCopier(null);
    }
    a = (ByteString.ByteArrayCopier)localObject;
  }
  
  private static int a(byte paramByte)
  {
    return paramByte & 0xFF;
  }
  
  private static ByteString a(InputStream paramInputStream, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      int j = paramInputStream.read(arrayOfByte, i, paramInt - i);
      if (j == -1) {
        break;
      }
      i += j;
    }
    if (i == 0) {
      return null;
    }
    return copyFrom(arrayOfByte, 0, i);
  }
  
  private static ByteString a(Iterator<ByteString> paramIterator, int paramInt)
  {
    if (paramInt >= 1)
    {
      if (paramInt == 1) {
        return (ByteString)paramIterator.next();
      }
      int i = paramInt >>> 1;
      return a(paramIterator, i).concat(a(paramIterator, paramInt - i));
    }
    throw new IllegalArgumentException(String.format("length (%s) must be >= 1", new Object[] { Integer.valueOf(paramInt) }));
  }
  
  static void checkIndex(int paramInt1, int paramInt2)
  {
    if ((paramInt2 - (paramInt1 + 1) | paramInt1) < 0)
    {
      if (paramInt1 < 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Index < 0: ");
        localStringBuilder.append(paramInt1);
        throw new ArrayIndexOutOfBoundsException(localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Index > length: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramInt2);
      throw new ArrayIndexOutOfBoundsException(localStringBuilder.toString());
    }
  }
  
  static int checkRange(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2 - paramInt1;
    if ((paramInt1 | paramInt2 | i | paramInt3 - paramInt2) < 0)
    {
      if (paramInt1 >= 0)
      {
        if (paramInt2 < paramInt1)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Beginning index larger than ending index: ");
          localStringBuilder.append(paramInt1);
          localStringBuilder.append(", ");
          localStringBuilder.append(paramInt2);
          throw new IndexOutOfBoundsException(localStringBuilder.toString());
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("End index: ");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(" >= ");
        localStringBuilder.append(paramInt3);
        throw new IndexOutOfBoundsException(localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Beginning index: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" < 0");
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
    return i;
  }
  
  public static ByteString copyFrom(Iterable<ByteString> paramIterable)
  {
    if (!(paramIterable instanceof Collection))
    {
      int i = 0;
      Iterator localIterator = paramIterable.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localIterator.next();
        i += 1;
      }
    }
    int j = ((Collection)paramIterable).size();
    if (j == 0) {
      return EMPTY;
    }
    return a(paramIterable.iterator(), j);
  }
  
  public static ByteString copyFrom(String paramString1, String paramString2)
  {
    return new ByteString.LiteralByteString(paramString1.getBytes(paramString2));
  }
  
  public static ByteString copyFrom(String paramString, Charset paramCharset)
  {
    return new ByteString.LiteralByteString(paramString.getBytes(paramCharset));
  }
  
  public static ByteString copyFrom(ByteBuffer paramByteBuffer)
  {
    return copyFrom(paramByteBuffer, paramByteBuffer.remaining());
  }
  
  public static ByteString copyFrom(ByteBuffer paramByteBuffer, int paramInt)
  {
    checkRange(0, paramInt, paramByteBuffer.remaining());
    byte[] arrayOfByte = new byte[paramInt];
    paramByteBuffer.get(arrayOfByte);
    return new ByteString.LiteralByteString(arrayOfByte);
  }
  
  public static ByteString copyFrom(byte[] paramArrayOfByte)
  {
    return copyFrom(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static ByteString copyFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    checkRange(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
    return new ByteString.LiteralByteString(a.a(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  public static ByteString copyFromUtf8(String paramString)
  {
    return new ByteString.LiteralByteString(paramString.getBytes(Internal.a));
  }
  
  static ByteString.CodedBuilder newCodedBuilder(int paramInt)
  {
    return new ByteString.CodedBuilder(paramInt, null);
  }
  
  public static ByteString.Output newOutput()
  {
    return new ByteString.Output(128);
  }
  
  public static ByteString.Output newOutput(int paramInt)
  {
    return new ByteString.Output(paramInt);
  }
  
  public static ByteString readFrom(InputStream paramInputStream)
  {
    return readFrom(paramInputStream, 256, 8192);
  }
  
  public static ByteString readFrom(InputStream paramInputStream, int paramInt)
  {
    return readFrom(paramInputStream, paramInt, paramInt);
  }
  
  public static ByteString readFrom(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      ByteString localByteString = a(paramInputStream, paramInt1);
      if (localByteString == null) {
        return copyFrom(localArrayList);
      }
      localArrayList.add(localByteString);
      paramInt1 = Math.min(paramInt1 * 2, paramInt2);
    }
  }
  
  public static Comparator<ByteString> unsignedLexicographicalComparator()
  {
    return b;
  }
  
  static ByteString wrap(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.hasArray())
    {
      int i = paramByteBuffer.arrayOffset();
      return wrap(paramByteBuffer.array(), i + paramByteBuffer.position(), paramByteBuffer.remaining());
    }
    return new NioByteString(paramByteBuffer);
  }
  
  static ByteString wrap(byte[] paramArrayOfByte)
  {
    return new ByteString.LiteralByteString(paramArrayOfByte);
  }
  
  static ByteString wrap(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new ByteString.BoundedByteString(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public abstract ByteBuffer asReadOnlyByteBuffer();
  
  public abstract List<ByteBuffer> asReadOnlyByteBufferList();
  
  public abstract byte byteAt(int paramInt);
  
  public final ByteString concat(ByteString paramByteString)
  {
    if (2147483647 - size() >= paramByteString.size()) {
      return RopeByteString.concatenate(this, paramByteString);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ByteString would be too long: ");
    localStringBuilder.append(size());
    localStringBuilder.append("+");
    localStringBuilder.append(paramByteString.size());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public abstract void copyTo(ByteBuffer paramByteBuffer);
  
  public void copyTo(byte[] paramArrayOfByte, int paramInt)
  {
    copyTo(paramArrayOfByte, 0, paramInt, size());
  }
  
  @Deprecated
  public final void copyTo(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    checkRange(paramInt1, paramInt1 + paramInt3, size());
    checkRange(paramInt2, paramInt2 + paramInt3, paramArrayOfByte.length);
    if (paramInt3 > 0) {
      copyToInternal(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    }
  }
  
  protected abstract void copyToInternal(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public final boolean endsWith(ByteString paramByteString)
  {
    return (size() >= paramByteString.size()) && (substring(size() - paramByteString.size()).equals(paramByteString));
  }
  
  public abstract boolean equals(Object paramObject);
  
  protected abstract int getTreeDepth();
  
  public final int hashCode()
  {
    int j = this.hash;
    int i = j;
    if (j == 0)
    {
      i = size();
      j = partialHash(i, 0, i);
      i = j;
      if (j == 0) {
        i = 1;
      }
      this.hash = i;
    }
    return i;
  }
  
  abstract byte internalByteAt(int paramInt);
  
  protected abstract boolean isBalanced();
  
  public final boolean isEmpty()
  {
    return size() == 0;
  }
  
  public abstract boolean isValidUtf8();
  
  public ByteString.ByteIterator iterator()
  {
    return new ByteString.1(this);
  }
  
  public abstract CodedInputStream newCodedInput();
  
  public abstract InputStream newInput();
  
  protected abstract int partialHash(int paramInt1, int paramInt2, int paramInt3);
  
  protected abstract int partialIsValidUtf8(int paramInt1, int paramInt2, int paramInt3);
  
  protected final int peekCachedHashCode()
  {
    return this.hash;
  }
  
  public abstract int size();
  
  public final boolean startsWith(ByteString paramByteString)
  {
    int i = size();
    int j = paramByteString.size();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i >= j)
    {
      bool1 = bool2;
      if (substring(0, paramByteString.size()).equals(paramByteString)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final ByteString substring(int paramInt)
  {
    return substring(paramInt, size());
  }
  
  public abstract ByteString substring(int paramInt1, int paramInt2);
  
  public final byte[] toByteArray()
  {
    int i = size();
    if (i == 0) {
      return Internal.c;
    }
    byte[] arrayOfByte = new byte[i];
    copyToInternal(arrayOfByte, 0, 0, i);
    return arrayOfByte;
  }
  
  public final String toString()
  {
    return String.format("<ByteString@%s size=%d>", new Object[] { Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()) });
  }
  
  public final String toString(String paramString)
  {
    try
    {
      String str = toString(Charset.forName(paramString));
      return str;
    }
    catch (UnsupportedCharsetException localUnsupportedCharsetException)
    {
      paramString = new UnsupportedEncodingException(paramString);
      paramString.initCause(localUnsupportedCharsetException);
      throw paramString;
    }
  }
  
  public final String toString(Charset paramCharset)
  {
    if (size() == 0) {
      return "";
    }
    return toStringInternal(paramCharset);
  }
  
  protected abstract String toStringInternal(Charset paramCharset);
  
  public final String toStringUtf8()
  {
    return toString(Internal.a);
  }
  
  abstract void writeTo(ByteOutput paramByteOutput);
  
  public abstract void writeTo(OutputStream paramOutputStream);
  
  final void writeTo(OutputStream paramOutputStream, int paramInt1, int paramInt2)
  {
    checkRange(paramInt1, paramInt1 + paramInt2, size());
    if (paramInt2 > 0) {
      writeToInternal(paramOutputStream, paramInt1, paramInt2);
    }
  }
  
  abstract void writeToInternal(OutputStream paramOutputStream, int paramInt1, int paramInt2);
  
  abstract void writeToReverse(ByteOutput paramByteOutput);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.ByteString
 * JD-Core Version:    0.7.0.1
 */