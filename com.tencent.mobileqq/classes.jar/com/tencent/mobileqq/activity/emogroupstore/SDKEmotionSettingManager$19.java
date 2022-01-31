package com.tencent.mobileqq.activity.emogroupstore;

import afur;
import afvi;
import java.util.List;

public class SDKEmotionSettingManager$19
  implements Runnable
{
  public SDKEmotionSettingManager$19(afur paramafur, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    if (afur.a(this.this$0) != null) {
      afur.a(this.this$0).dismiss();
    }
    afur.a(this.this$0, false);
    if (this.a == this.b) {
      afur.a(this.this$0, afur.a(this.this$0), Long.valueOf(afur.a(this.this$0)).longValue(), true);
    }
    while (this.a == 1)
    {
      int j = -1;
      int i = j;
      if (afur.c(this.this$0) != null)
      {
        i = j;
        if (afur.c(this.this$0).size() > 0) {
          i = ((Integer)afur.c(this.this$0).get(0)).intValue();
        }
      }
      afur.a(this.this$0, i, null);
      return;
      afur.a(this.this$0, afur.a(this.this$0), Long.valueOf(afur.a(this.this$0)).longValue(), true, null);
    }
    afur.a(this.this$0, this.b, this.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.19
 * JD-Core Version:    0.7.0.1
 */