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

public class awoh
  extends aomz
{
  public static long a;
  
  public awoh(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
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
        break label1266;
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
      break label1268;
      localArrayList = new ArrayList();
      if (((!bbzj.c(k)) && (k != 208) && (k != 529)) || (!paramArrayOfByte.c2c_cmd.has())) {
        break label562;
      }
      i = paramArrayOfByte.c2c_cmd.get();
      if ((k != 529) || (i != 4)) {
        break label1297;
      }
      if (a(localArrayList, localMsg)) {
        paramQQAppInterface.a().a().a(localArrayList, ((im_msg_body.MsgBody)localMsg.msg_body.get()).msg_content.get());
      }
    }
    label273:
    label311:
    label326:
    int j;
    for (;;)
    {
      if ((k == 208) && (a(localArrayList, localMsg)))
      {
        new bbzy().a(localMessageHandler, localMsg, localArrayList, null);
        break label1283;
        int m = bbzf.a(localMsg);
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
          ((MessageRecord)localObject2).vipBubbleID = anuk.a((int)localObject1, m);
          ((MessageRecord)localObject2).isread = true;
          if (l4 != paramQQAppInterface.getLongAccountUin()) {
            break label1345;
          }
          j = 1;
          label434:
          ((MessageRecord)localObject2).issend = j;
          if ((k != 82) && (k != 43)) {
            break label1350;
          }
          ((MessageRecord)localObject2).istroop = 1;
          label460:
          if (((MessageRecord)localObject2).senderuin.equals(((MessageRecord)localObject2).selfuin)) {
            ((MessageRecord)localObject2).issend = 1;
          }
          if ((((MessageRecord)localObject2).msgData != null) || (((MessageRecord)localObject2).msg == null)) {
            break label1290;
          }
          ((MessageRecord)localObject2).msgData = ((MessageRecord)localObject2).msg.getBytes();
          break label1290;
          l1 = ((Long)((Pair)localObject2).second).longValue();
          break label1268;
          label530:
          if (!a(localArrayList, localMsg)) {
            break label1311;
          }
          bbzf.a(localMessageHandler, localArrayList, localMsg, true, false, null);
          continue;
          label562:
          if (((k != 82) && (k != 43)) || (!paramArrayOfByte.group_info.has())) {
            break label1323;
          }
          l1 = paramArrayOfByte.group_info.group_code.get();
          if (!a(localArrayList, localMsg)) {
            break label1256;
          }
          if (!paramQQAppInterface.a().a().a(localArrayList, localMsg)) {
            bbzf.a(localMessageHandler, localArrayList, localMsg, false, false, null);
          }
          paramArrayOfByte = (im_msg_body.MsgBody)localMsg.msg_body.get();
          if (!paramArrayOfByte.rich_text.has()) {
            break label1320;
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
                    break label1313;
                  }
                  for (;;)
                  {
                    try
                    {
                      paramArrayOfByte = new String(paramArrayOfByte, "ISO-8859-1");
                      label828:
                      Iterator localIterator = localArrayList.iterator();
                      if (!localIterator.hasNext()) {
                        break;
                      }
                      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
                      if (arrayOfByte == null)
                      {
                        localObject2 = "";
                        localMessageRecord.saveExtInfoToExtStr("anonymous", njo.a(i, paramArrayOfByte, (String)localObject2, j, m, str));
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
            break label1320;
          }
          new bbzt().a(localMessageHandler, localMsg, localArrayList, null);
          break label1320;
          label988:
          if (paramArrayOfByte.discuss_info.has())
          {
            l1 = paramArrayOfByte.discuss_info.discuss_uin.get();
            if (!a(localArrayList, localMsg)) {
              break label1253;
            }
            if (!paramQQAppInterface.a().a().b(localArrayList, localMsg)) {
              bbzf.a(localMessageHandler, localArrayList, localMsg, false, false, null);
            }
            paramArrayOfByte = (im_msg_body.MsgBody)localMsg.msg_body.get();
            if ((!paramArrayOfByte.rich_text.has()) || (!((im_msg_body.RichText)paramArrayOfByte.rich_text.get()).ptt.has())) {
              break label1340;
            }
            new bbzt().a(localMessageHandler, localMsg, localArrayList, null);
            break label1340;
          }
          label1110:
          if (!QLog.isColorLevel()) {
            break label1343;
          }
          QLog.d("MsgBackup_msgproxy", 2, "unpackPbToMultiMsgWithNest, illegal msgType:" + k);
          break label1343;
        }
      }
    }
    label1283:
    label1290:
    label1297:
    label1311:
    label1313:
    label1320:
    label1323:
    label1340:
    label1343:
    label1345:
    label1350:
    for (;;)
    {
      label1146:
      ((MessageRecord)localObject2).istroop = 3000;
      break label460;
      label1253:
      label1256:
      label1266:
      label1268:
      do
      {
        if (anhk.z.equals(Long.valueOf(l3)))
        {
          ((MessageRecord)localObject2).istroop = 6000;
          break label460;
        }
        if (anhk.A.equals(Long.valueOf(l3)))
        {
          ((MessageRecord)localObject2).istroop = 6003;
          break label460;
        }
        ((MessageRecord)localObject2).istroop = 0;
        break label460;
        anqc.a(localArrayList);
        if (localArrayList.size() > 0) {
          return (MessageRecord)localArrayList.get(0);
        }
        awqu.a("MsgBackup_msgproxy", "transToMessageRecord failed.........", new Object[0]);
        return null;
        break label311;
        break label311;
        do
        {
          l2 = l1;
          break;
          return null;
        } while (l1 != -1L);
        long l2 = 0L;
        break;
        l1 = l3;
        break label311;
        i += 1;
        break label326;
        if (i == 175) {
          break label530;
        }
        if (i != 11) {
          break label273;
        }
        break label530;
        break label273;
        paramArrayOfByte = "";
        break label828;
        break label311;
        if (k == 83) {
          break label988;
        }
        if (k != 42) {
          break label1110;
        }
        break label988;
        break label311;
        return null;
        j = 0;
        break label434;
        if (k == 83) {
          break label1146;
        }
      } while (k != 42);
    }
  }
  
  public static msg_comm.MsgHead a(MessageRecord paramMessageRecord, long paramLong)
  {
    msg_comm.MsgHead localMsgHead = new msg_comm.MsgHead();
    Object localObject = acwh.c(paramMessageRecord);
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
        paramQQAppInterface = bbzf.a(paramMessageRecord);
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
        if (njo.a(paramMessageRecord))
        {
          localObject1 = new im_msg_body.Elem();
          localObject2 = new im_msg_body.AnonymousGroupMsg();
          njp localnjp = njo.a(paramMessageRecord);
          ((im_msg_body.AnonymousGroupMsg)localObject2).uint32_flags.set(localnjp.jdField_a_of_type_Int);
          if (!TextUtils.isEmpty(localnjp.jdField_a_of_type_JavaLangString)) {
            ((im_msg_body.AnonymousGroupMsg)localObject2).str_anon_id.set(ByteStringMicro.copyFrom(localnjp.jdField_a_of_type_JavaLangString.getBytes()));
          }
          if (!TextUtils.isEmpty(localnjp.jdField_b_of_type_JavaLangString)) {
            ((im_msg_body.AnonymousGroupMsg)localObject2).str_anon_nick.set(ByteStringMicro.copyFrom(localnjp.jdField_b_of_type_JavaLangString.getBytes()));
          }
          ((im_msg_body.AnonymousGroupMsg)localObject2).uint32_head_portrait.set(localnjp.jdField_b_of_type_Int);
          ((im_msg_body.AnonymousGroupMsg)localObject2).uint32_expire_time.set(localnjp.jdField_c_of_type_Int);
          if (!TextUtils.isEmpty(localnjp.jdField_c_of_type_JavaLangString)) {
            ((im_msg_body.AnonymousGroupMsg)localObject2).str_rank_color.set(ByteStringMicro.copyFrom(localnjp.jdField_c_of_type_JavaLangString.getBytes()));
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
        paramQQAppInterface = bbzf.a((MessageForText)paramMessageRecord);
        continue;
        if (paramMessageRecord.msgtype == -1049)
        {
          paramQQAppInterface = bbzf.a((MessageForReplyText)paramMessageRecord);
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
          paramQQAppInterface = bbzf.a((MessageForQQStoryComment)paramMessageRecord);
          continue;
        }
        if (paramMessageRecord.msgtype == -2000)
        {
          paramQQAppInterface = bbzf.a((MessageForPic)paramMessageRecord);
          continue;
        }
        if (paramMessageRecord.msgtype == -5008)
        {
          paramQQAppInterface = bbzf.a((MessageForArkApp)paramMessageRecord, true);
          continue;
        }
        if (paramMessageRecord.msgtype == -5016)
        {
          paramQQAppInterface = bbzf.c((MessageForArkBabyqReply)paramMessageRecord, true);
          continue;
        }
        if (paramMessageRecord.msgtype == -5017)
        {
          paramQQAppInterface = bbzf.b((MessageForArkApp)paramMessageRecord, true);
          continue;
        }
        if (paramMessageRecord.msgtype == -5013)
        {
          paramQQAppInterface = bbzf.c((MessageForArkFlashChat)paramMessageRecord);
          continue;
        }
        if (paramMessageRecord.msgtype == -5014)
        {
          paramQQAppInterface = bbzf.d((MessageForHiBoom)paramMessageRecord);
          continue;
        }
        if (paramMessageRecord.msgtype == -2011)
        {
          paramQQAppInterface = bbzf.a((MessageForStructing)paramMessageRecord);
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
              localObject1 = bbzf.a((MessageForText)localObject1);
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
          paramQQAppInterface = bbzf.a((MessageForLongTextMsg)paramMessageRecord, false);
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
            paramQQAppInterface = bbzf.a((MessageForMarketFace)paramMessageRecord);
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
        bcrp.a(paramQQAppInterface, "MsgBackup_msgproxy,mr = " + paramMessageRecord.getClass().getSimpleName());
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
    long l4;
    int i1;
    Object localObject3;
    ArrayList localArrayList;
    int i;
    label435:
    int k;
    int j;
    label497:
    int n;
    label652:
    label688:
    label744:
    Object localObject2;
    for (;;)
    {
      MessageHandler localMessageHandler;
      try
      {
        if (paramMsgBackupMsgEntity.extensionData == null)
        {
          if (!QLog.isColorLevel()) {
            break label1509;
          }
          QLog.d("MsgBackup_msgproxy", 2, "transToMessageRecord, extensionData is null");
          break label1509;
        }
        localMsg.mergeFrom(paramMsgBackupMsgEntity.extensionData);
        if ((!localMsg.msg_body.has()) || ((!((im_msg_body.MsgBody)localMsg.msg_body.get()).rich_text.has()) && (!((im_msg_body.MsgBody)localMsg.msg_body.get()).msg_content.has())))
        {
          if (!QLog.isColorLevel()) {
            break label1511;
          }
          QLog.d("MsgBackup_msgproxy", 2, "transToMessageRecord, no msg_body or rich_text, msg_body.has():" + localMsg.msg_body.has());
          break label1511;
        }
        localObject1 = (msg_comm.MsgHead)localMsg.msg_head.get();
        long l3 = ((msg_comm.MsgHead)localObject1).from_uin.get();
        l4 = ((msg_comm.MsgHead)localObject1).to_uin.get();
        long l5 = ((msg_comm.MsgHead)localObject1).msg_seq.get();
        long l6 = ((msg_comm.MsgHead)localObject1).msg_time.get();
        long l7 = ((msg_comm.MsgHead)localObject1).msg_uid.get();
        i1 = ((msg_comm.MsgHead)localObject1).msg_type.get();
        boolean bool = ((msg_comm.MsgHead)localObject1).is_src_msg.get();
        localObject3 = new bepr();
        ((bepr)localObject3).jdField_a_of_type_Int = awqu.c(paramMsgBackupMsgEntity.chatType);
        localMessageHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        long l8 = bbzf.a(localMessageHandler, localMsg, String.valueOf(l4), String.valueOf(l3));
        localArrayList = new ArrayList();
        if (((bbzj.c(i1)) || (i1 == 208) || (i1 == 529)) && (((msg_comm.MsgHead)localObject1).c2c_cmd.has()))
        {
          l2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin(), l3, l4);
          i = ((msg_comm.MsgHead)localObject1).c2c_cmd.get();
          if ((i1 != 529) || (i != 4)) {
            break label1513;
          }
          l1 = System.currentTimeMillis();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(localArrayList, ((im_msg_body.MsgBody)localMsg.msg_body.get()).msg_content.get());
          jdField_a_of_type_Long += System.currentTimeMillis() - l1;
          l1 = l2;
          if (i1 == 208)
          {
            new bbzy().a(localMessageHandler, localMsg, localArrayList, null);
            l1 = l2;
          }
          int m = 0;
          int i2 = bbzf.a(localMsg);
          if (!localMsg.content_head.has()) {
            break label1499;
          }
          localObject1 = (msg_comm.ContentHead)localMsg.content_head.get();
          k = ((msg_comm.ContentHead)localObject1).div_seq.get();
          j = ((msg_comm.ContentHead)localObject1).pkg_num.get();
          i = ((msg_comm.ContentHead)localObject1).pkg_index.get();
          localObject1 = localArrayList.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label1462;
          }
          localObject3 = (MessageRecord)((Iterator)localObject1).next();
          ((MessageRecord)localObject3).isReplySource = bool;
          ((MessageRecord)localObject3).time = l6;
          ((MessageRecord)localObject3).shmsgseq = l5;
          ((MessageRecord)localObject3).msgUid = l7;
          ((MessageRecord)localObject3).selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          ((MessageRecord)localObject3).senderuin = String.valueOf(l3);
          ((MessageRecord)localObject3).frienduin = String.valueOf(l1);
          ((MessageRecord)localObject3).vipBubbleDiyTextId = i2;
          ((MessageRecord)localObject3).vipBubbleID = anuk.a((int)l8, i2);
          ((MessageRecord)localObject3).isread = true;
          if (j > 1)
          {
            ((MessageRecord)localObject3).longMsgCount = j;
            ((MessageRecord)localObject3).longMsgId = k;
            ((MessageRecord)localObject3).longMsgIndex = i;
          }
          if (l3 != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) {
            break label1559;
          }
          n = 2;
          ((MessageRecord)localObject3).issend = n;
          if ((i1 != 82) && (i1 != 43)) {
            break label1565;
          }
          ((MessageRecord)localObject3).istroop = 1;
          ((MessageRecord)localObject3).shmsgseq = paramMsgBackupMsgEntity.msgSeq;
          if ((((MessageRecord)localObject3).msgData == null) && (((MessageRecord)localObject3).msg != null)) {
            ((MessageRecord)localObject3).msgData = ((MessageRecord)localObject3).msg.getBytes();
          }
          ((MessageRecord)localObject3).msgBackupMsgSeq = paramMsgBackupMsgEntity.msgSeq;
          ((MessageRecord)localObject3).msgBackupMsgRandom = paramMsgBackupMsgEntity.msgRandom;
          m += 1;
          continue;
          bbzf.a(localMessageHandler, localArrayList, localMsg, true, false, (bepr)localObject3);
          continue;
        }
        if (i1 == 82) {}
      }
      catch (InvalidProtocolBufferMicroException paramMsgBackupMsgEntity)
      {
        paramMsgBackupMsgEntity.printStackTrace();
        return null;
      }
      if ((i1 != 43) || (!((msg_comm.MsgHead)localObject1).group_info.has())) {
        break label1540;
      }
      long l1 = ((msg_comm.MsgHead)localObject1).group_info.group_code.get();
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(localArrayList, localMsg)) {
        bbzf.a(localMessageHandler, localArrayList, localMsg, false, false, (bepr)localObject3);
      }
      Object localObject1 = (im_msg_body.MsgBody)localMsg.msg_body.get();
      if (!((im_msg_body.MsgBody)localObject1).rich_text.has()) {
        break label1537;
      }
      im_msg_body.RichText localRichText = (im_msg_body.RichText)((im_msg_body.MsgBody)localObject1).rich_text.get();
      if (localRichText.elems.has())
      {
        localObject1 = localRichText.elems.get();
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (im_msg_body.Elem)((Iterator)localObject1).next();
            if (((im_msg_body.Elem)localObject3).anon_group_msg.has())
            {
              localObject3 = (im_msg_body.AnonymousGroupMsg)((im_msg_body.Elem)localObject3).anon_group_msg.get();
              i = ((im_msg_body.AnonymousGroupMsg)localObject3).uint32_flags.get();
              localObject1 = ((im_msg_body.AnonymousGroupMsg)localObject3).str_anon_id.get().toByteArray();
              byte[] arrayOfByte = ((im_msg_body.AnonymousGroupMsg)localObject3).str_anon_nick.get().toByteArray();
              j = ((im_msg_body.AnonymousGroupMsg)localObject3).uint32_head_portrait.get();
              k = ((im_msg_body.AnonymousGroupMsg)localObject3).uint32_expire_time.get();
              String str = ((im_msg_body.AnonymousGroupMsg)localObject3).str_rank_color.get().toStringUtf8();
              if (localObject1 == null) {
                break label1529;
              }
              for (;;)
              {
                try
                {
                  localObject1 = new String((byte[])localObject1, "ISO-8859-1");
                  label1042:
                  Iterator localIterator = localArrayList.iterator();
                  if (!localIterator.hasNext()) {
                    break;
                  }
                  MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
                  if (arrayOfByte == null)
                  {
                    localObject3 = "";
                    localMessageRecord.saveExtInfoToExtStr("anonymous", njo.a(i, (String)localObject1, (String)localObject3, j, k, str));
                    localMessageRecord.extLong |= 0x3;
                  }
                  else
                  {
                    localObject3 = new String(arrayOfByte);
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
        break label1537;
      }
      new bbzt().a(localMessageHandler, localMsg, localArrayList, null);
      break label1537;
      label1205:
      if (!localUnsupportedEncodingException.discuss_info.has()) {
        break;
      }
      long l2 = localUnsupportedEncodingException.discuss_info.discuss_uin.get();
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b(localArrayList, localMsg)) {
        bbzf.a(localMessageHandler, localArrayList, localMsg, false, false, (bepr)localObject3);
      }
      localObject2 = (im_msg_body.MsgBody)localMsg.msg_body.get();
      l1 = l2;
      if (((im_msg_body.MsgBody)localObject2).rich_text.has())
      {
        l1 = l2;
        if (((im_msg_body.RichText)((im_msg_body.MsgBody)localObject2).rich_text.get()).ptt.has())
        {
          new bbzt().a(localMessageHandler, localMsg, localArrayList, null);
          l1 = l2;
        }
      }
    }
    label1338:
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_msgproxy", 2, "unpackPbToMultiMsgWithNest, illegal msgType:" + i1);
    }
    label1537:
    label1540:
    label1559:
    label1565:
    for (;;)
    {
      label1374:
      ((MessageRecord)localObject3).istroop = 3000;
      ((MessageRecord)localObject3).shmsgseq = paramMsgBackupMsgEntity.msgSeq;
      break label688;
      label1462:
      label1499:
      label1509:
      label1511:
      label1513:
      label1529:
      do
      {
        if (anhk.z.equals(Long.valueOf(l4))) {
          ((MessageRecord)localObject3).istroop = 6000;
        }
        for (;;)
        {
          ((MessageRecord)localObject3).msgseq = paramMsgBackupMsgEntity.msgSeq;
          break;
          if (anhk.A.equals(Long.valueOf(l4))) {
            ((MessageRecord)localObject3).istroop = 6003;
          } else {
            ((MessageRecord)localObject3).istroop = 0;
          }
        }
        anqc.a(localArrayList);
        if (localArrayList.size() > 0) {
          return (MessageRecord)localArrayList.get(0);
        }
        awqu.a("MsgBackup_msgproxy", "transToMessageRecord failed.........", new Object[0]);
        return null;
        i = 0;
        k = 0;
        j = 0;
        break label497;
        return null;
        return null;
        if (i == 175) {
          break label744;
        }
        if (i != 11) {
          break;
        }
        break label744;
        localObject2 = "";
        break label1042;
        break label435;
        if (i1 == 83) {
          break label1205;
        }
        if (i1 != 42) {
          break label1338;
        }
        break label1205;
        return null;
        n = 0;
        break label652;
        if (i1 == 83) {
          break label1374;
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
        awqu.a("transBackupEntity error,mr = %s ", paramMessageRecord.toString(), new Object[0]);
        return null;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("MsgBackup_msgproxy", 1, "transToBackupEntity,getMsgBody error mr = " + paramMessageRecord.getClass().getSimpleName());
        bcrp.a(localThrowable, "MsgBackup_msgproxy,mr = " + paramMessageRecord.getClass().getSimpleName());
        localObject2 = null;
      }
      localMsg.msg_head.set(localMsgHead);
      localMsg.msg_body.set((MessageMicro)localObject2);
      localObject2 = new MsgBackupMsgEntity();
      ((MsgBackupMsgEntity)localObject2).chatUin = paramMessageRecord.frienduin;
      ((MsgBackupMsgEntity)localObject2).chatType = awqu.b(paramMessageRecord.istroop);
      ((MsgBackupMsgEntity)localObject2).msgType = awqu.a(paramMessageRecord.msgtype);
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
      if (!awqu.d) {
        break label413;
      }
      i = localMsg.getSerializedSize();
      paramMessageRecord = awnw.a(i);
      if (paramMessageRecord != null) {
        break label402;
      }
      paramMessageRecord = localMsg.toByteArray();
      awnw.a(paramMessageRecord);
    }
    label363:
    for (((MsgBackupMsgEntity)localObject2).extensionData = paramMessageRecord;; ((MsgBackupMsgEntity)localObject2).extensionData = localMsg.toByteArray())
    {
      return localObject2;
      i = bbzj.b(paramMessageRecord.msgUid);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awoh
 * JD-Core Version:    0.7.0.1
 */