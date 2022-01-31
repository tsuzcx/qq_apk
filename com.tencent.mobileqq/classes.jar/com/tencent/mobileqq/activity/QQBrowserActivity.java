package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.pubaccount.util.SwipeBackLayout;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.LeakInspector.ActivityLeakSolution;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.shortvideo.util.ShortVideoGuideUtil;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.WebViewTitleStyleHelper;
import com.tencent.mobileqq.webview.swift.SwiftWebViewFragmentSupporter;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewFragmentBuilder;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.mobileqq.webview.swift.WebviewFragmentTabBarBuilder;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderContext;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserNavigator;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.TbsAccelerator;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import tih;
import tii;
import tij;
import tik;

public class QQBrowserActivity
  extends FragmentActivity
  implements SwiftWebViewFragmentSupporter, SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderContext
{
  public static final HashSet a;
  public static int c;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public SwipeBackLayout a;
  public final SwiftBrowserComponentsProvider a;
  public Class a;
  public ArrayList a;
  public int b = -1;
  public int d;
  
  static
  {
    jdField_a_of_type_JavaUtilHashSet = AbsBaseWebViewActivity.jdField_a_of_type_JavaUtilHashSet;
  }
  
  public QQBrowserActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider = a();
  }
  
  public static WebViewFragment a(int paramInt, QQBrowserActivity paramQQBrowserActivity)
  {
    WebViewTabBarData localWebViewTabBarData = (WebViewTabBarData)paramQQBrowserActivity.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    WebViewFragment localWebViewFragment = paramQQBrowserActivity.a(localWebViewTabBarData);
    FragmentTransaction localFragmentTransaction = paramQQBrowserActivity.getSupportFragmentManager().beginTransaction();
    paramQQBrowserActivity.a(localFragmentTransaction);
    if (!localWebViewFragment.isAdded()) {
      localFragmentTransaction.add(2131362369, localWebViewFragment, localWebViewTabBarData.tag);
    }
    for (;;)
    {
      localFragmentTransaction.commitAllowingStateLoss();
      paramQQBrowserActivity.d = paramInt;
      return localWebViewFragment;
      localFragmentTransaction.show(localWebViewFragment);
    }
  }
  
  private void a(Intent paramIntent)
  {
    String str = SwiftWebViewUtils.a(paramIntent);
    WebAccelerateHelper.getInstance().preGetKey(str, paramIntent, null);
    WebAccelerateHelper.getInstance().preCheckOffline(str);
    WebAccelerateHelper.getInstance().preFetchResource(str);
  }
  
  public Activity a()
  {
    return this;
  }
  
  public WebViewFragment a()
  {
    return b();
  }
  
  public WebViewFragment a(Intent paramIntent)
  {
    Object localObject2;
    Object localObject1;
    if (this.jdField_a_of_type_JavaLangClass != null) {
      try
      {
        WebViewFragment localWebViewFragment1 = (WebViewFragment)this.jdField_a_of_type_JavaLangClass.newInstance();
        localObject2 = new Bundle();
        ((Bundle)localObject2).putParcelable("intent", paramIntent);
        localWebViewFragment1.setArguments((Bundle)localObject2);
        return localWebViewFragment1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localObject1 = new WebViewFragment();
        }
      }
    }
    if (!TextUtils.isEmpty(paramIntent.getStringExtra("fragment_class"))) {
      localObject1 = paramIntent.getStringExtra("fragment_class");
    }
    for (;;)
    {
      try
      {
        localObject1 = Class.forName((String)localObject1).newInstance();
        if (!(localObject1 instanceof WebViewFragment)) {
          break label199;
        }
        localObject2 = (WebViewFragment)localObject1;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        localObject1 = new WebViewFragment();
        break;
      }
      catch (InstantiationException localInstantiationException)
      {
        localInstantiationException.printStackTrace();
        if (0 != 0) {
          break label194;
        }
        WebViewFragment localWebViewFragment2 = new WebViewFragment();
        break;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
        if (0 != 0) {
          break label194;
        }
        WebViewFragment localWebViewFragment3 = new WebViewFragment();
        break;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        localClassNotFoundException.printStackTrace();
        if (0 != 0) {
          break label194;
        }
        localWebViewFragment4 = new WebViewFragment();
        break;
      }
      finally
      {
        if (0 == 0) {
          new WebViewFragment();
        }
      }
      WebViewFragment localWebViewFragment4 = new WebViewFragment();
      break;
      label194:
      localWebViewFragment4 = null;
      break;
      label199:
      localObject2 = null;
    }
  }
  
  public WebViewFragment a(WebViewTabBarData paramWebViewTabBarData)
  {
    if (paramWebViewTabBarData != null)
    {
      Object localObject2 = (WebViewFragment)super.getSupportFragmentManager().findFragmentByTag(paramWebViewTabBarData.tag);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = super.getIntent();
        long l = ((Intent)localObject2).getLongExtra("startOpenPageTime", -1L);
        if ((l == -1L) || (System.currentTimeMillis() - l > 5000L)) {
          ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
        }
        Intent localIntent = new Intent((Intent)localObject2);
        if (!TextUtils.isEmpty(((Intent)localObject2).getStringExtra("fragment_class"))) {
          ((Intent)localObject2).removeExtra("fragment_class");
        }
        localObject1 = WebViewFragmentBuilder.a(this, paramWebViewTabBarData, localIntent);
        a(localIntent);
        ((Intent)localObject2).removeExtra("startOpenPageTime");
        ((Intent)localObject2).removeExtra("qqBrowserActivityCreateTime");
        ((Intent)localObject2).removeExtra("reportSourceFrom");
      }
      return localObject1;
    }
    return null;
  }
  
  public SwiftBrowserComponentsProvider a()
  {
    return new SwiftBrowserComponentsProvider(this, 1, null);
  }
  
  public WebView a()
  {
    if (a() != null) {
      return a().a();
    }
    return null;
  }
  
  public void a(FragmentTransaction paramFragmentTransaction)
  {
    if (paramFragmentTransaction == null) {}
    for (;;)
    {
      return;
      Object localObject = super.getSupportFragmentManager();
      if (localObject != null)
      {
        localObject = ((FragmentManager)localObject).getFragments();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            Fragment localFragment = (Fragment)((Iterator)localObject).next();
            if (((localFragment instanceof WebViewFragment)) && (localFragment.isVisible())) {
              paramFragmentTransaction.hide(localFragment);
            }
          }
        }
      }
    }
  }
  
  public void a(WebView paramWebView, String paramString) {}
  
  public boolean a(Bundle paramBundle)
  {
    return super.doOnCreate(paramBundle);
  }
  
  public boolean a(boolean paramBoolean)
  {
    Object localObject;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (paramBoolean)
      {
        i = 0;
        ((View)localObject).setVisibility(i);
      }
    }
    else if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)
    {
      localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      if (!paramBoolean) {
        break label86;
      }
    }
    label86:
    for (int i = 54;; i = 0)
    {
      ((FrameLayout.LayoutParams)localObject).bottomMargin = ((int)(i * getResources().getDisplayMetrics().density + 0.5F));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return false;
      i = 8;
      break;
    }
  }
  
  public WebViewFragment b()
  {
    Object localObject = super.getSupportFragmentManager();
    if (localObject != null)
    {
      localObject = ((FragmentManager)localObject).getFragments();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Fragment localFragment = (Fragment)((Iterator)localObject).next();
          if (((localFragment instanceof WebViewFragment)) && (localFragment.isVisible())) {
            return (WebViewFragment)localFragment;
          }
        }
      }
    }
    return null;
  }
  
  public void b(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 1) && (this.jdField_a_of_type_AndroidViewView == null))
    {
      this.jdField_a_of_type_AndroidViewView = WebviewFragmentTabBarBuilder.a(this, super.getIntent(), this.jdField_a_of_type_JavaUtilArrayList, new tik(this));
      this.jdField_a_of_type_AndroidViewView.setId(2131364593);
      Object localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout.getParent();
      if (!(localObject instanceof FrameLayout)) {
        break label154;
      }
      if (!super.getIntent().getBooleanExtra("topTabSwitchFragment", false))
      {
        ((FrameLayout)localObject).addView(this.jdField_a_of_type_AndroidViewView, new FrameLayout.LayoutParams(-1, -2, 80));
        localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).bottomMargin = ((int)(54.0F * getResources().getDisplayMetrics().density + 0.5F));
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    return;
    label154:
    QLog.e("WebLog_QQBrowserActivity", 1, "doOnCreate error:should not enter here!");
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 4660)
    {
      super.setResult(4660);
      finish();
    }
    for (;;)
    {
      WebViewFragment localWebViewFragment = b();
      if (localWebViewFragment != null) {
        localWebViewFragment.a(paramInt1, paramInt2, paramIntent);
      }
      return;
      if ((paramInt2 == -1) && (paramInt1 == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebLog_QQBrowserActivity", 2, "upload shotphoto request");
        }
        ShortVideoGuideUtil.a(this);
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if ((Build.VERSION.SDK_INT > 10) && (!jdField_a_of_type_JavaUtilHashSet.contains(Build.MANUFACTURER + "_" + Build.MODEL))) {
      getWindow().addFlags(16777216);
    }
    getWindow().setFormat(-3);
    getWindow().setBackgroundDrawable(null);
    this.mNeedStatusTrans = false;
    SwiftWebAccelerator.TbsAccelerator.a = 0L;
    SwiftWebAccelerator.TbsAccelerator.b();
    Object localObject1 = new FrameLayout(this);
    super.doOnCreate(paramBundle);
    super.setContentView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      super.getActivity().getWindow().addFlags(67108864);
    }
    paramBundle = super.getIntent();
    Object localObject2 = paramBundle.getSerializableExtra("tabConfigData");
    if ((localObject2 instanceof ArrayList)) {
      this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject2);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      localObject2 = new WebViewTabBarData();
      ((WebViewTabBarData)localObject2).tag = "web";
      ((WebViewTabBarData)localObject2).url = paramBundle.getStringExtra("url");
      if (((WebViewTabBarData)localObject2).url == null)
      {
        ((WebViewTabBarData)localObject2).url = "";
        QLog.e("WebLog_QQBrowserActivity", 1, "url = null");
      }
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localObject1);
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 1) && (!(((FrameLayout)localObject1).getParent() instanceof FrameLayout)))
      {
        this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this);
        ((FrameLayout)localObject1).addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, new FrameLayout.LayoutParams(-1, -1));
        QLog.i("WebLog_QQBrowserActivity", 1, "doOnCreate warning:content is not an instance of FrameLayout.");
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setId(2131362369);
      paramBundle = (WebViewTabBarData)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      localObject1 = a(paramBundle);
      if (((WebViewFragment)localObject1).isAdded()) {
        break;
      }
      super.getSupportFragmentManager().beginTransaction().add(2131362369, (Fragment)localObject1, paramBundle.tag).commitAllowingStateLoss();
      return true;
      paramBundle.removeExtra("tabConfigData");
    }
    super.getSupportFragmentManager().beginTransaction().show((Fragment)localObject1).commitAllowingStateLoss();
    return true;
  }
  
  public void doOnDestroy()
  {
    c -= 1;
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)
    {
      ViewParent localViewParent = this.jdField_a_of_type_AndroidWidgetFrameLayout.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.jdField_a_of_type_AndroidViewView);
      }
      this.jdField_a_of_type_AndroidViewView = null;
    }
    ActivityLeakSolution.a(this);
    ActivityLeakSolution.c(this);
    try
    {
      super.doOnDestroy();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("WebLog_QQBrowserActivity", 1, localException, new Object[0]);
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    WebViewFragment localWebViewFragment = b();
    if (localWebViewFragment != null) {
      localWebViewFragment.a(paramInt, paramKeyEvent);
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    WebViewFragment localWebViewFragment = b();
    if (localWebViewFragment != null) {
      localWebViewFragment.a(paramIntent);
    }
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putBoolean("browserRestoreFlag", true);
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      localBundle.putInt("key_maintab", this.d);
    }
    super.doOnSaveInstanceState(localBundle);
  }
  
  protected void doOnUserLeaveHint()
  {
    Intent localIntent = new Intent("tencent.notify.background");
    localIntent.putExtra("selfuin", BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localIntent.putExtra("AccountInfoSync", "mobileqq.web");
    localIntent.putExtra("classname", getClass().getName());
    sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
    super.doOnUserLeaveHint();
  }
  
  public void finish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_QQBrowserActivity", 2, "finish");
    }
    WebViewFragment localWebViewFragment = b();
    if (localWebViewFragment != null) {
      localWebViewFragment.d();
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if ((localInputMethodManager != null) && (super.getCurrentFocus() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(super.getCurrentFocus().getWindowToken(), 0);
    }
    super.finish();
    if (getIntent().getBooleanExtra("finish_animation_up_down", false)) {
      overridePendingTransition(0, 2131034122);
    }
    if (getIntent().getBooleanExtra("finish_animation_out_to_right", false)) {
      overridePendingTransition(0, 2131034298);
    }
    if (getIntent().getBooleanExtra("finish_animation_out_to_top", false)) {
      overridePendingTransition(0, 2131034384);
    }
    if ((localWebViewFragment != null) && (localWebViewFragment.a != null))
    {
      if ((localWebViewFragment.a.d & 0x100) == 0L) {
        break label168;
      }
      overridePendingTransition(0, 0);
    }
    label168:
    while ((localWebViewFragment.a.d & 0x200) == 0L) {
      return;
    }
    overridePendingTransition(0, 2131034135);
  }
  
  public String getModuleId()
  {
    return "modular_web";
  }
  
  /* Error */
  public Object getSystemService(@android.support.annotation.NonNull String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 632
    //   5: aload_1
    //   6: invokevirtual 637	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9: ifeq +57 -> 66
    //   12: aconst_null
    //   13: astore_1
    //   14: aload_0
    //   15: invokevirtual 119	com/tencent/mobileqq/activity/QQBrowserActivity:b	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   18: astore_2
    //   19: aload_2
    //   20: ifnull +8 -> 28
    //   23: aload_2
    //   24: invokevirtual 639	com/tencent/mobileqq/webview/swift/WebViewFragment:a	()Ljava/lang/Object;
    //   27: astore_1
    //   28: aload_1
    //   29: astore_2
    //   30: aload_1
    //   31: ifnonnull +31 -> 62
    //   34: aload_0
    //   35: ldc_w 632
    //   38: invokespecial 640	android/support/v4/app/FragmentActivity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   41: astore_1
    //   42: aload_1
    //   43: astore_2
    //   44: invokestatic 366	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   47: ifeq +15 -> 62
    //   50: ldc_w 343
    //   53: iconst_2
    //   54: ldc_w 642
    //   57: invokestatic 370	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: aload_1
    //   61: astore_2
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_2
    //   65: areturn
    //   66: aload_0
    //   67: aload_1
    //   68: invokespecial 640	android/support/v4/app/FragmentActivity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   71: astore_2
    //   72: goto -10 -> 62
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	QQBrowserActivity
    //   0	80	1	paramString	String
    //   18	54	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	75	finally
    //   14	19	75	finally
    //   23	28	75	finally
    //   34	42	75	finally
    //   44	60	75	finally
    //   66	72	75	finally
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    WebViewFragment localWebViewFragment = b();
    if (localWebViewFragment != null) {
      localWebViewFragment.n();
    }
    return true;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    WebViewFragment localWebViewFragment = b();
    if (localWebViewFragment != null) {
      localWebViewFragment.a(paramConfiguration);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    c += 1;
    Intent localIntent = super.getIntent();
    SwiftBrowserNavigator localSwiftBrowserNavigator = (SwiftBrowserNavigator)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(1);
    if (localSwiftBrowserNavigator != null)
    {
      if (!localSwiftBrowserNavigator.a(localIntent))
      {
        QLog.e("WebLog_QQBrowserActivity", 1, "navigate to another activity!");
        super.onCreate(paramBundle);
        super.getActivity().finish();
        return;
      }
      if ((!localSwiftBrowserNavigator.b(localIntent)) && (QLog.isColorLevel())) {
        QLog.i("WebLog_QQBrowserActivity", 2, "switch to different fragment.");
      }
    }
    if (paramBundle != null)
    {
      if (paramBundle.getBoolean("browserRestoreFlag")) {
        localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      }
      int i = paramBundle.getInt("key_maintab", 0);
      if (i != 0) {
        localIntent.putExtra("key_maintab", i);
      }
    }
    localIntent.putExtra("qqBrowserActivityCreateTime", System.currentTimeMillis());
    SwiftWebAccelerator.a().a();
    SwiftWebAccelerator.b();
    if (!WebAccelerateHelper.isWebViewCache)
    {
      ThreadManager.postImmediately(new tih(this), null, false);
      if (InnerDns.b() == null) {
        ThreadManager.postImmediately(new tii(this), null, false);
      }
      if (!WebViewTitleStyleHelper.a().a) {
        ThreadManager.postImmediately(new tij(this), null, false);
      }
    }
    super.onCreate(paramBundle);
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    WebViewFragment localWebViewFragment = b();
    if (localWebViewFragment != null) {
      localWebViewFragment.w();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    WebViewFragment localWebViewFragment = b();
    if (localWebViewFragment != null) {
      localWebViewFragment.e(paramBoolean);
    }
  }
  
  protected void receiveScreenOff()
  {
    super.receiveScreenOff();
    if ((this.mCanLock) && (!TextUtils.isEmpty(BaseApplicationImpl.getApplication().getRuntime().getAccount())) && (GesturePWDUtils.getGesturePWDState(this, BaseApplicationImpl.getApplication().getRuntime().getAccount()) == 2) && (GesturePWDUtils.getGesturePWDMode(this, BaseApplicationImpl.getApplication().getRuntime().getAccount()) == 21)) {
      startUnlockActivity();
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    if (getWindow().getContainer() == null) {
      requestWindowFeature(7);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    WebViewFragment localWebViewFragment = b();
    if (localWebViewFragment != null) {
      localWebViewFragment.d(paramCharSequence.toString());
    }
    super.setTitle(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBrowserActivity
 * JD-Core Version:    0.7.0.1
 */