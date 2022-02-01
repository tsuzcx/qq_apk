package com.tencent.biz.pubaccount.weishi_new.config.experiment;

import UserGrowth.stGetAllABTestPolicyRsp;
import UserGrowth.stGrayPolicyInfo;
import com.tencent.biz.pubaccount.weishi_new.event.WSExpEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class WSExpPolicyManager
{
  private Map<String, WSExpPolicyEntities> a = new ConcurrentHashMap();
  
  private stGrayPolicyInfo a(Map<String, String> paramMap)
  {
    stGrayPolicyInfo localstGrayPolicyInfo = new stGrayPolicyInfo();
    localstGrayPolicyInfo.grayPolicyId = "-999999";
    localstGrayPolicyInfo.params = paramMap;
    return localstGrayPolicyInfo;
  }
  
  public static WSExpPolicyManager a()
  {
    return WSExpPolicyManager.SingletonHolder.a();
  }
  
  private void a(WSExpPolicyEntities paramWSExpPolicyEntities)
  {
    paramWSExpPolicyEntities = new WSExpEvent(paramWSExpPolicyEntities);
    WSSimpleEventBus.a().a(paramWSExpPolicyEntities);
  }
  
  private void b(WSExpPolicyEntities paramWSExpPolicyEntities)
  {
    if (paramWSExpPolicyEntities != null) {}
    try
    {
      if (paramWSExpPolicyEntities.c() != null)
      {
        Object localObject = paramWSExpPolicyEntities.a();
        WSExpPolicyEntities localWSExpPolicyEntities = (WSExpPolicyEntities)this.a.get(localObject);
        if ((localWSExpPolicyEntities == null) || (localWSExpPolicyEntities.c() == null) || (paramWSExpPolicyEntities.c().serverTime > localWSExpPolicyEntities.c().serverTime))
        {
          this.a.put(localObject, paramWSExpPolicyEntities);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[WSExpPolicyManager.java][writeToExpEntitiesMap] policyEntities:");
          ((StringBuilder)localObject).append(paramWSExpPolicyEntities);
          WSLog.e("WSExpPolicyManager", ((StringBuilder)localObject).toString());
        }
        return;
      }
      WSLog.d("WSExpPolicyManager", "[WSExpPolicyManager.java][writeToExpEntitiesMap] policyEntities is null!");
      return;
    }
    finally {}
  }
  
  private void d()
  {
    ThreadManager.getFileThreadHandler().post(new WSExpPolicyManager.1(this));
  }
  
  private void e()
  {
    new WSExpDataModule().a(WeishiUtils.c(), new WSExpPolicyManager.2(this));
  }
  
  private WSExpPolicyEntities f()
  {
    stGetAllABTestPolicyRsp localstGetAllABTestPolicyRsp = new stGetAllABTestPolicyRsp();
    localstGetAllABTestPolicyRsp.policyInfo = g();
    return new WSExpPolicyEntities(WeishiUtils.c(), localstGetAllABTestPolicyRsp);
  }
  
  private Map<String, stGrayPolicyInfo> g()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("FeedsListClient_Preload", h());
    localHashMap.put("AioForwardScene", i());
    localHashMap.put("FeedLoopPlay", j());
    localHashMap.put("QQFollowPageMute", k());
    localHashMap.put("QQFeedScaleType", l());
    return localHashMap;
  }
  
  private stGrayPolicyInfo h()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("open_apk_preload", "0");
    return a(localHashMap);
  }
  
  private stGrayPolicyInfo i()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("scene", "0");
    return a(localHashMap);
  }
  
  private stGrayPolicyInfo j()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("loop_play_type", "0");
    return a(localHashMap);
  }
  
  private stGrayPolicyInfo k()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("show", "0");
    return a(localHashMap);
  }
  
  private stGrayPolicyInfo l()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", "0");
    return a(localHashMap);
  }
  
  public void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSExpPolicyManager.java][init] thread:");
    localStringBuilder.append(Thread.currentThread());
    WSLog.e("WSExpPolicyManager", localStringBuilder.toString());
    d();
    e();
  }
  
  public WSExpPolicyEntities c()
  {
    String str = WeishiUtils.c();
    Object localObject = (WSExpPolicyEntities)this.a.get(str);
    if (localObject != null) {
      return localObject;
    }
    WSExpPolicyEntities localWSExpPolicyEntities = WSExpFileCacheUtils.a(str);
    localObject = localWSExpPolicyEntities;
    if (localWSExpPolicyEntities == null) {
      localObject = f();
    }
    this.a.put(str, localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpPolicyManager
 * JD-Core Version:    0.7.0.1
 */