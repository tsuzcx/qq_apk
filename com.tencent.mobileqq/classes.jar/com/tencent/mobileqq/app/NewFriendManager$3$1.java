package com.tencent.mobileqq.app;

import alxr;
import alxu;
import alxx;
import java.util.Iterator;
import java.util.LinkedList;

public class NewFriendManager$3$1
  implements Runnable
{
  public NewFriendManager$3$1(alxu paramalxu, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      synchronized (alxr.a(this.jdField_a_of_type_Alxu.a))
      {
        Iterator localIterator = alxr.a(this.jdField_a_of_type_Alxu.a).iterator();
        if (localIterator.hasNext()) {
          ((alxx)localIterator.next()).al_();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.NewFriendManager.3.1
 * JD-Core Version:    0.7.0.1
 */