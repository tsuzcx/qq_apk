package com.tencent.mobileqq.app.pbsendhandler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.NearByMessageType;
import tencent.im.msg.im_msg_body.RichText;

public class ClearingMsgPbSendReqHandler
  implements IPbSendReqHandler
{
  public msg_svc.PbSendMsgReq a(AppInterface paramAppInterface, MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText, int paramInt, msg_svc.PbSendMsgReq paramPbSendMsgReq)
  {
    paramAppInterface = DatingUtil.a(paramMessageRecord);
    if (paramAppInterface != null)
    {
      if (QLog.isColorLevel())
      {
        paramMessageRecord = new StringBuilder();
        paramMessageRecord.append("clearingElem has carry, elem:");
        paramMessageRecord.append(paramAppInterface.near_by_msg.uint32_type.get());
        QLog.d("Q.nearby_bank", 2, paramMessageRecord.toString());
      }
      paramRichText.elems.add(paramAppInterface);
    }
    return paramPbSendMsgReq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.pbsendhandler.ClearingMsgPbSendReqHandler
 * JD-Core Version:    0.7.0.1
 */