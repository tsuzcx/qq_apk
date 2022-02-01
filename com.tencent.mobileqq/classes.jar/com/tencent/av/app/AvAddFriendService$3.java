package com.tencent.av.app;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class AvAddFriendService$3
  extends MessageObserver
{
  AvAddFriendService$3(AvAddFriendService paramAvAddFriendService) {}
  
  public void onGetSystemMsgFin(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i(AvAddFriendService.jdField_a_of_type_JavaLangString, 2, "onGetSystemMsgFin.bengin");
    }
    if (paramBoolean1) {
      if (QLog.isColorLevel()) {
        QLog.i(AvAddFriendService.jdField_a_of_type_JavaLangString, 2, "onGetSystemMsgFin.success");
      }
    }
    for (;;)
    {
      Object localObject;
      int i;
      try
      {
        new ArrayList();
        localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
        if (QLog.isColorLevel()) {
          QLog.d(AvAddFriendService.jdField_a_of_type_JavaLangString, 2, "onGetSystemMsgFin mDataList size=" + ((List)localObject).size());
        }
        i = ((List)localObject).size() - 1;
        if (i >= 0)
        {
          MessageForSystemMsg localMessageForSystemMsg = (MessageForSystemMsg)((List)localObject).get(i);
          if (localMessageForSystemMsg == null) {
            return;
          }
          if (QLog.isColorLevel())
          {
            QLog.d(AvAddFriendService.jdField_a_of_type_JavaLangString, 2, "msg_type=" + localMessageForSystemMsg.structMsg.msg_type.get() + ", source id" + localMessageForSystemMsg.structMsg.msg.src_id.get() + "senderuin" + localMessageForSystemMsg.senderuin);
            QLog.d(AvAddFriendService.jdField_a_of_type_JavaLangString, 2, "onGetSystemMsgFin " + localMessageForSystemMsg.senderuin + " 请求加好友");
          }
          if ((localMessageForSystemMsg.structMsg.msg.src_id.get() == 3023) || (localMessageForSystemMsg.structMsg.msg.src_id.get() == 2023) || (localMessageForSystemMsg.structMsg.msg.src_id.get() == 3025) || (localMessageForSystemMsg.structMsg.msg.src_id.get() == 2025)) {
            break label358;
          }
          if (!QLog.isColorLevel()) {
            break label659;
          }
          QLog.d(AvAddFriendService.jdField_a_of_type_JavaLangString, 2, "no av talk src id");
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      label358:
      int j;
      for (;;)
      {
        super.onGetSystemMsgFin(paramBoolean1, paramBoolean2, paramList);
        return;
        if (localException.structMsg.msg_type.get() != 1) {
          break label716;
        }
        String str = localException.senderuin;
        j = localException.structMsg.msg.sub_type.get();
        if (!QLog.isColorLevel()) {
          break label660;
        }
        QLog.d(AvAddFriendService.jdField_a_of_type_JavaLangString, 2, "systemMsg subType : " + j);
        break label660;
        if (this.a.a(str) == 4)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(AvAddFriendService.jdField_a_of_type_JavaLangString, 2, "already fiend :" + str);
          return;
        }
        if (this.a.a(str) == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d(AvAddFriendService.jdField_a_of_type_JavaLangString, 2, "recv add friend request when had send request, accept it automatically :" + str);
          }
          this.a.c(str);
          return;
        }
        if (!this.a.jdField_a_of_type_JavaUtilHashMap.containsKey(str))
        {
          localObject = new AvAddFriendService.AddFriendStatus(this.a);
          this.a.jdField_a_of_type_JavaUtilHashMap.put(str, localObject);
        }
        AvAddFriendService.a(this.a, str, 2);
        this.a.a(localException.senderuin);
        return;
        if (this.a.a(str) != 2) {
          break;
        }
        AvAddFriendService.a(this.a, str, 0);
        this.a.a(localException.senderuin);
        return;
        if ((paramBoolean2) && (QLog.isColorLevel())) {
          QLog.e(AvAddFriendService.jdField_a_of_type_JavaLangString, 2, "onGetSystemMsgFin bTimeout");
        }
      }
      label659:
      return;
      label660:
      switch (j)
      {
      }
      label716:
      i -= 1;
    }
  }
  
  public void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i(AvAddFriendService.jdField_a_of_type_JavaLangString, 2, "onSendSystemMsgActionError.bengin, isSuccess=" + paramBoolean + ", uin" + paramString);
    }
    super.onSendResult(paramBoolean, paramString, paramLong);
  }
  
  public void onSendSystemMsgActionError(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(AvAddFriendService.jdField_a_of_type_JavaLangString, 2, "onSendSystemMsgActionError.bengin 同意添加好友失败 :" + paramString);
    }
    long l2 = FriendSystemMsgController.a().b();
    long l1 = l2;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      l1 = Long.parseLong(paramString);
      if (FriendSystemMsgController.a().a(Long.valueOf(l1)) != null)
      {
        super.onSendSystemMsgActionError(paramString);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        l1 = l2;
        continue;
        if (QLog.isColorLevel()) {
          QLog.i(AvAddFriendService.jdField_a_of_type_JavaLangString, 2, "onSendSystemMsgActionError structMsg = null");
        }
      }
    }
  }
  
  public void onSendSystemMsgActionFin(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.i(AvAddFriendService.jdField_a_of_type_JavaLangString, 2, "onSendSystemMsgActionFin 同意加对方好友回调 issuc" + paramBoolean + ",logStr=" + paramString1 + ";actionType=" + paramInt1 + ";msgDetail=" + paramString2 + ";resultCode=" + paramInt2 + ";respType=" + paramInt3 + ";msgFail=" + paramString3 + ";msgInvalidDecided=" + paramString4 + ";remarkRet=" + paramInt4);
    }
    long l2 = FriendSystemMsgController.a().b();
    long l1 = l2;
    if (!TextUtils.isEmpty(paramString1)) {}
    try
    {
      l1 = Long.parseLong(paramString1);
      structmsg.StructMsg localStructMsg = FriendSystemMsgController.a().a(Long.valueOf(l1));
      if (localStructMsg != null)
      {
        l1 = localStructMsg.req_uin.get();
        if (QLog.isColorLevel()) {
          QLog.i(AvAddFriendService.jdField_a_of_type_JavaLangString, 2, "onSendSystemMsgActionFin 同意加对方好友回调  uin=" + String.valueOf(l1));
        }
        super.onSendSystemMsgActionFin(paramBoolean, paramString1, paramInt1, paramString2, paramInt2, paramInt3, paramString3, paramString4, paramInt4);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        l1 = l2;
        continue;
        if (QLog.isColorLevel()) {
          QLog.i(AvAddFriendService.jdField_a_of_type_JavaLangString, 2, "onSendSystemMsgActionFin structMsg = null");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.av.app.AvAddFriendService.3
 * JD-Core Version:    0.7.0.1
 */