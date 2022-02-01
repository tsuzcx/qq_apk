package com.tencent.common.wormhole.views;

import android.content.Context;
import com.tencent.mtt.hippy.views.view.HippyViewGroup;

public class HippySessionView
  extends HippyViewGroup
{
  private int a = -1;
  
  public HippySessionView(Context paramContext)
  {
    super(paramContext);
  }
  
  public int getRootId()
  {
    return this.a;
  }
  
  public void setRootId(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.wormhole.views.HippySessionView
 * JD-Core Version:    0.7.0.1
 */