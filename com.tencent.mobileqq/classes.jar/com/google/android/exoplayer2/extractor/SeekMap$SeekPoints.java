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
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (SeekPoints)paramObject;
      return (this.first.equals(paramObject.first)) && (this.second.equals(paramObject.second));
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.first.hashCode() * 31 + this.second.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.first);
    Object localObject;
    if (this.first.equals(this.second))
    {
      localObject = "";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(this.second);
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.SeekMap.SeekPoints
 * JD-Core Version:    0.7.0.1
 */