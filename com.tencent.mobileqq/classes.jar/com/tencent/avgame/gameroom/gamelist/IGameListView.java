package com.tencent.avgame.gameroom.gamelist;

import android.content.Context;
import com.tencent.avgame.gamelogic.data.EngineData;

public abstract interface IGameListView
{
  public abstract void a(EngineData paramEngineData);
  
  public abstract void a(String paramString);
  
  public abstract void c(int paramInt);
  
  public abstract Context getViewContext();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.IGameListView
 * JD-Core Version:    0.7.0.1
 */