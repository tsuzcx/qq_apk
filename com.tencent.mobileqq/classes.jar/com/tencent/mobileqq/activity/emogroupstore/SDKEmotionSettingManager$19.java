package com.tencent.mobileqq.activity.emogroupstore;

import afiu;
import afjl;
import java.util.List;

public class SDKEmotionSettingManager$19
  implements Runnable
{
  public SDKEmotionSettingManager$19(afiu paramafiu, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    if (afiu.a(this.this$0) != null) {
      afiu.a(this.this$0).dismiss();
    }
    afiu.a(this.this$0, false);
    if (this.a == this.b) {
      afiu.a(this.this$0, afiu.a(this.this$0), Long.valueOf(afiu.a(this.this$0)).longValue(), true);
    }
    while (this.a == 1)
    {
      int j = -1;
      int i = j;
      if (afiu.c(this.this$0) != null)
      {
        i = j;
        if (afiu.c(this.this$0).size() > 0) {
          i = ((Integer)afiu.c(this.this$0).get(0)).intValue();
        }
      }
      afiu.a(this.this$0, i, null);
      return;
      afiu.a(this.this$0, afiu.a(this.this$0), Long.valueOf(afiu.a(this.this$0)).longValue(), true, null);
    }
    afiu.a(this.this$0, this.b, this.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.19
 * JD-Core Version:    0.7.0.1
 */