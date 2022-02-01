package com.tencent.mobileqq.activity.contact.newfriend.msg;

import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.activateFriends.MessageForActivateFriends;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.BirthdayNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.OneBirthdayFriend;

public class ActivateFriendMessage
  extends NewFriendMessage
{
  public MessageForActivateFriends a;
  
  private boolean c(AppRuntime paramAppRuntime)
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    if (QLog.isColorLevel()) {
      localStringBuilder.append("isOutOfDate ");
    }
    SubMsgType0x76.MsgBody localMsgBody = this.a.getMsgBody();
    int i = localMsgBody.uint32_msg_type.get();
    boolean bool2 = false;
    if (i == 2)
    {
      int j = localMsgBody.msg_birthday_notify.rpt_msg_one_friend.get().size();
      paramAppRuntime = (FriendsManager)paramAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
      i = 0;
      while (i < j)
      {
        long l = ((SubMsgType0x76.OneBirthdayFriend)localMsgBody.msg_birthday_notify.rpt_msg_one_friend.get().get(i)).uint64_uin.get();
        if (QLog.isColorLevel()) {
          localStringBuilder.append(l);
        }
        if (!paramAppRuntime.n(String.valueOf(l)))
        {
          if (QLog.isColorLevel()) {
            localStringBuilder.append(" not friend");
          }
        }
        else
        {
          int k = ((SubMsgType0x76.OneBirthdayFriend)localMsgBody.msg_birthday_notify.rpt_msg_one_friend.get().get(i)).uint32_birth_month.get();
          int m = ((SubMsgType0x76.OneBirthdayFriend)localMsgBody.msg_birthday_notify.rpt_msg_one_friend.get().get(i)).uint32_birth_date.get();
          if (ActivateFriendsManager.a(((SubMsgType0x76.OneBirthdayFriend)localMsgBody.msg_birthday_notify.rpt_msg_one_friend.get().get(i)).uint32_birth_year.get(), k, m) != 0)
          {
            bool1 = bool2;
            if (!QLog.isColorLevel()) {
              break label285;
            }
            localStringBuilder.append(" not expired");
            bool1 = bool2;
            break label285;
          }
        }
        i += 1;
      }
    }
    boolean bool1 = true;
    label285:
    if (QLog.isColorLevel())
    {
      localStringBuilder.append(bool1);
      QLog.d("ActivateFriendMessage", 2, localStringBuilder.toString());
    }
    return bool1;
  }
  
  public String a()
  {
    SubMsgType0x76.MsgBody localMsgBody = this.a.getMsgBody();
    if ((localMsgBody.uint32_msg_type.get() == 2) && (localMsgBody.msg_birthday_notify.rpt_msg_one_friend.get().size() > 0)) {
      return String.valueOf(((SubMsgType0x76.OneBirthdayFriend)localMsgBody.msg_birthday_notify.rpt_msg_one_friend.get().get(0)).uint64_uin.get());
    }
    return super.a();
  }
  
  public boolean a(AppRuntime paramAppRuntime)
  {
    try
    {
      boolean bool = c(paramAppRuntime);
      return true ^ bool;
    }
    catch (Exception paramAppRuntime)
    {
      paramAppRuntime.printStackTrace();
      return true;
    }
    catch (NoSuchFieldError paramAppRuntime) {}
    return true;
  }
  
  public String b(AppRuntime paramAppRuntime)
  {
    if (TextUtils.isEmpty(this.c)) {
      this.c = this.a.msg;
    }
    return this.c;
  }
  
  public boolean b()
  {
    return this.a.isread;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.msg.ActivateFriendMessage
 * JD-Core Version:    0.7.0.1
 */