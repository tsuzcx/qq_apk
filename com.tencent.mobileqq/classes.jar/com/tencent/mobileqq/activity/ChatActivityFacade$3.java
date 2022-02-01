package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.requests.QCircleStGetC2CFeedRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetC2CFeedReq;

final class ChatActivityFacade$3
  implements Runnable
{
  ChatActivityFacade$3(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean) {}
  
  public void run()
  {
    if ((!ChatActivityFacade.i(this.a, this.b)) && (!ChatActivityFacade.e(this.a, this.b, true)))
    {
      QLog.d("ChatActivityFacade.QCircleFeeds", 2, "QCircleStGetC2CFeedRequest: (isShowStatus || isNeedInsertQCircleNewestFeeds) == false");
      return;
    }
    if (TextUtils.isEmpty(this.b.b))
    {
      QLog.e("ChatActivityFacade.QCircleFeeds", 2, "QCircleStGetC2CFeedRequest: sessionInfo.curFriendUin is empty");
      return;
    }
    QCircleStGetC2CFeedRequest localQCircleStGetC2CFeedRequest = new QCircleStGetC2CFeedRequest(this.b.b);
    String str = ChatActivityFacade.k(this.a, this.b);
    localQCircleStGetC2CFeedRequest.mReq.attchInfo.set(str);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QCircleStGetC2CFeedRequest: request.attchInfo==");
    localStringBuilder.append(str);
    QLog.d("ChatActivityFacade.QCircleFeeds", 2, localStringBuilder.toString());
    VSNetworkHelper.getInstance().sendRequest(localQCircleStGetC2CFeedRequest, new ChatActivityFacade.3.1(this));
    ChatActivityFacade.e(this.a, this.b, "key_last_req_aio_qcircle_feeds_time");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.3
 * JD-Core Version:    0.7.0.1
 */