package com.huawei.hms.support.api.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.push.aa;
import com.huawei.hms.push.utils.JsonUtil;
import com.huawei.hms.push.w;
import com.huawei.hms.push.z;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONException;
import org.json.JSONObject;

public final class PushReceiver
  extends BroadcastReceiver
{
  private static JSONObject a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      return paramJSONObject.optJSONObject("psContent");
    }
    return null;
  }
  
  private static JSONObject a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new JSONObject(aa.a(paramArrayOfByte));
      return paramArrayOfByte;
    }
    catch (JSONException paramArrayOfByte)
    {
      HMSLog.w("PushReceiver", "JSONException:parse message body failed.");
    }
    return null;
  }
  
  private void a(Context paramContext, Intent paramIntent)
  {
    try
    {
      if (paramIntent.hasExtra("device_token"))
      {
        z.a().execute(new PushReceiver.b(paramContext, paramIntent, null));
        return;
      }
      HMSLog.i("PushReceiver", "This message dose not sent by hwpush.");
      return;
    }
    catch (RuntimeException paramContext)
    {
      HMSLog.e("PushReceiver", "handlePushMessageEvent execute task runtime exception.");
      return;
    }
    catch (Exception paramContext)
    {
      HMSLog.e("PushReceiver", "handlePushTokenEvent execute task error");
    }
  }
  
  private static JSONObject b(Intent paramIntent)
  {
    paramIntent = a(paramIntent.getByteArrayExtra("msg_data"));
    JSONObject localJSONObject = b(paramIntent);
    String str = JsonUtil.getString(localJSONObject, "data", null);
    if (w.a(localJSONObject, a(localJSONObject), str)) {
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
  
  private static JSONObject b(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      return paramJSONObject.optJSONObject("msgContent");
    }
    return null;
  }
  
  private void b(Context paramContext, Intent paramIntent)
  {
    try
    {
      if (paramIntent.hasExtra("msg_data"))
      {
        z.a().execute(new PushReceiver.a(paramContext, paramIntent, null));
        return;
      }
      HMSLog.i("PushReceiver", "This push message dose not sent by hwpush.");
      return;
    }
    catch (RuntimeException paramContext)
    {
      HMSLog.e("PushReceiver", "handlePushMessageEvent execute task runtime exception.");
      return;
    }
    catch (Exception paramContext)
    {
      HMSLog.e("PushReceiver", "handlePushMessageEvent execute task error");
    }
  }
  
  public void onPushMsg(Context paramContext, byte[] paramArrayOfByte, String paramString) {}
  
  public boolean onPushMsg(Context paramContext, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    String str = "";
    if (paramBundle != null) {
      str = paramBundle.getString("deviceToken");
    }
    onPushMsg(paramContext, paramArrayOfByte, str);
    return true;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramContext == null)) {
      return;
    }
    HMSLog.i("PushReceiver", "push receive broadcast message, Intent:" + paramIntent.getAction() + " pkgName:" + paramContext.getPackageName());
    String str;
    try
    {
      paramIntent.getStringExtra("TestIntent");
      str = paramIntent.getAction();
      if (ResourceLoaderUtil.getmContext() == null) {
        ResourceLoaderUtil.setmContext(paramContext.getApplicationContext());
      }
      if ("com.huawei.android.push.intent.REGISTRATION".equals(str))
      {
        a(paramContext, paramIntent);
        return;
      }
    }
    catch (Exception paramContext)
    {
      HMSLog.e("PushReceiver", "intent has some error");
      return;
    }
    if ("com.huawei.android.push.intent.RECEIVE".equals(str))
    {
      b(paramContext, paramIntent);
      return;
    }
    HMSLog.i("PushReceiver", "message can't be recognised:" + paramIntent.toUri(0));
  }
  
  public void onToken(Context paramContext, String paramString) {}
  
  public void onToken(Context paramContext, String paramString, Bundle paramBundle)
  {
    onToken(paramContext, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.support.api.push.PushReceiver
 * JD-Core Version:    0.7.0.1
 */