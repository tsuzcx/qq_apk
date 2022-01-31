package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry;

import ahfx;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo;
import com.tencent.mobileqq.mini.entry.QQMessagePageMiniAppEntryManager;
import mqq.app.AppRuntime;

public class SpringHbEntryManager$19
  implements Runnable
{
  public SpringHbEntryManager$19(ahfx paramahfx, boolean paramBoolean, SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo.PendantEntryInfo.BannerInfo paramBannerInfo) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("show", this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo$PendantEntryInfo$BannerInfo.bannerHeight = this.this$0.a();
      localBundle.putSerializable("bannerInfo", this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpringfestivalConfigSpringFestivalRedpacketConfBean$SpringFestivalHbEntryInfo$PendantEntryInfo$BannerInfo);
    }
    BaseApplicationImpl.getApplication().getRuntime().notifyObservers(QQMessagePageMiniAppEntryManager.class, 104, true, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.SpringHbEntryManager.19
 * JD-Core Version:    0.7.0.1
 */