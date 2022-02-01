package com.tencent.biz.pubaccount.weishi_new.player.wrapper;

import android.content.Context;

public abstract interface IWSPlayerFactory<U, V>
{
  public abstract AbsWSPlayerInfo<U, V> a();
  
  public abstract IWSPlayer a(Context paramContext, IWSVideoView paramIWSVideoView);
  
  public abstract IWSPlayerPreDownloader a(Context paramContext);
  
  public abstract IWSVideoView a(Context paramContext, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayerFactory
 * JD-Core Version:    0.7.0.1
 */