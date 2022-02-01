package com.tencent.biz.qqcircle.immersive.aggregation;

import com.tencent.biz.qqcircle.immersive.aggregation.bean.QFSMusicAggregationInitBean;
import com.tencent.biz.qqcircle.immersive.aggregation.request.QFSGetFeedListMusicRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.engineering.preload.BasePreLoadTask;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;

public class QFSMusicAggregationPreLoaderTask
  extends BasePreLoadTask
{
  private QFSMusicAggregationInitBean a;
  
  public QFSMusicAggregationPreLoaderTask(QFSMusicAggregationInitBean paramQFSMusicAggregationInitBean)
  {
    this.a = paramQFSMusicAggregationInitBean;
  }
  
  public void onRemove() {}
  
  public void startLoadData(OnPreLoadListener paramOnPreLoadListener)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    localObject = new QFSGetFeedListMusicRequest((QFSMusicAggregationInitBean)localObject, null, null);
    paramOnPreLoadListener = new QFSMusicAggregationPreLoaderTask.1(this, paramOnPreLoadListener);
    ((QFSGetFeedListMusicRequest)localObject).setEnableCache(true);
    VSNetworkHelper.getInstance().sendRequest((BaseRequest)localObject, paramOnPreLoadListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.aggregation.QFSMusicAggregationPreLoaderTask
 * JD-Core Version:    0.7.0.1
 */