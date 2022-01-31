package com.tencent.mobileqq.activity.qwallet.report;

import VACDReport.ReportBody;
import VACDReport.ReportHeader;
import VACDReport.ReportInfo;
import VACDReport.ReportItem;
import VACDReport.ReportReq;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;
import xnb;
import xnd;
import xne;
import xnf;
import xng;
import xnh;

public class VACDReportMgr
  implements Manager
{
  private static boolean jdField_a_of_type_Boolean;
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private static byte[] jdField_b_of_type_ArrayOfByte = new byte[0];
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList(8);
  private Map jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap(8));
  private BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver = new xng(this);
  private xnb jdField_a_of_type_Xnb = new xnb(BaseApplicationImpl.getApplication());
  private Handler jdField_b_of_type_AndroidOsHandler;
  private HandlerThread jdField_b_of_type_AndroidOsHandlerThread;
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList(8);
  private Map jdField_b_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap(8));
  private boolean jdField_b_of_type_Boolean;
  private Handler jdField_c_of_type_AndroidOsHandler;
  private HandlerThread jdField_c_of_type_AndroidOsHandlerThread;
  
  public static void a()
  {
    if (!jdField_a_of_type_Boolean) {
      new VACDReportMgr().a(true);
    }
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VACDReport", 2, "writeCacheToDB, from=" + paramInt + ", headerSize=" + this.jdField_a_of_type_JavaUtilArrayList.size() + ", itemSize=" + this.jdField_b_of_type_JavaUtilArrayList.size());
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      this.jdField_a_of_type_Xnb.c(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
    {
      this.jdField_a_of_type_Xnb.b(this.jdField_b_of_type_JavaUtilArrayList);
      this.jdField_b_of_type_JavaUtilArrayList.clear();
    }
  }
  
  private void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject = new StringBuffer();
        i = 0;
        if (i < paramList.size())
        {
          this.jdField_b_of_type_JavaUtilMap.put(Long.valueOf(((ReportInfo)paramList.get(i)).header.seqno), Long.valueOf(SystemClock.uptimeMillis()));
          ((StringBuffer)localObject).append(((ReportInfo)paramList.get(i)).header.seqno);
          if (i < paramList.size() - 1) {
            ((StringBuffer)localObject).append('|');
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("VACDReport", 2, "sendReports, sendingSize=" + this.jdField_b_of_type_JavaUtilMap.size() + ", seqnoList=" + ((StringBuffer)localObject).toString());
          }
          localObject = new ReportReq();
          ((ReportReq)localObject).reports = new ArrayList(paramList);
          paramList = BaseApplicationImpl.getApplication().getRuntime();
          NewIntent localNewIntent = new NewIntent(paramList.getApplication(), VACDReportServlet.class);
          localNewIntent.putExtra("req", (Serializable)localObject);
          localNewIntent.putExtra("cmd_type", 1);
          localNewIntent.setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
          paramList.startServlet(localNewIntent);
          return;
        }
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
        return;
      }
      i += 1;
    }
  }
  
  /* Error */
  private void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 236	com/tencent/mobileqq/activity/qwallet/report/VACDReportMgr:jdField_b_of_type_Boolean	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: getstatic 23	com/tencent/mobileqq/activity/qwallet/report/VACDReportMgr:jdField_b_of_type_ArrayOfByte	[B
    //   11: astore_2
    //   12: aload_2
    //   13: monitorenter
    //   14: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +28 -> 45
    //   20: ldc 89
    //   22: iconst_2
    //   23: new 91	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   30: ldc 238
    //   32: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: iload_1
    //   36: invokevirtual 241	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   39: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: aload_0
    //   46: iconst_1
    //   47: putfield 236	com/tencent/mobileqq/activity/qwallet/report/VACDReportMgr:jdField_b_of_type_Boolean	Z
    //   50: iconst_1
    //   51: putstatic 77	com/tencent/mobileqq/activity/qwallet/report/VACDReportMgr:jdField_a_of_type_Boolean	Z
    //   54: new 243	xnc
    //   57: dup
    //   58: aload_0
    //   59: invokespecial 244	xnc:<init>	(Lcom/tencent/mobileqq/activity/qwallet/report/VACDReportMgr;)V
    //   62: bipush 10
    //   64: aconst_null
    //   65: iconst_0
    //   66: invokestatic 250	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   69: iload_1
    //   70: ifne +11 -> 81
    //   73: aload_0
    //   74: invokespecial 252	com/tencent/mobileqq/activity/qwallet/report/VACDReportMgr:d	()V
    //   77: aload_0
    //   78: invokespecial 254	com/tencent/mobileqq/activity/qwallet/report/VACDReportMgr:c	()V
    //   81: aload_0
    //   82: iload_1
    //   83: invokespecial 256	com/tencent/mobileqq/activity/qwallet/report/VACDReportMgr:b	(Z)V
    //   86: aload_2
    //   87: monitorexit
    //   88: return
    //   89: astore_3
    //   90: aload_2
    //   91: monitorexit
    //   92: aload_3
    //   93: athrow
    //   94: astore_3
    //   95: ldc 89
    //   97: iconst_1
    //   98: ldc_w 258
    //   101: aload_3
    //   102: invokestatic 262	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   105: aload_0
    //   106: invokevirtual 265	com/tencent/mobileqq/activity/qwallet/report/VACDReportMgr:onDestroy	()V
    //   109: goto -23 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	VACDReportMgr
    //   0	112	1	paramBoolean	boolean
    //   89	4	3	localObject	Object
    //   94	8	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   14	45	89	finally
    //   45	69	89	finally
    //   73	81	89	finally
    //   81	86	89	finally
    //   86	88	89	finally
    //   90	92	89	finally
    //   95	109	89	finally
    //   14	45	94	java/lang/Throwable
    //   45	69	94	java/lang/Throwable
    //   73	81	94	java/lang/Throwable
    //   81	86	94	java/lang/Throwable
  }
  
  private boolean a(List paramList)
  {
    Object localObject;
    ReportInfo localReportInfo;
    ArrayList localArrayList;
    int i;
    label253:
    do
    {
      try
      {
        localObject = new ArrayList(this.jdField_a_of_type_JavaUtilMap.values());
        if ((localObject == null) || (((List)localObject).isEmpty())) {
          break;
        }
        Iterator localIterator = ((List)localObject).iterator();
        while (localIterator.hasNext())
        {
          localReportInfo = (ReportInfo)localIterator.next();
          if ((localReportInfo != null) && (localReportInfo.body != null) && (localReportInfo.body.reportItems != null) && (!localReportInfo.body.reportItems.isEmpty()) && (localReportInfo.header != null) && (localReportInfo.header.totalTime >= 0L))
          {
            long l = localReportInfo.header.seqno;
            if (this.jdField_b_of_type_JavaUtilMap.containsKey(Long.valueOf(l)))
            {
              if (Math.abs(SystemClock.uptimeMillis() - ((Long)this.jdField_b_of_type_JavaUtilMap.get(Long.valueOf(l))).longValue()) > 35000L) {
                this.jdField_b_of_type_JavaUtilMap.remove(Long.valueOf(l));
              }
            }
            else
            {
              if (paramList.size() > 10L) {
                return true;
              }
              paramList.add(localReportInfo);
              Collections.sort(localReportInfo.body.reportItems);
              localArrayList = localReportInfo.body.reportItems;
              localObject = null;
              i = 0;
              if (i >= localArrayList.size()) {
                break label316;
              }
              ReportItem localReportItem = (ReportItem)localArrayList.get(i);
              if (i == 0) {
                localReportItem.costTime = 0L;
              } else {
                localReportItem.costTime = (localReportItem.createTime - ((ReportItem)localObject).createTime);
              }
            }
          }
        }
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
      }
      return false;
      if ((localObject != null) && (((ReportItem)localObject).result != 0)) {
        localReportInfo.header.result = ((ReportItem)localObject).result;
      }
    } while (localReportInfo.header.result != -1);
    label316:
    int j = 0;
    int k = localArrayList.size() - 2;
    for (;;)
    {
      boolean bool;
      if (k >= 0)
      {
        localObject = (ReportItem)localArrayList.get(k);
        if (localObject == null) {
          break label652;
        }
        i = j;
        if (!TextUtils.isEmpty(((ReportItem)localObject).step))
        {
          i = j;
          if (((ReportItem)localObject).step.equals("qpay_gate.cgi.end"))
          {
            bool = TextUtils.isEmpty(((ReportItem)localObject).params);
            i = j;
            if (bool) {}
          }
        }
        try
        {
          int m = ((ReportItem)localObject).params.indexOf("&cardtype=");
          i = j;
          if (m != -1)
          {
            i = "&cardtype=".length() + m;
            i = Integer.valueOf(((ReportItem)localObject).params.substring(i, i + 1)).intValue();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            i = 0;
          }
        }
        j = i;
        if (((ReportItem)localObject).result == 0) {
          break label652;
        }
        j = i;
        if (((ReportItem)localObject).result == -1) {
          break label652;
        }
        localReportInfo.header.result = ((ReportItem)localObject).result;
        bool = false;
      }
      for (;;)
      {
        if ((bool) && (i > 0)) {
          localReportInfo.header.result = (i + 668900);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("VACDReport", 2, "handleUserGiveUp seqno=" + localReportInfo.header.seqno + ",result:" + localReportInfo.header.result + ",isUserGiveUp" + bool);
        break;
        bool = true;
        i = j;
      }
      return false;
      i += 1;
      localObject = localException;
      break label253;
      label652:
      k -= 1;
    }
  }
  
  private void b()
  {
    a(false);
  }
  
  private void b(int paramInt)
  {
    a(paramInt);
    if ((this.jdField_a_of_type_JavaUtilMap != null) && (!this.jdField_a_of_type_JavaUtilMap.isEmpty()))
    {
      boolean bool;
      do
      {
        ArrayList localArrayList = new ArrayList();
        bool = a(localArrayList);
        a(localArrayList);
      } while (bool);
    }
  }
  
  private void b(List paramList)
  {
    ThreadManager.post(new xnh(this, paramList), 10, null, true);
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidOsHandlerThread == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VACDReport", 2, "TimeOutThread start. isOnlyCheckTimeoutOnQQStart=" + paramBoolean);
      }
      this.jdField_b_of_type_AndroidOsHandlerThread = new HandlerThread("VACDReportTimeOut");
      this.jdField_b_of_type_AndroidOsHandlerThread.start();
      this.jdField_b_of_type_AndroidOsHandler = new Handler(this.jdField_b_of_type_AndroidOsHandlerThread.getLooper());
      this.jdField_b_of_type_AndroidOsHandler.postDelayed(new xnd(this, paramBoolean), 0L);
    }
  }
  
  private void c()
  {
    if (this.jdField_c_of_type_AndroidOsHandlerThread == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VACDReport", 2, "ReportThread start.");
      }
      this.jdField_c_of_type_AndroidOsHandlerThread = new HandlerThread("ReportCache");
      this.jdField_c_of_type_AndroidOsHandlerThread.start();
      this.jdField_c_of_type_AndroidOsHandler = new xne(this, this.jdField_c_of_type_AndroidOsHandlerThread.getLooper());
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VACDReport", 2, "WriteDBThread start.");
      }
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("VACDReportWriteDB");
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new xnf(this, new byte[0]), 2000L);
    }
  }
  
  void a(long paramLong, ReportItem paramReportItem)
  {
    if (paramReportItem == null) {
      if (QLog.isColorLevel()) {
        QLog.d("VACDReport", 2, "endReport seqno=" + paramLong + "  item is null return.");
      }
    }
    Message localMessage;
    do
    {
      do
      {
        return;
        b();
      } while (this.jdField_c_of_type_AndroidOsHandler == null);
      localMessage = this.jdField_c_of_type_AndroidOsHandler.obtainMessage();
    } while (localMessage == null);
    localMessage.arg1 = 3;
    localMessage.obj = new Object[] { Long.valueOf(paramLong), paramReportItem };
    this.jdField_c_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 10000L);
  }
  
  void a(long paramLong, String paramString, ReportItem paramReportItem)
  {
    if (paramReportItem == null) {
      if (QLog.isColorLevel()) {
        QLog.d("VACDReport", 2, "addReportItem seqno=" + paramLong + "  item is null return.");
      }
    }
    Message localMessage;
    do
    {
      do
      {
        return;
        b();
      } while (this.jdField_c_of_type_AndroidOsHandler == null);
      localMessage = this.jdField_c_of_type_AndroidOsHandler.obtainMessage();
    } while (localMessage == null);
    localMessage.arg1 = 2;
    localMessage.obj = new Object[] { Long.valueOf(paramLong), paramString, paramReportItem };
    this.jdField_c_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  void a(String paramString, ReportHeader paramReportHeader, ReportItem paramReportItem)
  {
    if (paramReportHeader == null) {
      if (QLog.isColorLevel()) {
        QLog.d("VACDReport", 2, "startReport header is null return");
      }
    }
    Message localMessage;
    do
    {
      do
      {
        do
        {
          return;
          if (paramReportHeader.seqno > 0L) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("VACDReport", 2, "startReport header seqno=" + paramReportHeader.seqno + " is illegal!");
        return;
        b();
      } while (this.jdField_c_of_type_AndroidOsHandler == null);
      localMessage = this.jdField_c_of_type_AndroidOsHandler.obtainMessage();
    } while (localMessage == null);
    localMessage.arg1 = 1;
    localMessage.obj = new Object[] { paramString, paramReportHeader, paramReportItem };
    this.jdField_c_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  void b(String paramString, ReportHeader paramReportHeader, ReportItem paramReportItem)
  {
    if (paramReportHeader == null) {
      if (QLog.isColorLevel()) {
        QLog.i("VACDReport", 2, "singleReport:header is null return");
      }
    }
    Message localMessage;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramReportHeader.seqno > 0L) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("VACDReport", 2, "singleReport header seqno=" + paramReportHeader.seqno + " is illegal!");
          return;
          if (paramReportItem != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("VACDReport", 2, "singleReport:item is null return");
        return;
        b();
      } while (this.jdField_c_of_type_AndroidOsHandler == null);
      localMessage = this.jdField_c_of_type_AndroidOsHandler.obtainMessage();
    } while (localMessage == null);
    localMessage.arg1 = 4;
    localMessage.obj = new Object[] { paramString, paramReportHeader, paramReportItem };
    this.jdField_c_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void onDestroy()
  {
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (!this.jdField_b_of_type_Boolean) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VACDReport", 2, "VACDReportMgr destroy");
      }
      this.jdField_b_of_type_Boolean = false;
      jdField_a_of_type_ArrayOfByte.notifyAll();
      if (this.jdField_c_of_type_AndroidOsHandler != null) {
        this.jdField_c_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
      if (this.jdField_c_of_type_AndroidOsHandlerThread != null)
      {
        this.jdField_c_of_type_AndroidOsHandlerThread.quit();
        this.jdField_c_of_type_AndroidOsHandlerThread = null;
      }
      if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
      {
        this.jdField_a_of_type_AndroidOsHandlerThread.quit();
        this.jdField_a_of_type_AndroidOsHandlerThread = null;
      }
      if (this.jdField_b_of_type_AndroidOsHandler != null) {
        this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
      if (this.jdField_b_of_type_AndroidOsHandlerThread != null)
      {
        this.jdField_b_of_type_AndroidOsHandlerThread.quit();
        this.jdField_b_of_type_AndroidOsHandlerThread = null;
      }
      if (this.jdField_a_of_type_JavaUtilMap != null) {
        this.jdField_a_of_type_JavaUtilMap.clear();
      }
      if (this.jdField_b_of_type_JavaUtilMap != null) {
        this.jdField_b_of_type_JavaUtilMap.clear();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.report.VACDReportMgr
 * JD-Core Version:    0.7.0.1
 */