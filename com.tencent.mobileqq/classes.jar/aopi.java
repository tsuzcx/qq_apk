import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.transfile.ProtoReqManager.IProtoRespBack;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.RspHead;
import tencent.mobileim.structmsg.structmsg.RspNextSystemMsg;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class aopi
  implements ProtoReqManager.IProtoRespBack
{
  aopi(aooy paramaooy) {}
  
  public void onProtoResp(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    if (paramProtoResp.resp.getResultCode() != 1000)
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
        localObject1 = (anvk)aooy.b(this.a).getManager(QQManagerFactory.FRIENDS_MANAGER);
        paramProtoReq = aooy.c(this.a).getAccount();
        localRspNextSystemMsg = new structmsg.RspNextSystemMsg();
        localRspNextSystemMsg.mergeFrom((byte[])paramProtoResp.resp.getWupBuffer());
        new StringBuilder();
        if ((localRspNextSystemMsg == null) || (localRspNextSystemMsg.head.result.get() != 0)) {
          this.a.a(4006, false, null);
        }
        paramProtoResp = new ArrayList();
        localObject2 = localRspNextSystemMsg.msgs.get();
        j = ((List)localObject2).size();
        if (!QLog.isColorLevel()) {
          break label861;
        }
        QLog.e("Q.systemmsg.", 2, "<---sendGetNextFriendSystemMsg Resp : decode pb size = " + j);
      }
      catch (Exception paramProtoResp)
      {
        int j;
        long l3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.systemmsg.", 2, "clearFriendSystemMsgResp exception", paramProtoResp);
        this.a.a(4006, false, null);
        return;
      }
      if (i < j)
      {
        localObject3 = bcsa.a(-2018);
        ((MessageRecord)localObject3).msgtype = -2018;
        ((MessageRecord)localObject3).selfuin = paramProtoReq;
        ((MessageRecord)localObject3).frienduin = AppConstants.FRIEND_SYSTEM_MSG_UIN;
        ((MessageRecord)localObject3).senderuin = (((structmsg.StructMsg)((List)localObject2).get(i)).req_uin.get() + "");
        ((MessageRecord)localObject3).istroop = 0;
        ((MessageRecord)localObject3).time = ((structmsg.StructMsg)((List)localObject2).get(i)).msg_time.get();
        ((MessageRecord)localObject3).isread = true;
        localMessageForSystemMsg = (MessageForSystemMsg)localObject3;
        localMessageForSystemMsg.structMsg = ((structmsg.StructMsg)((structmsg.StructMsg)((List)localObject2).get(i)).get());
        ((MessageRecord)localObject3).msgData = localMessageForSystemMsg.structMsg.toByteArray();
        localMessageForSystemMsg.parse();
        paramProtoResp.add(localMessageForSystemMsg);
        i += 1;
      }
      else if (paramProtoResp.size() > 0)
      {
        i = paramProtoResp.size();
        long l1 = ((MessageRecord)paramProtoResp.get(0)).time;
        long l2 = ((MessageRecord)paramProtoResp.get(i - 1)).time;
        l3 = bdzx.a().a(aooy.d(this.a));
        localObject2 = aooy.e(this.a).getMessageFacade().getAIOList(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, l3).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ChatMessage)((Iterator)localObject2).next();
          if ((((ChatMessage)localObject3).time >= l2) && (((ChatMessage)localObject3).time <= l1))
          {
            aooy.f(this.a).getMessageFacade().removeMsgByUniseq(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, ((ChatMessage)localObject3).uniseq, false);
            ((Iterator)localObject2).remove();
          }
          else if ((localObject3 instanceof MessageForSystemMsg))
          {
            localMessageForSystemMsg = (MessageForSystemMsg)localObject3;
            if (localMessageForSystemMsg.structMsg == null) {
              localMessageForSystemMsg.parse();
            }
            String str = localMessageForSystemMsg.senderuin;
            if ((localMessageForSystemMsg.structMsg.msg.sub_type.get() == 13) && (((anvk)localObject1).b(str)))
            {
              aooy.g(this.a).getMessageFacade().removeMsgByUniseq(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, ((ChatMessage)localObject3).uniseq, false);
              ((Iterator)localObject2).remove();
            }
          }
        }
        bdzx.a().a(aooy.h(this.a), l2);
        if (paramProtoResp.size() < 20) {
          bdzx.a().a(true, aooy.i(this.a));
        }
        l2 = localRspNextSystemMsg.following_friend_seq.get();
        l1 = l2;
        if (l2 <= 0L) {
          l1 = aooy.j(this.a).getMsgCache().e("following_friend_seq_47");
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.systemmsg.", 2, "<---sendGetNextFriendSystemMsg : decode pb following_friend_seq" + l1);
        }
        aooy.k(this.a).getMsgCache().e("following_friend_seq_47", l1);
        localObject1 = aooy.m(this.a).getMessageFacade();
        paramProtoReq = String.valueOf(paramProtoReq);
        if ((!anyv.a(paramProtoResp)) || (!aooy.l(this.a).isBackgroundStop)) {
          break label866;
        }
      }
    }
    label861:
    label866:
    for (boolean bool = true;; bool = false)
    {
      ((QQMessageFacade)localObject1).addMessage(paramProtoResp, paramProtoReq, bool);
      this.a.a("handleGetSystemMsgResp", true, paramProtoResp.size(), false, false);
      for (;;)
      {
        this.a.a(4005, true, null);
        return;
        bdzx.a().a(true, aooy.n(this.a));
      }
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aopi
 * JD-Core Version:    0.7.0.1
 */