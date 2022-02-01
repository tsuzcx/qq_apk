package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadInJoyUgcSearchTopicFragment$5
  implements View.OnClickListener
{
  ReadInJoyUgcSearchTopicFragment$5(ReadInJoyUgcSearchTopicFragment paramReadInJoyUgcSearchTopicFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.getActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyUgcSearchTopicFragment.5
 * JD-Core Version:    0.7.0.1
 */