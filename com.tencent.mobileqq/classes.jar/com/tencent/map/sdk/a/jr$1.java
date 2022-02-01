package com.tencent.map.sdk.a;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class jr$1
  implements View.OnClickListener
{
  jr$1(jr paramjr) {}
  
  public final void onClick(View paramView)
  {
    Context localContext = jr.a(this.a);
    if (localContext != null)
    {
      long l = SystemClock.uptimeMillis();
      if ((or.b != 0L) && (l - or.b >= 300L)) {
        break label134;
      }
      or.b = l;
      int i = or.c + 1;
      or.c = i;
      if ((i < 5) || (or.c >= 10)) {
        break label108;
      }
      Toast.makeText(localContext, "开发者调试在" + (10 - or.c) + "次后开启", 0).show();
    }
    label134:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label108:
      if (or.c == 10)
      {
        or.a = true;
        Toast.makeText(localContext, "开发者调试已开启", 0).show();
        continue;
        or.c = 0;
        or.b = 0L;
        or.a = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.jr.1
 * JD-Core Version:    0.7.0.1
 */