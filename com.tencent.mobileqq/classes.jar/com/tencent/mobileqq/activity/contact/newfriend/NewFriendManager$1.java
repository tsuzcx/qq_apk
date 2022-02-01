package com.tencent.mobileqq.activity.contact.newfriend;

import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendMessage;
import java.util.Comparator;

class NewFriendManager$1
  implements Comparator<NewFriendMessage>
{
  NewFriendManager$1(NewFriendManager paramNewFriendManager) {}
  
  public int a(NewFriendMessage paramNewFriendMessage1, NewFriendMessage paramNewFriendMessage2)
  {
    if ((!paramNewFriendMessage1.a()) && (paramNewFriendMessage2.a())) {
      return -1;
    }
    if ((paramNewFriendMessage1.a()) && (!paramNewFriendMessage2.a())) {
      return 1;
    }
    return (int)(paramNewFriendMessage2.a - paramNewFriendMessage1.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager.1
 * JD-Core Version:    0.7.0.1
 */