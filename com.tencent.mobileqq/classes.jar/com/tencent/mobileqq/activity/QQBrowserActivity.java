package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.lightGame.CmGameFragment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.ColorNoteController;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.Builder;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.colornote.swipeback.SwipePostTableLayout;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.shortvideo.util.ShortVideoGuideUtil;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.WebViewTitleStyleHelper;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.SwiftWebViewFragmentSupporter;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewFragmentBuilder;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.mobileqq.webview.swift.WebviewFragmentTabBarBuilder;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderContext;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserNavigator;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.TbsAccelerator;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.comic.utils.VipComicUrlHelper;
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

@RoutePage(desc="内置浏览器", path="/base/browser")
public class QQBrowserActivity
  extends FragmentActivity
  implements IServiceInfo, SwiftWebViewFragmentSupporter, SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderContext, IBrowserThirdAppReport
{
  public static final String ACTION_NAME = "action_name";
  public static final String APP_ID = "appid";
  public static final String APP_PARAM = "extraParams";
  public static final String ARTICAL_CHANNEL_EXTRAL_INFO = "ARTICAL_CHANNEL_EXTRAL_INFO";
  public static final String ARTICAL_CHANNEL_ID = "articalChannelId";
  public static final int CHANNEL_C2C_AIO = 2;
  public static final int CHANNEL_CONTACT_ADD_SEARCH = 12;
  public static final int CHANNEL_CONTACT_SEARCH = 11;
  public static final int CHANNEL_DISCUSSION_AIO = 4;
  public static final int CHANNEL_DYBAMIC_SEARCH = 13;
  public static final int CHANNEL_KANDIAN = 7;
  public static final int CHANNEL_NO_REPORT = 0;
  public static final int CHANNEL_OTHER = 100;
  public static final int CHANNEL_PB_AIO = 1;
  public static final int CHANNEL_QZONE_FEED = 5;
  public static final int CHANNEL_QZONE_KANDIAN = 6;
  public static final int CHANNEL_READINJOY_CONVERSION = 9;
  public static final int CHANNEL_READINJOY_SEARCH = 14;
  public static final int CHANNEL_TAB_SEARCH = 10;
  public static final int CHANNEL_TROOP_AIO = 3;
  public static final String EXTRA_FINISH_ANIMATION_NONE = "finish_animation_none";
  public static final String EXTRA_FINISH_ANIMATION_OUT_TO_RIGHT = "finish_animation_out_to_right";
  public static final String EXTRA_FINISH_ANIMATION_OUT_TO_TOP = "finish_animation_out_to_top";
  public static final String EXTRA_FINISH_ANIMATION_UP_DOWN = "finish_animation_up_down";
  private static final String FLAG_BROWSER_RESTORE = "browserRestoreFlag";
  public static final String FRAGMENT_CLASS = "fragment_class";
  public static final HashSet<String> HWForbiddenList = AbsBaseWebViewActivity.HWForbiddenList;
  public static final String INEWS_HEADLINES_URL = "miniqb://home";
  public static final String INEWS_PUBLIC_UIN = "2909288299";
  public static final String IS_OPENING_QUN_APP = "isOpeningQunApp";
  public static final String IS_SHOW_AD = "isShowAd";
  public static final String IS_WRAP_CONTENT = "is_wrap_content";
  public static final String KEY_DISCUSS_GROUP_UIN = "dicussgroup_uin";
  public static final String KEY_FAV_GROUP_ID = "favGroupID";
  public static final String KEY_FAV_ID = "favID";
  public static final String KEY_FRIEND_UIN = "friend_uin";
  public static final String KEY_FROM_FAV = "fromFav";
  public static final String KEY_FROM_NEARBY = "fromNearby";
  public static final String KEY_FROM_PUBLIC_AIO = "fromPublicAccount";
  public static final String KEY_GROUP_UIN = "groupUin";
  public static final String KEY_IS_SEND = "is_send";
  public static final String KEY_IS_TRANSPARENT_TITLE = "isTransparentTitle";
  private static final String KEY_MAINTAB_INDEX = "key_maintab";
  public static final String KEY_PAY_ACTION_RESULT = "key_pay_action_result";
  public static final String KEY_SCROLL_Y = "key_scroll_y";
  public static final String KEY_SENDER_UIN = "friendUin";
  public static final String KEY_TITLE_STYLE = "titleStyle";
  public static final String KEY_UIN_TYPE = "uinType";
  public static final String MAIN_ACTION = "webview";
  public static final String MI2 = "Xiaomi_MI 2";
  public static final String NAME_IS_LOGIN = "ba_is_login";
  public static final String ON_NEW_INTENT_REDO_STATEMACHINE = "onNewIntentReDoStateMachine";
  public static final int PLUGIN_START_REQUEST_CODE = 10000;
  public static final String QB_DOT_SHOW_VERSION_CODE_KEY = "version_code_key";
  public static final String QQBROWSERACTIVITY_CREATED_TIME = "qqBrowserActivityCreateTime";
  public static final String QQBROWSER_DOWNLOAD_URL_DIRECT = "https://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=50079";
  public static final String QQBROWSER_DOWNLOAD_URL_DIRECT_QBSHARE = "https://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10367";
  public static final int REQ_TYPE_BROWSE_ALBUM = 2;
  public static final int REQ_TYPE_EMOJI_SUB_PAGE = 6;
  public static final int REQ_TYPE_FIND_PASSWORD = 3;
  public static final int REQ_TYPE_FORWARD_DIALOG_PREVIEW = 7;
  public static final int REQ_TYPE_MODIFY_SELF_DETAIL = 1;
  public static final int REQ_TYPE_STREET_VIEW_MAP = 4;
  public static final int REQ_TYPE_TROOP_MEMBER_LEVEL = 5;
  public static final int RESULT_FINISHSELF = 4660;
  public static final int SUMMARY_FOR_SEND_TO_FRIEND = 1;
  public static final int SUMMARY_FOR_SEND_TO_READINJOY = 5;
  public static final int SUMMARY_FOR_SEND_TO_WECHAT = 3;
  public static final int SUMMARY_FOR_SEND_TO_WECHAT_CIRCLE = 4;
  public static final int SUMMARY_FOR_SHARE_TO_QZONE = 2;
  public static final String TAB_CONFIG_DATA = "tabConfigData";
  public static final String TAB_DEFAULT_INDEX = "tabDefaultIndex";
  public static final String TAG = "WebLog_QQBrowserActivity";
  public static final String TAG_WEB_REPORT = "web_report";
  public static final String TOPTAB_SELECT_INDEX = "topTabSelectIndex";
  public static final String TOPTAB_SWITCH_FRAGMENT = "topTabSwitchFragment";
  public static final String TROOP_ID = "troopid";
  public static final String WEB_FLOAT_SHORTCUT_FROM = "qqbrowser_float_shortcut";
  public static final String actionModifyDetailInfo = "com.tencent.mobileqq.card.modify";
  public static final String actionUpdateVipInfo = "com.tencent.mobileqq.opencenter.vipInfo";
  public static final String actionViewSelfAlbum = "com.tencent.mobileqq.view.self.album";
  public static final String broadcastActionKey = "broadcastAction";
  public static final String reqTypeKey = "reqType";
  public static int sQQBrowserActivityCounter = 0;
  public static long s_lastJumpWebTs;
  public int currentTabIndex = 0;
  private FrameLayout fragmentContentView;
  private ColorNote mColorNoteCache;
  protected ColorNoteController mColorNoteController;
  public final SwiftBrowserComponentsProvider mComponentsProvider = createComponentsProvider();
  private boolean mEnableSwipeLayout = true;
  public Class<? extends WebViewFragment> mFragmentClass = null;
  public int oldTabSelectIndex = -1;
  public ArrayList<WebViewTabBarData> tabBarConfigData;
  private View tabBarView;
  
  public static boolean checkNotFrequentlyThenEnter(long paramLong)
  {
    long l = System.currentTimeMillis();
    if (l - s_lastJumpWebTs > paramLong)
    {
      s_lastJumpWebTs = l;
      return true;
    }
    return false;
  }
  
  private void doFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_QQBrowserActivity", 2, "finish");
    }
    Object localObject = getCurrentWebViewFragment();
    if (localObject != null) {
      ((WebViewFragment)localObject).activityFinish();
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if ((localInputMethodManager != null) && (access$101(this) != null)) {
      localInputMethodManager.hideSoftInputFromWindow(access$201(this).getWindowToken(), 0);
    }
    super.finish();
    if ((this.mColorNoteController != null) && ((this.mColorNoteController.c()) || (this.mColorNoteController.d()))) {
      overridePendingTransition(0, 0);
    }
    if (getIntent().getBooleanExtra("finish_animation_up_down", false)) {
      overridePendingTransition(0, 2130771980);
    }
    if (getIntent().getBooleanExtra("finish_animation_out_to_right", false)) {
      overridePendingTransition(0, 2130772229);
    }
    if (getIntent().getBooleanExtra("finish_animation_out_to_top", false)) {
      overridePendingTransition(0, 2130772318);
    }
    if (getIntent().getBooleanExtra("finish_animation_none", false)) {
      overridePendingTransition(0, 0);
    }
    if ((localObject != null) && (((WebViewFragment)localObject).mUIStyle != null))
    {
      if ((((WebViewFragment)localObject).mUIStyle.d & 0x100) == 0L) {
        break label266;
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
      label266:
      if ((((WebViewFragment)localObject).mUIStyle.d & 0x200) != 0L) {
        overridePendingTransition(0, 2130772003);
      }
    }
  }
  
  public static boolean isCmShowUrl(String paramString)
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
  
  private void preInitWebViewFragment(Intent paramIntent)
  {
    String str = SwiftWebViewUtils.a(paramIntent);
    WebAccelerateHelper.getInstance().preGetKey(str, paramIntent, null);
    WebAccelerateHelper.getInstance().preCheckOffline(str);
    WebAccelerateHelper.getInstance().preFetchResource(str);
  }
  
  public static void setPreloadSucess(boolean paramBoolean)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("web_process_preload_file", 4).edit().putBoolean("key_preload", paramBoolean).commit();
  }
  
  private void showColorServiceTypeLog(int paramInt)
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
  
  public static WebViewFragment switchFragment(int paramInt, QQBrowserActivity paramQQBrowserActivity)
  {
    WebViewTabBarData localWebViewTabBarData = (WebViewTabBarData)paramQQBrowserActivity.tabBarConfigData.get(paramInt);
    WebViewFragment localWebViewFragment = paramQQBrowserActivity.getFragmentByTabBarData(localWebViewTabBarData);
    FragmentTransaction localFragmentTransaction = paramQQBrowserActivity.getSupportFragmentManager().beginTransaction();
    paramQQBrowserActivity.hideCurrentWebViewFragment(localFragmentTransaction);
    if (!localWebViewFragment.isAdded()) {
      localFragmentTransaction.add(2131365308, localWebViewFragment, localWebViewTabBarData.tag);
    }
    for (;;)
    {
      localFragmentTransaction.commitAllowingStateLoss();
      paramQQBrowserActivity.currentTabIndex = paramInt;
      return localWebViewFragment;
      localFragmentTransaction.show(localWebViewFragment);
    }
  }
  
  public SwiftBrowserComponentsProvider createComponentsProvider()
  {
    return new SwiftBrowserComponentsProvider(this, 1, null);
  }
  
  public WebViewFragment createFragment(Intent paramIntent)
  {
    Object localObject2;
    Object localObject1;
    if (this.mFragmentClass != null) {
      try
      {
        WebViewFragment localWebViewFragment1 = (WebViewFragment)this.mFragmentClass.newInstance();
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
          break label200;
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
          break label195;
        }
        WebViewFragment localWebViewFragment2 = new WebViewFragment();
        break;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
        if (0 != 0) {
          break label195;
        }
        WebViewFragment localWebViewFragment3 = new WebViewFragment();
        break;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        localClassNotFoundException.printStackTrace();
        if (0 != 0) {
          break label195;
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
      label195:
      localWebViewFragment4 = null;
      break;
      label200:
      localObject2 = null;
    }
  }
  
  public void createTabBarView()
  {
    if ((this.tabBarConfigData != null) && (this.tabBarConfigData.size() > 1) && (this.tabBarView == null))
    {
      this.tabBarView = WebviewFragmentTabBarBuilder.a(this, super.getIntent(), this.tabBarConfigData, new QQBrowserActivity.MyOnTabChangeListener(this));
      this.tabBarView.setId(2131378815);
      Object localObject = this.fragmentContentView.getParent();
      if (!(localObject instanceof FrameLayout)) {
        break label153;
      }
      if (!super.getIntent().getBooleanExtra("topTabSwitchFragment", false))
      {
        ((FrameLayout)localObject).addView(this.tabBarView, new FrameLayout.LayoutParams(-1, -2, 80));
        localObject = (FrameLayout.LayoutParams)this.fragmentContentView.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).bottomMargin = ((int)(54.0F * getResources().getDisplayMetrics().density + 0.5F));
        this.fragmentContentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    return;
    label153:
    QLog.e("WebLog_QQBrowserActivity", 1, "doOnCreate error:should not enter here!");
  }
  
  protected boolean directSuperDoOnCreate(Bundle paramBundle)
  {
    return super.doOnCreate(paramBundle);
  }
  
  protected void directSuperOnCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void disableSwipeLayout()
  {
    this.mEnableSwipeLayout = false;
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
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i("WebLog_QQBrowserActivity", 2, String.format("doOnActivityResult resultCode=0x%x", new Object[] { Integer.valueOf(paramInt2) }));
    }
    if (paramInt2 == 4660) {
      if (paramIntent != null)
      {
        super.setResult(4660, paramIntent);
        finish();
      }
    }
    for (;;)
    {
      WebViewFragment localWebViewFragment = getCurrentWebViewFragment();
      if (localWebViewFragment != null) {
        localWebViewFragment.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      }
      return;
      super.setResult(4660);
      break;
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
    com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.C = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_QQBrowserActivity", 2, "doOnCreate start");
    }
    if ((Build.VERSION.SDK_INT > 10) && (!HWForbiddenList.contains(Build.MANUFACTURER + "_" + Build.MODEL))) {
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
    ImmersiveUtils.clearCoverForStatus(getWindow(), true);
    paramBundle = super.getIntent();
    Object localObject2 = paramBundle.getSerializableExtra("tabConfigData");
    if ((localObject2 instanceof ArrayList)) {
      this.tabBarConfigData = ((ArrayList)localObject2);
    }
    if (this.tabBarConfigData == null)
    {
      localObject2 = new WebViewTabBarData();
      ((WebViewTabBarData)localObject2).tag = "web";
      ((WebViewTabBarData)localObject2).url = paramBundle.getStringExtra("url");
      if (((WebViewTabBarData)localObject2).url == null)
      {
        ((WebViewTabBarData)localObject2).url = "";
        QLog.e("WebLog_QQBrowserActivity", 1, "url = null");
      }
      this.tabBarConfigData = new ArrayList(1);
      this.tabBarConfigData.add(localObject2);
      localObject2 = paramBundle.getExtras();
      if (localObject2 != null)
      {
        if (!isCmShowUrl(SwiftWebViewUtils.a(paramBundle))) {
          break label461;
        }
        this.mFragmentClass = CmGameFragment.class;
      }
      label304:
      this.fragmentContentView = ((FrameLayout)localObject1);
      if ((this.tabBarConfigData.size() > 1) && (!(((FrameLayout)localObject1).getParent() instanceof FrameLayout)))
      {
        this.fragmentContentView = new FrameLayout(this);
        ((FrameLayout)localObject1).addView(this.fragmentContentView, new FrameLayout.LayoutParams(-1, -1));
        QLog.i("WebLog_QQBrowserActivity", 1, "doOnCreate warning:content is not an instance of FrameLayout.");
      }
      this.fragmentContentView.setId(2131365308);
      int i = paramBundle.getIntExtra("tabDefaultIndex", 0);
      localObject1 = (WebViewTabBarData)this.tabBarConfigData.get(i);
      paramBundle.removeExtra("tabDefaultIndex");
      paramBundle = getFragmentByTabBarData((WebViewTabBarData)localObject1);
      if (paramBundle.isAdded()) {
        break label488;
      }
      super.getSupportFragmentManager().beginTransaction().add(2131365308, paramBundle, ((WebViewTabBarData)localObject1).tag).commitAllowingStateLoss();
    }
    for (;;)
    {
      if (this.mEnableSwipeLayout) {
        initColorNote();
      }
      return true;
      paramBundle.removeExtra("tabConfigData");
      break;
      label461:
      localObject2 = (Class)((Bundle)localObject2).getSerializable("fragmentClass");
      if (localObject2 == null) {
        break label304;
      }
      this.mFragmentClass = ((Class)localObject2);
      break label304;
      label488:
      super.getSupportFragmentManager().beginTransaction().show(paramBundle).commitAllowingStateLoss();
    }
  }
  
  public void doOnDestroy()
  {
    sQQBrowserActivityCounter -= 1;
    if (this.fragmentContentView != null)
    {
      ViewParent localViewParent = this.fragmentContentView.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.tabBarView);
      }
      this.tabBarView = null;
    }
    if ((this.mEnableSwipeLayout) && (this.mColorNoteController != null)) {
      this.mColorNoteController.c();
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
    WebViewFragment localWebViewFragment = getCurrentWebViewFragment();
    if (localWebViewFragment != null) {
      localWebViewFragment.doOnKeyDown(paramInt, paramKeyEvent);
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    WebViewFragment localWebViewFragment = getCurrentWebViewFragment();
    if (localWebViewFragment != null) {
      localWebViewFragment.doOnNewIntent(paramIntent);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if ((this.mEnableSwipeLayout) && (this.mColorNoteController != null))
    {
      this.mColorNoteController.b();
      if (getIntent().getBooleanExtra("isFromFavourite", false)) {
        this.mColorNoteController.p();
      }
    }
    if (ColorNoteUtils.b(getOriginalUrl()))
    {
      ColorNoteSmallScreenUtil.a(this, 2, true);
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_QQBrowserActivity", 2, "color note small screen visible by doOnPause");
      }
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if ((this.mEnableSwipeLayout) && (this.mColorNoteController != null)) {
      this.mColorNoteController.a();
    }
    if (ColorNoteUtils.b(getOriginalUrl()))
    {
      ColorNoteSmallScreenUtil.a(this, 2, false);
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
    if (this.tabBarConfigData != null) {
      localBundle.putInt("key_maintab", this.currentTabIndex);
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
  
  public void enableSwipeLayout()
  {
    this.mEnableSwipeLayout = true;
  }
  
  public void finish()
  {
    if ((this.mEnableSwipeLayout) && (this.mColorNoteController != null))
    {
      this.mColorNoteController.d();
      return;
    }
    doFinish();
  }
  
  public ColorNote getColorNote()
  {
    Object localObject4 = null;
    Object localObject8 = super.getIntent();
    Object localObject5 = getCurrentWebViewFragment();
    Object localObject3 = "";
    Object localObject1;
    if ((localObject5 != null) && (((WebViewFragment)localObject5).mApp != null))
    {
      localObject4 = ((WebViewFragment)localObject5).getShare();
      if (!TextUtils.isEmpty(((Share)localObject4).b()))
      {
        localObject1 = ((Share)localObject4).b();
        localObject3 = ((Share)localObject4).c();
        localObject5 = ((Share)localObject4).d();
        if (!TextUtils.isEmpty((CharSequence)localObject5)) {
          break label649;
        }
        localObject4 = ColorNoteUtils.a(getOriginalUrl());
        localObject5 = localObject3;
        localObject3 = localObject1;
        localObject1 = localObject5;
      }
    }
    for (;;)
    {
      for (;;)
      {
        if ((this.mColorNoteCache == null) || (!this.mColorNoteCache.isTitleAndPicValid())) {
          break label219;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          this.mColorNoteCache.mMainTitle = ((String)localObject3);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          this.mColorNoteCache.mSubTitle = ((String)localObject1);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject4)) {
          this.mColorNoteCache.mPicUrl = ((String)localObject4);
        }
        return this.mColorNoteCache;
        localObject1 = localObject3;
        if (((WebViewFragment)localObject5).mSwiftTitleUI == null) {
          break;
        }
        try
        {
          localObject1 = ((WebViewFragment)localObject5).mSwiftTitleUI.a();
        }
        catch (Exception localException1)
        {
          QLog.e("WebLog_QQBrowserActivity", 2, "fragment.mSwiftTitleUI.getTitle()", localException1);
          localObject2 = localObject3;
        }
      }
      break;
      label219:
      localObject5 = getHostWebView();
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
            if (!VipComicUrlHelper.a((String)localObject8)) {
              break label642;
            }
            j = 16908292;
            localObject6 = VipComicUrlHelper.b(VipComicUrlHelper.a(VipComicUrlHelper.b((String)localObject8, "from", "1041001"), "from", "1041001"), "openFromColorTab", "1");
            i = j;
            localObject5 = localObject6;
            if (QLog.isColorLevel())
            {
              QLog.d("WebLog_QQBrowserActivity", 2, "isBoodoUlr,serviceType is ColorNoteConstants.ServiceType.BODONG, original url is " + (String)localObject8 + ", new url is " + (String)localObject6);
              localObject5 = localObject6;
              i = j;
            }
            showColorServiceTypeLog(i);
            if (this.mColorNoteController == null) {
              continue;
            }
            localObject2 = this.mColorNoteController.a(i, (String)localObject5, (String)localObject3, (String)localObject2, (String)localObject4, localJSONObject.toString().getBytes());
            this.mColorNoteCache = ((ColorNote)localObject2);
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
          localObject2 = new ColorNote.Builder().a(i).a(localJSONException).b((String)localObject3).c((String)localObject2).d((String)localObject4).a(localJSONObject.toString().getBytes()).a();
          this.mColorNoteCache = ((ColorNote)localObject2);
          return localObject2;
        }
        label642:
        int i = 16908288;
      }
      label649:
      localObject4 = localObject2;
      Object localObject2 = localObject3;
      localObject3 = localObject4;
      localObject4 = localJSONException;
      continue;
      localObject3 = "";
      localObject2 = null;
    }
  }
  
  public ColorNoteController getColorNoteController()
  {
    return this.mColorNoteController;
  }
  
  public String getCurrentUrl()
  {
    try
    {
      Object localObject = getHostWebView();
      if (localObject != null)
      {
        localObject = ((WebView)localObject).getUrl();
        return localObject;
      }
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public WebViewFragment getCurrentWebViewFragment()
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
  
  public WebViewFragment getFragmentByTabBarData(WebViewTabBarData paramWebViewTabBarData)
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
        preInitWebViewFragment(localIntent);
        ((Intent)localObject2).removeExtra("startOpenPageTime");
        ((Intent)localObject2).removeExtra("qqBrowserActivityCreateTime");
        ((Intent)localObject2).removeExtra("reportSourceFrom");
      }
      return localObject1;
    }
    return null;
  }
  
  public Activity getHostActivity()
  {
    return this;
  }
  
  public WebView getHostWebView()
  {
    if (getWebViewProvider() != null) {
      return getWebViewProvider().getHostWebView();
    }
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
  
  public FrameLayout getRootView()
  {
    return this.fragmentContentView;
  }
  
  public View getTabBarView()
  {
    return this.tabBarView;
  }
  
  public WebViewProvider getWebViewProvider()
  {
    return getCurrentWebViewFragment();
  }
  
  public void hideCurrentWebViewFragment(FragmentTransaction paramFragmentTransaction)
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
  
  protected void initColorNote()
  {
    initColorNote(null);
  }
  
  protected void initColorNote(SwipePostTableLayout paramSwipePostTableLayout)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_QQBrowserActivity", 2, "QQBrowserActivity initColorNote.");
    }
    int j = 1;
    int i = 1;
    if (!BaseApplicationImpl.getApplication().getRuntime().isLogin()) {
      j = 0;
    }
    if (ColorNoteUtils.d(getOriginalUrl())) {
      i = 0;
    }
    if ((ColorNoteUtils.a(getOriginalUrl())) || (TextUtils.isEmpty(getOriginalUrl()))) {
      i = 0;
    }
    if (j != 0) {
      if (i == 0) {
        break label162;
      }
    }
    label162:
    for (this.mColorNoteController = new ColorNoteController(this, true, false, paramSwipePostTableLayout, true, true, false, 2131165528);; this.mColorNoteController = new ColorNoteController(this, false, true, paramSwipePostTableLayout, true, true, false, 2131165528))
    {
      this.mColorNoteController.a(this);
      this.mColorNoteController.a(this);
      this.mColorNoteCache = getColorNote();
      this.mColorNoteController.a(new QQBrowserActivity.4(this));
      this.mColorNoteController.a(new QQBrowserActivity.5(this));
      this.mColorNoteController.a(getOriginalUrl());
      return;
    }
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
    WebViewFragment localWebViewFragment = getCurrentWebViewFragment();
    if (localWebViewFragment != null) {
      localWebViewFragment.doOnBackEvent();
    }
    return true;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    WebViewFragment localWebViewFragment = getCurrentWebViewFragment();
    if (localWebViewFragment != null) {
      localWebViewFragment.doOnConfigurationChanged(paramConfiguration);
    }
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_QQBrowserActivity", 2, "onCreate start");
    }
    sQQBrowserActivityCounter += 1;
    Intent localIntent = super.getIntent();
    Object localObject = (SwiftBrowserNavigator)this.mComponentsProvider.a(1);
    if (localObject != null)
    {
      if (!((SwiftBrowserNavigator)localObject).a(localIntent))
      {
        QLog.e("WebLog_QQBrowserActivity", 1, "navigate to another activity!");
        super.onCreate(paramBundle);
        super.getActivity().finish();
        return;
      }
      if ((!((SwiftBrowserNavigator)localObject).b(localIntent)) && (QLog.isColorLevel())) {
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
    SwiftWebAccelerator.a().a();
    SwiftWebAccelerator.b();
    if (!WebAccelerateHelper.isWebViewCache)
    {
      ThreadManager.postImmediately(new QQBrowserActivity.1(this), null, false);
      if (InnerDns.queryInstance() == null) {
        ThreadManager.postImmediately(new QQBrowserActivity.2(this), null, false);
      }
      if (!WebViewTitleStyleHelper.a().a) {
        ThreadManager.postImmediately(new QQBrowserActivity.3(this), null, false);
      }
    }
    localObject = paramBundle;
    if (getIntent().getBooleanExtra("isFromFavourite", false))
    {
      localObject = paramBundle;
      if (paramBundle == null) {
        localObject = new Bundle();
      }
      ((Bundle)localObject).putAll(localIntent.getExtras());
    }
    super.onCreate((Bundle)localObject);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString) {}
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    WebViewFragment localWebViewFragment = getCurrentWebViewFragment();
    if (localWebViewFragment != null) {
      localWebViewFragment.onPostThemeChanged();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    WebViewFragment localWebViewFragment = getCurrentWebViewFragment();
    if (localWebViewFragment != null) {
      localWebViewFragment.doOnWindowFocusChanged(paramBoolean);
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
  
  public boolean setBottomBarVisibility(boolean paramBoolean)
  {
    Object localObject;
    if (this.tabBarView != null)
    {
      localObject = this.tabBarView;
      if (paramBoolean)
      {
        i = 0;
        ((View)localObject).setVisibility(i);
      }
    }
    else if (this.fragmentContentView != null)
    {
      localObject = (FrameLayout.LayoutParams)this.fragmentContentView.getLayoutParams();
      if (!paramBoolean) {
        break label86;
      }
    }
    label86:
    for (int i = 54;; i = 0)
    {
      ((FrameLayout.LayoutParams)localObject).bottomMargin = ((int)(i * getResources().getDisplayMetrics().density + 0.5F));
      this.fragmentContentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return false;
      i = 8;
      break;
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    WebViewFragment localWebViewFragment = getCurrentWebViewFragment();
    if (localWebViewFragment != null) {
      localWebViewFragment.setTitle(paramCharSequence.toString());
    }
    super.setTitle(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBrowserActivity
 * JD-Core Version:    0.7.0.1
 */