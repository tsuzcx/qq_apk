package com.tencent.mobileqq.activity.contact.newfriend;

import aiyr;
import aiyu;
import aiyx;
import java.util.Iterator;
import java.util.LinkedList;

public class NewFriendManager$3$1
  implements Runnable
{
  public NewFriendManager$3$1(aiyu paramaiyu, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      synchronized (aiyr.a(this.jdField_a_of_type_Aiyu.a))
      {
        Iterator localIterator = aiyr.a(this.jdField_a_of_type_Aiyu.a).iterator();
        if (localIterator.hasNext()) {
          ((aiyx)localIterator.next()).an_();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager.3.1
 * JD-Core Version:    0.7.0.1
 */