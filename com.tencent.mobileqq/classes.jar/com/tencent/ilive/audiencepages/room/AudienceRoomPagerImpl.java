package com.tencent.ilive.audiencepages.room;

import android.content.Intent;
import com.tencent.ilive.base.page.fragment.LiveTemplateFragment;
import com.tencent.ilive.commonpages.room.VerticalViewPager;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilive.interfaces.RoomPageActionInterface;

public class AudienceRoomPagerImpl
  implements IAudienceRoomPager
{
  private AudienceRoomViewPager mAudienceRoomViewPager;
  
  public AudienceRoomPagerImpl(AudienceRoomViewPager paramAudienceRoomViewPager)
  {
    this.mAudienceRoomViewPager = paramAudienceRoomViewPager;
  }
  
  public LiveTemplateFragment getCurrentFragment()
  {
    if (this.mAudienceRoomViewPager != null) {
      return this.mAudienceRoomViewPager.getCurrentFragment();
    }
    return null;
  }
  
  public Intent getIntent()
  {
    if (this.mAudienceRoomViewPager != null) {
      return this.mAudienceRoomViewPager.getIntent();
    }
    return new Intent();
  }
  
  public int getLastIndex()
  {
    if (this.mAudienceRoomViewPager != null) {
      return this.mAudienceRoomViewPager.getLastIndex();
    }
    return 0;
  }
  
  public RoomPageActionInterface getRoomPageAction()
  {
    if (this.mAudienceRoomViewPager != null) {
      return this.mAudienceRoomViewPager.getRoomPageAction();
    }
    return null;
  }
  
  public int getScrollDirection()
  {
    if (this.mAudienceRoomViewPager != null) {
      return this.mAudienceRoomViewPager.getScrollDirection();
    }
    return 0;
  }
  
  public int getScrollState()
  {
    if (this.mAudienceRoomViewPager != null) {
      return this.mAudienceRoomViewPager.getScrollState();
    }
    return 0;
  }
  
  public VerticalViewPager getViewPager()
  {
    return this.mAudienceRoomViewPager;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.AudienceRoomPagerImpl
 * JD-Core Version:    0.7.0.1
 */