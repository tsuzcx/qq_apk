package com.tencent.mobileqq.activity.aio.item;

import com.immersion.stickersampleapp.HapticManager;

final class PokeItemHelper$1
  implements Runnable
{
  PokeItemHelper$1(int paramInt) {}
  
  public void run()
  {
    HapticManager localHapticManager = HapticManager.a();
    int i = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(PokeItemHelper.e);
    localStringBuilder.append(this.a);
    localStringBuilder.append("/");
    localStringBuilder.append(this.a);
    localStringBuilder.append(".hapt");
    localHapticManager.a(String.valueOf(i), localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PokeItemHelper.1
 * JD-Core Version:    0.7.0.1
 */