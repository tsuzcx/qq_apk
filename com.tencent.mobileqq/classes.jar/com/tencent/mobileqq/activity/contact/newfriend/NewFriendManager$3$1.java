package com.tencent.mobileqq.activity.contact.newfriend;

import ajka;
import ajkd;
import ajkg;
import java.util.Iterator;
import java.util.LinkedList;

public class NewFriendManager$3$1
  implements Runnable
{
  public NewFriendManager$3$1(ajkd paramajkd, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      synchronized (ajka.a(this.jdField_a_of_type_Ajkd.a))
      {
        Iterator localIterator = ajka.a(this.jdField_a_of_type_Ajkd.a).iterator();
        if (localIterator.hasNext()) {
          ((ajkg)localIterator.next()).an_();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager.3.1
 * JD-Core Version:    0.7.0.1
 */