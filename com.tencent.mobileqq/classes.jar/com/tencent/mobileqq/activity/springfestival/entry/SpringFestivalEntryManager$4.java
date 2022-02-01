package com.tencent.mobileqq.activity.springfestival.entry;

import com.tencent.mobileqq.activity.springfestival.entry.model.BaseActivityData;

class SpringFestivalEntryManager$4
  implements Runnable
{
  SpringFestivalEntryManager$4(SpringFestivalEntryManager paramSpringFestivalEntryManager, Party.PartyTask paramPartyTask) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_JavaLangObject instanceof BaseActivityData))
    {
      BaseActivityData localBaseActivityData = (BaseActivityData)this.a.jdField_a_of_type_JavaLangObject;
      SpringFestivalEntryManager.a(this.this$0, localBaseActivityData);
      SpringFestivalEntryManager.a(this.this$0).b(this.a.jdField_a_of_type_Long, localBaseActivityData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager.4
 * JD-Core Version:    0.7.0.1
 */