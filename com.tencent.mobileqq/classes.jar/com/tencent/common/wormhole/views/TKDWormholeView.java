package com.tencent.common.wormhole.views;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.views.view.HippyViewGroup;

public class TKDWormholeView
  extends HippyViewGroup
  implements ITKDWormhole
{
  private String a;
  private int b = -1;
  
  public TKDWormholeView(Context paramContext)
  {
    super(paramContext);
  }
  
  public int getRootId()
  {
    return this.b;
  }
  
  public View getView()
  {
    return this;
  }
  
  public String getWormholeId()
  {
    return this.a;
  }
  
  public void setRootId(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setWormholeId(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.wormhole.views.TKDWormholeView
 * JD-Core Version:    0.7.0.1
 */