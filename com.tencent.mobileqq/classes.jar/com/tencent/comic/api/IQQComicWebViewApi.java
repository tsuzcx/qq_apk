package com.tencent.comic.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.comic.data.ComicWebViewTabBarData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import java.util.List;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IQQComicWebViewApi
  extends QRouteApi
{
  public abstract String addUrlField(String paramString1, String paramString2, String paramString3);
  
  public abstract Object createComicFragment(Intent paramIntent);
  
  public abstract View createComicTabBarView(Context paramContext, Intent paramIntent, List<ComicWebViewTabBarData> paramList, TabBarView.OnTabChangeListener paramOnTabChangeListener);
  
  public abstract Object createComicTitleBarUI(Object paramObject);
  
  public abstract Object getCommonJsPluginFactory();
  
  public abstract boolean isBoodoUrl(String paramString);
  
  public abstract void openComicWebView(Activity paramActivity, String paramString, Intent paramIntent);
  
  public abstract String replaceUrlFieldValueReg(String paramString1, String paramString2, String paramString3);
  
  public abstract void updateOfflinePkgAsync(int paramInt, AppRuntime paramAppRuntime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.comic.api.IQQComicWebViewApi
 * JD-Core Version:    0.7.0.1
 */