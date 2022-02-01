package com.tencent.biz.pubaccount.readinjoy.struct;

import com.tencent.qphone.base.util.QLog;

public class NewPolymericInfo$PackQuestionAnswerExtraInfo
  implements Cloneable
{
  public String a;
  public String b;
  
  protected Object clone()
  {
    try
    {
      PackQuestionAnswerExtraInfo localPackQuestionAnswerExtraInfo = (PackQuestionAnswerExtraInfo)super.clone();
      return localPackQuestionAnswerExtraInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      QLog.e("NewPolymericInfo", 2, "PackTopicExtraInfo item clone failed. exception = " + localCloneNotSupportedException);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo.PackQuestionAnswerExtraInfo
 * JD-Core Version:    0.7.0.1
 */