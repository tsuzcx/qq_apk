package com.tencent.ilive.commonpages.room.basemodule;

import android.content.Context;
import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.log.LogSdkServiceInterface;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.falco.base.libapi.network.NetworkStateInterface;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilive.pages.room.bizmodule.RoomBizModule;
import com.tencent.ilive.pages.room.datamodel.RoomState;
import com.tencent.ilive.pages.room.events.ExitRoomtEvent;
import com.tencent.ilive.pages.room.events.ShowLiveOverEvent;
import com.tencent.ilive.pages.room.events.ShowLiveOverEvent.Source;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.livesdk.roomengine.RoomEngine;

public class BaseRoomCtrlModule
  extends RoomBizModule
{
  private final String TAG = "RoomCtrlModule";
  protected EnterRoomInfo enterRoomInfo;
  protected boolean isRoomEngineExit = false;
  protected RoomEngine roomEngine;
  protected RoomServiceInterface roomService;
  
  protected void goLiveOver(String paramString)
  {
    getEvent().post(new ShowLiveOverEvent(paramString, ShowLiveOverEvent.Source.ANCHOR_OVER));
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    getLog().i("RoomCtrlModule", "onCreate--", new Object[0]);
    this.isRoomEngineExit = false;
    this.roomEngine = getRoomEngine();
    this.roomService = ((RoomServiceInterface)this.roomEngine.getService(RoomServiceInterface.class));
    this.enterRoomInfo = getRoomBizContext().getEnterRoomInfo();
  }
  
  public void onDestroy()
  {
    boolean bool = this.roomBizContext.getRoomState().isSwitchRoom;
    super.onDestroy();
    if ((!this.isRoomEngineExit) && (!bool))
    {
      this.roomEngine.unint();
      this.isRoomEngineExit = true;
    }
    getEvent().clearObservers();
  }
  
  protected void onExitRoomEvent()
  {
    getEvent().post(new ExitRoomtEvent(true));
    ((NetworkStateInterface)this.roomEngine.getService(NetworkStateInterface.class)).clearEventOutput();
    ((ChannelInterface)this.roomEngine.getService(ChannelInterface.class)).clearEventOutput();
    this.roomEngine.unint();
    this.isRoomEngineExit = true;
    long l = ((LoginServiceInterface)this.roomEngine.getService(LoginServiceInterface.class)).getLoginInfo().uid;
    ((LogSdkServiceInterface)this.roomEngine.getService(LogSdkServiceInterface.class)).upload(String.valueOf(l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.commonpages.room.basemodule.BaseRoomCtrlModule
 * JD-Core Version:    0.7.0.1
 */