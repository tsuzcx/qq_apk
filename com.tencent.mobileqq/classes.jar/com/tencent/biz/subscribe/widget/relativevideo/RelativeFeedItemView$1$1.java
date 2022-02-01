package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLike;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoLikeRsp;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.subscribe.event.PraisedUpdateEvents;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;

class RelativeFeedItemView$1$1
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountWrite.StDoLikeRsp>
{
  RelativeFeedItemView$1$1(RelativeFeedItemView.1 param1) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountWrite.StDoLikeRsp paramStDoLikeRsp)
  {
    RelativeFeedItemView.a(this.a.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeFeedItemView, true);
    if ((paramBoolean) && (paramLong == 0L) && (paramStDoLikeRsp != null))
    {
      int i;
      if (paramStDoLikeRsp.like.status.get() == 1) {
        i = this.a.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.likeInfo.count.get() + 1;
      } else {
        i = this.a.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.likeInfo.count.get() - 1;
      }
      paramString = this.a.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get();
      if (paramStDoLikeRsp.like.status.get() == 1) {
        paramBaseRequest = "like";
      } else {
        paramBaseRequest = "cancel_like";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(RelativeFeedItemView.a(this.a.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeFeedItemView));
      localStringBuilder.append("");
      VSReporter.a(paramString, "auth_feeds", paramBaseRequest, 0, 0, new String[] { "", localStringBuilder.toString(), this.a.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.nick.get(), this.a.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.title.get() });
      SimpleEventBus.getInstance().dispatchEvent(new PraisedUpdateEvents(this.a.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get(), paramStDoLikeRsp.like.status.get(), i));
      return;
    }
    QQToast.a(this.a.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeFeedItemView.getContext(), 1, paramString, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView.1.1
 * JD-Core Version:    0.7.0.1
 */