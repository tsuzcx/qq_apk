package com.tencent.biz.qqcircle.preload.task;

import com.tencent.biz.qqcircle.requests.QCircleGetCommentListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.engineering.preload.BasePreLoadTask;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;

public class QCircleCommentPreLoaderTask
  extends BasePreLoadTask
{
  private FeedCloudMeta.StFeed a;
  
  public void onRemove() {}
  
  public void startLoadData(OnPreLoadListener paramOnPreLoadListener)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = new QCircleGetCommentListRequest((FeedCloudMeta.StFeed)localObject, null, 20, ((FeedCloudMeta.StFeed)localObject).likeInfo.id.get(), false);
      paramOnPreLoadListener = new QCircleCommentPreLoaderTask.1(this, paramOnPreLoadListener);
      ((QCircleGetCommentListRequest)localObject).setEnableCache(true);
      VSNetworkHelper.getInstance().sendRequest((BaseRequest)localObject, paramOnPreLoadListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.preload.task.QCircleCommentPreLoaderTask
 * JD-Core Version:    0.7.0.1
 */