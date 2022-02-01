package com.tencent.biz.pubaccount.readinjoy.activity;

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
import com.tencent.biz.pubaccount.readinjoy.common.RIJSocialBottomUtils;
import com.tencent.biz.pubaccount.readinjoy.common.RIJSocialBottomUtils.Companion;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew.DoShareClick;
import com.tencent.biz.pubaccount.readinjoy.webarticle.RIJPageGenerator;
import com.tencent.biz.pubaccount.readinjoy.webarticle.RIJWebArticleOptimizeUtil;
import com.tencent.biz.pubaccount.readinjoy.webarticle.RIJWebArticleUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.PubAccountPreloadPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.sdk.WebView;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment
  extends WebViewFragment
{
  public static final String a;
  public long a;
  public ImageView a;
  ReadInJoyFastWebBottomSocialViewNew.DoShareClick a;
  public boolean a;
  public long b;
  public String b;
  public boolean b;
  public long c;
  private String c;
  public long d;
  private String d;
  public long e = 0L;
  
  static
  {
    jdField_a_of_type_JavaLangString = ReadInJoyArticleDetailFragment.class.getSimpleName();
  }
  
  public ReadInJoyArticleDetailActivity$ReadInJoyArticleDetailFragment()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_b_of_type_JavaLangString = "-1";
    this.jdField_b_of_type_Boolean = false;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew$DoShareClick = new ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.4(this);
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    do
    {
      boolean bool;
      do
      {
        return false;
        bool = RIJWebArticleUtil.a.i();
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[loadCacheHtml] webLoadUrlOptimize = " + bool);
      } while (!bool);
      str = RIJPageGenerator.a.a(paramString);
    } while (TextUtils.isEmpty(str));
    this.webView.loadDataWithBaseURL(paramString, str, "text/html", "utf-8", paramString);
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[loadCacheHtml] hit cache, url = " + paramString);
    return true;
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
      if (SwiftBrowserStatistics.s)
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      label103:
      i = j;
      if (!SwiftBrowserStatistics.r) {
        i = 0;
      }
    }
  }
  
  private void d()
  {
    if ((this.intent == null) || (this.intent.getExtras() == null)) {
      return;
    }
    Bundle localBundle = this.intent.getExtras();
    this.jdField_c_of_type_JavaLangString = localBundle.getString("row_key", "");
    this.jdField_d_of_type_JavaLangString = localBundle.getString("url");
    this.jdField_d_of_type_JavaLangString = RIJWebArticleOptimizeUtil.a.a(this.jdField_d_of_type_JavaLangString);
    if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isKandianNeedAddSkinParamsUrl(this.jdField_d_of_type_JavaLangString))
    {
      this.jdField_d_of_type_JavaLangString = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).addSkinParams(this.jdField_d_of_type_JavaLangString);
      localBundle.putString("url", this.jdField_d_of_type_JavaLangString);
      this.intent.putExtra("url", this.jdField_d_of_type_JavaLangString);
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[initData] url = " + this.jdField_d_of_type_JavaLangString);
  }
  
  private void e()
  {
    if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (RIJPageGenerator.a.a(this.jdField_c_of_type_JavaLangString)) && (this.mUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar != null)) {
      this.mUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setVisibility(8);
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
  
  public SwiftBrowserComponentsProvider createComponentsProvider()
  {
    return new SwiftBrowserComponentsProvider(this, 127, new ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.1(this));
  }
  
  public int doCreateLoopStep_InitUIContent(Bundle paramBundle)
  {
    int i = super.doCreateLoopStep_InitUIContent(paramBundle);
    e();
    return i;
  }
  
  @TargetApi(12)
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    d();
    Object localObject = this.intent.getExtras();
    try
    {
      bool = super.doOnCreate(paramBundle);
      paramBundle = ((Bundle)localObject).getString("preload_iamge_url");
      if (this.mPluginEngine != null)
      {
        localObject = (PubAccountPreloadPlugin)this.mPluginEngine.a("pubAccountPreload");
        if ((localObject != null) && (!TextUtils.isEmpty(paramBundle))) {
          ((PubAccountPreloadPlugin)localObject).a(paramBundle, true);
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
    if ((this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetTextView != null) && (this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView != null) && (this.mSwiftTitleUI.jdField_a_of_type_AndroidViewViewGroup != null))
    {
      if ((this.mUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_b_of_type_Boolean) || (this.mUIStyle.m)) {
        break label94;
      }
      this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849909);
      this.mSwiftTitleUI.c(-16777216);
    }
    for (;;)
    {
      this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
      label94:
      paramIntent = ImageUtil.a(getResources().getDrawable(2130849909), -1);
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
    RIJSocialBottomUtils.a.a();
    super.onDestroy();
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    boolean bool = this.mStatistics.k;
    super.onPageFinished(paramWebView, paramString);
    if (bool)
    {
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      this.jdField_b_of_type_Boolean = true;
      paramWebView = BaseApplicationImpl.getApplication().getRuntime();
      if (paramWebView != null) {
        if (!ReadInJoyHelper.C(paramWebView)) {
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
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[onPageStarted]");
    boolean bool = this.mStatistics.j;
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    if (bool) {
      this.jdField_c_of_type_Long = System.currentTimeMillis();
    }
    e();
    RIJSocialBottomUtils.a.a(false, this.jdField_d_of_type_JavaLangString, paramString);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
  
  public void setRightButton(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener, APICallback paramAPICallback)
  {
    this.mSwiftTitleUI.a(paramString1, paramString2, paramString3, paramBoolean, paramInt1, paramInt2, null, paramOnClickListener, paramAPICallback);
    if ((this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetTextView != null) && (this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView != null) && (this.mSwiftTitleUI.jdField_a_of_type_AndroidViewViewGroup != null) && (!paramBoolean) && (paramInt1 == 4))
    {
      if ((this.mUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_b_of_type_Boolean) || (this.mUIStyle.m)) {
        break label130;
      }
      this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849909);
      this.mSwiftTitleUI.c(-16777216);
    }
    for (;;)
    {
      ((SwiftBrowserShareMenuHandler)this.mComponentsProvider.a(4)).e();
      this.mUIStyleHandler.l();
      return;
      label130:
      paramString1 = ImageUtil.a(getResources().getDrawable(2130849909), -1);
      this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString1);
      this.mSwiftTitleUI.c(-1);
    }
  }
  
  public boolean showPreview()
  {
    boolean bool = super.showPreview();
    if ((this.mSwiftTitleUI != null) && (this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetTextView != null) && (this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView != null) && (this.mSwiftTitleUI.jdField_a_of_type_AndroidViewViewGroup != null))
    {
      this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130849916);
      this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849909);
      if ((!this.mUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_b_of_type_Boolean) && (!this.mUIStyle.m))
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
        this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130849916);
        this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849909);
        this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    if (this.mNightMode)
    {
      View localView = new View(getActivity());
      localView.setBackgroundColor(1996488704);
      getActivity().addContentView(localView, new ViewGroup.LayoutParams(-1, -1));
    }
    RIJSocialBottomUtils.a.a(this.intent.getExtras(), getActivity(), getContentView(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew$DoShareClick);
    return bool;
  }
  
  public void startLoadUrl()
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    if (!a(this.mUrl)) {
      super.startLoadUrl();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment
 * JD-Core Version:    0.7.0.1
 */