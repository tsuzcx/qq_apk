package com.tencent.biz.pubaccount.readinjoy.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.List;

class ReadinjoySubscriptManagerActivity$SubscribeAdapter
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  private List<ReadinjoySubscriptManagerActivity.SubscribeFeedData> jdField_a_of_type_JavaUtilList;
  
  private ReadinjoySubscriptManagerActivity$SubscribeAdapter(ReadinjoySubscriptManagerActivity paramReadinjoySubscriptManagerActivity) {}
  
  private void a(ReadinjoySubscriptManagerActivity.SubscribeHolder paramSubscribeHolder, int paramInt, View paramView)
  {
    ReadinjoySubscriptManagerActivity.SubscribeFeedData localSubscribeFeedData = (ReadinjoySubscriptManagerActivity.SubscribeFeedData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    ReadinjoySubscriptManagerActivity.SubscribeHolder.a(paramSubscribeHolder).setText(ReadinjoySubscriptManagerActivity.SubscribeFeedData.b(localSubscribeFeedData));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)ReadinjoySubscriptManagerActivity.SubscribeHolder.a(paramSubscribeHolder).getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new RelativeLayout.LayoutParams(-2, -2);
    }
    ReadinjoySubscriptManagerActivity.SubscribeHolder.a(paramSubscribeHolder).setImageDrawable(ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity).a(1008, ReadinjoySubscriptManagerActivity.SubscribeFeedData.c(localSubscribeFeedData)));
    int i;
    if (ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity))
    {
      ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      localObject = ReadinjoySubscriptManagerActivity.SubscribeHolder.a(paramSubscribeHolder);
      if (!ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity)) {
        break label238;
      }
      i = 0;
      label121:
      ((View)localObject).setVisibility(i);
      ReadinjoySubscriptManagerActivity.SubscribeHolder.a(paramSubscribeHolder).setOnClickListener(new ReadinjoySubscriptManagerActivity.SubscribeAdapter.1(this, paramView));
      if (paramInt != getCount() - 1) {
        break label245;
      }
      ReadinjoySubscriptManagerActivity.SubscribeHolder.b(paramSubscribeHolder).setVisibility(8);
      label163:
      ReadinjoySubscriptManagerActivity.SubscribeHolder.a(paramSubscribeHolder).setOnClickListener(new ReadinjoySubscriptManagerActivity.SubscribeAdapter.2(this, localSubscribeFeedData));
      ReadinjoySubscriptManagerActivity.SubscribeHolder.a(paramSubscribeHolder, ReadinjoySubscriptManagerActivity.SubscribeFeedData.c(localSubscribeFeedData));
      if (!ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity)) {
        break label256;
      }
      ReadinjoySubscriptManagerActivity.SubscribeHolder.c(paramSubscribeHolder).setBackgroundResource(2131166912);
    }
    for (;;)
    {
      ReadinjoySubscriptManagerActivity.SubscribeHolder.c(paramSubscribeHolder).setPressed(false);
      return;
      ((RelativeLayout.LayoutParams)localObject).leftMargin = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity.getResources().getDimensionPixelSize(2131298856);
      break;
      label238:
      i = 8;
      break label121;
      label245:
      ReadinjoySubscriptManagerActivity.SubscribeHolder.b(paramSubscribeHolder).setVisibility(0);
      break label163;
      label256:
      ReadinjoySubscriptManagerActivity.SubscribeHolder.c(paramSubscribeHolder).setBackgroundResource(2130841884);
    }
  }
  
  public void a(List<ReadinjoySubscriptManagerActivity.SubscribeFeedData> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      paramView = new ReadinjoySubscriptManagerActivity.SubscribeHolder(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity, null);
      localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity.getLayoutInflater().inflate(2131560403, paramViewGroup, false);
      ReadinjoySubscriptManagerActivity.SubscribeHolder.a(paramView, localView.findViewById(2131365255));
      ReadinjoySubscriptManagerActivity.SubscribeHolder.b(paramView, localView.findViewById(2131365630));
      ReadinjoySubscriptManagerActivity.SubscribeHolder.a(paramView, (ImageView)localView.findViewById(2131378677));
      ReadinjoySubscriptManagerActivity.SubscribeHolder.a(paramView, (TextView)localView.findViewById(2131378683));
      ReadinjoySubscriptManagerActivity.SubscribeHolder.a(paramView, (Button)localView.findViewById(2131380904));
      ReadinjoySubscriptManagerActivity.SubscribeHolder.c(paramView, localView.findViewById(2131365922));
      localView.setTag(paramView);
      localView.setTag(-3, Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity.getResources().getDimensionPixelSize(2131298857)));
    }
    for (;;)
    {
      a(paramView, paramInt, localView);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      ReadinjoySubscriptManagerActivity.SubscribeHolder localSubscribeHolder = (ReadinjoySubscriptManagerActivity.SubscribeHolder)paramView.getTag();
      localView = paramView;
      paramView = localSubscribeHolder;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (ReadinjoySubscriptManagerActivity.SubscribeFeedData)getItem((int)paramLong);
    if ((paramAdapterView == null) || (ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity))) {
      return;
    }
    paramView = new ActivityURIRequest(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity, "/pubaccount/detail");
    paramView.extra().putString("uin", ReadinjoySubscriptManagerActivity.SubscribeFeedData.c(paramAdapterView));
    paramView.extra().putString("report_src_param_type", "");
    paramView.extra().putString("report_src_param_name", "");
    QRoute.startUri(paramView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoySubscriptManagerActivity.SubscribeAdapter
 * JD-Core Version:    0.7.0.1
 */