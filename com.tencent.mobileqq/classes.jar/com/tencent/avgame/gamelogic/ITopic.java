package com.tencent.avgame.gamelogic;

import java.util.List;
import trpc.qq_vgame.common.AvGameCommon.GameQuestionInfo;

public abstract interface ITopic
  extends Cloneable
{
  public abstract int a();
  
  public abstract void a(long paramLong);
  
  public abstract void a(AvGameCommon.GameQuestionInfo paramGameQuestionInfo);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract boolean a(ITopic paramITopic);
  
  public abstract int b();
  
  public abstract String c();
  
  public abstract String d();
  
  public abstract String e();
  
  public abstract int f();
  
  public abstract String[] g();
  
  public abstract long h();
  
  public abstract List<? extends ITopic> i();
  
  public abstract ITopic j();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.ITopic
 * JD-Core Version:    0.7.0.1
 */