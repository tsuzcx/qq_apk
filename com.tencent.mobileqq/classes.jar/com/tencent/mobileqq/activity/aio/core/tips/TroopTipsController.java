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
    TroopAioTips localTroopAioTips = this.a.a();
    if ((localTroopAioTips.d()) && ((localTroopAioTips.b() == 17) || (localTroopAioTips.b() == 100) || (localTroopAioTips.b() == 11))) {
      return false;
    }
    return super.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.tips.TroopTipsController
 * JD-Core Version:    0.7.0.1
 */