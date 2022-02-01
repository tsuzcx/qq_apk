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
  
  /* Error */
  private void b(WSExpPolicyEntities paramWSExpPolicyEntities)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +10 -> 13
    //   6: aload_1
    //   7: invokevirtual 143	com/tencent/biz/pubaccount/weishi_new/config/experiment/WSExpPolicyEntities:a	()LUserGrowth/stGetAllABTestPolicyRsp;
    //   10: ifnonnull +13 -> 23
    //   13: ldc 145
    //   15: ldc 147
    //   17: invokestatic 152	com/tencent/biz/pubaccount/weishi_new/util/WSLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_1
    //   24: invokevirtual 153	com/tencent/biz/pubaccount/weishi_new/config/experiment/WSExpPolicyEntities:a	()Ljava/lang/String;
    //   27: astore_2
    //   28: aload_0
    //   29: getfield 16	com/tencent/biz/pubaccount/weishi_new/config/experiment/WSExpPolicyManager:a	Ljava/util/Map;
    //   32: aload_2
    //   33: invokeinterface 157 2 0
    //   38: checkcast 115	com/tencent/biz/pubaccount/weishi_new/config/experiment/WSExpPolicyEntities
    //   41: astore_3
    //   42: aload_3
    //   43: ifnull +28 -> 71
    //   46: aload_3
    //   47: invokevirtual 143	com/tencent/biz/pubaccount/weishi_new/config/experiment/WSExpPolicyEntities:a	()LUserGrowth/stGetAllABTestPolicyRsp;
    //   50: ifnull +21 -> 71
    //   53: aload_1
    //   54: invokevirtual 143	com/tencent/biz/pubaccount/weishi_new/config/experiment/WSExpPolicyEntities:a	()LUserGrowth/stGetAllABTestPolicyRsp;
    //   57: getfield 161	UserGrowth/stGetAllABTestPolicyRsp:serverTime	J
    //   60: aload_3
    //   61: invokevirtual 143	com/tencent/biz/pubaccount/weishi_new/config/experiment/WSExpPolicyEntities:a	()LUserGrowth/stGetAllABTestPolicyRsp;
    //   64: getfield 161	UserGrowth/stGetAllABTestPolicyRsp:serverTime	J
    //   67: lcmp
    //   68: ifle -48 -> 20
    //   71: aload_0
    //   72: getfield 16	com/tencent/biz/pubaccount/weishi_new/config/experiment/WSExpPolicyManager:a	Ljava/util/Map;
    //   75: aload_2
    //   76: aload_1
    //   77: invokeinterface 33 3 0
    //   82: pop
    //   83: ldc 145
    //   85: new 163	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 164	java/lang/StringBuilder:<init>	()V
    //   92: ldc 166
    //   94: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_1
    //   98: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 178	com/tencent/biz/pubaccount/weishi_new/util/WSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: goto -87 -> 20
    //   110: astore_1
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_1
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	WSExpPolicyManager
    //   0	115	1	paramWSExpPolicyEntities	WSExpPolicyEntities
    //   27	49	2	str	String
    //   41	20	3	localWSExpPolicyEntities	WSExpPolicyEntities
    // Exception table:
    //   from	to	target	type
    //   6	13	110	finally
    //   13	20	110	finally
    //   23	42	110	finally
    //   46	71	110	finally
    //   71	107	110	finally
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
    WSLog.e("WSExpPolicyManager", "[WSExpPolicyManager.java][init] thread:" + Thread.currentThread());
    b();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpPolicyManager
 * JD-Core Version:    0.7.0.1
 */