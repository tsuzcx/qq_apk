package com.tencent.gamecenter.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.common.util.ReportInfoManager;
import com.tencent.gamecenter.common.util.ScreenshotManager;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.gamecenter.data.PadFaceAd;
import com.tencent.mobileqq.gamecenter.data.PadFaceManager;
import com.tencent.mobileqq.gamecenter.data.PadFaceManager.SWInfo;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePadFaceFragment;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.open.base.APNUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.WebView;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class GameCenterActivity$GameCenterFragment
  extends WebViewFragment
{
  public static int c;
  public static long d;
  public static long e;
  protected boolean a = false;
  protected String b;
  public long f = 0L;
  public boolean g = true;
  private DisplayMetrics h;
  private long i;
  private String j = "";
  private String k = "";
  private AppInterface l;
  private boolean m = false;
  
  private String a()
  {
    boolean bool = TextUtils.isEmpty(this.k);
    Object localObject = "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=no_config&_wv=18950115&_wwv=393&plat=qq&_wv=5127";
    if (!bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=no_config&_wv=18950115&_wwv=393&plat=qq&_wv=5127");
      ((StringBuilder)localObject).append("&");
      ((StringBuilder)localObject).append(this.k);
      localObject = ((StringBuilder)localObject).toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("&st=");
    localStringBuilder.append(this.i);
    return localStringBuilder.toString();
  }
  
  private void a(WebView paramWebView)
  {
    if (!GameCenterSpUtils.b("gamecenter_shot_switch")) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startMaskOpt murl=");
    ((StringBuilder)localObject).append(this.j);
    QLog.i("GameCenterFragment", 1, ((StringBuilder)localObject).toString());
    localObject = null;
    try
    {
      String str = Uri.parse(this.j).getQueryParameter("preMask");
      localObject = str;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("GAMECENTER_MASK_KEY error=");
      localStringBuilder.append(localException.toString());
      QLog.e("GameCenterFragment", 1, localStringBuilder.toString());
    }
    ScreenshotManager.a().b(paramWebView, (String)localObject, new GameCenterActivity.GameCenterFragment.1(this, paramWebView));
  }
  
  private void b()
  {
    Object localObject2 = getAppRuntime();
    Object localObject1 = null;
    if (localObject2 == null) {
      this.mApp = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    }
    if (this.l == null) {
      this.l = ((AppInterface)getAppRuntime());
    }
    localObject2 = this.l;
    if (localObject2 != null) {
      this.b = ((AppInterface)localObject2).getCurrentAccountUin();
    } else if (QLog.isColorLevel()) {
      QLog.i("GameCenterFragment", 2, "GameCenterActivity..gcRuntime is null");
    }
    if ((!TextUtils.isEmpty(this.b)) && (!TextUtils.isEmpty(this.mUrl)) && (b(this.mUrl)))
    {
      try
      {
        localObject2 = Uri.parse(this.mUrl).getQueryParameter("uin");
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      if (localObject1 == null)
      {
        localObject1 = this.mUrl;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("uin=");
        localStringBuilder.append(this.b);
        this.mUrl = HtmlOffline.a((String)localObject1, localStringBuilder.toString());
        this.intent.putExtra("url", this.mUrl);
      }
    }
  }
  
  private boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = null;
    try
    {
      paramString = Uri.parse(paramString).getQueryParameter("status");
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      paramString = localObject;
    }
    return !TextUtils.isEmpty(paramString);
  }
  
  private String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = Uri.parse(paramString).getQueryParameter("_bid");
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void d(String paramString)
  {
    Object localObject3 = null;
    try
    {
      boolean bool = TextUtils.isEmpty(this.j);
      Object localObject1 = localObject3;
      Object localObject2;
      if (!bool) {
        try
        {
          localObject1 = Uri.parse(this.j).getQueryParameter("status");
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          localObject2 = localObject3;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("parseExtraParamToReport , status");
        ((StringBuilder)localObject3).append(localObject2);
        QLog.i("GameCenterFragment", 2, ((StringBuilder)localObject3).toString());
      }
      if (!TextUtils.isEmpty(localObject2))
      {
        localObject3 = paramString;
        if (TextUtils.isEmpty(paramString)) {
          localObject3 = "0";
        }
        if (this.h == null)
        {
          this.h = new DisplayMetrics();
          super.getQBaseActivity().getWindowManager().getDefaultDisplay().getMetrics(this.h);
        }
        paramString = APNUtil.a(super.getQBaseActivity().getApplicationContext());
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(this.h.widthPixels);
        ((StringBuilder)localObject4).append(" * ");
        ((StringBuilder)localObject4).append(this.h.heightPixels);
        localObject4 = ((StringBuilder)localObject4).toString();
        paramString = ReportInfoManager.getInstance().genClickReportInfo(this.b, localObject2, (String)localObject3, paramString, (String)localObject4);
        ReportInfoManager.getInstance().postClickReportInfo(paramString);
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    Object localObject;
    if (this.webView == null) {
      localObject = null;
    } else {
      localObject = this.webView.getPluginEngine();
    }
    if ((!this.m) && (!paramString.startsWith("data")) && (localObject != null))
    {
      localObject = ((WebViewPluginEngine)localObject).b("offline");
      if ((localObject != null) && ((localObject instanceof OfflinePlugin)))
      {
        if (((OfflinePlugin)localObject).j == 0)
        {
          d("0");
          return;
        }
        d(HtmlOffline.d(c(paramString)));
      }
    }
    else
    {
      this.m = false;
    }
  }
  
  public boolean a(WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    if (AuthorizeConfig.a().q(this.mUrl)) {
      b();
    }
    if (b(this.j))
    {
      Object localObject2 = getWebView().getX5WebViewExtension();
      int n = 0;
      if (localObject2 != null)
      {
        localObject1 = PadFaceManager.a((AppInterface)getAppRuntime());
        if ((((PadFaceManager.SWInfo)localObject1).b != 0L) && (((PadFaceManager.SWInfo)localObject1).a != ((PadFaceManager.SWInfo)localObject1).b))
        {
          if (!TextUtils.isEmpty(((PadFaceManager.SWInfo)localObject1).c))
          {
            ((IX5WebViewExtension)localObject2).updateServiceWorkerBackground(this.j);
            localObject2 = ((PadFaceManager.SWInfo)localObject1).c;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("jump_url=");
            localStringBuilder.append(this.mUrl);
            localObject2 = HtmlOffline.a((String)localObject2, localStringBuilder.toString());
            this.mUrl = ((String)localObject2);
            this.j = ((String)localObject2);
            this.intent.putExtra("url", this.mUrl);
            QLog.e("GameCenterFragment", 1, new Object[] { "doCreateLoopStep_InitWebView: replace url with: ", this.mUrl });
          }
          PadFaceManager.a((AppInterface)getAppRuntime(), ((PadFaceManager.SWInfo)localObject1).b);
        }
      }
      Object localObject1 = PadFaceManager.a(getQBaseActivity().getIntent());
      if (localObject1 != null)
      {
        if ((((PadFaceAd)localObject1).isValid()) || (((PadFaceAd)localObject1).redPointId > 0)) {
          n = 1;
        }
        if (n != 0) {
          QQGamePadFaceFragment.a(getQBaseActivity(), (PadFaceAd)localObject1);
        }
      }
    }
    return paramWebViewKernelCallBack.interceptStartLoadUrl();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterFragment", 2, "game center fragment doOnCreate");
    }
    c += 1;
    this.i = System.currentTimeMillis();
    if (this.intent != null)
    {
      this.j = this.intent.getStringExtra("url");
      this.k = this.intent.getStringExtra("redTouch");
      if (TextUtils.isEmpty(this.j))
      {
        this.j = a();
        this.intent.putExtra("url", this.j);
      }
      if ((!TextUtils.isEmpty(this.j)) && (b(this.j)))
      {
        d = this.intent.getLongExtra("plugin_start_time", 0L);
        if (d == 0L)
        {
          Object localObject = null;
          try
          {
            String str = Uri.parse(this.j).getQueryParameter("st");
            localObject = str;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          if (!TextUtils.isEmpty(localObject)) {
            d = Long.valueOf(localObject).longValue();
          }
        }
      }
    }
    else
    {
      Toast.makeText(super.getQBaseActivity().getApplicationContext(), 2131887872, 0).show();
      super.getQBaseActivity().finish();
    }
    super.doOnCreate(paramBundle);
    this.a = false;
    return true;
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new GameCenterActivity.GameCenterFragment.2(this, this.webViewSurface);
  }
  
  public void onDestroy()
  {
    this.a = true;
    c -= 1;
    if (c == 0)
    {
      this.f = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("enterGameCenterTime = ");
        localStringBuilder.append(d);
        localStringBuilder.append(" , startLoadGameCenterTime = ");
        localStringBuilder.append(e);
        localStringBuilder.append(" , exitGameCenterTime = ");
        localStringBuilder.append(this.f);
        QLog.d("GameCenterFragment", 2, localStringBuilder.toString());
      }
      VipUtils.a(null, "vip", "0X8004BFB", "0X8004BFB", 0, 0, new String[] { String.valueOf(d), String.valueOf(e), String.valueOf(this.f) });
    }
    super.onDestroy();
    GameCenterVideoManager.a().c();
    System.gc();
    ScreenshotManager.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.activities.GameCenterActivity.GameCenterFragment
 * JD-Core Version:    0.7.0.1
 */