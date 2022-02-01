package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadInJoyProteusFamilyFragment$3
  implements View.OnClickListener
{
  ReadInJoyProteusFamilyFragment$3(ReadInJoyProteusFamilyFragment paramReadInJoyProteusFamilyFragment) {}
  
  public void onClick(View paramView)
  {
    if (ReadInJoyProteusFamilyFragment.a(this.a) != null) {
      ReadInJoyProteusFamilyFragment.a(this.a).a(true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyProteusFamilyFragment.3
 * JD-Core Version:    0.7.0.1
 */