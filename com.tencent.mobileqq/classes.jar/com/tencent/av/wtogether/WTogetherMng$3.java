package com.tencent.av.wtogether;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.filter.EffectFilterTools;
import com.tencent.av.business.manager.pendant.EffectPendantBase;

class WTogetherMng$3
  implements Runnable
{
  WTogetherMng$3(WTogetherMng paramWTogetherMng, long paramLong) {}
  
  public void run()
  {
    int[] arrayOfInt = new int[3];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 2;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 13;
    int[] tmp14_9 = tmp9_5;
    tmp14_9[2] = 14;
    tmp14_9;
    int i = 0;
    while (i < arrayOfInt.length)
    {
      if (WTogetherMng.b(this.this$0).d(arrayOfInt[i]))
      {
        EffectPendantBase localEffectPendantBase = (EffectPendantBase)WTogetherMng.c(this.this$0).c(arrayOfInt[i]);
        if (localEffectPendantBase != null) {
          localEffectPendantBase.a(this.a, null);
        }
      }
      i += 1;
    }
    if (WTogetherMng.d(this.this$0).d(1)) {
      ((EffectFilterTools)WTogetherMng.e(this.this$0).c(1)).a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.WTogetherMng.3
 * JD-Core Version:    0.7.0.1
 */