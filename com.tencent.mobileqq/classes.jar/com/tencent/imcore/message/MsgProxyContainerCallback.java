package com.tencent.imcore.message;

import com.tencent.imcore.message.msgproxy.ChatMessageMsgProxy;
import com.tencent.imcore.message.msgproxy.ConfessMsgProxy;
import com.tencent.imcore.message.msgproxy.MsgProxyWrapper;
import com.tencent.imcore.message.msgproxy.UniteGrayTipMsgProxy;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.StatisticCollector.ReportContext;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.troop.data.TroopAndDiscMsgProxy;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class MsgProxyContainerCallback
  implements MsgProxyContainer.Callback
{
  private BaseMsgProxy a(int paramInt, MsgProxyContainer paramMsgProxyContainer, AppRuntime paramAppRuntime, BaseProxyManager paramBaseProxyManager, MsgPool paramMsgPool)
  {
    if (paramInt != 0)
    {
      paramMsgProxyContainer = paramMsgProxyContainer.a(0);
      if (paramMsgProxyContainer != null) {
        return paramMsgProxyContainer;
      }
    }
    return a(new MsgProxy(paramAppRuntime, paramBaseProxyManager, paramMsgPool), new Class[] { ChatMessageMsgProxy.class, UniteGrayTipMsgProxy.class });
  }
  
  private BaseMsgProxy a(BaseMsgProxy paramBaseMsgProxy, Class<? extends MsgProxyWrapper>[] paramArrayOfClass)
  {
    QLog.d("MsgProxyContainerCallback", 1, "wrapMsgProxy() called with: next = [" + paramBaseMsgProxy + "], wrapCls = [" + Arrays.toString(paramArrayOfClass) + "]");
    AppRuntime localAppRuntime = paramBaseMsgProxy.a();
    BaseProxyManager localBaseProxyManager = paramBaseMsgProxy.a();
    MsgPool localMsgPool = paramBaseMsgProxy.a();
    int i = paramArrayOfClass.length - 1;
    Object localObject1 = paramBaseMsgProxy;
    if (i >= 0)
    {
      Object localObject2 = paramArrayOfClass[i];
      for (;;)
      {
        try
        {
          localObject2 = (BaseMsgProxy)((Class)localObject2).getConstructor(new Class[] { AppRuntime.class, BaseProxyManager.class, MsgPool.class }).newInstance(new Object[] { localAppRuntime, localBaseProxyManager, localMsgPool });
        }
        catch (Exception localException1)
        {
          try
          {
            ((MsgProxyWrapper)localObject2).a(paramBaseMsgProxy);
            paramBaseMsgProxy = (BaseMsgProxy)localObject2;
            i -= 1;
            localObject1 = localObject2;
          }
          catch (Exception localException2)
          {
            break label157;
          }
          localException1 = localException1;
          localObject2 = localObject1;
        }
        label157:
        QLog.e("MsgProxyContainerCallback", 1, "wrapMsgProxy: ", localException1);
      }
    }
    a((BaseMsgProxy)localObject1);
    return localObject1;
  }
  
  private BaseMsgProxy a(MsgProxyContainer paramMsgProxyContainer, AppRuntime paramAppRuntime, BaseProxyManager paramBaseProxyManager, MsgPool paramMsgPool)
  {
    return a(new MsgProxy(paramAppRuntime, paramBaseProxyManager, paramMsgPool), new Class[] { ChatMessageMsgProxy.class, UniteGrayTipMsgProxy.class, ConfessMsgProxy.class });
  }
  
  private void a()
  {
    StatisticCollector.ReportContext localReportContext = new StatisticCollector.ReportContext();
    localReportContext.MAINTHREAD_TAG = 0;
    localReportContext.OPTTYPE_TAG = "select";
    localReportContext.OPTSCENE_TAG = "launch";
    if ((localReportContext.OPTCOUNT_TAG != 0) && (StatisticCollector.SQLite3OptimizeReport()))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_IsMainThread", String.valueOf(localReportContext.MAINTHREAD_TAG));
      localHashMap.put("param_OptType", localReportContext.OPTTYPE_TAG);
      localHashMap.put("param_OptTotalCost", String.valueOf(localReportContext.OPTTOTALCOST_TAG));
      localHashMap.put("param_OptCount", String.valueOf(localReportContext.OPTCOUNT_TAG));
      localHashMap.put("param_OptMsgCount", String.valueOf(localReportContext.OPTMSGCOUNT_TAG));
      localHashMap.put("param_OptOneCost", String.valueOf(localReportContext.OPTONECOST_TAG));
      localHashMap.put("param_OptScene", localReportContext.OPTSCENE_TAG);
      localHashMap.put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actSqliteOptCost", true, localReportContext.OPTMSGCOUNT_TAG, 0L, localHashMap, null, false);
    }
  }
  
  private void a(BaseMsgProxy paramBaseMsgProxy)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    while (paramBaseMsgProxy != null)
    {
      localStringBuilder.append(paramBaseMsgProxy.toString()).append(", ");
      if ((paramBaseMsgProxy instanceof MsgProxyWrapper)) {
        paramBaseMsgProxy = ((MsgProxyWrapper)paramBaseMsgProxy).a();
      } else {
        paramBaseMsgProxy = null;
      }
    }
    QLog.d("MsgProxyContainerCallback", 1, "printWrappers() called with:[" + localStringBuilder.toString() + "]");
  }
  
  public BaseMsgProxy a(int paramInt, MsgProxyContainer paramMsgProxyContainer)
  {
    AppRuntime localAppRuntime = paramMsgProxyContainer.a();
    BaseProxyManager localBaseProxyManager = paramMsgProxyContainer.a();
    MsgPool localMsgPool = paramMsgProxyContainer.a();
    switch (paramInt)
    {
    default: 
      return a(paramInt, paramMsgProxyContainer, localAppRuntime, localBaseProxyManager, localMsgPool);
    case 1: 
    case 1026: 
    case 3000: 
      return a(new TroopAndDiscMsgProxy(localAppRuntime, localBaseProxyManager, localMsgPool), new Class[] { ChatMessageMsgProxy.class });
    }
    return a(paramMsgProxyContainer, localAppRuntime, localBaseProxyManager, localMsgPool);
  }
  
  public List<MsgProxyContainer.SessionKey> a(MsgProxyContainer paramMsgProxyContainer)
  {
    ArrayList localArrayList = new ArrayList();
    paramMsgProxyContainer = ((ProxyManager)paramMsgProxyContainer.a().getManager(QQManagerFactory.PROXY_MANAGER)).a().a(true).iterator();
    while (paramMsgProxyContainer.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramMsgProxyContainer.next();
      localArrayList.add(new MsgProxyContainer.SessionKey(localRecentUser.uin, localRecentUser.getType()));
    }
    return localArrayList;
  }
  
  public void a(long paramLong, MsgProxyContainer.SessionKey paramSessionKey, MsgProxyContainer paramMsgProxyContainer)
  {
    if ((paramSessionKey.a() == 0) && (AppConstants.TROOP_SYSTEM_MSG_UIN.equals(paramSessionKey.a))) {
      GroupSystemMsgController.a().a(paramMsgProxyContainer.a().getEntityManagerFactory().createEntityManager());
    }
  }
  
  public void a(MsgProxyContainer paramMsgProxyContainer)
  {
    a();
  }
  
  public void b(long paramLong, MsgProxyContainer.SessionKey paramSessionKey, MsgProxyContainer paramMsgProxyContainer)
  {
    StatisticCollector.ReportContext localReportContext = new StatisticCollector.ReportContext();
    localReportContext.MAINTHREAD_TAG = 0;
    localReportContext.OPTTYPE_TAG = "select";
    localReportContext.OPTSCENE_TAG = "launch";
    MsgProxyCallback.a(paramMsgProxyContainer.a(), paramSessionKey.a, paramSessionKey.a(), localReportContext, paramLong);
  }
  
  public void b(MsgProxyContainer paramMsgProxyContainer)
  {
    long l = System.currentTimeMillis();
    paramMsgProxyContainer.a(0);
    paramMsgProxyContainer.a(1);
    paramMsgProxyContainer.a(3000);
    paramMsgProxyContainer.a(1026);
    paramMsgProxyContainer.a(1033);
    paramMsgProxyContainer.a(1034);
    QLog.d("MsgProxyContainerCallback", 2, "initProxies() called with: msgProxyContainer = [" + paramMsgProxyContainer + "], costTime =[" + (System.currentTimeMillis() - l) + "]ms");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.MsgProxyContainerCallback
 * JD-Core Version:    0.7.0.1
 */