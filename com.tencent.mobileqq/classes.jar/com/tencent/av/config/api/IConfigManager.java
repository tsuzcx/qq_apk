package com.tencent.av.config.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IConfigManager
  extends QRouteApi
{
  public abstract IConfigParser getConfigParser(Context paramContext);
  
  public abstract void onCreate(Context paramContext);
  
  public abstract void onDestroy(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.config.api.IConfigManager
 * JD-Core Version:    0.7.0.1
 */