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
  public abstract AVGameUserInfo a(String paramString);
  
  public abstract void a();
  
  public abstract void a(long paramLong1, long paramLong2);
  
  public abstract void a(Context paramContext, IGameListPresenter paramIGameListPresenter, IStagePresenter paramIStagePresenter, ISeatPresenter paramISeatPresenter, IOverlayPresenter paramIOverlayPresenter, IAVControlUiPresenter paramIAVControlUiPresenter, IStageRecordPresenter paramIStageRecordPresenter, ISurvivalStagePresenter paramISurvivalStagePresenter);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean, int paramInt);
  
  public abstract void b();
  
  public abstract void b(String paramString);
  
  public abstract void c();
  
  public abstract void c(String paramString);
  
  public abstract void c(boolean paramBoolean);
  
  public abstract ISeatPresenter d();
  
  public abstract void d(boolean paramBoolean);
  
  public abstract IOverlayPresenter e();
  
  public abstract void e(boolean paramBoolean);
  
  public abstract void f(boolean paramBoolean);
  
  public abstract IStageRecordPresenter g();
  
  public abstract void i(EngineData paramEngineData);
  
  public abstract void k(EngineData paramEngineData);
  
  public abstract Activity m();
  
  public abstract void m(EngineData paramEngineData);
  
  public abstract List<Player> p();
  
  public abstract void q();
  
  public abstract String r();
  
  public abstract String s();
  
  public abstract boolean t();
  
  public abstract RectF u();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.IGameRoomPresenter
 * JD-Core Version:    0.7.0.1
 */