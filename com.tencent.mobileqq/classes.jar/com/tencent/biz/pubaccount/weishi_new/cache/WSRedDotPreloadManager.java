package com.tencent.biz.pubaccount.weishi_new.cache;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.weishi_new.WSQQConnectAuthManager;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpPreloadABTestManager;
import com.tencent.biz.pubaccount.weishi_new.event.WSExpEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventReceiver;
import com.tencent.biz.pubaccount.weishi_new.push.IWSPushBaseStrategy;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushVideoModel;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WSSharePreferencesUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public class WSRedDotPreloadManager
  implements WSSimpleEventReceiver<WSExpEvent>
{
  private SparseArray<WSFeedsPreloadStrategy> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private boolean jdField_a_of_type_Boolean;
  
  private WSRedDotPreloadManager()
  {
    b();
  }
  
  @NotNull
  private WSFeedsPreloadStrategy a()
  {
    if (WSExpPreloadABTestManager.a().a()) {}
    for (int i = 13;; i = 8)
    {
      WSFeedsPreloadStrategy localWSFeedsPreloadStrategy2 = (WSFeedsPreloadStrategy)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      WSFeedsPreloadStrategy localWSFeedsPreloadStrategy1 = localWSFeedsPreloadStrategy2;
      if (localWSFeedsPreloadStrategy2 == null)
      {
        localWSFeedsPreloadStrategy1 = new WSFeedsPreloadStrategy(i);
        this.jdField_a_of_type_AndroidUtilSparseArray.put(i, localWSFeedsPreloadStrategy1);
      }
      return localWSFeedsPreloadStrategy1;
    }
  }
  
  public static WSRedDotPreloadManager a()
  {
    return WSRedDotPreloadManager.SingletonHolder.a();
  }
  
  private void d()
  {
    WSLog.d("WSRedDotPreloadManager", "[preloadVideoCover] start");
    if (!WSExpPreloadABTestManager.a().b()) {}
    Object localObject2;
    do
    {
      return;
      WSLog.d("WSRedDotPreloadManager", "[preloadVideoCover] hit preloadBigImage exp");
      localObject1 = WeishiUtils.a();
      if (localObject1 == null)
      {
        WSLog.d("WSRedDotPreloadManager", "[preloadVideoCover] wsPushMsgData: null");
        return;
      }
      localObject2 = WSSharePreferencesUtil.a("key_preload_msg_uin", "");
      String str = ((WSRedDotPushMsg)localObject1).mFeedIds;
      if (TextUtils.equals((CharSequence)localObject2, str))
      {
        WSLog.d("WSRedDotPreloadManager", "[preloadVideoCover] has preloaded this feed");
        return;
      }
      WSSharePreferencesUtil.a("key_preload_msg_uin", str);
      localObject2 = ((WSRedDotPushMsg)localObject1).mStrategyInfo;
    } while (TextUtils.isEmpty(((WSRedDotPushMsg)localObject1).mFeedIds));
    if ((localObject2 == null) || (((IWSPushBaseStrategy)localObject2).getType() == 2) || (((WSPushStrategyInfo)localObject2).mWSPushVideoModel == null))
    {
      WSLog.d("WSRedDotPreloadManager", "[preloadVideoCover] invalid info");
      return;
    }
    Object localObject1 = ((WSPushStrategyInfo)localObject2).mWSPushVideoModel;
    WSLog.d("WSRedDotPreloadManager", "[preloadVideoCover] async loadImage");
    ThreadManager.executeOnSubThread(new WSRedDotPreloadManager.1(this, (WSPushVideoModel)localObject1));
  }
  
  public ArrayList<Class<WSExpEvent>> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(WSExpEvent.class);
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    WSLog.e("WSRedDotPreloadManager", "[unRegisterReceiverAndCancelPreload] enterPublicAcc");
    WSSimpleEventBus.a().b(this);
    a().a();
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    WSLog.e("WSRedDotPreloadManager", "[onReceiveEvent] WSExpEvent receive and preload feeds");
    if (!(paramWSSimpleBaseEvent instanceof WSExpEvent)) {
      return;
    }
    paramWSSimpleBaseEvent = ((WSExpEvent)paramWSSimpleBaseEvent).getPolicyEntities();
    if (!WSExpPreloadABTestManager.a().a(paramWSSimpleBaseEvent)) {}
    for (int i = 1;; i = 0)
    {
      WSExpPreloadABTestManager.a().a(paramWSSimpleBaseEvent);
      if (i != 0) {
        a().b();
      }
      c();
      return;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    WSLog.e("WSRedDotPreloadManager", "[registerReceiver] exitPubicAcc");
    WSSimpleEventBus.a().a(this);
    WSExpPreloadABTestManager.a().a();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      WSLog.b("WSRedDotPreloadManager", "===inPublicAcc not need preload===");
      return;
    }
    WSLog.b("WSRedDotPreloadManager", "===startPreloadRedData===");
    d();
    WSFeedsPreloadStrategy localWSFeedsPreloadStrategy = a();
    String str = WeishiUtils.e();
    WSLog.e("WSRedDotPreloadManager", "[preloadData] preloadFeedId:" + str);
    localWSFeedsPreloadStrategy.a(str);
    WSQQConnectAuthManager.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WSRedDotPreloadManager
 * JD-Core Version:    0.7.0.1
 */