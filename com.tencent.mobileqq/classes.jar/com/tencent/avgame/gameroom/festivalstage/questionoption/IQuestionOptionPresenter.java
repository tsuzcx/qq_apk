package com.tencent.avgame.gameroom.festivalstage.questionoption;

import com.tencent.avgame.gamelogic.data.AnswerInfo;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.TopicBase;
import com.tencent.avgame.gameroom.stage.IStagePresenter;

public abstract interface IQuestionOptionPresenter
{
  public abstract void a();
  
  public abstract void a(int paramInt, AnswerInfo paramAnswerInfo);
  
  public abstract void a(EngineData paramEngineData);
  
  public abstract void a(TopicBase paramTopicBase);
  
  public abstract void a(QuestionOptionsAdapter paramQuestionOptionsAdapter);
  
  public abstract void a(QuestionOptionsDataSource paramQuestionOptionsDataSource);
  
  public abstract void a(IStagePresenter paramIStagePresenter);
  
  public abstract void a(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract boolean a(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.festivalstage.questionoption.IQuestionOptionPresenter
 * JD-Core Version:    0.7.0.1
 */