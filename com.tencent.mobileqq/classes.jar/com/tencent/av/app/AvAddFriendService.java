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
  public static String a = "AvAddFriendService";
  int jdField_a_of_type_Int = 0;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new AvAddFriendService.3(this);
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new AvAddFriendService.4(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new AvAddFriendService.1(this);
  FriendObserver jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver = new AvAddFriendService.2(this);
  public HashMap<String, AvAddFriendService.AddFriendStatus> a;
  boolean jdField_a_of_type_Boolean = false;
  
  public AvAddFriendService(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "AvAddFriendLogic");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
  }
  
  private void a(String paramString, int paramInt)
  {
    String str;
    StringBuilder localStringBuilder;
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      if (QLog.isColorLevel())
      {
        str = jdField_a_of_type_JavaLangString;
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
        str = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setRelationStatus :");
        localStringBuilder.append(paramString);
        localStringBuilder.append(",status");
        localStringBuilder.append(paramInt);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      ((AvAddFriendService.AddFriendStatus)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).b = paramInt;
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    String str;
    StringBuilder localStringBuilder;
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      if (QLog.isColorLevel())
      {
        str = jdField_a_of_type_JavaLangString;
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
        str = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setRelationStatus :");
        localStringBuilder.append(paramString);
        localStringBuilder.append(",status");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(",safeStatus:");
        localStringBuilder.append(paramInt2);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      ((AvAddFriendService.AddFriendStatus)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).b = paramInt1;
      ((AvAddFriendService.AddFriendStatus)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).b = paramInt2;
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
    if (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
      return false;
    }
    try
    {
      Long.parseLong(paramString);
      FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localFriendsManager != null) {
        paramString = localFriendsManager.e(paramString);
      } else {
        paramString = null;
      }
      return (paramString == null) || (paramString.groupid < 0);
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  private void d(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER) != null) {
      ((IFriendHandlerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IFriendHandlerService.class)).requestUserAddFriendSetting(paramString, this.jdField_a_of_type_Int, 0, "");
    }
  }
  
  public int a(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      if (QLog.isColorLevel())
      {
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getRelationStatus no uin in map:");
        localStringBuilder.append(paramString);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      return 0;
    }
    return ((AvAddFriendService.AddFriendStatus)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).b;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "AvAddFriendLogic onDestory");
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  void a(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.video.q2v.AddfrindMsg");
    localIntent.putExtra("peerUin", paramString);
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramString != null) {
      paramString.getApp().sendBroadcast(localIntent);
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "addFriend uin is null");
      }
      return false;
    }
    this.jdField_a_of_type_Int = paramInt;
    if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString))
    {
      localObject = new AvAddFriendService.AddFriendStatus(this);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject);
      a(paramString, 4);
      a(paramString);
      return true;
    }
    if (!a(1, paramString)) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addFriend uin");
      localStringBuilder.append(paramString);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = new AvAddFriendService.AddFriendStatus(this);
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject);
    ((IFriendHandlerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IFriendHandlerService.class)).requestUinSafetyFlag(Long.parseLong(paramString));
    return true;
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      return;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    }
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "acceptAddFriend uin is null");
      }
      return;
    }
    new ArrayList();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
    structmsg.StructMsg localStructMsg = null;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "systemMsgList is null");
      }
      return;
    }
    if ((((List)localObject).size() > 0) && (!(((List)localObject).get(0) instanceof MessageForSystemMsg)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "systemMsgList error");
      }
      return;
    }
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("answerAddFriend systemMsgList size");
      localStringBuilder.append(((List)localObject).size());
      QLog.d(str, 2, localStringBuilder.toString());
    }
    int i = ((List)localObject).size() - 1;
    while (i >= 0)
    {
      localStructMsg = ((MessageForSystemMsg)((List)localObject).get(i)).getSystemMsg();
      if (QLog.isColorLevel())
      {
        str = jdField_a_of_type_JavaLangString;
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
      i -= 1;
    }
    if ((localStructMsg != null) && (paramString.equals(String.valueOf(localStructMsg.req_uin.get()))))
    {
      i = localStructMsg.msg_type.get();
      long l1 = localStructMsg.msg_seq.get();
      long l2 = localStructMsg.req_uin.get();
      int j = localStructMsg.msg.sub_type.get();
      int k = localStructMsg.msg.src_id.get();
      int m = localStructMsg.msg.sub_src_id.get();
      int n = localStructMsg.msg.group_msg_type.get();
      paramString = localStructMsg.msg.actions.get();
      if ((paramString != null) && (paramString.size() > 0))
      {
        paramString = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)paramString.get(0)).action_info.get();
        paramString.remark.set("");
        paramString.group_id.set(0);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(i, l1, l2, j, k, m, n, paramString, 0, localStructMsg, false);
        a(localStructMsg, localStructMsg.msg_seq.get());
        if (QLog.isColorLevel())
        {
          paramString = jdField_a_of_type_JavaLangString;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("answerAddFriend  structMsg.req_uin:  ");
          ((StringBuilder)localObject).append(String.valueOf(localStructMsg.req_uin.get()));
          QLog.d(paramString, 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "answerAddFriend  structMsg == null | , friendUin == structMsg.req_uin | ");
    }
  }
  
  protected void finalize()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "finalize");
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