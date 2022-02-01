package com.google.android.exoplayer2.extractor;

public final class SeekPoint
{
  public static final SeekPoint START = new SeekPoint(0L, 0L);
  public final long position;
  public final long timeUs;
  
  public SeekPoint(long paramLong1, long paramLong2)
  {
    this.timeUs = paramLong1;
    this.position = paramLong2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (SeekPoint)paramObject;
      return (this.timeUs == paramObject.timeUs) && (this.position == paramObject.position);
    }
    return false;
  }
  
  public int hashCode()
  {
    return (int)this.timeUs * 31 + (int)this.position;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[timeUs=");
    localStringBuilder.append(this.timeUs);
    localStringBuilder.append(", position=");
    localStringBuilder.append(this.position);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.SeekPoint
 * JD-Core Version:    0.7.0.1
 */