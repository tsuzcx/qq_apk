import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MsgType0x210;
import tencent.im.s2c.msgtype0x210.submsgtype0x4e.Submsgtype0x4e.GroupBulletin;
import tencent.im.s2c.msgtype0x210.submsgtype0x4e.Submsgtype0x4e.GroupBulletin.Content;
import tencent.im.s2c.msgtype0x210.submsgtype0x4e.Submsgtype0x4e.MsgBody;

public class bcts
  implements bctr
{
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    Object localObject = new Submsgtype0x4e.MsgBody();
    for (;;)
    {
      int i;
      long l1;
      long l2;
      long l3;
      String str;
      int j;
      try
      {
        paramArrayOfByte = (Submsgtype0x4e.MsgBody)((Submsgtype0x4e.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        i = paramArrayOfByte.uint32_appid.get();
        l1 = paramArrayOfByte.uint64_group_id.get();
        l2 = paramArrayOfByte.uint64_group_code.get();
        if (paramArrayOfByte.msg_group_bulletin.has())
        {
          l3 = (int)bcrg.a();
          localObject = paramArrayOfByte.msg_group_bulletin.rpt_msg_content.get();
          new ArrayList();
          paramArrayOfByte = paramQQAppInterface.a().createEntityManager();
          localObject = ((List)localObject).iterator();
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          Submsgtype0x4e.GroupBulletin.Content localContent = (Submsgtype0x4e.GroupBulletin.Content)((Iterator)localObject).next();
          l3 = localContent.uint64_uin.get();
          str = localContent.bytes_feedid.get().toStringUtf8();
          j = localContent.uint32_time.get();
          if (bgts.b(str))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("TroopNotificationHelper", 2, "notice is loading");
            continue;
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopAnnouncementDecoder", 2, "<---decodeC2CMsgPkg_MsgType0x210 : fail to parse SubMsgType0x4e.");
        }
      }
      if ((TroopNotificationCache)paramArrayOfByte.find(TroopNotificationCache.class, "troopUin=? and feedsId=?", new String[] { String.valueOf(l2), str }) != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopAnnouncementDecoder", 2, "notice has exist!");
        }
      }
      else {
        bgts.a(paramQQAppInterface, i, l1, l2, l3, str, j, "OidbSvc.0x852_35", (short)23, false, false);
      }
    }
    paramArrayOfByte.close();
  }
  
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg, List<MessageRecord> paramList, bcre parambcre, MessageHandler paramMessageHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationHelper", 2, "get notice from decodeC2CMsgPkg_MsgType0x210");
    }
    paramMsgType0x210 = paramMsgType0x210.msg_content.get().toByteArray();
    a(paramMessageHandler.app, paramMsgType0x210);
    bcrw.a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcts
 * JD-Core Version:    0.7.0.1
 */