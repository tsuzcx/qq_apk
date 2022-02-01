package com.tencent.avgame.gameroom.seat;

import android.graphics.RectF;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.MemberVideoDisplayInfo;
import com.tencent.avgame.session.AVGameUserInfo;
import java.util.List;

public abstract interface ISeatPresenter
{
  public abstract RectF a(long paramLong);
  
  public abstract AVGameUserInfo a(String paramString);
  
  public abstract List<SeatMemberInfo> a();
  
  public abstract void a(long paramLong, boolean paramBoolean);
  
  public abstract void a(EngineData paramEngineData);
  
  public abstract void a(Player paramPlayer);
  
  public abstract void a(IGameRoomPresenter paramIGameRoomPresenter);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void b(Player paramPlayer);
  
  public abstract void b(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract boolean b();
  
  public abstract void c();
  
  public abstract void c(Player paramPlayer);
  
  public abstract List<MemberVideoDisplayInfo> d();
  
  public abstract void e();
  
  public abstract RectF f();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.ISeatPresenter
 * JD-Core Version:    0.7.0.1
 */