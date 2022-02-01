package com.tencent.biz.pubaccount.readinjoy.common;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDailySettingModel;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDailySettingPopupWindow;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.List;

public class ReadInJoyDailySettingAdapter
  extends RecyclerView.Adapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  ReadInJoyDailySettingPopupWindow jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDailySettingPopupWindow;
  private List<ReadInJoyDailySettingModel> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<ReadInJoyDailySettingModel> b = new ArrayList();
  
  public ReadInJoyDailySettingAdapter(Context paramContext, List<ReadInJoyDailySettingModel> paramList1, List<ReadInJoyDailySettingModel> paramList2)
  {
    this.jdField_a_of_type_JavaUtilList = paramList1;
    this.b = paramList2;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(int paramInt, ReadInJoyDailySettingModel paramReadInJoyDailySettingModel)
  {
    if (paramInt == 0) {
      ReadInJoyHelper.a("readinjoy_show_recommend_reason_in_title_b", paramReadInJoyDailySettingModel.c);
    }
  }
  
  public int getItemCount()
  {
    int j = 0;
    if (this.jdField_a_of_type_JavaUtilList != null) {}
    for (int i = this.jdField_a_of_type_JavaUtilList.size();; i = 0)
    {
      if (this.b != null) {
        j = this.b.size();
      }
      return i + 0 + j;
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt < this.b.size()) {
      return 0;
    }
    return 1;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    ReadInJoyDailySettingAdapter.DailySettingViewHolder localDailySettingViewHolder = (ReadInJoyDailySettingAdapter.DailySettingViewHolder)paramViewHolder;
    ReadInJoyDailySettingModel localReadInJoyDailySettingModel;
    if (paramInt >= this.b.size())
    {
      paramInt -= this.b.size();
      localReadInJoyDailySettingModel = (ReadInJoyDailySettingModel)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      localDailySettingViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      localDailySettingViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localReadInJoyDailySettingModel.b);
      localDailySettingViewHolder.b.setText(localReadInJoyDailySettingModel.d);
      localDailySettingViewHolder.itemView.setOnClickListener(new ReadInJoyDailySettingAdapter.1(this, localDailySettingViewHolder, localReadInJoyDailySettingModel, paramInt));
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      localReadInJoyDailySettingModel = (ReadInJoyDailySettingModel)this.b.get(paramInt);
      localDailySettingViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new ReadInJoyDailySettingAdapter.DailySettingViewHolder(this, View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131560332, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDailySettingAdapter
 * JD-Core Version:    0.7.0.1
 */