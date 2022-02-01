package com.tencent.mobileqq.activity.aio.item;

import com.immersion.stickersampleapp.HapticManager;

final class PokeItemHelper$1
  implements Runnable
{
  PokeItemHelper$1(int paramInt) {}
  
  public void run()
  {
    HapticManager.a().a(String.valueOf(this.a), PokeItemHelper.e + this.a + "/" + this.a + ".hapt");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PokeItemHelper.1
 * JD-Core Version:    0.7.0.1
 */