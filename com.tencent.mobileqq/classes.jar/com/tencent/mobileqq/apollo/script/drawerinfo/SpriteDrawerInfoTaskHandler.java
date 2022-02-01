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
  private static int jdField_a_of_type_Int;
  private SpriteContext jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
  private CopyOnWriteArrayList<SpriteTaskParam> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private int jdField_b_of_type_Int = 0;
  private CopyOnWriteArrayList<ISpriteTaskStatusCallback> jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  
  public SpriteDrawerInfoTaskHandler(SpriteContext paramSpriteContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteDrawerInfoTaskHandler", 2, "SpriteTaskHandler constructor.");
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext = paramSpriteContext;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  }
  
  private SpriteTaskParam a(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    if (localObject != null)
    {
      if (((CopyOnWriteArrayList)localObject).size() == 0) {
        return null;
      }
      localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)((Iterator)localObject).next();
        if (localSpriteTaskParam.jdField_a_of_type_Long == paramLong) {
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
  
  public SpriteTaskParam a()
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    if ((localCopyOnWriteArrayList != null) && (localCopyOnWriteArrayList.size() != 0)) {
      return (SpriteTaskParam)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(0);
    }
    return null;
  }
  
  public SpriteTaskParam a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    if (localObject != null)
    {
      if (((CopyOnWriteArrayList)localObject).size() == 0) {
        return null;
      }
      localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)((Iterator)localObject).next();
        if (localSpriteTaskParam.jdField_a_of_type_Int == paramInt) {
          return localSpriteTaskParam;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow][scripted]SpriteDrawerInfoTaskHandler", 2, "[findTask], task NOT found in queue");
      }
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteDrawerInfoTaskHandler", 2, "[clear]");
    }
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    if (localObject != null) {
      ((CopyOnWriteArrayList)localObject).clear();
    }
    localObject = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    if (localObject != null) {
      ((CopyOnWriteArrayList)localObject).clear();
    }
    if (this.jdField_b_of_type_Int > 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
      if (localObject != null) {
        VipUtils.a(((SpriteContext)localObject).a(), "cmshow", "Apollo", "play_times", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int), 0, new String[] { Integer.toString(this.jdField_b_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_JavaLangString });
      }
    }
    this.jdField_b_of_type_Int = 0;
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    if ((localObject != null) && (((CopyOnWriteArrayList)localObject).size() != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow][scripted]SpriteDrawerInfoTaskHandler", 2, new Object[] { "[removeTask], total task num:", Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size()), ",taskId:", Integer.valueOf(paramInt) });
      }
      localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)((Iterator)localObject).next();
        if (localSpriteTaskParam.jdField_a_of_type_Int == paramInt)
        {
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localSpriteTaskParam);
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
  
  public void a(ISpriteTaskStatusCallback paramISpriteTaskStatusCallback)
  {
    if (paramISpriteTaskStatusCallback != null)
    {
      CopyOnWriteArrayList localCopyOnWriteArrayList = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
      if (localCopyOnWriteArrayList != null)
      {
        if (localCopyOnWriteArrayList.contains(paramISpriteTaskStatusCallback))
        {
          QLog.w("[cmshow][scripted]SpriteDrawerInfoTaskHandler", 1, "[addActionCallback], repeat callback.");
          return;
        }
        this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramISpriteTaskStatusCallback);
      }
    }
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam)
  {
    if (paramSpriteTaskParam != null)
    {
      CopyOnWriteArrayList localCopyOnWriteArrayList = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
      if ((localCopyOnWriteArrayList != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext != null))
      {
        paramSpriteTaskParam.jdField_b_of_type_Int = 1;
        int i = jdField_a_of_type_Int + 1;
        jdField_a_of_type_Int = i;
        paramSpriteTaskParam.jdField_a_of_type_Int = i;
        localCopyOnWriteArrayList.add(0, paramSpriteTaskParam);
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow][scripted]SpriteDrawerInfoTaskHandler", 2, new Object[] { "[addTask], size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size()), ",taskId:", Integer.valueOf(paramSpriteTaskParam.jdField_a_of_type_Int) });
        }
        a(null);
        return;
      }
    }
    QLog.w("[cmshow][scripted]SpriteDrawerInfoTaskHandler", 1, "[addTask], fail. null param");
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
    paramString.jdField_b_of_type_Int = 3;
    Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      ISpriteTaskStatusCallback localISpriteTaskStatusCallback = (ISpriteTaskStatusCallback)localIterator.next();
      if (localISpriteTaskStatusCallback != null) {
        localISpriteTaskStatusCallback.a(paramString, paramString.jdField_a_of_type_Long);
      }
    }
    this.jdField_b_of_type_Int += 1;
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
    paramString.jdField_b_of_type_Int = 6;
    Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      ISpriteTaskStatusCallback localISpriteTaskStatusCallback = (ISpriteTaskStatusCallback)localIterator.next();
      if (localISpriteTaskStatusCallback != null) {
        localISpriteTaskStatusCallback.a(paramString, paramString.jdField_a_of_type_Long, paramInt2);
      }
    }
    a(paramInt1);
  }
  
  public boolean a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    if (localObject != null)
    {
      if (((CopyOnWriteArrayList)localObject).size() == 0) {
        return false;
      }
      localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)((Iterator)localObject).next();
        if ((localSpriteTaskParam != null) && (localSpriteTaskParam.jdField_b_of_type_Int == 3)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean a(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      if (((CopyOnWriteArrayList)localObject).size() == 0) {
        return false;
      }
      localObject = a(paramLong);
      if (localObject == null) {
        return false;
      }
      bool1 = bool2;
      if (((SpriteTaskParam)localObject).jdField_b_of_type_Int == 3) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean a(SpriteTaskParam paramSpriteTaskParam)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
    if ((localObject != null) && (((SpriteContext)localObject).c()))
    {
      localObject = paramSpriteTaskParam;
      if (paramSpriteTaskParam == null) {
        localObject = a();
      }
      if (localObject != null)
      {
        if (((SpriteTaskParam)localObject).jdField_b_of_type_Int == 2) {
          return false;
        }
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow][scripted]SpriteDrawerInfoTaskHandler", 2, new Object[] { "[execSpriteTask], taskId:", Integer.valueOf(((SpriteTaskParam)localObject).jdField_a_of_type_Int), ",actionId:", Integer.valueOf(((SpriteTaskParam)localObject).f) });
        }
        if (((SpriteTaskParam)localObject).jdField_a_of_type_ComTencentMobileqqApolloScriptISpriteBridge != null) {
          ((SpriteTaskParam)localObject).jdField_a_of_type_ComTencentMobileqqApolloScriptISpriteBridge.a((SpriteTaskParam)localObject);
        }
        return true;
      }
      return false;
    }
    QLog.w("[cmshow][scripted]SpriteDrawerInfoTaskHandler", 1, "surfaceview is NOT ready.");
    return false;
  }
  
  public int b()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.drawerinfo.SpriteDrawerInfoTaskHandler
 * JD-Core Version:    0.7.0.1
 */