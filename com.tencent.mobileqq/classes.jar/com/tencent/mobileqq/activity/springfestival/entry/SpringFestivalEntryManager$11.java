package com.tencent.mobileqq.activity.springfestival.entry;

import com.tencent.mobileqq.activity.springfestival.entry.model.PopBannerData;

class SpringFestivalEntryManager$11
  implements Runnable
{
  SpringFestivalEntryManager$11(SpringFestivalEntryManager paramSpringFestivalEntryManager, Party.PartyTask paramPartyTask) {}
  
  public void run()
  {
    if ((this.a.c instanceof PopBannerData))
    {
      PopBannerData localPopBannerData = (PopBannerData)this.a.c;
      SpringFestivalEntryManager.a(this.this$0, localPopBannerData);
      SpringFestivalEntryManager.g(this.this$0).a(localPopBannerData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager.11
 * JD-Core Version:    0.7.0.1
 */