package com.tencent.TMG.report;

public class AVReporting
  implements Cloneable
{
  public int mCount;
  public String mDetail;
  public int mDetailHashCode;
  public int mLockedCount;
  public int mSeqKey;
  public String mTag;
  
  public AVReporting clone()
  {
    try
    {
      AVReporting localAVReporting = (AVReporting)super.clone();
      return localAVReporting;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.report.AVReporting
 * JD-Core Version:    0.7.0.1
 */