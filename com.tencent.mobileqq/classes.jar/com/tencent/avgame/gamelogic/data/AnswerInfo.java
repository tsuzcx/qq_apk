package com.tencent.avgame.gamelogic.data;

import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.Serializable;
import trpc.qq_vgame.common.AvGameCommon.UserAnswerInfo;

public class AnswerInfo
  implements Serializable
{
  public int answer_index;
  public int answer_result;
  public long uin;
  
  public AnswerInfo()
  {
    reset();
  }
  
  public AnswerInfo clone()
  {
    AnswerInfo localAnswerInfo = new AnswerInfo();
    try
    {
      localAnswerInfo.copyFrom(this);
      return localAnswerInfo;
    }
    catch (Exception localException) {}
    return localAnswerInfo;
  }
  
  public void copyFrom(AnswerInfo paramAnswerInfo)
  {
    if (paramAnswerInfo == null) {
      return;
    }
    this.uin = paramAnswerInfo.uin;
    this.answer_result = paramAnswerInfo.answer_result;
    this.answer_index = paramAnswerInfo.answer_index;
  }
  
  public final void parseFrom(AvGameCommon.UserAnswerInfo paramUserAnswerInfo)
  {
    if (paramUserAnswerInfo == null) {
      return;
    }
    this.uin = paramUserAnswerInfo.uin.get();
    this.answer_result = paramUserAnswerInfo.answer_result.get();
    this.answer_index = paramUserAnswerInfo.answer_index.get();
  }
  
  public void reset()
  {
    this.uin = 0L;
    this.answer_result = 0;
    this.answer_index = -1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin");
    localStringBuilder.append("=");
    localStringBuilder.append(this.uin);
    localStringBuilder.append("|");
    localStringBuilder.append("answer_result");
    localStringBuilder.append("=");
    localStringBuilder.append(this.answer_result);
    localStringBuilder.append("|");
    localStringBuilder.append("answer_index");
    localStringBuilder.append("=");
    localStringBuilder.append(this.answer_index);
    localStringBuilder.append("|");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.AnswerInfo
 * JD-Core Version:    0.7.0.1
 */