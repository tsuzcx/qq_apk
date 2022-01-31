package com.tencent.biz.pubaccount.readinjoy.struct;

import awge;
import awhs;

public class InterestLabelInfo
  extends awge
  implements Cloneable
{
  public static final String TABLE_NAME = ArticleInfo.class.getSimpleName();
  @awhs
  public int mInterestLabelID;
  public String mInterestLabelNme;
  public boolean mIsDefault;
  
  public InterestLabelInfo clone()
  {
    try
    {
      InterestLabelInfo localInterestLabelInfo = (InterestLabelInfo)super.clone();
      return localInterestLabelInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.InterestLabelInfo
 * JD-Core Version:    0.7.0.1
 */