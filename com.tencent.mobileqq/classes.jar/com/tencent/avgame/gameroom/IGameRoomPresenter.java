package com.tencent.avgame.gameroom;

import android.app.Activity;
import android.content.Context;
import android.graphics.RectF;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gameroom.gamelist.IGameListPresenter;
import com.tencent.avgame.gameroom.overlay.IOverlayPresenter;
import com.tencent.avgame.gameroom.pkstage.ISurvivalStagePresenter;
import com.tencent.avgame.gameroom.seat.ISeatPresenter;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.gameroom.stage.IStageRecordPresenter;
import com.tencent.avgame.gameroom.video.IAVControlUiPresenter;
import com.tencent.avgame.session.AVGameUserInfo;
import java.util.List;

public abstract interface IGameRoomPresenter
{
  public abstract Activity a();
  
  public abstract RectF a();
  
  public abstract IOverlayPresenter a();
  
  public abstract ISeatPresenter a();
  
  public abstract IStageRecordPresenter a();
  
  public abstract AVGameUserInfo a(String paramString);
  
  public abstract String a();
  
  public abstract void a();
  
  public abstract void a(long paramLong1, long paramLong2);
  
  public abstract void a(Context paramContext, IGameListPresenter paramIGameListPresenter, IStagePresenter paramIStagePresenter, ISeatPresenter paramISeatPresenter, IOverlayPresenter paramIOverlayPresenter, IAVControlUiPresenter paramIAVControlUiPresenter, IStageRecordPresenter paramIStageRecordPresenter, ISurvivalStagePresenter paramISurvivalStagePresenter);
  
  public abstract void a(String paramString);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean, int paramInt);
  
  public abstract boolean a();
  
  public abstract String b();
  
  public abstract void b();
  
  public abstract void b(String paramString);
  
  public abstract List<Player> c();
  
  public abstract void c();
  
  public abstract void c(boolean paramBoolean);
  
  public abstract void d();
  
  public abstract void d(boolean paramBoolean);
  
  public abstract void e(boolean paramBoolean);
  
  public abstract void f(boolean paramBoolean);
  
  public abstract void i(EngineData paramEngineData);
  
  public abstract void k(EngineData paramEngineData);
  
  public abstract void m(EngineData paramEngineData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.IGameRoomPresenter
 * JD-Core Version:    0.7.0.1
 */