package com.tencent.mobileqq.activity.activateFriend;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.data.ActivateFriendItem;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.ArrayList;

class ActivateFriendView$2
  extends FriendListObserver
{
  ActivateFriendView$2(ActivateFriendView paramActivateFriendView) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    int i = 0;
    while (i < ActivateFriendView.a(this.a).size())
    {
      String str = String.valueOf(((ActivateFriendItem)ActivateFriendView.a(this.a).get(i)).uin);
      if (paramString.equals(str))
      {
        paramString = ContactUtils.a(ActivateFriendView.a(this.a), str, false);
        ((ActivateFriendViewItem)ActivateFriendView.b(this.a).get(i)).setNickName(paramString);
        return;
      }
      i += 1;
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    while (i < ActivateFriendView.a(this.a).size())
    {
      String str = ContactUtils.d(ActivateFriendView.a(this.a), String.valueOf(((ActivateFriendItem)ActivateFriendView.a(this.a).get(i)).uin));
      ((ActivateFriendViewItem)ActivateFriendView.b(this.a).get(i)).setNickName(str);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendView.2
 * JD-Core Version:    0.7.0.1
 */