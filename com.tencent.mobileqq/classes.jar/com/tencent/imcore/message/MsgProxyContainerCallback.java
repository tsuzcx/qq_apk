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
import com.tencent.mobileqq.guild.message.db.GuildMsgProxy;
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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("wrapMsgProxy() called with: next = [");
    ((StringBuilder)localObject1).append(paramBaseMsgProxy);
    ((StringBuilder)localObject1).append("], wrapCls = [");
    ((StringBuilder)localObject1).append(Arrays.toString(paramArrayOfClass));
    ((StringBuilder)localObject1).append("]");
    QLog.d("MsgProxyContainerCallback", 1, ((StringBuilder)localObject1).toString());
    AppRuntime localAppRuntime = paramBaseMsgProxy.b();
    BaseProxyManager localBaseProxyManager = paramBaseMsgProxy.c();
    MsgPool localMsgPool = paramBaseMsgProxy.a();
    int i = paramArrayOfClass.length;
    localObject1 = paramBaseMsgProxy;
    i -= 1;
    while (i >= 0)
    {
      Object localObject2 = paramArrayOfClass[i];
      try
      {
        localObject2 = (BaseMsgProxy)((Class)localObject2).getConstructor(new Class[] { AppRuntime.class, BaseProxyManager.class, MsgPool.class }).newInstance(new Object[] { localAppRuntime, localBaseProxyManager, localMsgPool });
        try
        {
          ((MsgProxyWrapper)localObject2).a((BaseMsgProxy)localObject1);
          paramBaseMsgProxy = (BaseMsgProxy)localObject2;
          localObject1 = paramBaseMsgProxy;
        }
        catch (Exception localException2)
        {
          paramBaseMsgProxy = (BaseMsgProxy)localObject2;
          localObject2 = localException2;
        }
        QLog.e("MsgProxyContainerCallback", 1, "wrapMsgProxy: ", localException1);
      }
      catch (Exception localException1) {}
      i -= 1;
    }
    a(paramBaseMsgProxy);
    return paramBaseMsgProxy;
  }
  
  private BaseMsgProxy a(MsgProxyContainer paramMsgProxyContainer, AppRuntime paramAppRuntime, BaseProxyManager paramBaseProxyManager, MsgPool paramMsgPool)
  {
    return a(new MsgProxy(paramAppRuntime, paramBaseProxyManager, paramMsgPool), new Class[] { ChatMessageMsgProxy.class, UniteGrayTipMsgProxy.class, ConfessMsgProxy.class });
  }
  
  private void a()
  {
    StatisticCollector.ReportContext localReportContext = new StatisticCollector.ReportContext();
    localReportContext.mainthreadTag = 0;
    localReportContext.opttypeTag = "select";
    localReportContext.optsceneTag = "launch";
    if ((localReportContext.optcountTag != 0) && (StatisticCollector.sqlite3Optimizereport()))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_IsMainThread", String.valueOf(localReportContext.mainthreadTag));
      localHashMap.put("param_OptType", localReportContext.opttypeTag);
      localHashMap.put("param_OptTotalCost", String.valueOf(localReportContext.opttotalcostTag));
      localHashMap.put("param_OptCount", String.valueOf(localReportContext.optcountTag));
      localHashMap.put("param_OptMsgCount", String.valueOf(localReportContext.optmsgcountTag));
      localHashMap.put("param_OptOneCost", String.valueOf(localReportContext.optonecostTag));
      localHashMap.put("param_OptScene", localReportContext.optsceneTag);
      localHashMap.put("param_WalSwitch", String.valueOf(SQLiteOpenHelper.WAL_ENABLE));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actSqliteOptCost", true, localReportContext.optmsgcountTag, 0L, localHashMap, null, false);
    }
  }
  
  private void a(BaseMsgProxy paramBaseMsgProxy)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    while (paramBaseMsgProxy != null)
    {
      localStringBuilder.append(paramBaseMsgProxy.toString());
      localStringBuilder.append(", ");
      if ((paramBaseMsgProxy instanceof MsgProxyWrapper)) {
        paramBaseMsgProxy = ((MsgProxyWrapper)paramBaseMsgProxy).i();
      } else {
        paramBaseMsgProxy = null;
      }
    }
    paramBaseMsgProxy = new StringBuilder();
    paramBaseMsgProxy.append("printWrappers() called with:[");
    paramBaseMsgProxy.append(localStringBuilder.toString());
    paramBaseMsgProxy.append("]");
    QLog.d("MsgProxyContainerCallback", 1, paramBaseMsgProxy.toString());
  }
  
  public BaseMsgProxy a(int paramInt, MsgProxyContainer paramMsgProxyContainer)
  {
    AppRuntime localAppRuntime = paramMsgProxyContainer.b();
    BaseProxyManager localBaseProxyManager = paramMsgProxyContainer.c();
    MsgPool localMsgPool = paramMsgProxyContainer.d();
    if ((paramInt != 1) && (paramInt != 1026) && (paramInt != 3000))
    {
      if (paramInt != 10014)
      {
        if ((paramInt != 1033) && (paramInt != 1034)) {
          return a(paramInt, paramMsgProxyContainer, localAppRuntime, localBaseProxyManager, localMsgPool);
        }
        return a(paramMsgProxyContainer, localAppRuntime, localBaseProxyManager, localMsgPool);
      }
      return a(new GuildMsgProxy(localAppRuntime, localBaseProxyManager, localMsgPool), new Class[] { ChatMessageMsgProxy.class });
    }
    return a(new TroopAndDiscMsgProxy(localAppRuntime, localBaseProxyManager, localMsgPool), new Class[] { ChatMessageMsgProxy.class });
  }
  
  public List<MsgProxyContainer.SessionKey> a(MsgProxyContainer paramMsgProxyContainer)
  {
    ArrayList localArrayList = new ArrayList();
    paramMsgProxyContainer = ((ProxyManager)paramMsgProxyContainer.b().getManager(QQManagerFactory.PROXY_MANAGER)).g().a(true).iterator();
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
      GroupSystemMsgController.a().a(paramMsgProxyContainer.b().getEntityManagerFactory().createEntityManager());
    }
  }
  
  public void b(long paramLong, MsgProxyContainer.SessionKey paramSessionKey, MsgProxyContainer paramMsgProxyContainer)
  {
    StatisticCollector.ReportContext localReportContext = new StatisticCollector.ReportContext();
    localReportContext.mainthreadTag = 0;
    localReportContext.opttypeTag = "select";
    localReportContext.optsceneTag = "launch";
    MsgProxyCallback.a(paramMsgProxyContainer.b(), paramSessionKey.a, paramSessionKey.a(), localReportContext, paramLong);
  }
  
  public void b(MsgProxyContainer paramMsgProxyContainer)
  {
    a();
  }
  
  public void c(MsgProxyContainer paramMsgProxyContainer)
  {
    long l = System.currentTimeMillis();
    paramMsgProxyContainer.a(0);
    paramMsgProxyContainer.a(1);
    paramMsgProxyContainer.a(3000);
    paramMsgProxyContainer.a(1026);
    paramMsgProxyContainer.a(10014);
    paramMsgProxyContainer.a(1033);
    paramMsgProxyContainer.a(1034);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initProxies() called with: msgProxyContainer = [");
    localStringBuilder.append(paramMsgProxyContainer);
    localStringBuilder.append("], costTime =[");
    localStringBuilder.append(System.currentTimeMillis() - l);
    localStringBuilder.append("]ms");
    QLog.d("MsgProxyContainerCallback", 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.MsgProxyContainerCallback
 * JD-Core Version:    0.7.0.1
 */