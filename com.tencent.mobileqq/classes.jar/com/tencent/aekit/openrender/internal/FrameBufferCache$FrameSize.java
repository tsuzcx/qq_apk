package com.tencent.aekit.openrender.internal;

class FrameBufferCache$FrameSize
{
  public int height;
  public int width;
  
  public FrameBufferCache$FrameSize(FrameBufferCache paramFrameBufferCache, int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (FrameSize)paramObject;
    } while ((this.width == paramObject.width) && (this.height == paramObject.height));
    return false;
  }
  
  public int hashCode()
  {
    return this.width * 42 + this.height;
  }
  
  public String toString()
  {
    return String.format("[FrameSize] width = %d, height = %d", new Object[] { Integer.valueOf(this.width), Integer.valueOf(this.height) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aekit.openrender.internal.FrameBufferCache.FrameSize
 * JD-Core Version:    0.7.0.1
 */