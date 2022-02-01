package com.tencent.comic.data;

public class ComicCancelRedPointPopIntercetorParams
{
  public long a;
  public boolean a;
  public long b = 0L;
  public long c = 0L;
  
  public ComicCancelRedPointPopIntercetorParams()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ComicCancelRedPointPopIntercetorParams{mHasRedDot=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", mVisibleTime=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", mInteractiveTime=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mLastTouchTime=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.comic.data.ComicCancelRedPointPopIntercetorParams
 * JD-Core Version:    0.7.0.1
 */