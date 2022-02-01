package com.tencent.biz.qqcircle.fragments.main;

import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.requests.QCircleClearCountRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil;
import feedcloud.FeedCloudRead.StClearCountInfo;

class QCircleFolderFollowTabFragment$4
  implements Runnable
{
  QCircleFolderFollowTabFragment$4(QCircleFolderFollowTabFragment paramQCircleFolderFollowTabFragment) {}
  
  public void run()
  {
    Object localObject = new FeedCloudRead.StClearCountInfo();
    ((FeedCloudRead.StClearCountInfo)localObject).clearType.set(1);
    ((FeedCloudRead.StClearCountInfo)localObject).countType.set(1);
    ((FeedCloudRead.StClearCountInfo)localObject).delayTimeInterval.set(EeveeRedpointUtil.getFollowTabClearRedDotDelayInSecond());
    localObject = new QCircleClearCountRequest(HostDataTransUtils.getAccount(), (FeedCloudRead.StClearCountInfo)localObject);
    VSNetworkHelper.getInstance().sendRequest((BaseRequest)localObject, new QCircleFolderFollowTabFragment.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.main.QCircleFolderFollowTabFragment.4
 * JD-Core Version:    0.7.0.1
 */