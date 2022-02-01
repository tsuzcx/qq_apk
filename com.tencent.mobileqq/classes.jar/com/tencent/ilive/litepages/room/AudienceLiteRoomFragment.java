package com.tencent.ilive.litepages.room;

import com.tencent.ilive.audiencepages.room.AudienceRoomFragment;
import com.tencent.ilive.config.AudienceLiteRoomConfig;
import com.tencent.ilive.config.PageConfigInterface;

public class AudienceLiteRoomFragment
  extends AudienceRoomFragment
{
  public PageConfigInterface getPageUIConfig()
  {
    return new AudienceLiteRoomConfig();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.AudienceLiteRoomFragment
 * JD-Core Version:    0.7.0.1
 */