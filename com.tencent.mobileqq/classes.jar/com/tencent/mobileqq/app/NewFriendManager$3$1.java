package com.tencent.mobileqq.app;

import altc;
import altf;
import alti;
import java.util.Iterator;
import java.util.LinkedList;

public class NewFriendManager$3$1
  implements Runnable
{
  public NewFriendManager$3$1(altf paramaltf, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      synchronized (altc.a(this.jdField_a_of_type_Altf.a))
      {
        Iterator localIterator = altc.a(this.jdField_a_of_type_Altf.a).iterator();
        if (localIterator.hasNext()) {
          ((alti)localIterator.next()).ao_();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.NewFriendManager.3.1
 * JD-Core Version:    0.7.0.1
 */