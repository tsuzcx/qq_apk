package com.tencent.mobileqq.apollo.script.drawerinfo;

import com.tencent.mobileqq.apollo.script.ISpriteBridge;
import com.tencent.mobileqq.apollo.script.ISpriteTaskHandler;
import com.tencent.mobileqq.apollo.script.ISpriteTaskStatusCallback;
import com.tencent.mobileqq.apollo.script.SpriteContext;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.script.callback.ISpriteActionCallback;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class SpriteDrawerInfoTaskHandler
  implements ISpriteTaskHandler, ISpriteActionCallback
{
  private static int b;
  private CopyOnWriteArrayList<SpriteTaskParam> a;
  private SpriteContext c;
  private CopyOnWriteArrayList<ISpriteTaskStatusCallback> d;
  private int e = 0;
  
  public SpriteDrawerInfoTaskHandler(SpriteContext paramSpriteContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteDrawerInfoTaskHandler", 2, "SpriteTaskHandler constructor.");
    }
    this.c = paramSpriteContext;
    this.a = new CopyOnWriteArrayList();
    b = 0;
    this.d = new CopyOnWriteArrayList();
  }
  
  private SpriteTaskParam b(long paramLong)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((CopyOnWriteArrayList)localObject).size() == 0) {
        return null;
      }
      localObject = this.a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)((Iterator)localObject).next();
        if (localSpriteTaskParam.h == paramLong) {
          return localSpriteTaskParam;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow][scripted]SpriteDrawerInfoTaskHandler", 2, "[findTaskByTaskId], task NOT found in queue");
      }
    }
    return null;
  }
  
  public int a()
  {
    return 0;
  }
  
  public SpriteTaskParam a(int paramInt)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((CopyOnWriteArrayList)localObject).size() == 0) {
        return null;
      }
      localObject = this.a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)((Iterator)localObject).next();
        if (localSpriteTaskParam.a == paramInt) {
          return localSpriteTaskParam;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow][scripted]SpriteDrawerInfoTaskHandler", 2, "[findTask], task NOT found in queue");
      }
    }
    return null;
  }
  
  public void a(ISpriteTaskStatusCallback paramISpriteTaskStatusCallback)
  {
    if (paramISpriteTaskStatusCallback != null)
    {
      CopyOnWriteArrayList localCopyOnWriteArrayList = this.d;
      if (localCopyOnWriteArrayList != null)
      {
        if (localCopyOnWriteArrayList.contains(paramISpriteTaskStatusCallback))
        {
          QLog.w("[cmshow][scripted]SpriteDrawerInfoTaskHandler", 1, "[addActionCallback], repeat callback.");
          return;
        }
        this.d.add(paramISpriteTaskStatusCallback);
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteDrawerInfoTaskHandler", 2, new Object[] { "[onStartAction], taskId:", Integer.valueOf(paramInt) });
    }
    paramString = a(paramInt);
    if (paramString == null) {
      return;
    }
    paramString.b = 3;
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      ISpriteTaskStatusCallback localISpriteTaskStatusCallback = (ISpriteTaskStatusCallback)localIterator.next();
      if (localISpriteTaskStatusCallback != null) {
        localISpriteTaskStatusCallback.a(paramString, paramString.h);
      }
    }
    this.e += 1;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteDrawerInfoTaskHandler", 2, new Object[] { "[onCompleteAction], taskId:", Integer.valueOf(paramInt1), ",type:", Integer.valueOf(paramInt2) });
    }
    paramString = a(paramInt1);
    if (paramString == null) {
      return;
    }
    paramString.b = 6;
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      ISpriteTaskStatusCallback localISpriteTaskStatusCallback = (ISpriteTaskStatusCallback)localIterator.next();
      if (localISpriteTaskStatusCallback != null) {
        localISpriteTaskStatusCallback.a(paramString, paramString.h, paramInt2);
      }
    }
    b(paramInt1);
  }
  
  public boolean a(long paramLong)
  {
    Object localObject = this.a;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      if (((CopyOnWriteArrayList)localObject).size() == 0) {
        return false;
      }
      localObject = b(paramLong);
      if (localObject == null) {
        return false;
      }
      bool1 = bool2;
      if (((SpriteTaskParam)localObject).b == 3) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean a(SpriteTaskParam paramSpriteTaskParam)
  {
    Object localObject = this.c;
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
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow][scripted]SpriteDrawerInfoTaskHandler", 2, new Object[] { "[execSpriteTask], taskId:", Integer.valueOf(((SpriteTaskParam)localObject).a), ",actionId:", Integer.valueOf(((SpriteTaskParam)localObject).f) });
        }
        if (((SpriteTaskParam)localObject).u != null) {
          ((SpriteTaskParam)localObject).u.a((SpriteTaskParam)localObject);
        }
        return true;
      }
      return false;
    }
    QLog.w("[cmshow][scripted]SpriteDrawerInfoTaskHandler", 1, "surfaceview is NOT ready.");
    return false;
  }
  
  public SpriteTaskParam b()
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.a;
    if ((localCopyOnWriteArrayList != null) && (localCopyOnWriteArrayList.size() != 0)) {
      return (SpriteTaskParam)this.a.get(0);
    }
    return null;
  }
  
  public void b(int paramInt)
  {
    Object localObject = this.a;
    if ((localObject != null) && (((CopyOnWriteArrayList)localObject).size() != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow][scripted]SpriteDrawerInfoTaskHandler", 2, new Object[] { "[removeTask], total task num:", Integer.valueOf(this.a.size()), ",taskId:", Integer.valueOf(paramInt) });
      }
      localObject = this.a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)((Iterator)localObject).next();
        if (localSpriteTaskParam.a == paramInt)
        {
          this.a.remove(localSpriteTaskParam);
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow][scripted]SpriteDrawerInfoTaskHandler", 2, "[removeTask], task NOT found in queue");
      }
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[removeTask], fail. NO task. taskId:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.w("[cmshow][scripted]SpriteDrawerInfoTaskHandler", 1, ((StringBuilder)localObject).toString());
  }
  
  public void b(SpriteTaskParam paramSpriteTaskParam)
  {
    if (paramSpriteTaskParam != null)
    {
      CopyOnWriteArrayList localCopyOnWriteArrayList = this.a;
      if ((localCopyOnWriteArrayList != null) && (this.c != null))
      {
        paramSpriteTaskParam.b = 1;
        int i = b + 1;
        b = i;
        paramSpriteTaskParam.a = i;
        localCopyOnWriteArrayList.add(0, paramSpriteTaskParam);
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow][scripted]SpriteDrawerInfoTaskHandler", 2, new Object[] { "[addTask], size:", Integer.valueOf(this.a.size()), ",taskId:", Integer.valueOf(paramSpriteTaskParam.a) });
        }
        a(null);
        return;
      }
    }
    QLog.w("[cmshow][scripted]SpriteDrawerInfoTaskHandler", 1, "[addTask], fail. null param");
  }
  
  public boolean c()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((CopyOnWriteArrayList)localObject).size() == 0) {
        return false;
      }
      localObject = this.a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)((Iterator)localObject).next();
        if ((localSpriteTaskParam != null) && (localSpriteTaskParam.b == 3)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public int d()
  {
    return 0;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteDrawerInfoTaskHandler", 2, "[clear]");
    }
    Object localObject = this.a;
    if (localObject != null) {
      ((CopyOnWriteArrayList)localObject).clear();
    }
    localObject = this.d;
    if (localObject != null) {
      ((CopyOnWriteArrayList)localObject).clear();
    }
    if (this.e > 0)
    {
      localObject = this.c;
      if (localObject != null) {
        VipUtils.a(((SpriteContext)localObject).l(), "cmshow", "Apollo", "play_times", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(this.c.a), 0, new String[] { Integer.toString(this.e), this.c.b });
      }
    }
    this.e = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.drawerinfo.SpriteDrawerInfoTaskHandler
 * JD-Core Version:    0.7.0.1
 */