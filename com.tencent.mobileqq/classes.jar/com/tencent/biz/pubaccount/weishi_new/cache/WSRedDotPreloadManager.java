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
  private SparseArray<WSFeedsPreloadStrategy> a = new SparseArray();
  private boolean b;
  
  private WSRedDotPreloadManager()
  {
    c();
  }
  
  public static WSRedDotPreloadManager a()
  {
    return WSRedDotPreloadManager.SingletonHolder.a();
  }
  
  @NotNull
  private WSFeedsPreloadStrategy e()
  {
    int i;
    if (WSExpPreloadABTestManager.a().c()) {
      i = 13;
    } else {
      i = 8;
    }
    WSFeedsPreloadStrategy localWSFeedsPreloadStrategy2 = (WSFeedsPreloadStrategy)this.a.get(i);
    WSFeedsPreloadStrategy localWSFeedsPreloadStrategy1 = localWSFeedsPreloadStrategy2;
    if (localWSFeedsPreloadStrategy2 == null)
    {
      localWSFeedsPreloadStrategy1 = new WSFeedsPreloadStrategy(i);
      this.a.put(i, localWSFeedsPreloadStrategy1);
    }
    return localWSFeedsPreloadStrategy1;
  }
  
  private void f()
  {
    WSLog.d("WSRedDotPreloadManager", "[preloadVideoCover] start");
    if (!WSExpPreloadABTestManager.a().d()) {
      return;
    }
    WSLog.d("WSRedDotPreloadManager", "[preloadVideoCover] hit preloadBigImage exp");
    Object localObject1 = WeishiUtils.g();
    if (localObject1 == null)
    {
      WSLog.d("WSRedDotPreloadManager", "[preloadVideoCover] wsPushMsgData: null");
      return;
    }
    Object localObject2 = WSSharePreferencesUtil.b("key_preload_msg_uin", "");
    String str = ((WSRedDotPushMsg)localObject1).mFeedIds;
    if (TextUtils.equals((CharSequence)localObject2, str))
    {
      WSLog.d("WSRedDotPreloadManager", "[preloadVideoCover] has preloaded this feed");
      return;
    }
    WSSharePreferencesUtil.a("key_preload_msg_uin", str);
    localObject2 = ((WSRedDotPushMsg)localObject1).mStrategyInfo;
    if (TextUtils.isEmpty(((WSRedDotPushMsg)localObject1).mFeedIds)) {
      return;
    }
    if ((localObject2 != null) && (((IWSPushBaseStrategy)localObject2).getType() != 2))
    {
      localObject1 = (WSPushStrategyInfo)localObject2;
      if (((WSPushStrategyInfo)localObject1).mWSPushVideoModel != null)
      {
        localObject1 = ((WSPushStrategyInfo)localObject1).mWSPushVideoModel;
        WSLog.d("WSRedDotPreloadManager", "[preloadVideoCover] async downloadImageOnly");
        ThreadManager.executeOnSubThread(new WSRedDotPreloadManager.1(this, (WSPushVideoModel)localObject1));
        return;
      }
    }
    WSLog.d("WSRedDotPreloadManager", "[preloadVideoCover] invalid info");
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    WSLog.e("WSRedDotPreloadManager", "[onReceiveEvent] WSExpEvent receive and preload feeds");
    if (!(paramWSSimpleBaseEvent instanceof WSExpEvent)) {
      return;
    }
    paramWSSimpleBaseEvent = ((WSExpEvent)paramWSSimpleBaseEvent).getPolicyEntities();
    boolean bool = WSExpPreloadABTestManager.a().b(paramWSSimpleBaseEvent);
    WSExpPreloadABTestManager.a().a(paramWSSimpleBaseEvent);
    if ((bool ^ true)) {
      e().b();
    }
    d();
  }
  
  public void b()
  {
    this.b = true;
    WSLog.e("WSRedDotPreloadManager", "[unRegisterReceiverAndCancelPreload] enterPublicAcc");
    WSSimpleEventBus.a().b(this);
    e().a();
  }
  
  public void c()
  {
    this.b = false;
    WSLog.e("WSRedDotPreloadManager", "[registerReceiver] exitPubicAcc");
    WSSimpleEventBus.a().a(this);
    WSExpPreloadABTestManager.a().b();
  }
  
  public void d()
  {
    if (this.b)
    {
      WSLog.b("WSRedDotPreloadManager", "===inPublicAcc not need preload===");
      return;
    }
    WSLog.b("WSRedDotPreloadManager", "===startPreloadRedData===");
    f();
    WSFeedsPreloadStrategy localWSFeedsPreloadStrategy = e();
    String str = WeishiUtils.p();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[preloadData] preloadFeedId:");
    localStringBuilder.append(str);
    WSLog.e("WSRedDotPreloadManager", localStringBuilder.toString());
    localWSFeedsPreloadStrategy.a(str);
    WSQQConnectAuthManager.a().b();
  }
  
  public ArrayList<Class<WSExpEvent>> z()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(WSExpEvent.class);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WSRedDotPreloadManager
 * JD-Core Version:    0.7.0.1
 */