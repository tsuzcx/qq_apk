package com.tencent.avgame.gameroom.stage;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.festivalstage.questionoption.IQuestionOptionPresenter;

public abstract interface IStagePresenter
{
  public abstract RectF a();
  
  public abstract Drawable a();
  
  public abstract IGameRoomPresenter a();
  
  public abstract void a();
  
  public abstract void a(ImageView paramImageView, long paramLong1, long paramLong2);
  
  public abstract void a(EngineData paramEngineData);
  
  public abstract void a(IGameRoomPresenter paramIGameRoomPresenter);
  
  public abstract void a(IQuestionOptionPresenter paramIQuestionOptionPresenter);
  
  public abstract void a(IGameStagePresenter paramIGameStagePresenter);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract void a(String paramString, EngineData paramEngineData);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract boolean a(EngineData paramEngineData);
  
  public abstract Drawable b();
  
  public abstract void b();
  
  public abstract void b(EngineData paramEngineData);
  
  public abstract void b(IGameStagePresenter paramIGameStagePresenter);
  
  public abstract void b(String paramString, EngineData paramEngineData);
  
  public abstract void b(boolean paramBoolean);
  
  public abstract void c();
  
  public abstract void c(IGameStagePresenter paramIGameStagePresenter);
  
  public abstract void d();
  
  public abstract void d(IGameStagePresenter paramIGameStagePresenter);
  
  public abstract void e(IGameStagePresenter paramIGameStagePresenter);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.IStagePresenter
 * JD-Core Version:    0.7.0.1
 */