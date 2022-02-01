package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo.RedPoint;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianUrlRoundCornerImageView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView.AbstractDynamicGridAdapter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.widget.AutoFitTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.Iterator;
import java.util.List;

public class RIJStaticChannelGridViewAdapter
  extends RIJBaseChannelGridViewAdapter
  implements AdapterView.OnItemClickListener
{
  public RIJStaticChannelGridViewAdapter(Context paramContext, int paramInt1, int paramInt2, RIJBaseChannelGridViewAdapter.AdapterCallback paramAdapterCallback)
  {
    super(paramContext, paramInt1, paramInt2, paramAdapterCallback);
  }
  
  private int a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    int j = -1291845632;
    int i = j;
    if (paramTabChannelCoverInfo != null)
    {
      i = j;
      if (paramTabChannelCoverInfo.fontsColor != 0) {
        i = paramTabChannelCoverInfo.fontsColor;
      }
    }
    return i;
  }
  
  List<TabChannelCoverInfo> a(List<TabChannelCoverInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      QLog.d("RIJStaticChannelGridViewAdapter", 2, "No channel Cache info.");
    }
    for (;;)
    {
      return paramList;
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        ((TabChannelCoverInfo)localIterator.next()).isCurrent = false;
      }
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)getItem(paramInt);
    View localView;
    label206:
    Object localObject;
    int i;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560375, null);
      paramView = new RIJStaticChannelGridViewAdapter.ChannelItemViewHolder(this.jdField_a_of_type_AndroidContentContext);
      paramView.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131370416));
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView = ((AutoFitTextView)localView.findViewById(2131364577));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131376828));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131376833));
      paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)localView.findViewById(2131369690));
      if (paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView != null) {
        paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setCorner(this.jdField_a_of_type_Int);
      }
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView.setOnGetMaxWidthCallback(paramView);
      localView.setTag(paramView);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView.setText(localTabChannelCoverInfo.mChannelCoverName);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView.setTextColor(a(localTabChannelCoverInfo));
      if (!this.jdField_a_of_type_Boolean) {
        break label306;
      }
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView.setCompoundDrawablesWithIntrinsicBounds(2130842975, 0, 0, 0);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView.setCompoundDrawablePadding(AIOUtils.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localObject = paramView.jdField_a_of_type_AndroidWidgetImageView;
      if (RIJChannelHelper.a(localTabChannelCoverInfo) != 0) {
        break label320;
      }
      i = 0;
      label223:
      ((ImageView)localObject).setVisibility(i);
      if ((RIJChannelHelper.a(localTabChannelCoverInfo) != 1) || (localTabChannelCoverInfo.redPoint.c > 0L)) {
        break label327;
      }
      paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      a(localTabChannelCoverInfo, paramView.jdField_a_of_type_AndroidWidgetTextView);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (RIJStaticChannelGridViewAdapter.ChannelItemViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label306:
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetAutoFitTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label206;
      label320:
      i = 8;
      break label223;
      label327:
      paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = (TabChannelCoverInfo)getItem(paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentRIJBaseChannelGridViewAdapter$AdapterCallback.a(paramAdapterView, this, paramInt, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.RIJStaticChannelGridViewAdapter
 * JD-Core Version:    0.7.0.1
 */