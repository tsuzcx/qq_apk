package com.tencent.av.share;

import com.tencent.av.ReqGroupVideo.ReqPushShareArk;
import com.tencent.av.ReqGroupVideo.RspPushShareArk;
import com.tencent.av.business.handler.MessageHandler;
import com.tencent.av.business.handler.MessageHandler.MsgListener;
import com.tencent.av.common.ErrorInfo;
import com.tencent.qphone.base.util.QLog;

final class ShareChat$4
  extends MessageHandler.MsgListener<ReqGroupVideo.ReqPushShareArk, ReqGroupVideo.RspPushShareArk>
{
  public void a(long paramLong, boolean paramBoolean, ReqGroupVideo.ReqPushShareArk paramReqPushShareArk, ReqGroupVideo.RspPushShareArk paramRspPushShareArk, Object paramObject)
  {
    int i = MessageHandler.a((common.ErrorInfo)paramRspPushShareArk.result.get());
    paramReqPushShareArk = new StringBuilder();
    paramReqPushShareArk.append("shareGAVArkMsg errCode[");
    paramReqPushShareArk.append(i);
    paramReqPushShareArk.append("]");
    QLog.d("ShareChat", 1, paramReqPushShareArk.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.share.ShareChat.4
 * JD-Core Version:    0.7.0.1
 */