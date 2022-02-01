package com.tencent.avgame.gameroom;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.graphics.RectF;
import com.tencent.avgame.gamelogic.data.EngineData;
import java.util.List;

public abstract interface IGameRoomView
{
  public abstract void a(int paramInt, String paramString);
  
  public abstract void a(long paramLong, int paramInt, String paramString1, String paramString2);
  
  public abstract void a(long paramLong1, long paramLong2);
  
  public abstract void a(RectF paramRectF);
  
  public abstract void a(EngineData paramEngineData);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract void a(String paramString, DialogInterface.OnClickListener paramOnClickListener);
  
  public abstract void a(String paramString, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean);
  
  public abstract void a(String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, boolean paramBoolean);
  
  public abstract void a(List<MemberVideoDisplayInfo> paramList);
  
  public abstract void b(int paramInt);
  
  public abstract void b(int paramInt, String paramString);
  
  public abstract void b(String paramString);
  
  public abstract void b(boolean paramBoolean);
  
  public abstract Activity d();
  
  public abstract void f();
  
  public abstract void g();
  
  public abstract void h();
  
  public abstract void i();
  
  public abstract void j();
  
  public abstract void k();
  
  public abstract void l();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.IGameRoomView
 * JD-Core Version:    0.7.0.1
 */