import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.frdsysmsg.FrdSysMsg.FriendSysMsg;
import tencent.im.s2c.frdsysmsg.FrdSysMsg.SchoolInfo;

public class armq
  extends WebViewPlugin
{
  public armq()
  {
    this.mPluginNameSpace = "friendApi";
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"friendApi".equals(paramString2)) {
      return false;
    }
    if ("openProfile".equals(paramString3)) {
      if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
        if (QLog.isColorLevel()) {
          QLog.w("FriendApiPlugin", 2, "open profile " + paramVarArgs[0]);
        }
      }
    }
    label322:
    do
    {
      for (;;)
      {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = new ProfileActivity.AllInOne(paramJsBridgeListener.optString("uin"), paramJsBridgeListener.optInt("from"));
          ProfileActivity.b(this.mRuntime.a(), paramJsBridgeListener);
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.w("FriendApiPlugin", 2, "open profile error:" + paramJsBridgeListener.toString());
          continue;
        }
        if ("addFriend".equals(paramString3))
        {
          if ((paramVarArgs != null) && (paramVarArgs.length > 0))
          {
            if (QLog.isColorLevel()) {
              QLog.w("FriendApiPlugin", 2, "add friend " + paramVarArgs[0]);
            }
            try
            {
              paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
              paramString1 = paramJsBridgeListener.optString("uin");
              int i = paramJsBridgeListener.optInt("sourceId", 0);
              int j = paramJsBridgeListener.optInt("subSourceId", 0);
              if (!paramJsBridgeListener.has("schoolInfo")) {
                break label746;
              }
              paramString2 = paramJsBridgeListener.optJSONObject("schoolInfo");
              if (paramString2 == null) {
                break label746;
              }
              paramJsBridgeListener = paramString2.optString("schoolId");
              paramString3 = paramString2.optString("schoolName");
              paramString2 = new FrdSysMsg.SchoolInfo();
              paramString2.str_school_id.set(paramJsBridgeListener);
              paramString2.str_school_name.set(paramString3);
              paramJsBridgeListener = new FrdSysMsg.FriendSysMsg();
              paramJsBridgeListener.msg_school_info.set(paramString2);
              paramJsBridgeListener = paramJsBridgeListener.toByteArray();
              paramString3 = this.mRuntime.a();
              paramVarArgs = AddFriendLogicActivity.a(paramString3, 1, paramString1, "", i, j, null, null, null, null, null);
              if (paramJsBridgeListener != null)
              {
                paramString2 = paramVarArgs.getBundleExtra("flc_extra_param");
                paramString1 = paramString2;
                if (paramString2 == null)
                {
                  paramString1 = new Bundle();
                  paramVarArgs.putExtra("flc_extra_param", paramString1);
                }
                paramString1.putByteArray("friend_src_desc", paramJsBridgeListener);
              }
              paramString3.startActivity(paramVarArgs);
            }
            catch (JSONException paramJsBridgeListener) {}
            if (QLog.isColorLevel()) {
              QLog.w("FriendApiPlugin", 2, "add friend error:" + paramJsBridgeListener.toString());
            }
          }
        }
        else
        {
          if (!"isFriend".equals(paramString3)) {
            break;
          }
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
            try
            {
              paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
              paramString1 = paramJsBridgeListener.optString("frd_uin");
              paramString2 = new Bundle();
              paramString2.putString("KEY_UIN", paramString1);
              paramString1 = QIPCClientHelper.getInstance().getClient().callServer("FriendQIPCModule", "ACTION_IS_FRIEND", paramString2);
              boolean bool = false;
              if (paramString1.isSuccess()) {
                bool = paramString1.data.getBoolean("KEY_IS_FRIEND", false);
              }
              paramString1 = new JSONObject();
              paramString1.put("result", bool);
              callJs(paramJsBridgeListener.optString("callback"), new String[] { paramString1.toString() });
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
        }
      }
    } while ((!"getPhoneNumber".equals(paramString3)) || (paramVarArgs == null) || (paramVarArgs.length <= 0));
    for (;;)
    {
      try
      {
        paramString2 = new JSONObject(paramVarArgs[0]);
        paramJsBridgeListener = paramString2.optString("frd_uin");
        paramString1 = new Bundle();
        paramString1.putString("KEY_UIN", paramJsBridgeListener);
        paramString1 = QIPCClientHelper.getInstance().getClient().callServer("FriendQIPCModule", "ACTION_GET_PHONE_NUMBER", paramString1);
        paramJsBridgeListener = null;
        if (paramString1.isSuccess()) {
          paramJsBridgeListener = paramString1.data.getString("PHONE_NUMBER", null);
        }
        paramString3 = new JSONObject();
        if (TextUtils.isEmpty(paramJsBridgeListener)) {
          break label751;
        }
        paramString1 = paramJsBridgeListener;
        if ("0".equals(paramJsBridgeListener)) {
          break label751;
        }
        paramString3.put("PhoneNumber", paramString1);
        callJs(paramString2.optString("callback"), new String[] { paramString3.toString() });
      }
      catch (JSONException paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
      }
      break;
      label746:
      paramJsBridgeListener = null;
      break label322;
      label751:
      paramString1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     armq
 * JD-Core Version:    0.7.0.1
 */