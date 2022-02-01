package com.tencent.hippy.qq.module;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.jsp.ShareMsgImpl;
import com.tencent.mobileqq.jsp.ShareMsgImpl.ShareMsgImplListener;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.activity.PublicCommentWindow;
import com.tencent.mobileqq.troop.activity.TroopBarCommentWindow;
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
  static final byte CODE_OPEN_CUSTOM_WEBVIEW = 14;
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
    Activity localActivity = null;
    this.mOpenViewPromise = null;
    try
    {
      paramString = new JSONObject(paramString);
      localActivity = getActivity();
      Object localObject1 = getFragment();
      boolean bool1 = localActivity instanceof QBaseActivity;
      int j;
      if ((bool1) && (!localActivity.isFinishing()) && (localObject1 != null))
      {
        j = 0;
        if ((paramString != null) && (bool1)) {
          try
          {
            localObject2 = paramString.optString("viewType", "activity");
            str1 = paramString.optString("name");
            str2 = paramString.optString("options");
            i = paramString.optInt("animation", -1);
            bool2 = paramString.optBoolean("isNeedCloseCallback");
          }
          catch (Exception paramString)
          {
            Object localObject2;
            String str1;
            String str2;
            label132:
            label441:
            label480:
            label491:
            bool1 = false;
          }
        }
      }
      try
      {
        try
        {
          paramString = new JSONObject(str2);
        }
        catch (Exception paramString)
        {
          bool1 = bool2;
          break label604;
        }
      }
      catch (JSONException paramString)
      {
        break label132;
        if (i == 1001) {
          break label480;
        }
        break label491;
      }
      paramString = new JSONObject();
      if ("popWindow".equals(localObject2))
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("options", paramString.toString());
        if ("com.tencent.mobileqq.troop.activity.PublicCommentActivity".equals(str1)) {
          new PublicCommentWindow((QBaseActivity)localActivity, (Bundle)localObject1).a(localActivity);
        } else if ("com.tencent.mobileqq.troop.activity.TroopBarCommentActivity".equals(str1)) {
          new TroopBarCommentWindow((QBaseActivity)localActivity, (Bundle)localObject1).a(localActivity);
        }
        bool1 = false;
      }
      else if ("activity".equals(localObject2))
      {
        localObject2 = new Intent();
        if ("cooperation.comic.VipComicJumpActivity".equals(str1)) {
          ((Intent)localObject2).setComponent(new ComponentName(getActivity(), str1));
        }
      }
      try
      {
        ((Intent)localObject2).putExtra("click_start_time", System.currentTimeMillis());
        break label441;
        if ("cooperation.qqindividuality.QQIndividualityBridgeActivity".equals(str1))
        {
          ((Intent)localObject2).setComponent(new ComponentName(localActivity, str1));
          ((Intent)localObject2).putExtra("k_source", 0);
          ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
          ((Intent)localObject2).putExtra(QQIndividualityUtils.l, 1);
          ((Intent)localObject2).putExtra(QQIndividualityUtils.e, "path");
          ((Intent)localObject2).putExtra(QQIndividualityUtils.f, "name");
        }
        else if ("com.tencent.mobileqq.activity.AuthDevOpenUgActivity".equals(str1))
        {
          ((Intent)localObject2).setComponent(new ComponentName(localActivity, str1));
          ((Intent)localObject2).putExtra("AUTH_DEV_OPEN_UG_ACTIVITY", "true");
        }
        else
        {
          ((Intent)localObject2).setComponent(new ComponentName(localActivity, str1));
        }
        ((Intent)localObject2).putExtra("options", paramString.toString());
        if (!bool2) {
          ((QBaseFragment)localObject1).startActivity((Intent)localObject2);
        } else {
          ((QBaseFragment)localObject1).startActivityForResult((Intent)localObject2, 101);
        }
      }
      catch (Exception paramString)
      {
        bool1 = bool2;
        break label604;
      }
      localActivity.overridePendingTransition(2130771993, 2130771991);
      bool1 = bool2;
      if (PoiMapActivity.class.getName().equals(str1))
      {
        if (this.mClient == null)
        {
          this.mClient = TroopMemberApiClient.a();
          this.mClient.a();
        }
        this.mClient.c();
        bool1 = bool2;
        break label587;
        bool1 = bool2;
        if ("activityWrapper".equals(localObject2))
        {
          bool1 = bool2;
          if (str1.equals("com.tencent.mobileqq.richmedia.capture.activity.CameraCaptureActivity"))
          {
            paramString.optInt("openSource", 0);
            bool1 = bool2;
          }
        }
      }
      label587:
      i = 1;
      break label664;
      label604:
      boolean bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("QQUiModule", 2, " openView startActivity failed");
        QLog.d("QQUiModule", 2, QLog.getStackTraceString(paramString));
        bool2 = bool1;
        break label658;
        if (QLog.isColorLevel()) {
          QLog.d("QQUiModule", 2, "openView error, json is NULL-----");
        }
        bool2 = false;
      }
      label658:
      i = 0;
      bool1 = bool2;
      label664:
      if ((bool1) && (i != 0))
      {
        this.mOpenViewPromise = paramPromise;
        return;
      }
      paramString = new HippyMap();
      if (i != 0) {
        i = j;
      } else {
        i = -1;
      }
      paramString.pushInt("code", i);
      paramPromise.resolve(paramString);
      return;
      QLog.e("QQUiModule", 1, "shareMessage activity is finishing");
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString = localActivity;
      }
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
    if ((!StringUtil.a(str1)) && (!StringUtil.a(str2)))
    {
      QQNotifyUtils.a(getActivity(), str1, paramJSONObject, str2, QQNotifySettingBaseFragment.a);
      return;
    }
    localHippyMap.pushInt("code", -1);
    if (paramPromise != null) {
      paramPromise.resolve(localHippyMap);
    }
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
    if ((!StringUtil.a(str1)) && (!StringUtil.a(str2)))
    {
      QQNotifyUtils.a(str1, paramJSONObject, str2, this);
      return;
    }
    localHippyMap.pushInt("code", -1);
    if (paramPromise != null) {
      paramPromise.resolve(localHippyMap);
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.mActionSheetPromise != null)
    {
      paramView = new HippyMap();
      paramView.pushInt("index", paramInt);
      if ((this.mActionSheetIsCancle) && (paramInt == 0)) {
        paramView.pushInt("type", 2);
      } else {
        paramView.pushInt("type", 0);
      }
      this.mActionSheetPromise.resolve(paramView);
    }
    paramView = this.mActionSheet;
    if (paramView != null) {
      paramView.dismiss();
    }
  }
  
  public void destroy()
  {
    super.destroy();
    Object localObject = this.mShareMsgImpl;
    if (localObject != null) {
      ((ShareMsgImpl)localObject).a();
    }
    localObject = this.mClient;
    if (localObject != null) {
      ((TroopMemberApiClient)localObject).b();
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
    if (paramInt1 != 101)
    {
      paramActivity = this.mShareMsgImpl;
      if (paramActivity != null) {
        paramActivity.a(paramIntent, (byte)paramInt1, paramInt2);
      }
    }
    else if (this.mOpenViewPromise != null)
    {
      HippyMap localHippyMap = new HippyMap();
      if (paramInt2 == -1)
      {
        if (paramIntent == null) {
          paramActivity = "";
        } else {
          paramActivity = paramIntent.getStringExtra("result");
        }
        localHippyMap.pushInt("code", 0);
        localHippyMap.pushString("result", paramActivity);
      }
      else
      {
        localHippyMap.pushInt("code", -1);
      }
      this.mOpenViewPromise.resolve(localHippyMap);
    }
    if ((paramInt1 == CODE_SUBSCRIBE) && (this.mNotifyPromise != null))
    {
      paramActivity = new HippyMap();
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        paramActivity.pushInt("retcode", paramIntent.getIntExtra("errorCode", 0));
        paramActivity.pushString("retmsg", paramIntent.getStringExtra("msg"));
      }
      else
      {
        paramActivity.pushInt("retcode", -1);
      }
      this.mNotifyPromise.resolve(paramActivity);
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
    Activity localActivity = getActivity();
    if ((localActivity instanceof PublicFragmentActivity)) {
      ((PublicFragmentActivity)localActivity).a();
    }
  }
  
  @HippyMethod(name="openMiniApp")
  public void openMiniApp(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("openMiniApp:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("QQUiModule", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = getActivity();
    if (localObject == null)
    {
      QLog.e("QQUiModule", 1, "openMiniApp activity is null");
      return;
    }
    try
    {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp((Context)localObject, paramString, 2016, null);
      return;
    }
    catch (Exception paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("openMiniApp error: ");
      ((StringBuilder)localObject).append(paramString.getMessage());
      QLog.e("QQUiModule", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  @HippyMethod(name="openUrl")
  public void openUrl(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("openUrl:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("QQUiModule", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = getActivity();
    AppInterface localAppInterface = getAppInterface();
    if ((localObject != null) && (localAppInterface != null))
    {
      UiApiPlugin.a((Activity)localObject, null, localAppInterface, paramString, true, true);
      return;
    }
    QLog.e("QQUiModule", 1, "openUrl activity or appinterface is null");
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
      paramPromise = new StringBuilder();
      paramPromise.append("qqNotify error:");
      paramPromise.append(paramString.getMessage());
      QLog.e("QQUiModule", 2, paramPromise.toString());
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
    paramBundle2 = this.mNotifyPromise;
    if (paramBundle2 != null) {
      paramBundle2.resolve(paramBundle1);
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
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = getActivity();
      AppInterface localAppInterface = getAppInterface();
      if (((localObject instanceof QBaseActivity)) && (localAppInterface != null))
      {
        localObject = (QBaseActivity)localObject;
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
          paramPromise = new StringBuilder();
          paramPromise.append("shareMessage error:");
          paramPromise.append(paramString);
          QLog.e("QQUiModule", 1, paramPromise.toString());
          return;
        }
      }
      QLog.e("QQUiModule", 1, "shareMessage activity isvnot BaseActivity or appinterface is null");
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
      ThreadManager.getUIHandler().post(new QQUiModule.4(this, paramPromise, paramString));
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
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = getActivity();
      AppInterface localAppInterface = getAppInterface();
      if (((localObject instanceof QBaseActivity)) && (localAppInterface != null))
      {
        localObject = (QBaseActivity)localObject;
        ((IPublicAccountJavascriptInterface)QRoute.api(IPublicAccountJavascriptInterface.class)).excuteShowProfile(localAppInterface, (Context)localObject, paramString);
        return;
      }
      QLog.e("QQUiModule", 1, "showProfile activity isvnot BaseActivity or appInterface is null");
    }
  }
  
  @HippyMethod(name="showTips")
  public void showTips(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      ThreadManager.getUIHandler().post(new QQUiModule.2(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQUiModule
 * JD-Core Version:    0.7.0.1
 */