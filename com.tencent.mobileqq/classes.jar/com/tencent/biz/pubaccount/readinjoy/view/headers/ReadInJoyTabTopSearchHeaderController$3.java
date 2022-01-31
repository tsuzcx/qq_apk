package com.tencent.biz.pubaccount.readinjoy.view.headers;

import android.text.format.DateUtils;
import android.util.Log;
import baig;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import rcf;

public class ReadInJoyTabTopSearchHeaderController$3
  implements Runnable
{
  public ReadInJoyTabTopSearchHeaderController$3(rcf paramrcf, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    int i = 0;
    if (!DateUtils.isToday(baig.b("search_word_prefix_last_change_hotword_time")))
    {
      baig.a("search_word_prefix_last_change_hotword_time", System.currentTimeMillis());
      baig.a(this.this$0.a, 0);
      baig.a(this.this$0.b, 0);
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
      Log.d("Debug_HSF", baig.a(this.this$0.a) + "," + baig.a(this.this$0.b));
      if (baig.a(this.this$0.a) < m)
      {
        if (baig.a(this.this$0.b) >= k) {
          break label255;
        }
        if ((baig.a(this.this$0.b) + 1) % j == 0)
        {
          baig.a(this.this$0.a, baig.a(this.this$0.a) + 1);
          this.this$0.b(true, this.a, this.b);
          Log.d("Debug_HSF", "前刷新");
        }
      }
      for (;;)
      {
        baig.a(this.this$0.b, baig.a(this.this$0.b) + 1);
        return;
        label255:
        if ((baig.a(this.this$0.b) + 1 - k) % i == 0)
        {
          baig.a(this.this$0.a, baig.a(this.this$0.a) + 1);
          this.this$0.b(true, this.a, this.b);
          Log.d("Debug_HSF", "后刷新");
        }
      }
      j = 0;
      k = 0;
      m = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyTabTopSearchHeaderController.3
 * JD-Core Version:    0.7.0.1
 */