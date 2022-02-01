package com.tencent.mobileqq.activity.springfestival.entry;

import com.tencent.mobileqq.activity.springfestival.entry.model.BaseActivityData;

class SpringFestivalEntryManager$5
  implements Runnable
{
  SpringFestivalEntryManager$5(SpringFestivalEntryManager paramSpringFestivalEntryManager, Party.PartyTask paramPartyTask) {}
  
  public void run()
  {
    if ((this.a.a instanceof BaseActivityData))
    {
      BaseActivityData localBaseActivityData = (BaseActivityData)this.a.a;
      SpringFestivalEntryManager.a(this.this$0, localBaseActivityData);
      SpringFestivalEntryManager.a(this.this$0).a(localBaseActivityData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager.5
 * JD-Core Version:    0.7.0.1
 */