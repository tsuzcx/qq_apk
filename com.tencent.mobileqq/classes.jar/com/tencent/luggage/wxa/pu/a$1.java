package com.tencent.luggage.wxa.pu;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public void onClick(View paramView)
  {
    if (a.a(this.a) != null)
    {
      int i;
      if (paramView.getId() == 2131447011)
      {
        i = a.b(this.a);
        if (i != 0) {
          if (i != 1)
          {
            if (i == 2) {
              a.a(this.a).dispatchKeyEvent(new KeyEvent(0, 56));
            }
          }
          else
          {
            a.a(this.a).dispatchKeyEvent(new KeyEvent(0, 59));
            a.a(this.a).dispatchKeyEvent(new KeyEvent(0, 52));
            a.a(this.a).dispatchKeyEvent(new KeyEvent(1, 59));
          }
        }
      }
      else
      {
        if (paramView.getId() == 2131447001) {
          i = 8;
        } else if (paramView.getId() == 2131447002) {
          i = 9;
        } else if (paramView.getId() == 2131447003) {
          i = 10;
        } else if (paramView.getId() == 2131447004) {
          i = 11;
        } else if (paramView.getId() == 2131447005) {
          i = 12;
        } else if (paramView.getId() == 2131447006) {
          i = 13;
        } else if (paramView.getId() == 2131447007) {
          i = 14;
        } else if (paramView.getId() == 2131447008) {
          i = 15;
        } else if (paramView.getId() == 2131447009) {
          i = 16;
        } else if (paramView.getId() == 2131447000) {
          i = 7;
        } else if (paramView.getId() == 2131447010) {
          i = 67;
        } else {
          i = 0;
        }
        a.a(this.a).dispatchKeyEvent(new KeyEvent(0, i));
        a.a(this.a).dispatchKeyEvent(new KeyEvent(1, i));
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pu.a.1
 * JD-Core Version:    0.7.0.1
 */