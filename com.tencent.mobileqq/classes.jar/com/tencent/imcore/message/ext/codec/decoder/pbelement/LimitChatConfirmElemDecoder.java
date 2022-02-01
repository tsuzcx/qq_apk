package com.tencent.imcore.message.ext.codec.decoder.pbelement;

import com.tencent.mobileqq.data.MessageForLimitChatConfirm;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.TempSessionInfo;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype24;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype24.LimitChatEnter;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype24.LimitChatExit;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;

public class LimitChatConfirmElemDecoder
  extends SimplePBElemDecoder
{
  private void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (im_msg_body.Elem)paramList.next();
      if (((im_msg_body.Elem)localObject).common_elem.has())
      {
        paramList = (im_msg_body.CommonElem)((im_msg_body.Elem)localObject).common_elem.get();
        break label55;
      }
    }
    paramList = null;
    label55:
    if (paramList == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("decodePBMsgElems_LimitChatConfirmMsg;\n");
    }
    Object localObject = new hummer_commelem.MsgElemInfo_servtype24();
    try
    {
      ((hummer_commelem.MsgElemInfo_servtype24)localObject).mergeFrom(paramList.bytes_pb_elem.get().toByteArray());
      paramStringBuilder = (MessageForLimitChatConfirm)MessageRecordFactory.a(-7005);
      paramStringBuilder.msgtype = -7005;
      int i;
      if (paramList.uint32_business_type.has()) {
        i = paramList.uint32_business_type.get();
      } else {
        i = 1;
      }
      if (i == 1)
      {
        if (((hummer_commelem.MsgElemInfo_servtype24)localObject).limit_chat_enter.has())
        {
          paramStringBuilder.SenderNickName = ((hummer_commelem.MsgElemInfo_servtype24)localObject).limit_chat_enter.bytes_match_nick.get().toStringUtf8();
          paramStringBuilder.tipsWording = ((hummer_commelem.MsgElemInfo_servtype24)localObject).limit_chat_enter.bytes_tips_wording.get().toStringUtf8();
          paramStringBuilder.leftChatTime = ((hummer_commelem.MsgElemInfo_servtype24)localObject).limit_chat_enter.uint32_left_chat_time.get();
          paramStringBuilder.c2cExpiredTime = ((hummer_commelem.MsgElemInfo_servtype24)localObject).limit_chat_enter.uint32_c2c_expired_time.get();
          paramStringBuilder.matchExpiredTime = ((hummer_commelem.MsgElemInfo_servtype24)localObject).limit_chat_enter.uint32_match_expired_time.get();
          paramStringBuilder.timeStamp = ((hummer_commelem.MsgElemInfo_servtype24)localObject).limit_chat_enter.uint64_match_ts.get();
          paramStringBuilder.readyTs = ((hummer_commelem.MsgElemInfo_servtype24)localObject).limit_chat_enter.uint64_ready_ts.get();
          paramStringBuilder.bEnterMsg = true;
        }
        else
        {
          QLog.e("LimitChatConfirmElemDecoderExtendFriendLimitChatLimitChatConfirm msg", 1, " !!!limitChatElem  limit_chat_enter is null ");
        }
      }
      else if (((hummer_commelem.MsgElemInfo_servtype24)localObject).limit_chat_exit.has())
      {
        paramStringBuilder.bEnterMsg = false;
        paramStringBuilder.leaveChatType = ((hummer_commelem.MsgElemInfo_servtype24)localObject).limit_chat_exit.uint32_exit_method.get();
        paramStringBuilder.timeStamp = ((hummer_commelem.MsgElemInfo_servtype24)localObject).limit_chat_exit.uint64_match_ts.get();
      }
      else
      {
        QLog.e("LimitChatConfirmElemDecoderLimitChatConfirm msg", 1, " limitChatElem  limit_chat_exit is null ");
      }
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append(" decodePBMsgElems_LimitChatConfirmMsg type");
        paramList.append(i);
        paramList.append(" ");
        paramList.append(paramStringBuilder.matchExpiredTime);
        paramList.append(" ");
        paramList.append(paramStringBuilder.frienduin);
        QLog.i("LimitChatConfirmElemDecoderLimitChatConfirm msg", 1, paramList.toString());
      }
      paramStringBuilder.prewrite();
      paramList1.add(paramStringBuilder);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramList)
    {
      paramList.printStackTrace();
      QLog.e("LimitChatConfirmElemDecoderscribble msg", 1, paramList, new Object[0]);
    }
  }
  
  public int a()
  {
    return 1000;
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, MessageInfo paramMessageInfo, TempSessionInfo paramTempSessionInfo, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    a(paramList, paramList1, paramStringBuilder);
    return true;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return (paramElem.common_elem.has()) && (24 == paramElem.common_elem.uint32_service_type.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.pbelement.LimitChatConfirmElemDecoder
 * JD-Core Version:    0.7.0.1
 */