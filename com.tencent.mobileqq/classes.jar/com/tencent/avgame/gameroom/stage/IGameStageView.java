package com.tencent.avgame.gameroom.stage;

import android.widget.ImageView;
import com.tencent.avgame.gamelogic.ITopic;

public abstract interface IGameStageView
{
  public abstract void a(ITopic paramITopic);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract boolean a();
  
  public abstract ImageView getTopicClockView();
  
  public abstract void setTitleRight(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.IGameStageView
 * JD-Core Version:    0.7.0.1
 */