package com.tencent.avgame.gamelogic.data;

import com.tencent.avgame.gamelogic.GameUtil;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import trpc.qq_vgame.common.AvGameCommon.GameInfo;

public class GameInfo
{
  public int a;
  public String a;
  public int b = 0;
  public int c = 120;
  public int d = 5;
  public int e = 15;
  public int f = 2;
  public int g = 0;
  public int h = 0;
  public int i;
  
  public GameInfo()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public int a()
  {
    return this.i;
  }
  
  public GameInfo a()
  {
    GameInfo localGameInfo = new GameInfo();
    try
    {
      localGameInfo.a(this);
      return localGameInfo;
    }
    catch (Exception localException) {}
    return localGameInfo;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.b = 0;
    this.d = 120;
    this.d = 5;
    this.e = 15;
    this.f = 2;
    this.g = 0;
    this.h = 0;
    this.jdField_a_of_type_JavaLangString = null;
    this.i = 0;
  }
  
  public void a(GameInfo paramGameInfo)
  {
    if (paramGameInfo == null) {
      return;
    }
    this.jdField_a_of_type_Int = paramGameInfo.jdField_a_of_type_Int;
    this.b = paramGameInfo.b;
    this.c = paramGameInfo.c;
    this.d = paramGameInfo.d;
    this.e = paramGameInfo.e;
    this.f = paramGameInfo.f;
    this.g = paramGameInfo.g;
    this.h = paramGameInfo.h;
    this.jdField_a_of_type_JavaLangString = paramGameInfo.jdField_a_of_type_JavaLangString;
    this.i = paramGameInfo.i;
  }
  
  public final void a(AvGameCommon.GameInfo paramGameInfo)
  {
    if (paramGameInfo == null) {
      return;
    }
    this.jdField_a_of_type_Int = paramGameInfo.type.get();
    this.b = GameUtil.a(this.jdField_a_of_type_Int);
    this.c = paramGameInfo.game_duration.get();
    this.d = paramGameInfo.game_preptime.get();
    this.e = paramGameInfo.question_duration.get();
    this.f = paramGameInfo.question_interim.get();
    this.g = paramGameInfo.finish_type.get();
    this.h = paramGameInfo.finish_question_num.get();
    this.i = paramGameInfo.answer_duration.get();
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel())
    {
      String str = getClass().getName();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("finishType = ");
      localStringBuilder.append(this.g);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    return this.g == 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("typeSvr");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("|");
    localStringBuilder.append("typeLoc");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("|");
    localStringBuilder.append("gameDuration");
    localStringBuilder.append("=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("|");
    localStringBuilder.append("gamePrepareDuration");
    localStringBuilder.append("=");
    localStringBuilder.append(this.d);
    localStringBuilder.append("|");
    localStringBuilder.append("topicDuration");
    localStringBuilder.append("=");
    localStringBuilder.append(this.e);
    localStringBuilder.append("|");
    localStringBuilder.append("topicInterim");
    localStringBuilder.append("=");
    localStringBuilder.append(this.f);
    localStringBuilder.append("|");
    localStringBuilder.append("finishType");
    localStringBuilder.append("=");
    localStringBuilder.append(this.g);
    localStringBuilder.append("|");
    localStringBuilder.append("finishTopicNum");
    localStringBuilder.append("=");
    localStringBuilder.append(this.h);
    localStringBuilder.append("|");
    localStringBuilder.append("questionClass");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("|");
    localStringBuilder.append("answerCountDownForVideoClick=");
    localStringBuilder.append(this.i);
    localStringBuilder.append("|");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.GameInfo
 * JD-Core Version:    0.7.0.1
 */