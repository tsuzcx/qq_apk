package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8ArrayBuffer;
import com.eclipsesource.v8.V8TypedArray;

public class TypedArray
{
  private V8TypedArray typedArray;
  
  public TypedArray(V8 paramV8, ArrayBuffer paramArrayBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    paramArrayBuffer = paramArrayBuffer.getV8ArrayBuffer();
    paramV8 = new V8TypedArray(paramV8, paramArrayBuffer, paramInt1, paramInt2, paramInt3);
    try
    {
      this.typedArray = ((V8TypedArray)paramV8.twin().setWeak());
      return;
    }
    finally
    {
      paramArrayBuffer.close();
      paramV8.close();
    }
  }
  
  TypedArray(V8TypedArray paramV8TypedArray)
  {
    this.typedArray = ((V8TypedArray)paramV8TypedArray.twin().setWeak());
  }
  
  public V8TypedArray getV8TypedArray()
  {
    return (V8TypedArray)this.typedArray.twin();
  }
  
  public boolean isAvailable()
  {
    return this.typedArray.isReleased() ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.v8.utils.TypedArray
 * JD-Core Version:    0.7.0.1
 */