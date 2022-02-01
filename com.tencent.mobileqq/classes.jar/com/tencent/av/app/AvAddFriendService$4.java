package com.tencent.av.app;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class AvAddFriendService$4
  extends MessageObserver
{
  AvAddFriendService$4(AvAddFriendService paramAvAddFriendService) {}
  
  protected void onGetSystemMsgFin(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
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
      int j;
      try
      {
        new ArrayList();
        Object localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
        Object localObject3;
        if (QLog.isColorLevel())
        {
          localObject2 = AvAddFriendService.jdField_a_of_type_JavaLangString;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("onGetSystemMsgFin mDataList size=");
          ((StringBuilder)localObject3).append(((List)localObject1).size());
          QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
        }
        int i = ((List)localObject1).size() - 1;
        if (i < 0) {
          break label759;
        }
        Object localObject2 = (MessageForSystemMsg)((List)localObject1).get(i);
        if (localObject2 == null) {
          return;
        }
        Object localObject4;
        if (QLog.isColorLevel())
        {
          localObject3 = AvAddFriendService.jdField_a_of_type_JavaLangString;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("msg_type=");
          ((StringBuilder)localObject4).append(((MessageForSystemMsg)localObject2).structMsg.msg_type.get());
          ((StringBuilder)localObject4).append(", source id");
          ((StringBuilder)localObject4).append(((MessageForSystemMsg)localObject2).structMsg.msg.src_id.get());
          ((StringBuilder)localObject4).append("senderuin");
          ((StringBuilder)localObject4).append(((MessageForSystemMsg)localObject2).senderuin);
          QLog.d((String)localObject3, 2, ((StringBuilder)localObject4).toString());
          localObject3 = AvAddFriendService.jdField_a_of_type_JavaLangString;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("onGetSystemMsgFin ");
          ((StringBuilder)localObject4).append(((MessageForSystemMsg)localObject2).senderuin);
          ((StringBuilder)localObject4).append(" 请求加好友");
          QLog.d((String)localObject3, 2, ((StringBuilder)localObject4).toString());
        }
        if ((((MessageForSystemMsg)localObject2).structMsg.msg.src_id.get() != 3023) && (((MessageForSystemMsg)localObject2).structMsg.msg.src_id.get() != 2023) && (((MessageForSystemMsg)localObject2).structMsg.msg.src_id.get() != 3025) && (((MessageForSystemMsg)localObject2).structMsg.msg.src_id.get() != 2025))
        {
          if (!QLog.isColorLevel()) {
            break label767;
          }
          QLog.d(AvAddFriendService.jdField_a_of_type_JavaLangString, 2, "no av talk src id");
          return;
        }
        if (((MessageForSystemMsg)localObject2).structMsg.msg_type.get() == 1)
        {
          localObject3 = ((MessageForSystemMsg)localObject2).senderuin;
          j = ((MessageForSystemMsg)localObject2).structMsg.msg.sub_type.get();
          if (!QLog.isColorLevel()) {
            break label768;
          }
          localObject4 = AvAddFriendService.jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("systemMsg subType : ");
          localStringBuilder.append(j);
          QLog.d((String)localObject4, 2, localStringBuilder.toString());
          break label768;
          if (this.a.a((String)localObject3) != 2) {
            break;
          }
          AvAddFriendService.a(this.a, (String)localObject3, 0);
          this.a.a(((MessageForSystemMsg)localObject2).senderuin);
          return;
          if (this.a.a((String)localObject3) == 4)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = AvAddFriendService.jdField_a_of_type_JavaLangString;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("already fiend :");
              ((StringBuilder)localObject2).append((String)localObject3);
              QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
            }
          }
          else
          {
            if (this.a.a((String)localObject3) == 1)
            {
              if (QLog.isColorLevel())
              {
                localObject1 = AvAddFriendService.jdField_a_of_type_JavaLangString;
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("recv add friend request when had send request, accept it automatically :");
                ((StringBuilder)localObject2).append((String)localObject3);
                QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
              }
              this.a.c((String)localObject3);
              return;
            }
            if (!this.a.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject3))
            {
              localObject1 = new AvAddFriendService.AddFriendStatus(this.a);
              this.a.jdField_a_of_type_JavaUtilHashMap.put(localObject3, localObject1);
            }
            AvAddFriendService.a(this.a, (String)localObject3, 2);
            this.a.a(((MessageForSystemMsg)localObject2).senderuin);
          }
          return;
        }
        i -= 1;
        continue;
        if (!paramBoolean2) {
          break label759;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      if (QLog.isColorLevel()) {
        QLog.e(AvAddFriendService.jdField_a_of_type_JavaLangString, 2, "onGetSystemMsgFin bTimeout");
      }
      label759:
      super.onGetSystemMsgFin(paramBoolean1, paramBoolean2, paramList);
      return;
      label767:
      return;
      label768:
      if (j != 1) {
        switch (j)
        {
        }
      }
    }
  }
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      String str = AvAddFriendService.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSendSystemMsgActionError.bengin, isSuccess=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", uin");
      localStringBuilder.append(paramString);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    super.onSendResult(paramBoolean, paramString, paramLong);
  }
  
  protected void onSendSystemMsgActionError(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = AvAddFriendService.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSendSystemMsgActionError.bengin 同意添加好友失败 :");
      localStringBuilder.append(paramString);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    long l2 = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getCurrStructMsgKey();
    long l1 = l2;
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        l1 = Long.parseLong(paramString);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        l1 = l2;
      }
    }
    if ((((INewFriendApi)QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(l1)) == null) && (QLog.isColorLevel())) {
      QLog.i(AvAddFriendService.jdField_a_of_type_JavaLangString, 2, "onSendSystemMsgActionError structMsg = null");
    }
    super.onSendSystemMsgActionError(paramString);
  }
  
  protected void onSendSystemMsgActionFin(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      String str = AvAddFriendService.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSendSystemMsgActionFin 同意加对方好友回调 issuc");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",logStr=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(";actionType=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(";msgDetail=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(";resultCode=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(";respType=");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(";msgFail=");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(";msgInvalidDecided=");
      localStringBuilder.append(paramString4);
      localStringBuilder.append(";remarkRet=");
      localStringBuilder.append(paramInt4);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    long l2 = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getCurrStructMsgKey();
    long l1 = l2;
    if (!TextUtils.isEmpty(paramString1)) {
      try
      {
        l1 = Long.parseLong(paramString1);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        l1 = l2;
      }
    }
    Object localObject = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(l1));
    if (localObject != null)
    {
      l1 = ((structmsg.StructMsg)localObject).req_uin.get();
      if (QLog.isColorLevel())
      {
        localObject = AvAddFriendService.jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onSendSystemMsgActionFin 同意加对方好友回调  uin=");
        localStringBuilder.append(String.valueOf(l1));
        QLog.i((String)localObject, 2, localStringBuilder.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.i(AvAddFriendService.jdField_a_of_type_JavaLangString, 2, "onSendSystemMsgActionFin structMsg = null");
    }
    super.onSendSystemMsgActionFin(paramBoolean, paramString1, paramInt1, paramString2, paramInt2, paramInt3, paramString3, paramString4, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.AvAddFriendService.4
 * JD-Core Version:    0.7.0.1
 */