package com.tencent.mobileqq.activity.springfestival.entry;

import com.tencent.mobileqq.activity.springfestival.entry.model.MsgTabBannerData;

class SpringFestivalEntryManager$13
  implements Runnable
{
  SpringFestivalEntryManager$13(SpringFestivalEntryManager paramSpringFestivalEntryManager, Party.PartyTask paramPartyTask) {}
  
  public void run()
  {
    if ((this.a.a instanceof MsgTabBannerData))
    {
      MsgTabBannerData localMsgTabBannerData = (MsgTabBannerData)this.a.a;
      SpringFestivalEntryManager.a(this.this$0, localMsgTabBannerData);
      SpringFestivalEntryManager.a(this.this$0).a(localMsgTabBannerData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager.13
 * JD-Core Version:    0.7.0.1
 */