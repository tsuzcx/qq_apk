package com.tencent.biz.subscribe.preloader.task;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.subscribe.network.GetSubscribeFeedDetailRequest;
import com.tencent.mobileqq.engineering.preload.BasePreLoadTask;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;

public class SubscribeDetailPreLoaderTask
  extends BasePreLoadTask
{
  private CertifiedAccountMeta.StFeed a;
  
  public SubscribeDetailPreLoaderTask(CertifiedAccountMeta.StFeed paramStFeed)
  {
    this.a = paramStFeed;
  }
  
  public void onRemove() {}
  
  public void startLoadData(OnPreLoadListener paramOnPreLoadListener)
  {
    GetSubscribeFeedDetailRequest localGetSubscribeFeedDetailRequest = new GetSubscribeFeedDetailRequest(this.a, null);
    paramOnPreLoadListener = new SubscribeDetailPreLoaderTask.1(this, paramOnPreLoadListener);
    localGetSubscribeFeedDetailRequest.setEnableCache(false);
    VSNetworkHelper.getInstance().sendRequest(localGetSubscribeFeedDetailRequest, paramOnPreLoadListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.preloader.task.SubscribeDetailPreLoaderTask
 * JD-Core Version:    0.7.0.1
 */