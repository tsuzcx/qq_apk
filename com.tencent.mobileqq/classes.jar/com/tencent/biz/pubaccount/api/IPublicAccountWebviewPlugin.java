package com.tencent.biz.pubaccount.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

@QAPI(process={"all"})
public abstract interface IPublicAccountWebviewPlugin
  extends QRouteApi
{
  public static final String NAME_SPACE = "PublicAccountJs";
  public static final String SCHEME = "publicaccount";
  
  public abstract WebViewPlugin getWebViewPlugin();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.IPublicAccountWebviewPlugin
 * JD-Core Version:    0.7.0.1
 */