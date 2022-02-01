package com.tencent.mobileqq.app.message;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.RspHead;
import tencent.mobileim.structmsg.structmsg.RspNextSystemMsg;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class SystemMessageProcessor$9
  implements ProtoReqManagerImpl.IProtoRespBack
{
  SystemMessageProcessor$9(SystemMessageProcessor paramSystemMessageProcessor) {}
  
  public void onProtoResp(ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    if (paramProtoResp.resp.getResultCode() != 1000)
    {
      this.a.a(4006, false, null);
      return;
    }
    for (;;)
    {
      try
      {
        paramProtoReq = (FriendsManager)SystemMessageProcessor.e(this.a).getManager(QQManagerFactory.FRIENDS_MANAGER);
        String str1 = SystemMessageProcessor.f(this.a).getAccount();
        structmsg.RspNextSystemMsg localRspNextSystemMsg = new structmsg.RspNextSystemMsg();
        localRspNextSystemMsg.mergeFrom((byte[])paramProtoResp.resp.getWupBuffer());
        new StringBuilder();
        if (localRspNextSystemMsg.head.result.get() != 0) {
          this.a.a(4006, false, null);
        }
        ArrayList localArrayList = new ArrayList();
        Object localObject1 = localRspNextSystemMsg.msgs.get();
        int j = ((List)localObject1).size();
        if (QLog.isColorLevel())
        {
          paramProtoResp = new StringBuilder();
          paramProtoResp.append("<---sendGetNextFriendSystemMsg Resp : decode pb size = ");
          paramProtoResp.append(j);
          QLog.e("Q.systemmsg.", 2, paramProtoResp.toString());
        }
        int i = 0;
        paramProtoResp = paramProtoReq;
        Object localObject2;
        if (i < j)
        {
          paramProtoReq = MessageRecordFactory.a(-2018);
          paramProtoReq.msgtype = -2018;
          paramProtoReq.selfuin = str1;
          paramProtoReq.frienduin = AppConstants.FRIEND_SYSTEM_MSG_UIN;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(((structmsg.StructMsg)((List)localObject1).get(i)).req_uin.get());
          ((StringBuilder)localObject2).append("");
          paramProtoReq.senderuin = ((StringBuilder)localObject2).toString();
          paramProtoReq.istroop = 0;
          paramProtoReq.time = ((structmsg.StructMsg)((List)localObject1).get(i)).msg_time.get();
          paramProtoReq.isread = true;
          localObject2 = (MessageForSystemMsg)paramProtoReq;
          ((MessageForSystemMsg)localObject2).structMsg = ((structmsg.StructMsg)((structmsg.StructMsg)((List)localObject1).get(i)).get());
          paramProtoReq.msgData = ((MessageForSystemMsg)localObject2).structMsg.toByteArray();
          ((MessageForSystemMsg)localObject2).parse();
          localArrayList.add(localObject2);
          i += 1;
          continue;
        }
        if (localArrayList.size() > 0)
        {
          i = localArrayList.size();
          long l1 = ((MessageRecord)localArrayList.get(0)).time;
          long l2 = ((MessageRecord)localArrayList.get(i - 1)).time;
          long l3 = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getOldestSysMsgTime(SystemMessageProcessor.g(this.a));
          paramProtoReq = ((IMessageFacade)SystemMessageProcessor.h(this.a).getRuntimeService(IMessageFacade.class, "")).getAIOList(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, l3).iterator();
          if (paramProtoReq.hasNext())
          {
            localObject1 = (ChatMessage)paramProtoReq.next();
            if ((((ChatMessage)localObject1).time >= l2) && (((ChatMessage)localObject1).time <= l1))
            {
              ((IMessageFacade)SystemMessageProcessor.i(this.a).getRuntimeService(IMessageFacade.class, "")).removeMsgByUniseq(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, ((ChatMessage)localObject1).uniseq, false);
              paramProtoReq.remove();
              break label946;
            }
            if (!(localObject1 instanceof MessageForSystemMsg)) {
              break label946;
            }
            localObject2 = (MessageForSystemMsg)localObject1;
            if (((MessageForSystemMsg)localObject2).structMsg == null) {
              ((MessageForSystemMsg)localObject2).parse();
            }
            String str2 = ((MessageForSystemMsg)localObject2).senderuin;
            if ((((MessageForSystemMsg)localObject2).structMsg.msg.sub_type.get() != 13) || (!paramProtoResp.n(str2))) {
              break label946;
            }
            ((IMessageFacade)SystemMessageProcessor.j(this.a).getRuntimeService(IMessageFacade.class, "")).removeMsgByUniseq(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0, ((ChatMessage)localObject1).uniseq, false);
            paramProtoReq.remove();
            break label946;
          }
          ((INewFriendApi)QRoute.api(INewFriendApi.class)).setOldestSysMsgTime(SystemMessageProcessor.k(this.a), l2);
          if (localArrayList.size() < 20) {
            ((INewFriendApi)QRoute.api(INewFriendApi.class)).setHasNoMoreMsg(true, SystemMessageProcessor.l(this.a));
          }
          l2 = localRspNextSystemMsg.following_friend_seq.get();
          l1 = l2;
          if (l2 <= 0L) {
            l1 = ((MessageCache)SystemMessageProcessor.m(this.a).getMsgCache()).y("following_friend_seq_47");
          }
          if (QLog.isColorLevel())
          {
            paramProtoResp = new StringBuilder();
            paramProtoResp.append("<---sendGetNextFriendSystemMsg : decode pb following_friend_seq");
            paramProtoResp.append(l1);
            QLog.e("Q.systemmsg.", 2, paramProtoResp.toString());
          }
          ((MessageCache)SystemMessageProcessor.n(this.a).getMsgCache()).e("following_friend_seq_47", l1);
          paramProtoResp = (IMessageFacade)SystemMessageProcessor.p(this.a).getRuntimeService(IMessageFacade.class, "");
          paramProtoReq = String.valueOf(str1);
          if ((!MessageHandlerUtils.a(localArrayList)) || (!SystemMessageProcessor.o(this.a).isBackgroundStop)) {
            break label949;
          }
          bool = true;
          paramProtoResp.addMessage(localArrayList, paramProtoReq, bool);
          this.a.a("handleGetSystemMsgResp", true, localArrayList.size(), false, false);
        }
        else
        {
          ((INewFriendApi)QRoute.api(INewFriendApi.class)).setHasNoMoreMsg(true, SystemMessageProcessor.q(this.a));
        }
        this.a.a(4005, true, null);
        return;
      }
      catch (Exception paramProtoResp)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.systemmsg.", 2, "clearFriendSystemMsgResp exception", paramProtoResp);
        }
        this.a.a(4006, false, null);
        return;
      }
      label946:
      continue;
      label949:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.SystemMessageProcessor.9
 * JD-Core Version:    0.7.0.1
 */