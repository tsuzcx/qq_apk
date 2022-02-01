package com.tencent.imcore.message.ext.codec.decoder.pbelement;

import com.tencent.biz.bmqq.protocol.Crm.CrmCCNotify;
import com.tencent.biz.bmqq.protocol.Crm.GrayMsg;
import com.tencent.biz.bmqq.protocol.Crm.QidianGroupMsg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.TempSessionInfo;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qidian.util.QidianUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body.CrmElem;
import tencent.im.msg.im_msg_body.Elem;

public class CrmFlagsElemDecoder
  extends SimplePBElemDecoder
{
  public int a()
  {
    return -1000;
  }
  
  void a(int paramInt, List<MessageRecord> paramList, msg_comm.Msg paramMsg, TempSessionInfo paramTempSessionInfo, MessageHandler paramMessageHandler)
  {
    if (!paramList.isEmpty()) {
      ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("crmelem_qidian_flag", paramInt + "");
    }
    paramList = paramMessageHandler.a.getCurrentAccountUin();
    paramMsg = String.valueOf(paramMsg.msg_head.from_uin.get());
    if (!paramList.equals(paramMsg))
    {
      paramList = (QidianManager)paramMessageHandler.a.getManager(QQManagerFactory.QIDIAN_MANAGER);
      if (!paramList.a.containsKey(paramMsg)) {
        paramList.a(new BmqqAccountType(paramMsg, 1));
      }
    }
    if ((paramTempSessionInfo != null) && (paramTempSessionInfo.a == 1024)) {
      paramTempSessionInfo.a = 1025;
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, im_msg_body.CrmElem paramCrmElem, List<MessageRecord> paramList, msg_comm.Msg paramMsg, TempSessionInfo paramTempSessionInfo)
  {
    Crm.CrmCCNotify localCrmCCNotify = new Crm.CrmCCNotify();
    Object localObject = paramQQAppInterface.getMsgHandler();
    try
    {
      localCrmCCNotify.mergeFrom(paramCrmElem.crm_buf.get().toByteArray());
      int i = localCrmCCNotify.crm_flag.get();
      int j;
      long l1;
      if ((i == 8) && (localCrmCCNotify.qidian_group_msg.has()))
      {
        paramCrmElem = (Crm.QidianGroupMsg)localCrmCCNotify.qidian_group_msg.get();
        j = paramCrmElem.uint32_group_task_id.get();
        int k = paramCrmElem.uint32_group_msg_type.get();
        l1 = paramCrmElem.uint64_kfuin.get();
        int m = paramCrmElem.uint32_show_tip.get();
        paramCrmElem = paramCrmElem.str_tip_text.get();
        if (!paramList.isEmpty())
        {
          MessageRecord localMessageRecord = (MessageRecord)paramList.get(0);
          if (localMessageRecord != null)
          {
            localMessageRecord.mQidianTaskId = j;
            localMessageRecord.mQidianMasterUin = l1;
            localMessageRecord.mIsShowQidianTips = m;
            localMessageRecord.mQidianTipText = paramCrmElem;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("CrmFlagsElemDecoder", 2, String.format("received qidian bulk message taskId: %d, msgType: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) }));
        }
        MessageProtoCodec.a((MessageHandler)localObject, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
        if (j != 0)
        {
          paramCrmElem = (QidianHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER);
          localObject = new JSONObject();
          ((JSONObject)localObject).put("action", "receive");
          ((JSONObject)localObject).put("fromUin", String.valueOf(paramMsg.msg_head.from_uin.get()));
          ((JSONObject)localObject).put("toUin", paramQQAppInterface.getCurrentAccountUin());
          ((JSONObject)localObject).put("taskID", String.valueOf(j));
          ((JSONObject)localObject).put("clickURL", "");
          ((JSONObject)localObject).put("timestamp", String.valueOf(System.currentTimeMillis() / 1000L));
          paramCrmElem.a(((JSONObject)localObject).toString(), String.valueOf(paramMsg.msg_head.from_uin.get()), "", 10009, 0);
        }
      }
      if ((i == 11) && (localCrmCCNotify.msg_gray_msg.has()))
      {
        localObject = (Crm.GrayMsg)localCrmCCNotify.msg_gray_msg.get();
        i = ((Crm.GrayMsg)localObject).uint32_type.get();
        paramCrmElem = ((Crm.GrayMsg)localObject).str_text.get();
        l1 = ((Crm.GrayMsg)localObject).uint64_from_uin.get();
        j = paramMsg.msg_head.msg_seq.get();
        long l2 = paramMsg.msg_head.msg_uid.get();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(l2);
        if (QLog.isColorLevel()) {
          QLog.d("CrmFlagsElemDecoder", 2, String.format("received qidian gray msg type: %d, tips: %s, fromUin: %d", new Object[] { Integer.valueOf(i), paramCrmElem, Long.valueOf(l1) }));
        }
        QidianUtils.a(paramQQAppInterface, String.valueOf(l1), paramCrmElem, 1024, ((StringBuilder)localObject).toString());
      }
      if (localCrmCCNotify.str_check_id.has()) {
        QidianUtils.a(paramQQAppInterface, paramList, paramMsg, paramTempSessionInfo, localCrmCCNotify);
      }
      if ((paramTempSessionInfo != null) && (paramTempSessionInfo.a == 1024) && (localCrmCCNotify.str_ext_nick_name.has()))
      {
        paramQQAppInterface = localCrmCCNotify.str_ext_nick_name.get();
        if (!paramList.isEmpty())
        {
          paramCrmElem = (MessageRecord)paramList.get(0);
          if (paramCrmElem != null) {
            paramCrmElem.saveExtInfoToExtStr("qidian_ext_nick_name", paramQQAppInterface);
          }
        }
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("CrmFlagsElemDecoder", 2, "receive ccNotify but throw exception " + paramQQAppInterface.getMessage());
    }
  }
  
  public void a(im_msg_body.Elem paramElem, List<MessageRecord> paramList, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, TempSessionInfo paramTempSessionInfo)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    MessageHandler localMessageHandler = localQQAppInterface.getMsgHandler();
    paramElem = (im_msg_body.CrmElem)paramElem.crm_elem.get();
    if (paramElem != null)
    {
      i = paramElem.uint32_qidian_flag.get();
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("has uint32_qidian_flag:").append(i).append(";");
      }
      if (i == 1) {
        a(i, paramList, paramMsg, paramTempSessionInfo, localMessageHandler);
      }
      if (paramElem.crm_buf.has()) {
        a(localQQAppInterface, paramElem, paramList, paramMsg, paramTempSessionInfo);
      }
    }
    while (!QLog.isColorLevel())
    {
      int i;
      return;
    }
    paramStringBuilder.append("has crmElem, but crmElem is null");
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, MessageInfo paramMessageInfo, TempSessionInfo paramTempSessionInfo, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramMessageInfo = (im_msg_body.Elem)paramList.next();
      if (a(paramMessageInfo)) {
        a(paramMessageInfo, paramList1, paramStringBuilder, paramMsg, paramTempSessionInfo);
      }
    }
    return false;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return paramElem.crm_elem.has();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.pbelement.CrmFlagsElemDecoder
 * JD-Core Version:    0.7.0.1
 */