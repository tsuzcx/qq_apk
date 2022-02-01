package com.tencent.ilivesdk.harvestservice_interface;

import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface HarvestServiceInterface
  extends ServiceBaseInterface
{
  public abstract void getRoomHarvest(String paramString, GetRoomHarvestCallback paramGetRoomHarvestCallback);
  
  public abstract void init(HarvestServiceAdapter paramHarvestServiceAdapter);
  
  public abstract void listenRoomHarvestPush(GetRoomHarvestCallback paramGetRoomHarvestCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.harvestservice_interface.HarvestServiceInterface
 * JD-Core Version:    0.7.0.1
 */