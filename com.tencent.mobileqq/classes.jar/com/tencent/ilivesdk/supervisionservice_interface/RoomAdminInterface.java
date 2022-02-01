package com.tencent.ilivesdk.supervisionservice_interface;

public abstract interface RoomAdminInterface
{
  public static final int ERR_ADMIN_OVER_LIMIT = 10013;
  
  public abstract void addAdminStatusListener(RoomAdminInterface.OnAdminStatusChangedListener paramOnAdminStatusChangedListener);
  
  public abstract void cancelAdmin(long paramLong1, long paramLong2, long paramLong3, RoomAdminInterface.SetAdminCallback paramSetAdminCallback);
  
  public abstract void isAdmin(long paramLong1, long paramLong2, long paramLong3, RoomAdminInterface.QueryIsAdminCallback paramQueryIsAdminCallback);
  
  public abstract void queryAllAdminList(long paramLong1, long paramLong2, RoomAdminInterface.QueryAdminListCallback paramQueryAdminListCallback);
  
  public abstract void queryOnlineAdminList(long paramLong1, long paramLong2, RoomAdminInterface.QueryAdminListCallback paramQueryAdminListCallback);
  
  public abstract void removeAdminStatusListener(RoomAdminInterface.OnAdminStatusChangedListener paramOnAdminStatusChangedListener);
  
  public abstract void setAdmin(long paramLong1, long paramLong2, long paramLong3, RoomAdminInterface.SetAdminCallback paramSetAdminCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.supervisionservice_interface.RoomAdminInterface
 * JD-Core Version:    0.7.0.1
 */