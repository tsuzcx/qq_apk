package com.tencent.biz.qqcircle.immersive.tab;

import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.requests.QCircleClearCountRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import feedcloud.FeedCloudRead.StClearCountInfo;

class QFSFollowTabFragment$1
  implements Runnable
{
  QFSFollowTabFragment$1(QFSFollowTabFragment paramQFSFollowTabFragment, long paramLong) {}
  
  public void run()
  {
    Object localObject = new FeedCloudRead.StClearCountInfo();
    ((FeedCloudRead.StClearCountInfo)localObject).clearType.set(3);
    ((FeedCloudRead.StClearCountInfo)localObject).countType.set(2);
    ((FeedCloudRead.StClearCountInfo)localObject).rewriteClearTime.set(this.a);
    localObject = new QCircleClearCountRequest(HostDataTransUtils.getAccount(), (FeedCloudRead.StClearCountInfo)localObject);
    VSNetworkHelper.getInstance().sendRequest((BaseRequest)localObject, new QFSFollowTabFragment.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.tab.QFSFollowTabFragment.1
 * JD-Core Version:    0.7.0.1
 */