package com.tencent.mobileqq.activity.activateFriend;

import android.content.res.Resources;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsObserver;
import com.tencent.mobileqq.data.ActivateFriendItem;
import java.util.ArrayList;

class ActivateFriendGrid$3
  extends ActivateFriendsObserver
{
  ActivateFriendGrid$3(ActivateFriendGrid paramActivateFriendGrid) {}
  
  public void b()
  {
    if (ActivateFriendGrid.f(this.a) != null)
    {
      if (ActivateFriendGrid.h(this.a) == null) {
        return;
      }
      int i = 0;
      while (i < ActivateFriendGrid.f(this.a).size())
      {
        if (this.a.a.c(((ActivateFriendItem)ActivateFriendGrid.f(this.a).get(i)).uin, 2))
        {
          ((ActivateFriendGridItem)ActivateFriendGrid.h(this.a).get(i)).setChecked(false);
          ((ActivateFriendGridItem)ActivateFriendGrid.h(this.a).get(i)).setBirthday(this.a.getResources().getString(2131886159));
        }
        else if (this.a.a.b(((ActivateFriendItem)ActivateFriendGrid.f(this.a).get(i)).uin, 2))
        {
          ((ActivateFriendGridItem)ActivateFriendGrid.h(this.a).get(i)).setChecked(false);
          ((ActivateFriendGridItem)ActivateFriendGrid.h(this.a).get(i)).setBirthday(this.a.getResources().getString(2131886162));
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid.3
 * JD-Core Version:    0.7.0.1
 */