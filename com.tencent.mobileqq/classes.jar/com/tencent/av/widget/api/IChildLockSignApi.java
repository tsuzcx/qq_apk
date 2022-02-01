package com.tencent.av.widget.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IChildLockSignApi
  extends QRouteApi
{
  public abstract void handleSuccessMsg(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.widget.api.IChildLockSignApi
 * JD-Core Version:    0.7.0.1
 */