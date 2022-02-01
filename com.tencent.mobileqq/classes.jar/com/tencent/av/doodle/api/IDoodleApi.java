package com.tencent.av.doodle.api;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IDoodleApi
  extends QRouteApi
{
  public abstract View createDoodleSurfaceView(Context paramContext);
  
  public abstract Class<?> getDoodleToolbarClass();
  
  public abstract void notifyAddDoodleSurfaceView();
  
  public abstract int sendAVFunChatMsg(int paramInt, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.doodle.api.IDoodleApi
 * JD-Core Version:    0.7.0.1
 */