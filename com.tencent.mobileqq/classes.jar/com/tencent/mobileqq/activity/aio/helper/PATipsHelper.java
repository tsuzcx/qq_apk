package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.tips.PubAccountTips;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;

public class PATipsHelper
  extends TipsHelper
{
  public PATipsHelper(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  protected void a()
  {
    this.f = this.c.c();
    PubAccountTips localPubAccountTips = new PubAccountTips(this.d, this.g, this.f, this.c.b(), this.c.g());
    this.f.b(localPubAccountTips);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.PATipsHelper
 * JD-Core Version:    0.7.0.1
 */