import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.SystemMessageProcessor.11.1;
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
import mqq.os.MqqHandler;
import tencent.mobileim.structmsg.structmsg.RspHead;
import tencent.mobileim.structmsg.structmsg.RspNextSystemMsg;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class aogg
  implements bdxd
{
  aogg(aogd paramaogd) {}
  
  public void a(bdxf parambdxf, bdxe parambdxe)
  {
    if (parambdxf.a.getResultCode() != 1000) {
      this.a.a(4006, false, null);
    }
    label54:
    Object localObject2;
    do
    {
      return;
      try
      {
        if ((parambdxe.a == null) || (!(parambdxe.a instanceof Integer))) {
          break label1097;
        }
        i = ((Integer)parambdxe.a).intValue();
        parambdxe = aogd.o(this.a).getAccount();
        localObject2 = new structmsg.RspNextSystemMsg();
        ((structmsg.RspNextSystemMsg)localObject2).mergeFrom((byte[])parambdxf.a.getWupBuffer());
        new StringBuilder();
        if ((localObject2 == null) || (((structmsg.RspNextSystemMsg)localObject2).head.result.get() != 0)) {
          this.a.a(4006, false, null);
        }
        if (i != 3) {
          break;
        }
        ajga.a(this.a, aogd.p(this.a), (structmsg.RspNextSystemMsg)localObject2, parambdxe);
        return;
      }
      catch (Exception parambdxf) {}
    } while (!QLog.isColorLevel());
    QLog.d("Q.systemmsg.", 2, "clearFriendSystemMsgResp exception", parambdxf);
    return;
    ArrayList localArrayList = new ArrayList();
    parambdxf = ((structmsg.RspNextSystemMsg)localObject2).msgs.get();
    int j = parambdxf.size();
    if (QLog.isColorLevel()) {
      QLog.e("Q.systemmsg.", 2, "<---sendGetNextGroupSystemMsg Resp : decode pb size = " + j);
    }
    Object localObject1 = new HashSet();
    int i = 0;
    label238:
    if (i < j)
    {
      Object localObject3 = (structmsg.StructMsg)((structmsg.StructMsg)parambdxf.get(i)).get();
      if ((localObject3 == null) || (!((structmsg.StructMsg)localObject3).msg_seq.has()) || (!((Set)localObject1).contains(Long.valueOf(((structmsg.StructMsg)localObject3).msg_seq.get()))))
      {
        MessageRecord localMessageRecord = bbzh.a(-2018);
        localMessageRecord.msgtype = -2018;
        localMessageRecord.selfuin = parambdxe;
        localMessageRecord.frienduin = anhk.N;
        localMessageRecord.senderuin = (((structmsg.StructMsg)parambdxf.get(i)).req_uin.get() + "");
        localMessageRecord.istroop = 0;
        MessageForSystemMsg localMessageForSystemMsg = (MessageForSystemMsg)localMessageRecord;
        localMessageForSystemMsg.structMsg = ((structmsg.StructMsg)((structmsg.StructMsg)parambdxf.get(i)).get());
        localMessageRecord.msgData = localMessageForSystemMsg.structMsg.toByteArray();
        localArrayList.add(localMessageForSystemMsg);
        if ((localObject3 != null) && (((structmsg.StructMsg)localObject3).msg_seq.has())) {
          ((Set)localObject1).add(Long.valueOf(((structmsg.StructMsg)localObject3).msg_seq.get()));
        }
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(" type:").append(localMessageRecord.msgtype);
          ((StringBuilder)localObject3).append(" selfuin:").append(localMessageRecord.selfuin);
          ((StringBuilder)localObject3).append(" frienduin:").append(localMessageRecord.frienduin);
          ((StringBuilder)localObject3).append(" senderuin:").append(localMessageRecord.senderuin);
          ((StringBuilder)localObject3).append(" istroop:").append(localMessageRecord.istroop);
          QLog.d("SystemMessageProcessor", 2, "sendGetNextGroupSystemMsg-->" + ((StringBuilder)localObject3).toString());
        }
      }
    }
    else
    {
      localObject1 = (awne)aogd.q(this.a).getManager(37);
      if (localArrayList.size() > 0)
      {
        if (localArrayList.size() < 100)
        {
          bdgn.a().a(true, aogd.r(this.a));
          if (localObject1 != null) {
            ((awne)localObject1).a(true);
          }
        }
        long l2 = ((structmsg.RspNextSystemMsg)localObject2).following_group_seq.get();
        long l1 = l2;
        if (l2 <= 0L) {
          l1 = aogd.s(this.a).a().e("following_group_seq");
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.systemmsg.", 2, "<---sendGetNextGroupSystemMsg : decode pb following_group_seq" + l1);
        }
        aogd.t(this.a).a().e("following_group_seq", l1);
        localObject2 = ajfn.d();
        if (localObject2 == null) {
          break label1092;
        }
      }
    }
    for (;;)
    {
      boolean bool;
      try
      {
        parambdxf = this.a.a((List)localObject2, localArrayList);
        if (QLog.isColorLevel())
        {
          i = localArrayList.size();
          QLog.e("Q.systemmsg.", 2, "<---sendGetNextGroupSystemMsg Resp : save db size = " + i);
        }
        if (QLog.isColorLevel())
        {
          i = localArrayList.size();
          QLog.e("Q.systemmsg.", 2, "<---sendGetNextGroupSystemMsg Resp : save cache size = " + i);
        }
        i = bdgn.a().a(aogd.u(this.a));
        ThreadManager.getUIHandler().post(new SystemMessageProcessor.11.1(this, localArrayList, i));
        if ((parambdxf != null) && (parambdxf.size() > 0))
        {
          localObject2 = aogd.w(this.a).a();
          parambdxe = String.valueOf(parambdxe);
          if ((!anqc.a(localArrayList)) || (!aogd.v(this.a).isBackground_Stop)) {
            break label1109;
          }
          bool = true;
          ((QQMessageFacade)localObject2).a(parambdxf, parambdxe, bool);
        }
        this.a.a("handleGetSystemMsgResp", true, localArrayList.size(), false, false);
        this.a.a(4005, true, localArrayList);
        parambdxf = (aqlz)aqlk.a().a(634);
        i = parambdxf.d;
        parambdxe = aogd.y(this.a).a().a(anhk.N, 0, null);
        if ((((awne)localObject1).a()) || (parambdxe == null) || (parambdxe.size() >= i) || (!parambdxf.a)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SystemMessageProcessor", 2, "Auto Get Msg Continue");
        }
        this.a.c(0);
        return;
      }
      finally {}
      bdgn.a().a(true, aogd.x(this.a));
      if (localObject1 != null)
      {
        ((awne)localObject1).a(true);
        continue;
        label1092:
        parambdxf = null;
        continue;
        label1097:
        i = 0;
        break label54;
        i += 1;
        break label238;
        label1109:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aogg
 * JD-Core Version:    0.7.0.1
 */