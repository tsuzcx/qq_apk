package com.tencent.biz.subscribe.comment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EmoWindowAdapter$1
  implements View.OnClickListener
{
  EmoWindowAdapter$1(EmoWindowAdapter paramEmoWindowAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.b.a.a(this.a, EmoWindowAdapter.a(this.b));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.EmoWindowAdapter.1
 * JD-Core Version:    0.7.0.1
 */