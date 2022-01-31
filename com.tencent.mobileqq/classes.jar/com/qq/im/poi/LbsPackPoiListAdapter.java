package com.qq.im.poi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aom;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XBaseAdapter;
import java.util.ArrayList;
import java.util.List;

public class LbsPackPoiListAdapter
  extends XBaseAdapter
{
  public long a;
  private Context a;
  public LbsPackPoiListAdapter.onClickListener a;
  public List a;
  
  public LbsPackPoiListAdapter(Context paramContext, List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(LbsPackPoiListAdapter.onClickListener paramonClickListener)
  {
    this.jdField_a_of_type_ComQqImPoiLbsPackPoiListAdapter$onClickListener = paramonClickListener;
  }
  
  public void a(PoiInfo paramPoiInfo)
  {
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (paramPoiInfo.jdField_a_of_type_Long == ((PoiInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Long)
        {
          this.jdField_a_of_type_Long = paramPoiInfo.jdField_a_of_type_Long;
          notifyDataSetChanged();
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  public void a(List paramList)
  {
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList = paramList;
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    int i = 0;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      i = this.jdField_a_of_type_JavaUtilList.size();
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        if (paramInt > this.jdField_a_of_type_JavaUtilList.size()) {
          return null;
        }
        Object localObject = this.jdField_a_of_type_JavaUtilList.get(paramInt);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LbsPack", 2, "getItem error!");
      }
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969046, null);
      paramViewGroup = new LbsPackPoiListAdapter.ViewHolder();
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131364300));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364827));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131364828));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364337));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      PoiInfo localPoiInfo = (PoiInfo)getItem(paramInt);
      if (localPoiInfo != null)
      {
        paramViewGroup.jdField_a_of_type_ComQqImPoiPoiInfo = localPoiInfo;
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        if (this.jdField_a_of_type_Long == paramViewGroup.jdField_a_of_type_ComQqImPoiPoiInfo.jdField_a_of_type_Long) {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localPoiInfo.jdField_a_of_type_JavaLangString);
        paramViewGroup.b.setText(localPoiInfo.b);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new aom(this, localPoiInfo));
      }
      return paramView;
      paramViewGroup = (LbsPackPoiListAdapter.ViewHolder)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qq.im.poi.LbsPackPoiListAdapter
 * JD-Core Version:    0.7.0.1
 */