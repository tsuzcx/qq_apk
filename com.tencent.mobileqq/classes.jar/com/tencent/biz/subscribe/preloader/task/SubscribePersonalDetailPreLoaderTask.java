package com.tencent.biz.subscribe.preloader.task;

import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.SubscribePersonalDetailRequest;
import com.tencent.mobileqq.engineering.preload.BasePreLoadTask;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;

public class SubscribePersonalDetailPreLoaderTask
  extends BasePreLoadTask
{
  private String a;
  
  public SubscribePersonalDetailPreLoaderTask(String paramString)
  {
    this.a = paramString;
  }
  
  public void onRemove() {}
  
  public void startLoadData(OnPreLoadListener paramOnPreLoadListener)
  {
    SubscribePersonalDetailRequest localSubscribePersonalDetailRequest = new SubscribePersonalDetailRequest(this.a, null);
    paramOnPreLoadListener = new SubscribePersonalDetailPreLoaderTask.1(this, paramOnPreLoadListener);
    localSubscribePersonalDetailRequest.setEnableCache(true);
    VSNetworkHelper.getInstance().sendRequest(localSubscribePersonalDetailRequest, paramOnPreLoadListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.preloader.task.SubscribePersonalDetailPreLoaderTask
 * JD-Core Version:    0.7.0.1
 */