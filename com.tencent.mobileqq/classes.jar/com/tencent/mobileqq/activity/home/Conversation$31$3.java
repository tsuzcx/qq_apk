package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.activity.recent.RecentAdapter;
import java.util.ArrayList;
import java.util.Iterator;

class Conversation$31$3
  implements Runnable
{
  Conversation$31$3(Conversation.31 param31, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$31.a.a != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$31.a.a.a(str, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.31.3
 * JD-Core Version:    0.7.0.1
 */