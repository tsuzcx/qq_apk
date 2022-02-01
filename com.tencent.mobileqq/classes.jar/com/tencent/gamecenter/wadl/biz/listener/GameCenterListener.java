package com.tencent.gamecenter.wadl.biz.listener;

import com.tencent.gamecenter.wadl.biz.entity.WadlResult;

public abstract interface GameCenterListener
{
  public abstract void onTaskComplete(WadlResult paramWadlResult);
  
  public abstract void onTaskDeleted(String paramString1, String paramString2);
  
  public abstract void onTaskInstall(WadlResult paramWadlResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.listener.GameCenterListener
 * JD-Core Version:    0.7.0.1
 */