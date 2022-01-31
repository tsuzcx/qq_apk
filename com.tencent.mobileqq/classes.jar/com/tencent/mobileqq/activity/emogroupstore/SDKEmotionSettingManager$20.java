package com.tencent.mobileqq.activity.emogroupstore;

import ahsh;
import ahta;
import java.util.List;

public class SDKEmotionSettingManager$20
  implements Runnable
{
  public SDKEmotionSettingManager$20(ahsh paramahsh, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    if (ahsh.a(this.this$0) != null) {
      ahsh.a(this.this$0).dismiss();
    }
    ahsh.a(this.this$0, false);
    if (this.a == this.b) {
      ahsh.a(this.this$0, ahsh.a(this.this$0), Long.valueOf(ahsh.a(this.this$0)).longValue(), true);
    }
    while (this.a == 1)
    {
      int j = -1;
      int i = j;
      if (ahsh.c(this.this$0) != null)
      {
        i = j;
        if (ahsh.c(this.this$0).size() > 0) {
          i = ((Integer)ahsh.c(this.this$0).get(0)).intValue();
        }
      }
      ahsh.a(this.this$0, i, null);
      return;
      ahsh.a(this.this$0, ahsh.a(this.this$0), Long.valueOf(ahsh.a(this.this$0)).longValue(), true, null);
    }
    ahsh.a(this.this$0, this.b, this.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.20
 * JD-Core Version:    0.7.0.1
 */