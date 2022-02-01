package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ComponentContentNoteCard$3
  implements View.OnClickListener
{
  ComponentContentNoteCard$3(ComponentContentNoteCard paramComponentContentNoteCard) {}
  
  public void onClick(View paramView)
  {
    ComponentContentNoteCard.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentNoteCard.3
 * JD-Core Version:    0.7.0.1
 */