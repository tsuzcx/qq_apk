package com.tencent.mobileqq.activity.contact.newfriend;

import java.util.Iterator;
import java.util.LinkedList;

class NewFriendManager$4$1
  implements Runnable
{
  NewFriendManager$4$1(NewFriendManager.4 param4, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      synchronized (NewFriendManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager$4.a))
      {
        Iterator localIterator = NewFriendManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager$4.a).iterator();
        if (localIterator.hasNext()) {
          ((NewFriendManager.INewFriendListener)localIterator.next()).ae_();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager.4.1
 * JD-Core Version:    0.7.0.1
 */