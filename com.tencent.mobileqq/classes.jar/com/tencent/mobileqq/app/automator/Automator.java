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
  private static ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor;
  public int a;
  public long a;
  public SharedPreferences a;
  public AppInterface a;
  public QQAppInterface a;
  private LinearGroup jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup = null;
  private HashMap<Integer, CheckUpdateItemInterface> jdField_a_of_type_JavaUtilHashMap = new LinkedHashMap();
  protected LinkedList<AsyncStep> a;
  public ConcurrentHashMap<String, Long> a;
  public boolean a;
  public int b;
  private LinkedList<LinearGroup> b;
  public boolean b;
  protected int c;
  public boolean c;
  private volatile boolean d;
  
  public Automator(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_b_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(16);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramQQAppInterface;
  }
  
  private void a(LinearGroup paramLinearGroup)
  {
    boolean bool3 = StepFactory.a.equals(paramLinearGroup.mName);
    boolean bool1 = true;
    boolean bool2 = true;
    Object localObject;
    if (bool3)
    {
      this.jdField_b_of_type_JavaUtilLinkedList.clear();
    }
    else
    {
      AsyncStep localAsyncStep;
      if ((!"{[13,16],19,21,58,60,89,23,46,33,61,42,92,96,97,99}".equals(paramLinearGroup.mName)) && (!"{15,18,21,58,60,24}".equals(paramLinearGroup.mName)))
      {
        if (StepFactory.b.equals(paramLinearGroup.mName))
        {
          localObject = this.jdField_b_of_type_JavaUtilLinkedList.iterator();
          for (;;)
          {
            bool1 = bool2;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localAsyncStep = (AsyncStep)((Iterator)localObject).next();
            if (StepFactory.a.equals(localAsyncStep.mName)) {
              bool2 = false;
            }
          }
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup != null)
      {
        bool1 = d();
        localObject = this.jdField_b_of_type_JavaUtilLinkedList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localAsyncStep = (AsyncStep)((Iterator)localObject).next();
          if ((StepFactory.a.equals(localAsyncStep.mName)) || (localAsyncStep.mName.equals(paramLinearGroup.mName))) {
            bool1 = false;
          }
        }
      }
    }
    if (bool1) {
      this.jdField_b_of_type_JavaUtilLinkedList.add(paramLinearGroup);
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
  
  public int a()
  {
    LinearGroup localLinearGroup = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup;
    if (localLinearGroup != null) {
      return StepFactory.a(localLinearGroup, false);
    }
    if (this.d) {
      return 1;
    }
    return -1;
  }
  
  public CheckUpdateItemInterface a(int paramInt)
  {
    return (CheckUpdateItemInterface)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
  }
  
  public HashMap<Integer, CheckUpdateItemInterface> a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public void a()
  {
    notifyUI(0, true, null);
  }
  
  public void a(int paramInt, CheckUpdateItemInterface paramCheckUpdateItemInterface)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), paramCheckUpdateItemInterface);
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
    synchronized (this.jdField_b_of_type_JavaUtilLinkedList)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup = ((LinearGroup)localObject1);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("run ");
          localStringBuilder.append(((LinearGroup)localObject1).mName);
          QLog.d("QQInitHandler", 2, localStringBuilder.toString());
        }
        if (jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor == null)
        {
          jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = new ThreadPoolExecutor(3, 3, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(24), new Automator.MyThreadFactory(null));
          if (Build.VERSION.SDK_INT > 8) {
            jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.allowCoreThreadTimeOut(true);
          }
        }
        jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.execute(this);
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
    Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences;
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
      if (this.jdField_a_of_type_AndroidContentSharedPreferences != null) {
        bool = true;
      }
      ((StringBuilder)localObject).append(bool);
      QLog.d("QQInitHandler", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramBoolean1) || (paramBoolean2))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("{");
      int i;
      if (paramBoolean1) {
        i = 7;
      } else {
        i = 8;
      }
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("}");
      a(StepFactory.a(this, ((StringBuilder)localObject).toString()));
    }
  }
  
  public void a(AsyncStep[] paramArrayOfAsyncStep)
  {
    int i;
    label100:
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_c_of_type_Int -= 1;
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
      {
        if (paramArrayOfAsyncStep != null)
        {
          int j = paramArrayOfAsyncStep.length;
          i = 0;
          if (i < j)
          {
            AsyncStep localAsyncStep = paramArrayOfAsyncStep[i];
            if (!this.jdField_a_of_type_JavaUtilLinkedList.remove(localAsyncStep)) {
              break label100;
            }
            b(localAsyncStep);
            return;
          }
        }
        b((AsyncStep)this.jdField_a_of_type_JavaUtilLinkedList.poll());
      }
      else
      {
        return;
      }
    }
  }
  
  public boolean a()
  {
    if (!StartService.jdField_a_of_type_Boolean) {
      return false;
    }
    LinearGroup localLinearGroup = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup;
    if (localLinearGroup != null) {
      return StepFactory.a(localLinearGroup);
    }
    return true;
  }
  
  public void b()
  {
    if (!this.d) {
      return;
    }
    boolean bool1 = true;
    boolean bool2 = true;
    if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup != null)
    {
      LinkedList localLinkedList = this.jdField_b_of_type_JavaUtilLinkedList;
      bool1 = bool2;
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup.setResult(4);
          bool1 = d();
        }
      }
      finally {}
    }
    if (bool1) {
      a(StepFactory.a(this, "{[13,16],19,21,58,60,89,23,46,33,61,42,92,96,97,99}"));
    }
  }
  
  @TargetApi(9)
  public void b(AsyncStep paramAsyncStep)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (this.jdField_c_of_type_Int < 3)
      {
        this.jdField_c_of_type_Int += 1;
        if (jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor == null)
        {
          jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = new ThreadPoolExecutor(3, 3, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(24), new Automator.MyThreadFactory(null));
          if (Build.VERSION.SDK_INT > 8) {
            jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.allowCoreThreadTimeOut(true);
          }
        }
        jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.execute(paramAsyncStep);
      }
      else
      {
        this.jdField_a_of_type_JavaUtilLinkedList.add(paramAsyncStep);
      }
      return;
    }
  }
  
  public boolean b()
  {
    LinearGroup localLinearGroup = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup;
    if (localLinearGroup != null) {
      return StepFactory.a(localLinearGroup, true) == 0;
    }
    return this.d ^ true;
  }
  
  public void c()
  {
    a(StepFactory.a(this, "{15,18,21,58,60,24}"));
  }
  
  public boolean c()
  {
    LinearGroup localLinearGroup = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup;
    if (localLinearGroup != null) {
      return StepFactory.b(localLinearGroup);
    }
    return true;
  }
  
  public void d()
  {
    notifyUI(4, true, null);
  }
  
  public boolean d()
  {
    LinearGroup localLinearGroup = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup;
    if (localLinearGroup != null) {
      return StepFactory.c(localLinearGroup);
    }
    return true;
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
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      this.jdField_c_of_type_Int = 0;
      synchronized (this.jdField_b_of_type_JavaUtilLinkedList)
      {
        this.jdField_b_of_type_JavaUtilLinkedList.clear();
        if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup.setResult(8);
          this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup = null;
        }
        this.jdField_a_of_type_Long = 0L;
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
    if (!this.d)
    {
      int i = 0;
      synchronized (this.jdField_b_of_type_JavaUtilLinkedList)
      {
        if (!this.d)
        {
          i = 1;
          this.d = true;
        }
        if (i != 0) {
          StepFactory.a(this, "2").run();
        }
      }
    }
    for (;;)
    {
      ??? = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup;
      if (??? != null) {
        ((AsyncStep)???).run();
      }
      synchronized (this.jdField_b_of_type_JavaUtilLinkedList)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup = ((LinearGroup)this.jdField_b_of_type_JavaUtilLinkedList.poll());
        if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorLinearGroup == null) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.Automator
 * JD-Core Version:    0.7.0.1
 */