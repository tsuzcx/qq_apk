package com.tencent.biz.pubaccount.weishi_new.player.wrapper;

import android.content.Context;
import android.view.ViewGroup;
import java.util.Properties;

public abstract interface IWSPlayer<U, V>
{
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(Context paramContext, long paramLong, int paramInt, AbsWSPlayerInfo<U, V> paramAbsWSPlayerInfo);
  
  public abstract void a(IWSPlayerListener paramIWSPlayerListener);
  
  public abstract void a(IWSVideoView paramIWSVideoView);
  
  public abstract void a(IWSVideoView paramIWSVideoView, ViewGroup paramViewGroup);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void b();
  
  public abstract void b(int paramInt);
  
  public abstract void b(boolean paramBoolean);
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract void e();
  
  public abstract void f();
  
  public abstract boolean g();
  
  public abstract boolean h();
  
  public abstract long i();
  
  public abstract long j();
  
  public abstract int k();
  
  public abstract int l();
  
  public abstract String m();
  
  public abstract Properties n();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayer
 * JD-Core Version:    0.7.0.1
 */