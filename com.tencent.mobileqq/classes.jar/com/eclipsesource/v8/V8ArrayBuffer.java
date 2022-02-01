package com.eclipsesource.v8;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public class V8ArrayBuffer
  extends V8Value
{
  ByteBuffer byteBuffer;
  
  public V8ArrayBuffer(V8 paramV8, int paramInt)
  {
    super(paramV8);
    initialize(paramV8.getV8RuntimePtr(), Integer.valueOf(paramInt));
    this.byteBuffer = paramV8.createV8ArrayBufferBackingStore(paramV8.getV8RuntimePtr(), this.objectHandle, paramInt);
    this.byteBuffer.order(ByteOrder.nativeOrder());
  }
  
  public V8ArrayBuffer(V8 paramV8, ByteBuffer paramByteBuffer)
  {
    super(paramV8);
    ByteBuffer localByteBuffer = paramByteBuffer;
    if (paramByteBuffer == null) {
      localByteBuffer = ByteBuffer.allocateDirect(0);
    }
    if (localByteBuffer.isDirect())
    {
      initialize(paramV8.getV8RuntimePtr(), localByteBuffer);
      this.byteBuffer = localByteBuffer;
      localByteBuffer.order(ByteOrder.nativeOrder());
      return;
    }
    throw new IllegalArgumentException("ByteBuffer must be a allocated as a direct ByteBuffer");
  }
  
  public final byte[] array()
  {
    this.v8.checkThread();
    checkReleased();
    return this.byteBuffer.array();
  }
  
  public final int arrayOffset()
  {
    this.v8.checkThread();
    checkReleased();
    return this.byteBuffer.arrayOffset();
  }
  
  public final int capacity()
  {
    this.v8.checkThread();
    checkReleased();
    return this.byteBuffer.capacity();
  }
  
  public final V8ArrayBuffer clear()
  {
    this.v8.checkThread();
    checkReleased();
    this.byteBuffer.clear();
    return this;
  }
  
  public V8ArrayBuffer compact()
  {
    this.v8.checkThread();
    checkReleased();
    this.byteBuffer.compact();
    return this;
  }
  
  protected V8Value createTwin()
  {
    return new V8ArrayBuffer(this.v8, this.byteBuffer);
  }
  
  public int doubleLimit()
  {
    this.v8.checkThread();
    checkReleased();
    return this.byteBuffer.asDoubleBuffer().limit();
  }
  
  public final V8ArrayBuffer flip()
  {
    this.v8.checkThread();
    checkReleased();
    this.byteBuffer.flip();
    return this;
  }
  
  public int floatLimit()
  {
    this.v8.checkThread();
    checkReleased();
    return this.byteBuffer.asFloatBuffer().limit();
  }
  
  public byte get()
  {
    this.v8.checkThread();
    checkReleased();
    return this.byteBuffer.get();
  }
  
  public byte get(int paramInt)
  {
    this.v8.checkThread();
    checkReleased();
    return this.byteBuffer.get(paramInt);
  }
  
  public V8ArrayBuffer get(byte[] paramArrayOfByte)
  {
    this.v8.checkThread();
    checkReleased();
    this.byteBuffer.get(paramArrayOfByte);
    return this;
  }
  
  public V8ArrayBuffer get(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.v8.checkThread();
    checkReleased();
    this.byteBuffer.get(paramArrayOfByte, paramInt1, paramInt2);
    return this;
  }
  
  public char getChar()
  {
    this.v8.checkThread();
    checkReleased();
    return this.byteBuffer.getChar();
  }
  
  public char getChar(int paramInt)
  {
    this.v8.checkThread();
    checkReleased();
    return this.byteBuffer.getChar(paramInt);
  }
  
  public double getDouble()
  {
    this.v8.checkThread();
    checkReleased();
    return this.byteBuffer.getDouble();
  }
  
  public double getDouble(int paramInt)
  {
    this.v8.checkThread();
    checkReleased();
    return this.byteBuffer.getDouble(paramInt);
  }
  
  public float getFloat()
  {
    this.v8.checkThread();
    checkReleased();
    return this.byteBuffer.getFloat();
  }
  
  public float getFloat(int paramInt)
  {
    this.v8.checkThread();
    checkReleased();
    return this.byteBuffer.getFloat(paramInt);
  }
  
  public int getInt()
  {
    this.v8.checkThread();
    checkReleased();
    return this.byteBuffer.getInt();
  }
  
  public int getInt(int paramInt)
  {
    this.v8.checkThread();
    checkReleased();
    return this.byteBuffer.getInt(paramInt);
  }
  
  public long getLong()
  {
    this.v8.checkThread();
    checkReleased();
    return this.byteBuffer.getLong();
  }
  
  public long getLong(int paramInt)
  {
    this.v8.checkThread();
    checkReleased();
    return this.byteBuffer.getLong(paramInt);
  }
  
  public short getShort()
  {
    this.v8.checkThread();
    checkReleased();
    return this.byteBuffer.getShort();
  }
  
  public short getShort(int paramInt)
  {
    this.v8.checkThread();
    checkReleased();
    return this.byteBuffer.getShort(paramInt);
  }
  
  public final boolean hasArray()
  {
    this.v8.checkThread();
    checkReleased();
    return this.byteBuffer.hasArray();
  }
  
  public final boolean hasRemaining()
  {
    this.v8.checkThread();
    checkReleased();
    return this.byteBuffer.hasRemaining();
  }
  
  protected void initialize(long paramLong, Object paramObject)
  {
    this.v8.checkThread();
    int i;
    if ((paramObject instanceof ByteBuffer))
    {
      paramObject = (ByteBuffer)paramObject;
      i = paramObject.limit();
      this.objectHandle = this.v8.initNewV8ArrayBuffer(this.v8.getV8RuntimePtr(), paramObject, i);
    }
    else
    {
      i = ((Integer)paramObject).intValue();
      this.objectHandle = this.v8.initNewV8ArrayBuffer(this.v8.getV8RuntimePtr(), i);
    }
    this.released = false;
    addObjectReference(this.objectHandle);
  }
  
  public int intLimit()
  {
    this.v8.checkThread();
    checkReleased();
    return this.byteBuffer.asIntBuffer().limit();
  }
  
  public boolean isDirect()
  {
    this.v8.checkThread();
    checkReleased();
    return this.byteBuffer.isDirect();
  }
  
  public boolean isReadOnly()
  {
    this.v8.checkThread();
    checkReleased();
    return this.byteBuffer.isReadOnly();
  }
  
  public int limit()
  {
    this.v8.checkThread();
    checkReleased();
    return this.byteBuffer.limit();
  }
  
  public final V8ArrayBuffer limit(int paramInt)
  {
    this.v8.checkThread();
    checkReleased();
    this.byteBuffer.limit(paramInt);
    return this;
  }
  
  public final V8ArrayBuffer mark()
  {
    this.v8.checkThread();
    checkReleased();
    this.byteBuffer.mark();
    return this;
  }
  
  public final V8ArrayBuffer order(ByteOrder paramByteOrder)
  {
    this.v8.checkThread();
    checkReleased();
    this.byteBuffer.order(paramByteOrder);
    return this;
  }
  
  public final ByteOrder order()
  {
    this.v8.checkThread();
    checkReleased();
    return this.byteBuffer.order();
  }
  
  public final int position()
  {
    this.v8.checkThread();
    checkReleased();
    return this.byteBuffer.position();
  }
  
  public final V8ArrayBuffer position(int paramInt)
  {
    this.v8.checkThread();
    checkReleased();
    this.byteBuffer.position(paramInt);
    return this;
  }
  
  public V8ArrayBuffer put(byte paramByte)
  {
    this.v8.checkThread();
    checkReleased();
    this.byteBuffer.put(paramByte);
    return this;
  }
  
  public V8ArrayBuffer put(int paramInt, byte paramByte)
  {
    this.v8.checkThread();
    checkReleased();
    this.byteBuffer.put(paramInt, paramByte);
    return this;
  }
  
  public V8ArrayBuffer put(ByteBuffer paramByteBuffer)
  {
    this.v8.checkThread();
    checkReleased();
    this.byteBuffer.put(paramByteBuffer);
    return this;
  }
  
  public final V8ArrayBuffer put(byte[] paramArrayOfByte)
  {
    this.v8.checkThread();
    checkReleased();
    this.byteBuffer.put(paramArrayOfByte);
    return this;
  }
  
  public V8ArrayBuffer put(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.v8.checkThread();
    checkReleased();
    this.byteBuffer.put(paramArrayOfByte, paramInt1, paramInt2);
    return this;
  }
  
  public V8ArrayBuffer putChar(char paramChar)
  {
    this.v8.checkThread();
    checkReleased();
    this.byteBuffer.putChar(paramChar);
    return this;
  }
  
  public V8ArrayBuffer putChar(int paramInt, char paramChar)
  {
    this.v8.checkThread();
    checkReleased();
    this.byteBuffer.putChar(paramInt, paramChar);
    return this;
  }
  
  public V8ArrayBuffer putDouble(double paramDouble)
  {
    this.v8.checkThread();
    checkReleased();
    this.byteBuffer.putDouble(paramDouble);
    return this;
  }
  
  public V8ArrayBuffer putDouble(int paramInt, double paramDouble)
  {
    this.v8.checkThread();
    checkReleased();
    this.byteBuffer.putDouble(paramInt, paramDouble);
    return this;
  }
  
  public V8ArrayBuffer putFloat(float paramFloat)
  {
    this.v8.checkThread();
    checkReleased();
    this.byteBuffer.putFloat(paramFloat);
    return this;
  }
  
  public V8ArrayBuffer putFloat(int paramInt, float paramFloat)
  {
    this.v8.checkThread();
    checkReleased();
    this.byteBuffer.putFloat(paramInt, paramFloat);
    return this;
  }
  
  public V8ArrayBuffer putInt(int paramInt)
  {
    this.v8.checkThread();
    checkReleased();
    this.byteBuffer.putInt(paramInt);
    return this;
  }
  
  public V8ArrayBuffer putInt(int paramInt1, int paramInt2)
  {
    this.v8.checkThread();
    checkReleased();
    this.byteBuffer.asIntBuffer().put(paramInt1, paramInt2);
    return this;
  }
  
  public V8ArrayBuffer putLong(int paramInt, long paramLong)
  {
    this.v8.checkThread();
    checkReleased();
    this.byteBuffer.putLong(paramInt, paramLong);
    return this;
  }
  
  public V8ArrayBuffer putLong(long paramLong)
  {
    this.v8.checkThread();
    checkReleased();
    this.byteBuffer.putLong(paramLong);
    return this;
  }
  
  public V8ArrayBuffer putShort(int paramInt, short paramShort)
  {
    this.v8.checkThread();
    checkReleased();
    this.byteBuffer.putShort(paramInt, paramShort);
    return this;
  }
  
  public V8ArrayBuffer putShort(short paramShort)
  {
    this.v8.checkThread();
    checkReleased();
    this.byteBuffer.putShort(paramShort);
    return this;
  }
  
  public final int remaining()
  {
    this.v8.checkThread();
    checkReleased();
    return this.byteBuffer.remaining();
  }
  
  public final V8ArrayBuffer reset()
  {
    this.v8.checkThread();
    checkReleased();
    this.byteBuffer.reset();
    return this;
  }
  
  public final V8ArrayBuffer rewind()
  {
    this.v8.checkThread();
    checkReleased();
    this.byteBuffer.rewind();
    return this;
  }
  
  public int shortLimit()
  {
    this.v8.checkThread();
    checkReleased();
    return this.byteBuffer.asShortBuffer().limit();
  }
  
  public V8ArrayBuffer twin()
  {
    this.v8.checkThread();
    checkReleased();
    return (V8ArrayBuffer)super.twin();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.v8.V8ArrayBuffer
 * JD-Core Version:    0.7.0.1
 */