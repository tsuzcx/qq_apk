package com.tencent.av.utils;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.SystemClock;
import android.telephony.PhoneStateListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import kgb;
import kgc;
import kge;
import kgg;

public class PhoneStatusMonitor
{
  public Context a;
  public Handler a;
  public PhoneStateListener a;
  public PhoneStatusMonitor.PhoneStatusListener a;
  public Runnable a;
  kge a;
  public boolean a;
  
  public PhoneStatusMonitor(Context paramContext, PhoneStatusMonitor.PhoneStatusListener paramPhoneStatusListener)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_JavaLangRunnable = new kgc(this);
    long l = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("PhoneStatusMonitor", 2, "PhoneStatusMonitor Begin");
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener = paramPhoneStatusListener;
    try
    {
      this.jdField_a_of_type_AndroidTelephonyPhoneStateListener = new kgg(this);
      this.jdField_a_of_type_Kge = new kge(this);
    }
    catch (Exception paramPhoneStatusListener)
    {
      try
      {
        do
        {
          ThreadManager.post(new kgb(this, paramContext), 5, null, false);
          if (QLog.isColorLevel()) {
            QLog.d("PhoneStatusMonitor", 2, "PhoneStatusMonitor Step1,time=" + (SystemClock.elapsedRealtime() - l));
          }
          paramPhoneStatusListener = new IntentFilter();
          paramPhoneStatusListener.addAction("android.intent.action.PHONE_STATE");
          paramPhoneStatusListener.addAction("android.intent.action.PHONE_STATE2");
          paramPhoneStatusListener.addAction("android.intent.action.PHONE_STATE_2");
          paramPhoneStatusListener.addAction("android.intent.action.PHONE_STATE_EXT");
          paramPhoneStatusListener.addAction("android.intent.action.NEW_OUTGOING_CALL");
          paramContext.registerReceiver(this.jdField_a_of_type_Kge, paramPhoneStatusListener);
          if (QLog.isColorLevel()) {
            QLog.d("PhoneStatusMonitor", 2, "PhoneStatusMonitor End,time=" + (SystemClock.elapsedRealtime() - l));
          }
          this.jdField_a_of_type_AndroidOsHandler = new Handler();
          return;
          paramPhoneStatusListener = paramPhoneStatusListener;
        } while (!QLog.isColorLevel());
        QLog.e("PhoneStatusMonitor", 2, "PhoneStatusMonitor e1 = " + paramPhoneStatusListener);
      }
      catch (InternalError paramPhoneStatusListener)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("PhoneStatusMonitor", 2, "PhoneStatusMonitor e = " + paramPhoneStatusListener);
          }
        }
      }
      catch (IncompatibleClassChangeError paramPhoneStatusListener)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("PhoneStatusMonitor", 2, "PhoneStatusMonitor e2 = " + paramPhoneStatusListener);
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void finalize()
  {
    try
    {
      PhoneStatusTools.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidTelephonyPhoneStateListener, 0);
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_Kge);
      this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener = null;
      this.jdField_a_of_type_Kge = null;
      this.jdField_a_of_type_AndroidTelephonyPhoneStateListener = null;
      this.jdField_a_of_type_AndroidContentContext = null;
      this.jdField_a_of_type_AndroidOsHandler = null;
      return;
    }
    finally
    {
      super.finalize();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.av.utils.PhoneStatusMonitor
 * JD-Core Version:    0.7.0.1
 */