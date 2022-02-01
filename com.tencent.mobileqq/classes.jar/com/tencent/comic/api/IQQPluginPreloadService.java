package com.tencent.comic.api;

import com.tencent.comic.api.plugin.IQQComicPluginPreloadStrategy;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={"", "tool"})
public abstract interface IQQPluginPreloadService
  extends IRuntimeService
{
  public abstract void preload(int paramInt);
  
  public abstract void preload(int paramInt1, int paramInt2);
  
  public abstract void preload(IQQComicPluginPreloadStrategy paramIQQComicPluginPreloadStrategy, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.comic.api.IQQPluginPreloadService
 * JD-Core Version:    0.7.0.1
 */