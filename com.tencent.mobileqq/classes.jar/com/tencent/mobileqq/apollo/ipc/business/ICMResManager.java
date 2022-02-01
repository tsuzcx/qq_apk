package com.tencent.mobileqq.apollo.ipc.business;

import com.tencent.mobileqq.apollo.ipc.annotation.RemoteCallBack;
import com.tencent.mobileqq.apollo.ipc.annotation.ServletImpl;
import com.tencent.mobileqq.apollo.utils.CrossEngineResManager.LoadListener;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader.OnFaceDataDownloadListener;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager.ApolloDressInfoListener;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager.ApolloRoleInfoListener;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager.ApolloUserDressInfoListener;
import java.util.ArrayList;

@ServletImpl(a=CMResManager.class)
public abstract interface ICMResManager
{
  public abstract void a(int paramInt1, int paramInt2, @RemoteCallBack IApolloResManager.ApolloRoleInfoListener paramApolloRoleInfoListener);
  
  public abstract void a(@RemoteCallBack CrossEngineResManager.LoadListener paramLoadListener);
  
  public abstract void a(String paramString, int paramInt, @RemoteCallBack IApolloResDownloader.OnFaceDataDownloadListener paramOnFaceDataDownloadListener);
  
  public abstract void a(String paramString, int paramInt, @RemoteCallBack IApolloResManager.ApolloUserDressInfoListener paramApolloUserDressInfoListener);
  
  public abstract void a(ArrayList<Integer> paramArrayList, int paramInt, @RemoteCallBack IApolloResManager.ApolloDressInfoListener paramApolloDressInfoListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.business.ICMResManager
 * JD-Core Version:    0.7.0.1
 */