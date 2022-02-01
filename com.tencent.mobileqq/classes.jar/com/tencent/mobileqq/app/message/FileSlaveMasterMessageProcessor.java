package com.tencent.mobileqq.app.message;

import IMMsgBodyPack.SlaveMasterMsg;
import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import com.qq.taf.jce.JceInputStream;
import com.tencent.imcore.message.BaseMessageProcessor;
import com.tencent.imcore.message.OnLinePushParamReturnMsg;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.NotOnlineFile;
import tencent.im.msg.resv21.hummer_resv_21.FileImgInfo;
import tencent.im.msg.resv21.hummer_resv_21.ResvAttr;
import tencent.im.s2c.msgtype0x211.submsgtype0x4.SubMsgType0x4.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x4.SubMsgType0x4.WlanRecvNotify;

public class FileSlaveMasterMessageProcessor
  extends BaseMessageProcessor
{
  public FileSlaveMasterMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private void a(MessageHandler paramMessageHandler, MsgInfo paramMsgInfo, SlaveMasterMsg paramSlaveMasterMsg)
  {
    Object localObject1 = new SubMsgType0x4.MsgBody();
    Object localObject2;
    do
    {
      for (;;)
      {
        try
        {
          localObject2 = (SubMsgType0x4.MsgBody)((SubMsgType0x4.MsgBody)localObject1).mergeFrom(paramSlaveMasterMsg.vOrigMsg);
          if (!((SubMsgType0x4.MsgBody)localObject2).msg_not_online_file.has()) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : MsgBody is NotOnlineFile");
          }
          im_msg_body.NotOnlineFile localNotOnlineFile = (im_msg_body.NotOnlineFile)((SubMsgType0x4.MsgBody)localObject2).msg_not_online_file.get();
          if (((SubMsgType0x4.MsgBody)localObject2).resv_attr.has())
          {
            localObject1 = (hummer_resv_21.ResvAttr)((SubMsgType0x4.MsgBody)localObject2).resv_attr.get();
            if (((SubMsgType0x4.MsgBody)localObject2).file_image_info.has()) {
              ((hummer_resv_21.ResvAttr)localObject1).file_image_info.set(((SubMsgType0x4.MsgBody)localObject2).file_image_info.get());
            }
            localObject2 = new ArrayList();
            msg_comm.Msg localMsg = new msg_comm.Msg();
            localMsg.msg_head.msg_uid.set(paramMsgInfo.lMsgUid);
            localMsg.msg_head.msg_time.set(paramMsgInfo.uRealMsgTime);
            localMsg.msg_head.from_uin.set(paramSlaveMasterMsg.lFromUin);
            localMsg.msg_head.msg_seq.set((int)paramSlaveMasterMsg.uSeq);
            paramMessageHandler.a.getFileTransferHandler().a(paramMessageHandler, (List)localObject2, localMsg, localNotOnlineFile, String.valueOf(paramSlaveMasterMsg.lToUin), true, false, -100L, -1, (hummer_resv_21.ResvAttr)localObject1);
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramMessageHandler)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x4] failed", paramMessageHandler);
          return;
        }
        localObject1 = new hummer_resv_21.ResvAttr();
      }
    } while (!((SubMsgType0x4.MsgBody)localObject2).msg_wlan_recved_notify.has());
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.BaseMessageProcessor", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : MsgBody is WlanRecvedNotify");
    }
    paramMessageHandler.a.getFileTransferHandler().a((SubMsgType0x4.WlanRecvNotify)((SubMsgType0x4.MsgBody)localObject2).msg_wlan_recved_notify.get());
  }
  
  private boolean a(MsgInfo paramMsgInfo)
  {
    JceInputStream localJceInputStream = new JceInputStream(paramMsgInfo.vMsg);
    SlaveMasterMsg localSlaveMasterMsg = new SlaveMasterMsg();
    localSlaveMasterMsg.readFrom(localJceInputStream);
    if (((int)localSlaveMasterMsg.uMsgType == 529) && (4L == localSlaveMasterMsg.uCmd))
    {
      a(this.a.getMsgHandler(), paramMsgInfo, localSlaveMasterMsg);
      return true;
    }
    return false;
  }
  
  public OnLinePushParamReturnMsg a(int paramInt, MsgInfo paramMsgInfo, SvcReqPushMsg paramSvcReqPushMsg)
  {
    boolean bool = false;
    switch (paramInt)
    {
    }
    for (;;)
    {
      return new OnLinePushParamReturnMsg(null, bool);
      if ((paramMsgInfo != null) && (paramSvcReqPushMsg != null)) {
        bool = a(paramMsgInfo);
      } else {
        a(getClass().getName(), paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.FileSlaveMasterMessageProcessor
 * JD-Core Version:    0.7.0.1
 */