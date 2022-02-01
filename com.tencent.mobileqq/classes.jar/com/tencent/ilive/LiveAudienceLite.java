package com.tencent.ilive;

import com.tencent.ilive.audiencepages.room.AudienceRoomActivity;
import com.tencent.ilive.base.page.PageFactory;
import com.tencent.ilive.base.page.PageType;
import com.tencent.ilive.base.page.config.ActivityConfig;
import com.tencent.ilive.base.page.config.FragmentConfig;
import com.tencent.ilive.litepages.room.AudienceLiteRoomFragment;

public class LiveAudienceLite
{
  public static void initPageConfig()
  {
    ActivityConfig localActivityConfig = new ActivityConfig();
    FragmentConfig localFragmentConfig = new FragmentConfig();
    localActivityConfig.add(PageType.LIVE_ROOM_AUDIENCE_LITE.value, AudienceRoomActivity.class);
    localFragmentConfig.add(PageType.LIVE_ROOM_AUDIENCE_LITE.value, AudienceLiteRoomFragment.class);
    PageFactory.initPageConfig(localActivityConfig, localFragmentConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.LiveAudienceLite
 * JD-Core Version:    0.7.0.1
 */