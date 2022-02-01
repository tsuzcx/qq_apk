package com.huawei.hms.support.api.push;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.hms.push.a;
import com.huawei.hms.push.aa;
import com.huawei.hms.push.l;
import com.huawei.hms.support.log.HMSLog;
import java.util.concurrent.RejectedExecutionException;

class PushReceiver$b
  implements Runnable
{
  private Context a;
  private Intent b;
  
  private PushReceiver$b(Context paramContext, Intent paramIntent)
  {
    this.a = paramContext;
    this.b = paramIntent;
  }
  
  public void run()
  {
    try
    {
      byte[] arrayOfByte = this.b.getByteArrayExtra("device_token");
      if ((arrayOfByte == null) || (arrayOfByte.length == 0))
      {
        HMSLog.i("PushReceiver", "get a deviceToken, but it is null or empty");
        return;
      }
      HMSLog.i("PushReceiver", "receive a push token: " + this.a.getPackageName());
      Intent localIntent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
      localIntent.setPackage(this.b.getPackage());
      Bundle localBundle = new Bundle();
      localBundle.putString("message_type", "new_token");
      localBundle.putString("device_token", aa.a(arrayOfByte));
      localBundle.putString("transaction_id", this.b.getStringExtra("transaction_id"));
      localBundle.putInt("error", this.b.getIntExtra("error", a.a.a()));
      if (!new l().a(this.a, localBundle, localIntent))
      {
        HMSLog.e("PushReceiver", "receive " + this.b.getAction() + " and start service failed");
        return;
      }
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      HMSLog.e("PushReceiver", "execute task error");
      return;
    }
    catch (Exception localException)
    {
      HMSLog.e("PushReceiver", "handle push token error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.support.api.push.PushReceiver.b
 * JD-Core Version:    0.7.0.1
 */