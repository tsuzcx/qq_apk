import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.RspHead;
import tencent.mobileim.structmsg.structmsg.RspNextSystemMsg;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class aogf
  implements bdxd
{
  aogf(aogd paramaogd) {}
  
  public void a(bdxf parambdxf, bdxe parambdxe)
  {
    if (parambdxf.a.getResultCode() != 1000)
    {
      this.a.a(4006, false, null);
      return;
    }
    Object localObject1;
    int i;
    for (;;)
    {
      structmsg.RspNextSystemMsg localRspNextSystemMsg;
      Object localObject2;
      Object localObject3;
      MessageForSystemMsg localMessageForSystemMsg;
      try
      {
        localObject1 = (anmw)aogd.b(this.a).getManager(51);
        parambdxe = aogd.c(this.a).getAccount();
        localRspNextSystemMsg = new structmsg.RspNextSystemMsg();
        localRspNextSystemMsg.mergeFrom((byte[])parambdxf.a.getWupBuffer());
        new StringBuilder();
        if ((localRspNextSystemMsg == null) || (localRspNextSystemMsg.head.result.get() != 0)) {
          this.a.a(4006, false, null);
        }
        parambdxf = new ArrayList();
        localObject2 = localRspNextSystemMsg.msgs.get();
        j = ((List)localObject2).size();
        if (!QLog.isColorLevel()) {
          break label860;
        }
        QLog.e("Q.systemmsg.", 2, "<---sendGetNextFriendSystemMsg Resp : decode pb size = " + j);
      }
      catch (Exception parambdxf)
      {
        int j;
        long l3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.systemmsg.", 2, "clearFriendSystemMsgResp exception", parambdxf);
        this.a.a(4006, false, null);
        return;
      }
      if (i < j)
      {
        localObject3 = bbzh.a(-2018);
        ((MessageRecord)localObject3).msgtype = -2018;
        ((MessageRecord)localObject3).selfuin = parambdxe;
        ((MessageRecord)localObject3).frienduin = anhk.M;
        ((MessageRecord)localObject3).senderuin = (((structmsg.StructMsg)((List)localObject2).get(i)).req_uin.get() + "");
        ((MessageRecord)localObject3).istroop = 0;
        ((MessageRecord)localObject3).time = ((structmsg.StructMsg)((List)localObject2).get(i)).msg_time.get();
        ((MessageRecord)localObject3).isread = true;
        localMessageForSystemMsg = (MessageForSystemMsg)localObject3;
        localMessageForSystemMsg.structMsg = ((structmsg.StructMsg)((structmsg.StructMsg)((List)localObject2).get(i)).get());
        ((MessageRecord)localObject3).msgData = localMessageForSystemMsg.structMsg.toByteArray();
        localMessageForSystemMsg.parse();
        parambdxf.add(localMessageForSystemMsg);
        i += 1;
      }
      else if (parambdxf.size() > 0)
      {
        i = parambdxf.size();
        long l1 = ((MessageRecord)parambdxf.get(0)).time;
        long l2 = ((MessageRecord)parambdxf.get(i - 1)).time;
        l3 = bdgm.a().a(aogd.d(this.a));
        localObject2 = aogd.e(this.a).a().a(anhk.M, 0, l3).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ChatMessage)((Iterator)localObject2).next();
          if ((((ChatMessage)localObject3).time >= l2) && (((ChatMessage)localObject3).time <= l1))
          {
            aogd.f(this.a).a().b(anhk.M, 0, ((ChatMessage)localObject3).uniseq, false);
            ((Iterator)localObject2).remove();
          }
          else if ((localObject3 instanceof MessageForSystemMsg))
          {
            localMessageForSystemMsg = (MessageForSystemMsg)localObject3;
            if (localMessageForSystemMsg.structMsg == null) {
              localMessageForSystemMsg.parse();
            }
            String str = localMessageForSystemMsg.senderuin;
            if ((localMessageForSystemMsg.structMsg.msg.sub_type.get() == 13) && (((anmw)localObject1).b(str)))
            {
              aogd.g(this.a).a().b(anhk.M, 0, ((ChatMessage)localObject3).uniseq, false);
              ((Iterator)localObject2).remove();
            }
          }
        }
        bdgm.a().a(aogd.h(this.a), l2);
        if (parambdxf.size() < 20) {
          bdgm.a().a(true, aogd.i(this.a));
        }
        l2 = localRspNextSystemMsg.following_friend_seq.get();
        l1 = l2;
        if (l2 <= 0L) {
          l1 = aogd.j(this.a).a().e("following_friend_seq_47");
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.systemmsg.", 2, "<---sendGetNextFriendSystemMsg : decode pb following_friend_seq" + l1);
        }
        aogd.k(this.a).a().e("following_friend_seq_47", l1);
        localObject1 = aogd.m(this.a).a();
        parambdxe = String.valueOf(parambdxe);
        if ((!anqc.a(parambdxf)) || (!aogd.l(this.a).isBackground_Stop)) {
          break label865;
        }
      }
    }
    label860:
    label865:
    for (boolean bool = true;; bool = false)
    {
      ((QQMessageFacade)localObject1).a(parambdxf, parambdxe, bool);
      this.a.a("handleGetSystemMsgResp", true, parambdxf.size(), false, false);
      for (;;)
      {
        this.a.a(4005, true, null);
        return;
        bdgm.a().a(true, aogd.n(this.a));
      }
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aogf
 * JD-Core Version:    0.7.0.1
 */