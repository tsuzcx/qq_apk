package com.tencent.biz.pubaccount.readinjoy.view.headers;

import android.text.format.DateUtils;
import bfyz;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import sya;

public class ReadInJoyTabTopSearchHeaderController$5
  implements Runnable
{
  public ReadInJoyTabTopSearchHeaderController$5(sya paramsya, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (!DateUtils.isToday(bfyz.b("search_word_prefix_last_change_hotword_time")))
    {
      bfyz.a("search_word_prefix_last_change_hotword_time", System.currentTimeMillis());
      bfyz.a(this.this$0.a, 0);
      bfyz.a(this.this$0.b, 0);
    }
    AladdinConfig localAladdinConfig = Aladdin.getConfig(204);
    int m;
    int k;
    int j;
    if (localAladdinConfig != null)
    {
      m = localAladdinConfig.getIntegerFromString("search_max_num", 100);
      k = localAladdinConfig.getIntegerFromString("refresh_num_n", 100);
      j = localAladdinConfig.getIntegerFromString("wording_times_m", 1);
    }
    for (int i = localAladdinConfig.getIntegerFromString("later_wording_times_y", 1);; i = 1)
    {
      if (bfyz.a(this.this$0.a) < m)
      {
        if (this.a != 6) {
          break label178;
        }
        bfyz.a(this.this$0.a, bfyz.a(this.this$0.a) + 1);
        this.this$0.b(true, this.a, this.b);
      }
      for (;;)
      {
        bfyz.a(this.this$0.b, bfyz.a(this.this$0.b) + 1);
        return;
        label178:
        if (bfyz.a(this.this$0.b) < k)
        {
          if ((j > 0) && ((bfyz.a(this.this$0.b) + 1) % j == 0))
          {
            bfyz.a(this.this$0.a, bfyz.a(this.this$0.a) + 1);
            this.this$0.b(true, this.a, this.b);
          }
        }
        else if ((i > 0) && ((bfyz.a(this.this$0.b) + 1 - k) % i == 0))
        {
          bfyz.a(this.this$0.a, bfyz.a(this.this$0.a) + 1);
          this.this$0.b(true, this.a, this.b);
        }
      }
      j = 1;
      k = 100;
      m = 100;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyTabTopSearchHeaderController.5
 * JD-Core Version:    0.7.0.1
 */