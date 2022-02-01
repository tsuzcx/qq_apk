package com.eclipsesource.mmv8;

import java.nio.ByteBuffer;

public class SharedV8ArrayBuffer
  extends V8ArrayBuffer
{
  private SharedV8ArrayBuffer(V8 paramV8, int paramInt)
  {
    super(paramV8, paramInt);
    throw new IllegalArgumentException("not support this way construct");
  }
  
  public SharedV8ArrayBuffer(V8 paramV8, ByteBuffer paramByteBuffer)
  {
    super(paramV8, paramByteBuffer);
  }
  
  protected void initialize(long paramLong, Object paramObject)
  {
    this.v8.checkThread();
    paramObject = (ByteBuffer)paramObject;
    int i = paramObject.limit();
    this.objectHandle = this.v8.initNewSharedV8ArrayBuffer(this.v8.getV8RuntimePtr(), paramObject, i);
    this.released = false;
    addObjectReference(this.objectHandle);
  }
  
  public void manualRelease()
  {
    super.release();
  }
  
  public void release() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.mmv8.SharedV8ArrayBuffer
 * JD-Core Version:    0.7.0.1
 */