package com.tencent.mobileqq.activity.phone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.utils.PhoneCodeUtils.CountryCode;
import com.tencent.mobileqq.widget.PinnedDividerListView.DividerAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.LinkedHashMap;

class NewStyleCountryActivity$CountryAdapter
  extends PinnedDividerListView.DividerAdapter
{
  private NewStyleCountryActivity$CountryAdapter(NewStyleCountryActivity paramNewStyleCountryActivity) {}
  
  public int a()
  {
    return 2131562756;
  }
  
  public void a(View paramView, int paramInt)
  {
    paramInt = ((Integer)this.a.jdField_a_of_type_JavaUtilLinkedHashMap.get(((PhoneCodeUtils.CountryCode)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString)).intValue();
    ((TextView)paramView).setText(((PhoneCodeUtils.CountryCode)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString);
  }
  
  public boolean a(int paramInt)
  {
    return ((PhoneCodeUtils.CountryCode)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Boolean;
  }
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((PhoneCodeUtils.CountryCode)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Boolean ^ true;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    PhoneCodeUtils.CountryCode localCountryCode = (PhoneCodeUtils.CountryCode)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    View localView;
    if (getItemViewType(paramInt) == 0)
    {
      localView = paramView;
      if (paramView == null) {
        localView = this.a.getLayoutInflater().inflate(a(), paramViewGroup, false);
      }
      ((TextView)localView).setText(localCountryCode.jdField_a_of_type_JavaLangString);
    }
    else
    {
      localView = paramView;
      if (paramView == null)
      {
        paramView = this.a;
        localView = NewStyleCountryActivity.a(paramView, paramViewGroup, paramView.getLayoutInflater(), false);
        localView.setOnClickListener(this.a);
      }
      this.a.a(localView, localCountryCode);
    }
    localView.setVisibility(0);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.NewStyleCountryActivity.CountryAdapter
 * JD-Core Version:    0.7.0.1
 */