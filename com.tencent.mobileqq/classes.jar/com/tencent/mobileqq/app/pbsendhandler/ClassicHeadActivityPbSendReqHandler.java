package com.tencent.mobileqq.app.pbsendhandler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.utils.ClassicHeadActivityManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype13;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.RichText;

public class ClassicHeadActivityPbSendReqHandler
  implements IPbSendReqHandler
{
  private void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText)
  {
    paramQQAppInterface = (ClassicHeadActivityManager)paramQQAppInterface.getManager(QQManagerFactory.CLASSIC_HEAD_ACIVITY_MANAGER);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.a()) && (paramQQAppInterface.c() == 1L) && ((paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 3000)))
    {
      paramQQAppInterface = paramQQAppInterface.d();
      if (paramQQAppInterface != null)
      {
        int i = paramQQAppInterface.systemHeadID;
        int j = paramQQAppInterface.bHeadType;
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append(" QQ 18 aniversary activity send system head id = ");
          paramQQAppInterface.append(i);
          paramQQAppInterface.append(", head flag = ");
          paramQQAppInterface.append(j);
          QLog.d("Q.msg.MessageHandlerUtils", 4, new Object[] { Integer.valueOf(2), paramQQAppInterface.toString() });
        }
        paramQQAppInterface = new im_msg_body.Elem();
        paramMessageRecord = new im_msg_body.CommonElem();
        paramMessageRecord.uint32_service_type.set(13);
        hummer_commelem.MsgElemInfo_servtype13 localMsgElemInfo_servtype13 = new hummer_commelem.MsgElemInfo_servtype13();
        localMsgElemInfo_servtype13.uint32_sys_head_id.set(i);
        localMsgElemInfo_servtype13.uint32_head_flag.set(j);
        paramMessageRecord.bytes_pb_elem.set(ByteStringMicro.copyFrom(localMsgElemInfo_servtype13.toByteArray()));
        paramQQAppInterface.common_elem.set(paramMessageRecord);
        paramRichText.elems.add(paramQQAppInterface);
      }
    }
  }
  
  public msg_svc.PbSendMsgReq a(AppInterface paramAppInterface, MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText, int paramInt, msg_svc.PbSendMsgReq paramPbSendMsgReq)
  {
    a((QQAppInterface)paramAppInterface, paramMessageRecord, paramRichText);
    return paramPbSendMsgReq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.pbsendhandler.ClassicHeadActivityPbSendReqHandler
 * JD-Core Version:    0.7.0.1
 */