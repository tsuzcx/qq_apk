package com.tencent.mobileqq.activity.activateFriend;

import android.content.res.Resources;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsObserver;
import com.tencent.mobileqq.data.ActivateFriendItem;
import java.util.ArrayList;

class ActivateFriendView$3
  extends ActivateFriendsObserver
{
  ActivateFriendView$3(ActivateFriendView paramActivateFriendView) {}
  
  public void b()
  {
    if (ActivateFriendView.e(this.a) != null)
    {
      if (ActivateFriendView.g(this.a) == null) {
        return;
      }
      ActivateFriendView.a(this.a, 0);
      int i = 0;
      while (i < ActivateFriendView.e(this.a).size())
      {
        if (this.a.a.c(((ActivateFriendItem)ActivateFriendView.e(this.a).get(i)).uin, 2))
        {
          ((ActivateFriendViewItem)ActivateFriendView.g(this.a).get(i)).setChecked(false);
          ((ActivateFriendViewItem)ActivateFriendView.g(this.a).get(i)).setBirthday(this.a.getResources().getString(2131886159));
        }
        else if (this.a.a.b(((ActivateFriendItem)ActivateFriendView.e(this.a).get(i)).uin, 2))
        {
          ((ActivateFriendViewItem)ActivateFriendView.g(this.a).get(i)).setChecked(false);
          ((ActivateFriendViewItem)ActivateFriendView.g(this.a).get(i)).setBirthday(this.a.getResources().getString(2131886162));
        }
        else
        {
          ActivateFriendView.b(this.a);
          ((ActivateFriendViewItem)ActivateFriendView.g(this.a).get(i)).setChecked(true);
        }
        i += 1;
      }
      if (ActivateFriendView.c(this.a) != null) {
        ActivateFriendView.c(this.a).a(ActivateFriendView.d(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendView.3
 * JD-Core Version:    0.7.0.1
 */