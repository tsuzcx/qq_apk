package com.tencent.hippy.qq.module;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment;
import com.tencent.mobileqq.activity.activateFriend.QQNotifyUtils;
import com.tencent.mobileqq.activity.activateFriend.QQNotifyUtils.QQNotifyListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.jsp.ShareMsgImpl;
import com.tencent.mobileqq.jsp.ShareMsgImpl.ShareMsgImplListener;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;
import com.tencent.mobileqq.tribe.takevideo.TribePublishLauncher;
import com.tencent.mobileqq.troop.activity.PublicCommentWindow;
import com.tencent.mobileqq.troop.activity.TroopBarCommentWindow;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.webview.swift.WebViewUtil;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheet.OnDismissListener;
import com.tencent.widget.ActionSheet.WatchDismissActions;
import cooperation.qqindividuality.QQIndividualityUtils;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

@HippyNativeModule(name="QQUiModule")
public class QQUiModule
  extends QQBaseLifecycleModule
  implements DialogInterface.OnCancelListener, QQNotifyUtils.QQNotifyListener, ActionSheet.OnButtonClickListener, ActionSheet.OnDismissListener, ActionSheet.WatchDismissActions
{
  static final String CLASSNAME = "QQUiModule";
  private static final int CODE_OPEN_VIEW = 101;
  private static final int CODE_SUBSCRIBE = WebViewUtil.a("qw_mix") << 8;
  public static final String METHOD_ACTION_NOTIFY_NEW_SUBSCRIBE = "newSubscribe";
  public static final String METHOD_ACTION_NOTIFY_QUERY = "query";
  public static final String PARAMS_BUSINESS_ID = "busiid";
  public static final String PARAMS_DOMAIN = "domain";
  public static final String PARAMS_MSG_ID = "msgid";
  private ActionSheet mActionSheet;
  private boolean mActionSheetIsCancle = false;
  public int mActionSheetItemCount = 0;
  private String mActionSheetParamStr;
  private Promise mActionSheetPromise;
  TroopMemberApiClient mClient = null;
  private Promise mNotifyPromise;
  private Promise mOpenViewPromise;
  private ShareMsgImpl mShareMsgImpl;
  ShareMsgImpl.ShareMsgImplListener mShareMsgImplListener = new QQUiModule.6(this);
  private Promise mShareMsgPromise;
  
  public QQUiModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  private void excuteOpenView(String paramString, Promise paramPromise)
  {
    this.mOpenViewPromise = null;
    Activity localActivity;
    Object localObject1;
    boolean bool2;
    try
    {
      paramString = new JSONObject(paramString);
      localActivity = getActivity();
      localObject1 = getFragment();
      if ((!(localActivity instanceof BaseActivity)) || (localActivity.isFinishing()) || (localObject1 == null))
      {
        QLog.e("QQUiModule", 1, "shareMessage activity is finishing");
        return;
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString = null;
      }
      bool2 = false;
      if (paramString == null) {
        break label841;
      }
    }
    if ((localActivity instanceof BaseActivity)) {}
    for (;;)
    {
      Object localObject2;
      String str1;
      int i;
      boolean bool1;
      try
      {
        localObject2 = paramString.optString("viewType", "activity");
        str1 = paramString.optString("name");
        str2 = paramString.optString("options");
        i = paramString.optInt("animation", -1);
        bool1 = paramString.optBoolean("isNeedCloseCallback");
      }
      catch (Exception paramString)
      {
        String str2;
        label197:
        label220:
        bool1 = false;
        paramString = paramString;
        continue;
      }
      try
      {
        paramString = new JSONObject(str2);
        if ("popWindow".equals(localObject2))
        {
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("options", paramString.toString());
          if ("com.tencent.mobileqq.troop.activity.PublicCommentActivity".equals(str1))
          {
            new PublicCommentWindow((BaseActivity)localActivity, (Bundle)localObject1).a(localActivity);
            bool2 = false;
            bool1 = bool2;
            i = 1;
            if ((bool1) && (i != 0)) {
              break label881;
            }
            paramString = new HippyMap();
            if (i == 0) {
              break label876;
            }
            i = 0;
            paramString.pushInt("code", i);
            paramPromise.resolve(paramString);
            return;
          }
        }
      }
      catch (JSONException paramString)
      {
        paramString = new JSONObject();
        continue;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("QQUiModule", 2, " openView startActivity failed");
          QLog.d("QQUiModule", 2, QLog.getStackTraceString(paramString));
        }
        i = 0;
        continue;
        if (!"com.tencent.mobileqq.troop.activity.TroopBarCommentActivity".equals(str1)) {
          continue;
        }
        new TroopBarCommentWindow((BaseActivity)localActivity, (Bundle)localObject1).a(localActivity);
        continue;
      }
      if ("activity".equals(localObject2))
      {
        localObject2 = new Intent();
        if ("cooperation.comic.VipComicJumpActivity".equals(str1))
        {
          ((Intent)localObject2).setComponent(new ComponentName(getActivity(), str1));
          ((Intent)localObject2).putExtra("click_start_time", System.currentTimeMillis());
          label375:
          ((Intent)localObject2).putExtra("options", paramString.toString());
          if (bool1) {
            break label604;
          }
          ((Fragment)localObject1).startActivity((Intent)localObject2);
          break label887;
        }
      }
      for (;;)
      {
        bool2 = bool1;
        if (!PoiMapActivity.class.getName().equals(str1)) {
          break;
        }
        if (this.mClient == null)
        {
          this.mClient = TroopMemberApiClient.a();
          this.mClient.a();
        }
        this.mClient.c();
        bool2 = bool1;
        break;
        if ("cooperation.qqindividuality.QQIndividualityBridgeActivity".equals(str1))
        {
          ((Intent)localObject2).setComponent(new ComponentName(localActivity, str1));
          ((Intent)localObject2).putExtra("k_source", 0);
          ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
          ((Intent)localObject2).putExtra(QQIndividualityUtils.l, 1);
          ((Intent)localObject2).putExtra(QQIndividualityUtils.e, "path");
          ((Intent)localObject2).putExtra(QQIndividualityUtils.f, "name");
          break label375;
        }
        if ("com.tencent.mobileqq.activity.AuthDevOpenUgActivity".equals(str1))
        {
          ((Intent)localObject2).setComponent(new ComponentName(localActivity, str1));
          ((Intent)localObject2).putExtra("AUTH_DEV_OPEN_UG_ACTIVITY", "true");
          break label375;
        }
        ((Intent)localObject2).setComponent(new ComponentName(localActivity, str1));
        break label375;
        label604:
        ((Fragment)localObject1).startActivityForResult((Intent)localObject2, 101);
        break label887;
        localActivity.overridePendingTransition(2130771981, 2130771979);
        continue;
        bool2 = bool1;
        if (!"activityWrapper".equals(localObject2)) {
          break;
        }
        if (str1.equals("com.tencent.mobileqq.richmedia.capture.activity.CameraCaptureActivity"))
        {
          bool2 = bool1;
          if (paramString.optInt("openSource", 0) != 1) {
            break;
          }
          str1 = paramString.optString("from", "");
          paramString = TribePublishLauncher.a(localActivity, getAppInterface(), paramString.toString(), (byte)101, str1);
          bool2 = bool1;
          if (paramString == null) {
            break;
          }
          downloadShortVideoFilterSo();
          ((Fragment)localObject1).startActivityForResult(paramString, 101);
          localActivity.overridePendingTransition(2130771981, 2130771979);
          bool2 = bool1;
          break;
        }
        bool2 = bool1;
        if (!str1.equals(TroopBarReplyActivity.class.getName())) {
          break;
        }
        localObject2 = new Intent();
        ((Intent)localObject2).setComponent(new ComponentName(localActivity, str1));
        ((Intent)localObject2).putExtra("options", paramString.toString());
        if (!bool1)
        {
          ((Fragment)localObject1).startActivity((Intent)localObject2);
          break label911;
          localActivity.overridePendingTransition(2130771981, 2130771979);
          bool2 = bool1;
          break;
        }
        ((Fragment)localObject1).startActivityForResult((Intent)localObject2, 101);
        break label911;
        label841:
        int j = 0;
        i = j;
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          break label197;
        }
        QLog.d("QQUiModule", 2, "openView error, json is NULL-----");
        i = j;
        bool1 = bool2;
        break label197;
        label876:
        i = -1;
        break label220;
        label881:
        this.mOpenViewPromise = paramPromise;
        return;
        label887:
        switch (i)
        {
        }
      }
      label911:
      switch (i)
      {
      }
      bool2 = bool1;
    }
  }
  
  private void newSubscribeRecurrentNotifyFragment(JSONObject paramJSONObject, Promise paramPromise)
  {
    String str1 = paramJSONObject.optString("msgid");
    String str2 = paramJSONObject.optString("busiid");
    paramJSONObject = paramJSONObject.optString("domain");
    this.mNotifyPromise = null;
    this.mNotifyPromise = paramPromise;
    HippyMap localHippyMap = new HippyMap();
    if ((StringUtil.a(str1)) || (StringUtil.a(str2)))
    {
      localHippyMap.pushInt("code", -1);
      if (paramPromise != null) {
        paramPromise.resolve(localHippyMap);
      }
      return;
    }
    QQNotifyUtils.a(getActivity(), str1, paramJSONObject, str2, QQNotifySettingBaseFragment.a);
  }
  
  private void onActionSheetCancel()
  {
    if (this.mActionSheetPromise != null)
    {
      HippyMap localHippyMap = new HippyMap();
      localHippyMap.pushInt("type", 1);
      localHippyMap.pushInt("index", this.mActionSheetItemCount);
      this.mActionSheetPromise.resolve(localHippyMap);
    }
  }
  
  private void queryBusinessHasSet(JSONObject paramJSONObject, Promise paramPromise)
  {
    String str1 = paramJSONObject.optString("msgid");
    String str2 = paramJSONObject.optString("busiid");
    paramJSONObject = paramJSONObject.optString("domain");
    this.mNotifyPromise = null;
    this.mNotifyPromise = paramPromise;
    HippyMap localHippyMap = new HippyMap();
    if ((StringUtil.a(str1)) || (StringUtil.a(str2)))
    {
      localHippyMap.pushInt("code", -1);
      if (paramPromise != null) {
        paramPromise.resolve(localHippyMap);
      }
      return;
    }
    QQNotifyUtils.a(str1, paramJSONObject, str2, this);
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.mActionSheetPromise != null)
    {
      paramView = new HippyMap();
      paramView.pushInt("index", paramInt);
      if ((!this.mActionSheetIsCancle) || (paramInt != 0)) {
        break label67;
      }
      paramView.pushInt("type", 2);
    }
    for (;;)
    {
      this.mActionSheetPromise.resolve(paramView);
      if (this.mActionSheet != null) {
        this.mActionSheet.dismiss();
      }
      return;
      label67:
      paramView.pushInt("type", 0);
    }
  }
  
  public void destroy()
  {
    super.destroy();
    if (this.mShareMsgImpl != null) {
      this.mShareMsgImpl.a();
    }
    if (this.mClient != null) {
      this.mClient.b();
    }
  }
  
  public void downloadShortVideoFilterSo()
  {
    if (this.mClient == null) {
      this.mClient = TroopMemberApiClient.a();
    }
    this.mClient.e();
  }
  
  public void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
      if (this.mShareMsgImpl != null) {
        this.mShareMsgImpl.a(paramIntent, (byte)paramInt1, paramInt2);
      }
      if ((paramInt1 == CODE_SUBSCRIBE) && (this.mNotifyPromise != null))
      {
        paramActivity = new HippyMap();
        if (paramInt2 != -1) {
          break label192;
        }
        paramActivity.pushInt("retcode", paramIntent.getIntExtra("errorCode", 0));
        paramActivity.pushString("retmsg", paramIntent.getStringExtra("msg"));
      }
      break;
    }
    for (;;)
    {
      this.mNotifyPromise.resolve(paramActivity);
      return;
      if (this.mOpenViewPromise == null) {
        break;
      }
      HippyMap localHippyMap = new HippyMap();
      if (paramInt2 == -1) {
        if (paramIntent == null)
        {
          paramActivity = "";
          label138:
          localHippyMap.pushInt("code", 0);
          localHippyMap.pushString("result", paramActivity);
        }
      }
      for (;;)
      {
        this.mOpenViewPromise.resolve(localHippyMap);
        break;
        paramActivity = paramIntent.getStringExtra("result");
        break label138;
        localHippyMap.pushInt("code", -1);
      }
      label192:
      paramActivity.pushInt("retcode", -1);
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    onActionSheetCancel();
  }
  
  public void onDismiss()
  {
    if (this.mActionSheetPromise != null) {
      onActionSheetCancel();
    }
  }
  
  public void onDismissOperations()
  {
    Object localObject = getActivity();
    if ((localObject instanceof PublicFragmentActivity))
    {
      localObject = ((PublicFragmentActivity)localObject).a();
      if ((localObject instanceof TribeVideoListPlayerFragment)) {
        ((TribeVideoListPlayerFragment)localObject).a(this.mActionSheet);
      }
    }
  }
  
  @HippyMethod(name="openMiniApp")
  public void openMiniApp(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQUiModule", 2, "openMiniApp:" + paramString);
    }
    Activity localActivity = getActivity();
    if (localActivity == null)
    {
      QLog.e("QQUiModule", 1, "openMiniApp activity is null");
      return;
    }
    try
    {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(localActivity, paramString, 2016, null);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("QQUiModule", 1, "openMiniApp error: " + paramString.getMessage());
    }
  }
  
  @HippyMethod(name="openUrl")
  public void openUrl(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQUiModule", 2, "openUrl:" + paramString);
    }
    Activity localActivity = getActivity();
    AppInterface localAppInterface = getAppInterface();
    if ((localActivity == null) || (localAppInterface == null))
    {
      QLog.e("QQUiModule", 1, "openUrl activity or appinterface is null");
      return;
    }
    UiApiPlugin.a(localActivity, null, localAppInterface, paramString, true, true);
  }
  
  @HippyMethod(name="openView")
  public void openView(String paramString, Promise paramPromise)
  {
    ThreadManager.getUIHandler().post(new QQUiModule.3(this, paramString, paramPromise));
  }
  
  @HippyMethod(name="qqNotify")
  public void qqNotify(String paramString, Promise paramPromise)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      paramString = localJSONObject.optString("action");
      localJSONObject = localJSONObject.optJSONObject("params");
      if ("newSubscribe".equals(paramString))
      {
        newSubscribeRecurrentNotifyFragment(localJSONObject, paramPromise);
        return;
      }
      if ("query".equals(paramString))
      {
        queryBusinessHasSet(localJSONObject, paramPromise);
        return;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("QQUiModule", 2, "qqNotify error:" + paramString.getMessage());
    }
  }
  
  public void queryHasSetNotify(Bundle paramBundle1, @Nullable Bundle paramBundle2)
  {
    int i = paramBundle1.getInt("retcode", -1);
    paramBundle2 = paramBundle1.getString("retmsg", "");
    int j = paramBundle1.getInt("has_subscribe", -1);
    paramBundle1 = new HippyMap();
    paramBundle1.pushInt("retcode", i);
    paramBundle1.pushString("retmsg", paramBundle2);
    if (i == 0) {
      paramBundle1.pushInt("has_subscribe", j);
    }
    if (this.mNotifyPromise != null) {
      this.mNotifyPromise.resolve(paramBundle1);
    }
  }
  
  @HippyMethod(name="setStatusBarDarkFont")
  public void setStatusBarDarkFont(boolean paramBoolean)
  {
    Activity localActivity = getActivity();
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      localActivity.runOnUiThread(new QQUiModule.1(this, paramBoolean));
      return;
    }
    QLog.e("QQUiModule", 1, "setStatusBarDarkFont activity is null");
  }
  
  @HippyMethod(name="shareMessage")
  public void shareMessage(String paramString, Promise paramPromise)
  {
    AppInterface localAppInterface;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = getActivity();
      localAppInterface = getAppInterface();
      if ((!(localObject instanceof BaseActivity)) || (localAppInterface == null)) {
        QLog.e("QQUiModule", 1, "shareMessage activity isvnot BaseActivity or appinterface is null");
      }
    }
    else
    {
      return;
    }
    Object localObject = (BaseActivity)localObject;
    if (this.mShareMsgImpl == null) {
      this.mShareMsgImpl = new ShareMsgImpl((Context)localObject, (Activity)localObject, localAppInterface, this.mShareMsgImplListener);
    }
    try
    {
      this.mShareMsgPromise = null;
      paramString = new JSONObject(paramString);
      if (paramPromise != null)
      {
        paramString.put("callback", paramPromise.getCallId());
        this.mShareMsgPromise = paramPromise;
      }
      this.mShareMsgImpl.a(paramString.toString(), false);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("QQUiModule", 1, "shareMessage error:" + paramString);
    }
  }
  
  @HippyMethod(name="showActionSheet")
  public void showActionSheet(String paramString, Promise paramPromise)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("QQUiModule", 1, "showActionSheet params is empty");
      return;
    }
    ThreadManager.getUIHandler().post(new QQUiModule.5(this, paramString, paramPromise));
  }
  
  @HippyMethod(name="showDialog")
  public void showDialog(String paramString, Promise paramPromise)
  {
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString != null) {
        ThreadManager.getUIHandler().post(new QQUiModule.4(this, paramPromise, paramString));
      }
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  @HippyMethod(name="showProfile")
  public void showProfile(String paramString)
  {
    AppInterface localAppInterface;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = getActivity();
      localAppInterface = getAppInterface();
      if ((!(localObject instanceof BaseActivity)) || (localAppInterface == null)) {
        QLog.e("QQUiModule", 1, "showProfile activity isvnot BaseActivity or appInterface is null");
      }
    }
    else
    {
      return;
    }
    Object localObject = (BaseActivity)localObject;
    ((IPublicAccountJavascriptInterface)QRoute.api(IPublicAccountJavascriptInterface.class)).excuteShowProfile(localAppInterface, (Context)localObject, paramString);
  }
  
  @HippyMethod(name="showTips")
  public void showTips(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      ThreadManager.getUIHandler().post(new QQUiModule.2(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQUiModule
 * JD-Core Version:    0.7.0.1
 */