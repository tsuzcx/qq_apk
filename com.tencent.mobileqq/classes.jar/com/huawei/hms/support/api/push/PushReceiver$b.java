package com.huawei.hms.support.api.push;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.push.h;
import com.huawei.hms.push.v;
import com.huawei.hms.support.log.HMSLog;
import java.util.concurrent.RejectedExecutionException;

public class PushReceiver$b
  implements Runnable
{
  public Context a;
  public Intent b;
  
  public PushReceiver$b(Context paramContext, Intent paramIntent)
  {
    this.a = paramContext;
    this.b = paramIntent;
  }
  
  public void run()
  {
    try
    {
      Object localObject1 = this.b.getByteArrayExtra("device_token");
      if ((localObject1 != null) && (localObject1.length != 0))
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("receive a push token: ");
        ((StringBuilder)localObject2).append(this.a.getPackageName());
        HMSLog.i("PushReceiver", ((StringBuilder)localObject2).toString());
        localObject2 = new Intent("com.huawei.push.action.MESSAGING_EVENT");
        ((Intent)localObject2).setPackage(this.b.getPackage());
        Bundle localBundle = new Bundle();
        localBundle.putString("message_type", "new_token");
        localBundle.putString("device_token", v.a((byte[])localObject1));
        localBundle.putString("transaction_id", this.b.getStringExtra("transaction_id"));
        localBundle.putString("subjectId", this.b.getStringExtra("subjectId"));
        localBundle.putInt("error", this.b.getIntExtra("error", ErrorEnum.SUCCESS.getInternalCode()));
        localBundle.putString("belongId", this.b.getStringExtra("belongId"));
        if (new h().a(this.a, localBundle, (Intent)localObject2)) {
          break label258;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("receive ");
        ((StringBuilder)localObject1).append(this.b.getAction());
        ((StringBuilder)localObject1).append(" and start service failed");
        HMSLog.e("PushReceiver", ((StringBuilder)localObject1).toString());
        return;
      }
      HMSLog.i("PushReceiver", "get a deviceToken, but it is null or empty");
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      label258:
      break label251;
    }
    catch (Exception localException)
    {
      label243:
      label251:
      break label243;
    }
    HMSLog.e("PushReceiver", "handle push token error");
    return;
    HMSLog.e("PushReceiver", "execute task error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.support.api.push.PushReceiver.b
 * JD-Core Version:    0.7.0.1
 */