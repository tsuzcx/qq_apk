package com.tencent.biz.qqstory.playvideo.dataprovider;

import android.support.annotation.NonNull;
import java.util.List;

public abstract interface IGroupPageLoader
{
  public abstract List<IGroupPageLoader.IVidFullSyncer> a(List<IDataProvider.GroupId> paramList);
  
  public abstract void a();
  
  public abstract void a(int paramInt, IGroupPageLoader.CallBack paramCallBack);
  
  public abstract boolean a(IDataProvider.GroupInfo paramGroupInfo);
  
  public abstract void b();
  
  @NonNull
  public abstract IDataProvider.StartInfo c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.IGroupPageLoader
 * JD-Core Version:    0.7.0.1
 */