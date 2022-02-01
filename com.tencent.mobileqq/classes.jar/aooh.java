import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForLightVideo;
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
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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

public class aooh
  extends aoxs
{
  private static final Class[] jdField_a_of_type_ArrayOfJavaLangClass = { MessageForText.class, MessageForPic.class, MessageForMixedMsg.class, MessageForLongMsg.class, MessageForShortVideo.class, MessageForReplyText.class, MessageForTroopFile.class, MessageForQQStoryComment.class, MessageForArkApp.class, MessageForArkFlashChat.class };
  azhs jdField_a_of_type_Azhs = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
  public aooh(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
  }
  
  private long a(@NonNull HashMap<String, String> paramHashMap, bffl parambffl, msg_comm.Msg paramMsg, msg_comm.MsgHead paramMsgHead, long paramLong1, long paramLong2, int paramInt, MessageHandler paramMessageHandler, ArrayList<MessageRecord> paramArrayList)
  {
    if ((bcsc.c(paramInt)) || (paramInt == 208)) {
      a(paramHashMap, parambffl, paramMsg, paramMsgHead, paramLong1, paramMessageHandler, paramArrayList);
    }
    do
    {
      return paramLong2;
      if ((paramInt == 82) || (paramInt == 43))
      {
        paramLong2 = paramMsgHead.group_info.group_code.get();
        c(paramHashMap, parambffl, paramMsg, paramMsgHead, paramLong1, paramMessageHandler, paramArrayList);
        return paramLong2;
      }
    } while ((paramInt != 83) && (paramInt != 42));
    paramLong2 = paramMsgHead.discuss_info.discuss_uin.get();
    b(paramHashMap, parambffl, paramMsg, paramMsgHead, paramLong1, paramMessageHandler, paramArrayList);
    return paramLong2;
  }
  
  private azhs a()
  {
    if ((this.jdField_a_of_type_Azhs == null) || (!this.jdField_a_of_type_Azhs.isOpen())) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_Azhs == null) || (!this.jdField_a_of_type_Azhs.isOpen())) {
        this.jdField_a_of_type_Azhs = ((azhs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createMessageRecordEntityManager());
      }
      return this.jdField_a_of_type_Azhs;
    }
  }
  
  private MessageRecord a(MessageRecord paramMessageRecord1, msg_comm.MsgHead paramMsgHead, ArrayList<MessageRecord> paramArrayList, int paramInt, MessageRecord paramMessageRecord2)
  {
    MessageRecord localMessageRecord = paramMessageRecord2;
    if (!bbbf.a(paramMessageRecord1))
    {
      localMessageRecord = paramMessageRecord2;
      if (!axiv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)paramMessageRecord2))
      {
        localMessageRecord = paramMessageRecord2;
        if (!(paramMessageRecord2 instanceof MessageForArkApp))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "not support multi forward msg! " + paramMessageRecord2.toString());
          }
          localMessageRecord = bcsa.a(-1000);
          localMessageRecord.msg = paramMsgHead.multi_compatible_text.get();
          paramArrayList.set(paramInt, localMessageRecord);
        }
      }
    }
    return localMessageRecord;
  }
  
  private String a(msg_comm.Msg paramMsg, HashMap<String, String> paramHashMap, bffl parambffl, msg_comm.MsgHead paramMsgHead, long paramLong, int paramInt, String paramString, MessageHandler paramMessageHandler, ArrayList<MessageRecord> paramArrayList, MessageRecord paramMessageRecord)
  {
    int i = paramMsgHead.c2c_cmd.get();
    if ((paramInt == 529) && (i == 4)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a(paramArrayList, ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get());
    }
    for (;;)
    {
      parambffl = paramString;
      if (paramMsgHead.from_nick.has())
      {
        parambffl = paramString;
        if (paramHashMap != null)
        {
          parambffl = paramMsgHead.from_nick.get();
          paramHashMap.put(String.valueOf(paramLong), paramMsgHead.from_nick.get());
        }
      }
      a(paramMessageRecord, paramMsg, paramMessageHandler, paramArrayList);
      return parambffl;
      if ((i == 175) || (i == 11)) {
        bcrx.a(paramMessageHandler, paramArrayList, paramMsg, true, false, parambffl);
      }
    }
  }
  
  private String a(msg_comm.Msg paramMsg, HashMap<String, String> paramHashMap, MessageRecord paramMessageRecord, bffl parambffl, msg_comm.MsgHead paramMsgHead, long paramLong, String paramString, MessageHandler paramMessageHandler, ArrayList<MessageRecord> paramArrayList)
  {
    paramMsgHead.discuss_info.discuss_uin.get();
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().b(paramArrayList, paramMsg)) {
      bcrx.a(paramMessageHandler, paramArrayList, paramMsg, false, false, parambffl);
    }
    parambffl = paramString;
    if (paramMsgHead.discuss_info.discuss_remark.has())
    {
      parambffl = paramString;
      if (paramHashMap != null)
      {
        paramMsgHead = paramMsgHead.discuss_info.discuss_remark.get().toStringUtf8();
        parambffl = paramMsgHead;
        if (!TextUtils.isEmpty(paramMsgHead))
        {
          paramHashMap.put(String.valueOf(paramLong), paramMsgHead);
          parambffl = paramMsgHead;
        }
      }
    }
    a(paramMessageRecord, paramMsg, paramMessageHandler, paramArrayList);
    return parambffl;
  }
  
  private String a(msg_comm.Msg paramMsg, HashMap<String, String> paramHashMap, MessageRecord paramMessageRecord, msg_comm.MsgHead paramMsgHead, long paramLong, String paramString, MessageHandler paramMessageHandler, ArrayList<MessageRecord> paramArrayList, bffl parambffl)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a(paramArrayList, paramMsg)) {
      bcrx.a(paramMessageHandler, paramArrayList, paramMsg, false, false, parambffl);
    }
    parambffl = paramString;
    if (paramMsgHead.group_info.group_card.has())
    {
      parambffl = paramString;
      if (paramHashMap != null)
      {
        paramMsgHead = paramMsgHead.group_info.group_card.get().toStringUtf8();
        parambffl = paramMsgHead;
        if (!TextUtils.isEmpty(paramMsgHead))
        {
          paramHashMap.put(String.valueOf(paramLong), paramMsgHead);
          parambffl = paramMsgHead;
        }
      }
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
            paramHashMap = (im_msg_body.Elem)paramMsg.next();
            if (paramHashMap.anon_group_msg.has())
            {
              paramHashMap = (im_msg_body.AnonymousGroupMsg)paramHashMap.anon_group_msg.get();
              int i = paramHashMap.uint32_flags.get();
              paramMsg = paramHashMap.str_anon_id.get().toByteArray();
              paramMessageRecord = paramHashMap.str_anon_nick.get().toByteArray();
              int j = paramHashMap.uint32_head_portrait.get();
              int k = paramHashMap.uint32_expire_time.get();
              paramMsgHead = paramHashMap.str_rank_color.get().toStringUtf8();
              if (paramMsg != null) {}
              for (;;)
              {
                try
                {
                  paramMsg = new String(paramMsg, "ISO-8859-1");
                  paramString = paramArrayList.iterator();
                  if (!paramString.hasNext()) {
                    break;
                  }
                  paramMessageHandler = (MessageRecord)paramString.next();
                  if (paramMessageRecord != null) {
                    break label374;
                  }
                  paramHashMap = "";
                  paramMessageHandler.saveExtInfoToExtStr("anonymous", nty.a(i, paramMsg, paramHashMap, j, k, paramMsgHead));
                  paramMessageHandler.extLong |= 0x3;
                  continue;
                  paramMsg = "";
                }
                catch (UnsupportedEncodingException paramMsg)
                {
                  paramMsg.printStackTrace();
                }
                continue;
                label374:
                paramHashMap = new String(paramMessageRecord);
              }
              if (QLog.isColorLevel()) {
                QLog.d("anonymous_decode", 2, "anonymous_flags has = " + i);
              }
            }
          }
        }
      }
    }
    return parambffl;
  }
  
  @Nullable
  private im_msg_body.RichText a(MessageForStructing paramMessageForStructing)
  {
    im_msg_body.RichText localRichText = bcrx.a(paramMessageForStructing);
    try
    {
      if ((paramMessageForStructing.structingMsg != null) && ((paramMessageForStructing.structingMsg instanceof StructMsgForImageShare)))
      {
        paramMessageForStructing = ((StructMsgForImageShare)paramMessageForStructing.structingMsg).getFirstImageElement();
        if (paramMessageForStructing != null)
        {
          paramMessageForStructing = paramMessageForStructing.a.richText;
          localRichText.elems.add(paramMessageForStructing.elems.get(0));
        }
      }
    }
    catch (Exception paramMessageForStructing)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MultiMsg_TAG", 2, " packMultiMsg.structMsg.exception...");
    }
    return localRichText;
    return localRichText;
  }
  
  private im_msg_body.RichText a(MessageRecord paramMessageRecord)
  {
    String str = anvx.a(2131706484);
    if ((paramMessageRecord instanceof MessageForTroopFile)) {
      str = ((MessageForTroopFile)paramMessageRecord).getSummaryMsg();
    }
    return bcrx.a((MessageForText)a(paramMessageRecord, str, false));
  }
  
  private void a(MessageForStructing paramMessageForStructing, HashMap<String, ArrayList<MessageRecord>> paramHashMap, int paramInt)
  {
    if (paramInt > 3) {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "recursionAddMultiMsg return before of max recurTime");
      }
    }
    label276:
    for (;;)
    {
      return;
      if ((paramMessageForStructing == null) || (paramMessageForStructing.structingMsg == null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "recursionAddMultiMsg return before of null structmsg");
        }
      }
      else
      {
        String str = a(paramInt, paramMessageForStructing);
        ArrayList localArrayList;
        if (paramHashMap.containsKey(str))
        {
          localArrayList = (ArrayList)paramHashMap.get(str);
          localObject = localArrayList;
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, String.format("recursionAddMultiMsg find list size:%d, filename:%s", new Object[] { Integer.valueOf(localArrayList.size()), str }));
          }
        }
        for (Object localObject = localArrayList;; localObject = null)
        {
          if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
            break label276;
          }
          a(paramMessageForStructing, (List)localObject, null);
          paramInt += 1;
          paramMessageForStructing = ((ArrayList)localObject).iterator();
          while (paramMessageForStructing.hasNext())
          {
            localObject = (MessageRecord)paramMessageForStructing.next();
            if (axiv.a((ChatMessage)localObject))
            {
              if (QLog.isColorLevel()) {
                QLog.d("MultiMsg_TAG", 2, String.format("recursionAddMultiMsg need recur, uniseq:%d, recurTimes:%d", new Object[] { Long.valueOf(((MessageRecord)localObject).uniseq), Integer.valueOf(paramInt) }));
              }
              a((MessageForStructing)localObject, paramHashMap, paramInt);
            }
          }
          break;
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, String.format("recursionAddMultiMsg error filename:%s not found, recurTimes=%d", new Object[] { str, Integer.valueOf(paramInt) }));
          }
        }
      }
    }
  }
  
  private void a(MessageForStructing paramMessageForStructing, HashMap<String, ArrayList<MessageRecord>> paramHashMap1, HashMap<String, ArrayList<MessageRecord>> paramHashMap2, int paramInt, ProxyListener paramProxyListener, boolean paramBoolean1, boolean paramBoolean2, ArrayList<MessageRecord> paramArrayList)
  {
    if (paramInt > 3) {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "recursivePreAddMultiMsg return before of max recurTime");
      }
    }
    label389:
    label390:
    for (;;)
    {
      return;
      if ((paramMessageForStructing == null) || (paramMessageForStructing.structingMsg == null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "recursivePreAddMultiMsg return before of null structmsg");
        }
      }
      else
      {
        String str1 = a(paramInt, paramMessageForStructing);
        Object localObject;
        int i;
        if (paramHashMap1.containsKey(str1))
        {
          localObject = (ArrayList)paramHashMap1.get(str1);
          if (!QLog.isColorLevel()) {
            break label389;
          }
          if (localObject != null)
          {
            i = ((ArrayList)localObject).size();
            QLog.d("MultiMsg_TAG", 2, String.format("recursivePreAddMultiMsg find list size:%d, filename:%s", new Object[] { Integer.valueOf(i), str1 }));
          }
        }
        for (;;)
        {
          label125:
          if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
            break label390;
          }
          paramMessageForStructing = a(paramMessageForStructing, (ArrayList)localObject, paramProxyListener, paramBoolean1, paramBoolean2, paramArrayList);
          if (paramMessageForStructing == null) {
            break;
          }
          localObject = paramMessageForStructing.iterator();
          for (;;)
          {
            if (((Iterator)localObject).hasNext())
            {
              MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
              if (axiv.a((ChatMessage)localMessageRecord))
              {
                MessageForStructing localMessageForStructing = (MessageForStructing)localMessageRecord;
                String str2 = localMessageForStructing.structingMsg.mFileName;
                String str3 = String.valueOf(localMessageForStructing.uniseq);
                localMessageForStructing.structingMsg.mFileName = str3;
                a(localMessageRecord, null);
                paramHashMap1.put(str3, (ArrayList)paramHashMap1.remove(str2));
                continue;
                i = 0;
                break;
                if (QLog.isColorLevel()) {
                  QLog.d("MultiMsg_TAG", 2, String.format("recursivePreAddMultiMsg error filename:%s not found, recurTimes=%d", new Object[] { str1, Integer.valueOf(paramInt) }));
                }
                localObject = null;
                break label125;
              }
            }
          }
          paramHashMap2.put(str1, paramMessageForStructing);
          if ((paramMessageForStructing == null) || (paramMessageForStructing.size() <= 0)) {
            break;
          }
          paramMessageForStructing = paramMessageForStructing.iterator();
          while (paramMessageForStructing.hasNext())
          {
            localObject = (MessageRecord)paramMessageForStructing.next();
            if (axiv.a((ChatMessage)localObject)) {
              a((MessageForStructing)localObject, paramHashMap1, paramHashMap2, paramInt + 1, paramProxyListener, paramBoolean1, paramBoolean2, paramArrayList);
            }
          }
          break;
        }
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord, msg_comm.Msg paramMsg, MessageHandler paramMessageHandler, ArrayList<MessageRecord> paramArrayList)
  {
    if (((paramMessageRecord instanceof MessageForStructing)) && (((MessageForStructing)paramMessageRecord).structingMsg != null) && (((MessageForStructing)paramMessageRecord).structingMsg.mMsgServiceID == 107))
    {
      if ((paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 3000)) {
        new bcsm().a(paramMessageHandler, paramMsg, paramArrayList, null);
      }
    }
    else {
      return;
    }
    new bcsr().a(paramMessageHandler, paramMsg, paramArrayList, null);
  }
  
  private void a(MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText)
  {
    if (nty.a(paramMessageRecord))
    {
      im_msg_body.Elem localElem = new im_msg_body.Elem();
      im_msg_body.AnonymousGroupMsg localAnonymousGroupMsg = new im_msg_body.AnonymousGroupMsg();
      ntz localntz = nty.a(paramMessageRecord);
      localAnonymousGroupMsg.uint32_flags.set(localntz.jdField_a_of_type_Int);
      if (!TextUtils.isEmpty(localntz.jdField_a_of_type_JavaLangString)) {
        localAnonymousGroupMsg.str_anon_id.set(ByteStringMicro.copyFrom(localntz.jdField_a_of_type_JavaLangString.getBytes()));
      }
      if (!TextUtils.isEmpty(localntz.jdField_b_of_type_JavaLangString)) {
        localAnonymousGroupMsg.str_anon_nick.set(ByteStringMicro.copyFrom(localntz.jdField_b_of_type_JavaLangString.getBytes()));
      }
      localAnonymousGroupMsg.uint32_head_portrait.set(localntz.jdField_b_of_type_Int);
      localAnonymousGroupMsg.uint32_expire_time.set(localntz.jdField_c_of_type_Int);
      if (!TextUtils.isEmpty(localntz.jdField_c_of_type_JavaLangString)) {
        localAnonymousGroupMsg.str_rank_color.set(ByteStringMicro.copyFrom(localntz.jdField_c_of_type_JavaLangString.getBytes()));
      }
      localAnonymousGroupMsg.uint32_bubble_id.set((int)paramMessageRecord.vipBubbleID);
      localElem.anon_group_msg.set(localAnonymousGroupMsg);
      if (QLog.isColorLevel()) {
        QLog.d("anonymous_decode", 2, "anonymous_addd anon_group_msg = ");
      }
      paramRichText.elems.add(localElem);
    }
  }
  
  private void a(@NonNull HashMap<String, String> paramHashMap, bffl parambffl, msg_comm.Msg paramMsg, msg_comm.MsgHead paramMsgHead, long paramLong, MessageHandler paramMessageHandler, ArrayList<MessageRecord> paramArrayList)
  {
    int i = paramMsgHead.c2c_cmd.get();
    if ((i == 175) || (i == 11))
    {
      if (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has()) {
        break label105;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a(paramArrayList, ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get());
    }
    for (;;)
    {
      if (paramMsgHead.from_nick.has()) {
        paramHashMap.put(String.valueOf(paramLong), paramMsgHead.from_nick.get());
      }
      return;
      label105:
      bcrx.a(paramMessageHandler, paramArrayList, paramMsg, true, false, parambffl);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if (MessageForTroopFile.class.isInstance(paramChatMessage)) {}
    do
    {
      return true;
      if (!MessageForFile.class.isInstance(paramChatMessage)) {
        break;
      }
    } while (!auea.a(paramQQAppInterface, (MessageForFile)paramChatMessage).sendCloudUnsuccessful());
    return false;
    return false;
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    return (MessageForMarketFace.class.isInstance(paramChatMessage)) || (MessageForPic.class.isInstance(paramChatMessage));
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if (nty.a(paramMessageRecord)) {
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
    if (MessageForLightVideo.class.isInstance(paramMessageRecord)) {
      return false;
    }
    Class[] arrayOfClass = jdField_a_of_type_ArrayOfJavaLangClass;
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
      return b(paramMessageRecord);
    }
    if ((paramMessageRecord instanceof MessageForArkBabyqReply))
    {
      paramMessageRecord = (MessageForArkBabyqReply)paramMessageRecord;
      return (paramMessageRecord.mArkBabyqReplyCardList != null) && (paramMessageRecord.mArkBabyqReplyCardList.size() > 0);
    }
    return false;
  }
  
  /* Error */
  public static byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +30 -> 33
    //   6: ldc 135
    //   8: iconst_2
    //   9: new 137	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 630
    //   19: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_0
    //   23: arraylength
    //   24: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: new 632	java/io/ByteArrayInputStream
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 633	java/io/ByteArrayInputStream:<init>	([B)V
    //   41: astore_3
    //   42: new 635	java/io/ByteArrayOutputStream
    //   45: dup
    //   46: invokespecial 636	java/io/ByteArrayOutputStream:<init>	()V
    //   49: astore 4
    //   51: sipush 1024
    //   54: newarray byte
    //   56: astore_0
    //   57: new 638	java/util/zip/GZIPOutputStream
    //   60: dup
    //   61: aload 4
    //   63: invokespecial 641	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   66: astore_2
    //   67: aload_3
    //   68: aload_0
    //   69: iconst_0
    //   70: sipush 1024
    //   73: invokevirtual 645	java/io/ByteArrayInputStream:read	([BII)I
    //   76: istore_1
    //   77: iload_1
    //   78: iconst_m1
    //   79: if_icmpeq +64 -> 143
    //   82: aload_2
    //   83: aload_0
    //   84: iconst_0
    //   85: iload_1
    //   86: invokevirtual 649	java/util/zip/GZIPOutputStream:write	([BII)V
    //   89: goto -22 -> 67
    //   92: astore_2
    //   93: aconst_null
    //   94: astore_0
    //   95: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   98: ifeq +32 -> 130
    //   101: ldc 135
    //   103: iconst_2
    //   104: new 137	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   111: ldc_w 651
    //   114: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload_2
    //   118: invokevirtual 654	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   121: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: aload 4
    //   132: invokevirtual 657	java/io/ByteArrayOutputStream:close	()V
    //   135: aload_3
    //   136: invokevirtual 658	java/io/ByteArrayInputStream:close	()V
    //   139: aload_0
    //   140: astore_2
    //   141: aload_2
    //   142: areturn
    //   143: aload_2
    //   144: invokevirtual 661	java/util/zip/GZIPOutputStream:flush	()V
    //   147: aload_2
    //   148: invokevirtual 662	java/util/zip/GZIPOutputStream:close	()V
    //   151: aload 4
    //   153: invokevirtual 663	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   156: astore_0
    //   157: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq +30 -> 190
    //   163: ldc 135
    //   165: iconst_2
    //   166: new 137	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   173: ldc_w 665
    //   176: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload_0
    //   180: arraylength
    //   181: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   184: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: aload 4
    //   192: invokevirtual 657	java/io/ByteArrayOutputStream:close	()V
    //   195: aload_3
    //   196: invokevirtual 658	java/io/ByteArrayInputStream:close	()V
    //   199: aload_0
    //   200: areturn
    //   201: astore_3
    //   202: aload_0
    //   203: astore_2
    //   204: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   207: ifeq -66 -> 141
    //   210: ldc 135
    //   212: iconst_2
    //   213: new 137	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   220: ldc_w 667
    //   223: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload_3
    //   227: invokevirtual 668	java/io/IOException:getMessage	()Ljava/lang/String;
    //   230: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   239: aload_0
    //   240: areturn
    //   241: astore_3
    //   242: aload_0
    //   243: astore_2
    //   244: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   247: ifeq -106 -> 141
    //   250: ldc 135
    //   252: iconst_2
    //   253: new 137	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   260: ldc_w 667
    //   263: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload_3
    //   267: invokevirtual 668	java/io/IOException:getMessage	()Ljava/lang/String;
    //   270: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   279: aload_0
    //   280: areturn
    //   281: astore_2
    //   282: aconst_null
    //   283: astore_0
    //   284: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   287: ifeq +32 -> 319
    //   290: ldc 135
    //   292: iconst_2
    //   293: new 137	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   300: ldc_w 670
    //   303: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload_2
    //   307: invokevirtual 671	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   310: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: aload 4
    //   321: invokevirtual 657	java/io/ByteArrayOutputStream:close	()V
    //   324: aload_3
    //   325: invokevirtual 658	java/io/ByteArrayInputStream:close	()V
    //   328: aload_0
    //   329: areturn
    //   330: astore_3
    //   331: aload_0
    //   332: astore_2
    //   333: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   336: ifeq -195 -> 141
    //   339: ldc 135
    //   341: iconst_2
    //   342: new 137	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   349: ldc_w 667
    //   352: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload_3
    //   356: invokevirtual 668	java/io/IOException:getMessage	()Ljava/lang/String;
    //   359: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   368: aload_0
    //   369: areturn
    //   370: astore_0
    //   371: aload 4
    //   373: invokevirtual 657	java/io/ByteArrayOutputStream:close	()V
    //   376: aload_3
    //   377: invokevirtual 658	java/io/ByteArrayInputStream:close	()V
    //   380: aload_0
    //   381: athrow
    //   382: astore_2
    //   383: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   386: ifeq -6 -> 380
    //   389: ldc 135
    //   391: iconst_2
    //   392: new 137	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   399: ldc_w 667
    //   402: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: aload_2
    //   406: invokevirtual 668	java/io/IOException:getMessage	()Ljava/lang/String;
    //   409: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: goto -38 -> 380
    //   421: astore_2
    //   422: goto -138 -> 284
    //   425: astore_2
    //   426: goto -331 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	429	0	paramArrayOfByte	byte[]
    //   76	10	1	i	int
    //   66	17	2	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    //   92	26	2	localException1	Exception
    //   140	104	2	arrayOfByte1	byte[]
    //   281	26	2	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   332	1	2	arrayOfByte2	byte[]
    //   382	24	2	localIOException1	java.io.IOException
    //   421	1	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   425	1	2	localException2	Exception
    //   41	155	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   201	26	3	localIOException2	java.io.IOException
    //   241	84	3	localIOException3	java.io.IOException
    //   330	47	3	localIOException4	java.io.IOException
    //   49	323	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   51	67	92	java/lang/Exception
    //   67	77	92	java/lang/Exception
    //   82	89	92	java/lang/Exception
    //   143	157	92	java/lang/Exception
    //   190	199	201	java/io/IOException
    //   130	139	241	java/io/IOException
    //   51	67	281	java/lang/OutOfMemoryError
    //   67	77	281	java/lang/OutOfMemoryError
    //   82	89	281	java/lang/OutOfMemoryError
    //   143	157	281	java/lang/OutOfMemoryError
    //   319	328	330	java/io/IOException
    //   51	67	370	finally
    //   67	77	370	finally
    //   82	89	370	finally
    //   95	130	370	finally
    //   143	157	370	finally
    //   157	190	370	finally
    //   284	319	370	finally
    //   371	380	382	java/io/IOException
    //   157	190	421	java/lang/OutOfMemoryError
    //   157	190	425	java/lang/Exception
  }
  
  private im_msg_body.RichText b(MessageRecord paramMessageRecord)
  {
    String str = anvx.a(2131706486);
    if ((paramMessageRecord instanceof MessageForFile)) {
      str = ((MessageForFile)paramMessageRecord).getSummaryMsg();
    }
    return bcrx.a((MessageForText)a(paramMessageRecord, str, false));
  }
  
  private void b(MessageForStructing paramMessageForStructing, HashMap<String, ArrayList<MessageRecord>> paramHashMap, int paramInt)
  {
    if (paramInt > 1) {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "recursiveQueryMultiMsg return before of max recurTime");
      }
    }
    ArrayList localArrayList;
    do
    {
      do
      {
        return;
        if (paramMessageForStructing != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("MultiMsg_TAG", 2, "recursiveQueryMultiMsg return before of null structmsg");
      return;
      localArrayList = a(paramMessageForStructing.uniseq);
    } while ((localArrayList == null) || (localArrayList.size() <= 0));
    paramHashMap.put(a(paramInt, paramMessageForStructing), localArrayList);
    paramInt += 1;
    paramMessageForStructing = localArrayList.iterator();
    label87:
    label226:
    for (;;)
    {
      MessageRecord localMessageRecord1;
      if (paramMessageForStructing.hasNext())
      {
        localMessageRecord1 = (MessageRecord)paramMessageForStructing.next();
        if (!axiv.a((ChatMessage)localMessageRecord1)) {
          continue;
        }
        if (paramInt != 2) {
          break label214;
        }
        MessageRecord localMessageRecord2 = a(localMessageRecord1, axim.jdField_a_of_type_JavaLangString, false);
        localMessageRecord2.setStatus(1000);
        localMessageRecord2.msgData = localMessageRecord2.msg.getBytes();
        localArrayList.set(localArrayList.indexOf(localMessageRecord1), localMessageRecord2);
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label226;
        }
        QLog.d("MultiMsg_TAG", 2, String.format("recursiveQueryMultiMsg need recur, uniseq:%d, recurTimes:%d", new Object[] { Long.valueOf(localMessageRecord1.uniseq), Integer.valueOf(paramInt) }));
        break label87;
        break;
        b((MessageForStructing)localMessageRecord1, paramHashMap, paramInt);
      }
    }
  }
  
  private void b(@NonNull HashMap<String, String> paramHashMap, bffl parambffl, msg_comm.Msg paramMsg, msg_comm.MsgHead paramMsgHead, long paramLong, MessageHandler paramMessageHandler, ArrayList<MessageRecord> paramArrayList)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().b(paramArrayList, paramMsg)) {
      bcrx.a(paramMessageHandler, paramArrayList, paramMsg, false, false, parambffl);
    }
    if (paramMsgHead.discuss_info.discuss_remark.has()) {
      paramHashMap.put(String.valueOf(paramLong), paramMsgHead.discuss_info.discuss_remark.get().toStringUtf8());
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if (MessageForTroopFile.class.isInstance(paramChatMessage)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return true;
            if (!MessageForFile.class.isInstance(paramChatMessage)) {
              break;
            }
          } while (!auea.a(paramQQAppInterface, (MessageForFile)paramChatMessage).sendCloudUnsuccessful());
          return false;
        } while (MessageForPic.class.isInstance(paramChatMessage));
        if (!MessageForShortVideo.class.isInstance(paramChatMessage)) {
          break;
        }
      } while (((MessageForShortVideo)paramChatMessage).checkForward());
      return false;
    } while (b(paramChatMessage));
    return false;
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
  
  private static boolean b(MessageRecord paramMessageRecord)
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
  
  /* Error */
  public static byte[] b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +30 -> 33
    //   6: ldc 135
    //   8: iconst_2
    //   9: new 137	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 719
    //   19: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_0
    //   23: arraylength
    //   24: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aconst_null
    //   34: astore 5
    //   36: aconst_null
    //   37: astore 4
    //   39: new 632	java/io/ByteArrayInputStream
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 633	java/io/ByteArrayInputStream:<init>	([B)V
    //   47: astore 6
    //   49: new 635	java/io/ByteArrayOutputStream
    //   52: dup
    //   53: invokespecial 636	java/io/ByteArrayOutputStream:<init>	()V
    //   56: astore 7
    //   58: aload 4
    //   60: astore_2
    //   61: aload 5
    //   63: astore_3
    //   64: sipush 1024
    //   67: newarray byte
    //   69: astore 8
    //   71: aload 4
    //   73: astore_2
    //   74: aload 5
    //   76: astore_3
    //   77: new 721	java/util/zip/GZIPInputStream
    //   80: dup
    //   81: aload 6
    //   83: invokespecial 724	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   86: astore 9
    //   88: aload 4
    //   90: astore_2
    //   91: aload 5
    //   93: astore_3
    //   94: aload 9
    //   96: aload 8
    //   98: iconst_0
    //   99: sipush 1024
    //   102: invokevirtual 725	java/util/zip/GZIPInputStream:read	([BII)I
    //   105: istore_1
    //   106: iload_1
    //   107: iconst_m1
    //   108: if_icmpeq +73 -> 181
    //   111: aload 4
    //   113: astore_2
    //   114: aload 5
    //   116: astore_3
    //   117: aload 7
    //   119: aload 8
    //   121: iconst_0
    //   122: iload_1
    //   123: invokevirtual 726	java/io/ByteArrayOutputStream:write	([BII)V
    //   126: goto -38 -> 88
    //   129: astore_3
    //   130: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +32 -> 165
    //   136: ldc 135
    //   138: iconst_2
    //   139: new 137	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   146: ldc_w 728
    //   149: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_3
    //   153: invokevirtual 654	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   156: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: aload 7
    //   167: invokevirtual 657	java/io/ByteArrayOutputStream:close	()V
    //   170: aload 6
    //   172: invokevirtual 658	java/io/ByteArrayInputStream:close	()V
    //   175: aload_2
    //   176: ifnonnull +316 -> 492
    //   179: aload_0
    //   180: areturn
    //   181: aload 4
    //   183: astore_2
    //   184: aload 5
    //   186: astore_3
    //   187: aload 9
    //   189: invokevirtual 729	java/util/zip/GZIPInputStream:close	()V
    //   192: aload 4
    //   194: astore_2
    //   195: aload 5
    //   197: astore_3
    //   198: aload 7
    //   200: invokevirtual 663	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   203: astore 4
    //   205: aload 4
    //   207: astore_2
    //   208: aload 4
    //   210: astore_3
    //   211: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   214: ifeq +37 -> 251
    //   217: aload 4
    //   219: astore_2
    //   220: aload 4
    //   222: astore_3
    //   223: ldc 135
    //   225: iconst_2
    //   226: new 137	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   233: ldc_w 731
    //   236: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload 4
    //   241: arraylength
    //   242: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   245: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: aload 7
    //   253: invokevirtual 657	java/io/ByteArrayOutputStream:close	()V
    //   256: aload 6
    //   258: invokevirtual 658	java/io/ByteArrayInputStream:close	()V
    //   261: aload 4
    //   263: astore_2
    //   264: goto -89 -> 175
    //   267: astore_2
    //   268: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   271: ifeq +32 -> 303
    //   274: ldc 135
    //   276: iconst_2
    //   277: new 137	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   284: ldc_w 733
    //   287: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload_2
    //   291: invokevirtual 668	java/io/IOException:getMessage	()Ljava/lang/String;
    //   294: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   303: aload 4
    //   305: astore_2
    //   306: goto -131 -> 175
    //   309: astore_3
    //   310: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   313: ifeq +32 -> 345
    //   316: ldc 135
    //   318: iconst_2
    //   319: new 137	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   326: ldc_w 733
    //   329: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload_3
    //   333: invokevirtual 668	java/io/IOException:getMessage	()Ljava/lang/String;
    //   336: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   345: goto -170 -> 175
    //   348: astore_2
    //   349: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   352: ifeq +32 -> 384
    //   355: ldc 135
    //   357: iconst_2
    //   358: new 137	java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   365: ldc_w 728
    //   368: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: aload_2
    //   372: invokevirtual 671	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   375: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   384: aload 7
    //   386: invokevirtual 657	java/io/ByteArrayOutputStream:close	()V
    //   389: aload 6
    //   391: invokevirtual 658	java/io/ByteArrayInputStream:close	()V
    //   394: aload_3
    //   395: astore_2
    //   396: goto -221 -> 175
    //   399: astore_2
    //   400: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   403: ifeq +32 -> 435
    //   406: ldc 135
    //   408: iconst_2
    //   409: new 137	java/lang/StringBuilder
    //   412: dup
    //   413: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   416: ldc_w 733
    //   419: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: aload_2
    //   423: invokevirtual 668	java/io/IOException:getMessage	()Ljava/lang/String;
    //   426: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   432: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   435: aload_3
    //   436: astore_2
    //   437: goto -262 -> 175
    //   440: astore_0
    //   441: aload 7
    //   443: invokevirtual 657	java/io/ByteArrayOutputStream:close	()V
    //   446: aload 6
    //   448: invokevirtual 658	java/io/ByteArrayInputStream:close	()V
    //   451: aload_0
    //   452: athrow
    //   453: astore_2
    //   454: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   457: ifeq -6 -> 451
    //   460: ldc 135
    //   462: iconst_2
    //   463: new 137	java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   470: ldc_w 733
    //   473: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: aload_2
    //   477: invokevirtual 668	java/io/IOException:getMessage	()Ljava/lang/String;
    //   480: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   489: goto -38 -> 451
    //   492: aload_2
    //   493: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	494	0	paramArrayOfByte	byte[]
    //   105	18	1	i	int
    //   60	204	2	arrayOfByte1	byte[]
    //   267	24	2	localIOException1	java.io.IOException
    //   305	1	2	arrayOfByte2	byte[]
    //   348	24	2	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   395	1	2	localObject1	Object
    //   399	24	2	localIOException2	java.io.IOException
    //   436	1	2	localObject2	Object
    //   453	40	2	localIOException3	java.io.IOException
    //   63	54	3	localObject3	Object
    //   129	24	3	localException	Exception
    //   186	37	3	localObject4	Object
    //   309	127	3	localIOException4	java.io.IOException
    //   37	267	4	arrayOfByte3	byte[]
    //   34	162	5	localObject5	Object
    //   47	400	6	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   56	386	7	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   69	51	8	arrayOfByte4	byte[]
    //   86	102	9	localGZIPInputStream	java.util.zip.GZIPInputStream
    // Exception table:
    //   from	to	target	type
    //   64	71	129	java/lang/Exception
    //   77	88	129	java/lang/Exception
    //   94	106	129	java/lang/Exception
    //   117	126	129	java/lang/Exception
    //   187	192	129	java/lang/Exception
    //   198	205	129	java/lang/Exception
    //   211	217	129	java/lang/Exception
    //   223	251	129	java/lang/Exception
    //   251	261	267	java/io/IOException
    //   165	175	309	java/io/IOException
    //   64	71	348	java/lang/OutOfMemoryError
    //   77	88	348	java/lang/OutOfMemoryError
    //   94	106	348	java/lang/OutOfMemoryError
    //   117	126	348	java/lang/OutOfMemoryError
    //   187	192	348	java/lang/OutOfMemoryError
    //   198	205	348	java/lang/OutOfMemoryError
    //   211	217	348	java/lang/OutOfMemoryError
    //   223	251	348	java/lang/OutOfMemoryError
    //   384	394	399	java/io/IOException
    //   64	71	440	finally
    //   77	88	440	finally
    //   94	106	440	finally
    //   117	126	440	finally
    //   130	165	440	finally
    //   187	192	440	finally
    //   198	205	440	finally
    //   211	217	440	finally
    //   223	251	440	finally
    //   349	384	440	finally
    //   441	451	453	java/io/IOException
  }
  
  private im_msg_body.RichText c(MessageRecord paramMessageRecord)
  {
    if (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("sens_msg_source_msg_info"))) {
      return bcrx.a(paramMessageRecord);
    }
    return bcrx.a((MessageForText)paramMessageRecord);
  }
  
  private void c(@NonNull HashMap<String, String> paramHashMap, bffl parambffl, msg_comm.Msg paramMsg, msg_comm.MsgHead paramMsgHead, long paramLong, MessageHandler paramMessageHandler, ArrayList<MessageRecord> paramArrayList)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a(paramArrayList, paramMsg)) {
      bcrx.a(paramMessageHandler, paramArrayList, paramMsg, false, false, parambffl);
    }
    if (paramMsgHead.group_info.group_card.has()) {
      paramHashMap.put(String.valueOf(paramLong), paramMsgHead.group_info.group_card.get().toStringUtf8());
    }
  }
  
  protected MessageRecord a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "queryLastMsg,delNum:" + paramInt);
    }
    ArrayList localArrayList = (ArrayList)a().rawQuery(MessageRecord.class, "select * from mr_multimessage limit 1 offset ?", new String[] { String.valueOf(paramInt - 1) });
    if ((localArrayList == null) || (localArrayList.size() < 1)) {
      return null;
    }
    return (MessageRecord)localArrayList.get(0);
  }
  
  public MessageRecord a(long paramLong)
  {
    List localList = a().rawQuery(MessageRecord.class, "select * from mr_multimessage where uniseq=?", new String[] { String.valueOf(paramLong) });
    if ((localList == null) || (localList.size() < 1)) {
      return null;
    }
    ((MessageRecord)localList.get(0)).isMultiMsg = true;
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "queryOneMsgFromMultiMsg,list.get(0).uniseq:" + ((MessageRecord)localList.get(0)).uniseq + " msgseq:" + ((MessageRecord)localList.get(0)).msgseq);
    }
    return (MessageRecord)localList.get(0);
  }
  
  public MessageRecord a(MessageRecord paramMessageRecord, String paramString, boolean paramBoolean)
  {
    MessageRecord localMessageRecord = bcsa.a(-1000);
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
      a().update(localMessageRecord);
    }
    return localMessageRecord;
  }
  
  public String a(int paramInt, MessageForStructing paramMessageForStructing)
  {
    String str = "MultiMsg";
    if (paramInt > 0)
    {
      if ((paramMessageForStructing != null) && (paramMessageForStructing.structingMsg != null) && (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mFileName))) {
        str = paramMessageForStructing.structingMsg.mFileName;
      }
    }
    else {
      return str;
    }
    paramMessageForStructing = new StringBuilder();
    paramMessageForStructing.append("MultiMsg");
    paramMessageForStructing.append("_");
    paramMessageForStructing.append(paramInt);
    paramMessageForStructing = paramMessageForStructing.toString();
    QLog.d("MultiMsg_TAG", 1, "resid is null! " + paramMessageForStructing);
    return paramMessageForStructing;
  }
  
  public ArrayList<MessageRecord> a(long paramLong)
  {
    ArrayList localArrayList = (ArrayList)a().rawQuery(MessageRecord.class, "select * from mr_multimessage where msgseq=? order by _id asc", new String[] { String.valueOf(paramLong) });
    Object localObject1;
    if ((localArrayList == null) || (localArrayList.size() < 1)) {
      localObject1 = new ArrayList();
    }
    do
    {
      return localObject1;
      localObject1 = localArrayList.iterator();
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
      localObject1 = localArrayList;
    } while (!QLog.isColorLevel());
    QLog.d("MultiMsg_TAG", 2, "querySevalMsgFromMultiMsg,list.get(0).uniseq:" + ((MessageRecord)localArrayList.get(0)).uniseq + " msgseq:" + ((MessageRecord)localArrayList.get(0)).msgseq);
    return localArrayList;
  }
  
  public ArrayList<MessageRecord> a(MessageRecord paramMessageRecord, ArrayList<? extends MessageRecord> paramArrayList, ProxyListener paramProxyListener, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramMessageRecord = a(paramMessageRecord, paramArrayList, paramProxyListener, paramBoolean1, paramBoolean2, new ArrayList(0));
    if (paramBoolean1) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase();
    }
    return paramMessageRecord;
  }
  
  public ArrayList<MessageRecord> a(MessageRecord paramMessageRecord, ArrayList<? extends MessageRecord> paramArrayList, ProxyListener paramProxyListener, boolean paramBoolean1, boolean paramBoolean2, ArrayList<MessageRecord> paramArrayList1)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      Object localObject1;
      Object localObject2;
      if (paramBoolean2)
      {
        if (localMessageRecord.msgtype == -1037) {
          paramArrayList = ((MessageForLongMsg)localMessageRecord).rebuildLongMsg(true);
        }
        while (paramArrayList == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "preAddMultiMsg.mrTemp is null ,not normal...");
          }
          return null;
          if (localMessageRecord.msgtype == -1036)
          {
            paramArrayList = (MessageForMixedMsg)((MessageForLongMsg)localMessageRecord).rebuildLongMsg();
          }
          else if (localMessageRecord.msgtype == -1035)
          {
            paramArrayList = ((MessageForMixedMsg)localMessageRecord).rebuildMixedMsg();
            localObject1 = (MessageForMixedMsg)paramArrayList;
            if (((MessageForMixedMsg)localObject1).getReplyMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != null)
            {
              paramArrayList1.add(((MessageForMixedMsg)localObject1).getReplyMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
              localObject1 = ((MessageForMixedMsg)localMessageRecord).getReplyMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              localObject2 = ((MessageForMixedMsg)paramArrayList).getReplyMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              if ((localObject1 != null) && (localObject2 != null)) {
                aufd.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageForReplyText)localObject1).getSourceMessage(), ((MessageForReplyText)localObject2).getSourceMessage());
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
            ((MessageForReplyText)paramArrayList).deepCopySourceMsg((MessageForReplyText)localMessageRecord);
            ((MessageForReplyText)paramArrayList).isBarrageMsg = false;
            ((MessageForReplyText)paramArrayList).barrageTimeLocation = 0L;
            paramArrayList.removeExtInfoToExtStr("barrage_time_location");
            paramArrayList.removeExtInfoToExtStr("barrage_source_msg_type");
          }
          else
          {
            paramArrayList = (MessageRecord)localMessageRecord.deepCopyByReflect();
          }
        }
        if (!TextUtils.isEmpty(paramArrayList.getExtInfoFromExtStr("troop_at_info_list"))) {
          paramArrayList.removeExtInfoToExtStr("troop_at_info_list");
        }
        if (!TextUtils.isEmpty(paramArrayList.getExtInfoFromExtStr("disc_at_info_list"))) {
          paramArrayList.removeExtInfoToExtStr("disc_at_info_list");
        }
        paramArrayList.atInfoList = null;
        if ((nty.a(paramArrayList)) && (nty.b(paramArrayList))) {
          paramArrayList.senderuin = "80000000";
        }
        paramArrayList.extLong = localMessageRecord.extLong;
      }
      for (;;)
      {
        paramArrayList.createMessageUniseq();
        paramArrayList.msgseq = paramMessageRecord.uniseq;
        paramArrayList.isMultiMsg = true;
        paramArrayList.extraflag = 32770;
        if (paramArrayList.msgtype != -1035) {
          break;
        }
        localObject1 = ((MessageForMixedMsg)paramArrayList).msgElemList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MessageRecord)((Iterator)localObject1).next();
          ((MessageRecord)localObject2).msgseq = paramArrayList.msgseq;
          ((MessageRecord)localObject2).isMultiMsg = true;
        }
        paramArrayList = localMessageRecord;
      }
      aufd.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, paramArrayList);
      if (paramArrayList.msgtype == -1049)
      {
        localObject1 = (MessageForReplyText)localMessageRecord;
        localObject2 = (MessageForReplyText)paramArrayList;
        aufd.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageForReplyText)localObject1).getSourceMessage(), ((MessageForReplyText)localObject2).getSourceMessage());
      }
      if (paramArrayList.msgtype == -2022) {
        ((MessageForShortVideo)paramArrayList).redBagType = 0;
      }
      localArrayList.add(paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "preAddMultiMsg, MessageRecord:" + localMessageRecord.toString());
      }
      if (paramBoolean1) {
        if (paramArrayList.getStatus() == 1000) {
          this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.addMsgQueueDonotNotify(paramArrayList.frienduin, paramArrayList.istroop, paramArrayList.getTableName(), paramArrayList, 0, paramProxyListener);
        } else {
          a(paramArrayList, null);
        }
      }
    }
    return localArrayList;
  }
  
  public ArrayList<MessageRecord> a(msg_comm.Msg paramMsg, HashMap<String, String> paramHashMap, MessageRecord paramMessageRecord, bffl parambffl)
  {
    if ((!paramMsg.msg_body.has()) || ((!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has()) && (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "unpackPbToMultiMsgWithNest, no msg_body or rich_text, msg_body.has():" + paramMsg.msg_body.has());
      }
      return null;
    }
    msg_comm.MsgHead localMsgHead = (msg_comm.MsgHead)paramMsg.msg_head.get();
    long l2 = localMsgHead.from_uin.get();
    long l3 = localMsgHead.msg_seq.get();
    long l4 = localMsgHead.msg_time.get();
    long l5 = localMsgHead.msg_uid.get();
    int j = localMsgHead.msg_type.get();
    String str = String.valueOf(l2);
    MessageHandler localMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler();
    long l6 = bcrx.a(localMessageHandler, paramMsg, String.valueOf(l2), String.valueOf(l2));
    ArrayList localArrayList = new ArrayList();
    long l1;
    if (((bcsc.c(j)) || (j == 208) || (j == 529)) && (localMsgHead.c2c_cmd.has()))
    {
      paramHashMap = a(paramMsg, paramHashMap, parambffl, localMsgHead, l2, j, str, localMessageHandler, localArrayList, paramMessageRecord);
      l1 = l2;
    }
    for (;;)
    {
      int i = 0;
      int k = bcrx.a(paramMsg);
      paramMsg = localArrayList.iterator();
      for (;;)
      {
        if (!paramMsg.hasNext()) {
          break label567;
        }
        parambffl = a(paramMessageRecord, localMsgHead, localArrayList, i, (MessageRecord)paramMsg.next());
        i += 1;
        parambffl.time = l4;
        parambffl.shmsgseq = l3;
        parambffl.msgUid = l5;
        parambffl.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        parambffl.senderuin = String.valueOf(l2);
        parambffl.frienduin = String.valueOf(l1);
        parambffl.vipBubbleDiyTextId = k;
        parambffl.vipBubbleID = aocy.a((int)l6, k);
        axiv.a(parambffl, paramHashMap, paramMessageRecord);
        if ((j == 82) || (j == 43))
        {
          parambffl.istroop = 1;
          continue;
          if (((j == 82) || (j == 43)) && (localMsgHead.group_info.has()))
          {
            l1 = localMsgHead.group_info.group_code.get();
            paramHashMap = a(paramMsg, paramHashMap, paramMessageRecord, localMsgHead, l2, str, localMessageHandler, localArrayList, parambffl);
            break;
          }
          if (((j != 83) && (j != 42)) || (!localMsgHead.discuss_info.has())) {
            break label575;
          }
          l1 = localMsgHead.discuss_info.discuss_uin.get();
          paramHashMap = a(paramMsg, paramHashMap, paramMessageRecord, parambffl, localMsgHead, l2, str, localMessageHandler, localArrayList);
          break;
        }
        if ((j == 83) || (j == 42)) {
          parambffl.istroop = 3000;
        } else {
          parambffl.istroop = 0;
        }
      }
      label567:
      anyv.a(localArrayList);
      return localArrayList;
      label575:
      l1 = l2;
      paramHashMap = str;
    }
  }
  
  public ArrayList<MessageRecord> a(@NonNull byte[] paramArrayOfByte, @NonNull HashMap<String, String> paramHashMap, MessageRecord paramMessageRecord, bffl parambffl)
  {
    System.currentTimeMillis();
    Object localObject1 = b(paramArrayOfByte);
    paramArrayOfByte = new ArrayList();
    Object localObject2 = new msg_transmit.PbMultiMsgTransmit();
    for (;;)
    {
      int i;
      Object localObject4;
      int j;
      try
      {
        localObject1 = (msg_transmit.PbMultiMsgTransmit)((msg_transmit.PbMultiMsgTransmit)localObject2).mergeFrom((byte[])localObject1);
        i = 0;
        if (i >= ((msg_transmit.PbMultiMsgTransmit)localObject1).msg.size()) {
          break;
        }
        Object localObject3 = (msg_comm.Msg)((msg_transmit.PbMultiMsgTransmit)localObject1).msg.get(i);
        localObject4 = (msg_comm.MsgHead)((msg_comm.Msg)localObject3).msg_head.get();
        long l1 = ((msg_comm.MsgHead)localObject4).from_uin.get();
        long l2 = ((msg_comm.MsgHead)localObject4).msg_seq.get();
        long l3 = ((msg_comm.MsgHead)localObject4).msg_time.get();
        long l4 = ((msg_comm.MsgHead)localObject4).msg_uid.get();
        j = ((msg_comm.MsgHead)localObject4).msg_type.get();
        MessageHandler localMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler();
        long l5 = bcrx.a(localMessageHandler, (msg_comm.Msg)localObject3, String.valueOf(l1), String.valueOf(l1));
        localObject2 = new ArrayList();
        long l6 = a(paramHashMap, parambffl, (msg_comm.Msg)localObject3, (msg_comm.MsgHead)localObject4, l1, l1, j, localMessageHandler, (ArrayList)localObject2);
        a(paramMessageRecord, (msg_comm.Msg)localObject3, localMessageHandler, (ArrayList)localObject2);
        int k = bcrx.a((msg_comm.Msg)localObject3);
        localObject3 = ((ArrayList)localObject2).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label391;
        }
        localObject4 = (MessageRecord)((Iterator)localObject3).next();
        ((MessageRecord)localObject4).time = l3;
        ((MessageRecord)localObject4).shmsgseq = l2;
        ((MessageRecord)localObject4).msgUid = l4;
        ((MessageRecord)localObject4).selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        ((MessageRecord)localObject4).senderuin = String.valueOf(l1);
        ((MessageRecord)localObject4).frienduin = String.valueOf(l6);
        ((MessageRecord)localObject4).vipBubbleDiyTextId = k;
        ((MessageRecord)localObject4).vipBubbleID = aocy.a((int)l5, k);
        if ((j == 82) || (j == 43))
        {
          ((MessageRecord)localObject4).istroop = 1;
          continue;
        }
        if (j == 83) {
          break label371;
        }
      }
      catch (Exception paramHashMap)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "unpackPbToMultiMsg, error: exception occurs while parsing the pb bytes", paramHashMap);
        }
        return paramArrayOfByte;
      }
      if (j == 42)
      {
        label371:
        ((MessageRecord)localObject4).istroop = 3000;
      }
      else
      {
        ((MessageRecord)localObject4).istroop = 0;
        continue;
        label391:
        anyv.a((List)localObject2);
        paramArrayOfByte.addAll((Collection)localObject2);
        i += 1;
      }
    }
    a(paramMessageRecord, paramArrayOfByte, null);
    return paramArrayOfByte;
  }
  
  public HashMap<String, ArrayList<MessageRecord>> a(MessageRecord paramMessageRecord)
  {
    HashMap localHashMap = new HashMap();
    if ((paramMessageRecord == null) || (!MessageForStructing.class.isInstance(paramMessageRecord)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "queryMultiMsgWithNest error before of null msg or not structMsg type");
      }
      return localHashMap;
    }
    b((MessageForStructing)paramMessageRecord, localHashMap, 0);
    return localHashMap;
  }
  
  public HashMap<String, ArrayList<MessageRecord>> a(MessageRecord paramMessageRecord, HashMap<String, ArrayList<MessageRecord>> paramHashMap, ProxyListener paramProxyListener, boolean paramBoolean1, boolean paramBoolean2)
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    if ((paramMessageRecord == null) || (paramHashMap == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "preAddMultiMsgWithNest error before of null msg or map");
      }
    }
    do
    {
      do
      {
        return localHashMap;
        if (axiv.a((ChatMessage)paramMessageRecord)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("MultiMsg_TAG", 2, "preAddMultiMsgWithNest error before of not structMsg");
      return localHashMap;
      a((MessageForStructing)paramMessageRecord, paramHashMap, localHashMap, 0, paramProxyListener, paramBoolean1, paramBoolean2, localArrayList);
      if (localArrayList.size() > 0) {
        localHashMap.put("reply_msg", localArrayList);
      }
    } while (!paramBoolean1);
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase();
    return localHashMap;
  }
  
  public HashMap<String, ArrayList<MessageRecord>> a(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap, MessageRecord paramMessageRecord, bffl parambffl)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "unpackPbToMultiMsgWithNest, start unpack, startTime:" + l1);
    }
    paramArrayOfByte = b(paramArrayOfByte);
    Object localObject1 = new msg_transmit.PbMultiMsgTransmit();
    Object localObject2;
    int i;
    Object localObject3;
    try
    {
      paramArrayOfByte = (msg_transmit.PbMultiMsgTransmit)((msg_transmit.PbMultiMsgTransmit)localObject1).mergeFrom(paramArrayOfByte);
      localObject1 = new HashMap();
      if (paramArrayOfByte.pbItemList.has()) {
        break label269;
      }
      localObject2 = new ArrayList();
      if (paramArrayOfByte.msg.has())
      {
        i = 0;
        while (i < paramArrayOfByte.msg.size())
        {
          localObject3 = a((msg_comm.Msg)paramArrayOfByte.msg.get(i), paramHashMap, paramMessageRecord, parambffl);
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
      if (((ArrayList)localObject2).size() <= 0) {
        break label256;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "unpackPbToMultiMsgWithNest, error: exception occurs while parsing PbMultiMsgTransmit", paramArrayOfByte);
      }
      return null;
    }
    ((HashMap)localObject1).put("MultiMsg", localObject2);
    label256:
    if (!a(paramMessageRecord, (HashMap)localObject1, null))
    {
      return null;
      label269:
      i = 0;
      label272:
      Object localObject4;
      if (i < paramArrayOfByte.pbItemList.size())
      {
        localObject4 = (msg_transmit.PbMultiMsgItem)paramArrayOfByte.pbItemList.get(i);
        localObject2 = ((msg_transmit.PbMultiMsgItem)localObject4).fileName.get();
        localObject3 = new msg_transmit.PbMultiMsgNew();
        try
        {
          ((msg_transmit.PbMultiMsgNew)localObject3).mergeFrom(((msg_transmit.PbMultiMsgItem)localObject4).buffer.get().toByteArray());
          localObject4 = new ArrayList();
          int j = 0;
          while (j < ((msg_transmit.PbMultiMsgNew)localObject3).msg.size())
          {
            ArrayList localArrayList = a((msg_comm.Msg)((msg_transmit.PbMultiMsgNew)localObject3).msg.get(j), paramHashMap, paramMessageRecord, parambffl);
            if ((localArrayList != null) && (localArrayList.size() > 0)) {
              ((ArrayList)localObject4).addAll(localArrayList);
            }
            j += 1;
            continue;
            i += 1;
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "unpackPbToMultiMsgWithNest, error: exception occurs while parsing PbMultiMsgNew", localInvalidProtocolBufferMicroException);
          }
        }
      }
      for (;;)
      {
        break label272;
        break;
        ((HashMap)localObject1).put(localInvalidProtocolBufferMicroException, localObject4);
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "unpackPbToMultiMsgWithNest, end unpack,endTime:" + l2 + " cost:" + (l2 - l1));
    }
    return localObject1;
  }
  
  public msg_comm.MsgHead a(MessageRecord paramMessageRecord, HashMap<String, String> paramHashMap, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    msg_comm.MsgHead localMsgHead = new msg_comm.MsgHead();
    localMsgHead.from_uin.set(Long.valueOf(acnh.c(paramMessageRecord)).longValue());
    localMsgHead.msg_seq.set((int)paramMessageRecord.shmsgseq);
    localMsgHead.msg_time.set((int)paramMessageRecord.time);
    localMsgHead.msg_uid.set(Long.valueOf(paramMessageRecord.msgUid).longValue());
    Object localObject1 = new msg_comm.MutilTransHead();
    Object localObject2 = ((msg_comm.MutilTransHead)localObject1).status;
    int i;
    if (paramBoolean1)
    {
      i = 0;
      ((PBUInt32Field)localObject2).set(i);
      ((msg_comm.MutilTransHead)localObject1).msgId.set(paramInt);
      localMsgHead.mutiltrans_head.set((MessageMicro)localObject1);
      localObject2 = paramMessageRecord.getExtInfoFromExtStr("self_nickname");
      String str = acnh.c(paramMessageRecord);
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
      axiv.a("step:packPb.getMsgHead.nickName = %s", new Object[] { localObject1 });
      if ((paramMessageRecord.istroop != 0) && (paramMessageRecord.istroop != 1000) && (paramMessageRecord.istroop != 1004) && (paramMessageRecord.istroop != 1022)) {
        break label378;
      }
      if (!(paramMessageRecord instanceof MessageForPtt)) {
        break label301;
      }
      localMsgHead.msg_type.set(208);
      label250:
      if ((!(paramMessageRecord instanceof MessageForText)) && (!(paramMessageRecord instanceof MessageForStructing))) {
        break label340;
      }
      localMsgHead.c2c_cmd.set(11);
      label274:
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localMsgHead.from_nick.set((String)localObject1);
      }
    }
    for (;;)
    {
      return localMsgHead;
      i = -1;
      break;
      label301:
      if ((!paramBoolean2) && ((paramMessageRecord instanceof MessageForFile)))
      {
        localMsgHead.msg_type.set(529);
        break label250;
      }
      localMsgHead.msg_type.set(9);
      break label250;
      label340:
      if ((!paramBoolean2) && ((paramMessageRecord instanceof MessageForFile)))
      {
        localMsgHead.c2c_cmd.set(4);
        break label274;
      }
      localMsgHead.c2c_cmd.set(175);
      break label274;
      label378:
      if (paramMessageRecord.istroop == 3000)
      {
        localMsgHead.msg_type.set(83);
        paramHashMap = new msg_comm.DiscussInfo();
        paramHashMap.discuss_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          paramHashMap.discuss_remark.set(ByteStringMicro.copyFromUtf8((String)localObject1));
        }
        localMsgHead.discuss_info.set(paramHashMap);
      }
      else
      {
        if (paramMessageRecord.istroop != 1) {
          break label530;
        }
        localMsgHead.msg_type.set(82);
        paramHashMap = new msg_comm.GroupInfo();
        paramHashMap.group_code.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          paramHashMap.group_card.set(ByteStringMicro.copyFromUtf8((String)localObject1));
        }
        localMsgHead.group_info.set(paramHashMap);
      }
    }
    label530:
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "MultiMsg:getMultiMsgHead, error:mr is not a C2C/dis/troop msg");
    }
    return null;
  }
  
  public im_msg_body.MsgBody a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    im_msg_body.MsgBody localMsgBody = null;
    for (;;)
    {
      try
      {
        if ((paramMessageRecord.msgtype == -1000) || (paramMessageRecord.msgtype == -10000))
        {
          localRichText = c(paramMessageRecord);
          if (localRichText == null) {}
        }
      }
      catch (Exception localException1)
      {
        im_msg_body.RichText localRichText;
        im_msg_body.ElemFlags2 localElemFlags2;
        im_msg_body.Elem localElem;
        paramMessageRecord = null;
        QLog.e("MultiMsg_TAG", 1, localException1, new Object[0]);
        return paramMessageRecord;
      }
      try
      {
        localElemFlags2 = new im_msg_body.ElemFlags2();
        localElemFlags2.uint32_color_text_id.set((int)(paramMessageRecord.vipBubbleID & 0xFFFFFFFF));
        localElem = new im_msg_body.Elem();
        localElem.elem_flags2.set(localElemFlags2);
        localRichText.elems.add(localElem);
        a(paramMessageRecord, localRichText);
        if (localMsgBody != null) {
          break label469;
        }
        paramMessageRecord = new im_msg_body.MsgBody();
      }
      catch (Exception localException2)
      {
        paramMessageRecord = localMsgBody;
        continue;
      }
      try
      {
        paramMessageRecord.rich_text.set(localRichText);
        return paramMessageRecord;
      }
      catch (Exception localException3)
      {
        continue;
      }
      if (paramMessageRecord.msgtype == -1049)
      {
        localRichText = bcrx.a((MessageForReplyText)paramMessageRecord);
      }
      else if (paramMessageRecord.msgtype == -2005)
      {
        if (paramBoolean)
        {
          localRichText = b(paramMessageRecord);
        }
        else
        {
          localMsgBody = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a(1, paramMessageRecord);
          localRichText = null;
        }
      }
      else if (paramMessageRecord.msgtype == -2017)
      {
        if (paramBoolean)
        {
          localRichText = a(paramMessageRecord);
        }
        else
        {
          localMsgBody = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a(1, paramMessageRecord);
          localRichText = null;
        }
      }
      else if (paramMessageRecord.msgtype == -2000)
      {
        localRichText = bcrx.a((MessageForPic)paramMessageRecord);
      }
      else if (paramMessageRecord.msgtype == -5008)
      {
        localRichText = bcrx.a((MessageForArkApp)paramMessageRecord, true);
      }
      else if (paramMessageRecord.msgtype == -5016)
      {
        localRichText = bcrx.c((MessageForArkBabyqReply)paramMessageRecord, true);
      }
      else if (paramMessageRecord.msgtype == -5017)
      {
        localRichText = bcrx.b((MessageForArkApp)paramMessageRecord, true);
      }
      else if (paramMessageRecord.msgtype == -5014)
      {
        localRichText = bcrx.d((MessageForHiBoom)paramMessageRecord);
      }
      else if (paramMessageRecord.msgtype == -2011)
      {
        localRichText = a((MessageForStructing)paramMessageRecord);
      }
      else if (paramMessageRecord.msgtype == -1035)
      {
        localRichText = bcrx.a((MessageForMixedMsg)paramMessageRecord);
      }
      else if (paramMessageRecord.msgtype == -1051)
      {
        localRichText = bcrx.a((MessageForLongTextMsg)paramMessageRecord, false);
      }
      else if (paramMessageRecord.msgtype == -2022)
      {
        localRichText = ((MessageForRichText)paramMessageRecord).richText;
      }
      else if (paramMessageRecord.msgtype == -2002)
      {
        localRichText = ((MessageForRichText)paramMessageRecord).richText;
        continue;
        label469:
        return localMsgBody;
      }
      else
      {
        Object localObject = null;
      }
    }
  }
  
  protected void a() {}
  
  protected void a(MessageRecord paramMessageRecord, List<MessageRecord> paramList, ProxyListener paramProxyListener)
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
      if (localMessageRecord1.msgtype == -1035)
      {
        Iterator localIterator = ((MessageForMixedMsg)localMessageRecord1).msgElemList.iterator();
        while (localIterator.hasNext())
        {
          MessageRecord localMessageRecord2 = (MessageRecord)localIterator.next();
          localMessageRecord2.msgseq = localMessageRecord1.msgseq;
          localMessageRecord2.isMultiMsg = true;
        }
      }
      if (QLog.isColorLevel())
      {
        localMessageRecord1.toString();
        QLog.d("MultiMsg_TAG", 2, "addMultiMsgSingle, time:" + localMessageRecord1.time + " senderuin:" + localMessageRecord1.senderuin + " istroop:" + localMessageRecord1.istroop + " shmsgseq:" + localMessageRecord1.shmsgseq + " msgseq:" + localMessageRecord1.msgseq + " msgData:" + localMessageRecord1.msgData);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.addMsgQueueDonotNotify(localMessageRecord1.frienduin, localMessageRecord1.istroop, localMessageRecord1.getTableName(), localMessageRecord1, 0, paramProxyListener);
    }
  }
  
  protected void a(String paramString, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.addMsgQueue(paramString, paramInt, "mr_multimessage", "msgseq=?", new String[] { String.valueOf(paramLong) }, 2, null);
  }
  
  public boolean a(MessageRecord paramMessageRecord, ProxyListener paramProxyListener)
  {
    if (paramMessageRecord.getStatus() == 1000) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.addMsgQueueDonotNotify(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.getTableName(), paramMessageRecord, 3, null);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase();
      return true;
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.addMsgQueueDonotNotify(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.getTableName(), paramMessageRecord, 4, null);
    }
  }
  
  public boolean a(MessageRecord paramMessageRecord, HashMap<String, ArrayList<MessageRecord>> paramHashMap, ProxyListener paramProxyListener)
  {
    if ((paramMessageRecord == null) || (paramHashMap == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "addMultiMsgWithNest error before of null msg or map");
      }
    }
    do
    {
      return false;
      if (MessageForStructing.class.isInstance(paramMessageRecord)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MultiMsg_TAG", 2, "addMultiMsgWithNest error before of not structMsg");
    return false;
    a((MessageForStructing)paramMessageRecord, paramHashMap, 0);
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase();
    return true;
  }
  
  protected boolean a(MessageRecord paramMessageRecord, List<MessageRecord> paramList, ProxyListener paramProxyListener)
  {
    a(paramMessageRecord, paramList, paramProxyListener);
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase();
    return true;
  }
  
  public boolean a(HashMap<String, ArrayList<MessageRecord>> paramHashMap, MessageRecord paramMessageRecord)
  {
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      Iterator localIterator1 = paramHashMap.keySet().iterator();
      boolean bool = false;
      if (localIterator1.hasNext())
      {
        ArrayList localArrayList = (ArrayList)paramHashMap.get((String)localIterator1.next());
        Iterator localIterator2 = localArrayList.iterator();
        int i = 0;
        label63:
        MessageRecord localMessageRecord1;
        if (localIterator2.hasNext())
        {
          localMessageRecord1 = (MessageRecord)localIterator2.next();
          if ((localMessageRecord1 instanceof MessageForReplyText))
          {
            MessageRecord localMessageRecord2 = ((MessageForReplyText)localMessageRecord1).getSourceMessage();
            if ((localMessageRecord2 != null) && (((localMessageRecord2 instanceof MessageForPic)) || ((localMessageRecord2 instanceof MessageForShortVideo))) && (localMessageRecord2.uniseq == paramMessageRecord.uniseq)) {
              bool = true;
            }
          }
        }
        for (;;)
        {
          if (bool)
          {
            if ((localArrayList.get(i) instanceof MessageForReplyText))
            {
              ((MessageForReplyText)localArrayList.get(i)).setSourceMessageRecord(paramMessageRecord);
              return bool;
              if (localMessageRecord1.uniseq == paramMessageRecord.uniseq)
              {
                bool = true;
                continue;
              }
              i += 1;
              break label63;
            }
            localArrayList.set(i, paramMessageRecord);
            return bool;
          }
          break;
          bool = false;
        }
      }
      return bool;
    }
    return false;
  }
  
  public boolean a(List<MessageRecord> paramList, ProxyListener paramProxyListener)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramProxyListener = (MessageRecord)paramList.next();
      if (paramProxyListener.getStatus() == 1000) {
        this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.addMsgQueueDonotNotify(paramProxyListener.frienduin, paramProxyListener.istroop, paramProxyListener.getTableName(), paramProxyListener, 3, null);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.addMsgQueueDonotNotify(paramProxyListener.frienduin, paramProxyListener.istroop, paramProxyListener.getTableName(), paramProxyListener, 4, null);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.transSaveToDatabase();
    return true;
  }
  
  public byte[] a(MessageRecord paramMessageRecord)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "packPbFromLongTextMsg, start pack, startTime:" + l1);
    }
    msg_transmit.PbMultiMsgTransmit localPbMultiMsgTransmit = new msg_transmit.PbMultiMsgTransmit();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
    Object localObject2 = new HashMap();
    ((HashMap)localObject2).put(paramMessageRecord.senderuin, localObject1);
    localObject1 = new msg_comm.Msg();
    localObject2 = a(paramMessageRecord, (HashMap)localObject2, true, 1, false);
    im_msg_body.MsgBody localMsgBody = a(paramMessageRecord, false);
    if ((localObject2 != null) && (localMsgBody != null))
    {
      ((msg_comm.Msg)localObject1).msg_head.set((MessageMicro)localObject2);
      ((msg_comm.Msg)localObject1).msg_body.set(localMsgBody);
      localPbMultiMsgTransmit.msg.add((MessageMicro)localObject1);
    }
    for (;;)
    {
      paramMessageRecord = a(localPbMultiMsgTransmit.toByteArray());
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "packPbFromLongTextMsg, end pack, endTime:" + l2 + " cost:" + (l2 - l1));
      }
      return paramMessageRecord;
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "packPbFromLongTextMsg, error:msg_head or msg_body is null,uniseq:" + paramMessageRecord.uniseq);
      }
    }
  }
  
  public byte[] a(ArrayList<MessageRecord> paramArrayList, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, new Object[] { "packPbToMultiMsg, start pack, startTime:", Long.valueOf(l1) });
    }
    MessageRecord localMessageRecord = null;
    msg_transmit.PbMultiMsgTransmit localPbMultiMsgTransmit = new msg_transmit.PbMultiMsgTransmit();
    int i = new Random(System.currentTimeMillis()).nextInt();
    Iterator localIterator = paramArrayList.iterator();
    paramArrayList = localMessageRecord;
    int j;
    while (localIterator.hasNext())
    {
      localMessageRecord = (MessageRecord)localIterator.next();
      msg_comm.Msg localMsg = new msg_comm.Msg();
      j = i + 1;
      msg_comm.MsgHead localMsgHead = a(localMessageRecord, paramHashMap, paramBoolean, i, false);
      im_msg_body.MsgBody localMsgBody = a(localMessageRecord, false);
      if ((localMsgHead != null) && (localMsgBody != null))
      {
        localMsg.msg_head.set(localMsgHead);
        localMsg.msg_body.set(localMsgBody);
        localPbMultiMsgTransmit.msg.add(localMsg);
        i = j;
      }
      else
      {
        if (paramArrayList != null) {
          break label298;
        }
        paramArrayList = new StringBuilder("packPbFromMultiMsg error:msg_head or msg_body is null, uniseq:");
      }
    }
    label298:
    for (;;)
    {
      paramArrayList.append(localMessageRecord.uniseq).append("|");
      i = j;
      break;
      if ((paramArrayList != null) && (QLog.isColorLevel())) {
        QLog.d("MultiMsg_TAG", 2, paramArrayList.toString());
      }
      paramArrayList = a(localPbMultiMsgTransmit.toByteArray());
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, "packPbToMultiMsg, end pack,endTime:" + l2 + " cost:" + (l2 - l1));
      }
      return paramArrayList;
    }
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
    Object localObject2 = paramHashMap.keySet().iterator();
    Object localObject3;
    Object localObject4;
    msg_transmit.PbMultiMsgNew localPbMultiMsgNew;
    label131:
    MessageRecord localMessageRecord;
    int j;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      Object localObject5 = (ArrayList)paramHashMap.get(localObject3);
      localObject4 = new msg_transmit.PbMultiMsgItem();
      localPbMultiMsgNew = new msg_transmit.PbMultiMsgNew();
      localObject5 = ((ArrayList)localObject5).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localMessageRecord = (MessageRecord)((Iterator)localObject5).next();
        msg_comm.Msg localMsg = new msg_comm.Msg();
        j = i + 1;
        msg_comm.MsgHead localMsgHead = a(localMessageRecord, paramHashMap1, paramBoolean, i, false);
        im_msg_body.MsgBody localMsgBody = a(localMessageRecord, false);
        if ((localMsgHead != null) && (localMsgBody != null))
        {
          localMsg.msg_head.set(localMsgHead);
          localMsg.msg_body.set(localMsgBody);
          localPbMultiMsgNew.msg.add(localMsg);
          i = j;
        }
        else
        {
          if (localObject1 != null) {
            break label613;
          }
          localObject1 = new StringBuilder("packPbFromMultiMsgWithNest error:msg_head or msg_body is null, uniseq:");
        }
      }
    }
    label610:
    label613:
    for (;;)
    {
      ((StringBuilder)localObject1).append(localMessageRecord.uniseq).append("|");
      i = j;
      break label131;
      ((msg_transmit.PbMultiMsgItem)localObject4).fileName.set((String)localObject3);
      ((msg_transmit.PbMultiMsgItem)localObject4).buffer.set(ByteStringMicro.copyFrom(localPbMultiMsgNew.toByteArray()));
      localPbMultiMsgTransmit.pbItemList.add((MessageMicro)localObject4);
      break;
      if ((localObject1 != null) && (QLog.isColorLevel())) {
        QLog.d("MultiMsg_TAG", 2, ((StringBuilder)localObject1).toString());
      }
      paramHashMap = (ArrayList)paramHashMap.get("MultiMsg");
      if ((paramHashMap != null) && (paramHashMap.size() > 0))
      {
        localObject1 = paramHashMap.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          paramHashMap = (MessageRecord)((Iterator)localObject1).next();
          if (!axiv.a((ChatMessage)paramHashMap)) {
            break label610;
          }
          paramHashMap = a(paramHashMap, axim.jdField_b_of_type_JavaLangString, false);
        }
      }
      for (;;)
      {
        localObject2 = new msg_comm.Msg();
        j = i + 1;
        localObject3 = a(paramHashMap, paramHashMap1, paramBoolean, i, true);
        localObject4 = a(paramHashMap, true);
        if ((localObject3 != null) && (localObject4 != null))
        {
          ((msg_comm.Msg)localObject2).msg_head.set((MessageMicro)localObject3);
          ((msg_comm.Msg)localObject2).msg_body.set((MessageMicro)localObject4);
          localPbMultiMsgTransmit.msg.add((MessageMicro)localObject2);
          i = j;
          break;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("MultiMsg_TAG", 2, "packPbFromMultiMsg error:msg_head or msg_body is null, uniseq:" + paramHashMap.uniseq);
          new StringBuilder();
          i = j;
          break;
          paramHashMap = a(localPbMultiMsgTransmit.toByteArray());
          long l2 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "packPbFromMultiMsgWithNest, end pack,endTime:" + l2 + " cost:" + (l2 - l1));
          }
          return paramHashMap;
        }
        i = j;
        break;
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Azhs != null) && (this.jdField_a_of_type_Azhs.isOpen())) {
      this.jdField_a_of_type_Azhs.close();
    }
  }
  
  public void c()
  {
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getWritableDatabase();
    if (localSQLiteDatabase == null) {}
    int i;
    MessageRecord localMessageRecord;
    do
    {
      do
      {
        return;
        i = localSQLiteDatabase.getCount("mr_multimessage");
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "checkMsgCounts, count:" + i);
        }
      } while (i <= 1000000);
      i = Math.max(i - 1000000, 200);
      localMessageRecord = a(i);
    } while (localMessageRecord == null);
    String str = String.format("delete from %s where _id in (select _id from %s order by _id limit %s)", new Object[] { "mr_multimessage", "mr_multimessage", Integer.valueOf(i) });
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "checkMsgCounts, delNum:" + i + "mr.msgseq:" + localMessageRecord.msgseq);
    }
    try
    {
      localSQLiteDatabase.execSQL(str);
      label165:
      a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.msgseq);
      return;
    }
    catch (Exception localException)
    {
      break label165;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aooh
 * JD-Core Version:    0.7.0.1
 */