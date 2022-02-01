package com.tencent.ilivesdk.floatheartservice_interface;

import com.tencent.ilivesdk.floatheartservice_interface.model.FloatHeartMessage;
import java.util.ArrayList;

public abstract interface FloatHeartServiceInterface$OnReceiveFloatHeartListener
{
  public abstract void onFloatHeartReceive(ArrayList<FloatHeartMessage> paramArrayList);
  
  public abstract void onGetRoomLikeTotalCount(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.floatheartservice_interface.FloatHeartServiceInterface.OnReceiveFloatHeartListener
 * JD-Core Version:    0.7.0.1
 */