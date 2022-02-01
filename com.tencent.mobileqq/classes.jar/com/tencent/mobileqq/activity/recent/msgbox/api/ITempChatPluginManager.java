package com.tencent.mobileqq.activity.recent.msgbox.api;

import android.content.Context;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.AbstractTempChatPlugin;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ITempChatPluginManager
  extends IRuntimeService
{
  public abstract AbstractTempChatPlugin getTempChatPlugin(int paramInt);
  
  public abstract boolean isCustomizeByBiz(int paramInt);
  
  public abstract boolean onHeadIconClickCusTempConv(Context paramContext, int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.api.ITempChatPluginManager
 * JD-Core Version:    0.7.0.1
 */