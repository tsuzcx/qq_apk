package com.tencent.biz.qqstory.playvideo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import java.util.ArrayList;
import java.util.List;
import nnr;

public class MyVideoVisibleTroopPageView$TroopListAdapter
  extends BaseAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public MyVideoVisibleTroopPageView$TroopListAdapter(MyVideoVisibleTroopPageView paramMyVideoVisibleTroopPageView, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(List paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (TroopInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (paramView == null)
    {
      paramViewGroup = new nnr(this);
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970898, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364975));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362894));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((TroopInfo)localObject).getTroopName());
      localObject = PlayModeUtils.a().a(((TroopInfo)localObject).troopuin);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return paramView;
      paramViewGroup = (nnr)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.MyVideoVisibleTroopPageView.TroopListAdapter
 * JD-Core Version:    0.7.0.1
 */