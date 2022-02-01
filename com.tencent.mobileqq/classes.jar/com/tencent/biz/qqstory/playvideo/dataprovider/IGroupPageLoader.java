package com.tencent.biz.qqstory.playvideo.dataprovider;

import android.support.annotation.NonNull;
import java.util.List;

public abstract interface IGroupPageLoader
{
  @NonNull
  public abstract IDataProvider.StartInfo a();
  
  public abstract List<IGroupPageLoader.IVidFullSyncer> a(List<IDataProvider.GroupId> paramList);
  
  public abstract void a();
  
  public abstract void a(int paramInt, IGroupPageLoader.CallBack paramCallBack);
  
  public abstract boolean a(IDataProvider.GroupInfo paramGroupInfo);
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.IGroupPageLoader
 * JD-Core Version:    0.7.0.1
 */