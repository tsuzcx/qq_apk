package com.tencent.mobileqq.activity.aio.reply;

import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ReplyMsgUtils
{
  public static MessageForReplyText.SourceMsgInfo a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, int paramInt, long paramLong, String paramString)
  {
    if (paramChatMessage == null) {
      return null;
    }
    long l;
    try
    {
      l = Long.parseLong(paramChatMessage.senderuin);
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.d("ReplyMsgUtils", 1, "generateSourceInfo sender uin exception:", paramQQAppInterface);
      l = 0L;
    }
    if (l <= 0L) {
      return null;
    }
    paramQQAppInterface = new MessageForReplyText.SourceMsgInfo();
    paramQQAppInterface.origUid = paramChatMessage.msgUid;
    paramQQAppInterface.mSourceMsgSeq = paramChatMessage.shmsgseq;
    paramQQAppInterface.mSourceMsgSenderUin = Long.parseLong(paramChatMessage.senderuin);
    paramQQAppInterface.setUniSeq(paramChatMessage.uniseq, true);
    paramQQAppInterface.mSourceMsgTime = ((int)paramChatMessage.time);
    paramQQAppInterface.mSourceSummaryFlag = 1;
    paramQQAppInterface.mType = paramInt;
    paramQQAppInterface.mAtInfoStr = paramChatMessage.getExtInfoFromExtStr(MessageConstants.i);
    Object localObject = AnonymousChatHelper.a(paramChatMessage);
    if (!TextUtils.isEmpty(((AnonymousChatHelper.AnonymousExtInfo)localObject).b))
    {
      paramQQAppInterface.mAnonymousNickName = ((AnonymousChatHelper.AnonymousExtInfo)localObject).b;
    }
    else if ((paramQQAppInterface.mSourceMsgSenderUin == 50000000L) || (paramQQAppInterface.mSourceMsgSenderUin == 1000000L))
    {
      localObject = TroopBusinessUtil.a(paramChatMessage);
      if (localObject != null) {
        paramQQAppInterface.mAnonymousNickName = ((TroopBusinessUtil.TroopBusinessMessage)localObject).c;
      }
    }
    if (((paramChatMessage instanceof MessageForFile)) && (paramQQAppInterface.mSourceMsgSenderUin == 0L) && (paramChatMessage.issend != 1) && (!TextUtils.isEmpty(paramChatMessage.frienduin))) {
      paramQQAppInterface.mSourceMsgSenderUin = Long.parseLong(paramChatMessage.frienduin);
    }
    paramQQAppInterface.mSourceMsgToUin = paramLong;
    paramQQAppInterface.mSourceMsgTroopName = paramString;
    try
    {
      if ((paramChatMessage instanceof MessageForMixedMsg))
      {
        paramQQAppInterface.mSourceMsgText = MessageForMixedMsg.getReplySummary(paramChatMessage);
        return paramQQAppInterface;
      }
      if ((paramChatMessage instanceof MessageForStructing))
      {
        paramQQAppInterface.mSourceMsgText = MessageForStructing.getReplySummary(paramChatMessage);
        return paramQQAppInterface;
      }
      if ((paramChatMessage instanceof MessageForArkApp))
      {
        paramQQAppInterface.mSourceMsgText = MessageForArkApp.getReplySummary(paramChatMessage);
        return paramQQAppInterface;
      }
      paramQQAppInterface.mSourceMsgText = paramChatMessage.getSummaryMsg();
      return paramQQAppInterface;
    }
    catch (Exception paramChatMessage)
    {
      label302:
      break label302;
    }
    paramQQAppInterface.mSourceMsgText = "";
    return paramQQAppInterface;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
  {
    paramQQAppInterface = paramQQAppInterface.getMessageFacade().a(paramBaseSessionInfo.jdField_a_of_type_JavaLangString, paramBaseSessionInfo.jdField_a_of_type_Int, paramSourceMsgInfo.mSourceMsgSeq, 0L);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
    {
      int i = 0;
      while (i < paramQQAppInterface.size())
      {
        paramBaseSessionInfo = (MessageRecord)paramQQAppInterface.get(i);
        if ((!MsgProxyUtils.a(paramBaseSessionInfo)) && (!(paramBaseSessionInfo instanceof MessageForSafeGrayTips))) {
          return paramBaseSessionInfo;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    paramQQAppInterface = paramQQAppInterface.getMessageFacade().b(paramString, paramInt, paramLong1, paramLong2);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
    {
      paramInt = 0;
      while (paramInt < paramQQAppInterface.size())
      {
        paramString = (MessageRecord)paramQQAppInterface.get(paramInt);
        if ((!MsgProxyUtils.b(paramString)) && (!(paramString instanceof MessageForSafeGrayTips))) {
          return paramString;
        }
        paramInt += 1;
      }
    }
    return null;
  }
  
  public static MessageRecord b(QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
  {
    return a(paramQQAppInterface, paramBaseSessionInfo.jdField_a_of_type_JavaLangString, paramBaseSessionInfo.jdField_a_of_type_Int, paramSourceMsgInfo.mSourceMsgTime, paramSourceMsgInfo.origUid);
  }
  
  public static MessageRecord c(QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
  {
    if (paramBaseSessionInfo.jdField_a_of_type_Int == 0) {
      return b(paramQQAppInterface, paramBaseSessionInfo, paramSourceMsgInfo);
    }
    return a(paramQQAppInterface, paramBaseSessionInfo, paramSourceMsgInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.reply.ReplyMsgUtils
 * JD-Core Version:    0.7.0.1
 */