package com.tencent.av.app;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class AvAddFriendService
{
  public static String b = "AvAddFriendService";
  boolean a = false;
  QQAppInterface c = null;
  int d = 0;
  public HashMap<String, AvAddFriendService.AddFriendStatus> e = new HashMap();
  AvatarObserver f = new AvAddFriendService.1(this);
  FriendObserver g = new AvAddFriendService.2(this);
  FriendListObserver h = new AvAddFriendService.3(this);
  MessageObserver i = new AvAddFriendService.4(this);
  
  public AvAddFriendService(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d(b, 2, "AvAddFriendLogic");
    }
    this.c = paramQQAppInterface;
    this.c.addObserver(this.i);
    this.c.addObserver(this.h);
    this.c.addObserver(this.f);
    this.c.addObserver(this.g);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    String str;
    StringBuilder localStringBuilder;
    if (!this.e.containsKey(paramString))
    {
      if (QLog.isColorLevel())
      {
        str = b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setRelationStatus no uin in map:");
        localStringBuilder.append(paramString);
        QLog.d(str, 2, localStringBuilder.toString());
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        str = b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setRelationStatus :");
        localStringBuilder.append(paramString);
        localStringBuilder.append(",status");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(",safeStatus:");
        localStringBuilder.append(paramInt2);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      ((AvAddFriendService.AddFriendStatus)this.e.get(paramString)).b = paramInt1;
      ((AvAddFriendService.AddFriendStatus)this.e.get(paramString)).b = paramInt2;
    }
  }
  
  private void a(structmsg.StructMsg paramStructMsg, long paramLong)
  {
    if (paramStructMsg != null)
    {
      long l = ((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get() + ((structmsg.StructMsg)paramStructMsg.get()).msg_type.get();
      ((INewFriendApi)QRoute.api(INewFriendApi.class)).putStructMsgToMap(Long.valueOf(l), (structmsg.StructMsg)paramStructMsg.get());
      ((INewFriendApi)QRoute.api(INewFriendApi.class)).setCurrStructMsgKey(l);
      ((INewFriendApi)QRoute.api(INewFriendApi.class)).setCurrentUniseq(paramLong);
    }
  }
  
  private boolean a(int paramInt, String paramString)
  {
    if (paramInt != 1) {
      return false;
    }
    if (paramString.equals(this.c.getCurrentAccountUin())) {
      return false;
    }
    try
    {
      Long.parseLong(paramString);
      FriendsManager localFriendsManager = (FriendsManager)this.c.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localFriendsManager != null) {
        paramString = localFriendsManager.m(paramString);
      } else {
        paramString = null;
      }
      return (paramString == null) || (paramString.groupid < 0);
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  private void b(String paramString, int paramInt)
  {
    String str;
    StringBuilder localStringBuilder;
    if (!this.e.containsKey(paramString))
    {
      if (QLog.isColorLevel())
      {
        str = b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setRelationStatus no uin in map:");
        localStringBuilder.append(paramString);
        QLog.d(str, 2, localStringBuilder.toString());
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        str = b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setRelationStatus :");
        localStringBuilder.append(paramString);
        localStringBuilder.append(",status");
        localStringBuilder.append(paramInt);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      ((AvAddFriendService.AddFriendStatus)this.e.get(paramString)).b = paramInt;
    }
  }
  
  private void e(String paramString)
  {
    if (this.c.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER) != null) {
      ((IFriendHandlerService)this.c.getRuntimeService(IFriendHandlerService.class)).requestUserAddFriendSetting(paramString, this.d, 0, "");
    }
  }
  
  public int a(String paramString)
  {
    if (!this.e.containsKey(paramString))
    {
      if (QLog.isColorLevel())
      {
        String str = b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getRelationStatus no uin in map:");
        localStringBuilder.append(paramString);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      return 0;
    }
    return ((AvAddFriendService.AddFriendStatus)this.e.get(paramString)).b;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(b, 2, "AvAddFriendLogic onDestory");
    }
    this.e.clear();
    this.c.removeObserver(this.i);
    this.c.removeObserver(this.h);
    this.c.removeObserver(this.f);
    this.c.removeObserver(this.g);
    this.c = null;
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d(b, 2, "addFriend uin is null");
      }
      return false;
    }
    this.d = paramInt;
    if (((FriendsManager)this.c.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(paramString))
    {
      localObject = new AvAddFriendService.AddFriendStatus(this);
      this.e.put(paramString, localObject);
      b(paramString, 4);
      b(paramString);
      return true;
    }
    if (!a(1, paramString)) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      localObject = b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addFriend uin");
      localStringBuilder.append(paramString);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = new AvAddFriendService.AddFriendStatus(this);
    this.e.put(paramString, localObject);
    ((IFriendHandlerService)this.c.getRuntimeService(IFriendHandlerService.class)).requestUinSafetyFlag(Long.parseLong(paramString));
    return true;
  }
  
  void b(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.video.q2v.AddfrindMsg");
    localIntent.putExtra("peerUin", paramString);
    paramString = this.c;
    if (paramString != null) {
      paramString.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.e.clear();
      return;
    }
    if (this.e.containsKey(paramString)) {
      this.e.remove(paramString);
    }
  }
  
  public void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d(b, 2, "acceptAddFriend uin is null");
      }
      return;
    }
    new ArrayList();
    Object localObject = this.c.getMessageFacade().h(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
    structmsg.StructMsg localStructMsg = null;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(b, 2, "systemMsgList is null");
      }
      return;
    }
    if ((((List)localObject).size() > 0) && (!(((List)localObject).get(0) instanceof MessageForSystemMsg)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(b, 2, "systemMsgList error");
      }
      return;
    }
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = b;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("answerAddFriend systemMsgList size");
      localStringBuilder.append(((List)localObject).size());
      QLog.d(str, 2, localStringBuilder.toString());
    }
    int j = ((List)localObject).size() - 1;
    while (j >= 0)
    {
      localStructMsg = ((MessageForSystemMsg)((List)localObject).get(j)).getSystemMsg();
      if (QLog.isColorLevel())
      {
        str = b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("answerAddFriend structMsg.req_uin =");
        localStringBuilder.append(String.valueOf(localStructMsg.req_uin.get()));
        localStringBuilder.append("friendUin=");
        localStringBuilder.append(paramString);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      if (paramString.equals(String.valueOf(localStructMsg.req_uin.get()))) {
        break;
      }
      j -= 1;
    }
    if ((localStructMsg != null) && (paramString.equals(String.valueOf(localStructMsg.req_uin.get()))))
    {
      j = localStructMsg.msg_type.get();
      long l1 = localStructMsg.msg_seq.get();
      long l2 = localStructMsg.req_uin.get();
      int k = localStructMsg.msg.sub_type.get();
      int m = localStructMsg.msg.src_id.get();
      int n = localStructMsg.msg.sub_src_id.get();
      int i1 = localStructMsg.msg.group_msg_type.get();
      paramString = localStructMsg.msg.actions.get();
      if ((paramString != null) && (paramString.size() > 0))
      {
        paramString = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)paramString.get(0)).action_info.get();
        paramString.remark.set("");
        paramString.group_id.set(0);
        this.c.getMsgHandler().B().a(j, l1, l2, k, m, n, i1, paramString, 0, localStructMsg, false);
        a(localStructMsg, localStructMsg.msg_seq.get());
        if (QLog.isColorLevel())
        {
          paramString = b;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("answerAddFriend  structMsg.req_uin:  ");
          ((StringBuilder)localObject).append(String.valueOf(localStructMsg.req_uin.get()));
          QLog.d(paramString, 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d(b, 2, "answerAddFriend  structMsg == null | , friendUin == structMsg.req_uin | ");
    }
  }
  
  protected void finalize()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(b, 2, "finalize");
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.AvAddFriendService
 * JD-Core Version:    0.7.0.1
 */