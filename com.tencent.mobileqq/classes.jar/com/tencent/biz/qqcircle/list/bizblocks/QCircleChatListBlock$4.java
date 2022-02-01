package com.tencent.biz.qqcircle.list.bizblocks;

import com.tencent.biz.qqcircle.fragments.chat.QCircleChatGiftManager;
import com.tencent.biz.qqcircle.utils.QCircleProtoUtil;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import qqcircle.QQCirclePrivateMsgShow.StBatchGetPMGiftInfoRsp;

class QCircleChatListBlock$4
  implements VSDispatchObserver.onVSRspCallBack<QQCirclePrivateMsgShow.StBatchGetPMGiftInfoRsp>
{
  QCircleChatListBlock$4(QCircleChatListBlock paramQCircleChatListBlock) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCirclePrivateMsgShow.StBatchGetPMGiftInfoRsp paramStBatchGetPMGiftInfoRsp)
  {
    if ((paramBoolean) && (paramLong == 0L) && (paramStBatchGetPMGiftInfoRsp != null))
    {
      QCircleChatGiftManager.getInstance().saveGiftInfo(QCircleProtoUtil.d(paramStBatchGetPMGiftInfoRsp.userGiftInfos.get()));
      QCircleChatListBlock.access$100(this.a);
      QCircleChatListBlock.access$200(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.list.bizblocks.QCircleChatListBlock.4
 * JD-Core Version:    0.7.0.1
 */