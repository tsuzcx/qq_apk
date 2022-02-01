package com.tencent.biz.qqcircle.publish.queue;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneThreadHelper;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.publish.common.Singleton;
import com.tencent.biz.qqcircle.publish.task.IQueueTask;
import com.tencent.biz.qqcircle.publish.task.QCircleUploadShuoShuoTask;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.winkpublish.event.QCirclePublishBoxStatusEvent;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleFakeFeed;
import cooperation.qqcircle.beans.QCircleFakeFeed.Builder;
import cooperation.qqcircle.utils.NetworkState;
import cooperation.qqcircle.utils.NetworkState.NetworkStateListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

public class QCircleTaskQueue
  implements Handler.Callback, IPublishQueue, NetworkState.NetworkStateListener
{
  public static boolean a = false;
  private static int b = 10;
  private static final Singleton<QCircleTaskQueue, Void> e = new QCircleTaskQueue.1();
  private static final long k = TimeZone.getTimeZone("GMT+8").getRawOffset();
  private Handler c = new Handler(QCircleHostQzoneThreadHelper.getRealTimeLooper(), this);
  private final ArrayList<WeakReference<IPublishQueueListener>> d = new ArrayList();
  private boolean f = false;
  private QCircleCustomDialog g;
  private Runnable h = new QCircleTaskQueue.2(this);
  private Runnable i = new QCircleTaskQueue.3(this);
  private Runnable j = new QCircleTaskQueue.4(this);
  
  private QCircleTaskQueue()
  {
    NetworkState.addListener(this);
  }
  
  public static QCircleTaskQueue a()
  {
    return (QCircleTaskQueue)e.b(null);
  }
  
  private void a(Message paramMessage)
  {
    paramMessage = (IQueueTask)paramMessage.obj;
    if (paramMessage == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAddTask id:");
    localStringBuilder.append(paramMessage.c());
    localStringBuilder.append(", type:");
    localStringBuilder.append(paramMessage.k());
    QLog.i("[upload2_outbox_QCircleTaskQueue]", 1, localStringBuilder.toString());
    QCircleTaskManager.a().a(paramMessage);
    if (!NetworkState.isNetSupport()) {
      paramMessage.b(6);
    }
    m();
    i();
  }
  
  private boolean a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("resultCodeCanRetry... resultcode:");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool2 = true;
    QLog.d("[upload2_outbox_QCircleTaskQueue]", 1, (String)localObject);
    boolean bool1 = bool2;
    if (paramInt != 0)
    {
      bool1 = bool2;
      if (paramInt != -3000)
      {
        bool1 = bool2;
        if (paramInt != -5000)
        {
          bool1 = bool2;
          if (paramInt != 35000)
          {
            bool1 = bool2;
            if (paramInt != 301002)
            {
              bool1 = bool2;
              if (paramInt != 301013)
              {
                bool1 = bool2;
                if (paramInt != 1000004)
                {
                  if (paramInt == 10001) {
                    return true;
                  }
                  bool1 = false;
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private void b(Message paramMessage)
  {
    paramMessage = (IQueueTask)paramMessage.obj;
    if (paramMessage == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUpdateTask id:");
    localStringBuilder.append(paramMessage.c());
    localStringBuilder.append(", type:");
    localStringBuilder.append(paramMessage.k());
    QLog.i("[upload2_outbox_QCircleTaskQueue]", 1, localStringBuilder.toString());
    QCircleTaskManager.a().b(paramMessage);
  }
  
  private void c(Message paramMessage)
  {
    paramMessage = (IQueueTask)paramMessage.obj;
    if (paramMessage == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPauseTask id:");
    localStringBuilder.append(paramMessage.c());
    localStringBuilder.append(", type:");
    localStringBuilder.append(paramMessage.k());
    QLog.i("[upload2_outbox_QCircleTaskQueue]", 1, localStringBuilder.toString());
    QCircleTaskManager.a().c(paramMessage);
  }
  
  private void d(Message paramMessage)
  {
    paramMessage = (IQueueTask)paramMessage.obj;
    if (paramMessage == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onResumeTask id:");
    localStringBuilder.append(paramMessage.c());
    localStringBuilder.append(", type:");
    localStringBuilder.append(paramMessage.k());
    QLog.i("[upload2_outbox_QCircleTaskQueue]", 1, localStringBuilder.toString());
    QCircleTaskManager.a().d(paramMessage);
    m();
    i();
  }
  
  private void e(Message paramMessage)
  {
    IQueueTask localIQueueTask = (IQueueTask)paramMessage.obj;
    if (localIQueueTask == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCompleteTask id:");
    ((StringBuilder)localObject).append(localIQueueTask.c());
    ((StringBuilder)localObject).append(", type:");
    ((StringBuilder)localObject).append(localIQueueTask.k());
    localObject = ((StringBuilder)localObject).toString();
    boolean bool = true;
    QLog.i("[upload2_outbox_QCircleTaskQueue]", 1, (String)localObject);
    localObject = QCircleTaskManager.a();
    if (paramMessage.arg1 != 1) {
      bool = false;
    }
    ((QCircleTaskManager)localObject).a(localIQueueTask, bool);
    m();
    i();
  }
  
  private void f(Message paramMessage)
  {
    IQueueTask localIQueueTask = (IQueueTask)paramMessage.obj;
    if (localIQueueTask == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onFinishTask id:");
    ((StringBuilder)localObject).append(localIQueueTask.c());
    ((StringBuilder)localObject).append(", type:");
    ((StringBuilder)localObject).append(localIQueueTask.k());
    localObject = ((StringBuilder)localObject).toString();
    boolean bool = true;
    QLog.i("[upload2_outbox_QCircleTaskQueue]", 1, (String)localObject);
    localObject = QCircleTaskManager.a();
    if (paramMessage.arg1 != 1) {
      bool = false;
    }
    ((QCircleTaskManager)localObject).b(localIQueueTask, bool);
    m();
    i();
  }
  
  private void g(Message paramMessage)
  {
    paramMessage = (IQueueTask)paramMessage.obj;
    if (paramMessage == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRemoveTask id:");
    localStringBuilder.append(paramMessage.c());
    localStringBuilder.append(", type:");
    localStringBuilder.append(paramMessage.k());
    QLog.i("[upload2_outbox_QCircleTaskQueue]", 1, localStringBuilder.toString());
    QCircleTaskManager.a().e(paramMessage);
    m();
    i();
    g(paramMessage);
  }
  
  private static void g(IQueueTask paramIQueueTask)
  {
    paramIQueueTask = new QCircleFakeFeed.Builder().setFeedId("").setClientKey(paramIQueueTask.j()).build();
    SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedEvent(paramIQueueTask, 3));
  }
  
  private boolean h(IQueueTask paramIQueueTask)
  {
    boolean bool2 = false;
    if (paramIQueueTask == null) {
      return false;
    }
    b = QCircleConfigHelper.a("QZoneSetting", "ReconnectionTimes", Integer.valueOf(b)).intValue();
    boolean bool1 = bool2;
    if (paramIQueueTask.bn_() == 2)
    {
      bool1 = bool2;
      if (a(paramIQueueTask.o()))
      {
        bool1 = bool2;
        if (paramIQueueTask.p() < b) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean i(IQueueTask paramIQueueTask)
  {
    if (paramIQueueTask == null) {
      return false;
    }
    int m = QCircleConfigHelper.a("QZoneSetting", "ReconnectionTimes", Integer.valueOf(2147483647)).intValue();
    long l = QCircleConfigHelper.a("QZoneSetting", "ReconnectionDays", Integer.valueOf(7)).intValue();
    if ((paramIQueueTask.p() < m) && (System.currentTimeMillis() - paramIQueueTask.q() < l * 86400L)) {
      return true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("this task is out of date. task.retryNum = ");
      localStringBuilder.append(paramIQueueTask.p());
      localStringBuilder.append(",task.timestamp = ");
      localStringBuilder.append(paramIQueueTask.q());
      QLog.d("[upload2_outbox_QCircleTaskQueue]", 1, localStringBuilder.toString());
    }
    return false;
  }
  
  private void k()
  {
    if (QCircleTaskManager.a().c())
    {
      this.c.removeCallbacks(this.j);
      this.c.postDelayed(this.j, 3000L);
      this.c.removeCallbacks(this.h);
      this.c.postDelayed(this.h, 5000L);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRestore taskList size:");
    localStringBuilder.append(d());
    QLog.i("[upload2_outbox_QCircleTaskQueue]", 1, localStringBuilder.toString());
    i();
  }
  
  private void l()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onResetTask task size:");
    localStringBuilder.append(d());
    QLog.i("[upload2_outbox_QCircleTaskQueue]", 1, localStringBuilder.toString());
    QCircleTaskManager.a().d();
  }
  
  private boolean m()
  {
    return QCircleTaskManager.a().b();
  }
  
  private List<IPublishQueueListener> n()
  {
    Object localObject3;
    synchronized (this.d)
    {
      if (this.d.size() > 0)
      {
        ArrayList localArrayList1 = new ArrayList();
        Iterator localIterator = this.d.iterator();
        Object localObject1;
        for (;;)
        {
          localObject1 = localArrayList1;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (WeakReference)localIterator.next();
          if (localObject1 == null) {
            localObject1 = null;
          } else {
            localObject1 = (IPublishQueueListener)((WeakReference)localObject1).get();
          }
          if (localObject1 != null) {
            localArrayList1.add(localObject1);
          }
        }
        return localObject1;
      }
    }
  }
  
  public IQueueTask a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return QCircleTaskManager.a().a(paramString);
  }
  
  public void a(IPublishQueueListener paramIPublishQueueListener)
  {
    if (paramIPublishQueueListener == null) {
      return;
    }
    synchronized (this.d)
    {
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        IPublishQueueListener localIPublishQueueListener = (IPublishQueueListener)((WeakReference)localIterator.next()).get();
        if (localIPublishQueueListener == null) {
          localIterator.remove();
        } else if (localIPublishQueueListener == paramIPublishQueueListener) {
          return;
        }
      }
      this.d.add(new WeakReference(paramIPublishQueueListener));
      return;
    }
    for (;;)
    {
      throw paramIPublishQueueListener;
    }
  }
  
  public void a(IQueueTask paramIQueueTask)
  {
    if (paramIQueueTask == null) {
      return;
    }
    paramIQueueTask.a(System.currentTimeMillis());
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = paramIQueueTask;
    this.c.sendMessage(localMessage);
  }
  
  public void a(IQueueTask paramIQueueTask, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void b()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 5;
    this.c.sendMessage(localMessage);
  }
  
  public void b(IQueueTask paramIQueueTask)
  {
    if (paramIQueueTask == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 8;
    localMessage.obj = paramIQueueTask;
    this.c.sendMessage(localMessage);
  }
  
  public void b(IQueueTask paramIQueueTask, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void c()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 7;
    this.c.sendMessage(localMessage);
  }
  
  public boolean c(IQueueTask paramIQueueTask)
  {
    if (paramIQueueTask == null) {
      return false;
    }
    boolean bool1 = e(paramIQueueTask);
    boolean bool2 = true;
    if (bool1)
    {
      bool1 = bool2;
      if (paramIQueueTask.bn_() != 2)
      {
        bool1 = bool2;
        if (paramIQueueTask.bn_() != 0)
        {
          bool1 = bool2;
          if (paramIQueueTask.bn_() != 5) {
            if (paramIQueueTask.bn_() == 6)
            {
              bool1 = bool2;
            }
            else if (paramIQueueTask.g())
            {
              bool1 = bool2;
            }
            else
            {
              QLog.i("[upload2_outbox_QCircleTaskQueue]", 1, "removeTask cancel fail");
              return false;
            }
          }
        }
      }
    }
    else
    {
      bool1 = false;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 4;
    localMessage.obj = paramIQueueTask;
    this.c.sendMessage(localMessage);
    return bool1;
  }
  
  public boolean c(IQueueTask paramIQueueTask, boolean paramBoolean)
  {
    if (paramIQueueTask == null) {
      return false;
    }
    String str = QCircleConfigHelper.a("QZoneSetting", "SafetyStrikeCode", "-4015,-4033");
    if (!TextUtils.isEmpty(str))
    {
      Object localObject = str.split(",");
      int n = localObject.length;
      int m = 0;
      while (m < n)
      {
        CharSequence localCharSequence = localObject[m];
        if ((!TextUtils.isEmpty(localCharSequence)) && (localCharSequence.equals(String.valueOf(paramIQueueTask.o()))))
        {
          if (paramBoolean) {
            i();
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("this task is beSafetyStriked(). task.mResultCode = ");
          ((StringBuilder)localObject).append(paramIQueueTask.o());
          ((StringBuilder)localObject).append(",errorCode = ");
          ((StringBuilder)localObject).append(str);
          QLog.d("[upload2_outbox_QCircleTaskQueue]", 1, ((StringBuilder)localObject).toString());
          return true;
        }
        m += 1;
      }
    }
    return false;
  }
  
  public int d()
  {
    return QCircleTaskManager.a().g();
  }
  
  public void d(IQueueTask paramIQueueTask)
  {
    if (paramIQueueTask == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = paramIQueueTask;
    this.c.sendMessage(localMessage);
  }
  
  public boolean e()
  {
    return QCircleTaskManager.a().i();
  }
  
  public boolean e(IQueueTask paramIQueueTask)
  {
    return QCircleTaskManager.a().f(paramIQueueTask);
  }
  
  public void f(IQueueTask paramIQueueTask)
  {
    Object localObject = n();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        IPublishQueueListener localIPublishQueueListener = (IPublishQueueListener)((Iterator)localObject).next();
        if (localIPublishQueueListener != null) {
          localIPublishQueueListener.a(paramIQueueTask);
        }
      }
    }
  }
  
  public boolean f()
  {
    return QCircleTaskManager.a().j();
  }
  
  public boolean g()
  {
    return QCircleTaskManager.a().k();
  }
  
  public CopyOnWriteArrayList<IQueueTask> h()
  {
    long l = System.currentTimeMillis();
    CopyOnWriteArrayList localCopyOnWriteArrayList = QCircleTaskManager.a().e();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getTaskList timeCost:");
    localStringBuilder.append(System.currentTimeMillis() - l);
    QLog.d("[upload2_outbox_QCircleTaskQueue]", 1, localStringBuilder.toString());
    return localCopyOnWriteArrayList;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      break;
    case 9: 
      f(paramMessage);
      break;
    case 8: 
      b(paramMessage);
      break;
    case 7: 
      l();
      break;
    case 6: 
      e(paramMessage);
      break;
    case 5: 
      k();
      break;
    case 4: 
      g(paramMessage);
      break;
    case 3: 
      c(paramMessage);
      break;
    case 2: 
      d(paramMessage);
      break;
    case 1: 
      a(paramMessage);
    }
    return false;
  }
  
  public void i()
  {
    Object localObject = n();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        IPublishQueueListener localIPublishQueueListener = (IPublishQueueListener)((Iterator)localObject).next();
        if (localIPublishQueueListener != null) {
          localIPublishQueueListener.a();
        }
      }
    }
    localObject = SimpleEventBus.getInstance();
    int m = d();
    boolean bool;
    if ((!e()) && (!f())) {
      bool = false;
    } else {
      bool = true;
    }
    ((SimpleEventBus)localObject).dispatchEvent(new QCirclePublishBoxStatusEvent(m, bool, g(), f()));
  }
  
  public ArrayList<QCircleFakeFeed> j()
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = h();
    ArrayList localArrayList = new ArrayList();
    int m = 0;
    while (m < localCopyOnWriteArrayList.size())
    {
      Object localObject = (IQueueTask)localCopyOnWriteArrayList.get(m);
      if (!(localObject instanceof QCircleUploadShuoShuoTask))
      {
        QLog.w("[upload2_outbox_QCircleTaskQueue]", 1, "task is not QCircleUploadShuoShuoTask");
      }
      else
      {
        localObject = ((QCircleUploadShuoShuoTask)localObject).I();
        if (localObject == null) {
          QLog.w("[upload2_outbox_QCircleTaskQueue]", 1, "feed == null");
        } else {
          localArrayList.add(localObject);
        }
      }
      m += 1;
    }
    return localArrayList;
  }
  
  public void onNetworkConnect(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a = false;
      this.f = false;
      QCircleCustomDialog localQCircleCustomDialog = this.g;
      if ((localQCircleCustomDialog != null) && (localQCircleCustomDialog.isShowing()))
      {
        this.g.dismiss();
        this.g = null;
      }
      this.c.removeCallbacks(this.i);
      this.c.postDelayed(this.i, 10000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.queue.QCircleTaskQueue
 * JD-Core Version:    0.7.0.1
 */