package com.tencent.avgame.gameroom.stage;

import android.content.Context;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.data.EngineData;

public abstract interface IGameStagePresenter
{
  public abstract IStagePresenter a();
  
  public abstract String a(Context paramContext, EngineData paramEngineData);
  
  public abstract String a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void a(ITopic paramITopic);
  
  public abstract void a(EngineData paramEngineData);
  
  public abstract void a(IStagePresenter paramIStagePresenter);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract boolean a();
  
  public abstract boolean a(boolean paramBoolean);
  
  public abstract void b(EngineData paramEngineData);
  
  public abstract void c(EngineData paramEngineData);
  
  public abstract void d(EngineData paramEngineData);
  
  public abstract void e(EngineData paramEngineData);
  
  public abstract void f(EngineData paramEngineData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.IGameStagePresenter
 * JD-Core Version:    0.7.0.1
 */