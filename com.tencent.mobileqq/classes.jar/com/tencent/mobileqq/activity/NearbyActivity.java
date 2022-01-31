package com.tencent.mobileqq.activity;

import abnk;
import abnl;
import abnm;
import abnp;
import abnq;
import abnr;
import abns;
import abnt;
import ajsd;
import ajya;
import akbl;
import akbm;
import alyy;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
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
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqjw;
import arhj;
import arhk;
import atbg;
import atbi;
import atbq;
import atbr;
import atfz;
import atga;
import atym;
import axqy;
import axrc;
import axsf;
import axsg;
import baxn;
import bbbr;
import bbkb;
import bcaz;
import bcdp;
import bcdq;
import bcil;
import bcsc;
import bfob;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
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
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.widget.NonSwipeableViewPager;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class NearbyActivity
  extends NearbyTitleBarActivity
  implements Handler.Callback, bcdq, bcil, bcsc
{
  public static String a;
  int jdField_a_of_type_Int = -1;
  public long a;
  abnt jdField_a_of_type_Abnt;
  public akbl a;
  protected akbm a;
  public Handler a;
  FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  ViewPager.OnPageChangeListener jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = new abnp(this);
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  atbq jdField_a_of_type_Atbq;
  protected atga a;
  RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  NonSwipeableViewPager jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager;
  public TabBarView a;
  public ArrayList<NearbyActivity.TabInfo> a;
  public List<View.OnClickListener> a;
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  public long b;
  public Handler b;
  public RedTouch b;
  boolean b;
  public int c;
  public long c;
  public boolean c;
  public int d = 0;
  public long d;
  int e = -1;
  public long e;
  int f = 0;
  public long f;
  int g;
  public long g;
  public int h;
  public long h;
  public int i;
  public long i;
  public long j;
  public long k;
  public long l;
  public long m;
  public long n = 60000L;
  
  static
  {
    jdField_a_of_type_JavaLangString = "http://now.qq.com/qq/nearby/index.html?_wv=3&now_n_http=1&now_n_r=2&_proxy=1";
  }
  
  public NearbyActivity()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new bfob(Looper.getMainLooper(), this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_g_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_h_of_type_Int = -1;
    this.jdField_i_of_type_Int = 1000;
    this.jdField_b_of_type_AndroidOsHandler = new abns(this);
    this.jdField_a_of_type_Atga = new abnl(this);
    this.jdField_a_of_type_Akbm = new abnm(this);
  }
  
  public static int a(ArrayList<NearbyActivity.TabInfo> paramArrayList)
  {
    paramArrayList.clear();
    Object localObject = (String)atbi.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "key_tabs_array", "");
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
          NearbyActivity.TabInfo localTabInfo = new NearbyActivity.TabInfo();
          i3 = i1;
          localTabInfo.tabName = localJSONObject.optString("tabName");
          i3 = i1;
          localTabInfo.tabIndex = localJSONObject.optInt("tabIndex");
          i3 = i1;
          localTabInfo.reportId = localJSONObject.optInt("reportId");
          i3 = i1;
          localTabInfo.tabUrl = localJSONObject.optString("tabUrl");
          i3 = i1;
          localTabInfo.tabType = localJSONObject.optInt("tabType");
          i3 = i1;
          localTabInfo.disableScroll = localJSONObject.optInt("disableScroll");
          i3 = i1;
          localTabInfo.needLoc = localJSONObject.optInt("needLoc");
          i3 = i1;
          localTabInfo.autoEnter = localJSONObject.optInt("AutoEnter");
          i3 = i1;
          if (TextUtils.isEmpty(localTabInfo.tabName)) {
            break label520;
          }
          i3 = i1;
          if (localTabInfo.tabName.length() > 4) {
            break label520;
          }
          i3 = i1;
          if (localTabInfo.tabType == 1) {
            break label537;
          }
          i3 = i1;
          paramArrayList.add(localTabInfo);
          i3 = i1;
          if (localTabInfo.tabType != 6) {
            break label517;
          }
          i3 = i1;
          i1 = localTabInfo.tabIndex;
          break label528;
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
          break label542;
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
        ((NearbyActivity.TabInfo)paramArrayList.get(i2)).tabIndex = i2;
        i2 += 1;
      }
      else
      {
        i2 = 0;
        if (i2 != 0)
        {
          localObject = new NearbyActivity.TabInfo();
          ((NearbyActivity.TabInfo)localObject).tabName = ajya.a(2131707107);
          ((NearbyActivity.TabInfo)localObject).tabIndex = 0;
          ((NearbyActivity.TabInfo)localObject).tabUrl = "https://nearby.qq.com/nearby-index/index.html?_wv=1031&_proxy=1&_wwv=128";
          ((NearbyActivity.TabInfo)localObject).tabType = 5;
          paramArrayList.add(localObject);
          localObject = new NearbyActivity.TabInfo();
          ((NearbyActivity.TabInfo)localObject).tabName = ajya.a(2131707108);
          ((NearbyActivity.TabInfo)localObject).tabIndex = 1;
          ((NearbyActivity.TabInfo)localObject).tabUrl = "";
          ((NearbyActivity.TabInfo)localObject).tabType = 2;
          paramArrayList.add(localObject);
        }
        Collections.sort(paramArrayList);
        return i1;
        label517:
        break label528;
        label520:
        continue;
        i2 = 1;
        continue;
        label528:
        i4 += 1;
        continue;
        label537:
        i2 = 1;
        continue;
        label542:
        i2 = 0;
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
  
  public static RedTouch a(Context paramContext, TabBarView paramTabBarView, int paramInt1, int paramInt2)
  {
    paramInt1 = baxn.b(paramContext, paramContext.getResources().getDisplayMetrics().widthPixels / paramInt1);
    return new RedTouch(paramContext, paramTabBarView.a(paramInt2)).a(53).d(4).c(paramInt1 / 2 - 8 - 20).a();
  }
  
  public static void a(Context paramContext, TabBarView paramTabBarView, ArrayList<NearbyActivity.TabInfo> paramArrayList)
  {
    paramTabBarView.setEnableRepeatedClick(true);
    paramTabBarView.setTabTextSize(16);
    paramTabBarView.setSelectColor(Color.parseColor("#00aced"));
    paramTabBarView.setUnselectColor(Color.parseColor("#777777"));
    paramTabBarView.setUnderLineHeight(baxn.a(paramContext, 3.0F));
    paramTabBarView.setTabHeight(baxn.a(paramContext, 45.0F));
    int i1 = paramArrayList.size();
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1);
    localLayoutParams.gravity = 17;
    localLayoutParams.width = (paramContext.getResources().getDisplayMetrics().widthPixels / i1);
    paramTabBarView.setTabLayoutParams(localLayoutParams);
    i1 = 0;
    while (i1 < paramArrayList.size())
    {
      paramTabBarView.a(((NearbyActivity.TabInfo)paramArrayList.get(i1)).tabName);
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
  
  public int a()
  {
    return 2131559323;
  }
  
  public int a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      NearbyActivity.TabInfo localTabInfo = (NearbyActivity.TabInfo)localIterator.next();
      if (localTabInfo.tabType == paramInt) {
        return localTabInfo.tabIndex;
      }
    }
    return 0;
  }
  
  public bcaz a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Abnt != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Abnt.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment != null) {
        localObject1 = this.jdField_a_of_type_Abnt.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment.a;
      }
    }
    return localObject1;
  }
  
  public HotChatFragment a()
  {
    return this.jdField_a_of_type_Abnt.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment;
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
        localObject1 = (NearbyActivity.TabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        localObject1 = (NearbyBaseFragment)this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag(((NearbyActivity.TabInfo)localObject1).getTabTag());
      }
    }
    return localObject1;
  }
  
  public NearbyHybridFragment a()
  {
    NearbyHybridFragment localNearbyHybridFragment = this.jdField_a_of_type_Abnt.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment;
    int i1;
    if ((localNearbyHybridFragment == null) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      i1 = 0;
      if (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        Object localObject = (NearbyActivity.TabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        localObject = (NearbyBaseFragment)this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag(((NearbyActivity.TabInfo)localObject).getTabTag());
        if (QLog.isColorLevel()) {
          QLog.d("nearby.NearbyActivity", 2, "getNearbyHybridFragment is null, search:" + i1 + ", " + localObject);
        }
        if ((localObject instanceof NearbyHybridFragment))
        {
          localNearbyHybridFragment = (NearbyHybridFragment)localObject;
          this.jdField_a_of_type_Abnt.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment = localNearbyHybridFragment;
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
    return this.jdField_a_of_type_Abnt.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment;
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
  
  public void a(aqjw paramaqjw)
  {
    if (paramaqjw == null) {}
    Object localObject;
    do
    {
      return;
      localObject = a(NearbyBaseFragment.jdField_b_of_type_Int);
      if (QLog.isColorLevel()) {
        atbr.a("nearby.NearbyActivity", new Object[] { "updateTitlebar", localObject, paramaqjw.jdField_a_of_type_ComTencentMobileqqFragmentBaseFragment });
      }
    } while (localObject != paramaqjw.jdField_a_of_type_ComTencentMobileqqFragmentBaseFragment);
    if (paramaqjw.jdField_b_of_type_Boolean)
    {
      if (this.centerView.getVisibility() != 0) {
        this.centerView.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 8) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      if (!bbbr.a(paramaqjw.jdField_a_of_type_JavaLangString, getTextTitle())) {
        setTitle(paramaqjw.jdField_a_of_type_JavaLangString);
      }
      if (!paramaqjw.jdField_a_of_type_Boolean) {
        break label411;
      }
      if (!isTitleProgressShowing()) {
        startTitleProgress();
      }
    }
    for (;;)
    {
      if (!paramaqjw.jdField_c_of_type_Boolean) {
        break label426;
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramaqjw.jdField_a_of_type_AndroidViewView$OnClickListener);
      if ((AppSetting.d) && (paramaqjw.e != null)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramaqjw.e);
      }
      if (paramaqjw.jdField_a_of_type_Int > 0) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramaqjw.jdField_a_of_type_Int);
      }
      if (this.rightViewText.getVisibility() != 8) {
        this.rightViewText.setVisibility(8);
      }
      this.centerView.setClickable(true);
      this.centerView.setOnClickListener(new abnq(this));
      return;
      if (this.centerView.getVisibility() != 4) {
        this.centerView.setVisibility(4);
      }
      if (!bbbr.a(paramaqjw.jdField_a_of_type_JavaLangString, getTextTitle())) {
        setTitle(paramaqjw.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      if (paramaqjw.jdField_b_of_type_JavaLangString != null)
      {
        localObject = (TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131377438);
        if (!bbbr.a(paramaqjw.jdField_b_of_type_JavaLangString, ((TextView)localObject).getText())) {
          ((TextView)localObject).setText(paramaqjw.jdField_b_of_type_JavaLangString);
        }
      }
      if (paramaqjw.jdField_c_of_type_JavaLangString == null) {
        break;
      }
      localObject = (TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131377379);
      if (bbbr.a(paramaqjw.jdField_c_of_type_JavaLangString, ((TextView)localObject).getText())) {
        break;
      }
      ((TextView)localObject).setText(paramaqjw.jdField_c_of_type_JavaLangString);
      break;
      label411:
      if (isTitleProgressShowing()) {
        stopTitleProgress();
      }
    }
    label426:
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 8) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (TextUtils.isEmpty(paramaqjw.d)) {
      if (this.rightViewText.getVisibility() != 8) {
        this.rightViewText.setVisibility(8);
      }
    }
    for (;;)
    {
      if (!bbbr.a(paramaqjw.d, this.rightViewText.getText())) {
        this.rightViewText.setText(paramaqjw.d);
      }
      this.rightViewText.setOnClickListener(paramaqjw.jdField_a_of_type_AndroidViewView$OnClickListener);
      break;
      if (this.rightViewText.getVisibility() != 0) {
        this.rightViewText.setVisibility(0);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    String str = ajsd.I;
    Intent localIntent = new Intent(this, MsgBoxListActivity.class);
    localIntent.putExtra("uin", str);
    localIntent.putExtra("uintype", 1001);
    localIntent.putExtra("isFromNearby", true);
    localIntent.putExtra("tabs", this.jdField_a_of_type_JavaUtilArrayList);
    localIntent.putExtra("msgTabIndex", this.jdField_c_of_type_Int);
    localIntent.putExtra("mUnReadMsgNum", this.jdField_g_of_type_Int);
    localIntent.putExtra("selfSet_leftViewText", ajya.a(2131707102));
    startActivityForResult(localIntent, 10001);
    if (paramBoolean) {
      overridePendingTransition(2130772211, 2130772211);
    }
    if (QLog.isColorLevel()) {
      QLog.d("nearby.msgbox.tab", 2, "startMsgBoxListActivity");
    }
    new axrc(null).a("dc00899").b("grp_lbs").c("msg_box").d("page_exp").a();
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
    return 2130838514;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager = ((NonSwipeableViewPager)findViewById(2131379344));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.a(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.setOnPageChangeListener(this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.setPagingEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131376796));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this);
    a(this, this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView, this.jdField_a_of_type_JavaUtilArrayList);
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_c_of_type_Int >= 0) && (this.jdField_c_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = a(this, this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView, this.jdField_a_of_type_JavaUtilArrayList.size(), this.jdField_c_of_type_Int);
    }
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i1 = 0;
    int i4;
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        if (((NearbyActivity.TabInfo)((Iterator)localObject).next()).tabType == 7)
        {
          arhj.a.b(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
          this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = a(this, this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView, this.jdField_a_of_type_JavaUtilArrayList.size(), i1);
          this.e = i1;
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new NearbyActivity.3(this), 2000L);
        }
      }
      else
      {
        if (this.titleRoot != null)
        {
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.titleRoot.findViewById(2131375329).findViewById(2131368441));
          this.centerView = ((TextView)this.titleRoot.findViewById(2131368472));
          this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.titleRoot.findViewById(2131377400));
        }
        c();
        i4 = ((Integer)atbi.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin(), "key_auto_enter_without_redot", Integer.valueOf(0))).intValue();
        i2 = 0;
        i1 = -1;
        while (i2 < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localObject = (NearbyActivity.TabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i2);
          if (((NearbyActivity.TabInfo)localObject).autoEnter == 1) {
            i1 = ((NearbyActivity.TabInfo)localObject).tabIndex;
          }
          i2 += 1;
        }
      }
      i1 += 1;
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = getSupportFragmentManager();
    this.jdField_a_of_type_Abnt = new abnt(this, this.jdField_a_of_type_AndroidSupportV4AppFragmentManager);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.setAdapter(this.jdField_a_of_type_Abnt);
    int i2 = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(5) != null) {
      i2 = a(5);
    }
    for (int i3 = 1;; i3 = 0)
    {
      if (i3 != 0)
      {
        if ((i4 != 1) || (i1 == -1)) {
          break label858;
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
        i2 = ((NearbyActivity.TabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).tabIndex;
        if ((((NearbyActivity.TabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).autoEnter == 1) && (((NearbyActivity.TabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).tabUrl != null))
        {
          localObject = ((NearbyActivity.TabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).tabUrl;
          if (!((String)localObject).contains("?")) {
            break label863;
          }
          localObject = (String)localObject + "&open_way=nearby_auto";
          label664:
          ((NearbyActivity.TabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).tabUrl = ((String)localObject);
          if (QLog.isColorLevel()) {
            QLog.i("nearby.NearbyActivity", 2, "autoEnter url = " + (String)localObject);
          }
        }
        if (i2 < 0) {
          break label889;
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
          atbr.a("MSG_INIT", new Object[] { Integer.valueOf(i1), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int), Integer.valueOf(NearbyBaseFragment.jdField_b_of_type_Int) });
        }
        return;
        i3 = i1;
        if (i1 != -1) {
          break;
        }
        label858:
        i3 = i2;
        break;
        label863:
        localObject = (String)localObject + "?open_way=nearby_auto";
        break label664;
        label889:
        i2 = 0;
      }
    }
  }
  
  public int c()
  {
    return this.jdField_h_of_type_Int;
  }
  
  void c()
  {
    setTitle(2131694529);
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("abp_flag", this.jdField_b_of_type_Boolean);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("FROM_WHERE", this.jdField_a_of_type_Int);
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Int == 0))
    {
      setLeftViewName(2131720039);
      return;
    }
    if (this.jdField_a_of_type_Int == 1003)
    {
      setLeftViewName(2131693271);
      return;
    }
    if (this.jdField_a_of_type_Int == 1004)
    {
      setLeftViewName(2131689628);
      return;
    }
    if (this.jdField_a_of_type_Int == 1002)
    {
      setLeftViewName(2131689607);
      return;
    }
    setLeftViewName(getIntent());
  }
  
  public void d()
  {
    this.jdField_a_of_type_Akbl.b();
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
          atym.a(this, paramInt1, paramInt2, paramIntent);
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
        this.jdField_g_of_type_Int = paramInt2;
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
    this.jdField_c_of_type_Int = a(this.jdField_a_of_type_JavaUtilArrayList);
    boolean bool = super.doOnCreate(paramBundle);
    try
    {
      axqy.b(null, "dc00899", "grp_lbs", "", "entry", "open_nearby_act_total_tmp", 0, 0, Build.MODEL, Build.VERSION.SDK, "", "");
      label52:
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface == null)
      {
        finish();
        QLog.e("nearby.NearbyActivity", 1, "doOnCreate app==null, goto finish");
        return false;
      }
      this.jdField_a_of_type_Akbl = ((akbl)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(3));
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
          localObject2 = bbkb.e(this, this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin());
        }
        if (bbbr.a(localObject2, bbkb.e(this, this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin()))) {
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
      for (int i1 = ((NearbyActivity.TabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int)).tabType;; i1 = 5)
      {
        i1 = paramBundle.getIntExtra("TAB_TYPE", i1);
        if (i1 == 3)
        {
          this.jdField_h_of_type_Long = paramBundle.getLongExtra("ENTER_TIME", l1);
          this.jdField_g_of_type_Long = l1;
          if (QLog.isDevelopLevel()) {
            atbr.a("WebSpeedTrace", "mClickTime", new Object[] { "doOnCreate", Long.valueOf(this.jdField_h_of_type_Long) });
          }
        }
        if (i1 == 2)
        {
          this.jdField_a_of_type_Long = paramBundle.getLongExtra("ENTER_TIME", l1);
          this.jdField_b_of_type_Long = l1;
          if (QLog.isDevelopLevel()) {
            atbr.a("WebSpeedTrace", "mClickTime", new Object[] { "doOnCreate", Long.valueOf(this.jdField_h_of_type_Long) });
          }
        }
        this.jdField_a_of_type_Atbq = new atbq(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "grp_lbs", "basic", "visit_time");
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.addObserver(this.jdField_a_of_type_Akbm);
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(this.jdField_a_of_type_Atga);
        d();
        if ((Build.VERSION.SDK_INT >= 23) && (checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)) {
          requestPermissions(new abnk(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
        }
        return bool;
      }
    }
    catch (Exception paramBundle)
    {
      break label52;
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
      Object localObject = (atbg)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(219);
      if (localObject != null)
      {
        ((atbg)localObject).a();
        ((atbg)localObject).jdField_a_of_type_Boolean = true;
      }
      localObject = axsf.a(getClass(), hashCode());
      if (localObject != null)
      {
        long l1 = SystemClock.elapsedRealtime();
        long l2 = ((axsg)localObject).jdField_b_of_type_Long;
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "", "", ((axsg)localObject).jdField_a_of_type_JavaLangString, ((axsg)localObject).jdField_a_of_type_JavaLangString, ((axsg)localObject).jdField_a_of_type_Int, 0, Long.toString(l1 - l2), "", "", "");
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
    if (this.jdField_a_of_type_Atbq != null) {
      this.jdField_a_of_type_Atbq.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b(this.jdField_a_of_type_Atga);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.removeObserver(this.jdField_a_of_type_Akbm);
    f();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    c();
    int i1 = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int;
    if (i1 >= 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(i1, false);
      if (QLog.isColorLevel()) {
        QLog.i("nearby.NearbyActivity", 2, "doOnNewIntent setSelectedTab:" + i1);
      }
    }
    atym.a(this, 1000, -1, paramIntent);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_c_of_type_Boolean) {}
    for (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int = this.jdField_b_of_type_Int;; this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int = 0)
    {
      if (QLog.isDevelopLevel()) {
        atbr.a("Q.nearby", "doOnPause", new Object[] { Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_c_of_type_Boolean), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int) });
      }
      ((alyy)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(180)).b();
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
    this.jdField_a_of_type_Atbq.a();
    NearbyBaseFragment localNearbyBaseFragment = a(this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.getCurrentItem());
    if ((localNearbyBaseFragment instanceof NearbyHybridFragment)) {
      ((NearbyHybridFragment)localNearbyBaseFragment).h();
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch != null) && (arhj.a.jdField_a_of_type_Int <= 0)) {
      a(this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch, 0);
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
    SosoInterface.SosoLbsInfo localSosoLbsInfo = SosoInterface.b();
    if (localSosoLbsInfo == null)
    {
      SosoInterface.a(new abnr(this, "NearbyProtocolCoder.Encounter"));
      return;
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Akbl.a(1, localSosoLbsInfo);
  }
  
  public void f()
  {
    this.jdField_a_of_type_Akbl.a(2, null);
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
    this.jdField_a_of_type_Akbl.a(3, null);
  }
  
  public long getDetect302Time()
  {
    return 0L;
  }
  
  public boolean getIsReloadUrl()
  {
    bcaz localbcaz = a();
    if (localbcaz == null) {}
    for (boolean bool = false;; bool = localbcaz.getIsReloadUrl())
    {
      if (QLog.isDevelopLevel()) {
        atbr.a("WebSpeedTrace", "getIsReloadUrl", new Object[] { Boolean.valueOf(bool) });
      }
      return bool;
    }
  }
  
  public long getOpenUrlAfterCheckOfflineTime()
  {
    bcaz localbcaz = a();
    if (localbcaz == null) {}
    for (long l1 = 0L;; l1 = localbcaz.getOpenUrlAfterCheckOfflineTime())
    {
      if (QLog.isDevelopLevel()) {
        atbr.a("WebSpeedTrace", "getOpenUrlAfterCheckOfflineTime", new Object[] { Long.valueOf(l1) });
      }
      return l1;
    }
  }
  
  public long getReadIndexFromOfflineTime()
  {
    bcaz localbcaz = a();
    if (localbcaz == null) {}
    for (long l1 = 0L;; l1 = localbcaz.getReadIndexFromOfflineTime())
    {
      if (QLog.isDevelopLevel()) {
        atbr.a("WebSpeedTrace", "getReadIndexFromOfflineTime", new Object[] { Long.valueOf(l1) });
      }
      return l1;
    }
  }
  
  public JSONObject getX5Performance()
  {
    bcaz localbcaz = a();
    if (localbcaz != null) {
      return localbcaz.mX5PerformanceJson;
    }
    return null;
  }
  
  public long getgetWebViewTime()
  {
    if (QLog.isDevelopLevel()) {
      atbr.a("WebSpeedTrace", "getgetWebViewTime", new Object[] { Long.valueOf(this.k) });
    }
    return this.k;
  }
  
  public long getinitBrowserTime()
  {
    if (QLog.isDevelopLevel()) {
      atbr.a("WebSpeedTrace", "getinitBrowserTime", new Object[] { Long.valueOf(this.m) });
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
      atbr.a("WebSpeedTrace", "getinitTime", new Object[] { Long.valueOf(this.l) });
    }
    return this.l;
  }
  
  public boolean getisWebViewCache()
  {
    boolean bool = WebAccelerateHelper.isWebViewCache;
    if (QLog.isDevelopLevel()) {
      atbr.a("WebSpeedTrace", "getisWebViewCache", new Object[] { Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public long getmClickTime()
  {
    if (QLog.isDevelopLevel()) {
      atbr.a("WebSpeedTrace", "getmClickTime", new Object[] { Long.valueOf(this.jdField_h_of_type_Long) });
    }
    return this.jdField_h_of_type_Long;
  }
  
  public long getmOnCreateMilliTimeStamp()
  {
    if (QLog.isDevelopLevel()) {
      atbr.a("WebSpeedTrace", "getmOnCreateMilliTimeStamp", new Object[] { Long.valueOf(this.jdField_g_of_type_Long) });
    }
    return this.jdField_g_of_type_Long;
  }
  
  public boolean getmPerfFirstLoadTag()
  {
    bcaz localbcaz = a();
    if (localbcaz == null) {}
    for (boolean bool = false;; bool = localbcaz.ismPerfFirstLoadTag())
    {
      if (QLog.isDevelopLevel()) {
        atbr.a("WebSpeedTrace", "getmPerfFirstLoadTag", new Object[] { Boolean.valueOf(bool) });
      }
      return bool;
    }
  }
  
  public long getmStartLoadUrlMilliTimeStamp()
  {
    bcaz localbcaz = a();
    if (localbcaz == null) {}
    for (long l1 = 0L;; l1 = localbcaz.mStartLoadUrlMilliTimeStamp)
    {
      if (QLog.isDevelopLevel()) {
        atbr.a("WebSpeedTrace", "getmStartLoadUrlMilliTimeStamp", new Object[] { Long.valueOf(l1) });
      }
      return l1;
    }
  }
  
  public long getmTimeBeforeLoadUrl()
  {
    bcaz localbcaz = a();
    if (localbcaz == null) {}
    for (long l1 = 0L;; l1 = localbcaz.getmTimeBeforeLoadUrl())
    {
      if (QLog.isDevelopLevel()) {
        atbr.a("WebSpeedTrace", "getmTimeBeforeLoadUrl", new Object[] { Long.valueOf(l1) });
      }
      return l1;
    }
  }
  
  public long getonCreateTime()
  {
    if (QLog.isDevelopLevel()) {
      atbr.a("WebSpeedTrace", "getonCreateTime", new Object[] { Long.valueOf(this.jdField_i_of_type_Long) });
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
      atbr.a("WebSpeedTrace", "getviewInflateTime", new Object[] { Long.valueOf(this.j) });
    }
    return this.j;
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
        axsf.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, getClass(), hashCode(), "0X80059D6", i1);
      }
      catch (Throwable paramMessage)
      {
        paramMessage.printStackTrace();
      }
      continue;
      this.f += 1;
      if (QLog.isColorLevel()) {
        QLog.d("nearby.msgbox.tab", 2, "MSG_INIT_MSGTAB_REDDOT，retryTime=" + this.f + ", msgBoxTabIndex=" + this.jdField_c_of_type_Int);
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
          this.jdField_g_of_type_Int = i1;
        }
        else if (this.f < 3)
        {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 1000L);
        }
      }
    }
  }
  
  public boolean isMainPageUseLocalFile()
  {
    bcaz localbcaz = a();
    if (localbcaz == null) {}
    for (boolean bool = false;; bool = localbcaz.isMainPageUseLocalFile())
    {
      if (QLog.isDevelopLevel()) {
        atbr.a("WebSpeedTrace", "isMainPageUseLocalFile", new Object[] { Boolean.valueOf(bool) });
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
    if (this.jdField_h_of_type_Int >= 0)
    {
      localObject = a(this.jdField_h_of_type_Int);
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
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    NearbyBaseFragment localNearbyBaseFragment;
    if (paramInt2 == this.jdField_h_of_type_Int)
    {
      localNearbyBaseFragment = a(this.jdField_h_of_type_Int);
      if (localNearbyBaseFragment != null) {
        localNearbyBaseFragment.a();
      }
      if (QLog.isColorLevel()) {
        atbr.a("onTabClicked", new Object[0]);
      }
    }
    if (QLog.isColorLevel()) {
      atbr.a("onTabSelected", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.getCurrentItem()), Integer.valueOf(this.jdField_h_of_type_Int) });
    }
    if ((this.jdField_h_of_type_Int >= 0) && (this.jdField_h_of_type_Int != paramInt2))
    {
      localNearbyBaseFragment = a(this.jdField_h_of_type_Int);
      if (localNearbyBaseFragment != null) {
        localNearbyBaseFragment.onHiddenChanged(true);
      }
      if (paramInt2 == this.jdField_c_of_type_Int) {
        a(true);
      }
    }
    this.jdField_h_of_type_Int = paramInt2;
    if ((this.jdField_b_of_type_Int < 0) || (paramInt2 != this.jdField_b_of_type_Int) || (paramInt2 != this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.getCurrentItem())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.setCurrentItem(paramInt2, false);
    }
    if (paramInt2 == 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.a(false);
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.a(true);
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
  
  public String setLastActivityName()
  {
    if (this.jdField_b_of_type_Int == 2) {
      return getString(2131694071);
    }
    return super.setLastActivityName();
  }
  
  public void setX5Performance(JSONObject paramJSONObject)
  {
    bcaz localbcaz = a();
    if (localbcaz != null) {
      localbcaz.mX5PerformanceJson = paramJSONObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NearbyActivity
 * JD-Core Version:    0.7.0.1
 */