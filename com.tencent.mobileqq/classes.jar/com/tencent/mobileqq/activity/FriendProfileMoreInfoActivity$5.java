package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.widget.QQToast;

class FriendProfileMoreInfoActivity$5
  implements ConditionSearchManager.IConfigListener
{
  FriendProfileMoreInfoActivity$5(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((this.a.a == 1) || (this.a.a == 2))
    {
      if (!paramBoolean)
      {
        FriendProfileMoreInfoActivity.a(this.a);
        QQToast.a(this.a, 2131691057, 0).b(this.a.getTitleBarHeight());
        return;
      }
      if (paramInt == 2)
      {
        FriendProfileMoreInfoActivity.a(this.a);
        FriendProfileMoreInfoActivity localFriendProfileMoreInfoActivity = this.a;
        FriendProfileMoreInfoActivity.a(localFriendProfileMoreInfoActivity, localFriendProfileMoreInfoActivity.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity.5
 * JD-Core Version:    0.7.0.1
 */