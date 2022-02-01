package com.tencent.biz.qqstory.takevideo.filter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class POIFilterData$POIFilterPageItem
  extends FilterData.FilterPageItem<POIFilterData>
{
  TextView jdField_a_of_type_AndroidWidgetTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370792);
  
  POIFilterData$POIFilterPageItem(POIFilterData paramPOIFilterData, @NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
  }
  
  protected View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2131561897, paramViewGroup, false);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
  }
  
  public void a(POIFilterData paramPOIFilterData, int paramInt)
  {
    super.a(paramPOIFilterData, paramInt);
    if (paramPOIFilterData != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramPOIFilterData.a());
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.filter.POIFilterData.POIFilterPageItem
 * JD-Core Version:    0.7.0.1
 */