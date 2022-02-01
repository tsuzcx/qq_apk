package com.tencent.avgame.gamelogic.data;

import com.tencent.avgame.gamelogic.GameUtil;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import trpc.qq_vgame.common.AvGameCommon.GameInfo;

public class GameInfo
{
  public int a = 0;
  public int b = 0;
  public int c = 120;
  public int d = 5;
  public int e = 15;
  public int f = 2;
  public String g;
  public int h = 0;
  public int i = 0;
  public int j;
  
  public void a()
  {
    this.a = 0;
    this.b = 0;
    this.d = 120;
    this.d = 5;
    this.e = 15;
    this.f = 2;
    this.h = 0;
    this.i = 0;
    this.g = null;
    this.j = 0;
  }
  
  public void a(GameInfo paramGameInfo)
  {
    if (paramGameInfo == null) {
      return;
    }
    this.a = paramGameInfo.a;
    this.b = paramGameInfo.b;
    this.c = paramGameInfo.c;
    this.d = paramGameInfo.d;
    this.e = paramGameInfo.e;
    this.f = paramGameInfo.f;
    this.h = paramGameInfo.h;
    this.i = paramGameInfo.i;
    this.g = paramGameInfo.g;
    this.j = paramGameInfo.j;
  }
  
  public final void a(AvGameCommon.GameInfo paramGameInfo)
  {
    if (paramGameInfo == null) {
      return;
    }
    this.a = paramGameInfo.type.get();
    this.b = GameUtil.b(this.a);
    this.c = paramGameInfo.game_duration.get();
    this.d = paramGameInfo.game_preptime.get();
    this.e = paramGameInfo.question_duration.get();
    this.f = paramGameInfo.question_interim.get();
    this.h = paramGameInfo.finish_type.get();
    this.i = paramGameInfo.finish_question_num.get();
    this.j = paramGameInfo.answer_duration.get();
  }
  
  public int b()
  {
    return this.j;
  }
  
  public GameInfo c()
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
  
  public boolean d()
  {
    if (QLog.isColorLevel())
    {
      String str = getClass().getName();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("finishType = ");
      localStringBuilder.append(this.h);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    return this.h == 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("typeSvr");
    localStringBuilder.append("=");
    localStringBuilder.append(this.a);
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
    localStringBuilder.append(this.h);
    localStringBuilder.append("|");
    localStringBuilder.append("finishTopicNum");
    localStringBuilder.append("=");
    localStringBuilder.append(this.i);
    localStringBuilder.append("|");
    localStringBuilder.append("questionClass");
    localStringBuilder.append("=");
    localStringBuilder.append(this.g);
    localStringBuilder.append("|");
    localStringBuilder.append("answerCountDownForVideoClick=");
    localStringBuilder.append(this.j);
    localStringBuilder.append("|");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.GameInfo
 * JD-Core Version:    0.7.0.1
 */