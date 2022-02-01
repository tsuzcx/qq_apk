package com.tencent.comic.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.comic.VipComicHelper;
import com.tencent.comic.api.IQQComicWebViewApi;
import com.tencent.comic.data.ComicWebViewTabBarData;
import com.tencent.comic.hippy.QQHippyCommonJsPluginFactory;
import com.tencent.comic.ui.QQComicFragment;
import com.tencent.comic.ui.QQComicTabBarView;
import com.tencent.comic.ui.QQComicTitleBarView;
import com.tencent.comic.utils.VipComicUrlHelper;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class QQComicWebViewApiImpl
  implements IQQComicWebViewApi
{
  public String addUrlField(String paramString1, String paramString2, String paramString3)
  {
    return VipComicUrlHelper.b(paramString1, paramString2, paramString3);
  }
  
  public Object createComicFragment(Intent paramIntent)
  {
    return QQComicFragment.a(paramIntent);
  }
  
  public View createComicTabBarView(Context paramContext, Intent paramIntent, List<ComicWebViewTabBarData> paramList, TabBarView.OnTabChangeListener paramOnTabChangeListener)
  {
    paramContext = new QQComicTabBarView(paramContext);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ComicWebViewTabBarData localComicWebViewTabBarData = (ComicWebViewTabBarData)paramList.next();
      WebViewTabBarData localWebViewTabBarData = new WebViewTabBarData();
      localWebViewTabBarData.tabIcon = localComicWebViewTabBarData.d;
      localWebViewTabBarData.tabName = localComicWebViewTabBarData.a;
      localWebViewTabBarData.tag = localComicWebViewTabBarData.b;
      localWebViewTabBarData.url = localComicWebViewTabBarData.c;
      localArrayList.add(localWebViewTabBarData);
    }
    paramContext.a(paramIntent, localArrayList, paramOnTabChangeListener);
    return paramContext;
  }
  
  public Object createComicTitleBarUI(Object paramObject)
  {
    if ((paramObject instanceof SwiftBrowserUIStyleHandler)) {
      return new QQComicTitleBarView((SwiftBrowserUIStyleHandler)paramObject);
    }
    return null;
  }
  
  public Object getCommonJsPluginFactory()
  {
    return new QQHippyCommonJsPluginFactory();
  }
  
  public boolean isBoodoUrl(String paramString)
  {
    return VipComicUrlHelper.b(paramString);
  }
  
  public void openComicWebView(Activity paramActivity, String paramString, Intent paramIntent)
  {
    if (VipComicHelper.a(paramString, paramIntent))
    {
      paramIntent.setClassName("com.qqcomic", "com.qqcomic.activity.media.VipComicMediaPlayActivity");
      paramActivity.startActivityForResult(paramIntent, 100);
      return;
    }
    VipComicHelper.a(paramActivity, paramIntent, 100);
  }
  
  public String replaceUrlFieldValueReg(String paramString1, String paramString2, String paramString3)
  {
    return VipComicUrlHelper.a(paramString1, paramString2, paramString3);
  }
  
  public void updateOfflinePkgAsync(int paramInt, AppRuntime paramAppRuntime)
  {
    VipComicHelper.a(paramInt, paramAppRuntime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.api.impl.QQComicWebViewApiImpl
 * JD-Core Version:    0.7.0.1
 */