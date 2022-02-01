import com.tencent.common.app.BaseApplicationImpl;
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
import tencent.im.cs.head.ContentHead;
import tencent.im.cs.head.Head;
import tencent.im.cs.head.MsgHead;
import tencent.im.msg.im_msg_body.MsgBody;

public class bcaf
  implements bbzr
{
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, bbyn parambbyn)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has())) {
      if (QLog.isColorLevel()) {
        QLog.e("VideoQCallDecoder", 2, "<---decodeC2CMsgPkg_QCall return null:hasBody:" + paramMsg.msg_body.has() + ",hasMsgContent" + ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has());
      }
    }
    do
    {
      for (;;)
      {
        return;
        long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
        long l3 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
        long l4 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
        long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
        ((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get();
        paramList = l4 + "-" + l3;
        if (QLog.isColorLevel()) {
          QLog.d("decodeC2CMsgPkg_QCall", 2, "<---decodeC2CMsgPkg_QCall :  key:" + paramList);
        }
        if (paramMessageHandler.app.a().a(l2, paramList))
        {
          if (QLog.isColorLevel()) {
            QLog.d("decodeC2CMsgPkg_QCall", 2, "msg has been pulled");
          }
        }
        else
        {
          l3 = bbyp.a();
          l4 = Long.valueOf(paramMessageHandler.app.getCurrentAccountUin()).longValue();
          paramMsg = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
          paramList = new byte[4];
          Object localObject = new byte[4];
          System.arraycopy(paramMsg, 0, paramList, 0, 4);
          System.arraycopy(paramMsg, 4, localObject, 0, 4);
          int i = lcr.a(paramList, 4);
          int j = lcr.a((byte[])localObject, 4);
          if ((i <= 0) || (j <= 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("decodeC2CMsgPkg_QCall", 2, "invalid head length:" + i + " or body length:" + j);
            }
          }
          else
          {
            paramList = null;
            try
            {
              localObject = new head.Head();
              byte[] arrayOfByte = new byte[i];
              System.arraycopy(paramMsg, 8, arrayOfByte, 0, i);
              ((head.Head)localObject).mergeFrom(arrayOfByte);
              int k = ((head.Head)localObject).msg_msg_head.msg_content_head.uint32_type.get();
              int m = ((head.Head)localObject).msg_msg_head.msg_content_head.uint32_subtype.get();
              if ((k == 562) && (m == 17))
              {
                localObject = new im_msg_body.MsgBody();
                arrayOfByte = new byte[j];
                System.arraycopy(paramMsg, i + 8, arrayOfByte, 0, j);
                ((im_msg_body.MsgBody)localObject).mergeFrom(arrayOfByte);
                paramMsg = ((im_msg_body.MsgBody)localObject).msg_content.get().toByteArray();
                if (paramMsg == null)
                {
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.d("decodeC2CMsgPkg_QCall", 2, "msg sharp content null, return;");
                }
              }
              else
              {
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("decodeC2CMsgPkg_QCall", 2, "error msgType:" + k + ", or subType:" + m);
                return;
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                paramMsg = paramList;
                if (QLog.isColorLevel())
                {
                  QLog.d("decodeC2CMsgPkg_QCall", 2, "error when process qcall offline msg", localException);
                  paramMsg = paramList;
                }
              }
              boolean bool = lkm.a(paramMsg);
              if (((!parambbyn.jdField_a_of_type_Boolean) && (!parambbyn.f)) || ((parambbyn.jdField_a_of_type_Long != parambbyn.b) || ((parambbyn.jdField_a_of_type_Long == parambbyn.b) && (!bool))))
              {
                if (QLog.isColorLevel()) {
                  QLog.e("decodeC2CMsgPkg_QCall", 2, "<---decodeC2CMsgPkg_QCall return null:,isReaded:" + parambbyn.jdField_a_of_type_Boolean + "syncOther:" + parambbyn.f + ",isSharpRequest" + bool);
                }
              }
              else
              {
                mqu.a(l2);
                mqu.a(l4);
                try
                {
                  new lxd(BaseApplicationImpl.getContext()).a(new bcag(this, paramMsg, l3 - l1, paramMessageHandler, l4, l2, l1, bool));
                  return;
                }
                catch (Exception paramMessageHandler) {}
              }
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("decodeC2CMsgPkg_QCall", 2, "exception when process qcall offline msg", paramMessageHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcaf
 * JD-Core Version:    0.7.0.1
 */