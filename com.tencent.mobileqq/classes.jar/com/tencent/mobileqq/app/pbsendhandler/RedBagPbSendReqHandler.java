package com.tencent.mobileqq.app.pbsendhandler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ExtraInfo;
import tencent.im.msg.im_msg_body.RichText;

public class RedBagPbSendReqHandler
  implements IPbSendReqHandler
{
  private void a(MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText)
  {
    if (paramMessageRecord.msgtype == -1000)
    {
      Object localObject = (MessageForText)paramMessageRecord;
      if (((MessageForText)localObject).mPasswdRedBagFlag != 0)
      {
        paramMessageRecord = new im_msg_body.ExtraInfo();
        paramMessageRecord.uint64_uin.set(((MessageForText)localObject).mPasswdRedBagSender);
        paramMessageRecord.uint32_msg_state_flag.set(((MessageForText)localObject).mPasswdRedBagFlag);
        localObject = new im_msg_body.Elem();
        ((im_msg_body.Elem)localObject).extra_info.set(paramMessageRecord);
        paramRichText.elems.add((MessageMicro)localObject);
      }
    }
  }
  
  public msg_svc.PbSendMsgReq a(AppInterface paramAppInterface, MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText, int paramInt, msg_svc.PbSendMsgReq paramPbSendMsgReq)
  {
    a(paramMessageRecord, paramRichText);
    return paramPbSendMsgReq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.pbsendhandler.RedBagPbSendReqHandler
 * JD-Core Version:    0.7.0.1
 */