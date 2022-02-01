package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.common.DistinctEventReporter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class ReadInJoyPicWaterFallFragment$ClassificationAdapter
  extends BaseAdapter
{
  private ReadInJoyPicWaterFallFragment$ClassificationAdapter(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment) {}
  
  public ReadInJoyPicWaterFallFragment.ClassData a(int paramInt)
  {
    return (ReadInJoyPicWaterFallFragment.ClassData)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a.getActivity()).inflate(2131562880, paramViewGroup, false);
      paramView.setOnClickListener(new ReadInJoyPicWaterFallFragment.ClassificationAdapter.1(this));
    }
    for (;;)
    {
      ReadInJoyPicWaterFallFragment.ClassData localClassData = (ReadInJoyPicWaterFallFragment.ClassData)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      paramView.setTag(Integer.valueOf(paramInt));
      ((TextView)paramView).setText(localClassData.a());
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonDistinctEventReporter.a("exp_subchannel", localClassData);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment.ClassificationAdapter
 * JD-Core Version:    0.7.0.1
 */