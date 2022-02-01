package com.tencent.av.wtogether.util;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.av.service.IQQServiceForAV;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class CallStatusClient
{
  private static final String b = "CallStatusClient";
  private static volatile CallStatusClient f;
  boolean a = false;
  private WeakReference<Context> c;
  private ServiceConnection d = null;
  private IQQServiceForAV e = null;
  
  public static CallStatusClient a()
  {
    if (f == null) {
      try
      {
        if (f == null) {
          f = new CallStatusClient();
        }
      }
      finally {}
    }
    return f;
  }
  
  public void a(Context paramContext)
  {
    this.c = new WeakReference(paramContext);
  }
  
  public void b()
  {
    this.c = null;
  }
  
  public boolean c()
  {
    try
    {
      if (this.e != null)
      {
        boolean bool = this.e.n();
        return bool;
      }
    }
    catch (Exception localException)
    {
      QLog.e(b, 1, "isVideoChatting fail.", localException);
    }
    return false;
  }
  
  public void d()
  {
    if (!this.a)
    {
      Object localObject = this.c;
      if (localObject != null)
      {
        localObject = (Context)((WeakReference)localObject).get();
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i(b, 2, "bindQQServiceForAV");
          }
          if (this.d == null) {
            this.d = new CallStatusClient.1(this);
          }
          ((Context)localObject).bindService(new Intent((Context)localObject, QQServiceForAV.class), this.d, 1);
          this.a = true;
        }
      }
    }
  }
  
  public void e()
  {
    if (this.a)
    {
      Object localObject = this.c;
      if (localObject != null)
      {
        localObject = (Context)((WeakReference)localObject).get();
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i(b, 2, "unbindQQServiceForAV");
          }
          ServiceConnection localServiceConnection = this.d;
          if (localServiceConnection != null)
          {
            ((Context)localObject).unbindService(localServiceConnection);
            this.d = null;
          }
          this.a = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.util.CallStatusClient
 * JD-Core Version:    0.7.0.1
 */