package com.huawei.hms.support.api.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.push.s;
import com.huawei.hms.push.u;
import com.huawei.hms.push.utils.JsonUtil;
import com.huawei.hms.push.v;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONException;
import org.json.JSONObject;

public final class PushReceiver
  extends BroadcastReceiver
{
  public static JSONObject a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      return paramJSONObject.optJSONObject("msgContent");
    }
    return null;
  }
  
  public static JSONObject a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new JSONObject(v.a(paramArrayOfByte));
      return paramArrayOfByte;
    }
    catch (JSONException paramArrayOfByte)
    {
      label14:
      break label14;
    }
    HMSLog.w("PushReceiver", "JSONException:parse message body failed.");
    return null;
  }
  
  public static JSONObject b(Intent paramIntent)
  {
    paramIntent = a(paramIntent.getByteArrayExtra("msg_data"));
    JSONObject localJSONObject = a(paramIntent);
    String str = JsonUtil.getString(localJSONObject, "data", null);
    if (s.a(localJSONObject, b(localJSONObject), str)) {
      return paramIntent;
    }
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    try
    {
      paramIntent = new JSONObject(str);
      return paramIntent;
    }
    catch (JSONException paramIntent) {}
    return null;
  }
  
  public static JSONObject b(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      return paramJSONObject.optJSONObject("psContent");
    }
    return null;
  }
  
  public final void a(Context paramContext, Intent paramIntent)
  {
    try
    {
      if (paramIntent.hasExtra("msg_data"))
      {
        u.a().execute(new PushReceiver.a(paramContext, paramIntent, null));
        return;
      }
      HMSLog.i("PushReceiver", "This push message dose not sent by hwpush.");
      return;
    }
    catch (RuntimeException paramContext)
    {
      break label42;
    }
    catch (Exception paramContext)
    {
      label34:
      label42:
      break label34;
    }
    HMSLog.e("PushReceiver", "handlePushMessageEvent execute task error");
    return;
    HMSLog.e("PushReceiver", "handlePushMessageEvent execute task runtime exception.");
  }
  
  public final void b(Context paramContext, Intent paramIntent)
  {
    try
    {
      if (paramIntent.hasExtra("device_token"))
      {
        u.a().execute(new PushReceiver.b(paramContext, paramIntent, null));
        return;
      }
      HMSLog.i("PushReceiver", "This message dose not sent by hwpush.");
      return;
    }
    catch (RuntimeException paramContext)
    {
      break label42;
    }
    catch (Exception paramContext)
    {
      label34:
      label42:
      break label34;
    }
    HMSLog.e("PushReceiver", "handlePushTokenEvent execute task error");
    return;
    HMSLog.e("PushReceiver", "handlePushMessageEvent execute task runtime exception.");
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject;
    if (paramIntent != null)
    {
      if (paramContext == null) {
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("push receive broadcast message, Intent:");
      ((StringBuilder)localObject).append(paramIntent.getAction());
      ((StringBuilder)localObject).append(" pkgName:");
      ((StringBuilder)localObject).append(paramContext.getPackageName());
      HMSLog.i("PushReceiver", ((StringBuilder)localObject).toString());
    }
    try
    {
      paramIntent.getStringExtra("TestIntent");
      localObject = paramIntent.getAction();
      if (ResourceLoaderUtil.getmContext() == null) {
        ResourceLoaderUtil.setmContext(paramContext.getApplicationContext());
      }
      if ("com.huawei.android.push.intent.REGISTRATION".equals(localObject))
      {
        b(paramContext, paramIntent);
        return;
      }
      if ("com.huawei.android.push.intent.RECEIVE".equals(localObject))
      {
        a(paramContext, paramIntent);
        return;
      }
      paramContext = new StringBuilder();
      paramContext.append("message can't be recognised:");
      paramContext.append(paramIntent.toUri(0));
      HMSLog.i("PushReceiver", paramContext.toString());
      return;
    }
    catch (Exception paramContext)
    {
      label150:
      break label150;
    }
    HMSLog.e("PushReceiver", "intent has some error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.support.api.push.PushReceiver
 * JD-Core Version:    0.7.0.1
 */