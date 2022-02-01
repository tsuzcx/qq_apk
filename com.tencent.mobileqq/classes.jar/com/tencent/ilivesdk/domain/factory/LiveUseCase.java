package com.tencent.ilivesdk.domain.factory;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.livesdk.roomengine.RoomEngine;

public abstract class LiveUseCase<T, Params>
{
  private MutableLiveData<T> liveData;
  public LogInterface mLogger;
  
  public void execute(LifecycleOwner paramLifecycleOwner, Params paramParams, BaseObserver<T> paramBaseObserver)
  {
    this.liveData = new MutableLiveData();
    this.liveData.observe(paramLifecycleOwner, paramBaseObserver);
    executeUseCase(paramParams);
  }
  
  protected void executeRoomUseCase(RoomEngine paramRoomEngine, Params paramParams) {}
  
  protected void executeUseCase(Params paramParams) {}
  
  public void onDestroy() {}
  
  public void post(T paramT)
  {
    this.liveData.postValue(paramT);
  }
  
  public void roomExecute(RoomEngine paramRoomEngine, LifecycleOwner paramLifecycleOwner, Params paramParams, BaseObserver<T> paramBaseObserver)
  {
    this.liveData = new MutableLiveData();
    this.liveData.observe(paramLifecycleOwner, paramBaseObserver);
    executeRoomUseCase(paramRoomEngine, paramParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.domain.factory.LiveUseCase
 * JD-Core Version:    0.7.0.1
 */