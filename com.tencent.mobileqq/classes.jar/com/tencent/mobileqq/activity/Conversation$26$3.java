package com.tencent.mobileqq.activity;

import acrq;
import ajit;
import java.util.HashSet;
import java.util.Iterator;

public class Conversation$26$3
  implements Runnable
{
  public Conversation$26$3(acrq paramacrq, HashSet paramHashSet) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Acrq.a.a != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.jdField_a_of_type_Acrq.a.a.a(str, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.26.3
 * JD-Core Version:    0.7.0.1
 */