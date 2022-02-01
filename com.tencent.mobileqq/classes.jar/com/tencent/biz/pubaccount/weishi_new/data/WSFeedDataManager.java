package com.tencent.biz.pubaccount.weishi_new.data;

import UserGrowth.stFeed;
import UserGrowth.stSimpleMetaFeed;
import android.util.SparseIntArray;
import com.tencent.biz.pubaccount.weishi_new.holder.WSPlayableHolder;
import com.tencent.biz.pubaccount.weishi_new.net.IWeishiServiceListener;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiBusinessLooper;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.player.IWSPlayerUIDelegate;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi_new.presenter.WSFollowFeedUIDelegate;
import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.request.FollowRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.ArrayList;
import java.util.List;

public class WSFeedDataManager
{
  public List<stSimpleMetaFeed> a = new ArrayList();
  public List<stFeed> b = new ArrayList();
  public String c = "";
  public String d = "";
  public int e;
  public SparseIntArray f = new SparseIntArray();
  private WSPlayerParam g;
  
  public static WSFeedDataManager a()
  {
    return WSFeedDataManager.Holder.a();
  }
  
  private IWeishiServiceListener a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, long paramLong, WSFeedDataManager.OnDataReceivedListener paramOnDataReceivedListener)
  {
    return new WSFeedDataManager.1(this, paramBoolean1, paramBoolean2, paramLong, paramInt, paramOnDataReceivedListener);
  }
  
  private void a(WeishiTask paramWeishiTask, long paramLong, int paramInt, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("请求关注流耗时：");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("毫秒");
    WSLog.a("weishi-beacon", ((StringBuilder)localObject).toString());
    if (paramInt != 10) {}
    for (localObject = "focus";; localObject = "fullscreen_videoplay") {
      break;
    }
    WsBeaconReportPresenter.a().a(paramLong, paramWeishiTask.g, (String)localObject, paramBoolean);
  }
  
  private void a(List<stFeed> paramList, boolean paramBoolean1, int paramInt, boolean paramBoolean2, WSFeedDataManager.OnDataReceivedListener paramOnDataReceivedListener)
  {
    if (paramBoolean1)
    {
      this.b.clear();
      this.a.clear();
      this.f.clear();
    }
    List localList = b(paramList);
    this.b.addAll(paramList);
    if (paramOnDataReceivedListener == null) {
      return;
    }
    if (paramInt == 9)
    {
      if (paramBoolean1)
      {
        paramOnDataReceivedListener.a(false, this.b, paramBoolean2);
        return;
      }
      paramOnDataReceivedListener.a(true, paramList, paramBoolean2);
      return;
    }
    if (paramInt == 10) {
      paramOnDataReceivedListener.a(true, localList, paramBoolean2);
    }
  }
  
  private List<stSimpleMetaFeed> b(List<stFeed> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (WSFeedUtils.a(paramList)) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramList.size())
    {
      stFeed localstFeed = (stFeed)paramList.get(i);
      if ((localstFeed.feed_type == 2) && (localstFeed.feed != null))
      {
        this.f.put(this.b.size() + i, this.a.size() + localArrayList.size());
        localArrayList.add(localstFeed.feed);
      }
      i += 1;
    }
    this.a.addAll(localArrayList);
    paramList = new StringBuilder();
    paramList.append("position map: ");
    paramList.append(this.f.toString());
    WSLog.b("WSVideoDataManager", paramList.toString());
    return localArrayList;
  }
  
  public IWSPlayerUIDelegate a(WSPlayableHolder paramWSPlayableHolder)
  {
    IWSPlayerUIDelegate localIWSPlayerUIDelegate = paramWSPlayableHolder.c;
    Object localObject = localIWSPlayerUIDelegate;
    if (localIWSPlayerUIDelegate == null) {
      localObject = new WSFollowFeedUIDelegate();
    }
    ((WSFollowFeedUIDelegate)localObject).a(paramWSPlayableHolder);
    return localObject;
  }
  
  public WSPlayerParam a(WSPlayableHolder paramWSPlayableHolder, long paramLong, int paramInt)
  {
    WSPlayerParam localWSPlayerParam2 = paramWSPlayableHolder.b;
    WSPlayerParam localWSPlayerParam1 = localWSPlayerParam2;
    if (localWSPlayerParam2 == null) {
      localWSPlayerParam1 = new WSPlayerParam();
    }
    localWSPlayerParam1.c = paramWSPlayableHolder.a;
    localWSPlayerParam1.a = paramWSPlayableHolder.k();
    localWSPlayerParam1.k = paramWSPlayableHolder.c;
    localWSPlayerParam1.e = 2;
    localWSPlayerParam1.g = paramLong;
    localWSPlayerParam1.i = false;
    localWSPlayerParam1.f = paramInt;
    localWSPlayerParam1.j = "follow_tab";
    return localWSPlayerParam1;
  }
  
  public void a(WSPlayerParam paramWSPlayerParam)
  {
    this.g = paramWSPlayerParam;
  }
  
  public void a(List<stFeed> paramList)
  {
    b(paramList);
    this.b = paramList;
    this.e = 15;
  }
  
  public <T> void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt, long paramLong, WSFeedDataManager.OnDataReceivedListener<T> paramOnDataReceivedListener)
  {
    String str;
    if ((!paramBoolean1) && (!paramBoolean2)) {
      str = this.c;
    } else {
      str = "";
    }
    paramString = new WeishiTask(new FollowRequest(str, paramBoolean1, paramBoolean2, paramString, paramInt), null, a(paramBoolean1, paramBoolean2, paramInt, paramLong, paramOnDataReceivedListener), 3001);
    WeishiBusinessLooper.a().a(paramString);
  }
  
  public WSPlayerParam b()
  {
    return this.g;
  }
  
  public void b(WSPlayableHolder paramWSPlayableHolder)
  {
    paramWSPlayableHolder = paramWSPlayableHolder.b;
    if ((paramWSPlayableHolder != null) && ((paramWSPlayableHolder.h) || ((paramWSPlayableHolder.d != null) && (paramWSPlayableHolder.d.E() != 0)))) {
      paramWSPlayableHolder.h = false;
    }
  }
  
  public void c()
  {
    this.c = "";
    this.d = "";
    if (this.g != null) {
      this.g = null;
    }
    Object localObject = this.b;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    localObject = this.a;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    localObject = this.f;
    if (localObject != null) {
      ((SparseIntArray)localObject).clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.data.WSFeedDataManager
 * JD-Core Version:    0.7.0.1
 */