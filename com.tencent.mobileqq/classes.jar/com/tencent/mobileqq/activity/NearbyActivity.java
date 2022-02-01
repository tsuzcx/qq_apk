package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.common.app.AppInterface;
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
import com.tencent.mobileqq.fragment.CommonTabFragment;
import com.tencent.mobileqq.fragment.HotChatFragment;
import com.tencent.mobileqq.fragment.NearbyBaseFragment;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.fragment.NowLiveFragment;
import com.tencent.mobileqq.fragment.TitlebarBaseFragment;
import com.tencent.mobileqq.fragment.TitlebarStatus;
import com.tencent.mobileqq.freshnews.feed.NearbyImgLoader;
import com.tencent.mobileqq.nearby.MatchMakerPlugin;
import com.tencent.mobileqq.nearby.NearbyConstants;
import com.tencent.mobileqq.nearby.NearbyReportManager;
import com.tencent.mobileqq.nearby.NearbyTitleBarActivity;
import com.tencent.mobileqq.nearby.NearbyUsingTimeReport;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.home.NearbyTabInfo;
import com.tencent.mobileqq.nearby.home.impl.NearbyFragmentPagerAdapterImpl;
import com.tencent.mobileqq.nearby.ipc.INearbyProcManager;
import com.tencent.mobileqq.nearby.ipc.INearbyProcObserver;
import com.tencent.mobileqq.nearby.redtouch.NearbyRedNum;
import com.tencent.mobileqq.nearby.report.IODReportTask;
import com.tencent.mobileqq.nearby.widget.NearbyPublishMenuHelper;
import com.tencent.mobileqq.newnearby.NearbyActivityController;
import com.tencent.mobileqq.newnearby.impl.NearbyAlbumHelperImpl;
import com.tencent.mobileqq.newnearby.impl.NearbyReportHelperImpl;
import com.tencent.mobileqq.newnearby.model.TabInfo;
import com.tencent.mobileqq.newnearby.util.NearbyStatusBarHelper;
import com.tencent.mobileqq.now.utils.StatusBarUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.statistics.ViewExposeUtil;
import com.tencent.mobileqq.statistics.ViewExposeUtil.ViewExposeUnit;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
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

@RoutePage(desc="附近Activity", path="/nearby/activity")
public class NearbyActivity
  extends NearbyTitleBarActivity
  implements Handler.Callback, INearbyActivity, WebViewPluginContainer, WebUiUtils.WebviewReportSpeedInterface, TabBarView.OnTabChangeListener
{
  public static final String KEY_FROM_CLEAR_LOCATION = "key_from_location";
  static final String MI2 = "Xiaomi_MI 2";
  static final int MSG_INIT = 1;
  static final int MSG_INIT_MSGTAB_REDDOT = 2;
  static final String MX2 = "Meizu_M040";
  public static final int REQ_CODE_FRESH_NEWS_NOTIFY = 1001;
  public static final int REQ_START_MSG_LIST_ACTIVITY = 10001;
  public static final int REQ_START_OFFICAL_NOTIFY_PAGE = 10002;
  private static final String SPEED_TRACE = "WebSpeedTrace";
  public static final String TAG = "nearby.NearbyActivity";
  public static long enterNearbyTime = 0L;
  public static long enterNearbyTimeCost = 0L;
  public static String nearByTabUrl = "https://now.qq.com/qq/nearby/index.html?_wv=3&now_n_http=1&now_n_r=2&_proxy=1";
  protected final int MSG_SEND_GET_RED_DOT = 1001;
  protected final int MSG_SEND_HEART_BEAT = 1000;
  protected boolean isStopHeartBeat = false;
  boolean mApbFlag = false;
  public TabBarView mBarView;
  public long mClickTime = 0L;
  int mFrom = -1;
  Handler mHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  protected Handler mHeartBeatHandler = new Handler(new NearbyActivity.8(this));
  protected long mHeartBeatInterval = 60000L;
  int mHuiyinRedNum = 0;
  protected INearbyProcObserver mINearbyProcObserver = new NearbyActivity.9(this);
  public long mInitTime = 0L;
  public long mInitWebViewTime = 0L;
  boolean mIsInit = false;
  int mLastUnreadNum = -1;
  int mMsgBoxTabIndex;
  int mMsgTabRedDotRetryTime = 0;
  RedTouch mMsgTabRedTouch;
  NearbyActivityController mNearbyActivityController;
  NearbyHandler mNearbyHandler;
  protected NearbyObserver mNearbyObserver = new NearbyActivity.10(this);
  NearbyUsingTimeReport mNearbyUsingTimeReport;
  public long mNowClickTime = 0L;
  public long mNowInitTime = 0L;
  public long mNowInitWebViewTime = 0L;
  public long mNowOnCreateMilliTimeStamp = 0L;
  public long mNowOnCreateTime = 0L;
  public long mNowPreloadTime = 0L;
  public long mNowViewInflateTime = 0L;
  public long mOnCreateMilliTimeStamp;
  ViewPager.OnPageChangeListener mOnPageChangeListener = new NearbyActivity.3(this);
  NearbyFragmentPagerAdapterImpl mPagerAdapter;
  public long mPreloadTime = 0L;
  int mResumeTabIndex = -1;
  int mTabBarIndex = -1;
  ArrayList<NearbyTabInfo> mTabInfos = new ArrayList();
  public RedTouch[] mTabRedTouchs;
  RelativeLayout mTitleTopBottom;
  public long mViewInflateTime = 0L;
  NonSwipeableViewPager mViewPager;
  int mYuLiaoTabIndex = -1;
  RedTouch mYuLiaoTabRedTouch;
  FragmentManager mgrFragment;
  public long onCreateTime = 0L;
  QQCustomDialog testDialog;
  public List<View.OnClickListener> titleClickListeners = new ArrayList();
  ImageView titleRightImg;
  
  @android.support.annotation.NonNull
  private Intent fillIntent()
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(new Bundle());
    setIntent(localIntent);
    return localIntent;
  }
  
  private NearbyTabInfo getCurrentTabInfo()
  {
    if (getCurrentIndex() > 0) {
      return (NearbyTabInfo)this.mTabInfos.get(getCurrentIndex());
    }
    return null;
  }
  
  private int getNearbyMatchMakerRedNum(RedDotTextView paramRedDotTextView)
  {
    Object localObject = this.app.getNearbyProcManager();
    boolean bool = ((INearbyProcManager)localObject).h();
    int j = 0;
    if (!bool) {
      return 0;
    }
    localObject = ((INearbyProcManager)localObject).i();
    if (localObject == null) {
      return 0;
    }
    if (((NearbyRedNum)localObject).a > 0)
    {
      int i = j;
      if (!TextUtils.isEmpty(((NearbyRedNum)localObject).e)) {
        try
        {
          i = new JSONObject(((NearbyRedNum)localObject).e).optInt("is_follow", 0);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          i = j;
        }
      }
      if (paramRedDotTextView.getTag() == null) {
        ((IODReportTask)QRoute.api(IODReportTask.class)).setModule("nearby_hongniang").setAction("tab_red_view").setUin(this.app.getCurrentAccountUin()).setRes1(String.valueOf(i)).report();
      }
      MatchMakerPlugin.a((NearbyRedNum)localObject);
      paramRedDotTextView.setTag(Integer.valueOf(i));
    }
    return ((NearbyRedNum)localObject).a;
  }
  
  public static RedTouch getTabRedTouch(Context paramContext, TabBarView paramTabBarView, int paramInt1, int paramInt2)
  {
    return NearbyActivityHelper.a(paramContext, paramTabBarView, paramInt1, paramInt2);
  }
  
  private static void initTabBarView(Context paramContext, TabBarView paramTabBarView, ArrayList<NearbyTabInfo> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
      localArrayList.addAll(paramArrayList);
    }
    NearbyActivityHelper.a(paramContext, paramTabBarView, localArrayList);
  }
  
  private boolean isStatusBarSupportWhiteMode()
  {
    String str = VasUtil.e();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!QQTheme.isCustomTheme(str, false))
    {
      bool1 = bool2;
      if (!StatusBarUtil.a())
      {
        bool1 = bool2;
        if (ImmersiveUtils.isSupporImmersive() == 1)
        {
          bool1 = bool2;
          if (Build.VERSION.SDK_INT >= 23) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private void onMatchMakerTabClick(RedDotTextView paramRedDotTextView)
  {
    paramRedDotTextView.a(false);
    if (paramRedDotTextView.getTag() != null)
    {
      ((IODReportTask)QRoute.api(IODReportTask.class)).setModule("nearby_hongniang").setAction("tab_red_clk").setUin(this.app.getCurrentAccountUin()).setRes1(String.valueOf(paramRedDotTextView.getTag())).report();
      paramRedDotTextView.setTag(null);
    }
  }
  
  private void setNavBarBgWhiteColor()
  {
    if ((!StatusBarUtil.a()) && (!QQTheme.isCustomTheme(VasUtil.e(), false)))
    {
      if (ImmersiveUtils.isSupporImmersive() != 1) {
        return;
      }
      View localView = getTitleBarView();
      if ((localView instanceof NavBarCommon)) {
        ((NavBarCommon)localView).changeBg(true);
      }
    }
  }
  
  private void showClearLocationConfirmDialog()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 0, null, "地理位置信息已清除", null, "确定", new NearbyActivity.11(this), null);
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.show();
  }
  
  private void showMatchMakerRedDot()
  {
    NearbyTabInfo localNearbyTabInfo = getCurrentTabInfo();
    if ((localNearbyTabInfo != null) && (localNearbyTabInfo.getTabType() == 7)) {
      return;
    }
    boolean bool = false;
    int i = 0;
    while (i < this.mTabInfos.size())
    {
      localNearbyTabInfo = (NearbyTabInfo)this.mTabInfos.get(i);
      if (localNearbyTabInfo.getTabType() != 7)
      {
        i += 1;
      }
      else
      {
        RedDotTextView localRedDotTextView = this.mBarView.b(i);
        if (getNearbyMatchMakerRedNum(localRedDotTextView) > 0) {
          bool = true;
        }
        localNearbyTabInfo.setShowRedRot(bool);
        if (bool) {
          localRedDotTextView.a(localNearbyTabInfo.isShowRedRot());
        }
      }
    }
  }
  
  private static void updateTabRedTouch(RedTouch paramRedTouch, int paramInt)
  {
    NearbyActivityHelper.a(paramRedTouch, paramInt);
  }
  
  public void addTitleOnClick(View.OnClickListener paramOnClickListener)
  {
    this.titleClickListeners.add(paramOnClickListener);
  }
  
  public void checkNearbyUserAuth()
  {
    this.mNearbyHandler.b();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("NearbyActivity->doOnActivityResult, reqCode=");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d("nearby.NearbyActivity", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramInt1 == 1000) || (paramInt1 == 1001)) {
      NearbyPublishMenuHelper.a(this, paramInt1, paramInt2, paramIntent);
    }
    if (this.mIsNew)
    {
      this.mNearbyActivityController.a(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (paramInt1 == 10002)
    {
      paramIntent = new Intent(this, QQBrowserActivity.class);
      paramIntent.putExtra("url", "https://nearby.qq.com/nearby-index/my_msg.html?_wv=1031&_bid=3027");
      startActivity(paramIntent);
      overridePendingTransition(2130772005, 2130772006);
      return;
    }
    if (paramInt1 == 10001)
    {
      if (paramInt2 == -1)
      {
        paramInt1 = paramIntent.getIntExtra("curIndex", -1);
        paramInt2 = paramIntent.getIntExtra("unReadMsgNum", 0);
        boolean bool = paramIntent.getBooleanExtra("isNeedFinish", false);
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("index=");
          paramIntent.append(paramInt1);
          paramIntent.append(", unReadMsgNum=");
          paramIntent.append(paramInt2);
          paramIntent.append(", isNeedFinish=");
          paramIntent.append(bool);
          QLog.d("nearby.msgbox.tab", 2, paramIntent.toString());
        }
        if (bool) {
          super.finish();
        } else if ((paramInt1 >= 0) && (paramInt1 < this.mTabInfos.size())) {
          this.mBarView.setSelectedTab(paramInt1, false);
        }
        this.mLastUnreadNum = paramInt2;
        updateTabRedTouch(this.mMsgTabRedTouch, paramInt2);
      }
      return;
    }
    Object localObject = getFragmentByIndex(this.mResumeTabIndex);
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
    enterNearbyTime = System.currentTimeMillis();
    enterNearbyTimeCost = enterNearbyTime - getIntent().getLongExtra("CLICK_ENTER_TIME", System.currentTimeMillis());
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("enter nearby success, time cost: ");
    ((StringBuilder)localObject1).append(enterNearbyTimeCost);
    QLog.i("nearby.NearbyActivity-timecost", 1, ((StringBuilder)localObject1).toString());
    this.mIsNew = getIntent().getBooleanExtra("is_new", false);
    if (this.mIsNew)
    {
      this.mNearbyActivityController = new NearbyActivityController(this);
      NearbyStatusBarHelper.a(this);
      bool = super.doOnCreate(paramBundle);
      this.mNearbyHandler = ((NearbyHandler)this.app.getBusinessHandler(NearbyConstants.a));
      this.app.addObserver(this.mNearbyObserver);
      this.app.addNearbyProcObserver(this.mINearbyProcObserver);
      setContentView(getLayoutResId());
      this.mNearbyActivityController.a();
      this.mHeartBeatHandler.sendEmptyMessageDelayed(1001, 1000L);
      if ((!isFinishing()) && (!this.isStopHeartBeat)) {
        notifyServerEnterNearby();
      }
      NearbyReportHelperImpl.reportEnterNewNearbySuccess(this);
      return bool;
    }
    NearbyReportHelperImpl.reportEnterOldNearbySuccess(this);
    long l = System.currentTimeMillis();
    MatchMakerPlugin.a();
    this.mMsgBoxTabIndex = initTabs(this.mTabInfos);
    setImmersiveStatus(-1);
    boolean bool = super.doOnCreate(paramBundle);
    setNavBarBgWhiteColor();
    if (getIntent().getBooleanExtra("key_from_location", false))
    {
      finish();
      return true;
    }
    try
    {
      ReportController.b(null, "dc00899", "grp_lbs", "", "entry", "open_nearby_act_total_tmp", 0, 0, Build.MODEL, Build.VERSION.SDK, "", "");
      label298:
      if (this.app == null)
      {
        finish();
        QLog.e("nearby.NearbyActivity", 1, "doOnCreate app==null, goto finish");
        return false;
      }
      this.mNearbyHandler = ((NearbyHandler)this.app.getBusinessHandler(NearbyConstants.a));
      localObject1 = getIntent();
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = fillIntent();
      }
      paramBundle.setExtrasClassLoader(DatingFilters.class.getClassLoader());
      if (TextUtils.isEmpty(paramBundle.getStringExtra("big_brother_source_key"))) {
        paramBundle.putExtra("big_brother_source_key", "biz_src_hdsp_nearby");
      }
      Object localObject2 = null;
      if (paramBundle == null)
      {
        localObject1 = paramBundle;
        paramBundle = (Bundle)localObject2;
      }
      else
      {
        try
        {
          localObject1 = paramBundle.getStringExtra("url");
          localObject2 = localObject1;
          localObject1 = paramBundle;
          paramBundle = (Bundle)localObject2;
        }
        catch (Throwable paramBundle)
        {
          if (QLog.isColorLevel()) {
            QLog.i("nearby.NearbyActivity", 2, paramBundle.getMessage(), paramBundle);
          }
          localObject1 = fillIntent();
          paramBundle = (Bundle)localObject2;
        }
      }
      localObject2 = paramBundle;
      if (TextUtils.isEmpty(paramBundle)) {
        localObject2 = SharedPreUtils.ah(this, this.app.getCurrentAccountUin());
      }
      if (!Utils.a(localObject2, SharedPreUtils.ah(this, this.app.getCurrentAccountUin())))
      {
        this.mFrom = 1;
        paramBundle = new Intent(this, QQBrowserActivity.class);
        paramBundle.putExtra("url", URLUtil.guessUrl((String)localObject2));
        startActivity(paramBundle);
        finish();
        return bool;
      }
      if (this.app.getmLastTabIndex() < this.mTabInfos.size()) {
        i = ((NearbyTabInfo)this.mTabInfos.get(this.app.getmLastTabIndex())).getTabType();
      } else {
        i = 5;
      }
      int i = ((Intent)localObject1).getIntExtra("TAB_TYPE", i);
      if (i == 3)
      {
        this.mClickTime = ((Intent)localObject1).getLongExtra("ENTER_TIME", l);
        this.mOnCreateMilliTimeStamp = l;
        if (QLog.isDevelopLevel()) {
          NearbyUtils.a("WebSpeedTrace", "mClickTime", new Object[] { "doOnCreate", Long.valueOf(this.mClickTime) });
        }
      }
      if (i == 2)
      {
        this.mNowClickTime = ((Intent)localObject1).getLongExtra("ENTER_TIME", l);
        this.mNowOnCreateMilliTimeStamp = l;
        if (QLog.isDevelopLevel()) {
          NearbyUtils.a("WebSpeedTrace", "mClickTime", new Object[] { "doOnCreate", Long.valueOf(this.mClickTime) });
        }
      }
      this.mNearbyUsingTimeReport = new NearbyUsingTimeReport(this.app, "grp_lbs", "basic", "visit_time");
      this.mNearbyUsingTimeReport.b();
      this.app.addObserver(this.mNearbyObserver);
      this.app.addNearbyProcObserver(this.mINearbyProcObserver);
      checkNearbyUserAuth();
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
        {
          requestPermissions(new NearbyActivity.1(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
          return bool;
        }
        NearbyReportHelperImpl.reportRequestLocation(this, false, false);
      }
      return bool;
    }
    catch (Exception paramBundle)
    {
      break label298;
    }
  }
  
  public void doOnDestroy()
  {
    try
    {
      super.doOnDestroy();
    }
    catch (Exception localException1)
    {
      if (QLog.isDevelopLevel()) {
        localException1.printStackTrace();
      }
    }
    if (this.app == null) {
      return;
    }
    this.mHeartBeatHandler.removeCallbacksAndMessages(null);
    Object localObject = (NearbyReportManager)this.app.getManager(NearbyConstants.j);
    if (localObject != null)
    {
      ((NearbyReportManager)localObject).a();
      ((NearbyReportManager)localObject).c = true;
    }
    localObject = ViewExposeUtil.a(getClass(), hashCode());
    if (localObject != null)
    {
      long l1 = SystemClock.elapsedRealtime();
      long l2 = ((ViewExposeUtil.ViewExposeUnit)localObject).c;
      this.app.reportClickEventAsync("CliOper", "", "", ((ViewExposeUtil.ViewExposeUnit)localObject).d, ((ViewExposeUtil.ViewExposeUnit)localObject).d, ((ViewExposeUtil.ViewExposeUnit)localObject).e, 0, Long.toString(l1 - l2), "", "", "");
    }
    try
    {
      getIntent().getIntExtra("FROM_WHERE", -1);
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
    NearbyImgLoader.a().c();
    NearbyUsingTimeReport localNearbyUsingTimeReport = this.mNearbyUsingTimeReport;
    if (localNearbyUsingTimeReport != null)
    {
      int i = this.mTabBarIndex;
      localNearbyUsingTimeReport.a(i, i);
      this.mNearbyUsingTimeReport.c();
    }
    this.app.removeNearbyProcObserver(this.mINearbyProcObserver);
    this.app.removeObserver(this.mNearbyObserver);
    notifyServerExitNearby();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (!this.mIsNew) {
      initTitle();
    }
    if (paramIntent.getBooleanExtra("key_from_location", false))
    {
      showClearLocationConfirmDialog();
      return;
    }
    if (!this.mIsNew)
    {
      int i = this.app.getmLastTabIndex();
      if (i >= 0)
      {
        this.mBarView.setSelectedTab(i, false);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("doOnNewIntent setSelectedTab:");
          localStringBuilder.append(i);
          QLog.i("nearby.NearbyActivity", 2, localStringBuilder.toString());
        }
      }
    }
    if ((this.mIsNew) && (NearbyAlbumHelperImpl.getLock()))
    {
      NearbyAlbumHelperImpl.onPickPhoto(paramIntent);
      NearbyAlbumHelperImpl.setLock(false);
      return;
    }
    NearbyPublishMenuHelper.a(this, 1000, -1, paramIntent);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.mIsNew) {
      return;
    }
    if (this.app.ismNeedStoreAnchorage()) {
      this.app.setmLastTabIndex(this.mResumeTabIndex);
    } else {
      this.app.setmLastTabIndex(0);
    }
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("Q.nearby", "doOnPause", new Object[] { Boolean.valueOf(this.app.ismNeedStoreAnchorage()), Integer.valueOf(this.app.getmLastTabIndex()) });
    }
    ((DynamicAvatarManager)this.app.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER)).d();
    Object localObject = getFragmentByIndex(this.mViewPager.getCurrentItem());
    if ((localObject instanceof NearbyHybridFragment))
    {
      localObject = (NearbyHybridFragment)localObject;
      ((NearbyHybridFragment)localObject).k();
      ((NearbyHybridFragment)localObject).B();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (!BaseApplicationImpl.getApplication().getRuntime().isLogin()) {
      finish();
    }
    if (this.mIsNew)
    {
      this.mHandler.sendEmptyMessageDelayed(2, 0L);
      this.mNearbyActivityController.f();
      return;
    }
    NearbyBaseFragment localNearbyBaseFragment = getFragmentByIndex(this.mViewPager.getCurrentItem());
    if ((localNearbyBaseFragment instanceof NearbyHybridFragment)) {
      ((NearbyHybridFragment)localNearbyBaseFragment).j();
    }
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("nearby.NearbyActivity", 2, "doOnSaveInstanceState");
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (this.mIsNew) {
      return;
    }
    if ((paramBoolean) && (!this.mIsInit))
    {
      this.mIsInit = true;
      this.mHandler.sendEmptyMessageDelayed(1, 1000L);
    }
  }
  
  public void finish()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if ((localInputMethodManager != null) && (getCurrentFocus() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
    super.finish();
    if (this.mApbFlag) {
      overridePendingTransition(2130772005, 2130772006);
    }
  }
  
  public AbsWebView getAbsWebView()
  {
    NearbyFragmentPagerAdapterImpl localNearbyFragmentPagerAdapterImpl = this.mPagerAdapter;
    if ((localNearbyFragmentPagerAdapterImpl != null) && (localNearbyFragmentPagerAdapterImpl.getHotChatFragment() != null)) {
      return ((HotChatFragment)this.mPagerAdapter.getHotChatFragment()).b;
    }
    return null;
  }
  
  public int getBackgroundDrawableResource()
  {
    if ((ThemeUtil.getUserCurrentThemeId((AppRuntime)this.app).equals("1000")) && (!ThemeUtil.isInNightMode((AppRuntime)this.app)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyActivity", 2, "default theme daymode,clear decorview background");
      }
      return 0;
    }
    return 2130838958;
  }
  
  public NearbyActivityController getController()
  {
    return this.mNearbyActivityController;
  }
  
  public int getCurrentIndex()
  {
    return this.mTabBarIndex;
  }
  
  public long getDetect302Time()
  {
    return 0L;
  }
  
  public NearbyBaseFragment getFragmentByIndex(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.mTabInfos.size()))
    {
      NearbyTabInfo localNearbyTabInfo = (NearbyTabInfo)this.mTabInfos.get(paramInt);
      return (NearbyBaseFragment)this.mgrFragment.findFragmentByTag(localNearbyTabInfo.getTabTag());
    }
    return null;
  }
  
  public HotChatFragment getHotChatFragment()
  {
    return (HotChatFragment)this.mPagerAdapter.getHotChatFragment();
  }
  
  public boolean getIsReloadUrl()
  {
    AbsWebView localAbsWebView = getAbsWebView();
    boolean bool;
    if (localAbsWebView == null) {
      bool = false;
    } else {
      bool = OfflinePlugin.e(localAbsWebView.mWebview);
    }
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("WebSpeedTrace", "getIsReloadUrl", new Object[] { Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public int getLayoutResId()
  {
    if (this.mIsNew) {
      return 1946484755;
    }
    return 2131625498;
  }
  
  public RedTouch getMsgTabRedTouch()
  {
    return this.mMsgTabRedTouch;
  }
  
  public AppInterface getNearbyAppInterface()
  {
    return (AppInterface)this.app;
  }
  
  public NearbyHybridFragment getNearbyHybridFragment()
  {
    NearbyHybridFragment localNearbyHybridFragment = (NearbyHybridFragment)this.mPagerAdapter.getNearbyHybridFragment();
    Object localObject1 = localNearbyHybridFragment;
    if (localNearbyHybridFragment == null)
    {
      Object localObject2 = this.mTabInfos;
      localObject1 = localNearbyHybridFragment;
      if (localObject2 != null)
      {
        localObject1 = localNearbyHybridFragment;
        if (((ArrayList)localObject2).size() > 0)
        {
          int i = 0;
          for (;;)
          {
            localObject1 = localNearbyHybridFragment;
            if (i >= this.mTabInfos.size()) {
              break;
            }
            localObject1 = (NearbyTabInfo)this.mTabInfos.get(i);
            localObject1 = (NearbyBaseFragment)this.mgrFragment.findFragmentByTag(((NearbyTabInfo)localObject1).getTabTag());
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("getNearbyHybridFragment is null, search:");
              ((StringBuilder)localObject2).append(i);
              ((StringBuilder)localObject2).append(", ");
              ((StringBuilder)localObject2).append(localObject1);
              QLog.d("nearby.NearbyActivity", 2, ((StringBuilder)localObject2).toString());
            }
            if ((localObject1 instanceof NearbyHybridFragment))
            {
              localObject1 = (NearbyHybridFragment)localObject1;
              this.mPagerAdapter.setNearbyHybridFragment(localObject1);
              break;
            }
            i += 1;
          }
        }
      }
    }
    if ((QLog.isColorLevel()) && (localObject1 == null)) {
      QLog.d("nearby.NearbyActivity", 2, "getNearbyHybridFragment is null");
    }
    return localObject1;
  }
  
  public NowLiveFragment getNowLivFramgent()
  {
    return (NowLiveFragment)this.mPagerAdapter.getNowLiveFragment();
  }
  
  public long getOpenUrlAfterCheckOfflineTime()
  {
    AbsWebView localAbsWebView = getAbsWebView();
    long l;
    if (localAbsWebView == null) {
      l = 0L;
    } else {
      l = OfflinePlugin.c(localAbsWebView.mWebview);
    }
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("WebSpeedTrace", "getOpenUrlAfterCheckOfflineTime", new Object[] { Long.valueOf(l) });
    }
    return l;
  }
  
  public long getReadIndexFromOfflineTime()
  {
    AbsWebView localAbsWebView = getAbsWebView();
    long l;
    if (localAbsWebView == null) {
      l = 0L;
    } else {
      l = OfflinePlugin.d(localAbsWebView.mWebview);
    }
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("WebSpeedTrace", "getReadIndexFromOfflineTime", new Object[] { Long.valueOf(l) });
    }
    return l;
  }
  
  public int getTabIndexByType(int paramInt)
  {
    Iterator localIterator = this.mTabInfos.iterator();
    while (localIterator.hasNext())
    {
      NearbyTabInfo localNearbyTabInfo = (NearbyTabInfo)localIterator.next();
      if (localNearbyTabInfo.getTabType() == paramInt) {
        return localNearbyTabInfo.getTabIndex();
      }
    }
    return 0;
  }
  
  public ImageView getTitleBarLeftBackIcon()
  {
    return this.mLeftBackIcon;
  }
  
  public JSONObject getX5Performance()
  {
    AbsWebView localAbsWebView = getAbsWebView();
    if (localAbsWebView != null) {
      return localAbsWebView.mX5PerformanceJson;
    }
    return null;
  }
  
  public long getgetWebViewTime()
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("WebSpeedTrace", "getgetWebViewTime", new Object[] { Long.valueOf(this.mInitWebViewTime) });
    }
    return this.mInitWebViewTime;
  }
  
  public long getinitBrowserTime()
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("WebSpeedTrace", "getinitBrowserTime", new Object[] { Long.valueOf(this.mPreloadTime) });
    }
    return this.mPreloadTime;
  }
  
  public long getinitTBSTime()
  {
    return 0L;
  }
  
  public long getinitTime()
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("WebSpeedTrace", "getinitTime", new Object[] { Long.valueOf(this.mInitTime) });
    }
    return this.mInitTime;
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
      NearbyUtils.a("WebSpeedTrace", "getmClickTime", new Object[] { Long.valueOf(this.mClickTime) });
    }
    return this.mClickTime;
  }
  
  public long getmOnCreateMilliTimeStamp()
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("WebSpeedTrace", "getmOnCreateMilliTimeStamp", new Object[] { Long.valueOf(this.mOnCreateMilliTimeStamp) });
    }
    return this.mOnCreateMilliTimeStamp;
  }
  
  public boolean getmPerfFirstLoadTag()
  {
    AbsWebView localAbsWebView = getAbsWebView();
    boolean bool;
    if (localAbsWebView == null) {
      bool = false;
    } else {
      bool = localAbsWebView.isPerfFirstLoadTag();
    }
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("WebSpeedTrace", "getmPerfFirstLoadTag", new Object[] { Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public long getmStartLoadUrlMilliTimeStamp()
  {
    AbsWebView localAbsWebView = getAbsWebView();
    long l;
    if (localAbsWebView == null) {
      l = 0L;
    } else {
      l = localAbsWebView.getStartLoadUrlMilliTimeStamp();
    }
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("WebSpeedTrace", "getmStartLoadUrlMilliTimeStamp", new Object[] { Long.valueOf(l) });
    }
    return l;
  }
  
  public long getmTimeBeforeLoadUrl()
  {
    AbsWebView localAbsWebView = getAbsWebView();
    long l;
    if (localAbsWebView == null) {
      l = 0L;
    } else {
      l = localAbsWebView.getTimeBeforeLoadUrl();
    }
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("WebSpeedTrace", "getmTimeBeforeLoadUrl", new Object[] { Long.valueOf(l) });
    }
    return l;
  }
  
  public long getonCreateTime()
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("WebSpeedTrace", "getonCreateTime", new Object[] { Long.valueOf(this.onCreateTime) });
    }
    return this.onCreateTime;
  }
  
  public long getpluginFinished()
  {
    return 0L;
  }
  
  public long getviewInflateTime()
  {
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("WebSpeedTrace", "getviewInflateTime", new Object[] { Long.valueOf(this.mViewInflateTime) });
    }
    return this.mViewInflateTime;
  }
  
  public void grant()
  {
    if (getNearbyHybridFragment() != null) {
      getNearbyHybridFragment().c();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int j = paramMessage.what;
    int i = 1;
    if (j != 1)
    {
      if (j != 2) {
        return false;
      }
      this.mMsgTabRedDotRetryTime += 1;
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("MSG_INIT_MSGTAB_REDDOT，retryTime=");
        paramMessage.append(this.mMsgTabRedDotRetryTime);
        paramMessage.append(", msgBoxTabIndex=");
        paramMessage.append(this.mMsgBoxTabIndex);
        QLog.d("nearby.msgbox.tab", 2, paramMessage.toString());
      }
      if (this.mIsNew)
      {
        paramMessage = this.mNearbyActivityController;
        if (NearbyActivityController.a == TabInfo.a) {}
      }
      else
      {
        while (this.mBarView.getSelectedTabIndex() != this.mMsgBoxTabIndex)
        {
          i = 0;
          break;
        }
      }
      if ((this.mMsgBoxTabIndex >= 0) && (i == 0) && (this.mMsgTabRedTouch != null))
      {
        paramMessage = this.app.getNearbyProcManager();
        if (paramMessage.h())
        {
          i = paramMessage.g();
          updateTabRedTouch(this.mMsgTabRedTouch, i);
          if (QLog.isColorLevel())
          {
            paramMessage = new StringBuilder();
            paramMessage.append("MSG_INIT_MSGTAB_REDDOT，curRedNum=");
            paramMessage.append(i);
            paramMessage.append("");
            QLog.d("nearby.msgbox.tab", 2, paramMessage.toString());
          }
          this.mLastUnreadNum = i;
          return false;
        }
        if (this.mMsgTabRedDotRetryTime < 3)
        {
          this.mHandler.sendEmptyMessageDelayed(2, 1000L);
          return false;
        }
      }
    }
    else
    {
      if (this.mIsNew) {
        return false;
      }
      ThreadManager.post(new NearbyActivity.2(this), 8, null, true);
      try
      {
        i = getIntent().getIntExtra("NEARBY_IS_HAS_ICON", 2);
        ViewExposeUtil.a((AppInterface)this.app, getClass(), hashCode(), "0X80059D6", i);
        return false;
      }
      catch (Throwable paramMessage)
      {
        paramMessage.printStackTrace();
      }
    }
    return false;
  }
  
  public int initTabs(ArrayList<NearbyTabInfo> paramArrayList)
  {
    paramArrayList.clear();
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    localObject1 = (String)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(((AppRuntime)localObject1).getAccount(), "key_tabs_array", "");
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initTabs:");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("nearby.NearbyActivity", 2, ((StringBuilder)localObject2).toString());
    }
    int i = -1;
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      int n;
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        j = 0;
        k = 0;
        i = -1;
        try
        {
          if (j < ((JSONArray)localObject1).length())
          {
            localObject2 = ((JSONArray)localObject1).optJSONObject(j);
            NearbyTabInfo localNearbyTabInfo2 = new NearbyTabInfo();
            localNearbyTabInfo2.setTabName(((JSONObject)localObject2).optString("tabName"));
            localNearbyTabInfo2.setTabIndex(((JSONObject)localObject2).optInt("tabIndex"));
            localNearbyTabInfo2.setReportId(((JSONObject)localObject2).optInt("reportId"));
            localNearbyTabInfo2.setTabUrl(((JSONObject)localObject2).optString("tabUrl"));
            localNearbyTabInfo2.setTabType(((JSONObject)localObject2).optInt("tabType"));
            localNearbyTabInfo2.setDisableScroll(((JSONObject)localObject2).optInt("disableScroll"));
            localNearbyTabInfo2.setNeedLoc(((JSONObject)localObject2).optInt("needLoc"));
            localNearbyTabInfo2.setAutoEnter(((JSONObject)localObject2).optInt("autoEnter"));
            localNearbyTabInfo2.setShowRedRot(((JSONObject)localObject2).optBoolean("showRedRot"));
            m = k;
            if (!TextUtils.isEmpty(localNearbyTabInfo2.getTabName()))
            {
              m = k;
              if (localNearbyTabInfo2.getTabName().length() <= 4)
              {
                if (localNearbyTabInfo2.getTabType() == 1) {
                  break label544;
                }
                paramArrayList.add(localNearbyTabInfo2);
                m = k;
              }
            }
            n = i;
            if (localNearbyTabInfo2.getTabType() != 6) {
              break label550;
            }
            n = localNearbyTabInfo2.getTabIndex();
            break label550;
          }
          j = paramArrayList.size();
          if (j != 0)
          {
            if (k != 0)
            {
              try
              {
                if (!QLog.isColorLevel()) {
                  break label564;
                }
                QLog.w("nearby.NearbyActivity", 2, "initTabs, isOldConfig=true, reset tabindex");
              }
              catch (Exception localException1)
              {
                j = 0;
                break label418;
              }
              if (j < paramArrayList.size())
              {
                ((NearbyTabInfo)paramArrayList.get(j)).setTabIndex(j);
                j += 1;
                continue;
              }
            }
            j = 0;
          }
          else
          {
            j = 1;
          }
        }
        catch (Exception localException2) {}
        j = 1;
      }
      catch (Exception localException3) {}
      label418:
      if (QLog.isColorLevel()) {
        QLog.e("nearby.NearbyActivity", 2, "initTabs exception:", localException3);
      }
      break label440;
      int j = 1;
      label440:
      if (j != 0)
      {
        NearbyTabInfo localNearbyTabInfo1 = new NearbyTabInfo();
        localNearbyTabInfo1.setTabName(HardCodeUtil.a(2131904970));
        localNearbyTabInfo1.setTabIndex(0);
        localNearbyTabInfo1.setTabUrl("https://nearby.qq.com/nearby-index/index.html?_wv=1031&_proxy=1&_wwv=128");
        localNearbyTabInfo1.setTabType(5);
        paramArrayList.add(localNearbyTabInfo1);
        localNearbyTabInfo1 = new NearbyTabInfo();
        localNearbyTabInfo1.setTabName(HardCodeUtil.a(2131904971));
        localNearbyTabInfo1.setTabIndex(1);
        localNearbyTabInfo1.setTabUrl("");
        localNearbyTabInfo1.setTabType(2);
        paramArrayList.add(localNearbyTabInfo1);
      }
      Collections.sort(paramArrayList);
      return i;
      label544:
      int m = 1;
      continue;
      label550:
      j += 1;
      int k = m;
      i = n;
      continue;
      label564:
      j = 0;
    }
  }
  
  void initTitle()
  {
    setTitle(2131892066);
    this.mApbFlag = getIntent().getBooleanExtra("abp_flag", this.mApbFlag);
    this.mFrom = getIntent().getIntExtra("FROM_WHERE", this.mFrom);
    if (!this.mApbFlag)
    {
      int i = this.mFrom;
      if (i != 0)
      {
        if (i == 1003)
        {
          setLeftViewName(2131890674);
          return;
        }
        if (i == 1004)
        {
          setLeftViewName(2131886199);
          return;
        }
        if (i == 1002)
        {
          setLeftViewName(2131886175);
          return;
        }
        setLeftViewName(getIntent());
        return;
      }
    }
    setLeftViewName(2131917005);
  }
  
  public void initViews()
  {
    if (this.mIsNew) {
      return;
    }
    this.mViewPager = ((NonSwipeableViewPager)findViewById(2131450002));
    this.mViewPager.requestParentDisallowInterecptTouchEvent(true);
    this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
    this.mViewPager.setPagingEnabled(false);
    this.mBarView = ((TabBarView)findViewById(2131446735));
    this.mBarView.setOnTabChangeListener(this);
    initTabBarView(this, this.mBarView, this.mTabInfos);
    if (this.mTabInfos.size() > 0)
    {
      i = this.mMsgBoxTabIndex;
      if ((i >= 0) && (i < this.mTabInfos.size())) {
        this.mMsgTabRedTouch = getTabRedTouch(this, this.mBarView, this.mTabInfos.size(), this.mMsgBoxTabIndex);
      }
    }
    if (this.titleRoot != null)
    {
      this.titleRightImg = ((ImageView)this.titleRoot.findViewById(2131444897).findViewById(2131436194));
      this.centerView = ((TextView)this.titleRoot.findViewById(2131436227));
      this.mTitleTopBottom = ((RelativeLayout)this.titleRoot.findViewById(2131447534));
    }
    initTitle();
    int m = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.app.getCurrentAccountUin(), "key_auto_enter_without_redot", Integer.valueOf(0))).intValue();
    int j = 0;
    int i = -1;
    while (j < this.mTabInfos.size())
    {
      localObject = (NearbyTabInfo)this.mTabInfos.get(j);
      if (((NearbyTabInfo)localObject).getAutoEnter() == 1) {
        i = ((NearbyTabInfo)localObject).getTabIndex();
      }
      j += 1;
    }
    this.mgrFragment = getSupportFragmentManager();
    this.mPagerAdapter = new NearbyFragmentPagerAdapterImpl(this.mgrFragment, this.mTabInfos);
    this.mViewPager.setAdapter(this.mPagerAdapter);
    j = this.app.getmLastTabIndex();
    int k;
    if (this.app.getNearbyProcManager().a(5) != null)
    {
      j = getTabIndexByType(5);
      k = 1;
    }
    else
    {
      k = 0;
    }
    if (k != 0 ? (m != 1) && (i == -1) : i == -1) {
      i = j;
    }
    if (getIntent().hasExtra("TAB_TYPE")) {
      i = getTabIndexByType(getIntent().getIntExtra("TAB_TYPE", 5));
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("tabIdx=");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(", tabs.size=");
    ((StringBuilder)localObject).append(this.mTabInfos.size());
    QLog.d("nearby.NearbyActivity", 1, ((StringBuilder)localObject).toString());
    if (i >= 0)
    {
      j = i;
      if (i < this.mTabInfos.size()) {}
    }
    else
    {
      j = 0;
    }
    NearbyBaseFragment.j = j;
    this.app.setmNeedStoreAnchorage(true);
    this.app.setmLastTabIndex(j);
    i = ((NearbyTabInfo)this.mTabInfos.get(j)).getTabIndex();
    if ((((NearbyTabInfo)this.mTabInfos.get(j)).getAutoEnter() == 1) && (((NearbyTabInfo)this.mTabInfos.get(j)).getTabUrl() != null))
    {
      localObject = ((NearbyTabInfo)this.mTabInfos.get(j)).getTabUrl();
      StringBuilder localStringBuilder;
      if (((String)localObject).contains("?"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("&open_way=nearby_auto");
        localObject = localStringBuilder.toString();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("?open_way=nearby_auto");
        localObject = localStringBuilder.toString();
      }
      ((NearbyTabInfo)this.mTabInfos.get(j)).setTabUrl((String)localObject);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("autoEnter url = ");
        localStringBuilder.append((String)localObject);
        QLog.i("nearby.NearbyActivity", 2, localStringBuilder.toString());
      }
    }
    if (i < 0) {
      i = 0;
    }
    this.mBarView.setSelectedTab(i, false);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initViews, curIdx=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", msgTabBoxIdx=");
      ((StringBuilder)localObject).append(this.mMsgBoxTabIndex);
      ((StringBuilder)localObject).append(", tabs.size=");
      ((StringBuilder)localObject).append(this.mTabInfos.size());
      QLog.d("nearby.msgbox.tab", 2, ((StringBuilder)localObject).toString());
    }
    this.mHandler.sendEmptyMessageDelayed(2, 1000L);
    this.mResumeTabIndex = i;
    if (QLog.isColorLevel()) {
      NearbyUtils.a("MSG_INIT", new Object[] { Integer.valueOf(j), Integer.valueOf(this.app.getmLastTabIndex()), Integer.valueOf(NearbyBaseFragment.j) });
    }
    this.mHeartBeatHandler.sendEmptyMessageDelayed(1001, 1000L);
  }
  
  public boolean isMainPageUseLocalFile()
  {
    AbsWebView localAbsWebView = getAbsWebView();
    boolean bool;
    if (localAbsWebView == null) {
      bool = false;
    } else {
      bool = OfflinePlugin.a(localAbsWebView.mWebview);
    }
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("WebSpeedTrace", "isMainPageUseLocalFile", new Object[] { Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needHardAccelerated()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(Build.MODEL);
    localObject = ((StringBuilder)localObject).toString();
    return (Build.VERSION.SDK_INT > 10) && (!"Meizu_M040".equals(localObject));
  }
  
  public void notifyHeartBeat()
  {
    this.mNearbyHandler.a(3, null);
  }
  
  public void notifyServerEnterNearby()
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
    this.isStopHeartBeat = false;
    this.mNearbyHandler.a(1, localSosoLbsInfo);
  }
  
  public void notifyServerExitNearby()
  {
    this.mNearbyHandler.a(2, null);
    this.isStopHeartBeat = true;
  }
  
  protected boolean onBackEvent()
  {
    if (this.mIsNew) {
      return super.onBackEvent();
    }
    int i = this.mTabBarIndex;
    Object localObject;
    if (i >= 0)
    {
      localObject = getFragmentByIndex(i);
      if ((localObject != null) && (((TitlebarBaseFragment)localObject).D())) {
        return false;
      }
    }
    if ((this.mApbFlag) && (this.mFrom != 0))
    {
      localObject = new Intent(this, SplashActivity.class);
      ((Intent)localObject).putExtra("main_tab_id", 4);
      ((Intent)localObject).setFlags(603979776);
      startActivity((Intent)localObject);
    }
    return super.onBackEvent();
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    NearbyActivityHelper.a(this, this.mBarView);
  }
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    if (this.mIsNew) {
      return;
    }
    int i = this.mTabBarIndex;
    NearbyBaseFragment localNearbyBaseFragment;
    if (paramInt2 == i)
    {
      localNearbyBaseFragment = getFragmentByIndex(i);
      if (localNearbyBaseFragment != null) {
        localNearbyBaseFragment.e();
      }
      if (QLog.isColorLevel()) {
        NearbyUtils.a("onTabClicked", new Object[0]);
      }
    }
    if (QLog.isColorLevel()) {
      NearbyUtils.a("onTabSelected", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.mResumeTabIndex), Integer.valueOf(this.mViewPager.getCurrentItem()), Integer.valueOf(this.mTabBarIndex) });
    }
    paramInt1 = this.mTabBarIndex;
    if ((paramInt1 >= 0) && (paramInt1 != paramInt2))
    {
      localNearbyBaseFragment = getFragmentByIndex(paramInt1);
      if (localNearbyBaseFragment != null) {
        localNearbyBaseFragment.onHiddenChanged(true);
      }
      if (paramInt2 == this.mMsgBoxTabIndex) {
        startMsgBoxListActivity(true);
      }
    }
    this.mTabBarIndex = paramInt2;
    paramInt1 = this.mResumeTabIndex;
    if ((paramInt1 < 0) || (paramInt2 != paramInt1) || (paramInt2 != this.mViewPager.getCurrentItem())) {
      this.mViewPager.setCurrentItem(paramInt2, false);
    }
    if (paramInt2 == 0) {
      this.mViewPager.requestParentDisallowInterecptTouchEvent(false);
    } else {
      this.mViewPager.requestParentDisallowInterecptTouchEvent(true);
    }
    if (this.mResumeTabIndex == 3) {
      doClkActionReport((AppInterface)this.app, "0X8005CEA");
    }
    if (this.mResumeTabIndex == 1) {
      this.app.nearbyReportClickEvent("dc00899", "grp_lbs", "", "anchor_tab", "exp", 0, 0, "", "", "", "");
    }
  }
  
  public int pluginStartActivityForResult(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    int i = switchRequestCode(paramWebViewPlugin, paramByte);
    if (i == -1)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("nearby.NearbyActivity", 2, "pluginStartActivityForResult not handled");
        return i;
      }
    }
    else {
      startActivityForResult(paramIntent, i);
    }
    return i;
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
    if (this.mIsNew) {
      return;
    }
    if (isStatusBarSupportWhiteMode())
    {
      setImmersiveStatus(-1);
      return;
    }
    super.setImmersiveStatus();
  }
  
  public void setImmersiveStatus(int paramInt)
  {
    if (!isStatusBarSupportWhiteMode())
    {
      super.setImmersiveStatus();
      return;
    }
    if (this.mNeedStatusTrans)
    {
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, paramInt);
      }
      ImmersiveUtils.clearCoverForStatus(getWindow(), this.isClearCoverLayer);
      StatusBarUtil.a(this, false);
    }
  }
  
  protected String setLastActivityName()
  {
    if (this.mResumeTabIndex == 2) {
      return getString(2131891481);
    }
    return super.setLastActivityName();
  }
  
  public void setLastUnreadNum(int paramInt)
  {
    this.mLastUnreadNum = paramInt;
  }
  
  public void setMsgTabIndex(int paramInt)
  {
    this.mMsgBoxTabIndex = paramInt;
  }
  
  public void setMsgTabRedTouch(RedTouch paramRedTouch)
  {
    this.mMsgTabRedTouch = paramRedTouch;
    this.mHandler.sendEmptyMessageDelayed(2, 1000L);
  }
  
  public void setX5Performance(JSONObject paramJSONObject)
  {
    AbsWebView localAbsWebView = getAbsWebView();
    if (localAbsWebView != null) {
      localAbsWebView.mX5PerformanceJson = paramJSONObject;
    }
  }
  
  void showTestDialog()
  {
    if (this.testDialog == null)
    {
      this.testDialog = DialogUtil.a(this, 230);
      EditText localEditText1 = new EditText(this);
      EditText localEditText2 = new EditText(this);
      Button localButton1 = new Button(this);
      Button localButton2 = new Button(this);
      Button localButton3 = new Button(this);
      Button localButton4 = new Button(this);
      NearbyActivity.6 local6 = new NearbyActivity.6(this, localButton1, localEditText1, localButton2, localEditText2, localButton3, localButton4);
      localEditText1.setHint("tinyId");
      this.testDialog.addView(localEditText1);
      this.testDialog.addView(localButton1);
      localButton1.setText(HardCodeUtil.a(2131904963));
      localButton1.setOnClickListener(local6);
      localEditText2.setHint("uin");
      this.testDialog.addView(localEditText2);
      localButton2.setText(HardCodeUtil.a(2131904967));
      localButton2.setOnClickListener(local6);
      this.testDialog.addView(localButton2);
      localButton3.setText(HardCodeUtil.a(2131904972));
      localButton3.setOnClickListener(local6);
      this.testDialog.addView(localButton3);
      localButton4.setText("打开游戏邀请页面12人局");
      localButton4.setOnClickListener(local6);
      this.testDialog.addView(localButton4);
    }
    this.testDialog.show();
  }
  
  public void startActivityFromFragment(@androidx.annotation.NonNull Fragment paramFragment, Intent paramIntent, int paramInt, @Nullable Bundle paramBundle)
  {
    if (paramInt == -1)
    {
      ActivityCompat.startActivityForResult(this, paramIntent, -1, paramBundle);
      return;
    }
    ActivityCompat.startActivityForResult(this, paramIntent, paramInt, paramBundle);
  }
  
  public void startIntentSenderFromFragment(@androidx.annotation.NonNull Fragment paramFragment, IntentSender paramIntentSender, int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, @Nullable Bundle paramBundle)
  {
    if (paramInt1 == -1)
    {
      ActivityCompat.startIntentSenderForResult(this, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
      return;
    }
    ActivityCompat.startIntentSenderForResult(this, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
  }
  
  public void startMsgBoxListActivity(boolean paramBoolean)
  {
    String str = AppConstants.NEARBY_LBS_HELLO_UIN;
    Intent localIntent = new Intent(this, MsgBoxListActivity.class);
    localIntent.putExtra("uin", str);
    localIntent.putExtra("uintype", 1001);
    localIntent.putExtra("isFromNearby", true);
    localIntent.putExtra("tabs", this.mTabInfos);
    localIntent.putExtra("msgTabIndex", this.mMsgBoxTabIndex);
    localIntent.putExtra("mUnReadMsgNum", this.mLastUnreadNum);
    localIntent.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131904965));
    startActivityForResult(localIntent, 10001);
    if (paramBoolean) {
      overridePendingTransition(2130772361, 2130772361);
    }
    if (QLog.isColorLevel()) {
      QLog.d("nearby.msgbox.tab", 2, "startMsgBoxListActivity");
    }
    new ReportTask(null).a("dc00899").b("grp_lbs").c("msg_box").d("page_exp").a();
  }
  
  public int switchRequestCode(WebViewPlugin paramWebViewPlugin, byte paramByte)
  {
    CustomWebView localCustomWebView = paramWebViewPlugin.mRuntime.a();
    if (localCustomWebView == null) {
      return -1;
    }
    if (localCustomWebView.getPluginEngine() == null) {
      return -1;
    }
    int i = WebViewUtil.a(paramWebViewPlugin);
    if (i == -1)
    {
      if (QLog.isColorLevel())
      {
        paramWebViewPlugin = new StringBuilder();
        paramWebViewPlugin.append("switchRequestCode failed: webview index=");
        paramWebViewPlugin.append(0);
        paramWebViewPlugin.append(", pluginIndex=");
        paramWebViewPlugin.append(i);
        QLog.d("nearby.NearbyActivity", 2, paramWebViewPlugin.toString());
      }
      return -1;
    }
    return i << 8 & 0xFF00 | 0x0 | paramByte & 0xFF;
  }
  
  public void updateTitlebar(Object paramObject)
  {
    if (this.mIsNew) {
      return;
    }
    paramObject = (TitlebarStatus)paramObject;
    if (paramObject == null) {
      return;
    }
    Object localObject = getFragmentByIndex(NearbyBaseFragment.j);
    if (QLog.isColorLevel()) {
      NearbyUtils.a("nearby.NearbyActivity", new Object[] { "updateTitlebar", localObject, paramObject.k });
    }
    if (localObject != paramObject.k) {
      return;
    }
    if (paramObject.b)
    {
      if (this.centerView.getVisibility() != 0) {
        this.centerView.setVisibility(0);
      }
      if (this.mTitleTopBottom.getVisibility() != 8) {
        this.mTitleTopBottom.setVisibility(8);
      }
      if (!Utils.a(paramObject.c, getTextTitle())) {
        setTitle(paramObject.c);
      }
    }
    else
    {
      if (this.centerView.getVisibility() != 4) {
        this.centerView.setVisibility(4);
      }
      if (!Utils.a(paramObject.c, getTextTitle())) {
        setTitle(paramObject.c);
      }
      if (this.mTitleTopBottom.getVisibility() != 0) {
        this.mTitleTopBottom.setVisibility(0);
      }
      if (paramObject.d != null)
      {
        localObject = (TextView)this.mTitleTopBottom.findViewById(2131447581);
        if (!Utils.a(paramObject.d, ((TextView)localObject).getText())) {
          ((TextView)localObject).setText(paramObject.d);
        }
      }
      if (paramObject.e != null)
      {
        localObject = (TextView)this.mTitleTopBottom.findViewById(2131447497);
        if (!Utils.a(paramObject.e, ((TextView)localObject).getText())) {
          ((TextView)localObject).setText(paramObject.e);
        }
      }
    }
    if (paramObject.a)
    {
      if (!isTitleProgressShowing()) {
        startTitleProgress();
      }
    }
    else if (isTitleProgressShowing()) {
      stopTitleProgress();
    }
    if (paramObject.f)
    {
      if (this.titleRightImg.getVisibility() != 0) {
        this.titleRightImg.setVisibility(0);
      }
      this.titleRightImg.setOnClickListener(paramObject.j);
      if ((AppSetting.e) && (paramObject.i != null)) {
        this.titleRightImg.setContentDescription(paramObject.i);
      }
      if (paramObject.h > 0) {
        this.titleRightImg.setImageResource(paramObject.h);
      }
      if (this.rightViewText.getVisibility() != 8) {
        this.rightViewText.setVisibility(8);
      }
    }
    else
    {
      if (this.titleRightImg.getVisibility() != 8) {
        this.titleRightImg.setVisibility(8);
      }
      if (TextUtils.isEmpty(paramObject.g))
      {
        if (this.rightViewText.getVisibility() != 8) {
          this.rightViewText.setVisibility(8);
        }
      }
      else if (this.rightViewText.getVisibility() != 0) {
        this.rightViewText.setVisibility(0);
      }
      if (!Utils.a(paramObject.g, this.rightViewText.getText())) {
        this.rightViewText.setText(paramObject.g);
      }
      this.rightViewText.setOnClickListener(paramObject.j);
    }
    this.centerView.setClickable(true);
    this.centerView.setOnClickListener(new NearbyActivity.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NearbyActivity
 * JD-Core Version:    0.7.0.1
 */