package com.tencent.av.wtogether;

import com.tencent.av.app.VideoAppInterface;
import lhb;
import lhy;
import mxd;

public class WTogetherMng$3
  implements Runnable
{
  public WTogetherMng$3(mxd parammxd, long paramLong) {}
  
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
    if (i < arrayOfInt.length)
    {
      lhy locallhy;
      if (mxd.b(this.this$0).a(arrayOfInt[i]))
      {
        locallhy = (lhy)mxd.c(this.this$0).a(arrayOfInt[i]);
        if (locallhy != null) {
          break label72;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label72:
        locallhy.a(this.a, null);
      }
    }
    if (mxd.d(this.this$0).a(1)) {
      ((lhb)mxd.e(this.this$0).a(1)).a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.wtogether.WTogetherMng.3
 * JD-Core Version:    0.7.0.1
 */