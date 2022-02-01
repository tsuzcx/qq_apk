package com.tencent.biz.qqcircle.richframework.video;

import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;

public abstract interface QCirclePlayerCallback
{
  public abstract void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2);
  
  public abstract void a(ISuperPlayer paramISuperPlayer);
  
  public abstract void a(SuperPlayerVideoInfo paramSuperPlayerVideoInfo);
  
  public abstract void b(ISuperPlayer paramISuperPlayer);
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract void e();
  
  public abstract void f();
  
  public abstract void g();
  
  public abstract Object getReportData();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.video.QCirclePlayerCallback
 * JD-Core Version:    0.7.0.1
 */