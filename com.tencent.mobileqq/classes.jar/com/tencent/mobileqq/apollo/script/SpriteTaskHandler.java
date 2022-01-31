package com.tencent.mobileqq.apollo.script;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.script.callback.ISpriteActionCallback;
import com.tencent.mobileqq.apollo.script.callback.ISpriteBridgeInterface;
import com.tencent.mobileqq.apollo.script.callback.ISpriteTaskInterface;
import com.tencent.mobileqq.apollo.script.callback.ISpriteTaskStatusCallback;
import com.tencent.mobileqq.apollo.script.callback.ISpriteUICallback;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class SpriteTaskHandler
  implements ISpriteActionCallback, ISpriteTaskInterface
{
  private static int jdField_a_of_type_Int;
  private SpriteContext jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
  private ISpriteUICallback jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteUICallback;
  private CopyOnWriteArrayList jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private int jdField_b_of_type_Int;
  private CopyOnWriteArrayList jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  
  public SpriteTaskHandler(SpriteContext paramSpriteContext, ISpriteUICallback paramISpriteUICallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteTaskHandler", 2, "SpriteTaskHandler constructor.");
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext = paramSpriteContext;
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteUICallback = paramISpriteUICallback;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  }
  
  public SpriteTaskParam a()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      return null;
    }
    return (SpriteTaskParam)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(0);
  }
  
  public SpriteTaskParam a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)localIterator.next();
      if (localSpriteTaskParam.jdField_a_of_type_Int == paramInt) {
        return localSpriteTaskParam;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteTaskHandler", 2, "[findTask], task NOT found in queue");
    }
    return null;
  }
  
  public SpriteTaskParam a(long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)localIterator.next();
      if (localSpriteTaskParam.jdField_a_of_type_Long == paramLong) {
        return localSpriteTaskParam;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteTaskHandler", 2, "[findTaskByTaskId], task NOT found in queue");
    }
    return null;
  }
  
  public SpriteTaskParam a(long paramLong, int paramInt)
  {
    Object localObject;
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      localObject = null;
    }
    SpriteTaskParam localSpriteTaskParam;
    do
    {
      return localObject;
      localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localSpriteTaskParam = (SpriteTaskParam)((Iterator)localObject).next();
      } while ((localSpriteTaskParam == null) || (localSpriteTaskParam.jdField_a_of_type_Long != paramLong) || (paramInt != 2));
      localObject = localSpriteTaskParam;
    } while (!QLog.isColorLevel());
    QLog.d("cmshow_scripted_SpriteTaskHandler", 2, new Object[] { "[stopTask], msgId:", Long.valueOf(paramLong), ",taskId:", Integer.valueOf(localSpriteTaskParam.jdField_a_of_type_Int) });
    return localSpriteTaskParam;
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteTaskHandler", 2, "[clear]");
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) {
      this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    }
    if ((this.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext != null)) {
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), "cmshow", "Apollo", "play_times", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int), 0, new String[] { Integer.toString(this.jdField_b_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_JavaLangString });
    }
    this.jdField_b_of_type_Int = 0;
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      QLog.w("cmshow_scripted_SpriteTaskHandler", 1, "[removeTask], fail. NO task. taskId:" + paramInt);
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteTaskHandler", 2, new Object[] { "[removeTask], total task num:", Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size()), ",taskId:", Integer.valueOf(paramInt) });
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext())
      {
        SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)localIterator.next();
        if (localSpriteTaskParam.jdField_a_of_type_Int == paramInt)
        {
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(localSpriteTaskParam);
          return;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("cmshow_scripted_SpriteTaskHandler", 2, "[removeTask], task NOT found in queue");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteTaskHandler", 2, new Object[] { "[onCompleteAction], taskId:", Integer.valueOf(paramInt1), ",type:", Integer.valueOf(paramInt2) });
    }
    SpriteTaskParam localSpriteTaskParam = a(paramInt1);
    if (localSpriteTaskParam == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteUICallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteUICallback.a(localSpriteTaskParam, localSpriteTaskParam.jdField_a_of_type_Long, paramInt2);
    }
    localSpriteTaskParam.jdField_b_of_type_Int = 6;
    Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      ISpriteTaskStatusCallback localISpriteTaskStatusCallback = (ISpriteTaskStatusCallback)localIterator.next();
      if (localISpriteTaskStatusCallback != null) {
        localISpriteTaskStatusCallback.a(localSpriteTaskParam, localSpriteTaskParam.jdField_a_of_type_Long, paramInt2);
      }
    }
    a(paramInt1);
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam)
  {
    if ((paramSpriteTaskParam == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null)) {
      QLog.w("cmshow_scripted_SpriteTaskHandler", 1, "[addTask], fail. null param");
    }
    do
    {
      return;
      if ((1 == this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.c) && (paramSpriteTaskParam.g != 1))
      {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramSpriteTaskParam);
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteUICallback instanceof SpriteUIHandler)) {
          ((SpriteUIHandler)this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteUICallback).a(false, true, null);
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
        localObject2 = Integer.toString(ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int));
        if (paramSpriteTaskParam.g == 2) {}
        for (paramSpriteTaskParam = "1";; paramSpriteTaskParam = "2")
        {
          VipUtils.a((AppInterface)localObject1, "cmshow", "Apollo", "aio_double_show_clk", 0, 0, new String[] { localObject2, paramSpriteTaskParam });
          return;
        }
      }
      if (!a(paramSpriteTaskParam)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("cmshow_scripted_SpriteTaskHandler", 2, "[addTask], same task. discard it.");
    return;
    Object localObject1 = a(paramSpriteTaskParam.jdField_a_of_type_Long, paramSpriteTaskParam.g);
    if (localObject1 == null)
    {
      paramSpriteTaskParam.jdField_b_of_type_Int = 1;
      i = jdField_a_of_type_Int + 1;
      jdField_a_of_type_Int = i;
      paramSpriteTaskParam.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramSpriteTaskParam);
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteTaskHandler", 2, new Object[] { "[addTask], size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size()), ",taskId:", Integer.valueOf(paramSpriteTaskParam.jdField_a_of_type_Int) });
      }
      b((SpriteTaskParam)localObject1);
      return;
    }
    ((SpriteTaskParam)localObject1).jdField_b_of_type_Int = 5;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
    int i = ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int);
    String str = Integer.toString(paramSpriteTaskParam.f);
    if (paramSpriteTaskParam.jdField_a_of_type_Boolean) {}
    for (paramSpriteTaskParam = "0";; paramSpriteTaskParam = "1")
    {
      VipUtils.a((AppInterface)localObject2, "cmshow", "Apollo", "msg_paly_stop", i, 0, new String[] { str, paramSpriteTaskParam });
      break;
    }
  }
  
  public void a(ISpriteTaskStatusCallback paramISpriteTaskStatusCallback)
  {
    if ((paramISpriteTaskStatusCallback != null) && (this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null))
    {
      if (this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramISpriteTaskStatusCallback)) {
        QLog.w("cmshow_scripted_SpriteTaskHandler", 1, "[addActionCallback], repeat callback.");
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramISpriteTaskStatusCallback);
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)localIterator.next();
      if ((localSpriteTaskParam != null) && (localSpriteTaskParam.jdField_b_of_type_Int == 3)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {}
    SpriteTaskParam localSpriteTaskParam;
    do
    {
      return false;
      localSpriteTaskParam = a(paramLong);
    } while ((localSpriteTaskParam == null) || (localSpriteTaskParam.jdField_b_of_type_Int != 3));
    return true;
  }
  
  public boolean a(SpriteTaskParam paramSpriteTaskParam)
  {
    if (paramSpriteTaskParam == null) {
      return false;
    }
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)localIterator.next();
      if ((localSpriteTaskParam != null) && (localSpriteTaskParam.jdField_a_of_type_Long == paramSpriteTaskParam.jdField_a_of_type_Long) && (localSpriteTaskParam.g != 2) && (localSpriteTaskParam.g != 3)) {
        return true;
      }
    }
    return false;
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteTaskHandler", 2, new Object[] { "[onStartAction], taskId:", Integer.valueOf(paramInt) });
    }
    SpriteTaskParam localSpriteTaskParam = a(paramInt);
    if (localSpriteTaskParam == null) {
      return;
    }
    localSpriteTaskParam.jdField_b_of_type_Int = 3;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteUICallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteUICallback.a(localSpriteTaskParam, localSpriteTaskParam.jdField_a_of_type_Long);
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      ISpriteTaskStatusCallback localISpriteTaskStatusCallback = (ISpriteTaskStatusCallback)localIterator.next();
      if (localISpriteTaskStatusCallback != null) {
        localISpriteTaskStatusCallback.a(localSpriteTaskParam, localSpriteTaskParam.jdField_a_of_type_Long);
      }
    }
    this.jdField_b_of_type_Int += 1;
  }
  
  public boolean b(SpriteTaskParam paramSpriteTaskParam)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null) || (!this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.c()))
    {
      QLog.w("cmshow_scripted_SpriteTaskHandler", 1, "surfaceview is NOT ready.");
      bool = false;
    }
    SpriteTaskParam localSpriteTaskParam;
    do
    {
      return bool;
      localSpriteTaskParam = paramSpriteTaskParam;
      if (paramSpriteTaskParam == null) {
        localSpriteTaskParam = a();
      }
      if ((localSpriteTaskParam == null) || (localSpriteTaskParam.jdField_b_of_type_Int == 2)) {
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteTaskHandler", 2, new Object[] { "[execSpriteTask], taskId:", Integer.valueOf(localSpriteTaskParam.jdField_a_of_type_Int), ",actionId:", Integer.valueOf(localSpriteTaskParam.f) });
      }
    } while (localSpriteTaskParam.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteBridgeInterface == null);
    localSpriteTaskParam.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteBridgeInterface.b(localSpriteTaskParam);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteTaskHandler
 * JD-Core Version:    0.7.0.1
 */