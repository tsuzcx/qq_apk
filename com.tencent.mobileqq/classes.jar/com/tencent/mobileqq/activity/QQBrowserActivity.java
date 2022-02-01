package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.WebViewTitleStyleHelper;
import com.tencent.mobileqq.webview.swift.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webview.swift.SwiftWebViewFragmentSupporter;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewFragmentBuilder;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.mobileqq.webview.swift.WebviewFragmentTabBarBuilder;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderContext;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserNavigator;
import com.tencent.mobileqq.webview.swift.injector.WebColorNoteInjectorUtil;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.TbsAccelerator;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.mobileqq.webview.util.IWebColorNoteInject;
import com.tencent.mobileqq.webview.util.WebViewComUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.IBrowserThirdAppReport;
import mqq.app.MobileQQ;

@RoutePage(desc="内置浏览器", path="/base/browser")
public class QQBrowserActivity
  extends QBaseActivity
  implements SwiftWebViewFragmentSupporter, SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderContext, IBrowserThirdAppReport
{
  public static final String ACTION_NAME = "action_name";
  public static final String ACTION_UPDATE_VIP_INFO = "com.tencent.mobileqq.opencenter.vipInfo";
  public static final String ACTION_VIEW_SELF_ALBUM = "com.tencent.mobileqq.view.self.album";
  public static final String APP_ID = "appid";
  public static final String APP_PARAM = "extraParams";
  public static final String ARTICAL_CHANNEL_EXTRAL_INFO = "ARTICAL_CHANNEL_EXTRAL_INFO";
  public static final String BROADCAST_ACTION_KEY = "broadcastAction";
  public static final int CHANNEL_C2C_AIO = 2;
  public static final int CHANNEL_CONTACT_ADD_SEARCH = 12;
  public static final int CHANNEL_CONTACT_SEARCH = 11;
  public static final int CHANNEL_DISCUSSION_AIO = 4;
  public static final int CHANNEL_DYBAMIC_SEARCH = 13;
  public static final int CHANNEL_KANDIAN = 7;
  public static final int CHANNEL_NO_REPORT = 0;
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
  public static final String EXTRA_FINISH_ANIMATION_UP_DOWN_GUILD = "finish_animation_up_down_guild";
  private static final String FLAG_BROWSER_RESTORE = "browserRestoreFlag";
  public static final String FRAGMENT_CLASS = "fragment_class";
  public static final HashSet<String> HW_FORBINDDEN_LIST = WebViewComUtils.b;
  public static final String INEWS_HEADLINES_URL = "miniqb://home";
  public static final String INEWS_PUBLIC_UIN = "2909288299";
  public static final String IS_OPENING_QUN_APP = "isOpeningQunApp";
  public static final String IS_WRAP_CONTENT = "is_wrap_content";
  public static final String KEY_DISCUSS_GROUP_UIN = "dicussgroup_uin";
  public static final String KEY_FAV_GROUP_ID = "favGroupID";
  public static final String KEY_FAV_ID = "favID";
  public static final String KEY_FRIEND_UIN = "friend_uin";
  public static final String KEY_FROM_FAV = "fromFav";
  public static final String KEY_FROM_NEARBY = "fromNearby";
  public static final String KEY_GROUP_UIN = "groupUin";
  public static final String KEY_IS_SEND = "is_send";
  public static final String KEY_IS_TRANSPARENT_TITLE = "isTransparentTitle";
  private static final String KEY_MAINTAB_INDEX = "key_maintab";
  public static final String KEY_PAY_ACTION_RESULT = "key_pay_action_result";
  public static final String KEY_SENDER_UIN = "friendUin";
  public static final String KEY_UIN_TYPE = "uinType";
  public static final String MAIN_ACTION = "webview";
  public static final int PLUGIN_START_REQUEST_CODE = 10000;
  public static final String QB_DOT_SHOW_VERSION_CODE_KEY = "version_code_key";
  public static final String QQBROWSER_DOWNLOAD_URL_DIRECT = "https://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=50079";
  public static final String QQBROWSER_DOWNLOAD_URL_DIRECT_QBSHARE = "https://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10367";
  public static final int REQ_TYPE_BROWSE_ALBUM = 2;
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
  public static final String TOPTAB_SELECT_INDEX = "topTabSelectIndex";
  public static final String TOPTAB_SWITCH_FRAGMENT = "topTabSwitchFragment";
  public static final String TROOP_ID = "troopid";
  public static final String WEB_FLOAT_SHORTCUT_FROM = "qqbrowser_float_shortcut";
  public static int sQQBrowserActivityCounter = 0;
  public int currentTabIndex = 0;
  private FrameLayout fragmentContentView;
  private IWebColorNoteInject inject;
  public final SwiftBrowserComponentsProvider mComponentsProvider = createComponentsProvider();
  public Class<? extends WebViewFragment> mFragmentClass = null;
  public int oldTabSelectIndex = -1;
  public ArrayList<WebViewTabBarData> tabBarConfigData;
  private View tabBarView;
  
  private void doOverrideAnim()
  {
    IWebColorNoteInject localIWebColorNoteInject = this.inject;
    if ((localIWebColorNoteInject != null) && (localIWebColorNoteInject.c())) {
      overridePendingTransition(0, 0);
    }
    if (getIntent().getBooleanExtra("finish_animation_up_down", false)) {
      overridePendingTransition(0, 2130771995);
    }
    if (getIntent().getBooleanExtra("finish_animation_out_to_right", false)) {
      overridePendingTransition(0, 2130772324);
    }
    if (getIntent().getBooleanExtra("finish_animation_out_to_top", false)) {
      overridePendingTransition(0, 2130772438);
    }
    if (getIntent().getBooleanExtra("finish_animation_none", false)) {
      overridePendingTransition(0, 0);
    }
    if (getIntent().getBooleanExtra("finish_animation_up_down_guild", false)) {
      overridePendingTransition(0, 2130772135);
    }
  }
  
  private void preInitWebViewFragment(Intent paramIntent)
  {
    String str = SwiftWebViewUtils.a(paramIntent);
    WebAccelerateHelper.getInstance().preGetKey(str, paramIntent, null);
    WebAccelerateHelper.getInstance().preCheckOffline(str);
    WebAccelerateHelper.getInstance().preFetchResource(str);
  }
  
  public static WebViewFragment switchFragment(int paramInt, QQBrowserActivity paramQQBrowserActivity)
  {
    WebViewTabBarData localWebViewTabBarData = (WebViewTabBarData)paramQQBrowserActivity.tabBarConfigData.get(paramInt);
    WebViewFragment localWebViewFragment = paramQQBrowserActivity.getFragmentByTabBarData(localWebViewTabBarData);
    FragmentTransaction localFragmentTransaction = paramQQBrowserActivity.getSupportFragmentManager().beginTransaction();
    paramQQBrowserActivity.hideCurrentWebViewFragment(localFragmentTransaction);
    if (!localWebViewFragment.isAdded()) {
      localFragmentTransaction.add(2131431345, localWebViewFragment, localWebViewTabBarData.tag);
    } else {
      localFragmentTransaction.show(localWebViewFragment);
    }
    localFragmentTransaction.commitAllowingStateLoss();
    paramQQBrowserActivity.currentTabIndex = paramInt;
    return localWebViewFragment;
  }
  
  public SwiftBrowserComponentsProvider createComponentsProvider()
  {
    return new SwiftBrowserComponentsProvider(this, 1, null);
  }
  
  /* Error */
  public WebViewFragment createFragment(Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 222	com/tencent/mobileqq/activity/QQBrowserActivity:mFragmentClass	Ljava/lang/Class;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnull +25 -> 31
    //   9: aload_2
    //   10: invokevirtual 361	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   13: checkcast 319	com/tencent/mobileqq/webview/swift/WebViewFragment
    //   16: astore_2
    //   17: goto +145 -> 162
    //   20: new 319	com/tencent/mobileqq/webview/swift/WebViewFragment
    //   23: dup
    //   24: invokespecial 362	com/tencent/mobileqq/webview/swift/WebViewFragment:<init>	()V
    //   27: astore_2
    //   28: goto +134 -> 162
    //   31: aload_1
    //   32: ldc 86
    //   34: invokevirtual 366	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   37: invokestatic 372	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   40: ifne +114 -> 154
    //   43: aload_1
    //   44: ldc 86
    //   46: invokevirtual 366	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   49: astore_2
    //   50: aload_2
    //   51: invokestatic 376	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   54: invokevirtual 361	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   57: astore_2
    //   58: aload_2
    //   59: instanceof 319
    //   62: ifeq +11 -> 73
    //   65: aload_2
    //   66: checkcast 319	com/tencent/mobileqq/webview/swift/WebViewFragment
    //   69: astore_3
    //   70: goto +5 -> 75
    //   73: aconst_null
    //   74: astore_3
    //   75: aload_3
    //   76: astore_2
    //   77: aload_3
    //   78: ifnonnull +84 -> 162
    //   81: new 319	com/tencent/mobileqq/webview/swift/WebViewFragment
    //   84: dup
    //   85: invokespecial 362	com/tencent/mobileqq/webview/swift/WebViewFragment:<init>	()V
    //   88: astore_2
    //   89: goto +73 -> 162
    //   92: astore_1
    //   93: goto +51 -> 144
    //   96: astore_2
    //   97: aload_2
    //   98: invokevirtual 379	java/lang/ClassNotFoundException:printStackTrace	()V
    //   101: new 319	com/tencent/mobileqq/webview/swift/WebViewFragment
    //   104: dup
    //   105: invokespecial 362	com/tencent/mobileqq/webview/swift/WebViewFragment:<init>	()V
    //   108: astore_2
    //   109: goto +53 -> 162
    //   112: astore_2
    //   113: aload_2
    //   114: invokevirtual 380	java/lang/IllegalAccessException:printStackTrace	()V
    //   117: new 319	com/tencent/mobileqq/webview/swift/WebViewFragment
    //   120: dup
    //   121: invokespecial 362	com/tencent/mobileqq/webview/swift/WebViewFragment:<init>	()V
    //   124: astore_2
    //   125: goto +37 -> 162
    //   128: astore_2
    //   129: aload_2
    //   130: invokevirtual 381	java/lang/InstantiationException:printStackTrace	()V
    //   133: new 319	com/tencent/mobileqq/webview/swift/WebViewFragment
    //   136: dup
    //   137: invokespecial 362	com/tencent/mobileqq/webview/swift/WebViewFragment:<init>	()V
    //   140: astore_2
    //   141: goto +21 -> 162
    //   144: new 319	com/tencent/mobileqq/webview/swift/WebViewFragment
    //   147: dup
    //   148: invokespecial 362	com/tencent/mobileqq/webview/swift/WebViewFragment:<init>	()V
    //   151: pop
    //   152: aload_1
    //   153: athrow
    //   154: new 319	com/tencent/mobileqq/webview/swift/WebViewFragment
    //   157: dup
    //   158: invokespecial 362	com/tencent/mobileqq/webview/swift/WebViewFragment:<init>	()V
    //   161: astore_2
    //   162: new 383	android/os/Bundle
    //   165: dup
    //   166: invokespecial 384	android/os/Bundle:<init>	()V
    //   169: astore_3
    //   170: aload_3
    //   171: ldc_w 386
    //   174: aload_1
    //   175: invokevirtual 390	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   178: aload_2
    //   179: aload_3
    //   180: invokevirtual 394	com/tencent/mobileqq/webview/swift/WebViewFragment:setArguments	(Landroid/os/Bundle;)V
    //   183: aload_2
    //   184: areturn
    //   185: astore_2
    //   186: goto -166 -> 20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	QQBrowserActivity
    //   0	189	1	paramIntent	Intent
    //   4	85	2	localObject1	Object
    //   96	2	2	localClassNotFoundException	java.lang.ClassNotFoundException
    //   108	1	2	localWebViewFragment1	WebViewFragment
    //   112	2	2	localIllegalAccessException	java.lang.IllegalAccessException
    //   124	1	2	localWebViewFragment2	WebViewFragment
    //   128	2	2	localInstantiationException	java.lang.InstantiationException
    //   140	44	2	localWebViewFragment3	WebViewFragment
    //   185	1	2	localException	Exception
    //   69	111	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   50	70	92	finally
    //   97	101	92	finally
    //   113	117	92	finally
    //   129	133	92	finally
    //   50	70	96	java/lang/ClassNotFoundException
    //   50	70	112	java/lang/IllegalAccessException
    //   50	70	128	java/lang/InstantiationException
    //   9	17	185	java/lang/Exception
  }
  
  public void createTabBarView()
  {
    Object localObject = this.tabBarConfigData;
    if ((localObject != null) && (((ArrayList)localObject).size() > 1) && (this.tabBarView == null))
    {
      this.tabBarView = WebviewFragmentTabBarBuilder.a(this, super.getIntent(), this.tabBarConfigData, new QQBrowserActivity.MyOnTabChangeListener(this));
      this.tabBarView.setId(2131446722);
      localObject = this.fragmentContentView.getParent();
      if ((localObject instanceof FrameLayout))
      {
        if (!super.getIntent().getBooleanExtra("topTabSwitchFragment", false))
        {
          ((FrameLayout)localObject).addView(this.tabBarView, new FrameLayout.LayoutParams(-1, -2, 80));
          localObject = (FrameLayout.LayoutParams)this.fragmentContentView.getLayoutParams();
          ((FrameLayout.LayoutParams)localObject).bottomMargin = ((int)(getResources().getDisplayMetrics().density * 54.0F + 0.5F));
          this.fragmentContentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      else {
        QLog.e("WebLog_QQBrowserActivity", 1, "doOnCreate error:should not enter here!");
      }
    }
  }
  
  protected boolean directSuperDoOnCreate(Bundle paramBundle)
  {
    return super.doOnCreate(paramBundle);
  }
  
  protected void directSuperOnCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_QQBrowserActivity", 2, "finish");
    }
    Object localObject = getCurrentWebViewFragment();
    if (localObject != null) {
      ((WebViewFragment)localObject).activityFinish();
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if ((localInputMethodManager != null) && (access$001(this) != null)) {
      localInputMethodManager.hideSoftInputFromWindow(access$101(this).getWindowToken(), 0);
    }
    super.finish();
    doOverrideAnim();
    if ((localObject != null) && (((WebViewFragment)localObject).getUIStyle() != null)) {
      if ((((WebViewFragment)localObject).getUIStyle().g & 0x100) != 0L) {
        overridePendingTransition(0, 0);
      } else if ((((WebViewFragment)localObject).getUIStyle().g & 0x200) != 0L) {
        overridePendingTransition(0, 2130772018);
      }
    }
    if (getIntent().getBooleanExtra("from_risk_hint", false))
    {
      getIntent().removeExtra("from_risk_hint");
      localObject = new Intent();
      ((Intent)localObject).putExtra("from_risk_hint", true);
      RouteUtils.a(this, (Intent)localObject, "/base/safe/loginInfo");
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.i("WebLog_QQBrowserActivity", 2, String.format("doOnActivityResult resultCode=0x%x", new Object[] { Integer.valueOf(paramInt2) }));
    }
    if (paramInt2 == 4660)
    {
      if (paramIntent != null) {
        super.setResult(4660, paramIntent);
      } else {
        super.setResult(4660);
      }
      finish();
    }
    WebViewFragment localWebViewFragment = getCurrentWebViewFragment();
    if (localWebViewFragment != null) {
      localWebViewFragment.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.F = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_QQBrowserActivity", 2, "doOnCreate start");
    }
    if (Build.VERSION.SDK_INT > 10)
    {
      localObject1 = HW_FORBINDDEN_LIST;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(Build.MANUFACTURER);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(Build.MODEL);
      if (!((HashSet)localObject1).contains(((StringBuilder)localObject2).toString())) {
        getWindow().addFlags(16777216);
      }
    }
    getWindow().setFormat(-3);
    getWindow().setBackgroundDrawable(null);
    this.mNeedStatusTrans = false;
    SwiftWebAccelerator.TbsAccelerator.b = 0L;
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
    }
    else
    {
      paramBundle.removeExtra("tabConfigData");
    }
    localObject2 = paramBundle.getExtras();
    if (localObject2 != null)
    {
      localObject2 = (Class)((Bundle)localObject2).getSerializable("fragmentClass");
      if (localObject2 != null) {
        this.mFragmentClass = ((Class)localObject2);
      }
    }
    this.fragmentContentView = ((FrameLayout)localObject1);
    if ((this.tabBarConfigData.size() > 1) && (!(((FrameLayout)localObject1).getParent() instanceof FrameLayout)))
    {
      this.fragmentContentView = new FrameLayout(this);
      ((FrameLayout)localObject1).addView(this.fragmentContentView, new FrameLayout.LayoutParams(-1, -1));
      QLog.i("WebLog_QQBrowserActivity", 1, "doOnCreate warning:content is not an instance of FrameLayout.");
    }
    this.fragmentContentView.setId(2131431345);
    int i = paramBundle.getIntExtra("tabDefaultIndex", 0);
    localObject1 = (WebViewTabBarData)this.tabBarConfigData.get(i);
    paramBundle.removeExtra("tabDefaultIndex");
    paramBundle = getFragmentByTabBarData((WebViewTabBarData)localObject1);
    if (!paramBundle.isAdded())
    {
      super.getSupportFragmentManager().beginTransaction().add(2131431345, paramBundle, ((WebViewTabBarData)localObject1).tag).commitAllowingStateLoss();
      return true;
    }
    super.getSupportFragmentManager().beginTransaction().show(paramBundle).commitAllowingStateLoss();
    return true;
  }
  
  protected void doOnDestroy()
  {
    sQQBrowserActivityCounter -= 1;
    Object localObject = this.fragmentContentView;
    if (localObject != null)
    {
      localObject = ((FrameLayout)localObject).getParent();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).removeView(this.tabBarView);
      }
      this.tabBarView = null;
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
  
  protected boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    WebViewFragment localWebViewFragment = getCurrentWebViewFragment();
    if (localWebViewFragment != null) {
      localWebViewFragment.doOnKeyDown(paramInt, paramKeyEvent);
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    WebViewFragment localWebViewFragment = getCurrentWebViewFragment();
    if (localWebViewFragment != null) {
      localWebViewFragment.doOnNewIntent(paramIntent);
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    doOverrideAnim();
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
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
  
  protected void doOnUserLeaveHint()
  {
    Intent localIntent = new Intent("tencent.notify.background");
    localIntent.setPackage(MobileQQ.getContext().getPackageName());
    localIntent.putExtra("selfuin", MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
    localIntent.putExtra("AccountInfoSync", "mobileqq.web");
    localIntent.putExtra("classname", getClass().getName());
    sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
    super.doOnUserLeaveHint();
  }
  
  public void finish()
  {
    IWebColorNoteInject localIWebColorNoteInject = this.inject;
    if ((localIWebColorNoteInject == null) || (!localIWebColorNoteInject.b())) {
      doFinish();
    }
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
    catch (Throwable localThrowable)
    {
      label16:
      break label16;
    }
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
      Object localObject = (WebViewFragment)super.getSupportFragmentManager().findFragmentByTag(paramWebViewTabBarData.tag);
      if (localObject == null)
      {
        localObject = super.getIntent();
        long l = ((Intent)localObject).getLongExtra("startOpenPageTime", -1L);
        if ((l == -1L) || (System.currentTimeMillis() - l > 5000L)) {
          ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
        }
        Intent localIntent = new Intent((Intent)localObject);
        if (!TextUtils.isEmpty(((Intent)localObject).getStringExtra("fragment_class"))) {
          ((Intent)localObject).removeExtra("fragment_class");
        }
        paramWebViewTabBarData = WebViewFragmentBuilder.a(this, paramWebViewTabBarData, localIntent);
        preInitWebViewFragment(localIntent);
        ((Intent)localObject).removeExtra("startOpenPageTime");
        ((Intent)localObject).removeExtra("qqBrowserActivityCreateTime");
        ((Intent)localObject).removeExtra("reportSourceFrom");
        return paramWebViewTabBarData;
      }
      return localObject;
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
  
  public IWebColorNoteInject getWebColorNoteInjector()
  {
    return this.inject;
  }
  
  public WebViewProvider getWebViewProvider()
  {
    return getCurrentWebViewFragment();
  }
  
  public void hideCurrentWebViewFragment(FragmentTransaction paramFragmentTransaction)
  {
    if (paramFragmentTransaction == null) {
      return;
    }
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
  
  public boolean isWrapContent()
  {
    return getIntent().getBooleanExtra("is_wrap_content", false);
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
  
  protected void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_QQBrowserActivity", 2, "onCreate start");
    }
    sQQBrowserActivityCounter += 1;
    Intent localIntent = super.getIntent();
    Object localObject = (SwiftBrowserNavigator)this.mComponentsProvider.a(1);
    if (localObject != null)
    {
      if (((SwiftBrowserNavigator)localObject).a(localIntent))
      {
        QLog.e("WebLog_QQBrowserActivity", 1, "navigate to another activity!");
        super.onCreate(paramBundle);
        super.getActivity().finish();
        return;
      }
      if ((((SwiftBrowserNavigator)localObject).b(localIntent)) && (QLog.isColorLevel())) {
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
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCreate createTime = ");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    QLog.d("WebLog_QQBrowserActivity", 1, ((StringBuilder)localObject).toString());
    SwiftWebAccelerator.a().b();
    SwiftWebAccelerator.c();
    if (!WebAccelerateHelper.isWebViewCache)
    {
      ThreadManager.postImmediately(new QQBrowserActivity.1(this), null, false);
      if (BaseInnerDns.queryInstance() == null) {
        ThreadManager.postImmediately(new QQBrowserActivity.2(this), null, false);
      }
      if (!WebViewTitleStyleHelper.a().b) {
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
    this.inject = WebColorNoteInjectorUtil.a();
    paramBundle = this.inject;
    if (paramBundle != null) {
      registerActivityLifecycleCallbacks(paramBundle);
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
    if ((this.mCanLock) && (!TextUtils.isEmpty(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount())) && (BaseGesturePWDUtil.getGesturePWDState(this, MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount()) == 2) && (BaseGesturePWDUtil.getGesturePWDMode(this, MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount()) == 21)) {
      startUnlockActivity();
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    if (getWindow().getContainer() == null) {
      requestWindowFeature(7);
    }
  }
  
  public boolean setBottomBarVisibility(boolean paramBoolean)
  {
    Object localObject = this.tabBarView;
    int i;
    if (localObject != null)
    {
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      ((View)localObject).setVisibility(i);
    }
    localObject = this.fragmentContentView;
    if (localObject != null)
    {
      localObject = (FrameLayout.LayoutParams)((FrameLayout)localObject).getLayoutParams();
      if (paramBoolean) {
        i = 54;
      } else {
        i = 0;
      }
      ((FrameLayout.LayoutParams)localObject).bottomMargin = ((int)(i * getResources().getDisplayMetrics().density + 0.5F));
      this.fragmentContentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    return false;
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    WebViewFragment localWebViewFragment = getCurrentWebViewFragment();
    if (localWebViewFragment != null) {
      localWebViewFragment.setTitle(paramCharSequence.toString());
    }
    super.setTitle(paramCharSequence);
  }
  
  public void startActivityFromFragment(@NonNull Fragment paramFragment, Intent paramIntent, int paramInt, @Nullable Bundle paramBundle)
  {
    if (paramInt == -1)
    {
      ActivityCompat.startActivityForResult(this, paramIntent, -1, paramBundle);
      return;
    }
    ActivityCompat.startActivityForResult(this, paramIntent, paramInt, paramBundle);
  }
  
  public void startIntentSenderFromFragment(@NonNull Fragment paramFragment, IntentSender paramIntentSender, int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, @Nullable Bundle paramBundle)
  {
    if (paramInt1 == -1)
    {
      ActivityCompat.startIntentSenderForResult(this, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
      return;
    }
    ActivityCompat.startIntentSenderForResult(this, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBrowserActivity
 * JD-Core Version:    0.7.0.1
 */