package com.tencent.mobileqq.apollo.script;

import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.script.callback.ISpriteActionCallback;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import mqq.os.MqqHandler;

public class SpriteTaskHandler
  implements ISpriteTaskHandler, ISpriteActionCallback
{
  public static volatile int a;
  private CopyOnWriteArrayList<SpriteTaskParam> b;
  private BlockingDeque<SpriteTaskParam> c;
  private ISpriteUIHandler d;
  private SpriteContext e;
  private CopyOnWriteArrayList<ISpriteTaskStatusCallback> f;
  private int g = 0;
  private long h = 0L;
  private Map<Integer, Long> i = new HashMap();
  private Runnable j = new SpriteTaskHandler.1(this);
  
  public SpriteTaskHandler(SpriteContext paramSpriteContext, @NonNull ISpriteUIHandler paramISpriteUIHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteTaskHandler", 2, "SpriteTaskHandler constructor.");
    }
    this.e = paramSpriteContext;
    this.d = paramISpriteUIHandler;
    this.b = new CopyOnWriteArrayList();
    this.c = new LinkedBlockingDeque(50);
    a = 0;
    this.f = new CopyOnWriteArrayList();
  }
  
  private SpriteTaskParam a(long paramLong, int paramInt)
  {
    if (this.b.size() == 0) {
      return null;
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)localIterator.next();
      if ((localSpriteTaskParam != null) && (localSpriteTaskParam.h == paramLong) && (paramInt == 2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow][scripted]SpriteTaskHandler", 2, new Object[] { "[stopTask], msgId:", Long.valueOf(paramLong), ",taskId:", Integer.valueOf(localSpriteTaskParam.a) });
        }
        return localSpriteTaskParam;
      }
    }
    return null;
  }
  
  private SpriteTaskParam b(long paramLong)
  {
    if (this.b.size() == 0) {
      return null;
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)localIterator.next();
      if (localSpriteTaskParam.h == paramLong) {
        return localSpriteTaskParam;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteTaskHandler", 2, "[findTaskByTaskId], task NOT found in queue");
    }
    return null;
  }
  
  private boolean c(SpriteTaskParam paramSpriteTaskParam)
  {
    if (paramSpriteTaskParam == null) {
      return false;
    }
    if (this.b.size() == 0) {
      return false;
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)localIterator.next();
      if ((localSpriteTaskParam != null) && (localSpriteTaskParam.h == paramSpriteTaskParam.h) && (localSpriteTaskParam.g != 2) && (localSpriteTaskParam.g != 3)) {
        return true;
      }
    }
    return false;
  }
  
  public int a()
  {
    return this.b.size();
  }
  
  public SpriteTaskParam a(int paramInt)
  {
    if (this.b.size() == 0) {
      return null;
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)localIterator.next();
      if (localSpriteTaskParam.a == paramInt) {
        return localSpriteTaskParam;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteTaskHandler", 2, "[findTask], task NOT found in queue");
    }
    return null;
  }
  
  public void a(ISpriteTaskStatusCallback paramISpriteTaskStatusCallback)
  {
    if (paramISpriteTaskStatusCallback != null)
    {
      if (this.f.contains(paramISpriteTaskStatusCallback))
      {
        QLog.w("[cmshow][scripted]SpriteTaskHandler", 1, "[addActionCallback], repeat callback.");
        return;
      }
      this.f.add(paramISpriteTaskStatusCallback);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteTaskHandler", 2, new Object[] { "[onStartAction], taskId:", Integer.valueOf(paramInt) });
    }
    paramString = a(paramInt);
    if (paramString == null)
    {
      paramString = new StringBuilder();
      paramString.append("onStartAction, found no task for taskId:");
      paramString.append(paramInt);
      paramString.append(" in container!!");
      QLog.e("[cmshow][scripted]SpriteTaskHandler", 1, paramString.toString());
      return;
    }
    paramString.b = 3;
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      ISpriteTaskStatusCallback localISpriteTaskStatusCallback = (ISpriteTaskStatusCallback)localIterator.next();
      if (localISpriteTaskStatusCallback != null) {
        localISpriteTaskStatusCallback.a(paramString, paramString.h);
      }
    }
    this.g += 1;
    this.i.put(Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()));
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean a(long paramLong)
  {
    int k = this.b.size();
    boolean bool = false;
    if (k == 0) {
      return false;
    }
    SpriteTaskParam localSpriteTaskParam = b(paramLong);
    if (localSpriteTaskParam == null) {
      return false;
    }
    if (localSpriteTaskParam.b == 3) {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(SpriteTaskParam paramSpriteTaskParam)
  {
    Object localObject = this.e;
    if ((localObject != null) && (((SpriteContext)localObject).c()))
    {
      localObject = paramSpriteTaskParam;
      if (paramSpriteTaskParam == null) {
        localObject = b();
      }
      if (localObject != null)
      {
        if (((SpriteTaskParam)localObject).b == 2) {
          return false;
        }
        if ((!this.e.x()) && (this.e.d())) {
          this.d.a(false, "none_apollo_play_action");
        }
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow][scripted]SpriteTaskHandler", 2, new Object[] { "[execSpriteTask], taskId:", Integer.valueOf(((SpriteTaskParam)localObject).a), ",actionId:", Integer.valueOf(((SpriteTaskParam)localObject).f) });
        }
        if (((SpriteTaskParam)localObject).u != null) {
          ((SpriteTaskParam)localObject).u.a((SpriteTaskParam)localObject);
        }
        return true;
      }
      return false;
    }
    QLog.w("[cmshow][scripted]SpriteTaskHandler", 1, "surfaceview is NOT ready.");
    return false;
  }
  
  public SpriteTaskParam b()
  {
    if (this.b.size() == 0) {
      return null;
    }
    return (SpriteTaskParam)this.b.get(0);
  }
  
  public void b(int paramInt)
  {
    if (this.b.size() == 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[removeTask], fail. NO task. taskId:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.w("[cmshow][scripted]SpriteTaskHandler", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteTaskHandler", 2, new Object[] { "[removeTask], total task num:", Integer.valueOf(this.b.size()), ",taskId:", Integer.valueOf(paramInt) });
    }
    Object localObject = this.b.iterator();
    while (((Iterator)localObject).hasNext())
    {
      SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)((Iterator)localObject).next();
      if (localSpriteTaskParam.a == paramInt)
      {
        this.b.remove(localSpriteTaskParam);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteTaskHandler", 2, "[removeTask], task NOT found in queue");
    }
  }
  
  public void b(SpriteTaskParam paramSpriteTaskParam)
  {
    if (paramSpriteTaskParam != null)
    {
      Object localObject1 = this.e;
      if (localObject1 != null)
      {
        boolean bool = ((SpriteContext)localObject1).a();
        localObject1 = "1";
        Object localObject3;
        if ((bool) && (paramSpriteTaskParam.g != 1))
        {
          this.b.add(0, paramSpriteTaskParam);
          this.d.a(false, true, null);
          localObject2 = this.e.l();
          localObject3 = Integer.toString(((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(this.e.a));
          if (paramSpriteTaskParam.g != 2) {
            localObject1 = "2";
          }
          VipUtils.a((AppInterface)localObject2, "cmshow", "Apollo", "aio_double_show_clk", 0, 0, new String[] { localObject3, localObject1 });
          return;
        }
        if ((!this.e.x()) && (this.e.d()) && (!this.e.c()))
        {
          this.b.add(0, paramSpriteTaskParam);
          this.d.a(false, false, "none_apollo_play_action");
          return;
        }
        if (c(paramSpriteTaskParam))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[addTask], same task. discard it. ");
          ((StringBuilder)localObject1).append(paramSpriteTaskParam);
          QLog.w("[cmshow][scripted]SpriteTaskHandler", 1, ((StringBuilder)localObject1).toString());
          return;
        }
        Object localObject2 = a(paramSpriteTaskParam.h, paramSpriteTaskParam.g);
        int k;
        if (localObject2 == null)
        {
          this.c.offerLast(paramSpriteTaskParam);
          long l = System.currentTimeMillis();
          if ((l - this.h <= 500L) && (c()))
          {
            ThreadManager.getSubThreadHandler().removeCallbacks(this.j);
            ThreadManager.getSubThreadHandler().postDelayed(this.j, 500L);
            return;
          }
          paramSpriteTaskParam = (SpriteTaskParam)this.c.pollLast();
          this.c.clear();
          this.h = l;
          if (paramSpriteTaskParam == null)
          {
            QLog.e("[cmshow][scripted]SpriteTaskHandler", 1, "[addTask] poll task from deque failed");
            return;
          }
          paramSpriteTaskParam.b = 1;
          k = a + 1;
          a = k;
          paramSpriteTaskParam.a = k;
          this.b.add(0, paramSpriteTaskParam);
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow][scripted]SpriteTaskHandler", 2, new Object[] { "[addTask], size:", Integer.valueOf(this.b.size()), ",taskId:", Integer.valueOf(paramSpriteTaskParam.a) });
          }
        }
        else
        {
          ((SpriteTaskParam)localObject2).b = 5;
          localObject3 = this.e.l();
          k = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(this.e.a);
          String str = Integer.toString(paramSpriteTaskParam.f);
          if (paramSpriteTaskParam.l) {
            localObject1 = "0";
          }
          VipUtils.a((AppInterface)localObject3, "cmshow", "Apollo", "msg_paly_stop", k, 0, new String[] { str, localObject1 });
        }
        a((SpriteTaskParam)localObject2);
        return;
      }
    }
    QLog.w("[cmshow][scripted]SpriteTaskHandler", 1, "[addTask], fail. null param");
  }
  
  public boolean c()
  {
    if (this.b.size() == 0) {
      return false;
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)localIterator.next();
      if ((localSpriteTaskParam != null) && (localSpriteTaskParam.b == 3)) {
        return true;
      }
    }
    return false;
  }
  
  public int d()
  {
    int k = a + 1;
    a = k;
    return k;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteTaskHandler", 2, "[clear]");
    }
    this.b.clear();
    this.f.clear();
    if (this.g > 0)
    {
      SpriteContext localSpriteContext = this.e;
      if (localSpriteContext != null) {
        VipUtils.a(localSpriteContext.l(), "cmshow", "Apollo", "play_times", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(this.e.a), 0, new String[] { Integer.toString(this.g), this.e.b });
      }
    }
    this.c.clear();
    this.g = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteTaskHandler
 * JD-Core Version:    0.7.0.1
 */