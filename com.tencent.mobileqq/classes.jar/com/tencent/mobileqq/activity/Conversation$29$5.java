package com.tencent.mobileqq.activity;

import aeib;
import alms;
import java.util.ArrayList;
import java.util.Iterator;

public class Conversation$29$5
  implements Runnable
{
  public Conversation$29$5(aeib paramaeib, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Aeib.a.a != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.jdField_a_of_type_Aeib.a.a.a(str, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.29.5
 * JD-Core Version:    0.7.0.1
 */