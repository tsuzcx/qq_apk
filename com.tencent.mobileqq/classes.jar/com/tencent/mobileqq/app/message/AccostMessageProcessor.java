package com.tencent.mobileqq.app.message;

import AccostSvc.Msg;
import AccostSvc.MsgItem;
import AccostSvc.RichMsg;
import AccostSvc.SvrMsg;
import AccostSvc.UserInfo;
import MessageSvcPack.AccostMsg;
import MessageSvcPack.SvcGetMsgInfo;
import MessageSvcPack.SvcResponseGetMsgV2;
import QQService.PushCardMsg;
import QQService.PushType;
import QQService.PushVoteIncreaseInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.BaseMessageProcessor;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.handler.PreDownloadMsg;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.open.appcommon.Common;
import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class AccostMessageProcessor
  extends BaseMessageProcessor
{
  public AccostMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private RichMsg a(byte[] paramArrayOfByte)
  {
    RichMsg localRichMsg;
    try
    {
      localRichMsg = new RichMsg();
    }
    catch (Exception paramArrayOfByte)
    {
      label31:
      break label31;
    }
    try
    {
      paramArrayOfByte = new JceInputStream(paramArrayOfByte);
      paramArrayOfByte.setServerEncoding("utf-8");
      localRichMsg.readFrom(paramArrayOfByte);
      return localRichMsg;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
    return localRichMsg;
  }
  
  private void a(long paramLong, AccostMessageProcessor.OriginalAccostMsg paramOriginalAccostMsg)
  {
    ArrayList localArrayList = paramOriginalAccostMsg.e;
    int i = 0;
    try
    {
      while (i < localArrayList.size())
      {
        Object localObject1 = (MsgItem)localArrayList.get(i);
        new String(((MsgItem)localObject1).MsgContent);
        if (-56 == ((MsgItem)localObject1).cType)
        {
          localObject1 = new JceInputStream(((MsgItem)localObject1).MsgContent);
          ((JceInputStream)localObject1).setServerEncoding("utf-8");
          Object localObject2 = new PushCardMsg();
          ((PushCardMsg)localObject2).readFrom((JceInputStream)localObject1);
          if (PushType.PUSH_TYPE_VOTE_INCR.value() == ((PushCardMsg)localObject2).ePushType)
          {
            localObject2 = new JceInputStream(((PushCardMsg)localObject2).vPushInfo);
            ((JceInputStream)localObject2).setServerEncoding("utf-8");
            localObject1 = new PushVoteIncreaseInfo();
            ((PushVoteIncreaseInfo)localObject1).readFrom((JceInputStream)localObject2);
            if (((PushVoteIncreaseInfo)localObject1).iIncrement > 0)
            {
              localObject2 = (CardHandler)this.q.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
              if (localObject2 != null) {
                ((CardHandler)localObject2).a((PushVoteIncreaseInfo)localObject1, String.valueOf(paramLong), String.valueOf(paramOriginalAccostMsg.b));
              }
            }
          }
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramOriginalAccostMsg)
    {
      paramOriginalAccostMsg.printStackTrace();
    }
  }
  
  private void a(long paramLong, AccostMessageProcessor.OriginalAccostMsg paramOriginalAccostMsg, SvcGetMsgInfo paramSvcGetMsgInfo, boolean paramBoolean)
  {
    Object localObject2 = this;
    String str2 = "Q.msg.BaseMessageProcessor";
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = paramOriginalAccostMsg.e;
    String str1 = paramOriginalAccostMsg.f;
    int i = -1000;
    int j = 0;
    for (;;)
    {
      long l2 = paramLong;
      if (j >= localArrayList1.size()) {
        break;
      }
      MsgItem localMsgItem = (MsgItem)localArrayList1.get(j);
      Object localObject3 = localMsgItem.MsgContent;
      localStringBuilder2 = null;
      Object localObject1 = null;
      if (localObject3 != null) {
        localObject3 = new String(localMsgItem.MsgContent);
      } else {
        localObject3 = null;
      }
      k = localMsgItem.cType;
      for (;;)
      {
        try
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          localStringBuilder3 = new StringBuilder();
        }
        catch (Exception localException1)
        {
          StringBuilder localStringBuilder3;
          long l1;
          long l3;
          boolean bool;
          continue;
          if (k == 1) {
            continue;
          }
          if (k == 19) {
            continue;
          }
          if (k == 3) {
            continue;
          }
          if (k == 4) {
            continue;
          }
          StringBuilder localStringBuilder1 = localStringBuilder2;
          continue;
        }
        try
        {
          localStringBuilder3.append("----------handleAccostMsgItemResp msgItem.cType:");
          localStringBuilder3.append(localMsgItem.cType);
          localStringBuilder3.append(" isReaded:");
          localStringBuilder3.append(paramBoolean);
          QLog.d(str2, 2, localStringBuilder3.toString());
        }
        catch (Exception localException2) {}
      }
      localObject1 = TransfileUtile.makeTransFileProtocolData((String)localObject3, 0L, 2, false, (String)localObject3);
      i = -2002;
      break label253;
      localObject1 = TransfileUtile.makeTransFileProtocolData((String)localObject3, 0L, 1, false, (String)localObject3);
      i = -2000;
      break label253;
      ((AccostMessageProcessor)localObject2).a(l2, paramBoolean, paramOriginalAccostMsg);
      return;
      if (localMsgItem.MsgContent != null) {
        localObject1 = new String(EmotionCodecUtils.a(localMsgItem.MsgContent), "utf-8");
      }
      i = -1000;
      label253:
      break label318;
      if ((localMsgItem.MsgContent != null) && (QLog.isColorLevel()))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("----------handleAccostMsgItemResp msgItem.MsgContent:");
        ((StringBuilder)localObject1).append(HexUtil.bytes2HexStr(localMsgItem.MsgContent));
        QLog.w(str2, 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = null;
      label318:
      if (localObject1 != null)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("----------handleAccostMsgItemResp accostMsg.eAccostType");
          localStringBuilder2.append(paramOriginalAccostMsg.a);
          localStringBuilder2.append("accostMsg.msgId: ");
          localStringBuilder2.append(paramOriginalAccostMsg.c);
          localStringBuilder2.append(" accostMsg.time");
          localStringBuilder2.append(paramOriginalAccostMsg.d);
          localStringBuilder2.append(" msgConten: ");
          localStringBuilder2.append(MessageRecordUtil.a((String)localObject1));
          QLog.d(str2, 2, localStringBuilder2.toString());
        }
        l1 = paramOriginalAccostMsg.b;
        if (paramOriginalAccostMsg.a == 1) {
          l1 = 9999L;
        }
        for (;;)
        {
          break;
          if (paramOriginalAccostMsg.a == 201)
          {
            localObject1 = ActionMsgUtil.a((String)localObject1, str1);
            if (i == -2000) {
              i = -1032;
            } else if (i == -2002) {
              i = -1031;
            } else {
              i = -1003;
            }
          }
          else if (paramOriginalAccostMsg.a == 6)
          {
            ((AccostMessageProcessor)localObject2).a(str1, l2, false);
            localObject1 = ActionMsgUtil.a((String)localObject1, str1);
            i = -3001;
          }
          else if ((str1 != null) && (str1.length() > 0))
          {
            localObject1 = ActionMsgUtil.a((String)localObject1, str1);
            i = -3000;
          }
        }
        localObject2 = MessageRecordFactory.a(i);
        l2 = paramOriginalAccostMsg.b;
        l3 = paramOriginalAccostMsg.d;
        ((MessageRecord)localObject2).init(paramLong, l1, l2, (String)localObject1, l3, i, 1001, 0L);
        ((MessageRecord)localObject2).shmsgseq = paramOriginalAccostMsg.c;
        ((MessageRecord)localObject2).isread = paramBoolean;
        if ((paramSvcGetMsgInfo != null) && (paramSvcGetMsgInfo.vReserved != null) && (paramSvcGetMsgInfo.vReserved.length >= 2))
        {
          ((MessageRecord)localObject2).longMsgCount = paramSvcGetMsgInfo.vReserved[0];
          ((MessageRecord)localObject2).longMsgIndex = paramSvcGetMsgInfo.vReserved[1];
          ((MessageRecord)localObject2).longMsgId = paramSvcGetMsgInfo.vReserved[2];
        }
        if ((localObject2 instanceof MessageForPic))
        {
          localObject1 = (MessageForPic)localObject2;
          ((MessageForPic)localObject1).subVersion = 2;
          if (i == -2000)
          {
            ((MessageForPic)localObject1).path = ((String)localObject3);
            ((MessageForPic)localObject1).uuid = ((String)localObject3);
            ((MessageForPic)localObject1).size = 0L;
            ((MessageForPic)localObject1).type = 1;
            ((MessageForPic)localObject1).isRead = false;
          }
        }
        else if ((localObject2 instanceof MessageForPtt))
        {
          localObject1 = (MessageForPtt)localObject2;
          ((MessageForPtt)localObject1).subVersion = 2;
          ((MessageForPtt)localObject1).url = ((String)localObject3);
          ((MessageForPtt)localObject1).urlAtServer = ((String)localObject3);
          ((MessageForPtt)localObject1).itemType = 2;
          ((MessageForPtt)localObject1).fileSize = 0L;
          ((MessageForPtt)localObject1).isread = false;
        }
        localObject1 = this;
        if (!MessageHandlerUtils.a(((AccostMessageProcessor)localObject1).q, (MessageRecord)localObject2, false)) {
          localArrayList2.add(localObject2);
        }
      }
      else
      {
        localObject1 = localObject2;
      }
      j += 1;
      localObject2 = localObject1;
    }
    paramBoolean = true;
    if (localArrayList2.size() > 0)
    {
      bool = MessageHandlerUtils.a(localArrayList2);
      i = MsgProxyUtils.a(localArrayList2, (MessageCache)((AccostMessageProcessor)localObject2).q.getMsgCache());
      paramOriginalAccostMsg = (IMessageFacade)((AccostMessageProcessor)localObject2).q.getRuntimeService(IMessageFacade.class, "");
      if ((!bool) || (!((AccostMessageProcessor)localObject2).q.isBackgroundStop)) {
        paramBoolean = false;
      }
      paramOriginalAccostMsg.addMessage(localArrayList2, String.valueOf(paramLong), paramBoolean);
      a("handleAccostMsgItemResp", true, i, ((AccostMessageProcessor)localObject2).r.a(bool), false);
    }
  }
  
  private void a(long paramLong1, ArrayList<AccostMsg> paramArrayList, ArrayList<AccostMessageProcessor.DelAccostMsg> paramArrayList1, ArrayList<SvcGetMsgInfo> paramArrayList2, long paramLong2, String paramString)
  {
    int i = 0;
    for (;;)
    {
      Object localObject2 = this;
      if (i >= paramArrayList.size()) {
        break;
      }
      AccostMsg localAccostMsg = (AccostMsg)paramArrayList.get(i);
      Object localObject3 = null;
      Object localObject1 = localObject3;
      if (paramArrayList2 != null)
      {
        localObject1 = localObject3;
        if (paramArrayList2.size() > i) {
          localObject1 = (SvcGetMsgInfo)paramArrayList2.get(i);
        }
      }
      localObject3 = new AccostMessageProcessor.DelAccostMsg();
      ((AccostMessageProcessor.DelAccostMsg)localObject3).a = localAccostMsg.lFromMID;
      ((AccostMessageProcessor.DelAccostMsg)localObject3).b = localAccostMsg.lToMID;
      ((AccostMessageProcessor.DelAccostMsg)localObject3).c = localAccostMsg.uMsgID;
      ((AccostMessageProcessor.DelAccostMsg)localObject3).d = localAccostMsg.shMsgType;
      paramArrayList1.add(localObject3);
      boolean bool = ((AccostMessageProcessor)localObject2).a(String.valueOf(paramLong1), String.valueOf(localAccostMsg.lFromMID));
      if (QLog.isColorLevel())
      {
        MessageHandlerUtils.a("Q.msg.BaseMessageProcessor", paramString, localAccostMsg.uMsgID, String.valueOf(paramLong1), String.valueOf(localAccostMsg.lToMID));
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("----------handleGetAccostMessageResp fromBlackList: ");
        ((StringBuilder)localObject3).append(bool);
        ((StringBuilder)localObject3).append("accostMsg.shMsgType: ");
        ((StringBuilder)localObject3).append(localAccostMsg.shMsgType);
        QLog.d("Q.msg.BaseMessageProcessor", 2, ((StringBuilder)localObject3).toString());
      }
      if ((!bool) && (localAccostMsg.shMsgType == 5))
      {
        localObject2 = ((AccostMessageProcessor)localObject2).a(localAccostMsg.strMsg);
        if (localObject2 != null)
        {
          localObject3 = ((RichMsg)localObject2).VecMsg;
          if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
          {
            paramLong2 = localAccostMsg.lFromMID;
            int j;
            if (localAccostMsg.eAccostType == 0) {
              j = localAccostMsg.iAccostType;
            } else {
              j = localAccostMsg.eAccostType;
            }
            a(paramLong1, new AccostMessageProcessor.OriginalAccostMsg(paramLong2, j, localAccostMsg.uMsgID, localAccostMsg.iMsgTime, (ArrayList)localObject3, ((RichMsg)localObject2).sAction), (SvcGetMsgInfo)localObject1, false);
          }
        }
      }
      i += 1;
    }
  }
  
  private void a(long paramLong, boolean paramBoolean, AccostMessageProcessor.OriginalAccostMsg paramOriginalAccostMsg)
  {
    Object localObject1 = this;
    ArrayList localArrayList = new ArrayList();
    long l = paramOriginalAccostMsg.g;
    int i;
    if (l == paramLong) {
      i = 1;
    } else {
      i = 0;
    }
    new ArrayList();
    SystemMsg localSystemMsg = new SystemMsg();
    Object localObject2 = new StringBuffer();
    int j = 0;
    while (j < paramOriginalAccostMsg.e.size())
    {
      ((StringBuffer)localObject2).append(new String(((MsgItem)paramOriginalAccostMsg.e.get(j)).MsgContent));
      if (j < paramOriginalAccostMsg.e.size() - 1) {
        ((StringBuffer)localObject2).append("\n");
      }
      j += 1;
    }
    localSystemMsg.sMsg = ((StringBuffer)localObject2).toString();
    localSystemMsg.auth = paramOriginalAccostMsg.i;
    localSystemMsg.lToMobile = paramOriginalAccostMsg.j;
    localSystemMsg.strNickName = paramOriginalAccostMsg.h;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("addFriendRequestByOldVersion, addUin=");
      ((StringBuilder)localObject2).append(paramOriginalAccostMsg.g);
      ((StringBuilder)localObject2).append(", msgUid=");
      ((StringBuilder)localObject2).append(paramOriginalAccostMsg.c);
      ((StringBuilder)localObject2).append(", msg=");
      ((StringBuilder)localObject2).append(localSystemMsg.sMsg);
      QLog.d("MessageHandler", 2, ((StringBuilder)localObject2).toString());
    }
    localObject2 = null;
    Friends localFriends = ((FriendsManager)((AccostMessageProcessor)localObject1).q.getManager(QQManagerFactory.FRIENDS_MANAGER)).m(String.valueOf(l));
    if (localFriends != null)
    {
      localObject1 = ContactUtils.a(localFriends);
    }
    else
    {
      ((FriendListHandler)((AccostMessageProcessor)localObject1).q.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(String.valueOf(l));
      localObject1 = localObject2;
    }
    if ((localObject1 != null) && (((String)localObject1).length() != 0))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(BaseApplication.getContext().getString(2131886233));
      localSystemMsg.message = ((StringBuilder)localObject2).toString();
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(l);
      ((StringBuilder)localObject1).append(BaseApplication.getContext().getString(2131886233));
      localSystemMsg.message = ((StringBuilder)localObject1).toString();
    }
    localObject1 = new JceOutputStream();
    ((JceOutputStream)localObject1).setServerEncoding("UTF-8");
    localSystemMsg.writeTo((JceOutputStream)localObject1);
    localObject2 = HexUtil.bytes2HexStr(((JceOutputStream)localObject1).toByteArray());
    if (localObject2 != null)
    {
      localObject1 = MessageRecordFactory.a(-1011);
      ((MessageRecord)localObject1).init(paramLong, 9998L, l, (String)localObject2, 0L, -1011, 0, paramOriginalAccostMsg.d);
      ((MessageRecord)localObject1).shmsgseq = 187L;
      ((MessageRecord)localObject1).msgUid = paramOriginalAccostMsg.c;
      if (paramBoolean) {
        ((MessageRecord)localObject1).isread = true;
      }
      ((MessageRecord)localObject1).issend = i;
      if (!MessageHandlerUtils.a(this.q, (MessageRecord)localObject1, true))
      {
        localArrayList.add(localObject1);
      }
      else if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("addFriendRequestByOldVersion, the message is remove by msgFilter, addUin=");
        ((StringBuilder)localObject2).append(paramOriginalAccostMsg.g);
        ((StringBuilder)localObject2).append(", msgUid=");
        ((StringBuilder)localObject2).append(((MessageRecord)localObject1).msgUid);
        ((StringBuilder)localObject2).append(", msg=");
        ((StringBuilder)localObject2).append(localSystemMsg.sMsg);
        QLog.d("MessageHandler", 2, ((StringBuilder)localObject2).toString());
      }
    }
    paramOriginalAccostMsg = this;
    if (localArrayList.size() > 0)
    {
      i = MsgProxyUtils.a(localArrayList, (MessageCache)paramOriginalAccostMsg.q.getMsgCache());
      ((IMessageFacade)paramOriginalAccostMsg.q.getRuntimeService(IMessageFacade.class, "")).setAutoPullC2CMsgResult(String.valueOf(9998L), 0, localArrayList, true);
      ((IMessageFacade)paramOriginalAccostMsg.q.getRuntimeService(IMessageFacade.class, "")).addMessage(localArrayList, String.valueOf(paramLong));
      a("addFriendRequestByOldVersion", true, i, true, false);
      PreDownloadMsg.a(localArrayList, true, paramOriginalAccostMsg.q);
    }
  }
  
  private void a(String paramString, long paramLong, boolean paramBoolean)
  {
    paramString = Common.b(paramString);
    String str = (String)paramString.get("appid");
    paramString = (String)paramString.get("via");
    if (TextUtils.isEmpty("via")) {
      paramString = "ANDROIDQQ.PCPUSH";
    }
    if (str != null) {
      OpenSdkStatic.a().a(String.valueOf(paramLong), str, paramString, "100", paramBoolean);
    }
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    paramString1 = ((FriendsManager)this.q.getManager(QQManagerFactory.FRIENDS_MANAGER)).m(paramString2);
    return (paramString1 != null) && (paramString1.groupid == -1002);
  }
  
  private boolean a(String paramString1, String paramString2, long paramLong)
  {
    EntityManager localEntityManager = this.q.getEntityManagerFactory(String.valueOf(paramString1)).createEntityManager();
    paramString1 = localEntityManager.query(false, MessageRecord.getTableName(paramString2, 1001), null, "msgseq=?", new String[] { String.valueOf(paramLong) }, null, null, null, null);
    if (paramString1 != null) {}
    int i;
    try
    {
      i = paramString1.getCount();
    }
    finally
    {
      if (paramString1 != null) {
        paramString1.close();
      }
    }
    paramString1.close();
    paramString1 = localEntityManager.query(false, MessageRecord.getTableName(paramString2, 10002), null, "msgseq=?", new String[] { String.valueOf(paramLong) }, null, null, null, null);
    if (paramString1 != null) {}
    int j;
    try
    {
      j = paramString1.getCount();
    }
    finally
    {
      if (paramString1 != null) {
        paramString1.close();
      }
    }
    paramString1.close();
    return i + j > 0;
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    paramObject = (SvrMsg)paramObject;
    if (paramObject.stMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "handlePushAccostMsg sMsg.stMsg is null");
      }
      return;
    }
    if (paramFromServiceMsg.getUin() == null) {
      paramToServiceMsg = this.q.getAccount();
    } else {
      paramToServiceMsg = paramFromServiceMsg.getUin();
    }
    boolean bool = a(paramFromServiceMsg.getUin(), String.valueOf(paramObject.stMsg.lFromMID));
    if (QLog.isColorLevel()) {
      MessageHandlerUtils.a("Q.msg.BaseMessageProcessor", (String)paramFromServiceMsg.getAttribute("_tag_LOGSTR"), paramObject.stMsg.uMsgID, paramToServiceMsg, String.valueOf(paramObject.stMsg.lFromMID));
    }
    if (!bool)
    {
      int i = paramObject.stMsg.shMsgType;
      if (i != 5)
      {
        if (i == 9)
        {
          paramFromServiceMsg = a(paramObject.stMsg.strMsg);
          if (paramFromServiceMsg != null)
          {
            paramFromServiceMsg = new AccostMessageProcessor.OriginalAccostMsg(paramObject.stMsg.lFromMID, paramFromServiceMsg.VecMsg);
            a(Long.valueOf(paramToServiceMsg).longValue(), paramFromServiceMsg);
          }
        }
      }
      else if ((paramObject.bResend != 1) || (!a(paramToServiceMsg, String.valueOf(paramObject.stMsg.lFromMID), paramObject.stMsg.uMsgID)))
      {
        paramFromServiceMsg = a(paramObject.stMsg.strMsg);
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.VecMsg != null))
        {
          Object localObject = paramFromServiceMsg.VecMsg;
          localObject = new AccostMessageProcessor.OriginalAccostMsg(paramObject.stMsg.lFromMID, paramObject.stMsg.eAccostType, paramObject.stMsg.uMsgID, paramObject.stMsg.iMsgTime, (ArrayList)localObject, paramFromServiceMsg.sAction);
          if (paramFromServiceMsg.stSender != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "handlePushAccostMsg richMsg.stSender is null");
            }
            ((AccostMessageProcessor.OriginalAccostMsg)localObject).g = paramFromServiceMsg.stSender.lMobileUin;
            ((AccostMessageProcessor.OriginalAccostMsg)localObject).i = paramFromServiceMsg.stSender.sig;
            ((AccostMessageProcessor.OriginalAccostMsg)localObject).h = paramFromServiceMsg.stSender.nickname;
          }
          ((AccostMessageProcessor.OriginalAccostMsg)localObject).j = paramObject.stMsg.lFromMID;
          a(Long.valueOf(paramToServiceMsg).longValue(), (AccostMessageProcessor.OriginalAccostMsg)localObject, null, false);
        }
      }
    }
    a(paramObject);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramObject = (SvcResponseGetMsgV2)paramObject;
    if ((paramObject != null) && (paramObject.cReplyCode == 0))
    {
      if (paramFromServiceMsg.getUin() == null) {
        paramFromServiceMsg = this.q.getAccount();
      } else {
        paramFromServiceMsg = paramFromServiceMsg.getUin();
      }
      long l = Long.valueOf(paramFromServiceMsg).longValue();
      int j = paramObject.cMoreMsg;
      paramFromServiceMsg = paramObject.vCookies;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("<GetMsgV4><R>--->handleGetLbsMessageResp ssoSeq:");
        ((StringBuilder)localObject).append(paramToServiceMsg.getRequestSsoSeq());
        ((StringBuilder)localObject).append(" msgStruct.cReplyCode: ");
        ((StringBuilder)localObject).append(paramObject.cReplyCode);
        ((StringBuilder)localObject).append(" vCookies:");
        ((StringBuilder)localObject).append(paramFromServiceMsg);
        ((StringBuilder)localObject).append(" size:");
        int i;
        if (paramFromServiceMsg != null) {
          i = paramFromServiceMsg.length;
        } else {
          i = 0;
        }
        ((StringBuilder)localObject).append(i);
        QLog.d("Q.msg.BaseMessageProcessor", 2, ((StringBuilder)localObject).toString());
      }
      paramToServiceMsg = paramObject.vAccostMsg;
      Object localObject = new ArrayList();
      ArrayList localArrayList = paramObject.vMsgInfos;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("<---handleGetLbsMessageResp : moreMsg: ");
        localStringBuilder.append(j);
        localStringBuilder.append("cSyncFlag:");
        localStringBuilder.append(paramObject.cSyncFlag);
        QLog.d("Q.msg.BaseMessageProcessor", 2, localStringBuilder.toString());
      }
      if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0))
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("----------handleGetC2CMessageResp accostMsg size: ");
          localStringBuilder.append(paramToServiceMsg.size());
          QLog.d("Q.msg.BaseMessageProcessor", 2, localStringBuilder.toString());
        }
        a(l, paramToServiceMsg, (ArrayList)localObject, localArrayList, 0L, "handleGetLbsMessageResp");
      }
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.length > 0)) {
        a(paramFromServiceMsg, paramObject.cSyncFlag);
      } else if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "<---handleGetLbsMessageResp. final resp of LbsMessage.");
      }
      if (((ArrayList)localObject).size() > 0) {
        a(null, (ArrayList)localObject);
      }
      return;
    }
    this.r.c(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramInt != 5002) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.msg.BaseMessageProcessor", 2, "<GetMsgV4><E>handleGetLbsOfflineMessageError ");
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 5001)
    {
      if (paramInt != 5002) {
        return;
      }
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        c((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      b((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  public void a(SvrMsg paramSvrMsg)
  {
    ToServiceMsg localToServiceMsg = this.r.createToServiceMsg("AccostSvc.SvrMsg");
    localToServiceMsg.extraData.putSerializable("SvrMsg", paramSvrMsg);
    this.r.send(localToServiceMsg);
  }
  
  public void a(ArrayList<AccostMessageProcessor.DelBuddyMsg> paramArrayList, ArrayList<AccostMessageProcessor.DelAccostMsg> paramArrayList1)
  {
    ToServiceMsg localToServiceMsg = this.r.createToServiceMsg("MessageSvc.DelMsgV2");
    int j = 0;
    long[] arrayOfLong;
    Object localObject;
    short[] arrayOfShort;
    int i;
    StringBuilder localStringBuilder;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      arrayOfLong = new long[paramArrayList.size()];
      localObject = new int[paramArrayList.size()];
      arrayOfShort = new short[paramArrayList.size()];
      i = 0;
      while (i < paramArrayList.size())
      {
        arrayOfLong[i] = ((AccostMessageProcessor.DelBuddyMsg)paramArrayList.get(i)).a;
        localObject[i] = ((AccostMessageProcessor.DelBuddyMsg)paramArrayList.get(i)).b;
        arrayOfShort[i] = ((AccostMessageProcessor.DelBuddyMsg)paramArrayList.get(i)).c;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("--->>delC2CMessage i: ");
          localStringBuilder.append(i);
          localStringBuilder.append(" fromUin:");
          localStringBuilder.append(arrayOfLong[i]);
          localStringBuilder.append(" msgTime: ");
          localStringBuilder.append(localObject[i]);
          localStringBuilder.append(" msgSeq:");
          localStringBuilder.append(arrayOfShort[i]);
          QLog.d("Q.msg.BaseMessageProcessor", 2, localStringBuilder.toString());
        }
        i += 1;
      }
      localToServiceMsg.extraData.putLongArray("fromUin", arrayOfLong);
      localToServiceMsg.extraData.putIntArray("msgTime", (int[])localObject);
      localToServiceMsg.extraData.putShortArray("msgSeq", arrayOfShort);
    }
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0))
    {
      paramArrayList = new long[paramArrayList1.size()];
      arrayOfLong = new long[paramArrayList1.size()];
      localObject = new long[paramArrayList1.size()];
      arrayOfShort = new short[paramArrayList1.size()];
      i = j;
      while (i < paramArrayList1.size())
      {
        paramArrayList[i] = ((AccostMessageProcessor.DelAccostMsg)paramArrayList1.get(i)).a;
        arrayOfLong[i] = ((AccostMessageProcessor.DelAccostMsg)paramArrayList1.get(i)).b;
        localObject[i] = ((AccostMessageProcessor.DelAccostMsg)paramArrayList1.get(i)).c;
        arrayOfShort[i] = ((AccostMessageProcessor.DelAccostMsg)paramArrayList1.get(i)).d;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("--->>delC2CMessage i: ");
          localStringBuilder.append(i);
          localStringBuilder.append(" fromUin:");
          localStringBuilder.append(paramArrayList[i]);
          localStringBuilder.append(" msgId: ");
          localStringBuilder.append(localObject[i]);
          localStringBuilder.append(" msgType:");
          localStringBuilder.append(arrayOfShort[i]);
          QLog.d("Q.msg.BaseMessageProcessor", 2, localStringBuilder.toString());
        }
        i += 1;
      }
      localToServiceMsg.extraData.putLongArray("accostFromUin", paramArrayList);
      localToServiceMsg.extraData.putLongArray("accostToUin", arrayOfLong);
      localToServiceMsg.extraData.putLongArray("accostMsgId", (long[])localObject);
      localToServiceMsg.extraData.putShortArray("accostMsgType", arrayOfShort);
    }
    this.r.send(localToServiceMsg);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<GetMsgV4><S>--->getLbsOfflineMsg : cChannel:4,syncFlag:");
      localStringBuilder.append(paramInt);
      QLog.d("Q.msg.BaseMessageProcessor", 2, localStringBuilder.toString());
    }
    a(false, false, false, 0L, new AccostMessageProcessor.1(this, paramArrayOfByte, paramInt));
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramInt != 5002) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.msg.BaseMessageProcessor", 2, "<GetMsgV4><E>handleGetLbsOfflineMessageTimeOut ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.AccostMessageProcessor
 * JD-Core Version:    0.7.0.1
 */