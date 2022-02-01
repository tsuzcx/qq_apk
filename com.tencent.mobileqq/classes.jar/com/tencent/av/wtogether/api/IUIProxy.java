package com.tencent.av.wtogether.api;

import android.content.Context;
import com.tencent.av.wtogether.callback.WatchTogetherUIProxy;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IUIProxy
  extends QRouteApi
{
  public abstract WatchTogetherUIProxy getAdminControlView(Context paramContext);
  
  public abstract WatchTogetherUIProxy getOrdinaryControlView(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.api.IUIProxy
 * JD-Core Version:    0.7.0.1
 */