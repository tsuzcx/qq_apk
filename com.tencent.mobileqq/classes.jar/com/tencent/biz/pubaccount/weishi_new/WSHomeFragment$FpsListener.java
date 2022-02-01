package com.tencent.biz.pubaccount.weishi_new;

import com.tencent.mobileqq.util.FPSCalculator.GetFPSListener;

class WSHomeFragment$FpsListener
  implements FPSCalculator.GetFPSListener
{
  public void onInfo(long paramLong, double paramDouble)
  {
    WSHomeFragment.a(this.a, paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.FpsListener
 * JD-Core Version:    0.7.0.1
 */