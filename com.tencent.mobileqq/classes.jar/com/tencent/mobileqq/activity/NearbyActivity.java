package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
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
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.NearbyObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.dating.DatingFilters;
import com.tencent.mobileqq.fragment.BaseFragment;
import com.tencent.mobileqq.fragment.CommonTabFragment;
import com.tencent.mobileqq.fragment.HotChatFragment;
import com.tencent.mobileqq.fragment.NearbyBaseFragment;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.fragment.NowLiveFragment;
import com.tencent.mobileqq.fragment.TitlebarStatus;
import com.tencent.mobileqq.freshnews.feed.NearbyImgLoader;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyReportManager;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyTitleBarActivity;
import com.tencent.mobileqq.nearby.NearbyUsingTimeReport;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.mobileqq.statistics.ViewExposeUtil;
import com.tencent.mobileqq.statistics.ViewExposeUtil.ViewExposeUnit;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginContainer;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebviewReportSpeedInterface;
import com.tencent.mobileqq.widget.NonSwipeableViewPager;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
import tgs;
import tgt;
import tgu;
import tgv;
import tgw;
import tgx;
import tgy;

public class NearbyActivity
  extends NearbyTitleBarActivity
  implements Handler.Callback, WebViewPluginContainer, WebUiUtils.WebviewReportSpeedInterface, TabBarView.OnTabChangeListener
{
  public static String a;
  int jdField_a_of_type_Int = -1;
  public long a;
  Handler jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  ViewPager.OnPageChangeListener jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = new tgt(this);
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public NearbyHandler a;
  protected NearbyObserver a;
  NearbyUsingTimeReport jdField_a_of_type_ComTencentMobileqqNearbyNearbyUsingTimeReport;
  NonSwipeableViewPager jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager;
  public TabBarView a;
  public ArrayList a;
  public List a;
  tgy jdField_a_of_type_Tgy;
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  public long b;
  public Handler b;
  boolean b;
  public int c;
  public long c;
  public boolean c;
  public int d = 1000;
  public long d;
  public long e;
  public long f;
  public long g;
  public long h;
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
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_Int = -1;
    this.jdField_b_of_type_AndroidOsHandler = new tgw(this);
    this.jdField_a_of_type_ComTencentMobileqqAppNearbyObserver = new tgx(this);
  }
  
  @NonNull
  private Intent a()
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(new Bundle());
    setIntent(localIntent);
    return localIntent;
  }
  
  public int a()
  {
    return 2130969113;
  }
  
  public int a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      NearbyActivity.TabInfo localTabInfo = (NearbyActivity.TabInfo)localIterator.next();
      if (localTabInfo.jdField_b_of_type_Int == paramInt) {
        return localTabInfo.jdField_a_of_type_Int;
      }
    }
    return 0;
  }
  
  public int a(WebViewPlugin paramWebViewPlugin, byte paramByte)
  {
    CustomWebView localCustomWebView = paramWebViewPlugin.mRuntime.a();
    if (localCustomWebView == null) {}
    int i1;
    do
    {
      do
      {
        return -1;
      } while (localCustomWebView.a() == null);
      i1 = WebViewPluginEngine.a(paramWebViewPlugin);
      if (i1 != -1) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("NearbyActivity", 2, "switchRequestCode failed: webview index=" + 0 + ", pluginIndex=" + i1);
    return -1;
    return i1 << 8 & 0xFF00 | 0x0 | paramByte & 0xFF;
  }
  
  public int a(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    int i1 = a(paramWebViewPlugin, paramByte);
    if (i1 == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyActivity", 2, "pluginStartActivityForResult not handled");
      }
      return i1;
    }
    startActivityForResult(paramIntent, i1);
    return i1;
  }
  
  public HotChatFragment a()
  {
    return this.jdField_a_of_type_Tgy.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment;
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
        localObject1 = (NearbyBaseFragment)this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag(((NearbyActivity.TabInfo)localObject1).a());
      }
    }
    return localObject1;
  }
  
  public NearbyHybridFragment a()
  {
    NearbyHybridFragment localNearbyHybridFragment = this.jdField_a_of_type_Tgy.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment;
    int i1;
    if ((localNearbyHybridFragment == null) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      i1 = 0;
      if (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        Object localObject = (NearbyActivity.TabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        localObject = (NearbyBaseFragment)this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag(((NearbyActivity.TabInfo)localObject).a());
        if (QLog.isColorLevel()) {
          QLog.d("NearbyActivity", 2, "getNearbyHybridFragment is null, search:" + i1 + ", " + localObject);
        }
        if ((localObject instanceof NearbyHybridFragment))
        {
          localNearbyHybridFragment = (NearbyHybridFragment)localObject;
          this.jdField_a_of_type_Tgy.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment = localNearbyHybridFragment;
        }
      }
    }
    for (;;)
    {
      if ((QLog.isColorLevel()) && (localNearbyHybridFragment == null)) {
        QLog.d("NearbyActivity", 2, "getNearbyHybridFragment is null");
      }
      return localNearbyHybridFragment;
      i1 += 1;
      break;
    }
  }
  
  public NowLiveFragment a()
  {
    return this.jdField_a_of_type_Tgy.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment;
  }
  
  public AbsWebView a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Tgy != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Tgy.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment != null) {
        localObject1 = this.jdField_a_of_type_Tgy.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment.a;
      }
    }
    return localObject1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager = ((NonSwipeableViewPager)findViewById(2131365255));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.a(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.setOnPageChangeListener(this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.setPagingEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131363117));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setEnableRepeatedClick(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setTabTextSize(16);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectColor(Color.parseColor("#9359ff"));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setUnselectColor(Color.parseColor("#777777"));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setUnderLineHeight(DisplayUtil.a(this, 3.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setTabHeight(DisplayUtil.a(this, 45.0F));
    if (this.titleRoot != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.titleRoot.findViewById(2131363261).findViewById(2131363493));
      this.centerView = ((TextView)this.titleRoot.findViewById(2131363400));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.titleRoot.findViewById(2131363399));
    }
    b();
    int i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
    Object localObject = new LinearLayout.LayoutParams(0, -1);
    ((LinearLayout.LayoutParams)localObject).gravity = 17;
    ((LinearLayout.LayoutParams)localObject).width = (getResources().getDisplayMetrics().widthPixels / i1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setTabLayoutParams((LinearLayout.LayoutParams)localObject);
    int i4 = ((Integer)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin(), "key_auto_enter_without_redot", Integer.valueOf(0))).intValue();
    int i2 = 0;
    i1 = -1;
    while (i2 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject = (NearbyActivity.TabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i2);
      if (((NearbyActivity.TabInfo)localObject).e == 1) {
        i1 = ((NearbyActivity.TabInfo)localObject).jdField_a_of_type_Int;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(((NearbyActivity.TabInfo)localObject).jdField_a_of_type_JavaLangString);
      i2 += 1;
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = getSupportFragmentManager();
    this.jdField_a_of_type_Tgy = new tgy(this, this.jdField_a_of_type_AndroidSupportV4AppFragmentManager);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.setAdapter(this.jdField_a_of_type_Tgy);
    i2 = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(5) != null) {
      i2 = a(5);
    }
    for (int i3 = 1;; i3 = 0)
    {
      if (i3 != 0)
      {
        if ((i4 != 1) || (i1 == -1)) {
          break label754;
        }
        i3 = i1;
        if (getIntent().hasExtra("TAB_TYPE")) {
          i3 = a(getIntent().getIntExtra("TAB_TYPE", 5));
        }
        QLog.d("NearbyActivity", 1, "tabIdx=" + i3 + ", tabs.size=" + this.jdField_a_of_type_JavaUtilArrayList.size());
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
        i2 = ((NearbyActivity.TabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int;
        if ((((NearbyActivity.TabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).e == 1) && (((NearbyActivity.TabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).jdField_b_of_type_JavaLangString != null))
        {
          localObject = ((NearbyActivity.TabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).jdField_b_of_type_JavaLangString;
          if (!((String)localObject).contains("?")) {
            break label759;
          }
          localObject = (String)localObject + "&open_way=nearby_auto";
          label634:
          ((NearbyActivity.TabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).jdField_b_of_type_JavaLangString = ((String)localObject);
          if (QLog.isColorLevel()) {
            QLog.i("NearbyActivity", 2, "autoEnter url = " + (String)localObject);
          }
        }
        if (i2 < 0) {
          break label785;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(i2, false);
        this.jdField_b_of_type_Int = i2;
        if (QLog.isColorLevel()) {
          NearbyUtils.a("MSG_INIT", new Object[] { Integer.valueOf(i1), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int), Integer.valueOf(NearbyBaseFragment.jdField_b_of_type_Int) });
        }
        return;
        i3 = i1;
        if (i1 != -1) {
          break;
        }
        label754:
        i3 = i2;
        break;
        label759:
        localObject = (String)localObject + "?open_way=nearby_auto";
        break label634;
        label785:
        i2 = 0;
      }
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramOnClickListener);
  }
  
  public void a(TitlebarStatus paramTitlebarStatus)
  {
    if (paramTitlebarStatus == null) {}
    Object localObject;
    do
    {
      return;
      localObject = a(NearbyBaseFragment.jdField_b_of_type_Int);
      if (QLog.isColorLevel()) {
        NearbyUtils.a("NearbyActivity", new Object[] { "updateTitlebar", localObject, paramTitlebarStatus.jdField_a_of_type_ComTencentMobileqqFragmentBaseFragment });
      }
    } while (localObject != paramTitlebarStatus.jdField_a_of_type_ComTencentMobileqqFragmentBaseFragment);
    if (paramTitlebarStatus.jdField_b_of_type_Boolean)
    {
      if (this.centerView.getVisibility() != 0) {
        this.centerView.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 8) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      if (!Utils.a(paramTitlebarStatus.jdField_a_of_type_JavaLangString, getTextTitle())) {
        setTitle(paramTitlebarStatus.jdField_a_of_type_JavaLangString);
      }
      if (!paramTitlebarStatus.jdField_a_of_type_Boolean) {
        break label411;
      }
      if (!isTitleProgressShowing()) {
        startTitleProgress();
      }
    }
    for (;;)
    {
      if (!paramTitlebarStatus.jdField_c_of_type_Boolean) {
        break label426;
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramTitlebarStatus.jdField_a_of_type_AndroidViewView$OnClickListener);
      if ((AppSetting.jdField_b_of_type_Boolean) && (paramTitlebarStatus.e != null)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramTitlebarStatus.e);
      }
      if (paramTitlebarStatus.jdField_a_of_type_Int > 0) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramTitlebarStatus.jdField_a_of_type_Int);
      }
      if (this.rightViewText.getVisibility() != 8) {
        this.rightViewText.setVisibility(8);
      }
      this.centerView.setClickable(true);
      this.centerView.setOnClickListener(new tgu(this));
      return;
      if (this.centerView.getVisibility() != 4) {
        this.centerView.setVisibility(4);
      }
      if (!Utils.a(paramTitlebarStatus.jdField_a_of_type_JavaLangString, getTextTitle())) {
        setTitle(paramTitlebarStatus.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      if (paramTitlebarStatus.jdField_b_of_type_JavaLangString != null)
      {
        localObject = (TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363489);
        if (!Utils.a(paramTitlebarStatus.jdField_b_of_type_JavaLangString, ((TextView)localObject).getText())) {
          ((TextView)localObject).setText(paramTitlebarStatus.jdField_b_of_type_JavaLangString);
        }
      }
      if (paramTitlebarStatus.jdField_c_of_type_JavaLangString == null) {
        break;
      }
      localObject = (TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363490);
      if (Utils.a(paramTitlebarStatus.jdField_c_of_type_JavaLangString, ((TextView)localObject).getText())) {
        break;
      }
      ((TextView)localObject).setText(paramTitlebarStatus.jdField_c_of_type_JavaLangString);
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
    if (TextUtils.isEmpty(paramTitlebarStatus.d)) {
      if (this.rightViewText.getVisibility() != 8) {
        this.rightViewText.setVisibility(8);
      }
    }
    for (;;)
    {
      if (!Utils.a(paramTitlebarStatus.d, this.rightViewText.getText())) {
        this.rightViewText.setText(paramTitlebarStatus.d);
      }
      this.rightViewText.setOnClickListener(paramTitlebarStatus.jdField_a_of_type_AndroidViewView$OnClickListener);
      break;
      if (this.rightViewText.getVisibility() != 0) {
        this.rightViewText.setVisibility(0);
      }
    }
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
        QLog.d("NearbyActivity", 2, "default theme daymode,clear decorview background");
      }
      return 0;
    }
    return 2130838219;
  }
  
  void b()
  {
    setTitle(2131435091);
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("abp_flag", this.jdField_b_of_type_Boolean);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("FROM_WHERE", this.jdField_a_of_type_Int);
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Int == 0))
    {
      setLeftViewName(2131433307);
      return;
    }
    if (this.jdField_a_of_type_Int == 1003)
    {
      setLeftViewName(2131434040);
      return;
    }
    if (this.jdField_a_of_type_Int == 1004)
    {
      setLeftViewName(2131434494);
      return;
    }
    if (this.jdField_a_of_type_Int == 1002)
    {
      setLeftViewName(2131437254);
      return;
    }
    setLeftViewName(getIntent());
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    Object localObject = (String)NearbySPUtil.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "key_tabs_array", "");
    if (QLog.isColorLevel()) {
      QLog.d("NearbyActivity", 2, "initTabs:" + (String)localObject);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      int i2;
      int i1;
      int i3;
      try
      {
        localObject = new JSONArray((String)localObject);
        i2 = 0;
        i1 = 0;
        if (i2 < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i2);
          NearbyActivity.TabInfo localTabInfo = new NearbyActivity.TabInfo();
          localTabInfo.jdField_a_of_type_JavaLangString = localJSONObject.optString("tabName");
          localTabInfo.jdField_a_of_type_Int = localJSONObject.optInt("tabIndex");
          localTabInfo.jdField_b_of_type_JavaLangString = localJSONObject.optString("tabUrl");
          localTabInfo.jdField_b_of_type_Int = localJSONObject.optInt("tabType");
          localTabInfo.jdField_c_of_type_Int = localJSONObject.optInt("disableScroll");
          localTabInfo.d = localJSONObject.optInt("needLoc");
          localTabInfo.e = localJSONObject.optInt("AutoEnter");
          i3 = i1;
          if (TextUtils.isEmpty(localTabInfo.jdField_a_of_type_JavaLangString)) {
            break label474;
          }
          i3 = i1;
          if (localTabInfo.jdField_a_of_type_JavaLangString.length() > 4) {
            break label474;
          }
          if (localTabInfo.jdField_b_of_type_Int == 1) {
            break label483;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(localTabInfo);
          i3 = i1;
          break label474;
        }
        i2 = this.jdField_a_of_type_JavaUtilArrayList.size();
        if (i2 == 0) {
          continue;
        }
        if (i1 == 0) {}
      }
      catch (Exception localException1)
      {
        i2 = 1;
        i1 = i2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("NearbyActivity", 2, "initTabs exception:", localException1);
        i1 = i2;
        continue;
        i1 = 1;
        continue;
      }
      try
      {
        if (!QLog.isColorLevel()) {
          break label488;
        }
        QLog.w("NearbyActivity", 2, "initTabs, isOldConfig=true, reset tabindex");
      }
      catch (Exception localException2)
      {
        i2 = 0;
        continue;
      }
      if (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((NearbyActivity.TabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_Int = i1;
        i1 += 1;
      }
      else
      {
        i1 = 0;
        if (i1 != 0)
        {
          localObject = new NearbyActivity.TabInfo();
          ((NearbyActivity.TabInfo)localObject).jdField_a_of_type_JavaLangString = "直播";
          ((NearbyActivity.TabInfo)localObject).jdField_a_of_type_Int = 0;
          ((NearbyActivity.TabInfo)localObject).jdField_b_of_type_JavaLangString = "";
          ((NearbyActivity.TabInfo)localObject).jdField_b_of_type_Int = 2;
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
          localObject = new NearbyActivity.TabInfo();
          ((NearbyActivity.TabInfo)localObject).jdField_a_of_type_JavaLangString = "群聊";
          ((NearbyActivity.TabInfo)localObject).jdField_a_of_type_Int = 1;
          ((NearbyActivity.TabInfo)localObject).jdField_b_of_type_JavaLangString = "";
          ((NearbyActivity.TabInfo)localObject).jdField_b_of_type_Int = 3;
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
        }
        Collections.sort(this.jdField_a_of_type_JavaUtilArrayList);
        return;
        i1 = 1;
        continue;
        for (;;)
        {
          label474:
          i2 += 1;
          i1 = i3;
          break;
          label483:
          i3 = 1;
        }
        label488:
        i1 = 0;
      }
    }
  }
  
  public void d()
  {
    this.jdField_c_of_type_Boolean = false;
    SosoInterface.SosoLbsInfo localSosoLbsInfo = SosoInterface.b();
    if (localSosoLbsInfo == null)
    {
      SosoInterface.a(new tgv(this, "NearbyProtocolCoder.Encounter"));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppNearbyHandler.a(1, localSosoLbsInfo);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NBase", 2, "doOnActivityResult() NearbyActivity");
    }
    Object localObject = a(this.jdField_b_of_type_Int);
    if ((localObject instanceof CommonTabFragment))
    {
      localObject = (CommonTabFragment)localObject;
      HashMap localHashMap = new HashMap();
      localHashMap.put("requestCode", Integer.valueOf(paramInt1));
      localHashMap.put("resultCode", Integer.valueOf(paramInt2));
      localHashMap.put("data", paramIntent);
      if (((CommonTabFragment)localObject).a(8589934600L, localHashMap, paramInt2, paramInt1, paramIntent)) {
        return;
      }
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    long l1 = System.currentTimeMillis();
    c();
    boolean bool = super.doOnCreate(paramBundle);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface == null)
    {
      finish();
      QLog.e("NearbyActivity", 1, "doOnCreate app==null, goto finish");
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppNearbyHandler = ((NearbyHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(3));
    Intent localIntent = getIntent();
    paramBundle = localIntent;
    if (localIntent == null) {
      paramBundle = a();
    }
    paramBundle.setExtrasClassLoader(DatingFilters.class.getClassLoader());
    if (paramBundle == null)
    {
      localObject1 = localObject2;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = SharedPreUtils.d(this, this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin());
      }
      if (!Utils.a(localObject2, SharedPreUtils.d(this, this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin())))
      {
        this.jdField_a_of_type_Int = 1;
        localObject1 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", URLUtil.guessUrl((String)localObject2));
        startActivity((Intent)localObject1);
        finish();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label426;
      }
    }
    label426:
    for (int i1 = ((NearbyActivity.TabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int)).jdField_b_of_type_Int;; i1 = 5)
    {
      for (;;)
      {
        i1 = paramBundle.getIntExtra("TAB_TYPE", i1);
        if (i1 == 3)
        {
          this.h = paramBundle.getLongExtra("ENTER_TIME", l1);
          this.g = l1;
          if (QLog.isDevelopLevel()) {
            NearbyUtils.a("WebSpeedTrace", "mClickTime", new Object[] { "doOnCreate", Long.valueOf(this.h) });
          }
        }
        if (i1 == 2)
        {
          this.jdField_a_of_type_Long = paramBundle.getLongExtra("ENTER_TIME", l1);
          this.jdField_b_of_type_Long = l1;
          if (QLog.isDevelopLevel()) {
            NearbyUtils.a("WebSpeedTrace", "mClickTime", new Object[] { "doOnCreate", Long.valueOf(this.h) });
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUsingTimeReport = new NearbyUsingTimeReport(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "grp_lbs", "basic", "visit_time");
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppNearbyObserver);
        d();
        return bool;
        try
        {
          localObject2 = paramBundle.getStringExtra("url");
          localObject1 = localObject2;
        }
        catch (Throwable paramBundle)
        {
          if (QLog.isColorLevel()) {
            QLog.i("NearbyActivity", 2, paramBundle.getMessage(), paramBundle);
          }
          paramBundle = a();
        }
      }
      break;
    }
  }
  
  public void doOnDestroy()
  {
    try
    {
      super.doOnDestroy();
      Object localObject = (NearbyReportManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(218);
      if (localObject != null)
      {
        ((NearbyReportManager)localObject).a();
        ((NearbyReportManager)localObject).jdField_a_of_type_Boolean = true;
      }
      localObject = ViewExposeUtil.a(getClass(), hashCode());
      if (localObject != null)
      {
        long l1 = SystemClock.elapsedRealtime();
        long l2 = ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_b_of_type_Long;
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "", "", ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_a_of_type_JavaLangString, ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_a_of_type_JavaLangString, ((ViewExposeUtil.ViewExposeUnit)localObject).jdField_a_of_type_Int, 0, Long.toString(l1 - l2), "", "", "");
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
      NearbyImgLoader.a().a();
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUsingTimeReport != null) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUsingTimeReport.b();
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppNearbyObserver);
      e();
      return;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          localException1.printStackTrace();
        }
      }
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    b();
    int i1 = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int;
    if (i1 >= 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(i1, false);
      if (QLog.isColorLevel()) {
        QLog.i("NBase", 2, "doOnNewIntent setSelectedTab:" + i1);
      }
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_c_of_type_Boolean) {}
    for (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int = this.jdField_b_of_type_Int;; this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int = 0)
    {
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("Q.nearby", "doOnPause", new Object[] { Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_c_of_type_Boolean), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int) });
      }
      ((DynamicAvatarManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(179)).b();
      NearbyBaseFragment localNearbyBaseFragment = a(this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.getCurrentItem());
      if ((localNearbyBaseFragment instanceof NearbyHybridFragment))
      {
        ((NearbyHybridFragment)localNearbyBaseFragment).i();
        ((NearbyHybridFragment)localNearbyBaseFragment).r();
      }
      return;
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUsingTimeReport.a();
    NearbyBaseFragment localNearbyBaseFragment = a(this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.getCurrentItem());
    if ((localNearbyBaseFragment instanceof NearbyHybridFragment)) {
      ((NearbyHybridFragment)localNearbyBaseFragment).h();
    }
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("NBase", 2, "doOnSaveInstanceState");
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
    this.jdField_a_of_type_ComTencentMobileqqAppNearbyHandler.a(2, null);
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppNearbyHandler.a(3, null);
  }
  
  public void finish()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if ((localInputMethodManager != null) && (getCurrentFocus() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
    super.finish();
    if (this.jdField_b_of_type_Boolean) {
      overridePendingTransition(2131034129, 2131034130);
    }
  }
  
  public long getDetect302Time()
  {
    return 0L;
  }
  
  public boolean getIsReloadUrl()
  {
    AbsWebView localAbsWebView = a();
    if (localAbsWebView == null) {}
    for (boolean bool = false;; bool = localAbsWebView.e())
    {
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "getIsReloadUrl", new Object[] { Boolean.valueOf(bool) });
      }
      return bool;
    }
  }
  
  public long getOpenUrlAfterCheckOfflineTime()
  {
    AbsWebView localAbsWebView = a();
    if (localAbsWebView == null) {}
    for (long l1 = 0L;; l1 = localAbsWebView.a())
    {
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "getOpenUrlAfterCheckOfflineTime", new Object[] { Long.valueOf(l1) });
      }
      return l1;
    }
  }
  
  public long getReadIndexFromOfflineTime()
  {
    AbsWebView localAbsWebView = a();
    if (localAbsWebView == null) {}
    for (long l1 = 0L;; l1 = localAbsWebView.b())
    {
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "getReadIndexFromOfflineTime", new Object[] { Long.valueOf(l1) });
      }
      return l1;
    }
  }
  
  public JSONObject getX5Performance()
  {
    AbsWebView localAbsWebView = a();
    if (localAbsWebView != null) {
      return localAbsWebView.a;
    }
    return null;
  }
  
  public long getgetWebViewTime()
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("WebSpeedTrace", "getgetWebViewTime", new Object[] { Long.valueOf(this.k) });
    }
    return this.k;
  }
  
  public long getinitBrowserTime()
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("WebSpeedTrace", "getinitBrowserTime", new Object[] { Long.valueOf(this.m) });
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
      NearbyUtils.a("WebSpeedTrace", "getinitTime", new Object[] { Long.valueOf(this.l) });
    }
    return this.l;
  }
  
  public boolean getisWebViewCache()
  {
    boolean bool = WebAccelerateHelper.isWebViewCache;
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("WebSpeedTrace", "getisWebViewCache", new Object[] { Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public long getmClickTime()
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("WebSpeedTrace", "getmClickTime", new Object[] { Long.valueOf(this.h) });
    }
    return this.h;
  }
  
  public long getmOnCreateMilliTimeStamp()
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("WebSpeedTrace", "getmOnCreateMilliTimeStamp", new Object[] { Long.valueOf(this.g) });
    }
    return this.g;
  }
  
  public boolean getmPerfFirstLoadTag()
  {
    AbsWebView localAbsWebView = a();
    if (localAbsWebView == null) {}
    for (boolean bool = false;; bool = localAbsWebView.f())
    {
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "getmPerfFirstLoadTag", new Object[] { Boolean.valueOf(bool) });
      }
      return bool;
    }
  }
  
  public long getmStartLoadUrlMilliTimeStamp()
  {
    AbsWebView localAbsWebView = a();
    if (localAbsWebView == null) {}
    for (long l1 = 0L;; l1 = localAbsWebView.c)
    {
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "getmStartLoadUrlMilliTimeStamp", new Object[] { Long.valueOf(l1) });
      }
      return l1;
    }
  }
  
  public long getmTimeBeforeLoadUrl()
  {
    AbsWebView localAbsWebView = a();
    if (localAbsWebView == null) {}
    for (long l1 = 0L;; l1 = localAbsWebView.c())
    {
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "getmTimeBeforeLoadUrl", new Object[] { Long.valueOf(l1) });
      }
      return l1;
    }
  }
  
  public long getonCreateTime()
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("WebSpeedTrace", "getonCreateTime", new Object[] { Long.valueOf(this.i) });
    }
    return this.i;
  }
  
  public long getpluginFinished()
  {
    return 0L;
  }
  
  public long getviewInflateTime()
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("WebSpeedTrace", "getviewInflateTime", new Object[] { Long.valueOf(this.j) });
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
      ThreadManager.post(new tgs(this), 8, null, true);
      try
      {
        int i1 = getIntent().getIntExtra("NEARBY_IS_HAS_ICON", 2);
        ViewExposeUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, getClass(), hashCode(), "0X80059D6", i1);
      }
      catch (Throwable paramMessage)
      {
        paramMessage.printStackTrace();
      }
    }
  }
  
  public boolean isMainPageUseLocalFile()
  {
    AbsWebView localAbsWebView = a();
    if (localAbsWebView == null) {}
    for (boolean bool = false;; bool = localAbsWebView.d())
    {
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "isMainPageUseLocalFile", new Object[] { Boolean.valueOf(bool) });
      }
      return bool;
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    Object localObject;
    if (this.jdField_c_of_type_Int >= 0)
    {
      localObject = a(this.jdField_c_of_type_Int);
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
    if (paramInt2 == this.jdField_c_of_type_Int)
    {
      localNearbyBaseFragment = a(this.jdField_c_of_type_Int);
      if (localNearbyBaseFragment != null) {
        localNearbyBaseFragment.a();
      }
    }
    if (QLog.isColorLevel()) {
      NearbyUtils.a("onTabSelected", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.getCurrentItem()), Integer.valueOf(this.jdField_c_of_type_Int) });
    }
    if ((this.jdField_c_of_type_Int >= 0) && (this.jdField_c_of_type_Int != paramInt2))
    {
      localNearbyBaseFragment = a(this.jdField_c_of_type_Int);
      if (localNearbyBaseFragment != null) {
        localNearbyBaseFragment.onHiddenChanged(true);
      }
    }
    this.jdField_c_of_type_Int = paramInt2;
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
  
  @TargetApi(11)
  public void removeWebViewLayerType()
  {
    if (Build.VERSION.SDK_INT == 16) {
      this.vg.setLayerType(0, null);
    }
  }
  
  protected String setLastActivityName()
  {
    if (this.jdField_b_of_type_Int == 2) {
      return getString(2131433286);
    }
    return super.setLastActivityName();
  }
  
  public void setX5Performance(JSONObject paramJSONObject)
  {
    AbsWebView localAbsWebView = a();
    if (localAbsWebView != null) {
      localAbsWebView.a = paramJSONObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NearbyActivity
 * JD-Core Version:    0.7.0.1
 */