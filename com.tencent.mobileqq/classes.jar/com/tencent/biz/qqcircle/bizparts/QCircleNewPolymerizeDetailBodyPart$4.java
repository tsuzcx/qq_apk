package com.tencent.biz.qqcircle.bizparts;

import com.tencent.biz.qqcircle.viewmodels.QCirclePolymerizeDetailViewModel;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import feedcloud.FeedCloudRead.StGetFeedListRsp;

class QCircleNewPolymerizeDetailBodyPart$4
  implements OnTaskListener<Object>
{
  QCircleNewPolymerizeDetailBodyPart$4(QCircleNewPolymerizeDetailBodyPart paramQCircleNewPolymerizeDetailBodyPart) {}
  
  public void onComplete(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length == 4)) {
      QCircleNewPolymerizeDetailBodyPart.a(this.a).a(((Boolean)paramVarArgs[0]).booleanValue(), ((Long)paramVarArgs[1]).longValue(), (String)paramVarArgs[2], (FeedCloudRead.StGetFeedListRsp)paramVarArgs[3], false, QCircleNewPolymerizeDetailBodyPart.b(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleNewPolymerizeDetailBodyPart.4
 * JD-Core Version:    0.7.0.1
 */