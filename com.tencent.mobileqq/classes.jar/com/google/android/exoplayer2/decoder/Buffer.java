package com.google.android.exoplayer2.decoder;

public abstract class Buffer
{
  private int flags;
  
  public final void addFlag(int paramInt)
  {
    this.flags = (paramInt | this.flags);
  }
  
  public void clear()
  {
    this.flags = 0;
  }
  
  public final void clearFlag(int paramInt)
  {
    this.flags = ((paramInt ^ 0xFFFFFFFF) & this.flags);
  }
  
  protected final boolean getFlag(int paramInt)
  {
    return (this.flags & paramInt) == paramInt;
  }
  
  public final boolean isDecodeOnly()
  {
    return getFlag(-2147483648);
  }
  
  public final boolean isEndOfStream()
  {
    return getFlag(4);
  }
  
  public final boolean isKeyFrame()
  {
    return getFlag(1);
  }
  
  public final void setFlags(int paramInt)
  {
    this.flags = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.decoder.Buffer
 * JD-Core Version:    0.7.0.1
 */