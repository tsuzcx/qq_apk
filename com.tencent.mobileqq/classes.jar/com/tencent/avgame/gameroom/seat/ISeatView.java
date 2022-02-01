package com.tencent.avgame.gameroom.seat;

import android.graphics.RectF;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gameroom.MemberVideoDisplayInfo;
import java.util.List;

public abstract interface ISeatView
{
  public abstract RectF a(long paramLong);
  
  public abstract void a(long paramLong, boolean paramBoolean);
  
  public abstract void a(EngineData paramEngineData);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void b(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract RectF getAddMemberViewRectInRootView();
  
  public abstract List<MemberVideoDisplayInfo> getMemberHeadViewDisplayInfoList();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.ISeatView
 * JD-Core Version:    0.7.0.1
 */