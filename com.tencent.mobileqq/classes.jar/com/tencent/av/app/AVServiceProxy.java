package com.tencent.av.app;

import android.app.Application;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import com.tencent.av.AVLog;
import com.tencent.av.service.AVServiceForQQ;
import com.tencent.av.service.IAVServiceForQQ;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class AVServiceProxy
{
  private static String d = "AVServiceProxy";
  protected VideoAppInterface a;
  protected IAVServiceForQQ b = null;
  protected AVServiceProxy.AVServiceForQQConnection c = null;
  private boolean e = true;
  
  public AVServiceProxy(VideoAppInterface paramVideoAppInterface)
  {
    this.a = paramVideoAppInterface;
  }
  
  protected void a()
  {
    Intent localIntent = new Intent(this.a.getApplication(), AVServiceForQQ.class);
    try
    {
      this.a.getApplication().startService(localIntent);
    }
    catch (Throwable localThrowable)
    {
      String str = d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bindService ");
      localStringBuilder.append(localThrowable.getMessage());
      AVLog.printErrorLog(str, localStringBuilder.toString());
    }
    this.c = new AVServiceProxy.AVServiceForQQConnection(this);
    this.a.getApplication().bindService(localIntent, this.c, 1);
  }
  
  public void a(boolean paramBoolean, Notification paramNotification)
  {
    QLog.d(d, 1, String.format("setAVServiceForegroud start=%s mAvService=%s", new Object[] { Boolean.valueOf(paramBoolean), this.b }));
    Object localObject = this.b;
    if (localObject != null) {
      try
      {
        ((IAVServiceForQQ)localObject).a(paramBoolean, paramNotification);
      }
      catch (Throwable paramNotification)
      {
        QLog.d(d, 1, "setAVServiceForegroud fail.", paramNotification);
      }
      catch (RemoteException paramNotification)
      {
        QLog.d(d, 1, "setAVServiceForegroud fail.", paramNotification);
      }
    } else {
      try
      {
        localObject = this.a.getApplication();
        Intent localIntent = new Intent((Context)localObject, AVServiceForQQ.class);
        localIntent.putExtra("setForeground", true);
        localIntent.putExtra("foreground", paramBoolean);
        localIntent.putExtra("notification", paramNotification);
        ((Application)localObject).startService(localIntent);
      }
      catch (Throwable paramNotification)
      {
        QLog.d(d, 1, "setAVServiceForegroud fail.", paramNotification);
      }
    }
    this.e = paramBoolean;
  }
  
  protected void b()
  {
    Intent localIntent = new Intent(this.a.getApplication(), AVServiceForQQ.class);
    this.a.getApplication().stopService(localIntent);
    if (this.b != null) {
      try
      {
        this.a.getApplication().unbindService(this.c);
        return;
      }
      catch (Exception localException)
      {
        String str = d;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("disconnect msg = ");
        localStringBuilder.append(localException.getMessage());
        AVLog.printErrorLog(str, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.AVServiceProxy
 * JD-Core Version:    0.7.0.1
 */