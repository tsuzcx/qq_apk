package com.tencent.biz.pubaccount.subscript;

import android.app.Activity;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

class SubscriptRecommendAdapter$RecommendItem$3
  implements View.OnTouchListener
{
  SubscriptRecommendAdapter$RecommendItem$3(SubscriptRecommendAdapter.RecommendItem paramRecommendItem, SubscriptRecommendAdapter paramSubscriptRecommendAdapter, boolean paramBoolean) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i != 1) && (i != 3) && (i != 4)) {
        return false;
      }
      this.c.d.setTextColor(this.c.m.a.getResources().getColor(2131166845));
      this.c.c.setBackgroundResource(2130844322);
      return false;
    }
    this.c.d.setTextColor(this.c.m.a.getResources().getColor(2131166846));
    if (!this.b)
    {
      this.c.c.setBackgroundResource(2130844313);
      return false;
    }
    this.c.c.setBackgroundResource(2130844314);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptRecommendAdapter.RecommendItem.3
 * JD-Core Version:    0.7.0.1
 */