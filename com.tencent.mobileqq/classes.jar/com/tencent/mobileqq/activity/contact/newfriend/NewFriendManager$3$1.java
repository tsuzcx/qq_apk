package com.tencent.mobileqq.activity.contact.newfriend;

import aizi;
import aizl;
import aizo;
import java.util.Iterator;
import java.util.LinkedList;

public class NewFriendManager$3$1
  implements Runnable
{
  public NewFriendManager$3$1(aizl paramaizl, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      synchronized (aizi.a(this.jdField_a_of_type_Aizl.a))
      {
        Iterator localIterator = aizi.a(this.jdField_a_of_type_Aizl.a).iterator();
        if (localIterator.hasNext()) {
          ((aizo)localIterator.next()).af_();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager.3.1
 * JD-Core Version:    0.7.0.1
 */