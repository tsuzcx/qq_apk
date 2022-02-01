package com.huawei.hms.support.api.push;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.hms.push.a;
import com.huawei.hms.push.aa;
import com.huawei.hms.push.l;
import com.huawei.hms.push.utils.JsonUtil;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONObject;

class PushReceiver$a
  implements Runnable
{
  private Context a;
  private Intent b;
  
  private PushReceiver$a(Context paramContext, Intent paramIntent)
  {
    this.a = paramContext;
    this.b = paramIntent;
  }
  
  public void run()
  {
    Intent localIntent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
    localIntent.setPackage(this.b.getPackage());
    JSONObject localJSONObject = PushReceiver.a(this.b);
    String str = JsonUtil.getString(localJSONObject, "moduleName", "");
    int k = JsonUtil.getInt(localJSONObject, "msgType", 0);
    int j = JsonUtil.getInt(localJSONObject, "status", 0);
    int i = j;
    if (a.a.a() != j) {
      i = a.B.a();
    }
    Bundle localBundle = new Bundle();
    if (("Push".equals(str)) && (1 == k))
    {
      localBundle.putString("message_type", "delivery");
      localBundle.putString("message_id", JsonUtil.getString(localJSONObject, "msgId", ""));
      localBundle.putInt("error", i);
      localBundle.putString("transaction_id", JsonUtil.getString(localJSONObject, "transactionId", ""));
    }
    while (new l().a(this.a, localBundle, localIntent))
    {
      HMSLog.i("PushReceiver", "receive " + this.b.getAction() + " and start service success");
      return;
      localBundle.putString("message_type", "received_message");
      localBundle.putString("message_id", this.b.getStringExtra("msgIdStr"));
      localBundle.putByteArray("message_body", this.b.getByteArrayExtra("msg_data"));
      localBundle.putString("device_token", aa.a(this.b.getByteArrayExtra("device_token")));
      localBundle.putInt("inputType", 1);
      localBundle.putInt("message_proxy_type", this.b.getIntExtra("message_proxy_type", -1));
    }
    HMSLog.e("PushReceiver", "receive " + this.b.getAction() + " and start service failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.support.api.push.PushReceiver.a
 * JD-Core Version:    0.7.0.1
 */