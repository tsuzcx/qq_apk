import com.tencent.av.VideoController;
import com.tencent.av.hd_video_2.CmdS2CInviteReqBody;
import com.tencent.av.hd_video_2.InviteTempSessionData;
import com.tencent.av.hd_video_2.MsgBody;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.MsgBody;

public class bcsq
  implements bcsi
{
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, bcre parambcre)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has())) {
      if (QLog.isColorLevel()) {
        QLog.e("SharpVideoDecoder", 2, "<---decodeC2CMsgPkg_SharpVideo return null:hasBody:" + paramMsg.msg_body.has() + ",hasMsgContent" + ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has());
      }
    }
    long l1;
    long l4;
    long l2;
    long l5;
    byte[] arrayOfByte2;
    int i;
    int j;
    boolean bool;
    do
    {
      long l3;
      do
      {
        byte[] arrayOfByte1;
        do
        {
          do
          {
            return;
            l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
            l3 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
            l4 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
            l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
            ((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get();
            paramList = l4 + "-" + l3;
            if (QLog.isColorLevel()) {
              QLog.d("shanezhaiSHARP", 2, "<---decodeC2CMsgPkg_SharpVideo :  key:" + paramList);
            }
            if (!paramMessageHandler.app.a().a(l2, paramList)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("shanezhaiSHARP", 2, "msg has been pulled");
          return;
          l3 = bcrg.a();
          l4 = Long.valueOf(paramMessageHandler.app.getCurrentAccountUin()).longValue();
          arrayOfByte1 = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
          l5 = l3 - l1;
          arrayOfByte2 = new byte[4];
          byte[] arrayOfByte3 = new byte[4];
          System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, 4);
          System.arraycopy(arrayOfByte1, 4, arrayOfByte3, 0, 4);
          i = lcy.a(arrayOfByte2, 4);
          j = arrayOfByte1.length - 8 - i;
        } while (j < 0);
        arrayOfByte2 = new byte[j];
        System.arraycopy(arrayOfByte1, i + 8, arrayOfByte2, 0, j);
        bool = lla.a(arrayOfByte2);
        if (((parambcre.jdField_a_of_type_Boolean) || (parambcre.f)) && ((parambcre.jdField_a_of_type_Long == parambcre.b) && ((parambcre.jdField_a_of_type_Long != parambcre.b) || (bool)))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("SharpVideoDecoder", 2, "<---decodeC2CMsgPkg_SharpVideo return null:,isReaded:" + parambcre.jdField_a_of_type_Boolean + "syncOther:" + parambcre.f + ",isSharpRequest" + bool);
      return;
      if (bool)
      {
        paramMessageHandler.app.a().a(l2, paramList, l3);
        lcc.a(l4, l2, 215);
      }
      if (llk.c()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("shanezhaiSHARP", 2, "Discard video message cause device not support");
      }
    } while (!bool);
    lcc.a(l4, l2, 212);
    return;
    if (l5 >= 60L)
    {
      int k;
      int i1;
      int i2;
      int m;
      if (bool)
      {
        paramList = String.valueOf(l2);
        parambcre = new hd_video_2.MsgBody();
        k = -1;
        i1 = 0;
        i2 = 0;
        i = 0;
        j = i2;
        m = k;
      }
      int n;
      for (;;)
      {
        try
        {
          parambcre.mergeFrom(arrayOfByte2);
          j = i2;
          m = k;
          n = parambcre.msg_invite_body.uint32_new_business_flag.get();
          j = i2;
          m = n;
          if (!parambcre.msg_invite_body.msg_temp_session.has()) {
            continue;
          }
          k = i1;
          j = i2;
          m = n;
          if (parambcre.msg_invite_body.msg_temp_session.uint32_relationship_type.has())
          {
            j = i2;
            m = n;
            i1 = VideoController.a(parambcre.msg_invite_body.msg_temp_session.uint32_relationship_type.get(), false, 1);
            if (i1 != -1) {
              i = i1;
            }
            k = i;
            j = i;
            m = n;
            if (QLog.isColorLevel())
            {
              j = i;
              m = n;
              QLog.d("shanezhaiSHARP", 2, "uinType" + i + " translateType:" + i1);
              k = i;
            }
          }
          i = k;
        }
        catch (Exception parambcre)
        {
          parambcre.printStackTrace();
          i = j;
          n = m;
          continue;
        }
        if (-1 != n) {
          break label956;
        }
        VideoMsgTools.a(paramMessageHandler.app, 0, 6, true, paramList, String.valueOf(l4), false, null, false, new Object[] { paramMsg });
        lcc.a(l4, l2, 208);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("shanezhaiSHARP", 2, "Discard video message because of time out " + l5 + " s");
        return;
        k = i1;
        j = i2;
        m = n;
        if (QLog.isColorLevel())
        {
          j = i2;
          m = n;
          QLog.d("shanezhaiSHARP", 2, "msg_temp_session not include");
          k = i1;
        }
      }
      label956:
      if (n == 0) {}
      for (bool = true;; bool = false)
      {
        VideoMsgTools.a(paramMessageHandler.app, i, 6, bool, paramList, String.valueOf(l2), false, null, false, new Object[] { paramMsg });
        break;
      }
    }
    if (bool) {
      lcc.a(l4, l2, 211);
    }
    if (QLog.isColorLevel()) {
      QLog.d("shanezhaiSHARP", 2, "===========handleSharpVideoMessageResp 1234========");
    }
    paramMessageHandler.a(l4, arrayOfByte2, l2, (int)l1, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcsq
 * JD-Core Version:    0.7.0.1
 */