package com.tencent.falco.base.libapi.hostproxy;

import android.app.Activity;
import android.content.Context;

public abstract interface ClickEventInterface
{
  public abstract void onClickCancelAuthFloatPermission();
  
  public abstract void onClickLiveOverClose(Activity paramActivity);
  
  public abstract boolean onClickMiniCardAvatar(long paramLong);
  
  public abstract boolean onClickRoomAudienceList(Context paramContext);
  
  public abstract boolean onLivePrepareBackPressed(Activity paramActivity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.libapi.hostproxy.ClickEventInterface
 * JD-Core Version:    0.7.0.1
 */