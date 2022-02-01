package com.tencent.mobileqq.activity.contact.newfriend;

import android.os.Handler;
import com.tencent.mobileqq.activity.contact.newfriend.poke.NewFriendNotifyPokeObserver;

class NewFriendManager$3
  extends NewFriendNotifyPokeObserver
{
  NewFriendManager$3(NewFriendManager paramNewFriendManager) {}
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (NewFriendManager.a(this.a) != null)) {
      NewFriendManager.a(this.a).sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager.3
 * JD-Core Version:    0.7.0.1
 */