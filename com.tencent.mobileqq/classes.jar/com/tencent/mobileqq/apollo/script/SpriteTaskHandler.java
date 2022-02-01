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
  private long jdField_a_of_type_Long = 0L;
  private ISpriteUIHandler jdField_a_of_type_ComTencentMobileqqApolloScriptISpriteUIHandler;
  private SpriteContext jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
  private Runnable jdField_a_of_type_JavaLangRunnable = new SpriteTaskHandler.1(this);
  private Map<Integer, Long> jdField_a_of_type_JavaUtilMap = new HashMap();
  private BlockingDeque<SpriteTaskParam> jdField_a_of_type_JavaUtilConcurrentBlockingDeque;
  private CopyOnWriteArrayList<SpriteTaskParam> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private int jdField_b_of_type_Int = 0;
  private CopyOnWriteArrayList<ISpriteTaskStatusCallback> jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  
  public SpriteTaskHandler(SpriteContext paramSpriteContext, @NonNull ISpriteUIHandler paramISpriteUIHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteTaskHandler", 2, "SpriteTaskHandler constructor.");
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext = paramSpriteContext;
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptISpriteUIHandler = paramISpriteUIHandler;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque = new LinkedBlockingDeque(50);
    jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  }
  
  private SpriteTaskParam a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0) {
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
      QLog.d("[cmshow][scripted]SpriteTaskHandler", 2, "[findTaskByTaskId], task NOT found in queue");
    }
    return null;
  }
  
  private SpriteTaskParam a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)localIterator.next();
      if ((localSpriteTaskParam != null) && (localSpriteTaskParam.jdField_a_of_type_Long == paramLong) && (paramInt == 2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow][scripted]SpriteTaskHandler", 2, new Object[] { "[stopTask], msgId:", Long.valueOf(paramLong), ",taskId:", Integer.valueOf(localSpriteTaskParam.jdField_a_of_type_Int) });
        }
        return localSpriteTaskParam;
      }
    }
    return null;
  }
  
  private boolean b(SpriteTaskParam paramSpriteTaskParam)
  {
    if (paramSpriteTaskParam == null) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0) {
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
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
  }
  
  public SpriteTaskParam a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0) {
      return null;
    }
    return (SpriteTaskParam)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(0);
  }
  
  public SpriteTaskParam a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0) {
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
      QLog.d("[cmshow][scripted]SpriteTaskHandler", 2, "[findTask], task NOT found in queue");
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteTaskHandler", 2, "[clear]");
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    if (this.jdField_b_of_type_Int > 0)
    {
      SpriteContext localSpriteContext = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
      if (localSpriteContext != null) {
        VipUtils.a(localSpriteContext.a(), "cmshow", "Apollo", "play_times", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int), 0, new String[] { Integer.toString(this.jdField_b_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_JavaLangString });
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque.clear();
    this.jdField_b_of_type_Int = 0;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[removeTask], fail. NO task. taskId:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.w("[cmshow][scripted]SpriteTaskHandler", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteTaskHandler", 2, new Object[] { "[removeTask], total task num:", Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size()), ",taskId:", Integer.valueOf(paramInt) });
    }
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
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
      QLog.d("[cmshow][scripted]SpriteTaskHandler", 2, "[removeTask], task NOT found in queue");
    }
  }
  
  public void a(ISpriteTaskStatusCallback paramISpriteTaskStatusCallback)
  {
    if (paramISpriteTaskStatusCallback != null)
    {
      if (this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramISpriteTaskStatusCallback))
      {
        QLog.w("[cmshow][scripted]SpriteTaskHandler", 1, "[addActionCallback], repeat callback.");
        return;
      }
      this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramISpriteTaskStatusCallback);
    }
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam)
  {
    if (paramSpriteTaskParam != null)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
      if (localObject1 != null)
      {
        boolean bool = ((SpriteContext)localObject1).a();
        localObject1 = "1";
        Object localObject3;
        if ((bool) && (paramSpriteTaskParam.g != 1))
        {
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramSpriteTaskParam);
          this.jdField_a_of_type_ComTencentMobileqqApolloScriptISpriteUIHandler.a(false, true, null);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
          localObject3 = Integer.toString(((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int));
          if (paramSpriteTaskParam.g != 2) {
            localObject1 = "2";
          }
          VipUtils.a((AppInterface)localObject2, "cmshow", "Apollo", "aio_double_show_clk", 0, 0, new String[] { localObject3, localObject1 });
          return;
        }
        if ((!this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.i()) && (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.d()) && (!this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.c()))
        {
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramSpriteTaskParam);
          this.jdField_a_of_type_ComTencentMobileqqApolloScriptISpriteUIHandler.a(false, false, "none_apollo_play_action");
          return;
        }
        if (b(paramSpriteTaskParam))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[addTask], same task. discard it. ");
          ((StringBuilder)localObject1).append(paramSpriteTaskParam);
          QLog.w("[cmshow][scripted]SpriteTaskHandler", 1, ((StringBuilder)localObject1).toString());
          return;
        }
        Object localObject2 = a(paramSpriteTaskParam.jdField_a_of_type_Long, paramSpriteTaskParam.g);
        int i;
        if (localObject2 == null)
        {
          this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque.offerLast(paramSpriteTaskParam);
          long l = System.currentTimeMillis();
          if ((l - this.jdField_a_of_type_Long <= 500L) && (a()))
          {
            ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
            ThreadManager.getSubThreadHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
            return;
          }
          paramSpriteTaskParam = (SpriteTaskParam)this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque.pollLast();
          this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque.clear();
          this.jdField_a_of_type_Long = l;
          if (paramSpriteTaskParam == null)
          {
            QLog.e("[cmshow][scripted]SpriteTaskHandler", 1, "[addTask] poll task from deque failed");
            return;
          }
          paramSpriteTaskParam.jdField_b_of_type_Int = 1;
          i = jdField_a_of_type_Int + 1;
          jdField_a_of_type_Int = i;
          paramSpriteTaskParam.jdField_a_of_type_Int = i;
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramSpriteTaskParam);
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow][scripted]SpriteTaskHandler", 2, new Object[] { "[addTask], size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size()), ",taskId:", Integer.valueOf(paramSpriteTaskParam.jdField_a_of_type_Int) });
          }
        }
        else
        {
          ((SpriteTaskParam)localObject2).jdField_b_of_type_Int = 5;
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
          i = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int);
          String str = Integer.toString(paramSpriteTaskParam.f);
          if (paramSpriteTaskParam.jdField_a_of_type_Boolean) {
            localObject1 = "0";
          }
          VipUtils.a((AppInterface)localObject3, "cmshow", "Apollo", "msg_paly_stop", i, 0, new String[] { str, localObject1 });
        }
        a((SpriteTaskParam)localObject2);
        return;
      }
    }
    QLog.w("[cmshow][scripted]SpriteTaskHandler", 1, "[addTask], fail. null param");
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
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()));
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0) {
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
    int i = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
    boolean bool = false;
    if (i == 0) {
      return false;
    }
    SpriteTaskParam localSpriteTaskParam = a(paramLong);
    if (localSpriteTaskParam == null) {
      return false;
    }
    if (localSpriteTaskParam.jdField_b_of_type_Int == 3) {
      bool = true;
    }
    return bool;
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
        if ((!this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.i()) && (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.d())) {
          this.jdField_a_of_type_ComTencentMobileqqApolloScriptISpriteUIHandler.a(false, "none_apollo_play_action");
        }
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow][scripted]SpriteTaskHandler", 2, new Object[] { "[execSpriteTask], taskId:", Integer.valueOf(((SpriteTaskParam)localObject).jdField_a_of_type_Int), ",actionId:", Integer.valueOf(((SpriteTaskParam)localObject).f) });
        }
        if (((SpriteTaskParam)localObject).jdField_a_of_type_ComTencentMobileqqApolloScriptISpriteBridge != null) {
          ((SpriteTaskParam)localObject).jdField_a_of_type_ComTencentMobileqqApolloScriptISpriteBridge.a((SpriteTaskParam)localObject);
        }
        return true;
      }
      return false;
    }
    QLog.w("[cmshow][scripted]SpriteTaskHandler", 1, "surfaceview is NOT ready.");
    return false;
  }
  
  public int b()
  {
    int i = jdField_a_of_type_Int + 1;
    jdField_a_of_type_Int = i;
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteTaskHandler
 * JD-Core Version:    0.7.0.1
 */