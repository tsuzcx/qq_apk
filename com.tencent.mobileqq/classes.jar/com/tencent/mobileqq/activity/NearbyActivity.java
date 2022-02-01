package com.tencent.mobileqq.activity;

import Override;
import aeiq;
import aeir;
import aeit;
import aeiu;
import aeiv;
import aeiw;
import aeix;
import aeiy;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anvx;
import anzr;
import anzs;
import aqeq;
import auyp;
import axns;
import axoc;
import axqa;
import axqc;
import axqk;
import axql;
import axut;
import axuu;
import aymi;
import aymp;
import aynv;
import ayqu;
import bdla;
import bdlf;
import bdmb;
import bdmc;
import bhbx;
import bhdj;
import bhhr;
import bidf;
import bifw;
import bifx;
import biko;
import biuc;
import bkys;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.dating.DatingFilters;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.fragment.BaseFragment;
import com.tencent.mobileqq.fragment.CommonTabFragment;
import com.tencent.mobileqq.fragment.HotChatFragment;
import com.tencent.mobileqq.fragment.NearbyBaseFragment;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.fragment.NowLiveFragment;
import com.tencent.mobileqq.freshnews.feed.NearbyImgLoader;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyTitleBarActivity;
import com.tencent.mobileqq.nearby.home.NearbyFragmentPagerAdapter;
import com.tencent.mobileqq.nearby.home.NearbyTabInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.widget.NonSwipeableViewPager;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NearbyActivity
  extends NearbyTitleBarActivity
  implements Handler.Callback, bifx, biko, biuc
{
  public static String a;
  int jdField_a_of_type_Int = -1;
  public long a;
  public Handler a;
  FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  ViewPager.OnPageChangeListener jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = new aeiu(this);
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public anzr a;
  protected anzs a;
  public axqk a;
  protected axuu a;
  NearbyFragmentPagerAdapter jdField_a_of_type_ComTencentMobileqqNearbyHomeNearbyFragmentPagerAdapter;
  RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  NonSwipeableViewPager jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager;
  public TabBarView a;
  public ArrayList<NearbyTabInfo> a;
  public List<View.OnClickListener> a;
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  public long b;
  public Handler b;
  boolean b;
  public int c;
  public long c;
  public boolean c;
  int d = 0;
  public long d;
  int e = -1;
  public long e;
  public int f = -1;
  public long f;
  int g;
  public long g;
  int h;
  public long h;
  protected final int i;
  public long i;
  protected final int j;
  public long j;
  public long k;
  public long l;
  public long m;
  public long n = 60000L;
  
  static
  {
    jdField_a_of_type_JavaLangString = "https://now.qq.com/qq/nearby/index.html?_wv=3&now_n_http=1&now_n_r=2&_proxy=1";
  }
  
  public NearbyActivity()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new bkys(Looper.getMainLooper(), this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_g_of_type_Int = 0;
    this.jdField_h_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_i_of_type_Int = 1000;
    this.jdField_j_of_type_Int = 1001;
    this.jdField_b_of_type_AndroidOsHandler = new Handler(new aeix(this));
    this.jdField_a_of_type_Axuu = new aeiy(this);
    this.jdField_a_of_type_Anzs = new aeir(this);
  }
  
  private int a(RedDotTextView paramRedDotTextView)
  {
    int i2 = 0;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a();
    if (!((axut)localObject).a()) {}
    do
    {
      return 0;
      localObject = ((axut)localObject).b();
    } while (localObject == null);
    int i1;
    if (((aymi)localObject).jdField_a_of_type_Int > 0)
    {
      i1 = i2;
      if (TextUtils.isEmpty(((aymi)localObject).jdField_a_of_type_JavaLangString)) {}
    }
    try
    {
      i1 = new JSONObject(((aymi)localObject).jdField_a_of_type_JavaLangString).optInt("is_follow", 0);
      if (paramRedDotTextView.getTag() == null) {
        new aymp().b("nearby_hongniang").c("tab_red_view").a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin()).g(String.valueOf(i1)).a();
      }
      paramRedDotTextView.setTag(Integer.valueOf(i1));
      return ((aymi)localObject).jdField_a_of_type_Int;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        i1 = i2;
      }
    }
  }
  
  @NonNull
  private Intent a()
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(new Bundle());
    setIntent(localIntent);
    return localIntent;
  }
  
  private NearbyTabInfo a()
  {
    if (c() > 0) {
      return (NearbyTabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(c());
    }
    return null;
  }
  
  public static RedTouch a(Context paramContext, TabBarView paramTabBarView, int paramInt1, int paramInt2)
  {
    paramInt1 = DisplayUtil.px2dip(paramContext, paramContext.getResources().getDisplayMetrics().widthPixels / paramInt1);
    return new RedTouch(paramContext, paramTabBarView.a(paramInt2)).b(53).e(4).d(paramInt1 / 2 - 8 - 20).a();
  }
  
  public static void a(Context paramContext, TabBarView paramTabBarView, ArrayList<NearbyTabInfo> paramArrayList)
  {
    paramTabBarView.setEnableRepeatedClick(true);
    paramTabBarView.setTabTextSize(16);
    paramTabBarView.setSelectColor(Color.parseColor("#00aced"));
    paramTabBarView.setUnselectColor(Color.parseColor("#777777"));
    paramTabBarView.setUnderLineHeight(DisplayUtil.dip2px(paramContext, 3.0F));
    paramTabBarView.setTabHeight(DisplayUtil.dip2px(paramContext, 45.0F));
    int i1 = paramArrayList.size();
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1);
    localLayoutParams.gravity = 17;
    localLayoutParams.width = (paramContext.getResources().getDisplayMetrics().widthPixels / i1);
    paramTabBarView.setTabLayoutParams(localLayoutParams);
    i1 = 0;
    while (i1 < paramArrayList.size())
    {
      paramContext = (NearbyTabInfo)paramArrayList.get(i1);
      paramTabBarView.a(paramContext.tabName);
      paramTabBarView.a(i1).a(paramContext.showRedRot);
      i1 += 1;
    }
  }
  
  public static void a(RedTouch paramRedTouch, int paramInt)
  {
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = null;
    if (paramInt == 0) {}
    for (;;)
    {
      paramRedTouch.a(localRedTypeInfo);
      return;
      if (paramInt == -1)
      {
        localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        localRedTypeInfo.red_type.set(0);
        localRedTypeInfo.red_content.set("");
      }
      else
      {
        Object localObject = String.valueOf(paramInt);
        if (paramInt > 99) {
          localObject = "99+";
        }
        localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        localRedTypeInfo.red_type.set(4);
        localRedTypeInfo.red_content.set((String)localObject);
        try
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("cn", "#ff0000");
          localRedTypeInfo.red_desc.set(((JSONObject)localObject).toString());
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  private void a(RedDotTextView paramRedDotTextView)
  {
    paramRedDotTextView.a(false);
    if (paramRedDotTextView.getTag() != null)
    {
      new aymp().b("nearby_hongniang").c("tab_red_clk").a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin()).g(String.valueOf(paramRedDotTextView.getTag())).a();
      paramRedDotTextView.setTag(null);
    }
  }
  
  private boolean b()
  {
    return (!ThemeUtil.isCustomTheme(false)) && (!ayqu.a()) && (ImmersiveUtils.isSupporImmersive() == 1) && (Build.VERSION.SDK_INT >= 23);
  }
  
  private void h()
  {
    if ((ayqu.a()) || (ThemeUtil.isCustomTheme(false)) || (ImmersiveUtils.isSupporImmersive() != 1)) {}
    View localView;
    do
    {
      return;
      localView = getTitleBarView();
    } while (!(localView instanceof NavBarCommon));
    ((NavBarCommon)localView).changeBg(true);
  }
  
  private void i()
  {
    QQCustomDialog localQQCustomDialog = bhdj.a(this, 0, null, "地理位置信息已清除", null, "确定", new aeit(this), null);
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.show();
  }
  
  private void j()
  {
    boolean bool = false;
    NearbyTabInfo localNearbyTabInfo = a();
    if ((localNearbyTabInfo != null) && (localNearbyTabInfo.tabType == 7)) {
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, this.n / 3L);
    }
    int i1;
    for (;;)
    {
      return;
      i1 = 0;
      while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localNearbyTabInfo = (NearbyTabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        if (localNearbyTabInfo.tabType == 7) {
          break label81;
        }
        i1 += 1;
      }
    }
    label81:
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, this.n / 3L);
    RedDotTextView localRedDotTextView = this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(i1);
    if (a(localRedDotTextView) > 0) {
      bool = true;
    }
    localNearbyTabInfo.showRedRot = bool;
    localRedDotTextView.a(localNearbyTabInfo.showRedRot);
  }
  
  public int a()
  {
    return 2131559529;
  }
  
  public int a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      NearbyTabInfo localNearbyTabInfo = (NearbyTabInfo)localIterator.next();
      if (localNearbyTabInfo.tabType == paramInt) {
        return localNearbyTabInfo.tabIndex;
      }
    }
    return 0;
  }
  
  public int a(ArrayList<NearbyTabInfo> paramArrayList)
  {
    paramArrayList.clear();
    Object localObject = (String)axqc.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "key_tabs_array", "");
    if (QLog.isColorLevel()) {
      QLog.d("nearby.NearbyActivity", 2, "initTabs:" + (String)localObject);
    }
    int i1 = -1;
    int i3;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      i3 = i1;
    }
    for (;;)
    {
      int i4;
      int i2;
      try
      {
        localObject = new JSONArray((String)localObject);
        i4 = 0;
        i2 = 0;
        i3 = i1;
        if (i4 < ((JSONArray)localObject).length())
        {
          i3 = i1;
          JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i4);
          i3 = i1;
          NearbyTabInfo localNearbyTabInfo = new NearbyTabInfo();
          i3 = i1;
          localNearbyTabInfo.tabName = localJSONObject.optString("tabName");
          i3 = i1;
          localNearbyTabInfo.tabIndex = localJSONObject.optInt("tabIndex");
          i3 = i1;
          localNearbyTabInfo.reportId = localJSONObject.optInt("reportId");
          i3 = i1;
          localNearbyTabInfo.tabUrl = localJSONObject.optString("tabUrl");
          i3 = i1;
          localNearbyTabInfo.tabType = localJSONObject.optInt("tabType");
          i3 = i1;
          localNearbyTabInfo.disableScroll = localJSONObject.optInt("disableScroll");
          i3 = i1;
          localNearbyTabInfo.needLoc = localJSONObject.optInt("needLoc");
          i3 = i1;
          localNearbyTabInfo.autoEnter = localJSONObject.optInt("autoEnter");
          i3 = i1;
          localNearbyTabInfo.showRedRot = localJSONObject.optBoolean("showRedRot");
          i3 = i1;
          if (TextUtils.isEmpty(localNearbyTabInfo.tabName)) {
            break label574;
          }
          i3 = i1;
          if (localNearbyTabInfo.tabName.length() > 4) {
            break label574;
          }
          i3 = i1;
          if (localNearbyTabInfo.tabType == 1) {
            break label591;
          }
          i3 = i1;
          paramArrayList.add(localNearbyTabInfo);
          i3 = i1;
          if (localNearbyTabInfo.tabType != 6) {
            break label571;
          }
          i3 = i1;
          i1 = localNearbyTabInfo.tabIndex;
          break label582;
        }
        i3 = i1;
        i4 = paramArrayList.size();
        if (i4 == 0) {
          continue;
        }
        if (i2 == 0) {}
      }
      catch (Exception localException1)
      {
        i4 = 1;
        i1 = i3;
        i2 = i4;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("nearby.NearbyActivity", 2, "initTabs exception:", localException1);
        i1 = i3;
        i2 = i4;
        continue;
        i2 = 1;
        continue;
      }
      try
      {
        if (!QLog.isColorLevel()) {
          break label596;
        }
        QLog.w("nearby.NearbyActivity", 2, "initTabs, isOldConfig=true, reset tabindex");
      }
      catch (Exception localException2)
      {
        i4 = 0;
        i3 = i1;
        continue;
      }
      if (i2 < paramArrayList.size())
      {
        ((NearbyTabInfo)paramArrayList.get(i2)).tabIndex = i2;
        i2 += 1;
      }
      else
      {
        i2 = 0;
        if (i2 != 0)
        {
          localObject = new NearbyTabInfo();
          ((NearbyTabInfo)localObject).tabName = anvx.a(2131706571);
          ((NearbyTabInfo)localObject).tabIndex = 0;
          ((NearbyTabInfo)localObject).tabUrl = "https://nearby.qq.com/nearby-index/index.html?_wv=1031&_proxy=1&_wwv=128";
          ((NearbyTabInfo)localObject).tabType = 5;
          paramArrayList.add(localObject);
          localObject = new NearbyTabInfo();
          ((NearbyTabInfo)localObject).tabName = anvx.a(2131706572);
          ((NearbyTabInfo)localObject).tabIndex = 1;
          ((NearbyTabInfo)localObject).tabUrl = "";
          ((NearbyTabInfo)localObject).tabType = 2;
          paramArrayList.add(localObject);
        }
        Collections.sort(paramArrayList);
        return i1;
        label571:
        break label582;
        label574:
        continue;
        i2 = 1;
        continue;
        label582:
        i4 += 1;
        continue;
        label591:
        i2 = 1;
        continue;
        label596:
        i2 = 0;
      }
    }
  }
  
  public bidf a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyHomeNearbyFragmentPagerAdapter != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyHomeNearbyFragmentPagerAdapter.a() != null) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyHomeNearbyFragmentPagerAdapter.a().a;
      }
    }
    return localObject1;
  }
  
  public HotChatFragment a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyHomeNearbyFragmentPagerAdapter.a();
  }
  
  public NearbyBaseFragment a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject1 = (NearbyTabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        localObject1 = (NearbyBaseFragment)this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag(((NearbyTabInfo)localObject1).getTabTag());
      }
    }
    return localObject1;
  }
  
  public NearbyHybridFragment a()
  {
    NearbyHybridFragment localNearbyHybridFragment = this.jdField_a_of_type_ComTencentMobileqqNearbyHomeNearbyFragmentPagerAdapter.a();
    int i1;
    if ((localNearbyHybridFragment == null) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      i1 = 0;
      if (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        Object localObject = (NearbyTabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        localObject = (NearbyBaseFragment)this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag(((NearbyTabInfo)localObject).getTabTag());
        if (QLog.isColorLevel()) {
          QLog.d("nearby.NearbyActivity", 2, "getNearbyHybridFragment is null, search:" + i1 + ", " + localObject);
        }
        if ((localObject instanceof NearbyHybridFragment))
        {
          localNearbyHybridFragment = (NearbyHybridFragment)localObject;
          this.jdField_a_of_type_ComTencentMobileqqNearbyHomeNearbyFragmentPagerAdapter.a(localNearbyHybridFragment);
        }
      }
    }
    for (;;)
    {
      if ((QLog.isColorLevel()) && (localNearbyHybridFragment == null)) {
        QLog.d("nearby.NearbyActivity", 2, "getNearbyHybridFragment is null");
      }
      return localNearbyHybridFragment;
      i1 += 1;
      break;
    }
  }
  
  public NowLiveFragment a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyHomeNearbyFragmentPagerAdapter.a();
  }
  
  public void a()
  {
    if (a() != null) {
      a().d();
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramOnClickListener);
  }
  
  public void a(auyp paramauyp)
  {
    if (paramauyp == null) {}
    Object localObject;
    do
    {
      return;
      localObject = a(NearbyBaseFragment.jdField_b_of_type_Int);
      if (QLog.isColorLevel()) {
        axql.a("nearby.NearbyActivity", new Object[] { "updateTitlebar", localObject, paramauyp.jdField_a_of_type_ComTencentMobileqqFragmentBaseFragment });
      }
    } while (localObject != paramauyp.jdField_a_of_type_ComTencentMobileqqFragmentBaseFragment);
    if (paramauyp.jdField_b_of_type_Boolean)
    {
      if (this.centerView.getVisibility() != 0) {
        this.centerView.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 8) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      if (!bhbx.a(paramauyp.jdField_a_of_type_JavaLangString, getTextTitle())) {
        setTitle(paramauyp.jdField_a_of_type_JavaLangString);
      }
      if (!paramauyp.jdField_a_of_type_Boolean) {
        break label412;
      }
      if (!isTitleProgressShowing()) {
        startTitleProgress();
      }
    }
    for (;;)
    {
      if (!paramauyp.jdField_c_of_type_Boolean) {
        break label427;
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramauyp.jdField_a_of_type_AndroidViewView$OnClickListener);
      if ((AppSetting.jdField_c_of_type_Boolean) && (paramauyp.e != null)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramauyp.e);
      }
      if (paramauyp.jdField_a_of_type_Int > 0) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramauyp.jdField_a_of_type_Int);
      }
      if (this.rightViewText.getVisibility() != 8) {
        this.rightViewText.setVisibility(8);
      }
      this.centerView.setClickable(true);
      this.centerView.setOnClickListener(new aeiv(this));
      return;
      if (this.centerView.getVisibility() != 4) {
        this.centerView.setVisibility(4);
      }
      if (!bhbx.a(paramauyp.jdField_a_of_type_JavaLangString, getTextTitle())) {
        setTitle(paramauyp.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      if (paramauyp.jdField_b_of_type_JavaLangString != null)
      {
        localObject = (TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379098);
        if (!bhbx.a(paramauyp.jdField_b_of_type_JavaLangString, ((TextView)localObject).getText())) {
          ((TextView)localObject).setText(paramauyp.jdField_b_of_type_JavaLangString);
        }
      }
      if (paramauyp.jdField_c_of_type_JavaLangString == null) {
        break;
      }
      localObject = (TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379031);
      if (bhbx.a(paramauyp.jdField_c_of_type_JavaLangString, ((TextView)localObject).getText())) {
        break;
      }
      ((TextView)localObject).setText(paramauyp.jdField_c_of_type_JavaLangString);
      break;
      label412:
      if (isTitleProgressShowing()) {
        stopTitleProgress();
      }
    }
    label427:
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 8) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (TextUtils.isEmpty(paramauyp.d)) {
      if (this.rightViewText.getVisibility() != 8) {
        this.rightViewText.setVisibility(8);
      }
    }
    for (;;)
    {
      if (!bhbx.a(paramauyp.d, this.rightViewText.getText())) {
        this.rightViewText.setText(paramauyp.d);
      }
      this.rightViewText.setOnClickListener(paramauyp.jdField_a_of_type_AndroidViewView$OnClickListener);
      break;
      if (this.rightViewText.getVisibility() != 0) {
        this.rightViewText.setVisibility(0);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    String str = AppConstants.NEARBY_LBS_HELLO_UIN;
    Intent localIntent = new Intent(this, MsgBoxListActivity.class);
    localIntent.putExtra("uin", str);
    localIntent.putExtra("uintype", 1001);
    localIntent.putExtra("isFromNearby", true);
    localIntent.putExtra("tabs", this.jdField_a_of_type_JavaUtilArrayList);
    localIntent.putExtra("msgTabIndex", this.jdField_c_of_type_Int);
    localIntent.putExtra("mUnReadMsgNum", this.jdField_h_of_type_Int);
    localIntent.putExtra("selfSet_leftViewText", anvx.a(2131706566));
    startActivityForResult(localIntent, 10001);
    if (paramBoolean) {
      overridePendingTransition(2130772233, 2130772233);
    }
    if (QLog.isColorLevel()) {
      QLog.d("nearby.msgbox.tab", 2, "startMsgBoxListActivity");
    }
    new bdlf(null).a("dc00899").b("grp_lbs").c("msg_box").d("page_exp").a();
  }
  
  public boolean a()
  {
    String str = Build.MANUFACTURER + "_" + Build.MODEL;
    return (Build.VERSION.SDK_INT > 10) && (!"Meizu_M040".equals(str));
  }
  
  public int b()
  {
    if ((ThemeUtil.getUserCurrentThemeId(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface).equals("1000")) && (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyActivity", 2, "default theme daymode,clear decorview background");
      }
      return 0;
    }
    return 2130838911;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager = ((NonSwipeableViewPager)findViewById(2131381319));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.requestParentDisallowInterecptTouchEvent(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.setOnPageChangeListener(this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.setPagingEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131378400));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this);
    a(this, this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView, this.jdField_a_of_type_JavaUtilArrayList);
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_c_of_type_Int >= 0) && (this.jdField_c_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = a(this, this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView, this.jdField_a_of_type_JavaUtilArrayList.size(), this.jdField_c_of_type_Int);
    }
    if (this.titleRoot != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.titleRoot.findViewById(2131376760).findViewById(2131369245));
      this.centerView = ((TextView)this.titleRoot.findViewById(2131369278));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.titleRoot.findViewById(2131379056));
    }
    c();
    int i4 = ((Integer)axqc.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin(), "key_auto_enter_without_redot", Integer.valueOf(0))).intValue();
    int i2 = 0;
    int i1 = -1;
    Object localObject;
    while (i2 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject = (NearbyTabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i2);
      if (((NearbyTabInfo)localObject).autoEnter == 1) {
        i1 = ((NearbyTabInfo)localObject).tabIndex;
      }
      i2 += 1;
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = getSupportFragmentManager();
    this.jdField_a_of_type_ComTencentMobileqqNearbyHomeNearbyFragmentPagerAdapter = new NearbyFragmentPagerAdapter(this.jdField_a_of_type_AndroidSupportV4AppFragmentManager, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqNearbyHomeNearbyFragmentPagerAdapter);
    i2 = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(5) != null) {
      i2 = a(5);
    }
    for (int i3 = 1;; i3 = 0)
    {
      if (i3 != 0)
      {
        if ((i4 != 1) || (i1 == -1)) {
          break label777;
        }
        i3 = i1;
        if (getIntent().hasExtra("TAB_TYPE")) {
          i3 = a(getIntent().getIntExtra("TAB_TYPE", 5));
        }
        QLog.d("nearby.NearbyActivity", 1, "tabIdx=" + i3 + ", tabs.size=" + this.jdField_a_of_type_JavaUtilArrayList.size());
        if (i3 >= 0)
        {
          i1 = i3;
          if (i3 < this.jdField_a_of_type_JavaUtilArrayList.size()) {}
        }
        else
        {
          i1 = 0;
        }
        NearbyBaseFragment.jdField_b_of_type_Int = i1;
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int = i1;
        i2 = ((NearbyTabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).tabIndex;
        if ((((NearbyTabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).autoEnter == 1) && (((NearbyTabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).tabUrl != null))
        {
          localObject = ((NearbyTabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).tabUrl;
          if (!((String)localObject).contains("?")) {
            break label782;
          }
          localObject = (String)localObject + "&open_way=nearby_auto";
          label568:
          ((NearbyTabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).tabUrl = ((String)localObject);
          if (QLog.isColorLevel()) {
            QLog.i("nearby.NearbyActivity", 2, "autoEnter url = " + (String)localObject);
          }
        }
        if (i2 < 0) {
          break label808;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(i2, false);
        if (QLog.isColorLevel()) {
          QLog.d("nearby.msgbox.tab", 2, "initViews, curIdx=" + i2 + ", msgTabBoxIdx=" + this.jdField_c_of_type_Int + ", tabs.size=" + this.jdField_a_of_type_JavaUtilArrayList.size());
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 1000L);
        this.jdField_b_of_type_Int = i2;
        if (QLog.isColorLevel()) {
          axql.a("MSG_INIT", new Object[] { Integer.valueOf(i1), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int), Integer.valueOf(NearbyBaseFragment.jdField_b_of_type_Int) });
        }
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 1000L);
        return;
        i3 = i1;
        if (i1 != -1) {
          break;
        }
        label777:
        i3 = i2;
        break;
        label782:
        localObject = (String)localObject + "?open_way=nearby_auto";
        break label568;
        label808:
        i2 = 0;
      }
    }
  }
  
  public int c()
  {
    return this.f;
  }
  
  void c()
  {
    setTitle(2131694218);
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("abp_flag", this.jdField_b_of_type_Boolean);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("FROM_WHERE", this.jdField_a_of_type_Int);
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Int == 0))
    {
      setLeftViewName(2131719164);
      return;
    }
    if (this.jdField_a_of_type_Int == 1003)
    {
      setLeftViewName(2131693029);
      return;
    }
    if (this.jdField_a_of_type_Int == 1004)
    {
      setLeftViewName(2131689550);
      return;
    }
    if (this.jdField_a_of_type_Int == 1002)
    {
      setLeftViewName(2131689531);
      return;
    }
    setLeftViewName(getIntent());
  }
  
  public void d()
  {
    this.jdField_a_of_type_Anzr.b();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("nearby.NearbyActivity", 2, "NearbyActivity->doOnActivityResult, reqCode=" + paramInt1);
    }
    if (paramInt1 == 10002)
    {
      paramIntent = new Intent(this, QQBrowserActivity.class);
      paramIntent.putExtra("url", "https://nearby.qq.com/nearby-index/my_msg.html?_wv=1031&_bid=3027");
      startActivity(paramIntent);
      overridePendingTransition(2130771988, 2130771989);
    }
    Object localObject;
    HashMap localHashMap;
    do
    {
      do
      {
        return;
        if ((paramInt1 == 1000) || (paramInt1 == 1001)) {
          aynv.a(this, paramInt1, paramInt2, paramIntent);
        }
        if (paramInt1 != 10001) {
          break;
        }
      } while (paramInt2 != -1);
      paramInt1 = paramIntent.getIntExtra("curIndex", -1);
      paramInt2 = paramIntent.getIntExtra("unReadMsgNum", 0);
      boolean bool = paramIntent.getBooleanExtra("isNeedFinish", false);
      if (QLog.isColorLevel()) {
        QLog.d("nearby.msgbox.tab", 2, "index=" + paramInt1 + ", unReadMsgNum=" + paramInt2 + ", isNeedFinish=" + bool);
      }
      if (bool) {
        super.finish();
      }
      for (;;)
      {
        this.jdField_h_of_type_Int = paramInt2;
        a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, paramInt2);
        return;
        if ((paramInt1 >= 0) && (paramInt1 < this.jdField_a_of_type_JavaUtilArrayList.size())) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(paramInt1, false);
        }
      }
      localObject = a(this.jdField_b_of_type_Int);
      if (!(localObject instanceof CommonTabFragment)) {
        break;
      }
      localObject = (CommonTabFragment)localObject;
      localHashMap = new HashMap();
      localHashMap.put("requestCode", Integer.valueOf(paramInt1));
      localHashMap.put("resultCode", Integer.valueOf(paramInt2));
      localHashMap.put("data", paramIntent);
    } while (((CommonTabFragment)localObject).a(8589934600L, localHashMap, paramInt2, paramInt1, paramIntent));
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    long l1 = System.currentTimeMillis();
    axns.a();
    this.jdField_c_of_type_Int = a(this.jdField_a_of_type_JavaUtilArrayList);
    setImmersiveStatus(-1);
    boolean bool = super.doOnCreate(paramBundle);
    h();
    if (getIntent().getBooleanExtra("key_from_location", false))
    {
      finish();
      return true;
    }
    try
    {
      bdla.b(null, "dc00899", "grp_lbs", "", "entry", "open_nearby_act_total_tmp", 0, 0, Build.MODEL, Build.VERSION.SDK, "", "");
      label88:
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface == null)
      {
        finish();
        QLog.e("nearby.NearbyActivity", 1, "doOnCreate app==null, goto finish");
        return false;
      }
      this.jdField_a_of_type_Anzr = ((anzr)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(axoc.jdField_c_of_type_Int));
      Object localObject1 = getIntent();
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = a();
      }
      paramBundle.setExtrasClassLoader(DatingFilters.class.getClassLoader());
      if (TextUtils.isEmpty(paramBundle.getStringExtra("big_brother_source_key"))) {
        paramBundle.putExtra("big_brother_source_key", "biz_src_hdsp_nearby");
      }
      localObject1 = null;
      if (paramBundle == null) {
        localObject1 = null;
      }
      for (;;)
      {
        Object localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = bhhr.e(this, this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin());
        }
        if (bhbx.a(localObject2, bhhr.e(this, this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin()))) {
          break;
        }
        this.jdField_a_of_type_Int = 1;
        paramBundle = new Intent(this, QQBrowserActivity.class);
        paramBundle.putExtra("url", URLUtil.guessUrl((String)localObject2));
        startActivity(paramBundle);
        finish();
        return bool;
        try
        {
          localObject2 = paramBundle.getStringExtra("url");
          localObject1 = localObject2;
        }
        catch (Throwable paramBundle)
        {
          if (QLog.isColorLevel()) {
            QLog.i("nearby.NearbyActivity", 2, paramBundle.getMessage(), paramBundle);
          }
          paramBundle = a();
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size()) {}
      for (int i1 = ((NearbyTabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int)).tabType;; i1 = 5)
      {
        i1 = paramBundle.getIntExtra("TAB_TYPE", i1);
        if (i1 == 3)
        {
          this.jdField_h_of_type_Long = paramBundle.getLongExtra("ENTER_TIME", l1);
          this.jdField_g_of_type_Long = l1;
          if (QLog.isDevelopLevel()) {
            axql.a("WebSpeedTrace", "mClickTime", new Object[] { "doOnCreate", Long.valueOf(this.jdField_h_of_type_Long) });
          }
        }
        if (i1 == 2)
        {
          this.jdField_a_of_type_Long = paramBundle.getLongExtra("ENTER_TIME", l1);
          this.jdField_b_of_type_Long = l1;
          if (QLog.isDevelopLevel()) {
            axql.a("WebSpeedTrace", "mClickTime", new Object[] { "doOnCreate", Long.valueOf(this.jdField_h_of_type_Long) });
          }
        }
        this.jdField_a_of_type_Axqk = new axqk(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "grp_lbs", "basic", "visit_time");
        this.jdField_a_of_type_Axqk.a();
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.addObserver(this.jdField_a_of_type_Anzs);
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(this.jdField_a_of_type_Axuu);
        d();
        if ((Build.VERSION.SDK_INT >= 23) && (checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)) {
          requestPermissions(new aeiq(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
        }
        return bool;
      }
    }
    catch (Exception paramBundle)
    {
      break label88;
    }
  }
  
  public void doOnDestroy()
  {
    try
    {
      super.doOnDestroy();
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface == null) {
        return;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          localException1.printStackTrace();
        }
      }
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      Object localObject = (axqa)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(axoc.m);
      if (localObject != null)
      {
        ((axqa)localObject).a();
        ((axqa)localObject).jdField_a_of_type_Boolean = true;
      }
      localObject = bdmb.a(getClass(), hashCode());
      if (localObject != null)
      {
        long l1 = SystemClock.elapsedRealtime();
        long l2 = ((bdmc)localObject).jdField_b_of_type_Long;
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "", "", ((bdmc)localObject).jdField_a_of_type_JavaLangString, ((bdmc)localObject).jdField_a_of_type_JavaLangString, ((bdmc)localObject).jdField_a_of_type_Int, 0, Long.toString(l1 - l2), "", "", "");
      }
    }
    try
    {
      int i1 = getIntent().getIntExtra("FROM_WHERE", -1);
      if (i1 != 0) {}
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        localException2.printStackTrace();
      }
    }
    NearbyImgLoader.a().b();
    if (this.jdField_a_of_type_Axqk != null)
    {
      this.jdField_a_of_type_Axqk.a(this.f, this.f);
      this.jdField_a_of_type_Axqk.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b(this.jdField_a_of_type_Axuu);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.removeObserver(this.jdField_a_of_type_Anzs);
    f();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    c();
    if (paramIntent.getBooleanExtra("key_from_location", false))
    {
      i();
      return;
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int;
    if (i1 >= 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(i1, false);
      if (QLog.isColorLevel()) {
        QLog.i("nearby.NearbyActivity", 2, "doOnNewIntent setSelectedTab:" + i1);
      }
    }
    aynv.a(this, 1000, -1, paramIntent);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_c_of_type_Boolean) {}
    for (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int = this.jdField_b_of_type_Int;; this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int = 0)
    {
      if (QLog.isDevelopLevel()) {
        axql.a("Q.nearby", "doOnPause", new Object[] { Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_c_of_type_Boolean), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int) });
      }
      ((aqeq)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER)).b();
      NearbyBaseFragment localNearbyBaseFragment = a(this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.getCurrentItem());
      if ((localNearbyBaseFragment instanceof NearbyHybridFragment))
      {
        ((NearbyHybridFragment)localNearbyBaseFragment).i();
        ((NearbyHybridFragment)localNearbyBaseFragment).s();
      }
      return;
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    NearbyBaseFragment localNearbyBaseFragment = a(this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.getCurrentItem());
    if ((localNearbyBaseFragment instanceof NearbyHybridFragment)) {
      ((NearbyHybridFragment)localNearbyBaseFragment).h();
    }
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("nearby.NearbyActivity", 2, "doOnSaveInstanceState");
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
    }
  }
  
  public void e()
  {
    SosoInterface.SosoLbsInfo localSosoLbsInfo = SosoInterface.getSosoInfo();
    if (localSosoLbsInfo == null)
    {
      SosoInterface.startLocation(new aeiw(this, "NearbyProtocolCoder.Encounter"));
      return;
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Anzr.a(1, localSosoLbsInfo);
  }
  
  public void f()
  {
    this.jdField_a_of_type_Anzr.a(2, null);
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void finish()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if ((localInputMethodManager != null) && (getCurrentFocus() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
    super.finish();
    if (this.jdField_b_of_type_Boolean) {
      overridePendingTransition(2130771988, 2130771989);
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Anzr.a(3, null);
  }
  
  public long getDetect302Time()
  {
    return 0L;
  }
  
  public boolean getIsReloadUrl()
  {
    bidf localbidf = a();
    if (localbidf == null) {}
    for (boolean bool = false;; bool = localbidf.getIsReloadUrl())
    {
      if (QLog.isDevelopLevel()) {
        axql.a("WebSpeedTrace", "getIsReloadUrl", new Object[] { Boolean.valueOf(bool) });
      }
      return bool;
    }
  }
  
  public long getOpenUrlAfterCheckOfflineTime()
  {
    bidf localbidf = a();
    if (localbidf == null) {}
    for (long l1 = 0L;; l1 = localbidf.getOpenUrlAfterCheckOfflineTime())
    {
      if (QLog.isDevelopLevel()) {
        axql.a("WebSpeedTrace", "getOpenUrlAfterCheckOfflineTime", new Object[] { Long.valueOf(l1) });
      }
      return l1;
    }
  }
  
  public long getReadIndexFromOfflineTime()
  {
    bidf localbidf = a();
    if (localbidf == null) {}
    for (long l1 = 0L;; l1 = localbidf.getReadIndexFromOfflineTime())
    {
      if (QLog.isDevelopLevel()) {
        axql.a("WebSpeedTrace", "getReadIndexFromOfflineTime", new Object[] { Long.valueOf(l1) });
      }
      return l1;
    }
  }
  
  public JSONObject getX5Performance()
  {
    bidf localbidf = a();
    if (localbidf != null) {
      return localbidf.mX5PerformanceJson;
    }
    return null;
  }
  
  public long getgetWebViewTime()
  {
    if (QLog.isDevelopLevel()) {
      axql.a("WebSpeedTrace", "getgetWebViewTime", new Object[] { Long.valueOf(this.k) });
    }
    return this.k;
  }
  
  public long getinitBrowserTime()
  {
    if (QLog.isDevelopLevel()) {
      axql.a("WebSpeedTrace", "getinitBrowserTime", new Object[] { Long.valueOf(this.m) });
    }
    return this.m;
  }
  
  public long getinitTBSTime()
  {
    return 0L;
  }
  
  public long getinitTime()
  {
    if (QLog.isDevelopLevel()) {
      axql.a("WebSpeedTrace", "getinitTime", new Object[] { Long.valueOf(this.l) });
    }
    return this.l;
  }
  
  public boolean getisWebViewCache()
  {
    boolean bool = WebAccelerateHelper.isWebViewCache;
    if (QLog.isDevelopLevel()) {
      axql.a("WebSpeedTrace", "getisWebViewCache", new Object[] { Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public long getmClickTime()
  {
    if (QLog.isDevelopLevel()) {
      axql.a("WebSpeedTrace", "getmClickTime", new Object[] { Long.valueOf(this.jdField_h_of_type_Long) });
    }
    return this.jdField_h_of_type_Long;
  }
  
  public long getmOnCreateMilliTimeStamp()
  {
    if (QLog.isDevelopLevel()) {
      axql.a("WebSpeedTrace", "getmOnCreateMilliTimeStamp", new Object[] { Long.valueOf(this.jdField_g_of_type_Long) });
    }
    return this.jdField_g_of_type_Long;
  }
  
  public boolean getmPerfFirstLoadTag()
  {
    bidf localbidf = a();
    if (localbidf == null) {}
    for (boolean bool = false;; bool = localbidf.ismPerfFirstLoadTag())
    {
      if (QLog.isDevelopLevel()) {
        axql.a("WebSpeedTrace", "getmPerfFirstLoadTag", new Object[] { Boolean.valueOf(bool) });
      }
      return bool;
    }
  }
  
  public long getmStartLoadUrlMilliTimeStamp()
  {
    bidf localbidf = a();
    if (localbidf == null) {}
    for (long l1 = 0L;; l1 = localbidf.mStartLoadUrlMilliTimeStamp)
    {
      if (QLog.isDevelopLevel()) {
        axql.a("WebSpeedTrace", "getmStartLoadUrlMilliTimeStamp", new Object[] { Long.valueOf(l1) });
      }
      return l1;
    }
  }
  
  public long getmTimeBeforeLoadUrl()
  {
    bidf localbidf = a();
    if (localbidf == null) {}
    for (long l1 = 0L;; l1 = localbidf.getmTimeBeforeLoadUrl())
    {
      if (QLog.isDevelopLevel()) {
        axql.a("WebSpeedTrace", "getmTimeBeforeLoadUrl", new Object[] { Long.valueOf(l1) });
      }
      return l1;
    }
  }
  
  public long getonCreateTime()
  {
    if (QLog.isDevelopLevel()) {
      axql.a("WebSpeedTrace", "getonCreateTime", new Object[] { Long.valueOf(this.jdField_i_of_type_Long) });
    }
    return this.jdField_i_of_type_Long;
  }
  
  public long getpluginFinished()
  {
    return 0L;
  }
  
  public long getviewInflateTime()
  {
    if (QLog.isDevelopLevel()) {
      axql.a("WebSpeedTrace", "getviewInflateTime", new Object[] { Long.valueOf(this.jdField_j_of_type_Long) });
    }
    return this.jdField_j_of_type_Long;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      ThreadManager.post(new NearbyActivity.2(this), 8, null, true);
      try
      {
        i1 = getIntent().getIntExtra("NEARBY_IS_HAS_ICON", 2);
        bdmb.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, getClass(), hashCode(), "0X80059D6", i1);
      }
      catch (Throwable paramMessage)
      {
        paramMessage.printStackTrace();
      }
      continue;
      this.jdField_g_of_type_Int += 1;
      if (QLog.isColorLevel()) {
        QLog.d("nearby.msgbox.tab", 2, "MSG_INIT_MSGTAB_REDDOT，retryTime=" + this.jdField_g_of_type_Int + ", msgBoxTabIndex=" + this.jdField_c_of_type_Int);
      }
      int i1 = this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a();
      if ((this.jdField_c_of_type_Int >= 0) && (i1 != this.jdField_c_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null))
      {
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a();
        if (paramMessage.a())
        {
          i1 = paramMessage.b();
          a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, i1);
          if (QLog.isColorLevel()) {
            QLog.d("nearby.msgbox.tab", 2, "MSG_INIT_MSGTAB_REDDOT，curRedNum=" + i1 + "");
          }
          this.jdField_h_of_type_Int = i1;
        }
        else if (this.jdField_g_of_type_Int < 3)
        {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 1000L);
        }
      }
    }
  }
  
  public boolean isMainPageUseLocalFile()
  {
    bidf localbidf = a();
    if (localbidf == null) {}
    for (boolean bool = false;; bool = localbidf.isMainPageUseLocalFile())
    {
      if (QLog.isDevelopLevel()) {
        axql.a("WebSpeedTrace", "isMainPageUseLocalFile", new Object[] { Boolean.valueOf(bool) });
      }
      return bool;
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    Object localObject;
    if (this.f >= 0)
    {
      localObject = a(this.f);
      if ((localObject != null) && (((BaseFragment)localObject).a())) {
        return false;
      }
    }
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Int != 0))
    {
      localObject = new Intent(this, SplashActivity.class);
      ((Intent)localObject).putExtra("main_tab_id", 4);
      ((Intent)localObject).setFlags(603979776);
      startActivity((Intent)localObject);
    }
    return super.onBackEvent();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    NearbyBaseFragment localNearbyBaseFragment;
    if (paramInt2 == this.f)
    {
      localNearbyBaseFragment = a(this.f);
      if (localNearbyBaseFragment != null) {
        localNearbyBaseFragment.a();
      }
      if (QLog.isColorLevel()) {
        axql.a("onTabClicked", new Object[0]);
      }
    }
    if (QLog.isColorLevel()) {
      axql.a("onTabSelected", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.getCurrentItem()), Integer.valueOf(this.f) });
    }
    if ((this.f >= 0) && (this.f != paramInt2))
    {
      localNearbyBaseFragment = a(this.f);
      if (localNearbyBaseFragment != null) {
        localNearbyBaseFragment.onHiddenChanged(true);
      }
      if (paramInt2 == this.jdField_c_of_type_Int) {
        a(true);
      }
    }
    this.f = paramInt2;
    if ((this.jdField_b_of_type_Int < 0) || (paramInt2 != this.jdField_b_of_type_Int) || (paramInt2 != this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.getCurrentItem())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.setCurrentItem(paramInt2, false);
    }
    if (paramInt2 == 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.requestParentDisallowInterecptTouchEvent(false);
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Int == 3) {
        a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "0X8005CEA");
      }
      if (this.jdField_b_of_type_Int == 1) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.reportClickEvent("dc00899", "grp_lbs", "", "anchor_tab", "exp", 0, 0, "", "", "", "");
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.requestParentDisallowInterecptTouchEvent(true);
    }
  }
  
  public int pluginStartActivityForResult(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    int i1 = switchRequestCode(paramWebViewPlugin, paramByte);
    if (i1 == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyActivity", 2, "pluginStartActivityForResult not handled");
      }
      return i1;
    }
    startActivityForResult(paramIntent, i1);
    return i1;
  }
  
  @TargetApi(11)
  public void removeWebViewLayerType()
  {
    if (Build.VERSION.SDK_INT == 16) {
      this.vg.setLayerType(0, null);
    }
  }
  
  public void setImmersiveStatus()
  {
    if (b())
    {
      setImmersiveStatus(-1);
      return;
    }
    super.setImmersiveStatus();
  }
  
  public void setImmersiveStatus(int paramInt)
  {
    if (!b()) {
      super.setImmersiveStatus();
    }
    while (!this.mNeedStatusTrans) {
      return;
    }
    if (this.mSystemBarComp == null) {
      this.mSystemBarComp = new SystemBarCompact(this, true, paramInt);
    }
    ImmersiveUtils.a(getWindow(), this.isClearCoverLayer);
    ayqu.a(this, false);
  }
  
  public String setLastActivityName()
  {
    if (this.jdField_b_of_type_Int == 2) {
      return getString(2131693749);
    }
    return super.setLastActivityName();
  }
  
  public void setX5Performance(JSONObject paramJSONObject)
  {
    bidf localbidf = a();
    if (localbidf != null) {
      localbidf.mX5PerformanceJson = paramJSONObject;
    }
  }
  
  public int switchRequestCode(WebViewPlugin paramWebViewPlugin, byte paramByte)
  {
    CustomWebView localCustomWebView = paramWebViewPlugin.mRuntime.a();
    if (localCustomWebView == null) {}
    int i1;
    do
    {
      do
      {
        return -1;
      } while (localCustomWebView.getPluginEngine() == null);
      i1 = WebViewPluginEngine.a(paramWebViewPlugin);
      if (i1 != -1) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("nearby.NearbyActivity", 2, "switchRequestCode failed: webview index=" + 0 + ", pluginIndex=" + i1);
    return -1;
    return i1 << 8 & 0xFF00 | 0x0 | paramByte & 0xFF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NearbyActivity
 * JD-Core Version:    0.7.0.1
 */