package com.tencent.biz.pubaccount.readinjoy.video;

public class VideoBehaviorsReportData
{
  public int a;
  public long a;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append("mSceneType: ").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", mCurIndexDiff: ").append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", mPreIndexDiff: ").append(this.c);
    localStringBuilder.append(", mTimeInterval: ").append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", mIsPull: ").append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", mIsAutoPlay: ").append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoBehaviorsReportData
 * JD-Core Version:    0.7.0.1
 */