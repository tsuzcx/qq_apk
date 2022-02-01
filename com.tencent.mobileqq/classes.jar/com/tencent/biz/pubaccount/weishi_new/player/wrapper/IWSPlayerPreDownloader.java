package com.tencent.biz.pubaccount.weishi_new.player.wrapper;

public abstract interface IWSPlayerPreDownloader<U, V>
{
  public abstract void a();
  
  public abstract void a(AbsWSPlayerInfo<U, V> paramAbsWSPlayerInfo);
  
  public abstract void a(IWSPlayerPreDownloader.Listener paramListener);
  
  public abstract void b();
  
  public abstract boolean b(AbsWSPlayerInfo<U, V> paramAbsWSPlayerInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayerPreDownloader
 * JD-Core Version:    0.7.0.1
 */