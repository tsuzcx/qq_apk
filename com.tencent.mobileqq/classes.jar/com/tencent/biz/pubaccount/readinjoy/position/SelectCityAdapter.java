package com.tencent.biz.pubaccount.readinjoy.position;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class SelectCityAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ArrayList<SelectCityAdapter.CityData> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public SelectCityAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(int paramInt, SelectCityAdapter.ViewHolder paramViewHolder)
  {
    String str;
    if (((SelectCityAdapter.CityData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int == 2) {
      str = ((SelectCityAdapter.CityData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).b;
    }
    for (;;)
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      return;
      if (((SelectCityAdapter.CityData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int == 1) {
        str = ((SelectCityAdapter.CityData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString;
      } else {
        str = "";
      }
    }
  }
  
  public void a(List<SelectCityAdapter.CityData> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if ((paramView != null) && (((SelectCityAdapter.ViewHolder)paramView.getTag()).jdField_a_of_type_Int == ((SelectCityAdapter.CityData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int))
    {
      localViewHolder = (SelectCityAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      a(paramInt, localViewHolder);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
    }
    SelectCityAdapter.ViewHolder localViewHolder = new SelectCityAdapter.ViewHolder(this, null);
    localViewHolder.jdField_a_of_type_Int = ((SelectCityAdapter.CityData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int;
    if (((SelectCityAdapter.CityData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int == 2) {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560387, paramViewGroup, false);
    }
    for (localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131364757));; localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131369033)))
    {
      localView.setTag(localViewHolder);
      break;
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560390, paramViewGroup, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.position.SelectCityAdapter
 * JD-Core Version:    0.7.0.1
 */