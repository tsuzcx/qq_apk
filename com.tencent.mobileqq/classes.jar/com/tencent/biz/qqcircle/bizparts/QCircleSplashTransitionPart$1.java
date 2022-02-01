package com.tencent.biz.qqcircle.bizparts;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.viewmodels.QCircleSplashViewModel;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase.StNewUserPymkPageData;

class QCircleSplashTransitionPart$1
  implements Observer<UIStateData<FeedCloudRead.StGetFeedListRsp>>
{
  QCircleSplashTransitionPart$1(QCircleSplashTransitionPart paramQCircleSplashTransitionPart) {}
  
  public void a(@Nullable UIStateData<FeedCloudRead.StGetFeedListRsp> paramUIStateData)
  {
    if ((QCircleSplashTransitionPart.a(this.a) != null) && (QCircleSplashTransitionPart.a(this.a).b() != null) && (QCircleSplashTransitionPart.a(this.a).b().busiRspData.has()))
    {
      paramUIStateData = new QQCircleFeedBase.StFeedListBusiRspData();
      try
      {
        paramUIStateData.mergeFrom(QCircleSplashTransitionPart.a(this.a).b().busiRspData.get().toByteArray());
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
      QCircleSplashTransitionPart localQCircleSplashTransitionPart = this.a;
      boolean bool;
      if (paramUIStateData.newUserPymkPageData.friends.size() > 0) {
        bool = true;
      } else {
        bool = false;
      }
      QCircleSplashTransitionPart.a(localQCircleSplashTransitionPart, bool);
      if (QCircleSplashTransitionPart.b(this.a))
      {
        QCircleSplashTransitionPart.a(this.a, paramUIStateData);
        return;
      }
      QCircleSplashTransitionPart.c(this.a);
      return;
    }
    QCircleSplashTransitionPart.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleSplashTransitionPart.1
 * JD-Core Version:    0.7.0.1
 */