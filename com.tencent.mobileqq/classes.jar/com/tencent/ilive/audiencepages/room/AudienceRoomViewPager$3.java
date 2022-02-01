package com.tencent.ilive.audiencepages.room;

import android.content.Intent;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.audiencepages.room.pagelogic.AudienceMultiRoomPageLogic;
import com.tencent.ilive.audiencepages.room.pagelogic.widgets.SwitchRoomAdapter;
import com.tencent.ilive.base.bizmodule.BootBizModules;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.base.page.PageListener;
import com.tencent.ilive.base.page.fragment.LiveTemplateFragment;
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
    AudienceRoomViewPager.access$1002(this.this$0, paramInt);
    AudienceRoomViewPager.access$1102(this.this$0, true);
  }
  
  public void onPageScrollTop() {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (AudienceRoomViewPager.access$000(this.this$0) != null) {
      AudienceRoomViewPager.access$000(this.this$0).i("AudienceRoomViewPager", "onPageScrolled--onPageScrolled position = " + paramInt1 + " positionOffset = " + paramFloat + " positionOffsetPixels = " + paramInt2 + " countTotal = " + this.this$0.getAdapter().getCount(), new Object[0]);
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      AudienceRoomViewPager.access$300(this.this$0, 0);
    }
    while ((paramInt1 != this.this$0.getAdapter().getCount() - 1) || (paramInt2 != 0)) {
      return;
    }
    AudienceRoomViewPager.access$300(this.this$0, 1);
  }
  
  public void onPageSelected(int paramInt)
  {
    if (AudienceRoomViewPager.access$400(this.this$0) < paramInt)
    {
      AudienceRoomViewPager.access$502(this.this$0, 2);
      AudienceRoomViewPager.access$402(this.this$0, paramInt);
      if (AudienceRoomViewPager.access$600(this.this$0) != null) {
        break label75;
      }
    }
    label75:
    do
    {
      return;
      if (AudienceRoomViewPager.access$400(this.this$0) > paramInt)
      {
        AudienceRoomViewPager.access$502(this.this$0, 1);
        break;
      }
      AudienceRoomViewPager.access$502(this.this$0, 0);
      break;
      SwitchRoomInfo localSwitchRoomInfo = AudienceRoomViewPager.access$600(this.this$0).getSwitchRoomInfo(paramInt);
      AudienceRoomViewPager.access$702(this.this$0, localSwitchRoomInfo.roomId);
      AudienceRoomViewPager.access$802(this.this$0, localSwitchRoomInfo.videoId);
      this.this$0.getIntent().putExtra("video_url", "");
      this.this$0.currentFragment = ((AudienceRoomFragment)AudienceRoomViewPager.access$600(this.this$0).getItem(paramInt));
      this.this$0.currentFragment.setPageListener(this.this$0.mPageListener);
      AudienceRoomViewPager.access$900(this.this$0).onSwitchRoomBefore(localSwitchRoomInfo, (AudienceRoomFragment)this.this$0.currentFragment);
      RoomEngine localRoomEngine = ((AudienceRoomFragment)this.this$0.currentFragment).getRoomEngine();
      AudienceRoomViewPager.access$900(this.this$0).setRoomEngine(localRoomEngine);
      BizEngineMgr.getInstance().setCurrentRoomEngine(localRoomEngine);
      AudienceRoomViewPager.access$900(this.this$0).onSwitchRoomAfter(localSwitchRoomInfo);
    } while (!this.this$0.currentFragment.isFragmentCreated);
    this.this$0.mPageListener.onFragmentCreated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.AudienceRoomViewPager.3
 * JD-Core Version:    0.7.0.1
 */