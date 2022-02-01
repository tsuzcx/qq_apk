package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder.Holder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.os.MqqHandler;

class FontSettingActivity$AioListAdapter
  extends BaseAdapter
{
  FontSettingActivity$AioListAdapter(FontSettingActivity paramFontSettingActivity) {}
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = this.a.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity$MyItemBuilder.a(paramInt, getCount(), (ChatMessage)this.a.jdField_a_of_type_JavaUtilList.get(paramInt), paramView, paramViewGroup, null);
    TextItemBuilder.Holder localHolder = (TextItemBuilder.Holder)localView.getTag();
    localHolder.d.setOnClickListener(null);
    if ((localHolder.d instanceof AnimationTextView)) {
      ((AnimationTextView)localHolder.d).onDoubleClick = null;
    }
    if ((FontSettingActivity.a(this.a)) && (paramInt == this.a.jdField_a_of_type_JavaUtilList.size() - 1))
    {
      this.a.jdField_a_of_type_Boolean = true;
      this.a.a();
    }
    if ((this.a.c) && (paramInt == this.a.jdField_a_of_type_JavaUtilList.size() - 1))
    {
      this.a.c = false;
      FontSettingActivity.a(this.a).postDelayed(new FontSettingActivity.AioListAdapter.1(this), 100L);
    }
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "[AioListAdapter#getView] invoked");
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FontSettingActivity.AioListAdapter
 * JD-Core Version:    0.7.0.1
 */