package com.tencent.mobileqq.app.automator;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AutomatorObserver;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.startup.step.StartService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import mqq.app.Constants.Key;

public class Automator
  extends BusinessHandler
  implements Runnable
{
  private static ThreadPoolExecutor p;
  public long a;
  public int b = 1;
  public int c = 0;
  public SharedPreferences d;
  public boolean e = false;
  public boolean f = false;
  public boolean g = false;
  protected int h = 0;
  protected LinkedList<AsyncStep> i = new LinkedList();
  public ConcurrentHashMap<String, Long> j = new ConcurrentHashMap(16);
  public QQAppInterface k;
  public AppInterface l;
  private volatile boolean m;
  private LinearGroup n = null;
  private LinkedList<LinearGroup> o = new LinkedList();
  private HashMap<Integer, CheckUpdateItemInterface> q = new LinkedHashMap();
  
  public Automator(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.k = paramQQAppInterface;
    this.l = paramQQAppInterface;
  }
  
  private void a(LinearGroup paramLinearGroup)
  {
    boolean bool3 = StepFactory.d.equals(paramLinearGroup.mName);
    boolean bool1 = true;
    boolean bool2 = true;
    Object localObject;
    if (bool3)
    {
      this.o.clear();
    }
    else
    {
      AsyncStep localAsyncStep;
      if ((!"{[13,16],19,118,21,58,60,89,23,46,33,120,61,42,92,96,97,99}".equals(paramLinearGroup.mName)) && (!"{15,18,118,21,58,60,24}".equals(paramLinearGroup.mName)))
      {
        if (StepFactory.e.equals(paramLinearGroup.mName))
        {
          localObject = this.o.iterator();
          for (;;)
          {
            bool1 = bool2;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localAsyncStep = (AsyncStep)((Iterator)localObject).next();
            if (StepFactory.d.equals(localAsyncStep.mName)) {
              bool2 = false;
            }
          }
        }
      }
      else if (this.n != null)
      {
        bool1 = i();
        localObject = this.o.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localAsyncStep = (AsyncStep)((Iterator)localObject).next();
          if ((StepFactory.d.equals(localAsyncStep.mName)) || (localAsyncStep.mName.equals(paramLinearGroup.mName))) {
            bool1 = false;
          }
        }
      }
    }
    if (bool1) {
      this.o.add(paramLinearGroup);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addWaitingMode_Locked ");
      ((StringBuilder)localObject).append(paramLinearGroup.mName);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(bool1);
      QLog.d("QQInitHandler", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public CheckUpdateItemInterface a(int paramInt)
  {
    return (CheckUpdateItemInterface)this.q.get(Integer.valueOf(paramInt));
  }
  
  public HashMap<Integer, CheckUpdateItemInterface> a()
  {
    return this.q;
  }
  
  public void a(int paramInt, CheckUpdateItemInterface paramCheckUpdateItemInterface)
  {
    this.q.put(Integer.valueOf(paramInt), paramCheckUpdateItemInterface);
  }
  
  @TargetApi(9)
  public void a(AsyncStep arg1)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("start ");
      ((StringBuilder)localObject1).append(???.mName);
      QLog.d("QQInitHandler", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = (LinearGroup)???;
    synchronized (this.o)
    {
      if (this.n == null)
      {
        this.n = ((LinearGroup)localObject1);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("run ");
          localStringBuilder.append(((LinearGroup)localObject1).mName);
          QLog.d("QQInitHandler", 2, localStringBuilder.toString());
        }
        if (p == null)
        {
          p = new ThreadPoolExecutor(3, 3, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(24), new Automator.MyThreadFactory(null));
          if (Build.VERSION.SDK_INT > 8) {
            p.allowCoreThreadTimeOut(true);
          }
        }
        p.execute(this);
      }
      else
      {
        a((LinearGroup)localObject1);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    Object localObject = this.d;
    boolean bool = false;
    if ((localObject != null) && (paramBoolean1)) {
      ((SharedPreferences)localObject).edit().putBoolean("isFriendlistok", false).commit();
    }
    if (paramLong != 0L) {
      this.appRuntime.getPreferences().edit().putLong(Constants.Key.SvcRegister_timeStamp.toString(), paramLong).commit();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshAllList isListChanged=");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(",timeStamp=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(",accInfoPref!=null ");
      if (this.d != null) {
        bool = true;
      }
      ((StringBuilder)localObject).append(bool);
      QLog.d("QQInitHandler", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramBoolean1) || (paramBoolean2))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("{");
      int i1;
      if (paramBoolean1) {
        i1 = 7;
      } else {
        i1 = 8;
      }
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append("}");
      a(StepFactory.a(this, ((StringBuilder)localObject).toString()));
    }
  }
  
  public void a(AsyncStep[] paramArrayOfAsyncStep)
  {
    int i1;
    label100:
    synchronized (this.i)
    {
      this.h -= 1;
      if (this.i.size() > 0)
      {
        if (paramArrayOfAsyncStep != null)
        {
          int i2 = paramArrayOfAsyncStep.length;
          i1 = 0;
          if (i1 < i2)
          {
            AsyncStep localAsyncStep = paramArrayOfAsyncStep[i1];
            if (!this.i.remove(localAsyncStep)) {
              break label100;
            }
            b(localAsyncStep);
            return;
          }
        }
        b((AsyncStep)this.i.poll());
      }
      else
      {
        return;
      }
    }
  }
  
  public void b()
  {
    notifyUI(0, true, null);
  }
  
  @TargetApi(9)
  public void b(AsyncStep paramAsyncStep)
  {
    synchronized (this.i)
    {
      if (this.h < 3)
      {
        this.h += 1;
        if (p == null)
        {
          p = new ThreadPoolExecutor(3, 3, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(24), new Automator.MyThreadFactory(null));
          if (Build.VERSION.SDK_INT > 8) {
            p.allowCoreThreadTimeOut(true);
          }
        }
        p.execute(paramAsyncStep);
      }
      else
      {
        this.i.add(paramAsyncStep);
      }
      return;
    }
  }
  
  public void c()
  {
    if (!this.m) {
      return;
    }
    boolean bool1 = true;
    boolean bool2 = true;
    if (this.n != null)
    {
      LinkedList localLinkedList = this.o;
      bool1 = bool2;
      try
      {
        if (this.n != null)
        {
          this.n.setResult(4);
          bool1 = i();
        }
      }
      finally {}
    }
    if (bool1) {
      a(StepFactory.a(this, "{[13,16],19,118,21,58,60,89,23,46,33,120,61,42,92,96,97,99}"));
    }
  }
  
  public void d()
  {
    a(StepFactory.a(this, "{15,18,118,21,58,60,24}"));
  }
  
  public boolean e()
  {
    if (!StartService.a) {
      return false;
    }
    LinearGroup localLinearGroup = this.n;
    if (localLinearGroup != null) {
      return StepFactory.a(localLinearGroup);
    }
    return true;
  }
  
  public int f()
  {
    LinearGroup localLinearGroup = this.n;
    if (localLinearGroup != null) {
      return StepFactory.a(localLinearGroup, false);
    }
    if (this.m) {
      return 1;
    }
    return -1;
  }
  
  public boolean g()
  {
    LinearGroup localLinearGroup = this.n;
    if (localLinearGroup != null) {
      return StepFactory.a(localLinearGroup, true) == 0;
    }
    return this.m ^ true;
  }
  
  public boolean h()
  {
    LinearGroup localLinearGroup = this.n;
    if (localLinearGroup != null) {
      return StepFactory.b(localLinearGroup);
    }
    return true;
  }
  
  public boolean i()
  {
    LinearGroup localLinearGroup = this.n;
    if (localLinearGroup != null) {
      return StepFactory.c(localLinearGroup);
    }
    return true;
  }
  
  public boolean j()
  {
    LinearGroup localLinearGroup = this.n;
    if (localLinearGroup != null) {
      return StepFactory.d(localLinearGroup);
    }
    return true;
  }
  
  public void k()
  {
    notifyUI(4, true, null);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return AutomatorObserver.class;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "onDestroy");
    }
    synchronized (this.i)
    {
      this.i.clear();
      this.h = 0;
      synchronized (this.o)
      {
        this.o.clear();
        if (this.n != null)
        {
          this.n.setResult(8);
          this.n = null;
        }
        this.a = 0L;
        return;
      }
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    new RuntimeException("WTF");
  }
  
  public void run()
  {
    if (!this.m)
    {
      int i1 = 0;
      synchronized (this.o)
      {
        if (!this.m)
        {
          i1 = 1;
          this.m = true;
        }
        if (i1 != 0) {
          StepFactory.a(this, "2").run();
        }
      }
    }
    for (;;)
    {
      ??? = this.n;
      if (??? != null) {
        ((AsyncStep)???).run();
      }
      synchronized (this.o)
      {
        this.n = ((LinearGroup)this.o.poll());
        if (this.n == null) {
          return;
        }
      }
    }
    for (;;)
    {
      throw localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.Automator
 * JD-Core Version:    0.7.0.1
 */