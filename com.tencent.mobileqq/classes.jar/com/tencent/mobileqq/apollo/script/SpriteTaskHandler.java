package com.tencent.mobileqq.apollo.script;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.script.ISpriteBridge;
import com.tencent.mobileqq.apollo.api.script.ISpriteTaskHandler;
import com.tencent.mobileqq.apollo.api.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.script.callback.ISpriteActionCallback;
import com.tencent.mobileqq.apollo.script.callback.ISpriteTaskStatusCallback;
import com.tencent.mobileqq.apollo.script.callback.ISpriteUICallback;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanel;
import com.tencent.mobileqq.app.QQAppInterface;
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
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class SpriteTaskHandler
  implements ISpriteTaskHandler, ISpriteActionCallback
{
  public static volatile int a;
  private long jdField_a_of_type_Long = 0L;
  private SpriteContext jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
  private ISpriteUICallback jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteUICallback;
  private Runnable jdField_a_of_type_JavaLangRunnable = new SpriteTaskHandler.1(this);
  private Map<Integer, Long> jdField_a_of_type_JavaUtilMap = new HashMap();
  private BlockingDeque<SpriteTaskParam> jdField_a_of_type_JavaUtilConcurrentBlockingDeque;
  private CopyOnWriteArrayList<SpriteTaskParam> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private int jdField_b_of_type_Int = 0;
  private CopyOnWriteArrayList<ISpriteTaskStatusCallback> jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  
  public SpriteTaskHandler(SpriteContext paramSpriteContext, ISpriteUICallback paramISpriteUICallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteTaskHandler", 2, "SpriteTaskHandler constructor.");
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext = paramSpriteContext;
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteUICallback = paramISpriteUICallback;
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
      QLog.d("cmshow_scripted_SpriteTaskHandler", 2, "[findTaskByTaskId], task NOT found in queue");
    }
    return null;
  }
  
  private SpriteTaskParam a(long paramLong, int paramInt)
  {
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0) {
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
      QLog.d("cmshow_scripted_SpriteTaskHandler", 2, "[findTask], task NOT found in queue");
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteTaskHandler", 2, "[clear]");
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    if (this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) {
      this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    }
    if ((this.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext != null)) {
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), "cmshow", "Apollo", "play_times", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int), 0, new String[] { Integer.toString(this.jdField_b_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_JavaLangString });
    }
    this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque.clear();
    this.jdField_b_of_type_Int = 0;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0) {
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
  
  public void a(SpriteTaskParam paramSpriteTaskParam)
  {
    if ((paramSpriteTaskParam == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null)) {
      QLog.w("cmshow_scripted_SpriteTaskHandler", 1, "[addTask], fail. null param");
    }
    do
    {
      do
      {
        return;
        if ((1 == this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.d) && (paramSpriteTaskParam.g != 1))
        {
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramSpriteTaskParam);
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteUICallback instanceof SpriteUIHandler)) {
            ((SpriteUIHandler)this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteUICallback).a(false, true, null);
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
          localObject2 = Integer.toString(((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int));
          if (paramSpriteTaskParam.g == 2) {}
          for (paramSpriteTaskParam = "1";; paramSpriteTaskParam = "2")
          {
            VipUtils.a((AppInterface)localObject1, "cmshow", "Apollo", "aio_double_show_clk", 0, 0, new String[] { localObject2, paramSpriteTaskParam });
            return;
          }
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.i()) || (!this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.d()) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.c())) {
          break;
        }
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramSpriteTaskParam);
      } while (!(this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteUICallback instanceof SpriteUIHandler));
      ((SpriteUIHandler)this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteUICallback).a(false, false, "none_apollo_play_action");
      return;
      if (!b(paramSpriteTaskParam)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("cmshow_scripted_SpriteTaskHandler", 2, "[addTask], same task. discard it.");
    return;
    Object localObject1 = a(paramSpriteTaskParam.jdField_a_of_type_Long, paramSpriteTaskParam.g);
    if (localObject1 == null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque.offerLast(paramSpriteTaskParam);
      long l = System.currentTimeMillis();
      if ((l - this.jdField_a_of_type_Long > 500L) || (!a()))
      {
        paramSpriteTaskParam = (SpriteTaskParam)this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque.pollLast();
        this.jdField_a_of_type_JavaUtilConcurrentBlockingDeque.clear();
        this.jdField_a_of_type_Long = l;
        if (paramSpriteTaskParam == null) {
          QLog.e("cmshow_scripted_SpriteTaskHandler", 1, "[addTask] poll task from deque failed");
        }
      }
      else
      {
        ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        ThreadManager.getSubThreadHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
        return;
      }
      paramSpriteTaskParam.jdField_b_of_type_Int = 1;
      i = jdField_a_of_type_Int + 1;
      jdField_a_of_type_Int = i;
      paramSpriteTaskParam.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(0, paramSpriteTaskParam);
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteTaskHandler", 2, new Object[] { "[addTask], size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size()), ",taskId:", Integer.valueOf(paramSpriteTaskParam.jdField_a_of_type_Int) });
      }
      a((SpriteTaskParam)localObject1);
      return;
    }
    ((SpriteTaskParam)localObject1).jdField_b_of_type_Int = 5;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
    int i = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int);
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
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteTaskHandler", 2, new Object[] { "[onStartAction], taskId:", Integer.valueOf(paramInt) });
    }
    paramString = a(paramInt);
    if (paramString == null) {
      return;
    }
    paramString.jdField_b_of_type_Int = 3;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteUICallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteUICallback.onTaskStart(paramString, paramString.jdField_a_of_type_Long);
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      ISpriteTaskStatusCallback localISpriteTaskStatusCallback = (ISpriteTaskStatusCallback)localIterator.next();
      if (localISpriteTaskStatusCallback != null) {
        localISpriteTaskStatusCallback.onTaskStart(paramString, paramString.jdField_a_of_type_Long);
      }
    }
    this.jdField_b_of_type_Int += 1;
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()));
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteTaskHandler", 2, new Object[] { "[onCompleteAction], taskId:", Integer.valueOf(paramInt1), ",type:", Integer.valueOf(paramInt2) });
    }
    paramString = a(paramInt1);
    if (paramString == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteUICallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteUICallback.onTaskComplete(paramString, paramString.jdField_a_of_type_Long, paramInt2);
    }
    paramString.jdField_b_of_type_Int = 6;
    Object localObject = this.jdField_b_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ISpriteTaskStatusCallback localISpriteTaskStatusCallback = (ISpriteTaskStatusCallback)((Iterator)localObject).next();
      if (localISpriteTaskStatusCallback != null) {
        localISpriteTaskStatusCallback.onTaskComplete(paramString, paramString.jdField_a_of_type_Long, paramInt2);
      }
    }
    a(paramInt1);
    long l = ((Long)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt1))).longValue();
    if ((l > 0L) && (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext != null))
    {
      l = System.currentTimeMillis() - l;
      if (!ApolloPanel.jdField_a_of_type_Boolean) {
        break label360;
      }
      paramInt2 = 1;
      label189:
      localObject = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
      if (paramString.c != 1) {
        break label365;
      }
      if (localObject == null) {
        break label583;
      }
    }
    label583:
    for (int i = ((IApolloManagerService)((QQAppInterface)localObject).getRuntimeService(IApolloManagerService.class, "all")).getApolloUserStatus((AppRuntime)localObject);; i = 0)
    {
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), "cmshow", "Apollo", "emotion_play_time", paramInt2, 0, new String[] { String.valueOf(i), "", "", String.valueOf(l) });
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt1));
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null) || (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty()) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.i()) || (!this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.d()) || (!(this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteUICallback instanceof SpriteUIHandler))) {
          break;
        }
        ((SpriteUIHandler)this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteUICallback).a(true, "none_apollo_play_action");
        return;
        label360:
        paramInt2 = 0;
        break label189;
        label365:
        if (paramString.l == 1)
        {
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), "cmshow", "Apollo", "quickresponse_play_time", paramInt2, 0, new String[] { "", "", "", String.valueOf(l) });
        }
        else if (paramString.l == 2)
        {
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), "cmshow", "Apollo", "groupplus_play_time", paramInt2, 0, new String[] { "", "", "", String.valueOf(l) });
        }
        else if (localObject != null)
        {
          i = ((ApolloDaoManagerServiceImpl)((QQAppInterface)localObject).getRuntimeService(IApolloDaoManagerService.class, "all")).getActionPkgId(paramString.f);
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(), "cmshow", "Apollo", "action_play_time", paramInt2, 0, new String[] { "655_" + i, "", "", String.valueOf(l) });
        }
      }
    }
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
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0) {}
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
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null) || (!this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.c()))
    {
      QLog.w("cmshow_scripted_SpriteTaskHandler", 1, "surfaceview is NOT ready.");
      return false;
    }
    SpriteTaskParam localSpriteTaskParam = paramSpriteTaskParam;
    if (paramSpriteTaskParam == null) {
      localSpriteTaskParam = a();
    }
    if ((localSpriteTaskParam == null) || (localSpriteTaskParam.jdField_b_of_type_Int == 2)) {
      return false;
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.i()) && (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.d()) && ((this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteUICallback instanceof SpriteUIHandler))) {
      ((SpriteUIHandler)this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteUICallback).a(false, "none_apollo_play_action");
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteTaskHandler", 2, new Object[] { "[execSpriteTask], taskId:", Integer.valueOf(localSpriteTaskParam.jdField_a_of_type_Int), ",actionId:", Integer.valueOf(localSpriteTaskParam.f) });
    }
    if (localSpriteTaskParam.jdField_a_of_type_ComTencentMobileqqApolloApiScriptISpriteBridge != null) {
      localSpriteTaskParam.jdField_a_of_type_ComTencentMobileqqApolloApiScriptISpriteBridge.a(localSpriteTaskParam);
    }
    return true;
  }
  
  public int b()
  {
    int i = jdField_a_of_type_Int + 1;
    jdField_a_of_type_Int = i;
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteTaskHandler
 * JD-Core Version:    0.7.0.1
 */