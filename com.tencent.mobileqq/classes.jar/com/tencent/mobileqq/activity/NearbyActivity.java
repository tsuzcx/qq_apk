package com.tencent.mobileqq.activity;

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
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.NearbyObserver;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.dating.DatingFilters;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.fragment.BaseFragment;
import com.tencent.mobileqq.fragment.CommonTabFragment;
import com.tencent.mobileqq.fragment.HotChatFragment;
import com.tencent.mobileqq.fragment.NearbyBaseFragment;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.fragment.NowLiveFragment;
import com.tencent.mobileqq.fragment.TitlebarStatus;
import com.tencent.mobileqq.freshnews.feed.NearbyImgLoader;
import com.tencent.mobileqq.nearby.MatchMakerPlugin;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyConstants;
import com.tencent.mobileqq.nearby.NearbyReportManager;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyTitleBarActivity;
import com.tencent.mobileqq.nearby.NearbyUsingTimeReport;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.home.NearbyFragmentPagerAdapter;
import com.tencent.mobileqq.nearby.home.NearbyTabInfo;
import com.tencent.mobileqq.nearby.ipc.NearbyProcManager;
import com.tencent.mobileqq.nearby.ipc.NearbyProcObserver;
import com.tencent.mobileqq.nearby.redtouch.NearbyRedNum;
import com.tencent.mobileqq.nearby.report.ODReportTask;
import com.tencent.mobileqq.nearby.widget.NearbyPublishMenuHelper;
import com.tencent.mobileqq.now.utils.StatusBarUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.statistics.ViewExposeUtil;
import com.tencent.mobileqq.statistics.ViewExposeUtil.ViewExposeUnit;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginContainer;
import com.tencent.mobileqq.webview.swift.WebViewUtil;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebviewReportSpeedInterface;
import com.tencent.mobileqq.widget.NonSwipeableViewPager;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
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
  implements Handler.Callback, WebViewPluginContainer, WebUiUtils.WebviewReportSpeedInterface, TabBarView.OnTabChangeListener
{
  public static String a;
  int jdField_a_of_type_Int = -1;
  public long a;
  Handler jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  ViewPager.OnPageChangeListener jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = new NearbyActivity.3(this);
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  NearbyHandler jdField_a_of_type_ComTencentMobileqqAppNearbyHandler;
  protected NearbyObserver a;
  NearbyUsingTimeReport jdField_a_of_type_ComTencentMobileqqNearbyNearbyUsingTimeReport;
  NearbyFragmentPagerAdapter jdField_a_of_type_ComTencentMobileqqNearbyHomeNearbyFragmentPagerAdapter;
  protected NearbyProcObserver a;
  RedTouch jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
  NonSwipeableViewPager jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager;
  public TabBarView a;
  ArrayList<NearbyTabInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public List<View.OnClickListener> a;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = -1;
  public long b;
  protected Handler b;
  boolean jdField_b_of_type_Boolean = false;
  int c;
  public long c;
  protected boolean c;
  int d;
  public long d;
  int e;
  public long e;
  int f;
  public long f;
  int g;
  public long g;
  int h;
  public long h;
  protected final int i;
  public long i;
  protected final int j;
  public long j;
  public long k = 0L;
  public long l = 0L;
  public long m = 0L;
  public long n = 0L;
  protected long o = 60000L;
  
  static
  {
    jdField_a_of_type_JavaLangString = "https://now.qq.com/qq/nearby/index.html?_wv=3&now_n_http=1&now_n_r=2&_proxy=1";
  }
  
  public NearbyActivity()
  {
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = -1;
    this.jdField_f_of_type_Int = -1;
    this.jdField_g_of_type_Int = 0;
    this.jdField_h_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_f_of_type_Long = 0L;
    this.jdField_g_of_type_Long = 0L;
    this.jdField_i_of_type_Long = 0L;
    this.jdField_j_of_type_Long = 0L;
    this.jdField_i_of_type_Int = 1000;
    this.jdField_j_of_type_Int = 1001;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidOsHandler = new Handler(new NearbyActivity.8(this));
    this.jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcObserver = new NearbyActivity.9(this);
    this.jdField_a_of_type_ComTencentMobileqqAppNearbyObserver = new NearbyActivity.10(this);
  }
  
  private int a(RedDotTextView paramRedDotTextView)
  {
    int i2 = 0;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a();
    if (!((NearbyProcManager)localObject).a()) {}
    do
    {
      return 0;
      localObject = ((NearbyProcManager)localObject).b();
    } while (localObject == null);
    int i1;
    if (((NearbyRedNum)localObject).jdField_a_of_type_Int > 0)
    {
      i1 = i2;
      if (TextUtils.isEmpty(((NearbyRedNum)localObject).jdField_a_of_type_JavaLangString)) {}
    }
    try
    {
      i1 = new JSONObject(((NearbyRedNum)localObject).jdField_a_of_type_JavaLangString).optInt("is_follow", 0);
      if (paramRedDotTextView.getTag() == null) {
        new ODReportTask().b("nearby_hongniang").c("tab_red_view").a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin()).i(String.valueOf(i1)).a();
      }
      MatchMakerPlugin.a((NearbyRedNum)localObject);
      paramRedDotTextView.setTag(Integer.valueOf(i1));
      return ((NearbyRedNum)localObject).jdField_a_of_type_Int;
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
    paramInt1 = DisplayUtil.b(paramContext, paramContext.getResources().getDisplayMetrics().widthPixels / paramInt1);
    return new RedTouch(paramContext, paramTabBarView.a(paramInt2)).b(53).e(4).d(paramInt1 / 2 - 8 - 20).a();
  }
  
  public static void a(Context paramContext, TabBarView paramTabBarView, ArrayList<NearbyTabInfo> paramArrayList)
  {
    paramTabBarView.setEnableRepeatedClick(true);
    paramTabBarView.setTabTextSize(16);
    paramTabBarView.setSelectColor(Color.parseColor("#00aced"));
    paramTabBarView.setUnselectColor(Color.parseColor("#777777"));
    paramTabBarView.setUnderLineHeight(DisplayUtil.a(paramContext, 3.0F));
    paramTabBarView.setTabHeight(DisplayUtil.a(paramContext, 45.0F));
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
      new ODReportTask().b("nearby_hongniang").c("tab_red_clk").a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin()).i(String.valueOf(paramRedDotTextView.getTag())).a();
      paramRedDotTextView.setTag(null);
    }
  }
  
  private boolean b()
  {
    return (!ThemeUtil.isCustomTheme(false)) && (!StatusBarUtil.a()) && (ImmersiveUtils.isSupporImmersive() == 1) && (Build.VERSION.SDK_INT >= 23);
  }
  
  private void h()
  {
    if ((StatusBarUtil.a()) || (ThemeUtil.isCustomTheme(false)) || (ImmersiveUtils.isSupporImmersive() != 1)) {}
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
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 0, null, "地理位置信息已清除", null, "确定", new NearbyActivity.11(this), null);
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.show();
  }
  
  private void j()
  {
    boolean bool = false;
    NearbyTabInfo localNearbyTabInfo = a();
    if ((localNearbyTabInfo != null) && (localNearbyTabInfo.tabType == 7)) {}
    label62:
    RedDotTextView localRedDotTextView;
    do
    {
      int i1;
      for (;;)
      {
        return;
        i1 = 0;
        while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localNearbyTabInfo = (NearbyTabInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
          if (localNearbyTabInfo.tabType == 7) {
            break label62;
          }
          i1 += 1;
        }
      }
      localRedDotTextView = this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(i1);
      if (a(localRedDotTextView) > 0) {
        bool = true;
      }
      localNearbyTabInfo.showRedRot = bool;
    } while (!bool);
    localRedDotTextView.a(localNearbyTabInfo.showRedRot);
  }
  
  public int a()
  {
    return 2131559601;
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
    Object localObject = (String)NearbySPUtil.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "key_tabs_array", "");
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
          ((NearbyTabInfo)localObject).tabName = HardCodeUtil.a(2131707110);
          ((NearbyTabInfo)localObject).tabIndex = 0;
          ((NearbyTabInfo)localObject).tabUrl = "https://nearby.qq.com/nearby-index/index.html?_wv=1031&_proxy=1&_wwv=128";
          ((NearbyTabInfo)localObject).tabType = 5;
          paramArrayList.add(localObject);
          localObject = new NearbyTabInfo();
          ((NearbyTabInfo)localObject).tabName = HardCodeUtil.a(2131707111);
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
  
  public AbsWebView a()
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
  
  public void a()
  {
    if (a() != null) {
      a().d();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    NearbyBaseFragment localNearbyBaseFragment;
    if (paramInt2 == this.jdField_f_of_type_Int)
    {
      localNearbyBaseFragment = a(this.jdField_f_of_type_Int);
      if (localNearbyBaseFragment != null) {
        localNearbyBaseFragment.a();
      }
      if (QLog.isColorLevel()) {
        NearbyUtils.a("onTabClicked", new Object[0]);
      }
    }
    if (QLog.isColorLevel()) {
      NearbyUtils.a("onTabSelected", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.getCurrentItem()), Integer.valueOf(this.jdField_f_of_type_Int) });
    }
    if ((this.jdField_f_of_type_Int >= 0) && (this.jdField_f_of_type_Int != paramInt2))
    {
      localNearbyBaseFragment = a(this.jdField_f_of_type_Int);
      if (localNearbyBaseFragment != null) {
        localNearbyBaseFragment.onHiddenChanged(true);
      }
      if (paramInt2 == this.jdField_c_of_type_Int) {
        a(true);
      }
    }
    this.jdField_f_of_type_Int = paramInt2;
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
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b("dc00899", "grp_lbs", "", "anchor_tab", "exp", 0, 0, "", "", "", "");
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.requestParentDisallowInterecptTouchEvent(true);
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
        NearbyUtils.a("nearby.NearbyActivity", new Object[] { "updateTitlebar", localObject, paramTitlebarStatus.jdField_a_of_type_ComTencentMobileqqFragmentBaseFragment });
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
        break label412;
      }
      if (!isTitleProgressShowing()) {
        startTitleProgress();
      }
    }
    for (;;)
    {
      if (!paramTitlebarStatus.jdField_c_of_type_Boolean) {
        break label427;
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramTitlebarStatus.jdField_a_of_type_AndroidViewView$OnClickListener);
      if ((AppSetting.d) && (paramTitlebarStatus.e != null)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramTitlebarStatus.e);
      }
      if (paramTitlebarStatus.jdField_a_of_type_Int > 0) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramTitlebarStatus.jdField_a_of_type_Int);
      }
      if (this.rightViewText.getVisibility() != 8) {
        this.rightViewText.setVisibility(8);
      }
      this.centerView.setClickable(true);
      this.centerView.setOnClickListener(new NearbyActivity.4(this));
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
        localObject = (TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379532);
        if (!Utils.a(paramTitlebarStatus.jdField_b_of_type_JavaLangString, ((TextView)localObject).getText())) {
          ((TextView)localObject).setText(paramTitlebarStatus.jdField_b_of_type_JavaLangString);
        }
      }
      if (paramTitlebarStatus.jdField_c_of_type_JavaLangString == null) {
        break;
      }
      localObject = (TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379462);
      if (Utils.a(paramTitlebarStatus.jdField_c_of_type_JavaLangString, ((TextView)localObject).getText())) {
        break;
      }
      ((TextView)localObject).setText(paramTitlebarStatus.jdField_c_of_type_JavaLangString);
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
    localIntent.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131707105));
    startActivityForResult(localIntent, 10001);
    if (paramBoolean) {
      overridePendingTransition(2130772247, 2130772247);
    }
    if (QLog.isColorLevel()) {
      QLog.d("nearby.msgbox.tab", 2, "startMsgBoxListActivity");
    }
    new ReportTask(null).a("dc00899").b("grp_lbs").c("msg_box").d("page_exp").a();
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
    return 2130838979;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager = ((NonSwipeableViewPager)findViewById(2131381782));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.requestParentDisallowInterecptTouchEvent(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.setOnPageChangeListener(this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNonSwipeableViewPager.setPagingEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131378828));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this);
    a(this, this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView, this.jdField_a_of_type_JavaUtilArrayList);
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_c_of_type_Int >= 0) && (this.jdField_c_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = a(this, this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView, this.jdField_a_of_type_JavaUtilArrayList.size(), this.jdField_c_of_type_Int);
    }
    if (this.titleRoot != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.titleRoot.findViewById(2131377159).findViewById(2131369501));
      this.centerView = ((TextView)this.titleRoot.findViewById(2131369534));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.titleRoot.findViewById(2131379487));
    }
    c();
    int i4 = ((Integer)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin(), "key_auto_enter_without_redot", Integer.valueOf(0))).intValue();
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
          NearbyUtils.a("MSG_INIT", new Object[] { Integer.valueOf(i1), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int), Integer.valueOf(NearbyBaseFragment.jdField_b_of_type_Int) });
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
    return this.jdField_f_of_type_Int;
  }
  
  void c()
  {
    setTitle(2131694422);
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("abp_flag", this.jdField_b_of_type_Boolean);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("FROM_WHERE", this.jdField_a_of_type_Int);
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Int == 0))
    {
      setLeftViewName(2131719721);
      return;
    }
    if (this.jdField_a_of_type_Int == 1003)
    {
      setLeftViewName(2131693175);
      return;
    }
    if (this.jdField_a_of_type_Int == 1004)
    {
      setLeftViewName(2131689557);
      return;
    }
    if (this.jdField_a_of_type_Int == 1002)
    {
      setLeftViewName(2131689538);
      return;
    }
    setLeftViewName(getIntent());
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppNearbyHandler.b();
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
      overridePendingTransition(2130771990, 2130771991);
    }
    Object localObject;
    HashMap localHashMap;
    do
    {
      do
      {
        return;
        if ((paramInt1 == 1000) || (paramInt1 == 1001)) {
          NearbyPublishMenuHelper.a(this, paramInt1, paramInt2, paramIntent);
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
        a(this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch, paramInt2);
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
    MatchMakerPlugin.a();
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
      ReportController.b(null, "dc00899", "grp_lbs", "", "entry", "open_nearby_act_total_tmp", 0, 0, Build.MODEL, Build.VERSION.SDK, "", "");
      label88:
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface == null)
      {
        finish();
        QLog.e("nearby.NearbyActivity", 1, "doOnCreate app==null, goto finish");
        return false;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppNearbyHandler = ((NearbyHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getBusinessHandler(NearbyConstants.jdField_a_of_type_JavaLangString));
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
          localObject2 = SharedPreUtils.e(this, this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin());
        }
        if (Utils.a(localObject2, SharedPreUtils.e(this, this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin()))) {
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
          this.jdField_i_of_type_Long = paramBundle.getLongExtra("ENTER_TIME", l1);
          this.jdField_h_of_type_Long = l1;
          if (QLog.isDevelopLevel()) {
            NearbyUtils.a("WebSpeedTrace", "mClickTime", new Object[] { "doOnCreate", Long.valueOf(this.jdField_i_of_type_Long) });
          }
        }
        if (i1 == 2)
        {
          this.jdField_a_of_type_Long = paramBundle.getLongExtra("ENTER_TIME", l1);
          this.jdField_b_of_type_Long = l1;
          if (QLog.isDevelopLevel()) {
            NearbyUtils.a("WebSpeedTrace", "mClickTime", new Object[] { "doOnCreate", Long.valueOf(this.jdField_i_of_type_Long) });
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUsingTimeReport = new NearbyUsingTimeReport(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "grp_lbs", "basic", "visit_time");
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUsingTimeReport.a();
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppNearbyObserver);
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcObserver);
        d();
        if ((Build.VERSION.SDK_INT >= 23) && (checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)) {
          requestPermissions(new NearbyActivity.1(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
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
      Object localObject = (NearbyReportManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(NearbyConstants.jdField_h_of_type_Int);
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
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUsingTimeReport != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUsingTimeReport.a(this.jdField_f_of_type_Int, this.jdField_f_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyUsingTimeReport.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqNearbyIpcNearbyProcObserver);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppNearbyObserver);
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
    NearbyPublishMenuHelper.a(this, 1000, -1, paramIntent);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_c_of_type_Boolean) {}
    for (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int = this.jdField_b_of_type_Int;; this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int = 0)
    {
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("Q.nearby", "doOnPause", new Object[] { Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_c_of_type_Boolean), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.jdField_a_of_type_Int) });
      }
      ((DynamicAvatarManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER)).b();
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
    SosoLbsInfo localSosoLbsInfo = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("NearbyProtocolCoder.Encounter");
    if (localSosoLbsInfo == null)
    {
      if (!mAppForground)
      {
        if (QLog.isColorLevel()) {
          QLog.d("nearby.heart_beat", 2, "startLocation: app running in the background");
        }
        return;
      }
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new NearbyActivity.7(this, "NearbyProtocolCoder.Encounter"));
      return;
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppNearbyHandler.a(1, localSosoLbsInfo);
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppNearbyHandler.a(2, null);
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
      overridePendingTransition(2130771990, 2130771991);
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppNearbyHandler.a(3, null);
  }
  
  public long getDetect302Time()
  {
    return 0L;
  }
  
  public boolean getIsReloadUrl()
  {
    AbsWebView localAbsWebView = a();
    if (localAbsWebView == null) {}
    for (boolean bool = false;; bool = localAbsWebView.getIsReloadUrl())
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
    for (long l1 = 0L;; l1 = localAbsWebView.getOpenUrlAfterCheckOfflineTime())
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
    for (long l1 = 0L;; l1 = localAbsWebView.getReadIndexFromOfflineTime())
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
      return localAbsWebView.mX5PerformanceJson;
    }
    return null;
  }
  
  public long getgetWebViewTime()
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("WebSpeedTrace", "getgetWebViewTime", new Object[] { Long.valueOf(this.l) });
    }
    return this.l;
  }
  
  public long getinitBrowserTime()
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("WebSpeedTrace", "getinitBrowserTime", new Object[] { Long.valueOf(this.n) });
    }
    return this.n;
  }
  
  public long getinitTBSTime()
  {
    return 0L;
  }
  
  public long getinitTime()
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("WebSpeedTrace", "getinitTime", new Object[] { Long.valueOf(this.m) });
    }
    return this.m;
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
      NearbyUtils.a("WebSpeedTrace", "getmClickTime", new Object[] { Long.valueOf(this.jdField_i_of_type_Long) });
    }
    return this.jdField_i_of_type_Long;
  }
  
  public long getmOnCreateMilliTimeStamp()
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("WebSpeedTrace", "getmOnCreateMilliTimeStamp", new Object[] { Long.valueOf(this.jdField_h_of_type_Long) });
    }
    return this.jdField_h_of_type_Long;
  }
  
  public boolean getmPerfFirstLoadTag()
  {
    AbsWebView localAbsWebView = a();
    if (localAbsWebView == null) {}
    for (boolean bool = false;; bool = localAbsWebView.ismPerfFirstLoadTag())
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
    for (long l1 = 0L;; l1 = localAbsWebView.mStartLoadUrlMilliTimeStamp)
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
    for (long l1 = 0L;; l1 = localAbsWebView.getmTimeBeforeLoadUrl())
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
      NearbyUtils.a("WebSpeedTrace", "getonCreateTime", new Object[] { Long.valueOf(this.jdField_j_of_type_Long) });
    }
    return this.jdField_j_of_type_Long;
  }
  
  public long getpluginFinished()
  {
    return 0L;
  }
  
  public long getviewInflateTime()
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("WebSpeedTrace", "getviewInflateTime", new Object[] { Long.valueOf(this.k) });
    }
    return this.k;
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
        ViewExposeUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, getClass(), hashCode(), "0X80059D6", i1);
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
      if ((this.jdField_c_of_type_Int >= 0) && (i1 != this.jdField_c_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null))
      {
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a();
        if (paramMessage.a())
        {
          i1 = paramMessage.b();
          a(this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch, i1);
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
    AbsWebView localAbsWebView = a();
    if (localAbsWebView == null) {}
    for (boolean bool = false;; bool = localAbsWebView.isMainPageUseLocalFile())
    {
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "isMainPageUseLocalFile", new Object[] { Boolean.valueOf(bool) });
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
    if (this.jdField_f_of_type_Int >= 0)
    {
      localObject = a(this.jdField_f_of_type_Int);
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
    ImmersiveUtils.clearCoverForStatus(getWindow(), this.isClearCoverLayer);
    StatusBarUtil.a(this, false);
  }
  
  public String setLastActivityName()
  {
    if (this.jdField_b_of_type_Int == 2) {
      return getString(2131693920);
    }
    return super.setLastActivityName();
  }
  
  public void setX5Performance(JSONObject paramJSONObject)
  {
    AbsWebView localAbsWebView = a();
    if (localAbsWebView != null) {
      localAbsWebView.mX5PerformanceJson = paramJSONObject;
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
      i1 = WebViewUtil.a(paramWebViewPlugin);
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