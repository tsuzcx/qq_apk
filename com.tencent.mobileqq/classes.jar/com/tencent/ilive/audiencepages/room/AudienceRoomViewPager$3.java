package com.tencent.ilive.audiencepages.room;

import android.content.Intent;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.audiencepages.room.pagelogic.AudienceMultiRoomPageLogic;
import com.tencent.ilive.audiencepages.room.pagelogic.widgets.SwitchRoomAdapter;
import com.tencent.ilive.base.bizmodule.BootBizModules;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.base.page.PageListener;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilive.interfaces.ILiveOnPageChangeListener;
import com.tencent.ilive.pages.room.events.ScrollBottomEvent;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;
import com.tencent.livesdk.roomengine.RoomEngine;

class AudienceRoomViewPager$3
  implements ILiveOnPageChangeListener
{
  AudienceRoomViewPager$3(AudienceRoomViewPager paramAudienceRoomViewPager) {}
  
  public void onPageScrollBottom()
  {
    if ((this.this$0.currentFragment != null) && (this.this$0.currentFragment.getBootBizModules() != null) && (this.this$0.currentFragment.getBootBizModules().getModuleEvent() != null)) {
      this.this$0.currentFragment.getBootBizModules().getModuleEvent().post(new ScrollBottomEvent());
    }
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    AudienceRoomViewPager.access$1102(this.this$0, paramInt);
    AudienceRoomViewPager.access$1202(this.this$0, true);
  }
  
  public void onPageScrollTop() {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (AudienceRoomViewPager.access$000(this.this$0) != null)
    {
      LogInterface localLogInterface = AudienceRoomViewPager.access$000(this.this$0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageScrolled--onPageScrolled position = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" positionOffset = ");
      localStringBuilder.append(paramFloat);
      localStringBuilder.append(" positionOffsetPixels = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" countTotal = ");
      localStringBuilder.append(this.this$0.getAdapter().getCount());
      localLogInterface.i("AudienceRoomViewPager", localStringBuilder.toString(), new Object[0]);
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      AudienceRoomViewPager.access$300(this.this$0, 0);
      return;
    }
    if ((paramInt1 == this.this$0.getAdapter().getCount() - 1) && (paramInt2 == 0)) {
      AudienceRoomViewPager.access$300(this.this$0, 1);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if ((AudienceRoomViewPager.access$400(this.this$0)) && (paramInt == 0)) {
      return;
    }
    if (AudienceRoomViewPager.access$500(this.this$0) < paramInt) {
      AudienceRoomViewPager.access$602(this.this$0, 2);
    } else if (AudienceRoomViewPager.access$500(this.this$0) > paramInt) {
      AudienceRoomViewPager.access$602(this.this$0, 1);
    } else {
      AudienceRoomViewPager.access$602(this.this$0, 0);
    }
    AudienceRoomViewPager.access$502(this.this$0, paramInt);
    if (AudienceRoomViewPager.access$700(this.this$0) == null) {
      return;
    }
    SwitchRoomInfo localSwitchRoomInfo = AudienceRoomViewPager.access$700(this.this$0).getSwitchRoomInfo(paramInt);
    AudienceRoomViewPager.access$802(this.this$0, localSwitchRoomInfo.roomId);
    AudienceRoomViewPager.access$902(this.this$0, localSwitchRoomInfo.videoId);
    this.this$0.getIntent().putExtra("video_url", "");
    Object localObject = this.this$0;
    ((AudienceRoomViewPager)localObject).currentFragment = ((AudienceRoomFragment)AudienceRoomViewPager.access$700((AudienceRoomViewPager)localObject).getItem(paramInt));
    this.this$0.currentFragment.setPageListener(this.this$0.mPageListener);
    AudienceRoomViewPager.access$1000(this.this$0).onSwitchRoomBefore(localSwitchRoomInfo, this.this$0.currentFragment);
    AudienceRoomViewPager.access$1000(this.this$0).exitRoom();
    localObject = this.this$0.currentFragment.getRoomEngine();
    AudienceRoomViewPager.access$1000(this.this$0).setRoomEngine((RoomEngine)localObject);
    BizEngineMgr.getInstance().setCurrentRoomEngine((RoomEngine)localObject);
    AudienceRoomViewPager.access$1000(this.this$0).onSwitchRoomAfter(localSwitchRoomInfo);
    if (this.this$0.currentFragment.isFragmentCreated) {
      this.this$0.mPageListener.onFragmentCreated();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.AudienceRoomViewPager.3
 * JD-Core Version:    0.7.0.1
 */