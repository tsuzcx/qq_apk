package com.tencent.ilive.enginemanager;

import com.tencent.livesdk.accountengine.UserEngine;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.livesdk.roomengine.RoomEngine;
import com.tencent.livesdk.servicefactory.ServiceAccessorMgr;

public class BizEngineMgr
{
  private static BizEngineMgr instance;
  private LiveEngine liveEngine;
  private UserEngine userEngine;
  
  public static BizEngineMgr getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new BizEngineMgr();
      }
      BizEngineMgr localBizEngineMgr = instance;
      return localBizEngineMgr;
    }
    finally {}
  }
  
  public LiveEngine getLiveEngine()
  {
    return this.liveEngine;
  }
  
  public UserEngine getUserEngine()
  {
    return this.userEngine;
  }
  
  public void init() {}
  
  public void setCurrentRoomEngine(RoomEngine paramRoomEngine)
  {
    this.userEngine.setCurrentRoomEngine(paramRoomEngine);
    ServiceAccessorMgr.getInstance().setRoomAccessor(paramRoomEngine.getServiceAccessor());
  }
  
  public void setLiveEngine(LiveEngine paramLiveEngine)
  {
    this.liveEngine = paramLiveEngine;
  }
  
  public void setUserEngine(UserEngine paramUserEngine)
  {
    this.userEngine = paramUserEngine;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.enginemanager.BizEngineMgr
 * JD-Core Version:    0.7.0.1
 */