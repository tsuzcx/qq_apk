package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.Assertions;

public final class SeekMap$SeekPoints
{
  public final SeekPoint first;
  public final SeekPoint second;
  
  public SeekMap$SeekPoints(SeekPoint paramSeekPoint)
  {
    this(paramSeekPoint, paramSeekPoint);
  }
  
  public SeekMap$SeekPoints(SeekPoint paramSeekPoint1, SeekPoint paramSeekPoint2)
  {
    this.first = ((SeekPoint)Assertions.checkNotNull(paramSeekPoint1));
    this.second = ((SeekPoint)Assertions.checkNotNull(paramSeekPoint2));
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
      paramObject = (SeekPoints)paramObject;
    } while ((this.first.equals(paramObject.first)) && (this.second.equals(paramObject.second)));
    return false;
  }
  
  public int hashCode()
  {
    return this.first.hashCode() * 31 + this.second.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("[").append(this.first);
    if (this.first.equals(this.second)) {}
    for (String str = "";; str = ", " + this.second) {
      return str + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.SeekMap.SeekPoints
 * JD-Core Version:    0.7.0.1
 */