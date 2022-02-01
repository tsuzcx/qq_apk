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
  public static int a;
  public static long a;
  public static long b;
  private DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  protected String a;
  protected boolean a;
  private String b;
  public boolean b;
  public long c;
  private String jdField_c_of_type_JavaLangString = "";
  private boolean jdField_c_of_type_Boolean = false;
  private long d;
  
  public GameCenterActivity$GameCenterFragment()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_Long = 0L;
    this.jdField_b_of_type_Boolean = true;
  }
  
  private String a()
  {
    boolean bool = TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString);
    Object localObject = "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=no_config&_wv=18950115&_wwv=393&plat=qq&_wv=5127";
    if (!bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=no_config&_wv=18950115&_wwv=393&plat=qq&_wv=5127");
      ((StringBuilder)localObject).append("&");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_JavaLangString);
      localObject = ((StringBuilder)localObject).toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("&st=");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
  
  private String a(String paramString)
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
  
  private void a()
  {
    Object localObject2 = getAppRuntime();
    Object localObject1 = null;
    if (localObject2 == null) {
      this.mApp = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)getAppRuntime());
    }
    localObject2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (localObject2 != null) {
      this.jdField_a_of_type_JavaLangString = ((AppInterface)localObject2).getCurrentAccountUin();
    } else if (QLog.isColorLevel()) {
      QLog.i("GameCenterFragment", 2, "GameCenterActivity..gcRuntime is null");
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.mUrl)) && (a(this.mUrl)))
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
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        this.mUrl = HtmlOffline.a((String)localObject1, localStringBuilder.toString());
        this.intent.putExtra("url", this.mUrl);
      }
    }
  }
  
  private void a(WebView paramWebView)
  {
    if (!GameCenterSpUtils.a("gamecenter_shot_switch")) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startMaskOpt murl=");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
    QLog.i("GameCenterFragment", 1, ((StringBuilder)localObject).toString());
    localObject = null;
    try
    {
      String str = Uri.parse(this.jdField_b_of_type_JavaLangString).getQueryParameter("preMask");
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
  
  private boolean a(String paramString)
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
  
  private void b(String paramString)
  {
    Object localObject3 = null;
    try
    {
      boolean bool = TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString);
      Object localObject1 = localObject3;
      Object localObject2;
      if (!bool) {
        try
        {
          localObject1 = Uri.parse(this.jdField_b_of_type_JavaLangString).getQueryParameter("status");
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
        if (this.jdField_a_of_type_AndroidUtilDisplayMetrics == null)
        {
          this.jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
          super.getQBaseActivity().getWindowManager().getDefaultDisplay().getMetrics(this.jdField_a_of_type_AndroidUtilDisplayMetrics);
        }
        paramString = APNUtil.a(super.getQBaseActivity().getApplicationContext());
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels);
        ((StringBuilder)localObject4).append(" * ");
        ((StringBuilder)localObject4).append(this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels);
        localObject4 = ((StringBuilder)localObject4).toString();
        paramString = ReportInfoManager.getInstance().genClickReportInfo(this.jdField_a_of_type_JavaLangString, localObject2, (String)localObject3, paramString, (String)localObject4);
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
    if ((!this.jdField_c_of_type_Boolean) && (!paramString.startsWith("data")) && (localObject != null))
    {
      localObject = ((WebViewPluginEngine)localObject).a("offline");
      if ((localObject != null) && ((localObject instanceof OfflinePlugin)))
      {
        if (((OfflinePlugin)localObject).b == 0)
        {
          b("0");
          return;
        }
        b(HtmlOffline.a(a(paramString)));
      }
    }
    else
    {
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  public boolean a(WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    if (AuthorizeConfig.a().i(this.mUrl)) {
      a();
    }
    if (a(this.jdField_b_of_type_JavaLangString))
    {
      Object localObject2 = getWebView().getX5WebViewExtension();
      int i = 0;
      if (localObject2 != null)
      {
        localObject1 = PadFaceManager.a((AppInterface)getAppRuntime());
        if ((((PadFaceManager.SWInfo)localObject1).jdField_b_of_type_Long != 0L) && (((PadFaceManager.SWInfo)localObject1).jdField_a_of_type_Long != ((PadFaceManager.SWInfo)localObject1).jdField_b_of_type_Long))
        {
          if (!TextUtils.isEmpty(((PadFaceManager.SWInfo)localObject1).jdField_a_of_type_JavaLangString))
          {
            ((IX5WebViewExtension)localObject2).updateServiceWorkerBackground(this.jdField_b_of_type_JavaLangString);
            localObject2 = ((PadFaceManager.SWInfo)localObject1).jdField_a_of_type_JavaLangString;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("jump_url=");
            localStringBuilder.append(this.mUrl);
            localObject2 = HtmlOffline.a((String)localObject2, localStringBuilder.toString());
            this.mUrl = ((String)localObject2);
            this.jdField_b_of_type_JavaLangString = ((String)localObject2);
            this.intent.putExtra("url", this.mUrl);
            QLog.e("GameCenterFragment", 1, new Object[] { "doCreateLoopStep_InitWebView: replace url with: ", this.mUrl });
          }
          PadFaceManager.a((AppInterface)getAppRuntime(), ((PadFaceManager.SWInfo)localObject1).jdField_b_of_type_Long);
        }
      }
      Object localObject1 = PadFaceManager.a(getQBaseActivity().getIntent());
      if (localObject1 != null)
      {
        if ((((PadFaceAd)localObject1).isValid()) || (((PadFaceAd)localObject1).redPointId > 0)) {
          i = 1;
        }
        if (i != 0) {
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
    jdField_a_of_type_Int += 1;
    this.d = System.currentTimeMillis();
    if (this.intent != null)
    {
      this.jdField_b_of_type_JavaLangString = this.intent.getStringExtra("url");
      this.jdField_c_of_type_JavaLangString = this.intent.getStringExtra("redTouch");
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        this.jdField_b_of_type_JavaLangString = a();
        this.intent.putExtra("url", this.jdField_b_of_type_JavaLangString);
      }
      if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (a(this.jdField_b_of_type_JavaLangString)))
      {
        jdField_a_of_type_Long = this.intent.getLongExtra("plugin_start_time", 0L);
        if (jdField_a_of_type_Long == 0L)
        {
          Object localObject = null;
          try
          {
            String str = Uri.parse(this.jdField_b_of_type_JavaLangString).getQueryParameter("st");
            localObject = str;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          if (!TextUtils.isEmpty(localObject)) {
            jdField_a_of_type_Long = Long.valueOf(localObject).longValue();
          }
        }
      }
    }
    else
    {
      Toast.makeText(super.getQBaseActivity().getApplicationContext(), 2131690933, 0).show();
      super.getQBaseActivity().finish();
    }
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Boolean = false;
    return true;
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new GameCenterActivity.GameCenterFragment.2(this, this.webViewSurface);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Int -= 1;
    if (jdField_a_of_type_Int == 0)
    {
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("enterGameCenterTime = ");
        localStringBuilder.append(jdField_a_of_type_Long);
        localStringBuilder.append(" , startLoadGameCenterTime = ");
        localStringBuilder.append(jdField_b_of_type_Long);
        localStringBuilder.append(" , exitGameCenterTime = ");
        localStringBuilder.append(this.jdField_c_of_type_Long);
        QLog.d("GameCenterFragment", 2, localStringBuilder.toString());
      }
      VipUtils.a(null, "vip", "0X8004BFB", "0X8004BFB", 0, 0, new String[] { String.valueOf(jdField_a_of_type_Long), String.valueOf(jdField_b_of_type_Long), String.valueOf(this.jdField_c_of_type_Long) });
    }
    super.onDestroy();
    GameCenterVideoManager.a().a();
    System.gc();
    ScreenshotManager.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.activities.GameCenterActivity.GameCenterFragment
 * JD-Core Version:    0.7.0.1
 */