package com.tencent.mobileqq.activity.home;

import ajbw;
import akkk;
import java.util.ArrayList;
import java.util.Iterator;

public class Conversation$30$5
  implements Runnable
{
  public Conversation$30$5(ajbw paramajbw, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Ajbw.a.a != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.jdField_a_of_type_Ajbw.a.a.a(str, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.30.5
 * JD-Core Version:    0.7.0.1
 */