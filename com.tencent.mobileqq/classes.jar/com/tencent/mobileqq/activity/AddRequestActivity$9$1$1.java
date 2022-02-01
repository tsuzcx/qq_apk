package com.tencent.mobileqq.activity;

import android.widget.TextView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.FriendInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class AddRequestActivity$9$1$1
  implements Runnable
{
  AddRequestActivity$9$1$1(AddRequestActivity.9.1 param1, Card paramCard) {}
  
  public void run()
  {
    if ((this.b.a.a.q != null) && (this.b.a.a.q.msg != null) && (this.b.a.a.q.msg.friend_info.has()) && (this.b.a.a.q.msg.friend_info.msg_joint_friend.has() == true))
    {
      AddRequestActivity.d(this.b.a.a).setText(this.b.a.a.q.msg.friend_info.msg_joint_friend.get());
      AddRequestActivity.d(this.b.a.a).setVisibility(0);
    }
    else
    {
      AddRequestActivity.d(this.b.a.a).setVisibility(8);
      this.b.a.a.a(this.a);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Card find Uin :");
      localStringBuilder.append(this.b.a.a.a);
      localStringBuilder.append("age:");
      localStringBuilder.append(this.a.age);
      localStringBuilder.append("gender:");
      localStringBuilder.append(this.a.shGender);
      QLog.d("Q.systemmsg.AddRequestActivity", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddRequestActivity.9.1.1
 * JD-Core Version:    0.7.0.1
 */