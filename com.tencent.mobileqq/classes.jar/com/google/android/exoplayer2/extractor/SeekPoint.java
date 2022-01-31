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
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (SeekPoint)paramObject;
    } while ((this.timeUs == paramObject.timeUs) && (this.position == paramObject.position));
    return false;
  }
  
  public int hashCode()
  {
    return (int)this.timeUs * 31 + (int)this.position;
  }
  
  public String toString()
  {
    return "[timeUs=" + this.timeUs + ", position=" + this.position + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.SeekPoint
 * JD-Core Version:    0.7.0.1
 */