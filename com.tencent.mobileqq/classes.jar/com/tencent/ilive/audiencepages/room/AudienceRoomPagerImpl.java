package com.tencent.ilive.audiencepages.room;

import android.content.Intent;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.ilive.base.page.fragment.LiveTemplateFragment;
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
  
  public int getCount()
  {
    AudienceRoomViewPager localAudienceRoomViewPager = this.mAudienceRoomViewPager;
    if ((localAudienceRoomViewPager != null) && (localAudienceRoomViewPager.getAdapter() != null)) {
      return this.mAudienceRoomViewPager.getAdapter().getCount();
    }
    return 0;
  }
  
  public LiveTemplateFragment getCurrentFragment()
  {
    AudienceRoomViewPager localAudienceRoomViewPager = this.mAudienceRoomViewPager;
    if (localAudienceRoomViewPager != null) {
      return localAudienceRoomViewPager.getCurrentFragment();
    }
    return null;
  }
  
  public int getCurrentIndex()
  {
    return this.mAudienceRoomViewPager.getCurrentItem();
  }
  
  public Intent getIntent()
  {
    AudienceRoomViewPager localAudienceRoomViewPager = this.mAudienceRoomViewPager;
    if (localAudienceRoomViewPager != null) {
      return localAudienceRoomViewPager.getIntent();
    }
    return new Intent();
  }
  
  public int getLastIndex()
  {
    AudienceRoomViewPager localAudienceRoomViewPager = this.mAudienceRoomViewPager;
    if (localAudienceRoomViewPager != null) {
      return localAudienceRoomViewPager.getLastIndex();
    }
    return 0;
  }
  
  public RoomPageActionInterface getRoomPageAction()
  {
    AudienceRoomViewPager localAudienceRoomViewPager = this.mAudienceRoomViewPager;
    if (localAudienceRoomViewPager != null) {
      return localAudienceRoomViewPager.getRoomPageAction();
    }
    return null;
  }
  
  public int getScrollDirection()
  {
    AudienceRoomViewPager localAudienceRoomViewPager = this.mAudienceRoomViewPager;
    if (localAudienceRoomViewPager != null) {
      return localAudienceRoomViewPager.getScrollDirection();
    }
    return 0;
  }
  
  public int getScrollState()
  {
    AudienceRoomViewPager localAudienceRoomViewPager = this.mAudienceRoomViewPager;
    if (localAudienceRoomViewPager != null) {
      return localAudienceRoomViewPager.getScrollState();
    }
    return 0;
  }
  
  public int getScrollY()
  {
    AudienceRoomViewPager localAudienceRoomViewPager = this.mAudienceRoomViewPager;
    if (localAudienceRoomViewPager != null) {
      return localAudienceRoomViewPager.getScrollY();
    }
    return 0;
  }
  
  public void onDestroy() {}
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    AudienceRoomViewPager localAudienceRoomViewPager = this.mAudienceRoomViewPager;
    if (localAudienceRoomViewPager != null) {
      localAudienceRoomViewPager.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    AudienceRoomViewPager localAudienceRoomViewPager = this.mAudienceRoomViewPager;
    if (localAudienceRoomViewPager != null) {
      localAudienceRoomViewPager.scrollTo(paramInt1, paramInt2);
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    AudienceRoomViewPager localAudienceRoomViewPager = this.mAudienceRoomViewPager;
    if ((localAudienceRoomViewPager != null) && (paramInt < localAudienceRoomViewPager.getAdapter().getCount())) {
      this.mAudienceRoomViewPager.setCurrentItem(paramInt);
    }
  }
  
  public void setScrollForbidden(boolean paramBoolean)
  {
    AudienceRoomViewPager localAudienceRoomViewPager = this.mAudienceRoomViewPager;
    if (localAudienceRoomViewPager != null) {
      localAudienceRoomViewPager.setScrollForbidden(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.AudienceRoomPagerImpl
 * JD-Core Version:    0.7.0.1
 */