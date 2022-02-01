package com.tencent.mobileqq.activity.emogroupstore;

import aitt;
import aium;
import java.util.List;

public class SDKEmotionSettingManager$20
  implements Runnable
{
  public SDKEmotionSettingManager$20(aitt paramaitt, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    if (aitt.a(this.this$0) != null) {
      aitt.a(this.this$0).dismiss();
    }
    aitt.a(this.this$0, false);
    if (this.a == this.b) {
      aitt.a(this.this$0, aitt.a(this.this$0), Long.valueOf(aitt.a(this.this$0)).longValue(), true);
    }
    while (this.a == 1)
    {
      int j = -1;
      int i = j;
      if (aitt.c(this.this$0) != null)
      {
        i = j;
        if (aitt.c(this.this$0).size() > 0) {
          i = ((Integer)aitt.c(this.this$0).get(0)).intValue();
        }
      }
      aitt.a(this.this$0, i, null);
      return;
      aitt.a(this.this$0, aitt.a(this.this$0), Long.valueOf(aitt.a(this.this$0)).longValue(), true, null);
    }
    aitt.a(this.this$0, this.b, this.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.20
 * JD-Core Version:    0.7.0.1
 */