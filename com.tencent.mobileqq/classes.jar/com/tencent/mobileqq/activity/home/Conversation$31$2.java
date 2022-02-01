package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.activity.recent.RecentAdapter;
import java.util.HashSet;
import java.util.Iterator;

class Conversation$31$2
  implements Runnable
{
  Conversation$31$2(Conversation.31 param31, HashSet paramHashSet) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$31.a.a != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation$31.a.a.a(str, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.31.2
 * JD-Core Version:    0.7.0.1
 */