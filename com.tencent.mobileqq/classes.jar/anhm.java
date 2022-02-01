import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
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
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

public class anhm
  extends WebViewPlugin
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new anhn(this);
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private EIPCResultCallback jdField_a_of_type_EipcEIPCResultCallback = new anho(this);
  private String jdField_a_of_type_JavaLangString;
  
  public anhm()
  {
    this.mPluginNameSpace = "babyQ";
  }
  
  private void a(Bundle paramBundle)
  {
    paramBundle = QIPCClientHelper.getInstance().getClient().callServer("BabyQIPCModule", "sendmsg", paramBundle);
    if (paramBundle.isSuccess())
    {
      paramBundle = (ProfileActivity.AllInOne)paramBundle.data.getParcelable("key_parcel_allinone");
      azfe localazfe = new azfe();
      localazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = paramBundle;
      localazfe.jdField_a_of_type_ComTencentMobileqqDataCard = new Card();
      localazfe.jdField_a_of_type_ComTencentMobileqqDataCard.uin = anhk.aC;
      FriendProfileCardActivity.a(this.mRuntime.a(), localazfe, anhk.aC, 0, paramBundle.h);
    }
  }
  
  private void a(String paramString, Bundle paramBundle)
  {
    anhs.a().a(paramString, paramBundle, this.jdField_a_of_type_EipcEIPCResultCallback);
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
  
  private void a(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    paramBundle = QIPCClientHelper.getInstance().getClient().callServer("BabyQIPCModule", "getFriendStatus", paramBundle);
    if (paramBundle.isSuccess())
    {
      long l = paramBundle.data.getLong("key_get_friend_status");
      paramString3 = "{ \"ret\": 0, \"response\": { \"has_add\":" + l + "}}";
    }
    a(paramString1, paramString3, paramString2);
  }
  
  private void a(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      try
      {
        Object localObject = new JSONObject(paramVarArgs[0]);
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
        QLog.d("BabyQFriendStatusWebViewPlugin", 1, "babyqWeb setFriendStatus req error args msg: " + paramVarArgs[0]);
      }
    }
  }
  
  private Object[] a(String paramString, String... paramVarArgs)
  {
    long l = 0L;
    String str2 = null;
    String str1;
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      str1 = str2;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramVarArgs[0]);
        str1 = str2;
        str2 = localJSONObject.optString("callback");
        str1 = str2;
        if (paramString.equals("setPushStatus"))
        {
          str1 = str2;
          int i = localJSONObject.optInt("pushStatus");
          l = i;
        }
        paramString = str2;
      }
      catch (JSONException localJSONException)
      {
        QLog.e("BabyQFriendStatusWebViewPlugin", 1, "babyqWeb " + paramString + " req error args msg: " + paramVarArgs[0]);
        l = 0L;
        paramString = str1;
        continue;
      }
      return new Object[] { paramString, Long.valueOf(l) };
      l = 0L;
      paramString = null;
    }
  }
  
  private void b(Bundle paramBundle)
  {
    if (QIPCClientHelper.getInstance().getClient().callServer("BabyQIPCModule", "deleteFriend", paramBundle).isSuccess()) {
      BaseApplicationImpl.getContext().sendBroadcast(new Intent("com.tencent.mobileqq.action.ACTION_WEBVIEW_CLOSE"), "com.tencent.msg.permission.pushnotify");
    }
  }
  
  private void b(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    paramBundle = QIPCClientHelper.getInstance().getClient().callServer("BabyQIPCModule", "getZanVoteCount", paramBundle);
    if (paramBundle.isSuccess())
    {
      long l = paramBundle.data.getLong("key_get_zan_vote_count");
      paramString3 = "{ \"ret\": 0, \"votecount\": " + l + "}";
    }
    a(paramString1, paramString3, paramString2);
  }
  
  private void c(Bundle paramBundle)
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
  
  private void c(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    paramBundle = QIPCClientHelper.getInstance().getClient().callServer("BabyQIPCModule", "requestZan", paramBundle);
    if (paramBundle.isSuccess())
    {
      long l = paramBundle.data.getLong("key_request_zan_vote_result", 2L);
      paramString3 = "{\"ret\":" + l + "}";
    }
    a(paramString1, paramString3, paramString2);
  }
  
  private void d(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    paramBundle = QIPCClientHelper.getInstance().getClient().callServer("BabyQIPCModule", "getFriendGrouping", paramBundle);
    if (paramBundle.isSuccess())
    {
      paramString3 = paramBundle.data.getString("key_handle_set_get_group");
      paramString3 = "{ \"ret\": 0, \"group\": \"" + paramString3 + "\"}";
    }
    a(paramString1, paramString3, paramString2);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    QLog.d("BabyQFriendStatusWebViewPlugin", 1, new Object[] { "babyqWeb handleJsRequest url =", paramString1, ",method=", paramString3 });
    if ((paramString2 == null) || (!paramString2.equalsIgnoreCase("babyQ")) || (TextUtils.isEmpty(paramString3)) || (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) || (this.jdField_a_of_type_AndroidAppActivity == null)) {
      return false;
    }
    paramString1 = a(paramString3, paramVarArgs);
    if (paramString1[0] != null)
    {
      paramJsBridgeListener = (String)paramString1[0];
      if (paramString1[1] == null) {
        break label156;
      }
    }
    label156:
    for (long l = ((Integer)paramString1[1]).intValue();; l = 0L)
    {
      paramString2 = new Bundle();
      paramString2.putString("web_js_call_back_id", paramJsBridgeListener);
      paramString1 = "";
      if (!paramString3.equals("getFriendStatus")) {
        break label162;
      }
      a(paramJsBridgeListener, paramString3, "", paramString2);
      return true;
      paramJsBridgeListener = null;
      break;
    }
    label162:
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
      startActivityForResult(AddFriendLogicActivity.a(this.mRuntime.a(), 2, anhk.aC, null, 3001, 12, "babyQ", null, null, null, null), (byte)1);
      return true;
    }
    if (paramString3.equals("sendmsg"))
    {
      a(paramString2);
      return true;
    }
    if (paramString3.equals("deleteFriend"))
    {
      b(paramString2);
      return true;
    }
    if (paramString3.equals("getFriendGrouping"))
    {
      d(paramJsBridgeListener, paramString3, "", paramString2);
      return true;
    }
    if (paramString3.equals("setFriendGrouping"))
    {
      c(paramString2);
      return true;
    }
    if (paramString3.equals("reportFriend"))
    {
      paramJsBridgeListener = QIPCClientHelper.getInstance().getClient().callServer("BabyQIPCModule", "reportFriend", paramString2);
      if (paramJsBridgeListener.isSuccess())
      {
        paramJsBridgeListener = paramJsBridgeListener.data.getString("key_report_msg");
        abao.a((BaseActivity)this.mRuntime.a(), anhk.aC, null, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), 21001, paramJsBridgeListener);
      }
      return true;
    }
    if (paramString3.equals("getPushStatus"))
    {
      paramString2 = QIPCClientHelper.getInstance().getClient().callServer("BabyQIPCModule", "getPushStatus", paramString2);
      if (paramString2.isSuccess())
      {
        l = paramString2.data.getLong("key_request_zan_vote_result", 0L);
        paramString1 = "{ \"ret\": 0, \"pushStatus\": " + l + "}";
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
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BabyQFriendStatusWebViewPlugin", 2, String.format("babyqWeb onActivityResult requestCode=%s resultCode=%s intent=%s", new Object[] { Byte.valueOf(paramByte), Integer.valueOf(paramInt), paramIntent }));
    }
  }
  
  public void onCreate()
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
  
  public void onDestroy()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anhm
 * JD-Core Version:    0.7.0.1
 */