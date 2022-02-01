package com.tencent.biz.pubaccount.api;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

@QAPI(process={"all"})
public abstract interface IPublicAccountJavascriptInterface
  extends QRouteApi
{
  public static final String KEY_PUB_UIN = "pubUin";
  public static final long MAX_H5_DATA_SIZE = 52428800L;
  public static final String NAME_SPACE = "publicAccount";
  
  public abstract void deleteAllH5Data(AppInterface paramAppInterface);
  
  public abstract int excuteShowProfile(AppInterface paramAppInterface, Context paramContext, String paramString);
  
  public abstract String getDataPath();
  
  public abstract boolean getLocationPermissionGrant(String paramString1, String paramString2);
  
  public abstract WebViewPlugin getWebViewPlugin();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface
 * JD-Core Version:    0.7.0.1
 */