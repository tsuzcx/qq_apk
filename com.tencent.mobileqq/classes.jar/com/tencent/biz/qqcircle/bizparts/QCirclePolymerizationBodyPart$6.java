package com.tencent.biz.qqcircle.bizparts;

import com.tencent.biz.qqcircle.viewmodels.QCirclePolymerizationViewModel;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import feedcloud.FeedCloudRead.StGetFeedListRsp;

class QCirclePolymerizationBodyPart$6
  implements OnTaskListener<Object>
{
  QCirclePolymerizationBodyPart$6(QCirclePolymerizationBodyPart paramQCirclePolymerizationBodyPart) {}
  
  public void onComplete(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length == 4)) {
      QCirclePolymerizationBodyPart.a(this.a).a(((Boolean)paramVarArgs[0]).booleanValue(), ((Long)paramVarArgs[1]).longValue(), (String)paramVarArgs[2], (FeedCloudRead.StGetFeedListRsp)paramVarArgs[3], false, QCirclePolymerizationBodyPart.b(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePolymerizationBodyPart.6
 * JD-Core Version:    0.7.0.1
 */