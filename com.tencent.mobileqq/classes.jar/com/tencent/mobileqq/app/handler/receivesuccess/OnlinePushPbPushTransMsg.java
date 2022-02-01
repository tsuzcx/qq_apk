package com.tencent.mobileqq.app.handler.receivesuccess;

import android.os.Bundle;
import com.tencent.imcore.message.BaseMessageProcessor;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.util.NoDisturbUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.onlinepush.OnlinePushTrans.ExtGroupKeyInfo;
import com.tencent.pb.onlinepush.OnlinePushTrans.PbMsgInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public class OnlinePushPbPushTransMsg
{
  public static void a(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("OnlinePush.PbPushTransMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      Object localObject = paramFromServiceMsg.getWupBuffer();
      byte[] arrayOfByte = new byte[localObject.length - 4];
      PkgTools.copyData(arrayOfByte, 0, (byte[])localObject, 4, localObject.length - 4);
      localObject = new OnlinePushTrans.PbMsgInfo();
      try
      {
        ((OnlinePushTrans.PbMsgInfo)localObject).mergeFrom(arrayOfByte);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localObject = null;
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
      int i;
      if (localObject != null)
      {
        if ((((OnlinePushTrans.PbMsgInfo)localObject).uint32_general_flag.get() & 0x20) == 32) {
          NoDisturbUtil.a(true);
        } else {
          NoDisturbUtil.a(false);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, new Object[] { "PbPushTransMsg muteGeneralFlag:", Integer.valueOf(((OnlinePushTrans.PbMsgInfo)localObject).uint32_general_flag.get()) });
        }
        if (((OnlinePushTrans.PbMsgInfo)localObject).msg_type.get() == 207)
        {
          paramMessageHandler.a(((OnlinePushTrans.PbMsgInfo)localObject).msg_data.get().toByteArray());
        }
        else if ((((OnlinePushTrans.PbMsgInfo)localObject).msg_type.get() != 44) && (((OnlinePushTrans.PbMsgInfo)localObject).msg_type.get() != 34))
        {
          if ((((OnlinePushTrans.PbMsgInfo)localObject).msg_type.get() == 529) && (((OnlinePushTrans.PbMsgInfo)localObject).msg_subtype.get() == 11)) {
            paramMessageHandler.a("video_processor").a(3001, new Object[] { paramToServiceMsg, paramFromServiceMsg, ((OnlinePushTrans.PbMsgInfo)localObject).msg_data.get().toByteArray() });
          }
        }
        else
        {
          paramMessageHandler.a().a(3, 1, false);
          long l1;
          long l2;
          if (((OnlinePushTrans.PbMsgInfo)localObject).msg_type.get() == 34)
          {
            paramToServiceMsg = (TroopGagMgr)paramMessageHandler.a.getManager(QQManagerFactory.TROOP_GAG_MANAGER);
            paramToServiceMsg = ((OnlinePushTrans.PbMsgInfo)localObject).msg_data.get().toByteArray();
            l1 = PkgTools.getLongData(paramToServiceMsg, 0);
            i = paramToServiceMsg[4];
            l2 = PkgTools.getLongData(paramToServiceMsg, 5);
            ((OnlinePushTrans.PbMsgInfo)localObject).from_uin.get();
            ((TroopManager)paramMessageHandler.a.getManager(QQManagerFactory.TROOP_MANAGER)).a(String.valueOf(l1), String.valueOf(l2), i);
            paramToServiceMsg = (OnlinePushTrans.ExtGroupKeyInfo)((OnlinePushTrans.PbMsgInfo)localObject).ext_group_key_info.get();
            if (paramToServiceMsg != null)
            {
              l1 = paramToServiceMsg.cur_max_seq.get();
              l2 = paramToServiceMsg.cur_time.get();
              if (QLog.isColorLevel())
              {
                paramToServiceMsg = new StringBuilder();
                paramToServiceMsg.append("OnlinePushTrans 0x22 maxseq = ");
                paramToServiceMsg.append(l1);
                paramToServiceMsg.append(", maxTime = ");
                paramToServiceMsg.append(l2);
                QLog.d("GrayTipsForTroop", 2, paramToServiceMsg.toString());
              }
            }
          }
          else if (((OnlinePushTrans.PbMsgInfo)localObject).msg_type.get() == 44)
          {
            paramToServiceMsg = ((OnlinePushTrans.PbMsgInfo)localObject).msg_data.get().toByteArray();
            long l3 = PkgTools.getLongData(paramToServiceMsg, 0);
            i = paramToServiceMsg[4];
            i = paramToServiceMsg[5];
            l2 = 0L;
            if ((i != 0) && (i != 1))
            {
              l1 = PkgTools.getLongData(paramToServiceMsg, 6);
              l2 = PkgTools.getLongData(paramToServiceMsg, 10);
            }
            else
            {
              l1 = PkgTools.getLongData(paramToServiceMsg, 6);
            }
            if (QLog.isColorLevel()) {
              QLog.d(".troop.push_msg", 2, new Object[] { "GroupCode: ", Long.valueOf(l3) });
            }
            AIOUtils.a(".troop.push_msg", paramMessageHandler.a, 86, 0, 0, Arrays.asList(new Long[] { Long.valueOf(l3), Long.valueOf(l1), Long.valueOf(l2) }), 500);
          }
        }
      }
      paramToServiceMsg = paramMessageHandler.createToServiceMsg("OnlinePush.RespPush");
      if (localObject != null)
      {
        i = paramFromServiceMsg.getRequestSsoSeq();
        paramToServiceMsg.extraData.putInt("svrip", ((OnlinePushTrans.PbMsgInfo)localObject).svr_ip.get());
        paramToServiceMsg.extraData.putInt("seq", i);
      }
      paramToServiceMsg.extraData.putLong("lUin", Long.parseLong(paramMessageHandler.a.getCurrentAccountUin()));
      paramToServiceMsg.setNeedCallback(false);
      paramMessageHandler.send(paramToServiceMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.OnlinePushPbPushTransMsg
 * JD-Core Version:    0.7.0.1
 */