package com.tencent.mobileqq.activity.emogroupstore;

import ajpi;
import ajqb;
import java.util.List;

public class SDKEmotionSettingManager$20
  implements Runnable
{
  public SDKEmotionSettingManager$20(ajpi paramajpi, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    if (ajpi.a(this.this$0) != null) {
      ajpi.a(this.this$0).dismiss();
    }
    ajpi.a(this.this$0, false);
    if (this.a == this.b) {
      ajpi.a(this.this$0, ajpi.a(this.this$0), Long.valueOf(ajpi.a(this.this$0)).longValue(), true);
    }
    while (this.a == 1)
    {
      int j = -1;
      int i = j;
      if (ajpi.c(this.this$0) != null)
      {
        i = j;
        if (ajpi.c(this.this$0).size() > 0) {
          i = ((Integer)ajpi.c(this.this$0).get(0)).intValue();
        }
      }
      ajpi.a(this.this$0, i, null);
      return;
      ajpi.a(this.this$0, ajpi.a(this.this$0), Long.valueOf(ajpi.a(this.this$0)).longValue(), true, null);
    }
    ajpi.a(this.this$0, this.b, this.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.20
 * JD-Core Version:    0.7.0.1
 */