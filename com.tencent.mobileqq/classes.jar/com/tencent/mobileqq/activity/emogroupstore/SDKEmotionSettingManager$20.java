package com.tencent.mobileqq.activity.emogroupstore;

import ajyt;
import ajzm;
import java.util.List;

public class SDKEmotionSettingManager$20
  implements Runnable
{
  public SDKEmotionSettingManager$20(ajyt paramajyt, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    if (ajyt.a(this.this$0) != null) {
      ajyt.a(this.this$0).dismiss();
    }
    ajyt.a(this.this$0, false);
    if (this.a == this.b) {
      ajyt.a(this.this$0, ajyt.a(this.this$0), Long.valueOf(ajyt.a(this.this$0)).longValue(), true);
    }
    while (this.a == 1)
    {
      int j = -1;
      int i = j;
      if (ajyt.c(this.this$0) != null)
      {
        i = j;
        if (ajyt.c(this.this$0).size() > 0) {
          i = ((Integer)ajyt.c(this.this$0).get(0)).intValue();
        }
      }
      ajyt.a(this.this$0, i, null);
      return;
      ajyt.a(this.this$0, ajyt.a(this.this$0), Long.valueOf(ajyt.a(this.this$0)).longValue(), true, null);
    }
    ajyt.a(this.this$0, this.b, this.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.20
 * JD-Core Version:    0.7.0.1
 */