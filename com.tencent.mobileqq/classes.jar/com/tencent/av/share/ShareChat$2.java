package com.tencent.av.share;

import com.tencent.av.ReqGroupVideo.ReqCreateShareUrl;
import com.tencent.av.ReqGroupVideo.RspCreateShareUrl;
import com.tencent.av.business.handler.MessageHandler;
import com.tencent.av.business.handler.MessageHandler.MsgListener;
import com.tencent.av.common.ErrorInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.utils.QAVGroupConfig;
import com.tencent.mobileqq.utils.QAVGroupConfig.ConfigInfo;
import com.tencent.qphone.base.util.QLog;

class ShareChat$2
  extends MessageHandler.MsgListener<ReqGroupVideo.ReqCreateShareUrl, ReqGroupVideo.RspCreateShareUrl>
{
  ShareChat$2(ShareChat paramShareChat) {}
  
  public void a(long paramLong, boolean paramBoolean, ReqGroupVideo.ReqCreateShareUrl paramReqCreateShareUrl, ReqGroupVideo.RspCreateShareUrl paramRspCreateShareUrl, Object paramObject)
  {
    this.a.jdField_a_of_type_Boolean = false;
    paramReqCreateShareUrl = paramRspCreateShareUrl.share_url_with_no_sig.get().toStringUtf8();
    paramObject = paramRspCreateShareUrl.share_url.get().toStringUtf8();
    paramRspCreateShareUrl = (common.ErrorInfo)paramRspCreateShareUrl.result.get();
    int i = MessageHandler.a(paramRspCreateShareUrl);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestGetUrlFromServer.callback, result[");
    localStringBuilder.append(i);
    localStringBuilder.append("], bytes_errmsg[");
    localStringBuilder.append(paramRspCreateShareUrl.bytes_errmsg.get().toStringUtf8());
    localStringBuilder.append("], shareUrlWithNoSig[");
    localStringBuilder.append(paramReqCreateShareUrl);
    localStringBuilder.append("], shareUrl[");
    localStringBuilder.append(paramObject);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w("ShareChat", 1, localStringBuilder.toString());
    if (i == 0)
    {
      paramRspCreateShareUrl = this.a;
      paramRspCreateShareUrl.c = paramObject;
      paramRspCreateShareUrl.b = paramReqCreateShareUrl;
      QAVGroupConfig.a().a(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.a.b, this.a.c);
    }
    paramReqCreateShareUrl = this.a;
    paramReqCreateShareUrl.a(paramReqCreateShareUrl.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.share.ShareChat.2
 * JD-Core Version:    0.7.0.1
 */