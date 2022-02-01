package com.tencent.mobileqq.app;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginContainer;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

public class BabyQFriendStatusWebViewPlugin
  extends WebViewPlugin
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new BabyQFriendStatusWebViewPlugin.1(this);
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private EIPCResultCallback jdField_a_of_type_EipcEIPCResultCallback = new BabyQFriendStatusWebViewPlugin.2(this);
  private String jdField_a_of_type_JavaLangString = null;
  
  public BabyQFriendStatusWebViewPlugin()
  {
    this.mPluginNameSpace = "babyQ";
  }
  
  public static void a(Activity paramActivity, ProfileCardInfo paramProfileCardInfo, String paramString1, int paramInt, String paramString2)
  {
    Class localClass = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getProfileCardActivityClass();
    Intent localIntent = AIOUtils.a(new Intent(paramActivity, SplashActivity.class), null);
    localIntent.putExtra("PREVIOUS_WINDOW", localClass.getName());
    localIntent.putExtra("PREVIOUS_UIN", paramProfileCardInfo.allInOne.uin);
    if ((paramActivity.getIntent() != null) && (paramActivity.getIntent().getExtras() != null)) {
      localIntent.putExtra("cSpecialFlag", paramActivity.getIntent().getExtras().getInt("cSpecialFlag"));
    }
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("aio_msg_source", 3);
    if (paramProfileCardInfo.allInOne.chatEntrance != 0) {
      localIntent.putExtra("entrance", paramProfileCardInfo.allInOne.chatEntrance);
    }
    localIntent.putExtra("uinname", paramString2);
    paramActivity.startActivity(localIntent);
  }
  
  private void c(Bundle paramBundle)
  {
    paramBundle = QIPCClientHelper.getInstance().getClient().callServer("BabyQIPCModule", "sendmsg", paramBundle);
    if (paramBundle.isSuccess())
    {
      paramBundle = (AllInOne)paramBundle.data.getParcelable("key_parcel_allinone");
      ProfileCardInfo localProfileCardInfo = new ProfileCardInfo();
      localProfileCardInfo.allInOne = paramBundle;
      localProfileCardInfo.card = new Card();
      localProfileCardInfo.card.uin = AppConstants.BABY_Q_UIN;
      a(this.mRuntime.a(), localProfileCardInfo, AppConstants.BABY_Q_UIN, 0, paramBundle.nickname);
    }
  }
  
  void a(Bundle paramBundle)
  {
    if (QIPCClientHelper.getInstance().getClient().callServer("BabyQIPCModule", "deleteFriend", paramBundle).isSuccess()) {
      BaseApplicationImpl.getContext().sendBroadcast(new Intent("com.tencent.mobileqq.action.ACTION_WEBVIEW_CLOSE"), "com.tencent.msg.permission.pushnotify");
    }
  }
  
  void a(String paramString, Bundle paramBundle)
  {
    BabyQIPCModule.a().a(paramString, paramBundle, this.jdField_a_of_type_EipcEIPCResultCallback);
  }
  
  void a(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("(");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(");");
      paramString1 = localStringBuilder.toString();
      callJs(paramString1);
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("babyqWeb callback js api: jsapi=");
        paramString2.append(paramString3);
        paramString2.append(", script=");
        paramString2.append(paramString1);
        QLog.i("BabyQFriendStatusWebViewPlugin", 2, paramString2.toString());
      }
    }
  }
  
  void a(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    paramBundle = QIPCClientHelper.getInstance().getClient().callServer("BabyQIPCModule", "getFriendStatus", paramBundle);
    if (paramBundle.isSuccess())
    {
      long l = paramBundle.data.getLong("key_get_friend_status");
      paramString3 = new StringBuilder();
      paramString3.append("{ \"ret\": 0, \"response\": { \"has_add\":");
      paramString3.append(l);
      paramString3.append("}}");
      paramString3 = paramString3.toString();
    }
    a(paramString1, paramString3, paramString2);
  }
  
  void a(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
    try
    {
      localObject = new JSONObject(paramVarArgs[0]);
      String str = ((JSONObject)localObject).optString("callback");
      int i = ((JSONObject)localObject).optInt("user_type");
      int j = ((JSONObject)localObject).optInt("from_type");
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_JavaLangString = str;
        localObject = new Intent("com.tencent.mobileqq.babyq.add");
        ((Intent)localObject).putExtra("user_type", i);
        ((Intent)localObject).putExtra("from_type", j);
        ((Intent)localObject).setPackage(this.jdField_a_of_type_AndroidAppActivity.getPackageName());
        this.jdField_a_of_type_AndroidAppActivity.sendBroadcast((Intent)localObject);
        return;
      }
      this.jdField_a_of_type_JavaLangString = null;
      return;
    }
    catch (JSONException localJSONException)
    {
      Object localObject;
      label124:
      break label124;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("babyqWeb setFriendStatus req error args msg: ");
    ((StringBuilder)localObject).append(paramVarArgs[0]);
    QLog.d("BabyQFriendStatusWebViewPlugin", 1, ((StringBuilder)localObject).toString());
  }
  
  Object[] a(String paramString, String... paramVarArgs)
  {
    long l2 = 0L;
    String str2 = null;
    String str1 = null;
    long l1 = l2;
    Object localObject = str1;
    if (paramVarArgs != null)
    {
      l1 = l2;
      localObject = str1;
      if (paramVarArgs.length > 0) {
        str1 = str2;
      }
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramVarArgs[0]);
      str1 = str2;
      str2 = localJSONObject.optString("callback");
      l1 = l2;
      localObject = str2;
      str1 = str2;
      if (!paramString.equals("setPushStatus")) {
        break label173;
      }
      str1 = str2;
      int i = localJSONObject.optInt("pushStatus");
      l1 = i;
      localObject = str2;
    }
    catch (JSONException localJSONException)
    {
      label110:
      break label110;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("babyqWeb ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" req error args msg: ");
    ((StringBuilder)localObject).append(paramVarArgs[0]);
    QLog.e("BabyQFriendStatusWebViewPlugin", 1, ((StringBuilder)localObject).toString());
    localObject = str1;
    l1 = l2;
    label173:
    return new Object[] { localObject, Long.valueOf(l1) };
  }
  
  void b(Bundle paramBundle)
  {
    Object localObject = QIPCClientHelper.getInstance().getClient().callServer("BabyQIPCModule", "setFriendGrouping", paramBundle);
    if (((EIPCResult)localObject).isSuccess())
    {
      String str = ((EIPCResult)localObject).data.getString("friendUin");
      byte b = ((EIPCResult)localObject).data.getByte("mgid");
      localObject = this.mRuntime.a();
      Intent localIntent = new Intent((Context)localObject, MoveToGroupActivity.class);
      localIntent.putExtra("friendUin", str);
      localIntent.putExtra("mgid", b);
      localIntent.putExtra("key_from_babyq_web_plugin", true);
      ((Activity)localObject).startActivity(localIntent);
      QLog.i("BabyQFriendStatusWebViewPlugin", 1, "babyqWeb set group begin");
    }
    a("setFriendGrouping", paramBundle);
  }
  
  void b(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    paramBundle = QIPCClientHelper.getInstance().getClient().callServer("BabyQIPCModule", "getZanVoteCount", paramBundle);
    if (paramBundle.isSuccess())
    {
      long l = paramBundle.data.getLong("key_get_zan_vote_count");
      paramString3 = new StringBuilder();
      paramString3.append("{ \"ret\": 0, \"votecount\": ");
      paramString3.append(l);
      paramString3.append("}");
      paramString3 = paramString3.toString();
    }
    a(paramString1, paramString3, paramString2);
  }
  
  void c(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    paramBundle = QIPCClientHelper.getInstance().getClient().callServer("BabyQIPCModule", "requestZan", paramBundle);
    if (paramBundle.isSuccess())
    {
      long l = paramBundle.data.getLong("key_request_zan_vote_result", 2L);
      paramString3 = new StringBuilder();
      paramString3.append("{\"ret\":");
      paramString3.append(l);
      paramString3.append("}");
      paramString3 = paramString3.toString();
    }
    a(paramString1, paramString3, paramString2);
  }
  
  void d(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    paramBundle = QIPCClientHelper.getInstance().getClient().callServer("BabyQIPCModule", "getFriendGrouping", paramBundle);
    if (paramBundle.isSuccess())
    {
      paramString3 = paramBundle.data.getString("key_handle_set_get_group");
      paramBundle = new StringBuilder();
      paramBundle.append("{ \"ret\": 0, \"group\": \"");
      paramBundle.append(paramString3);
      paramBundle.append("\"}");
      paramString3 = paramBundle.toString();
    }
    a(paramString1, paramString3, paramString2);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    QLog.d("BabyQFriendStatusWebViewPlugin", 1, new Object[] { "babyqWeb handleJsRequest url =", paramString1, ",method=", paramString3 });
    if ((paramString2 != null) && (paramString2.equalsIgnoreCase("babyQ")) && (!TextUtils.isEmpty(paramString3)) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null))
    {
      if (this.jdField_a_of_type_AndroidAppActivity == null) {
        return false;
      }
      paramString1 = a(paramString3, paramVarArgs);
      if (paramString1[0] != null) {
        paramJsBridgeListener = (String)paramString1[0];
      } else {
        paramJsBridgeListener = null;
      }
      long l;
      if (paramString1[1] != null) {
        l = ((Integer)paramString1[1]).intValue();
      } else {
        l = 0L;
      }
      paramString2 = new Bundle();
      paramString2.putString("web_js_call_back_id", paramJsBridgeListener);
      paramString1 = "";
      if (paramString3.equals("getFriendStatus"))
      {
        a(paramJsBridgeListener, paramString3, "", paramString2);
        return true;
      }
      if (paramString3.equals("setFriendStatus"))
      {
        a(paramVarArgs);
        return true;
      }
      if (paramString3.equals("getZanVoteCount"))
      {
        b(paramJsBridgeListener, paramString3, "", paramString2);
        return true;
      }
      if (paramString3.equals("requestZan"))
      {
        c(paramJsBridgeListener, paramString3, "", paramString2);
        return true;
      }
      if (paramString3.equals("addFriend"))
      {
        paramJsBridgeListener = this.mRuntime.a(this.mRuntime.a());
        int i;
        if ((paramJsBridgeListener instanceof WebViewPluginContainer)) {
          i = ((WebViewPluginContainer)paramJsBridgeListener).switchRequestCode(this, (byte)1);
        } else {
          i = 1;
        }
        paramJsBridgeListener = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this.mRuntime.a(), 2, AppConstants.BABY_Q_UIN, null, 3001, 12, "babyQ", null, null, null, null);
        ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriendForResult(this.mRuntime.a(), paramJsBridgeListener, i);
        return true;
      }
      if (paramString3.equals("sendmsg"))
      {
        c(paramString2);
        return true;
      }
      if (paramString3.equals("deleteFriend"))
      {
        a(paramString2);
        return true;
      }
      if (paramString3.equals("getFriendGrouping"))
      {
        d(paramJsBridgeListener, paramString3, "", paramString2);
        return true;
      }
      if (paramString3.equals("setFriendGrouping"))
      {
        b(paramString2);
        return true;
      }
      if (paramString3.equals("reportFriend"))
      {
        paramJsBridgeListener = QIPCClientHelper.getInstance().getClient().callServer("BabyQIPCModule", "reportFriend", paramString2);
        if (paramJsBridgeListener.isSuccess())
        {
          paramJsBridgeListener = paramJsBridgeListener.data.getString("key_report_msg");
          NewReportPlugin.a((BaseActivity)this.mRuntime.a(), AppConstants.BABY_Q_UIN, null, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), 21001, paramJsBridgeListener);
        }
        return true;
      }
      if (paramString3.equals("getPushStatus"))
      {
        paramString2 = QIPCClientHelper.getInstance().getClient().callServer("BabyQIPCModule", "getPushStatus", paramString2);
        if (paramString2.isSuccess())
        {
          l = paramString2.data.getLong("key_request_zan_vote_result", 0L);
          paramString1 = new StringBuilder();
          paramString1.append("{ \"ret\": 0, \"pushStatus\": ");
          paramString1.append(l);
          paramString1.append("}");
          paramString1 = paramString1.toString();
        }
        a(paramJsBridgeListener, paramString1, paramString3);
        return true;
      }
      if (paramString3.equals("setPushStatus"))
      {
        paramString2.putLong("key_push_status", l);
        a("setPushStatus", paramString2);
        return true;
      }
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BabyQFriendStatusWebViewPlugin", 2, String.format("babyqWeb onActivityResult requestCode=%s resultCode=%s intent=%s", new Object[] { Byte.valueOf(paramByte), Integer.valueOf(paramInt), paramIntent }));
    }
  }
  
  protected void onCreate()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = this.mRuntime.a();
    this.jdField_a_of_type_AndroidAppActivity = this.mRuntime.a();
    Object localObject;
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("com.tencent.mobileqq.babyq.added");
      this.jdField_a_of_type_AndroidAppActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("babyqWeb BabyQFriendStatusWebViewPlugin onCreate:");
      ((StringBuilder)localObject).append(this);
      QLog.d("BabyQFriendStatusWebViewPlugin", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("babyqWeb BabyQFriendStatusWebViewPlugin onDestroy:");
      ((StringBuilder)localObject).append(this);
      QLog.d("BabyQFriendStatusWebViewPlugin", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_AndroidAppActivity;
    if (localObject != null) {}
    try
    {
      ((Activity)localObject).unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      label60:
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
      return;
    }
    catch (Exception localException)
    {
      break label60;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.BabyQFriendStatusWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */