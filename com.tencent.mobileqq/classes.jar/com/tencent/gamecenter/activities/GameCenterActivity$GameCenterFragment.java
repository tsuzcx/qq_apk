package com.tencent.gamecenter.activities;

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
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.common.util.ReportInfoManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.open.base.APNUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import qhj;

public class GameCenterActivity$GameCenterFragment
  extends WebViewFragment
{
  public static int a;
  public static long a;
  public static long b;
  private DisplayMetrics a;
  protected String a;
  protected boolean a;
  private AppInterface jdField_b_of_type_ComTencentCommonAppAppInterface;
  private String jdField_b_of_type_JavaLangString = "";
  public boolean b;
  public long c;
  private String jdField_c_of_type_JavaLangString = "";
  private boolean jdField_c_of_type_Boolean;
  private long d;
  
  public GameCenterActivity$GameCenterFragment()
  {
    this.jdField_b_of_type_Boolean = true;
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
              str3 = APNUtil.a(super.getActivity().getApplicationContext());
              String str4 = this.jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels + " * " + this.jdField_a_of_type_AndroidUtilDisplayMetrics.heightPixels;
              paramString = ReportInfoManager.a().a(this.jdField_a_of_type_JavaLangString, str1, paramString, str3, str4);
              ReportInfoManager.a().a(paramString);
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
  
  private boolean d(String paramString)
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
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    }
    if (this.jdField_b_of_type_ComTencentCommonAppAppInterface == null) {
      this.jdField_b_of_type_ComTencentCommonAppAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    }
    if (this.jdField_b_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.g)) && (d(this.g))) {}
      try
      {
        String str = Uri.parse(this.g).getQueryParameter("uin");
        if (str == null)
        {
          this.g = HtmlOffline.a(this.g, "uin=" + this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidContentIntent.putExtra("url", this.g);
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
  
  private String i()
  {
    String str = "http://gamecenter.qq.com/front/release/index/index.html?plat=qq&_wv=5127";
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      str = "http://gamecenter.qq.com/front/release/index/index.html?plat=qq&_wv=5127" + "&" + this.jdField_c_of_type_JavaLangString;
    }
    return str + "&st=" + this.d;
  }
  
  protected int a(Bundle paramBundle)
  {
    int i = super.a(paramBundle);
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.b != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.b.setVisibility(0);
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.b instanceof TextView)) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.b.setText(2131431771);
      }
    }
    return i;
  }
  
  public String a()
  {
    return "gamecenter";
  }
  
  public void a(WebView paramWebView, String paramString)
  {
    if ((this.jdField_b_of_type_Boolean) && (!this.h))
    {
      if ((this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) || (!this.jdField_a_of_type_ComTencentBizUiTouchWebView.canGoBack()) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a == null)) {
        break label70;
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a.setText(2131432397);
    }
    for (;;)
    {
      a(paramString);
      this.jdField_b_of_type_Boolean = false;
      super.a(paramWebView, paramString);
      return;
      label70:
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a(this.jdField_a_of_type_AndroidContentIntent);
    }
  }
  
  public void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if ((!this.jdField_c_of_type_Boolean) && (!TextUtils.isEmpty(paramString)) && (d(paramString))) {
      jdField_b_of_type_Long = System.currentTimeMillis();
    }
    super.a(paramWebView, paramString, paramBitmap);
  }
  
  public void a(String paramString)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {
      localObject = null;
    }
    while ((!this.jdField_c_of_type_Boolean) && (!paramString.startsWith("data")) && (localObject != null))
    {
      localObject = ((WebViewPluginEngine)localObject).a("offline");
      if ((localObject != null) && ((localObject instanceof OfflinePlugin)))
      {
        if (((OfflinePlugin)localObject).b == 0) {
          b("0");
        }
      }
      else
      {
        return;
        localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.a();
        continue;
      }
      b(HtmlOffline.a(a(paramString)));
      return;
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  public boolean a(Bundle paramBundle)
  {
    jdField_a_of_type_Int += 1;
    this.d = System.currentTimeMillis();
    if (this.jdField_a_of_type_AndroidContentIntent != null)
    {
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("url");
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("redTouch");
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        this.jdField_b_of_type_JavaLangString = i();
        this.jdField_a_of_type_AndroidContentIntent.putExtra("url", this.jdField_b_of_type_JavaLangString);
      }
      if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (d(this.jdField_b_of_type_JavaLangString)))
      {
        jdField_a_of_type_Long = this.jdField_a_of_type_AndroidContentIntent.getLongExtra("plugin_start_time", 0L);
        if (jdField_a_of_type_Long != 0L) {}
      }
    }
    for (;;)
    {
      try
      {
        String str = Uri.parse(this.jdField_b_of_type_JavaLangString).getQueryParameter("st");
        if (!TextUtils.isEmpty(str)) {
          jdField_a_of_type_Long = Long.valueOf(str).longValue();
        }
        super.a(paramBundle);
        this.jdField_a_of_type_Boolean = false;
        ThreadManager.postImmediately(new qhj(this), null, false);
        return true;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        Object localObject = null;
        continue;
      }
      Toast.makeText(super.getActivity().getApplicationContext(), 2131431774, 0).show();
      super.getActivity().finish();
    }
  }
  
  protected void c()
  {
    super.c();
    if (AuthorizeConfig.a().e(this.g)) {
      f();
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
    System.gc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.activities.GameCenterActivity.GameCenterFragment
 * JD-Core Version:    0.7.0.1
 */