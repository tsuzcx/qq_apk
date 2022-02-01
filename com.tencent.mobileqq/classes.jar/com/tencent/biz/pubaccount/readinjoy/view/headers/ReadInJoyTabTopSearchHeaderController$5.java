package com.tencent.biz.pubaccount.readinjoy.view.headers;

import android.text.format.DateUtils;
import bhsi;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import sua;

public class ReadInJoyTabTopSearchHeaderController$5
  implements Runnable
{
  public ReadInJoyTabTopSearchHeaderController$5(sua paramsua, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    int i = 0;
    if (!DateUtils.isToday(bhsi.b("search_word_prefix_last_change_hotword_time")))
    {
      bhsi.a("search_word_prefix_last_change_hotword_time", System.currentTimeMillis());
      bhsi.a(this.this$0.a, 0);
      bhsi.a(this.this$0.b, 0);
    }
    AladdinConfig localAladdinConfig = Aladdin.getConfig(204);
    int m;
    int k;
    int j;
    if (localAladdinConfig != null)
    {
      m = localAladdinConfig.getIntegerFromString("search_max_num", 100);
      k = localAladdinConfig.getIntegerFromString("refresh_num_n", 0);
      j = localAladdinConfig.getIntegerFromString("wording_times_m", 0);
      i = localAladdinConfig.getIntegerFromString("later_wording_times_y", 0);
    }
    for (;;)
    {
      if (bhsi.a(this.this$0.a) < m)
      {
        if (this.a != 6) {
          break label179;
        }
        bhsi.a(this.this$0.a, bhsi.a(this.this$0.a) + 1);
        this.this$0.b(true, this.a, this.b);
      }
      for (;;)
      {
        bhsi.a(this.this$0.b, bhsi.a(this.this$0.b) + 1);
        return;
        label179:
        if (bhsi.a(this.this$0.b) < k)
        {
          if ((j > 0) && ((bhsi.a(this.this$0.b) + 1) % j == 0))
          {
            bhsi.a(this.this$0.a, bhsi.a(this.this$0.a) + 1);
            this.this$0.b(true, this.a, this.b);
          }
        }
        else if ((i > 0) && ((bhsi.a(this.this$0.b) + 1 - k) % i == 0))
        {
          bhsi.a(this.this$0.a, bhsi.a(this.this$0.a) + 1);
          this.this$0.b(true, this.a, this.b);
        }
      }
      k = 0;
      m = 100;
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyTabTopSearchHeaderController.5
 * JD-Core Version:    0.7.0.1
 */