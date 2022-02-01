package com.tencent.biz.pubaccount.weishi_new.player.wrapper;

import android.graphics.Bitmap;

public abstract interface IWSPlayerListener
{
  public abstract void a(int paramInt, long paramLong, String paramString);
  
  public abstract void a(IWSPlayer paramIWSPlayer);
  
  public abstract void a(IWSPlayer paramIWSPlayer, int paramInt1, int paramInt2);
  
  public abstract void a(IWSPlayer paramIWSPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap);
  
  public abstract void a(String paramString);
  
  public abstract boolean a(IWSPlayer paramIWSPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString);
  
  public abstract boolean a(IWSPlayer paramIWSPlayer, int paramInt, Object paramObject);
  
  public abstract void b(IWSPlayer paramIWSPlayer);
  
  public abstract void c(IWSPlayer paramIWSPlayer);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayerListener
 * JD-Core Version:    0.7.0.1
 */