package com.tencent.mobileqq.apollo.game.process.data;

import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CmGameLifeCycleMgr
{
  private CopyOnWriteArrayList<CmGameLifeCycle> a = new CopyOnWriteArrayList();
  
  public CmGameLifeCycle a(int paramInt)
  {
    if (this.a == null) {
      return null;
    }
    Object localObject2 = b(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new CmGameLifeCycle(paramInt);
      this.a.add(0, localObject1);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[add] size of cycles:");
      ((StringBuilder)localObject2).append(this.a.size());
      QLog.i("cmgame_process.CmGameLifeCycleMgr", 1, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  public CmGameLifeCycle a(int paramInt1, int paramInt2)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return null;
    }
    localObject = ((CopyOnWriteArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      CmGameLifeCycle localCmGameLifeCycle = (CmGameLifeCycle)((Iterator)localObject).next();
      if ((localCmGameLifeCycle != null) && (localCmGameLifeCycle.a() == paramInt1) && (localCmGameLifeCycle.b == paramInt2)) {
        return localCmGameLifeCycle;
      }
    }
    return null;
  }
  
  public void a()
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.a;
    if (localCopyOnWriteArrayList == null) {
      return;
    }
    localCopyOnWriteArrayList.clear();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, StartCheckParam paramStartCheckParam)
  {
    Object localObject2 = b(paramInt1);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (paramInt2 == 1)
      {
        localObject2 = a(paramInt1);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (paramStartCheckParam != null)
          {
            ((CmGameLifeCycle)localObject2).b = paramInt3;
            if (BaseActivity.sTopActivity != null) {
              ((CmGameLifeCycle)localObject2).a(BaseActivity.sTopActivity, paramStartCheckParam);
            } else {
              QLog.e("cmgame_process.CmGameLifeCycleMgr", 1, "[handleActLifeCycle] context is null");
            }
            localObject1 = localObject2;
            if (QLog.isColorLevel())
            {
              QLog.d("cmgame_process.CmGameLifeCycleMgr", 2, "[handleActLifeCycle] rebuild game");
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    if (paramInt2 == 1)
    {
      if (localObject1 != null)
      {
        if (((CmGameLifeCycle)localObject1).b == 0)
        {
          ((CmGameLifeCycle)localObject1).b = paramInt3;
          localObject2 = localObject1;
        }
        else
        {
          localObject2 = localObject1;
          if (((CmGameLifeCycle)localObject1).b != paramInt3)
          {
            ((CmGameLifeCycle)localObject1).a(paramInt1, 5);
            localObject2 = this.a;
            if (localObject2 != null) {
              ((CopyOnWriteArrayList)localObject2).remove(localObject1);
            }
            QLog.e("cmgame_process.CmGameLifeCycleMgr", 1, "handleActLifeCycle remove last same gameId activity");
            localObject2 = new CmGameLifeCycle(paramInt1);
            ((CmGameLifeCycle)localObject2).b = paramInt3;
            if ((BaseActivity.sTopActivity != null) && (paramStartCheckParam != null)) {
              ((CmGameLifeCycle)localObject2).a(BaseActivity.sTopActivity, paramStartCheckParam);
            }
            this.a.add(0, localObject2);
            paramStartCheckParam = new StringBuilder();
            paramStartCheckParam.append("handleActLifeCycle [add] size of cycles:");
            paramStartCheckParam.append(this.a.size());
            QLog.i("cmgame_process.CmGameLifeCycleMgr", 1, paramStartCheckParam.toString());
          }
        }
        ((CmGameLifeCycle)localObject2).a(paramInt1, paramInt2);
      }
    }
    else
    {
      if (paramInt2 == 5)
      {
        paramStartCheckParam = a(paramInt1, paramInt3);
        if (paramStartCheckParam == null)
        {
          QLog.e("cmgame_process.CmGameLifeCycleMgr", 1, "findLifeCycleByActivityId not found ON_DESTROY");
          return;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("findLifeCycleByActivityId found ON_DESTROY lifeCycle:");
          ((StringBuilder)localObject1).append(paramStartCheckParam);
          QLog.d("cmgame_process.CmGameLifeCycleMgr", 2, ((StringBuilder)localObject1).toString());
        }
        paramStartCheckParam.a(paramInt1, paramInt2);
        localObject1 = this.a;
        if (localObject1 != null) {
          ((CopyOnWriteArrayList)localObject1).remove(paramStartCheckParam);
        }
        paramStartCheckParam = new StringBuilder();
        paramStartCheckParam.append("[remove], size of cycles:");
        paramStartCheckParam.append(this.a.size());
        QLog.i("cmgame_process.CmGameLifeCycleMgr", 1, paramStartCheckParam.toString());
        return;
      }
      if (localObject1 != null) {
        ((CmGameLifeCycle)localObject1).a(paramInt1, paramInt2);
      }
    }
  }
  
  public CmGameLifeCycle b(int paramInt)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return null;
    }
    localObject = ((CopyOnWriteArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      CmGameLifeCycle localCmGameLifeCycle = (CmGameLifeCycle)((Iterator)localObject).next();
      if ((localCmGameLifeCycle != null) && (localCmGameLifeCycle.a() == paramInt)) {
        return localCmGameLifeCycle;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.data.CmGameLifeCycleMgr
 * JD-Core Version:    0.7.0.1
 */