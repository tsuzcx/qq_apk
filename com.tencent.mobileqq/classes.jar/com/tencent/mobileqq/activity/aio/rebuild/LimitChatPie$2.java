package com.tencent.mobileqq.activity.aio.rebuild;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.contact.newfriend.msg.FriendSystemMessage;
import com.tencent.mobileqq.limitchat.LimitChatUtil;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class LimitChatPie$2
  implements Observer
{
  LimitChatPie$2(LimitChatPie paramLimitChatPie) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof FriendSystemMessage))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.b, 2, "new FriendSystemMessage,:");
      }
      paramObservable = ((FriendSystemMessage)paramObject).a.getSystemMsg();
      if (paramObservable != null) {
        break label42;
      }
    }
    label42:
    do
    {
      do
      {
        do
        {
          return;
        } while (paramObservable.msg.sub_type.get() != 9);
        paramObservable = String.valueOf(paramObservable.req_uin.get());
        if (QLog.isColorLevel()) {
          QLog.d(this.a.b, 2, "FRIEND_ADDSUCCESS, uin:" + paramObservable + " badd:" + LimitChatPie.b(this.a));
        }
      } while ((TextUtils.isEmpty(paramObservable)) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (!paramObservable.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)));
      if (!LimitChatPie.b(this.a))
      {
        LimitChatPie.a(this.a, true);
        LimitChatUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObservable);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.a.b, 2, "FRIEND_ADDSUCCESS, processed:");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.2
 * JD-Core Version:    0.7.0.1
 */