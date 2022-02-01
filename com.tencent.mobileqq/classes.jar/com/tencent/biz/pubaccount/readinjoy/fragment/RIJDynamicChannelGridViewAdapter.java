package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo.RedPoint;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianUrlRoundCornerImageView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView.AbstractDynamicGridAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView.OnDragListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView.OnDropListener;
import com.tencent.mobileqq.widget.AutoFitTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import java.util.List;

public class RIJDynamicChannelGridViewAdapter
  extends RIJBaseChannelGridViewAdapter
  implements View.OnClickListener, ReadInJoyDynamicGridView.OnDragListener, ReadInJoyDynamicGridView.OnDropListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener
{
  private final RIJDynamicChannelGridViewAdapter.DynamicAdapterCallback a;
  private final int c;
  private int d = 0;
  
  public RIJDynamicChannelGridViewAdapter(Context paramContext, int paramInt1, int paramInt2, RIJDynamicChannelGridViewAdapter.DynamicAdapterCallback paramDynamicAdapterCallback, int paramInt3)
  {
    super(paramContext, paramInt1, paramInt2, paramDynamicAdapterCallback);
    this.c = paramInt3;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentRIJDynamicChannelGridViewAdapter$DynamicAdapterCallback = paramDynamicAdapterCallback;
  }
  
  private int a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    int j = -1291845632;
    int i = j;
    if (paramTabChannelCoverInfo != null)
    {
      if (paramTabChannelCoverInfo.fontsColor == 0) {
        break label23;
      }
      i = paramTabChannelCoverInfo.fontsColor;
    }
    label23:
    do
    {
      return i;
      i = j;
    } while (!paramTabChannelCoverInfo.isCurrent);
    return -15550475;
  }
  
  List<TabChannelCoverInfo> a(List<TabChannelCoverInfo> paramList)
  {
    int j = 0;
    if ((paramList == null) || (paramList.size() == 0))
    {
      QLog.d("RIJDynamicChannelGridViewAdapter", 2, "No channel Cache info.");
      return paramList;
    }
    if ((this.c >= 0) && (this.c < paramList.size())) {
      ((TabChannelCoverInfo)paramList.get(this.c)).isCurrent = true;
    }
    int i = 0;
    TabChannelCoverInfo localTabChannelCoverInfo;
    if (i < paramList.size())
    {
      localTabChannelCoverInfo = (TabChannelCoverInfo)paramList.get(i);
      if (localTabChannelCoverInfo != null) {
        if (i != this.c) {
          break label116;
        }
      }
      label116:
      for (boolean bool = true;; bool = false)
      {
        localTabChannelCoverInfo.isCurrent = bool;
        i += 1;
        break;
      }
    }
    i = 0;
    if (j < paramList.size())
    {
      localTabChannelCoverInfo = (TabChannelCoverInfo)paramList.get(j);
      if (localTabChannelCoverInfo == null) {
        break label191;
      }
      if (localTabChannelCoverInfo.reason == 4) {
        i += 1;
      }
    }
    label191:
    for (;;)
    {
      j += 1;
      break;
      this.d = i;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentRIJDynamicChannelGridViewAdapter$DynamicAdapterCallback.a(this.d);
      return paramList;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentRIJDynamicChannelGridViewAdapter$DynamicAdapterCallback.a();
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentRIJDynamicChannelGridViewAdapter$DynamicAdapterCallback.a(this, paramInt1, paramInt2);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)getItem(paramInt);
    View localView;
    Object localObject;
    int i;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560347, null);
      paramView = new RIJDynamicChannelGridViewAdapter.ChannelItemViewHolder();
      paramView.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131370416));
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView = ((AutoFitTextView)localView.findViewById(2131364577));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131376828));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131376833));
      paramView.b = ((ImageView)localView.findViewById(2131365657));
      paramView.b.setOnClickListener(this);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView.setOnGetMaxWidthCallback(paramView);
      paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)localView.findViewById(2131369690));
      if (paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView != null) {
        paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setCorner(this.jdField_a_of_type_Int);
      }
      localView.setTag(paramView);
      localView.setAlpha(1.0F);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView.setText(localTabChannelCoverInfo.mChannelCoverName);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView.setTextColor(a(localTabChannelCoverInfo));
      localObject = paramView.b;
      if (!this.jdField_a_of_type_Boolean) {
        break label329;
      }
      i = 0;
      label208:
      ((ImageView)localObject).setVisibility(i);
      paramView.b.setTag(localTabChannelCoverInfo);
      paramView.b.setTag(2131376596, Integer.valueOf(paramInt));
      if ((paramInt < this.d) && (this.jdField_a_of_type_Boolean))
      {
        localView.setAlpha(0.5F);
        paramView.b.setVisibility(8);
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label336;
      }
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (RIJDynamicChannelGridViewAdapter.ChannelItemViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label329:
      i = 8;
      break label208;
      label336:
      localObject = paramView.jdField_a_of_type_AndroidWidgetImageView;
      if (RIJChannelHelper.a(localTabChannelCoverInfo) == 0) {}
      for (i = 0;; i = 8)
      {
        ((ImageView)localObject).setVisibility(i);
        if ((RIJChannelHelper.a(localTabChannelCoverInfo) != 1) || (localTabChannelCoverInfo.redPoint.c > 0L)) {
          break label410;
        }
        paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        a(localTabChannelCoverInfo, paramView.jdField_a_of_type_AndroidWidgetTextView);
        break;
      }
      label410:
      paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = ((Integer)paramView.getTag(2131376596)).intValue();
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)paramView.getTag();
      QLog.d("RIJDynamicChannelGridViewAdapter", 1, new Object[] { "onClick, delete button position = ", Integer.valueOf(i) });
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentRIJDynamicChannelGridViewAdapter$DynamicAdapterCallback.a(i, localTabChannelCoverInfo, this);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = (TabChannelCoverInfo)getItem(paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentRIJDynamicChannelGridViewAdapter$DynamicAdapterCallback.a(paramAdapterView, this, paramInt, paramView);
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = (TabChannelCoverInfo)getItem(paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentRIJDynamicChannelGridViewAdapter$DynamicAdapterCallback.b(paramAdapterView, this, paramInt, paramView);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.RIJDynamicChannelGridViewAdapter
 * JD-Core Version:    0.7.0.1
 */