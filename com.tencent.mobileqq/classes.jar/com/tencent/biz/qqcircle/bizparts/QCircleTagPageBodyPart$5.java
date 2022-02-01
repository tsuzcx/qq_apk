package com.tencent.biz.qqcircle.bizparts;

import com.tencent.biz.qqcircle.viewmodels.QCircleTagPageViewModel;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import feedcloud.FeedCloudRead.StGetFeedListRsp;

class QCircleTagPageBodyPart$5
  implements OnTaskListener<Object>
{
  QCircleTagPageBodyPart$5(QCircleTagPageBodyPart paramQCircleTagPageBodyPart) {}
  
  public void onComplete(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length == 4)) {
      QCircleTagPageBodyPart.a(this.a).a(((Boolean)paramVarArgs[0]).booleanValue(), ((Long)paramVarArgs[1]).longValue(), (String)paramVarArgs[2], (FeedCloudRead.StGetFeedListRsp)paramVarArgs[3], false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleTagPageBodyPart.5
 * JD-Core Version:    0.7.0.1
 */