package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IAudioPanelUtils
  extends QRouteApi
{
  public static final int AUDIO_PANEL_CHANGE_VOICE = 3;
  public static final int AUDIO_PANEL_INPUT = 4;
  public static final int AUDIO_PANEL_PRESS_TO_SPEAK = 1;
  public static final int AUDIO_PANEL_RECORDER = 2;
  public static final int AUDIO_PANEL_RED_PACKET = 5;
  public static final int AUDIO_PANEL_UNKNOWN = 0;
  
  public abstract String getTimeStrByMillis(double paramDouble);
  
  public abstract int getTitleBarHeight(Context paramContext);
  
  public abstract int getVolumeLevel(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.IAudioPanelUtils
 * JD-Core Version:    0.7.0.1
 */