import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
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

public class avug
  extends anus
{
  public static long a;
  
  public avug(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
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
  
  public static MessageRecord a(@NonNull QQAppInterface paramQQAppInterface, @NonNull byte[] paramArrayOfByte)
  {
    Object localObject1 = new msg_comm.Msg();
    for (;;)
    {
      Object localObject2;
      long l4;
      long l5;
      int i1;
      long l2;
      long l1;
      int k;
      int j;
      int i;
      label341:
      int n;
      try
      {
        ((msg_comm.Msg)localObject1).mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_msgproxy", 2, "transToMessageRecord, no msg_body or rich_text, msg_body.has():" + ((msg_comm.Msg)localObject1).msg_body.has());
        }
        localObject2 = (msg_comm.MsgHead)((msg_comm.Msg)localObject1).msg_head.get();
        long l3 = ((msg_comm.MsgHead)localObject2).from_uin.get();
        l4 = ((msg_comm.MsgHead)localObject2).to_uin.get();
        l5 = ((msg_comm.MsgHead)localObject2).msg_seq.get();
        long l6 = ((msg_comm.MsgHead)localObject2).msg_time.get();
        long l7 = ((msg_comm.MsgHead)localObject2).msg_uid.get();
        i1 = ((msg_comm.MsgHead)localObject2).msg_type.get();
        boolean bool = ((msg_comm.MsgHead)localObject2).is_src_msg.get();
        bdyi localbdyi = new bdyi();
        l2 = 0L;
        MessageHandler localMessageHandler = paramQQAppInterface.getMsgHandler();
        long l8 = bblf.a(localMessageHandler, (msg_comm.Msg)localObject1, String.valueOf(l4), String.valueOf(l3));
        paramArrayOfByte = new ArrayList();
        if (((!bblk.c(i1)) && (i1 != 208) && (i1 != 529)) || (!((msg_comm.MsgHead)localObject2).c2c_cmd.has())) {
          break label803;
        }
        l2 = a(paramQQAppInterface.getLongAccountUin(), l3, l4);
        a(paramQQAppInterface, (msg_comm.Msg)localObject1, localbdyi, (msg_comm.MsgHead)localObject2, i1, localMessageHandler, paramArrayOfByte);
        l1 = l2;
        if (i1 != 208) {
          break label841;
        }
        new bblz().a(localMessageHandler, (msg_comm.Msg)localObject1, paramArrayOfByte, null);
        l1 = l2;
        int m = 0;
        int i2 = bblf.a((msg_comm.Msg)localObject1);
        if (!((msg_comm.Msg)localObject1).content_head.has()) {
          break label793;
        }
        localObject1 = (msg_comm.ContentHead)((msg_comm.Msg)localObject1).content_head.get();
        k = ((msg_comm.ContentHead)localObject1).div_seq.get();
        j = ((msg_comm.ContentHead)localObject1).pkg_num.get();
        i = ((msg_comm.ContentHead)localObject1).pkg_index.get();
        localObject1 = paramArrayOfByte.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label778;
        }
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        ((MessageRecord)localObject2).isReplySource = bool;
        ((MessageRecord)localObject2).time = l6;
        ((MessageRecord)localObject2).shmsgseq = l5;
        ((MessageRecord)localObject2).msgUid = l7;
        ((MessageRecord)localObject2).selfuin = paramQQAppInterface.getCurrentAccountUin();
        ((MessageRecord)localObject2).senderuin = String.valueOf(l3);
        ((MessageRecord)localObject2).frienduin = String.valueOf(l1);
        ((MessageRecord)localObject2).vipBubbleDiyTextId = i2;
        ((MessageRecord)localObject2).vipBubbleID = anaj.a((int)l8, i2);
        ((MessageRecord)localObject2).isread = true;
        if (j > 1)
        {
          ((MessageRecord)localObject2).longMsgCount = j;
          ((MessageRecord)localObject2).longMsgId = k;
          ((MessageRecord)localObject2).longMsgIndex = i;
        }
        if (l3 != paramQQAppInterface.getLongAccountUin()) {
          break label844;
        }
        n = 2;
        label489:
        ((MessageRecord)localObject2).issend = n;
        if ((i1 != 82) && (i1 != 43)) {
          break label850;
        }
        ((MessageRecord)localObject2).istroop = 1;
        ((MessageRecord)localObject2).shmsgseq = l5;
        if ((((MessageRecord)localObject2).msgData == null) && (((MessageRecord)localObject2).msg != null)) {
          ((MessageRecord)localObject2).msgData = ((MessageRecord)localObject2).msg.getBytes();
        }
        ((MessageRecord)localObject2).msgBackupMsgSeq = l5;
        ((MessageRecord)localObject2).msgBackupMsgRandom = bblk.b(l7);
        m += 1;
        continue;
        label579:
        if (!((msg_comm.MsgHead)localObject2).group_info.has()) {
          break label820;
        }
        l1 = ((msg_comm.MsgHead)localObject2).group_info.group_code.get();
        a(paramQQAppInterface, (msg_comm.Msg)localObject1, localMessageHandler, paramArrayOfByte, localbdyi);
        continue;
        label617:
        l1 = l2;
        if (!((msg_comm.MsgHead)localObject2).discuss_info.has()) {
          break label841;
        }
        l1 = ((msg_comm.MsgHead)localObject2).discuss_info.discuss_uin.get();
        a(paramQQAppInterface, (msg_comm.Msg)localObject1, localbdyi, localMessageHandler, paramArrayOfByte);
      }
      catch (Exception paramQQAppInterface)
      {
        label659:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MsgBackup_msgproxy", 2, "transToMessageRecord, error happens :" + paramQQAppInterface);
        return null;
      }
      ((MessageRecord)localObject2).istroop = 3000;
      ((MessageRecord)localObject2).shmsgseq = l5;
      continue;
      label778:
      label793:
      label803:
      label820:
      label841:
      label844:
      label850:
      do
      {
        if (AppConstants.DATALINE_PC_UIN.equals(Long.valueOf(l4))) {
          ((MessageRecord)localObject2).istroop = 6000;
        }
        for (;;)
        {
          ((MessageRecord)localObject2).msgseq = l5;
          break;
          if (AppConstants.DATALINE_IPAD_UIN.equals(Long.valueOf(l4))) {
            ((MessageRecord)localObject2).istroop = 6003;
          } else {
            ((MessageRecord)localObject2).istroop = 0;
          }
        }
        amwh.a(paramArrayOfByte);
        paramQQAppInterface = (MessageRecord)paramArrayOfByte.get(0);
        return paramQQAppInterface;
        i = 0;
        k = 0;
        j = 0;
        break label341;
        if ((i1 == 82) || (i1 == 43)) {
          break label579;
        }
        if (i1 == 83) {
          break label617;
        }
        l1 = l2;
        if (i1 == 42) {
          break label617;
        }
        break;
        n = 0;
        break label489;
        if (i1 == 83) {
          break label659;
        }
      } while (i1 != 42);
    }
  }
  
  public static msg_comm.MsgHead a(MessageRecord paramMessageRecord, long paramLong)
  {
    msg_comm.MsgHead localMsgHead = new msg_comm.MsgHead();
    Object localObject = abwz.c(paramMessageRecord);
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
    Object localObject1 = null;
    if ((paramMessageRecord.msgtype == -1000) || (paramMessageRecord.msgtype == -10000) || (paramMessageRecord.msgtype == -7014)) {
      if (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("sens_msg_source_msg_info"))) {
        paramQQAppInterface = bblf.a(paramMessageRecord);
      }
    }
    for (;;)
    {
      Object localObject2;
      if (paramQQAppInterface != null)
      {
        localObject1 = new im_msg_body.ElemFlags2();
        ((im_msg_body.ElemFlags2)localObject1).uint32_color_text_id.set((int)(paramMessageRecord.vipBubbleID & 0xFFFFFFFF));
        localObject2 = new im_msg_body.Elem();
        ((im_msg_body.Elem)localObject2).elem_flags2.set((MessageMicro)localObject1);
        paramQQAppInterface.elems.add((MessageMicro)localObject2);
      }
      a(paramMessageRecord, paramQQAppInterface);
      if (0 == 0)
      {
        paramMessageRecord = new im_msg_body.MsgBody();
        paramMessageRecord.rich_text.set(paramQQAppInterface);
      }
      for (;;)
      {
        paramQQAppInterface = paramMessageRecord;
        do
        {
          return paramQQAppInterface;
          paramQQAppInterface = bblf.a((MessageForText)paramMessageRecord);
          break;
          if (paramMessageRecord.msgtype == -1049)
          {
            paramQQAppInterface = bblf.a((MessageForReplyText)paramMessageRecord);
            break;
          }
          if (paramMessageRecord.msgtype == -2005) {
            return paramQQAppInterface.getFileManagerEngine().a().a(2, paramMessageRecord);
          }
          if (paramMessageRecord.msgtype == -2017) {
            return paramQQAppInterface.getFileManagerEngine().a().a(2, paramMessageRecord);
          }
          if (paramMessageRecord.msgtype == -2052)
          {
            paramQQAppInterface = bblf.a((MessageForQQStoryComment)paramMessageRecord);
            break;
          }
          if (paramMessageRecord.msgtype == -2000)
          {
            paramQQAppInterface = bblf.a((MessageForPic)paramMessageRecord);
            break;
          }
          if (paramMessageRecord.msgtype == -5008)
          {
            paramQQAppInterface = bblf.a((MessageForArkApp)paramMessageRecord, true);
            break;
          }
          if (paramMessageRecord.msgtype == -5016)
          {
            paramQQAppInterface = bblf.c((MessageForArkBabyqReply)paramMessageRecord, true);
            break;
          }
          if (paramMessageRecord.msgtype == -5017)
          {
            paramQQAppInterface = bblf.b((MessageForArkApp)paramMessageRecord, true);
            break;
          }
          if (paramMessageRecord.msgtype == -5013)
          {
            paramQQAppInterface = bblf.c((MessageForArkFlashChat)paramMessageRecord);
            break;
          }
          if (paramMessageRecord.msgtype == -5014)
          {
            paramQQAppInterface = bblf.d((MessageForHiBoom)paramMessageRecord);
            break;
          }
          if (paramMessageRecord.msgtype != -2011) {
            break label388;
          }
          localObject2 = bblf.a((MessageForStructing)paramMessageRecord);
          paramQQAppInterface = (QQAppInterface)localObject1;
        } while (localObject2 == null);
        paramQQAppInterface = (QQAppInterface)localObject2;
        break;
        label388:
        if (paramMessageRecord.msgtype == -1035)
        {
          paramQQAppInterface = bblf.a((MessageForMixedMsg)paramMessageRecord);
          break;
        }
        if (paramMessageRecord.msgtype == -1051)
        {
          paramQQAppInterface = bblf.a((MessageForLongTextMsg)paramMessageRecord, false);
          break;
        }
        if (paramMessageRecord.msgtype == -2022)
        {
          paramQQAppInterface = ((MessageForRichText)paramMessageRecord).richText;
          break;
        }
        if (paramMessageRecord.msgtype == -2002)
        {
          paramQQAppInterface = ((MessageForRichText)paramMessageRecord).richText;
          break;
        }
        if (paramMessageRecord.msgtype == -2071)
        {
          paramQQAppInterface = ((MessageForLightVideo)paramMessageRecord).richText;
          break;
        }
        if (paramMessageRecord.msgtype == -2007)
        {
          paramQQAppInterface = bblf.a((MessageForMarketFace)paramMessageRecord);
          break;
        }
        if ((paramMessageRecord.msgtype != -2059) || (TextUtils.isEmpty(paramMessageRecord.msg))) {
          break label597;
        }
        paramQQAppInterface = new im_msg_body.RichText();
        localObject1 = new im_msg_body.Elem();
        localObject2 = new im_msg_body.Text();
        ((im_msg_body.Text)localObject2).str.set(ByteStringMicro.copyFromUtf8(paramMessageRecord.msg));
        ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject2);
        paramQQAppInterface.elems.add((MessageMicro)localObject1);
        break;
        paramMessageRecord = null;
      }
      label597:
      paramQQAppInterface = null;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, msg_comm.Msg paramMsg, bdyi parambdyi, MessageHandler paramMessageHandler, ArrayList<MessageRecord> paramArrayList)
  {
    if (!paramQQAppInterface.getFileManagerEngine().a().b(paramArrayList, paramMsg)) {
      bblf.a(paramMessageHandler, paramArrayList, paramMsg, false, false, parambdyi);
    }
    paramQQAppInterface = (im_msg_body.MsgBody)paramMsg.msg_body.get();
    if ((paramQQAppInterface.rich_text.has()) && (((im_msg_body.RichText)paramQQAppInterface.rich_text.get()).ptt.has())) {
      new bblu().a(paramMessageHandler, paramMsg, paramArrayList, null);
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, msg_comm.Msg paramMsg, bdyi parambdyi, msg_comm.MsgHead paramMsgHead, int paramInt, MessageHandler paramMessageHandler, ArrayList<MessageRecord> paramArrayList)
  {
    int i = paramMsgHead.c2c_cmd.get();
    if ((paramInt == 529) && (i == 4)) {
      paramQQAppInterface.getFileManagerEngine().a().a(paramArrayList, ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get());
    }
    while ((i != 175) && (i != 11)) {
      return;
    }
    bblf.a(paramMessageHandler, paramArrayList, paramMsg, true, false, parambdyi);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, msg_comm.Msg paramMsg, MessageHandler paramMessageHandler, ArrayList<MessageRecord> paramArrayList, bdyi parambdyi)
  {
    if (!paramQQAppInterface.getFileManagerEngine().a().a(paramArrayList, paramMsg)) {
      bblf.a(paramMessageHandler, paramArrayList, paramMsg, false, false, parambdyi);
    }
    paramQQAppInterface = (im_msg_body.MsgBody)paramMsg.msg_body.get();
    if (paramQQAppInterface.rich_text.has())
    {
      im_msg_body.RichText localRichText = (im_msg_body.RichText)paramQQAppInterface.rich_text.get();
      if (localRichText.elems.has())
      {
        paramQQAppInterface = localRichText.elems.get();
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.iterator();
          while (paramQQAppInterface.hasNext())
          {
            parambdyi = (im_msg_body.Elem)paramQQAppInterface.next();
            if (parambdyi.anon_group_msg.has())
            {
              parambdyi = (im_msg_body.AnonymousGroupMsg)parambdyi.anon_group_msg.get();
              int i = parambdyi.uint32_flags.get();
              paramQQAppInterface = parambdyi.str_anon_id.get().toByteArray();
              byte[] arrayOfByte = parambdyi.str_anon_nick.get().toByteArray();
              int j = parambdyi.uint32_head_portrait.get();
              int k = parambdyi.uint32_expire_time.get();
              String str = parambdyi.str_rank_color.get().toStringUtf8();
              if (paramQQAppInterface != null) {}
              for (;;)
              {
                try
                {
                  paramQQAppInterface = new String(paramQQAppInterface, "ISO-8859-1");
                  Iterator localIterator = paramArrayList.iterator();
                  if (!localIterator.hasNext()) {
                    break;
                  }
                  MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
                  if (arrayOfByte != null) {
                    break label304;
                  }
                  parambdyi = "";
                  localMessageRecord.saveExtInfoToExtStr("anonymous", nmy.a(i, paramQQAppInterface, parambdyi, j, k, str));
                  localMessageRecord.extLong |= 0x3;
                  continue;
                  paramQQAppInterface = "";
                }
                catch (UnsupportedEncodingException paramQQAppInterface)
                {
                  paramQQAppInterface.printStackTrace();
                }
                continue;
                label304:
                parambdyi = new String(arrayOfByte);
              }
              if (QLog.isColorLevel()) {
                QLog.d("anonymous_decode", 2, "anonymous_flags has = " + i);
              }
            }
          }
        }
        if (localRichText.ptt.has()) {
          new bblu().a(paramMessageHandler, paramMsg, paramArrayList, null);
        }
      }
    }
  }
  
  private static void a(MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText)
  {
    if (nmy.a(paramMessageRecord))
    {
      im_msg_body.Elem localElem = new im_msg_body.Elem();
      im_msg_body.AnonymousGroupMsg localAnonymousGroupMsg = new im_msg_body.AnonymousGroupMsg();
      nmz localnmz = nmy.a(paramMessageRecord);
      localAnonymousGroupMsg.uint32_flags.set(localnmz.jdField_a_of_type_Int);
      if (!TextUtils.isEmpty(localnmz.jdField_a_of_type_JavaLangString)) {
        localAnonymousGroupMsg.str_anon_id.set(ByteStringMicro.copyFrom(localnmz.jdField_a_of_type_JavaLangString.getBytes()));
      }
      if (!TextUtils.isEmpty(localnmz.jdField_b_of_type_JavaLangString)) {
        localAnonymousGroupMsg.str_anon_nick.set(ByteStringMicro.copyFrom(localnmz.jdField_b_of_type_JavaLangString.getBytes()));
      }
      localAnonymousGroupMsg.uint32_head_portrait.set(localnmz.jdField_b_of_type_Int);
      localAnonymousGroupMsg.uint32_expire_time.set(localnmz.jdField_c_of_type_Int);
      if (!TextUtils.isEmpty(localnmz.jdField_c_of_type_JavaLangString)) {
        localAnonymousGroupMsg.str_rank_color.set(ByteStringMicro.copyFrom(localnmz.jdField_c_of_type_JavaLangString.getBytes()));
      }
      localAnonymousGroupMsg.uint32_bubble_id.set((int)paramMessageRecord.vipBubbleID);
      localElem.anon_group_msg.set(localAnonymousGroupMsg);
      if (QLog.isColorLevel()) {
        QLog.d("anonymous_decode", 2, "anonymous_addd anon_group_msg = ");
      }
      paramRichText.elems.add(localElem);
    }
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
        bcdb.a(paramQQAppInterface, "MsgBackup_msgproxy,mr = " + paramMessageRecord.getClass().getSimpleName());
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
    MessageRecord localMessageRecord = null;
    if (paramMsgBackupMsgEntity.extensionData != null) {
      localMessageRecord = a(this.a, paramMsgBackupMsgEntity.extensionData);
    }
    return localMessageRecord;
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
    msg_comm.MsgHead localMsgHead = a(paramMessageRecord, this.a.getLongAccountUin());
    Object localObject2;
    try
    {
      localObject1 = a(paramMessageRecord, this.a);
      if ((localMsgHead == null) || (localObject1 == null))
      {
        avwu.a("transBackupEntity error,mr = %s ", paramMessageRecord.toString(), new Object[0]);
        return null;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("MsgBackup_msgproxy", 1, "transToBackupEntity,getMsgBody error mr = " + paramMessageRecord.getClass().getSimpleName());
        bcdb.a(localThrowable, "MsgBackup_msgproxy,mr = " + paramMessageRecord.getClass().getSimpleName());
        localObject2 = null;
      }
      localMsg.msg_head.set(localMsgHead);
      localMsg.msg_body.set((MessageMicro)localObject2);
      localObject2 = new MsgBackupMsgEntity();
      ((MsgBackupMsgEntity)localObject2).chatUin = paramMessageRecord.frienduin;
      ((MsgBackupMsgEntity)localObject2).chatType = avwu.b(paramMessageRecord.istroop);
      ((MsgBackupMsgEntity)localObject2).msgType = avwu.a(paramMessageRecord.msgtype);
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
      if (!avwu.d) {
        break label413;
      }
      i = localMsg.getSerializedSize();
      paramMessageRecord = avtv.a(i);
      if (paramMessageRecord != null) {
        break label402;
      }
      paramMessageRecord = localMsg.toByteArray();
      avtv.a(paramMessageRecord);
    }
    label363:
    for (((MsgBackupMsgEntity)localObject2).extensionData = paramMessageRecord;; ((MsgBackupMsgEntity)localObject2).extensionData = localMsg.toByteArray())
    {
      return localObject2;
      i = bblk.b(paramMessageRecord.msgUid);
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
 * Qualified Name:     avug
 * JD-Core Version:    0.7.0.1
 */