package com.tencent.mobileqq.app;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONException;
import org.json.JSONObject;
import yzv;
import yzw;

public class BabyQFriendStatusWebViewPlugin
  extends WebViewPlugin
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new yzv(this);
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private EIPCResultCallback jdField_a_of_type_EipcEIPCResultCallback = new yzw(this);
  private String jdField_a_of_type_JavaLangString;
  
  public BabyQFriendStatusWebViewPlugin()
  {
    this.mPluginNameSpace = "babyQ";
  }
  
  private void a(String paramString, Bundle paramBundle)
  {
    BabyQIPCModule.a().a(paramString, paramBundle, this.jdField_a_of_type_EipcEIPCResultCallback);
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString1 = paramString1 + "(" + paramString2 + ");";
      callJs(paramString1);
      if (QLog.isColorLevel()) {
        QLog.i("BabyQFriendStatusWebViewPlugin", 2, "babyqWeb callback js api: jsapi=" + paramString3 + ", script=" + paramString1);
      }
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BabyQFriendStatusWebViewPlugin", 2, new Object[] { "babyqWeb handleJsRequest url =", paramString1, ",method=", paramString3 });
    }
    if ((paramString2 == null) || (!paramString2.equalsIgnoreCase("babyQ")) || (TextUtils.isEmpty(paramString3)) || (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) || (this.jdField_a_of_type_AndroidAppActivity == null)) {
      return false;
    }
    paramString2 = null;
    paramString1 = null;
    long l2 = 0L;
    long l1 = l2;
    paramJsBridgeListener = paramString1;
    if (paramVarArgs != null)
    {
      l1 = l2;
      paramJsBridgeListener = paramString1;
      if (paramVarArgs.length > 0) {
        paramString1 = paramString2;
      }
    }
    try
    {
      localJSONObject = new JSONObject(paramVarArgs[0]);
      paramString1 = paramString2;
      paramString2 = localJSONObject.optString("callback");
      l1 = l2;
      paramJsBridgeListener = paramString2;
      paramString1 = paramString2;
      if (paramString3.equals("setPushStatus"))
      {
        paramString1 = paramString2;
        i = localJSONObject.optInt("pushStatus");
        l1 = i;
        paramJsBridgeListener = paramString2;
      }
    }
    catch (JSONException paramJsBridgeListener)
    {
      JSONObject localJSONObject;
      int i;
      Bundle localBundle;
      Object localObject;
      for (;;)
      {
        l1 = l2;
        paramJsBridgeListener = paramString1;
        if (QLog.isColorLevel())
        {
          QLog.i("BabyQFriendStatusWebViewPlugin", 2, "babyqWeb " + paramString3 + " req error args msg: " + paramVarArgs[0]);
          l1 = l2;
          paramJsBridgeListener = paramString1;
        }
      }
      if (!paramString3.equals("setFriendStatus")) {
        break label495;
      }
      if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
        break label1286;
      }
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        paramString1 = paramJsBridgeListener.optString("callback");
        i = paramJsBridgeListener.optInt("user_type");
        int j = paramJsBridgeListener.optInt("from_type");
        if (!TextUtils.isEmpty(paramString1))
        {
          this.jdField_a_of_type_JavaLangString = paramString1;
          paramJsBridgeListener = new Intent("com.tencent.mobileqq.babyq.add");
          paramJsBridgeListener.putExtra("user_type", i);
          paramJsBridgeListener.putExtra("from_type", j);
          paramJsBridgeListener.setPackage(this.jdField_a_of_type_AndroidAppActivity.getPackageName());
          this.jdField_a_of_type_AndroidAppActivity.sendBroadcast(paramJsBridgeListener);
        }
        else
        {
          this.jdField_a_of_type_JavaLangString = null;
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        if (!QLog.isColorLevel()) {
          break label1286;
        }
      }
      QLog.d("BabyQFriendStatusWebViewPlugin", 2, "babyqWeb setFriendStatus req error args msg: " + paramVarArgs[0]);
      break label1286;
      label495:
      if (!paramString3.equals("getZanVoteCount")) {
        break label575;
      }
      paramString2 = QIPCClientHelper.getInstance().getClient().callServer("BabyQIPCModule", "getZanVoteCount", localBundle);
      if (!paramString2.isSuccess()) {
        break label565;
      }
      l1 = paramString2.data.getLong("key_get_zan_vote_count");
      paramString1 = "{ \"ret\": 0, \"votecount\": " + l1 + "}";
      label565:
      a(paramJsBridgeListener, paramString1, paramString3);
      return true;
      label575:
      if (!paramString3.equals("requestZan")) {
        break label663;
      }
      paramVarArgs = QIPCClientHelper.getInstance().getClient().callServer("BabyQIPCModule", "requestZan", localBundle);
      paramString1 = paramString2;
      if (!paramVarArgs.isSuccess()) {
        break label653;
      }
      l1 = paramVarArgs.data.getLong("key_request_zan_vote_result", 2L);
      paramString1 = "{\"ret\":" + l1 + "}";
      label653:
      a(paramJsBridgeListener, paramString1, paramString3);
      return true;
      label663:
      if (!paramString3.equals("addFriend")) {
        break label705;
      }
      startActivityForResult(AddFriendLogicActivity.a(this.mRuntime.a(), 2, AppConstants.au, null, 3001, 0, "babyQ", null, null, null, null), (byte)1);
      return true;
      label705:
      if (!paramString3.equals("sendmsg")) {
        break label809;
      }
      paramJsBridgeListener = QIPCClientHelper.getInstance().getClient().callServer("BabyQIPCModule", "sendmsg", localBundle);
      if (!paramJsBridgeListener.isSuccess()) {
        break label807;
      }
      paramJsBridgeListener = (ProfileActivity.AllInOne)paramJsBridgeListener.data.getParcelable("key_parcel_allinone");
      paramString1 = new ProfileCardInfo();
      paramString1.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = paramJsBridgeListener;
      paramString1.jdField_a_of_type_ComTencentMobileqqDataCard = new Card();
      paramString1.jdField_a_of_type_ComTencentMobileqqDataCard.uin = AppConstants.au;
      FriendProfileCardActivity.a(this.mRuntime.a(), paramString1, AppConstants.au, 0, paramJsBridgeListener.h);
      label807:
      return true;
      label809:
      if (!paramString3.equals("deleteFriend")) {
        break label863;
      }
      if (!QIPCClientHelper.getInstance().getClient().callServer("BabyQIPCModule", "deleteFriend", localBundle).isSuccess()) {
        break label861;
      }
      BaseApplicationImpl.getContext().sendBroadcast(new Intent("com.tencent.mobileqq.action.ACTION_WEBVIEW_CLOSE"), "com.tencent.msg.permission.pushnotify");
      label861:
      return true;
      label863:
      if (!paramString3.equals("getFriendGrouping")) {
        break label949;
      }
      paramString2 = QIPCClientHelper.getInstance().getClient().callServer("BabyQIPCModule", "getFriendGrouping", localBundle);
      paramString1 = localJSONObject;
      if (!paramString2.isSuccess()) {
        break label939;
      }
      paramString1 = paramString2.data.getString("key_handle_set_get_group");
      paramString1 = "{ \"ret\": 0, \"group\": \"" + paramString1 + "\"}";
      label939:
      a(paramJsBridgeListener, paramString1, paramString3);
      return true;
      label949:
      if (!paramString3.equals("setFriendGrouping")) {
        break label1086;
      }
      paramString1 = QIPCClientHelper.getInstance().getClient().callServer("BabyQIPCModule", "setFriendGrouping", localBundle);
      if (!paramString1.isSuccess()) {
        break label1075;
      }
      paramJsBridgeListener = paramString1.data.getString("friendUin");
      byte b = paramString1.data.getByte("mgid");
      paramString1 = this.mRuntime.a();
      paramString2 = new Intent(paramString1, MoveToGroupActivity.class);
      paramString2.putExtra("friendUin", paramJsBridgeListener);
      paramString2.putExtra("mgid", b);
      paramString2.putExtra("key_from_babyq_web_plugin", true);
      paramString1.startActivity(paramString2);
      if (!QLog.isColorLevel()) {
        break label1075;
      }
      QLog.i("BabyQFriendStatusWebViewPlugin", 2, "babyqWeb set group begin");
      label1075:
      a("setFriendGrouping", localBundle);
      return true;
      label1086:
      if (!paramString3.equals("reportFriend")) {
        break label1162;
      }
      paramJsBridgeListener = QIPCClientHelper.getInstance().getClient().callServer("BabyQIPCModule", "reportFriend", localBundle);
      if (!paramJsBridgeListener.isSuccess()) {
        break label1160;
      }
      paramJsBridgeListener = paramJsBridgeListener.data.getString("key_report_msg");
      ProfileCardUtil.a((BaseActivity)this.mRuntime.a(), AppConstants.au, null, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), 10027, paramJsBridgeListener);
      label1160:
      return true;
      label1162:
      if (!paramString3.equals("getPushStatus")) {
        break label1249;
      }
      paramString2 = QIPCClientHelper.getInstance().getClient().callServer("BabyQIPCModule", "getPushStatus", localBundle);
      paramString1 = localObject;
      if (!paramString2.isSuccess()) {
        break label1239;
      }
      l1 = paramString2.data.getLong("key_request_zan_vote_result", 0L);
      paramString1 = "{ \"ret\": 0, \"pushStatus\": " + l1 + "}";
      label1239:
      a(paramJsBridgeListener, paramString1, paramString3);
      return true;
      label1249:
      if (!paramString3.equals("setPushStatus")) {
        break label1279;
      }
      localBundle.putLong("key_push_status", l1);
      a("setPushStatus", localBundle);
      return true;
      label1279:
      return false;
    }
    localBundle = new Bundle();
    localBundle.putString("web_js_call_back_id", paramJsBridgeListener);
    paramString2 = null;
    localJSONObject = null;
    localObject = null;
    paramString1 = null;
    if (paramString3.equals("getFriendStatus"))
    {
      paramString1 = QIPCClientHelper.getInstance().getClient().callServer("BabyQIPCModule", "getFriendStatus", localBundle);
      if (!paramString1.isSuccess()) {
        break label1281;
      }
      l1 = paramString1.data.getLong("key_get_friend_status");
    }
    label1281:
    for (paramString1 = "{ \"ret\": 0, \"response\": { \"has_add\":" + l1 + "}}";; paramString1 = null)
    {
      a(paramJsBridgeListener, paramString1, paramString3);
      return true;
    }
    label1286:
    return true;
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
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.babyq.added");
      this.jdField_a_of_type_AndroidAppActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
    if (QLog.isColorLevel()) {
      QLog.d("BabyQFriendStatusWebViewPlugin", 2, "babyqWeb BabyQFriendStatusWebViewPlugin onCreate:" + this);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("BabyQFriendStatusWebViewPlugin", 2, "babyqWeb BabyQFriendStatusWebViewPlugin onDestroy:" + this);
    }
    if (this.jdField_a_of_type_AndroidAppActivity != null) {}
    try
    {
      this.jdField_a_of_type_AndroidAppActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      label54:
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
      return;
    }
    catch (Exception localException)
    {
      break label54;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BabyQFriendStatusWebViewPlugin
 * JD-Core Version:    0.7.0.1
 */