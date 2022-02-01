package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Collections;
import java.util.List;

class ChooseItemView$4
  implements View.OnClickListener
{
  ChooseItemView$4(ChooseItemView paramChooseItemView) {}
  
  public void onClick(View paramView)
  {
    if ((ChooseItemView.a(this.a) != null) && (ChooseItemView.a(this.a).size() > 1))
    {
      Collections.shuffle(ChooseItemView.a(this.a));
      this.a.a.a(ChooseItemView.b(this.a));
    }
    if (ChooseItemView.a(this.a) != null) {
      ChooseItemView.a(this.a).onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.ChooseItemView.4
 * JD-Core Version:    0.7.0.1
 */