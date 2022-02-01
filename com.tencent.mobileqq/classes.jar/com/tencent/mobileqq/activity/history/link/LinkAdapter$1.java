package com.tencent.mobileqq.activity.history.link;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LinkAdapter$1
  implements View.OnClickListener
{
  LinkAdapter$1(LinkAdapter paramLinkAdapter, LinkAdapter.DividerViewHolder paramDividerViewHolder) {}
  
  public void onClick(View paramView)
  {
    String str = String.valueOf(this.a.a.getText());
    LinkAdapter.a(this.b, str);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.link.LinkAdapter.1
 * JD-Core Version:    0.7.0.1
 */