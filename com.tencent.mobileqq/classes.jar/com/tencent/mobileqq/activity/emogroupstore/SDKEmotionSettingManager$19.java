package com.tencent.mobileqq.activity.emogroupstore;

import afup;
import afvg;
import java.util.List;

public class SDKEmotionSettingManager$19
  implements Runnable
{
  public SDKEmotionSettingManager$19(afup paramafup, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    if (afup.a(this.this$0) != null) {
      afup.a(this.this$0).dismiss();
    }
    afup.a(this.this$0, false);
    if (this.a == this.b) {
      afup.a(this.this$0, afup.a(this.this$0), Long.valueOf(afup.a(this.this$0)).longValue(), true);
    }
    while (this.a == 1)
    {
      int j = -1;
      int i = j;
      if (afup.c(this.this$0) != null)
      {
        i = j;
        if (afup.c(this.this$0).size() > 0) {
          i = ((Integer)afup.c(this.this$0).get(0)).intValue();
        }
      }
      afup.a(this.this$0, i, null);
      return;
      afup.a(this.this$0, afup.a(this.this$0), Long.valueOf(afup.a(this.this$0)).longValue(), true, null);
    }
    afup.a(this.this$0, this.b, this.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.19
 * JD-Core Version:    0.7.0.1
 */