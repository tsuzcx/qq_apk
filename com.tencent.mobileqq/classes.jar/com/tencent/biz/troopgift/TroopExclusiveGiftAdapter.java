package com.tencent.biz.troopgift;

import android.graphics.Color;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TroopExclusiveGiftAdapter
  extends BaseAdapter
{
  private List<TroopExclusiveGiftAdapter.TroopExclusiveGiftData> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<Integer, TroopExclusiveGiftAdapter.ViewHolder> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public void a(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      TroopExclusiveGiftAdapter.TroopExclusiveGiftData localTroopExclusiveGiftData = (TroopExclusiveGiftAdapter.TroopExclusiveGiftData)this.jdField_a_of_type_JavaUtilList.get(i);
      boolean bool;
      if (i == paramInt) {
        bool = true;
      } else {
        bool = false;
      }
      localTroopExclusiveGiftData.jdField_a_of_type_Boolean = bool;
      i += 1;
    }
    notifyDataSetChanged();
  }
  
  public void a(List<TroopExclusiveGiftAdapter.TroopExclusiveGiftData> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() != 0)) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TroopExclusiveGiftAdapter.TroopExclusiveGiftData localTroopExclusiveGiftData = (TroopExclusiveGiftAdapter.TroopExclusiveGiftData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    boolean bool = this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt));
    int i = 0;
    Object localObject1;
    Object localObject2;
    if (!bool)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560640, paramViewGroup, false);
      paramView.setLayoutParams(new ViewGroup.LayoutParams(-2, ScreenUtil.dip2px(50.0F)));
      localObject1 = new TroopExclusiveGiftAdapter.ViewHolder();
      ((TroopExclusiveGiftAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379704));
      ((TroopExclusiveGiftAdapter.ViewHolder)localObject1).b = paramView.findViewById(2131380844);
      if ((localTroopExclusiveGiftData != null) && (Build.VERSION.SDK_INT >= 4)) {
        paramView.setContentDescription(localTroopExclusiveGiftData.jdField_a_of_type_JavaLangString);
      }
      ((TroopExclusiveGiftAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidViewView = paramView;
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localObject1);
    }
    else
    {
      localObject2 = (TroopExclusiveGiftAdapter.ViewHolder)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        paramView = ((TroopExclusiveGiftAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidViewView;
        localObject1 = localObject2;
      }
    }
    if ((localTroopExclusiveGiftData != null) && (localObject1 != null) && (paramView != null))
    {
      ((TroopExclusiveGiftAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(localTroopExclusiveGiftData.jdField_a_of_type_JavaLangString);
      TextView localTextView = ((TroopExclusiveGiftAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView;
      if (localTroopExclusiveGiftData.jdField_a_of_type_Boolean) {
        localObject2 = "#ffff5b84";
      } else {
        localObject2 = "#ff878b99";
      }
      localTextView.setTextColor(Color.parseColor((String)localObject2));
      localObject1 = ((TroopExclusiveGiftAdapter.ViewHolder)localObject1).b;
      if (!localTroopExclusiveGiftData.jdField_a_of_type_Boolean) {
        i = 8;
      }
      ((View)localObject1).setVisibility(i);
      paramView.setSelected(localTroopExclusiveGiftData.jdField_a_of_type_Boolean);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopExclusiveGiftAdapter
 * JD-Core Version:    0.7.0.1
 */