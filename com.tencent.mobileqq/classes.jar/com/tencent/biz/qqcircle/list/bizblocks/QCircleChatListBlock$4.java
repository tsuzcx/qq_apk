package com.tencent.biz.qqcircle.list.bizblocks;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import qqcircle.QQCirclePrivateMsgShow.StBatchGetPMGiftInfoRsp;
import vjl;
import zxa;

class QCircleChatListBlock$4
  implements zxa<QQCirclePrivateMsgShow.StBatchGetPMGiftInfoRsp>
{
  QCircleChatListBlock$4(QCircleChatListBlock paramQCircleChatListBlock) {}
  
  public void onReceive(boolean paramBoolean, long paramLong, String paramString, QQCirclePrivateMsgShow.StBatchGetPMGiftInfoRsp paramStBatchGetPMGiftInfoRsp)
  {
    if ((paramBoolean) && (paramLong == 0L) && (paramStBatchGetPMGiftInfoRsp != null))
    {
      vjl.a().a(paramStBatchGetPMGiftInfoRsp.userGiftInfos.get());
      QCircleChatListBlock.access$300(this.this$0);
      QCircleChatListBlock.access$400(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.list.bizblocks.QCircleChatListBlock.4
 * JD-Core Version:    0.7.0.1
 */