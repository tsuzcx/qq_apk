package com.tencent.biz.pubaccount.readinjoy.view.headers;

import android.text.format.DateUtils;
import bdne;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import set;

public class ReadInJoyTabTopSearchHeaderController$3
  implements Runnable
{
  public ReadInJoyTabTopSearchHeaderController$3(set paramset, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    int i = 0;
    if (!DateUtils.isToday(bdne.b("search_word_prefix_last_change_hotword_time")))
    {
      bdne.a("search_word_prefix_last_change_hotword_time", System.currentTimeMillis());
      bdne.a(this.this$0.a, 0);
      bdne.a(this.this$0.b, 0);
    }
    AladdinConfig localAladdinConfig = Aladdin.getConfig(204);
    int m;
    int k;
    int j;
    if (localAladdinConfig != null)
    {
      m = localAladdinConfig.getIntegerFromString("search_max_num", 0);
      k = localAladdinConfig.getIntegerFromString("refresh_num_n", 0);
      j = localAladdinConfig.getIntegerFromString("wording_times_m", 0);
      i = localAladdinConfig.getIntegerFromString("later_wording_times_y", 0);
    }
    for (;;)
    {
      if (bdne.a(this.this$0.a) < m)
      {
        if (bdne.a(this.this$0.b) >= k) {
          break label200;
        }
        if ((bdne.a(this.this$0.b) + 1) % j == 0)
        {
          bdne.a(this.this$0.a, bdne.a(this.this$0.a) + 1);
          this.this$0.b(true, this.a, this.b);
        }
      }
      for (;;)
      {
        bdne.a(this.this$0.b, bdne.a(this.this$0.b) + 1);
        return;
        label200:
        if ((bdne.a(this.this$0.b) + 1 - k) % i == 0)
        {
          bdne.a(this.this$0.a, bdne.a(this.this$0.a) + 1);
          this.this$0.b(true, this.a, this.b);
        }
      }
      j = 0;
      k = 0;
      m = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyTabTopSearchHeaderController.3
 * JD-Core Version:    0.7.0.1
 */