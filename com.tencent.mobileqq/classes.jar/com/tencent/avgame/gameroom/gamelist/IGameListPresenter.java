package com.tencent.avgame.gameroom.gamelist;

import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.GameItem;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import java.util.List;

public abstract interface IGameListPresenter
{
  public abstract List<GameItem> a();
  
  public abstract void a(EngineData paramEngineData);
  
  public abstract void a(GameItem paramGameItem);
  
  public abstract void a(GameItem paramGameItem, int paramInt);
  
  public abstract void a(IGameRoomPresenter paramIGameRoomPresenter);
  
  public abstract void b(GameItem paramGameItem, int paramInt);
  
  public abstract boolean b();
  
  public abstract int c();
  
  public abstract void d();
  
  public abstract void e();
  
  public abstract void f();
  
  public abstract void g();
  
  public abstract void h();
  
  public abstract void i();
  
  public abstract void j();
  
  public abstract void k();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.IGameListPresenter
 * JD-Core Version:    0.7.0.1
 */