package com.tencent.biz.pubaccount.readinjoy.activity;

import aars;
import adaa;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import bheg;
import bieo;
import bigl;
import biho;
import bihv;
import bmhv;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import osl;
import ude;
import uuc;

public class ReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment
  extends WebViewFragment
{
  public static final String a;
  public long a;
  public ImageView a;
  public boolean a;
  public long b;
  public String b;
  public boolean b;
  public long c;
  public long d;
  public long e;
  
  static
  {
    jdField_a_of_type_JavaLangString = ReadInJoyArticleDetailFragment.class.getSimpleName();
  }
  
  public ReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment()
  {
    this.jdField_b_of_type_JavaLangString = "-1";
  }
  
  private void b()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null)
    {
      localObject = (AppInterface)((AppRuntime)localObject).getAppRuntime("modular_web");
      if (localObject != null)
      {
        localObject = BaseApplicationImpl.getContext().getSharedPreferences("sp_public_account_with_cuin_" + ((AppInterface)localObject).getCurrentAccountUin(), 4);
        if (localObject != null)
        {
          this.jdField_a_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("readInJoy_loading_img", false);
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "showGif" + this.jdField_a_of_type_Boolean);
          }
        }
      }
    }
  }
  
  private void c()
  {
    int j = 2;
    long l1 = this.intent.getLongExtra("click_time", -1L);
    long l2 = this.intent.getLongExtra("available_memory", -1L);
    boolean bool = this.intent.getBooleanExtra("preload_tool_white_list", false);
    int i;
    if (this.mStatistics.w)
    {
      i = 2;
      if (i == 0) {
        break label103;
      }
      i = 1;
    }
    for (;;)
    {
      if (l1 > 0L) {
        ThreadManager.post(new ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.3(this, l2, l1, i, bool), 8, null, true);
      }
      return;
      if (bihv.s)
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      label103:
      i = j;
      if (!bihv.r) {
        i = 0;
      }
    }
  }
  
  @TargetApi(14)
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    ThreadManager.getUIHandler().post(new ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.2(this));
  }
  
  public bigl createComponentsProvider()
  {
    return new bigl(this, 127, new osl(this));
  }
  
  @TargetApi(12)
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    Bundle localBundle = this.intent.getExtras();
    Object localObject = localBundle.getString("url");
    String str = ude.a.a((String)localObject);
    localObject = str;
    if (uuc.f(str))
    {
      localObject = uuc.a(str);
      localBundle.putString("url", (String)localObject);
      this.intent.putExtra("url", (String)localObject);
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "doOnCreate url = " + (String)localObject);
    }
    try
    {
      bool = super.doOnCreate(paramBundle);
      paramBundle = localBundle.getString("preload_iamge_url");
      if (this.mPluginEngine != null)
      {
        localObject = (aars)this.mPluginEngine.a("pubAccountPreload");
        if ((localObject != null) && (!TextUtils.isEmpty(paramBundle))) {
          ((aars)localObject).a(paramBundle, true);
        }
      }
      b();
      return bool;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
        boolean bool = false;
      }
    }
  }
  
  public Object handlerMiscCallback(String paramString, Bundle paramBundle)
  {
    String str;
    if ((TextUtils.equals("netTimeConsumingReport", paramString)) && (paramBundle != null) && (paramBundle.containsKey("firstbyte"))) {
      str = paramBundle.getString("firstword");
    }
    try
    {
      if (!TextUtils.isEmpty(str)) {
        this.e = Long.parseLong(str);
      }
      return super.handlerMiscCallback(paramString, paramBundle);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[handlerMiscCallback] e = " + localNumberFormatException);
      }
    }
  }
  
  public void initTitleBar(Intent paramIntent, String paramString)
  {
    super.initTitleBar(paramIntent, paramString);
    if ((this.mSwiftTitleUI.leftView != null) && (this.mSwiftTitleUI.rightViewImg != null) && (this.mSwiftTitleUI.titleContainer != null))
    {
      if ((this.mUIStyleHandler.mUIStyle.isTransparentTitle) || (this.mUIStyle.isTransparentTitleAndClickable)) {
        break label94;
      }
      this.mSwiftTitleUI.rightViewImg.setImageResource(2130849530);
      this.mSwiftTitleUI.setConversationBtnColor(-16777216);
    }
    for (;;)
    {
      this.mSwiftTitleUI.rightViewImg.setVisibility(0);
      return;
      label94:
      paramIntent = bheg.a(getResources().getDrawable(2130849530), -1);
      this.mSwiftTitleUI.rightViewImg.setImageDrawable(paramIntent);
      this.mSwiftTitleUI.setConversationBtnColor(-1);
    }
  }
  
  public void initWebView()
  {
    super.initWebView();
    if (this.webView != null) {
      this.webView.setMask(false);
    }
    boolean bool = this.intent.getExtras().getBoolean("ip_connect", false);
    if ((this.webView != null) && (bool))
    {
      localIX5WebSettingsExtension = this.webView.getSettingsExtension();
      i = WebView.getTbsCoreVersion(BaseApplicationImpl.getContext());
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "tbsCoreVersion: " + i);
      }
      if ((localIX5WebSettingsExtension != null) && (i >= 36855))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "rij webview use ip connect");
        }
        localArrayList = new ArrayList();
        localArrayList.add("post.mp.qq.com");
        localArrayList.add("*.qpic.cn");
        localIX5WebSettingsExtension.setHttpDnsDomains(localArrayList);
      }
    }
    while (!QLog.isColorLevel())
    {
      IX5WebSettingsExtension localIX5WebSettingsExtension;
      int i;
      ArrayList localArrayList;
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "ipConnect: " + bool);
  }
  
  public void onDestroy()
  {
    if (!this.jdField_b_of_type_Boolean) {
      c();
    }
    super.onDestroy();
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    boolean bool = this.mStatistics.k;
    super.onPageFinished(paramWebView, paramString);
    if (bool)
    {
      this.d = System.currentTimeMillis();
      this.jdField_b_of_type_Boolean = true;
      paramWebView = BaseApplicationImpl.getApplication().getRuntime();
      if (paramWebView != null) {
        if (!bmhv.C(paramWebView)) {
          break label62;
        }
      }
    }
    label62:
    for (paramWebView = "1";; paramWebView = "0")
    {
      this.jdField_b_of_type_JavaLangString = paramWebView;
      c();
      return;
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    boolean bool = this.mStatistics.j;
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    if (bool) {
      this.c = System.currentTimeMillis();
    }
  }
  
  public void setRightButton(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener, adaa paramadaa)
  {
    this.mSwiftTitleUI.setRightButton(paramString1, paramString2, paramString3, paramBoolean, paramInt1, paramInt2, null, paramOnClickListener, paramadaa);
    if ((this.mSwiftTitleUI.leftView != null) && (this.mSwiftTitleUI.rightViewImg != null) && (this.mSwiftTitleUI.titleContainer != null) && (!paramBoolean) && (paramInt1 == 4))
    {
      if ((this.mUIStyleHandler.mUIStyle.isTransparentTitle) || (this.mUIStyle.isTransparentTitleAndClickable)) {
        break label130;
      }
      this.mSwiftTitleUI.rightViewImg.setImageResource(2130849530);
      this.mSwiftTitleUI.setConversationBtnColor(-16777216);
    }
    for (;;)
    {
      ((biho)this.mComponentsProvider.a(4)).d();
      this.mUIStyleHandler.updateScreenOrientation();
      return;
      label130:
      paramString1 = bheg.a(getResources().getDrawable(2130849530), -1);
      this.mSwiftTitleUI.rightViewImg.setImageDrawable(paramString1);
      this.mSwiftTitleUI.setConversationBtnColor(-1);
    }
  }
  
  public boolean showPreview()
  {
    boolean bool = super.showPreview();
    if ((this.mSwiftTitleUI != null) && (this.mSwiftTitleUI.leftView != null) && (this.mSwiftTitleUI.rightViewImg != null) && (this.mSwiftTitleUI.titleContainer != null))
    {
      this.mSwiftTitleUI.leftView.setBackgroundResource(2130849538);
      this.mSwiftTitleUI.rightViewImg.setImageResource(2130839433);
      if ((!this.mUIStyleHandler.mUIStyle.isTransparentTitle) && (!this.mUIStyle.isTransparentTitleAndClickable))
      {
        this.mSwiftTitleUI.titleContainer.setBackgroundResource(0);
        this.mSwiftTitleUI.titleContainer.setBackgroundColor(-1);
        if (this.mUIStyleHandler.mLoadingProgressBar != null) {
          this.mUIStyleHandler.mLoadingProgressBar.setCustomColor(-1);
        }
        if (this.mSystemBarComp != null)
        {
          this.mSystemBarComp.setBackgroundColor(-1);
          this.mUIStyle.mUsingCustomTitleBarColor = true;
        }
        this.mSwiftTitleUI.setTitleBarTextColor(-16777216);
        this.mSwiftTitleUI.setTitleBarButtonColor(-16777216);
        this.mSwiftTitleUI.leftView.setBackgroundResource(2130849537);
        this.mSwiftTitleUI.rightViewImg.setImageResource(2130849530);
        this.mSwiftTitleUI.rightViewImg.setVisibility(0);
      }
    }
    if (this.mNightMode)
    {
      View localView = new View(getActivity());
      localView.setBackgroundColor(1996488704);
      getActivity().addContentView(localView, new ViewGroup.LayoutParams(-1, -1));
    }
    return bool;
  }
  
  public void startLoadUrl()
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    super.startLoadUrl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment
 * JD-Core Version:    0.7.0.1
 */