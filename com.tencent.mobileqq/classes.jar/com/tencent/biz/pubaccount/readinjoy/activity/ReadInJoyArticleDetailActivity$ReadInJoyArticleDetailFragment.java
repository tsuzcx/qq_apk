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
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.PubAccountPreloadPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
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
import lbz;
import lca;
import lcc;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

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
  
  private void h()
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
  
  private void i()
  {
    int j = 2;
    long l1 = this.jdField_a_of_type_AndroidContentIntent.getLongExtra("click_time", -1L);
    long l2 = this.jdField_a_of_type_AndroidContentIntent.getLongExtra("available_memory", -1L);
    boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("preload_tool_white_list", false);
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.s)
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
        ThreadManager.post(new lcc(this, l2, l1, i, bool), 8, null, true);
      }
      return;
      if (SwiftBrowserStatistics.o)
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      label103:
      i = j;
      if (!SwiftBrowserStatistics.n) {
        i = 0;
      }
    }
  }
  
  public SwiftBrowserComponentsProvider a()
  {
    return new SwiftBrowserComponentsProvider(this, 127, new lbz(this));
  }
  
  public void a(Intent paramIntent, String paramString)
  {
    super.a(paramIntent, paramString);
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup != null))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.k)) {
        break label92;
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845299);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.c(-16777216);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
      label92:
      paramIntent = ImageUtil.a(getResources().getDrawable(2130845299), -1);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramIntent);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.c(-1);
    }
  }
  
  public void a(WebView paramWebView, String paramString)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.g;
    super.a(paramWebView, paramString);
    if (bool)
    {
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      this.jdField_b_of_type_Boolean = true;
      paramWebView = BaseApplicationImpl.getApplication().getRuntime();
      if (paramWebView != null) {
        if (!ReadInJoyHelper.q(paramWebView)) {
          break label61;
        }
      }
    }
    label61:
    for (paramWebView = "1";; paramWebView = "0")
    {
      this.jdField_b_of_type_JavaLangString = paramWebView;
      i();
      return;
    }
  }
  
  public void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.f;
    super.a(paramWebView, paramString, paramBitmap);
    if (bool) {
      this.c = System.currentTimeMillis();
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, JsBridgeListener paramJsBridgeListener, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a(paramString1, paramString2, paramString3, paramBoolean, paramInt1, paramInt2, paramJsBridgeListener, paramOnClickListener);
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup != null) && (!paramBoolean) && (paramInt1 == 4))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.k)) {
        break label127;
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845299);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.c(-16777216);
    }
    for (;;)
    {
      ((SwiftBrowserShareMenuHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(4)).d();
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.f();
      return;
      label127:
      paramString1 = ImageUtil.a(getResources().getDrawable(2130845299), -1);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString1);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.c(-1);
    }
  }
  
  public boolean a()
  {
    boolean bool = super.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130845306);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838566);
      if ((!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.k))
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(0);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(-1);
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar != null) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setCustomColor(-1);
        }
        if (this.jdField_d_of_type_AndroidViewView != null)
        {
          this.jdField_d_of_type_AndroidViewView.setBackgroundColor(-1);
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.g = true;
        }
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.d(-16777216);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.e(-16777216);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130845305);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845299);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    if (this.g)
    {
      View localView = new View(getActivity());
      localView.setBackgroundColor(1996488704);
      getActivity().addContentView(localView, new ViewGroup.LayoutParams(-1, -1));
    }
    return bool;
  }
  
  @TargetApi(12)
  public boolean a(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    Bundle localBundle = this.jdField_a_of_type_AndroidContentIntent.getExtras();
    String str = localBundle.getString("url");
    Object localObject = str;
    if (PublicAccountUtil.e(str))
    {
      localObject = PublicAccountUtil.a(str);
      localBundle.putString("url", (String)localObject);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("url", (String)localObject);
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "doOnCreate url = " + (String)localObject);
    }
    try
    {
      bool = super.a(paramBundle);
      paramBundle = localBundle.getString("preload_iamge_url");
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null)
      {
        localObject = (PubAccountPreloadPlugin)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a("pubAccountPreload");
        if ((localObject != null) && (!TextUtils.isEmpty(paramBundle))) {
          ((PubAccountPreloadPlugin)localObject).a(paramBundle, true);
        }
      }
      h();
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
  
  protected void e()
  {
    super.e();
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setMask(false);
    }
    boolean bool = this.jdField_a_of_type_AndroidContentIntent.getExtras().getBoolean("ip_connect", false);
    if ((this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) && (bool))
    {
      localIX5WebSettingsExtension = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getSettingsExtension();
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
  
  @TargetApi(14)
  public void f()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    ThreadManager.getUIHandler().post(new lca(this));
  }
  
  public void g()
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    super.g();
  }
  
  public void onDestroy()
  {
    if (!this.jdField_b_of_type_Boolean) {
      i();
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment
 * JD-Core Version:    0.7.0.1
 */