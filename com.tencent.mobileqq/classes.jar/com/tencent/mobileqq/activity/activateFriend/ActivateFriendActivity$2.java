package com.tencent.mobileqq.activity.activateFriend;

import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

class ActivateFriendActivity$2
  implements Comparator<MessageRecord>
{
  ActivateFriendActivity$2(ActivateFriendActivity paramActivateFriendActivity) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    long l2 = paramMessageRecord1.time - paramMessageRecord2.time;
    long l1 = l2;
    if (l2 == 0L) {
      l1 = paramMessageRecord1.getId() - paramMessageRecord2.getId();
    }
    if (l1 > 0L) {
      return -1;
    }
    if (l1 < 0L) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity.2
 * JD-Core Version:    0.7.0.1
 */