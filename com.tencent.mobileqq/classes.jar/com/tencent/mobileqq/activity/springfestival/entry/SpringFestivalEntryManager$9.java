package com.tencent.mobileqq.activity.springfestival.entry;

import com.tencent.mobileqq.activity.springfestival.entry.model.BaseActivityData;

class SpringFestivalEntryManager$9
  implements Runnable
{
  SpringFestivalEntryManager$9(SpringFestivalEntryManager paramSpringFestivalEntryManager, Party.PartyTask paramPartyTask) {}
  
  public void run()
  {
    if ((this.a.c instanceof BaseActivityData))
    {
      BaseActivityData localBaseActivityData = (BaseActivityData)this.a.c;
      if (localBaseActivityData.equals(SpringFestivalEntryManager.h(this.this$0))) {
        SpringFestivalEntryManager.g(this.this$0).e(localBaseActivityData);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager.9
 * JD-Core Version:    0.7.0.1
 */