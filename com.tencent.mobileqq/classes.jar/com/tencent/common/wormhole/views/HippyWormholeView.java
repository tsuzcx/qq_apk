package com.tencent.common.wormhole.views;

import android.content.Context;
import com.tencent.mtt.hippy.views.view.HippyViewGroup;

public class HippyWormholeView
  extends HippyViewGroup
{
  private String a;
  
  public HippyWormholeView(Context paramContext)
  {
    super(paramContext);
  }
  
  public String getWormholeId()
  {
    return this.a;
  }
  
  public void setWormholeId(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.wormhole.views.HippyWormholeView
 * JD-Core Version:    0.7.0.1
 */