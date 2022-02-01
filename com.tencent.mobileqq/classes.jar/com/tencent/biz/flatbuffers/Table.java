package com.tencent.biz.flatbuffers;

import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

public class Table
{
  private static final ThreadLocal<CharsetDecoder> a = new Table.1();
  private static final ThreadLocal<CharBuffer> b = new ThreadLocal();
  public static final ThreadLocal<Charset> c = new Table.2();
  protected int d;
  protected ByteBuffer e;
  
  protected int a(Integer paramInteger1, Integer paramInteger2, ByteBuffer paramByteBuffer)
  {
    return 0;
  }
  
  protected String a(int paramInt, boolean paramBoolean)
  {
    CharsetDecoder localCharsetDecoder = (CharsetDecoder)a.get();
    localCharsetDecoder.reset();
    int i = paramInt;
    if (!paramBoolean)
    {
      if (!a(paramInt, 4)) {
        return null;
      }
      i = paramInt + this.e.getInt(paramInt);
    }
    if (!a(i, 4)) {
      return null;
    }
    ByteBuffer localByteBuffer = this.e.duplicate().order(ByteOrder.LITTLE_ENDIAN);
    paramInt = localByteBuffer.getInt(i);
    if (!a(i, paramInt + 4)) {
      return null;
    }
    i += 4;
    localByteBuffer.position(i);
    localByteBuffer.limit(i + paramInt);
    paramInt = (int)(paramInt * localCharsetDecoder.maxCharsPerByte());
    Object localObject2 = (CharBuffer)b.get();
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((CharBuffer)localObject2).capacity() >= paramInt) {}
    }
    else
    {
      localObject1 = CharBuffer.allocate(paramInt);
      b.set(localObject1);
    }
    ((CharBuffer)localObject1).clear();
    try
    {
      localObject2 = localCharsetDecoder.decode(localByteBuffer, (CharBuffer)localObject1, true);
      if (!((CoderResult)localObject2).isUnderflow()) {
        ((CoderResult)localObject2).throwException();
      }
      return ((CharBuffer)localObject1).flip().toString();
    }
    catch (Throwable localThrowable)
    {
      QLog.e("FlatBuffersParser", 1, "convertString error", localThrowable);
    }
    return null;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 >= 0) && (paramInt1 + paramInt2 <= this.e.capacity());
  }
  
  protected int d(int paramInt)
  {
    if (a(paramInt, 4)) {
      return paramInt + this.e.getInt(paramInt);
    }
    return -1;
  }
  
  protected String e(int paramInt)
  {
    return a(paramInt, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.flatbuffers.Table
 * JD-Core Version:    0.7.0.1
 */