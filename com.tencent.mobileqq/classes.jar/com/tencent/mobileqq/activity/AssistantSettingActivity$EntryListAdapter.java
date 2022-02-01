package com.tencent.mobileqq.activity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntry;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

class AssistantSettingActivity$EntryListAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  private final List<CTEntry> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public AssistantSettingActivity$EntryListAdapter(Context paramContext, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = paramOnCheckedChangeListener;
  }
  
  private void b(List<CTEntry> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        CTEntry localCTEntry = (CTEntry)paramList.get(i);
        if (((localCTEntry == null) || (localCTEntry.jdField_a_of_type_Int == 1) || (localCTEntry.jdField_a_of_type_Int == 2)) && (localCTEntry != null)) {
          paramList.remove(localCTEntry);
        }
        i -= 1;
      }
    }
  }
  
  public CTEntry a(short paramShort)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (((CTEntry)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Short == paramShort) {
        return (CTEntry)this.jdField_a_of_type_JavaUtilList.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public void a(List<CTEntry> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null)
    {
      b(paramList);
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(short[] paramArrayOfShort)
  {
    boolean bool1 = false;
    int i = 0;
    for (;;)
    {
      if ((!bool1) && (paramArrayOfShort != null)) {
        try
        {
          if (i < paramArrayOfShort.length)
          {
            int j = 0;
            boolean bool2;
            for (;;)
            {
              bool2 = bool1;
              if (j >= this.jdField_a_of_type_JavaUtilList.size()) {
                break;
              }
              int k = paramArrayOfShort[i];
              int m = ((CTEntry)this.jdField_a_of_type_JavaUtilList.get(j)).jdField_a_of_type_Short;
              if (k == m)
              {
                bool2 = true;
                break;
              }
              j += 1;
            }
            i += 1;
            bool1 = bool2;
          }
        }
        catch (Throwable paramArrayOfShort)
        {
          paramArrayOfShort.printStackTrace();
        }
      }
    }
    return bool1;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getCount())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    CTEntry localCTEntry = (CTEntry)getItem(paramInt);
    if (localCTEntry == null) {
      return 0L;
    }
    return localCTEntry.jdField_a_of_type_Int;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    FormMultiLineSwitchItem localFormMultiLineSwitchItem;
    if (!(paramView instanceof FormSwitchItem))
    {
      localFormMultiLineSwitchItem = new FormMultiLineSwitchItem(this.jdField_a_of_type_AndroidContentContext);
      paramView = localFormMultiLineSwitchItem;
    }
    else
    {
      localFormMultiLineSwitchItem = (FormMultiLineSwitchItem)paramView;
    }
    CTEntry localCTEntry = (CTEntry)getItem(paramInt);
    if (localCTEntry != null)
    {
      localFormMultiLineSwitchItem.setText(localCTEntry.jdField_a_of_type_JavaLangString);
      localFormMultiLineSwitchItem.setChecked(localCTEntry.e ^ true);
      if ((localCTEntry.jdField_a_of_type_Int == 3) && (localCTEntry.e))
      {
        localFormMultiLineSwitchItem.setSecendLineText(this.jdField_a_of_type_AndroidContentContext.getString(2131699008));
        localFormMultiLineSwitchItem.setSecondLineTextViewVisibility(0);
      }
      else
      {
        localFormMultiLineSwitchItem.setSecendLineText("");
        localFormMultiLineSwitchItem.setSecondLineTextViewVisibility(8);
      }
    }
    int i = getCount();
    if ((paramInt == 0) && (i == 1))
    {
      if (this.jdField_a_of_type_Boolean) {
        localFormMultiLineSwitchItem.setBgType(2);
      } else {
        localFormMultiLineSwitchItem.setBgType(0);
      }
    }
    else if (paramInt == 0)
    {
      localFormMultiLineSwitchItem.setBgType(1);
    }
    else
    {
      i -= 1;
      if (paramInt == i)
      {
        if (this.jdField_a_of_type_Boolean) {
          localFormMultiLineSwitchItem.setBgType(2);
        } else {
          localFormMultiLineSwitchItem.setBgType(3);
        }
      }
      else if ((paramInt > 0) && (paramInt < i)) {
        localFormMultiLineSwitchItem.setBgType(2);
      }
    }
    localFormMultiLineSwitchItem.setTag(localCTEntry);
    localFormMultiLineSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity.EntryListAdapter
 * JD-Core Version:    0.7.0.1
 */