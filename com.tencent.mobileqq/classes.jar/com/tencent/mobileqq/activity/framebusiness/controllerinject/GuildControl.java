package com.tencent.mobileqq.activity.framebusiness.controllerinject;

import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.qroute.QRoute;

public class GuildControl
  implements BaseTabControl
{
  private final String a = ((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).getGuildMainFrameClass().getName();
  
  public boolean a(String paramString)
  {
    return this.a.equals(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.controllerinject.GuildControl
 * JD-Core Version:    0.7.0.1
 */