package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import java.util.Comparator;

class QIMNewFriendManager$2
  implements Comparator<QIMNotifyAddFriend>
{
  QIMNewFriendManager$2(QIMNewFriendManager paramQIMNewFriendManager) {}
  
  public int a(QIMNotifyAddFriend paramQIMNotifyAddFriend1, QIMNotifyAddFriend paramQIMNotifyAddFriend2)
  {
    return (int)(paramQIMNotifyAddFriend2.pushTime - paramQIMNotifyAddFriend1.pushTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.QIMNewFriendManager.2
 * JD-Core Version:    0.7.0.1
 */