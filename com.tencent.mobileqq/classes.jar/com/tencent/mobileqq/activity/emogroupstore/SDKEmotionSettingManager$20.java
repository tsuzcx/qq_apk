package com.tencent.mobileqq.activity.emogroupstore;

import ajnk;
import ajod;
import java.util.List;

public class SDKEmotionSettingManager$20
  implements Runnable
{
  public SDKEmotionSettingManager$20(ajnk paramajnk, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    if (ajnk.a(this.this$0) != null) {
      ajnk.a(this.this$0).dismiss();
    }
    ajnk.a(this.this$0, false);
    if (this.a == this.b) {
      ajnk.a(this.this$0, ajnk.a(this.this$0), Long.valueOf(ajnk.a(this.this$0)).longValue(), true);
    }
    while (this.a == 1)
    {
      int j = -1;
      int i = j;
      if (ajnk.c(this.this$0) != null)
      {
        i = j;
        if (ajnk.c(this.this$0).size() > 0) {
          i = ((Integer)ajnk.c(this.this$0).get(0)).intValue();
        }
      }
      ajnk.a(this.this$0, i, null);
      return;
      ajnk.a(this.this$0, ajnk.a(this.this$0), Long.valueOf(ajnk.a(this.this$0)).longValue(), true, null);
    }
    ajnk.a(this.this$0, this.b, this.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.20
 * JD-Core Version:    0.7.0.1
 */