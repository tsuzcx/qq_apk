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
  private int jdField_a_of_type_Int = 0;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  Comparator<ChatRoomMsg> jdField_a_of_type_JavaUtilComparator = new ChatRoomMng.1(this);
  private final ConcurrentHashMap<ChatRoomInfo, ConcurrentLinkedQueue<ChatRoomMsg>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final ConcurrentLinkedQueue<ChatRoomInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private final ConcurrentLinkedQueue<ChatRoomObserver> b = new ConcurrentLinkedQueue();
  
  public ChatRoomMng(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  private ChatRoomInfo a(chatroom_sso.RoomKey paramRoomKey)
  {
    Object localObject1 = SessionMgr.a().a();
    int i = ((SessionInfo)localObject1).a();
    long l5 = ((SessionInfo)localObject1).a();
    long l3 = ((SessionInfo)localObject1).b();
    long l4 = ((SessionInfo)localObject1).d();
    long l2 = l3;
    long l1 = l4;
    Object localObject2;
    if (i == paramRoomKey.type.get())
    {
      l2 = l3;
      l1 = l4;
      if (l5 == paramRoomKey.id.get())
      {
        localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
        if (localObject2 != null) {
          ((VideoController)localObject2).a("pushMsg", (SessionInfo)localObject1);
        }
        l2 = ((SessionInfo)localObject1).b();
        l1 = ((SessionInfo)localObject1).d();
      }
    }
    if ((i == paramRoomKey.type.get()) && (l5 == paramRoomKey.id.get()) && (l2 == paramRoomKey.room_id.get()) && (l1 == paramRoomKey.create_ts.get())) {
      localObject1 = a((SessionInfo)localObject1);
    } else {
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (ChatRoomInfo)localIterator.next();
        if ((localObject2 != null) && (((ChatRoomInfo)localObject2).jdField_a_of_type_Int == paramRoomKey.type.get()) && (((ChatRoomInfo)localObject2).jdField_b_of_type_Long == paramRoomKey.id.get()) && (((ChatRoomInfo)localObject2).jdField_c_of_type_Long == paramRoomKey.create_ts.get()) && (((ChatRoomInfo)localObject2).jdField_a_of_type_Long != paramRoomKey.room_id.get()))
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
  
  private ConcurrentLinkedQueue<ChatRoomMsg> a(ChatRoomInfo paramChatRoomInfo)
  {
    ConcurrentLinkedQueue localConcurrentLinkedQueue2 = (ConcurrentLinkedQueue)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramChatRoomInfo);
    ConcurrentLinkedQueue localConcurrentLinkedQueue1 = localConcurrentLinkedQueue2;
    if (localConcurrentLinkedQueue2 == null)
    {
      localConcurrentLinkedQueue1 = new ConcurrentLinkedQueue();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramChatRoomInfo, localConcurrentLinkedQueue1);
    }
    return localConcurrentLinkedQueue1;
  }
  
  private void a(int paramInt, ChatRoomInfo paramChatRoomInfo)
  {
    this.jdField_a_of_type_Int = (paramInt | this.jdField_a_of_type_Int);
    if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1, paramChatRoomInfo))
    {
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramChatRoomInfo;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    }
  }
  
  private void a(ChatRoomInfo paramChatRoomInfo, long paramLong)
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
      ((StringBuilder)localObject).append(paramChatRoomInfo.a());
      ((StringBuilder)localObject).append("]");
      QLog.i("ChatRoomMng", 2, ((StringBuilder)localObject).toString());
    }
    paramLong = Math.max(paramLong, 1000L);
    if (paramChatRoomInfo.a())
    {
      localObject = Message.obtain();
      ((Message)localObject).obj = paramChatRoomInfo;
      ((Message)localObject).what = 3;
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, paramLong);
    }
  }
  
  private void a(ChatRoomMsg paramChatRoomMsg)
  {
    if (paramChatRoomMsg != null)
    {
      if (paramChatRoomMsg.jdField_a_of_type_ComTencentAvChatroomChatRoomInfo == null) {
        return;
      }
      ChatRoomInfo localChatRoomInfo = paramChatRoomMsg.jdField_a_of_type_ComTencentAvChatroomChatRoomInfo;
      long l1 = 0L;
      try
      {
        l2 = Long.parseLong(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
        l1 = l2;
      }
      catch (Throwable localThrowable)
      {
        QLog.i("ChatRoomMng", 1, "sendMsg get self uin fail.", localThrowable);
      }
      long l2 = AudioHelper.b();
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
      paramChatRoomMsg.a();
      Object localObject2 = new chatroom_sso.RoomKey();
      ((chatroom_sso.RoomKey)localObject2).type.set(localChatRoomInfo.jdField_a_of_type_Int);
      ((chatroom_sso.RoomKey)localObject2).room_id.set(localChatRoomInfo.jdField_a_of_type_Long);
      ((chatroom_sso.RoomKey)localObject2).id.set(localChatRoomInfo.jdField_b_of_type_Long);
      ((chatroom_sso.RoomKey)localObject2).create_ts.set((int)localChatRoomInfo.jdField_c_of_type_Long);
      chatroom_sso.Msg localMsg = new chatroom_sso.Msg();
      localMsg.msg.set(paramChatRoomMsg.jdField_a_of_type_JavaLangString);
      localMsg.uin.set(l1);
      Object localObject1 = new chatroom_sso.ReqSendMsg();
      ((chatroom_sso.ReqSendMsg)localObject1).room_key.set((MessageMicro)localObject2);
      ((chatroom_sso.ReqSendMsg)localObject1).msg.set(localMsg);
      localObject2 = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), VideoServlet.class);
      ((NewIntent)localObject2).putExtra("reqType", 21);
      ((NewIntent)localObject2).putExtra("ssoCmd", "QQRTCSvc.chatroom_send_msg");
      ((NewIntent)localObject2).putExtra("vMsg", ((chatroom_sso.ReqSendMsg)localObject1).toByteArray());
      ((NewIntent)localObject2).putExtra("room_key", localChatRoomInfo);
      ((NewIntent)localObject2).putExtra("localSeq", paramChatRoomMsg.jdField_b_of_type_Long);
      SeqUtil.a((Intent)localObject2, l2);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.startServlet((NewIntent)localObject2);
      if (paramChatRoomMsg.e == ChatRoomMsg.jdField_a_of_type_Int) {
        a(1, localChatRoomInfo);
      }
    }
  }
  
  private void b(ChatRoomMsg paramChatRoomMsg)
  {
    if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(2, paramChatRoomMsg))
    {
      Message localMessage = Message.obtain();
      localMessage.what = 2;
      localMessage.obj = paramChatRoomMsg;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    }
  }
  
  public ChatRoomInfo a(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
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
      localObject = (ConcurrentLinkedQueue)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localChatRoomInfo);
      if (localObject == null)
      {
        localObject = new ConcurrentLinkedQueue();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localChatRoomInfo, localObject);
      }
      else
      {
        ((ConcurrentLinkedQueue)localObject).clear();
      }
      localObject = Message.obtain();
      ((Message)localObject).obj = localChatRoomInfo;
      ((Message)localObject).what = 3;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
    }
    if ((QLog.isDevelopLevel()) && (paramSessionInfo != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enterChatRoom, SessionType[");
      ((StringBuilder)localObject).append(paramSessionInfo.d);
      ((StringBuilder)localObject).append("], relationType[");
      ((StringBuilder)localObject).append(paramSessionInfo.E);
      ((StringBuilder)localObject).append("], relationId[");
      ((StringBuilder)localObject).append(paramSessionInfo.f);
      ((StringBuilder)localObject).append("], peerUin[");
      ((StringBuilder)localObject).append(paramSessionInfo.c);
      ((StringBuilder)localObject).append("], extraUin[");
      ((StringBuilder)localObject).append(paramSessionInfo.e);
      ((StringBuilder)localObject).append("], isDoubleVideoMeeting[");
      ((StringBuilder)localObject).append(paramSessionInfo.y);
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
      int i = paramSessionInfo.a();
      long l5 = paramSessionInfo.a();
      long l3 = paramSessionInfo.b();
      long l4 = paramSessionInfo.d();
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
            VideoController.a().c();
          } else if (i == 1) {
            VideoController.a().d();
          }
          l2 = paramSessionInfo.b();
          l1 = paramSessionInfo.d();
        }
      }
      ChatRoomInfo localChatRoomInfo = a(i, l2, l5, l1);
      if ((localChatRoomInfo == null) && (paramBoolean))
      {
        if ((l2 != 0L) && (l5 != 0L) && (i != 0))
        {
          localChatRoomInfo = new ChatRoomInfo(i, l2, l5, l1);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(localChatRoomInfo);
        }
        localObject = localChatRoomInfo;
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getRoomInfo, SessionType[");
          ((StringBuilder)localObject).append(paramSessionInfo.d);
          ((StringBuilder)localObject).append("], relationType[");
          ((StringBuilder)localObject).append(paramSessionInfo.E);
          ((StringBuilder)localObject).append("], relationId[");
          ((StringBuilder)localObject).append(paramSessionInfo.f);
          ((StringBuilder)localObject).append("], peerUin[");
          ((StringBuilder)localObject).append(paramSessionInfo.c);
          ((StringBuilder)localObject).append("], extraUin[");
          ((StringBuilder)localObject).append(paramSessionInfo.e);
          ((StringBuilder)localObject).append("], isDoubleVideoMeeting[");
          ((StringBuilder)localObject).append(paramSessionInfo.y);
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
    Object localObject2 = a(paramChatRoomInfo);
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
        } while ((paramChatRoomInfo == null) || (paramChatRoomInfo.jdField_b_of_type_Long != paramLong));
      }
    }
    return paramChatRoomInfo;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomMng", 2, "clearObserver");
    }
    this.b.clear();
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
      paramVideoController.jdField_c_of_type_Boolean = true;
      if ((localChatRoomInfo2 != paramVideoController) && (localChatRoomInfo2 != null)) {
        paramVideoController.d = localChatRoomInfo2.jdField_a_of_type_Long;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3, paramVideoController);
      paramSessionInfo = Message.obtain();
      paramSessionInfo.obj = paramVideoController;
      paramSessionInfo.what = 3;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramSessionInfo);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomMng", 2, String.format("onSwitchTerminalSuccess, ret[%s], pre[%s], cur[%s]", new Object[] { Boolean.valueOf(bool), localChatRoomInfo2, paramVideoController }));
    }
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    ChatRoomInfo localChatRoomInfo = a(paramSessionInfo, false);
    a(localChatRoomInfo);
    if ((QLog.isDevelopLevel()) && (paramSessionInfo != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("quitChatRoom, SessionType[");
      localStringBuilder.append(paramSessionInfo.d);
      localStringBuilder.append("], relationType[");
      localStringBuilder.append(paramSessionInfo.E);
      localStringBuilder.append("], relationId[");
      localStringBuilder.append(paramSessionInfo.f);
      localStringBuilder.append("], peerUin[");
      localStringBuilder.append(paramSessionInfo.c);
      localStringBuilder.append("], extraUin[");
      localStringBuilder.append(paramSessionInfo.e);
      localStringBuilder.append("], isDoubleVideoMeeting[");
      localStringBuilder.append(paramSessionInfo.y);
      localStringBuilder.append("], room[");
      localStringBuilder.append(localChatRoomInfo);
      localStringBuilder.append("]");
      QLog.i("ChatRoomMng", 4, localStringBuilder.toString());
    }
  }
  
  public void a(ChatRoomInfo paramChatRoomInfo)
  {
    if (paramChatRoomInfo != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.remove(paramChatRoomInfo);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramChatRoomInfo);
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
        long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
        l1 = l2;
      }
      catch (Throwable localThrowable)
      {
        QLog.i("ChatRoomMng", 1, "sendMsg get self uin fail.", localThrowable);
      }
      paramString = new ChatRoomMsg(paramChatRoomInfo, l1, paramString, paramLong, -9223372036854775808L, ChatRoomMsg.jdField_a_of_type_Int);
      a(paramChatRoomInfo).add(paramString);
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
      paramChatRoomInfo = (ConcurrentLinkedQueue)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramChatRoomInfo);
      if ((paramChatRoomInfo != null) && (paramChatRoomInfo.size() > 0)) {
        paramList.addAll(paramChatRoomInfo);
      }
      try
      {
        Collections.sort(paramList, this.jdField_a_of_type_JavaUtilComparator);
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
    if ((paramChatRoomObserver != null) && (!this.b.contains(paramChatRoomObserver))) {
      this.b.add(paramChatRoomObserver);
    }
  }
  
  /* Error */
  public void a(String paramString, boolean paramBoolean, int paramInt, Intent paramIntent, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload 4
    //   2: invokestatic 578	com/tencent/av/utils/SeqUtil:a	(Landroid/content/Intent;)J
    //   5: lstore 11
    //   7: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +96 -> 106
    //   13: new 158	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   20: astore 13
    //   22: aload 13
    //   24: ldc_w 580
    //   27: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 13
    //   33: aload_1
    //   34: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload 13
    //   40: ldc_w 582
    //   43: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 13
    //   49: iload_2
    //   50: invokevirtual 227	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 13
    //   56: ldc_w 584
    //   59: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 13
    //   65: iload_3
    //   66: invokevirtual 390	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload 13
    //   72: ldc_w 586
    //   75: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 13
    //   81: lload 11
    //   83: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload 13
    //   89: ldc 170
    //   91: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: ldc 172
    //   97: iconst_2
    //   98: aload 13
    //   100: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 180	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   106: ldc_w 333
    //   109: aload_1
    //   110: invokevirtual 589	java/lang/String:equals	(Ljava/lang/Object;)Z
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
    //   129: ifeq +527 -> 656
    //   132: aload 4
    //   134: ldc_w 346
    //   137: invokevirtual 595	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   140: checkcast 139	com/tencent/av/chatroom/ChatRoomInfo
    //   143: astore_1
    //   144: aload 4
    //   146: ldc_w 351
    //   149: lconst_0
    //   150: invokevirtual 599	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   153: lstore 11
    //   155: aload_1
    //   156: ifnull +28 -> 184
    //   159: aload_0
    //   160: aload_1
    //   161: getfield 140	com/tencent/av/chatroom/ChatRoomInfo:jdField_a_of_type_Int	I
    //   164: aload_1
    //   165: getfield 148	com/tencent/av/chatroom/ChatRoomInfo:jdField_a_of_type_Long	J
    //   168: aload_1
    //   169: getfield 143	com/tencent/av/chatroom/ChatRoomInfo:jdField_b_of_type_Long	J
    //   172: aload_1
    //   173: getfield 146	com/tencent/av/chatroom/ChatRoomInfo:jdField_c_of_type_Long	J
    //   176: invokevirtual 421	com/tencent/av/chatroom/ChatRoomMng:a	(IJJJ)Lcom/tencent/av/chatroom/ChatRoomInfo;
    //   179: astore 4
    //   181: goto +6 -> 187
    //   184: aconst_null
    //   185: astore 4
    //   187: aload 4
    //   189: ifnull +16 -> 205
    //   192: aload_0
    //   193: aload 4
    //   195: lload 11
    //   197: invokevirtual 601	com/tencent/av/chatroom/ChatRoomMng:a	(Lcom/tencent/av/chatroom/ChatRoomInfo;J)Lcom/tencent/av/chatroom/ChatRoomMsg;
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
    //   239: new 603	tencent/av/chatroom/chatroom_sso$RspSendMsg
    //   242: dup
    //   243: invokespecial 604	tencent/av/chatroom/chatroom_sso$RspSendMsg:<init>	()V
    //   246: astore 16
    //   248: iload 7
    //   250: istore_3
    //   251: aload 14
    //   253: astore_1
    //   254: aload 16
    //   256: aload 5
    //   258: invokevirtual 605	tencent/av/chatroom/chatroom_sso$RspSendMsg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   261: pop
    //   262: iload 7
    //   264: istore_3
    //   265: aload 14
    //   267: astore_1
    //   268: aload 16
    //   270: getfield 608	tencent/av/chatroom/chatroom_sso$RspSendMsg:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   273: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   276: istore 6
    //   278: iload 6
    //   280: istore_3
    //   281: aload 14
    //   283: astore_1
    //   284: aload 16
    //   286: getfield 611	tencent/av/chatroom/chatroom_sso$RspSendMsg:err_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   289: invokevirtual 613	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   292: astore 5
    //   294: iload 6
    //   296: istore_3
    //   297: aload 5
    //   299: astore_1
    //   300: aload 16
    //   302: getfield 616	tencent/av/chatroom/chatroom_sso$RspSendMsg:msg_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   305: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
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
    //   326: ldc 172
    //   328: iconst_1
    //   329: ldc_w 618
    //   332: aload 5
    //   334: invokestatic 261	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   337: lconst_0
    //   338: lstore 9
    //   340: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   343: ifeq +46 -> 389
    //   346: ldc 172
    //   348: iconst_2
    //   349: ldc_w 620
    //   352: iconst_4
    //   353: anewarray 4	java/lang/Object
    //   356: dup
    //   357: iconst_0
    //   358: iload_3
    //   359: invokestatic 481	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   362: aastore
    //   363: dup
    //   364: iconst_1
    //   365: lload 9
    //   367: invokestatic 484	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   370: aastore
    //   371: dup
    //   372: iconst_2
    //   373: aload_1
    //   374: aastore
    //   375: dup
    //   376: iconst_3
    //   377: lload 11
    //   379: invokestatic 484	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   382: aastore
    //   383: invokestatic 490	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   386: invokestatic 180	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   389: iload_3
    //   390: ifeq +55 -> 445
    //   393: aload 13
    //   395: getstatic 622	com/tencent/av/chatroom/ChatRoomMsg:jdField_b_of_type_Int	I
    //   398: invokevirtual 624	com/tencent/av/chatroom/ChatRoomMsg:a	(I)V
    //   401: aload 15
    //   403: aload 13
    //   405: invokespecial 626	com/tencent/av/chatroom/ChatRoomMng:b	(Lcom/tencent/av/chatroom/ChatRoomMsg;)V
    //   408: aload 13
    //   410: invokevirtual 628	com/tencent/av/chatroom/ChatRoomMsg:b	()Z
    //   413: ifeq +685 -> 1098
    //   416: invokestatic 201	android/os/Message:obtain	()Landroid/os/Message;
    //   419: astore_1
    //   420: aload_1
    //   421: iconst_4
    //   422: putfield 204	android/os/Message:what	I
    //   425: aload_1
    //   426: aload 13
    //   428: putfield 208	android/os/Message:obj	Ljava/lang/Object;
    //   431: aload 15
    //   433: getfield 59	com/tencent/av/chatroom/ChatRoomMng:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   436: aload_1
    //   437: ldc2_w 629
    //   440: invokevirtual 239	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   443: pop
    //   444: return
    //   445: aload 13
    //   447: lload 9
    //   449: putfield 631	com/tencent/av/chatroom/ChatRoomMsg:d	J
    //   452: aload 13
    //   454: getstatic 633	com/tencent/av/chatroom/ChatRoomMsg:c	I
    //   457: invokevirtual 624	com/tencent/av/chatroom/ChatRoomMsg:a	(I)V
    //   460: aload 15
    //   462: aload 13
    //   464: invokespecial 626	com/tencent/av/chatroom/ChatRoomMng:b	(Lcom/tencent/av/chatroom/ChatRoomMsg;)V
    //   467: aload 4
    //   469: getfield 635	com/tencent/av/chatroom/ChatRoomInfo:jdField_a_of_type_Boolean	Z
    //   472: ifne +15 -> 487
    //   475: ldc_w 637
    //   478: invokestatic 641	com/tencent/av/chatroom/ChatRoomUtil:a	(Ljava/lang/String;)V
    //   481: aload 4
    //   483: iconst_1
    //   484: putfield 635	com/tencent/av/chatroom/ChatRoomInfo:jdField_a_of_type_Boolean	Z
    //   487: aload 4
    //   489: getfield 643	com/tencent/av/chatroom/ChatRoomInfo:jdField_b_of_type_Boolean	Z
    //   492: ifne +606 -> 1098
    //   495: aload 13
    //   497: getfield 290	com/tencent/av/chatroom/ChatRoomMsg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   500: invokestatic 529	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   503: ifne +595 -> 1098
    //   506: aload 13
    //   508: getfield 290	com/tencent/av/chatroom/ChatRoomMsg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   511: bipush 20
    //   513: invokevirtual 647	java/lang/String:indexOf	(I)I
    //   516: iflt +582 -> 1098
    //   519: ldc_w 649
    //   522: invokestatic 641	com/tencent/av/chatroom/ChatRoomUtil:a	(Ljava/lang/String;)V
    //   525: aload 4
    //   527: iconst_1
    //   528: putfield 643	com/tencent/av/chatroom/ChatRoomInfo:jdField_b_of_type_Boolean	Z
    //   531: return
    //   532: aload 13
    //   534: getstatic 622	com/tencent/av/chatroom/ChatRoomMsg:jdField_b_of_type_Int	I
    //   537: invokevirtual 624	com/tencent/av/chatroom/ChatRoomMsg:a	(I)V
    //   540: aload 15
    //   542: aload 13
    //   544: invokespecial 626	com/tencent/av/chatroom/ChatRoomMng:b	(Lcom/tencent/av/chatroom/ChatRoomMsg;)V
    //   547: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   550: ifeq +548 -> 1098
    //   553: new 158	java/lang/StringBuilder
    //   556: dup
    //   557: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   560: astore_1
    //   561: aload_1
    //   562: ldc_w 651
    //   565: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: pop
    //   569: aload_1
    //   570: lload 11
    //   572: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   575: pop
    //   576: aload_1
    //   577: ldc 170
    //   579: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: pop
    //   583: ldc 172
    //   585: iconst_2
    //   586: aload_1
    //   587: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   590: invokestatic 180	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   593: return
    //   594: new 158	java/lang/StringBuilder
    //   597: dup
    //   598: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   601: astore 4
    //   603: aload 4
    //   605: ldc_w 653
    //   608: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: pop
    //   612: aload 4
    //   614: lload 11
    //   616: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   619: pop
    //   620: aload 4
    //   622: ldc_w 268
    //   625: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: pop
    //   629: aload 4
    //   631: aload_1
    //   632: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   635: pop
    //   636: aload 4
    //   638: ldc 170
    //   640: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: pop
    //   644: ldc 172
    //   646: iconst_1
    //   647: aload 4
    //   649: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   652: invokestatic 180	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   655: return
    //   656: ldc_w 655
    //   659: aload_1
    //   660: invokevirtual 589	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   663: ifeq +435 -> 1098
    //   666: aload 4
    //   668: ldc_w 346
    //   671: invokevirtual 595	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   674: checkcast 139	com/tencent/av/chatroom/ChatRoomInfo
    //   677: astore_1
    //   678: aload_1
    //   679: ifnull +28 -> 707
    //   682: aload_0
    //   683: aload_1
    //   684: getfield 140	com/tencent/av/chatroom/ChatRoomInfo:jdField_a_of_type_Int	I
    //   687: aload_1
    //   688: getfield 148	com/tencent/av/chatroom/ChatRoomInfo:jdField_a_of_type_Long	J
    //   691: aload_1
    //   692: getfield 143	com/tencent/av/chatroom/ChatRoomInfo:jdField_b_of_type_Long	J
    //   695: aload_1
    //   696: getfield 146	com/tencent/av/chatroom/ChatRoomInfo:jdField_c_of_type_Long	J
    //   699: invokevirtual 421	com/tencent/av/chatroom/ChatRoomMng:a	(IJJJ)Lcom/tencent/av/chatroom/ChatRoomInfo;
    //   702: astore 13
    //   704: goto +6 -> 710
    //   707: aconst_null
    //   708: astore 13
    //   710: aload 13
    //   712: ifnonnull +48 -> 760
    //   715: new 158	java/lang/StringBuilder
    //   718: dup
    //   719: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   722: astore 4
    //   724: aload 4
    //   726: ldc_w 657
    //   729: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   732: pop
    //   733: aload 4
    //   735: aload_1
    //   736: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   739: pop
    //   740: aload 4
    //   742: ldc 170
    //   744: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: pop
    //   748: ldc 172
    //   750: iconst_1
    //   751: aload 4
    //   753: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   756: invokestatic 180	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   759: return
    //   760: ldc2_w 228
    //   763: lstore 9
    //   765: iload_2
    //   766: ifeq +277 -> 1043
    //   769: aload 5
    //   771: ifnull +272 -> 1043
    //   774: aload 5
    //   776: arraylength
    //   777: ifle +266 -> 1043
    //   780: new 659	tencent/av/chatroom/chatroom_sso$RspGetMsg
    //   783: dup
    //   784: invokespecial 660	tencent/av/chatroom/chatroom_sso$RspGetMsg:<init>	()V
    //   787: astore 14
    //   789: iload 7
    //   791: istore 6
    //   793: aload 14
    //   795: aload 5
    //   797: invokevirtual 661	tencent/av/chatroom/chatroom_sso$RspGetMsg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   800: pop
    //   801: iload 7
    //   803: istore 6
    //   805: aload 14
    //   807: getfield 662	tencent/av/chatroom/chatroom_sso$RspGetMsg:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   810: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   813: istore_3
    //   814: iload_3
    //   815: istore 6
    //   817: aload 14
    //   819: getfield 663	tencent/av/chatroom/chatroom_sso$RspGetMsg:err_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   822: invokevirtual 613	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   825: astore_1
    //   826: aload 16
    //   828: astore 5
    //   830: aload 14
    //   832: getfield 667	tencent/av/chatroom/chatroom_sso$RspGetMsg:msg_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   835: invokevirtual 672	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   838: astore 4
    //   840: aload 4
    //   842: astore 5
    //   844: aload 14
    //   846: getfield 676	tencent/av/chatroom/chatroom_sso$RspGetMsg:retry	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   849: invokevirtual 680	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   852: istore_2
    //   853: aload 14
    //   855: getfield 683	tencent/av/chatroom/chatroom_sso$RspGetMsg:retry_delay	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   858: invokevirtual 102	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   861: lstore 11
    //   863: lload 11
    //   865: lstore 9
    //   867: goto +49 -> 916
    //   870: astore 14
    //   872: aload 4
    //   874: astore 5
    //   876: goto +25 -> 901
    //   879: astore 4
    //   881: goto +14 -> 895
    //   884: astore 4
    //   886: aconst_null
    //   887: astore_1
    //   888: aload 15
    //   890: astore 5
    //   892: iload 6
    //   894: istore_3
    //   895: iconst_0
    //   896: istore_2
    //   897: aload 4
    //   899: astore 14
    //   901: ldc 172
    //   903: iconst_1
    //   904: ldc_w 685
    //   907: aload 14
    //   909: invokestatic 261	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   912: aload 5
    //   914: astore 4
    //   916: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   919: ifeq +73 -> 992
    //   922: aload 4
    //   924: ifnonnull +9 -> 933
    //   927: iconst_0
    //   928: istore 6
    //   930: goto +12 -> 942
    //   933: aload 4
    //   935: invokeinterface 554 1 0
    //   940: istore 6
    //   942: ldc 172
    //   944: iconst_2
    //   945: ldc_w 687
    //   948: iconst_5
    //   949: anewarray 4	java/lang/Object
    //   952: dup
    //   953: iconst_0
    //   954: iload_3
    //   955: invokestatic 481	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   958: aastore
    //   959: dup
    //   960: iconst_1
    //   961: aload_1
    //   962: aastore
    //   963: dup
    //   964: iconst_2
    //   965: iload 6
    //   967: invokestatic 481	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   970: aastore
    //   971: dup
    //   972: iconst_3
    //   973: iload_2
    //   974: invokestatic 512	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   977: aastore
    //   978: dup
    //   979: iconst_4
    //   980: lload 9
    //   982: invokestatic 484	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   985: aastore
    //   986: invokestatic 490	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   989: invokestatic 180	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   992: iload_3
    //   993: ifne +41 -> 1034
    //   996: iload_2
    //   997: ifeq +27 -> 1024
    //   1000: aload 4
    //   1002: ifnull +13 -> 1015
    //   1005: aload 4
    //   1007: invokeinterface 554 1 0
    //   1012: ifne +12 -> 1024
    //   1015: aload_0
    //   1016: aload 13
    //   1018: lload 9
    //   1020: invokespecial 689	com/tencent/av/chatroom/ChatRoomMng:a	(Lcom/tencent/av/chatroom/ChatRoomInfo;J)V
    //   1023: return
    //   1024: aload_0
    //   1025: aload 13
    //   1027: aload 4
    //   1029: iconst_0
    //   1030: invokevirtual 691	com/tencent/av/chatroom/ChatRoomMng:a	(Lcom/tencent/av/chatroom/ChatRoomInfo;Ljava/util/List;Z)V
    //   1033: return
    //   1034: aload_0
    //   1035: aload 13
    //   1037: lload 9
    //   1039: invokespecial 689	com/tencent/av/chatroom/ChatRoomMng:a	(Lcom/tencent/av/chatroom/ChatRoomInfo;J)V
    //   1042: return
    //   1043: aload_0
    //   1044: aload 13
    //   1046: ldc2_w 228
    //   1049: invokespecial 689	com/tencent/av/chatroom/ChatRoomMng:a	(Lcom/tencent/av/chatroom/ChatRoomInfo;J)V
    //   1052: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1055: ifeq +43 -> 1098
    //   1058: new 158	java/lang/StringBuilder
    //   1061: dup
    //   1062: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   1065: astore_1
    //   1066: aload_1
    //   1067: ldc_w 693
    //   1070: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1073: pop
    //   1074: aload_1
    //   1075: lload 11
    //   1077: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1080: pop
    //   1081: aload_1
    //   1082: ldc 170
    //   1084: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1087: pop
    //   1088: ldc 172
    //   1090: iconst_2
    //   1091: aload_1
    //   1092: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1095: invokestatic 180	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1098: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1099	0	this	ChatRoomMng
    //   0	1099	1	paramString	String
    //   0	1099	2	paramBoolean	boolean
    //   0	1099	3	paramInt	int
    //   0	1099	4	paramIntent	Intent
    //   0	1099	5	paramArrayOfByte	byte[]
    //   276	690	6	i	int
    //   116	686	7	j	int
    //   113	15	8	bool	boolean
    //   313	725	9	l1	long
    //   5	1071	11	l2	long
    //   20	1025	13	localObject	Object
    //   125	729	14	localRspGetMsg	tencent.av.chatroom.chatroom_sso.RspGetMsg
    //   870	1	14	localInvalidProtocolBufferMicroException	InvalidProtocolBufferMicroException
    //   899	9	14	localIntent	Intent
    //   122	767	15	localChatRoomMng	ChatRoomMng
    //   119	708	16	localRspSendMsg	tencent.av.chatroom.chatroom_sso.RspSendMsg
    // Exception table:
    //   from	to	target	type
    //   254	262	324	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   268	278	324	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   284	294	324	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   300	310	324	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   853	863	870	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   830	840	879	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   844	853	879	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   793	801	884	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   805	814	884	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   817	826	884	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  protected void b(ChatRoomInfo paramChatRoomInfo)
  {
    if (paramChatRoomInfo == null)
    {
      QLog.i("ChatRoomMng", 1, "reqGetMsgFromServer, no room info.");
      return;
    }
    long l = AudioHelper.b();
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
    int i = (int)paramChatRoomInfo.jdField_c_of_type_Long;
    Object localObject2 = new chatroom_sso.RoomKey();
    ((chatroom_sso.RoomKey)localObject2).type.set(paramChatRoomInfo.jdField_a_of_type_Int);
    ((chatroom_sso.RoomKey)localObject2).room_id.set(paramChatRoomInfo.jdField_a_of_type_Long);
    ((chatroom_sso.RoomKey)localObject2).id.set(paramChatRoomInfo.jdField_b_of_type_Long);
    ((chatroom_sso.RoomKey)localObject2).create_ts.set(i);
    Object localObject1 = new chatroom_sso.ReqGetMsg();
    ((chatroom_sso.ReqGetMsg)localObject1).room_key.set((MessageMicro)localObject2);
    if (paramChatRoomInfo.jdField_c_of_type_Boolean)
    {
      ((chatroom_sso.ReqGetMsg)localObject1).is_terminal_switch.set(true);
      if (paramChatRoomInfo.d != 0L) {
        ((chatroom_sso.ReqGetMsg)localObject1).room_id.set(paramChatRoomInfo.d);
      }
    }
    paramChatRoomInfo.a();
    localObject2 = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), VideoServlet.class);
    ((NewIntent)localObject2).putExtra("reqType", 21);
    ((NewIntent)localObject2).putExtra("ssoCmd", "QQRTCSvc.chatroom_get_msg");
    ((NewIntent)localObject2).putExtra("vMsg", ((chatroom_sso.ReqGetMsg)localObject1).toByteArray());
    ((NewIntent)localObject2).putExtra("room_key", paramChatRoomInfo);
    SeqUtil.a((Intent)localObject2, l);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.startServlet((NewIntent)localObject2);
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
      this.b.remove(paramChatRoomObserver);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Iterator localIterator;
    ChatRoomObserver localChatRoomObserver;
    if (paramMessage.what == 1)
    {
      int i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = 0;
      paramMessage = (ChatRoomInfo)paramMessage.obj;
      localIterator = this.b.iterator();
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
      localIterator = this.b.iterator();
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
      if ((paramMessage != null) && (paramMessage.b())) {
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