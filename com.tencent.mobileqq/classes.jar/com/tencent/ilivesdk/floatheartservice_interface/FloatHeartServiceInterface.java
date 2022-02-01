package com.tencent.ilivesdk.floatheartservice_interface;

import android.util.SparseIntArray;
import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface FloatHeartServiceInterface
  extends ServiceBaseInterface
{
  public abstract void addOnReceiveFloatHeartListener(FloatHeartServiceInterface.OnReceiveFloatHeartListener paramOnReceiveFloatHeartListener);
  
  public abstract void fetchFloatHeartInfo(FloatHeartServiceInterface.FetchFloatHeartInfoCallback paramFetchFloatHeartInfoCallback);
  
  public abstract String getFloatHeartURLByType(int paramInt);
  
  public abstract void init(FloatHeartServiceAdapter paramFloatHeartServiceAdapter);
  
  public abstract void removeOnReceiveFloatHeartListener(FloatHeartServiceInterface.OnReceiveFloatHeartListener paramOnReceiveFloatHeartListener);
  
  public abstract void sendFloatHeart(SparseIntArray paramSparseIntArray, FloatHeartServiceInterface.FloatHeartSenderListener paramFloatHeartSenderListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.floatheartservice_interface.FloatHeartServiceInterface
 * JD-Core Version:    0.7.0.1
 */