package com.tencent.mobileqq.apollo.game;

import ammx;
import amnr;
import ampj;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import bcst;
import bhmv;
import bhqc;
import bhql;
import bkqv;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import nmj;

public class ApolloWebViewFragment
  extends ApolloFragment
{
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  View.OnLayoutChangeListener jdField_a_of_type_AndroidViewView$OnLayoutChangeListener = new amnr(this);
  public Runnable a;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  
  public ApolloWebViewFragment()
  {
    this.jdField_a_of_type_JavaLangRunnable = new ApolloWebViewFragment.2(this);
  }
  
  private void a()
  {
    if (bkqv.a(getHostActivity()))
    {
      getHostActivity().findViewById(16908290).addOnLayoutChangeListener(this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  private boolean a()
  {
    try
    {
      Uri localUri = Uri.parse(getCurrentUrl());
      if (localUri.isHierarchical())
      {
        boolean bool = TextUtils.isEmpty(localUri.getQueryParameter("_fv"));
        if (!bool) {
          return true;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("ApolloWebViewFragment", 1, localException, new Object[0]);
    }
    return false;
  }
  
  private boolean b()
  {
    try
    {
      Object localObject = Uri.parse(getCurrentUrl());
      if (((Uri)localObject).isHierarchical())
      {
        String str = ((Uri)localObject).getQueryParameter("_wv");
        localObject = ((Uri)localObject).getQueryParameter("_wwv");
        if (TextUtils.isEmpty(str))
        {
          boolean bool = TextUtils.isEmpty((CharSequence)localObject);
          if (bool) {}
        }
        else
        {
          return true;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("ApolloWebViewFragment", 1, localException, new Object[0]);
    }
    return false;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.webView != null)
    {
      paramBundle = getIntent();
      if (paramBundle != null) {
        paramBundle.putExtra("Director", new WebGameFakeView.Director());
      }
      if (Build.VERSION.SDK_INT < 18) {
        this.webView.clearView();
      }
    }
    else
    {
      return;
    }
    this.webView.loadUrl("about:blank");
  }
  
  public void a(String paramString)
  {
    nmj.a("Web_readyToLoadUrl");
    if ((this.webView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    initFinish();
    if (Build.VERSION.SDK_INT < 18) {
      this.webView.clearView();
    }
    for (;;)
    {
      if ((this.mStatistics.i) && (this.mStatistics.k > 0L))
      {
        bcst.b(null, "P_CliOper", "BizTechReport", "", "web", "plugin_start_time", 0, 1, (int)((System.nanoTime() - this.mStatistics.k) / 1000000L), "", "", "", "" + this.mStatistics.c);
        this.mStatistics.k = 0L;
      }
      this.mStatistics.q = System.currentTimeMillis();
      long l = this.mStatistics.q;
      l = this.mStatistics.b;
      this.mUrl = paramString;
      if (!TextUtils.isEmpty(this.mUrl)) {
        this.webView.loadUrl(this.mUrl);
      }
      nmj.b("Web_readyToLoadUrl");
      this.mStatistics.a(this.webView, this.mUrl, 0, 0, 0, 0, 0, null);
      return;
      this.webView.loadUrl("about:blank");
    }
  }
  
  public void b(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloWebViewFragment", 2, "[onShow] ");
    }
    String str1;
    if (paramBundle != null)
    {
      paramBundle.getInt("id");
      str1 = paramBundle.getString("url");
      String str2 = getCurrentUrl();
      ampj.a(new Object[] { "[launchWebGame], success load url:", str1 });
      if ((TextUtils.isEmpty(str2)) || (str2.equals(str1))) {
        break label79;
      }
      a(str1);
    }
    for (;;)
    {
      super.b(paramBundle);
      return;
      label79:
      if (this.webView != null) {
        this.webView.loadUrl(str1);
      }
    }
  }
  
  public void c(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloWebViewFragment", 2, "[onForward] ");
    }
    if (paramBundle != null)
    {
      this.jdField_a_of_type_Int = paramBundle.getInt("id");
      ThreadManager.post(new ApolloWebViewFragment.3(this, paramBundle.getString("url")), 8, null, false);
    }
    super.c(paramBundle);
  }
  
  public int doCreateLoopStep_InitUIFrame(Bundle paramBundle)
  {
    nmj.a("Web_qqbrowser_state_machine_init_ui_frame");
    if (this.mUIStyleHandler != null) {
      this.mUIStyleHandler.d = true;
    }
    a();
    showPreview();
    this.mCreateLoopNextStep = 128;
    nmj.b("Web_qqbrowser_state_machine_init_ui_frame");
    return 1;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Boolean) {
      getHostActivity().findViewById(16908290).removeOnLayoutChangeListener(this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener);
    }
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    String str = paramWebView.getTitle();
    if (!TextUtils.isEmpty(str))
    {
      Object localObject = getIntent().getSerializableExtra("Director");
      if ((localObject != null) && ((localObject instanceof WebGameFakeView.Director)))
      {
        localObject = (WebGameFakeView.Director)localObject;
        if (!str.equals(((WebGameFakeView.Director)localObject).title))
        {
          ((WebGameFakeView.Director)localObject).title = str;
          ammx.a().b();
        }
      }
    }
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.webView != null) {}
    try
    {
      this.webView.requestFocus();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ApolloWebViewFragment", 1, localException, new Object[0]);
    }
  }
  
  public boolean showPreview()
  {
    boolean bool = b();
    if (!bool)
    {
      this.mUIStyleHandler.jdField_a_of_type_Bhqo.jdField_a_of_type_Boolean = true;
      this.mUIStyleHandler.b = false;
      this.mUIStyleHandler.jdField_a_of_type_Boolean = false;
    }
    if (!a()) {
      this.mUIStyle.c = 0L;
    }
    super.showPreview();
    if (!bool) {
      this.mSwiftTitleUI.b(false);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloWebViewFragment
 * JD-Core Version:    0.7.0.1
 */