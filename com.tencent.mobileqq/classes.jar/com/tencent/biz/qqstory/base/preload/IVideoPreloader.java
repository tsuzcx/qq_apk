package com.tencent.biz.qqstory.base.preload;

import java.util.List;

public abstract interface IVideoPreloader
{
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(IVideoPreloader.OnPreloadListener paramOnPreloadListener);
  
  public abstract void a(List<DownloadTask> paramList, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.IVideoPreloader
 * JD-Core Version:    0.7.0.1
 */