package com.tencent.mobileqq.activity.home;

import ajxk;
import algc;
import java.util.HashSet;
import java.util.Iterator;

public class Conversation$29$3
  implements Runnable
{
  public Conversation$29$3(ajxk paramajxk, HashSet paramHashSet) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Ajxk.a.a != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.jdField_a_of_type_Ajxk.a.a.a(str, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.29.3
 * JD-Core Version:    0.7.0.1
 */