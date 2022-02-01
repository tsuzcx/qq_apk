package com.tencent.biz.pubaccount.readinjoy.activity;

import abbs;
import adea;
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
import bgmo;
import bhmv;
import bhos;
import bhpv;
import bhqc;
import bhql;
import bhqo;
import bmqa;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import ohu;
import tzo;

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
      if (bhqc.s)
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      label103:
      i = j;
      if (!bhqc.r) {
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
  
  public bhos createComponentsProvider()
  {
    return new bhos(this, 127, new ohu(this));
  }
  
  @TargetApi(12)
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    Bundle localBundle = this.intent.getExtras();
    String str = localBundle.getString("url");
    Object localObject = str;
    if (tzo.f(str))
    {
      localObject = tzo.a(str);
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
        localObject = (abbs)this.mPluginEngine.a("pubAccountPreload");
        if ((localObject != null) && (!TextUtils.isEmpty(paramBundle))) {
          ((abbs)localObject).a(paramBundle, true);
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
  
  public void initTitleBar(Intent paramIntent, String paramString)
  {
    super.initTitleBar(paramIntent, paramString);
    if ((this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetTextView != null) && (this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView != null) && (this.mSwiftTitleUI.jdField_a_of_type_AndroidViewViewGroup != null))
    {
      if ((this.mUIStyleHandler.jdField_a_of_type_Bhqo.jdField_b_of_type_Boolean) || (this.mUIStyle.m)) {
        break label94;
      }
      this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849518);
      this.mSwiftTitleUI.c(-16777216);
    }
    for (;;)
    {
      this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
      label94:
      paramIntent = bgmo.a(getResources().getDrawable(2130849518), -1);
      this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramIntent);
      this.mSwiftTitleUI.c(-1);
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
        if (!bmqa.B(paramWebView)) {
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
  
  public void setRightButton(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener, adea paramadea)
  {
    this.mSwiftTitleUI.a(paramString1, paramString2, paramString3, paramBoolean, paramInt1, paramInt2, null, paramOnClickListener, paramadea);
    if ((this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetTextView != null) && (this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView != null) && (this.mSwiftTitleUI.jdField_a_of_type_AndroidViewViewGroup != null) && (!paramBoolean) && (paramInt1 == 4))
    {
      if ((this.mUIStyleHandler.jdField_a_of_type_Bhqo.jdField_b_of_type_Boolean) || (this.mUIStyle.m)) {
        break label130;
      }
      this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849518);
      this.mSwiftTitleUI.c(-16777216);
    }
    for (;;)
    {
      ((bhpv)this.mComponentsProvider.a(4)).d();
      this.mUIStyleHandler.l();
      return;
      label130:
      paramString1 = bgmo.a(getResources().getDrawable(2130849518), -1);
      this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString1);
      this.mSwiftTitleUI.c(-1);
    }
  }
  
  public boolean showPreview()
  {
    boolean bool = super.showPreview();
    if ((this.mSwiftTitleUI != null) && (this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetTextView != null) && (this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView != null) && (this.mSwiftTitleUI.jdField_a_of_type_AndroidViewViewGroup != null))
    {
      this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130849527);
      this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839369);
      if ((!this.mUIStyleHandler.jdField_a_of_type_Bhqo.jdField_b_of_type_Boolean) && (!this.mUIStyle.m))
      {
        this.mSwiftTitleUI.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(0);
        this.mSwiftTitleUI.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(-1);
        if (this.mUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar != null) {
          this.mUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setCustomColor(-1);
        }
        if (this.mSystemBarComp != null)
        {
          this.mSystemBarComp.setBackgroundColor(-1);
          this.mUIStyle.i = true;
        }
        this.mSwiftTitleUI.d(-16777216);
        this.mSwiftTitleUI.f(-16777216);
        this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130849526);
        this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849518);
        this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
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