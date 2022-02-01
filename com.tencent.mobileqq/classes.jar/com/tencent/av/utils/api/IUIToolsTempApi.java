package com.tencent.av.utils.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=true)
public abstract interface IUIToolsTempApi
  extends QRouteApi
{
  public abstract float dp2px(Context paramContext, float paramFloat);
  
  public abstract int uinType2AVRelationType(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.api.IUIToolsTempApi
 * JD-Core Version:    0.7.0.1
 */