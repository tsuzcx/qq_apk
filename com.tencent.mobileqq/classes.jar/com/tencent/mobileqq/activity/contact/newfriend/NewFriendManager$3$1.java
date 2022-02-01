package com.tencent.mobileqq.activity.contact.newfriend;

import aiej;
import aiem;
import aiep;
import java.util.Iterator;
import java.util.LinkedList;

public class NewFriendManager$3$1
  implements Runnable
{
  public NewFriendManager$3$1(aiem paramaiem, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      synchronized (aiej.a(this.jdField_a_of_type_Aiem.a))
      {
        Iterator localIterator = aiej.a(this.jdField_a_of_type_Aiem.a).iterator();
        if (localIterator.hasNext()) {
          ((aiep)localIterator.next()).ad_();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager.3.1
 * JD-Core Version:    0.7.0.1
 */