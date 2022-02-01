package com.tencent.gamecenter.wadl.api;

import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.gamecenter.wadl.biz.listener.WadlResCallBack;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IQQGameDownloadService
  extends IRuntimeService
{
  public abstract void deleteDownload(int paramInt, String paramString);
  
  public abstract void deleteResDownload(String paramString);
  
  public abstract void doAppSystemReceiver(String paramString1, String paramString2);
  
  public abstract void doDownloadAction(WadlParams paramWadlParams);
  
  public abstract void doInstallAction(WadlParams paramWadlParams);
  
  public abstract void doPauseAction(int paramInt, String paramString);
  
  public abstract void doPauseResAction(String paramString);
  
  public abstract void doQueryAction(ArrayList<String> paramArrayList);
  
  public abstract void doQueryActionByVia(String paramString);
  
  public abstract void doQueryAllRes();
  
  public abstract void doQueryAllTask();
  
  public abstract void doResumeAction(int paramInt, String paramString);
  
  public abstract void doResumeResAction(String paramString);
  
  public abstract void registerResCallBack(WadlResCallBack paramWadlResCallBack);
  
  public abstract void registerWadlServiceCallBack(WadlProxyServiceCallBackInterface paramWadlProxyServiceCallBackInterface);
  
  public abstract void unRegisterResCallBack(WadlResCallBack paramWadlResCallBack);
  
  public abstract void unRegisterWadlServiceCallBack(WadlProxyServiceCallBackInterface paramWadlProxyServiceCallBackInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.IQQGameDownloadService
 * JD-Core Version:    0.7.0.1
 */