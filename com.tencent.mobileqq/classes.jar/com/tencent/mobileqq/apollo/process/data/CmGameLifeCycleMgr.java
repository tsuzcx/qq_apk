package com.tencent.mobileqq.apollo.process.data;

import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CmGameLifeCycleMgr
{
  private int jdField_a_of_type_Int = -1;
  private CopyOnWriteArrayList jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public CmGameLifeCycle a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) {
      localObject = null;
    }
    CmGameLifeCycle localCmGameLifeCycle;
    do
    {
      return localObject;
      localCmGameLifeCycle = b(paramInt);
      localObject = localCmGameLifeCycle;
    } while (localCmGameLifeCycle != null);
    Object localObject = new CmGameLifeCycle(paramInt);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject);
    QLog.i("cmgame_process.CmGameLifeCycleMgr", 1, "[add] size of cycles:" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
    return localObject;
  }
  
  public void a(int paramInt)
  {
    if (CmGameUtil.a(paramInt)) {}
    CmGameLifeCycle localCmGameLifeCycle;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null);
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 1)
      {
        QLog.i("cmgame_process.CmGameLifeCycleMgr", 1, "curGame:" + paramInt);
        this.jdField_a_of_type_Int = paramInt;
        return;
      }
      localCmGameLifeCycle = b(paramInt);
    } while ((localCmGameLifeCycle == null) || (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localCmGameLifeCycle)));
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, localCmGameLifeCycle);
    QLog.i("cmgame_process.CmGameLifeCycleMgr", 1, "curGame:" + paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    CmGameLifeCycle localCmGameLifeCycle2 = b(paramInt1);
    CmGameLifeCycle localCmGameLifeCycle1 = localCmGameLifeCycle2;
    if (localCmGameLifeCycle2 == null)
    {
      localCmGameLifeCycle1 = localCmGameLifeCycle2;
      if (paramInt2 == 1)
      {
        localCmGameLifeCycle2 = a(paramInt1);
        localCmGameLifeCycle1 = localCmGameLifeCycle2;
        if (localCmGameLifeCycle2 != null)
        {
          localCmGameLifeCycle1 = localCmGameLifeCycle2;
          if (paramStartCheckParam != null)
          {
            if (BaseActivity.sTopActivity == null) {
              break label109;
            }
            localCmGameLifeCycle2.a(BaseActivity.sTopActivity, paramStartCheckParam);
            localCmGameLifeCycle1 = localCmGameLifeCycle2;
            if (QLog.isColorLevel())
            {
              QLog.d("cmgame_process.CmGameLifeCycleMgr", 2, "[handleActLifeCycle] rebuild game");
              localCmGameLifeCycle1 = localCmGameLifeCycle2;
            }
          }
        }
      }
    }
    if (localCmGameLifeCycle1 != null)
    {
      localCmGameLifeCycle1.a(paramInt1, paramInt2);
      if (paramInt2 != 2) {
        break label120;
      }
      a(paramInt1);
    }
    label109:
    label120:
    while (paramInt2 != 4)
    {
      return;
      QLog.e("cmgame_process.CmGameLifeCycleMgr", 1, "[handleActLifeCycle] context is null");
      break;
    }
    b(paramInt1);
  }
  
  public CmGameLifeCycle b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      CmGameLifeCycle localCmGameLifeCycle = (CmGameLifeCycle)localIterator.next();
      if ((localCmGameLifeCycle != null) && (localCmGameLifeCycle.a() == paramInt)) {
        return localCmGameLifeCycle;
      }
    }
    return null;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) {}
    CmGameLifeCycle localCmGameLifeCycle;
    do
    {
      return;
      localCmGameLifeCycle = b(paramInt);
    } while (localCmGameLifeCycle == null);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localCmGameLifeCycle);
    if (!CmGameUtil.a(paramInt)) {
      this.jdField_a_of_type_Int = -1;
    }
    QLog.i("cmgame_process.CmGameLifeCycleMgr", 1, "[remove], size of cycles:" + this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameLifeCycleMgr
 * JD-Core Version:    0.7.0.1
 */