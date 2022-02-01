package com.tencent.mobileqq.activity.contact.troop;

import ajep;
import ajfb;
import ajgm;

public class TroopNotifyAndRecommendView$5$1
  implements Runnable
{
  public TroopNotifyAndRecommendView$5$1(ajgm paramajgm) {}
  
  public void run()
  {
    if (this.a.a.a != null) {
      this.a.a.a.notifyDataSetChanged();
    }
    if (TroopNotifyAndRecommendView.a(this.a.a) != null) {
      TroopNotifyAndRecommendView.a(this.a.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.5.1
 * JD-Core Version:    0.7.0.1
 */