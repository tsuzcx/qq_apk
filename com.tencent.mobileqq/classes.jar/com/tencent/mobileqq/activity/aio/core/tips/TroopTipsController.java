package com.tencent.mobileqq.activity.aio.core.tips;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.troop.data.TroopAioTips;

public class TroopTipsController
  extends TipsController
{
  public TroopTipsController(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  public boolean a(int paramInt)
  {
    TroopAioTips localTroopAioTips = this.a.G();
    if ((localTroopAioTips.h()) && ((localTroopAioTips.i() == 17) || (localTroopAioTips.i() == 100) || (localTroopAioTips.i() == 11))) {
      return false;
    }
    return super.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.tips.TroopTipsController
 * JD-Core Version:    0.7.0.1
 */