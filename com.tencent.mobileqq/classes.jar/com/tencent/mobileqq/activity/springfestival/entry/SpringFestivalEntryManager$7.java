package com.tencent.mobileqq.activity.springfestival.entry;

import com.tencent.mobileqq.activity.springfestival.entry.model.BaseActivityData;

class SpringFestivalEntryManager$7
  implements Runnable
{
  SpringFestivalEntryManager$7(SpringFestivalEntryManager paramSpringFestivalEntryManager, Party.PartyTask paramPartyTask) {}
  
  public void run()
  {
    if ((this.a.a instanceof BaseActivityData))
    {
      BaseActivityData localBaseActivityData = (BaseActivityData)this.a.a;
      if (localBaseActivityData.equals(SpringFestivalEntryManager.a(this.this$0))) {
        SpringFestivalEntryManager.a(this.this$0).c(localBaseActivityData);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager.7
 * JD-Core Version:    0.7.0.1
 */