package com.tencent.mobileqq.activity.contact.newfriend;

import com.tencent.mobileqq.data.SysSuspiciousMsg;
import java.util.Comparator;

class NewFriendManager$2
  implements Comparator<SysSuspiciousMsg>
{
  NewFriendManager$2(NewFriendManager paramNewFriendManager) {}
  
  public int a(SysSuspiciousMsg paramSysSuspiciousMsg1, SysSuspiciousMsg paramSysSuspiciousMsg2)
  {
    if ((paramSysSuspiciousMsg1 != null) && (paramSysSuspiciousMsg2 != null)) {
      return (int)(paramSysSuspiciousMsg2.time - paramSysSuspiciousMsg1.time);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager.2
 * JD-Core Version:    0.7.0.1
 */