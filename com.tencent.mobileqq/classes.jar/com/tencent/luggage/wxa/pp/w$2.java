package com.tencent.luggage.wxa.pp;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputConnection;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class w$2
  implements View.OnClickListener
{
  w$2(w paramw) {}
  
  public void onClick(View paramView)
  {
    if (w.a(this.a) != null)
    {
      String str1 = null;
      int i;
      String str2;
      if (paramView.getId() == 2131447011)
      {
        i = w.b(this.a);
        if (i != 1)
        {
          if (i != 2) {
            break label156;
          }
          str2 = ".";
        }
        else
        {
          str2 = "X";
        }
      }
      else
      {
        i = 0;
        for (;;)
        {
          str2 = str1;
          if (i >= w.c(this.a).size()) {
            break;
          }
          int j = w.c(this.a).valueAt(i);
          if (paramView.getId() == j) {
            str1 = String.valueOf(w.c(this.a).keyAt(i));
          }
          i += 1;
        }
      }
      if (!TextUtils.isEmpty(str2)) {
        w.a(this.a).commitText(str2, str2.length());
      }
    }
    label156:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.w.2
 * JD-Core Version:    0.7.0.1
 */