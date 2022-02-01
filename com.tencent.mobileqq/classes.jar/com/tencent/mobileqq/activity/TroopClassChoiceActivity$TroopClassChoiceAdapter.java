package com.tencent.mobileqq.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.troop.troopcatalog.GroupCatalogBean;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class TroopClassChoiceActivity$TroopClassChoiceAdapter
  extends BaseAdapter
{
  TroopClassChoiceActivity$TroopClassChoiceAdapter(TroopClassChoiceActivity paramTroopClassChoiceActivity) {}
  
  public int getCount()
  {
    if (this.a.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.a.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = this.a.getLayoutInflater().inflate(2131562956, null);
    }
    TextView localTextView1 = (TextView)localView.findViewById(2131379181);
    TextView localTextView2 = (TextView)localView.findViewById(2131379180);
    ImageView localImageView = (ImageView)localView.findViewById(2131372124);
    GroupCatalogBean localGroupCatalogBean2 = (GroupCatalogBean)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogBean != null) && (localGroupCatalogBean2.jdField_a_of_type_Int < this.a.jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogBean.jdField_a_of_type_Int))
    {
      Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogBean;
      GroupCatalogBean localGroupCatalogBean1;
      for (paramView = ((GroupCatalogBean)localObject).jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogBean; (paramView != null) && (paramView.jdField_a_of_type_Int >= localGroupCatalogBean2.jdField_a_of_type_Int); paramView = localGroupCatalogBean1)
      {
        if (localGroupCatalogBean2.b.equals(paramView.b))
        {
          i = 1;
          break label172;
        }
        localGroupCatalogBean1 = paramView.jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogBean;
        localObject = paramView;
      }
      int i = 0;
      label172:
      if (i != 0)
      {
        localTextView2.setVisibility(0);
        localTextView2.setText(((GroupCatalogBean)localObject).jdField_a_of_type_JavaLangString);
        localTextView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130851097, 0);
      }
      else
      {
        localTextView2.setVisibility(4);
      }
    }
    else if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogBean != null) && (localGroupCatalogBean2.b.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogBean.b)))
    {
      localTextView2.setVisibility(0);
      localTextView2.setText("");
      localTextView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130851097, 0);
    }
    else
    {
      localTextView2.setVisibility(4);
    }
    localTextView1.setText(localGroupCatalogBean2.jdField_a_of_type_JavaLangString);
    if ((localGroupCatalogBean2.jdField_a_of_type_JavaUtilArrayList != null) && (localGroupCatalogBean2.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      localImageView.setVisibility(0);
    } else {
      localImageView.setVisibility(4);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopClassChoiceActivity.TroopClassChoiceAdapter
 * JD-Core Version:    0.7.0.1
 */