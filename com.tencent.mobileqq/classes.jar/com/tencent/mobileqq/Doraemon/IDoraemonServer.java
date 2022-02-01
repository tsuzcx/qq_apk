package com.tencent.mobileqq.Doraemon;

import android.os.Bundle;
import android.os.Messenger;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IDoraemonServer
  extends QRouteApi
{
  public abstract void sendToClient(int paramInt1, Bundle paramBundle, int paramInt2, Messenger paramMessenger);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.IDoraemonServer
 * JD-Core Version:    0.7.0.1
 */