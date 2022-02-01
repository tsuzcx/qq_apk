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
      if ((or.b != 0L) && (l - or.b >= 300L))
      {
        or.c = 0;
        or.b = 0L;
        or.a = false;
      }
      else
      {
        or.b = l;
        int i = or.c + 1;
        or.c = i;
        if ((i >= 5) && (or.c < 10))
        {
          StringBuilder localStringBuilder = new StringBuilder("开发者调试在");
          localStringBuilder.append(10 - or.c);
          localStringBuilder.append("次后开启");
          Toast.makeText(localContext, localStringBuilder.toString(), 0).show();
        }
        else if (or.c == 10)
        {
          or.a = true;
          Toast.makeText(localContext, "开发者调试已开启", 0).show();
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.jr.1
 * JD-Core Version:    0.7.0.1
 */