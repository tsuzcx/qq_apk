package com.tencent.biz.qqcircle.richframework.outbox;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.biz.qqcircle.publish.account.LoginData;
import com.tencent.biz.qqcircle.publish.common.Singleton;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.utils.NetworkState;
import cooperation.qqcircle.utils.NetworkState.NetworkStateListener;
import feedcloud.FeedCloudCommon.Entry;
import java.util.Arrays;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

public class QCircleOutboxTaskQueue
  extends BaseOutboxTaskQueue
  implements Handler.Callback, NetworkState.NetworkStateListener
{
  private static int a = 3;
  private static final Singleton<QCircleOutboxTaskQueue, Void> d = new QCircleOutboxTaskQueue.1();
  private static final long g = TimeZone.getTimeZone("GMT+8").getRawOffset();
  private HandlerThread b;
  private Handler c;
  private Runnable e = new QCircleOutboxTaskQueue.2(this);
  private Runnable f = new QCircleOutboxTaskQueue.3(this);
  
  private QCircleOutboxTaskQueue()
  {
    QLog.d("QCircleOutboxTaskQueue", 1, "new instance");
    this.b = new HandlerThread("QCircleOutboxTaskQueue", 10);
    this.b.start();
    this.c = new Handler(this.b.getLooper(), this);
    NetworkState.addListener(this);
  }
  
  private void a(Message paramMessage)
  {
    paramMessage = (QCircleOutboxTask)paramMessage.obj;
    if (paramMessage == null) {
      return;
    }
    paramMessage.a("QCircleOutboxTaskQueue", "onAddTask");
    QCircleOutboxTaskManager.a().a(paramMessage);
    i();
  }
  
  public static BaseOutboxTaskQueue b()
  {
    if (QCircleConfigHelper.a("qqcircle", "qqcircle_outbox_switch", Integer.valueOf(0)).intValue() == 0) {
      return (BaseOutboxTaskQueue)d.b(null);
    }
    return new BaseOutboxTaskQueue();
  }
  
  private void b(Message paramMessage)
  {
    paramMessage = (QCircleOutboxTask)paramMessage.obj;
    if (paramMessage == null) {
      return;
    }
    paramMessage.a("QCircleOutboxTaskQueue", "onResumeTask");
    QCircleOutboxTaskManager.a().b(paramMessage);
    i();
  }
  
  private void c()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 4;
    this.c.sendMessage(localMessage);
  }
  
  private void c(Message paramMessage)
  {
    QCircleOutboxTask localQCircleOutboxTask = (QCircleOutboxTask)paramMessage.obj;
    if (localQCircleOutboxTask == null) {
      return;
    }
    localQCircleOutboxTask.a("QCircleOutboxTaskQueue", "onCompleteTask");
    QCircleOutboxTaskManager localQCircleOutboxTaskManager = QCircleOutboxTaskManager.a();
    int i = paramMessage.arg1;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    localQCircleOutboxTaskManager.a(localQCircleOutboxTask, bool);
    i();
  }
  
  private boolean c(QCircleOutboxTask paramQCircleOutboxTask)
  {
    boolean bool2 = false;
    if (paramQCircleOutboxTask == null) {
      return false;
    }
    paramQCircleOutboxTask.a("QCircleOutboxTaskQueue", "removeTask", true);
    boolean bool1 = bool2;
    if (e(paramQCircleOutboxTask)) {
      if (paramQCircleOutboxTask.b() == 2)
      {
        bool1 = true;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("removeTask id:");
        ((StringBuilder)localObject).append(paramQCircleOutboxTask.a());
        ((StringBuilder)localObject).append(",unexpect state:");
        ((StringBuilder)localObject).append(paramQCircleOutboxTask.b());
        QLog.d("QCircleOutboxTaskQueue", 1, ((StringBuilder)localObject).toString());
        bool1 = bool2;
      }
    }
    Object localObject = Message.obtain();
    ((Message)localObject).what = 3;
    ((Message)localObject).obj = paramQCircleOutboxTask;
    this.c.sendMessage((Message)localObject);
    return bool1;
  }
  
  private void d()
  {
    if (QCircleOutboxTaskManager.a().c())
    {
      this.c.removeCallbacks(this.e);
      this.c.postDelayed(this.e, 3000L);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRestore taskList size:");
    localStringBuilder.append(g());
    QLog.i("QCircleOutboxTaskQueue", 1, localStringBuilder.toString());
  }
  
  private void d(Message paramMessage)
  {
    paramMessage = (QCircleOutboxTask)paramMessage.obj;
    if (paramMessage == null) {
      return;
    }
    paramMessage.a("QCircleOutboxTaskQueue", "onRemoveTask", true);
    QCircleOutboxTaskManager.a().c(paramMessage);
    i();
  }
  
  private void d(QCircleOutboxTask paramQCircleOutboxTask)
  {
    if (paramQCircleOutboxTask == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = paramQCircleOutboxTask;
    this.c.sendMessage(localMessage);
  }
  
  private void e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onResetTask task size:");
    localStringBuilder.append(g());
    QLog.i("QCircleOutboxTaskQueue", 1, localStringBuilder.toString());
    QCircleOutboxTaskManager.a().d();
    f();
  }
  
  private boolean e(QCircleOutboxTask paramQCircleOutboxTask)
  {
    return QCircleOutboxTaskManager.a().d(paramQCircleOutboxTask);
  }
  
  private void f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("release uin:");
    localStringBuilder.append(LoginData.a().b());
    QLog.i("QCircleOutboxTaskQueue", 1, localStringBuilder.toString());
    this.c.removeCallbacksAndMessages(null);
    this.b.quit();
    this.b = null;
    this.c = null;
    d.a();
  }
  
  private void f(QCircleOutboxTask paramQCircleOutboxTask)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramQCircleOutboxTask.i());
    ((StringBuilder)localObject1).append("");
    localObject1 = QCircleReportHelper.newEntry("ret_code", ((StringBuilder)localObject1).toString());
    FeedCloudCommon.Entry localEntry = QCircleReportHelper.newEntry("url", paramQCircleOutboxTask.j());
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramQCircleOutboxTask.n());
    ((StringBuilder)localObject2).append("");
    localObject2 = QCircleReportHelper.newEntry("refer", ((StringBuilder)localObject2).toString());
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(paramQCircleOutboxTask.l());
    ((StringBuilder)localObject3).append("");
    localObject3 = QCircleReportHelper.newEntry("count", ((StringBuilder)localObject3).toString());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramQCircleOutboxTask.a());
    localStringBuilder.append("_");
    localStringBuilder.append(Arrays.toString(paramQCircleOutboxTask.m()));
    localStringBuilder.append("_");
    localStringBuilder.append(paramQCircleOutboxTask.i());
    localStringBuilder.append("_");
    localStringBuilder.append(paramQCircleOutboxTask.j());
    localStringBuilder.append("_state=");
    localStringBuilder.append(paramQCircleOutboxTask.b());
    QCircleQualityReporter.reportQualityEvent("outbox_task_resend_event_final", Arrays.asList(new FeedCloudCommon.Entry[] { localObject1, localEntry, localObject2, localObject3, QCircleReportHelper.newEntry("attach_info", localStringBuilder.toString()) }), false);
  }
  
  private int g()
  {
    return QCircleOutboxTaskManager.a().f();
  }
  
  private boolean g(QCircleOutboxTask paramQCircleOutboxTask)
  {
    boolean bool2 = false;
    if (paramQCircleOutboxTask == null) {
      return false;
    }
    a = QCircleConfigHelper.a("qqcircle", "qqcircle_max_retry_count", Integer.valueOf(a)).intValue();
    boolean bool1 = bool2;
    if (paramQCircleOutboxTask.b() == 2)
    {
      bool1 = bool2;
      if (h(paramQCircleOutboxTask))
      {
        bool1 = bool2;
        if (paramQCircleOutboxTask.l() < a) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private CopyOnWriteArrayList<QCircleOutboxTask> h()
  {
    long l = System.currentTimeMillis();
    CopyOnWriteArrayList localCopyOnWriteArrayList = QCircleOutboxTaskManager.a().e();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getTaskList timeCost:");
    localStringBuilder.append(System.currentTimeMillis() - l);
    QLog.d("QCircleOutboxTaskQueue", 1, localStringBuilder.toString());
    return localCopyOnWriteArrayList;
  }
  
  private boolean h(QCircleOutboxTask paramQCircleOutboxTask)
  {
    long l = paramQCircleOutboxTask.i();
    Object localObject = paramQCircleOutboxTask.m();
    boolean bool2 = false;
    if ((localObject != null) && (localObject.length > 0))
    {
      int j = localObject.length;
      int i = 0;
      for (;;)
      {
        bool1 = bool2;
        if (i >= j) {
          break label64;
        }
        if (localObject[i] == l) {
          break;
        }
        i += 1;
      }
    }
    boolean bool1 = true;
    label64:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("resultCodeCanRetry id:");
    ((StringBuilder)localObject).append(paramQCircleOutboxTask.a());
    ((StringBuilder)localObject).append(" ,state:");
    ((StringBuilder)localObject).append(paramQCircleOutboxTask.b());
    ((StringBuilder)localObject).append(" ,info:");
    ((StringBuilder)localObject).append(paramQCircleOutboxTask.n());
    ((StringBuilder)localObject).append(" ,retCode:");
    ((StringBuilder)localObject).append(paramQCircleOutboxTask.i());
    ((StringBuilder)localObject).append(" ,curRetryNum:");
    ((StringBuilder)localObject).append(paramQCircleOutboxTask.l());
    ((StringBuilder)localObject).append(" ,retryCodes:");
    ((StringBuilder)localObject).append(Arrays.toString(paramQCircleOutboxTask.m()));
    ((StringBuilder)localObject).append(" ,canRetry:");
    ((StringBuilder)localObject).append(bool1);
    QLog.d("QCircleOutboxTaskQueue", 1, ((StringBuilder)localObject).toString());
    return bool1;
  }
  
  private boolean i()
  {
    return QCircleOutboxTaskManager.a().b();
  }
  
  private void j()
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = h();
    if (localCopyOnWriteArrayList != null)
    {
      int j = localCopyOnWriteArrayList.size();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkRetry taskList size:");
      ((StringBuilder)localObject).append(j);
      QLog.i("QCircleOutboxTaskQueue", 1, ((StringBuilder)localObject).toString());
      int i = 0;
      while (i < j)
      {
        localObject = (QCircleOutboxTask)localCopyOnWriteArrayList.get(i);
        ((QCircleOutboxTask)localObject).a("QCircleOutboxTaskQueue", "checkRetry");
        if (((QCircleOutboxTask)localObject).b() != 1)
        {
          StringBuilder localStringBuilder;
          if (g((QCircleOutboxTask)localObject))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("retryTask id:");
            localStringBuilder.append(((QCircleOutboxTask)localObject).a());
            localStringBuilder.append(" ,state:");
            localStringBuilder.append(((QCircleOutboxTask)localObject).b());
            localStringBuilder.append(" ,info:");
            localStringBuilder.append(((QCircleOutboxTask)localObject).n());
            localStringBuilder.append(" ,curRetryNum:");
            localStringBuilder.append(((QCircleOutboxTask)localObject).l());
            QLog.d("QCircleOutboxTaskQueue", 1, localStringBuilder.toString());
            d((QCircleOutboxTask)localObject);
          }
          else
          {
            f((QCircleOutboxTask)localObject);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("removeTask id:");
            localStringBuilder.append(((QCircleOutboxTask)localObject).a());
            localStringBuilder.append(" ,state:");
            localStringBuilder.append(((QCircleOutboxTask)localObject).b());
            localStringBuilder.append(" ,info:");
            localStringBuilder.append(((QCircleOutboxTask)localObject).n());
            localStringBuilder.append(" ,curRetryNum:");
            localStringBuilder.append(((QCircleOutboxTask)localObject).l());
            localStringBuilder.append(" ,resultCode:");
            localStringBuilder.append(((QCircleOutboxTask)localObject).i());
            QLog.d("QCircleOutboxTaskQueue", 1, localStringBuilder.toString());
            c((QCircleOutboxTask)localObject);
          }
        }
        i += 1;
      }
    }
  }
  
  public void a()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 6;
    this.c.sendMessage(localMessage);
  }
  
  public void a(QCircleOutboxTask paramQCircleOutboxTask)
  {
    if (paramQCircleOutboxTask == null) {
      return;
    }
    paramQCircleOutboxTask.a(System.currentTimeMillis());
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = paramQCircleOutboxTask;
    this.c.sendMessage(localMessage);
  }
  
  public void a(QCircleOutboxTask paramQCircleOutboxTask, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void b(QCircleOutboxTask paramQCircleOutboxTask)
  {
    if (paramQCircleOutboxTask == null) {
      return;
    }
    paramQCircleOutboxTask.a(2);
    a(paramQCircleOutboxTask);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      break;
    case 6: 
      e();
      break;
    case 5: 
      c(paramMessage);
      break;
    case 4: 
      d();
      break;
    case 3: 
      d(paramMessage);
      break;
    case 2: 
      b(paramMessage);
      break;
    case 1: 
      a(paramMessage);
    }
    return false;
  }
  
  public void onNetworkConnect(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Handler localHandler = this.c;
      if (localHandler != null)
      {
        localHandler.removeCallbacks(this.e);
        this.c.postDelayed(this.e, 10000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.outbox.QCircleOutboxTaskQueue
 * JD-Core Version:    0.7.0.1
 */