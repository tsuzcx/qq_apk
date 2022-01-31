package com.tencent.mobileqq.app;

import akbn;
import akbq;
import akbt;
import java.util.Iterator;
import java.util.LinkedList;

public class NewFriendManager$3$1
  implements Runnable
{
  public NewFriendManager$3$1(akbq paramakbq, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      synchronized (akbn.a(this.jdField_a_of_type_Akbq.a))
      {
        Iterator localIterator = akbn.a(this.jdField_a_of_type_Akbq.a).iterator();
        if (localIterator.hasNext()) {
          ((akbt)localIterator.next()).ag_();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.NewFriendManager.3.1
 * JD-Core Version:    0.7.0.1
 */