package com.tencent.mobileqq.activity;

import abvb;
import adpw;
import adpx;
import adpy;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
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
import aobw;
import aocf;
import aocl;
import aocr;
import aofm;
import azla;
import bazo;
import befg;
import beft;
import begc;
import begs;
import behm;
import beho;
import beht;
import beih;
import bejk;
import bejx;
import bejz;
import beka;
import bioq;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.lightGame.CmGameFragment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.swipeback.SwipePostTableLayout;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.IBrowserThirdAppReport;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import zfy;

public class QQBrowserActivity
  extends FragmentActivity
  implements aocf, begc, beht, IBrowserThirdAppReport
{
  public static final HashSet<String> a;
  public static int c;
  public static long d;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  protected aobw a;
  public final beho a;
  private ColorNote jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote;
  public Class<? extends WebViewFragment> a;
  public ArrayList<WebViewTabBarData> a;
  private boolean jdField_a_of_type_Boolean = true;
  public int b = -1;
  public int d;
  
  static
  {
    jdField_a_of_type_JavaUtilHashSet = AbsBaseWebViewActivity.jdField_a_of_type_JavaUtilHashSet;
  }
  
  public QQBrowserActivity()
  {
    this.jdField_a_of_type_Beho = a();
  }
  
  public static WebViewFragment a(int paramInt, QQBrowserActivity paramQQBrowserActivity)
  {
    WebViewTabBarData localWebViewTabBarData = (WebViewTabBarData)paramQQBrowserActivity.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    WebViewFragment localWebViewFragment = paramQQBrowserActivity.a(localWebViewTabBarData);
    FragmentTransaction localFragmentTransaction = paramQQBrowserActivity.getSupportFragmentManager().beginTransaction();
    paramQQBrowserActivity.a(localFragmentTransaction);
    if (!localWebViewFragment.isAdded()) {
      localFragmentTransaction.add(2131364785, localWebViewFragment, localWebViewTabBarData.tag);
    }
    for (;;)
    {
      localFragmentTransaction.commitAllowingStateLoss();
      paramQQBrowserActivity.jdField_d_of_type_Int = paramInt;
      return localWebViewFragment;
      localFragmentTransaction.show(localWebViewFragment);
    }
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_QQBrowserActivity", 2, "finish");
    }
    Object localObject = b();
    if (localObject != null) {
      ((WebViewFragment)localObject).d();
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if ((localInputMethodManager != null) && (a(this) != null)) {
      localInputMethodManager.hideSoftInputFromWindow(b(this).getWindowToken(), 0);
    }
    super.finish();
    if ((this.jdField_a_of_type_Aobw != null) && ((this.jdField_a_of_type_Aobw.c()) || (this.jdField_a_of_type_Aobw.d()))) {
      overridePendingTransition(0, 0);
    }
    if (getIntent().getBooleanExtra("finish_animation_up_down", false)) {
      overridePendingTransition(0, 2130771978);
    }
    if (getIntent().getBooleanExtra("finish_animation_out_to_right", false)) {
      overridePendingTransition(0, 2130772202);
    }
    if (getIntent().getBooleanExtra("finish_animation_out_to_top", false)) {
      overridePendingTransition(0, 2130772297);
    }
    if (getIntent().getBooleanExtra("finish_animation_none", false)) {
      overridePendingTransition(0, 0);
    }
    if ((localObject != null) && (((WebViewFragment)localObject).jdField_a_of_type_Bejk != null))
    {
      if ((((WebViewFragment)localObject).jdField_a_of_type_Bejk.jdField_d_of_type_Long & 0x100) == 0L) {
        break label257;
      }
      overridePendingTransition(0, 0);
    }
    for (;;)
    {
      if (getIntent().getBooleanExtra("from_risk_hint", false))
      {
        getIntent().removeExtra("from_risk_hint");
        localObject = new Intent(this, LoginInfoActivity.class);
        ((Intent)localObject).putExtra("from_risk_hint", true);
        startActivity((Intent)localObject);
      }
      return;
      label257:
      if ((((WebViewFragment)localObject).jdField_a_of_type_Bejk.jdField_d_of_type_Long & 0x200) != 0L) {
        overridePendingTransition(0, 2130772001);
      }
    }
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      if (paramInt == 16908288) {
        QLog.d("WebLog_QQBrowserActivity", 2, "QQBrowserActivity getColorNote,serviceType is ColorNoteConstants.ServiceType.WEB.");
      }
      if (paramInt == 16908292) {
        QLog.d("WebLog_QQBrowserActivity", 2, "QQBrowserActivity getColorNote,serviceType is ColorNoteConstants.ServiceType.BODONG.");
      }
    }
  }
  
  private void a(Intent paramIntent)
  {
    String str = beka.a(paramIntent);
    WebAccelerateHelper.getInstance().preGetKey(str, paramIntent, null);
    WebAccelerateHelper.getInstance().preCheckOffline(str);
    WebAccelerateHelper.getInstance().preFetchResource(str);
  }
  
  public static boolean a(long paramLong)
  {
    long l = System.currentTimeMillis();
    if (l - jdField_d_of_type_Long > paramLong)
    {
      jdField_d_of_type_Long = l;
      return true;
    }
    return false;
  }
  
  public static boolean b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        Object localObject = Uri.parse(paramString);
        paramString = ((Uri)localObject).getHost();
        localObject = ((Uri)localObject).getQueryParameter("useCMShowWebview");
        if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("qq.com")) && (!TextUtils.isEmpty((CharSequence)localObject)))
        {
          int i = Integer.parseInt((String)localObject);
          if (i == 1) {
            return true;
          }
        }
        return false;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return false;
      }
    }
    return false;
  }
  
  public Activity a()
  {
    return this;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public aobw a()
  {
    return this.jdField_a_of_type_Aobw;
  }
  
  public beho a()
  {
    return new beho(this, 1, null);
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
          break label202;
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
          break label197;
        }
        WebViewFragment localWebViewFragment2 = new WebViewFragment();
        break;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
        if (0 != 0) {
          break label197;
        }
        WebViewFragment localWebViewFragment3 = new WebViewFragment();
        break;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        localClassNotFoundException.printStackTrace();
        if (0 != 0) {
          break label197;
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
      label197:
      localWebViewFragment4 = null;
      break;
      label202:
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
        localObject1 = begs.a(this, paramWebViewTabBarData, localIntent);
        a(localIntent);
        ((Intent)localObject2).removeExtra("startOpenPageTime");
        ((Intent)localObject2).removeExtra("qqBrowserActivityCreateTime");
        ((Intent)localObject2).removeExtra("reportSourceFrom");
      }
      return localObject1;
    }
    return null;
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
  
  protected void a(SwipePostTableLayout paramSwipePostTableLayout)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_QQBrowserActivity", 2, "QQBrowserActivity initColorNote.");
    }
    int j = 1;
    int i = 1;
    if (!BaseApplicationImpl.getApplication().getRuntime().isLogin()) {
      j = 0;
    }
    if (aocr.d(getOriginalUrl())) {
      i = 0;
    }
    if ((aocr.a(getOriginalUrl())) || (TextUtils.isEmpty(getOriginalUrl()))) {
      i = 0;
    }
    if (j != 0) {
      if (i == 0) {
        break label162;
      }
    }
    label162:
    for (this.jdField_a_of_type_Aobw = new aobw(this, true, false, paramSwipePostTableLayout, true, true, false, 2131165479);; this.jdField_a_of_type_Aobw = new aobw(this, false, true, paramSwipePostTableLayout, true, true, false, 2131165479))
    {
      this.jdField_a_of_type_Aobw.a(this);
      this.jdField_a_of_type_Aobw.a(this);
      this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote = getColorNote();
      this.jdField_a_of_type_Aobw.a(new adpw(this));
      this.jdField_a_of_type_Aobw.a(new adpx(this));
      this.jdField_a_of_type_Aobw.a(getOriginalUrl());
      return;
    }
  }
  
  public void a(WebView paramWebView, String paramString) {}
  
  protected boolean a(Bundle paramBundle)
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
  
  protected void b(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i("WebLog_QQBrowserActivity", 2, String.format("doOnActivityResult resultCode=0x%x", new Object[] { Integer.valueOf(paramInt2) }));
    }
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
        azla.a(this);
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    beiy.B = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_QQBrowserActivity", 2, "doOnCreate start");
    }
    if ((Build.VERSION.SDK_INT > 10) && (!jdField_a_of_type_JavaUtilHashSet.contains(Build.MANUFACTURER + "_" + Build.MODEL))) {
      getWindow().addFlags(16777216);
    }
    getWindow().setFormat(-3);
    getWindow().setBackgroundDrawable(null);
    this.mNeedStatusTrans = false;
    bejz.a = 0L;
    bejz.b();
    Object localObject1 = new FrameLayout(this);
    super.doOnCreate(paramBundle);
    super.setContentView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      super.getActivity().getWindow().addFlags(67108864);
    }
    ImmersiveUtils.a(getWindow(), true);
    paramBundle = super.getIntent();
    if (!paramBundle.hasExtra("big_brother_source_key")) {
      paramBundle.putExtra("big_brother_source_key", "biz_src_general_url");
    }
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
      localObject2 = paramBundle.getExtras();
      if (localObject2 != null)
      {
        if (!b(beka.a(paramBundle))) {
          break label484;
        }
        this.jdField_a_of_type_JavaLangClass = CmGameFragment.class;
      }
      label326:
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localObject1);
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 1) && (!(((FrameLayout)localObject1).getParent() instanceof FrameLayout)))
      {
        this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this);
        ((FrameLayout)localObject1).addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, new FrameLayout.LayoutParams(-1, -1));
        QLog.i("WebLog_QQBrowserActivity", 1, "doOnCreate warning:content is not an instance of FrameLayout.");
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setId(2131364785);
      int i = paramBundle.getIntExtra("tabDefaultIndex", 0);
      localObject1 = (WebViewTabBarData)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      paramBundle.removeExtra("tabDefaultIndex");
      paramBundle = a((WebViewTabBarData)localObject1);
      if (paramBundle.isAdded()) {
        break label511;
      }
      super.getSupportFragmentManager().beginTransaction().add(2131364785, paramBundle, ((WebViewTabBarData)localObject1).tag).commitAllowingStateLoss();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean) {
        e();
      }
      return true;
      paramBundle.removeExtra("tabConfigData");
      break;
      label484:
      localObject2 = (Class)((Bundle)localObject2).getSerializable("fragmentClass");
      if (localObject2 == null) {
        break label326;
      }
      this.jdField_a_of_type_JavaLangClass = ((Class)localObject2);
      break label326;
      label511:
      super.getSupportFragmentManager().beginTransaction().show(paramBundle).commitAllowingStateLoss();
    }
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
    abvb.a(this);
    abvb.c(this);
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Aobw != null)) {
      this.jdField_a_of_type_Aobw.c();
    }
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
  
  public void doOnPause()
  {
    super.doOnPause();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Aobw != null))
    {
      this.jdField_a_of_type_Aobw.b();
      if (getIntent().getBooleanExtra("isFromFavourite", false)) {
        this.jdField_a_of_type_Aobw.q();
      }
    }
    if (aocr.b(getOriginalUrl()))
    {
      aofm.a(this, 2, true);
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_QQBrowserActivity", 2, "color note small screen visible by doOnPause");
      }
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Aobw != null)) {
      this.jdField_a_of_type_Aobw.a();
    }
    if (aocr.b(getOriginalUrl()))
    {
      aofm.a(this, 2, false);
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_QQBrowserActivity", 2, "color note small screen invisible by doOnResume");
      }
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
      localBundle.putInt("key_maintab", this.jdField_d_of_type_Int);
    }
    super.doOnSaveInstanceState(localBundle);
  }
  
  public void doOnUserLeaveHint()
  {
    Intent localIntent = new Intent("tencent.notify.background");
    localIntent.setPackage(MobileQQ.getContext().getPackageName());
    localIntent.putExtra("selfuin", BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localIntent.putExtra("AccountInfoSync", "mobileqq.web");
    localIntent.putExtra("classname", getClass().getName());
    sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
    super.doOnUserLeaveHint();
  }
  
  protected void e()
  {
    a(null);
  }
  
  public void f()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void finish()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Aobw != null))
    {
      this.jdField_a_of_type_Aobw.d();
      return;
    }
    a();
  }
  
  public void g()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public ColorNote getColorNote()
  {
    Object localObject4 = null;
    Object localObject8 = super.getIntent();
    Object localObject5 = b();
    Object localObject3 = "";
    Object localObject1;
    if (localObject5 != null)
    {
      localObject4 = ((WebViewFragment)localObject5).a();
      if (!TextUtils.isEmpty(((zfy)localObject4).b()))
      {
        localObject1 = ((zfy)localObject4).b();
        localObject3 = ((zfy)localObject4).c();
        localObject5 = ((zfy)localObject4).d();
        if (!TextUtils.isEmpty((CharSequence)localObject5)) {
          break label640;
        }
        localObject4 = aocr.a(getOriginalUrl());
        localObject5 = localObject3;
        localObject3 = localObject1;
        localObject1 = localObject5;
      }
    }
    for (;;)
    {
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote == null) || (!this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote.isTitleAndPicValid())) {
          break label211;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote.mMainTitle = ((String)localObject3);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote.mSubTitle = ((String)localObject1);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject4)) {
          this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote.mPicUrl = ((String)localObject4);
        }
        return this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote;
        localObject1 = localObject3;
        if (((WebViewFragment)localObject5).jdField_a_of_type_Beft == null) {
          break;
        }
        try
        {
          localObject1 = ((WebViewFragment)localObject5).jdField_a_of_type_Beft.a();
        }
        catch (Exception localException1)
        {
          QLog.e("WebLog_QQBrowserActivity", 2, "fragment.mSwiftTitleUI.getTitle()", localException1);
          localObject2 = localObject3;
        }
      }
      break;
      label211:
      localObject5 = a();
      JSONObject localJSONObject = new JSONObject();
      if (localObject5 != null) {}
      for (;;)
      {
        try
        {
          localJSONObject.put("key_scroll_y", ((WebView)localObject5).getWebScrollY());
          localObject5 = getOriginalUrl();
          localObject6 = localObject5;
          if (TextUtils.isEmpty((CharSequence)localObject5)) {
            localObject6 = ((Intent)localObject8).getStringExtra("subType");
          }
          if (localObject6 != null)
          {
            localObject5 = localObject6;
            if (!TextUtils.isEmpty((CharSequence)localObject6)) {}
          }
          else
          {
            localObject5 = "unregistered service sub type";
          }
          localObject6 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject2 = getOriginalUrl();
            try
            {
              localObject6 = new URL((String)localObject2);
              boolean bool = TextUtils.isEmpty(((URL)localObject6).getHost());
              if (!bool) {
                continue;
              }
            }
            catch (RuntimeException localRuntimeException)
            {
              int j;
              QLog.e("WebLog_QQBrowserActivity", 1, localRuntimeException, new Object[0]);
              continue;
            }
            catch (MalformedURLException localMalformedURLException)
            {
              QLog.e("WebLog_QQBrowserActivity", 1, localMalformedURLException, new Object[0]);
              continue;
            }
            catch (Exception localException2)
            {
              QLog.e("WebLog_QQBrowserActivity", 1, localException2, new Object[0]);
              localObject7 = localObject2;
            }
            localObject8 = getOriginalUrl();
            if (!bioq.a((String)localObject8)) {
              break label634;
            }
            j = 16908292;
            localObject6 = bioq.b(bioq.a(bioq.b((String)localObject8, "from", "1041001"), "from", "1041001"), "openFromColorTab", "1");
            i = j;
            localObject5 = localObject6;
            if (QLog.isColorLevel())
            {
              QLog.d("WebLog_QQBrowserActivity", 2, "isBoodoUlr,serviceType is ColorNoteConstants.ServiceType.BODONG, original url is " + (String)localObject8 + ", new url is " + (String)localObject6);
              localObject5 = localObject6;
              i = j;
            }
            a(i);
            if (this.jdField_a_of_type_Aobw == null) {
              continue;
            }
            localObject2 = this.jdField_a_of_type_Aobw.a(i, (String)localObject5, (String)localObject3, (String)localObject2, (String)localObject4, localJSONObject.toString().getBytes());
            this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote = ((ColorNote)localObject2);
            return localObject2;
          }
        }
        catch (JSONException localJSONException)
        {
          QLog.e("WebLog_QQBrowserActivity", 1, localJSONException, new Object[0]);
          continue;
          Object localObject6 = ((URL)localObject6).getHost();
          localObject2 = localObject6;
          continue;
          Object localObject7;
          localObject2 = localObject7;
          continue;
          localObject2 = new aocl().a(i).a(localJSONException).b((String)localObject3).c((String)localObject2).d((String)localObject4).a(localJSONObject.toString().getBytes()).a();
          this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote = ((ColorNote)localObject2);
          return localObject2;
        }
        label634:
        int i = 16908288;
      }
      label640:
      localObject4 = localObject2;
      Object localObject2 = localObject3;
      localObject3 = localObject4;
      localObject4 = localJSONException;
      continue;
      localObject3 = "";
      localObject2 = null;
    }
  }
  
  public String getCurrentUrl()
  {
    try
    {
      Object localObject = a();
      if (localObject != null)
      {
        localObject = ((WebView)localObject).getUrl();
        return localObject;
      }
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public String getModuleId()
  {
    return "modular_web";
  }
  
  public String getOriginalUrl()
  {
    String str = "";
    try
    {
      Intent localIntent = getIntent();
      if (localIntent != null) {
        str = localIntent.getStringExtra("url");
      }
      return str;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 1) && (this.jdField_a_of_type_AndroidViewView == null))
    {
      this.jdField_a_of_type_AndroidViewView = behm.a(this, super.getIntent(), this.jdField_a_of_type_JavaUtilArrayList, new adpy(this));
      this.jdField_a_of_type_AndroidViewView.setId(2131377349);
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
  
  public boolean isWrapContent()
  {
    boolean bool = false;
    if (getIntent().getBooleanExtra("is_wrap_content", false)) {
      bool = true;
    }
    return bool;
  }
  
  public boolean onBackEvent()
  {
    WebViewFragment localWebViewFragment = b();
    if (localWebViewFragment != null) {
      localWebViewFragment.f();
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
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_QQBrowserActivity", 2, "onCreate start");
    }
    c += 1;
    Intent localIntent = super.getIntent();
    beih localbeih = (beih)this.jdField_a_of_type_Beho.a(1);
    if (localbeih != null)
    {
      if (!localbeih.a(localIntent))
      {
        QLog.e("WebLog_QQBrowserActivity", 1, "navigate to another activity!");
        super.onCreate(paramBundle);
        super.getActivity().finish();
        return;
      }
      if ((!localbeih.b(localIntent)) && (QLog.isColorLevel())) {
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
    QLog.d("WebLog_QQBrowserActivity", 1, "onCreate createTime = " + System.currentTimeMillis());
    bejx.a().a();
    bejx.b();
    if (!WebAccelerateHelper.isWebViewCache)
    {
      ThreadManager.postImmediately(new QQBrowserActivity.1(this), null, false);
      if (bazo.b() == null) {
        ThreadManager.postImmediately(new QQBrowserActivity.2(this), null, false);
      }
      if (!befg.a().jdField_a_of_type_Boolean) {
        ThreadManager.postImmediately(new QQBrowserActivity.3(this), null, false);
      }
    }
    super.onCreate(paramBundle);
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    WebViewFragment localWebViewFragment = b();
    if (localWebViewFragment != null) {
      localWebViewFragment.h();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    WebViewFragment localWebViewFragment = b();
    if (localWebViewFragment != null) {
      localWebViewFragment.b(paramBoolean);
    }
  }
  
  public void receiveScreenOff()
  {
    super.receiveScreenOff();
    if ((this.mCanLock) && (!TextUtils.isEmpty(BaseApplicationImpl.getApplication().getRuntime().getAccount())) && (GesturePWDUtils.getGesturePWDState(this, BaseApplicationImpl.getApplication().getRuntime().getAccount()) == 2) && (GesturePWDUtils.getGesturePWDMode(this, BaseApplicationImpl.getApplication().getRuntime().getAccount()) == 21)) {
      startUnlockActivity();
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBrowserActivity
 * JD-Core Version:    0.7.0.1
 */