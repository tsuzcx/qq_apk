package com.tencent.avgame.gamelogic.data;

import androidx.annotation.NonNull;
import trpc.qq_vgame.common.AvGameCommon.CommonQuestionInfo;

public class TopicSongGuess
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
    return 4;
  }
  
  protected TopicBase n()
  {
    return new TopicSongGuess();
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
 * Qualified Name:     com.tencent.avgame.gamelogic.data.TopicSongGuess
 * JD-Core Version:    0.7.0.1
 */