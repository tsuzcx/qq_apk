package com.tencent.avgame.gamelogic.data;

import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.qq_vgame.common.AvGameCommon.GameQuestionInfo;
import trpc.qq_vgame.common.AvGameCommon.GuessActionQuestionInfo;

public class TopicActGuess
  extends Topic
{
  public void a(AvGameCommon.GameQuestionInfo paramGameQuestionInfo)
  {
    AvGameCommon.GuessActionQuestionInfo localGuessActionQuestionInfo = (AvGameCommon.GuessActionQuestionInfo)paramGameQuestionInfo.topic.get();
    this.a = paramGameQuestionInfo.id.get();
    this.b = localGuessActionQuestionInfo.question.get();
    this.c = localGuessActionQuestionInfo.answer.get();
    this.d[0] = localGuessActionQuestionInfo.reward_type.get();
    this.d[1] = localGuessActionQuestionInfo.extra_reward.get();
    this.d[2] = localGuessActionQuestionInfo.reward_stroke_color.get();
  }
  
  public int b()
  {
    return 1;
  }
  
  public ITopic j()
  {
    TopicActGuess localTopicActGuess = new TopicActGuess();
    try
    {
      localTopicActGuess.a = this.a;
      localTopicActGuess.b = this.b;
      localTopicActGuess.c = this.c;
      localTopicActGuess.d = this.d;
      localTopicActGuess.f = this.f;
      return localTopicActGuess;
    }
    catch (Exception localException) {}
    return localTopicActGuess;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.TopicActGuess
 * JD-Core Version:    0.7.0.1
 */