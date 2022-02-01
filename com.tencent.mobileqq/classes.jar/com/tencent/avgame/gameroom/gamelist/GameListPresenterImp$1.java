package com.tencent.avgame.gameroom.gamelist;

import android.content.Context;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.listener.SimpleGameStatusListener;
import com.tencent.avgame.util.AVGameUtil;

class GameListPresenterImp$1
  extends SimpleGameStatusListener
{
  GameListPresenterImp$1(GameListPresenterImp paramGameListPresenterImp) {}
  
  public void a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2)
  {
    if (GameListPresenterImp.a(this.a))
    {
      GameListPresenterImp.a(this.a, false);
      if (AVGameUtil.b() == 2) {
        this.a.a.a(this.a.a.a().getString(2131690390));
      }
    }
  }
  
  public void c(EngineData paramEngineData)
  {
    GameListPresenterImp.a(this.a, false);
  }
  
  public void f(EngineData paramEngineData)
  {
    GameListPresenterImp.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListPresenterImp.1
 * JD-Core Version:    0.7.0.1
 */