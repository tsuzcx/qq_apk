package com.tencent.livesdk.servicefactory;

public class ServiceAccessorMgr
{
  private static ServiceAccessorMgr instance;
  private ServiceAccessor liveAccessor;
  private ServiceAccessor roomAccessor;
  private ServiceAccessor userAccessor;
  
  public static ServiceAccessorMgr getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new ServiceAccessorMgr();
      }
      ServiceAccessorMgr localServiceAccessorMgr = instance;
      return localServiceAccessorMgr;
    }
    finally {}
  }
  
  public ServiceAccessor getLiveAccessor()
  {
    return this.liveAccessor;
  }
  
  public ServiceAccessor getRoomAccessor()
  {
    return this.roomAccessor;
  }
  
  public ServiceAccessor getUserAccessor()
  {
    return this.userAccessor;
  }
  
  public void setLiveAccessor(ServiceAccessor paramServiceAccessor)
  {
    this.liveAccessor = paramServiceAccessor;
  }
  
  public void setRoomAccessor(ServiceAccessor paramServiceAccessor)
  {
    this.roomAccessor = paramServiceAccessor;
  }
  
  public void setUserAccessor(ServiceAccessor paramServiceAccessor)
  {
    this.userAccessor = paramServiceAccessor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.ServiceAccessorMgr
 * JD-Core Version:    0.7.0.1
 */