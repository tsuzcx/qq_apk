package com.tencent.ilive.pages.room;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.base.bizmodule.BizModule;
import com.tencent.ilive.base.bizmodule.BizModuleContext;
import com.tencent.ilive.base.bizmodule.BootBizModules;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.commonpages.room.basemodule.BaseRoomCtrlModule;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilive.pages.room.bizmodule.RoomBizModule;
import com.tencent.ilive.pages.room.events.EnterRoomEvent;
import com.tencent.ilive.pages.room.events.ExitRoomtEvent;
import com.tencent.ilive.pages.room.events.FirstFrameEvent;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.livesdk.roomengine.RoomEngine;
import java.util.Iterator;
import java.util.Set;

public abstract class RoomBootBizModules
  extends BootBizModules
{
  Observer enterRoomObserver = new RoomBootBizModules.1(this);
  Observer exitRoomObserver = new RoomBootBizModules.2(this);
  Observer firstFrameObserver = new RoomBootBizModules.3(this);
  private boolean isEnterRoom = false;
  private IAudienceRoomPager mAudienceRoomPager;
  private int mEnterRoomNum = 0;
  private RoomEngine mRoomEngine;
  protected RoomBizContext roomBizContext = new RoomBizContext();
  protected BaseRoomCtrlModule roomCtrlModule;
  
  private void initRoomEvent()
  {
    this.moduleEvent.observe(EnterRoomEvent.class, this.enterRoomObserver);
    this.moduleEvent.observe(ExitRoomtEvent.class, this.exitRoomObserver);
    this.moduleEvent.observe(FirstFrameEvent.class, this.firstFrameObserver);
  }
  
  public void addBizModuleExtData(BizModule paramBizModule)
  {
    paramBizModule = (RoomBizModule)paramBizModule;
    paramBizModule.setRoomEngine(this.mRoomEngine);
    paramBizModule.setAudienceRoomPager(this.mAudienceRoomPager);
  }
  
  public void clearEvent()
  {
    this.moduleEvent.removeObserver(EnterRoomEvent.class, this.enterRoomObserver);
    this.moduleEvent.removeObserver(ExitRoomtEvent.class, this.exitRoomObserver);
    this.moduleEvent.removeObserver(FirstFrameEvent.class, this.firstFrameObserver);
  }
  
  public <T extends BizModuleContext> T getBizModuleContext()
  {
    return this.roomBizContext;
  }
  
  public ViewGroup getLayout()
  {
    return super.getLayout();
  }
  
  public RoomBizContext getRoomBizContext()
  {
    return this.roomBizContext;
  }
  
  public RoomBizModule getRoomCtrlModule()
  {
    return this.roomCtrlModule;
  }
  
  public void onCreate(Context paramContext)
  {
    if (this.mRoomEngine == null)
    {
      if (BizEngineMgr.getInstance().getLiveEngine() != null)
      {
        ((LogInterface)BizEngineMgr.getInstance().getLiveEngine().getService(LogInterface.class)).e("RoomBootBizModules", "onCreate roomengine is null return", new Object[0]);
        return;
      }
      Log.e("RoomBootBizModules", "onCreate roomengine is null return");
      return;
    }
    super.onCreate(paramContext);
    initRoomEvent();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.isEnterRoom = false;
    this.mEnterRoomNum = 0;
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    if ((this.bizModules != null) && (this.bizModules.size() > 0))
    {
      Iterator localIterator = this.bizModules.iterator();
      while (localIterator.hasNext())
      {
        RoomBizModule localRoomBizModule = (RoomBizModule)localIterator.next();
        if (this.mEnterRoomNum > 0)
        {
          if (localRoomBizModule.getAcceptReEnterRoom()) {
            localRoomBizModule.onEnterRoom(paramBoolean);
          }
        }
        else {
          localRoomBizModule.onEnterRoom(paramBoolean);
        }
      }
    }
    this.mEnterRoomNum += 1;
    this.isEnterRoom = true;
  }
  
  public void onExitRoom(boolean paramBoolean)
  {
    if (!this.isEnterRoom) {
      return;
    }
    if ((this.bizModules != null) && (this.bizModules.size() > 0))
    {
      Iterator localIterator = this.bizModules.iterator();
      while (localIterator.hasNext()) {
        ((RoomBizModule)localIterator.next()).onExitRoom(paramBoolean);
      }
    }
  }
  
  public void onFistFrame()
  {
    if ((this.bizModules != null) && (this.bizModules.size() > 0))
    {
      Iterator localIterator = this.bizModules.iterator();
      while (localIterator.hasNext()) {
        ((RoomBizModule)localIterator.next()).onFirstFrame();
      }
    }
  }
  
  public void onPlayOver()
  {
    if ((this.bizModules != null) && (this.bizModules.size() > 0))
    {
      Iterator localIterator = this.bizModules.iterator();
      while (localIterator.hasNext()) {
        ((RoomBizModule)localIterator.next()).onPlayOver();
      }
    }
  }
  
  public void onSwitchRoom(SwitchRoomInfo paramSwitchRoomInfo)
  {
    if ((this.bizModules != null) && (this.bizModules.size() > 0))
    {
      Iterator localIterator = this.bizModules.iterator();
      while (localIterator.hasNext()) {
        ((RoomBizModule)localIterator.next()).onSwitchRoom(paramSwitchRoomInfo);
      }
    }
  }
  
  public void onSwitchScreen(boolean paramBoolean)
  {
    if ((this.bizModules != null) && (this.bizModules.size() > 0))
    {
      Iterator localIterator = this.bizModules.iterator();
      while (localIterator.hasNext()) {
        ((RoomBizModule)localIterator.next()).onSwitchScreen(paramBoolean);
      }
    }
  }
  
  public void setAudienceRoomPager(IAudienceRoomPager paramIAudienceRoomPager)
  {
    this.mAudienceRoomPager = paramIAudienceRoomPager;
  }
  
  public <T extends BizModuleContext> void setBizModuleContext(T paramT)
  {
    this.roomBizContext = ((RoomBizContext)paramT);
  }
  
  public void setRoomBizContext(RoomBizContext paramRoomBizContext)
  {
    setBizModuleContext(paramRoomBizContext);
  }
  
  public void setRoomEngine(RoomEngine paramRoomEngine)
  {
    this.mRoomEngine = paramRoomEngine;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.pages.room.RoomBootBizModules
 * JD-Core Version:    0.7.0.1
 */