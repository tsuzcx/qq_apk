package com.tencent.mobileqq.activity.aio.rebuild.tips;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyContext;

public class NearbyTipsController
  extends TipsController
{
  public NearbyTipsController(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  public boolean a(int paramInt)
  {
    if (((NearbyContext)this.a).P()) {
      return false;
    }
    return super.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.tips.NearbyTipsController
 * JD-Core Version:    0.7.0.1
 */