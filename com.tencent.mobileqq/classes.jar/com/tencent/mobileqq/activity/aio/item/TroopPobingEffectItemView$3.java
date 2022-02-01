package com.tencent.mobileqq.activity.aio.item;

import com.tencent.image.ApngDrawable.OnPlayRepeatListener;
import com.tencent.mobileqq.vas.trooppobing.PobingManager;

class TroopPobingEffectItemView$3
  implements ApngDrawable.OnPlayRepeatListener
{
  TroopPobingEffectItemView$3(TroopPobingEffectItemView paramTroopPobingEffectItemView) {}
  
  public void onPlayRepeat(int paramInt)
  {
    TroopPobingEffectItemView.b(this.a);
    PobingManager.b(TroopPobingEffectItemView.c(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopPobingEffectItemView.3
 * JD-Core Version:    0.7.0.1
 */