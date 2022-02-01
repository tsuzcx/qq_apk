package com.tencent.av.utils;

import android.content.Context;
import android.os.Handler;
import android.telephony.PhoneStateListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class PhoneStatusMonitor
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private PhoneStateListener jdField_a_of_type_AndroidTelephonyPhoneStateListener;
  private PhoneStatusMonitor.PhoneStatusListener jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener;
  private PhoneStatusMonitor.PhoneStatusReceiver jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusReceiver;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private boolean jdField_a_of_type_Boolean;
  private final AtomicBoolean b;
  
  /* Error */
  public PhoneStatusMonitor(Context paramContext, PhoneStatusMonitor.PhoneStatusListener paramPhoneStatusListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 27	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: aconst_null
    //   6: putfield 29	com/tencent/av/utils/PhoneStatusMonitor:jdField_a_of_type_AndroidTelephonyPhoneStateListener	Landroid/telephony/PhoneStateListener;
    //   9: aload_0
    //   10: aconst_null
    //   11: putfield 31	com/tencent/av/utils/PhoneStatusMonitor:jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusReceiver	Lcom/tencent/av/utils/PhoneStatusMonitor$PhoneStatusReceiver;
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield 33	com/tencent/av/utils/PhoneStatusMonitor:jdField_a_of_type_Boolean	Z
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 35	com/tencent/av/utils/PhoneStatusMonitor:jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener	Lcom/tencent/av/utils/PhoneStatusMonitor$PhoneStatusListener;
    //   24: aload_0
    //   25: aconst_null
    //   26: putfield 37	com/tencent/av/utils/PhoneStatusMonitor:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   29: aload_0
    //   30: new 39	java/util/concurrent/atomic/AtomicBoolean
    //   33: dup
    //   34: invokespecial 40	java/util/concurrent/atomic/AtomicBoolean:<init>	()V
    //   37: putfield 42	com/tencent/av/utils/PhoneStatusMonitor:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   40: aload_0
    //   41: new 39	java/util/concurrent/atomic/AtomicBoolean
    //   44: dup
    //   45: invokespecial 40	java/util/concurrent/atomic/AtomicBoolean:<init>	()V
    //   48: putfield 44	com/tencent/av/utils/PhoneStatusMonitor:b	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   51: aload_0
    //   52: new 46	com/tencent/av/utils/PhoneStatusMonitor$3
    //   55: dup
    //   56: aload_0
    //   57: invokespecial 49	com/tencent/av/utils/PhoneStatusMonitor$3:<init>	(Lcom/tencent/av/utils/PhoneStatusMonitor;)V
    //   60: putfield 51	com/tencent/av/utils/PhoneStatusMonitor:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   63: invokestatic 57	android/os/SystemClock:elapsedRealtime	()J
    //   66: lstore_3
    //   67: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   70: ifeq +11 -> 81
    //   73: ldc 65
    //   75: iconst_2
    //   76: ldc 67
    //   78: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: aload_0
    //   82: aload_1
    //   83: putfield 73	com/tencent/av/utils/PhoneStatusMonitor:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   86: aload_0
    //   87: aload_2
    //   88: putfield 35	com/tencent/av/utils/PhoneStatusMonitor:jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener	Lcom/tencent/av/utils/PhoneStatusMonitor$PhoneStatusListener;
    //   91: aload_0
    //   92: new 75	com/tencent/av/utils/PhoneStatusMonitor$QQPhoneStateListener
    //   95: dup
    //   96: aload_0
    //   97: invokespecial 76	com/tencent/av/utils/PhoneStatusMonitor$QQPhoneStateListener:<init>	(Lcom/tencent/av/utils/PhoneStatusMonitor;)V
    //   100: putfield 29	com/tencent/av/utils/PhoneStatusMonitor:jdField_a_of_type_AndroidTelephonyPhoneStateListener	Landroid/telephony/PhoneStateListener;
    //   103: aload_0
    //   104: new 78	com/tencent/av/utils/PhoneStatusMonitor$PhoneStatusReceiver
    //   107: dup
    //   108: aload_0
    //   109: invokespecial 79	com/tencent/av/utils/PhoneStatusMonitor$PhoneStatusReceiver:<init>	(Lcom/tencent/av/utils/PhoneStatusMonitor;)V
    //   112: putfield 31	com/tencent/av/utils/PhoneStatusMonitor:jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusReceiver	Lcom/tencent/av/utils/PhoneStatusMonitor$PhoneStatusReceiver;
    //   115: new 81	com/tencent/av/utils/PhoneStatusMonitor$1
    //   118: dup
    //   119: aload_0
    //   120: aload_1
    //   121: invokespecial 84	com/tencent/av/utils/PhoneStatusMonitor$1:<init>	(Lcom/tencent/av/utils/PhoneStatusMonitor;Landroid/content/Context;)V
    //   124: bipush 16
    //   126: aconst_null
    //   127: iconst_0
    //   128: invokestatic 90	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   131: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +37 -> 171
    //   137: ldc 65
    //   139: iconst_2
    //   140: new 92	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   147: ldc 95
    //   149: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokestatic 57	android/os/SystemClock:elapsedRealtime	()J
    //   155: lload_3
    //   156: lsub
    //   157: invokevirtual 102	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   160: ldc 104
    //   162: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   171: new 110	android/content/IntentFilter
    //   174: dup
    //   175: invokespecial 111	android/content/IntentFilter:<init>	()V
    //   178: astore_2
    //   179: aload_2
    //   180: ldc 113
    //   182: invokevirtual 117	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   185: aload_2
    //   186: ldc 119
    //   188: invokevirtual 117	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   191: aload_2
    //   192: ldc 121
    //   194: invokevirtual 117	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   197: aload_2
    //   198: ldc 123
    //   200: invokevirtual 117	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   203: aload_2
    //   204: ldc 125
    //   206: invokevirtual 117	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   209: aload_1
    //   210: aload_0
    //   211: getfield 31	com/tencent/av/utils/PhoneStatusMonitor:jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusReceiver	Lcom/tencent/av/utils/PhoneStatusMonitor$PhoneStatusReceiver;
    //   214: aload_2
    //   215: invokevirtual 131	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   218: pop
    //   219: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   222: ifeq +37 -> 259
    //   225: ldc 65
    //   227: iconst_2
    //   228: new 92	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   235: ldc 133
    //   237: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: invokestatic 57	android/os/SystemClock:elapsedRealtime	()J
    //   243: lload_3
    //   244: lsub
    //   245: invokevirtual 102	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   248: ldc 104
    //   250: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   259: aload_0
    //   260: new 135	android/os/Handler
    //   263: dup
    //   264: invokestatic 141	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   267: invokespecial 144	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   270: putfield 37	com/tencent/av/utils/PhoneStatusMonitor:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   273: return
    //   274: astore_2
    //   275: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   278: ifeq -175 -> 103
    //   281: ldc 65
    //   283: iconst_2
    //   284: new 92	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   291: ldc 146
    //   293: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: aload_2
    //   297: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 152	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   306: goto -203 -> 103
    //   309: astore_2
    //   310: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   313: ifeq -182 -> 131
    //   316: ldc 65
    //   318: iconst_2
    //   319: new 92	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   326: ldc 154
    //   328: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: aload_2
    //   332: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   335: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 152	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: goto -210 -> 131
    //   344: astore_2
    //   345: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   348: ifeq -217 -> 131
    //   351: ldc 65
    //   353: iconst_2
    //   354: new 92	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   361: ldc 156
    //   363: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload_2
    //   367: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   370: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokestatic 152	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   376: goto -245 -> 131
    //   379: astore_1
    //   380: ldc 65
    //   382: iconst_1
    //   383: ldc 157
    //   385: aload_1
    //   386: invokestatic 161	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   389: goto -170 -> 219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	this	PhoneStatusMonitor
    //   0	392	1	paramContext	Context
    //   0	392	2	paramPhoneStatusListener	PhoneStatusMonitor.PhoneStatusListener
    //   66	178	3	l	long
    // Exception table:
    //   from	to	target	type
    //   91	103	274	java/lang/Exception
    //   115	131	309	java/lang/InternalError
    //   115	131	344	java/lang/IncompatibleClassChangeError
    //   209	219	379	java/lang/Throwable
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean == paramBoolean) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("PhoneStatusMonitor", 2, "updateCallingState, pre[" + this.jdField_a_of_type_Boolean + "], cur[" + paramBoolean + "]");
      }
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener != null) {
        this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener.a(this.jdField_a_of_type_Boolean);
      }
    } while (this.jdField_a_of_type_Boolean);
    d();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_AndroidTelephonyPhoneStateListener == null)) {
      return;
    }
    d();
    PhoneStatusTools.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidTelephonyPhoneStateListener, 0);
    QLog.d("PhoneStatusMonitor", 1, "PhoneStatusMonitor.unregisterReceiver()");
    try
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusReceiver);
      this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusListener = null;
      this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor$PhoneStatusReceiver = null;
      this.jdField_a_of_type_AndroidTelephonyPhoneStateListener = null;
      this.jdField_a_of_type_AndroidContentContext = null;
      this.jdField_a_of_type_AndroidOsHandler = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.i("PhoneStatusMonitor", 1, "unregisterReceiver", localThrowable);
      }
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
    if (QLog.isColorLevel()) {
      QLog.i("PhoneStatusMonitor", 2, "checkCalling, begin, isCalling[" + this.jdField_a_of_type_Boolean + "], isChecking[" + bool + "]");
    }
    if (bool) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    ThreadManager.excute(new PhoneStatusMonitor.2(this), 16, null, false);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhoneStatusMonitor", 2, "clearTillEnd, calling[" + this.jdField_a_of_type_Boolean + "], tillEnd[" + this.b.get() + "]");
    }
    this.b.set(false);
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhoneStatusMonitor", 2, "checkEndOfCall, calling[" + this.jdField_a_of_type_Boolean + "]");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.av.utils.PhoneStatusMonitor
 * JD-Core Version:    0.7.0.1
 */