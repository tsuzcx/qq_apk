package com.tencent.avgame.gamelogic.data;

import androidx.annotation.NonNull;
import trpc.qq_vgame.common.AvGameCommon.CommonQuestionInfo;

public class TopicOperGuessVideo
  extends TopicBase
{
  public void a(TopicBase paramTopicBase)
  {
    super.a(paramTopicBase);
  }
  
  public void a(AvGameCommon.CommonQuestionInfo paramCommonQuestionInfo)
  {
    super.a(paramCommonQuestionInfo);
  }
  
  public int b()
  {
    return 3;
  }
  
  protected TopicBase n()
  {
    return new TopicOperGuessVideo();
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(o());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.TopicOperGuessVideo
 * JD-Core Version:    0.7.0.1
 */