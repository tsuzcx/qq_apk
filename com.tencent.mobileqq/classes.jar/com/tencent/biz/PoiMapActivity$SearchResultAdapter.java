package com.tencent.biz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class PoiMapActivity$SearchResultAdapter
  extends BaseAdapter
{
  protected LayoutInflater a;
  
  public PoiMapActivity$SearchResultAdapter(PoiMapActivity paramPoiMapActivity, Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentBizPoiMapActivity.a == null) {
      return 0;
    }
    if (this.jdField_a_of_type_ComTencentBizPoiMapActivity.d) {
      return this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.size() + 1;
    }
    return this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPoiMapActivity.a == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    PoiMapActivity.PoiItemViewHolder localPoiItemViewHolder;
    if (paramView == null)
    {
      localPoiItemViewHolder = new PoiMapActivity.PoiItemViewHolder(this.jdField_a_of_type_ComTencentBizPoiMapActivity);
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPoiMapActivity).inflate(2131559960, null);
      localPoiItemViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371709));
      localPoiItemViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362252));
      localPoiItemViewHolder.c = paramView.findViewById(2131377149);
      localPoiItemViewHolder.c.setVisibility(4);
      localPoiItemViewHolder.d = paramView.findViewById(2131371496);
      localPoiItemViewHolder.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365560);
      localPoiItemViewHolder.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131377358);
      paramView.setTag(localPoiItemViewHolder);
    }
    else
    {
      localPoiItemViewHolder = (PoiMapActivity.PoiItemViewHolder)paramView.getTag();
    }
    localPoiItemViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
    if (paramInt == this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.size())
    {
      localPoiItemViewHolder.d.setVisibility(0);
      localPoiItemViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    else
    {
      localPoiItemViewHolder.d.setVisibility(8);
      localPoiItemViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
      PoiMapActivity.POI localPOI = (PoiMapActivity.POI)getItem(paramInt);
      if (localPOI != null)
      {
        localPoiItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localPOI.a);
        localPoiItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(localPOI.b);
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */