package com.tencent.biz.pubaccount.readinjoy.activity;

import absf;
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
import bdda;
import bebk;
import bedf;
import beei;
import beep;
import beey;
import befb;
import bjxj;
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
import nxz;
import syb;
import zak;

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
  
  private void i()
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
  
  private void j()
  {
    int j = 2;
    long l1 = this.jdField_a_of_type_AndroidContentIntent.getLongExtra("click_time", -1L);
    long l2 = this.jdField_a_of_type_AndroidContentIntent.getLongExtra("available_memory", -1L);
    boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("preload_tool_white_list", false);
    int i;
    if (this.jdField_a_of_type_Beep.w)
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
      if (beep.s)
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      label103:
      i = j;
      if (!beep.r) {
        i = 0;
      }
    }
  }
  
  public bedf a()
  {
    return new bedf(this, 127, new nxz(this));
  }
  
  public void a(Intent paramIntent, String paramString)
  {
    super.a(paramIntent, paramString);
    if ((this.jdField_a_of_type_Bebk.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_Bebk.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_Bebk.jdField_a_of_type_AndroidViewViewGroup != null))
    {
      if ((this.jdField_a_of_type_Beey.jdField_a_of_type_Befb.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Befb.m)) {
        break label92;
      }
      this.jdField_a_of_type_Bebk.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848917);
      this.jdField_a_of_type_Bebk.c(-16777216);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bebk.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
      label92:
      paramIntent = bdda.a(getResources().getDrawable(2130848917), -1);
      this.jdField_a_of_type_Bebk.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramIntent);
      this.jdField_a_of_type_Bebk.c(-1);
    }
  }
  
  public void a(WebView paramWebView, String paramString)
  {
    boolean bool = this.jdField_a_of_type_Beep.k;
    super.a(paramWebView, paramString);
    if (bool)
    {
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      this.jdField_b_of_type_Boolean = true;
      paramWebView = BaseApplicationImpl.getApplication().getRuntime();
      if (paramWebView != null) {
        if (!bjxj.A(paramWebView)) {
          break label61;
        }
      }
    }
    label61:
    for (paramWebView = "1";; paramWebView = "0")
    {
      this.jdField_b_of_type_JavaLangString = paramWebView;
      j();
      return;
    }
  }
  
  public void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    boolean bool = this.jdField_a_of_type_Beep.j;
    super.a(paramWebView, paramString, paramBitmap);
    if (bool) {
      this.c = System.currentTimeMillis();
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener, absf paramabsf)
  {
    this.jdField_a_of_type_Bebk.a(paramString1, paramString2, paramString3, paramBoolean, paramInt1, paramInt2, null, paramOnClickListener, paramabsf);
    if ((this.jdField_a_of_type_Bebk.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_Bebk.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_Bebk.jdField_a_of_type_AndroidViewViewGroup != null) && (!paramBoolean) && (paramInt1 == 4))
    {
      if ((this.jdField_a_of_type_Beey.jdField_a_of_type_Befb.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Befb.m)) {
        break label128;
      }
      this.jdField_a_of_type_Bebk.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848917);
      this.jdField_a_of_type_Bebk.c(-16777216);
    }
    for (;;)
    {
      ((beei)this.jdField_a_of_type_Bedf.a(4)).d();
      this.jdField_a_of_type_Beey.l();
      return;
      label128:
      paramString1 = bdda.a(getResources().getDrawable(2130848917), -1);
      this.jdField_a_of_type_Bebk.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString1);
      this.jdField_a_of_type_Bebk.c(-1);
    }
  }
  
  public boolean a()
  {
    boolean bool = super.a();
    if ((this.jdField_a_of_type_Bebk != null) && (this.jdField_a_of_type_Bebk.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_Bebk.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_Bebk.jdField_a_of_type_AndroidViewViewGroup != null))
    {
      this.jdField_a_of_type_Bebk.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130848926);
      this.jdField_a_of_type_Bebk.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839192);
      if ((!this.jdField_a_of_type_Beey.jdField_a_of_type_Befb.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Befb.m))
      {
        this.jdField_a_of_type_Bebk.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(0);
        this.jdField_a_of_type_Bebk.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(-1);
        if (this.jdField_a_of_type_Beey.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar != null) {
          this.jdField_a_of_type_Beey.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setCustomColor(-1);
        }
        if (this.jdField_d_of_type_AndroidViewView != null)
        {
          this.jdField_d_of_type_AndroidViewView.setBackgroundColor(-1);
          this.jdField_a_of_type_Befb.i = true;
        }
        this.jdField_a_of_type_Bebk.d(-16777216);
        this.jdField_a_of_type_Bebk.f(-16777216);
        this.jdField_a_of_type_Bebk.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130848925);
        this.jdField_a_of_type_Bebk.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848917);
        this.jdField_a_of_type_Bebk.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    if (this.h)
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
    if (syb.f(str))
    {
      localObject = syb.a(str);
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
        localObject = (zak)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a("pubAccountPreload");
        if ((localObject != null) && (!TextUtils.isEmpty(paramBundle))) {
          ((zak)localObject).a(paramBundle, true);
        }
      }
      i();
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
  
  public void e()
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
  
  public void g()
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    super.g();
  }
  
  public void onDestroy()
  {
    if (!this.jdField_b_of_type_Boolean) {
      j();
    }
    super.onDestroy();
  }
  
  @TargetApi(14)
  public void x_()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    ThreadManager.getUIHandler().post(new ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity.ReadInJoyArticleDetailFragment
 * JD-Core Version:    0.7.0.1
 */