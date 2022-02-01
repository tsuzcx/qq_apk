package com.tencent.mobileqq.app.message;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.imcore.message.DecodeC2CMsgPkgBubbleID;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BaseMessageHandlerUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.FileMultiMsgPackageHandle;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.multimsg.MultiMsgConstant;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.MessageRecordEntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.receipt.ReceiptUtil;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.codec.decoder.GrpDisPTTDecoder;
import com.tencent.mobileqq.service.message.codec.decoder.PTTDecoder;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.svip.api.SVIPHandlerConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.String;Ljava.lang.String;>;
import java.util.HashMap<Ljava.lang.String;Ljava.util.ArrayList<Lcom.tencent.mobileqq.data.MessageRecord;>;>;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import msf.msgcomm.msg_comm.DiscussInfo;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MutilTransHead;
import msf.msgsvc.msgtransmit.msg_transmit.PbMultiMsgItem;
import msf.msgsvc.msgtransmit.msg_transmit.PbMultiMsgNew;
import msf.msgsvc.msgtransmit.msg_transmit.PbMultiMsgTransmit;
import org.jetbrains.annotations.Nullable;
import tencent.im.msg.im_msg_body.AnonymousGroupMsg;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.RichText;

@KeepClassConstructor
public class MultiMsgProxy
  extends BaseProxy
{
  private static final Class[] c = { MessageForText.class, MessageForPic.class, MessageForMixedMsg.class, MessageForLongMsg.class, MessageForShortVideo.class, MessageForReplyText.class, MessageForTroopFile.class, MessageForQQStoryComment.class, MessageForArkApp.class, MessageForArkFlashChat.class };
  MessageRecordEntityManager a = null;
  private Object b = new Object();
  
  public MultiMsgProxy(QQAppInterface paramQQAppInterface, BaseProxyManager paramBaseProxyManager)
  {
    super(paramQQAppInterface, paramBaseProxyManager);
  }
  
  private long a(@NonNull HashMap<String, String> paramHashMap, MessageInfo paramMessageInfo, msg_comm.Msg paramMsg, msg_comm.MsgHead paramMsgHead, long paramLong1, long paramLong2, int paramInt, MessageHandler paramMessageHandler, ArrayList<MessageRecord> paramArrayList)
  {
    if ((!MessageUtils.d(paramInt)) && (paramInt != 208))
    {
      if ((paramInt != 82) && (paramInt != 43))
      {
        if ((paramInt == 83) || (paramInt == 42))
        {
          paramLong2 = paramMsgHead.discuss_info.discuss_uin.get();
          b(paramHashMap, paramMessageInfo, paramMsg, paramMsgHead, paramLong1, paramMessageHandler, paramArrayList);
          return paramLong2;
        }
      }
      else
      {
        paramLong2 = paramMsgHead.group_info.group_code.get();
        c(paramHashMap, paramMessageInfo, paramMsg, paramMsgHead, paramLong1, paramMessageHandler, paramArrayList);
        return paramLong2;
      }
    }
    else {
      a(paramHashMap, paramMessageInfo, paramMsg, paramMsgHead, paramLong1, paramMessageHandler, paramArrayList);
    }
    return paramLong2;
  }
  
  private MessageRecord a(MessageRecord paramMessageRecord1, msg_comm.MsgHead paramMsgHead, ArrayList<MessageRecord> paramArrayList, int paramInt, MessageRecord paramMessageRecord2)
  {
    MessageRecord localMessageRecord = paramMessageRecord2;
    if (!ReceiptUtil.a(paramMessageRecord1))
    {
      localMessageRecord = paramMessageRecord2;
      if (!MultiMsgUtil.a((QQAppInterface)this.app, (ChatMessage)paramMessageRecord2))
      {
        localMessageRecord = paramMessageRecord2;
        if (!(paramMessageRecord2 instanceof MessageForArkApp))
        {
          if (QLog.isColorLevel())
          {
            paramMessageRecord1 = new StringBuilder();
            paramMessageRecord1.append("not support multi forward msg! ");
            paramMessageRecord1.append(paramMessageRecord2.toString());
            QLog.d("MultiMsg_TAG", 2, paramMessageRecord1.toString());
          }
          localMessageRecord = MessageRecordFactory.a(-1000);
          localMessageRecord.msg = paramMsgHead.multi_compatible_text.get();
          paramArrayList.set(paramInt, localMessageRecord);
        }
      }
    }
    return localMessageRecord;
  }
  
  private String a(msg_comm.Msg paramMsg, HashMap<String, String> paramHashMap, MessageRecord paramMessageRecord, MessageInfo paramMessageInfo, msg_comm.MsgHead paramMsgHead, long paramLong, String paramString, MessageHandler paramMessageHandler, ArrayList<MessageRecord> paramArrayList)
  {
    paramMsgHead.discuss_info.discuss_uin.get();
    if (!((QQAppInterface)this.app).getFileManagerEngine().a().b(paramArrayList, paramMsg)) {
      MessageProtoCodec.a(paramMessageHandler, paramArrayList, paramMsg, false, false, paramMessageInfo);
    }
    if ((paramMsgHead.discuss_info.discuss_remark.has()) && (paramHashMap != null))
    {
      paramMessageInfo = paramMsgHead.discuss_info.discuss_remark.get().toStringUtf8();
      if (!TextUtils.isEmpty(paramMessageInfo)) {
        paramHashMap.put(String.valueOf(paramLong), paramMessageInfo);
      }
      paramHashMap = paramMessageInfo;
    }
    else
    {
      paramHashMap = paramString;
    }
    a(paramMessageRecord, paramMsg, paramMessageHandler, paramArrayList);
    return paramHashMap;
  }
  
  private String a(msg_comm.Msg paramMsg, HashMap<String, String> paramHashMap, MessageRecord paramMessageRecord, msg_comm.MsgHead paramMsgHead, long paramLong, String paramString, MessageHandler paramMessageHandler, ArrayList<MessageRecord> paramArrayList, MessageInfo paramMessageInfo)
  {
    if (!((QQAppInterface)this.app).getFileManagerEngine().a().a(paramArrayList, paramMsg)) {
      MessageProtoCodec.a(paramMessageHandler, paramArrayList, paramMsg, false, false, paramMessageInfo);
    }
    if ((paramMsgHead.group_info.group_card.has()) && (paramHashMap != null))
    {
      paramMsgHead = paramMsgHead.group_info.group_card.get().toStringUtf8();
      if (!TextUtils.isEmpty(paramMsgHead)) {
        paramHashMap.put(String.valueOf(paramLong), paramMsgHead);
      }
      paramHashMap = paramMsgHead;
    }
    else
    {
      paramHashMap = paramString;
    }
    a(paramMessageRecord, paramMsg, paramMessageHandler, paramArrayList);
    paramMsg = (im_msg_body.MsgBody)paramMsg.msg_body.get();
    if (paramMsg.rich_text.has())
    {
      paramMsg = (im_msg_body.RichText)paramMsg.rich_text.get();
      if (paramMsg.elems.has())
      {
        paramMsg = paramMsg.elems.get();
        if (paramMsg != null)
        {
          paramMsg = paramMsg.iterator();
          while (paramMsg.hasNext())
          {
            paramMessageRecord = (im_msg_body.Elem)paramMsg.next();
            if (paramMessageRecord.anon_group_msg.has())
            {
              paramMessageRecord = (im_msg_body.AnonymousGroupMsg)paramMessageRecord.anon_group_msg.get();
              int i = paramMessageRecord.uint32_flags.get();
              paramMsg = paramMessageRecord.str_anon_id.get().toByteArray();
              paramMsgHead = paramMessageRecord.str_anon_nick.get().toByteArray();
              int j = paramMessageRecord.uint32_head_portrait.get();
              int k = paramMessageRecord.uint32_expire_time.get();
              paramString = paramMessageRecord.str_rank_color.get().toStringUtf8();
              if (paramMsg != null) {
                try
                {
                  paramMsg = new String(paramMsg, "ISO-8859-1");
                }
                catch (UnsupportedEncodingException paramMsg)
                {
                  paramMsg.printStackTrace();
                }
              } else {
                paramMsg = "";
              }
              paramMessageHandler = paramArrayList.iterator();
              while (paramMessageHandler.hasNext())
              {
                paramArrayList = (MessageRecord)paramMessageHandler.next();
                if (paramMsgHead == null) {
                  paramMessageRecord = "";
                } else {
                  paramMessageRecord = new String(paramMsgHead);
                }
                paramArrayList.saveExtInfoToExtStr("anonymous", AnonymousChatHelper.a(i, paramMsg, paramMessageRecord, j, k, paramString));
                paramArrayList.extLong |= 0x3;
              }
              if (QLog.isColorLevel())
              {
                paramMsg = new StringBuilder();
                paramMsg.append("anonymous_flags has = ");
                paramMsg.append(i);
                QLog.d("anonymous_decode", 2, paramMsg.toString());
              }
            }
          }
        }
      }
    }
    return paramHashMap;
  }
  
  private String a(msg_comm.Msg paramMsg, HashMap<String, String> paramHashMap, MessageInfo paramMessageInfo, msg_comm.MsgHead paramMsgHead, long paramLong, int paramInt, String paramString, MessageHandler paramMessageHandler, ArrayList<MessageRecord> paramArrayList, MessageRecord paramMessageRecord)
  {
    int i = paramMsgHead.c2c_cmd.get();
    if ((paramInt == 529) && (i == 4)) {
      ((QQAppInterface)this.app).getFileManagerEngine().a().a(paramArrayList, ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get());
    } else if ((i == 175) || (i == 11)) {
      MessageProtoCodec.a(paramMessageHandler, paramArrayList, paramMsg, true, false, paramMessageInfo);
    }
    if ((paramMsgHead.from_nick.has()) && (paramHashMap != null))
    {
      paramMessageInfo = paramMsgHead.from_nick.get();
      paramHashMap.put(String.valueOf(paramLong), paramMsgHead.from_nick.get());
      paramHashMap = paramMessageInfo;
    }
    else
    {
      paramHashMap = paramString;
    }
    a(paramMessageRecord, paramMsg, paramMessageHandler, paramArrayList);
    return paramHashMap;
  }
  
  @Nullable
  private im_msg_body.RichText a(MessageForStructing paramMessageForStructing)
  {
    im_msg_body.RichText localRichText = MessageProtoCodec.a(paramMessageForStructing);
    try
    {
      if ((paramMessageForStructing.structingMsg == null) || (!(paramMessageForStructing.structingMsg instanceof StructMsgForImageShare))) {
        break label77;
      }
      paramMessageForStructing = ((StructMsgForImageShare)paramMessageForStructing.structingMsg).getFirstImageElement();
      if (paramMessageForStructing == null) {
        break label77;
      }
      paramMessageForStructing = paramMessageForStructing.aF.richText;
      localRichText.elems.add(paramMessageForStructing.elems.get(0));
      return localRichText;
    }
    catch (Exception paramMessageForStructing)
    {
      label62:
      label77:
      break label62;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, " packMultiMsg.structMsg.exception...");
    }
    return localRichText;
  }
  
  private void a(MessageForStructing paramMessageForStructing, HashMap<String, ArrayList<MessageRecord>> paramHashMap, int paramInt)
  {
    if (paramInt > 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "recursionAddMultiMsg return before of max recurTime");
      }
      return;
    }
    if ((paramMessageForStructing != null) && (paramMessageForStructing.structingMsg != null))
    {
      String str = a(paramInt, paramMessageForStructing);
      Object localObject;
      if (paramHashMap.containsKey(str))
      {
        ArrayList localArrayList = (ArrayList)paramHashMap.get(str);
        localObject = localArrayList;
        if (QLog.isColorLevel())
        {
          QLog.d("MultiMsg_TAG", 2, String.format("recursionAddMultiMsg find list size:%d, filename:%s", new Object[] { Integer.valueOf(localArrayList.size()), str }));
          localObject = localArrayList;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, String.format("recursionAddMultiMsg error filename:%s not found, recurTimes=%d", new Object[] { str, Integer.valueOf(paramInt) }));
        }
        localObject = null;
      }
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        b(paramMessageForStructing, (List)localObject, null);
        paramInt += 1;
        paramMessageForStructing = ((ArrayList)localObject).iterator();
        while (paramMessageForStructing.hasNext())
        {
          localObject = (MessageRecord)paramMessageForStructing.next();
          if (MultiMsgUtil.a((ChatMessage)localObject))
          {
            if (QLog.isColorLevel()) {
              QLog.d("MultiMsg_TAG", 2, String.format("recursionAddMultiMsg need recur, uniseq:%d, recurTimes:%d", new Object[] { Long.valueOf(((MessageRecord)localObject).uniseq), Integer.valueOf(paramInt) }));
            }
            a((MessageForStructing)localObject, paramHashMap, paramInt);
          }
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "recursionAddMultiMsg return before of null structmsg");
    }
  }
  
  private void a(MessageForStructing paramMessageForStructing, HashMap<String, ArrayList<MessageRecord>> paramHashMap1, HashMap<String, ArrayList<MessageRecord>> paramHashMap2, int paramInt, ProxyListener paramProxyListener, boolean paramBoolean1, boolean paramBoolean2, ArrayList<MessageRecord> paramArrayList)
  {
    if (paramInt > 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "recursivePreAddMultiMsg return before of max recurTime");
      }
      return;
    }
    if ((paramMessageForStructing != null) && (paramMessageForStructing.structingMsg != null))
    {
      String str1 = a(paramInt, paramMessageForStructing);
      Object localObject;
      if (paramHashMap1.containsKey(str1))
      {
        localObject = (ArrayList)paramHashMap1.get(str1);
        if (QLog.isColorLevel())
        {
          int i;
          if (localObject != null) {
            i = ((ArrayList)localObject).size();
          } else {
            i = 0;
          }
          QLog.d("MultiMsg_TAG", 2, String.format("recursivePreAddMultiMsg find list size:%d, filename:%s", new Object[] { Integer.valueOf(i), str1 }));
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, String.format("recursivePreAddMultiMsg error filename:%s not found, recurTimes=%d", new Object[] { str1, Integer.valueOf(paramInt) }));
        }
        localObject = null;
      }
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        paramMessageForStructing = a(paramMessageForStructing, (ArrayList)localObject, paramProxyListener, paramBoolean1, paramBoolean2, paramArrayList);
        if (paramMessageForStructing != null)
        {
          localObject = paramMessageForStructing.iterator();
          while (((Iterator)localObject).hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
            if (MultiMsgUtil.a((ChatMessage)localMessageRecord))
            {
              MessageForStructing localMessageForStructing = (MessageForStructing)localMessageRecord;
              String str2 = localMessageForStructing.structingMsg.mFileName;
              String str3 = String.valueOf(localMessageForStructing.uniseq);
              localMessageForStructing.structingMsg.mFileName = str3;
              a(localMessageRecord, null);
              paramHashMap1.put(str3, (ArrayList)paramHashMap1.remove(str2));
            }
          }
          paramHashMap2.put(str1, paramMessageForStructing);
          if ((paramMessageForStructing != null) && (paramMessageForStructing.size() > 0))
          {
            paramMessageForStructing = paramMessageForStructing.iterator();
            while (paramMessageForStructing.hasNext())
            {
              localObject = (MessageRecord)paramMessageForStructing.next();
              if (MultiMsgUtil.a((ChatMessage)localObject)) {
                a((MessageForStructing)localObject, paramHashMap1, paramHashMap2, 1 + paramInt, paramProxyListener, paramBoolean1, paramBoolean2, paramArrayList);
              }
            }
          }
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "recursivePreAddMultiMsg return before of null structmsg");
    }
  }
  
  private void a(MessageRecord paramMessageRecord, msg_comm.Msg paramMsg, MessageHandler paramMessageHandler, ArrayList<MessageRecord> paramArrayList)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)paramMessageRecord;
      if ((localMessageForStructing.structingMsg != null) && (localMessageForStructing.structingMsg.mMsgServiceID == 107))
      {
        if ((paramMessageRecord.istroop != 1) && (paramMessageRecord.istroop != 3000))
        {
          new PTTDecoder().a(paramMessageHandler, paramMsg, paramArrayList, null);
          return;
        }
        new GrpDisPTTDecoder().a(paramMessageHandler, paramMsg, paramArrayList, null);
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText)
  {
    if (AnonymousChatHelper.c(paramMessageRecord))
    {
      im_msg_body.Elem localElem = new im_msg_body.Elem();
      im_msg_body.AnonymousGroupMsg localAnonymousGroupMsg = new im_msg_body.AnonymousGroupMsg();
      AnonymousChatHelper.AnonymousExtInfo localAnonymousExtInfo = AnonymousChatHelper.g(paramMessageRecord);
      localAnonymousGroupMsg.uint32_flags.set(localAnonymousExtInfo.a);
      if (!TextUtils.isEmpty(localAnonymousExtInfo.b)) {
        localAnonymousGroupMsg.str_anon_id.set(ByteStringMicro.copyFrom(localAnonymousExtInfo.b.getBytes()));
      }
      if (!TextUtils.isEmpty(localAnonymousExtInfo.c)) {
        localAnonymousGroupMsg.str_anon_nick.set(ByteStringMicro.copyFrom(localAnonymousExtInfo.c.getBytes()));
      }
      localAnonymousGroupMsg.uint32_head_portrait.set(localAnonymousExtInfo.d);
      localAnonymousGroupMsg.uint32_expire_time.set(localAnonymousExtInfo.e);
      if (!TextUtils.isEmpty(localAnonymousExtInfo.f)) {
        localAnonymousGroupMsg.str_rank_color.set(ByteStringMicro.copyFrom(localAnonymousExtInfo.f.getBytes()));
      }
      localAnonymousGroupMsg.uint32_bubble_id.set((int)paramMessageRecord.vipBubbleID);
      localElem.anon_group_msg.set(localAnonymousGroupMsg);
      if (QLog.isColorLevel()) {
        QLog.d("anonymous_decode", 2, "anonymous_addd anon_group_msg = ");
      }
      paramRichText.elems.add(localElem);
    }
  }
  
  private void a(@NonNull HashMap<String, String> paramHashMap, MessageInfo paramMessageInfo, msg_comm.Msg paramMsg, msg_comm.MsgHead paramMsgHead, long paramLong, MessageHandler paramMessageHandler, ArrayList<MessageRecord> paramArrayList)
  {
    int i = paramMsgHead.c2c_cmd.get();
    if ((i == 175) || (i == 11)) {
      if (((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has()) {
        ((QQAppInterface)this.app).getFileManagerEngine().a().a(paramArrayList, ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get());
      } else {
        MessageProtoCodec.a(paramMessageHandler, paramArrayList, paramMsg, true, false, paramMessageInfo);
      }
    }
    if (paramMsgHead.from_nick.has()) {
      paramHashMap.put(String.valueOf(paramLong), paramMsgHead.from_nick.get());
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if (MessageForTroopFile.class.isInstance(paramChatMessage)) {
      return true;
    }
    if (MessageForFile.class.isInstance(paramChatMessage)) {
      return !FileManagerUtil.a(paramQQAppInterface, (MessageForFile)paramChatMessage).sendCloudUnsuccessful();
    }
    return false;
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    return (MessageForMarketFace.class.isInstance(paramChatMessage)) || (MessageForPic.class.isInstance(paramChatMessage));
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if (AnonymousChatHelper.c(paramMessageRecord)) {
      return false;
    }
    if ((MessageForShortVideo.class.isInstance(paramMessageRecord)) && (((MessageForShortVideo)paramMessageRecord).busiType == 2)) {
      return false;
    }
    if ((MessageForLongTextMsg.class.isInstance(paramMessageRecord)) && ((paramMessageRecord.getExtInfoFromExtStr("long_text_recv_state").equals("2")) || (paramMessageRecord.getExtInfoFromExtStr("long_text_recv_state").equals("3")))) {
      return false;
    }
    if (!MessageForArkApp.isAllowedArkForward(false, paramMessageRecord)) {
      return false;
    }
    if (MessageForTroopConfess.class.isInstance(paramMessageRecord)) {
      return false;
    }
    Class[] arrayOfClass = c;
    int j = arrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfClass[i].isInstance(paramMessageRecord)) {
        return true;
      }
      i += 1;
    }
    if (MessageForStructing.class.isInstance(paramMessageRecord)) {
      return d(paramMessageRecord);
    }
    if ((paramMessageRecord instanceof MessageForArkBabyqReply))
    {
      paramMessageRecord = (MessageForArkBabyqReply)paramMessageRecord;
      if (paramMessageRecord.mArkBabyqReplyCardList != null) {
        return paramMessageRecord.mArkBabyqReplyCardList.size() > 0;
      }
    }
    return false;
  }
  
  /* Error */
  public static byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +36 -> 39
    //   6: new 123	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   13: astore_2
    //   14: aload_2
    //   15: ldc_w 606
    //   18: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_2
    //   23: aload_0
    //   24: arraylength
    //   25: invokevirtual 349	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: ldc 138
    //   31: iconst_2
    //   32: aload_2
    //   33: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: aconst_null
    //   40: astore 4
    //   42: aconst_null
    //   43: astore_3
    //   44: new 608	java/io/ByteArrayInputStream
    //   47: dup
    //   48: aload_0
    //   49: invokespecial 609	java/io/ByteArrayInputStream:<init>	([B)V
    //   52: astore 5
    //   54: new 611	java/io/ByteArrayOutputStream
    //   57: dup
    //   58: invokespecial 612	java/io/ByteArrayOutputStream:<init>	()V
    //   61: astore 6
    //   63: aload_3
    //   64: astore_0
    //   65: aload 4
    //   67: astore_2
    //   68: sipush 1024
    //   71: newarray byte
    //   73: astore 7
    //   75: aload_3
    //   76: astore_0
    //   77: aload 4
    //   79: astore_2
    //   80: new 614	java/util/zip/GZIPOutputStream
    //   83: dup
    //   84: aload 6
    //   86: invokespecial 617	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   89: astore 8
    //   91: aload_3
    //   92: astore_0
    //   93: aload 4
    //   95: astore_2
    //   96: aload 5
    //   98: aload 7
    //   100: iconst_0
    //   101: sipush 1024
    //   104: invokevirtual 621	java/io/ByteArrayInputStream:read	([BII)I
    //   107: istore_1
    //   108: iload_1
    //   109: iconst_m1
    //   110: if_icmpeq +20 -> 130
    //   113: aload_3
    //   114: astore_0
    //   115: aload 4
    //   117: astore_2
    //   118: aload 8
    //   120: aload 7
    //   122: iconst_0
    //   123: iload_1
    //   124: invokevirtual 625	java/util/zip/GZIPOutputStream:write	([BII)V
    //   127: goto -36 -> 91
    //   130: aload_3
    //   131: astore_0
    //   132: aload 4
    //   134: astore_2
    //   135: aload 8
    //   137: invokevirtual 628	java/util/zip/GZIPOutputStream:flush	()V
    //   140: aload_3
    //   141: astore_0
    //   142: aload 4
    //   144: astore_2
    //   145: aload 8
    //   147: invokevirtual 631	java/util/zip/GZIPOutputStream:close	()V
    //   150: aload_3
    //   151: astore_0
    //   152: aload 4
    //   154: astore_2
    //   155: aload 6
    //   157: invokevirtual 632	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   160: astore_3
    //   161: aload_3
    //   162: astore_0
    //   163: aload_3
    //   164: astore_2
    //   165: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   168: ifeq +56 -> 224
    //   171: aload_3
    //   172: astore_0
    //   173: aload_3
    //   174: astore_2
    //   175: new 123	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   182: astore 4
    //   184: aload_3
    //   185: astore_0
    //   186: aload_3
    //   187: astore_2
    //   188: aload 4
    //   190: ldc_w 634
    //   193: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload_3
    //   198: astore_0
    //   199: aload_3
    //   200: astore_2
    //   201: aload 4
    //   203: aload_3
    //   204: arraylength
    //   205: invokevirtual 349	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload_3
    //   210: astore_0
    //   211: aload_3
    //   212: astore_2
    //   213: ldc 138
    //   215: iconst_2
    //   216: aload 4
    //   218: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   224: aload 6
    //   226: invokevirtual 635	java/io/ByteArrayOutputStream:close	()V
    //   229: aload 5
    //   231: invokevirtual 636	java/io/ByteArrayInputStream:close	()V
    //   234: aload_3
    //   235: areturn
    //   236: astore_0
    //   237: aload_3
    //   238: astore 4
    //   240: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   243: ifeq +212 -> 455
    //   246: new 123	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   253: astore_2
    //   254: aload_0
    //   255: astore 4
    //   257: aload_3
    //   258: astore_0
    //   259: aload_2
    //   260: ldc_w 638
    //   263: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload_2
    //   268: aload 4
    //   270: invokevirtual 641	java/io/IOException:getMessage	()Ljava/lang/String;
    //   273: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: ldc 138
    //   279: iconst_2
    //   280: aload_2
    //   281: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: aload_0
    //   288: areturn
    //   289: astore_0
    //   290: goto +168 -> 458
    //   293: astore_2
    //   294: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   297: ifeq +38 -> 335
    //   300: new 123	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   307: astore_3
    //   308: aload_3
    //   309: ldc_w 643
    //   312: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload_3
    //   317: aload_2
    //   318: invokevirtual 644	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   321: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: ldc 138
    //   327: iconst_2
    //   328: aload_3
    //   329: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   335: aload 6
    //   337: invokevirtual 635	java/io/ByteArrayOutputStream:close	()V
    //   340: aload 5
    //   342: invokevirtual 636	java/io/ByteArrayInputStream:close	()V
    //   345: aload_0
    //   346: areturn
    //   347: astore_3
    //   348: aload_0
    //   349: astore 4
    //   351: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   354: ifeq +101 -> 455
    //   357: new 123	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   364: astore_2
    //   365: aload_3
    //   366: astore 4
    //   368: goto -109 -> 259
    //   371: astore_0
    //   372: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   375: ifeq +38 -> 413
    //   378: new 123	java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   385: astore_3
    //   386: aload_3
    //   387: ldc_w 646
    //   390: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: aload_3
    //   395: aload_0
    //   396: invokevirtual 647	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   399: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: pop
    //   403: ldc 138
    //   405: iconst_2
    //   406: aload_3
    //   407: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   413: aload 6
    //   415: invokevirtual 635	java/io/ByteArrayOutputStream:close	()V
    //   418: aload 5
    //   420: invokevirtual 636	java/io/ByteArrayInputStream:close	()V
    //   423: aload_2
    //   424: areturn
    //   425: astore_3
    //   426: aload_2
    //   427: astore 4
    //   429: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   432: ifeq +23 -> 455
    //   435: new 123	java/lang/StringBuilder
    //   438: dup
    //   439: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   442: astore 4
    //   444: aload_2
    //   445: astore_0
    //   446: aload 4
    //   448: astore_2
    //   449: aload_3
    //   450: astore 4
    //   452: goto -193 -> 259
    //   455: aload 4
    //   457: areturn
    //   458: aload 6
    //   460: invokevirtual 635	java/io/ByteArrayOutputStream:close	()V
    //   463: aload 5
    //   465: invokevirtual 636	java/io/ByteArrayInputStream:close	()V
    //   468: goto +45 -> 513
    //   471: astore_2
    //   472: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   475: ifeq +38 -> 513
    //   478: new 123	java/lang/StringBuilder
    //   481: dup
    //   482: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   485: astore_3
    //   486: aload_3
    //   487: ldc_w 638
    //   490: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: pop
    //   494: aload_3
    //   495: aload_2
    //   496: invokevirtual 641	java/io/IOException:getMessage	()Ljava/lang/String;
    //   499: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: pop
    //   503: ldc 138
    //   505: iconst_2
    //   506: aload_3
    //   507: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   510: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   513: goto +5 -> 518
    //   516: aload_0
    //   517: athrow
    //   518: goto -2 -> 516
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	521	0	paramArrayOfByte	byte[]
    //   107	17	1	i	int
    //   13	268	2	localObject1	Object
    //   293	25	2	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   364	85	2	localObject2	Object
    //   471	25	2	localIOException1	java.io.IOException
    //   43	286	3	localObject3	Object
    //   347	19	3	localIOException2	java.io.IOException
    //   385	22	3	localStringBuilder1	StringBuilder
    //   425	25	3	localIOException3	java.io.IOException
    //   485	22	3	localStringBuilder2	StringBuilder
    //   40	416	4	localObject4	Object
    //   52	412	5	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   61	398	6	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   73	48	7	arrayOfByte	byte[]
    //   89	57	8	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    // Exception table:
    //   from	to	target	type
    //   224	234	236	java/io/IOException
    //   68	75	289	finally
    //   80	91	289	finally
    //   96	108	289	finally
    //   118	127	289	finally
    //   135	140	289	finally
    //   145	150	289	finally
    //   155	161	289	finally
    //   165	171	289	finally
    //   175	184	289	finally
    //   188	197	289	finally
    //   201	209	289	finally
    //   213	224	289	finally
    //   294	335	289	finally
    //   372	413	289	finally
    //   68	75	293	java/lang/OutOfMemoryError
    //   80	91	293	java/lang/OutOfMemoryError
    //   96	108	293	java/lang/OutOfMemoryError
    //   118	127	293	java/lang/OutOfMemoryError
    //   135	140	293	java/lang/OutOfMemoryError
    //   145	150	293	java/lang/OutOfMemoryError
    //   155	161	293	java/lang/OutOfMemoryError
    //   165	171	293	java/lang/OutOfMemoryError
    //   175	184	293	java/lang/OutOfMemoryError
    //   188	197	293	java/lang/OutOfMemoryError
    //   201	209	293	java/lang/OutOfMemoryError
    //   213	224	293	java/lang/OutOfMemoryError
    //   335	345	347	java/io/IOException
    //   68	75	371	java/lang/Exception
    //   80	91	371	java/lang/Exception
    //   96	108	371	java/lang/Exception
    //   118	127	371	java/lang/Exception
    //   135	140	371	java/lang/Exception
    //   145	150	371	java/lang/Exception
    //   155	161	371	java/lang/Exception
    //   165	171	371	java/lang/Exception
    //   175	184	371	java/lang/Exception
    //   188	197	371	java/lang/Exception
    //   201	209	371	java/lang/Exception
    //   213	224	371	java/lang/Exception
    //   413	423	425	java/io/IOException
    //   458	468	471	java/io/IOException
  }
  
  private MessageRecordEntityManager b()
  {
    ??? = this.a;
    if ((??? == null) || (!((MessageRecordEntityManager)???).isOpen())) {}
    synchronized (this.b)
    {
      if ((this.a == null) || (!this.a.isOpen())) {
        this.a = ((MessageRecordEntityManager)((QQAppInterface)this.app).getEntityManagerFactory().b());
      }
      return this.a;
    }
  }
  
  private void b(MessageForStructing paramMessageForStructing, HashMap<String, ArrayList<MessageRecord>> paramHashMap, int paramInt)
  {
    if (paramInt > 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "recursiveQueryMultiMsg return before of max recurTime");
      }
      return;
    }
    if (paramMessageForStructing == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "recursiveQueryMultiMsg return before of null structmsg");
      }
      return;
    }
    ArrayList localArrayList = a(paramMessageForStructing.uniseq);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      paramHashMap.put(a(paramInt, paramMessageForStructing), localArrayList);
      paramInt += 1;
      paramMessageForStructing = localArrayList.iterator();
      while (paramMessageForStructing.hasNext())
      {
        MessageRecord localMessageRecord1 = (MessageRecord)paramMessageForStructing.next();
        if (MultiMsgUtil.a((ChatMessage)localMessageRecord1))
        {
          if (paramInt == 2)
          {
            MessageRecord localMessageRecord2 = a(localMessageRecord1, MultiMsgConstant.a, false);
            localMessageRecord2.setStatus(1000);
            localMessageRecord2.msgData = localMessageRecord2.msg.getBytes();
            localArrayList.set(localArrayList.indexOf(localMessageRecord1), localMessageRecord2);
          }
          else
          {
            b((MessageForStructing)localMessageRecord1, paramHashMap, paramInt);
          }
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, String.format("recursiveQueryMultiMsg need recur, uniseq:%d, recurTimes:%d", new Object[] { Long.valueOf(localMessageRecord1.uniseq), Integer.valueOf(paramInt) }));
          }
        }
      }
    }
  }
  
  private void b(@NonNull HashMap<String, String> paramHashMap, MessageInfo paramMessageInfo, msg_comm.Msg paramMsg, msg_comm.MsgHead paramMsgHead, long paramLong, MessageHandler paramMessageHandler, ArrayList<MessageRecord> paramArrayList)
  {
    if (!((QQAppInterface)this.app).getFileManagerEngine().a().b(paramArrayList, paramMsg)) {
      MessageProtoCodec.a(paramMessageHandler, paramArrayList, paramMsg, false, false, paramMessageInfo);
    }
    if (paramMsgHead.discuss_info.discuss_remark.has()) {
      paramHashMap.put(String.valueOf(paramLong), paramMsgHead.discuss_info.discuss_remark.get().toStringUtf8());
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if (MessageForTroopFile.class.isInstance(paramChatMessage)) {
      return true;
    }
    if (MessageForFile.class.isInstance(paramChatMessage)) {
      return !FileManagerUtil.a(paramQQAppInterface, (MessageForFile)paramChatMessage).sendCloudUnsuccessful();
    }
    if (MessageForDLFile.class.isInstance(paramChatMessage))
    {
      paramChatMessage = (MessageForDLFile)paramChatMessage;
      int i = paramChatMessage.deviceType;
      long l = paramChatMessage.associatedId;
      paramQQAppInterface = paramQQAppInterface.getMessageFacade().d(i).a(l);
      if (paramQQAppInterface != null) {
        return FileUtils.fileExistsAndNotEmpty(paramQQAppInterface.path);
      }
      return false;
    }
    if (MessageForPic.class.isInstance(paramChatMessage)) {
      return true;
    }
    if (MessageForShortVideo.class.isInstance(paramChatMessage)) {
      return ((MessageForShortVideo)paramChatMessage).checkForward();
    }
    return b(paramChatMessage);
  }
  
  public static boolean b(ChatMessage paramChatMessage)
  {
    if (MessageForStructing.class.isInstance(paramChatMessage))
    {
      paramChatMessage = (MessageForStructing)paramChatMessage;
      if ((StructMsgForImageShare.class.isInstance(paramChatMessage.structingMsg)) && (((StructMsgForImageShare)paramChatMessage.structingMsg).getFirstImageElement() != null)) {
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  public static byte[] b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +36 -> 39
    //   6: new 123	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   13: astore_2
    //   14: aload_2
    //   15: ldc_w 731
    //   18: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_2
    //   23: aload_0
    //   24: arraylength
    //   25: invokevirtual 349	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: ldc 138
    //   31: iconst_2
    //   32: aload_2
    //   33: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: aconst_null
    //   40: astore 5
    //   42: aconst_null
    //   43: astore 4
    //   45: new 608	java/io/ByteArrayInputStream
    //   48: dup
    //   49: aload_0
    //   50: invokespecial 609	java/io/ByteArrayInputStream:<init>	([B)V
    //   53: astore 6
    //   55: new 611	java/io/ByteArrayOutputStream
    //   58: dup
    //   59: invokespecial 612	java/io/ByteArrayOutputStream:<init>	()V
    //   62: astore 7
    //   64: aload 4
    //   66: astore_2
    //   67: aload 5
    //   69: astore_3
    //   70: sipush 1024
    //   73: newarray byte
    //   75: astore 8
    //   77: aload 4
    //   79: astore_2
    //   80: aload 5
    //   82: astore_3
    //   83: new 733	java/util/zip/GZIPInputStream
    //   86: dup
    //   87: aload 6
    //   89: invokespecial 736	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   92: astore 9
    //   94: aload 4
    //   96: astore_2
    //   97: aload 5
    //   99: astore_3
    //   100: aload 9
    //   102: aload 8
    //   104: iconst_0
    //   105: sipush 1024
    //   108: invokevirtual 737	java/util/zip/GZIPInputStream:read	([BII)I
    //   111: istore_1
    //   112: iload_1
    //   113: iconst_m1
    //   114: if_icmpeq +21 -> 135
    //   117: aload 4
    //   119: astore_2
    //   120: aload 5
    //   122: astore_3
    //   123: aload 7
    //   125: aload 8
    //   127: iconst_0
    //   128: iload_1
    //   129: invokevirtual 738	java/io/ByteArrayOutputStream:write	([BII)V
    //   132: goto -38 -> 94
    //   135: aload 4
    //   137: astore_2
    //   138: aload 5
    //   140: astore_3
    //   141: aload 9
    //   143: invokevirtual 739	java/util/zip/GZIPInputStream:close	()V
    //   146: aload 4
    //   148: astore_2
    //   149: aload 5
    //   151: astore_3
    //   152: aload 7
    //   154: invokevirtual 632	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   157: astore 4
    //   159: aload 4
    //   161: astore_2
    //   162: aload 4
    //   164: astore_3
    //   165: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   168: ifeq +65 -> 233
    //   171: aload 4
    //   173: astore_2
    //   174: aload 4
    //   176: astore_3
    //   177: new 123	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   184: astore 5
    //   186: aload 4
    //   188: astore_2
    //   189: aload 4
    //   191: astore_3
    //   192: aload 5
    //   194: ldc_w 741
    //   197: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload 4
    //   203: astore_2
    //   204: aload 4
    //   206: astore_3
    //   207: aload 5
    //   209: aload 4
    //   211: arraylength
    //   212: invokevirtual 349	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload 4
    //   218: astore_2
    //   219: aload 4
    //   221: astore_3
    //   222: ldc 138
    //   224: iconst_2
    //   225: aload 5
    //   227: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   233: aload 7
    //   235: invokevirtual 635	java/io/ByteArrayOutputStream:close	()V
    //   238: aload 6
    //   240: invokevirtual 636	java/io/ByteArrayInputStream:close	()V
    //   243: aload 4
    //   245: astore 5
    //   247: goto +242 -> 489
    //   250: astore 6
    //   252: aload 4
    //   254: astore 5
    //   256: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   259: ifeq +230 -> 489
    //   262: new 123	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   269: astore_3
    //   270: aload 4
    //   272: astore_2
    //   273: aload 6
    //   275: astore 4
    //   277: aload_3
    //   278: ldc_w 743
    //   281: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload_3
    //   286: aload 4
    //   288: invokevirtual 641	java/io/IOException:getMessage	()Ljava/lang/String;
    //   291: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: ldc 138
    //   297: iconst_2
    //   298: aload_3
    //   299: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   305: aload_2
    //   306: astore 5
    //   308: goto +181 -> 489
    //   311: astore_0
    //   312: goto +187 -> 499
    //   315: astore_3
    //   316: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   319: ifeq +42 -> 361
    //   322: new 123	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   329: astore 4
    //   331: aload 4
    //   333: ldc_w 745
    //   336: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload 4
    //   342: aload_3
    //   343: invokevirtual 644	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   346: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: ldc 138
    //   352: iconst_2
    //   353: aload 4
    //   355: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   361: aload 7
    //   363: invokevirtual 635	java/io/ByteArrayOutputStream:close	()V
    //   366: aload 6
    //   368: invokevirtual 636	java/io/ByteArrayInputStream:close	()V
    //   371: aload_2
    //   372: astore 5
    //   374: goto +115 -> 489
    //   377: astore 4
    //   379: aload_2
    //   380: astore 5
    //   382: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   385: ifeq +104 -> 489
    //   388: new 123	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   395: astore_3
    //   396: goto -119 -> 277
    //   399: astore_2
    //   400: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   403: ifeq +42 -> 445
    //   406: new 123	java/lang/StringBuilder
    //   409: dup
    //   410: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   413: astore 4
    //   415: aload 4
    //   417: ldc_w 745
    //   420: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: aload 4
    //   426: aload_2
    //   427: invokevirtual 647	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   430: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: pop
    //   434: ldc 138
    //   436: iconst_2
    //   437: aload 4
    //   439: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   445: aload 7
    //   447: invokevirtual 635	java/io/ByteArrayOutputStream:close	()V
    //   450: aload 6
    //   452: invokevirtual 636	java/io/ByteArrayInputStream:close	()V
    //   455: aload_3
    //   456: astore 5
    //   458: goto +31 -> 489
    //   461: astore 4
    //   463: aload_3
    //   464: astore 5
    //   466: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   469: ifeq +20 -> 489
    //   472: new 123	java/lang/StringBuilder
    //   475: dup
    //   476: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   479: astore 5
    //   481: aload_3
    //   482: astore_2
    //   483: aload 5
    //   485: astore_3
    //   486: goto -209 -> 277
    //   489: aload 5
    //   491: ifnonnull +5 -> 496
    //   494: aload_0
    //   495: areturn
    //   496: aload 5
    //   498: areturn
    //   499: aload 7
    //   501: invokevirtual 635	java/io/ByteArrayOutputStream:close	()V
    //   504: aload 6
    //   506: invokevirtual 636	java/io/ByteArrayInputStream:close	()V
    //   509: goto +45 -> 554
    //   512: astore_2
    //   513: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   516: ifeq +38 -> 554
    //   519: new 123	java/lang/StringBuilder
    //   522: dup
    //   523: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   526: astore_3
    //   527: aload_3
    //   528: ldc_w 743
    //   531: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: pop
    //   535: aload_3
    //   536: aload_2
    //   537: invokevirtual 641	java/io/IOException:getMessage	()Ljava/lang/String;
    //   540: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: pop
    //   544: ldc 138
    //   546: iconst_2
    //   547: aload_3
    //   548: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   551: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   554: goto +5 -> 559
    //   557: aload_0
    //   558: athrow
    //   559: goto -2 -> 557
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	562	0	paramArrayOfByte	byte[]
    //   111	18	1	i	int
    //   13	367	2	localObject1	Object
    //   399	28	2	localException	Exception
    //   482	1	2	localObject2	Object
    //   512	25	2	localIOException1	java.io.IOException
    //   69	230	3	localObject3	Object
    //   315	28	3	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   395	153	3	localObject4	Object
    //   43	311	4	localObject5	Object
    //   377	1	4	localIOException2	java.io.IOException
    //   413	25	4	localStringBuilder	StringBuilder
    //   461	1	4	localIOException3	java.io.IOException
    //   40	457	5	localObject6	Object
    //   53	186	6	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   250	255	6	localIOException4	java.io.IOException
    //   62	438	7	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   75	51	8	arrayOfByte	byte[]
    //   92	50	9	localGZIPInputStream	java.util.zip.GZIPInputStream
    // Exception table:
    //   from	to	target	type
    //   233	243	250	java/io/IOException
    //   70	77	311	finally
    //   83	94	311	finally
    //   100	112	311	finally
    //   123	132	311	finally
    //   141	146	311	finally
    //   152	159	311	finally
    //   165	171	311	finally
    //   177	186	311	finally
    //   192	201	311	finally
    //   207	216	311	finally
    //   222	233	311	finally
    //   316	361	311	finally
    //   400	445	311	finally
    //   70	77	315	java/lang/OutOfMemoryError
    //   83	94	315	java/lang/OutOfMemoryError
    //   100	112	315	java/lang/OutOfMemoryError
    //   123	132	315	java/lang/OutOfMemoryError
    //   141	146	315	java/lang/OutOfMemoryError
    //   152	159	315	java/lang/OutOfMemoryError
    //   165	171	315	java/lang/OutOfMemoryError
    //   177	186	315	java/lang/OutOfMemoryError
    //   192	201	315	java/lang/OutOfMemoryError
    //   207	216	315	java/lang/OutOfMemoryError
    //   222	233	315	java/lang/OutOfMemoryError
    //   361	371	377	java/io/IOException
    //   70	77	399	java/lang/Exception
    //   83	94	399	java/lang/Exception
    //   100	112	399	java/lang/Exception
    //   123	132	399	java/lang/Exception
    //   141	146	399	java/lang/Exception
    //   152	159	399	java/lang/Exception
    //   165	171	399	java/lang/Exception
    //   177	186	399	java/lang/Exception
    //   192	201	399	java/lang/Exception
    //   207	216	399	java/lang/Exception
    //   222	233	399	java/lang/Exception
    //   445	455	461	java/io/IOException
    //   499	509	512	java/io/IOException
  }
  
  private void c(@NonNull HashMap<String, String> paramHashMap, MessageInfo paramMessageInfo, msg_comm.Msg paramMsg, msg_comm.MsgHead paramMsgHead, long paramLong, MessageHandler paramMessageHandler, ArrayList<MessageRecord> paramArrayList)
  {
    if (!((QQAppInterface)this.app).getFileManagerEngine().a().a(paramArrayList, paramMsg)) {
      MessageProtoCodec.a(paramMessageHandler, paramArrayList, paramMsg, false, false, paramMessageInfo);
    }
    if (paramMsgHead.group_info.group_card.has()) {
      paramHashMap.put(String.valueOf(paramLong), paramMsgHead.group_info.group_card.get().toStringUtf8());
    }
  }
  
  private static boolean d(MessageRecord paramMessageRecord)
  {
    MessageForStructing localMessageForStructing = (MessageForStructing)paramMessageRecord;
    if ((localMessageForStructing.structingMsg != null) && (localMessageForStructing.structingMsg.mMsgServiceID == 82)) {
      return false;
    }
    if ((localMessageForStructing.structingMsg != null) && ("viewMultiMsg".equals(localMessageForStructing.structingMsg.mMsgAction))) {
      return false;
    }
    if (paramMessageRecord.msgtype != -2011) {
      return false;
    }
    if ((localMessageForStructing.structingMsg != null) && (localMessageForStructing.structingMsg.fwFlag == 1)) {
      return false;
    }
    return (localMessageForStructing.structingMsg == null) || (!localMessageForStructing.structingMsg.hasFlag(1));
  }
  
  private im_msg_body.RichText e(MessageRecord paramMessageRecord)
  {
    String str = HardCodeUtil.a(2131904887);
    if ((paramMessageRecord instanceof MessageForTroopFile)) {
      str = ((MessageForTroopFile)paramMessageRecord).getSummaryMsg();
    }
    return MessageProtoCodec.a((MessageForText)a(paramMessageRecord, str, false));
  }
  
  private im_msg_body.RichText f(MessageRecord paramMessageRecord)
  {
    String str = HardCodeUtil.a(2131904889);
    if ((paramMessageRecord instanceof MessageForFile)) {
      str = ((MessageForFile)paramMessageRecord).getSummaryMsg();
    }
    return MessageProtoCodec.a((MessageForText)a(paramMessageRecord, str, false));
  }
  
  private im_msg_body.RichText g(MessageRecord paramMessageRecord)
  {
    if (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("sens_msg_source_msg_info"))) {
      return MessageProtoCodec.a(paramMessageRecord);
    }
    return MessageProtoCodec.a((MessageForText)paramMessageRecord);
  }
  
  protected MessageRecord a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("queryLastMsg,delNum:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("MultiMsg_TAG", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (ArrayList)b().rawQuery(MessageRecord.class, "select * from mr_multimessage limit 1 offset ?", new String[] { String.valueOf(paramInt - 1) });
    if ((localObject != null) && (((ArrayList)localObject).size() >= 1)) {
      return (MessageRecord)((ArrayList)localObject).get(0);
    }
    return null;
  }
  
  public MessageRecord a(MessageRecord paramMessageRecord, String paramString, boolean paramBoolean)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
    localMessageRecord.msg = paramString;
    localMessageRecord.uniseq = paramMessageRecord.uniseq;
    localMessageRecord.msgseq = paramMessageRecord.msgseq;
    localMessageRecord.time = paramMessageRecord.time;
    localMessageRecord.shmsgseq = paramMessageRecord.shmsgseq;
    localMessageRecord.msgUid = paramMessageRecord.msgUid;
    localMessageRecord.selfuin = paramMessageRecord.selfuin;
    localMessageRecord.senderuin = paramMessageRecord.senderuin;
    localMessageRecord.frienduin = paramMessageRecord.frienduin;
    localMessageRecord.istroop = paramMessageRecord.istroop;
    localMessageRecord.vipBubbleDiyTextId = paramMessageRecord.vipBubbleDiyTextId;
    localMessageRecord.vipBubbleID = paramMessageRecord.vipBubbleID;
    localMessageRecord.isMultiMsg = paramMessageRecord.isMultiMsg;
    localMessageRecord.extLong = paramMessageRecord.extLong;
    localMessageRecord.extStr = paramMessageRecord.extStr;
    if (paramBoolean)
    {
      localMessageRecord.setId(paramMessageRecord.getId());
      localMessageRecord.setStatus(paramMessageRecord.getStatus());
      b().update(localMessageRecord);
    }
    return localMessageRecord;
  }
  
  public String a(int paramInt, MessageForStructing paramMessageForStructing)
  {
    String str = "MultiMsg";
    if (paramInt > 0)
    {
      if ((paramMessageForStructing != null) && (paramMessageForStructing.structingMsg != null) && (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mFileName))) {
        return paramMessageForStructing.structingMsg.mFileName;
      }
      paramMessageForStructing = new StringBuilder();
      paramMessageForStructing.append("MultiMsg");
      paramMessageForStructing.append("_");
      paramMessageForStructing.append(paramInt);
      str = paramMessageForStructing.toString();
      paramMessageForStructing = new StringBuilder();
      paramMessageForStructing.append("resid is null! ");
      paramMessageForStructing.append(str);
      QLog.d("MultiMsg_TAG", 1, paramMessageForStructing.toString());
    }
    return str;
  }
  
  public ArrayList<MessageRecord> a(long paramLong)
  {
    ArrayList localArrayList = (ArrayList)b().rawQuery(MessageRecord.class, "select * from mr_multimessage where msgseq=? order by _id asc", new String[] { String.valueOf(paramLong) });
    if ((localArrayList != null) && (localArrayList.size() >= 1))
    {
      Object localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (MessageRecord)((Iterator)localObject1).next();
        ((MessageRecord)localObject2).isMultiMsg = true;
        if (((MessageRecord)localObject2).msgtype == -1035)
        {
          localObject2 = ((MessageForMixedMsg)localObject2).msgElemList.iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((MessageRecord)((Iterator)localObject2).next()).isMultiMsg = true;
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("querySevalMsgFromMultiMsg,list.get(0).uniseq:");
        ((StringBuilder)localObject1).append(((MessageRecord)localArrayList.get(0)).uniseq);
        ((StringBuilder)localObject1).append(" msgseq:");
        ((StringBuilder)localObject1).append(((MessageRecord)localArrayList.get(0)).msgseq);
        QLog.d("MultiMsg_TAG", 2, ((StringBuilder)localObject1).toString());
      }
      return localArrayList;
    }
    return new ArrayList();
  }
  
  public ArrayList<MessageRecord> a(MessageRecord paramMessageRecord, ArrayList<? extends MessageRecord> paramArrayList, ProxyListener paramProxyListener, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramMessageRecord = a(paramMessageRecord, paramArrayList, paramProxyListener, paramBoolean1, paramBoolean2, new ArrayList(0));
    if (paramBoolean1) {
      this.proxyManager.transSaveToDatabase();
    }
    return paramMessageRecord;
  }
  
  public ArrayList<MessageRecord> a(MessageRecord paramMessageRecord, ArrayList<? extends MessageRecord> paramArrayList, ProxyListener paramProxyListener, boolean paramBoolean1, boolean paramBoolean2, ArrayList<MessageRecord> paramArrayList1)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = paramArrayList.iterator();
    while (localIterator1.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator1.next();
      Object localObject1 = "MultiMsg_TAG";
      Object localObject2;
      if (paramBoolean2)
      {
        if (localMessageRecord.msgtype == -1037) {
          paramArrayList = ((MessageForLongMsg)localMessageRecord).rebuildLongMsg(true);
        }
        for (;;)
        {
          break;
          if (localMessageRecord.msgtype == -1036)
          {
            paramArrayList = (MessageForMixedMsg)((MessageForLongMsg)localMessageRecord).rebuildLongMsg();
          }
          else if (localMessageRecord.msgtype == -1035)
          {
            localObject3 = (MessageForMixedMsg)localMessageRecord;
            paramArrayList = ((MessageForMixedMsg)localObject3).rebuildMixedMsg();
            localObject2 = (MessageForMixedMsg)paramArrayList;
            if (((MessageForMixedMsg)localObject2).getReplyMessage((QQAppInterface)this.app) != null)
            {
              paramArrayList1.add(((MessageForMixedMsg)localObject2).getReplyMessage((QQAppInterface)this.app));
              localObject3 = ((MessageForMixedMsg)localObject3).getReplyMessage((QQAppInterface)this.app);
              localObject2 = ((MessageForMixedMsg)localObject2).getReplyMessage((QQAppInterface)this.app);
              if ((localObject3 != null) && (localObject2 != null)) {
                QFileUtils.b((QQAppInterface)this.app, ((MessageForReplyText)localObject3).getSourceMessage(), ((MessageForReplyText)localObject2).getSourceMessage());
              }
            }
          }
          else if (localMessageRecord.msgtype == -2011)
          {
            paramArrayList = new MessageForStructing(localMessageRecord);
          }
          else if (localMessageRecord.msgtype == -1049)
          {
            paramArrayList = (MessageRecord)localMessageRecord.deepCopyByReflect();
            localObject2 = (MessageForReplyText)paramArrayList;
            ((MessageForReplyText)localObject2).deepCopySourceMsg((MessageForReplyText)localMessageRecord);
            ((MessageForReplyText)localObject2).isBarrageMsg = false;
            ((MessageForReplyText)localObject2).barrageTimeLocation = 0L;
            paramArrayList.removeExtInfoToExtStr("barrage_time_location");
            paramArrayList.removeExtInfoToExtStr("barrage_source_msg_type");
          }
          else
          {
            paramArrayList = (MessageRecord)localMessageRecord.deepCopyByReflect();
          }
        }
        if (paramArrayList == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "preAddMultiMsg.mrTemp is null ,not normal...");
          }
          return null;
        }
        if (!TextUtils.isEmpty(paramArrayList.getExtInfoFromExtStr("troop_at_info_list"))) {
          paramArrayList.removeExtInfoToExtStr("troop_at_info_list");
        }
        if (!TextUtils.isEmpty(paramArrayList.getExtInfoFromExtStr("disc_at_info_list"))) {
          paramArrayList.removeExtInfoToExtStr("disc_at_info_list");
        }
        paramArrayList.atInfoList = null;
        if ((AnonymousChatHelper.c(paramArrayList)) && (AnonymousChatHelper.f(paramArrayList))) {
          paramArrayList.senderuin = "80000000";
        }
        paramArrayList.extLong = localMessageRecord.extLong;
        localObject2 = paramArrayList;
      }
      else
      {
        localObject2 = localMessageRecord;
      }
      ((MessageRecord)localObject2).createMessageUniseq();
      ((MessageRecord)localObject2).msgseq = paramMessageRecord.uniseq;
      ((MessageRecord)localObject2).isMultiMsg = true;
      ((MessageRecord)localObject2).setExtraFlag(32770);
      Object localObject3 = localObject1;
      if (((MessageRecord)localObject2).msgtype == -1035)
      {
        Iterator localIterator2 = ((MessageForMixedMsg)localObject2).msgElemList.iterator();
        paramArrayList = (ArrayList<? extends MessageRecord>)localObject1;
        for (;;)
        {
          localObject3 = paramArrayList;
          if (!localIterator2.hasNext()) {
            break;
          }
          localObject1 = (MessageRecord)localIterator2.next();
          ((MessageRecord)localObject1).msgseq = ((MessageRecord)localObject2).msgseq;
          ((MessageRecord)localObject1).isMultiMsg = true;
        }
      }
      QFileUtils.b((QQAppInterface)this.app, localMessageRecord, (MessageRecord)localObject2);
      if (((MessageRecord)localObject2).msgtype == -1049)
      {
        paramArrayList = (MessageForReplyText)localMessageRecord;
        localObject1 = (MessageForReplyText)localObject2;
        QFileUtils.b((QQAppInterface)this.app, paramArrayList.getSourceMessage(), ((MessageForReplyText)localObject1).getSourceMessage());
      }
      if (((MessageRecord)localObject2).msgtype == -2022) {
        ((MessageForShortVideo)localObject2).redBagType = 0;
      }
      localArrayList.add(localObject2);
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("preAddMultiMsg, MessageRecord:");
        paramArrayList.append(localMessageRecord.toString());
        QLog.d((String)localObject3, 2, paramArrayList.toString());
      }
      if (paramBoolean1) {
        if (((MessageRecord)localObject2).getStatus() == 1000) {
          this.proxyManager.addMsgQueueDonotNotify(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).getTableName(), (Entity)localObject2, 0, paramProxyListener);
        } else {
          a((MessageRecord)localObject2, null);
        }
      }
    }
    return localArrayList;
  }
  
  public ArrayList<MessageRecord> a(msg_comm.Msg paramMsg, HashMap<String, String> paramHashMap, MessageRecord paramMessageRecord, MessageInfo paramMessageInfo)
  {
    if ((paramMsg.msg_body.has()) && ((((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has()) || (((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has())))
    {
      Object localObject = (msg_comm.MsgHead)paramMsg.msg_head.get();
      long l2 = ((msg_comm.MsgHead)localObject).from_uin.get();
      long l3 = ((msg_comm.MsgHead)localObject).msg_seq.get();
      long l6 = ((msg_comm.MsgHead)localObject).msg_time.get();
      long l5 = ((msg_comm.MsgHead)localObject).msg_uid.get();
      int i = ((msg_comm.MsgHead)localObject).msg_type.get();
      String str = String.valueOf(l2);
      MessageHandler localMessageHandler = ((QQAppInterface)this.app).getMsgHandler();
      long l4 = DecodeC2CMsgPkgBubbleID.a(localMessageHandler, paramMsg, String.valueOf(l2), String.valueOf(l2));
      ArrayList localArrayList = new ArrayList();
      long l1;
      if (((MessageUtils.d(i)) || (i == 208) || (i == 529)) && (((msg_comm.MsgHead)localObject).c2c_cmd.has()))
      {
        paramHashMap = a(paramMsg, paramHashMap, paramMessageInfo, (msg_comm.MsgHead)localObject, l2, i, str, localMessageHandler, localArrayList, paramMessageRecord);
        l1 = l2;
      }
      else
      {
        j = i;
        if (((j == 82) || (j == 43)) && (((msg_comm.MsgHead)localObject).group_info.has()))
        {
          l1 = ((msg_comm.MsgHead)localObject).group_info.group_code.get();
          paramHashMap = a(paramMsg, paramHashMap, paramMessageRecord, (msg_comm.MsgHead)localObject, l2, str, localMessageHandler, localArrayList, paramMessageInfo);
        }
        for (;;)
        {
          break;
          if (j != 83) {
            if (j != 42) {
              break label354;
            }
          }
          if (((msg_comm.MsgHead)localObject).discuss_info.has())
          {
            l1 = ((msg_comm.MsgHead)localObject).discuss_info.discuss_uin.get();
            paramHashMap = a(paramMsg, paramHashMap, paramMessageRecord, paramMessageInfo, (msg_comm.MsgHead)localObject, l2, str, localMessageHandler, localArrayList);
          }
          else
          {
            label354:
            l1 = l2;
            paramHashMap = str;
          }
        }
      }
      int j = i;
      int k = DecodeC2CMsgPkgBubbleID.a(paramMsg);
      paramMessageInfo = localArrayList.iterator();
      i = 0;
      paramMsg = (msg_comm.Msg)localObject;
      while (paramMessageInfo.hasNext())
      {
        localObject = a(paramMessageRecord, paramMsg, localArrayList, i, (MessageRecord)paramMessageInfo.next());
        ((MessageRecord)localObject).time = l6;
        ((MessageRecord)localObject).shmsgseq = l3;
        ((MessageRecord)localObject).msgUid = l5;
        ((MessageRecord)localObject).selfuin = ((QQAppInterface)this.app).getCurrentAccountUin();
        ((MessageRecord)localObject).senderuin = String.valueOf(l2);
        ((MessageRecord)localObject).frienduin = String.valueOf(l1);
        ((MessageRecord)localObject).vipBubbleDiyTextId = k;
        ((MessageRecord)localObject).vipBubbleID = SVIPHandlerConstants.a((int)l4, k);
        MultiMsgUtil.a((MessageRecord)localObject, paramHashMap, paramMessageRecord);
        if ((j != 82) && (j != 43))
        {
          if ((j != 83) && (j != 42)) {
            ((MessageRecord)localObject).istroop = 0;
          } else {
            ((MessageRecord)localObject).istroop = 3000;
          }
        }
        else {
          ((MessageRecord)localObject).istroop = 1;
        }
        i += 1;
      }
      BaseMessageHandlerUtils.a(localArrayList);
      return localArrayList;
    }
    if (QLog.isColorLevel())
    {
      paramHashMap = new StringBuilder();
      paramHashMap.append("unpackPbToMultiMsgWithNest, no msg_body or rich_text, msg_body.has():");
      paramHashMap.append(paramMsg.msg_body.has());
      QLog.d("MultiMsg_TAG", 2, paramHashMap.toString());
    }
    return null;
  }
  
  public ArrayList<MessageRecord> a(@NonNull byte[] paramArrayOfByte, @NonNull HashMap<String, String> paramHashMap, MessageRecord paramMessageRecord, MessageInfo paramMessageInfo)
  {
    System.currentTimeMillis();
    Object localObject2 = b(paramArrayOfByte);
    paramArrayOfByte = new ArrayList();
    Object localObject3 = new msg_transmit.PbMultiMsgTransmit();
    Object localObject1 = paramArrayOfByte;
    try
    {
      localObject2 = (msg_transmit.PbMultiMsgTransmit)((msg_transmit.PbMultiMsgTransmit)localObject3).mergeFrom((byte[])localObject2);
      i = 0;
    }
    catch (Exception paramArrayOfByte)
    {
      try
      {
        for (;;)
        {
          int i;
          Object localObject4;
          msg_comm.MsgHead localMsgHead;
          long l7;
          long l3;
          long l4;
          long l2;
          MessageHandler localMessageHandler;
          l1 = DecodeC2CMsgPkgBubbleID.a(localMessageHandler, (msg_comm.Msg)localObject4, String.valueOf(l7), String.valueOf(l7));
          localObject3 = new ArrayList();
          l6 = a(paramHashMap, paramMessageInfo, (msg_comm.Msg)localObject4, localMsgHead, l7, l7, j, localMessageHandler, (ArrayList)localObject3);
          a(paramMessageRecord, (msg_comm.Msg)localObject4, localMessageHandler, (ArrayList)localObject3);
          k = DecodeC2CMsgPkgBubbleID.a((msg_comm.Msg)localObject4);
          localObject1 = ((ArrayList)localObject3).iterator();
          l5 = l1;
          l1 = l6;
          if (((Iterator)localObject1).hasNext())
          {
            localObject4 = (MessageRecord)((Iterator)localObject1).next();
            ((MessageRecord)localObject4).time = l4;
            ((MessageRecord)localObject4).shmsgseq = l3;
            ((MessageRecord)localObject4).msgUid = l2;
            ((MessageRecord)localObject4).selfuin = ((QQAppInterface)this.app).getCurrentAccountUin();
            ((MessageRecord)localObject4).senderuin = String.valueOf(l7);
            ((MessageRecord)localObject4).frienduin = String.valueOf(l1);
            ((MessageRecord)localObject4).vipBubbleDiyTextId = k;
            m = (int)l5;
            ((MessageRecord)localObject4).vipBubbleID = SVIPHandlerConstants.a(m, k);
            if (j != 82)
            {
              if (j != 43) {
                break label477;
              }
              break label400;
              ((MessageRecord)localObject4).istroop = 0;
              break label494;
              ((MessageRecord)localObject4).istroop = 3000;
              break label494;
            }
            ((MessageRecord)localObject4).istroop = 1;
            break label494;
          }
          BaseMessageHandlerUtils.a((List)localObject3);
          localObject1 = paramArrayOfByte;
          try
          {
            ((ArrayList)localObject1).addAll((Collection)localObject3);
            i += 1;
            paramArrayOfByte = (byte[])localObject1;
          }
          catch (Exception paramArrayOfByte)
          {
            paramHashMap = paramArrayOfByte;
            paramArrayOfByte = paramArrayOfByte;
            break label459;
          }
        }
        paramHashMap = paramArrayOfByte;
        a(paramMessageRecord, paramHashMap, null);
        return paramHashMap;
      }
      catch (Exception paramMessageRecord)
      {
        for (;;)
        {
          int j;
          paramHashMap = paramArrayOfByte;
          paramArrayOfByte = paramMessageRecord;
        }
      }
      paramArrayOfByte = paramArrayOfByte;
      paramHashMap = (HashMap<String, String>)localObject1;
    }
    localObject1 = paramArrayOfByte;
    if (i < ((msg_transmit.PbMultiMsgTransmit)localObject2).msg.size())
    {
      localObject1 = paramArrayOfByte;
      localObject4 = (msg_comm.Msg)((msg_transmit.PbMultiMsgTransmit)localObject2).msg.get(i);
      localObject1 = paramArrayOfByte;
      localMsgHead = (msg_comm.MsgHead)((msg_comm.Msg)localObject4).msg_head.get();
      localObject1 = paramArrayOfByte;
      l7 = localMsgHead.from_uin.get();
      localObject1 = paramArrayOfByte;
      l3 = localMsgHead.msg_seq.get();
      localObject1 = paramArrayOfByte;
      l4 = localMsgHead.msg_time.get();
      localObject1 = paramArrayOfByte;
      l2 = localMsgHead.msg_uid.get();
      localObject1 = paramArrayOfByte;
      j = localMsgHead.msg_type.get();
      localObject1 = paramArrayOfByte;
      localMessageHandler = ((QQAppInterface)this.app).getMsgHandler();
    }
    label400:
    label459:
    label477:
    label494:
    for (;;)
    {
      long l1;
      long l6;
      int k;
      long l5;
      int m;
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "unpackPbToMultiMsg, error: exception occurs while parsing the pb bytes", paramArrayOfByte);
      }
      return paramHashMap;
      if (j != 83) {
        if (j == 42) {}
      }
    }
  }
  
  public HashMap<String, ArrayList<MessageRecord>> a(MessageRecord paramMessageRecord, HashMap<String, ArrayList<MessageRecord>> paramHashMap, ProxyListener paramProxyListener, boolean paramBoolean1, boolean paramBoolean2)
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    if ((paramMessageRecord != null) && (paramHashMap != null))
    {
      if (!MultiMsgUtil.a((ChatMessage)paramMessageRecord))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "preAddMultiMsgWithNest error before of not structMsg");
        }
        return localHashMap;
      }
      a((MessageForStructing)paramMessageRecord, paramHashMap, localHashMap, 0, paramProxyListener, paramBoolean1, paramBoolean2, localArrayList);
      if (localArrayList.size() > 0) {
        localHashMap.put("reply_msg", localArrayList);
      }
      if (paramBoolean1)
      {
        this.proxyManager.transSaveToDatabase();
        return localHashMap;
      }
      return localHashMap;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "preAddMultiMsgWithNest error before of null msg or map");
    }
    return localHashMap;
  }
  
  public msg_comm.MsgHead a(MessageRecord paramMessageRecord, HashMap<String, String> paramHashMap, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    msg_comm.MsgHead localMsgHead = new msg_comm.MsgHead();
    localMsgHead.from_uin.set(Long.valueOf(MsgProxyUtils.d(paramMessageRecord)).longValue());
    localMsgHead.msg_seq.set((int)paramMessageRecord.shmsgseq);
    localMsgHead.msg_time.set((int)paramMessageRecord.time);
    localMsgHead.msg_uid.set(Long.valueOf(paramMessageRecord.msgUid).longValue());
    Object localObject1 = new msg_comm.MutilTransHead();
    Object localObject2 = ((msg_comm.MutilTransHead)localObject1).status;
    int i;
    if (paramBoolean1) {
      i = 0;
    } else {
      i = -1;
    }
    ((PBUInt32Field)localObject2).set(i);
    ((msg_comm.MutilTransHead)localObject1).msgId.set(paramInt);
    localMsgHead.mutiltrans_head.set((MessageMicro)localObject1);
    localObject2 = paramMessageRecord.getExtInfoFromExtStr("self_nickname");
    String str = MsgProxyUtils.d(paramMessageRecord);
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (paramHashMap != null)
      {
        localObject1 = localObject2;
        if (paramHashMap.containsKey(str)) {
          localObject1 = (String)paramHashMap.get(str);
        }
      }
    }
    MultiMsgUtil.a("step:packPb.getMsgHead.nickName = %s", new Object[] { localObject1 });
    if ((paramMessageRecord.istroop != 0) && (paramMessageRecord.istroop != 1000) && (paramMessageRecord.istroop != 1004) && (paramMessageRecord.istroop != 1022))
    {
      if (paramMessageRecord.istroop == 3000)
      {
        localMsgHead.msg_type.set(83);
        paramHashMap = new msg_comm.DiscussInfo();
        paramHashMap.discuss_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          paramHashMap.discuss_remark.set(ByteStringMicro.copyFromUtf8((String)localObject1));
        }
        localMsgHead.discuss_info.set(paramHashMap);
        return localMsgHead;
      }
      if (paramMessageRecord.istroop == 1)
      {
        localMsgHead.msg_type.set(82);
        paramHashMap = new msg_comm.GroupInfo();
        paramHashMap.group_code.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          paramHashMap.group_card.set(ByteStringMicro.copyFromUtf8((String)localObject1));
        }
        localMsgHead.group_info.set(paramHashMap);
        return localMsgHead;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "MultiMsg:getMultiMsgHead, error:mr is not a C2C/dis/troop msg");
      }
      return null;
    }
    if ((paramMessageRecord instanceof MessageForPtt)) {
      localMsgHead.msg_type.set(208);
    } else if ((!paramBoolean2) && ((paramMessageRecord instanceof MessageForFile))) {
      localMsgHead.msg_type.set(529);
    } else if ((!paramBoolean2) && ((paramMessageRecord instanceof MessageForDLFile))) {
      localMsgHead.msg_type.set(529);
    } else {
      localMsgHead.msg_type.set(9);
    }
    if ((!(paramMessageRecord instanceof MessageForText)) && (!(paramMessageRecord instanceof MessageForStructing)))
    {
      if ((!paramBoolean2) && ((paramMessageRecord instanceof MessageForFile))) {
        localMsgHead.c2c_cmd.set(4);
      } else if ((!paramBoolean2) && ((paramMessageRecord instanceof MessageForDLFile))) {
        localMsgHead.c2c_cmd.set(4);
      } else {
        localMsgHead.c2c_cmd.set(175);
      }
    }
    else {
      localMsgHead.c2c_cmd.set(11);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      localMsgHead.from_nick.set((String)localObject1);
    }
    return localMsgHead;
  }
  
  public im_msg_body.MsgBody a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    Object localObject1 = null;
    Exception localException2 = null;
    Object localObject3 = localObject1;
    for (;;)
    {
      try
      {
        if (paramMessageRecord.msgtype != -1000)
        {
          localObject3 = localObject1;
          if (paramMessageRecord.msgtype != -10000)
          {
            localObject3 = localObject1;
            if (paramMessageRecord.msgtype == -1049)
            {
              localObject3 = localObject1;
              localObject1 = MessageProtoCodec.a((MessageForReplyText)paramMessageRecord);
              continue;
            }
            localObject3 = localObject1;
            if (paramMessageRecord.msgtype == -2005)
            {
              if (paramBoolean)
              {
                localObject3 = localObject1;
                localObject1 = f(paramMessageRecord);
                continue;
              }
              localObject3 = localObject1;
              localObject1 = ((QQAppInterface)this.app).getFileManagerEngine().a().a(1, paramMessageRecord);
              break label677;
            }
            localObject3 = localObject1;
            if (paramMessageRecord.msgtype == -2017)
            {
              if (paramBoolean)
              {
                localObject3 = localObject1;
                localObject1 = e(paramMessageRecord);
                continue;
              }
              localObject3 = localObject1;
              localObject1 = ((QQAppInterface)this.app).getFileManagerEngine().a().a(1, paramMessageRecord);
              break label677;
            }
            localObject3 = localObject1;
            if (paramMessageRecord.msgtype == -3017)
            {
              if (paramBoolean)
              {
                localObject3 = localObject1;
                localObject1 = f(paramMessageRecord);
                continue;
              }
              localObject3 = localObject1;
              localObject1 = ((QQAppInterface)this.app).getFileManagerEngine().a().a(1, paramMessageRecord);
              break label677;
            }
            localObject3 = localObject1;
            if (paramMessageRecord.msgtype == -2000)
            {
              localObject3 = localObject1;
              localObject1 = MessageProtoCodec.a((MessageForPic)paramMessageRecord);
              continue;
            }
            localObject3 = localObject1;
            if (paramMessageRecord.msgtype == -5008)
            {
              localObject3 = localObject1;
              localObject1 = MessageProtoCodec.a((MessageForArkApp)paramMessageRecord, true);
              continue;
            }
            localObject3 = localObject1;
            if (paramMessageRecord.msgtype == -5016)
            {
              localObject3 = localObject1;
              localObject1 = MessageProtoCodec.c((MessageForArkBabyqReply)paramMessageRecord, true);
              continue;
            }
            localObject3 = localObject1;
            if (paramMessageRecord.msgtype == -5017)
            {
              localObject3 = localObject1;
              localObject1 = MessageProtoCodec.b((MessageForArkApp)paramMessageRecord, true);
              continue;
            }
            localObject3 = localObject1;
            if (paramMessageRecord.msgtype == -5013)
            {
              localObject3 = localObject1;
              localObject1 = MessageProtoCodec.c((MessageForArkFlashChat)paramMessageRecord);
              continue;
            }
            localObject3 = localObject1;
            if (paramMessageRecord.msgtype == -5014)
            {
              localObject3 = localObject1;
              localObject1 = MessageProtoCodec.d((MessageForHiBoom)paramMessageRecord);
              continue;
            }
            localObject3 = localObject1;
            if (paramMessageRecord.msgtype == -2011)
            {
              localObject3 = localObject1;
              localObject1 = a((MessageForStructing)paramMessageRecord);
              continue;
            }
            localObject3 = localObject1;
            if (paramMessageRecord.msgtype == -1035)
            {
              localObject3 = localObject1;
              localObject1 = MessageProtoCodec.a((MessageForMixedMsg)paramMessageRecord);
              continue;
            }
            localObject3 = localObject1;
            if (paramMessageRecord.msgtype == -1051)
            {
              localObject3 = localObject1;
              localObject1 = MessageProtoCodec.a((MessageForLongTextMsg)paramMessageRecord, false);
              continue;
            }
            localObject3 = localObject1;
            if (paramMessageRecord.msgtype == -2022)
            {
              localObject3 = localObject1;
              localObject1 = ((MessageForRichText)paramMessageRecord).richText;
              continue;
            }
            localObject3 = localObject1;
            if (paramMessageRecord.msgtype != -2002) {
              break label689;
            }
            localObject3 = localObject1;
            localObject1 = ((MessageForRichText)paramMessageRecord).richText;
            continue;
          }
        }
        localObject3 = localObject1;
        localObject1 = g(paramMessageRecord);
        if (localObject1 != null)
        {
          localObject3 = localException2;
          im_msg_body.ElemFlags2 localElemFlags2 = new im_msg_body.ElemFlags2();
          localObject3 = localException2;
          localElemFlags2.uint32_color_text_id.set((int)(paramMessageRecord.vipBubbleID & 0xFFFFFFFF));
          localObject3 = localException2;
          im_msg_body.Elem localElem = new im_msg_body.Elem();
          localObject3 = localException2;
          localElem.elem_flags2.set(localElemFlags2);
          localObject3 = localException2;
          ((im_msg_body.RichText)localObject1).elems.add(localElem);
          localObject3 = localException2;
          a(paramMessageRecord, (im_msg_body.RichText)localObject1);
        }
        localObject3 = localException2;
        if (localException2 == null)
        {
          localObject3 = localException2;
          paramMessageRecord = new im_msg_body.MsgBody();
          try
          {
            paramMessageRecord.rich_text.set((MessageMicro)localObject1);
            return paramMessageRecord;
          }
          catch (Exception localException1)
          {
            localObject3 = paramMessageRecord;
            paramMessageRecord = localException1;
          }
          QLog.e("MultiMsg_TAG", 1, paramMessageRecord, new Object[0]);
        }
      }
      catch (Exception paramMessageRecord) {}
      return localObject3;
      label677:
      localObject3 = null;
      localException2 = localException1;
      Object localObject2 = localObject3;
      continue;
      label689:
      localObject2 = null;
    }
  }
  
  public void a()
  {
    SQLiteDatabase localSQLiteDatabase = ((QQAppInterface)this.app).getWritableDatabase();
    if (localSQLiteDatabase == null) {
      return;
    }
    int i = localSQLiteDatabase.getCount("mr_multimessage");
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkMsgCounts, count:");
      ((StringBuilder)localObject).append(i);
      QLog.d("MultiMsg_TAG", 2, ((StringBuilder)localObject).toString());
    }
    String str;
    if (i > 1000000)
    {
      i = Math.max(i - 1000000, 200);
      localObject = a(i);
      if (localObject == null) {
        return;
      }
      str = String.format("delete from %s where _id in (select _id from %s order by _id limit %s)", new Object[] { "mr_multimessage", "mr_multimessage", Integer.valueOf(i) });
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkMsgCounts, delNum:");
        localStringBuilder.append(i);
        localStringBuilder.append("mr.msgseq:");
        localStringBuilder.append(((MessageRecord)localObject).msgseq);
        QLog.d("MultiMsg_TAG", 2, localStringBuilder.toString());
      }
    }
    try
    {
      localSQLiteDatabase.execSQL(str);
      label191:
      a(((MessageRecord)localObject).frienduin, ((MessageRecord)localObject).istroop, ((MessageRecord)localObject).msgseq);
      return;
    }
    catch (Exception localException)
    {
      break label191;
    }
  }
  
  protected void a(String paramString, int paramInt, long paramLong)
  {
    this.proxyManager.addMsgQueue(paramString, paramInt, "mr_multimessage", "msgseq=?", new String[] { String.valueOf(paramLong) }, 2, null);
  }
  
  public boolean a(MessageRecord paramMessageRecord, ProxyListener paramProxyListener)
  {
    if (paramMessageRecord.getStatus() == 1000) {
      this.proxyManager.addMsgQueueDonotNotify(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.getTableName(), paramMessageRecord, 3, null);
    } else {
      this.proxyManager.addMsgQueueDonotNotify(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.getTableName(), paramMessageRecord, 4, null);
    }
    this.proxyManager.transSaveToDatabase();
    return true;
  }
  
  public boolean a(MessageRecord paramMessageRecord, HashMap<String, ArrayList<MessageRecord>> paramHashMap, ProxyListener paramProxyListener)
  {
    if ((paramMessageRecord != null) && (paramHashMap != null))
    {
      if (!MessageForStructing.class.isInstance(paramMessageRecord))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "addMultiMsgWithNest error before of not structMsg");
        }
        return false;
      }
      a((MessageForStructing)paramMessageRecord, paramHashMap, 0);
      this.proxyManager.transSaveToDatabase();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "addMultiMsgWithNest error before of null msg or map");
    }
    return false;
  }
  
  protected boolean a(MessageRecord paramMessageRecord, List<MessageRecord> paramList, ProxyListener paramProxyListener)
  {
    b(paramMessageRecord, paramList, paramProxyListener);
    this.proxyManager.transSaveToDatabase();
    return true;
  }
  
  public boolean a(HashMap<String, ArrayList<MessageRecord>> paramHashMap, MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramHashMap != null)
    {
      bool1 = bool2;
      if (paramHashMap.size() > 0)
      {
        Iterator localIterator1 = paramHashMap.keySet().iterator();
        bool1 = false;
        while (localIterator1.hasNext())
        {
          ArrayList localArrayList = (ArrayList)paramHashMap.get((String)localIterator1.next());
          Iterator localIterator2 = localArrayList.iterator();
          int i = 0;
          for (;;)
          {
            bool2 = localIterator2.hasNext();
            bool1 = true;
            if (!bool2) {
              break;
            }
            MessageRecord localMessageRecord1 = (MessageRecord)localIterator2.next();
            if ((localMessageRecord1 instanceof MessageForReplyText))
            {
              MessageRecord localMessageRecord2 = ((MessageForReplyText)localMessageRecord1).getSourceMessage();
              if ((localMessageRecord2 != null) && (((localMessageRecord2 instanceof MessageForPic)) || ((localMessageRecord2 instanceof MessageForShortVideo))) && (localMessageRecord2.uniseq == paramMessageRecord.uniseq)) {
                break label184;
              }
            }
            if (localMessageRecord1.uniseq == paramMessageRecord.uniseq) {
              break label184;
            }
            i += 1;
          }
          bool1 = false;
          label184:
          if (bool1)
          {
            if ((localArrayList.get(i) instanceof MessageForReplyText)) {
              ((MessageForReplyText)localArrayList.get(i)).setSourceMessageRecord(paramMessageRecord);
            } else {
              localArrayList.set(i, paramMessageRecord);
            }
            return bool1;
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean a(List<MessageRecord> paramList, ProxyListener paramProxyListener)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramProxyListener = (MessageRecord)paramList.next();
      if (paramProxyListener.getStatus() == 1000) {
        this.proxyManager.addMsgQueueDonotNotify(paramProxyListener.frienduin, paramProxyListener.istroop, paramProxyListener.getTableName(), paramProxyListener, 3, null);
      } else {
        this.proxyManager.addMsgQueueDonotNotify(paramProxyListener.frienduin, paramProxyListener.istroop, paramProxyListener.getTableName(), paramProxyListener, 4, null);
      }
    }
    this.proxyManager.transSaveToDatabase();
    return true;
  }
  
  public byte[] a(ArrayList<MessageRecord> paramArrayList, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, new Object[] { "packPbToMultiMsg, start pack, startTime:", Long.valueOf(l1) });
    }
    Object localObject = null;
    msg_transmit.PbMultiMsgTransmit localPbMultiMsgTransmit = new msg_transmit.PbMultiMsgTransmit();
    int i = new Random(System.currentTimeMillis()).nextInt();
    Iterator localIterator = paramArrayList.iterator();
    paramArrayList = (ArrayList<MessageRecord>)localObject;
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      localObject = new msg_comm.Msg();
      msg_comm.MsgHead localMsgHead = a(localMessageRecord, paramHashMap, paramBoolean, i, false);
      im_msg_body.MsgBody localMsgBody = a(localMessageRecord, false);
      if ((localMsgHead != null) && (localMsgBody != null))
      {
        ((msg_comm.Msg)localObject).msg_head.set(localMsgHead);
        ((msg_comm.Msg)localObject).msg_body.set(localMsgBody);
        localPbMultiMsgTransmit.msg.add((MessageMicro)localObject);
      }
      else
      {
        localObject = paramArrayList;
        if (paramArrayList == null) {
          localObject = new StringBuilder("packPbFromMultiMsg error:msg_head or msg_body is null, uniseq:");
        }
        ((StringBuilder)localObject).append(localMessageRecord.uniseq);
        ((StringBuilder)localObject).append("|");
        paramArrayList = (ArrayList<MessageRecord>)localObject;
      }
      i += 1;
    }
    if ((paramArrayList != null) && (QLog.isColorLevel())) {
      QLog.d("MultiMsg_TAG", 2, paramArrayList.toString());
    }
    paramArrayList = a(localPbMultiMsgTransmit.toByteArray());
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      paramHashMap = new StringBuilder();
      paramHashMap.append("packPbToMultiMsg, end pack,endTime:");
      paramHashMap.append(l2);
      paramHashMap.append(" cost:");
      paramHashMap.append(l2 - l1);
      QLog.d("MultiMsg_TAG", 2, paramHashMap.toString());
    }
    return paramArrayList;
  }
  
  public byte[] a(HashMap<String, ArrayList<MessageRecord>> paramHashMap, HashMap<String, String> paramHashMap1, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, new Object[] { "packPbFromMultiMsgWithNest, start pack, startTime:", Long.valueOf(l1) });
    }
    Object localObject1 = null;
    msg_transmit.PbMultiMsgTransmit localPbMultiMsgTransmit = new msg_transmit.PbMultiMsgTransmit();
    int i = new Random(System.currentTimeMillis()).nextInt();
    Iterator localIterator = paramHashMap.keySet().iterator();
    Object localObject2;
    Object localObject3;
    Object localObject4;
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      Object localObject5 = (ArrayList)paramHashMap.get(localObject2);
      localObject3 = new msg_transmit.PbMultiMsgItem();
      localObject4 = new msg_transmit.PbMultiMsgNew();
      localObject5 = ((ArrayList)localObject5).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject5).next();
        msg_comm.Msg localMsg = new msg_comm.Msg();
        msg_comm.MsgHead localMsgHead = a(localMessageRecord, paramHashMap1, paramBoolean, i, false);
        im_msg_body.MsgBody localMsgBody = a(localMessageRecord, false);
        if ((localMsgHead != null) && (localMsgBody != null))
        {
          localMsg.msg_head.set(localMsgHead);
          localMsg.msg_body.set(localMsgBody);
          ((msg_transmit.PbMultiMsgNew)localObject4).msg.add(localMsg);
        }
        else
        {
          if (localObject1 == null) {
            localObject1 = new StringBuilder("packPbFromMultiMsgWithNest error:msg_head or msg_body is null, uniseq:");
          }
          ((StringBuilder)localObject1).append(localMessageRecord.uniseq);
          ((StringBuilder)localObject1).append("|");
        }
        i += 1;
      }
      ((msg_transmit.PbMultiMsgItem)localObject3).fileName.set((String)localObject2);
      ((msg_transmit.PbMultiMsgItem)localObject3).buffer.set(ByteStringMicro.copyFrom(((msg_transmit.PbMultiMsgNew)localObject4).toByteArray()));
      localPbMultiMsgTransmit.pbItemList.add((MessageMicro)localObject3);
    }
    if ((localObject1 != null) && (QLog.isColorLevel())) {
      QLog.d("MultiMsg_TAG", 2, ((StringBuilder)localObject1).toString());
    }
    paramHashMap = (ArrayList)paramHashMap.get("MultiMsg");
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      localObject2 = paramHashMap.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (MessageRecord)((Iterator)localObject2).next();
        paramHashMap = (HashMap<String, ArrayList<MessageRecord>>)localObject1;
        if (MultiMsgUtil.a((ChatMessage)localObject1)) {
          paramHashMap = a((MessageRecord)localObject1, MultiMsgConstant.b, false);
        }
        localObject1 = new msg_comm.Msg();
        localObject3 = a(paramHashMap, paramHashMap1, paramBoolean, i, true);
        localObject4 = a(paramHashMap, true);
        if ((localObject3 != null) && (localObject4 != null))
        {
          ((msg_comm.Msg)localObject1).msg_head.set((MessageMicro)localObject3);
          ((msg_comm.Msg)localObject1).msg_body.set((MessageMicro)localObject4);
          localPbMultiMsgTransmit.msg.add((MessageMicro)localObject1);
        }
        else if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("packPbFromMultiMsg error:msg_head or msg_body is null, uniseq:");
          ((StringBuilder)localObject1).append(paramHashMap.uniseq);
          QLog.d("MultiMsg_TAG", 2, ((StringBuilder)localObject1).toString());
          new StringBuilder();
        }
        i += 1;
      }
    }
    paramHashMap = a(localPbMultiMsgTransmit.toByteArray());
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      paramHashMap1 = new StringBuilder();
      paramHashMap1.append("packPbFromMultiMsgWithNest, end pack,endTime:");
      paramHashMap1.append(l2);
      paramHashMap1.append(" cost:");
      paramHashMap1.append(l2 - l1);
      QLog.d("MultiMsg_TAG", 2, paramHashMap1.toString());
    }
    return paramHashMap;
  }
  
  public MessageRecord b(long paramLong)
  {
    List localList = b().rawQuery(MessageRecord.class, "select * from mr_multimessage where uniseq=?", new String[] { String.valueOf(paramLong) });
    if ((localList != null) && (localList.size() >= 1))
    {
      ((MessageRecord)localList.get(0)).isMultiMsg = true;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("queryOneMsgFromMultiMsg,list.get(0).uniseq:");
        localStringBuilder.append(((MessageRecord)localList.get(0)).uniseq);
        localStringBuilder.append(" msgseq:");
        localStringBuilder.append(((MessageRecord)localList.get(0)).msgseq);
        QLog.d("MultiMsg_TAG", 2, localStringBuilder.toString());
      }
      return (MessageRecord)localList.get(0);
    }
    return null;
  }
  
  public HashMap<String, ArrayList<MessageRecord>> b(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap, MessageRecord paramMessageRecord, MessageInfo paramMessageInfo)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("unpackPbToMultiMsgWithNest, start unpack, startTime:");
      ((StringBuilder)localObject1).append(l1);
      QLog.d("MultiMsg_TAG", 2, ((StringBuilder)localObject1).toString());
    }
    paramArrayOfByte = b(paramArrayOfByte);
    Object localObject1 = new msg_transmit.PbMultiMsgTransmit();
    try
    {
      localObject1 = (msg_transmit.PbMultiMsgTransmit)((msg_transmit.PbMultiMsgTransmit)localObject1).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = new HashMap();
      Object localObject2;
      int i;
      Object localObject3;
      if (!((msg_transmit.PbMultiMsgTransmit)localObject1).pbItemList.has())
      {
        localObject2 = new ArrayList();
        if (((msg_transmit.PbMultiMsgTransmit)localObject1).msg.has())
        {
          i = 0;
          while (i < ((msg_transmit.PbMultiMsgTransmit)localObject1).msg.size())
          {
            localObject3 = a((msg_comm.Msg)((msg_transmit.PbMultiMsgTransmit)localObject1).msg.get(i), paramHashMap, paramMessageRecord, paramMessageInfo);
            if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
            {
              ((ArrayList)localObject2).addAll((Collection)localObject3);
              if (QLog.isColorLevel()) {
                QLog.d("MultiMsg_TAG", 2, String.format("unpackPbToMultiMsgWithNest for old version, msgsize:%d, msgtype:%d", new Object[] { Integer.valueOf(((ArrayList)localObject3).size()), Integer.valueOf(((MessageRecord)((ArrayList)localObject3).get(0)).msgtype) }));
              }
            }
            i += 1;
          }
        }
        if (((ArrayList)localObject2).size() > 0) {
          paramArrayOfByte.put("MultiMsg", localObject2);
        }
      }
      else
      {
        i = 0;
        for (;;)
        {
          int j = 0;
          if (i >= ((msg_transmit.PbMultiMsgTransmit)localObject1).pbItemList.size()) {
            break;
          }
          Object localObject4 = (msg_transmit.PbMultiMsgItem)((msg_transmit.PbMultiMsgTransmit)localObject1).pbItemList.get(i);
          localObject2 = ((msg_transmit.PbMultiMsgItem)localObject4).fileName.get();
          localObject3 = new msg_transmit.PbMultiMsgNew();
          try
          {
            ((msg_transmit.PbMultiMsgNew)localObject3).mergeFrom(((msg_transmit.PbMultiMsgItem)localObject4).buffer.get().toByteArray());
            localObject4 = new ArrayList();
            while (j < ((msg_transmit.PbMultiMsgNew)localObject3).msg.size())
            {
              ArrayList localArrayList = a((msg_comm.Msg)((msg_transmit.PbMultiMsgNew)localObject3).msg.get(j), paramHashMap, paramMessageRecord, paramMessageInfo);
              if ((localArrayList != null) && (localArrayList.size() > 0)) {
                ((ArrayList)localObject4).addAll(localArrayList);
              }
              j += 1;
            }
            paramArrayOfByte.put(localObject2, localObject4);
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
          {
            if (QLog.isColorLevel()) {
              QLog.d("MultiMsg_TAG", 2, "unpackPbToMultiMsgWithNest, error: exception occurs while parsing PbMultiMsgNew", localInvalidProtocolBufferMicroException);
            }
          }
          i += 1;
        }
      }
      if (!a(paramMessageRecord, paramArrayOfByte, null)) {
        return null;
      }
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        paramHashMap = new StringBuilder();
        paramHashMap.append("unpackPbToMultiMsgWithNest, end unpack,endTime:");
        paramHashMap.append(l2);
        paramHashMap.append(" cost:");
        paramHashMap.append(l2 - l1);
        QLog.d("MultiMsg_TAG", 2, paramHashMap.toString());
      }
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "unpackPbToMultiMsgWithNest, error: exception occurs while parsing PbMultiMsgTransmit", paramArrayOfByte);
      }
    }
    return null;
  }
  
  protected void b(MessageRecord paramMessageRecord, List<MessageRecord> paramList, ProxyListener paramProxyListener)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord1 = (MessageRecord)paramList.next();
      if (paramMessageRecord.senderuin.equals(localMessageRecord1.senderuin))
      {
        localMessageRecord1.issend = 1;
        localMessageRecord1.selfuin = localMessageRecord1.senderuin;
      }
      if ((localMessageRecord1 instanceof MessageForPtt)) {
        localMessageRecord1.issend = paramMessageRecord.issend;
      }
      localMessageRecord1.msgseq = paramMessageRecord.uniseq;
      localMessageRecord1.isMultiMsg = true;
      Object localObject;
      if (localMessageRecord1.msgtype == -1035)
      {
        localObject = ((MessageForMixedMsg)localMessageRecord1).msgElemList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord2 = (MessageRecord)((Iterator)localObject).next();
          localMessageRecord2.msgseq = localMessageRecord1.msgseq;
          localMessageRecord2.isMultiMsg = true;
        }
      }
      if (QLog.isColorLevel())
      {
        localMessageRecord1.toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("addMultiMsgSingle, time:");
        ((StringBuilder)localObject).append(localMessageRecord1.time);
        ((StringBuilder)localObject).append(" senderuin:");
        ((StringBuilder)localObject).append(localMessageRecord1.senderuin);
        ((StringBuilder)localObject).append(" istroop:");
        ((StringBuilder)localObject).append(localMessageRecord1.istroop);
        ((StringBuilder)localObject).append(" shmsgseq:");
        ((StringBuilder)localObject).append(localMessageRecord1.shmsgseq);
        ((StringBuilder)localObject).append(" msgseq:");
        ((StringBuilder)localObject).append(localMessageRecord1.msgseq);
        ((StringBuilder)localObject).append(" msgData:");
        ((StringBuilder)localObject).append(localMessageRecord1.msgData);
        QLog.d("MultiMsg_TAG", 2, ((StringBuilder)localObject).toString());
      }
      this.proxyManager.addMsgQueueDonotNotify(localMessageRecord1.frienduin, localMessageRecord1.istroop, localMessageRecord1.getTableName(), localMessageRecord1, 0, paramProxyListener);
    }
  }
  
  public byte[] b(MessageRecord paramMessageRecord)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("packPbFromLongTextMsg, start pack, startTime:");
      ((StringBuilder)localObject1).append(l1);
      QLog.d("MultiMsg_TAG", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new msg_transmit.PbMultiMsgTransmit();
    Object localObject2 = ((QQAppInterface)this.app).getCurrentNickname();
    Object localObject3 = new HashMap();
    ((HashMap)localObject3).put(paramMessageRecord.senderuin, localObject2);
    localObject2 = new msg_comm.Msg();
    localObject3 = a(paramMessageRecord, (HashMap)localObject3, true, 1, false);
    im_msg_body.MsgBody localMsgBody = a(paramMessageRecord, false);
    if ((localObject3 != null) && (localMsgBody != null))
    {
      ((msg_comm.Msg)localObject2).msg_head.set((MessageMicro)localObject3);
      ((msg_comm.Msg)localObject2).msg_body.set(localMsgBody);
      ((msg_transmit.PbMultiMsgTransmit)localObject1).msg.add((MessageMicro)localObject2);
    }
    else if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("packPbFromLongTextMsg, error:msg_head or msg_body is null,uniseq:");
      ((StringBuilder)localObject2).append(paramMessageRecord.uniseq);
      QLog.d("MultiMsg_TAG", 2, ((StringBuilder)localObject2).toString());
    }
    paramMessageRecord = a(((msg_transmit.PbMultiMsgTransmit)localObject1).toByteArray());
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("packPbFromLongTextMsg, end pack, endTime:");
      ((StringBuilder)localObject1).append(l2);
      ((StringBuilder)localObject1).append(" cost:");
      ((StringBuilder)localObject1).append(l2 - l1);
      QLog.d("MultiMsg_TAG", 2, ((StringBuilder)localObject1).toString());
    }
    return paramMessageRecord;
  }
  
  public HashMap<String, ArrayList<MessageRecord>> c(MessageRecord paramMessageRecord)
  {
    HashMap localHashMap = new HashMap();
    if ((paramMessageRecord != null) && (MessageForStructing.class.isInstance(paramMessageRecord)))
    {
      b((MessageForStructing)paramMessageRecord, localHashMap, 0);
      return localHashMap;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "queryMultiMsgWithNest error before of null msg or not structMsg type");
    }
    return localHashMap;
  }
  
  public void destroy()
  {
    MessageRecordEntityManager localMessageRecordEntityManager = this.a;
    if ((localMessageRecordEntityManager != null) && (localMessageRecordEntityManager.isOpen())) {
      this.a.close();
    }
  }
  
  public void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.MultiMsgProxy
 * JD-Core Version:    0.7.0.1
 */