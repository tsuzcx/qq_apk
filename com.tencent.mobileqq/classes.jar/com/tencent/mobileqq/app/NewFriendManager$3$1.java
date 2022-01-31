package com.tencent.mobileqq.app;

import akbo;
import akbr;
import akbu;
import java.util.Iterator;
import java.util.LinkedList;

public class NewFriendManager$3$1
  implements Runnable
{
  public NewFriendManager$3$1(akbr paramakbr, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      synchronized (akbo.a(this.jdField_a_of_type_Akbr.a))
      {
        Iterator localIterator = akbo.a(this.jdField_a_of_type_Akbr.a).iterator();
        if (localIterator.hasNext()) {
          ((akbu)localIterator.next()).ag_();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.NewFriendManager.3.1
 * JD-Core Version:    0.7.0.1
 */