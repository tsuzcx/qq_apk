package com.tencent.avgame.gameroom.stage;

import android.graphics.RectF;
import android.view.View;
import android.widget.ImageView;
import com.tencent.avgame.gamelogic.data.EngineData;

public abstract interface IStageView
{
  public abstract RectF a();
  
  public abstract View a();
  
  public abstract void a(ImageView paramImageView, long paramLong1, long paramLong2);
  
  public abstract void a(EngineData paramEngineData);
  
  public abstract void a(String paramString);
  
  public abstract void a(boolean paramBoolean, long paramLong1, long paramLong2);
  
  public abstract void b();
  
  public abstract void b(EngineData paramEngineData);
  
  public abstract void b(String paramString);
  
  public abstract void c();
  
  public abstract void d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.IStageView
 * JD-Core Version:    0.7.0.1
 */