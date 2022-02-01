package com.tencent.av.widget.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IChildLockCircleApi
  extends QRouteApi
{
  public abstract void handleAnimSuccessMsg(Context paramContext);
  
  public abstract void onAnimationEnd();
  
  public abstract void onAnimationFailed(Context paramContext);
  
  public abstract boolean onLockSuccess(Context paramContext);
  
  public abstract void startChildLockAnimation();
  
  public abstract boolean updateText(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.widget.api.IChildLockCircleApi
 * JD-Core Version:    0.7.0.1
 */