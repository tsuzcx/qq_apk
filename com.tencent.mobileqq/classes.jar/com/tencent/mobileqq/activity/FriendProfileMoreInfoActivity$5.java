package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.widget.QQToast;

class FriendProfileMoreInfoActivity$5
  implements ConditionSearchManager.IConfigListener
{
  FriendProfileMoreInfoActivity$5(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((this.a.t == 1) || (this.a.t == 2))
    {
      if (!paramBoolean)
      {
        FriendProfileMoreInfoActivity.c(this.a);
        QQToast.makeText(this.a, 2131888003, 0).show(this.a.getTitleBarHeight());
        return;
      }
      if (paramInt == 2)
      {
        FriendProfileMoreInfoActivity.c(this.a);
        FriendProfileMoreInfoActivity localFriendProfileMoreInfoActivity = this.a;
        FriendProfileMoreInfoActivity.a(localFriendProfileMoreInfoActivity, localFriendProfileMoreInfoActivity.t);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity.5
 * JD-Core Version:    0.7.0.1
 */