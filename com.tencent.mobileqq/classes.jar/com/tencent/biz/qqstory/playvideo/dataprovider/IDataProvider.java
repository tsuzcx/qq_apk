package com.tencent.biz.qqstory.playvideo.dataprovider;

import android.support.annotation.Nullable;
import android.support.annotation.UiThread;

public abstract interface IDataProvider
{
  public abstract IDataProvider.Data a(@Nullable IDataProvider.GroupId paramGroupId, int paramInt);
  
  @UiThread
  public abstract IDataProvider.StartInfo a();
  
  public abstract void a();
  
  @UiThread
  public abstract void a(@Nullable IDataProvider.GroupId paramGroupId, int paramInt1, int paramInt2, String paramString);
  
  @UiThread
  public abstract void a(@Nullable IDataProvider.GroupId paramGroupId, String paramString);
  
  public abstract void a(IDataProvider.ICallBack paramICallBack);
  
  public abstract void b();
  
  public abstract void b(IDataProvider.ICallBack paramICallBack);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider
 * JD-Core Version:    0.7.0.1
 */