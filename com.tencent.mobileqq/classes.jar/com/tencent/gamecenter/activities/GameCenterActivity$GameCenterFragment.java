package com.tencent.gamecenter.activities;

import aarc;
import abtz;
import abua;
import abuf;
import abuv;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import avce;
import avcg;
import avdj;
import bieo;
import bjkj;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.common.util.ReportInfoManager;
import com.tencent.mobileqq.gamecenter.data.PadFaceAd;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePadFaceFragment;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.WebView;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import nro;
import nuz;

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
  private boolean jdField_c_of_type_Boolean;
  private long d;
  
  public GameCenterActivity$GameCenterFragment()
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Boolean = true;
  }
  
  private String a()
  {
    String str = "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=no_config&_wv=18950115&_wwv=393&plat=qq&_wv=5127";
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      str = "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=no_config&_wv=18950115&_wwv=393&plat=qq&_wv=5127" + "&" + this.jdField_c_of_type_JavaLangString;
    }
    return str + "&st=" + this.d;
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
    if (this.mApp == null) {
      this.mApp = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = this.mApp;
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.mUrl)) && (a(this.mUrl))) {}
      try
      {
        String str = Uri.parse(this.mUrl).getQueryParameter("uin");
        if (str == null)
        {
          this.mUrl = nuz.a(this.mUrl, "uin=" + this.jdField_a_of_type_JavaLangString);
          this.intent.putExtra("url", this.mUrl);
        }
        return;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("GameCenterFragment", 2, "GameCenterActivity..gcRuntime is null");
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          Object localObject = null;
        }
      }
    }
  }
  
  private void a(WebView paramWebView)
  {
    if (!abuf.a("gamecenter_shot_switch")) {
      return;
    }
    QLog.i("GameCenterFragment", 1, "startMaskOpt murl=" + this.jdField_b_of_type_JavaLangString);
    Object localObject = null;
    try
    {
      String str = Uri.parse(this.jdField_b_of_type_JavaLangString).getQueryParameter("preMask");
      localObject = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("GameCenterFragment", 1, "GAMECENTER_MASK_KEY error=" + localException.toString());
      }
    }
    abuv.a().b(paramWebView, localObject, new abtz(this, paramWebView));
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
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = localObject;
      }
    }
    return true;
  }
  
  private void b(String paramString)
  {
    String str3 = null;
    try
    {
      boolean bool = TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString);
      String str1 = str3;
      if (!bool) {}
      for (;;)
      {
        try
        {
          str1 = Uri.parse(this.jdField_b_of_type_JavaLangString).getQueryParameter("status");
          if (QLog.isColorLevel()) {
            QLog.i("GameCenterFragment", 2, "parseExtraParamToReport , status" + str1);
          }
          if (!TextUtils.isEmpty(str1))
          {
            if (TextUtils.isEmpty(paramString))
            {
              paramString = "0";
              if (this.jdField_a_of_type_AndroidUtilDisplayMetrics == null)
              {
                this.jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
                super.getActivity().getWindowManager().getDefaultDisplay().getMetrics(this.jdField_a_of_type_AndroidUtilDisplayMetrics);
              }
              str3 = bjkj.a(super.getActivity().getApplicationContext());
              String str4 = this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels + " * " + this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels;
              paramString = ReportInfoManager.getInstance().genClickReportInfo(this.jdField_a_of_type_JavaLangString, str1, paramString, str3, str4);
              ReportInfoManager.getInstance().postClickReportInfo(paramString);
            }
          }
          else {
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          String str2 = str3;
        }
      }
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    Object localObject;
    if (this.webView == null) {
      localObject = null;
    }
    while ((!this.jdField_c_of_type_Boolean) && (!paramString.startsWith("data")) && (localObject != null))
    {
      localObject = ((WebViewPluginEngine)localObject).a("offline");
      if ((localObject != null) && ((localObject instanceof aarc)))
      {
        if (((aarc)localObject).b == 0) {
          b("0");
        }
      }
      else
      {
        return;
        localObject = this.webView.getPluginEngine();
        continue;
      }
      b(nuz.a(a(paramString)));
      return;
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  public int doCreateLoopStep_Final(Bundle paramBundle)
  {
    return super.doCreateLoopStep_Final(paramBundle);
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
      Object localObject;
      if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (a(this.jdField_b_of_type_JavaLangString)))
      {
        jdField_a_of_type_Long = this.intent.getLongExtra("plugin_start_time", 0L);
        if (jdField_a_of_type_Long == 0L) {
          localObject = null;
        }
      }
      try
      {
        String str = Uri.parse(this.jdField_b_of_type_JavaLangString).getQueryParameter("st");
        localObject = str;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      if (!TextUtils.isEmpty(localObject)) {
        jdField_a_of_type_Long = Long.valueOf(localObject).longValue();
      }
    }
    for (;;)
    {
      super.doOnCreate(paramBundle);
      this.jdField_a_of_type_Boolean = false;
      return true;
      Toast.makeText(super.getActivity().getApplicationContext(), 2131690912, 0).show();
      super.getActivity().finish();
    }
  }
  
  public String getUAMark()
  {
    return "gamecenter";
  }
  
  public void initFinish()
  {
    int i = 0;
    super.initFinish();
    if (nro.a().i(this.mUrl)) {
      a();
    }
    if (a(this.jdField_b_of_type_JavaLangString))
    {
      Object localObject2 = getWebView().getX5WebViewExtension();
      if (localObject2 != null)
      {
        localObject1 = avce.a(this.mApp);
        if ((((avcg)localObject1).jdField_b_of_type_Long != 0L) && (((avcg)localObject1).jdField_a_of_type_Long != ((avcg)localObject1).jdField_b_of_type_Long))
        {
          if (!TextUtils.isEmpty(((avcg)localObject1).jdField_a_of_type_JavaLangString))
          {
            ((IX5WebViewExtension)localObject2).updateServiceWorkerBackground(this.jdField_b_of_type_JavaLangString);
            localObject2 = nuz.a(((avcg)localObject1).jdField_a_of_type_JavaLangString, "jump_url=" + this.mUrl);
            this.mUrl = ((String)localObject2);
            this.jdField_b_of_type_JavaLangString = ((String)localObject2);
            this.intent.putExtra("url", this.mUrl);
            QLog.e("GameCenterFragment", 1, new Object[] { "doCreateLoopStep_InitWebView: replace url with: ", this.mUrl });
          }
          avce.a(this.mApp, ((avcg)localObject1).jdField_b_of_type_Long);
        }
      }
      Object localObject1 = avce.a(getActivity().getIntent());
      if (localObject1 != null)
      {
        if ((((PadFaceAd)localObject1).isValid()) || (((PadFaceAd)localObject1).redPointId > 0)) {
          i = 1;
        }
        if (i != 0) {
          QQGamePadFaceFragment.a(getActivity(), (PadFaceAd)localObject1);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Int -= 1;
    if (jdField_a_of_type_Int == 0)
    {
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("GameCenterFragment", 2, "enterGameCenterTime = " + jdField_a_of_type_Long + " , startLoadGameCenterTime = " + jdField_b_of_type_Long + " , exitGameCenterTime = " + this.jdField_c_of_type_Long);
      }
      VipUtils.a(null, "vip", "0X8004BFB", "0X8004BFB", 0, 0, new String[] { String.valueOf(jdField_a_of_type_Long), String.valueOf(jdField_b_of_type_Long), String.valueOf(this.jdField_c_of_type_Long) });
    }
    super.onDestroy();
    avdj.a().a();
    System.gc();
    abuv.a().a();
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if ((this.jdField_b_of_type_Boolean) && (!this.isDestroyed))
    {
      if ((this.webView == null) || (!this.webView.canGoBack()) || (this.mSwiftTitleUI.leftView == null)) {
        break label116;
      }
      this.mSwiftTitleUI.leftView.setText(2131690499);
    }
    for (;;)
    {
      a(paramString);
      this.jdField_b_of_type_Boolean = false;
      if ((!TextUtils.isEmpty(paramString)) && (a(paramString)) && (abuv.a().a()))
      {
        abuv.a().a(paramWebView, new abua(this));
        abuv.a().b();
      }
      super.onPageFinished(paramWebView, paramString);
      return;
      label116:
      this.mSwiftTitleUI.setLeftViewName(this.intent);
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if ((!this.jdField_c_of_type_Boolean) && (!TextUtils.isEmpty(paramString)) && (a(paramString)))
    {
      jdField_b_of_type_Long = System.currentTimeMillis();
      a(paramWebView);
    }
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gamecenter.activities.GameCenterActivity.GameCenterFragment
 * JD-Core Version:    0.7.0.1
 */