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
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = null;
  private PhoneStateListener jdField_a_of_type_AndroidTelephonyPhoneStateListener = null;
  private PhoneStatusMonitor.PhoneStatusListener jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener = null;
  private PhoneStatusMonitor.PhoneStatusReceiver jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusReceiver = null;
  private Runnable jdField_a_of_type_JavaLangRunnable = new PhoneStatusMonitor.3(this);
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  private boolean jdField_a_of_type_Boolean = false;
  private final AtomicBoolean b = new AtomicBoolean();
  
  public PhoneStatusMonitor(Context paramContext, PhoneStatusMonitor.PhoneStatusListener paramPhoneStatusListener)
  {
    long l = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("PhoneStatusMonitor", 2, "PhoneStatusMonitor Begin");
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener = paramPhoneStatusListener;
    StringBuilder localStringBuilder;
    try
    {
      this.jdField_a_of_type_AndroidTelephonyPhoneStateListener = new PhoneStatusMonitor.QQPhoneStateListener(this);
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
    this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusReceiver = new PhoneStatusMonitor.PhoneStatusReceiver(this);
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
      paramContext.registerReceiver(this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusReceiver, paramPhoneStatusListener);
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
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean == paramBoolean) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateCallingState, pre[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append("], cur[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("]");
      QLog.i("PhoneStatusMonitor", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    Object localObject = this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener;
    if (localObject != null) {
      ((PhoneStatusMonitor.PhoneStatusListener)localObject).a(this.jdField_a_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean) {
      d();
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      if (this.jdField_a_of_type_AndroidTelephonyPhoneStateListener == null) {
        return;
      }
      d();
      PhoneStatusTools.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidTelephonyPhoneStateListener, 0);
      QLog.d("PhoneStatusMonitor", 1, "PhoneStatusMonitor.unregisterReceiver()");
      try
      {
        this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusReceiver);
      }
      catch (Throwable localThrowable)
      {
        QLog.i("PhoneStatusMonitor", 1, "unregisterReceiver", localThrowable);
      }
      this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener = null;
      this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusReceiver = null;
      this.jdField_a_of_type_AndroidTelephonyPhoneStateListener = null;
      this.jdField_a_of_type_AndroidContentContext = null;
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    a();
  }
  
  public void c()
  {
    boolean bool = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkCalling, begin, isCalling[");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append("], isChecking[");
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.i("PhoneStatusMonitor", 2, localStringBuilder.toString());
    }
    if (bool) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    ThreadManager.excute(new PhoneStatusMonitor.2(this), 16, null, false);
  }
  
  public void d()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clearTillEnd, calling[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append("], tillEnd[");
      ((StringBuilder)localObject).append(this.b.get());
      ((StringBuilder)localObject).append("]");
      QLog.i("PhoneStatusMonitor", 2, ((StringBuilder)localObject).toString());
    }
    this.b.set(false);
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkEndOfCall, calling[");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append("]");
      QLog.i("PhoneStatusMonitor", 2, localStringBuilder.toString());
    }
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.b.set(true);
    c();
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