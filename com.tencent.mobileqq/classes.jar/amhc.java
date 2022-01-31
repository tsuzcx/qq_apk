import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.mobileim.structmsg.structmsg.RspHead;
import tencent.mobileim.structmsg.structmsg.RspNextSystemMsg;
import tencent.mobileim.structmsg.structmsg.StructMsg;

class amhc
  implements barg
{
  amhc(amha paramamha) {}
  
  public void a(bari parambari, barh parambarh)
  {
    if (parambari.a.getResultCode() != 1000) {
      this.a.a(4006, false, null);
    }
    Object localObject1;
    do
    {
      return;
      try
      {
        if ((parambarh.a == null) || (!(parambarh.a instanceof Integer))) {
          break label722;
        }
        i = ((Integer)parambarh.a).intValue();
        parambarh = amha.o(this.a).getAccount();
        localObject1 = new structmsg.RspNextSystemMsg();
        ((structmsg.RspNextSystemMsg)localObject1).mergeFrom((byte[])parambari.a.getWupBuffer());
        new StringBuilder();
        if ((localObject1 == null) || (((structmsg.RspNextSystemMsg)localObject1).head.result.get() != 0)) {
          this.a.a(4006, false, null);
        }
        if (i != 3) {
          break;
        }
        ahlw.a(this.a, amha.p(this.a), (structmsg.RspNextSystemMsg)localObject1, parambarh);
        return;
      }
      catch (Exception parambari) {}
    } while (!QLog.isColorLevel());
    QLog.d("Q.systemmsg.", 2, "clearFriendSystemMsgResp exception", parambari);
    return;
    parambari = new ArrayList();
    Object localObject2 = ((structmsg.RspNextSystemMsg)localObject1).msgs.get();
    int j = ((List)localObject2).size();
    if (QLog.isColorLevel()) {
      QLog.e("Q.systemmsg.", 2, "<---sendGetNextGroupSystemMsg Resp : decode pb size = " + j);
    }
    HashSet localHashSet = new HashSet();
    int i = 0;
    label239:
    if (i < j)
    {
      structmsg.StructMsg localStructMsg = (structmsg.StructMsg)((structmsg.StructMsg)((List)localObject2).get(i)).get();
      if ((localStructMsg == null) || (!localStructMsg.msg_seq.has()) || (!localHashSet.contains(Long.valueOf(localStructMsg.msg_seq.get()))))
      {
        MessageRecord localMessageRecord = ayvw.a(-2018);
        localMessageRecord.msgtype = -2018;
        localMessageRecord.selfuin = parambarh;
        localMessageRecord.frienduin = aljq.N;
        localMessageRecord.senderuin = (((structmsg.StructMsg)((List)localObject2).get(i)).req_uin.get() + "");
        localMessageRecord.istroop = 0;
        MessageForSystemMsg localMessageForSystemMsg = (MessageForSystemMsg)localMessageRecord;
        localMessageForSystemMsg.structMsg = ((structmsg.StructMsg)((structmsg.StructMsg)((List)localObject2).get(i)).get());
        localMessageRecord.msgData = localMessageForSystemMsg.structMsg.toByteArray();
        parambari.add(localMessageForSystemMsg);
        if ((localStructMsg != null) && (localStructMsg.msg_seq.has())) {
          localHashSet.add(Long.valueOf(localStructMsg.msg_seq.get()));
        }
      }
    }
    else
    {
      localObject2 = (aubr)amha.q(this.a).getManager(37);
      if (parambari.size() > 0)
      {
        if (parambari.size() < 20)
        {
          baba.a().a(true, amha.r(this.a));
          if (localObject2 != null) {
            ((aubr)localObject2).a(true);
          }
        }
        long l2 = ((structmsg.RspNextSystemMsg)localObject1).following_group_seq.get();
        long l1 = l2;
        if (l2 <= 0L) {
          l1 = amha.s(this.a).a().e("following_group_seq");
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.systemmsg.", 2, "<---sendGetNextGroupSystemMsg : decode pb following_group_seq" + l1);
        }
        amha.t(this.a).a().e("following_group_seq", l1);
        localObject1 = amha.v(this.a).a();
        parambarh = String.valueOf(parambarh);
        if ((!alsh.a(parambari)) || (!amha.u(this.a).isBackground_Stop)) {
          break label734;
        }
      }
    }
    label722:
    label734:
    for (boolean bool = true;; bool = false)
    {
      ((QQMessageFacade)localObject1).a(parambari, parambarh, bool);
      this.a.a("handleGetSystemMsgResp", true, parambari.size(), false, false);
      for (;;)
      {
        this.a.a(4005, true, parambari);
        return;
        baba.a().a(true, amha.w(this.a));
        if (localObject2 != null) {
          ((aubr)localObject2).a(true);
        }
      }
      i = 0;
      break;
      i += 1;
      break label239;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amhc
 * JD-Core Version:    0.7.0.1
 */