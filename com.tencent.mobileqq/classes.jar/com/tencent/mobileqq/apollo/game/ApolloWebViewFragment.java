package com.tencent.mobileqq.apollo.game;

import aktr;
import akul;
import akwd;
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
import azqs;
import beft;
import beiy;
import bejh;
import bidj;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import ndq;

public class ApolloWebViewFragment
  extends ApolloFragment
{
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  View.OnLayoutChangeListener jdField_a_of_type_AndroidViewView$OnLayoutChangeListener = new akul(this);
  public Runnable a;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  
  public ApolloWebViewFragment()
  {
    this.jdField_a_of_type_JavaLangRunnable = new ApolloWebViewFragment.2(this);
  }
  
  private boolean g()
  {
    try
    {
      Uri localUri = Uri.parse(b());
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
  
  private boolean h()
  {
    try
    {
      Object localObject = Uri.parse(b());
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
  
  private void i()
  {
    if (bidj.a(a()))
    {
      a().findViewById(16908290).addOnLayoutChangeListener(this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      paramBundle = a();
      if (paramBundle != null) {
        paramBundle.putExtra("Director", new WebGameFakeView.Director());
      }
      if (Build.VERSION.SDK_INT < 18) {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.clearView();
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl("about:blank");
  }
  
  public void a(WebView paramWebView, String paramString)
  {
    String str = paramWebView.getTitle();
    if (!TextUtils.isEmpty(str))
    {
      Object localObject = a().getSerializableExtra("Director");
      if ((localObject != null) && ((localObject instanceof WebGameFakeView.Director)))
      {
        localObject = (WebGameFakeView.Director)localObject;
        if (!str.equals(((WebGameFakeView.Director)localObject).title))
        {
          ((WebGameFakeView.Director)localObject).title = str;
          aktr.a().b();
        }
      }
    }
    super.a(paramWebView, paramString);
  }
  
  public void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.a(paramWebView, paramString, paramBitmap);
  }
  
  public void a(String paramString)
  {
    ndq.a("Web_readyToLoadUrl");
    if ((this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    a();
    if (Build.VERSION.SDK_INT < 18) {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.clearView();
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Beiy.i) && (this.jdField_a_of_type_Beiy.k > 0L))
      {
        azqs.b(null, "P_CliOper", "BizTechReport", "", "web", "plugin_start_time", 0, 1, (int)((System.nanoTime() - this.jdField_a_of_type_Beiy.k) / 1000000L), "", "", "", "" + this.jdField_a_of_type_Beiy.c);
        this.jdField_a_of_type_Beiy.k = 0L;
      }
      this.jdField_a_of_type_Beiy.q = System.currentTimeMillis();
      long l = this.jdField_a_of_type_Beiy.q;
      l = this.jdField_a_of_type_Beiy.b;
      this.g = paramString;
      if (!TextUtils.isEmpty(this.g)) {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(this.g);
      }
      ndq.b("Web_readyToLoadUrl");
      this.jdField_a_of_type_Beiy.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView, this.g, 0, 0, 0, 0, 0, null);
      return;
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl("about:blank");
    }
  }
  
  public boolean a()
  {
    boolean bool = h();
    if (!bool)
    {
      this.jdField_a_of_type_Bejh.jdField_a_of_type_Bejk.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Bejh.b = false;
      this.jdField_a_of_type_Bejh.jdField_a_of_type_Boolean = false;
    }
    if (!g()) {
      this.jdField_a_of_type_Bejk.c = 0L;
    }
    super.a();
    if (!bool) {
      this.jdField_a_of_type_Beft.b(false);
    }
    return true;
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
      String str2 = b();
      akwd.a(new Object[] { "[launchWebGame], success load url:", str1 });
      if ((TextUtils.isEmpty(str2)) || (str2.equals(str1))) {
        break label83;
      }
      a(str1);
    }
    for (;;)
    {
      super.b(paramBundle);
      return;
      label83:
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(str1);
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
  
  public int f(Bundle paramBundle)
  {
    ndq.a("Web_qqbrowser_state_machine_init_ui_frame");
    if (this.jdField_a_of_type_Bejh != null) {
      this.jdField_a_of_type_Bejh.d = true;
    }
    i();
    a();
    this.m = 128;
    ndq.b("Web_qqbrowser_state_machine_init_ui_frame");
    return 1;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Boolean) {
      a().findViewById(16908290).removeOnLayoutChangeListener(this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.requestFocus();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ApolloWebViewFragment", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloWebViewFragment
 * JD-Core Version:    0.7.0.1
 */