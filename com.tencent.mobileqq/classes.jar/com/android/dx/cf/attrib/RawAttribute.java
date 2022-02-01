package com.android.dx.cf.attrib;

import com.android.dx.rop.cst.ConstantPool;
import com.android.dx.util.ByteArray;

public final class RawAttribute
  extends BaseAttribute
{
  private final ByteArray data;
  private final ConstantPool pool;
  
  public RawAttribute(String paramString, ByteArray paramByteArray, int paramInt1, int paramInt2, ConstantPool paramConstantPool)
  {
    this(paramString, paramByteArray.slice(paramInt1, paramInt1 + paramInt2), paramConstantPool);
  }
  
  public RawAttribute(String paramString, ByteArray paramByteArray, ConstantPool paramConstantPool)
  {
    super(paramString);
    if (paramByteArray == null) {
      throw new NullPointerException("data == null");
    }
    this.data = paramByteArray;
    this.pool = paramConstantPool;
  }
  
  public int byteLength()
  {
    return this.data.size() + 6;
  }
  
  public ByteArray getData()
  {
    return this.data;
  }
  
  public ConstantPool getPool()
  {
    return this.pool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.attrib.RawAttribute
 * JD-Core Version:    0.7.0.1
 */