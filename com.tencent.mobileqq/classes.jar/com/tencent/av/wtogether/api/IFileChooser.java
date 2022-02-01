package com.tencent.av.wtogether.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IFileChooser
  extends QRouteApi
{
  public abstract void startAVGroupFileSelectFragment(Activity paramActivity, long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3);
  
  public abstract void startAVRecentFileSelectFragment(Activity paramActivity, int paramInt1, int paramInt2, String paramString, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.api.IFileChooser
 * JD-Core Version:    0.7.0.1
 */