package com.tencent.biz.pubaccount.readinjoy.struct;

import com.tencent.qphone.base.util.QLog;

public class NewPolymericInfo$PackTopicExtraInfo
  implements Cloneable
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  
  protected Object clone()
  {
    try
    {
      PackTopicExtraInfo localPackTopicExtraInfo = (PackTopicExtraInfo)super.clone();
      return localPackTopicExtraInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      QLog.e("NewPolymericInfo", 2, "PackTopicExtraInfo item clone failed. exception = " + localCloneNotSupportedException);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo.PackTopicExtraInfo
 * JD-Core Version:    0.7.0.1
 */