package com.tencent.mobileqq.activity.springfestival.entry;

import com.tencent.mobileqq.activity.springfestival.entry.model.BaseActivityData;

class SpringFestivalEntryManager$3
  implements Runnable
{
  SpringFestivalEntryManager$3(SpringFestivalEntryManager paramSpringFestivalEntryManager, Party.PartyTask paramPartyTask) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_JavaLangObject instanceof BaseActivityData))
    {
      BaseActivityData localBaseActivityData = (BaseActivityData)this.a.jdField_a_of_type_JavaLangObject;
      SpringFestivalEntryManager.a(this.this$0, localBaseActivityData);
      SpringFestivalEntryManager.a(this.this$0).a(this.a.jdField_a_of_type_Long, localBaseActivityData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager.3
 * JD-Core Version:    0.7.0.1
 */