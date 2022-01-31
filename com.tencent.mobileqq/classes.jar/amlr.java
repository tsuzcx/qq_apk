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

class amlr
  implements bavp
{
  amlr(amlp paramamlp) {}
  
  public void a(bavr parambavr, bavq parambavq)
  {
    if (parambavr.a.getResultCode() != 1000) {
      this.a.a(4006, false, null);
    }
    Object localObject1;
    do
    {
      return;
      try
      {
        if ((parambavq.a == null) || (!(parambavq.a instanceof Integer))) {
          break label722;
        }
        i = ((Integer)parambavq.a).intValue();
        parambavq = amlp.o(this.a).getAccount();
        localObject1 = new structmsg.RspNextSystemMsg();
        ((structmsg.RspNextSystemMsg)localObject1).mergeFrom((byte[])parambavr.a.getWupBuffer());
        new StringBuilder();
        if ((localObject1 == null) || (((structmsg.RspNextSystemMsg)localObject1).head.result.get() != 0)) {
          this.a.a(4006, false, null);
        }
        if (i != 3) {
          break;
        }
        ahql.a(this.a, amlp.p(this.a), (structmsg.RspNextSystemMsg)localObject1, parambavq);
        return;
      }
      catch (Exception parambavr) {}
    } while (!QLog.isColorLevel());
    QLog.d("Q.systemmsg.", 2, "clearFriendSystemMsgResp exception", parambavr);
    return;
    parambavr = new ArrayList();
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
        MessageRecord localMessageRecord = azaf.a(-2018);
        localMessageRecord.msgtype = -2018;
        localMessageRecord.selfuin = parambavq;
        localMessageRecord.frienduin = alof.N;
        localMessageRecord.senderuin = (((structmsg.StructMsg)((List)localObject2).get(i)).req_uin.get() + "");
        localMessageRecord.istroop = 0;
        MessageForSystemMsg localMessageForSystemMsg = (MessageForSystemMsg)localMessageRecord;
        localMessageForSystemMsg.structMsg = ((structmsg.StructMsg)((structmsg.StructMsg)((List)localObject2).get(i)).get());
        localMessageRecord.msgData = localMessageForSystemMsg.structMsg.toByteArray();
        parambavr.add(localMessageForSystemMsg);
        if ((localStructMsg != null) && (localStructMsg.msg_seq.has())) {
          localHashSet.add(Long.valueOf(localStructMsg.msg_seq.get()));
        }
      }
    }
    else
    {
      localObject2 = (auga)amlp.q(this.a).getManager(37);
      if (parambavr.size() > 0)
      {
        if (parambavr.size() < 20)
        {
          bafj.a().a(true, amlp.r(this.a));
          if (localObject2 != null) {
            ((auga)localObject2).a(true);
          }
        }
        long l2 = ((structmsg.RspNextSystemMsg)localObject1).following_group_seq.get();
        long l1 = l2;
        if (l2 <= 0L) {
          l1 = amlp.s(this.a).a().e("following_group_seq");
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.systemmsg.", 2, "<---sendGetNextGroupSystemMsg : decode pb following_group_seq" + l1);
        }
        amlp.t(this.a).a().e("following_group_seq", l1);
        localObject1 = amlp.v(this.a).a();
        parambavq = String.valueOf(parambavq);
        if ((!alww.a(parambavr)) || (!amlp.u(this.a).isBackground_Stop)) {
          break label734;
        }
      }
    }
    label722:
    label734:
    for (boolean bool = true;; bool = false)
    {
      ((QQMessageFacade)localObject1).a(parambavr, parambavq, bool);
      this.a.a("handleGetSystemMsgResp", true, parambavr.size(), false, false);
      for (;;)
      {
        this.a.a(4005, true, parambavr);
        return;
        bafj.a().a(true, amlp.w(this.a));
        if (localObject2 != null) {
          ((auga)localObject2).a(true);
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
 * Qualified Name:     amlr
 * JD-Core Version:    0.7.0.1
 */