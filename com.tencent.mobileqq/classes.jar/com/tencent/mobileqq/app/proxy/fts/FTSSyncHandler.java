package com.tencent.mobileqq.app.proxy.fts;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.FTSDBManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.opt.threadpriority.ThreadRegulator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class FTSSyncHandler
  extends Handler
{
  public static int a;
  public static long a;
  private FTSDBManager a;
  private long b = 0L;
  private long c = 0L;
  private long d = 0L;
  
  static
  {
    jdField_a_of_type_Long = 0L;
    jdField_a_of_type_Int = -1000;
  }
  
  public FTSSyncHandler(Looper paramLooper, QQAppInterface paramQQAppInterface, FTSDBManager paramFTSDBManager)
  {
    super(paramLooper);
    this.jdField_a_of_type_ComTencentMobileqqAppProxyFTSDBManager = paramFTSDBManager;
    this.b = System.currentTimeMillis();
  }
  
  public void a()
  {
    removeCallbacksAndMessages(null);
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    ThreadRegulator.a().b();
    super.dispatchMessage(paramMessage);
  }
  
  public void handleMessage(Message paramMessage)
  {
    jdField_a_of_type_Int = Process.myTid();
    jdField_a_of_type_Long = SystemClock.currentThreadTimeMillis();
    long l2 = System.currentTimeMillis();
    long l3 = SystemClock.currentThreadTimeMillis();
    Object localObject1 = (FTSIndexOperator)paramMessage.obj;
    label270:
    boolean bool;
    for (;;)
    {
      try
      {
        int i = paramMessage.what;
        switch (i)
        {
        default: 
          this.d += SystemClock.currentThreadTimeMillis() - l3;
          this.c += System.currentTimeMillis() - l2;
          if (System.currentTimeMillis() - this.b > 300000L)
          {
            paramMessage = new StringBuilder(100);
            paramMessage.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(System.currentTimeMillis()))).append(" ");
            paramMessage.append("cpu:").append(this.d).append(" - wall:").append(this.c).append(" ");
            localObject1 = (FTSMsgOperator)this.jdField_a_of_type_ComTencentMobileqqAppProxyFTSDBManager.a(1);
            if (localObject1 != null) {
              paramMessage.append(((FTSMsgOperator)localObject1).a());
            }
            localObject1 = (FTSTroopOperator)this.jdField_a_of_type_ComTencentMobileqqAppProxyFTSDBManager.a(2);
            if (localObject1 != null) {
              paramMessage.append(((FTSTroopOperator)localObject1).a()).append("\n");
            }
            QLog.d("Q.fts.BgCpu.Total", 1, paramMessage.toString());
            this.d = 0L;
            this.c = 0L;
            this.b = System.currentTimeMillis();
          }
          return;
        }
      }
      finally
      {
        l1 = this.d;
        this.d = (SystemClock.currentThreadTimeMillis() - l3 + l1);
        l1 = this.c;
        this.c = (System.currentTimeMillis() - l2 + l1);
        if (System.currentTimeMillis() - this.b <= 300000L) {
          continue;
        }
        localObject1 = new StringBuilder(100);
        ((StringBuilder)localObject1).append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(System.currentTimeMillis()))).append(" ");
        ((StringBuilder)localObject1).append("cpu:").append(this.d).append(" - wall:").append(this.c).append(" ");
        Object localObject2 = (FTSMsgOperator)this.jdField_a_of_type_ComTencentMobileqqAppProxyFTSDBManager.a(1);
        if (localObject2 == null) {
          continue;
        }
        ((StringBuilder)localObject1).append(((FTSMsgOperator)localObject2).a());
        localObject2 = (FTSTroopOperator)this.jdField_a_of_type_ComTencentMobileqqAppProxyFTSDBManager.a(2);
        if (localObject2 == null) {
          continue;
        }
        ((StringBuilder)localObject1).append(((FTSTroopOperator)localObject2).a()).append("\n");
        QLog.d("Q.fts.BgCpu.Total", 1, ((StringBuilder)localObject1).toString());
        this.d = 0L;
        this.c = 0L;
        this.b = System.currentTimeMillis();
      }
      if (((FTSIndexOperator)localObject1).c())
      {
        sendMessageDelayed(obtainMessage(2, localObject1), 30000L);
      }
      else if (QLog.isColorLevel())
      {
        QLog.w("Q.fts.sync_worker", 2, "readSyncedCursor is false!!");
        continue;
        removeMessages(2, localObject1);
        if (((FTSIndexOperator)localObject1).d()) {
          ((FTSIndexOperator)localObject1).e();
        }
        bool = this.jdField_a_of_type_ComTencentMobileqqAppProxyFTSDBManager.b;
        if (bool)
        {
          this.d += SystemClock.currentThreadTimeMillis() - l3;
          this.c += System.currentTimeMillis() - l2;
          if (System.currentTimeMillis() - this.b > 300000L)
          {
            paramMessage = new StringBuilder(100);
            paramMessage.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(System.currentTimeMillis()))).append(" ");
            paramMessage.append("cpu:").append(this.d).append(" - wall:").append(this.c).append(" ");
            localObject1 = (FTSMsgOperator)this.jdField_a_of_type_ComTencentMobileqqAppProxyFTSDBManager.a(1);
            if (localObject1 != null) {
              paramMessage.append(((FTSMsgOperator)localObject1).a());
            }
            localObject1 = (FTSTroopOperator)this.jdField_a_of_type_ComTencentMobileqqAppProxyFTSDBManager.a(2);
            if (localObject1 != null) {
              paramMessage.append(((FTSTroopOperator)localObject1).a()).append("\n");
            }
            QLog.d("Q.fts.BgCpu.Total", 1, paramMessage.toString());
            this.d = 0L;
            this.c = 0L;
            this.b = System.currentTimeMillis();
          }
        }
        else if (((FTSIndexOperator)localObject1).g())
        {
          sendMessageDelayed(obtainMessage(4, localObject1), 15000L);
        }
        else
        {
          paramMessage = obtainMessage(2, localObject1);
          if (!((FTSIndexOperator)localObject1).f()) {
            break;
          }
          l1 = 15000L;
          label812:
          sendMessageDelayed(paramMessage, l1);
        }
      }
    }
    removeMessages(4, localObject1);
    ((FTSIndexOperator)localObject1).f();
    paramMessage = obtainMessage(2, localObject1);
    if (((FTSIndexOperator)localObject1).f()) {}
    for (long l1 = 15000L;; l1 = 30000L)
    {
      sendMessageDelayed(paramMessage, l1);
      break;
      removeMessages(3, localObject1);
      ((FTSIndexOperator)localObject1).e();
      bool = this.jdField_a_of_type_ComTencentMobileqqAppProxyFTSDBManager.b;
      if (!bool) {
        break;
      }
      this.d += SystemClock.currentThreadTimeMillis() - l3;
      this.c += System.currentTimeMillis() - l2;
      if (System.currentTimeMillis() - this.b <= 300000L) {
        break label270;
      }
      paramMessage = new StringBuilder(100);
      paramMessage.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(System.currentTimeMillis()))).append(" ");
      paramMessage.append("cpu:").append(this.d).append(" - wall:").append(this.c).append(" ");
      localObject1 = (FTSMsgOperator)this.jdField_a_of_type_ComTencentMobileqqAppProxyFTSDBManager.a(1);
      if (localObject1 != null) {
        paramMessage.append(((FTSMsgOperator)localObject1).a());
      }
      localObject1 = (FTSTroopOperator)this.jdField_a_of_type_ComTencentMobileqqAppProxyFTSDBManager.a(2);
      if (localObject1 != null) {
        paramMessage.append(((FTSTroopOperator)localObject1).a()).append("\n");
      }
      QLog.d("Q.fts.BgCpu.Total", 1, paramMessage.toString());
      this.d = 0L;
      this.c = 0L;
      this.b = System.currentTimeMillis();
      return;
      l1 = 30000L;
      break label812;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.fts.FTSSyncHandler
 * JD-Core Version:    0.7.0.1
 */