package com.tencent.mobileqq.activity.emogroupstore;

import ahww;
import ahxp;
import java.util.List;

public class SDKEmotionSettingManager$20
  implements Runnable
{
  public SDKEmotionSettingManager$20(ahww paramahww, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    if (ahww.a(this.this$0) != null) {
      ahww.a(this.this$0).dismiss();
    }
    ahww.a(this.this$0, false);
    if (this.a == this.b) {
      ahww.a(this.this$0, ahww.a(this.this$0), Long.valueOf(ahww.a(this.this$0)).longValue(), true);
    }
    while (this.a == 1)
    {
      int j = -1;
      int i = j;
      if (ahww.c(this.this$0) != null)
      {
        i = j;
        if (ahww.c(this.this$0).size() > 0) {
          i = ((Integer)ahww.c(this.this$0).get(0)).intValue();
        }
      }
      ahww.a(this.this$0, i, null);
      return;
      ahww.a(this.this$0, ahww.a(this.this$0), Long.valueOf(ahww.a(this.this$0)).longValue(), true, null);
    }
    ahww.a(this.this$0, this.b, this.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.20
 * JD-Core Version:    0.7.0.1
 */