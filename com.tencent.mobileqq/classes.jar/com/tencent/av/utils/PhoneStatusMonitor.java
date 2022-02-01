package com.tencent.av.utils;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.telephony.PhoneStateListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class PhoneStatusMonitor
{
  private Context a;
  private PhoneStateListener b = null;
  private PhoneStatusMonitor.PhoneStatusReceiver c = null;
  private boolean d = false;
  private PhoneStatusMonitor.PhoneStatusListener e = null;
  private Handler f = null;
  private final AtomicBoolean g = new AtomicBoolean();
  private final AtomicBoolean h = new AtomicBoolean();
  private Runnable i = new PhoneStatusMonitor.3(this);
  
  public PhoneStatusMonitor(Context paramContext, PhoneStatusMonitor.PhoneStatusListener paramPhoneStatusListener)
  {
    long l = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("PhoneStatusMonitor", 2, "PhoneStatusMonitor Begin");
    }
    this.a = paramContext;
    this.e = paramPhoneStatusListener;
    StringBuilder localStringBuilder;
    try
    {
      this.b = new PhoneStatusMonitor.QQPhoneStateListener(this);
    }
    catch (Exception paramPhoneStatusListener)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("PhoneStatusMonitor e1 = ");
        localStringBuilder.append(paramPhoneStatusListener);
        QLog.e("PhoneStatusMonitor", 2, localStringBuilder.toString());
      }
    }
    this.c = new PhoneStatusMonitor.PhoneStatusReceiver(this);
    try
    {
      ThreadManager.excute(new PhoneStatusMonitor.1(this, paramContext), 16, null, false);
    }
    catch (IncompatibleClassChangeError paramPhoneStatusListener)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("PhoneStatusMonitor e2 = ");
        localStringBuilder.append(paramPhoneStatusListener);
        QLog.e("PhoneStatusMonitor", 2, localStringBuilder.toString());
      }
    }
    catch (InternalError paramPhoneStatusListener)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("PhoneStatusMonitor e = ");
        localStringBuilder.append(paramPhoneStatusListener);
        QLog.e("PhoneStatusMonitor", 2, localStringBuilder.toString());
      }
    }
    if (QLog.isColorLevel())
    {
      paramPhoneStatusListener = new StringBuilder();
      paramPhoneStatusListener.append("PhoneStatusMonitor, Step1, cost[");
      paramPhoneStatusListener.append(SystemClock.elapsedRealtime() - l);
      paramPhoneStatusListener.append("]");
      QLog.d("PhoneStatusMonitor", 2, paramPhoneStatusListener.toString());
    }
    paramPhoneStatusListener = new IntentFilter();
    paramPhoneStatusListener.addAction("android.intent.action.PHONE_STATE");
    paramPhoneStatusListener.addAction("android.intent.action.PHONE_STATE2");
    paramPhoneStatusListener.addAction("android.intent.action.PHONE_STATE_2");
    paramPhoneStatusListener.addAction("android.intent.action.PHONE_STATE_EXT");
    paramPhoneStatusListener.addAction("android.intent.action.NEW_OUTGOING_CALL");
    try
    {
      paramContext.registerReceiver(this.c, paramPhoneStatusListener);
    }
    catch (Throwable paramContext)
    {
      QLog.i("PhoneStatusMonitor", 1, "registerReceiver", paramContext);
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("PhoneStatusMonitor End, cost[");
      paramContext.append(SystemClock.elapsedRealtime() - l);
      paramContext.append("]");
      QLog.d("PhoneStatusMonitor", 2, paramContext.toString());
    }
    this.f = new Handler(Looper.getMainLooper());
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.d == paramBoolean) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateCallingState, pre[");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append("], cur[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("]");
      QLog.i("PhoneStatusMonitor", 2, ((StringBuilder)localObject).toString());
    }
    this.d = paramBoolean;
    Object localObject = this.e;
    if (localObject != null) {
      ((PhoneStatusMonitor.PhoneStatusListener)localObject).a(this.d);
    }
    if (!this.d) {
      e();
    }
  }
  
  public void a()
  {
    if (this.a != null)
    {
      if (this.b == null) {
        return;
      }
      e();
      PhoneStatusTools.a(this.a, this.b, 0);
      QLog.d("PhoneStatusMonitor", 1, "PhoneStatusMonitor.unregisterReceiver()");
      try
      {
        this.a.unregisterReceiver(this.c);
      }
      catch (Throwable localThrowable)
      {
        QLog.i("PhoneStatusMonitor", 1, "unregisterReceiver", localThrowable);
      }
      this.e = null;
      this.c = null;
      this.b = null;
      this.a = null;
      this.f = null;
    }
  }
  
  public void b()
  {
    a();
  }
  
  public boolean c()
  {
    return this.d;
  }
  
  public void d()
  {
    boolean bool = this.g.get();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkCalling, begin, isCalling[");
      localStringBuilder.append(this.d);
      localStringBuilder.append("], isChecking[");
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.i("PhoneStatusMonitor", 2, localStringBuilder.toString());
    }
    if (bool) {
      return;
    }
    this.g.set(true);
    ThreadManager.excute(new PhoneStatusMonitor.2(this), 16, null, false);
  }
  
  public void e()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clearTillEnd, calling[");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append("], tillEnd[");
      ((StringBuilder)localObject).append(this.h.get());
      ((StringBuilder)localObject).append("]");
      QLog.i("PhoneStatusMonitor", 2, ((StringBuilder)localObject).toString());
    }
    this.h.set(false);
    Object localObject = this.f;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacks(this.i);
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkEndOfCall, calling[");
      localStringBuilder.append(this.d);
      localStringBuilder.append("]");
      QLog.i("PhoneStatusMonitor", 2, localStringBuilder.toString());
    }
    if (!this.d) {
      return;
    }
    this.h.set(true);
    d();
  }
  
  protected void finalize()
  {
    try
    {
      a();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.PhoneStatusMonitor
 * JD-Core Version:    0.7.0.1
 */