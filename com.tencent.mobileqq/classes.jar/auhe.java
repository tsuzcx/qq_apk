import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.data.MsgBackupMsgEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.DiscussInfo;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.AnonymousGroupMsg;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;

public class auhe
  extends amno
{
  public static long a;
  
  public auhe(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
  }
  
  public static long a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong2 == paramLong1) {
      return paramLong3;
    }
    return paramLong2;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    msg_comm.Msg localMsg = new msg_comm.Msg();
    if ((paramArrayOfByte == null) || (paramQQAppInterface == null)) {}
    try
    {
      if (!QLog.isColorLevel()) {
        break label1242;
      }
      QLog.d("MsgBackup_msgproxy", 2, "transToMessageRecord, extensionData is null");
    }
    catch (InvalidProtocolBufferMicroException paramQQAppInterface)
    {
      long l4;
      long l5;
      long l6;
      long l7;
      paramQQAppInterface.printStackTrace();
      return null;
    }
    localMsg.mergeFrom(paramArrayOfByte);
    paramArrayOfByte = (msg_comm.MsgHead)localMsg.msg_head.get();
    l4 = paramArrayOfByte.from_uin.get();
    long l3 = paramArrayOfByte.to_uin.get();
    l5 = paramArrayOfByte.msg_seq.get();
    l6 = paramArrayOfByte.msg_time.get();
    l7 = paramArrayOfByte.msg_uid.get();
    int k = paramArrayOfByte.msg_type.get();
    MessageHandler localMessageHandler = paramQQAppInterface.a();
    Object localObject2 = new Pair(Long.valueOf(-1L), Long.valueOf(-1L));
    long l1;
    ArrayList localArrayList;
    int i;
    if (((Long)((Pair)localObject2).first).longValue() != 4294967295L)
    {
      l1 = ((Long)((Pair)localObject2).first).longValue();
      break label1244;
      localArrayList = new ArrayList();
      if (((!azah.c(k)) && (k != 208) && (k != 529)) || (!paramArrayOfByte.c2c_cmd.has())) {
        break label554;
      }
      i = paramArrayOfByte.c2c_cmd.get();
      if ((k != 529) || (i != 4)) {
        break label1273;
      }
      if (a(localArrayList, localMsg)) {
        paramQQAppInterface.a().a().a(localArrayList, ((im_msg_body.MsgBody)localMsg.msg_body.get()).msg_content.get());
      }
    }
    label273:
    label303:
    label318:
    int j;
    for (;;)
    {
      if ((k == 208) && (a(localArrayList, localMsg)))
      {
        azad.a(localMessageHandler, localArrayList, localMsg);
        break label1259;
        int m = azad.a(localMsg);
        paramArrayOfByte = localArrayList.iterator();
        i = 0;
        if (paramArrayOfByte.hasNext())
        {
          localObject2 = (MessageRecord)paramArrayOfByte.next();
          ((MessageRecord)localObject2).time = l6;
          ((MessageRecord)localObject2).shmsgseq = l5;
          ((MessageRecord)localObject2).msgUid = l7;
          ((MessageRecord)localObject2).selfuin = paramQQAppInterface.getCurrentAccountUin();
          ((MessageRecord)localObject2).senderuin = String.valueOf(l4);
          ((MessageRecord)localObject2).frienduin = String.valueOf(l1);
          ((MessageRecord)localObject2).vipBubbleDiyTextId = m;
          Object localObject1;
          ((MessageRecord)localObject2).vipBubbleID = amca.a((int)localObject1, m);
          ((MessageRecord)localObject2).isread = true;
          if (l4 != paramQQAppInterface.getLongAccountUin()) {
            break label1321;
          }
          j = 1;
          label426:
          ((MessageRecord)localObject2).issend = j;
          if ((k != 82) && (k != 43)) {
            break label1326;
          }
          ((MessageRecord)localObject2).istroop = 1;
          label452:
          if (((MessageRecord)localObject2).senderuin.equals(((MessageRecord)localObject2).selfuin)) {
            ((MessageRecord)localObject2).issend = 1;
          }
          if ((((MessageRecord)localObject2).msgData != null) || (((MessageRecord)localObject2).msg == null)) {
            break label1266;
          }
          ((MessageRecord)localObject2).msgData = ((MessageRecord)localObject2).msg.getBytes();
          break label1266;
          l1 = ((Long)((Pair)localObject2).second).longValue();
          break label1244;
          label522:
          if (!a(localArrayList, localMsg)) {
            break label1287;
          }
          azad.a(localMessageHandler, localArrayList, localMsg, true, false, null);
          continue;
          label554:
          if (((k != 82) && (k != 43)) || (!paramArrayOfByte.group_info.has())) {
            break label1299;
          }
          l1 = paramArrayOfByte.group_info.group_code.get();
          if (!a(localArrayList, localMsg)) {
            break label1232;
          }
          if (!paramQQAppInterface.a().a().a(localArrayList, localMsg)) {
            azad.a(localMessageHandler, localArrayList, localMsg, false, false, null);
          }
          paramArrayOfByte = (im_msg_body.MsgBody)localMsg.msg_body.get();
          if (!paramArrayOfByte.rich_text.has()) {
            break label1296;
          }
          im_msg_body.RichText localRichText = (im_msg_body.RichText)paramArrayOfByte.rich_text.get();
          if (localRichText.elems.has())
          {
            paramArrayOfByte = localRichText.elems.get();
            if (paramArrayOfByte != null)
            {
              paramArrayOfByte = paramArrayOfByte.iterator();
              while (paramArrayOfByte.hasNext())
              {
                localObject2 = (im_msg_body.Elem)paramArrayOfByte.next();
                if (((im_msg_body.Elem)localObject2).anon_group_msg.has())
                {
                  localObject2 = (im_msg_body.AnonymousGroupMsg)((im_msg_body.Elem)localObject2).anon_group_msg.get();
                  i = ((im_msg_body.AnonymousGroupMsg)localObject2).uint32_flags.get();
                  paramArrayOfByte = ((im_msg_body.AnonymousGroupMsg)localObject2).str_anon_id.get().toByteArray();
                  byte[] arrayOfByte = ((im_msg_body.AnonymousGroupMsg)localObject2).str_anon_nick.get().toByteArray();
                  j = ((im_msg_body.AnonymousGroupMsg)localObject2).uint32_head_portrait.get();
                  m = ((im_msg_body.AnonymousGroupMsg)localObject2).uint32_expire_time.get();
                  String str = ((im_msg_body.AnonymousGroupMsg)localObject2).str_rank_color.get().toStringUtf8();
                  if (paramArrayOfByte == null) {
                    break label1289;
                  }
                  for (;;)
                  {
                    try
                    {
                      paramArrayOfByte = new String(paramArrayOfByte, "ISO-8859-1");
                      label820:
                      Iterator localIterator = localArrayList.iterator();
                      if (!localIterator.hasNext()) {
                        break;
                      }
                      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
                      if (arrayOfByte == null)
                      {
                        localObject2 = "";
                        localMessageRecord.saveExtInfoToExtStr("anonymous", nav.a(i, paramArrayOfByte, (String)localObject2, j, m, str));
                        localMessageRecord.extLong |= 0x3;
                      }
                      else
                      {
                        localObject2 = new String(arrayOfByte);
                      }
                    }
                    catch (UnsupportedEncodingException paramArrayOfByte)
                    {
                      paramArrayOfByte.printStackTrace();
                    }
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("anonymous_decode", 2, "anonymous_flags has = " + i);
                  }
                }
              }
            }
          }
          if (!localRichText.ptt.has()) {
            break label1296;
          }
          azad.a(localMessageHandler, localMsg, localArrayList);
          break label1296;
          label972:
          if (paramArrayOfByte.discuss_info.has())
          {
            l1 = paramArrayOfByte.discuss_info.discuss_uin.get();
            if (!a(localArrayList, localMsg)) {
              break label1229;
            }
            if (!paramQQAppInterface.a().a().b(localArrayList, localMsg)) {
              azad.a(localMessageHandler, localArrayList, localMsg, false, false, null);
            }
            paramArrayOfByte = (im_msg_body.MsgBody)localMsg.msg_body.get();
            if ((!paramArrayOfByte.rich_text.has()) || (!((im_msg_body.RichText)paramArrayOfByte.rich_text.get()).ptt.has())) {
              break label1316;
            }
            azad.a(localMessageHandler, localMsg, localArrayList);
            break label1316;
          }
          label1086:
          if (!QLog.isColorLevel()) {
            break label1319;
          }
          QLog.d("MsgBackup_msgproxy", 2, "unpackPbToMultiMsgWithNest, illegal msgType:" + k);
          break label1319;
        }
      }
    }
    label1287:
    label1289:
    label1296:
    label1299:
    label1316:
    label1319:
    label1321:
    label1326:
    for (;;)
    {
      label1122:
      ((MessageRecord)localObject2).istroop = 3000;
      break label452;
      label1229:
      label1232:
      label1242:
      label1244:
      label1259:
      label1266:
      label1273:
      do
      {
        if (alof.z.equals(Long.valueOf(l3)))
        {
          ((MessageRecord)localObject2).istroop = 6000;
          break label452;
        }
        if (alof.A.equals(Long.valueOf(l3)))
        {
          ((MessageRecord)localObject2).istroop = 6003;
          break label452;
        }
        ((MessageRecord)localObject2).istroop = 0;
        break label452;
        alww.a(localArrayList);
        if (localArrayList.size() > 0) {
          return (MessageRecord)localArrayList.get(0);
        }
        aujq.a("MsgBackup_msgproxy", "transToMessageRecord failed.........", new Object[0]);
        return null;
        break label303;
        break label303;
        do
        {
          l2 = l1;
          break;
          return null;
        } while (l1 != -1L);
        long l2 = 0L;
        break;
        l1 = l3;
        break label303;
        i += 1;
        break label318;
        if (i == 175) {
          break label522;
        }
        if (i != 11) {
          break label273;
        }
        break label522;
        break label273;
        paramArrayOfByte = "";
        break label820;
        break label303;
        if (k == 83) {
          break label972;
        }
        if (k != 42) {
          break label1086;
        }
        break label972;
        break label303;
        return null;
        j = 0;
        break label426;
        if (k == 83) {
          break label1122;
        }
      } while (k != 42);
    }
  }
  
  public static msg_comm.MsgHead a(MessageRecord paramMessageRecord, long paramLong)
  {
    msg_comm.MsgHead localMsgHead = new msg_comm.MsgHead();
    Object localObject = abti.c(paramMessageRecord);
    for (;;)
    {
      try
      {
        long l1 = Long.valueOf((String)localObject).longValue();
        long l2 = Long.valueOf(paramMessageRecord.frienduin).longValue();
        localMsgHead.from_uin.set(l1);
        localMsgHead.to_uin.set(l2);
        localMsgHead.is_src_msg.set(paramMessageRecord.isReplySource);
        localMsgHead.msg_seq.set((int)paramMessageRecord.shmsgseq);
        localMsgHead.msg_time.set((int)paramMessageRecord.time);
        localMsgHead.msg_uid.set(Long.valueOf(paramMessageRecord.msgUid).longValue());
        if ((paramMessageRecord.istroop != 0) && (paramMessageRecord.istroop != 6000) && (paramMessageRecord.istroop != 6003) && (paramMessageRecord.istroop != 1000) && (paramMessageRecord.istroop != 1004) && (paramMessageRecord.istroop != 1022)) {
          break label311;
        }
        paramLong = b(paramLong, l1, l2);
        localMsgHead.to_uin.set(paramLong);
        if ((paramMessageRecord instanceof MessageForPtt))
        {
          localMsgHead.msg_type.set(208);
          if ((!(paramMessageRecord instanceof MessageForText)) && (!(paramMessageRecord instanceof MessageForStructing))) {
            break;
          }
          localMsgHead.c2c_cmd.set(11);
          break label446;
        }
        if ((paramMessageRecord instanceof MessageForFile)) {
          localMsgHead.msg_type.set(529);
        } else {
          localMsgHead.msg_type.set(9);
        }
      }
      catch (Exception paramMessageRecord)
      {
        QLog.e("MsgBackup_msgproxy", 1, paramMessageRecord, new Object[0]);
        return null;
      }
    }
    if ((paramMessageRecord instanceof MessageForFile))
    {
      localMsgHead.c2c_cmd.set(4);
    }
    else
    {
      localMsgHead.c2c_cmd.set(175);
      break label446;
      label311:
      if (paramMessageRecord.istroop == 3000)
      {
        localMsgHead.msg_type.set(83);
        localObject = new msg_comm.DiscussInfo();
        ((msg_comm.DiscussInfo)localObject).discuss_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
        localMsgHead.discuss_info.set((MessageMicro)localObject);
      }
      else if (paramMessageRecord.istroop == 1)
      {
        localMsgHead.msg_type.set(82);
        localObject = new msg_comm.GroupInfo();
        ((msg_comm.GroupInfo)localObject).group_code.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
        localMsgHead.group_info.set((MessageMicro)localObject);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_msgproxy", 2, "getMultiMsgHead, error:mr is not a C2C/dis/troop msg");
        }
        return null;
      }
    }
    label446:
    return localMsgHead;
  }
  
  public static im_msg_body.MsgBody a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramMessageRecord.msgtype == -1000) || (paramMessageRecord.msgtype == -10000)) {
      if (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("sens_msg_source_msg_info"))) {
        paramQQAppInterface = azad.a(paramMessageRecord);
      }
    }
    label965:
    for (;;)
    {
      if ((paramQQAppInterface != null) && (!paramQQAppInterface.elems.isEmpty()))
      {
        Object localObject1 = new im_msg_body.ElemFlags2();
        ((im_msg_body.ElemFlags2)localObject1).uint32_color_text_id.set((int)(paramMessageRecord.vipBubbleID & 0xFFFFFFFF));
        Object localObject2 = new im_msg_body.Elem();
        ((im_msg_body.Elem)localObject2).elem_flags2.set((MessageMicro)localObject1);
        paramQQAppInterface.elems.add((MessageMicro)localObject2);
        if (nav.a(paramMessageRecord))
        {
          localObject1 = new im_msg_body.Elem();
          localObject2 = new im_msg_body.AnonymousGroupMsg();
          naw localnaw = nav.a(paramMessageRecord);
          ((im_msg_body.AnonymousGroupMsg)localObject2).uint32_flags.set(localnaw.jdField_a_of_type_Int);
          if (!TextUtils.isEmpty(localnaw.jdField_a_of_type_JavaLangString)) {
            ((im_msg_body.AnonymousGroupMsg)localObject2).str_anon_id.set(ByteStringMicro.copyFrom(localnaw.jdField_a_of_type_JavaLangString.getBytes()));
          }
          if (!TextUtils.isEmpty(localnaw.jdField_b_of_type_JavaLangString)) {
            ((im_msg_body.AnonymousGroupMsg)localObject2).str_anon_nick.set(ByteStringMicro.copyFrom(localnaw.jdField_b_of_type_JavaLangString.getBytes()));
          }
          ((im_msg_body.AnonymousGroupMsg)localObject2).uint32_head_portrait.set(localnaw.jdField_b_of_type_Int);
          ((im_msg_body.AnonymousGroupMsg)localObject2).uint32_expire_time.set(localnaw.jdField_c_of_type_Int);
          if (!TextUtils.isEmpty(localnaw.jdField_c_of_type_JavaLangString)) {
            ((im_msg_body.AnonymousGroupMsg)localObject2).str_rank_color.set(ByteStringMicro.copyFrom(localnaw.jdField_c_of_type_JavaLangString.getBytes()));
          }
          ((im_msg_body.AnonymousGroupMsg)localObject2).uint32_bubble_id.set((int)paramMessageRecord.vipBubbleID);
          ((im_msg_body.Elem)localObject1).anon_group_msg.set((MessageMicro)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("anonymous_decode", 2, "anonymous_addd anon_group_msg = ");
          }
          paramQQAppInterface.elems.add((MessageMicro)localObject1);
        }
        paramMessageRecord = new im_msg_body.MsgBody();
        paramMessageRecord.rich_text.set(paramQQAppInterface);
        return paramMessageRecord;
        paramQQAppInterface = azad.a((MessageForText)paramMessageRecord);
        continue;
        if (paramMessageRecord.msgtype == -1049)
        {
          paramQQAppInterface = azad.a((MessageForReplyText)paramMessageRecord);
          continue;
        }
        if (paramMessageRecord.msgtype == -2005) {
          return paramQQAppInterface.a().a().a(2, paramMessageRecord);
        }
        if (paramMessageRecord.msgtype == -2017) {
          return paramQQAppInterface.a().a().a(2, paramMessageRecord);
        }
        if (paramMessageRecord.msgtype == -2052)
        {
          paramQQAppInterface = azad.a((MessageForQQStoryComment)paramMessageRecord);
          continue;
        }
        if (paramMessageRecord.msgtype == -2000)
        {
          paramQQAppInterface = azad.a((MessageForPic)paramMessageRecord);
          continue;
        }
        if (paramMessageRecord.msgtype == -5008)
        {
          paramQQAppInterface = azad.a((MessageForArkApp)paramMessageRecord, true);
          continue;
        }
        if (paramMessageRecord.msgtype == -5016)
        {
          paramQQAppInterface = azad.c((MessageForArkBabyqReply)paramMessageRecord, true);
          continue;
        }
        if (paramMessageRecord.msgtype == -5017)
        {
          paramQQAppInterface = azad.b((MessageForArkApp)paramMessageRecord, true);
          continue;
        }
        if (paramMessageRecord.msgtype == -5013)
        {
          paramQQAppInterface = azad.c((MessageForArkFlashChat)paramMessageRecord);
          continue;
        }
        if (paramMessageRecord.msgtype == -5014)
        {
          paramQQAppInterface = azad.d((MessageForHiBoom)paramMessageRecord);
          continue;
        }
        if (paramMessageRecord.msgtype == -2011)
        {
          paramQQAppInterface = azad.a((MessageForStructing)paramMessageRecord);
          if (paramQQAppInterface != null) {
            break label965;
          }
          return null;
        }
        if (paramMessageRecord.msgtype == -1035)
        {
          paramQQAppInterface = new im_msg_body.RichText();
          int k = ((MessageForMixedMsg)paramMessageRecord).msgElemList.size();
          int i = 0;
          while (i < k)
          {
            localObject1 = (MessageRecord)((MessageForMixedMsg)paramMessageRecord).msgElemList.get(i);
            if ((localObject1 instanceof MessageForText))
            {
              localObject1 = azad.a((MessageForText)localObject1);
              if (localObject1 == null) {
                return null;
              }
              int j = 0;
              while (j < ((im_msg_body.RichText)localObject1).elems.size())
              {
                paramQQAppInterface.elems.add(((im_msg_body.RichText)localObject1).elems.get(j));
                j += 1;
              }
            }
            if ((localObject1 instanceof MessageForRichText))
            {
              localObject1 = ((MessageForPic)localObject1).richText;
              if (localObject1 == null) {
                return null;
              }
              paramQQAppInterface.elems.add(((im_msg_body.RichText)localObject1).elems.get(0));
            }
            i += 1;
          }
          continue;
        }
        if (paramMessageRecord.msgtype == -1051)
        {
          paramQQAppInterface = azad.a((MessageForLongTextMsg)paramMessageRecord, false);
          continue;
        }
        if (paramMessageRecord.msgtype == -2022)
        {
          if ((paramMessageRecord instanceof MessageForRichText)) {
            paramQQAppInterface = ((MessageForRichText)paramMessageRecord).richText;
          }
        }
        else if (paramMessageRecord.msgtype == -2002)
        {
          if ((paramMessageRecord instanceof MessageForRichText)) {
            paramQQAppInterface = ((MessageForRichText)paramMessageRecord).richText;
          }
        }
        else
        {
          if (paramMessageRecord.msgtype == -2071)
          {
            paramQQAppInterface = ((MessageForLightVideo)paramMessageRecord).richText;
            continue;
          }
          if (paramMessageRecord.msgtype == -2007)
          {
            paramQQAppInterface = azad.a((MessageForMarketFace)paramMessageRecord);
            continue;
          }
          if ((paramMessageRecord.msgtype == -2059) && (!TextUtils.isEmpty(paramMessageRecord.msg)))
          {
            paramQQAppInterface = new im_msg_body.RichText();
            localObject1 = new im_msg_body.Elem();
            localObject2 = new im_msg_body.Text();
            ((im_msg_body.Text)localObject2).str.set(ByteStringMicro.copyFromUtf8(paramMessageRecord.msg));
            ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject2);
            paramQQAppInterface.elems.add((MessageMicro)localObject1);
          }
        }
      }
      else
      {
        return null;
      }
      paramQQAppInterface = null;
    }
  }
  
  private static boolean a(ArrayList<MessageRecord> paramArrayList, msg_comm.Msg paramMsg)
  {
    return (paramMsg.msg_body.has()) && ((((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has()) || (((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has()));
  }
  
  public static byte[] a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    msg_comm.Msg localMsg = new msg_comm.Msg();
    msg_comm.MsgHead localMsgHead = a(paramMessageRecord, paramQQAppInterface.getLongAccountUin());
    try
    {
      paramQQAppInterface = a(paramMessageRecord, paramQQAppInterface);
      if ((localMsgHead == null) || (paramQQAppInterface == null)) {
        return null;
      }
    }
    catch (Throwable paramQQAppInterface)
    {
      for (;;)
      {
        QLog.e("MsgBackup_msgproxy", 1, "transToBackupEntity,getMsgBody error mr = " + paramMessageRecord.getClass().getSimpleName());
        azpo.a(paramQQAppInterface, "MsgBackup_msgproxy,mr = " + paramMessageRecord.getClass().getSimpleName());
        paramQQAppInterface = null;
      }
      if (localMsgHead != null) {
        localMsg.msg_head.set(localMsgHead);
      }
      if (paramQQAppInterface != null) {
        localMsg.msg_body.set(paramQQAppInterface);
      }
    }
    return localMsg.toByteArray();
  }
  
  public static long b(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong3 == paramLong2) {
      return paramLong1;
    }
    return paramLong3;
  }
  
  public MessageRecord a(@NonNull MsgBackupMsgEntity paramMsgBackupMsgEntity)
  {
    msg_comm.Msg localMsg = new msg_comm.Msg();
    long l5;
    int i1;
    Object localObject4;
    Object localObject5;
    long l1;
    int i;
    label436:
    label461:
    int k;
    int j;
    label523:
    int n;
    label678:
    label714:
    label1239:
    Object localObject3;
    for (;;)
    {
      MessageHandler localMessageHandler;
      long l3;
      try
      {
        if (paramMsgBackupMsgEntity.extensionData == null)
        {
          if (!QLog.isColorLevel()) {
            break label1542;
          }
          QLog.d("MsgBackup_msgproxy", 2, "transToMessageRecord, extensionData is null");
          break label1542;
        }
        localMsg.mergeFrom(paramMsgBackupMsgEntity.extensionData);
        if ((!localMsg.msg_body.has()) || ((!((im_msg_body.MsgBody)localMsg.msg_body.get()).rich_text.has()) && (!((im_msg_body.MsgBody)localMsg.msg_body.get()).msg_content.has())))
        {
          if (!QLog.isColorLevel()) {
            break label1544;
          }
          QLog.d("MsgBackup_msgproxy", 2, "transToMessageRecord, no msg_body or rich_text, msg_body.has():" + localMsg.msg_body.has());
          break label1544;
        }
        localObject2 = (msg_comm.MsgHead)localMsg.msg_head.get();
        long l4 = ((msg_comm.MsgHead)localObject2).from_uin.get();
        l5 = ((msg_comm.MsgHead)localObject2).to_uin.get();
        long l6 = ((msg_comm.MsgHead)localObject2).msg_seq.get();
        long l7 = ((msg_comm.MsgHead)localObject2).msg_time.get();
        long l8 = ((msg_comm.MsgHead)localObject2).msg_uid.get();
        i1 = ((msg_comm.MsgHead)localObject2).msg_type.get();
        boolean bool = ((msg_comm.MsgHead)localObject2).is_src_msg.get();
        localObject4 = new bbpd();
        ((bbpd)localObject4).jdField_a_of_type_Int = aujq.c(paramMsgBackupMsgEntity.chatType);
        localMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        localObject5 = azad.a(localMessageHandler, localMsg, String.valueOf(l5), String.valueOf(l4));
        if (((Long)((Pair)localObject5).first).longValue() != 4294967295L)
        {
          l1 = ((Long)((Pair)localObject5).first).longValue();
          break label1546;
          localObject5 = new ArrayList();
          if (((!azah.c(i1)) && (i1 != 208) && (i1 != 529)) || (!((msg_comm.MsgHead)localObject2).c2c_cmd.has())) {
            break label809;
          }
          l3 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin(), l4, l5);
          i = ((msg_comm.MsgHead)localObject2).c2c_cmd.get();
          if ((i1 != 529) || (i != 4)) {
            break label1561;
          }
          l1 = System.currentTimeMillis();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a((ArrayList)localObject5, ((im_msg_body.MsgBody)localMsg.msg_body.get()).msg_content.get());
          jdField_a_of_type_Long += System.currentTimeMillis() - l1;
          l1 = l3;
          if (i1 == 208)
          {
            azad.a(localMessageHandler, (List)localObject5, localMsg);
            l1 = l3;
          }
          int m = 0;
          int i2 = azad.a(localMsg);
          if (!localMsg.content_head.has()) {
            break label1525;
          }
          localObject2 = (msg_comm.ContentHead)localMsg.content_head.get();
          k = ((msg_comm.ContentHead)localObject2).div_seq.get();
          j = ((msg_comm.ContentHead)localObject2).pkg_num.get();
          i = ((msg_comm.ContentHead)localObject2).pkg_index.get();
          localObject2 = ((ArrayList)localObject5).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject4 = (MessageRecord)((Iterator)localObject2).next();
          ((MessageRecord)localObject4).isReplySource = bool;
          ((MessageRecord)localObject4).time = l7;
          ((MessageRecord)localObject4).shmsgseq = l6;
          ((MessageRecord)localObject4).msgUid = l8;
          ((MessageRecord)localObject4).selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          ((MessageRecord)localObject4).senderuin = String.valueOf(l4);
          ((MessageRecord)localObject4).frienduin = String.valueOf(l1);
          ((MessageRecord)localObject4).vipBubbleDiyTextId = i2;
          Object localObject1;
          ((MessageRecord)localObject4).vipBubbleID = amca.a((int)localObject1, i2);
          ((MessageRecord)localObject4).isread = true;
          if (j > 1)
          {
            ((MessageRecord)localObject4).longMsgCount = j;
            ((MessageRecord)localObject4).longMsgId = k;
            ((MessageRecord)localObject4).longMsgIndex = i;
          }
          if (l4 != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) {
            break label1607;
          }
          n = 2;
          ((MessageRecord)localObject4).issend = n;
          if ((i1 != 82) && (i1 != 43)) {
            break label1613;
          }
          ((MessageRecord)localObject4).istroop = 1;
          ((MessageRecord)localObject4).shmsgseq = paramMsgBackupMsgEntity.msgSeq;
          if ((((MessageRecord)localObject4).msgData == null) && (((MessageRecord)localObject4).msg != null)) {
            ((MessageRecord)localObject4).msgData = ((MessageRecord)localObject4).msg.getBytes();
          }
          ((MessageRecord)localObject4).msgBackupMsgSeq = paramMsgBackupMsgEntity.msgSeq;
          ((MessageRecord)localObject4).msgBackupMsgRandom = paramMsgBackupMsgEntity.msgRandom;
          m += 1;
          continue;
        }
        l1 = ((Long)((Pair)localObject5).second).longValue();
      }
      catch (InvalidProtocolBufferMicroException paramMsgBackupMsgEntity)
      {
        label786:
        paramMsgBackupMsgEntity.printStackTrace();
        return null;
      }
      azad.a(localMessageHandler, (List)localObject5, localMsg, true, false, (bbpd)localObject4);
      continue;
      label809:
      if (((i1 != 82) && (i1 != 43)) || (!((msg_comm.MsgHead)localObject2).group_info.has())) {
        break label1588;
      }
      l1 = ((msg_comm.MsgHead)localObject2).group_info.group_code.get();
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a((ArrayList)localObject5, localMsg)) {
        azad.a(localMessageHandler, (List)localObject5, localMsg, false, false, (bbpd)localObject4);
      }
      Object localObject2 = (im_msg_body.MsgBody)localMsg.msg_body.get();
      if (!((im_msg_body.MsgBody)localObject2).rich_text.has()) {
        break label1585;
      }
      im_msg_body.RichText localRichText = (im_msg_body.RichText)((im_msg_body.MsgBody)localObject2).rich_text.get();
      if (localRichText.elems.has())
      {
        localObject2 = localRichText.elems.get();
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (im_msg_body.Elem)((Iterator)localObject2).next();
            if (((im_msg_body.Elem)localObject4).anon_group_msg.has())
            {
              localObject4 = (im_msg_body.AnonymousGroupMsg)((im_msg_body.Elem)localObject4).anon_group_msg.get();
              i = ((im_msg_body.AnonymousGroupMsg)localObject4).uint32_flags.get();
              localObject2 = ((im_msg_body.AnonymousGroupMsg)localObject4).str_anon_id.get().toByteArray();
              byte[] arrayOfByte = ((im_msg_body.AnonymousGroupMsg)localObject4).str_anon_nick.get().toByteArray();
              j = ((im_msg_body.AnonymousGroupMsg)localObject4).uint32_head_portrait.get();
              k = ((im_msg_body.AnonymousGroupMsg)localObject4).uint32_expire_time.get();
              String str = ((im_msg_body.AnonymousGroupMsg)localObject4).str_rank_color.get().toStringUtf8();
              if (localObject2 == null) {
                break label1577;
              }
              for (;;)
              {
                try
                {
                  localObject2 = new String((byte[])localObject2, "ISO-8859-1");
                  label1084:
                  Iterator localIterator = ((ArrayList)localObject5).iterator();
                  if (!localIterator.hasNext()) {
                    break;
                  }
                  MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
                  if (arrayOfByte == null)
                  {
                    localObject4 = "";
                    localMessageRecord.saveExtInfoToExtStr("anonymous", nav.a(i, (String)localObject2, (String)localObject4, j, k, str));
                    localMessageRecord.extLong |= 0x3;
                  }
                  else
                  {
                    localObject4 = new String(arrayOfByte);
                  }
                }
                catch (UnsupportedEncodingException localUnsupportedEncodingException)
                {
                  localUnsupportedEncodingException.printStackTrace();
                }
              }
              if (QLog.isColorLevel()) {
                QLog.d("anonymous_decode", 2, "anonymous_flags has = " + i);
              }
            }
          }
        }
      }
      if (!localRichText.ptt.has()) {
        break label1585;
      }
      azad.a(localMessageHandler, localMsg, (List)localObject5);
      break label1585;
      if (localUnsupportedEncodingException.discuss_info.has())
      {
        l3 = localUnsupportedEncodingException.discuss_info.discuss_uin.get();
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b((ArrayList)localObject5, localMsg)) {
          azad.a(localMessageHandler, (List)localObject5, localMsg, false, false, (bbpd)localObject4);
        }
        localObject3 = (im_msg_body.MsgBody)localMsg.msg_body.get();
        l1 = l3;
        if (((im_msg_body.MsgBody)localObject3).rich_text.has())
        {
          l1 = l3;
          if (((im_msg_body.RichText)((im_msg_body.MsgBody)localObject3).rich_text.get()).ptt.has())
          {
            azad.a(localMessageHandler, localMsg, (List)localObject5);
            l1 = l3;
          }
        }
      }
      else
      {
        label1364:
        if (!QLog.isColorLevel()) {
          break label1605;
        }
        QLog.d("MsgBackup_msgproxy", 2, "unpackPbToMultiMsgWithNest, illegal msgType:" + i1);
        break label1605;
      }
    }
    label1542:
    label1544:
    label1546:
    label1561:
    label1577:
    label1585:
    label1588:
    label1605:
    label1607:
    label1613:
    for (;;)
    {
      label1400:
      ((MessageRecord)localObject4).istroop = 3000;
      ((MessageRecord)localObject4).shmsgseq = paramMsgBackupMsgEntity.msgSeq;
      break label714;
      label1525:
      do
      {
        if (alof.z.equals(Long.valueOf(l5))) {
          ((MessageRecord)localObject4).istroop = 6000;
        }
        for (;;)
        {
          ((MessageRecord)localObject4).msgseq = paramMsgBackupMsgEntity.msgSeq;
          break;
          if (alof.A.equals(Long.valueOf(l5))) {
            ((MessageRecord)localObject4).istroop = 6003;
          } else {
            ((MessageRecord)localObject4).istroop = 0;
          }
        }
        alww.a((List)localObject5);
        if (((ArrayList)localObject5).size() > 0) {
          return (MessageRecord)((ArrayList)localObject5).get(0);
        }
        aujq.a("MsgBackup_msgproxy", "transToMessageRecord failed.........", new Object[0]);
        return null;
        i = 0;
        k = 0;
        j = 0;
        break label523;
        do
        {
          l2 = l1;
          break;
          return null;
          return null;
        } while (l1 != -1L);
        long l2 = 0L;
        break;
        if (i == 175) {
          break label786;
        }
        if (i != 11) {
          break label436;
        }
        break label786;
        localObject3 = "";
        break label1084;
        break label461;
        if (i1 == 83) {
          break label1239;
        }
        if (i1 != 42) {
          break label1364;
        }
        break label1239;
        return null;
        n = 0;
        break label678;
        if (i1 == 83) {
          break label1400;
        }
      } while (i1 != 42);
    }
  }
  
  public MsgBackupMsgEntity a(@NonNull MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    if ((paramMessageRecord.istroop == 1) && (paramMessageRecord.shmsgseq == 0L)) {
      QLog.e("MsgBackup_msgproxy", 1, "troopMsg msgshseq = 0,mr  == " + paramMessageRecord.toString());
    }
    msg_comm.Msg localMsg = new msg_comm.Msg();
    Object localObject1;
    if (paramMessageRecord.isLongMsg())
    {
      localObject1 = new msg_comm.ContentHead();
      ((msg_comm.ContentHead)localObject1).pkg_num.set(paramMessageRecord.longMsgCount);
      ((msg_comm.ContentHead)localObject1).div_seq.set(paramMessageRecord.longMsgId);
      ((msg_comm.ContentHead)localObject1).pkg_index.set(paramMessageRecord.longMsgIndex);
      localMsg.content_head.set((MessageMicro)localObject1);
    }
    msg_comm.MsgHead localMsgHead = a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
    Object localObject2;
    try
    {
      localObject1 = a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((localMsgHead == null) || (localObject1 == null))
      {
        aujq.a("transBackupEntity error,mr = %s ", paramMessageRecord.toString(), new Object[0]);
        return null;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("MsgBackup_msgproxy", 1, "transToBackupEntity,getMsgBody error mr = " + paramMessageRecord.getClass().getSimpleName());
        azpo.a(localThrowable, "MsgBackup_msgproxy,mr = " + paramMessageRecord.getClass().getSimpleName());
        localObject2 = null;
      }
      localMsg.msg_head.set(localMsgHead);
      localMsg.msg_body.set((MessageMicro)localObject2);
      localObject2 = new MsgBackupMsgEntity();
      ((MsgBackupMsgEntity)localObject2).chatUin = paramMessageRecord.frienduin;
      ((MsgBackupMsgEntity)localObject2).chatType = aujq.b(paramMessageRecord.istroop);
      ((MsgBackupMsgEntity)localObject2).msgType = aujq.a(paramMessageRecord.msgtype);
      ((MsgBackupMsgEntity)localObject2).msgTime = paramMessageRecord.time;
      ((MsgBackupMsgEntity)localObject2).msgSeq = paramMessageRecord.msgseq;
      if (paramMessageRecord.istroop == 1) {
        break label324;
      }
    }
    label324:
    int i;
    if (paramMessageRecord.istroop == 3000)
    {
      ((MsgBackupMsgEntity)localObject2).msgSeq = paramMessageRecord.shmsgseq;
      if (!aujq.d) {
        break label413;
      }
      i = localMsg.getSerializedSize();
      paramMessageRecord = augt.a(i);
      if (paramMessageRecord != null) {
        break label402;
      }
      paramMessageRecord = localMsg.toByteArray();
      augt.a(paramMessageRecord);
    }
    label363:
    for (((MsgBackupMsgEntity)localObject2).extensionData = paramMessageRecord;; ((MsgBackupMsgEntity)localObject2).extensionData = localMsg.toByteArray())
    {
      return localObject2;
      i = azah.b(paramMessageRecord.msgUid);
      ((MsgBackupMsgEntity)localObject2).msgSeq = (0xFFFF & (short)(int)paramMessageRecord.shmsgseq);
      ((MsgBackupMsgEntity)localObject2).msgRandom = i;
      break;
      localMsg.toByteArray(paramMessageRecord, 0, i);
      break label363;
    }
  }
  
  protected void a() {}
  
  protected void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auhe
 * JD-Core Version:    0.7.0.1
 */