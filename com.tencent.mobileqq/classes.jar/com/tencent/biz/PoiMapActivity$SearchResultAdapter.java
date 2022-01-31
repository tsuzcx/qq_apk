package com.tencent.biz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
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
    if (paramView == null)
    {
      paramViewGroup = new PoiMapActivity.PoiItemViewHolder(this.jdField_a_of_type_ComTencentBizPoiMapActivity);
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPoiMapActivity).inflate(2130969515, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366796));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366800));
      paramViewGroup.c = paramView.findViewById(2131366801);
      paramViewGroup.c.setVisibility(4);
      paramViewGroup.d = paramView.findViewById(2131366802);
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131366793);
      paramViewGroup.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131366794);
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(8);
      if (paramInt != this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.size()) {
        break label164;
      }
      paramViewGroup.d.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    label164:
    PoiMapActivity.POI localPOI;
    do
    {
      return paramView;
      paramViewGroup = (PoiMapActivity.PoiItemViewHolder)paramView.getTag();
      break;
      paramViewGroup.d.setVisibility(8);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      localPOI = (PoiMapActivity.POI)getItem(paramInt);
    } while (localPOI == null);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localPOI.a);
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localPOI.b);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */