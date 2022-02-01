package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.databinding.ObservableArrayList;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadInJoySelectMemberFragment$3
  implements AdapterView.OnItemClickListener
{
  ReadInJoySelectMemberFragment$3(ReadInJoySelectMemberFragment paramReadInJoySelectMemberFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.a.remove(paramInt);
    this.a.e();
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ReadInJoySelectMemberFragment.3
 * JD-Core Version:    0.7.0.1
 */