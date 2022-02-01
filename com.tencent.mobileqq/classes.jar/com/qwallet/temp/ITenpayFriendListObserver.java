package com.qwallet.temp;

import android.os.ResultReceiver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ITenpayFriendListObserver
  extends QRouteApi
{
  public abstract void add(String paramString, ResultReceiver paramResultReceiver);
  
  public abstract void destroy();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qwallet.temp.ITenpayFriendListObserver
 * JD-Core Version:    0.7.0.1
 */