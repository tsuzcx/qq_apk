package com.huawei.hms.support.api.push;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.push.h;
import com.huawei.hms.push.utils.JsonUtil;
import com.huawei.hms.push.v;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONObject;

public class PushReceiver$a
  implements Runnable
{
  public Context a;
  public Intent b;
  
  public PushReceiver$a(Context paramContext, Intent paramIntent)
  {
    this.a = paramContext;
    this.b = paramIntent;
  }
  
  public void run()
  {
    Object localObject = new Intent("com.huawei.push.action.MESSAGING_EVENT");
    ((Intent)localObject).setPackage(this.b.getPackage());
    JSONObject localJSONObject = PushReceiver.a(this.b);
    String str = JsonUtil.getString(localJSONObject, "moduleName", "");
    int k = JsonUtil.getInt(localJSONObject, "msgType", 0);
    int j = JsonUtil.getInt(localJSONObject, "status", 0);
    int i = j;
    if (ErrorEnum.SUCCESS.getInternalCode() != j) {
      i = ErrorEnum.ERROR_APP_SERVER_NOT_ONLINE.getInternalCode();
    }
    Bundle localBundle = new Bundle();
    if (("Push".equals(str)) && (k == 1))
    {
      localBundle.putString("message_type", "delivery");
      localBundle.putString("message_id", JsonUtil.getString(localJSONObject, "msgId", ""));
      localBundle.putInt("error", i);
      localBundle.putString("transaction_id", JsonUtil.getString(localJSONObject, "transactionId", ""));
    }
    else
    {
      if (this.b.getExtras() != null) {
        localBundle.putAll(this.b.getExtras());
      }
      localBundle.putString("message_type", "received_message");
      localBundle.putString("message_id", this.b.getStringExtra("msgIdStr"));
      localBundle.putByteArray("message_body", this.b.getByteArrayExtra("msg_data"));
      localBundle.putString("device_token", v.a(this.b.getByteArrayExtra("device_token")));
      localBundle.putInt("inputType", 1);
      localBundle.putString("message_proxy_type", this.b.getStringExtra("message_proxy_type"));
    }
    if (new h().a(this.a, localBundle, (Intent)localObject))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("receive ");
      ((StringBuilder)localObject).append(this.b.getAction());
      ((StringBuilder)localObject).append(" and start service success");
      HMSLog.i("PushReceiver", ((StringBuilder)localObject).toString());
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("receive ");
    ((StringBuilder)localObject).append(this.b.getAction());
    ((StringBuilder)localObject).append(" and start service failed");
    HMSLog.e("PushReceiver", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.support.api.push.PushReceiver.a
 * JD-Core Version:    0.7.0.1
 */