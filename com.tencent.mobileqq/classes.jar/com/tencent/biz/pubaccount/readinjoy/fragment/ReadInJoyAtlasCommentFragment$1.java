package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadInJoyAtlasCommentFragment$1
  implements View.OnClickListener
{
  ReadInJoyAtlasCommentFragment$1(ReadInJoyAtlasCommentFragment paramReadInJoyAtlasCommentFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.onBackEvent();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasCommentFragment.1
 * JD-Core Version:    0.7.0.1
 */