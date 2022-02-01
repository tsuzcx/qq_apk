package com.tencent.biz.qqcircle.manager;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.utils.QCircleTextUtils;
import com.tencent.biz.qqcircle.viewmodels.QCirclePersonalPymkViewModel;
import com.tencent.biz.qqcircle.viewmodels.QCircleSplashViewModel;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.util.List;

public class QCirclePersonalPymkModelManager
  implements LifecycleOwner
{
  private LifecycleRegistry a = new LifecycleRegistry(this);
  private QCirclePersonalPymkViewModel b;
  private QCircleSplashViewModel c;
  private QCirclePersonalPymkModelManager.FeedListRspObserver d;
  private QCirclePersonalPymkModelManager.OnPersonalPymkResultCallback e;
  private String f;
  
  public QCirclePersonalPymkModelManager()
  {
    this.a.setCurrentState(Lifecycle.State.STARTED);
  }
  
  private void a(long paramLong, String paramString)
  {
    QLog.d("PYMK-QCirclePersonalPymkModelManager", 1, new Object[] { "[handleFeedListRspFail] err code: ", Long.valueOf(paramLong), " | err msg: ", paramString });
    a(null);
    this.f = null;
  }
  
  private void a(FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    if (paramStGetFeedListRsp == null)
    {
      QLog.w("PYMK-QCirclePersonalPymkModelManager", 1, "[handleFeedListRspResult] rsp should be null.");
      return;
    }
    paramStGetFeedListRsp = paramStGetFeedListRsp.vecFeed.get();
    QLog.d("PYMK-QCirclePersonalPymkModelManager", 1, new Object[] { "[handleFeedListRspResult] result count: ", Integer.valueOf(paramStGetFeedListRsp.size()) });
    a(paramStGetFeedListRsp);
    this.f = null;
  }
  
  private void a(String paramString)
  {
    QCirclePersonalPymkViewModel localQCirclePersonalPymkViewModel = this.b;
    if (localQCirclePersonalPymkViewModel == null)
    {
      QLog.d("PYMK-QCirclePersonalPymkModelManager", 1, "[fetchGuestDataSource] guest view model should be null.");
      return;
    }
    localQCirclePersonalPymkViewModel.a(paramString);
  }
  
  private void a(List<FeedCloudMeta.StFeed> paramList)
  {
    if (this.e == null)
    {
      QLog.d("PYMK-QCirclePersonalPymkModelManager", 1, "[notifyPersonalPymkResult] result callback should not be null.");
      return;
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = (FeedCloudMeta.StFeed)((FeedCloudMeta.StFeed)paramList.get(0)).get();
      this.e.a(paramList);
      return;
    }
    QLog.d("PYMK-QCirclePersonalPymkModelManager", 1, "[notifyPersonalPymkResult] feed list is empty.");
  }
  
  private void b()
  {
    QCircleSplashViewModel localQCircleSplashViewModel = this.c;
    if (localQCircleSplashViewModel == null)
    {
      QLog.d("PYMK-QCirclePersonalPymkModelManager", 1, "[fetchMasterDataSource] master view model should be null.");
      return;
    }
    localQCircleSplashViewModel.a(1);
  }
  
  public void a()
  {
    this.d = new QCirclePersonalPymkModelManager.FeedListRspObserver(this);
    this.b = new QCirclePersonalPymkViewModel();
    this.b.a.observe(this, this.d);
    this.c = new QCircleSplashViewModel();
    this.c.a.observe(this, this.d);
  }
  
  public void a(QCirclePersonalPymkModelManager.OnPersonalPymkResultCallback paramOnPersonalPymkResultCallback)
  {
    this.e = paramOnPersonalPymkResultCallback;
  }
  
  public void a(FeedCloudMeta.StUser paramStUser)
  {
    if (paramStUser == null)
    {
      QLog.d("PYMK-QCirclePersonalPymkModelManager", 1, "[reloadDataSource] poster not is null.");
      return;
    }
    String str = paramStUser.id.get();
    if (QCircleTextUtils.b(this.f, str)) {
      return;
    }
    this.f = str;
    if (QCirclePluginUtil.b(paramStUser))
    {
      b();
      return;
    }
    a(str);
  }
  
  @NonNull
  public Lifecycle getLifecycle()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.manager.QCirclePersonalPymkModelManager
 * JD-Core Version:    0.7.0.1
 */