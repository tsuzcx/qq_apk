package com.tencent.biz.pubaccount.weishi_new.verticalvideo.deltatime;

import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;

public abstract interface IWSVerticalDeltaTimeCalculator
{
  public abstract void a(long paramLong);
  
  public abstract void a(long paramLong, WSPlayerParam paramWSPlayerParam);
  
  public abstract void a(long paramLong, WSVerticalItemData paramWSVerticalItemData);
  
  public abstract void a(long paramLong, String paramString1, String paramString2);
  
  public abstract void a(String paramString1, String paramString2, long paramLong1, long paramLong2);
  
  public abstract void b(long paramLong);
  
  public abstract void c(long paramLong);
  
  public abstract void d(long paramLong);
  
  public abstract void e(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.deltatime.IWSVerticalDeltaTimeCalculator
 * JD-Core Version:    0.7.0.1
 */