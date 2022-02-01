package com.tencent.biz.pubaccount.readinjoy.common;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDailySettingPopupWindow.Callback;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class ReadInJoyDailyConfigAdapter
  extends RecyclerView.Adapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ReadInJoyDailySettingPopupWindow.Callback jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDailySettingPopupWindow$Callback;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<String> b = new ArrayList();
  
  public ReadInJoyDailyConfigAdapter(Context paramContext, List<String> paramList1, List<String> paramList2, ReadInJoyDailySettingPopupWindow.Callback paramCallback)
  {
    this.b = paramList1;
    this.jdField_a_of_type_JavaUtilList = paramList2;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDailySettingPopupWindow$Callback = paramCallback;
  }
  
  public int getItemCount()
  {
    if (this.b != null) {
      return this.b.size();
    }
    return 0;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof ReadInJoyDailyConfigAdapter.DailyConfigViewHolder))
    {
      ReadInJoyDailyConfigAdapter.DailyConfigViewHolder localDailyConfigViewHolder = (ReadInJoyDailyConfigAdapter.DailyConfigViewHolder)paramViewHolder;
      if ((paramInt >= 0) && (paramInt < this.b.size()))
      {
        String str1 = (String)this.b.get(paramInt);
        String str2 = (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        localDailyConfigViewHolder.a.setText(str1);
        localDailyConfigViewHolder.a.setOnClickListener(new ReadInJoyDailyConfigAdapter.1(this, str2, str1));
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return new ReadInJoyDailyConfigAdapter.DailyConfigViewHolder(this, View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131560274, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDailyConfigAdapter
 * JD-Core Version:    0.7.0.1
 */