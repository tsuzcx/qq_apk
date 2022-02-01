package com.tencent.mobileqq.Doraemon;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IDoraemonClient
  extends QRouteApi
{
  public abstract void sendToServer(int paramInt, Bundle paramBundle, Callback paramCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.IDoraemonClient
 * JD-Core Version:    0.7.0.1
 */