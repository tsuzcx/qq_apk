package com.tencent.mobileqq.activity;

import aawe;
import ahmv;
import java.util.ArrayList;
import java.util.Iterator;

public class Conversation$27$5
  implements Runnable
{
  public Conversation$27$5(aawe paramaawe, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Aawe.a.a != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.jdField_a_of_type_Aawe.a.a.a(str, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.27.5
 * JD-Core Version:    0.7.0.1
 */