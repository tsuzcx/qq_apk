package com.tencent.gamecenter.activities;

import aahc;
import aahd;
import aahi;
import aahx;
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
import aslq;
import asls;
import asmr;
import beft;
import bflk;
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
import myl;
import nbv;
import zej;

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
  
  private void a(WebView paramWebView)
  {
    if (!aahi.b("gamecenter_shot_switch")) {
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
    aahx.a().b(paramWebView, localObject, new aahc(this, paramWebView));
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
              str3 = bflk.a(super.getActivity().getApplicationContext());
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
  
  private String d()
  {
    String str = "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=no_config&_wv=18950115&_wwv=393&plat=qq&_wv=5127";
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      str = "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=no_config&_wv=18950115&_wwv=393&plat=qq&_wv=5127" + "&" + this.jdField_c_of_type_JavaLangString;
    }
    return str + "&st=" + this.d;
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
  
  private void i()
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
          this.g = nbv.a(this.g, "uin=" + this.jdField_a_of_type_JavaLangString);
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
  
  public int a(Bundle paramBundle)
  {
    int i = super.a(paramBundle);
    if (this.jdField_a_of_type_Beft.b != null)
    {
      this.jdField_a_of_type_Beft.b.setVisibility(0);
      if ((this.jdField_a_of_type_Beft.b instanceof TextView)) {
        this.jdField_a_of_type_Beft.b.setText(2131690947);
      }
    }
    return i;
  }
  
  public String a()
  {
    return "gamecenter";
  }
  
  public void a()
  {
    int i = 0;
    super.a();
    if (myl.a().i(this.g)) {
      i();
    }
    if (d(this.jdField_b_of_type_JavaLangString))
    {
      Object localObject2 = getWebView().getX5WebViewExtension();
      if (localObject2 != null)
      {
        localObject1 = aslq.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        if ((((asls)localObject1).jdField_b_of_type_Long != 0L) && (((asls)localObject1).jdField_a_of_type_Long != ((asls)localObject1).jdField_b_of_type_Long))
        {
          if (!TextUtils.isEmpty(((asls)localObject1).jdField_a_of_type_JavaLangString))
          {
            ((IX5WebViewExtension)localObject2).updateServiceWorkerBackground(this.jdField_b_of_type_JavaLangString);
            localObject2 = nbv.a(((asls)localObject1).jdField_a_of_type_JavaLangString, "jump_url=" + this.g);
            this.g = ((String)localObject2);
            this.jdField_b_of_type_JavaLangString = ((String)localObject2);
            this.jdField_a_of_type_AndroidContentIntent.putExtra("url", this.g);
            QLog.e("GameCenterFragment", 1, new Object[] { "doCreateLoopStep_InitWebView: replace url with: ", this.g });
          }
          aslq.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, ((asls)localObject1).jdField_b_of_type_Long);
        }
      }
      Object localObject1 = aslq.a(getActivity().getIntent());
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
  
  public void a(WebView paramWebView, String paramString)
  {
    if ((this.jdField_b_of_type_Boolean) && (!this.i))
    {
      if ((this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) || (!this.jdField_a_of_type_ComTencentBizUiTouchWebView.canGoBack()) || (this.jdField_a_of_type_Beft.a == null)) {
        break label116;
      }
      this.jdField_a_of_type_Beft.a.setText(2131690382);
    }
    for (;;)
    {
      a(paramString);
      this.jdField_b_of_type_Boolean = false;
      if ((!TextUtils.isEmpty(paramString)) && (d(paramString)) && (aahx.a().a()))
      {
        aahx.a().a(paramWebView, new aahd(this));
        aahx.a().b();
      }
      super.a(paramWebView, paramString);
      return;
      label116:
      this.jdField_a_of_type_Beft.a(this.jdField_a_of_type_AndroidContentIntent);
    }
  }
  
  public void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if ((!this.jdField_c_of_type_Boolean) && (!TextUtils.isEmpty(paramString)) && (d(paramString)))
    {
      jdField_b_of_type_Long = System.currentTimeMillis();
      a(paramWebView);
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
      if ((localObject != null) && ((localObject instanceof zej)))
      {
        if (((zej)localObject).b == 0) {
          b("0");
        }
      }
      else
      {
        return;
        localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getPluginEngine();
        continue;
      }
      b(nbv.a(a(paramString)));
      return;
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  public boolean a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterFragment", 2, "game center fragment doOnCreate");
    }
    jdField_a_of_type_Int += 1;
    this.d = System.currentTimeMillis();
    if (this.jdField_a_of_type_AndroidContentIntent != null)
    {
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("url");
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("redTouch");
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        this.jdField_b_of_type_JavaLangString = d();
        this.jdField_a_of_type_AndroidContentIntent.putExtra("url", this.jdField_b_of_type_JavaLangString);
      }
      Object localObject;
      if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (d(this.jdField_b_of_type_JavaLangString)))
      {
        jdField_a_of_type_Long = this.jdField_a_of_type_AndroidContentIntent.getLongExtra("plugin_start_time", 0L);
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
      super.a(paramBundle);
      this.jdField_a_of_type_Boolean = false;
      return true;
      Toast.makeText(super.getActivity().getApplicationContext(), 2131690945, 0).show();
      super.getActivity().finish();
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
    asmr.a().a();
    System.gc();
    aahx.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gamecenter.activities.GameCenterActivity.GameCenterFragment
 * JD-Core Version:    0.7.0.1
 */