package com.tencent.falco.base.libapi.location;

import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface LocationInterface
  extends ServiceBaseInterface
{
  public abstract LocationInfo getCachedLocationInfo();
  
  public abstract void init(LocationInterface.LocationInterfaceAdapter paramLocationInterfaceAdapter);
  
  public abstract void sendLocationRequest(LocationListener paramLocationListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.libapi.location.LocationInterface
 * JD-Core Version:    0.7.0.1
 */