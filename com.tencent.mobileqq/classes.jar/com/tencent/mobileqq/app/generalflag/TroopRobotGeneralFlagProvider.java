package com.tencent.mobileqq.app.generalflag;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;

public class TroopRobotGeneralFlagProvider
  implements IGeneralFlagProvider
{
  private static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, msg_svc.PbSendMsgReq paramPbSendMsgReq, boolean paramBoolean, generalflags.ResvAttr paramResvAttr)
  {
    if (((TroopRobotManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).a(paramMessageRecord))
    {
      paramResvAttr.uint32_robot_msg_flag.set(1, true);
      if ((paramMessageRecord instanceof MessageForPtt))
      {
        paramQQAppInterface = (MessageForPtt)paramMessageRecord;
        new im_msg_body.Elem();
        new im_msg_body.Text();
        if ((paramQQAppInterface.atInfoList != null) && (!paramQQAppInterface.atInfoList.isEmpty()))
        {
          paramMessageRecord = (im_msg_body.RichText)((im_msg_body.MsgBody)paramPbSendMsgReq.msg_body.get()).rich_text.get();
          MessageProtoCodec.a(paramMessageRecord, paramQQAppInterface.mInputContent, paramQQAppInterface.atInfoList);
          if (paramMessageRecord.elems.has())
          {
            paramQQAppInterface = paramMessageRecord.elems.get().iterator();
            while (paramQQAppInterface.hasNext())
            {
              paramMessageRecord = (im_msg_body.Elem)paramQQAppInterface.next();
              if (paramMessageRecord.text.has())
              {
                paramMessageRecord = (im_msg_body.Text)paramMessageRecord.text.get();
                if (paramMessageRecord.str.has()) {
                  paramMessageRecord.str.set(ByteStringMicro.copyFromUtf8(""));
                }
              }
            }
          }
        }
      }
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public boolean[] a(AppInterface paramAppInterface, boolean paramBoolean1, boolean paramBoolean2, MessageRecord paramMessageRecord, generalflags.ResvAttr paramResvAttr, msg_svc.PbSendMsgReq paramPbSendMsgReq, im_msg_body.GeneralFlags paramGeneralFlags)
  {
    return new boolean[] { paramBoolean1, a((QQAppInterface)paramAppInterface, paramMessageRecord, paramPbSendMsgReq, paramBoolean2, paramResvAttr) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.generalflag.TroopRobotGeneralFlagProvider
 * JD-Core Version:    0.7.0.1
 */