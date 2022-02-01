package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyContext;
import com.tencent.mobileqq.activity.aio.tips.NearbyMarketGrayTips;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;

public class NearbyTipsHelper
  extends TipsHelper
{
  public NearbyTipsHelper(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  protected void a()
  {
    if (((NearbyContext)this.c).P()) {
      return;
    }
    super.a();
    NearbyMarketGrayTips localNearbyMarketGrayTips = new NearbyMarketGrayTips(this.d, this.g, this.f);
    localNearbyMarketGrayTips.a(((NearbyContext)this.c).Q());
    this.f.b(localNearbyMarketGrayTips);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.NearbyTipsHelper
 * JD-Core Version:    0.7.0.1
 */