package com.tencent.comic.api.plugin;

import com.tencent.comic.api.IQQComicPluginUtil.ExtraResult;

public abstract interface IQQComicPluginPreloadStrategy
{
  public static final IQQComicPluginPreloadStrategy.PluginPreloadInfo b = new IQQComicPluginPreloadStrategy.PluginPreloadInfo();
  
  public abstract void a();
  
  public abstract boolean a(IQQComicPluginUtil.ExtraResult paramExtraResult);
  
  public abstract boolean b(IQQComicPluginUtil.ExtraResult paramExtraResult);
  
  public abstract void c(IQQComicPluginUtil.ExtraResult paramExtraResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.comic.api.plugin.IQQComicPluginPreloadStrategy
 * JD-Core Version:    0.7.0.1
 */