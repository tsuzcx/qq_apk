package com.tencent.biz.qqcircle.fragments.main;

import com.tencent.biz.qqcircle.requests.QCircleClearCountRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import feedcloud.FeedCloudRead.StClearCountInfo;
import mqq.app.AppRuntime;
import vog;
import vtd;

public class QCircleFolderFollowTabFragment$6
  implements Runnable
{
  QCircleFolderFollowTabFragment$6(QCircleFolderFollowTabFragment paramQCircleFolderFollowTabFragment) {}
  
  public void run()
  {
    Object localObject = new FeedCloudRead.StClearCountInfo();
    ((FeedCloudRead.StClearCountInfo)localObject).clearType.set(1);
    ((FeedCloudRead.StClearCountInfo)localObject).countType.set(1);
    ((FeedCloudRead.StClearCountInfo)localObject).delayTimeInterval.set(vtd.h());
    localObject = new QCircleClearCountRequest(BaseApplicationImpl.getApplication().getRuntime().getAccount(), (FeedCloudRead.StClearCountInfo)localObject);
    VSNetworkHelper.a().a((VSBaseRequest)localObject, new vog(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.main.QCircleFolderFollowTabFragment.6
 * JD-Core Version:    0.7.0.1
 */