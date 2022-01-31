package com.tencent.map.sdk.a;

import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

final class jr$1
  implements View.OnClickListener
{
  jr$1(jr paramjr) {}
  
  public final void onClick(View paramView)
  {
    paramView = jr.a(this.a);
    if (paramView != null)
    {
      long l = SystemClock.uptimeMillis();
      if ((or.b != 0L) && (l - or.b >= 300L)) {
        break label121;
      }
      or.b = l;
      int i = or.c + 1;
      or.c = i;
      if ((i < 5) || (or.c >= 10)) {
        break label98;
      }
      Toast.makeText(paramView, "开发者调试在" + (10 - or.c) + "次后开启", 0).show();
    }
    label98:
    while (or.c != 10) {
      return;
    }
    or.a = true;
    Toast.makeText(paramView, "开发者调试已开启", 0).show();
    return;
    label121:
    or.c = 0;
    or.b = 0L;
    or.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.jr.1
 * JD-Core Version:    0.7.0.1
 */