package com.google.android.exoplayer2.source;

public final class MediaSource$MediaPeriodId
{
  public final int adGroupIndex;
  public final int adIndexInAdGroup;
  public final int periodIndex;
  public final long windowSequenceNumber;
  
  public MediaSource$MediaPeriodId(int paramInt)
  {
    this(paramInt, -1L);
  }
  
  public MediaSource$MediaPeriodId(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.periodIndex = paramInt1;
    this.adGroupIndex = paramInt2;
    this.adIndexInAdGroup = paramInt3;
    this.windowSequenceNumber = paramLong;
  }
  
  public MediaSource$MediaPeriodId(int paramInt, long paramLong)
  {
    this(paramInt, -1, -1, paramLong);
  }
  
  public MediaPeriodId copyWithPeriodIndex(int paramInt)
  {
    if (this.periodIndex == paramInt) {
      return this;
    }
    return new MediaPeriodId(paramInt, this.adGroupIndex, this.adIndexInAdGroup, this.windowSequenceNumber);
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
      paramObject = (MediaPeriodId)paramObject;
    } while ((this.periodIndex == paramObject.periodIndex) && (this.adGroupIndex == paramObject.adGroupIndex) && (this.adIndexInAdGroup == paramObject.adIndexInAdGroup) && (this.windowSequenceNumber == paramObject.windowSequenceNumber));
    return false;
  }
  
  public int hashCode()
  {
    return (((this.periodIndex + 527) * 31 + this.adGroupIndex) * 31 + this.adIndexInAdGroup) * 31 + (int)this.windowSequenceNumber;
  }
  
  public boolean isAd()
  {
    return this.adGroupIndex != -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.source.MediaSource.MediaPeriodId
 * JD-Core Version:    0.7.0.1
 */