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
  
  private stGrayPolicyInfo a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("open_apk_preload", "0");
    return a(localHashMap);
  }
  
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
  
  private Map<String, stGrayPolicyInfo> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("FeedsListClient_Preload", a());
    localHashMap.put("AioForwardScene", b());
    localHashMap.put("QQFeedPlayerType", c());
    localHashMap.put("FeedLoopPlay", d());
    localHashMap.put("QQFollowPageMute", e());
    localHashMap.put("QQFeedScaleType", f());
    return localHashMap;
  }
  
  private void a(WSExpPolicyEntities paramWSExpPolicyEntities)
  {
    paramWSExpPolicyEntities = new WSExpEvent(paramWSExpPolicyEntities);
    WSSimpleEventBus.a().a(paramWSExpPolicyEntities);
  }
  
  private stGrayPolicyInfo b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("scene", "0");
    return a(localHashMap);
  }
  
  private WSExpPolicyEntities b()
  {
    stGetAllABTestPolicyRsp localstGetAllABTestPolicyRsp = new stGetAllABTestPolicyRsp();
    localstGetAllABTestPolicyRsp.policyInfo = a();
    return new WSExpPolicyEntities(WeishiUtils.a(), localstGetAllABTestPolicyRsp);
  }
  
  private void b()
  {
    ThreadManager.getFileThreadHandler().post(new WSExpPolicyManager.1(this));
  }
  
  private void b(WSExpPolicyEntities paramWSExpPolicyEntities)
  {
    if (paramWSExpPolicyEntities != null) {}
    try
    {
      if (paramWSExpPolicyEntities.a() != null)
      {
        Object localObject = paramWSExpPolicyEntities.a();
        WSExpPolicyEntities localWSExpPolicyEntities = (WSExpPolicyEntities)this.a.get(localObject);
        if ((localWSExpPolicyEntities == null) || (localWSExpPolicyEntities.a() == null) || (paramWSExpPolicyEntities.a().serverTime > localWSExpPolicyEntities.a().serverTime))
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
  
  private stGrayPolicyInfo c()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", "0");
    return a(localHashMap);
  }
  
  private void c()
  {
    new WSExpDataModule().a(WeishiUtils.a(), new WSExpPolicyManager.2(this));
  }
  
  private stGrayPolicyInfo d()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("loop_play_type", "0");
    return a(localHashMap);
  }
  
  private stGrayPolicyInfo e()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("show", "0");
    return a(localHashMap);
  }
  
  private stGrayPolicyInfo f()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", "0");
    return a(localHashMap);
  }
  
  public WSExpPolicyEntities a()
  {
    String str = WeishiUtils.a();
    Object localObject = (WSExpPolicyEntities)this.a.get(str);
    if (localObject != null) {
      return localObject;
    }
    WSExpPolicyEntities localWSExpPolicyEntities = WSExpFileCacheUtils.a(str);
    localObject = localWSExpPolicyEntities;
    if (localWSExpPolicyEntities == null) {
      localObject = b();
    }
    this.a.put(str, localObject);
    return localObject;
  }
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSExpPolicyManager.java][init] thread:");
    localStringBuilder.append(Thread.currentThread());
    WSLog.e("WSExpPolicyManager", localStringBuilder.toString());
    b();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpPolicyManager
 * JD-Core Version:    0.7.0.1
 */