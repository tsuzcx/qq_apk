package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.parser.JumpActivityHelper;
import com.tencent.mobileqq.app.parser.jumpcontroller.IJumpBusinessInterface;
import com.tencent.mobileqq.app.parser.jumpcontroller.JumpActivityInjectUtil;
import com.tencent.mobileqq.app.parser.tempapi.IQJumpApi;
import com.tencent.mobileqq.haoliyou.sso.OnCheckShareListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.utils.JumpReportCtr;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.HashMap;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;

@RoutePage(desc="互联对外暴露的activity", path="/base/jump")
public class JumpActivity
  extends QBaseActivity
  implements DialogInterface.OnDismissListener, Handler.Callback, OnCheckShareListener
{
  public static final String BROADCAST_RECEIVER_FINISH_ACTION = "BroadcastReceiverFinishActivity";
  public static final String BROCAST_RECEIVER_ACTION = "ShareToQZoneAndFinishTheLastActivity";
  public static final int LBS_REQUEST = 18;
  public static final int MINIAPP_LOGIN_REQUEST = 24;
  public static final int MSG_AFTER_SECURITY_CHECK = 2;
  public static final int MSG_DISMISS_DIALOG = 1;
  public static final int REQUEST_MULTI_VOICE_CALL = 1;
  public static final int REQUEST_SINGLE_VOICE_CALL = 2;
  public static final String SCHEME_MQQ = "mqq";
  public static final int SHARE_LOGIN_REQUEST = 19;
  public static final int SHARE_PICTURE_TO_QZONE_REQUEST = 23;
  private static final String TAG = "JumpAction";
  public static final int THIRD_PARTY_GESTURE_PWD_REQUEST = 27;
  public static final int THIRD_PARTY_LOGIN_REQUEST = 26;
  public static final int TYPE_SHARED = 0;
  private static final int TYPE_VIEW = 1;
  public static final int VIEW_LOGIN_REQUEST = 20;
  public static final int WEB_SECURITY_VERIFY = 25;
  public static final int WPA_GESTURE_PWD_REQUEST = 22;
  public static final int WPA_LOGIN_REQUEST = 21;
  public static boolean sIsStartFromThirdParty = false;
  public static boolean sIsStartFromWpa = false;
  public static int sJASwitches = -1;
  public static HashMap<String, Integer> sLegalPrefix;
  public static String[] sLegalPrefixes = { "mqq", "mqqapi", "mqqmdpass", "mqqwpa", "mqqopensdkapi", "mqqflyticket", "wtloginmqq", "imto", "mqqtribe", "mqqvoipivr", "mqqverifycode", "mqqdevlock", "qapp", "qqwifi", "mqqconnect", "qqstory", "mqqconferenceflyticket", "mqqavshare" };
  public static volatile boolean sSwitchInited = false;
  public String callbackName;
  public String callbackType;
  public boolean doCallBack;
  public Intent gotoQQComic = null;
  public Intent gotoQReader = null;
  public boolean isActionPhoto = false;
  public boolean isActionSelectLocation = false;
  public MqqHandler mBgHandler = null;
  public HandlerThread mBgThread = null;
  private BroadcastReceiver mJumpFinishBroadcastReceiver;
  private JumpReportCtr mJumpReportCtr;
  public String mPackageName = "";
  public WtloginObserver mWtLoginObserver = new JumpActivity.1(this);
  public boolean needFinishOnPause = false;
  private BroadcastReceiver qqBroadcastReceiver;
  private ViewGroup rootView;
  public String srcType;
  public final MqqHandler uiHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  
  private boolean dealActionAndScheme(Intent paramIntent)
  {
    return (JumpActivityHelper.h(this, paramIntent)) && (JumpActivityHelper.i(this, paramIntent)) && (JumpActivityHelper.j(this, paramIntent));
  }
  
  private void dismissDialog()
  {
    ViewGroup localViewGroup = this.rootView;
    if (localViewGroup != null) {
      localViewGroup.setVisibility(8);
    }
  }
  
  public static void doJumpToMiniApp(JumpActivity paramJumpActivity, boolean paramBoolean)
  {
    JumpActivityHelper.a(paramJumpActivity, paramBoolean);
  }
  
  public static void doShare(JumpActivity paramJumpActivity, boolean paramBoolean)
  {
    JumpActivityHelper.c(paramJumpActivity, paramBoolean);
  }
  
  public static void doThirdPartyCheckLoginAndGesture(JumpActivity paramJumpActivity, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    JumpActivityHelper.a(paramJumpActivity, paramBoolean1, paramString, paramBoolean2);
  }
  
  public static void doView(JumpActivity paramJumpActivity, boolean paramBoolean)
  {
    Intent localIntent = JumpActivityHelper.b(paramJumpActivity, paramBoolean);
    if (localIntent == null) {
      return;
    }
    JumpActivityHelper.a(paramJumpActivity, localIntent, 1);
  }
  
  public static void dowpa(JumpActivity paramJumpActivity, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    JumpActivityHelper.b(paramJumpActivity, paramBoolean1, paramString, paramBoolean2);
  }
  
  public static String getFragmentName(Context paramContext)
  {
    return JumpActivityHelper.a(paramContext);
  }
  
  public static void handleIntentForQQBrowser(Context paramContext, Intent paramIntent)
  {
    JumpActivityHelper.a(paramContext, paramIntent);
  }
  
  public static void initJASwitch()
  {
    initJASwitch(BaseApplication.getContext().getSharedPreferences("Jump_Action", 0).getString("JASwitch", "FFFFFFFF"), false);
  }
  
  public static void initJASwitch(String paramString, boolean paramBoolean)
  {
    try
    {
      JumpActivityHelper.a(paramString, paramBoolean);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static boolean isLegalScheme(String paramString)
  {
    return JumpActivityHelper.a(paramString);
  }
  
  public static boolean needForceSetComponent(String paramString)
  {
    HashMap localHashMap = sLegalPrefix;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localHashMap != null)
    {
      bool1 = bool2;
      if ((1 << ((Integer)localHashMap.get(paramString)).intValue() & sJASwitches) != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static void onWebSecVerifyResult(JumpActivity paramJumpActivity, boolean paramBoolean, Intent paramIntent)
  {
    JumpActivityHelper.a(paramJumpActivity, paramBoolean, paramIntent);
  }
  
  public static void processIntent(Intent paramIntent)
  {
    JumpActivityHelper.a(paramIntent);
  }
  
  private static void reportJumpArguments(Intent paramIntent)
  {
    JumpActivityHelper.b(paramIntent);
  }
  
  public IJumpBusinessInterface createPlugin(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("createPlugin pluginKey: ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("JumpAction", 1, ((StringBuilder)localObject).toString());
    localObject = (Class)JumpActivityInjectUtil.b.get(String.valueOf(paramInt));
    try
    {
      localObject = (IJumpBusinessInterface)((Class)localObject).newInstance();
      return localObject;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createPlugin pluginKey: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" error: ");
      localStringBuilder.append(localException);
      QLog.e("JumpAction", 1, localStringBuilder.toString());
    }
    return null;
  }
  
  protected boolean dealIntentData(Intent paramIntent)
  {
    return (dealActionAndScheme(paramIntent)) && (JumpActivityHelper.k(this, paramIntent));
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doJumpQQComic(Intent paramIntent)
  {
    JumpActivityHelper.c(this, paramIntent);
  }
  
  public void doJumpQfile(Intent paramIntent)
  {
    JumpActivityHelper.d(this, paramIntent);
  }
  
  public void doJumpQlink(Intent paramIntent)
  {
    JumpActivityHelper.a(this, paramIntent);
  }
  
  public void doJumpReadInjoy(Intent paramIntent)
  {
    JumpActivityHelper.f(this, paramIntent);
  }
  
  public void doJumpSmartDevice(Intent paramIntent)
  {
    JumpActivityHelper.e(this, paramIntent);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("JumpActivity onActivityResult,requestCode=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",resultCode=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(",data=");
    Object localObject;
    if (paramIntent != null) {
      localObject = paramIntent.toString();
    } else {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    QLog.d("JumpAction", 1, localStringBuilder.toString());
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      try
      {
        localObject = createPlugin(paramInt1);
        if (localObject == null)
        {
          QLog.e("JumpAction", 1, "doOnActivityResult: result plugin not exist");
          finish();
          return;
        }
        ((IJumpBusinessInterface)localObject).a(paramInt1, paramInt2, paramIntent, this);
        return;
      }
      catch (Exception paramIntent)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doOnActivityResult error: ");
        ((StringBuilder)localObject).append(paramIntent.getMessage());
        QLog.e("JumpAction", 1, ((StringBuilder)localObject).toString());
        return;
      }
    }
    if (paramInt1 == 25)
    {
      onWebSecVerifyResult(this, false, paramIntent);
      return;
    }
    if (paramInt1 != 23) {
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    this.mNeedStatusTrans = false;
    getWindow().addFlags(67108864);
    try
    {
      super.doOnCreate(paramBundle);
      QLog.d("JumpAction", 1, "JumpActivity doOnCreate()");
      paramBundle = getIntent();
      if (paramBundle == null)
      {
        QLog.d("JumpAction", 1, "onCreate intent is null");
        finish();
        return false;
      }
      reportJumpArguments(paramBundle);
      this.mJumpReportCtr = new JumpReportCtr();
      this.mJumpReportCtr.a(getAppRuntime(), this, paramBundle);
      boolean bool = dealIntentData(paramBundle);
      return bool;
    }
    catch (Exception paramBundle)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnCreate|exp:");
      localStringBuilder.append(paramBundle.getMessage());
      QLog.e("JumpAction", 1, localStringBuilder.toString());
      finish();
    }
    return false;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    sIsStartFromWpa = false;
    sIsStartFromThirdParty = false;
    Object localObject = this.qqBroadcastReceiver;
    if (localObject != null) {
      unregisterReceiver((BroadcastReceiver)localObject);
    }
    localObject = this.mJumpFinishBroadcastReceiver;
    if (localObject != null) {
      unregisterReceiver((BroadcastReceiver)localObject);
    }
    this.uiHandler.removeMessages(2);
    this.uiHandler.removeMessages(1);
    dismissDialog();
    localObject = this.mBgHandler;
    if (localObject != null)
    {
      ((MqqHandler)localObject).removeCallbacksAndMessages(null);
      this.mBgThread.quit();
      this.mBgThread = null;
    }
    localObject = this.mJumpReportCtr;
    if (localObject != null)
    {
      ((JumpReportCtr)localObject).b(null);
      this.mJumpReportCtr = null;
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.needFinishOnPause) {
      finish();
    }
  }
  
  public int doQfavShare(Bundle paramBundle)
  {
    return JumpActivityHelper.b(this, paramBundle);
  }
  
  public void doShare(Bundle paramBundle)
  {
    JumpActivityHelper.c(this, paramBundle);
  }
  
  public void doSumsungCallUp()
  {
    JumpActivityHelper.a(this);
  }
  
  public void doView(Intent paramIntent, Bundle paramBundle)
  {
    JumpActivityHelper.a(this, paramIntent, paramBundle);
  }
  
  public void goToWebSecVerify(Intent paramIntent)
  {
    JumpActivityHelper.g(this, paramIntent);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i == 2)
      {
        this.uiHandler.removeMessages(2);
        if ((paramMessage.obj instanceof Intent))
        {
          i = paramMessage.arg1;
          Intent localIntent = (Intent)paramMessage.obj;
          dismissDialog();
          if (i == 0)
          {
            if (!JumpActivityHelper.b(this)) {
              doShare(localIntent.getExtras());
            }
          }
          else if (!JumpActivityHelper.b(this))
          {
            Bundle localBundle = localIntent.getExtras();
            paramMessage = localBundle;
            if (localBundle == null) {
              paramMessage = new Bundle();
            }
            doView(localIntent, paramMessage);
          }
        }
      }
    }
    else {
      dismissDialog();
    }
    return false;
  }
  
  public void initBroadcastReceiver()
  {
    if (this.qqBroadcastReceiver == null)
    {
      this.qqBroadcastReceiver = new JumpActivity.2(this);
      IntentFilter localIntentFilter = new IntentFilter("ShareToQZoneAndFinishTheLastActivity");
      registerReceiver(this.qqBroadcastReceiver, localIntentFilter);
    }
  }
  
  public void initFinishBroadcastReceiver()
  {
    if (this.mJumpFinishBroadcastReceiver == null)
    {
      this.mJumpFinishBroadcastReceiver = new JumpActivity.3(this);
      IntentFilter localIntentFilter = new IntentFilter("BroadcastReceiverFinishActivity");
      registerReceiver(this.mJumpFinishBroadcastReceiver, localIntentFilter);
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    finish();
  }
  
  public void onResponse(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    JumpActivityHelper.a(this, paramBoolean, paramInt1, paramInt2, paramString1, paramString2);
  }
  
  public int qqFavDoAction(HashMap<String, String> paramHashMap)
  {
    return JumpActivityHelper.a(this, paramHashMap);
  }
  
  public int qqFavHandleTypeImage(Bundle paramBundle, HashMap<String, String> paramHashMap)
  {
    return JumpActivityHelper.a(this, paramBundle, paramHashMap);
  }
  
  public int qqFavHandleTypeTxt(Bundle paramBundle, HashMap<String, String> paramHashMap, Uri paramUri, String paramString)
  {
    return JumpActivityHelper.a(this, paramBundle, paramHashMap, paramUri, paramString);
  }
  
  public Boolean qserIsOn()
  {
    return ((IQJumpApi)QRoute.api(IQJumpApi.class)).qserIsOn();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void showDialog()
  {
    try
    {
      setContentView(2131627476);
      this.rootView = ((RelativeLayout)findViewById(2131436711));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("JumpAction", 1, localThrowable, new Object[0]);
    }
  }
  
  public boolean showPreview()
  {
    if (JumpActivityHelper.d(this)) {
      return true;
    }
    return super.showPreview();
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
    paramBundle = this.mJumpReportCtr;
    if (paramBundle != null)
    {
      paramBundle.b(paramIntent);
      this.mJumpReportCtr = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JumpActivity
 * JD-Core Version:    0.7.0.1
 */