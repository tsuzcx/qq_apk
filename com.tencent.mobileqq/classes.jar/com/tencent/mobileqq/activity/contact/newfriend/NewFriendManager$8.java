package com.tencent.mobileqq.activity.contact.newfriend;

import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

class NewFriendManager$8
  implements Comparator<Object>
{
  NewFriendManager$8(NewFriendManager paramNewFriendManager) {}
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    int j = -1;
    int i;
    if ((paramObject1 == null) && (paramObject2 == null)) {
      i = 0;
    }
    do
    {
      do
      {
        do
        {
          return i;
          i = j;
        } while (paramObject1 == null);
        if (paramObject2 == null) {
          return 1;
        }
        if (((paramObject1 instanceof NewFriendMessage)) && ((paramObject2 instanceof NewFriendMessage))) {
          return (int)(((NewFriendMessage)paramObject2).a - ((NewFriendMessage)paramObject1).a);
        }
        if (((paramObject1 instanceof NewFriendMessage)) && ((paramObject2 instanceof PhoneContact))) {
          return (int)(((PhoneContact)paramObject2).lastScanTime - ((NewFriendMessage)paramObject1).a * 1000L);
        }
        if (((paramObject1 instanceof PhoneContact)) && ((paramObject2 instanceof PhoneContact))) {
          return (int)(((PhoneContact)paramObject2).lastScanTime - ((PhoneContact)paramObject1).lastScanTime);
        }
        if (((paramObject1 instanceof PhoneContact)) && ((paramObject2 instanceof NewFriendMessage))) {
          return (int)(((NewFriendMessage)paramObject2).a * 1000L - ((PhoneContact)paramObject1).lastScanTime);
        }
        i = j;
      } while ((paramObject1 instanceof PhoneContact));
      i = j;
    } while ((paramObject1 instanceof NewFriendMessage));
    if (((paramObject2 instanceof PhoneContact)) || ((paramObject2 instanceof NewFriendMessage))) {
      return 1;
    }
    return paramObject1.hashCode() - paramObject2.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager.8
 * JD-Core Version:    0.7.0.1
 */