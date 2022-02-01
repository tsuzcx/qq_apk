package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.SoftKeyboardObserver;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class UrlCheckPlugin
  extends WebViewPlugin
{
  public static int a = 0;
  public static int b = 1;
  public static int c = 2;
  public static int d = 3;
  WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams = null;
  WindowManager jdField_a_of_type_AndroidViewWindowManager = null;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  public SoftKeyboardObserver a;
  CustomWebView jdField_a_of_type_ComTencentBizPubaccountCustomWebView = null;
  QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = null;
  public Runnable a;
  boolean jdField_a_of_type_Boolean = false;
  public int e = jdField_a_of_type_Int;
  int f = 0;
  int g = 0;
  int h = 0;
  
  public UrlCheckPlugin()
  {
    this.jdField_a_of_type_JavaLangRunnable = new UrlCheckPlugin.4(this);
    this.mPluginNameSpace = "URL_CHECK";
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver == null) {
      this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver = new SoftKeyboardObserver(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView, new UrlCheckPlugin.2(this));
    }
  }
  
  public void a()
  {
    Object localObject = this.mRuntime.a();
    if ((localObject != null) && (!((Activity)localObject).isFinishing()) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.e == c))
    {
      localObject = ((Activity)localObject).getWindowManager();
      this.e = d;
      try
      {
        ((WindowManager)localObject).removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        if (QLog.isColorLevel())
        {
          String str = this.TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("removeView Error:");
          localStringBuilder.append(localIllegalArgumentException.getMessage());
          QLog.e(str, 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.mRuntime.a();
    if (!(localObject instanceof QBaseActivity)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = ((QBaseActivity)localObject);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getLayoutInflater().inflate(2131559002, null));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378963));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378959));
      this.jdField_a_of_type_AndroidViewWindowManager = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getWindowManager();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources();
    }
    try
    {
      i = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
    }
    catch (Exception localException2)
    {
      int i;
      label148:
      double d1;
      break label148;
    }
    d1 = ((Resources)localObject).getDisplayMetrics().density * 25.0F;
    Double.isNaN(d1);
    i = (int)(d1 + 0.5D);
    localObject = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
    ((WindowManager.LayoutParams)localObject).gravity = 49;
    ((WindowManager.LayoutParams)localObject).y = (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getTitleBarHeight() + i);
    localObject = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
    ((WindowManager.LayoutParams)localObject).type = 1002;
    ((WindowManager.LayoutParams)localObject).format = 1;
    ((WindowManager.LayoutParams)localObject).flags = 262664;
    ((WindowManager.LayoutParams)localObject).width = -1;
    ((WindowManager.LayoutParams)localObject).height = -2;
    localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener(new UrlCheckPlugin.3(this));
    }
    if (this.jdField_a_of_type_AndroidViewWindowManager == null) {
      this.jdField_a_of_type_AndroidViewWindowManager = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getWindowManager();
    }
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setText(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getText(paramInt));
    }
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.h + this.g);
    this.e = c;
    try
    {
      this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
      return;
    }
    catch (Exception localException1)
    {
      if (QLog.isColorLevel())
      {
        String str = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addView exception:");
        localStringBuilder.append(localException1.getMessage());
        QLog.e(str, 2, localStringBuilder.toString());
      }
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramInt3;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = this.mRuntime.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null) {
      return false;
    }
    paramString = this.mRuntime.a();
    if (!(paramString instanceof QBaseActivity)) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = ((QBaseActivity)paramString);
    b();
    if (paramLong == 8589934597L)
    {
      paramString = this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver;
      if (paramString != null)
      {
        paramString.a();
        this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver = null;
      }
      if (this.e == c)
      {
        paramString = this.jdField_a_of_type_AndroidWidgetImageView;
        if (paramString != null)
        {
          paramString.setOnClickListener(null);
          this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          a();
          return false;
        }
      }
    }
    else if ((paramLong == 8589934594L) && (this.f == 2) && (this.e != c))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.postDelayed(new UrlCheckPlugin.1(this), this.g);
    }
    return false;
  }
  
  protected void onDestroy()
  {
    SoftKeyboardObserver localSoftKeyboardObserver = this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver;
    if (localSoftKeyboardObserver != null)
    {
      localSoftKeyboardObserver.a();
      this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver = null;
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.UrlCheckPlugin
 * JD-Core Version:    0.7.0.1
 */