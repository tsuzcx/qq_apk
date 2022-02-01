package com.tencent.av.chatroom;

import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.VideoServlet;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.SeqUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.NewIntent;
import tencent.av.chatroom.chatroom_sso.Msg;
import tencent.av.chatroom.chatroom_sso.PushMsg;
import tencent.av.chatroom.chatroom_sso.ReqGetMsg;
import tencent.av.chatroom.chatroom_sso.ReqSendMsg;
import tencent.av.chatroom.chatroom_sso.RoomKey;

public class ChatRoomMng
  implements Handler.Callback
{
  Comparator<ChatRoomMsg> a = new ChatRoomMng.1(this);
  private final VideoAppInterface b;
  private final ConcurrentLinkedQueue<ChatRoomInfo> c = new ConcurrentLinkedQueue();
  private final ConcurrentLinkedQueue<ChatRoomObserver> d = new ConcurrentLinkedQueue();
  private final ConcurrentHashMap<ChatRoomInfo, ConcurrentLinkedQueue<ChatRoomMsg>> e = new ConcurrentHashMap();
  private final Handler f;
  private int g = 0;
  
  public ChatRoomMng(VideoAppInterface paramVideoAppInterface)
  {
    this.b = paramVideoAppInterface;
    this.f = new Handler(Looper.getMainLooper(), this);
  }
  
  private ChatRoomInfo a(chatroom_sso.RoomKey paramRoomKey)
  {
    Object localObject1 = SessionMgr.a().b();
    int i = ((SessionInfo)localObject1).x();
    long l5 = ((SessionInfo)localObject1).y();
    long l3 = ((SessionInfo)localObject1).D();
    long l4 = ((SessionInfo)localObject1).E();
    long l2 = l3;
    long l1 = l4;
    Object localObject2;
    if (i == paramRoomKey.type.get())
    {
      l2 = l3;
      l1 = l4;
      if (l5 == paramRoomKey.id.get())
      {
        localObject2 = this.b.b();
        if (localObject2 != null) {
          ((VideoController)localObject2).a("pushMsg", (SessionInfo)localObject1);
        }
        l2 = ((SessionInfo)localObject1).D();
        l1 = ((SessionInfo)localObject1).E();
      }
    }
    if ((i == paramRoomKey.type.get()) && (l5 == paramRoomKey.id.get()) && (l2 == paramRoomKey.room_id.get()) && (l1 == paramRoomKey.create_ts.get())) {
      localObject1 = a((SessionInfo)localObject1);
    } else {
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (ChatRoomInfo)localIterator.next();
        if ((localObject2 != null) && (((ChatRoomInfo)localObject2).a == paramRoomKey.type.get()) && (((ChatRoomInfo)localObject2).c == paramRoomKey.id.get()) && (((ChatRoomInfo)localObject2).d == paramRoomKey.create_ts.get()) && (((ChatRoomInfo)localObject2).b != paramRoomKey.room_id.get()))
        {
          paramRoomKey = (chatroom_sso.RoomKey)localObject2;
          break label289;
        }
      }
      paramRoomKey = null;
      label289:
      if (paramRoomKey != localObject1) {
        a(paramRoomKey);
      }
    }
    if (QLog.isColorLevel())
    {
      paramRoomKey = new StringBuilder();
      paramRoomKey.append("checkFromPushMsg, curRoomInfo[");
      paramRoomKey.append(localObject1);
      paramRoomKey.append("]");
      QLog.i("ChatRoomMng", 2, paramRoomKey.toString());
    }
    return localObject1;
  }
  
  private void a(int paramInt, ChatRoomInfo paramChatRoomInfo)
  {
    this.g = (paramInt | this.g);
    if (!this.f.hasMessages(1, paramChatRoomInfo))
    {
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramChatRoomInfo;
      this.f.sendMessage(localMessage);
    }
  }
  
  private void a(ChatRoomMsg paramChatRoomMsg)
  {
    if (paramChatRoomMsg != null)
    {
      if (paramChatRoomMsg.e == null) {
        return;
      }
      ChatRoomInfo localChatRoomInfo = paramChatRoomMsg.e;
      long l1 = 0L;
      try
      {
        l2 = Long.parseLong(this.b.getCurrentAccountUin());
        l1 = l2;
      }
      catch (Throwable localThrowable)
      {
        QLog.i("ChatRoomMng", 1, "sendMsg get self uin fail.", localThrowable);
      }
      long l2 = AudioHelper.c();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("sendMsg, seq[");
        ((StringBuilder)localObject1).append(l2);
        ((StringBuilder)localObject1).append("], room[");
        ((StringBuilder)localObject1).append(localChatRoomInfo);
        ((StringBuilder)localObject1).append("], msg[");
        ((StringBuilder)localObject1).append(paramChatRoomMsg);
        ((StringBuilder)localObject1).append("]");
        QLog.i("ChatRoomMng", 2, ((StringBuilder)localObject1).toString());
      }
      paramChatRoomMsg.b();
      Object localObject2 = new chatroom_sso.RoomKey();
      ((chatroom_sso.RoomKey)localObject2).type.set(localChatRoomInfo.a);
      ((chatroom_sso.RoomKey)localObject2).room_id.set(localChatRoomInfo.b);
      ((chatroom_sso.RoomKey)localObject2).id.set(localChatRoomInfo.c);
      ((chatroom_sso.RoomKey)localObject2).create_ts.set((int)localChatRoomInfo.d);
      chatroom_sso.Msg localMsg = new chatroom_sso.Msg();
      localMsg.msg.set(paramChatRoomMsg.g);
      localMsg.uin.set(l1);
      Object localObject1 = new chatroom_sso.ReqSendMsg();
      ((chatroom_sso.ReqSendMsg)localObject1).room_key.set((MessageMicro)localObject2);
      ((chatroom_sso.ReqSendMsg)localObject1).msg.set(localMsg);
      localObject2 = new NewIntent(this.b.getApplication(), VideoServlet.class);
      ((NewIntent)localObject2).putExtra("reqType", 21);
      ((NewIntent)localObject2).putExtra("ssoCmd", "QQRTCSvc.chatroom_send_msg");
      ((NewIntent)localObject2).putExtra("vMsg", ((chatroom_sso.ReqSendMsg)localObject1).toByteArray());
      ((NewIntent)localObject2).putExtra("room_key", localChatRoomInfo);
      ((NewIntent)localObject2).putExtra("localSeq", paramChatRoomMsg.h);
      SeqUtil.a((Intent)localObject2, l2);
      this.b.startServlet((NewIntent)localObject2);
      if (paramChatRoomMsg.j == ChatRoomMsg.a) {
        a(1, localChatRoomInfo);
      }
    }
  }
  
  private void b(ChatRoomInfo paramChatRoomInfo, long paramLong)
  {
    if (paramChatRoomInfo == null) {
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doRetryGetMsgList, room[");
      ((StringBuilder)localObject).append(paramChatRoomInfo);
      ((StringBuilder)localObject).append("], retryDelay[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("], canRetry[");
      ((StringBuilder)localObject).append(paramChatRoomInfo.b());
      ((StringBuilder)localObject).append("]");
      QLog.i("ChatRoomMng", 2, ((StringBuilder)localObject).toString());
    }
    paramLong = Math.max(paramLong, 1000L);
    if (paramChatRoomInfo.b())
    {
      localObject = Message.obtain();
      ((Message)localObject).obj = paramChatRoomInfo;
      ((Message)localObject).what = 3;
      this.f.sendMessageDelayed((Message)localObject, paramLong);
    }
  }
  
  private void b(ChatRoomMsg paramChatRoomMsg)
  {
    if (!this.f.hasMessages(2, paramChatRoomMsg))
    {
      Message localMessage = Message.obtain();
      localMessage.what = 2;
      localMessage.obj = paramChatRoomMsg;
      this.f.sendMessage(localMessage);
    }
  }
  
  private ConcurrentLinkedQueue<ChatRoomMsg> c(ChatRoomInfo paramChatRoomInfo)
  {
    ConcurrentLinkedQueue localConcurrentLinkedQueue2 = (ConcurrentLinkedQueue)this.e.get(paramChatRoomInfo);
    ConcurrentLinkedQueue localConcurrentLinkedQueue1 = localConcurrentLinkedQueue2;
    if (localConcurrentLinkedQueue2 == null)
    {
      localConcurrentLinkedQueue1 = new ConcurrentLinkedQueue();
      this.e.put(paramChatRoomInfo, localConcurrentLinkedQueue1);
    }
    return localConcurrentLinkedQueue1;
  }
  
  public ChatRoomInfo a(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      ChatRoomInfo localChatRoomInfo = (ChatRoomInfo)localIterator.next();
      if ((localChatRoomInfo != null) && (localChatRoomInfo.a(paramInt, paramLong1, paramLong2, paramLong3))) {
        return localChatRoomInfo;
      }
    }
    return null;
  }
  
  public ChatRoomInfo a(SessionInfo paramSessionInfo)
  {
    ChatRoomInfo localChatRoomInfo = a(paramSessionInfo, true);
    Object localObject;
    if (localChatRoomInfo != null)
    {
      localObject = (ConcurrentLinkedQueue)this.e.get(localChatRoomInfo);
      if (localObject == null)
      {
        localObject = new ConcurrentLinkedQueue();
        this.e.put(localChatRoomInfo, localObject);
      }
      else
      {
        ((ConcurrentLinkedQueue)localObject).clear();
      }
      localObject = Message.obtain();
      ((Message)localObject).obj = localChatRoomInfo;
      ((Message)localObject).what = 3;
      this.f.sendMessage((Message)localObject);
    }
    if ((QLog.isDevelopLevel()) && (paramSessionInfo != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enterChatRoom, SessionType[");
      ((StringBuilder)localObject).append(paramSessionInfo.g);
      ((StringBuilder)localObject).append("], relationType[");
      ((StringBuilder)localObject).append(paramSessionInfo.aQ);
      ((StringBuilder)localObject).append("], relationId[");
      ((StringBuilder)localObject).append(paramSessionInfo.aN);
      ((StringBuilder)localObject).append("], peerUin[");
      ((StringBuilder)localObject).append(paramSessionInfo.s);
      ((StringBuilder)localObject).append("], extraUin[");
      ((StringBuilder)localObject).append(paramSessionInfo.u);
      ((StringBuilder)localObject).append("], isDoubleVideoMeeting[");
      ((StringBuilder)localObject).append(paramSessionInfo.am);
      ((StringBuilder)localObject).append("], room[");
      ((StringBuilder)localObject).append(localChatRoomInfo);
      ((StringBuilder)localObject).append("]");
      QLog.i("ChatRoomMng", 4, ((StringBuilder)localObject).toString());
    }
    return localChatRoomInfo;
  }
  
  public ChatRoomInfo a(SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    Object localObject;
    if (paramSessionInfo != null)
    {
      int i = paramSessionInfo.x();
      long l5 = paramSessionInfo.y();
      long l3 = paramSessionInfo.D();
      long l4 = paramSessionInfo.E();
      long l2 = l3;
      long l1 = l4;
      if (paramBoolean) {
        if (l3 != 0L)
        {
          l2 = l3;
          l1 = l4;
          if (i == 1)
          {
            l2 = l3;
            l1 = l4;
            if (l4 != 0L) {}
          }
        }
        else
        {
          if (i == 2) {
            VideoController.f().ao();
          } else if (i == 1) {
            VideoController.f().ap();
          }
          l2 = paramSessionInfo.D();
          l1 = paramSessionInfo.E();
        }
      }
      ChatRoomInfo localChatRoomInfo = a(i, l2, l5, l1);
      if ((localChatRoomInfo == null) && (paramBoolean))
      {
        if ((l2 != 0L) && (l5 != 0L) && (i != 0))
        {
          localChatRoomInfo = new ChatRoomInfo(i, l2, l5, l1);
          this.c.add(localChatRoomInfo);
        }
        localObject = localChatRoomInfo;
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getRoomInfo, SessionType[");
          ((StringBuilder)localObject).append(paramSessionInfo.g);
          ((StringBuilder)localObject).append("], relationType[");
          ((StringBuilder)localObject).append(paramSessionInfo.aQ);
          ((StringBuilder)localObject).append("], relationId[");
          ((StringBuilder)localObject).append(paramSessionInfo.aN);
          ((StringBuilder)localObject).append("], peerUin[");
          ((StringBuilder)localObject).append(paramSessionInfo.s);
          ((StringBuilder)localObject).append("], extraUin[");
          ((StringBuilder)localObject).append(paramSessionInfo.u);
          ((StringBuilder)localObject).append("], isDoubleVideoMeeting[");
          ((StringBuilder)localObject).append(paramSessionInfo.am);
          ((StringBuilder)localObject).append("], type[");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append("], roomID[");
          ((StringBuilder)localObject).append(l2);
          ((StringBuilder)localObject).append("], id[");
          ((StringBuilder)localObject).append(l5);
          ((StringBuilder)localObject).append("], createTime[");
          ((StringBuilder)localObject).append(l1);
          ((StringBuilder)localObject).append("], room[");
          ((StringBuilder)localObject).append(localChatRoomInfo);
          ((StringBuilder)localObject).append("]");
          QLog.i("ChatRoomMng", 4, ((StringBuilder)localObject).toString());
          return localChatRoomInfo;
        }
      }
      else
      {
        return localChatRoomInfo;
      }
    }
    else
    {
      localObject = null;
    }
    return localObject;
  }
  
  public ChatRoomMsg a(ChatRoomInfo paramChatRoomInfo, long paramLong)
  {
    Object localObject1 = null;
    if (paramChatRoomInfo == null) {
      return null;
    }
    Object localObject2 = c(paramChatRoomInfo);
    paramChatRoomInfo = localObject1;
    if (localObject2 != null)
    {
      paramChatRoomInfo = localObject1;
      if (((ConcurrentLinkedQueue)localObject2).size() > 0)
      {
        localObject2 = ((ConcurrentLinkedQueue)localObject2).iterator();
        do
        {
          paramChatRoomInfo = localObject1;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          paramChatRoomInfo = (ChatRoomMsg)((Iterator)localObject2).next();
        } while ((paramChatRoomInfo == null) || (paramChatRoomInfo.h != paramLong));
      }
    }
    return paramChatRoomInfo;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomMng", 2, "clearObserver");
    }
    this.d.clear();
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    int i = 4;
    if ((paramInt == 2) && (paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      Object localObject = new chatroom_sso.PushMsg();
      chatroom_sso.Msg localMsg1 = null;
      try
      {
        ((chatroom_sso.PushMsg)localObject).mergeFrom(paramArrayOfByte);
        if (((chatroom_sso.PushMsg)localObject).room_key.has())
        {
          paramArrayOfByte = (chatroom_sso.RoomKey)((chatroom_sso.PushMsg)localObject).room_key.get();
          paramInt = 0;
        }
        else
        {
          paramArrayOfByte = null;
          paramInt = 2;
        }
        try
        {
          if (((chatroom_sso.PushMsg)localObject).msg.has()) {
            localMsg1 = (chatroom_sso.Msg)((chatroom_sso.PushMsg)localObject).msg.get();
          } else {
            paramInt = 3;
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1) {}
        if (!QLog.isColorLevel()) {
          break label128;
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
      {
        paramArrayOfByte = null;
      }
      QLog.i("ChatRoomMng", 2, "processAVChatRoomMsgPush parse fail.", localInvalidProtocolBufferMicroException2);
      label128:
      chatroom_sso.Msg localMsg2 = null;
      paramInt = 1;
      if ((paramArrayOfByte != null) && (localMsg2 != null))
      {
        ChatRoomInfo localChatRoomInfo = a(paramArrayOfByte.type.get(), paramArrayOfByte.room_id.get(), paramArrayOfByte.id.get(), paramArrayOfByte.create_ts.get());
        localObject = localChatRoomInfo;
        if (localChatRoomInfo == null) {
          localObject = a(paramArrayOfByte);
        }
        if (localObject != null)
        {
          a((ChatRoomInfo)localObject, localMsg2, true);
        }
        else
        {
          paramInt = i;
          if (QLog.isDevelopLevel())
          {
            QLog.i("ChatRoomMng", 4, String.format("onReceivePushMsg, [type: %s, room_id: %s, id: %s, create_ts: %s", new Object[] { Integer.valueOf(paramArrayOfByte.type.get()), Long.valueOf(paramArrayOfByte.room_id.get()), Long.valueOf(paramArrayOfByte.id.get()), Integer.valueOf(paramArrayOfByte.create_ts.get()) }));
            paramInt = i;
          }
        }
      }
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("onReceivePushMsg, ret[");
        paramArrayOfByte.append(paramInt);
        paramArrayOfByte.append("]");
        QLog.i("ChatRoomMng", 2, paramArrayOfByte.toString());
      }
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("ChatRoomMng", 4, "onReceivePushMsg params error.");
    }
  }
  
  public void a(VideoController paramVideoController, SessionInfo paramSessionInfo)
  {
    ChatRoomInfo localChatRoomInfo2 = a(paramSessionInfo, false);
    boolean bool = paramVideoController.a("onSwitchTerminalSuccess", paramSessionInfo);
    ChatRoomInfo localChatRoomInfo1 = a(paramSessionInfo, false);
    paramVideoController = localChatRoomInfo1;
    if (localChatRoomInfo1 == null) {
      paramVideoController = a(paramSessionInfo);
    }
    if (paramVideoController != null)
    {
      if (localChatRoomInfo2 != paramVideoController) {
        a(localChatRoomInfo2);
      }
      paramVideoController.j = true;
      if ((localChatRoomInfo2 != paramVideoController) && (localChatRoomInfo2 != null)) {
        paramVideoController.k = localChatRoomInfo2.b;
      }
      this.f.removeMessages(3, paramVideoController);
      paramSessionInfo = Message.obtain();
      paramSessionInfo.obj = paramVideoController;
      paramSessionInfo.what = 3;
      this.f.sendMessage(paramSessionInfo);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomMng", 2, String.format("onSwitchTerminalSuccess, ret[%s], pre[%s], cur[%s]", new Object[] { Boolean.valueOf(bool), localChatRoomInfo2, paramVideoController }));
    }
  }
  
  public void a(ChatRoomInfo paramChatRoomInfo)
  {
    if (paramChatRoomInfo != null)
    {
      this.c.remove(paramChatRoomInfo);
      this.e.remove(paramChatRoomInfo);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeChatRoom, room[");
      localStringBuilder.append(paramChatRoomInfo);
      localStringBuilder.append("]");
      QLog.i("ChatRoomMng", 2, localStringBuilder.toString());
    }
  }
  
  public void a(ChatRoomInfo paramChatRoomInfo, String paramString, long paramLong)
  {
    if (paramChatRoomInfo != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      long l1 = 0L;
      try
      {
        long l2 = Long.parseLong(this.b.getCurrentAccountUin());
        l1 = l2;
      }
      catch (Throwable localThrowable)
      {
        QLog.i("ChatRoomMng", 1, "sendMsg get self uin fail.", localThrowable);
      }
      paramString = new ChatRoomMsg(paramChatRoomInfo, l1, paramString, paramLong, -9223372036854775808L, ChatRoomMsg.a);
      c(paramChatRoomInfo).add(paramString);
      a(paramString);
    }
  }
  
  public void a(ChatRoomInfo paramChatRoomInfo, List<ChatRoomMsg> paramList)
  {
    if (paramChatRoomInfo != null)
    {
      if (paramList == null) {
        return;
      }
      paramChatRoomInfo = (ConcurrentLinkedQueue)this.e.get(paramChatRoomInfo);
      if ((paramChatRoomInfo != null) && (paramChatRoomInfo.size() > 0)) {
        paramList.addAll(paramChatRoomInfo);
      }
      try
      {
        Collections.sort(paramList, this.a);
        return;
      }
      catch (Throwable paramChatRoomInfo)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("ChatRoomMng", 4, "getChatRoomMsg", paramChatRoomInfo);
        }
      }
    }
  }
  
  public void a(ChatRoomInfo paramChatRoomInfo, List<chatroom_sso.Msg> paramList, boolean paramBoolean)
  {
    if ((paramChatRoomInfo != null) && (paramList != null))
    {
      if (paramList.size() == 0) {
        return;
      }
      Object localObject;
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onRecvMsg, room[");
        ((StringBuilder)localObject).append(paramChatRoomInfo);
        ((StringBuilder)localObject).append("], size[");
        ((StringBuilder)localObject).append(paramList.size());
        ((StringBuilder)localObject).append("]");
        QLog.i("ChatRoomMng", 4, ((StringBuilder)localObject).toString());
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (chatroom_sso.Msg)paramList.next();
        if (localObject != null) {
          a(paramChatRoomInfo, (chatroom_sso.Msg)localObject, paramBoolean);
        }
      }
    }
  }
  
  public void a(ChatRoomInfo paramChatRoomInfo, chatroom_sso.Msg paramMsg, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a28 = a22\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\r\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\r\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\nCaused by: java.lang.NullPointerException\r\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:552)\r\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:1)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\r\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\r\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\r\n\t... 17 more\r\n");
  }
  
  public void a(ChatRoomObserver paramChatRoomObserver)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addObserver, observer[");
      localStringBuilder.append(paramChatRoomObserver);
      localStringBuilder.append("]");
      QLog.i("ChatRoomMng", 2, localStringBuilder.toString());
    }
    if ((paramChatRoomObserver != null) && (!this.d.contains(paramChatRoomObserver))) {
      this.d.add(paramChatRoomObserver);
    }
  }
  
  /* Error */
  public void a(String paramString, boolean paramBoolean, int paramInt, Intent paramIntent, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload 4
    //   2: invokestatic 591	com/tencent/av/utils/SeqUtil:a	(Landroid/content/Intent;)J
    //   5: lstore 11
    //   7: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +96 -> 106
    //   13: new 166	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   20: astore 13
    //   22: aload 13
    //   24: ldc_w 593
    //   27: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 13
    //   33: aload_1
    //   34: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload 13
    //   40: ldc_w 595
    //   43: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 13
    //   49: iload_2
    //   50: invokevirtual 359	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 13
    //   56: ldc_w 597
    //   59: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 13
    //   65: iload_3
    //   66: invokevirtual 400	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload 13
    //   72: ldc_w 599
    //   75: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 13
    //   81: lload 11
    //   83: invokevirtual 241	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 13
    //   89: ldc 178
    //   91: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: ldc 180
    //   97: iconst_2
    //   98: aload 13
    //   100: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 188	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   106: ldc_w 308
    //   109: aload_1
    //   110: invokevirtual 602	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   113: istore 8
    //   115: iconst_m1
    //   116: istore 7
    //   118: aconst_null
    //   119: astore 16
    //   121: aconst_null
    //   122: astore 15
    //   124: aconst_null
    //   125: astore 14
    //   127: iload 8
    //   129: ifeq +526 -> 655
    //   132: aload 4
    //   134: ldc_w 321
    //   137: invokevirtual 608	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   140: checkcast 147	com/tencent/av/chatroom/ChatRoomInfo
    //   143: astore_1
    //   144: aload 4
    //   146: ldc_w 326
    //   149: lconst_0
    //   150: invokevirtual 612	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   153: lstore 11
    //   155: aload_1
    //   156: ifnull +28 -> 184
    //   159: aload_0
    //   160: aload_1
    //   161: getfield 149	com/tencent/av/chatroom/ChatRoomInfo:a	I
    //   164: aload_1
    //   165: getfield 156	com/tencent/av/chatroom/ChatRoomInfo:b	J
    //   168: aload_1
    //   169: getfield 152	com/tencent/av/chatroom/ChatRoomInfo:c	J
    //   172: aload_1
    //   173: getfield 154	com/tencent/av/chatroom/ChatRoomInfo:d	J
    //   176: invokevirtual 436	com/tencent/av/chatroom/ChatRoomMng:a	(IJJJ)Lcom/tencent/av/chatroom/ChatRoomInfo;
    //   179: astore 4
    //   181: goto +6 -> 187
    //   184: aconst_null
    //   185: astore 4
    //   187: aload 4
    //   189: ifnull +16 -> 205
    //   192: aload_0
    //   193: aload 4
    //   195: lload 11
    //   197: invokevirtual 614	com/tencent/av/chatroom/ChatRoomMng:a	(Lcom/tencent/av/chatroom/ChatRoomInfo;J)Lcom/tencent/av/chatroom/ChatRoomMsg;
    //   200: astore 13
    //   202: goto +6 -> 208
    //   205: aconst_null
    //   206: astore 13
    //   208: aload_0
    //   209: astore 15
    //   211: aload 4
    //   213: ifnull +381 -> 594
    //   216: aload 13
    //   218: ifnonnull +6 -> 224
    //   221: goto +373 -> 594
    //   224: iload_2
    //   225: ifeq +307 -> 532
    //   228: aload 5
    //   230: ifnull +302 -> 532
    //   233: aload 5
    //   235: arraylength
    //   236: ifle +296 -> 532
    //   239: new 616	tencent/av/chatroom/chatroom_sso$RspSendMsg
    //   242: dup
    //   243: invokespecial 617	tencent/av/chatroom/chatroom_sso$RspSendMsg:<init>	()V
    //   246: astore 16
    //   248: iload 7
    //   250: istore_3
    //   251: aload 14
    //   253: astore_1
    //   254: aload 16
    //   256: aload 5
    //   258: invokevirtual 618	tencent/av/chatroom/chatroom_sso$RspSendMsg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   261: pop
    //   262: iload 7
    //   264: istore_3
    //   265: aload 14
    //   267: astore_1
    //   268: aload 16
    //   270: getfield 621	tencent/av/chatroom/chatroom_sso$RspSendMsg:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   273: invokevirtual 102	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   276: istore 6
    //   278: iload 6
    //   280: istore_3
    //   281: aload 14
    //   283: astore_1
    //   284: aload 16
    //   286: getfield 624	tencent/av/chatroom/chatroom_sso$RspSendMsg:err_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   289: invokevirtual 626	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   292: astore 5
    //   294: iload 6
    //   296: istore_3
    //   297: aload 5
    //   299: astore_1
    //   300: aload 16
    //   302: getfield 629	tencent/av/chatroom/chatroom_sso$RspSendMsg:msg_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   305: invokevirtual 102	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   308: istore 7
    //   310: iload 7
    //   312: i2l
    //   313: lstore 9
    //   315: iload 6
    //   317: istore_3
    //   318: aload 5
    //   320: astore_1
    //   321: goto +19 -> 340
    //   324: astore 5
    //   326: ldc 180
    //   328: iconst_1
    //   329: ldc_w 631
    //   332: aload 5
    //   334: invokestatic 232	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   337: lconst_0
    //   338: lstore 9
    //   340: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   343: ifeq +46 -> 389
    //   346: ldc 180
    //   348: iconst_2
    //   349: ldc_w 633
    //   352: iconst_4
    //   353: anewarray 4	java/lang/Object
    //   356: dup
    //   357: iconst_0
    //   358: iload_3
    //   359: invokestatic 496	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   362: aastore
    //   363: dup
    //   364: iconst_1
    //   365: lload 9
    //   367: invokestatic 499	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   370: aastore
    //   371: dup
    //   372: iconst_2
    //   373: aload_1
    //   374: aastore
    //   375: dup
    //   376: iconst_3
    //   377: lload 11
    //   379: invokestatic 499	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   382: aastore
    //   383: invokestatic 505	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   386: invokestatic 188	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   389: iload_3
    //   390: ifeq +55 -> 445
    //   393: aload 13
    //   395: getstatic 635	com/tencent/av/chatroom/ChatRoomMsg:b	I
    //   398: invokevirtual 637	com/tencent/av/chatroom/ChatRoomMsg:a	(I)V
    //   401: aload 15
    //   403: aload 13
    //   405: invokespecial 639	com/tencent/av/chatroom/ChatRoomMng:b	(Lcom/tencent/av/chatroom/ChatRoomMsg;)V
    //   408: aload 13
    //   410: invokevirtual 641	com/tencent/av/chatroom/ChatRoomMsg:c	()Z
    //   413: ifeq +684 -> 1097
    //   416: invokestatic 199	android/os/Message:obtain	()Landroid/os/Message;
    //   419: astore_1
    //   420: aload_1
    //   421: iconst_4
    //   422: putfield 202	android/os/Message:what	I
    //   425: aload_1
    //   426: aload 13
    //   428: putfield 206	android/os/Message:obj	Ljava/lang/Object;
    //   431: aload 15
    //   433: getfield 64	com/tencent/av/chatroom/ChatRoomMng:f	Landroid/os/Handler;
    //   436: aload_1
    //   437: ldc2_w 642
    //   440: invokevirtual 371	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   443: pop
    //   444: return
    //   445: aload 13
    //   447: lload 9
    //   449: putfield 644	com/tencent/av/chatroom/ChatRoomMsg:k	J
    //   452: aload 13
    //   454: getstatic 646	com/tencent/av/chatroom/ChatRoomMsg:c	I
    //   457: invokevirtual 637	com/tencent/av/chatroom/ChatRoomMsg:a	(I)V
    //   460: aload 15
    //   462: aload 13
    //   464: invokespecial 639	com/tencent/av/chatroom/ChatRoomMng:b	(Lcom/tencent/av/chatroom/ChatRoomMsg;)V
    //   467: aload 4
    //   469: getfield 648	com/tencent/av/chatroom/ChatRoomInfo:h	Z
    //   472: ifne +15 -> 487
    //   475: ldc_w 650
    //   478: invokestatic 654	com/tencent/av/chatroom/ChatRoomUtil:b	(Ljava/lang/String;)V
    //   481: aload 4
    //   483: iconst_1
    //   484: putfield 648	com/tencent/av/chatroom/ChatRoomInfo:h	Z
    //   487: aload 4
    //   489: getfield 656	com/tencent/av/chatroom/ChatRoomInfo:i	Z
    //   492: ifne +605 -> 1097
    //   495: aload 13
    //   497: getfield 265	com/tencent/av/chatroom/ChatRoomMsg:g	Ljava/lang/String;
    //   500: invokestatic 542	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   503: ifne +594 -> 1097
    //   506: aload 13
    //   508: getfield 265	com/tencent/av/chatroom/ChatRoomMsg:g	Ljava/lang/String;
    //   511: bipush 20
    //   513: invokevirtual 660	java/lang/String:indexOf	(I)I
    //   516: iflt +581 -> 1097
    //   519: ldc_w 662
    //   522: invokestatic 654	com/tencent/av/chatroom/ChatRoomUtil:b	(Ljava/lang/String;)V
    //   525: aload 4
    //   527: iconst_1
    //   528: putfield 656	com/tencent/av/chatroom/ChatRoomInfo:i	Z
    //   531: return
    //   532: aload 13
    //   534: getstatic 635	com/tencent/av/chatroom/ChatRoomMsg:b	I
    //   537: invokevirtual 637	com/tencent/av/chatroom/ChatRoomMsg:a	(I)V
    //   540: aload 15
    //   542: aload 13
    //   544: invokespecial 639	com/tencent/av/chatroom/ChatRoomMng:b	(Lcom/tencent/av/chatroom/ChatRoomMsg;)V
    //   547: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   550: ifeq +547 -> 1097
    //   553: new 166	java/lang/StringBuilder
    //   556: dup
    //   557: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   560: astore_1
    //   561: aload_1
    //   562: ldc_w 664
    //   565: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: pop
    //   569: aload_1
    //   570: lload 11
    //   572: invokevirtual 241	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   575: pop
    //   576: aload_1
    //   577: ldc 178
    //   579: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: pop
    //   583: ldc 180
    //   585: iconst_2
    //   586: aload_1
    //   587: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   590: invokestatic 188	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   593: return
    //   594: new 166	java/lang/StringBuilder
    //   597: dup
    //   598: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   601: astore 4
    //   603: aload 4
    //   605: ldc_w 666
    //   608: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: pop
    //   612: aload 4
    //   614: lload 11
    //   616: invokevirtual 241	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   619: pop
    //   620: aload 4
    //   622: ldc 243
    //   624: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: pop
    //   628: aload 4
    //   630: aload_1
    //   631: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   634: pop
    //   635: aload 4
    //   637: ldc 178
    //   639: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: pop
    //   643: ldc 180
    //   645: iconst_1
    //   646: aload 4
    //   648: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   651: invokestatic 188	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   654: return
    //   655: ldc_w 668
    //   658: aload_1
    //   659: invokevirtual 602	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   662: ifeq +435 -> 1097
    //   665: aload 4
    //   667: ldc_w 321
    //   670: invokevirtual 608	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   673: checkcast 147	com/tencent/av/chatroom/ChatRoomInfo
    //   676: astore_1
    //   677: aload_1
    //   678: ifnull +28 -> 706
    //   681: aload_0
    //   682: aload_1
    //   683: getfield 149	com/tencent/av/chatroom/ChatRoomInfo:a	I
    //   686: aload_1
    //   687: getfield 156	com/tencent/av/chatroom/ChatRoomInfo:b	J
    //   690: aload_1
    //   691: getfield 152	com/tencent/av/chatroom/ChatRoomInfo:c	J
    //   694: aload_1
    //   695: getfield 154	com/tencent/av/chatroom/ChatRoomInfo:d	J
    //   698: invokevirtual 436	com/tencent/av/chatroom/ChatRoomMng:a	(IJJJ)Lcom/tencent/av/chatroom/ChatRoomInfo;
    //   701: astore 13
    //   703: goto +6 -> 709
    //   706: aconst_null
    //   707: astore 13
    //   709: aload 13
    //   711: ifnonnull +48 -> 759
    //   714: new 166	java/lang/StringBuilder
    //   717: dup
    //   718: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   721: astore 4
    //   723: aload 4
    //   725: ldc_w 670
    //   728: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: pop
    //   732: aload 4
    //   734: aload_1
    //   735: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   738: pop
    //   739: aload 4
    //   741: ldc 178
    //   743: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: pop
    //   747: ldc 180
    //   749: iconst_1
    //   750: aload 4
    //   752: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   755: invokestatic 188	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   758: return
    //   759: ldc2_w 360
    //   762: lstore 9
    //   764: iload_2
    //   765: ifeq +277 -> 1042
    //   768: aload 5
    //   770: ifnull +272 -> 1042
    //   773: aload 5
    //   775: arraylength
    //   776: ifle +266 -> 1042
    //   779: new 672	tencent/av/chatroom/chatroom_sso$RspGetMsg
    //   782: dup
    //   783: invokespecial 673	tencent/av/chatroom/chatroom_sso$RspGetMsg:<init>	()V
    //   786: astore 14
    //   788: iload 7
    //   790: istore 6
    //   792: aload 14
    //   794: aload 5
    //   796: invokevirtual 674	tencent/av/chatroom/chatroom_sso$RspGetMsg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   799: pop
    //   800: iload 7
    //   802: istore 6
    //   804: aload 14
    //   806: getfield 675	tencent/av/chatroom/chatroom_sso$RspGetMsg:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   809: invokevirtual 102	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   812: istore_3
    //   813: iload_3
    //   814: istore 6
    //   816: aload 14
    //   818: getfield 676	tencent/av/chatroom/chatroom_sso$RspGetMsg:err_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   821: invokevirtual 626	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   824: astore_1
    //   825: aload 16
    //   827: astore 5
    //   829: aload 14
    //   831: getfield 680	tencent/av/chatroom/chatroom_sso$RspGetMsg:msg_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   834: invokevirtual 685	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   837: astore 4
    //   839: aload 4
    //   841: astore 5
    //   843: aload 14
    //   845: getfield 689	tencent/av/chatroom/chatroom_sso$RspGetMsg:retry	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   848: invokevirtual 693	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   851: istore_2
    //   852: aload 14
    //   854: getfield 696	tencent/av/chatroom/chatroom_sso$RspGetMsg:retry_delay	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   857: invokevirtual 110	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   860: lstore 11
    //   862: lload 11
    //   864: lstore 9
    //   866: goto +49 -> 915
    //   869: astore 14
    //   871: aload 4
    //   873: astore 5
    //   875: goto +25 -> 900
    //   878: astore 4
    //   880: goto +14 -> 894
    //   883: astore 4
    //   885: aconst_null
    //   886: astore_1
    //   887: aload 15
    //   889: astore 5
    //   891: iload 6
    //   893: istore_3
    //   894: iconst_0
    //   895: istore_2
    //   896: aload 4
    //   898: astore 14
    //   900: ldc 180
    //   902: iconst_1
    //   903: ldc_w 698
    //   906: aload 14
    //   908: invokestatic 232	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   911: aload 5
    //   913: astore 4
    //   915: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   918: ifeq +73 -> 991
    //   921: aload 4
    //   923: ifnonnull +9 -> 932
    //   926: iconst_0
    //   927: istore 6
    //   929: goto +12 -> 941
    //   932: aload 4
    //   934: invokeinterface 567 1 0
    //   939: istore 6
    //   941: ldc 180
    //   943: iconst_2
    //   944: ldc_w 700
    //   947: iconst_5
    //   948: anewarray 4	java/lang/Object
    //   951: dup
    //   952: iconst_0
    //   953: iload_3
    //   954: invokestatic 496	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   957: aastore
    //   958: dup
    //   959: iconst_1
    //   960: aload_1
    //   961: aastore
    //   962: dup
    //   963: iconst_2
    //   964: iload 6
    //   966: invokestatic 496	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   969: aastore
    //   970: dup
    //   971: iconst_3
    //   972: iload_2
    //   973: invokestatic 528	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   976: aastore
    //   977: dup
    //   978: iconst_4
    //   979: lload 9
    //   981: invokestatic 499	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   984: aastore
    //   985: invokestatic 505	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   988: invokestatic 188	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   991: iload_3
    //   992: ifne +41 -> 1033
    //   995: iload_2
    //   996: ifeq +27 -> 1023
    //   999: aload 4
    //   1001: ifnull +13 -> 1014
    //   1004: aload 4
    //   1006: invokeinterface 567 1 0
    //   1011: ifne +12 -> 1023
    //   1014: aload_0
    //   1015: aload 13
    //   1017: lload 9
    //   1019: invokespecial 702	com/tencent/av/chatroom/ChatRoomMng:b	(Lcom/tencent/av/chatroom/ChatRoomInfo;J)V
    //   1022: return
    //   1023: aload_0
    //   1024: aload 13
    //   1026: aload 4
    //   1028: iconst_0
    //   1029: invokevirtual 704	com/tencent/av/chatroom/ChatRoomMng:a	(Lcom/tencent/av/chatroom/ChatRoomInfo;Ljava/util/List;Z)V
    //   1032: return
    //   1033: aload_0
    //   1034: aload 13
    //   1036: lload 9
    //   1038: invokespecial 702	com/tencent/av/chatroom/ChatRoomMng:b	(Lcom/tencent/av/chatroom/ChatRoomInfo;J)V
    //   1041: return
    //   1042: aload_0
    //   1043: aload 13
    //   1045: ldc2_w 360
    //   1048: invokespecial 702	com/tencent/av/chatroom/ChatRoomMng:b	(Lcom/tencent/av/chatroom/ChatRoomInfo;J)V
    //   1051: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1054: ifeq +43 -> 1097
    //   1057: new 166	java/lang/StringBuilder
    //   1060: dup
    //   1061: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   1064: astore_1
    //   1065: aload_1
    //   1066: ldc_w 706
    //   1069: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1072: pop
    //   1073: aload_1
    //   1074: lload 11
    //   1076: invokevirtual 241	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1079: pop
    //   1080: aload_1
    //   1081: ldc 178
    //   1083: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1086: pop
    //   1087: ldc 180
    //   1089: iconst_2
    //   1090: aload_1
    //   1091: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1094: invokestatic 188	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1097: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1098	0	this	ChatRoomMng
    //   0	1098	1	paramString	String
    //   0	1098	2	paramBoolean	boolean
    //   0	1098	3	paramInt	int
    //   0	1098	4	paramIntent	Intent
    //   0	1098	5	paramArrayOfByte	byte[]
    //   276	689	6	i	int
    //   116	685	7	j	int
    //   113	15	8	bool	boolean
    //   313	724	9	l1	long
    //   5	1070	11	l2	long
    //   20	1024	13	localObject	Object
    //   125	728	14	localRspGetMsg	tencent.av.chatroom.chatroom_sso.RspGetMsg
    //   869	1	14	localInvalidProtocolBufferMicroException	InvalidProtocolBufferMicroException
    //   898	9	14	localIntent	Intent
    //   122	766	15	localChatRoomMng	ChatRoomMng
    //   119	707	16	localRspSendMsg	tencent.av.chatroom.chatroom_sso.RspSendMsg
    // Exception table:
    //   from	to	target	type
    //   254	262	324	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   268	278	324	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   284	294	324	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   300	310	324	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   852	862	869	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   829	839	878	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   843	852	878	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   792	800	883	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   804	813	883	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   816	825	883	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public void b(SessionInfo paramSessionInfo)
  {
    ChatRoomInfo localChatRoomInfo = a(paramSessionInfo, false);
    a(localChatRoomInfo);
    if ((QLog.isDevelopLevel()) && (paramSessionInfo != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("quitChatRoom, SessionType[");
      localStringBuilder.append(paramSessionInfo.g);
      localStringBuilder.append("], relationType[");
      localStringBuilder.append(paramSessionInfo.aQ);
      localStringBuilder.append("], relationId[");
      localStringBuilder.append(paramSessionInfo.aN);
      localStringBuilder.append("], peerUin[");
      localStringBuilder.append(paramSessionInfo.s);
      localStringBuilder.append("], extraUin[");
      localStringBuilder.append(paramSessionInfo.u);
      localStringBuilder.append("], isDoubleVideoMeeting[");
      localStringBuilder.append(paramSessionInfo.am);
      localStringBuilder.append("], room[");
      localStringBuilder.append(localChatRoomInfo);
      localStringBuilder.append("]");
      QLog.i("ChatRoomMng", 4, localStringBuilder.toString());
    }
  }
  
  protected void b(ChatRoomInfo paramChatRoomInfo)
  {
    if (paramChatRoomInfo == null)
    {
      QLog.i("ChatRoomMng", 1, "reqGetMsgFromServer, no room info.");
      return;
    }
    long l = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("reqGetMsgFromServer, seq[");
      ((StringBuilder)localObject1).append(l);
      ((StringBuilder)localObject1).append("], curRoomInfo[");
      ((StringBuilder)localObject1).append(paramChatRoomInfo);
      ((StringBuilder)localObject1).append("]");
      QLog.i("ChatRoomMng", 2, ((StringBuilder)localObject1).toString());
    }
    int i = (int)paramChatRoomInfo.d;
    Object localObject2 = new chatroom_sso.RoomKey();
    ((chatroom_sso.RoomKey)localObject2).type.set(paramChatRoomInfo.a);
    ((chatroom_sso.RoomKey)localObject2).room_id.set(paramChatRoomInfo.b);
    ((chatroom_sso.RoomKey)localObject2).id.set(paramChatRoomInfo.c);
    ((chatroom_sso.RoomKey)localObject2).create_ts.set(i);
    Object localObject1 = new chatroom_sso.ReqGetMsg();
    ((chatroom_sso.ReqGetMsg)localObject1).room_key.set((MessageMicro)localObject2);
    if (paramChatRoomInfo.j)
    {
      ((chatroom_sso.ReqGetMsg)localObject1).is_terminal_switch.set(true);
      if (paramChatRoomInfo.k != 0L) {
        ((chatroom_sso.ReqGetMsg)localObject1).room_id.set(paramChatRoomInfo.k);
      }
    }
    paramChatRoomInfo.a();
    localObject2 = new NewIntent(this.b.getApplication(), VideoServlet.class);
    ((NewIntent)localObject2).putExtra("reqType", 21);
    ((NewIntent)localObject2).putExtra("ssoCmd", "QQRTCSvc.chatroom_get_msg");
    ((NewIntent)localObject2).putExtra("vMsg", ((chatroom_sso.ReqGetMsg)localObject1).toByteArray());
    ((NewIntent)localObject2).putExtra("room_key", paramChatRoomInfo);
    SeqUtil.a((Intent)localObject2, l);
    this.b.startServlet((NewIntent)localObject2);
  }
  
  public void b(ChatRoomObserver paramChatRoomObserver)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeObserver, observer[");
      localStringBuilder.append(paramChatRoomObserver);
      localStringBuilder.append("]");
      QLog.i("ChatRoomMng", 2, localStringBuilder.toString());
    }
    if (paramChatRoomObserver != null) {
      this.d.remove(paramChatRoomObserver);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Iterator localIterator;
    ChatRoomObserver localChatRoomObserver;
    if (paramMessage.what == 1)
    {
      int i = this.g;
      this.g = 0;
      paramMessage = (ChatRoomInfo)paramMessage.obj;
      localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        localChatRoomObserver = (ChatRoomObserver)localIterator.next();
        if (localChatRoomObserver != null) {
          localChatRoomObserver.a(i, paramMessage);
        }
      }
    }
    if (paramMessage.what == 2)
    {
      paramMessage = (ChatRoomMsg)paramMessage.obj;
      localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        localChatRoomObserver = (ChatRoomObserver)localIterator.next();
        if (localChatRoomObserver != null) {
          localChatRoomObserver.a(paramMessage);
        }
      }
    }
    if (paramMessage.what == 3)
    {
      ThreadManagerV2.excute(new ChatRoomMng.2(this, (ChatRoomInfo)paramMessage.obj), 16, null, true);
      return true;
    }
    if (paramMessage.what == 4)
    {
      paramMessage = (ChatRoomMsg)paramMessage.obj;
      if ((paramMessage != null) && (paramMessage.c())) {
        a(paramMessage);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.chatroom.ChatRoomMng
 * JD-Core Version:    0.7.0.1
 */