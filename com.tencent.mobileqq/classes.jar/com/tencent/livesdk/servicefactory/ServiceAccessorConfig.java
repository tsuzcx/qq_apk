package com.tencent.livesdk.servicefactory;

import androidx.annotation.Nullable;

public class ServiceAccessorConfig
{
  private ServiceAccessor mLiveAccessor;
  private ServiceAccessor mRoomAccessor;
  private ServiceAccessor mUserAccessor;
  
  public ServiceAccessorConfig(ServiceAccessor paramServiceAccessor1, ServiceAccessor paramServiceAccessor2, ServiceAccessor paramServiceAccessor3)
  {
    this.mLiveAccessor = paramServiceAccessor1;
    this.mUserAccessor = paramServiceAccessor2;
    this.mRoomAccessor = paramServiceAccessor3;
  }
  
  public ServiceAccessor getLiveAccessor()
  {
    return this.mLiveAccessor;
  }
  
  @Nullable
  public ServiceAccessor getRoomAccessor()
  {
    return this.mRoomAccessor;
  }
  
  public ServiceAccessor getUserAccessor()
  {
    return this.mUserAccessor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.ServiceAccessorConfig
 * JD-Core Version:    0.7.0.1
 */