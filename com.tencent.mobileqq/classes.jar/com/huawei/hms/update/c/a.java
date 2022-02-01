package com.huawei.hms.update.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.huawei.hms.ui.SafeIntent;

public class a
  extends BroadcastReceiver
{
  private Handler a;
  
  public a(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramContext = new SafeIntent(paramIntent);
            paramIntent = paramContext.getAction();
            if (!"com.huawei.appmarket.service.downloadservice.Receiver".equals(paramIntent)) {
              break;
            }
            paramContext = paramContext.getExtras();
          } while (paramContext == null);
          paramIntent = new Message();
          paramIntent.what = 101;
          paramIntent.obj = paramContext;
          this.a.sendMessage(paramIntent);
          return;
          if (!"com.huawei.appmarket.service.downloadservice.progress.Receiver".equals(paramIntent)) {
            break;
          }
          paramContext = paramContext.getExtras();
        } while (paramContext == null);
        paramIntent = new Message();
        paramIntent.what = 102;
        paramIntent.obj = paramContext;
        this.a.sendMessage(paramIntent);
        return;
      } while (!"com.huawei.appmarket.service.installerservice.Receiver".equals(paramIntent));
      paramContext = paramContext.getExtras();
    } while (paramContext == null);
    paramIntent = new Message();
    paramIntent.what = 103;
    paramIntent.obj = paramContext;
    this.a.sendMessage(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.update.c.a
 * JD-Core Version:    0.7.0.1
 */