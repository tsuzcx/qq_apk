package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadInJoyFragmentWithSubChannel$1
  implements AdapterView.OnItemClickListener
{
  ReadInJoyFragmentWithSubChannel$1(ReadInJoyFragmentWithSubChannel paramReadInJoyFragmentWithSubChannel) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.a(paramView, paramInt);
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyFragmentWithSubChannel.1
 * JD-Core Version:    0.7.0.1
 */