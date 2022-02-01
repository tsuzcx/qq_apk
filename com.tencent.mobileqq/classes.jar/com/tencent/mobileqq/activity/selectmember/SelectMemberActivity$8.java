package com.tencent.mobileqq.activity.selectmember;

import bdll;
import com.tencent.mobileqq.app.QQAppInterface;
import mvb;

class SelectMemberActivity$8
  implements Runnable
{
  SelectMemberActivity$8(SelectMemberActivity paramSelectMemberActivity, String paramString) {}
  
  public void run()
  {
    bdll.b(this.this$0.app, "dc00899", "invite_friend", "", "friend_list", this.a, 0, 0, this.this$0.c, mvb.a(this.this$0.app, this.this$0.app.getCurrentAccountUin(), this.this$0.c) + "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.8
 * JD-Core Version:    0.7.0.1
 */