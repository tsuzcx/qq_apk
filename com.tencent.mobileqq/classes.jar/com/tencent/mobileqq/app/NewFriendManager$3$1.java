package com.tencent.mobileqq.app;

import ajnf;
import ajni;
import ajnk;
import java.util.Iterator;
import java.util.LinkedList;

public class NewFriendManager$3$1
  implements Runnable
{
  public NewFriendManager$3$1(ajni paramajni, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      synchronized (ajnf.a(this.jdField_a_of_type_Ajni.a))
      {
        Iterator localIterator = ajnf.a(this.jdField_a_of_type_Ajni.a).iterator();
        if (localIterator.hasNext()) {
          ((ajnk)localIterator.next()).aj_();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.NewFriendManager.3.1
 * JD-Core Version:    0.7.0.1
 */